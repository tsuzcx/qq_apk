package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class operation_addreply_rsp
  extends JceStruct
{
  public String msg = "";
  public String replyLikeKey = "";
  public String replyid = "";
  public int ret;
  public String verifyurl = "";
  
  public operation_addreply_rsp() {}
  
  public operation_addreply_rsp(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.ret = paramInt;
    this.msg = paramString1;
    this.verifyurl = paramString2;
    this.replyid = paramString3;
    this.replyLikeKey = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.verifyurl = paramJceInputStream.readString(2, false);
    this.replyid = paramJceInputStream.readString(3, false);
    this.replyLikeKey = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.verifyurl != null) {
      paramJceOutputStream.write(this.verifyurl, 2);
    }
    if (this.replyid != null) {
      paramJceOutputStream.write(this.replyid, 3);
    }
    if (this.replyLikeKey != null) {
      paramJceOutputStream.write(this.replyLikeKey, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addreply_rsp
 * JD-Core Version:    0.7.0.1
 */