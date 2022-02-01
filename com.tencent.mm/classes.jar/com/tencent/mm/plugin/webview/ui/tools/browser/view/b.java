package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "mDialogView", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;", "onCreateDialogView", "Landroid/view/View;", "release", "", "setBrowserClickListener", "listener", "setBrowserList", "list", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final a Xbf;
  private List<f> XaG;
  private BrowserChooseDialogView Xbg;
  public com.tencent.mm.plugin.webview.ui.tools.browser.listener.a Xbh;
  
  static
  {
    AppMethodBeat.i(296604);
    Xbf = new a((byte)0);
    AppMethodBeat.o(296604);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final View izN()
  {
    AppMethodBeat.i(296612);
    Object localObject = getContext();
    s.s(localObject, "context");
    this.Xbg = new BrowserChooseDialogView((Context)localObject);
    localObject = this.Xbg;
    if (localObject != null)
    {
      a locala = (a)this;
      s.u(locala, "dialog");
      ((BrowserChooseDialogView)localObject).Xbl = locala;
    }
    localObject = this.Xbg;
    if (localObject != null) {
      ((BrowserChooseDialogView)localObject).setBrowserClickListener(this.Xbh);
    }
    localObject = this.Xbg;
    if (localObject != null) {
      ((BrowserChooseDialogView)localObject).setBrowserList(this.XaG);
    }
    localObject = this.Xbg;
    s.checkNotNull(localObject);
    localObject = (View)localObject;
    AppMethodBeat.o(296612);
    return localObject;
  }
  
  public final void setBrowserList(List<f> paramList)
  {
    AppMethodBeat.i(296618);
    s.u(paramList, "list");
    this.XaG = paramList;
    AppMethodBeat.o(296618);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.view.b
 * JD-Core Version:    0.7.0.1
 */