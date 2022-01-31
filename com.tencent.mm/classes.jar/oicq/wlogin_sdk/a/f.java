package oicq.wlogin_sdk.a;

public final class f
  extends a
{
  int xrj = 0;
  
  public f()
  {
    this.xqq = 260;
  }
  
  public final byte[] bZ(byte[] paramArrayOfByte)
  {
    this.xrj = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.xrj];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xrj);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.f
 * JD-Core Version:    0.7.0.1
 */