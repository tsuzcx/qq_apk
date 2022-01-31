package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_op_btn
  extends JceStruct
{
  public int btn_actiontype;
  public int btn_color;
  public String btn_title = "";
  public String btn_url = "";
  
  public s_op_btn() {}
  
  public s_op_btn(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.btn_title = paramString1;
    this.btn_color = paramInt1;
    this.btn_actiontype = paramInt2;
    this.btn_url = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.btn_title = paramJceInputStream.readString(0, false);
    this.btn_color = paramJceInputStream.read(this.btn_color, 1, false);
    this.btn_actiontype = paramJceInputStream.read(this.btn_actiontype, 2, false);
    this.btn_url = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.btn_title != null) {
      paramJceOutputStream.write(this.btn_title, 0);
    }
    paramJceOutputStream.write(this.btn_color, 1);
    paramJceOutputStream.write(this.btn_actiontype, 2);
    if (this.btn_url != null) {
      paramJceOutputStream.write(this.btn_url, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_op_btn
 * JD-Core Version:    0.7.0.1
 */