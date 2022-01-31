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
    this.CMD = 2064;
    this.CME = 2;
    this.CMG = parami;
  }
  
  public final byte[] cJ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96426);
    int k = this.CMG.CMQ;
    byte[] arrayOfByte1 = this.CMG.CML.erd();
    Object localObject = this.CMG.CMM;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).CNy];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).CNy <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).cK(arrayOfByte1);
      paramArrayOfByte = localao.q(paramArrayOfByte, arrayOfByte2);
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
      paramArrayOfByte = super.H(arrayOfByte2, this.CME, j + 1);
      a(this.CMy, this.CMD, this.CMG._uin, this.CMA, this.CMB, k, this.CMC, paramArrayOfByte);
      paramArrayOfByte = super.era();
      AppMethodBeat.o(96426);
      return paramArrayOfByte;
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).CMx, ((oicq.wlogin_sdk.a.g)localObject).CNA, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).CNy);
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