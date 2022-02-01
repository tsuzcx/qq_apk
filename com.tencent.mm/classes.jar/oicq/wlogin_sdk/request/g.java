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
    this.LVT = 2064;
    this.LVU = 2;
    this.LVW = parami;
  }
  
  public final byte[] db(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88065);
    int k = this.LVW.LWg;
    byte[] arrayOfByte1 = this.LVW.LWb.gfw();
    Object localObject = this.LVW.LWc;
    byte[] arrayOfByte2 = new byte[((oicq.wlogin_sdk.a.g)localObject).LWO];
    int i;
    if (((oicq.wlogin_sdk.a.g)localObject).LWO <= 0)
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
      paramArrayOfByte = super.O(arrayOfByte2, this.LVU, j + 1);
      a(this.LVO, this.LVT, this.LVW._uin, this.LVQ, this.LVR, k, this.LVS, paramArrayOfByte);
      paramArrayOfByte = super.gft();
      AppMethodBeat.o(88065);
      return paramArrayOfByte;
      System.arraycopy(((oicq.wlogin_sdk.a.g)localObject).LVN, ((oicq.wlogin_sdk.a.g)localObject).LWQ, arrayOfByte2, 0, ((oicq.wlogin_sdk.a.g)localObject).LWO);
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