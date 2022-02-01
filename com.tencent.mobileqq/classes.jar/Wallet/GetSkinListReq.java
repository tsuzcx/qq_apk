package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetSkinListReq
  extends JceStruct
{
  public int app_type = 0;
  public String busi_type = "";
  public String hb_from_type = "";
  public long op_uin = 0L;
  public String phone_model = "";
  public String phone_os = "";
  public String qq_version = "";
  public int selected_id = 0;
  
  public GetSkinListReq() {}
  
  public GetSkinListReq(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    this.op_uin = paramLong;
    this.app_type = paramInt1;
    this.qq_version = paramString1;
    this.phone_os = paramString2;
    this.phone_model = paramString3;
    this.busi_type = paramString4;
    this.hb_from_type = paramString5;
    this.selected_id = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op_uin = paramJceInputStream.read(this.op_uin, 0, false);
    this.app_type = paramJceInputStream.read(this.app_type, 1, false);
    this.qq_version = paramJceInputStream.readString(2, false);
    this.phone_os = paramJceInputStream.readString(3, false);
    this.phone_model = paramJceInputStream.readString(4, false);
    this.busi_type = paramJceInputStream.readString(5, false);
    this.hb_from_type = paramJceInputStream.readString(6, false);
    this.selected_id = paramJceInputStream.read(this.selected_id, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op_uin, 0);
    paramJceOutputStream.write(this.app_type, 1);
    if (this.qq_version != null) {
      paramJceOutputStream.write(this.qq_version, 2);
    }
    if (this.phone_os != null) {
      paramJceOutputStream.write(this.phone_os, 3);
    }
    if (this.phone_model != null) {
      paramJceOutputStream.write(this.phone_model, 4);
    }
    if (this.busi_type != null) {
      paramJceOutputStream.write(this.busi_type, 5);
    }
    if (this.hb_from_type != null) {
      paramJceOutputStream.write(this.hb_from_type, 6);
    }
    paramJceOutputStream.write(this.selected_id, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GetSkinListReq
 * JD-Core Version:    0.7.0.1
 */