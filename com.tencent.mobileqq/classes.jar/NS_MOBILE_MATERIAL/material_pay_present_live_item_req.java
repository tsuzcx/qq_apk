package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_pay_present_live_item_req
  extends JceStruct
{
  static LiveInfo cache_stLiveInfo = new LiveInfo();
  public int iAppid;
  public long lPayUin;
  public long lPresentUin;
  public LiveInfo stLiveInfo;
  public String strItemId = "";
  public String strQua = "";
  public String strSerialNo = "";
  
  public material_pay_present_live_item_req() {}
  
  public material_pay_present_live_item_req(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, String paramString3, LiveInfo paramLiveInfo)
  {
    this.lPayUin = paramLong1;
    this.lPresentUin = paramLong2;
    this.iAppid = paramInt;
    this.strItemId = paramString1;
    this.strSerialNo = paramString2;
    this.strQua = paramString3;
    this.stLiveInfo = paramLiveInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lPayUin = paramJceInputStream.read(this.lPayUin, 0, true);
    this.lPresentUin = paramJceInputStream.read(this.lPresentUin, 1, true);
    this.iAppid = paramJceInputStream.read(this.iAppid, 2, true);
    this.strItemId = paramJceInputStream.readString(3, true);
    this.strSerialNo = paramJceInputStream.readString(4, false);
    this.strQua = paramJceInputStream.readString(5, false);
    this.stLiveInfo = ((LiveInfo)paramJceInputStream.read(cache_stLiveInfo, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lPayUin, 0);
    paramJceOutputStream.write(this.lPresentUin, 1);
    paramJceOutputStream.write(this.iAppid, 2);
    paramJceOutputStream.write(this.strItemId, 3);
    if (this.strSerialNo != null) {
      paramJceOutputStream.write(this.strSerialNo, 4);
    }
    if (this.strQua != null) {
      paramJceOutputStream.write(this.strQua, 5);
    }
    if (this.stLiveInfo != null) {
      paramJceOutputStream.write(this.stLiveInfo, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_pay_present_live_item_req
 * JD-Core Version:    0.7.0.1
 */