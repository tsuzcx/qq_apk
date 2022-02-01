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
    this.ajGQ = 2064;
    this.ajGR = 2;
    this.ajGT = parami;
  }
  
  public final byte[] dP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88065);
    int k = this.ajGT.ajHd;
    byte[] arrayOfByte1 = this.ajGT.ajGY.kGj();
    Object localObject = this.ajGT.ajGZ;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).ajHL];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).ajHL <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).dQ(arrayOfByte1);
      paramArrayOfByte = localao.v(paramArrayOfByte, arrayOfByte2);
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
      paramArrayOfByte = super.Z(arrayOfByte2, this.ajGR, j + 1);
      a(this.ajGL, this.ajGQ, this.ajGT._uin, this.ajGN, this.ajGO, k, this.ajGP, paramArrayOfByte);
      paramArrayOfByte = super.kGg();
      AppMethodBeat.o(88065);
      return paramArrayOfByte;
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).ajGK, ((oicq.wlogin_sdk.a.g)localObject).ajHN, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).ajHL);
      break;
      label218:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.request.g
 * JD-Core Version:    0.7.0.1
 */