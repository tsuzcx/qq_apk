package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoMenuHelper;", "", "()V", "MENU_ID_FAV", "", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SEND_TO_SNS", "TAG", "", "showMenu", "", "ui", "Landroid/content/Context;", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "from", "plugin-webview_release"})
public final class g
{
  private static final int JwE = 2;
  public static final g JwF;
  private static final String TAG = "MicroMsg.JsApiHandleMPPageAction";
  private static final int pLT = 1;
  private static final int pLV = 0;
  
  static
  {
    AppMethodBeat.i(82675);
    JwF = new g();
    TAG = "MicroMsg.JsApiHandleMPPageAction";
    pLT = 1;
    JwE = 2;
    AppMethodBeat.o(82675);
  }
  
  public static void a(Context paramContext, final y paramy, final int paramInt)
  {
    AppMethodBeat.i(82674);
    p.h(paramContext, "ui");
    p.h(paramy, "mpShareVideoInfo");
    Object localObject = a.JvG;
    a.kr(paramInt, 3);
    if ((paramContext instanceof WebViewUI))
    {
      localObject = new e(paramContext, 1, false);
      ((e)localObject).a((o.f)new a(paramContext, paramInt));
      ((e)localObject).a((o.g)new b(paramContext, paramy, paramInt));
      ((e)localObject).a((e.a)new c(paramInt));
      ((e)localObject).o((CharSequence)" ", 1);
      ((e)localObject).Do(true);
      ((e)localObject).dGm();
      AppMethodBeat.o(82674);
      return;
    }
    Log.e(TAG, "not in WebViewUI now!");
    AppMethodBeat.o(82674);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements o.f
  {
    a(Context paramContext, int paramInt) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(82671);
      g localg = g.JwF;
      paramm.a(g.ghS(), (CharSequence)this.JwG.getString(2131764184), 2131689844, false);
      if (z.gsM())
      {
        localg = g.JwF;
        paramm.a(g.ghT(), (CharSequence)this.JwG.getString(2131764185), 2131689830, false);
      }
      if ((2 != paramInt) && (5 != paramInt))
      {
        localg = g.JwF;
        paramm.a(g.ghU(), (CharSequence)this.JwG.getString(2131763947), 2131689821, false);
      }
      AppMethodBeat.o(82671);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements o.g
  {
    b(Context paramContext, y paramy, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(82672);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = g.JwF;
      if (paramInt == g.ghS())
      {
        ((WebViewUI)this.JwG).JjJ.iwi = paramy;
        paramMenuItem = d.Jwx;
        d.a(this.JwG, paramy.iAo, "", paramy.title, paramy.KOe, 2);
        paramMenuItem = a.JvG;
        a.aN(1, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = g.JwF;
      if (paramInt == g.ghU())
      {
        paramMenuItem = f.JwB;
        f.b(paramy);
        h.cA(this.JwG, this.JwG.getString(2131759260));
        paramMenuItem = a.JvG;
        a.aN(2, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = g.JwF;
      if (paramInt == g.ghT())
      {
        paramMenuItem = c.Jwu;
        paramMenuItem = (jo)paramy;
        Context localContext = this.JwG;
        if (localContext == null)
        {
          paramMenuItem = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(82672);
          throw paramMenuItem;
        }
        c.b(paramMenuItem, (MMActivity)localContext, paramy.iAP);
        paramMenuItem = a.JvG;
        a.aN(4, paramInt, 3);
      }
      AppMethodBeat.o(82672);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class c
    implements e.a
  {
    c(int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82673);
      a locala = a.JvG;
      a.aN(3, this.JwH, 3);
      AppMethodBeat.o(82673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.g
 * JD-Core Version:    0.7.0.1
 */