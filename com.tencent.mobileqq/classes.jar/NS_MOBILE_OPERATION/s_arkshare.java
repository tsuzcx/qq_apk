package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_arkshare
  extends JceStruct
{
  public String ark_content = "";
  public String ark_id = "";
  public String view_id = "";
  
  public s_arkshare() {}
  
  public s_arkshare(String paramString1, String paramString2, String paramString3)
  {
    this.ark_id = paramString1;
    this.view_id = paramString2;
    this.ark_content = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ark_id = paramJceInputStream.readString(0, false);
    this.view_id = paramJceInputStream.readString(1, false);
    this.ark_content = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.ark_id;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.view_id;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.ark_content;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.s_arkshare
 * JD-Core Version:    0.7.0.1
 */