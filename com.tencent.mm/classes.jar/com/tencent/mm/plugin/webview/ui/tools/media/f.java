package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.a;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoMenuHelper;", "", "()V", "MENU_ID_FAV", "", "MENU_ID_SEND_TO_FRIEND", "TAG", "", "showMenu", "", "ui", "Landroid/content/Context;", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "from", "plugin-webview_release"})
public final class f
{
  public static final f BsZ;
  private static final String TAG = "MicroMsg.JsApiHandleMPPageAction";
  private static final int nmi = 1;
  private static final int nmk = 0;
  
  static
  {
    AppMethodBeat.i(82675);
    BsZ = new f();
    TAG = "MicroMsg.JsApiHandleMPPageAction";
    nmi = 1;
    AppMethodBeat.o(82675);
  }
  
  public static void a(Context paramContext, final y paramy, final int paramInt)
  {
    AppMethodBeat.i(82674);
    k.h(paramContext, "ui");
    k.h(paramy, "mpShareVideoInfo");
    Object localObject = a.Bsg;
    a.iF(paramInt, 3);
    if ((paramContext instanceof WebViewUI))
    {
      localObject = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).a((n.c)new a(paramContext));
      ((com.tencent.mm.ui.widget.a.e)localObject).a((n.d)new b(paramContext, paramy, paramInt));
      ((com.tencent.mm.ui.widget.a.e)localObject).a((e.a)new c(paramInt));
      ((com.tencent.mm.ui.widget.a.e)localObject).q((CharSequence)" ", 1);
      ((com.tencent.mm.ui.widget.a.e)localObject).ffv();
      ((com.tencent.mm.ui.widget.a.e)localObject).csG();
      AppMethodBeat.o(82674);
      return;
    }
    ad.e(TAG, "not in WebViewUI now!");
    AppMethodBeat.o(82674);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements n.c
  {
    a(Context paramContext) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(82671);
      f localf = f.BsZ;
      paraml.a(f.eqK(), (CharSequence)this.Bta.getString(2131762163), 2131689831, false);
      localf = f.BsZ;
      paraml.a(f.eqL(), (CharSequence)this.Bta.getString(2131761941), 2131689808, false);
      AppMethodBeat.o(82671);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements n.d
  {
    b(Context paramContext, y paramy, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(82672);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = f.BsZ;
      if (paramInt == f.eqK())
      {
        ((WebViewUI)this.Bta).Bit.gGE = paramy;
        paramMenuItem = c.BsS;
        c.a(this.Bta, paramy.gKD, "", paramy.title, paramy.CEf, 2);
        paramMenuItem = a.Bsg;
        a.aB(1, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = f.BsZ;
      if (paramInt == f.eqL())
      {
        paramMenuItem = e.BsW;
        e.b(paramy);
        h.cc(this.Bta, this.Bta.getString(2131758936));
        paramMenuItem = a.Bsg;
        a.aB(2, paramInt, 3);
      }
      AppMethodBeat.o(82672);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onClick"})
  static final class c
    implements e.a
  {
    c(int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82673);
      a locala = a.Bsg;
      a.aB(3, this.Btb, 3);
      AppMethodBeat.o(82673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.f
 * JD-Core Version:    0.7.0.1
 */