package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_addcomment_rsp
  extends JceStruct
{
  public String commentLikekey = "";
  public String commentid = "";
  public String msg = "";
  public int ret = 0;
  public String verifyurl = "";
  
  public operation_addcomment_rsp() {}
  
  public operation_addcomment_rsp(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.verifyurl = paramString2;
    this.commentid = paramString3;
    this.commentLikekey = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.verifyurl = paramJceInputStream.readString(2, false);
    this.commentid = paramJceInputStream.readString(3, false);
    this.commentLikekey = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    String str = this.msg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.verifyurl;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.commentid;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.commentLikekey;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addcomment_rsp
 * JD-Core Version:    0.7.0.1
 */