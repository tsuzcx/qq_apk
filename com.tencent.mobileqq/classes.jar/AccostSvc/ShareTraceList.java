package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ShareTraceList
  extends JceStruct
{
  static ArrayList<Long> cache_vecClose;
  static ArrayList<Long> cache_vecOpen;
  public byte cType = 0;
  public ArrayList<Long> vecClose = null;
  public ArrayList<Long> vecOpen = null;
  
  public ShareTraceList() {}
  
  public ShareTraceList(byte paramByte, ArrayList<Long> paramArrayList1, ArrayList<Long> paramArrayList2)
  {
    this.cType = paramByte;
    this.vecOpen = paramArrayList1;
    this.vecClose = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cType = paramJceInputStream.read(this.cType, 0, true);
    ArrayList localArrayList = cache_vecOpen;
    Long localLong = Long.valueOf(0L);
    if (localArrayList == null)
    {
      cache_vecOpen = new ArrayList();
      cache_vecOpen.add(localLong);
    }
    this.vecOpen = ((ArrayList)paramJceInputStream.read(cache_vecOpen, 1, false));
    if (cache_vecClose == null)
    {
      cache_vecClose = new ArrayList();
      cache_vecClose.add(localLong);
    }
    this.vecClose = ((ArrayList)paramJceInputStream.read(cache_vecClose, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cType, 0);
    ArrayList localArrayList = this.vecOpen;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
    localArrayList = this.vecClose;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     AccostSvc.ShareTraceList
 * JD-Core Version:    0.7.0.1
 */