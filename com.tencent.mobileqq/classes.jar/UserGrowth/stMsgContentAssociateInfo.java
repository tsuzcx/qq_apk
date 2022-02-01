package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMsgContentAssociateInfo
  extends JceStruct
{
  public int assocateType = 0;
  public String commentID = "";
  public String replyID = "";
  
  public stMsgContentAssociateInfo() {}
  
  public stMsgContentAssociateInfo(int paramInt, String paramString1, String paramString2)
  {
    this.assocateType = paramInt;
    this.commentID = paramString1;
    this.replyID = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.assocateType = paramJceInputStream.read(this.assocateType, 0, false);
    this.commentID = paramJceInputStream.readString(1, false);
    this.replyID = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.assocateType, 0);
    String str = this.commentID;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.replyID;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stMsgContentAssociateInfo
 * JD-Core Version:    0.7.0.1
 */