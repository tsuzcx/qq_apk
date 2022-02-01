package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.u;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.vj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q$a
  extends l.d
  implements l.b
{
  public final adh CqI;
  
  public q$a()
  {
    AppMethodBeat.i(152468);
    this.CqI = new adh();
    setUin(0);
    this.CqI.DdX = new adg();
    this.CqI.DdX.DdV = new vj();
    this.CqI.DdW = new adi();
    AppMethodBeat.o(152468);
  }
  
  public final int getFuncId()
  {
    if (f.CpT) {
      return 784;
    }
    return 722;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(152469);
    setRsaInfo(ac.eBY());
    this.CqI.DdX.setBaseRequest(l.a(this));
    this.CqI.DdW.CFU = new SKBuiltinBuffer_t().setBuffer(bt.eGG());
    setPassKey(this.CqI.DdW.CFU.getBuffer().toByteArray());
    setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(152467);
        paramAnonymousArrayOfByte2 = (l.b)jdField_this;
        long l1 = jdField_this.getUin();
        if ((com.tencent.mm.sdk.a.b.eEQ()) && (l1 == 0L)) {
          l1 = d.CpJ;
        }
        for (;;)
        {
          Object localObject1 = jdField_this.getRsaInfo();
          if (paramAnonymousInt1 == 722)
          {
            ad.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
            adh localadh = ((q.a)jdField_this).CqI;
            Object localObject2 = u.a(l1, localadh.DdW, localadh.DdX);
            if (localObject2 == null)
            {
              AppMethodBeat.o(152467);
              return false;
            }
            localadh = localObject2[0];
            localObject2 = localObject2[1];
            if (MMProtocalJni.packHybrid(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), ((ac)localObject1).ver, localadh, (byte[])localObject2, ((ac)localObject1).Crl.getBytes(), ((ac)localObject1).Crm.getBytes(), jdField_this.getPassKey(), paramAnonymousInt2, ((q.a)jdField_this).getRouteInfo()))
            {
              ad.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(152467);
              return true;
            }
          }
          else if (paramAnonymousInt1 == 784)
          {
            ad.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", new Object[] { Integer.valueOf(((ac)localObject1).ver), Boolean.valueOf(f.CpT), Long.valueOf(((l.b)jdField_this).getECDHEngine()) });
            ((l.b)jdField_this).getFuncId();
            paramAnonymousPByteArray = new PByteArray();
            localObject1 = ((l.b)jdField_this).toProtoBuf();
            if (localObject1 == null)
            {
              ad.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
              AppMethodBeat.o(152467);
              return false;
            }
            long l2 = f.cf(null);
            jdField_this.setEcdhEngine(l2);
            localObject1 = UtilsJni.HybridEcdhEncrypt(l2, (byte[])localObject1);
            boolean bool = MMProtocalJni.packHybridEcdh(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), f.CpY, (byte[])localObject1, paramAnonymousInt2, paramAnonymousArrayOfByte2.getRouteInfo(), 12);
            ad.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.CpY), Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
            AppMethodBeat.o(152467);
            return bool;
          }
          AppMethodBeat.o(152467);
          return false;
        }
      }
    });
    byte[] arrayOfByte = this.CqI.toByteArray();
    AppMethodBeat.o(152469);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.q.a
 * JD-Core Version:    0.7.0.1
 */