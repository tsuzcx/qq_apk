package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;

final class j$6$4
  implements g.a
{
  j$6$4(j.6 param6, b paramb, bi parambi, HashSet paramHashSet) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(31320);
    if ((paramInt == 0) && (paramc != null))
    {
      this.zyr.field_offset = paramc.field_finishedLength;
      al.aUJ().a(this.zyr, new String[0]);
    }
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
    {
      ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d", new Object[] { Long.valueOf(this.fkH.field_msgId) });
      this.zyr.field_status = 199L;
      this.zyr.field_offset = this.zyr.field_totalLen;
      al.aUJ().a(this.zyr, new String[0]);
      this.fkH.setStatus(3);
      aw.aaz();
      com.tencent.mm.model.c.YC().a(this.fkH.field_msgId, this.fkH);
      this.zBI.remove(Long.valueOf(this.fkH.field_msgId));
      j.6.a(this.zEY, this.zBI);
    }
    long l;
    if ((paramInt != 0) || ((paramd != null) && (paramd.field_retCode != 0)))
    {
      l = this.fkH.field_msgId;
      if (paramd != null) {
        break label286;
      }
    }
    label286:
    for (int i = 0;; i = paramd.field_retCode)
    {
      ab.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav success msgID:%d, error(%d,%d)", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt), Integer.valueOf(i) });
      this.zBI.remove(Long.valueOf(this.fkH.field_msgId));
      j.6.a(this.zEY, this.zBI);
      AppMethodBeat.o(31320);
      return 0;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.j.6.4
 * JD-Core Version:    0.7.0.1
 */