package com.tencent.mm.plugin.scanner.e.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/uploader/BaseAiImageUploader;", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader;", "()V", "onFailedWrapper", "", "session", "", "opImageType", "", "errType", "errCode", "errMsg", "", "resultCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "Companion", "plugin-scan_release"})
public abstract class e
  implements c
{
  public static final e.a IKd = new e.a((byte)0);
  
  protected static void a(final long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, g paramg)
  {
    Log.e("MicroMsg.BaseAiImageUploader", "onScanFailed session: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt3), paramString });
    f localf = new f();
    localf.IGy = paramInt1;
    localf.fwK = paramLong;
    localf.success = false;
    localf.errType = paramInt2;
    localf.errCode = paramInt3;
    localf.errMsg = paramString;
    h.ZvG.bc((Runnable)new b(paramg, paramLong, localf));
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(g paramg, long paramLong, f paramf) {}
    
    public final void run()
    {
      AppMethodBeat.i(218540);
      g localg = this.IJS;
      if (localg != null)
      {
        localg.a(paramLong, this.IKa);
        AppMethodBeat.o(218540);
        return;
      }
      AppMethodBeat.o(218540);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.e
 * JD-Core Version:    0.7.0.1
 */