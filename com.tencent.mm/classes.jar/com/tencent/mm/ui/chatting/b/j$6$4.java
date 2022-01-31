package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;

final class j$6$4
  implements f.a
{
  j$6$4(j.6 param6, b paramb, bi parambi, HashSet paramHashSet) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, d paramd, boolean paramBoolean)
  {
    if ((paramInt == 0) && (paramc != null))
    {
      this.vjs.field_offset = paramc.field_finishedLength;
      ap.avh().c(this.vjs, new String[0]);
    }
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
    {
      y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.dUy.field_msgId) });
      this.vjs.field_status = 199L;
      this.vjs.field_offset = this.vjs.field_totalLen;
      ap.avh().c(this.vjs, new String[0]);
      this.dUy.setStatus(3);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(this.dUy.field_msgId, this.dUy);
      this.vmk.remove(Long.valueOf(this.dUy.field_msgId));
      j.6.a(this.vpw, this.vmk);
    }
    long l;
    if ((paramInt != 0) || ((paramd != null) && (paramd.field_retCode != 0)))
    {
      l = this.dUy.field_msgId;
      if (paramd != null) {
        break label274;
      }
    }
    label274:
    for (int i = 0;; i = paramd.field_retCode)
    {
      y.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(i) });
      this.vmk.remove(Long.valueOf(this.dUy.field_msgId));
      j.6.a(this.vpw, this.vmk);
      return 0;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.j.6.4
 * JD-Core Version:    0.7.0.1
 */