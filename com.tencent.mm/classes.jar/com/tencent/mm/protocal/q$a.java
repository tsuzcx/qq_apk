package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.x;
import com.tencent.mm.bw.b;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ajk;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q$a
  extends l.d
  implements l.b
{
  public final ajl KzQ;
  
  public q$a()
  {
    AppMethodBeat.i(152468);
    this.KzQ = new ajl();
    setUin(0);
    this.KzQ.LsX = new ajk();
    this.KzQ.LsX.LsV = new zh();
    this.KzQ.LsW = new ajm();
    AppMethodBeat.o(152468);
  }
  
  public final int getFuncId()
  {
    if (f.KyZ) {
      return 784;
    }
    return 722;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(152469);
    setRsaInfo(ac.gtR());
    this.KzQ.LsX.setBaseRequest(l.a(this));
    this.KzQ.LsW.KPW = new SKBuiltinBuffer_t().setBuffer(Util.getUuidRandom());
    setPassKey(this.KzQ.LsW.KPW.getBuffer().toByteArray());
    setReqPackControl(new l.a()
    {
      public final boolean a(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, int paramAnonymousInt2)
      {
        AppMethodBeat.i(152467);
        paramAnonymousArrayOfByte2 = (l.b)jdField_this;
        long l1 = jdField_this.getUin();
        if ((CrashReportFactory.hasDebuger()) && (l1 == 0L)) {
          l1 = d.KyN;
        }
        for (;;)
        {
          Object localObject1 = jdField_this.getRsaInfo();
          if (paramAnonymousInt1 == 722)
          {
            Log.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
            ajl localajl = ((q.a)jdField_this).KzQ;
            Object localObject2 = x.a(l1, localajl.LsW, localajl.LsX);
            if (localObject2 == null)
            {
              AppMethodBeat.o(152467);
              return false;
            }
            localajl = localObject2[0];
            localObject2 = localObject2[1];
            if (MMProtocalJni.packHybrid(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), ((ac)localObject1).ver, localajl, (byte[])localObject2, ((ac)localObject1).KAw.getBytes(), ((ac)localObject1).KAx.getBytes(), jdField_this.getPassKey(), paramAnonymousInt2, ((q.a)jdField_this).getRouteInfo()))
            {
              Log.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2) });
              AppMethodBeat.o(152467);
              return true;
            }
          }
          else if (paramAnonymousInt1 == 784)
          {
            Log.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", new Object[] { Integer.valueOf(((ac)localObject1).ver), Boolean.valueOf(f.KyZ), Long.valueOf(((l.b)jdField_this).getECDHEngine()) });
            ((l.b)jdField_this).getFuncId();
            paramAnonymousPByteArray = new PByteArray();
            localObject1 = ((l.b)jdField_this).toProtoBuf();
            if (localObject1 == null)
            {
              Log.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
              AppMethodBeat.o(152467);
              return false;
            }
            long l2 = f.cF(null);
            jdField_this.setEcdhEngine(l2);
            localObject1 = UtilsJni.HybridEcdhEncrypt(l2, (byte[])localObject1);
            boolean bool = MMProtocalJni.packHybridEcdh(paramAnonymousPByteArray, paramAnonymousArrayOfByte1, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte2.getFuncId(), f.Kze, (byte[])localObject1, paramAnonymousInt2, paramAnonymousArrayOfByte2.getRouteInfo(), 12);
            Log.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.Kze), Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt2), Boolean.valueOf(bool) });
            AppMethodBeat.o(152467);
            return bool;
          }
          AppMethodBeat.o(152467);
          return false;
        }
      }
    });
    byte[] arrayOfByte = this.KzQ.toByteArray();
    AppMethodBeat.o(152469);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.q.a
 * JD-Core Version:    0.7.0.1
 */