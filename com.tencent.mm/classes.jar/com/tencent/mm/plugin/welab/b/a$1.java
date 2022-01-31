package com.tencent.mm.plugin.welab.b;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.lc;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.sdk.b.b;
import java.util.Map;

final class a$1
  implements Runnable
{
  a$1(a parama, String paramString, Activity paramActivity) {}
  
  public final void run()
  {
    Intent localIntent = aa.bZt();
    localIntent.putExtra("ftsbizscene", 21);
    localIntent.putExtra("ftsQuery", this.BG);
    localIntent.putExtra("title", this.BG);
    localIntent.putExtra("isWebwx", this.BG);
    localIntent.putExtra("ftscaneditable", false);
    Object localObject = aa.b(21, false, 2);
    ((Map)localObject).put("query", this.BG);
    ((Map)localObject).put("sceneActionType", "2");
    localIntent.putExtra("rawUrl", aa.c((Map)localObject, 1));
    localObject = new lc();
    ((lc)localObject).bUc.scene = 0;
    com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    d.b(this.val$activity, "webview", ".ui.tools.fts.FTSWebViewUI", localIntent);
    ao.aT(21, this.BG);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.b.a.1
 * JD-Core Version:    0.7.0.1
 */