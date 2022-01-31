package com.tencent.mm.plugin.x;

import com.tencent.mm.j.f.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

final class f$2
  implements f.a
{
  f$2(f paramf, d paramd, aq paramaq) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    y.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdnCallback clientid:%s, startRet:%d proginfo:[%s], res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if (paramInt == -21005)
    {
      y.d("MicroMsg.MsgSynchronizeServer", "msgSynchronize  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { paramString });
      return 0;
    }
    if (paramInt != 0)
    {
      y.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback startRet failed. clientid:%s, startRet:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      this.mtl.cancel();
      f.Ir(this.msR.action);
      b.a(0L, 0L, 0L, 0L, 1, this.mtl.bSn, this.msR.action);
      return 0;
    }
    if (paramd != null)
    {
      if (paramd.field_retCode == 0) {
        break label226;
      }
      y.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback failed. sceneResult.retCode[%d], arg[%s], info[%s], clientid[%s], filemd5[%s]", new Object[] { Integer.valueOf(paramd.field_retCode), paramd.field_arg, paramd.field_transInfo, paramString, paramd.field_filemd5 });
      f.Ir(this.msR.action);
      this.mtl.cancel();
      b.a(0L, 0L, 0L, 0L, 1, this.mtl.bSn, this.msR.action);
    }
    for (;;)
    {
      return 0;
      label226:
      y.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize cdn callback success. clientid[%s], filemd5[%s], isHitCacheUpload[%d]", new Object[] { paramString, paramd.field_filemd5, Integer.valueOf(paramd.field_UploadHitCacheType) });
      paramString = new PByteArray();
      if (!MMProtocalJni.rsaPublicEncryptPemkey(paramd.field_aesKey.getBytes(), paramString, this.msR.msU))
      {
        y.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize MMProtocalJni rsaPublicEncryptPemkey failed!");
        return -1;
      }
      paramString = bk.bG(paramString.value);
      paramc = this.msR;
      String str = paramd.field_fileId;
      paramInt = paramd.field_fileLength;
      paramc.mta = new String(str);
      paramc.mtb = new String(paramString);
      paramc.mtc = paramInt;
      if (a.hw(g.DN().dJB))
      {
        y.i("MicroMsg.MsgSynchronizeServer", "sendAppMsg immediately.");
        this.mtl.a(this.msR, false);
      }
      else
      {
        y.i("MicroMsg.MsgSynchronizeServer", "wait getOnlineInfoExtDeviceOnlineListener to sendAppMsg.");
        au.Hx();
        com.tencent.mm.model.c.a(this.mtm);
        this.mtl.mtj = true;
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.x.f.2
 * JD-Core Version:    0.7.0.1
 */