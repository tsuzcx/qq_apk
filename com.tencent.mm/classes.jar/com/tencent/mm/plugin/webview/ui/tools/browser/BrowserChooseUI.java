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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.t;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "()V", "dialogController", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController;", "hasShownDialog", "", "configStatusBar", "", "dismissDialog", "dialog", "Landroid/app/Dialog;", "withAnimation", "finishUI", "resultCode", "", "data", "Landroid/content/Intent;", "getLayoutId", "getTargetIntent", "getUIContext", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showDialog", "Companion", "plugin-webview_release"})
public final class BrowserChooseUI
  extends MMActivity
  implements com.tencent.mm.plugin.webview.ui.tools.browser.model.a
{
  public static final BrowserChooseUI.a JlF;
  private final a JlD;
  private boolean JlE;
  
  static
  {
    AppMethodBeat.i(210429);
    JlF = new BrowserChooseUI.a((byte)0);
    AppMethodBeat.o(210429);
  }
  
  public BrowserChooseUI()
  {
    AppMethodBeat.i(210428);
    this.JlD = new a((com.tencent.mm.plugin.webview.ui.tools.browser.model.a)this);
    AppMethodBeat.o(210428);
  }
  
  public final void d(Dialog paramDialog)
  {
    AppMethodBeat.i(210424);
    Log.d("MicroMsg.BrowserChooseUI", "alvinluo showDialog dialog: %s, withAnimation: %b", new Object[] { paramDialog, Boolean.TRUE });
    if (paramDialog != null)
    {
      paramDialog.show();
      AppMethodBeat.o(210424);
      return;
    }
    AppMethodBeat.o(210424);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final Intent getTargetIntent()
  {
    AppMethodBeat.i(210426);
    Intent localIntent = (Intent)getIntent().getParcelableExtra("targetintent");
    AppMethodBeat.o(210426);
    return localIntent;
  }
  
  public final Context getUIContext()
  {
    AppMethodBeat.i(210425);
    Context localContext = (Context)getContext();
    AppMethodBeat.o(210425);
    return localContext;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(210422);
    super.onCreate(paramBundle);
    a locala = this.JlD;
    locala.mSessionId = System.currentTimeMillis();
    Log.i("MicroMsg.BrowserChooseController", "alvinluo onCreate uiModel: %s, sessionId: %s", new Object[] { locala.Jlp, Long.valueOf(locala.mSessionId) });
    locala.Jli.clear();
    Object localObject = com.tencent.mm.plugin.webview.ui.tools.browser.storage.a.ggv();
    paramBundle = locala.Jlp.getUIContext();
    if (paramBundle == null) {
      p.hyc();
    }
    List localList = b.as(paramBundle, locala.Jlp.getTargetIntent());
    Iterator localIterator = ((Iterable)localList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paramBundle = (ResolveInfo)localIterator.next();
      if (paramBundle != null)
      {
        f localf = new f(1);
        localf.resolveInfo = paramBundle;
        paramBundle = locala.Jlp.getUIContext();
        if (paramBundle == null) {
          p.hyc();
        }
        paramBundle = b.b(paramBundle, localf.resolveInfo);
        p.h(paramBundle, "<set-?>");
        localf.title = paramBundle;
        paramBundle = localf.resolveInfo;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.activityInfo;
          if (paramBundle == null) {}
        }
        for (paramBundle = paramBundle.packageName;; paramBundle = null)
        {
          if (n.I((String)localObject, paramBundle, false)) {
            locala.Jlk = i;
          }
          locala.Jli.add(localf);
          i += 1;
          break;
        }
      }
    }
    locala.Jlj = locala.Jli.size();
    Log.d("MicroMsg.BrowserChooseController", "alvinluo initBrowserList defaultBrowser: %s, defaultBrowserIndex: %s, %s %s", new Object[] { localObject, Integer.valueOf(locala.Jlk), Integer.valueOf(localList.size()), Integer.valueOf(locala.Jli.size()) });
    if (locala.Jli.isEmpty())
    {
      localObject = locala.Jlp.getUIContext();
      paramBundle = locala.Jlp.getUIContext();
      if (paramBundle == null) {
        break label421;
      }
      paramBundle = paramBundle.getResources();
      if (paramBundle == null) {
        break label421;
      }
    }
    label421:
    for (paramBundle = paramBundle.getString(2131768536);; paramBundle = null)
    {
      Toast.makeText((Context)localObject, (CharSequence)paramBundle, 0).show();
      locala.r(1, null);
      getController().setStatusBarColor(ar.fj(getResources().getColor(2131101424), 0));
      AppMethodBeat.o(210422);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(210423);
    super.onResume();
    if (!this.JlE)
    {
      this.JlE = true;
      h.RTc.n((Runnable)new b(this), 50L);
    }
    AppMethodBeat.o(210423);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void r(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(210427);
    if (paramIntent == null) {
      bool = true;
    }
    Log.v("MicroMsg.BrowserChooseUI", "alvinluo BrowserDialog finishUI resultCode: %d, data == null: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
    setResult(paramInt, paramIntent);
    finish();
    AppMethodBeat.o(210427);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(BrowserChooseUI paramBrowserChooseUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(210421);
      a locala = BrowserChooseUI.a(this.JlG);
      locala.ggt();
      c.q(locala.mSessionId, 1, locala.Jlj);
      AppMethodBeat.o(210421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.BrowserChooseUI
 * JD-Core Version:    0.7.0.1
 */