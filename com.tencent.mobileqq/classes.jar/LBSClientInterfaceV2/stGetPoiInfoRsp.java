package LBSClientInterfaceV2;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stGetPoiInfoRsp
  extends JceStruct
{
  static ArrayList<stPoiInfo> cache_vPoiList;
  public int iTotalNum = 0;
  public ArrayList<stPoiInfo> vPoiList = null;
  
  public stGetPoiInfoRsp() {}
  
  public stGetPoiInfoRsp(ArrayList<stPoiInfo> paramArrayList, int paramInt)
  {
    this.vPoiList = paramArrayList;
    this.iTotalNum = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vPoiList == null)
    {
      cache_vPoiList = new ArrayList();
      stPoiInfo localstPoiInfo = new stPoiInfo();
      cache_vPoiList.add(localstPoiInfo);
    }
    this.vPoiList = ((ArrayList)paramJceInputStream.read(cache_vPoiList, 0, true));
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vPoiList, 0);
    paramJceOutputStream.write(this.iTotalNum, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     LBSClientInterfaceV2.stGetPoiInfoRsp
 * JD-Core Version:    0.7.0.1
 */