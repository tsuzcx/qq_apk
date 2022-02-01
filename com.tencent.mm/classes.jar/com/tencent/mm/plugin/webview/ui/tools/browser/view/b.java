package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "mDialogView", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;", "onCreateDialogView", "Landroid/view/View;", "release", "", "setBrowserClickListener", "listener", "setBrowserList", "list", "Companion", "plugin-webview_release"})
public final class b
  extends a
{
  public static final a Qjl;
  public List<f> QiA;
  private BrowserChooseDialogView Qjj;
  public com.tencent.mm.plugin.webview.ui.tools.browser.listener.a Qjk;
  
  static
  {
    AppMethodBeat.i(249188);
    Qjl = new a((byte)0);
    AppMethodBeat.o(249188);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final View gZK()
  {
    AppMethodBeat.i(249184);
    Object localObject = getContext();
    p.j(localObject, "context");
    this.Qjj = new BrowserChooseDialogView((Context)localObject);
    localObject = this.Qjj;
    if (localObject != null)
    {
      a locala = (a)this;
      p.k(locala, "dialog");
      ((BrowserChooseDialogView)localObject).Qjp = locala;
    }
    localObject = this.Qjj;
    if (localObject != null) {
      ((BrowserChooseDialogView)localObject).setBrowserClickListener(this.Qjk);
    }
    localObject = this.Qjj;
    if (localObject != null) {
      ((BrowserChooseDialogView)localObject).setBrowserList(this.QiA);
    }
    localObject = this.Qjj;
    if (localObject == null) {
      p.iCn();
    }
    localObject = (View)localObject;
    AppMethodBeat.o(249184);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.b
 * JD-Core Version:    0.7.0.1
 */