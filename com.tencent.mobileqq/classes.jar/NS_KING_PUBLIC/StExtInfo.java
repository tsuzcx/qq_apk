package NS_KING_PUBLIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class StExtInfo
  extends JceStruct
{
  public String logDepth = "";
  public int logLevel = 0;
  public int logSeq = 0;
  
  public StExtInfo() {}
  
  public StExtInfo(int paramInt1, int paramInt2, String paramString)
  {
    this.logLevel = paramInt1;
    this.logSeq = paramInt2;
    this.logDepth = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.logLevel = paramJceInputStream.read(this.logLevel, 0, false);
    this.logSeq = paramJceInputStream.read(this.logSeq, 1, false);
    this.logDepth = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.logLevel, 0);
    paramJceOutputStream.write(this.logSeq, 1);
    if (this.logDepth != null) {
      paramJceOutputStream.write(this.logDepth, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_PUBLIC.StExtInfo
 * JD-Core Version:    0.7.0.1
 */