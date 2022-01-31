package com.tencent.mm.plugin.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;

final class f$2
  implements g.a
{
  f$2(f paramf, d paramd, as paramas) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(22904);
    ab.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      ab.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { paramString });
      AppMethodBeat.o(22904);
      return 0;
    }
    if (paramInt != 0)
    {
      ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      this.oSW.cancel();
      f.Ug(this.oSC.action);
      b.a(0L, 0L, 0L, 0L, 1, this.oSW.czO, this.oSC.action);
      AppMethodBeat.o(22904);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label250;
      }
      ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, paramString, paramd.field_filemd5 });
      f.Ug(this.oSC.action);
      this.oSW.cancel();
      b.a(0L, 0L, 0L, 0L, 1, this.oSW.czO, this.oSC.action);
    }
    for (;;)
    {
      AppMethodBeat.o(22904);
      return 0;
      label250:
      ab.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[] { paramString, paramd.field_filemd5, Integer.valueOf(paramd.field_UploadHitCacheType) });
      paramString = new PByteArray();
      if (!MMProtocalJni.rsaPublicEncryptPemkey(paramd.field_aesKey.getBytes(), paramString, this.oSC.oSF))
      {
        ab.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
        AppMethodBeat.o(22904);
        return -1;
      }
      paramString = bo.cg(paramString.value);
      paramc = this.oSC;
      String str = paramd.field_fileId;
      paramInt = paramd.field_fileLength;
      paramc.oSL = new String(str);
      paramc.oSM = new String(paramString);
      paramc.oSN = paramInt;
      if (a.jM(g.RJ().eHa))
      {
        ab.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
        this.oSW.a(this.oSC, false);
      }
      else
      {
        ab.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
        aw.aaz();
        com.tencent.mm.model.c.a(this.oSX);
        this.oSW.oSU = true;
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.q.f.2
 * JD-Core Version:    0.7.0.1
 */