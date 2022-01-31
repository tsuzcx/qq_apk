package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetSelectedSkinReq
  extends JceStruct
{
  public int app_type;
  public long op_uin;
  public String phone_model = "";
  public String phone_os = "";
  public String qq_version = "";
  public int skin_id;
  
  public SetSelectedSkinReq() {}
  
  public SetSelectedSkinReq(long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.op_uin = paramLong;
    this.app_type = paramInt1;
    this.qq_version = paramString1;
    this.phone_os = paramString2;
    this.phone_model = paramString3;
    this.skin_id = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op_uin = paramJceInputStream.read(this.op_uin, 0, false);
    this.app_type = paramJceInputStream.read(this.app_type, 1, false);
    this.qq_version = paramJceInputStream.readString(2, false);
    this.phone_os = paramJceInputStream.readString(3, false);
    this.phone_model = paramJceInputStream.readString(4, false);
    this.skin_id = paramJceInputStream.read(this.skin_id, 5, true);
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
    paramJceOutputStream.write(this.skin_id, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.SetSelectedSkinReq
 * JD-Core Version:    0.7.0.1
 */