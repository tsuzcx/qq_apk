package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class IsUinFocusMpIdRsp
  extends JceStruct
{
  public String account_name = "";
  public String describe_content = "";
  public String icon_url = "";
  public int is_focus_link_mp_id = 0;
  public String link_mp_id = "";
  public String link_mp_id_admin_uin = "";
  public int status_code = 0;
  
  public IsUinFocusMpIdRsp() {}
  
  public IsUinFocusMpIdRsp(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2)
  {
    this.link_mp_id = paramString1;
    this.link_mp_id_admin_uin = paramString2;
    this.is_focus_link_mp_id = paramInt1;
    this.account_name = paramString3;
    this.describe_content = paramString4;
    this.icon_url = paramString5;
    this.status_code = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.link_mp_id = paramJceInputStream.readString(0, false);
    this.link_mp_id_admin_uin = paramJceInputStream.readString(1, false);
    this.is_focus_link_mp_id = paramJceInputStream.read(this.is_focus_link_mp_id, 2, false);
    this.account_name = paramJceInputStream.readString(3, false);
    this.describe_content = paramJceInputStream.readString(4, false);
    this.icon_url = paramJceInputStream.readString(5, false);
    this.status_code = paramJceInputStream.read(this.status_code, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.link_mp_id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.link_mp_id_admin_uin;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.is_focus_link_mp_id, 2);
    str = this.account_name;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.describe_content;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.icon_url;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.status_code, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.IsUinFocusMpIdRsp
 * JD-Core Version:    0.7.0.1
 */