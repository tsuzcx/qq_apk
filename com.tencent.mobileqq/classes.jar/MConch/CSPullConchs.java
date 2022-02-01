package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CSPullConchs
  extends JceStruct
{
  public int busiType = 0;
  public int cmdId = 0;
  public int reserved = 0;
  
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
    int i = this.reserved;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.cmdId;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
    i = this.busiType;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MConch.CSPullConchs
 * JD-Core Version:    0.7.0.1
 */