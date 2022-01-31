package com.tencent.mm.ui.chatting;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;

final class ab$4
  implements g.a
{
  ab$4(ab paramab, b paramb, a parama, Object paramObject) {}
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(30933);
    if ((paramInt == 0) && (paramc != null))
    {
      this.zyr.field_offset = paramc.field_finishedLength;
      al.aUJ().a(this.zyr, new String[0]);
    }
    if ((paramInt == 0) && (paramd != null) && (paramd.field_retCode == 0))
    {
      this.zyr.field_status = 199L;
      this.zyr.field_offset = this.zyr.field_totalLen;
      al.aUJ().a(this.zyr, new String[0]);
      this.zBO.cmQ.setStatus(3);
      aw.aaz();
      com.tencent.mm.model.c.YC().a(this.zBO.cmQ.field_msgId, this.zBO.cmQ);
      new ak(Looper.getMainLooper()).post(new ab.4.1(this));
    }
    AppMethodBeat.o(30933);
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ab.4
 * JD-Core Version:    0.7.0.1
 */