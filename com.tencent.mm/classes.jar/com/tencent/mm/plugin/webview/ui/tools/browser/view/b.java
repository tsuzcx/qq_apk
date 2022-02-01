package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "mDialogView", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;", "onCreateDialogView", "Landroid/view/View;", "release", "", "setBrowserClickListener", "listener", "setBrowserList", "list", "Companion", "plugin-webview_release"})
public final class b
  extends a
{
  public static final b.a JlT;
  private BrowserChooseDialogView JlR;
  public com.tencent.mm.plugin.webview.ui.tools.browser.listener.a JlS;
  public List<f> Jli;
  
  static
  {
    AppMethodBeat.i(210447);
    JlT = new b.a((byte)0);
    AppMethodBeat.o(210447);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final View onCreateDialogView()
  {
    AppMethodBeat.i(210446);
    Object localObject = getContext();
    p.g(localObject, "context");
    this.JlR = new BrowserChooseDialogView((Context)localObject);
    localObject = this.JlR;
    if (localObject != null)
    {
      a locala = (a)this;
      p.h(locala, "dialog");
      ((BrowserChooseDialogView)localObject).JlX = locala;
    }
    localObject = this.JlR;
    if (localObject != null) {
      ((BrowserChooseDialogView)localObject).setBrowserClickListener(this.JlS);
    }
    localObject = this.JlR;
    if (localObject != null) {
      ((BrowserChooseDialogView)localObject).setBrowserList(this.Jli);
    }
    localObject = this.JlR;
    if (localObject == null) {
      p.hyc();
    }
    localObject = (View)localObject;
    AppMethodBeat.o(210446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.b
 * JD-Core Version:    0.7.0.1
 */