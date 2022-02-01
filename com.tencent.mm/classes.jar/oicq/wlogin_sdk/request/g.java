package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g
  extends d
{
  public g(i parami)
  {
    this.NQs = 2064;
    this.NQt = 2;
    this.NQv = parami;
  }
  
  public final byte[] di(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88065);
    int k = this.NQv.NQF;
    byte[] arrayOfByte1 = this.NQv.NQA.gxU();
    Object localObject = this.NQv.NQB;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).NRn];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).NRn <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).dj(arrayOfByte1);
      paramArrayOfByte = localao.r(paramArrayOfByte, arrayOfByte2);
      arrayOfByte2 = new byte[localObject.length + paramArrayOfByte.length];
      if (arrayOfByte1.length <= 0) {
        break label218;
      }
      System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
      i = localObject.length + 0;
    }
    for (int j = 1;; j = 0)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, i, paramArrayOfByte.length);
      paramArrayOfByte = super.P(arrayOfByte2, this.NQt, j + 1);
      a(this.NQn, this.NQs, this.NQv._uin, this.NQp, this.NQq, k, this.NQr, paramArrayOfByte);
      paramArrayOfByte = super.gxR();
      AppMethodBeat.o(88065);
      return paramArrayOfByte;
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).NQm, ((oicq.wlogin_sdk.a.g)localObject).NRp, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).NRn);
      break;
      label218:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.g
 * JD-Core Version:    0.7.0.1
 */