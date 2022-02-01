package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class e$d
  implements Runnable
{
  e$d(e.c paramc, int paramInt1, int paramInt2, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(288202);
    Object localObject = this.WXe;
    if (u.agG(((e.c)localObject).imagePath))
    {
      String str = MD5Util.getMD5String(u.aY(((e.c)localObject).imagePath, 0, -1));
      p.j(str, "MD5Util.getMD5String(VFS…omFile(imagePath, 0, -1))");
      p.k(str, "<set-?>");
      ((e.c)localObject).WXb = str;
      Log.v("MicroMsg.ImageScanButtonReporter", "alvinluo doReportSearchButtonAction sessionId: %s, msgId: %s, detectId: %s, action: %d, source: %d, scene: %d, chatType: %d, username: %s, chatRoomId: %s, imagePath: %s, md5: %s, serverSessionId: %s", new Object[] { ((e.c)localObject).sessionId, Long.valueOf(((e.c)localObject).msgId), Long.valueOf(((e.c)localObject).WWZ), Integer.valueOf(this.mpJ), Integer.valueOf(this.IKB), Integer.valueOf(((e.c)localObject).scene), Integer.valueOf(((e.c)localObject).chatType), ((e.c)localObject).WXa, ((e.c)localObject).uxC, ((e.c)localObject).imagePath, ((e.c)localObject).WXb, Long.valueOf(((e.c)localObject).WXc) });
      localObject = new ah();
      ((ah)localObject).iX(this.WXe.sessionId);
      ((ah)localObject).le(this.mpJ);
      ((ah)localObject).lf(this.IKB);
      ((ah)localObject).lg(this.WXe.scene);
      ((ah)localObject).iY(String.valueOf(this.WXe.msgId));
      ((ah)localObject).lh(this.WXe.chatType);
      ((ah)localObject).ja(this.WXe.uxC);
      ((ah)localObject).jb(this.WXe.WXb);
      ((ah)localObject).cq(this.nJi);
      ((ah)localObject).bpa();
    }
    AppMethodBeat.o(288202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.e.d
 * JD-Core Version:    0.7.0.1
 */