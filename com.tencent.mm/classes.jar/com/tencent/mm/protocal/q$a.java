package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.u;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agp;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.xs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class q$a
  extends l.d
  implements l.b
{
  public final agp Foh;
  
  public q$a()
  {
    AppMethodBeat.i(152468);
    this.Foh = new agp();
    setUin(0);
    this.Foh.GeG = new ago();
    this.Foh.GeG.GeE = new xs();
    this.Foh.GeF = new agq();
    AppMethodBeat.o(152468);
  }
  
  public final int getFuncId()
  {
    if (f.Fns) {
      return 784;
    }
    return 722;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(152469);
    setRsaInfo(ac.fgx());
    this.Foh.GeG.setBaseRequest(l.a(this));
    this.Foh.GeF.FDQ = new SKBuiltinBuffer_t().setBuffer(bt.flL());
    setPassKey(this.Foh.GeF.FDQ.getBuffer().toByteArray());
    setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(152467);
        paramAnonymousArrayOfByte2 = (l.b)jdField_this;
        long l1 = jdField_this.getUin();
        if ((com.tencent.mm.sdk.a.b.fjN()) && (l1 == 0L)) {
          l1 = d.Fni;
        }
        for (;;)
        {
          Object localObject1 = jdField_this.getRsaInfo();
          if (paramAnonymousInt1 == 722)
          {
            ad.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
            agp localagp = ((q.a)jdField_this).Foh;
            Object localObject2 = u.a(l1, localagp.GeF, localagp.GeG);
            if (localObject2 == null)
            {
              AppMethodBeat.o(152467);
              return false;
            }
            localagp = localObject2[0];
            localObject2 = localObject2[1];
            if (MMProtocalJni.packHybrid(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), ((ac)localObject1).ver, localagp, (byte[])localObject2, ((ac)localObject1).FoK.getBytes(), ((ac)localObject1).FoL.getBytes(), jdField_this.getPassKey(), paramAnonymousInt2, ((q.a)jdField_this).getRouteInfo()))
            {
              ad.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(152467);
              return true;
            }
          }
          else if (paramAnonymousInt1 == 784)
          {
            ad.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", new Object[] { Integer.valueOf(((ac)localObject1).ver), Boolean.valueOf(f.Fns), Long.valueOf(((l.b)jdField_this).getECDHEngine()) });
            ((l.b)jdField_this).getFuncId();
            paramAnonymousPByteArray = new PByteArray();
            localObject1 = ((l.b)jdField_this).toProtoBuf();
            if (localObject1 == null)
            {
              ad.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
              AppMethodBeat.o(152467);
              return false;
            }
            long l2 = f.cl(null);
            jdField_this.setEcdhEngine(l2);
            localObject1 = UtilsJni.HybridEcdhEncrypt(l2, (byte[])localObject1);
            boolean bool = MMProtocalJni.packHybridEcdh(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), f.Fnx, (byte[])localObject1, paramAnonymousInt2, paramAnonymousArrayOfByte2.getRouteInfo(), 12);
            ad.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.Fnx), Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
            AppMethodBeat.o(152467);
            return bool;
          }
          AppMethodBeat.o(152467);
          return false;
        }
      }
    });
    byte[] arrayOfByte = this.Foh.toByteArray();
    AppMethodBeat.o(152469);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.q.a
 * JD-Core Version:    0.7.0.1
 */