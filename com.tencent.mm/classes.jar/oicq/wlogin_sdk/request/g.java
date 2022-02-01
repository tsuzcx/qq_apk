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
    this.abFM = 2064;
    this.abFN = 2;
    this.abFP = parami;
  }
  
  public final byte[] dM(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88065);
    int k = this.abFP.abFZ;
    byte[] arrayOfByte1 = this.abFP.abFU.iUI();
    Object localObject = this.abFP.abFV;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).abGH];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).abGH <= 0)
    {
      localObject = new f();
      ao localao = new ao();
      localObject = ((f)localObject).dN(arrayOfByte1);
      paramArrayOfByte = localao.u(paramArrayOfByte, arrayOfByte2);
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
      paramArrayOfByte = super.ab(arrayOfByte2, this.abFN, j + 1);
      a(this.abFH, this.abFM, this.abFP._uin, this.abFJ, this.abFK, k, this.abFL, paramArrayOfByte);
      paramArrayOfByte = super.iUF();
      AppMethodBeat.o(88065);
      return paramArrayOfByte;
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).abFG, ((oicq.wlogin_sdk.a.g)localObject).abGJ, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).abGH);
      break;
      label218:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.request.g
 * JD-Core Version:    0.7.0.1
 */