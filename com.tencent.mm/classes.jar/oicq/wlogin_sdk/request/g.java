package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g
  extends d
{
  public g(i parami)
  {
    this.xqq = 2064;
    this.xqr = 2;
    this.xqt = parami;
  }
  
  public final byte[] bY(byte[] paramArrayOfByte)
  {
    int k = this.xqt.xqD;
    byte[] arrayOfByte1 = this.xqt.xqy.cUE();
    Object localObject = this.xqt.xqz;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).xrl];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).xrl <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).bZ(arrayOfByte1);
      paramArrayOfByte = localao.n(paramArrayOfByte, arrayOfByte2);
      arrayOfByte2 = new byte[localObject.length + paramArrayOfByte.length];
      if (arrayOfByte1.length <= 0) {
        break label206;
      }
      System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
      i = localObject.length + 0;
    }
    for (int j = 1;; j = 0)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i, paramArrayOfByte.length);
      paramArrayOfByte = super.x(arrayOfByte2, this.xqr, j + 1);
      a(this.xql, this.xqq, this.xqt._uin, this.xqn, this.xqo, k, this.xqp, paramArrayOfByte);
      return super.cUB();
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).xqk, ((oicq.wlogin_sdk.a.g)localObject).xrn, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).xrl);
      break;
      label206:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.g
 * JD-Core Version:    0.7.0.1
 */