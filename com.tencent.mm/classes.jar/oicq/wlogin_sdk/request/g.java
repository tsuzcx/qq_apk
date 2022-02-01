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
    this.Ony = 2064;
    this.Onz = 2;
    this.OnB = parami;
  }
  
  public final byte[] dl(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88065);
    int k = this.OnB.OnL;
    byte[] arrayOfByte1 = this.OnB.OnG.gCw();
    Object localObject = this.OnB.OnH;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).Oot];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).Oot <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).dm(arrayOfByte1);
      paramArrayOfByte = localao.s(paramArrayOfByte, arrayOfByte2);
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
      paramArrayOfByte = super.Q(arrayOfByte2, this.Onz, j + 1);
      a(this.Ont, this.Ony, this.OnB._uin, this.Onv, this.Onw, k, this.Onx, paramArrayOfByte);
      paramArrayOfByte = super.gCt();
      AppMethodBeat.o(88065);
      return paramArrayOfByte;
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).Ons, ((oicq.wlogin_sdk.a.g)localObject).Oov, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).Oot);
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