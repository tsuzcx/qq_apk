package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.b.b;
import java.util.Map;

final class a$1
  implements Runnable
{
  a$1(a parama, String paramString, Activity paramActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(26575);
    Intent localIntent = aa.cZp();
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", this.Cr);
    localIntent.putExtra("title", this.Cr);
    localIntent.putExtra("isWebwx", this.Cr);
    localIntent.putExtra("ftscaneditable", false);
    Object localObject = aa.d(21, false, 2);
    ((Map)localObject).put("query", this.Cr);
    ((Map)localObject).put("sceneActionType", "2");
    localIntent.putExtra("rawUrl", aa.d((Map)localObject, 1));
    localObject = new lq();
    ((lq)localObject).cBH.scene = 0;
    com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    d.b(this.val$activity, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
    an.bz(21, this.Cr);
    AppMethodBeat.o(26575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.a.1
 * JD-Core Version:    0.7.0.1
 */