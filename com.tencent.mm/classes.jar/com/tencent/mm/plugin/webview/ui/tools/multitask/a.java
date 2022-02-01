package com.tencent.mm.plugin.webview.ui.tools.multitask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.multitask.animation.swipeahead.b.c;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.plugin.webview.ui.tools.p.b;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.fky;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.multitask.b.c
{
  private static final Set<String> PRd;
  private static final com.tencent.mm.plugin.taskbar.api.b.a QuK;
  public fky PRr;
  private WebViewUI QcD;
  private boolean Qka;
  private boolean Qkb;
  private boolean QuI;
  private boolean QuJ;
  
  static
  {
    AppMethodBeat.i(244049);
    HashSet localHashSet = new HashSet();
    PRd = localHashSet;
    localHashSet.add("title");
    PRd.add("webpageTitle");
    PRd.add("hide_option_menu");
    PRd.add("translate_webview");
    PRd.add("srcUsername");
    PRd.add("srcDisplayname");
    PRd.add("mode");
    PRd.add("KTemplateId");
    PRd.add("KPublisherId");
    PRd.add(f.r.VSK);
    PRd.add(f.r.VSL);
    PRd.add("pay_channel");
    PRd.add("key_download_restrict");
    PRd.add("key_wallet_region");
    PRd.add("key_function_id");
    PRd.add(f.r.VSO);
    PRd.add("geta8key_scene");
    PRd.add(f.r.VSW);
    PRd.add("key_menu_hide_expose");
    PRd.add("webviewCurrentProcess");
    QuK = new com.tencent.mm.plugin.taskbar.api.b.a()
    {
      public final void a(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(223769);
        Log.d("MicroMsg.WebMultiTaskHelper", "MultiTaskInfo, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
        Object localObject = new fky();
        try
        {
          ((fky)localObject).parseFrom(paramAnonymousMultiTaskInfo.field_data);
          int i = ((fky)localObject).UJE;
          String str = ((fky)localObject).fXu;
          if ((i >= 0) && (!Util.isNullOrNil(str)))
          {
            int j = ((fky)localObject).UJz;
            Log.d("MicroMsg.WebMultiTaskHelper", "addToPreload, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
            ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(str, i, j, new Object[0]);
          }
          localObject = d.Qkh;
          d.t(paramAnonymousMultiTaskInfo);
          AppMethodBeat.o(223769);
          return;
        }
        catch (Throwable paramAnonymousMultiTaskInfo)
        {
          Log.e("MicroMsg.WebMultiTaskHelper", "WebMultiTaskData parse fail", new Object[] { paramAnonymousMultiTaskInfo });
          AppMethodBeat.o(223769);
        }
      }
      
      public final void b(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(223773);
        a.v(paramAnonymousMultiTaskInfo);
        AppMethodBeat.o(223773);
      }
      
      public final void c(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(223780);
        Log.d("MicroMsg.WebMultiTaskHelper", "onTaskBarItemRemoved, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
        d locald = d.Qkh;
        d.s(paramAnonymousMultiTaskInfo);
        AppMethodBeat.o(223780);
      }
    };
    AppMethodBeat.o(244049);
  }
  
  public a(com.tencent.mm.plugin.multitask.a.a parama, WebViewUI paramWebViewUI)
  {
    super(parama);
    AppMethodBeat.i(244008);
    this.QuI = true;
    this.QuJ = false;
    this.Qkb = false;
    this.QcD = paramWebViewUI;
    this.PRr = new fky();
    if (this.FGb.getIntent() != null) {
      com.tencent.mm.plugin.multitask.f.b.b(this.FGb.getIntent(), this.PRr);
    }
    Log.i("MicroMsg.WebMultiTaskHelper", "createWebMultiTaskHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(244008);
  }
  
  public static void dFh()
  {
    AppMethodBeat.i(244037);
    ((com.tencent.mm.plugin.taskbar.api.b)h.ae(com.tencent.mm.plugin.taskbar.api.b.class)).a(2, QuK);
    AppMethodBeat.o(244037);
  }
  
  public static void dFi()
  {
    AppMethodBeat.i(244038);
    ((com.tencent.mm.plugin.taskbar.api.b)h.ae(com.tencent.mm.plugin.taskbar.api.b.class)).b(2, QuK);
    AppMethodBeat.o(244038);
  }
  
  public static boolean hbx()
  {
    AppMethodBeat.i(244042);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(244042);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.waK, true);
    AppMethodBeat.o(244042);
    return bool;
  }
  
  public static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(244039);
    if (!Util.isNullOrNil(paramString))
    {
      if ((paramString.startsWith("https://" + WeChatHosts.domainString(c.i.host_mp_weixin_qq_com) + "/")) || (paramString.startsWith("http://" + WeChatHosts.domainString(c.i.host_mp_weixin_qq_com) + "/")))
      {
        AppMethodBeat.o(244039);
        return true;
      }
      AppMethodBeat.o(244039);
      return false;
    }
    AppMethodBeat.o(244039);
    return false;
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(244028);
    this.Qka = true;
    super.I(paramInt, paramString);
    if ((!faT()) && (((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb(this.QcD.cDu())))
    {
      this.FHd.field_id = g.aQV(this.QcD.cDu());
      Log.i("MicroMsg.WebMultiTaskHelper", "isMpArticle, url: %s", new Object[] { this.QcD.cDu() });
    }
    AppMethodBeat.o(244028);
  }
  
  public final boolean Q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(244012);
    cbL();
    if (!this.QuJ) {
      this.QuI = false;
    }
    paramBoolean = super.Q(paramInt, this.QuI);
    AppMethodBeat.o(244012);
    return paramBoolean;
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(244035);
    super.aOj();
    this.Qkb = false;
    AppMethodBeat.o(244035);
  }
  
  public final void af(Bitmap paramBitmap)
  {
    AppMethodBeat.i(244029);
    if (this.Qka) {
      super.af(paramBitmap);
    }
    AppMethodBeat.o(244029);
  }
  
  public final void ag(Bitmap paramBitmap)
  {
    AppMethodBeat.i(244032);
    if (this.Qka) {
      super.ag(paramBitmap);
    }
    AppMethodBeat.o(244032);
  }
  
  public final void aoV(int paramInt)
  {
    AppMethodBeat.i(244024);
    Log.i("MicroMsg.WebMultiTaskHelper", "sync Read State %d", new Object[] { Integer.valueOf(paramInt) });
    this.QuJ = true;
    if (paramInt == 0)
    {
      this.QuI = false;
      cbL();
      ag(null);
      AppMethodBeat.o(244024);
      return;
    }
    this.QuI = true;
    faW();
    AppMethodBeat.o(244024);
  }
  
  public final void bNV()
  {
    AppMethodBeat.i(244034);
    super.bNV();
    if (!this.Qkb) {
      this.Qkb = true;
    }
    AppMethodBeat.o(244034);
  }
  
  public final boolean cbG()
  {
    AppMethodBeat.i(244018);
    if ((this.QcD.gUC()) && (this.FGb.cbG()))
    {
      AppMethodBeat.o(244018);
      return true;
    }
    AppMethodBeat.o(244018);
    return false;
  }
  
  public final boolean cbH()
  {
    AppMethodBeat.i(244036);
    boolean bool = this.QcD.gUC();
    AppMethodBeat.o(244036);
    return bool;
  }
  
  public final void cbL()
  {
    AppMethodBeat.i(244026);
    try
    {
      this.PRr.fXu = this.QcD.cDu();
      p.b localb = this.QcD.gYE();
      if (localb != null)
      {
        this.FHd.fbc().title = localb.title;
        this.FHd.fbc().TIg = localb.QhG;
        localObject2 = this.FHd.fbc().nickname;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localb.QhF;
        }
        this.FHd.fbc().nickname = ((String)localObject1);
        this.PRr.coverUrl = localb.lpK;
      }
      Object localObject2 = this.FHd.fbc().title;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.QcD.getIntent().getStringExtra("webpageTitle");
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.QcD.pHS.getTitle();
      }
      this.FHd.fbc().title = ((String)localObject2);
      this.FHd.field_data = this.PRr.toByteArray();
      AppMethodBeat.o(244026);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", localException, "onMenuMultiTaskSelected", new Object[0]);
      AppMethodBeat.o(244026);
    }
  }
  
  public final void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(244015);
    if (this.QcD.gYE() == null)
    {
      Log.i("MicroMsg.WebMultiTaskHelper", "not MP page");
      AppMethodBeat.o(244015);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.WebMultiTaskHelper", "ended, remove historyTaskInfo");
      faW();
      AppMethodBeat.o(244015);
      return;
    }
    Log.i("MicroMsg.WebMultiTaskHelper", "not ended update historyTaskInfo");
    c(paramBitmap, true);
    AppMethodBeat.o(244015);
  }
  
  public final boolean dJN()
  {
    return true;
  }
  
  public final void dJO()
  {
    AppMethodBeat.i(244031);
    if (this.Qka) {
      super.dJO();
    }
    AppMethodBeat.o(244031);
  }
  
  public final Boolean faJ()
  {
    return Boolean.FALSE;
  }
  
  public final void faR()
  {
    AppMethodBeat.i(244030);
    if (this.Qka) {
      super.faR();
    }
    AppMethodBeat.o(244030);
  }
  
  public final MultiTaskInfo faU()
  {
    AppMethodBeat.i(244023);
    if ((this.FHd == null) || (this.FHd.field_data == null))
    {
      AppMethodBeat.o(244023);
      return null;
    }
    Object localObject = Parcel.obtain();
    ((Parcel)localObject).setDataPosition(0);
    this.FHd.writeToParcel((Parcel)localObject, 0);
    ((Parcel)localObject).setDataPosition(0);
    localObject = (MultiTaskInfo)MultiTaskInfo.CREATOR.createFromParcel((Parcel)localObject);
    ((MultiTaskInfo)localObject).field_id = g.aQU(((aa)h.ae(aa.class)).gw(this.QcD.cDu()));
    AppMethodBeat.o(244023);
    return localObject;
  }
  
  public final boolean faV()
  {
    AppMethodBeat.i(244014);
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wax, 0) != 0)
    {
      i = 1;
      if (i != 0) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WebMultiTaskHelper", "shouldCaptureOnClose:%b", new Object[] { Boolean.valueOf(bool) });
      if (i != 0) {
        break label75;
      }
      AppMethodBeat.o(244014);
      return true;
      i = 0;
      break;
    }
    label75:
    AppMethodBeat.o(244014);
    return false;
  }
  
  public final void hbw()
  {
    AppMethodBeat.i(244041);
    if (faX() != null)
    {
      com.tencent.mm.plugin.multitask.animation.swipeahead.b localb = faX();
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "stop FloatIndicatorController");
      MMHandlerThread.postToMainThread((Runnable)new b.c(localb));
      localb.FGb.a(null);
    }
    AppMethodBeat.o(244041);
  }
  
  public final void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(244009);
    cbL();
    super.iW(paramBoolean);
    AppMethodBeat.o(244009);
  }
  
  public final void setRawUrl(String paramString)
  {
    this.PRr.fXu = paramString;
  }
  
  public final boolean zH(int paramInt)
  {
    AppMethodBeat.i(244021);
    boolean bool = Q(paramInt, this.QuI);
    AppMethodBeat.o(244021);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.multitask.a
 * JD-Core Version:    0.7.0.1
 */