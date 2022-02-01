package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_pay_live_item_req
  extends JceStruct
{
  static LiveInfo cache_stLiveInfo = new LiveInfo();
  public int iAppid = 0;
  public long lUin = 0L;
  public LiveInfo stLiveInfo = null;
  public String strItemId = "";
  public String strQua = "";
  public String strSerialNo = "";
  
  public material_pay_live_item_req() {}
  
  public material_pay_live_item_req(long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, LiveInfo paramLiveInfo)
  {
    this.lUin = paramLong;
    this.iAppid = paramInt;
    this.strItemId = paramString1;
    this.strSerialNo = paramString2;
    this.strQua = paramString3;
    this.stLiveInfo = paramLiveInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iAppid = paramJceInputStream.read(this.iAppid, 1, true);
    this.strItemId = paramJceInputStream.readString(2, true);
    this.strSerialNo = paramJceInputStream.readString(3, false);
    this.strQua = paramJceInputStream.readString(4, false);
    this.stLiveInfo = ((LiveInfo)paramJceInputStream.read(cache_stLiveInfo, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iAppid, 1);
    paramJceOutputStream.write(this.strItemId, 2);
    Object localObject = this.strSerialNo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.strQua;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.stLiveInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_pay_live_item_req
 * JD-Core Version:    0.7.0.1
 */