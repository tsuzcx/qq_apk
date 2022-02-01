package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PopDialog
  extends JceStruct
{
  public String dialog_tips = "";
  public String dialog_title = "";
  public String left_tips = "";
  public String left_url = "";
  public String right_tips = "";
  public String right_url = "";
  
  public PopDialog() {}
  
  public PopDialog(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.dialog_tips = paramString1;
    this.left_tips = paramString2;
    this.left_url = paramString3;
    this.right_tips = paramString4;
    this.right_url = paramString5;
    this.dialog_title = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dialog_tips = paramJceInputStream.readString(0, false);
    this.left_tips = paramJceInputStream.readString(1, false);
    this.left_url = paramJceInputStream.readString(2, false);
    this.right_tips = paramJceInputStream.readString(3, false);
    this.right_url = paramJceInputStream.readString(4, false);
    this.dialog_title = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.dialog_tips;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.left_tips;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.left_url;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.right_tips;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.right_url;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.dialog_title;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.PopDialog
 * JD-Core Version:    0.7.0.1
 */