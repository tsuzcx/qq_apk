package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSPullConchs
  extends JceStruct
{
  public int busiType;
  public int cmdId = 0;
  public int reserved;
  
  public JceStruct newInit()
  {
    return new CSPullConchs();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reserved = paramJceInputStream.read(this.reserved, 0, false);
    this.cmdId = paramJceInputStream.read(this.cmdId, 1, false);
    this.busiType = paramJceInputStream.read(this.busiType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.reserved != 0) {
      paramJceOutputStream.write(this.reserved, 0);
    }
    if (this.cmdId != 0) {
      paramJceOutputStream.write(this.cmdId, 1);
    }
    if (this.busiType != 0) {
      paramJceOutputStream.write(this.busiType, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MConch.CSPullConchs
 * JD-Core Version:    0.7.0.1
 */