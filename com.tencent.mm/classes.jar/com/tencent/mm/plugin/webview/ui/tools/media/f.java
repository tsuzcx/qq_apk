package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.a;
import d.g.b.k;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoMenuHelper;", "", "()V", "MENU_ID_FAV", "", "MENU_ID_SEND_TO_FRIEND", "TAG", "", "showMenu", "", "ui", "Landroid/content/Context;", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "from", "plugin-webview_release"})
public final class f
{
  public static final f CLf;
  private static final String TAG = "MicroMsg.JsApiHandleMPPageAction";
  private static final int nPi = 1;
  private static final int nPk = 0;
  
  static
  {
    AppMethodBeat.i(82675);
    CLf = new f();
    TAG = "MicroMsg.JsApiHandleMPPageAction";
    nPi = 1;
    AppMethodBeat.o(82675);
  }
  
  public static void a(Context paramContext, final y paramy, final int paramInt)
  {
    AppMethodBeat.i(82674);
    k.h(paramContext, "ui");
    k.h(paramy, "mpShareVideoInfo");
    Object localObject = a.CKm;
    a.iS(paramInt, 3);
    if ((paramContext instanceof WebViewUI))
    {
      localObject = new com.tencent.mm.ui.widget.a.e(paramContext, 1, false);
      ((com.tencent.mm.ui.widget.a.e)localObject).a((n.c)new a(paramContext));
      ((com.tencent.mm.ui.widget.a.e)localObject).a((n.d)new b(paramContext, paramy, paramInt));
      ((com.tencent.mm.ui.widget.a.e)localObject).a((e.a)new c(paramInt));
      ((com.tencent.mm.ui.widget.a.e)localObject).p((CharSequence)" ", 1);
      ((com.tencent.mm.ui.widget.a.e)localObject).fvt();
      ((com.tencent.mm.ui.widget.a.e)localObject).cED();
      AppMethodBeat.o(82674);
      return;
    }
    ac.e(TAG, "not in WebViewUI now!");
    AppMethodBeat.o(82674);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements n.c
  {
    a(Context paramContext) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(82671);
      f localf = f.CLf;
      paraml.a(f.eGe(), (CharSequence)this.CLg.getString(2131762163), 2131689831, false);
      localf = f.CLf;
      paraml.a(f.eGf(), (CharSequence)this.CLg.getString(2131761941), 2131689808, false);
      AppMethodBeat.o(82671);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements n.d
  {
    b(Context paramContext, y paramy, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(82672);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = f.CLf;
      if (paramInt == f.eGe())
      {
        ((WebViewUI)this.CLg).CAG.hhf = paramy;
        paramMenuItem = c.CKY;
        c.a(this.CLg, paramy.hld, "", paramy.title, paramy.DWF, 2);
        paramMenuItem = a.CKm;
        a.aC(1, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = f.CLf;
      if (paramInt == f.eGf())
      {
        paramMenuItem = e.CLc;
        e.b(paramy);
        h.cd(this.CLg, this.CLg.getString(2131758936));
        paramMenuItem = a.CKm;
        a.aC(2, paramInt, 3);
      }
      AppMethodBeat.o(82672);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onClick"})
  static final class c
    implements e.a
  {
    c(int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82673);
      a locala = a.CKm;
      a.aC(3, this.CLh, 3);
      AppMethodBeat.o(82673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.f
 * JD-Core Version:    0.7.0.1
 */