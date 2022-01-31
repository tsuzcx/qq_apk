package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqGetSwitches
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static ArrayList<Integer> cache_types;
  public ReqHeader stHeader;
  public ArrayList<Integer> types;
  
  public ReqGetSwitches() {}
  
  public ReqGetSwitches(ReqHeader paramReqHeader, ArrayList<Integer> paramArrayList)
  {
    this.stHeader = paramReqHeader;
    this.types = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_types == null)
    {
      cache_types = new ArrayList();
      cache_types.add(Integer.valueOf(0));
    }
    this.types = ((ArrayList)paramJceInputStream.read(cache_types, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.types, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NeighborSvc.ReqGetSwitches
 * JD-Core Version:    0.7.0.1
 */