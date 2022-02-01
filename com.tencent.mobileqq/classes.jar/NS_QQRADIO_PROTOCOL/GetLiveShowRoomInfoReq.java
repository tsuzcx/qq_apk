package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetLiveShowRoomInfoReq
  extends JceStruct
{
  static CommonInfo cache_commonInfo = new CommonInfo();
  public CommonInfo commonInfo = null;
  public int infoType = 0;
  public int isHlsUrlSign = 0;
  public int pageType = 0;
  public String roomID = "";
  public String uid = "";
  
  public GetLiveShowRoomInfoReq() {}
  
  public GetLiveShowRoomInfoReq(CommonInfo paramCommonInfo, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    this.commonInfo = paramCommonInfo;
    this.roomID = paramString1;
    this.infoType = paramInt1;
    this.uid = paramString2;
    this.pageType = paramInt2;
    this.isHlsUrlSign = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commonInfo = ((CommonInfo)paramJceInputStream.read(cache_commonInfo, 0, false));
    this.roomID = paramJceInputStream.readString(1, false);
    this.infoType = paramJceInputStream.read(this.infoType, 2, false);
    this.uid = paramJceInputStream.readString(3, false);
    this.pageType = paramJceInputStream.read(this.pageType, 4, false);
    this.isHlsUrlSign = paramJceInputStream.read(this.isHlsUrlSign, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.commonInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.roomID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.infoType, 2);
    localObject = this.uid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.pageType, 4);
    paramJceOutputStream.write(this.isHlsUrlSign, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_PROTOCOL.GetLiveShowRoomInfoReq
 * JD-Core Version:    0.7.0.1
 */