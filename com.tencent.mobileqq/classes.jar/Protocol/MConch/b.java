package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b
  extends JceStruct
{
  public int bh = 0;
  public int bi = 0;
  
  public JceStruct newInit()
  {
    return new b();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bh = paramJceInputStream.read(this.bh, 0, false);
    this.bi = paramJceInputStream.read(this.bi, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    int i = this.bh;
    if (i != 0) {
      paramJceOutputStream.write(i, 0);
    }
    i = this.bi;
    if (i != 0) {
      paramJceOutputStream.write(i, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Protocol.MConch.b
 * JD-Core Version:    0.7.0.1
 */