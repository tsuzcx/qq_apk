package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.w;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "()V", "dialogController", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController;", "hasShownDialog", "", "configStatusBar", "", "dismissDialog", "dialog", "Landroid/app/Dialog;", "withAnimation", "finishUI", "resultCode", "", "data", "Landroid/content/Intent;", "getLayoutId", "getTargetIntent", "getUIContext", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showDialog", "Companion", "plugin-webview_release"})
public final class BrowserChooseUI
  extends MMActivity
  implements com.tencent.mm.plugin.webview.ui.tools.browser.model.a
{
  public static final a QiX;
  private final a QiV;
  private boolean QiW;
  
  static
  {
    AppMethodBeat.i(223228);
    QiX = new a((byte)0);
    AppMethodBeat.o(223228);
  }
  
  public BrowserChooseUI()
  {
    AppMethodBeat.i(223227);
    this.QiV = new a((com.tencent.mm.plugin.webview.ui.tools.browser.model.a)this);
    AppMethodBeat.o(223227);
  }
  
  public final void e(Dialog paramDialog)
  {
    AppMethodBeat.i(223217);
    Log.d("MicroMsg.BrowserChooseUI", "alvinluo showDialog dialog: %s, withAnimation: %b", new Object[] { paramDialog, Boolean.TRUE });
    if (paramDialog != null)
    {
      paramDialog.show();
      AppMethodBeat.o(223217);
      return;
    }
    AppMethodBeat.o(223217);
  }
  
  public final Intent gZH()
  {
    AppMethodBeat.i(223223);
    Intent localIntent = (Intent)getIntent().getParcelableExtra("targetintent");
    AppMethodBeat.o(223223);
    return localIntent;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final Context getUIContext()
  {
    AppMethodBeat.i(223221);
    Context localContext = (Context)getContext();
    AppMethodBeat.o(223221);
    return localContext;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(223212);
    super.onCreate(paramBundle);
    a locala = this.QiV;
    locala.mSessionId = System.currentTimeMillis();
    Log.i("MicroMsg.BrowserChooseController", "alvinluo onCreate uiModel: %s, sessionId: %s", new Object[] { locala.QiH, Long.valueOf(locala.mSessionId) });
    locala.QiA.clear();
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.browser.storage.a.gZJ();
    paramBundle = locala.QiH.getUIContext();
    if (paramBundle == null) {
      p.iCn();
    }
    List localList = b.aB(paramBundle, locala.QiH.gZH());
    Iterator localIterator = ((Iterable)localList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramBundle = (ResolveInfo)localIterator.next();
      if (paramBundle != null)
      {
        f localf = new f(1);
        localf.pN = paramBundle;
        paramBundle = locala.QiH.getUIContext();
        if (paramBundle == null) {
          p.iCn();
        }
        paramBundle = b.b(paramBundle, localf.pN);
        p.k(paramBundle, "<set-?>");
        localf.title = paramBundle;
        paramBundle = localf.pN;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.activityInfo;
          if (paramBundle == null) {}
        }
        for (paramBundle = paramBundle.packageName;; paramBundle = null)
        {
          if (n.L((String)localObject, paramBundle, false)) {
            locala.QiC = i;
          }
          locala.QiA.add(localf);
          i += 1;
          break;
        }
      }
    }
    locala.QiB = locala.QiA.size();
    Log.d("MicroMsg.BrowserChooseController", "alvinluo initBrowserList defaultBrowser: %s, defaultBrowserIndex: %s, %s %s", new Object[] { localObject, Integer.valueOf(locala.QiC), Integer.valueOf(localList.size()), Integer.valueOf(locala.QiA.size()) });
    if (locala.QiA.isEmpty())
    {
      localObject = locala.QiH.getUIContext();
      paramBundle = locala.QiH.getUIContext();
      if (paramBundle == null) {
        break label421;
      }
      paramBundle = paramBundle.getResources();
      if (paramBundle == null) {
        break label421;
      }
    }
    label421:
    for (paramBundle = paramBundle.getString(c.i.webview_browser_no_browser_app);; paramBundle = null)
    {
      Toast.makeText((Context)localObject, (CharSequence)paramBundle, 0).show();
      locala.r(1, null);
      getController().setStatusBarColor(au.fG(getResources().getColor(c.c.white), 0));
      AppMethodBeat.o(223212);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(223214);
    super.onResume();
    if (!this.QiW)
    {
      this.QiW = true;
      h.ZvG.n((Runnable)new b(this), 50L);
    }
    AppMethodBeat.o(223214);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void r(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(223225);
    if (paramIntent == null) {
      bool = true;
    }
    Log.v("MicroMsg.BrowserChooseUI", "alvinluo BrowserDialog finishUI resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    setResult(paramInt, paramIntent);
    finish();
    AppMethodBeat.o(223225);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseUI$Companion;", "", "()V", "EXTRA_BROWSER_SETTING_RESULT", "", "EXTRA_KEY_SCENE", "EXTRA_KEY_SHOW_BROWSER_RESOLVE_INFO", "EXTRA_KEY_SHOW_BROWSER_WITH_ANIMATION", "EXTRA_KEY_SHOW_WEBVIEW_MENU", "EXTRA_KEY_TARGET_INTENT", "EXTRA_KEY_TRANSERFER_BACK", "EXTRA_KEY_URL", "TAG", "plugin-webview_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(BrowserChooseUI paramBrowserChooseUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(249366);
      a locala = BrowserChooseUI.a(this.QiY);
      locala.gZG();
      c.r(locala.mSessionId, 1, locala.QiB);
      AppMethodBeat.o(249366);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.BrowserChooseUI
 * JD-Core Version:    0.7.0.1
 */