package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ah.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class al$1$3$1
  implements Runnable
{
  al$1$3$1(al.1.3 param3) {}
  
  public final void run()
  {
    this.rVc.rVa.rUZ.epi = false;
    this.rVc.rVa.rUZ.rUA.field_createTime = bk.UY();
    this.rVc.rVa.rUZ.rUA.field_lastModifyTime = bk.UX();
    this.rVc.rVa.rUZ.rUA.field_offset = 0L;
    this.rVc.rVa.rUZ.rUA.field_status = 101L;
    boolean bool = ap.avh().c(this.rVc.rVa.rUZ.rUA, new String[0]);
    y.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(this.rVc.rVa.rUZ.epi), Boolean.valueOf(bool), Long.valueOf(this.rVc.rVa.rUZ.rUA.field_createTime) });
    this.rVc.rVa.rUZ.a(this.rVc.rVa.rUZ.edc, this.rVc.rVa.rUZ.dmL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al.1.3.1
 * JD-Core Version:    0.7.0.1
 */