package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetKuolieFriendRecomReq
  extends JceStruct
{
  static CommonInfo cache_commInfo = new CommonInfo();
  public CommonInfo commInfo = null;
  public String roomId = "";
  public String userId = "";
  
  public GetKuolieFriendRecomReq() {}
  
  public GetKuolieFriendRecomReq(CommonInfo paramCommonInfo, String paramString1, String paramString2)
  {
    this.commInfo = paramCommonInfo;
    this.roomId = paramString1;
    this.userId = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.commInfo = ((CommonInfo)paramJceInputStream.read(cache_commInfo, 0, false));
    this.roomId = paramJceInputStream.readString(1, false);
    this.userId = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.commInfo != null) {
      paramJceOutputStream.write(this.commInfo, 0);
    }
    if (this.roomId != null) {
      paramJceOutputStream.write(this.roomId, 1);
    }
    if (this.userId != null) {
      paramJceOutputStream.write(this.userId, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.GetKuolieFriendRecomReq
 * JD-Core Version:    0.7.0.1
 */