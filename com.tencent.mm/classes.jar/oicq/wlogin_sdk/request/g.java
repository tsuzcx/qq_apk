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
    this.Kik = 2064;
    this.Kil = 2;
    this.Kin = parami;
  }
  
  public final byte[] db(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88065);
    int k = this.Kin.Kix;
    byte[] arrayOfByte1 = this.Kin.Kis.fMG();
    Object localObject = this.Kin.Kit;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).Kjf];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).Kjf <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).dc(arrayOfByte1);
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
      paramArrayOfByte = super.P(arrayOfByte2, this.Kil, j + 1);
      a(this.Kif, this.Kik, this.Kin._uin, this.Kih, this.Kii, k, this.Kij, paramArrayOfByte);
      paramArrayOfByte = super.fMD();
      AppMethodBeat.o(88065);
      return paramArrayOfByte;
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).Kie, ((oicq.wlogin_sdk.a.g)localObject).Kjh, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).Kjf);
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