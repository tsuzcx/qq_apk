package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.u;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aef;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.bs;

public final class q$a
  extends l.d
  implements l.b
{
  public final aeg DJa;
  
  public q$a()
  {
    AppMethodBeat.i(152468);
    this.DJa = new aeg();
    setUin(0);
    this.DJa.Exd = new aef();
    this.DJa.Exd.Exb = new vt();
    this.DJa.Exc = new aeh();
    AppMethodBeat.o(152468);
  }
  
  public final int getFuncId()
  {
    if (f.DIl) {
      return 784;
    }
    return 722;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(152469);
    setRsaInfo(ac.eRt());
    this.DJa.Exd.setBaseRequest(l.a(this));
    this.DJa.Exc.DYu = new SKBuiltinBuffer_t().setBuffer(bs.eWb());
    setPassKey(this.DJa.Exc.DYu.getBuffer().toByteArray());
    setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(152467);
        paramAnonymousArrayOfByte2 = (l.b)jdField_this;
        long l1 = jdField_this.getUin();
        if ((com.tencent.mm.sdk.a.b.eUk()) && (l1 == 0L)) {
          l1 = d.DIb;
        }
        for (;;)
        {
          Object localObject1 = jdField_this.getRsaInfo();
          if (paramAnonymousInt1 == 722)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
            aeg localaeg = ((q.a)jdField_this).DJa;
            Object localObject2 = u.a(l1, localaeg.Exc, localaeg.Exd);
            if (localObject2 == null)
            {
              AppMethodBeat.o(152467);
              return false;
            }
            localaeg = localObject2[0];
            localObject2 = localObject2[1];
            if (MMProtocalJni.packHybrid(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), ((ac)localObject1).ver, localaeg, (byte[])localObject2, ((ac)localObject1).DJD.getBytes(), ((ac)localObject1).DJE.getBytes(), jdField_this.getPassKey(), paramAnonymousInt2, ((q.a)jdField_this).getRouteInfo()))
            {
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(152467);
              return true;
            }
          }
          else if (paramAnonymousInt1 == 784)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", new Object[] { Integer.valueOf(((ac)localObject1).ver), Boolean.valueOf(f.DIl), Long.valueOf(((l.b)jdField_this).getECDHEngine()) });
            ((l.b)jdField_this).getFuncId();
            paramAnonymousPByteArray = new PByteArray();
            localObject1 = ((l.b)jdField_this).toProtoBuf();
            if (localObject1 == null)
            {
              com.tencent.mm.sdk.platformtools.ac.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
              AppMethodBeat.o(152467);
              return false;
            }
            long l2 = f.ce(null);
            jdField_this.setEcdhEngine(l2);
            localObject1 = UtilsJni.HybridEcdhEncrypt(l2, (byte[])localObject1);
            boolean bool = MMProtocalJni.packHybridEcdh(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), f.DIq, (byte[])localObject1, paramAnonymousInt2, paramAnonymousArrayOfByte2.getRouteInfo(), 12);
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.DIq), Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
            AppMethodBeat.o(152467);
            return bool;
          }
          AppMethodBeat.o(152467);
          return false;
        }
      }
    });
    byte[] arrayOfByte = this.DJa.toByteArray();
    AppMethodBeat.o(152469);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.q.a
 * JD-Core Version:    0.7.0.1
 */