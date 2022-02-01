package LBS_V2_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetPoiInfoRsp_V2
  extends JceStruct
{
  static ArrayList<PoiInfo_V2> cache_vPoiList = new ArrayList();
  public int iHasMore = 1;
  public int iTotalNum = 0;
  public String request_id = "";
  public String strAttachInfo = "";
  public ArrayList<PoiInfo_V2> vPoiList = null;
  
  static
  {
    PoiInfo_V2 localPoiInfo_V2 = new PoiInfo_V2();
    cache_vPoiList.add(localPoiInfo_V2);
  }
  
  public GetPoiInfoRsp_V2() {}
  
  public GetPoiInfoRsp_V2(ArrayList<PoiInfo_V2> paramArrayList, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.vPoiList = paramArrayList;
    this.iTotalNum = paramInt1;
    this.strAttachInfo = paramString1;
    this.iHasMore = paramInt2;
    this.request_id = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vPoiList = ((ArrayList)paramJceInputStream.read(cache_vPoiList, 0, true));
    this.iTotalNum = paramJceInputStream.read(this.iTotalNum, 1, false);
    this.strAttachInfo = paramJceInputStream.readString(2, false);
    this.iHasMore = paramJceInputStream.read(this.iHasMore, 3, false);
    this.request_id = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vPoiList, 0);
    paramJceOutputStream.write(this.iTotalNum, 1);
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 2);
    }
    paramJceOutputStream.write(this.iHasMore, 3);
    if (this.request_id != null) {
      paramJceOutputStream.write(this.request_id, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     LBS_V2_PROTOCOL.GetPoiInfoRsp_V2
 * JD-Core Version:    0.7.0.1
 */