package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "mDialogView", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;", "selectedIndex", "", "onCreateDialogView", "Landroid/view/View;", "release", "", "setBrowserList", "list", "setBrowserSelectedIndex", "index", "setBrowserSettingDialogClickListener", "listener", "Companion", "plugin-webview_release"})
public final class c
  extends a
{
  public static final a QjD;
  public List<f> QiA;
  public BrowserSettingDialogView QjB;
  public com.tencent.mm.plugin.webview.ui.tools.browser.listener.c QjC;
  public int bhr = -1;
  
  static
  {
    AppMethodBeat.i(258645);
    QjD = new a((byte)0);
    AppMethodBeat.o(258645);
  }
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final View gZK()
  {
    AppMethodBeat.i(258641);
    Object localObject = getContext();
    p.j(localObject, "context");
    this.QjB = new BrowserSettingDialogView((Context)localObject);
    localObject = this.QjB;
    if (localObject != null)
    {
      a locala = (a)this;
      p.k(locala, "dialog");
      ((BrowserSettingDialogView)localObject).Qjp = locala;
    }
    localObject = this.QjB;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setBrowserList(this.QiA);
    }
    localObject = this.QjB;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setSelectedBrowser(this.bhr);
    }
    localObject = this.QjB;
    if (localObject != null) {
      ((BrowserSettingDialogView)localObject).setBrowserSettingDialogClickListener(this.QjC);
    }
    localObject = this.QjB;
    if (localObject == null) {
      p.iCn();
    }
    localObject = (View)localObject;
    AppMethodBeat.o(258641);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.c
 * JD-Core Version:    0.7.0.1
 */