package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "mDialogView", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;", "selectedIndex", "", "onCreateDialogView", "Landroid/view/View;", "release", "", "setBrowserList", "list", "setBrowserSelectedIndex", "index", "setBrowserSettingDialogClickListener", "listener", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final a Xbw;
  public List<f> XaG;
  public BrowserSettingDialogView Xbx;
  public com.tencent.mm.plugin.webview.ui.tools.browser.listener.c Xby;
  public int dbk = -1;
  
  static
  {
    AppMethodBeat.i(296609);
    Xbw = new a((byte)0);
    AppMethodBeat.o(296609);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final View izN()
  {
    AppMethodBeat.i(296619);
    Object localObject = getContext();
    s.s(localObject, "context");
    this.Xbx = new BrowserSettingDialogView((Context)localObject);
    localObject = this.Xbx;
    if (localObject != null)
    {
      a locala = (a)this;
      s.u(locala, "dialog");
      ((BrowserSettingDialogView)localObject).Xbl = locala;
    }
    localObject = this.Xbx;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setBrowserList(this.XaG);
    }
    localObject = this.Xbx;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setSelectedBrowser(this.dbk);
    }
    localObject = this.Xbx;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setBrowserSettingDialogClickListener(this.Xby);
    }
    localObject = this.Xbx;
    s.checkNotNull(localObject);
    localObject = (View)localObject;
    AppMethodBeat.o(296619);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.c
 * JD-Core Version:    0.7.0.1
 */