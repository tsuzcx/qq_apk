package com.tencent.mm.protocal;

import com.tencent.mm.ah.t;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.a.b;

final class p$a$1
  implements k.a
{
  p$a$1(p.a parama, k.d paramd) {}
  
  public final boolean a(PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    paramArrayOfByte2 = (k.b)this.sqb;
    long l = this.sqb.spE;
    if ((b.cqk()) && (l == 0L)) {
      l = d.soZ;
    }
    for (;;)
    {
      y localy = this.sqb.spM;
      if (paramInt1 == 722)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
        vp localvp = ((p.a)this.sqb).sqa;
        Object localObject = t.a(l, localvp.sSQ, localvp.sSR);
        if (localObject == null) {
          return false;
        }
        localvp = localObject[0];
        localObject = localObject[1];
        if (MMProtocalJni.packHybrid(paramPByteArray, paramArrayOfByte1, this.sqb.spH, (int)l, paramArrayOfByte2.HH(), localy.ver, localvp, (byte[])localObject, localy.sqr.getBytes(), localy.sqs.getBytes(), this.sqb.spL, paramInt2, ((p.a)this.sqb).ecM))
        {
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramPByteArray.value.length), Integer.valueOf(paramInt2) });
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.p.a.1
 * JD-Core Version:    0.7.0.1
 */