package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.y;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoMenuHelper;", "", "()V", "MENU_ID_FAV", "", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SEND_TO_SNS", "TAG", "", "showMenu", "", "ui", "Landroid/content/Context;", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "from", "plugin-webview_release"})
public final class g
{
  private static final int Quo = 0;
  private static final int Qup = 1;
  private static final int Quq = 2;
  public static final g Qur;
  private static final String TAG = "MicroMsg.JsApiHandleMPPageAction";
  
  static
  {
    AppMethodBeat.i(82675);
    Qur = new g();
    TAG = "MicroMsg.JsApiHandleMPPageAction";
    Qup = 1;
    Quq = 2;
    AppMethodBeat.o(82675);
  }
  
  public static void a(Context paramContext, final y paramy, final int paramInt)
  {
    AppMethodBeat.i(82674);
    p.k(paramContext, "ui");
    p.k(paramy, "mpShareVideoInfo");
    Object localObject = a.Qtn;
    a.lL(paramInt, 3);
    if ((paramContext instanceof WebViewUI))
    {
      localObject = new e(paramContext, 1, false);
      ((e)localObject).a((q.f)new a(paramContext, paramInt));
      ((e)localObject).a((q.g)new b(paramContext, paramy, paramInt));
      ((e)localObject).a((e.a)new c(paramInt));
      ((e)localObject).q((CharSequence)" ", 1);
      ((e)localObject).HJ(true);
      ((e)localObject).eik();
      AppMethodBeat.o(82674);
      return;
    }
    Log.e(TAG, "not in WebViewUI now!");
    AppMethodBeat.o(82674);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements q.f
  {
    a(Context paramContext, int paramInt) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(82671);
      g localg = g.Qur;
      paramo.a(g.hbq(), (CharSequence)this.Qus.getString(c.i.readerapp_alert_retransmit), c.h.bottomsheet_icon_transmit, false);
      if (ab.hnU())
      {
        localg = g.Qur;
        paramo.a(g.hbr(), (CharSequence)this.Qus.getString(c.i.readerapp_alert_share_to_timeline), c.h.bottomsheet_icon_moment, false);
      }
      if ((2 != paramInt) && (5 != paramInt))
      {
        localg = g.Qur;
        paramo.a(g.hbs(), (CharSequence)this.Qus.getString(c.i.plugin_favorite_opt), c.h.bottomsheet_icon_fav, false);
      }
      AppMethodBeat.o(82671);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class b
    implements q.g
  {
    b(Context paramContext, y paramy, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(82672);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = g.Qur;
      if (paramInt == g.hbq())
      {
        ((WebViewUI)this.Qus).QgI.llv = paramy;
        paramMenuItem = d.Qug;
        d.a(this.Qus, paramy.lpK, "", paramy.title, paramy.ROZ, 2);
        paramMenuItem = a.Qtn;
        a.aR(1, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = g.Qur;
      if (paramInt == g.hbs())
      {
        paramMenuItem = f.Quk;
        f.b(paramy);
        h.cL(this.Qus, this.Qus.getString(c.i.favorite_ok));
        paramMenuItem = a.Qtn;
        a.aR(2, paramInt, 3);
        AppMethodBeat.o(82672);
        return;
      }
      paramMenuItem = g.Qur;
      if (paramInt == g.hbr())
      {
        paramMenuItem = c.Qud;
        paramMenuItem = (jd)paramy;
        Context localContext = this.Qus;
        if (localContext == null)
        {
          paramMenuItem = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(82672);
          throw paramMenuItem;
        }
        c.b(paramMenuItem, (MMActivity)localContext, paramy.lqn);
        paramMenuItem = a.Qtn;
        a.aR(4, paramInt, 3);
      }
      AppMethodBeat.o(82672);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class c
    implements e.a
  {
    c(int paramInt) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(82673);
      a locala = a.Qtn;
      a.aR(3, this.xvH, 3);
      AppMethodBeat.o(82673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.g
 * JD-Core Version:    0.7.0.1
 */