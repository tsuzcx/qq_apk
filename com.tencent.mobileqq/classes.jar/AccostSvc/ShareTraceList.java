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
  public byte cType;
  public ArrayList<Long> vecClose;
  public ArrayList<Long> vecOpen;
  
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
    if (cache_vecOpen == null)
    {
      cache_vecOpen = new ArrayList();
      cache_vecOpen.add(Long.valueOf(0L));
    }
    this.vecOpen = ((ArrayList)paramJceInputStream.read(cache_vecOpen, 1, false));
    if (cache_vecClose == null)
    {
      cache_vecClose = new ArrayList();
      cache_vecClose.add(Long.valueOf(0L));
    }
    this.vecClose = ((ArrayList)paramJceInputStream.read(cache_vecClose, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cType, 0);
    if (this.vecOpen != null) {
      paramJceOutputStream.write(this.vecOpen, 1);
    }
    if (this.vecClose != null) {
      paramJceOutputStream.write(this.vecClose, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     AccostSvc.ShareTraceList
 * JD-Core Version:    0.7.0.1
 */