package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class i
  extends JceStruct
{
  public int bC = 0;
  
  public JceStruct newInit()
  {
    return new i();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bC = paramJceInputStream.read(this.bC, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.bC;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Protocol.MConch.i
 * JD-Core Version:    0.7.0.1
 */