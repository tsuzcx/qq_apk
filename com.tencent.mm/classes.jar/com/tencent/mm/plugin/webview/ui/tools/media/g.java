package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.y;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import d.g.b.p;
import d.v;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoMenuHelper;", "", "()V", "MENU_ID_FAV", "", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SEND_TO_SNS", "TAG", "", "showMenu", "", "ui", "Landroid/content/Context;", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "from", "plugin-webview_release"})
public final class g
{
  private static final int EHa = 2;
  public static final g EHb;
  private static final String TAG = "MicroMsg.JsApiHandleMPPageAction";
  private static final int oyp = 1;
  private static final int oyr = 0;
  
  static
  {
    AppMethodBeat.i(82675);
    EHb = new g();
    TAG = "MicroMsg.JsApiHandleMPPageAction";
    oyp = 1;
    EHa = 2;
    AppMethodBeat.o(82675);
  }
  
  public static void a(Context paramContext, final y paramy, final int paramInt)
  {
    AppMethodBeat.i(82674);
    p.h(paramContext, "ui");
    p.h(paramy, "mpShareVideoInfo");
    Object localObject = a.EGd;
    a.jj(paramInt, 3);
    if ((paramContext instanceof WebViewUI))
    {
      localObject = new e(paramContext, 1, false);
      ((e)localObject).a((n.d)new a(paramContext, paramInt));
      ((e)localObject).a((n.e)new b(paramContext, paramy, paramInt));
      ((e)localObject).a((e.a)new c(paramInt));
      ((e)localObject).p((CharSequence)" ", 1);
      ((e)localObject).fQz();
      ((e)localObject).cPF();
      AppMethodBeat.o(82674);
      return;
    }
    ae.e(TAG, "not in WebViewUI now!");
    AppMethodBeat.o(82674);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements n.d
  {
    a(Context paramContext, int paramInt) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(82671);
      g localg = g.EHb;
      paraml.a(g.eYN(), (CharSequence)this.EHc.getString(2131762163), 2131689831, false);
      if (x.fjm())
      {
        localg = g.EHb;
        paraml.a(g.eYO(), (CharSequence)this.EHc.getString(2131762164), 2131689817, false);
      }
      if ((2 != paramInt) && (5 != paramInt))
      {
        localg = g.EHb;
        paraml.a(g.eYP(), (CharSequence)this.EHc.getString(2131761941), 2131689808, false);
      }
      AppMethodBeat.o(82671);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements n.e
  {
    b(Context paramContext, y paramy, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(82672);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = g.EHb;
      if (paramInt == g.eYN())
      {
        ((WebViewUI)this.EHc).Ewq.hCc = paramy;
        paramMenuItem = d.EGT;
        d.a(this.EHc, paramy.hGe, "", paramy.title, paramy.FUw, 2);
        paramMenuItem = a.EGd;
        a.aF(1, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = g.EHb;
      if (paramInt == g.eYP())
      {
        paramMenuItem = f.EGX;
        f.b(paramy);
        h.cj(this.EHc, this.EHc.getString(2131758936));
        paramMenuItem = a.EGd;
        a.aF(2, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = g.EHb;
      if (paramInt == g.eYO())
      {
        paramMenuItem = c.EGQ;
        paramMenuItem = (jb)paramy;
        Context localContext = this.EHc;
        if (localContext == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(82672);
          throw paramMenuItem;
        }
        c.b(paramMenuItem, (MMActivity)localContext, paramy.hGG);
        paramMenuItem = a.EGd;
        a.aF(4, paramInt, 3);
      }
      AppMethodBeat.o(82672);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onClick"})
  static final class c
    implements e.a
  {
    c(int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82673);
      a locala = a.EGd;
      a.aF(3, this.EHd, 3);
      AppMethodBeat.o(82673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.g
 * JD-Core Version:    0.7.0.1
 */