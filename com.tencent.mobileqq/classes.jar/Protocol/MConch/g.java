package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class g
  extends JceStruct
{
  public int bv = 0;
  
  public JceStruct newInit()
  {
    return new g();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bv = paramJceInputStream.read(this.bv, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.bv;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Protocol.MConch.g
 * JD-Core Version:    0.7.0.1
 */