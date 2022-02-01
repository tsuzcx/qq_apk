package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "mDialogView", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;", "selectedIndex", "", "onCreateDialogView", "Landroid/view/View;", "release", "", "setBrowserList", "list", "setBrowserSelectedIndex", "index", "setBrowserSettingDialogClickListener", "listener", "Companion", "plugin-webview_release"})
public final class c
  extends a
{
  public static final c.a Jmm;
  public List<f> Jli;
  public BrowserSettingDialogView Jmk;
  public com.tencent.mm.plugin.webview.ui.tools.browser.listener.c Jml;
  public int bxP = -1;
  
  static
  {
    AppMethodBeat.i(210470);
    Jmm = new c.a((byte)0);
    AppMethodBeat.o(210470);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final View onCreateDialogView()
  {
    AppMethodBeat.i(210469);
    Object localObject = getContext();
    p.g(localObject, "context");
    this.Jmk = new BrowserSettingDialogView((Context)localObject);
    localObject = this.Jmk;
    if (localObject != null)
    {
      a locala = (a)this;
      p.h(locala, "dialog");
      ((BrowserSettingDialogView)localObject).JlX = locala;
    }
    localObject = this.Jmk;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setBrowserList(this.Jli);
    }
    localObject = this.Jmk;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setSelectedBrowser(this.bxP);
    }
    localObject = this.Jmk;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setBrowserSettingDialogClickListener(this.Jml);
    }
    localObject = this.Jmk;
    if (localObject == null) {
      p.hyc();
    }
    localObject = (View)localObject;
    AppMethodBeat.o(210469);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.c
 * JD-Core Version:    0.7.0.1
 */