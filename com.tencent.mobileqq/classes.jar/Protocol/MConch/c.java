package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c
  extends JceStruct
{
  static byte[] bn = (byte[])new byte[1];
  static i bo = new i();
  static j bp = new j();
  public int bi = 0;
  public byte[] bj = null;
  public int bk = 0;
  public i bl = null;
  public j bm = null;
  
  static
  {
    ((byte[])bn)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new c();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bi = paramJceInputStream.read(this.bi, 0, false);
    this.bj = ((byte[])paramJceInputStream.read(bn, 1, false));
    this.bk = paramJceInputStream.read(this.bk, 2, false);
    this.bl = ((i)paramJceInputStream.read(bo, 3, false));
    this.bm = ((j)paramJceInputStream.read(bp, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bi, 0);
    if (this.bj != null) {
      paramJceOutputStream.write(this.bj, 1);
    }
    if (this.bk != 0) {
      paramJceOutputStream.write(this.bk, 2);
    }
    if (this.bl != null) {
      paramJceOutputStream.write(this.bl, 3);
    }
    if (this.bm != null) {
      paramJceOutputStream.write(this.bm, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Protocol.MConch.c
 * JD-Core Version:    0.7.0.1
 */