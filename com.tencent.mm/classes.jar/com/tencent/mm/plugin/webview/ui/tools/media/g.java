package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.y;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import d.g.b.p;
import d.v;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoMenuHelper;", "", "()V", "MENU_ID_FAV", "", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SEND_TO_SNS", "TAG", "", "showMenu", "", "ui", "Landroid/content/Context;", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "from", "plugin-webview_release"})
public final class g
{
  private static final int EoV = 2;
  public static final g EoW;
  private static final String TAG = "MicroMsg.JsApiHandleMPPageAction";
  private static final int orO = 1;
  private static final int orQ = 0;
  
  static
  {
    AppMethodBeat.i(82675);
    EoW = new g();
    TAG = "MicroMsg.JsApiHandleMPPageAction";
    orO = 1;
    EoV = 2;
    AppMethodBeat.o(82675);
  }
  
  public static void a(Context paramContext, final y paramy, final int paramInt)
  {
    AppMethodBeat.i(82674);
    p.h(paramContext, "ui");
    p.h(paramy, "mpShareVideoInfo");
    Object localObject = a.EnZ;
    a.jf(paramInt, 3);
    if ((paramContext instanceof WebViewUI))
    {
      localObject = new e(paramContext, 1, false);
      ((e)localObject).a((n.d)new a(paramContext, paramInt));
      ((e)localObject).a((n.e)new b(paramContext, paramy, paramInt));
      ((e)localObject).a((e.a)new c(paramInt));
      ((e)localObject).p((CharSequence)" ", 1);
      ((e)localObject).fMf();
      ((e)localObject).cMW();
      AppMethodBeat.o(82674);
      return;
    }
    ad.e(TAG, "not in WebViewUI now!");
    AppMethodBeat.o(82674);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements n.d
  {
    a(Context paramContext, int paramInt) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(82671);
      g localg = g.EoW;
      paraml.a(g.eVa(), (CharSequence)this.EoX.getString(2131762163), 2131689831, false);
      if (x.ffw())
      {
        localg = g.EoW;
        paraml.a(g.eVb(), (CharSequence)this.EoX.getString(2131762164), 2131689817, false);
      }
      if ((2 != paramInt) && (5 != paramInt))
      {
        localg = g.EoW;
        paraml.a(g.eVc(), (CharSequence)this.EoX.getString(2131761941), 2131689808, false);
      }
      AppMethodBeat.o(82671);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements n.e
  {
    b(Context paramContext, y paramy, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(82672);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = g.EoW;
      if (paramInt == g.eVa())
      {
        ((WebViewUI)this.EoX).Eeo.hzo = paramy;
        paramMenuItem = d.EoO;
        d.a(this.EoX, paramy.hDm, "", paramy.title, paramy.FCb, 2);
        paramMenuItem = a.EnZ;
        a.aE(1, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = g.EoW;
      if (paramInt == g.eVc())
      {
        paramMenuItem = f.EoS;
        f.b(paramy);
        h.ci(this.EoX, this.EoX.getString(2131758936));
        paramMenuItem = a.EnZ;
        a.aE(2, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = g.EoW;
      if (paramInt == g.eVb())
      {
        paramMenuItem = c.EoL;
        paramMenuItem = (jb)paramy;
        Context localContext = this.EoX;
        if (localContext == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(82672);
          throw paramMenuItem;
        }
        c.b(paramMenuItem, (MMActivity)localContext, paramy.hDO);
        paramMenuItem = a.EnZ;
        a.aE(4, paramInt, 3);
      }
      AppMethodBeat.o(82672);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onClick"})
  static final class c
    implements e.a
  {
    c(int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82673);
      a locala = a.EnZ;
      a.aE(3, this.EoY, 3);
      AppMethodBeat.o(82673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.g
 * JD-Core Version:    0.7.0.1
 */