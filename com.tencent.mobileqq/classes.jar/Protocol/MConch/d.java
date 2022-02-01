package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  public int bi = 0;
  public int bk = 0;
  public long bt = 0L;
  public long bu = 0L;
  public int bv = 0;
  
  public JceStruct newInit()
  {
    return new d();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bt = paramJceInputStream.read(this.bt, 0, false);
    this.bu = paramJceInputStream.read(this.bu, 1, false);
    this.bk = paramJceInputStream.read(this.bk, 2, false);
    this.bi = paramJceInputStream.read(this.bi, 3, false);
    this.bv = paramJceInputStream.read(this.bv, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    long l = this.bt;
    if (l != 0L) {
      paramJceOutputStream.write(l, 0);
    }
    l = this.bu;
    if (l != 0L) {
      paramJceOutputStream.write(l, 1);
    }
    int i = this.bk;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    paramJceOutputStream.write(this.bi, 3);
    i = this.bv;
    if (i != 0) {
      paramJceOutputStream.write(i, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Protocol.MConch.d
 * JD-Core Version:    0.7.0.1
 */