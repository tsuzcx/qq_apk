package com.tencent.mm.plugin.webview.emojistore.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ng;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.c.j;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.fcp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.f;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$IOnLoadingStateChangedListener;", "()V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "emojiList", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiRecyclerView;", "lastClickTimestamp", "", "lastReportExposeStartPosition", "", "dp2px", "context", "Landroid/content/Context;", "dpValue", "", "getLayoutId", "getRecyclerViewPadding", "getReportScene", "initHeadInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadMore", "parent", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "report18742", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "bOk", "", "reportExpose", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SosSimilarUI
  extends MMSecDataActivity
  implements com.tencent.mm.am.h, SimilarEmojiLoadMoreRecyclerView.a
{
  public static final SosSimilarUI.a WAp;
  private final c WAk;
  private final com.tencent.mm.search.d.a WAq;
  private SosSimilarEmojiRecyclerView WAr;
  private int WAs;
  private long WAt;
  
  static
  {
    AppMethodBeat.i(82509);
    WAp = new SosSimilarUI.a((byte)0);
    AppMethodBeat.o(82509);
  }
  
  public SosSimilarUI()
  {
    AppMethodBeat.i(82508);
    this.WAk = new c();
    this.WAq = new com.tencent.mm.search.d.a();
    AppMethodBeat.o(82508);
  }
  
  private static final boolean a(SosSimilarUI paramSosSimilarUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294785);
    kotlin.g.b.s.u(paramSosSimilarUI, "this$0");
    paramSosSimilarUI.finish();
    AppMethodBeat.o(294785);
    return false;
  }
  
  private final void def()
  {
    AppMethodBeat.i(82504);
    eqy localeqy;
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (this.WAs < this.WAq.xSC)
    {
      localeqy = new eqy();
      if (!this.WAk.itb()) {
        break label325;
      }
      localObject1 = "";
      localObject2 = ((Iterable)this.WAk.Trs).iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject3 = (com.tencent.mm.emoji.c.b.h)localObject3;
        if ((i <= this.WAs) || (i > this.WAq.xSC - 2)) {
          break label588;
        }
        localObject1 = (String)localObject1 + ((com.tencent.mm.emoji.c.b.h)localObject3).mgK.getMd5() + ';';
      }
    }
    label325:
    label585:
    label588:
    for (;;)
    {
      i += 1;
      break;
      localObject3 = new StringBuilder("logid=17368&sessionid=").append(this.WAk.xVe).append("&searchid=").append(this.WAk.xVe).append("&scene=59&md5=");
      localObject2 = this.WAk.WAo;
      if (localObject2 == null) {}
      for (localObject2 = null;; localObject2 = ((SimilarEmojiQueryModel)localObject2).emojiMD5)
      {
        localeqy.abuE = (localObject2 + "&md5content=" + (String)localObject1 + "&pos=" + (this.WAs + 2) + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + this.WAk.xVe);
        localObject1 = new com.tencent.mm.plugin.websearch.api.ae(localeqy);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject1, 0);
        this.WAs = this.WAq.xSC;
        Log.i("MicroMsg.WebSearch.SosSimilarUI", localeqy.abuE);
        AppMethodBeat.o(82504);
        return;
      }
      localObject1 = "";
      localObject2 = ((Iterable)this.WAk.Trs).iterator();
      i = 0;
      label346:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject3 = (com.tencent.mm.emoji.c.b.h)localObject3;
        if ((i <= this.WAs) || (i > this.WAq.xSC - 2)) {
          break label585;
        }
        localObject1 = (String)localObject1 + "256:" + ((com.tencent.mm.emoji.c.b.h)localObject3).miv + ':' + cn.bDw() + ';';
      }
      for (;;)
      {
        i += 1;
        break label346;
        localObject3 = new StringBuilder("isexpose=1&searchid=").append(this.WAk.xVe).append("&content=").append((String)localObject1).append("&query=");
        localObject1 = this.WAk.WAo;
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          localeqy.abuE = ((String)localObject1 + "&ishomepage=0&&sessionid=" + this.WAk.sessionId + "&scene=78&logtype=1&requestid=" + this.WAk.xVe + "&pageno=" + this.WAk.miw);
          break;
          localObject2 = ((SimilarEmojiQueryModel)localObject1).query;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
    }
  }
  
  private final int itc()
  {
    AppMethodBeat.i(82502);
    int i = aw.getDeviceWidth();
    AppCompatActivity localAppCompatActivity = getContext();
    kotlin.g.b.s.s(localAppCompatActivity, "context");
    i = (i - kM((Context)localAppCompatActivity) * 3) / 8;
    Log.i("MicroMsg.WebSearch.SosSimilarUI", kotlin.g.b.s.X("recycler view padding :", Integer.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(82502);
      return i;
    }
    AppMethodBeat.o(82502);
    return 0;
  }
  
  private static int kM(Context paramContext)
  {
    AppMethodBeat.i(82507);
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * 108.0F + 0.5F);
    AppMethodBeat.o(82507);
    return i;
  }
  
  public final void f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(294845);
    kotlin.g.b.s.u(paramEmojiInfo, "emojiInfo");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.report.f.Ozc.b(18742, new Object[] { Integer.valueOf(fJx()), this.WAk.xVe, this.WAk.xVe, this.WAk.xVe, Integer.valueOf(i), paramEmojiInfo.getMd5() });
      AppMethodBeat.o(294845);
      return;
    }
  }
  
  public final int fJx()
  {
    AppMethodBeat.i(294838);
    if (this.WAk.itb())
    {
      AppMethodBeat.o(294838);
      return 59;
    }
    AppMethodBeat.o(294838);
    return 78;
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void isZ()
  {
    AppMethodBeat.i(294882);
    SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView;
    if (this.WAk.ABD)
    {
      localSosSimilarEmojiRecyclerView = this.WAr;
      if ((localSosSimilarEmojiRecyclerView == null) || (localSosSimilarEmojiRecyclerView.uRi)) {
        break label74;
      }
    }
    label74:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localSosSimilarEmojiRecyclerView = this.WAr;
        if (localSosSimilarEmojiRecyclerView != null) {
          localSosSimilarEmojiRecyclerView.showLoading(true);
        }
        def();
        this.WAk.e((com.tencent.mm.am.h)this);
      }
      AppMethodBeat.o(294882);
      return;
    }
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(82501);
    super.onCreate(paramBundle);
    getWindow().getDecorView().setBackgroundColor(getResources().getColor(c.c.BW_93));
    Object localObject2 = this.WAk;
    paramBundle = (Context)this;
    Object localObject1 = getIntent();
    kotlin.g.b.s.u(paramBundle, "context");
    kotlin.g.b.s.u(localObject1, "intent");
    com.tencent.mm.kernel.h.aZW().a(2999, (com.tencent.mm.am.h)localObject2);
    com.tencent.mm.kernel.h.aZW().a(719, (com.tencent.mm.am.h)localObject2);
    ((c)localObject2).WAo = ((SimilarEmojiQueryModel)((Intent)localObject1).getParcelableExtra("KEY_NET_PARAM"));
    localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    paramBundle = a.a.jC(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (fcp)paramBundle.c(1, fcp.class);
      if (paramBundle != null)
      {
        localObject1 = paramBundle.SessionId;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
        kotlin.g.b.s.u(paramBundle, "<set-?>");
        ((c)localObject2).sessionId = paramBundle;
        Log.i("MicroMsg.SimilarEmoji", kotlin.g.b.s.X("report sessionId=", ((c)localObject2).sessionId));
      }
    }
    paramBundle = getContext();
    kotlin.g.b.s.s(paramBundle, "context");
    this.WAr = new SosSimilarEmojiRecyclerView((Context)new z((Context)paramBundle, c.j.EmojiPanel));
    paramBundle = this.WAr;
    if (paramBundle != null) {
      paramBundle.setBackgroundColor(getResources().getColor(c.c.BW_93));
    }
    paramBundle = this.WAr;
    if (paramBundle != null) {
      paramBundle.setOnLoadingStateChangedListener((SimilarEmojiLoadMoreRecyclerView.a)this);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    localObject1 = new TouchableLayout((Context)this);
    localObject2 = this.WAr;
    if (localObject2 != null) {
      ((SosSimilarEmojiRecyclerView)localObject2).setPadding(itc(), 0, itc(), 0);
    }
    ((TouchableLayout)localObject1).addView((View)this.WAr, (ViewGroup.LayoutParams)paramBundle);
    setContentView((View)localObject1, (ViewGroup.LayoutParams)paramBundle);
    paramBundle = this.WAk.WAo;
    if (paramBundle == null)
    {
      paramBundle = null;
      localObject1 = paramBundle;
      if (paramBundle == null)
      {
        localObject1 = MMApplicationContext.getContext().getString(c.i.sos_similar_emoji_title);
        kotlin.g.b.s.s(localObject1, "getContext().getString(R….sos_similar_emoji_title)");
      }
      setMMTitle((String)localObject1);
      setBackBtn(new SosSimilarUI..ExternalSyntheticLambda0(this));
      getContext();
      paramBundle = new GridLayoutManager(3);
      paramBundle.bWq = ((GridLayoutManager.b)new b(this, paramBundle));
      localObject1 = this.WAr;
      if (localObject1 != null) {
        ((SosSimilarEmojiRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
      }
      paramBundle = this.WAr;
      if (paramBundle != null) {
        paramBundle.setItemViewCacheSize(0);
      }
      paramBundle = this.WAr;
      if (paramBundle != null) {
        paramBundle.setAdapter((RecyclerView.a)this.WAq);
      }
      this.WAq.mkY = ((n)new c(this));
      this.WAq.acsm = false;
      paramBundle = this.WAk.ita();
      if (paramBundle != null)
      {
        if (!this.WAk.itb()) {
          break label572;
        }
        this.WAq.G(paramBundle);
      }
    }
    for (;;)
    {
      this.WAq.iTE();
      this.WAq.bZE.notifyChanged();
      this.WAk.e((com.tencent.mm.am.h)this);
      paramBundle = com.tencent.mm.search.c.a.acsi;
      com.tencent.mm.search.c.a.iTy();
      AppMethodBeat.o(82501);
      return;
      localObject1 = paramBundle.query;
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramBundle = null;
      break;
      label572:
      this.WAq.H(paramBundle);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(82506);
    def();
    super.onDestroy();
    c localc = this.WAk;
    localc.callback = null;
    com.tencent.mm.kernel.h.baD().mCm.cancel(2999);
    com.tencent.mm.kernel.h.baD().mCm.b(2999, (com.tencent.mm.am.h)localc);
    com.tencent.mm.kernel.h.baD().mCm.cancel(719);
    com.tencent.mm.kernel.h.aZW().b(719, (com.tencent.mm.am.h)localc);
    AppMethodBeat.o(82506);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(82503);
    paramp = this.WAr;
    if (paramp != null) {
      paramp.showLoading(false);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((List)this.WAk.Trs).size() > 1))
    {
      paramInt1 = this.WAq.getItemCount();
      this.WAq.acsm = true;
      this.WAq.bz((List)this.WAk.Trs);
      if (paramInt1 - 2 <= 0)
      {
        this.WAq.bZE.notifyChanged();
        AppMethodBeat.o(82503);
        return;
      }
      this.WAq.fV(paramInt1 - 1);
      def();
      AppMethodBeat.o(82503);
      return;
    }
    Log.i("MicroMsg.WebSearch.SosSimilarUI", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + ' ');
    paramString = new ArrayList();
    this.WAq.setData((List)paramString);
    paramString = this.WAk.ita();
    if (paramString != null)
    {
      if (!this.WAk.itb()) {
        break label244;
      }
      this.WAq.G(paramString);
    }
    for (;;)
    {
      this.WAq.iTF();
      this.WAq.bZE.notifyChanged();
      break;
      label244:
      this.WAq.H(paramString);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$2", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends GridLayoutManager.b
  {
    b(SosSimilarUI paramSosSimilarUI, GridLayoutManager paramGridLayoutManager) {}
    
    public final int fJ(int paramInt)
    {
      AppMethodBeat.i(82498);
      switch (SosSimilarUI.a(this.WAu).getItemViewType(paramInt))
      {
      case 101: 
      case 102: 
      case 103: 
      default: 
        AppMethodBeat.o(82498);
        return 1;
      }
      paramInt = paramBundle.bWl;
      AppMethodBeat.o(82498);
      return paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$3", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements n
  {
    c(SosSimilarUI paramSosSimilarUI) {}
    
    private static final void a(SosSimilarUI paramSosSimilarUI, ah.f paramf, Context paramContext, boolean paramBoolean, String paramString, int paramInt)
    {
      Object localObject2 = null;
      AppMethodBeat.i(294769);
      kotlin.g.b.s.u(paramSosSimilarUI, "this$0");
      kotlin.g.b.s.u(paramf, "$emojiInfo");
      kotlin.g.b.s.u(paramContext, "$context");
      Object localObject3;
      if (paramBoolean)
      {
        localObject3 = com.tencent.mm.plugin.emoji.model.s.dAl();
        localObject1 = SosSimilarUI.b(paramSosSimilarUI).WAo;
        if (localObject1 != null) {
          break label145;
        }
        localObject1 = null;
        ((com.tencent.mm.plugin.emoji.mgr.f)localObject3).a((String)localObject1, (EmojiInfo)paramf.aqH, null);
        if (!Util.isNullOrNil(paramString))
        {
          localObject3 = g.gaI();
          localObject1 = SosSimilarUI.b(paramSosSimilarUI).WAo;
          if (localObject1 != null) {
            break label155;
          }
        }
      }
      label145:
      label155:
      for (Object localObject1 = localObject2;; localObject1 = ((SimilarEmojiQueryModel)localObject1).toUser)
      {
        ((com.tencent.mm.plugin.messenger.a.d)localObject3).ke(paramString, (String)localObject1);
        aa.makeText(paramContext, (CharSequence)paramContext.getString(c.i.app_sent), 1).show();
        paramSosSimilarUI.f((EmojiInfo)paramf.aqH, paramBoolean);
        AppMethodBeat.o(294769);
        return;
        localObject1 = ((SimilarEmojiQueryModel)localObject1).toUser;
        break;
      }
    }
    
    private static final void a(SosSimilarUI paramSosSimilarUI, ah.f paramf, boolean paramBoolean, String paramString, int paramInt)
    {
      AppMethodBeat.i(294761);
      kotlin.g.b.s.u(paramSosSimilarUI, "this$0");
      kotlin.g.b.s.u(paramf, "$emojiInfo");
      com.tencent.mm.plugin.emoji.mgr.f localf;
      if (paramBoolean)
      {
        localf = com.tencent.mm.plugin.emoji.model.s.dAl();
        paramString = SosSimilarUI.b(paramSosSimilarUI).WAo;
        if (paramString != null) {
          break label92;
        }
      }
      label92:
      for (paramString = null;; paramString = paramString.toUser)
      {
        localf.a(paramString, (EmojiInfo)paramf.aqH, null);
        paramString = new Intent();
        paramString.putExtra("KEY_EMOJI_INFO_RESULT", (Parcelable)paramf.aqH);
        paramSosSimilarUI.setResult(-1, paramString);
        paramSosSimilarUI.finish();
        AppMethodBeat.o(294761);
        return;
      }
    }
    
    private static final void a(ah.f paramf, Context paramContext, SosSimilarUI paramSosSimilarUI, boolean paramBoolean, String paramString, int paramInt)
    {
      AppMethodBeat.i(294758);
      kotlin.g.b.s.u(paramf, "$emojiInfo");
      kotlin.g.b.s.u(paramContext, "$context");
      kotlin.g.b.s.u(paramSosSimilarUI, "this$0");
      if (paramBoolean)
      {
        paramString = com.tencent.mm.search.b.a.acse;
        paramString = com.tencent.mm.search.b.a.iTv();
        if (paramString != null)
        {
          paramString = paramString.mkP;
          if (paramString != null) {
            paramString.o((EmojiInfo)paramf.aqH);
          }
        }
        aa.makeText(paramContext, (CharSequence)paramContext.getString(c.i.app_sent), 1).show();
      }
      paramSosSimilarUI.f((EmojiInfo)paramf.aqH, paramBoolean);
      AppMethodBeat.o(294758);
    }
    
    public final void a(View paramView, Context paramContext, int paramInt)
    {
      AppMethodBeat.i(294795);
      kotlin.g.b.s.u(paramContext, "context");
      Object localObject2 = SosSimilarUI.a(this.WAu).rH(paramInt);
      int i;
      label71:
      Object localObject3;
      if ((localObject2 instanceof com.tencent.mm.emoji.c.b.h))
      {
        paramContext = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(((com.tencent.mm.emoji.c.b.h)localObject2).mgK.field_md5);
        if (paramContext != null) {
          break label354;
        }
        i = 0;
        if (i != EmojiInfo.aklM) {
          break label363;
        }
        i = 1;
        localObject3 = new ng();
        ((ng)localObject3).iqr = this.WAu.fJx();
        ((ng)localObject3).vA(SosSimilarUI.b(this.WAu).sessionId);
        ((ng)localObject3).vB(SosSimilarUI.b(this.WAu).xVe);
        ((ng)localObject3).vC(((com.tencent.mm.emoji.c.b.h)localObject2).mgK.field_md5);
        paramContext = SosSimilarUI.b(this.WAu).WAo;
        if (paramContext != null) {
          break label369;
        }
        paramContext = "";
        label161:
        ((ng)localObject3).vD(paramContext);
        ((ng)localObject3).jeA = SosSimilarUI.b(this.WAu).offset;
        ((ng)localObject3).jeB = paramInt;
        ((ng)localObject3).ivT = System.currentTimeMillis();
        ((ng)localObject3).vE(SosSimilarUI.b(this.WAu).xVe);
        ((ng)localObject3).ioV = 1L;
        if (i == 0) {
          break label390;
        }
      }
      label390:
      for (long l = 1L;; l = 0L)
      {
        ((ng)localObject3).iyE = l;
        ((ng)localObject3).bMH();
        as.a((com.tencent.mm.plugin.report.a)localObject3);
        if (i == 0)
        {
          paramContext = new com.tencent.mm.ui.widget.b.a((Context)this.WAu);
          localObject1 = (View.OnCreateContextMenuListener)new a((com.tencent.mm.emoji.c.b.h)localObject2);
          localObject2 = (u.i)new b((Context)this.WAu, (com.tencent.mm.emoji.c.b.h)localObject2, SosSimilarUI.b(this.WAu), paramInt);
          localObject3 = TouchableLayout.agKp;
          paramInt = TouchableLayout.jMn();
          localObject3 = TouchableLayout.agKp;
          paramContext.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (u.i)localObject2, paramInt, TouchableLayout.jMo());
        }
        AppMethodBeat.o(294795);
        return;
        label354:
        i = paramContext.field_catalog;
        break;
        label363:
        i = 0;
        break label71;
        label369:
        Object localObject1 = paramContext.emojiMD5;
        paramContext = (Context)localObject1;
        if (localObject1 != null) {
          break label161;
        }
        paramContext = "";
        break label161;
      }
    }
    
    public final void a(View paramView, Context paramContext, int paramInt, com.tencent.mm.emoji.c.b.ae paramae)
    {
      AppMethodBeat.i(294811);
      kotlin.g.b.s.u(paramContext, "context");
      if ((paramae == null) || (!(paramae instanceof com.tencent.mm.emoji.c.b.h)) || (((com.tencent.mm.emoji.c.b.h)paramae).miu != 103))
      {
        AppMethodBeat.o(294811);
        return;
      }
      if (System.currentTimeMillis() - SosSimilarUI.c(this.WAu) < 500L)
      {
        AppMethodBeat.o(294811);
        return;
      }
      SosSimilarUI.a(this.WAu, System.currentTimeMillis());
      Object localObject1 = com.tencent.mm.search.b.a.acse;
      localObject1 = com.tencent.mm.search.b.a.iTv();
      if (localObject1 != null) {
        ((com.tencent.mm.search.b.c)localObject1).a(paramView, paramContext, paramInt, paramae);
      }
      localObject1 = new ah.f();
      ((ah.f)localObject1).aqH = ((com.tencent.mm.emoji.c.b.h)paramae).mgK;
      Object localObject2;
      if (SosSimilarUI.b(this.WAu).itb())
      {
        localObject2 = (com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.j.class);
        paramView = SosSimilarUI.b(this.WAu).WAo;
        if (paramView == null)
        {
          paramView = null;
          ((com.tencent.mm.pluginsdk.j)localObject2).d(paramContext, paramView, ((EmojiInfo)((ah.f)localObject1).aqH).getMd5(), ((EmojiInfo)((ah.f)localObject1).aqH).akmc, new SosSimilarUI.c..ExternalSyntheticLambda2((ah.f)localObject1, paramContext, this.WAu));
          label213:
          localObject2 = new eqy();
          if (!SosSimilarUI.b(this.WAu).itb()) {
            break label642;
          }
          paramContext = new StringBuilder("logid=17372&sessionid=").append(SosSimilarUI.b(this.WAu).xVe).append("&searchid=").append(SosSimilarUI.b(this.WAu).xVe).append("&scene=59&clickmd5=").append(((EmojiInfo)((ah.f)localObject1).aqH).getMd5()).append("&querymd5=");
          paramView = SosSimilarUI.b(this.WAu).WAo;
          if (paramView != null) {
            break label634;
          }
        }
      }
      label634:
      for (paramView = null;; paramView = paramView.emojiMD5)
      {
        ((eqy)localObject2).abuE = (paramView + "&offset=" + SosSimilarUI.b(this.WAu).offset + "&pos=" + paramInt + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + SosSimilarUI.b(this.WAu).xVe);
        paramView = new com.tencent.mm.plugin.websearch.api.ae((eqy)localObject2);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramView, 0);
        Log.i("MicroMsg.WebSearch.SosSimilarUI", ((eqy)localObject2).abuE);
        AppMethodBeat.o(294811);
        return;
        paramView = paramView.toUser;
        break;
        if (this.WAu.getIntent().getBooleanExtra("KEY_GET_EMOJI_INFO_DIRECTLY", false))
        {
          paramView = (com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.j.class);
          SosSimilarUI.b(this.WAu);
          paramView.a(paramContext, ((EmojiInfo)((ah.f)localObject1).aqH).getMd5(), ((EmojiInfo)((ah.f)localObject1).aqH).field_designerID, "", ((EmojiInfo)((ah.f)localObject1).aqH).field_thumbUrl, new SosSimilarUI.c..ExternalSyntheticLambda0(this.WAu, (ah.f)localObject1));
          break label213;
        }
        localObject2 = (com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.j.class);
        paramView = SosSimilarUI.b(this.WAu).WAo;
        if (paramView == null) {}
        for (paramView = null;; paramView = paramView.toUser)
        {
          ((com.tencent.mm.pluginsdk.j)localObject2).b(paramContext, paramView, ((EmojiInfo)((ah.f)localObject1).aqH).getMd5(), ((EmojiInfo)((ah.f)localObject1).aqH).field_designerID, "", ((EmojiInfo)((ah.f)localObject1).aqH).field_thumbUrl, new SosSimilarUI.c..ExternalSyntheticLambda1(this.WAu, (ah.f)localObject1, paramContext));
          break;
        }
      }
      label642:
      localObject1 = new StringBuilder("scene=78&searchid=").append(SosSimilarUI.b(this.WAu).xVe).append("&businesstype=256&docid=").append(((com.tencent.mm.emoji.c.b.h)paramae).miv).append("&docpos=").append(paramInt).append("&typepos=0&ishomepage=0&clienttimestamp=").append(cn.bDw()).append("&sceneactiontype=1&query=");
      paramView = SosSimilarUI.b(this.WAu).WAo;
      if (paramView == null) {
        paramView = "";
      }
      for (;;)
      {
        ((eqy)localObject2).abuE = (paramView + "&sessionid=" + SosSimilarUI.b(this.WAu).sessionId + "&nettype=" + aj.gtA() + "&requestid=" + SosSimilarUI.b(this.WAu).xVe + "&reqbusinesstype=256&pageno=" + ((com.tencent.mm.emoji.c.b.h)paramae).miw);
        break;
        paramContext = paramView.query;
        paramView = paramContext;
        if (paramContext == null) {
          paramView = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.SosSimilarUI
 * JD-Core Version:    0.7.0.1
 */