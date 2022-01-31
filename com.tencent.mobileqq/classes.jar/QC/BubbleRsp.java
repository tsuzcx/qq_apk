package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BubbleRsp
  extends JceStruct
{
  public String actUrl = "";
  public int authRet;
  public int bubbleID;
  
  public BubbleRsp() {}
  
  public BubbleRsp(int paramInt1, int paramInt2, String paramString)
  {
    this.bubbleID = paramInt1;
    this.authRet = paramInt2;
    this.actUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bubbleID = paramJceInputStream.read(this.bubbleID, 0, false);
    this.authRet = paramJceInputStream.read(this.authRet, 1, false);
    this.actUrl = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bubbleID, 0);
    paramJceOutputStream.write(this.authRet, 1);
    if (this.actUrl != null) {
      paramJceOutputStream.write(this.actUrl, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.BubbleRsp
 * JD-Core Version:    0.7.0.1
 */