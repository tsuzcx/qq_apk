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
    this.Ucx = 2064;
    this.Ucy = 2;
    this.UcA = parami;
  }
  
  public final byte[] dn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88065);
    int k = this.UcA.UcK;
    byte[] arrayOfByte1 = this.UcA.UcF.hPA();
    Object localObject = this.UcA.UcG;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).Uds];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).Uds <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).jdMethod_do(arrayOfByte1);
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
      paramArrayOfByte = super.aa(arrayOfByte2, this.Ucy, j + 1);
      a(this.Ucs, this.Ucx, this.UcA._uin, this.Ucu, this.Ucv, k, this.Ucw, paramArrayOfByte);
      paramArrayOfByte = super.hPx();
      AppMethodBeat.o(88065);
      return paramArrayOfByte;
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).Ucr, ((oicq.wlogin_sdk.a.g)localObject).Udu, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).Uds);
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