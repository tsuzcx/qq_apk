package com.tencent.mm.plugin.scanner.e.a;

import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/uploader/BaseAiImageUploader;", "Lcom/tencent/mm/plugin/scanner/image/uploader/AiImageUploader;", "()V", "onFailedWrapper", "", "session", "", "opImageType", "", "errType", "errCode", "errMsg", "", "resultCallback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e
  implements c
{
  public static final e.a OQN = new e.a((byte)0);
  
  protected static void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString, g paramg)
  {
    Log.e("MicroMsg.BaseAiImageUploader", "onScanFailed session: %d, errCode: %d, errMsg: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt3), paramString });
    f localf = new f();
    localf.OMG = paramInt1;
    localf.hBk = paramLong;
    localf.success = false;
    localf.errType = paramInt2;
    localf.errCode = paramInt3;
    localf.errMsg = paramString;
    h.ahAA.bk(new e..ExternalSyntheticLambda0(paramg, paramLong, localf));
  }
  
  private static final void a(g paramg, long paramLong, f paramf)
  {
    s.u(paramf, "$result");
    if (paramg != null) {
      paramg.onCallback(paramLong, paramf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a.e
 * JD-Core Version:    0.7.0.1
 */