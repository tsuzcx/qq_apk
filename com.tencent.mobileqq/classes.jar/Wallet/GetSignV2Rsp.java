package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetSignV2Rsp
  extends JceStruct
{
  public String busi_info = "";
  public String mch_id = "";
  public int nav_type = 0;
  public int ret = 0;
  public String sign = "";
  public long time_stamp = 0L;
  public int token_scene = 0;
  public int token_type = 0;
  public long userid = 0L;
  public int userid_type = 0;
  
  public GetSignV2Rsp() {}
  
  public GetSignV2Rsp(int paramInt1, String paramString1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, String paramString2, int paramInt5, String paramString3)
  {
    this.ret = paramInt1;
    this.mch_id = paramString1;
    this.userid_type = paramInt2;
    this.userid = paramLong1;
    this.time_stamp = paramLong2;
    this.token_scene = paramInt3;
    this.token_type = paramInt4;
    this.busi_info = paramString2;
    this.nav_type = paramInt5;
    this.sign = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.mch_id = paramJceInputStream.readString(1, true);
    this.userid_type = paramJceInputStream.read(this.userid_type, 2, true);
    this.userid = paramJceInputStream.read(this.userid, 3, true);
    this.time_stamp = paramJceInputStream.read(this.time_stamp, 4, true);
    this.token_scene = paramJceInputStream.read(this.token_scene, 5, true);
    this.token_type = paramJceInputStream.read(this.token_type, 6, true);
    this.busi_info = paramJceInputStream.readString(7, true);
    this.nav_type = paramJceInputStream.read(this.nav_type, 8, true);
    this.sign = paramJceInputStream.readString(9, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.mch_id, 1);
    paramJceOutputStream.write(this.userid_type, 2);
    paramJceOutputStream.write(this.userid, 3);
    paramJceOutputStream.write(this.time_stamp, 4);
    paramJceOutputStream.write(this.token_scene, 5);
    paramJceOutputStream.write(this.token_type, 6);
    paramJceOutputStream.write(this.busi_info, 7);
    paramJceOutputStream.write(this.nav_type, 8);
    paramJceOutputStream.write(this.sign, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetSignV2Rsp
 * JD-Core Version:    0.7.0.1
 */