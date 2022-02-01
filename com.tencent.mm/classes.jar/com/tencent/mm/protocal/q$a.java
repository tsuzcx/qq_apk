package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.w;
import com.tencent.mm.bx.b;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q$a
  extends l.d
  implements l.b
{
  public final anw Yyj;
  
  public q$a()
  {
    AppMethodBeat.i(152468);
    this.Yyj = new anw();
    setUin(0);
    this.Yyj.Zvx = new anv();
    this.Yyj.Zvx.Zvv = new abi();
    this.Yyj.Zvw = new anx();
    AppMethodBeat.o(152468);
  }
  
  public final int getFuncId()
  {
    if (f.Yxs) {
      return 784;
    }
    return 722;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(152469);
    setRsaInfo(ac.iQc());
    this.Yyj.Zvx.setBaseRequest(l.a(this));
    this.Yyj.Zvw.YOj = new gol().df(Util.getUuidRandom());
    setPassKey(this.Yyj.Zvw.YOj.aaxD.toByteArray());
    setReqPackControl(new l.a()
    {
      public final boolean reqToBuf(PByteArray paramAnonymousPByteArray, int paramAnonymousInt1, byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2, byte[] paramAnonymousArrayOfByte3, int paramAnonymousInt2, boolean paramAnonymousBoolean, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(257315);
        paramAnonymousArrayOfByte1 = (l.b)jdField_this;
        long l1 = jdField_this.getUin();
        if ((CrashReportFactory.hasDebuger()) && (l1 == 0L)) {
          l1 = d.Yxg;
        }
        for (;;)
        {
          paramAnonymousArrayOfByte3 = jdField_this.getRsaInfo();
          if (paramAnonymousInt1 == 722)
          {
            Log.e("MicroMsg.MMEncryptCheckResUpdate", "MMEncryptCheckResUpdate reqToBuf rsaReqData");
            anw localanw = ((q.a)jdField_this).Yyj;
            Object localObject = w.a(l1, localanw.Zvw, localanw.Zvx);
            if (localObject == null)
            {
              AppMethodBeat.o(257315);
              return false;
            }
            localanw = localObject[0];
            localObject = localObject[1];
            if (MMProtocalJni.packHybrid(paramAnonymousPByteArray, paramAnonymousArrayOfByte2, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte1.getFuncId(), paramAnonymousArrayOfByte3.ver, localanw, (byte[])localObject, paramAnonymousArrayOfByte3.YyO.getBytes(), paramAnonymousArrayOfByte3.YyP.getBytes(), jdField_this.getPassKey(), paramAnonymousInt3, ((q.a)jdField_this).getRouteInfo()))
            {
              Log.d("MicroMsg.MMEncryptCheckResUpdate", "IRemoteReqDelegate reqToBuf packHybrid using protobuf ok, len:%d, flag:%d", new Object[] { Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt3) });
              AppMethodBeat.o(257315);
              return true;
            }
          }
          else if (paramAnonymousInt1 == 784)
          {
            Log.i("MicroMsg.MMEncryptCheckResUpdate", "summerauths rsaInfo[%s] EcdhMgr.USE_ECDH[%s] engine[%s]", new Object[] { Integer.valueOf(paramAnonymousArrayOfByte3.ver), Boolean.valueOf(f.Yxs), Long.valueOf(((l.b)jdField_this).getECDHEngine()) });
            ((l.b)jdField_this).getFuncId();
            paramAnonymousPByteArray = new PByteArray();
            paramAnonymousArrayOfByte3 = ((l.b)jdField_this).toProtoBuf();
            if (paramAnonymousArrayOfByte3 == null)
            {
              Log.f("MicroMsg.MMEncryptCheckResUpdate", "protobuf is null");
              AppMethodBeat.o(257315);
              return false;
            }
            long l2 = f.cZ(null);
            jdField_this.setEcdhEngine(l2);
            paramAnonymousArrayOfByte3 = UtilsJni.HybridEcdhEncrypt(l2, paramAnonymousArrayOfByte3);
            paramAnonymousBoolean = MMProtocalJni.packHybridEcdh(paramAnonymousPByteArray, paramAnonymousArrayOfByte2, jdField_this.getDeviceID(), (int)l1, paramAnonymousArrayOfByte1.getFuncId(), f.iPL(), paramAnonymousArrayOfByte3, paramAnonymousInt3, paramAnonymousArrayOfByte1.getRouteInfo(), 12);
            Log.d("MicroMsg.MMEncryptCheckResUpdate", "summerauths MMFunc_SecMMEncryptCheckResUpdate reqToBuf packHybridEcdh using protobuf ok, jType:%d, cert:%d len:%d, flag:%d ret:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(f.iPL()), Integer.valueOf(paramAnonymousPByteArray.value.length), Integer.valueOf(paramAnonymousInt3), Boolean.valueOf(paramAnonymousBoolean) });
            AppMethodBeat.o(257315);
            return paramAnonymousBoolean;
          }
          AppMethodBeat.o(257315);
          return false;
        }
      }
    });
    byte[] arrayOfByte = this.Yyj.toByteArray();
    AppMethodBeat.o(152469);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.q.a
 * JD-Core Version:    0.7.0.1
 */