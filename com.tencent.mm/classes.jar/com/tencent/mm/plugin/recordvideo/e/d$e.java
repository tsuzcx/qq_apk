package com.tencent.mm.plugin.recordvideo.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class d$e
  implements Runnable
{
  d$e(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(223938);
    Object localObject = h.aHG();
    kotlin.g.b.p.j(localObject, "MMKernel.storage()");
    boolean bool = ((f)localObject).aHp().getBoolean(ar.a.VnW, true);
    Log.i("MicroMsg.MediaFileUtil", "handleMultiVideoResult videoState : " + bool + ' ');
    if (bool)
    {
      localObject = AndroidMediaUtil.getExportImagePath("jpg");
      Context localContext = MMApplicationContext.getContext();
      String str = this.IeY;
      if (str == null) {
        kotlin.g.b.p.iCn();
      }
      com.tencent.mm.platformtools.p.l(localContext, str, (String)localObject);
      AndroidMediaUtil.refreshMediaScanner((String)localObject, MMApplicationContext.getContext());
    }
    AppMethodBeat.o(223938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.d.e
 * JD-Core Version:    0.7.0.1
 */