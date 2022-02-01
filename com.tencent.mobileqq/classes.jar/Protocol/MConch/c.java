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
    Object localObject = this.bj;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 1);
    }
    int i = this.bk;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    localObject = this.bl;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.bm;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Protocol.MConch.c
 * JD-Core Version:    0.7.0.1
 */