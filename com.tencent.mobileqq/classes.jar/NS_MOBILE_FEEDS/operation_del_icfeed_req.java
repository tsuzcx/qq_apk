package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_del_icfeed_req
  extends JceStruct
{
  public int appid;
  public String skey = "";
  public long time;
  public int typeId;
  public long uflag;
  public long uin;
  
  public operation_del_icfeed_req() {}
  
  public operation_del_icfeed_req(long paramLong1, int paramInt1, int paramInt2, String paramString, long paramLong2, long paramLong3)
  {
    this.uin = paramLong1;
    this.appid = paramInt1;
    this.typeId = paramInt2;
    this.skey = paramString;
    this.time = paramLong2;
    this.uflag = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.typeId = paramJceInputStream.read(this.typeId, 2, false);
    this.skey = paramJceInputStream.readString(3, false);
    this.time = paramJceInputStream.read(this.time, 4, false);
    this.uflag = paramJceInputStream.read(this.uflag, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.typeId, 2);
    if (this.skey != null) {
      paramJceOutputStream.write(this.skey, 3);
    }
    paramJceOutputStream.write(this.time, 4);
    paramJceOutputStream.write(this.uflag, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.operation_del_icfeed_req
 * JD-Core Version:    0.7.0.1
 */