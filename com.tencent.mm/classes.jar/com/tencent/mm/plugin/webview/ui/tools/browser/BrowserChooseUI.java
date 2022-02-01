package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "()V", "dialogController", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController;", "hasShownDialog", "", "configStatusBar", "", "dismissDialog", "dialog", "Landroid/app/Dialog;", "withAnimation", "finishUI", "resultCode", "", "data", "Landroid/content/Intent;", "getLayoutId", "getTargetIntent", "getUIContext", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showDialog", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BrowserChooseUI
  extends MMActivity
  implements com.tencent.mm.plugin.webview.ui.tools.browser.model.a
{
  public static final a XaS;
  private final a XaT;
  private boolean XaU;
  
  static
  {
    AppMethodBeat.i(296507);
    XaS = new a((byte)0);
    AppMethodBeat.o(296507);
  }
  
  public BrowserChooseUI()
  {
    AppMethodBeat.i(296499);
    this.XaT = new a((com.tencent.mm.plugin.webview.ui.tools.browser.model.a)this);
    AppMethodBeat.o(296499);
  }
  
  private static final void a(BrowserChooseUI paramBrowserChooseUI)
  {
    AppMethodBeat.i(296503);
    s.u(paramBrowserChooseUI, "this$0");
    paramBrowserChooseUI.XaT.izH();
    AppMethodBeat.o(296503);
  }
  
  public final void e(Dialog paramDialog)
  {
    AppMethodBeat.i(296538);
    Log.d("MicroMsg.BrowserChooseUI", "alvinluo showDialog dialog: %s, withAnimation: %b", new Object[] { paramDialog, Boolean.TRUE });
    if (paramDialog != null) {
      paramDialog.show();
    }
    AppMethodBeat.o(296538);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final Context getUIContext()
  {
    AppMethodBeat.i(296544);
    Context localContext = (Context)getContext();
    AppMethodBeat.o(296544);
    return localContext;
  }
  
  public final Intent izK()
  {
    AppMethodBeat.i(296549);
    Intent localIntent = (Intent)getIntent().getParcelableExtra("targetintent");
    AppMethodBeat.o(296549);
    return localIntent;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(296528);
    super.onCreate(paramBundle);
    a locala = this.XaT;
    locala.mSessionId = System.currentTimeMillis();
    Log.i("MicroMsg.BrowserChooseController", "alvinluo onCreate uiModel: %s, sessionId: %s", new Object[] { locala.XaF, Long.valueOf(locala.mSessionId) });
    locala.XaG.clear();
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.browser.storage.a.izM();
    paramBundle = locala.XaF.getUIContext();
    s.checkNotNull(paramBundle);
    List localList = b.aK(paramBundle, locala.XaF.izK());
    Iterator localIterator = ((Iterable)localList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramBundle = (ResolveInfo)localIterator.next();
      if (paramBundle != null)
      {
        f localf = new f(1);
        localf.qK = paramBundle;
        paramBundle = locala.XaF.getUIContext();
        s.checkNotNull(paramBundle);
        paramBundle = b.b(paramBundle, localf.qK);
        s.u(paramBundle, "<set-?>");
        localf.title = paramBundle;
        paramBundle = localf.qK;
        if (paramBundle == null) {
          paramBundle = null;
        }
        for (;;)
        {
          if (n.T((String)localObject, paramBundle, false)) {
            locala.XaI = i;
          }
          locala.XaG.add(localf);
          i += 1;
          break;
          paramBundle = paramBundle.activityInfo;
          if (paramBundle == null) {
            paramBundle = null;
          } else {
            paramBundle = paramBundle.packageName;
          }
        }
      }
    }
    locala.XaH = locala.XaG.size();
    Log.d("MicroMsg.BrowserChooseController", "alvinluo initBrowserList defaultBrowser: %s, defaultBrowserIndex: %s, %s %s", new Object[] { localObject, Integer.valueOf(locala.XaI), Integer.valueOf(localList.size()), Integer.valueOf(locala.XaG.size()) });
    if (locala.XaG.isEmpty())
    {
      localObject = locala.XaF.getUIContext();
      paramBundle = locala.XaF.getUIContext();
      if (paramBundle != null) {
        break label405;
      }
      paramBundle = null;
    }
    for (;;)
    {
      Toast.makeText((Context)localObject, (CharSequence)paramBundle, 0).show();
      locala.u(1, null);
      getController().setStatusBarColor(bb.gy(getResources().getColor(c.c.white), 0));
      AppMethodBeat.o(296528);
      return;
      label405:
      paramBundle = paramBundle.getResources();
      if (paramBundle == null) {
        paramBundle = null;
      } else {
        paramBundle = paramBundle.getString(c.i.webview_browser_no_browser_app);
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(296533);
    super.onResume();
    if (!this.XaU)
    {
      this.XaU = true;
      h.ahAA.o(new BrowserChooseUI..ExternalSyntheticLambda0(this), 50L);
    }
    AppMethodBeat.o(296533);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void u(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(296555);
    if (paramIntent == null) {
      bool = true;
    }
    Log.v("MicroMsg.BrowserChooseUI", "alvinluo BrowserDialog finishUI resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    setResult(paramInt, paramIntent);
    finish();
    AppMethodBeat.o(296555);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseUI$Companion;", "", "()V", "EXTRA_BROWSER_SETTING_RESULT", "", "EXTRA_KEY_SCENE", "EXTRA_KEY_SHOW_BROWSER_RESOLVE_INFO", "EXTRA_KEY_SHOW_BROWSER_WITH_ANIMATION", "EXTRA_KEY_SHOW_WEBVIEW_MENU", "EXTRA_KEY_TARGET_INTENT", "EXTRA_KEY_TRANSERFER_BACK", "EXTRA_KEY_URL", "TAG", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.BrowserChooseUI
 * JD-Core Version:    0.7.0.1
 */