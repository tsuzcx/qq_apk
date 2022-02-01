package com.tencent.mm.plugin.webview.emojistore.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$IOnLoadingStateChangedListener;", "()V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "emojiList", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiRecyclerView;", "lastClickTimestamp", "", "lastReportExposeStartPosition", "", "dp2px", "context", "Landroid/content/Context;", "dpValue", "", "getLayoutId", "getRecyclerViewPadding", "getReportScene", "initHeadInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadMore", "parent", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "report18742", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "bOk", "", "reportExpose", "Companion", "plugin-webview_release"})
public final class SosSimilarUI
  extends MMSecDataActivity
  implements i, SimilarEmojiLoadMoreRecyclerView.a
{
  public static final SosSimilarUI.a INJ;
  private final com.tencent.mm.search.d.a INF;
  private SosSimilarEmojiRecyclerView ING;
  private int INH;
  private long INI;
  private final c INz;
  
  static
  {
    AppMethodBeat.i(82509);
    INJ = new SosSimilarUI.a((byte)0);
    AppMethodBeat.o(82509);
  }
  
  public SosSimilarUI()
  {
    AppMethodBeat.i(82508);
    this.INz = new c();
    this.INF = new com.tencent.mm.search.d.a();
    AppMethodBeat.o(82508);
  }
  
  private final void cnl()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(82504);
    doc localdoc;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.INH < this.INF.rgC)
    {
      localdoc = new doc();
      if (!this.INz.gau()) {
        break label334;
      }
      localObject1 = "";
      localObject2 = ((Iterable)this.INz.IND).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject3 = (h)localObject3;
        if ((i <= this.INH) || (i > this.INF.rgC - 2)) {
          break label597;
        }
        localObject1 = (String)localObject1 + ((h)localObject3).gWm.getMd5() + ';';
      }
    }
    label334:
    label594:
    label597:
    for (;;)
    {
      i += 1;
      break;
      localObject3 = new StringBuilder("logid=17368&sessionid=").append(this.INz.rjq).append("&searchid=").append(this.INz.rjq).append("&scene=59&md5=");
      localObject2 = this.INz.INC;
      if (localObject2 != null) {}
      for (localObject2 = ((SimilarEmojiQueryModel)localObject2).emojiMD5;; localObject2 = null)
      {
        localdoc.MRe = ((String)localObject2 + "&md5content=" + (String)localObject1 + "&pos=" + (this.INH + 2) + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + this.INz.rjq);
        localObject1 = new ad(localdoc);
        com.tencent.mm.kernel.g.azz().b((q)localObject1);
        this.INH = this.INF.rgC;
        Log.i("MicroMsg.WebSearch.SosSimilarUI", localdoc.MRe);
        AppMethodBeat.o(82504);
        return;
      }
      localObject1 = "";
      localObject2 = ((Iterable)this.INz.IND).iterator();
      i = j;
      label356:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        localObject3 = (h)localObject3;
        if ((i <= this.INH) || (i > this.INF.rgC - 2)) {
          break label594;
        }
        localObject1 = (String)localObject1 + "256:" + ((h)localObject3).gYd + ':' + cl.aWA() + ';';
      }
      for (;;)
      {
        i += 1;
        break label356;
        localObject3 = new StringBuilder("isexpose=1&searchid=").append(this.INz.rjq).append("&content=").append((String)localObject1).append("&query=");
        localObject1 = this.INz.INC;
        if (localObject1 != null)
        {
          localObject2 = ((SimilarEmojiQueryModel)localObject1).query;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localdoc.MRe = ((String)localObject1 + "&ishomepage=0&&sessionid=" + this.INz.sessionId + "&scene=78&logtype=1&requestid=" + this.INz.rjq + "&pageno=" + this.INz.gYe);
        break;
      }
    }
  }
  
  private final int gav()
  {
    AppMethodBeat.i(82502);
    int i = ao.getDeviceWidth();
    AppCompatActivity localAppCompatActivity = getContext();
    p.g(localAppCompatActivity, "context");
    i = (i - hR((Context)localAppCompatActivity) * 3) / 8;
    Log.i("MicroMsg.WebSearch.SosSimilarUI", "recycler view padding :".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(82502);
      return i;
    }
    AppMethodBeat.o(82502);
    return 0;
  }
  
  private static int hR(Context paramContext)
  {
    AppMethodBeat.i(82507);
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    int i = (int)(paramContext.getDisplayMetrics().density * 108.0F + 0.5F);
    AppMethodBeat.o(82507);
    return i;
  }
  
  public final int dXX()
  {
    AppMethodBeat.i(210294);
    if (this.INz.gau())
    {
      AppMethodBeat.o(210294);
      return 59;
    }
    AppMethodBeat.o(210294);
    return 78;
  }
  
  public final void f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(210295);
    p.h(paramEmojiInfo, "emojiInfo");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      e.Cxv.a(18742, new Object[] { Integer.valueOf(dXX()), this.INz.rjq, this.INz.rjq, this.INz.rjq, Integer.valueOf(i), paramEmojiInfo.getMd5() });
      AppMethodBeat.o(210295);
      return;
    }
  }
  
  public final void gas()
  {
    AppMethodBeat.i(82505);
    if (this.INz.tuG)
    {
      SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.ING;
      if (localSosSimilarEmojiRecyclerView == null) {
        break label68;
      }
      if (!localSosSimilarEmojiRecyclerView.gar())
      {
        localSosSimilarEmojiRecyclerView = this.ING;
        if (localSosSimilarEmojiRecyclerView != null) {
          localSosSimilarEmojiRecyclerView.showLoading(true);
        }
        cnl();
        this.INz.f((i)this);
      }
    }
    AppMethodBeat.o(82505);
    return;
    label68:
    AppMethodBeat.o(82505);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(82501);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle.getDecorView().setBackgroundColor(getResources().getColor(2131099689));
    Object localObject2 = this.INz;
    paramBundle = (Context)this;
    Object localObject1 = getIntent();
    p.g(localObject1, "intent");
    p.h(paramBundle, "context");
    p.h(localObject1, "intent");
    com.tencent.mm.kernel.g.azz().a(2999, (i)localObject2);
    com.tencent.mm.kernel.g.azz().a(719, (i)localObject2);
    ((c)localObject2).INC = ((SimilarEmojiQueryModel)((Intent)localObject1).getParcelableExtra("KEY_NET_PARAM"));
    localObject1 = SecDataUIC.CWq;
    paramBundle = SecDataUIC.a.gU(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (dyn)paramBundle.f(1, dyn.class);
      if (paramBundle != null)
      {
        localObject1 = paramBundle.SessionId;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
        ((c)localObject2).sessionId = paramBundle;
        Log.i("MicroMsg.SimilarEmoji", "report sessionId=" + ((c)localObject2).sessionId);
      }
    }
    paramBundle = getContext();
    p.g(paramBundle, "context");
    this.ING = new SosSimilarEmojiRecyclerView((Context)new com.tencent.mm.ui.u((Context)paramBundle, 2131820879));
    paramBundle = this.ING;
    if (paramBundle != null) {
      paramBundle.setBackgroundColor(getResources().getColor(2131099689));
    }
    paramBundle = this.ING;
    if (paramBundle != null) {
      paramBundle.setOnLoadingStateChangedListener((SimilarEmojiLoadMoreRecyclerView.a)this);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    localObject1 = new TouchableLayout((Context)this);
    localObject2 = this.ING;
    if (localObject2 != null) {
      ((SosSimilarEmojiRecyclerView)localObject2).setPadding(gav(), 0, gav(), 0);
    }
    ((TouchableLayout)localObject1).addView((View)this.ING, (ViewGroup.LayoutParams)paramBundle);
    setContentView((View)localObject1, (ViewGroup.LayoutParams)paramBundle);
    paramBundle = this.INz.INC;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.query;
      if (localObject1 != null)
      {
        paramBundle = (Bundle)localObject1;
        if (localObject1 != null) {
          break label386;
        }
      }
    }
    paramBundle = MMApplicationContext.getContext().getString(2131766312);
    p.g(paramBundle, "run {\n            MMAppl…ar_emoji_title)\n        }");
    label386:
    setMMTitle(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    getContext();
    paramBundle = new GridLayoutManager(3);
    paramBundle.a((GridLayoutManager.b)new c(this, paramBundle));
    localObject1 = this.ING;
    if (localObject1 != null) {
      ((SosSimilarEmojiRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
    }
    paramBundle = this.ING;
    if (paramBundle != null) {
      paramBundle.setItemViewCacheSize(0);
    }
    paramBundle = this.ING;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.INF);
    }
    this.INF.haK = ((n)new d(this));
    this.INF.NJB = false;
    paramBundle = this.INz.gat();
    if (paramBundle != null)
    {
      if (!this.INz.gau()) {
        break label582;
      }
      this.INF.F(paramBundle);
    }
    for (;;)
    {
      this.INF.gxB();
      this.INF.notifyDataSetChanged();
      this.INz.f((i)this);
      paramBundle = com.tencent.mm.search.c.a.NJv;
      com.tencent.mm.search.c.a.gxt();
      AppMethodBeat.o(82501);
      return;
      label582:
      this.INF.G(paramBundle);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(82506);
    cnl();
    super.onDestroy();
    c localc = this.INz;
    localc.callback = null;
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().cancel(2999);
    localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(2999, (i)localc);
    localb = com.tencent.mm.kernel.g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().cancel(719);
    com.tencent.mm.kernel.g.azz().b(719, (i)localc);
    AppMethodBeat.o(82506);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(82503);
    paramq = this.ING;
    if (paramq != null) {
      paramq.showLoading(false);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((List)this.INz.IND).size() > 1))
    {
      paramInt1 = this.INF.getItemCount();
      this.INF.NJB = true;
      this.INF.ad((List)this.INz.IND);
      if (paramInt1 - 2 <= 0)
      {
        this.INF.notifyDataSetChanged();
        AppMethodBeat.o(82503);
        return;
      }
      this.INF.ci(paramInt1 - 1);
      cnl();
      AppMethodBeat.o(82503);
      return;
    }
    Log.i("MicroMsg.WebSearch.SosSimilarUI", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + ' ');
    paramString = new ArrayList();
    this.INF.setData((List)paramString);
    paramString = this.INz.gat();
    if (paramString != null)
    {
      if (!this.INz.gau()) {
        break label237;
      }
      this.INF.F(paramString);
    }
    for (;;)
    {
      this.INF.gxC();
      this.INF.notifyDataSetChanged();
      break;
      label237:
      this.INF.G(paramString);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(SosSimilarUI paramSosSimilarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(82497);
      this.INK.finish();
      AppMethodBeat.o(82497);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$2", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-webview_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(GridLayoutManager paramGridLayoutManager) {}
    
    public final int bX(int paramInt)
    {
      AppMethodBeat.i(82498);
      switch (SosSimilarUI.a(this.INK).getItemViewType(paramInt))
      {
      case 101: 
      case 102: 
      case 103: 
      default: 
        AppMethodBeat.o(82498);
        return 1;
      }
      paramInt = paramBundle.ki();
      AppMethodBeat.o(82498);
      return paramInt;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$3", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "plugin-webview_release"})
  public static final class d
    implements n
  {
    public final void a(View paramView, Context paramContext, int paramInt)
    {
      AppMethodBeat.i(210292);
      p.h(paramContext, "context");
      Object localObject2 = SosSimilarUI.a(this.INK).pm(paramInt);
      int i;
      label82:
      Object localObject3;
      Object localObject1;
      if ((localObject2 instanceof h))
      {
        paramContext = k.getEmojiStorageMgr();
        p.g(paramContext, "SubCoreEmoji.getEmojiStorageMgr()");
        paramContext = paramContext.cgN().blk(((h)localObject2).gWm.field_md5);
        if (paramContext == null) {
          break label384;
        }
        i = paramContext.getGroup();
        if (i != EmojiInfo.Uuv) {
          break label390;
        }
        i = 1;
        localObject3 = new ig();
        ((ig)localObject3).ri(this.INK.dXX());
        ((ig)localObject3).vZ(SosSimilarUI.b(this.INK).sessionId);
        ((ig)localObject3).wa(SosSimilarUI.b(this.INK).rjq);
        ((ig)localObject3).wb(((h)localObject2).gWm.field_md5);
        paramContext = SosSimilarUI.b(this.INK).INC;
        if (paramContext != null)
        {
          localObject1 = paramContext.emojiMD5;
          paramContext = (Context)localObject1;
          if (localObject1 != null) {}
        }
        else
        {
          paramContext = "";
        }
        ((ig)localObject3).wc(paramContext);
        ((ig)localObject3).rj(SosSimilarUI.b(this.INK).offset);
        ((ig)localObject3).rk(paramInt);
        ((ig)localObject3).rl(System.currentTimeMillis());
        ((ig)localObject3).wd(SosSimilarUI.b(this.INK).rjq);
        ((ig)localObject3).rm(1L);
        if (i == 0) {
          break label396;
        }
      }
      label384:
      label390:
      label396:
      for (long l = 1L;; l = 0L)
      {
        ((ig)localObject3).rn(l);
        ((ig)localObject3).bfK();
        ar.a((com.tencent.mm.plugin.report.a)localObject3);
        if (i == 0)
        {
          paramContext = new com.tencent.mm.ui.widget.b.a((Context)this.INK);
          localObject1 = (View.OnCreateContextMenuListener)new a((h)localObject2);
          localObject2 = (o.g)new b((Context)this.INK, (h)localObject2, SosSimilarUI.b(this.INK), paramInt);
          localObject3 = TouchableLayout.Rni;
          paramInt = TouchableLayout.hfC();
          localObject3 = TouchableLayout.Rni;
          paramContext.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (o.g)localObject2, paramInt, TouchableLayout.hfD());
        }
        AppMethodBeat.o(210292);
        return;
        i = 0;
        break;
        i = 0;
        break label82;
      }
    }
    
    public final void a(View paramView, final Context paramContext, int paramInt, ac paramac)
    {
      StringBuilder localStringBuilder = null;
      AppMethodBeat.i(210293);
      p.h(paramContext, "context");
      if ((paramac == null) || (!(paramac instanceof h)) || (((h)paramac).gYc != 103))
      {
        AppMethodBeat.o(210293);
        return;
      }
      if (System.currentTimeMillis() - SosSimilarUI.c(this.INK) < 500L)
      {
        AppMethodBeat.o(210293);
        return;
      }
      SosSimilarUI.a(this.INK, System.currentTimeMillis());
      Object localObject1 = com.tencent.mm.search.b.a.NJs;
      localObject1 = com.tencent.mm.search.b.a.gxq();
      if (localObject1 != null) {
        ((com.tencent.mm.search.b.c)localObject1).a(paramView, paramContext, paramInt, paramac);
      }
      localObject1 = new z.f();
      ((z.f)localObject1).SYG = ((h)paramac).gWm;
      Object localObject2;
      if (SosSimilarUI.b(this.INK).gau())
      {
        localObject2 = (com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.j.class);
        paramView = SosSimilarUI.b(this.INK).INC;
        if (paramView != null)
        {
          paramView = paramView.toUser;
          ((com.tencent.mm.pluginsdk.j)localObject2).b(paramContext, paramView, ((EmojiInfo)((z.f)localObject1).SYG).getMd5(), ((EmojiInfo)((z.f)localObject1).SYG).UuL, (y.a)new a(this, (z.f)localObject1, paramContext));
          localObject2 = new doc();
          if (!SosSimilarUI.b(this.INK).gau()) {
            break label546;
          }
          paramContext = new StringBuilder("logid=17372&sessionid=").append(SosSimilarUI.b(this.INK).rjq).append("&searchid=").append(SosSimilarUI.b(this.INK).rjq).append("&scene=59&clickmd5=").append(((EmojiInfo)((z.f)localObject1).SYG).getMd5()).append("&querymd5=");
          paramac = SosSimilarUI.b(this.INK).INC;
          paramView = localStringBuilder;
          if (paramac != null) {
            paramView = paramac.emojiMD5;
          }
        }
      }
      for (((doc)localObject2).MRe = (paramView + "&offset=" + SosSimilarUI.b(this.INK).offset + "&pos=" + paramInt + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + SosSimilarUI.b(this.INK).rjq);; ((doc)localObject2).MRe = (paramView + "&sessionid=" + SosSimilarUI.b(this.INK).sessionId + "&nettype=" + ai.ait() + "&requestid=" + SosSimilarUI.b(this.INK).rjq + "&reqbusinesstype=256&pageno=" + ((h)paramac).gYe))
      {
        paramView = new ad((doc)localObject2);
        com.tencent.mm.kernel.g.azz().b((q)paramView);
        Log.i("MicroMsg.WebSearch.SosSimilarUI", ((doc)localObject2).MRe);
        AppMethodBeat.o(210293);
        return;
        paramView = null;
        break;
        localObject2 = (com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.j.class);
        paramView = SosSimilarUI.b(this.INK).INC;
        if (paramView != null) {}
        for (paramView = paramView.toUser;; paramView = null)
        {
          ((com.tencent.mm.pluginsdk.j)localObject2).b(paramContext, paramView, ((EmojiInfo)((z.f)localObject1).SYG).getMd5(), ((EmojiInfo)((z.f)localObject1).SYG).field_designerID, "", ((EmojiInfo)((z.f)localObject1).SYG).field_thumbUrl, (y.a)new b(this, (z.f)localObject1, paramContext));
          break;
        }
        label546:
        localStringBuilder = new StringBuilder("scene=78&searchid=").append(SosSimilarUI.b(this.INK).rjq).append("&businesstype=256&docid=").append(((h)paramac).gYd).append("&docpos=").append(paramInt).append("&typepos=0&ishomepage=0&clienttimestamp=").append(cl.aWA()).append("&sceneactiontype=1&query=");
        paramView = SosSimilarUI.b(this.INK).INC;
        if (paramView != null)
        {
          paramContext = paramView.query;
          paramView = paramContext;
          if (paramContext != null) {}
        }
        else
        {
          paramView = "";
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
    static final class a
      implements y.a
    {
      a(SosSimilarUI.d paramd, z.f paramf, Context paramContext) {}
      
      public final void a(boolean paramBoolean, String paramString, int paramInt)
      {
        AppMethodBeat.i(82499);
        if (paramBoolean)
        {
          paramString = com.tencent.mm.search.b.a.NJs;
          paramString = com.tencent.mm.search.b.a.gxq();
          if (paramString != null)
          {
            paramString = paramString.haC;
            if (paramString != null) {
              paramString.B((EmojiInfo)this.INM.SYG);
            }
          }
          com.tencent.mm.ui.base.u.makeText(paramContext, (CharSequence)paramContext.getString(2131755979), 1).show();
        }
        this.INL.INK.f((EmojiInfo)this.INM.SYG, paramBoolean);
        AppMethodBeat.o(82499);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
    static final class b
      implements y.a
    {
      b(SosSimilarUI.d paramd, z.f paramf, Context paramContext) {}
      
      public final void a(boolean paramBoolean, String paramString, int paramInt)
      {
        Object localObject2 = null;
        AppMethodBeat.i(210291);
        Object localObject3;
        if (paramBoolean)
        {
          localObject3 = k.cGf();
          localObject1 = SosSimilarUI.b(this.INL.INK).INC;
          if (localObject1 == null) {
            break label165;
          }
        }
        label165:
        for (Object localObject1 = ((SimilarEmojiQueryModel)localObject1).toUser;; localObject1 = null)
        {
          ((com.tencent.mm.plugin.emoji.e.f)localObject3).a((String)localObject1, (EmojiInfo)this.INM.SYG, null);
          if (!Util.isNullOrNil(paramString))
          {
            localObject3 = com.tencent.mm.plugin.messenger.a.g.eir();
            SimilarEmojiQueryModel localSimilarEmojiQueryModel = SosSimilarUI.b(this.INL.INK).INC;
            localObject1 = localObject2;
            if (localSimilarEmojiQueryModel != null) {
              localObject1 = localSimilarEmojiQueryModel.toUser;
            }
            ((com.tencent.mm.plugin.messenger.a.d)localObject3).iF(paramString, (String)localObject1);
          }
          com.tencent.mm.ui.base.u.makeText(paramContext, (CharSequence)paramContext.getString(2131755979), 1).show();
          this.INL.INK.f((EmojiInfo)this.INM.SYG, paramBoolean);
          AppMethodBeat.o(210291);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.SosSimilarUI
 * JD-Core Version:    0.7.0.1
 */