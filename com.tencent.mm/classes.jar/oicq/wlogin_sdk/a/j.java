package oicq.wlogin_sdk.a;

public final class j
  extends a
{
  int xrs = 0;
  
  public j()
  {
    this.xqq = 264;
  }
  
  public final byte[] ca(byte[] paramArrayOfByte)
  {
    this.xrs = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.xrs];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xrs);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.j
 * JD-Core Version:    0.7.0.1
 */