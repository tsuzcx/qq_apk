package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_play_on_wifi_req
  extends JceStruct
{
  public boolean isSetPlayOnWifi = true;
  public String strFeedUgcKey = "";
  public long uFeedsUin;
  public long uTime;
  
  public operation_play_on_wifi_req() {}
  
  public operation_play_on_wifi_req(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    this.uFeedsUin = paramLong1;
    this.uTime = paramLong2;
    this.strFeedUgcKey = paramString;
    this.isSetPlayOnWifi = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uFeedsUin = paramJceInputStream.read(this.uFeedsUin, 0, false);
    this.uTime = paramJceInputStream.read(this.uTime, 1, false);
    this.strFeedUgcKey = paramJceInputStream.readString(2, false);
    this.isSetPlayOnWifi = paramJceInputStream.read(this.isSetPlayOnWifi, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uFeedsUin, 0);
    paramJceOutputStream.write(this.uTime, 1);
    if (this.strFeedUgcKey != null) {
      paramJceOutputStream.write(this.strFeedUgcKey, 2);
    }
    paramJceOutputStream.write(this.isSetPlayOnWifi, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_play_on_wifi_req
 * JD-Core Version:    0.7.0.1
 */