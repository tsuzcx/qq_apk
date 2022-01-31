package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CommentInfo
  extends JceStruct
{
  public String jumpUrlToDetail = "";
  public int totalComment;
  
  public CommentInfo() {}
  
  public CommentInfo(int paramInt, String paramString)
  {
    this.totalComment = paramInt;
    this.jumpUrlToDetail = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.totalComment = paramJceInputStream.read(this.totalComment, 0, false);
    this.jumpUrlToDetail = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.totalComment, 0);
    if (this.jumpUrlToDetail != null) {
      paramJceOutputStream.write(this.jumpUrlToDetail, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.CommentInfo
 * JD-Core Version:    0.7.0.1
 */