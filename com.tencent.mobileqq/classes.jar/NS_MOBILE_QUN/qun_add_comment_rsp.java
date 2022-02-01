package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class qun_add_comment_rsp
  extends JceStruct
{
  public String commentid = "";
  public String verifyurl = "";
  
  public qun_add_comment_rsp() {}
  
  public qun_add_comment_rsp(String paramString1, String paramString2)
  {
    this.verifyurl = paramString1;
    this.commentid = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.verifyurl = paramJceInputStream.readString(0, false);
    this.commentid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.verifyurl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.commentid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_add_comment_rsp
 * JD-Core Version:    0.7.0.1
 */