package oicq.wlogin_sdk.a;

public final class k
  extends a
{
  int xrt = 0;
  
  public k()
  {
    this.xqq = 265;
  }
  
  public final byte[] cb(byte[] paramArrayOfByte)
  {
    this.xrt = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[this.xrt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xrt);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.k
 * JD-Core Version:    0.7.0.1
 */