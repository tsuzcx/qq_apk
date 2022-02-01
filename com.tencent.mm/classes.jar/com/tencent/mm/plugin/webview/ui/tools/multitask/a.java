package com.tencent.mm.plugin.webview.ui.tools.multitask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUIStyleHelper.a;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.protocal.protobuf.ghm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.f.s;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.multitask.b.c
{
  private static final Set<String> WHA;
  private static final b.a XmI;
  public ghm WHP;
  private WebViewUI WUm;
  private boolean XbS;
  private boolean XbT;
  private boolean XmG;
  private boolean XmH;
  
  static
  {
    AppMethodBeat.i(296471);
    HashSet localHashSet = new HashSet();
    WHA = localHashSet;
    localHashSet.add("title");
    WHA.add("webpageTitle");
    WHA.add("hide_option_menu");
    WHA.add("translate_webview");
    WHA.add("srcUsername");
    WHA.add("srcDisplayname");
    WHA.add("mode");
    WHA.add("KTemplateId");
    WHA.add("KPublisherId");
    WHA.add("KOpenArticleSceneFromScene");
    WHA.add(f.s.adwT);
    WHA.add("pay_channel");
    WHA.add("key_download_restrict");
    WHA.add("key_wallet_region");
    WHA.add("key_function_id");
    WHA.add(f.s.adwW);
    WHA.add("geta8key_scene");
    WHA.add(f.s.adxe);
    WHA.add("key_menu_hide_expose");
    WHA.add("webviewCurrentProcess");
    XmI = new b.a()
    {
      public final void a(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(296454);
        Log.d("MicroMsg.WebMultiTaskHelper", "MultiTaskInfo, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
        Object localObject = new ghm();
        try
        {
          ((ghm)localObject).parseFrom(paramAnonymousMultiTaskInfo.field_data);
          int i = ((ghm)localObject).acdM;
          String str = ((ghm)localObject).idu;
          if ((i >= 0) && (!Util.isNullOrNil(str)))
          {
            int j = ((ghm)localObject).acdH;
            Log.d("MicroMsg.WebMultiTaskHelper", "addToPreload, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
            ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(str, i, j, new Object[0]);
          }
          localObject = d.XbW;
          d.t(paramAnonymousMultiTaskInfo);
          AppMethodBeat.o(296454);
          return;
        }
        finally
        {
          Log.e("MicroMsg.WebMultiTaskHelper", "WebMultiTaskData parse fail", new Object[] { paramAnonymousMultiTaskInfo });
          AppMethodBeat.o(296454);
        }
      }
      
      public final void b(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(296457);
        a.v(paramAnonymousMultiTaskInfo);
        AppMethodBeat.o(296457);
      }
      
      public final void c(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(296461);
        Log.d("MicroMsg.WebMultiTaskHelper", "onTaskBarItemRemoved, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
        d locald = d.XbW;
        d.s(paramAnonymousMultiTaskInfo);
        AppMethodBeat.o(296461);
      }
    };
    AppMethodBeat.o(296471);
  }
  
  public a(com.tencent.mm.plugin.multitask.a.a parama, WebViewUI paramWebViewUI)
  {
    super(parama);
    AppMethodBeat.i(296455);
    this.XmG = true;
    this.XmH = false;
    this.XbT = false;
    this.WUm = paramWebViewUI;
    this.WHP = new ghm();
    if (this.LBU.getIntent() != null) {
      com.tencent.mm.plugin.multitask.f.b.b(this.LBU.getIntent(), this.WHP);
    }
    Log.i("MicroMsg.WebMultiTaskHelper", "createWebMultiTaskHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(296455);
  }
  
  public static void evw()
  {
    AppMethodBeat.i(296460);
    ((com.tencent.mm.plugin.taskbar.api.b)h.ax(com.tencent.mm.plugin.taskbar.api.b.class)).a(2, XmI);
    AppMethodBeat.o(296460);
  }
  
  public static void evx()
  {
    AppMethodBeat.i(296464);
    ((com.tencent.mm.plugin.taskbar.api.b)h.ax(com.tencent.mm.plugin.taskbar.api.b.class)).b(2, XmI);
    AppMethodBeat.o(296464);
  }
  
  public static boolean iBJ()
  {
    AppMethodBeat.i(296469);
    if (BuildInfo.IS_FLAVOR_RED)
    {
      AppMethodBeat.o(296469);
      return true;
    }
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zul, true);
    AppMethodBeat.o(296469);
    return bool;
  }
  
  public static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(296467);
    if (!Util.isNullOrNil(paramString))
    {
      if ((paramString.startsWith("https://" + WeChatHosts.domainString(c.i.host_mp_weixin_qq_com) + "/")) || (paramString.startsWith("http://" + WeChatHosts.domainString(c.i.host_mp_weixin_qq_com) + "/")))
      {
        AppMethodBeat.o(296467);
        return true;
      }
      AppMethodBeat.o(296467);
      return false;
    }
    AppMethodBeat.o(296467);
    return false;
  }
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(296508);
    this.XbS = true;
    super.J(paramInt, paramString);
    if ((!gjZ()) && (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy(this.WUm.dgY())))
    {
      this.LCE.field_id = g.aNN(this.WUm.dgY());
      Log.i("MicroMsg.WebMultiTaskHelper", "isMpArticle, url: %s", new Object[] { this.WUm.dgY() });
    }
    AppMethodBeat.o(296508);
  }
  
  public final boolean af(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(296474);
    cCe();
    if (!this.XmH) {
      this.XmG = false;
    }
    paramBoolean = super.af(paramInt, this.XmG);
    AppMethodBeat.o(296474);
    return paramBoolean;
  }
  
  public final void ar(Bitmap paramBitmap)
  {
    AppMethodBeat.i(296515);
    if (this.XbS) {
      super.ar(paramBitmap);
    }
    AppMethodBeat.o(296515);
  }
  
  public final void as(Bitmap paramBitmap)
  {
    AppMethodBeat.i(296531);
    if (this.XbS) {
      super.as(paramBitmap);
    }
    AppMethodBeat.o(296531);
  }
  
  public final void auR(int paramInt)
  {
    AppMethodBeat.i(296497);
    Log.i("MicroMsg.WebMultiTaskHelper", "sync Read State %d", new Object[] { Integer.valueOf(paramInt) });
    this.XmH = true;
    if (paramInt == 0)
    {
      this.XmG = false;
      cCe();
      as(null);
      AppMethodBeat.o(296497);
      return;
    }
    this.XmG = true;
    gkb();
    AppMethodBeat.o(296497);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(296539);
    super.bhW();
    this.XbT = false;
    AppMethodBeat.o(296539);
  }
  
  public final boolean cBZ()
  {
    AppMethodBeat.i(296485);
    if ((this.WUm.iul()) && (this.LBU.cBZ()))
    {
      AppMethodBeat.o(296485);
      return true;
    }
    AppMethodBeat.o(296485);
    return false;
  }
  
  public final boolean cCa()
  {
    AppMethodBeat.i(296545);
    boolean bool = this.WUm.iul();
    AppMethodBeat.o(296545);
    return bool;
  }
  
  public final void cCe()
  {
    AppMethodBeat.i(296502);
    try
    {
      this.WHP.idu = this.WUm.dgY();
      WebViewUIStyleHelper.a locala = this.WUm.iyA();
      if (locala != null)
      {
        this.LCE.gkh().title = locala.title;
        this.LCE.gkh().aaXP = locala.WZF;
        localObject2 = this.LCE.gkh().nickname;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = locala.WZE;
        }
        this.LCE.gkh().nickname = ((String)localObject1);
        this.WHP.coverUrl = locala.nUM;
        if (locala.nQm == 16)
        {
          this.WHP.acdM = locala.nQm;
          localObject1 = Uri.parse(this.WHP.idu);
          localObject2 = ((Uri)localObject1).buildUpon();
          if (Util.isNullOrNil(((Uri)localObject1).getQueryParameter("item_show_type"))) {
            ((Uri.Builder)localObject2).appendQueryParameter("item_show_type", "16");
          }
          if (Util.isNullOrNil(((Uri)localObject1).getQueryParameter("vid"))) {
            ((Uri.Builder)localObject2).appendQueryParameter("vid", locala.vid);
          }
          Log.w("MicroMsg.WebMultiTaskHelper", "fillMultiTaskInfo  rawUrl:%s,  vid:%s", new Object[] { this.WUm.dgY(), locala.vid });
          this.WHP.idu = ((Uri.Builder)localObject2).build().toString();
        }
        Log.i("MicroMsg.WebMultiTaskHelper", "fillMultiTaskInfo  webMultiTaskData.rawUrl:" + this.WHP.idu + "   itemShowType:" + locala.nQm);
      }
      Object localObject2 = this.LCE.gkh().title;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.WUm.getIntent().getStringExtra("webpageTitle");
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.WUm.sMP.getTitle();
      }
      this.LCE.gkh().title = ((String)localObject2);
      this.LCE.field_data = this.WHP.toByteArray();
      AppMethodBeat.o(296502);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", localException, "onMenuMultiTaskSelected", new Object[0]);
      AppMethodBeat.o(296502);
    }
  }
  
  public final void coi()
  {
    AppMethodBeat.i(296534);
    super.coi();
    if (!this.XbT) {
      this.XbT = true;
    }
    AppMethodBeat.o(296534);
  }
  
  public final void e(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(296480);
    if (this.WUm.iyA() == null)
    {
      Log.i("MicroMsg.WebMultiTaskHelper", "not MP page");
      AppMethodBeat.o(296480);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.WebMultiTaskHelper", "ended, remove historyTaskInfo");
      gkb();
      AppMethodBeat.o(296480);
      return;
    }
    Log.i("MicroMsg.WebMultiTaskHelper", "not ended update historyTaskInfo");
    d(paramBitmap, true);
    AppMethodBeat.o(296480);
  }
  
  public final boolean eCI()
  {
    return true;
  }
  
  public final void eCK()
  {
    AppMethodBeat.i(296526);
    if (this.XbS) {
      super.eCK();
    }
    AppMethodBeat.o(296526);
  }
  
  public final boolean evu()
  {
    AppMethodBeat.i(296478);
    int i;
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztZ, 0) != 0)
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
      AppMethodBeat.o(296478);
      return true;
      i = 0;
      break;
    }
    label75:
    AppMethodBeat.o(296478);
    return false;
  }
  
  public final Boolean gjO()
  {
    return Boolean.FALSE;
  }
  
  public final void gjW()
  {
    AppMethodBeat.i(296521);
    if (this.XbS) {
      super.gjW();
    }
    AppMethodBeat.o(296521);
  }
  
  public final MultiTaskInfo gka()
  {
    AppMethodBeat.i(296493);
    if ((this.LCE == null) || (this.LCE.field_data == null))
    {
      AppMethodBeat.o(296493);
      return null;
    }
    Object localObject = Parcel.obtain();
    ((Parcel)localObject).setDataPosition(0);
    this.LCE.writeToParcel((Parcel)localObject, 0);
    ((Parcel)localObject).setDataPosition(0);
    localObject = (MultiTaskInfo)MultiTaskInfo.CREATOR.createFromParcel((Parcel)localObject);
    ((MultiTaskInfo)localObject).field_id = g.aNM(((ab)h.ax(ab.class)).hW(this.WUm.dgY()));
    AppMethodBeat.o(296493);
    return localObject;
  }
  
  public final void iBI()
  {
    AppMethodBeat.i(296560);
    if (gkc() != null) {
      gkc().stop();
    }
    AppMethodBeat.o(296560);
  }
  
  public final void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(296473);
    cCe();
    super.ke(paramBoolean);
    AppMethodBeat.o(296473);
  }
  
  public final void setRawUrl(String paramString)
  {
    this.WHP.idu = paramString;
  }
  
  public final boolean zX(int paramInt)
  {
    AppMethodBeat.i(296488);
    boolean bool = af(paramInt, this.XmG);
    AppMethodBeat.o(296488);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.multitask.a
 * JD-Core Version:    0.7.0.1
 */