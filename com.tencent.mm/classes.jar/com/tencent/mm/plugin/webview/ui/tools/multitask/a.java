package com.tencent.mm.plugin.webview.ui.tools.multitask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitask.animation.swipeahead.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.o.a;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.fah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.multitask.b.c
{
  private static final Set<String> IUM;
  private static final c.a JwV;
  public fah IVb;
  private WebViewUI Jkg;
  private boolean JmJ;
  private boolean JmK;
  private boolean JwT;
  private boolean JwU;
  
  static
  {
    AppMethodBeat.i(212049);
    HashSet localHashSet = new HashSet();
    IUM = localHashSet;
    localHashSet.add("title");
    IUM.add("webpageTitle");
    IUM.add("hide_option_menu");
    IUM.add("translate_webview");
    IUM.add("srcUsername");
    IUM.add("srcDisplayname");
    IUM.add("mode");
    IUM.add("KTemplateId");
    IUM.add("KPublisherId");
    IUM.add(e.p.Ozw);
    IUM.add(e.p.Ozx);
    IUM.add("pay_channel");
    IUM.add("key_download_restrict");
    IUM.add("key_wallet_region");
    IUM.add("key_function_id");
    IUM.add(e.p.OzA);
    IUM.add("geta8key_scene");
    IUM.add("biz_video_msg_id");
    IUM.add("biz_video_msg_index");
    IUM.add("biz_video_msg_svr_id");
    IUM.add("biz_mp_msg_info");
    IUM.add(e.p.OzI);
    IUM.add("key_menu_hide_expose");
    IUM.add("webviewCurrentProcess");
    JwV = new c.a()
    {
      public final void a(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(212023);
        Log.d("MicroMsg.WebMultiTaskHelper", "MultiTaskInfo, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
        Object localObject = new fah();
        try
        {
          ((fah)localObject).parseFrom(paramAnonymousMultiTaskInfo.field_data);
          int i = ((fah)localObject).Nwt;
          String str = ((fah)localObject).edo;
          if ((i >= 0) && (!Util.isNullOrNil(str)))
          {
            int j = ((fah)localObject).Nwo;
            Log.d("MicroMsg.WebMultiTaskHelper", "addToPreload, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
            ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(str, i, j, new Object[0]);
          }
          localObject = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
          com.tencent.mm.plugin.webview.ui.tools.floatball.d.r(paramAnonymousMultiTaskInfo);
          AppMethodBeat.o(212023);
          return;
        }
        catch (Throwable paramAnonymousMultiTaskInfo)
        {
          Log.e("MicroMsg.WebMultiTaskHelper", "WebMultiTaskData parse fail", new Object[] { paramAnonymousMultiTaskInfo });
          AppMethodBeat.o(212023);
        }
      }
      
      public final void b(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(212024);
        a.t(paramAnonymousMultiTaskInfo);
        AppMethodBeat.o(212024);
      }
      
      public final void c(MultiTaskInfo paramAnonymousMultiTaskInfo)
      {
        AppMethodBeat.i(212025);
        Log.d("MicroMsg.WebMultiTaskHelper", "onTaskBarItemRemoved, name:%s", new Object[] { paramAnonymousMultiTaskInfo.field_showData.title });
        com.tencent.mm.plugin.webview.ui.tools.floatball.d locald = com.tencent.mm.plugin.webview.ui.tools.floatball.d.JmQ;
        com.tencent.mm.plugin.webview.ui.tools.floatball.d.q(paramAnonymousMultiTaskInfo);
        AppMethodBeat.o(212025);
      }
    };
    AppMethodBeat.o(212049);
  }
  
  public a(com.tencent.mm.plugin.multitask.a.a parama, WebViewUI paramWebViewUI)
  {
    super(parama);
    AppMethodBeat.i(212026);
    this.JwT = true;
    this.JwU = false;
    this.JmK = false;
    this.Jkg = paramWebViewUI;
    this.IVb = new fah();
    if (this.Aak.getIntent() != null) {
      com.tencent.mm.plugin.multitask.f.b.b(this.Aak.getIntent(), this.IVb);
    }
    Log.i("MicroMsg.WebMultiTaskHelper", "createWebMultiTaskHelper, WebViewUI:%s", new Object[] { Integer.valueOf(paramWebViewUI.hashCode()) });
    AppMethodBeat.o(212026);
  }
  
  public static void euA()
  {
    AppMethodBeat.i(212044);
    ((com.tencent.mm.plugin.taskbar.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).a(2, JwV);
    AppMethodBeat.o(212044);
  }
  
  public static void euB()
  {
    AppMethodBeat.i(212045);
    ((com.tencent.mm.plugin.taskbar.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).b(2, JwV);
    AppMethodBeat.o(212045);
  }
  
  public static boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(212046);
    if (!Util.isNullOrNil(paramString))
    {
      if ((paramString.startsWith("https://" + WeChatHosts.domainString(2131761726) + "/")) || (paramString.startsWith("http://" + WeChatHosts.domainString(2131761726) + "/")))
      {
        AppMethodBeat.o(212046);
        return true;
      }
      AppMethodBeat.o(212046);
      return false;
    }
    AppMethodBeat.o(212046);
    return false;
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(212036);
    this.JmJ = true;
    super.G(paramInt, paramString);
    if ((!eqZ()) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(this.Jkg.coX())))
    {
      this.Abp.field_id = com.tencent.mm.plugin.multitask.g.aGH(this.Jkg.coX());
      Log.i("MicroMsg.WebMultiTaskHelper", "isMpArticle, url: %s", new Object[] { this.Jkg.coX() });
    }
    AppMethodBeat.o(212036);
  }
  
  public final boolean O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(212028);
    bPu();
    Object localObject;
    if (!this.JwU)
    {
      localObject = era();
      if (localObject == null) {
        break label78;
      }
      localObject = ((MultiTaskInfo)localObject).field_id;
      if (localObject == null) {
        break label78;
      }
    }
    label78:
    for (paramBoolean = ((com.tencent.mm.plugin.taskbar.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.taskbar.d.class)).hasTaskInfo((String)localObject);; paramBoolean = false)
    {
      if (paramBoolean) {
        this.JwT = false;
      }
      paramBoolean = super.O(paramInt, this.JwT);
      AppMethodBeat.o(212028);
      return paramBoolean;
    }
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(212042);
    super.aGj();
    this.JmK = false;
    AppMethodBeat.o(212042);
  }
  
  public final void ah(Bitmap paramBitmap)
  {
    AppMethodBeat.i(212037);
    if (this.JmJ) {
      super.ah(paramBitmap);
    }
    AppMethodBeat.o(212037);
  }
  
  public final void ahe(int paramInt)
  {
    AppMethodBeat.i(212034);
    this.JwU = true;
    if (paramInt == 0)
    {
      this.JwT = false;
      bPu();
      ai(null);
      AppMethodBeat.o(212034);
      return;
    }
    this.JwT = true;
    erc();
    AppMethodBeat.o(212034);
  }
  
  public final void ai(Bitmap paramBitmap)
  {
    AppMethodBeat.i(212040);
    if (this.JmJ) {
      super.ai(paramBitmap);
    }
    AppMethodBeat.o(212040);
  }
  
  public final void bCA()
  {
    AppMethodBeat.i(212041);
    super.bCA();
    if (!this.JmK) {
      this.JmK = true;
    }
    AppMethodBeat.o(212041);
  }
  
  public final boolean bPp()
  {
    AppMethodBeat.i(212031);
    if ((this.Jkg.gbH()) && (this.Aak.bPp()))
    {
      AppMethodBeat.o(212031);
      return true;
    }
    AppMethodBeat.o(212031);
    return false;
  }
  
  public final boolean bPq()
  {
    AppMethodBeat.i(212043);
    boolean bool = this.Jkg.gbH();
    AppMethodBeat.o(212043);
    return bool;
  }
  
  public final void bPu()
  {
    AppMethodBeat.i(212035);
    try
    {
      this.IVb.edo = this.Jkg.coX();
      o.a locala = this.Jkg.gft();
      if (locala != null)
      {
        this.Abp.erh().title = locala.title;
        this.Abp.erh().MwR = locala.Jko;
        localObject2 = this.Abp.erh().nickname;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = locala.Jkn;
        }
        this.Abp.erh().nickname = ((String)localObject1);
        this.IVb.coverUrl = locala.iAo;
      }
      Object localObject2 = this.Abp.erh().title;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = this.Jkg.getIntent().getStringExtra("webpageTitle");
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = this.Jkg.pGj.getTitle();
      }
      this.Abp.erh().title = ((String)localObject2);
      this.Abp.field_data = this.IVb.toByteArray();
      AppMethodBeat.o(212035);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", localException, "onMenuMultiTaskSelected", new Object[0]);
      AppMethodBeat.o(212035);
    }
  }
  
  public final void d(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(212030);
    if (paramBoolean)
    {
      Log.i("MicroMsg.WebMultiTaskHelper", "ended, remove historyTaskInfo");
      erc();
      AppMethodBeat.o(212030);
      return;
    }
    Log.i("MicroMsg.WebMultiTaskHelper", "not ended update historyTaskInfo");
    c(paramBitmap, true);
    AppMethodBeat.o(212030);
  }
  
  public final boolean dki()
  {
    return true;
  }
  
  public final void dkj()
  {
    AppMethodBeat.i(212039);
    if (this.JmJ) {
      super.dkj();
    }
    AppMethodBeat.o(212039);
  }
  
  public final void eqX()
  {
    AppMethodBeat.i(212038);
    if (this.JmJ) {
      super.eqX();
    }
    AppMethodBeat.o(212038);
  }
  
  public final MultiTaskInfo era()
  {
    AppMethodBeat.i(212033);
    if ((this.Abp == null) || (this.Abp.field_data == null))
    {
      AppMethodBeat.o(212033);
      return null;
    }
    Object localObject = Parcel.obtain();
    ((Parcel)localObject).setDataPosition(0);
    this.Abp.writeToParcel((Parcel)localObject, 0);
    ((Parcel)localObject).setDataPosition(0);
    localObject = (MultiTaskInfo)MultiTaskInfo.CREATOR.createFromParcel((Parcel)localObject);
    ((MultiTaskInfo)localObject).field_id = com.tencent.mm.plugin.multitask.g.aGG(((aa)com.tencent.mm.kernel.g.af(aa.class)).fM(this.Jkg.coX()));
    AppMethodBeat.o(212033);
    return localObject;
  }
  
  public final boolean erb()
  {
    AppMethodBeat.i(212029);
    int i;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.soS, 0) != 0)
    {
      i = 1;
      if (i != 0) {
        break label71;
      }
    }
    label71:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.WebMultiTaskHelper", "shouldCaptureOnClose:%b", new Object[] { Boolean.valueOf(bool) });
      if (i != 0) {
        break label76;
      }
      AppMethodBeat.o(212029);
      return true;
      i = 0;
      break;
    }
    label76:
    AppMethodBeat.o(212029);
    return false;
  }
  
  public final int ghY()
  {
    return this.IVb.Nwi;
  }
  
  public final void ghZ()
  {
    AppMethodBeat.i(212047);
    if (this.AbC != null)
    {
      com.tencent.mm.plugin.multitask.animation.swipeahead.b localb = this.AbC;
      Log.i("MicroMsg.FloatMultiTaskIndicatorController", "stop FloatIndicatorController");
      MMHandlerThread.postToMainThread((Runnable)new b.c(localb));
      localb.Aak.a(null);
    }
    AppMethodBeat.o(212047);
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(212027);
    bPu();
    super.ic(paramBoolean);
    AppMethodBeat.o(212027);
  }
  
  public final void setRawUrl(String paramString)
  {
    this.IVb.edo = paramString;
  }
  
  public final boolean wu(int paramInt)
  {
    AppMethodBeat.i(212032);
    boolean bool = O(paramInt, this.JwT);
    AppMethodBeat.o(212032);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.multitask.a
 * JD-Core Version:    0.7.0.1
 */