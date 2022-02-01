package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.y;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoMenuHelper;", "", "()V", "MENU_ID_FAV", "", "MENU_ID_SEND_TO_FRIEND", "MENU_ID_SEND_TO_SNS", "TAG", "", "showMenu", "", "ui", "Landroid/content/Context;", "mpShareVideoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "from", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String TAG;
  public static final f Xmo;
  private static final int Xmp = 0;
  private static final int Xmq;
  private static final int Xmr;
  
  static
  {
    AppMethodBeat.i(82675);
    Xmo = new f();
    TAG = "MicroMsg.JsApiHandleMPPageAction";
    Xmq = 1;
    Xmr = 2;
    AppMethodBeat.o(82675);
  }
  
  private static final void a(Context paramContext, int paramInt, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(296706);
    kotlin.g.b.s.u(paramContext, "$ui");
    params.a(Xmq, (CharSequence)paramContext.getString(c.i.readerapp_alert_retransmit), c.h.bottomsheet_icon_transmit, false);
    if (aa.iOM()) {
      params.a(Xmr, (CharSequence)paramContext.getString(c.i.readerapp_alert_share_to_timeline), c.h.bottomsheet_icon_moment, false);
    }
    if ((2 != paramInt) && (5 != paramInt)) {
      params.a(Xmp, (CharSequence)paramContext.getString(c.i.plugin_favorite_opt), c.h.bottomsheet_icon_fav, false);
    }
    AppMethodBeat.o(296706);
  }
  
  public static void a(Context paramContext, y paramy, int paramInt)
  {
    AppMethodBeat.i(82674);
    kotlin.g.b.s.u(paramContext, "ui");
    kotlin.g.b.s.u(paramy, "mpShareVideoInfo");
    Object localObject = a.XlE;
    a.nv(paramInt, 3);
    if ((paramContext instanceof WebViewUI))
    {
      localObject = new com.tencent.mm.ui.widget.a.f(paramContext, 1, false);
      ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new f..ExternalSyntheticLambda0(paramContext, paramInt);
      ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new f..ExternalSyntheticLambda1(paramContext, paramy, paramInt);
      ((com.tencent.mm.ui.widget.a.f)localObject).ages = new f..ExternalSyntheticLambda2(paramInt);
      ((com.tencent.mm.ui.widget.a.f)localObject).h((CharSequence)" ", 1, 0);
      ((com.tencent.mm.ui.widget.a.f)localObject).sRz = true;
      ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
      AppMethodBeat.o(82674);
      return;
    }
    Log.e(TAG, "not in WebViewUI now!");
    AppMethodBeat.o(82674);
  }
  
  private static final void a(Context paramContext, y paramy, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(296711);
    kotlin.g.b.s.u(paramContext, "$ui");
    kotlin.g.b.s.u(paramy, "$mpShareVideoInfo");
    paramInt2 = paramMenuItem.getItemId();
    if (paramInt2 == Xmq)
    {
      ((WebViewUI)paramContext).WYF.nQs = paramy;
      paramMenuItem = c.Xmk;
      c.a(paramContext, paramy.nUM, "", paramy.title, paramy.YMm, 2);
      paramContext = a.XlE;
      a.bs(1, paramInt1, 3);
      AppMethodBeat.o(296711);
      return;
    }
    if (paramInt2 == Xmp)
    {
      paramMenuItem = e.Xml;
      e.c(paramy);
      k.cZ(paramContext, paramContext.getString(c.i.favorite_ok));
      paramContext = a.XlE;
      a.bs(2, paramInt1, 3);
      AppMethodBeat.o(296711);
      return;
    }
    if (paramInt2 == Xmr)
    {
      paramMenuItem = b.Xmj;
      b.b((jz)paramy, (MMActivity)paramContext, paramy.nVq);
      paramContext = a.XlE;
      a.bs(4, paramInt1, 3);
    }
    AppMethodBeat.o(296711);
  }
  
  private static final void auQ(int paramInt)
  {
    AppMethodBeat.i(296712);
    a locala = a.XlE;
    a.bs(3, paramInt, 3);
    AppMethodBeat.o(296712);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.f
 * JD-Core Version:    0.7.0.1
 */