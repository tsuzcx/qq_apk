package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.t;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class q$a$1
  implements l.a
{
  q$a$1(q.a parama, l.d paramd) {}
  
  public final boolean a(PByteArray paramPByteArray, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
  {
    AppMethodBeat.i(79995);
    paramArrayOfByte2 = (l.b)this.wiF;
    long l1 = this.wiF.getUin();
    if ((b.dsf()) && (l1 == 0L)) {
      l1 = d.whG;
    }
    for (;;)
    {
      Object localObject1 = this.wiF.getRsaInfo();
      if (paramInt1 == 722)
      {
        ab.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
        zt localzt = ((q.a)this.wiF).wiE;
        Object localObject2 = t.a(l1, localzt.wQM, localzt.wQN);
        if (localObject2 == null)
        {
          AppMethodBeat.o(79995);
          return false;
        }
        localzt = localObject2[0];
        localObject2 = localObject2[1];
        if (MMProtocalJni.packHybrid(paramPByteArray, paramArrayOfByte1, this.wiF.getDeviceID(), (int)l1, paramArrayOfByte2.getFuncId(), ((aa)localObject1).ver, localzt, (byte[])localObject2, ((aa)localObject1).wiZ.getBytes(), ((aa)localObject1).wja.getBytes(), this.wiF.getPassKey(), paramInt2, ((q.a)this.wiF).getRouteInfo()))
        {
          ab.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramPByteArray.value.length), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(79995);
          return true;
        }
      }
      else if (paramInt1 == 784)
      {
        ab.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", new Object[] { Integer.valueOf(((aa)localObject1).ver), Boolean.valueOf(f.whQ), Long.valueOf(((l.b)this.wiF).getECDHEngine()) });
        ((l.b)this.wiF).getFuncId();
        paramPByteArray = new PByteArray();
        localObject1 = ((l.b)this.wiF).toProtoBuf();
        if (localObject1 == null)
        {
          ab.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
          AppMethodBeat.o(79995);
          return false;
        }
        long l2 = f.bN(null);
        this.wiF.setEcdhEngine(l2);
        localObject1 = UtilsJni.HybridEcdhEncrypt(l2, (byte[])localObject1);
        boolean bool = MMProtocalJni.packHybridEcdh(paramPByteArray, paramArrayOfByte1, this.wiF.getDeviceID(), (int)l1, paramArrayOfByte2.getFuncId(), f.whV, (byte[])localObject1, paramInt2, paramArrayOfByte2.getRouteInfo(), 12);
        ab.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(f.whV), Integer.valueOf(paramPByteArray.value.length), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
        AppMethodBeat.o(79995);
        return bool;
      }
      AppMethodBeat.o(79995);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.q.a.1
 * JD-Core Version:    0.7.0.1
 */