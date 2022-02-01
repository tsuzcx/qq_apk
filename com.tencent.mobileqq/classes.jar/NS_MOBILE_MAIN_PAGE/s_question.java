package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_question
  extends JceStruct
{
  public String qustion1 = "";
  public String qustion2 = "";
  public String qustion3 = "";
  public String result1 = "";
  public String result2 = "";
  public String result3 = "";
  
  public s_question() {}
  
  public s_question(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.qustion1 = paramString1;
    this.qustion2 = paramString2;
    this.qustion3 = paramString3;
    this.result1 = paramString4;
    this.result2 = paramString5;
    this.result3 = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qustion1 = paramJceInputStream.readString(0, false);
    this.qustion2 = paramJceInputStream.readString(1, false);
    this.qustion3 = paramJceInputStream.readString(2, false);
    this.result1 = paramJceInputStream.readString(3, false);
    this.result2 = paramJceInputStream.readString(4, false);
    this.result3 = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.qustion1;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.qustion2;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.qustion3;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.result1;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.result2;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.result3;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_question
 * JD-Core Version:    0.7.0.1
 */