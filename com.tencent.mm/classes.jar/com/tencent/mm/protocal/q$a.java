package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.u;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class q$a
  extends l.d
  implements l.b
{
  public final agz FGF;
  
  public q$a()
  {
    AppMethodBeat.i(152468);
    this.FGF = new agz();
    setUin(0);
    this.FGF.Gxo = new agy();
    this.FGF.Gxo.Gxm = new xv();
    this.FGF.Gxn = new aha();
    AppMethodBeat.o(152468);
  }
  
  public final int getFuncId()
  {
    if (f.FFQ) {
      return 784;
    }
    return 722;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(152469);
    setRsaInfo(ac.fkn());
    this.FGF.Gxo.setBaseRequest(l.a(this));
    this.FGF.Gxn.FWl = new SKBuiltinBuffer_t().setBuffer(bu.fpG());
    setPassKey(this.FGF.Gxn.FWl.getBuffer().toByteArray());
    setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(152467);
        paramAnonymousArrayOfByte2 = (l.b)jdField_this;
        long l1 = jdField_this.getUin();
        if ((com.tencent.mm.sdk.a.b.fnF()) && (l1 == 0L)) {
          l1 = d.FFG;
        }
        for (;;)
        {
          Object localObject1 = jdField_this.getRsaInfo();
          if (paramAnonymousInt1 == 722)
          {
            ae.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
            agz localagz = ((q.a)jdField_this).FGF;
            Object localObject2 = u.a(l1, localagz.Gxn, localagz.Gxo);
            if (localObject2 == null)
            {
              AppMethodBeat.o(152467);
              return false;
            }
            localagz = localObject2[0];
            localObject2 = localObject2[1];
            if (MMProtocalJni.packHybrid(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), ((ac)localObject1).ver, localagz, (byte[])localObject2, ((ac)localObject1).FHi.getBytes(), ((ac)localObject1).FHj.getBytes(), jdField_this.getPassKey(), paramAnonymousInt2, ((q.a)jdField_this).getRouteInfo()))
            {
              ae.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(152467);
              return true;
            }
          }
          else if (paramAnonymousInt1 == 784)
          {
            ae.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", new Object[] { Integer.valueOf(((ac)localObject1).ver), Boolean.valueOf(f.FFQ), Long.valueOf(((l.b)jdField_this).getECDHEngine()) });
            ((l.b)jdField_this).getFuncId();
            paramAnonymousPByteArray = new PByteArray();
            localObject1 = ((l.b)jdField_this).toProtoBuf();
            if (localObject1 == null)
            {
              ae.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
              AppMethodBeat.o(152467);
              return false;
            }
            long l2 = f.co(null);
            jdField_this.setEcdhEngine(l2);
            localObject1 = UtilsJni.HybridEcdhEncrypt(l2, (byte[])localObject1);
            boolean bool = MMProtocalJni.packHybridEcdh(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), f.FFV, (byte[])localObject1, paramAnonymousInt2, paramAnonymousArrayOfByte2.getRouteInfo(), 12);
            ae.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.FFV), Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
            AppMethodBeat.o(152467);
            return bool;
          }
          AppMethodBeat.o(152467);
          return false;
        }
      }
    });
    byte[] arrayOfByte = this.FGF.toByteArray();
    AppMethodBeat.o(152469);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.q.a
 * JD-Core Version:    0.7.0.1
 */