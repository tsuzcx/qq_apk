package com.tencent.mm.plugin.webview.emojistore.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.panel.a.e;
import com.tencent.mm.f.b.a.kn;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.messenger.a.d;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.c.c;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.c.j;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.ein;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.x;
import com.tencent.mm.view.TouchableLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$IOnLoadingStateChangedListener;", "()V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "emojiList", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiRecyclerView;", "lastClickTimestamp", "", "lastReportExposeStartPosition", "", "dp2px", "context", "Landroid/content/Context;", "dpValue", "", "getLayoutId", "getRecyclerViewPadding", "getReportScene", "initHeadInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadMore", "parent", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "report18742", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "bOk", "", "reportExpose", "Companion", "plugin-webview_release"})
public final class SosSimilarUI
  extends MMSecDataActivity
  implements i, SimilarEmojiLoadMoreRecyclerView.a
{
  public static final SosSimilarUI.a PKb;
  private final c PJS;
  private final com.tencent.mm.search.d.a PJX;
  private SosSimilarEmojiRecyclerView PJY;
  private int PJZ;
  private long PKa;
  
  static
  {
    AppMethodBeat.i(82509);
    PKb = new SosSimilarUI.a((byte)0);
    AppMethodBeat.o(82509);
  }
  
  public SosSimilarUI()
  {
    AppMethodBeat.i(82508);
    this.PJS = new c();
    this.PJX = new com.tencent.mm.search.d.a();
    AppMethodBeat.o(82508);
  }
  
  private final void cBa()
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(82504);
    dxu localdxu;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.PJZ < this.PJX.uJL)
    {
      localdxu = new dxu();
      if (!this.PJS.gTo()) {
        break label334;
      }
      localObject1 = "";
      localObject2 = ((Iterable)this.PJS.MGI).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject3 = (com.tencent.mm.emoji.b.b.h)localObject3;
        if ((i <= this.PJZ) || (i > this.PJX.uJL - 2)) {
          break label597;
        }
        localObject1 = (String)localObject1 + ((com.tencent.mm.emoji.b.b.h)localObject3).jHh.getMd5() + ';';
      }
    }
    label334:
    label594:
    label597:
    for (;;)
    {
      i += 1;
      break;
      localObject3 = new StringBuilder("logid=17368&sessionid=").append(this.PJS.uMC).append("&searchid=").append(this.PJS.uMC).append("&scene=59&md5=");
      localObject2 = this.PJS.PJV;
      if (localObject2 != null) {}
      for (localObject2 = ((SimilarEmojiQueryModel)localObject2).emojiMD5;; localObject2 = null)
      {
        localdxu.Udk = ((String)localObject2 + "&md5content=" + (String)localObject1 + "&pos=" + (this.PJZ + 2) + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + this.PJS.uMC);
        localObject1 = new ad(localdxu);
        com.tencent.mm.kernel.h.aGY().b((q)localObject1);
        this.PJZ = this.PJX.uJL;
        Log.i("MicroMsg.WebSearch.SosSimilarUI", localdxu.Udk);
        AppMethodBeat.o(82504);
        return;
      }
      localObject1 = "";
      localObject2 = ((Iterable)this.PJS.MGI).iterator();
      i = j;
      label356:
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject3 = (com.tencent.mm.emoji.b.b.h)localObject3;
        if ((i <= this.PJZ) || (i > this.PJX.uJL - 2)) {
          break label594;
        }
        localObject1 = (String)localObject1 + "256:" + ((com.tencent.mm.emoji.b.b.h)localObject3).jJd + ':' + cm.bfE() + ';';
      }
      for (;;)
      {
        i += 1;
        break label356;
        localObject3 = new StringBuilder("isexpose=1&searchid=").append(this.PJS.uMC).append("&content=").append((String)localObject1).append("&query=");
        localObject1 = this.PJS.PJV;
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
        localdxu.Udk = ((String)localObject1 + "&ishomepage=0&&sessionid=" + this.PJS.sessionId + "&scene=78&logtype=1&requestid=" + this.PJS.uMC + "&pageno=" + this.PJS.jJe);
        break;
      }
    }
  }
  
  private final int gTp()
  {
    AppMethodBeat.i(82502);
    int i = com.tencent.mm.ui.ar.getDeviceWidth();
    AppCompatActivity localAppCompatActivity = getContext();
    kotlin.g.b.p.j(localAppCompatActivity, "context");
    i = (i - iW((Context)localAppCompatActivity) * 3) / 8;
    Log.i("MicroMsg.WebSearch.SosSimilarUI", "recycler view padding :".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(82502);
      return i;
    }
    AppMethodBeat.o(82502);
    return 0;
  }
  
  private static int iW(Context paramContext)
  {
    AppMethodBeat.i(82507);
    paramContext = paramContext.getResources();
    kotlin.g.b.p.j(paramContext, "context.resources");
    int i = (int)(paramContext.getDisplayMetrics().density * 108.0F + 0.5F);
    AppMethodBeat.o(82507);
    return i;
  }
  
  public final int eBv()
  {
    AppMethodBeat.i(253471);
    if (this.PJS.gTo())
    {
      AppMethodBeat.o(253471);
      return 59;
    }
    AppMethodBeat.o(253471);
    return 78;
  }
  
  public final void f(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(253474);
    kotlin.g.b.p.k(paramEmojiInfo, "emojiInfo");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.report.f.Iyx.a(18742, new Object[] { Integer.valueOf(eBv()), this.PJS.uMC, this.PJS.uMC, this.PJS.uMC, Integer.valueOf(i), paramEmojiInfo.getMd5() });
      AppMethodBeat.o(253474);
      return;
    }
  }
  
  public final void gTm()
  {
    AppMethodBeat.i(253486);
    if (this.PJS.xcp)
    {
      SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.PJY;
      if (localSosSimilarEmojiRecyclerView == null) {
        break label68;
      }
      if (!localSosSimilarEmojiRecyclerView.gTl())
      {
        localSosSimilarEmojiRecyclerView = this.PJY;
        if (localSosSimilarEmojiRecyclerView != null) {
          localSosSimilarEmojiRecyclerView.showLoading(true);
        }
        cBa();
        this.PJS.e((i)this);
      }
    }
    AppMethodBeat.o(253486);
    return;
    label68:
    AppMethodBeat.o(253486);
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
    kotlin.g.b.p.j(paramBundle, "window");
    paramBundle.getDecorView().setBackgroundColor(getResources().getColor(c.c.BW_93));
    Object localObject2 = this.PJS;
    paramBundle = (Context)this;
    Object localObject1 = getIntent();
    kotlin.g.b.p.j(localObject1, "intent");
    kotlin.g.b.p.k(paramBundle, "context");
    kotlin.g.b.p.k(localObject1, "intent");
    com.tencent.mm.kernel.h.aGY().a(2999, (i)localObject2);
    com.tencent.mm.kernel.h.aGY().a(719, (i)localObject2);
    ((c)localObject2).PJV = ((SimilarEmojiQueryModel)((Intent)localObject1).getParcelableExtra("KEY_NET_PARAM"));
    localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    paramBundle = a.a.hU(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = (ein)paramBundle.c(1, ein.class);
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
    kotlin.g.b.p.j(paramBundle, "context");
    this.PJY = new SosSimilarEmojiRecyclerView((Context)new x((Context)paramBundle, c.j.EmojiPanel));
    paramBundle = this.PJY;
    if (paramBundle != null) {
      paramBundle.setBackgroundColor(getResources().getColor(c.c.BW_93));
    }
    paramBundle = this.PJY;
    if (paramBundle != null) {
      paramBundle.setOnLoadingStateChangedListener((SimilarEmojiLoadMoreRecyclerView.a)this);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    localObject1 = new TouchableLayout((Context)this);
    localObject2 = this.PJY;
    if (localObject2 != null) {
      ((SosSimilarEmojiRecyclerView)localObject2).setPadding(gTp(), 0, gTp(), 0);
    }
    ((TouchableLayout)localObject1).addView((View)this.PJY, (ViewGroup.LayoutParams)paramBundle);
    setContentView((View)localObject1, (ViewGroup.LayoutParams)paramBundle);
    paramBundle = this.PJS.PJV;
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
    paramBundle = MMApplicationContext.getContext().getString(c.i.sos_similar_emoji_title);
    kotlin.g.b.p.j(paramBundle, "run {\n            MMAppl…ar_emoji_title)\n        }");
    label386:
    setMMTitle(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    getContext();
    paramBundle = new GridLayoutManager(3);
    paramBundle.a((GridLayoutManager.b)new c(this, paramBundle));
    localObject1 = this.PJY;
    if (localObject1 != null) {
      ((SosSimilarEmojiRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
    }
    paramBundle = this.PJY;
    if (paramBundle != null) {
      paramBundle.setItemViewCacheSize(0);
    }
    paramBundle = this.PJY;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.PJX);
    }
    this.PJX.jLP = ((com.tencent.mm.emoji.panel.a.p)new d(this));
    this.PJX.UXc = false;
    paramBundle = this.PJS.gTn();
    if (paramBundle != null)
    {
      if (!this.PJS.gTo()) {
        break label582;
      }
      this.PJX.G(paramBundle);
    }
    for (;;)
    {
      this.PJX.htz();
      this.PJX.notifyDataSetChanged();
      this.PJS.e((i)this);
      paramBundle = com.tencent.mm.search.c.a.UWW;
      com.tencent.mm.search.c.a.htr();
      AppMethodBeat.o(82501);
      return;
      label582:
      this.PJX.H(paramBundle);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(82506);
    cBa();
    super.onDestroy();
    c localc = this.PJS;
    localc.callback = null;
    com.tencent.mm.kernel.c localc1 = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localc1, "MMKernel.network()");
    localc1.aGY().cancel(2999);
    localc1 = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localc1, "MMKernel.network()");
    localc1.aGY().b(2999, (i)localc);
    localc1 = com.tencent.mm.kernel.h.aHF();
    kotlin.g.b.p.j(localc1, "MMKernel.network()");
    localc1.aGY().cancel(719);
    com.tencent.mm.kernel.h.aGY().b(719, (i)localc);
    AppMethodBeat.o(82506);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(82503);
    paramq = this.PJY;
    if (paramq != null) {
      paramq.showLoading(false);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((List)this.PJS.MGI).size() > 1))
    {
      paramInt1 = this.PJX.getItemCount();
      this.PJX.UXc = true;
      this.PJX.aa((List)this.PJS.MGI);
      if (paramInt1 - 2 <= 0)
      {
        this.PJX.notifyDataSetChanged();
        AppMethodBeat.o(82503);
        return;
      }
      this.PJX.cL(paramInt1 - 1);
      cBa();
      AppMethodBeat.o(82503);
      return;
    }
    Log.i("MicroMsg.WebSearch.SosSimilarUI", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + ' ');
    paramString = new ArrayList();
    this.PJX.setData((List)paramString);
    paramString = this.PJS.gTn();
    if (paramString != null)
    {
      if (!this.PJS.gTo()) {
        break label237;
      }
      this.PJX.G(paramString);
    }
    for (;;)
    {
      this.PJX.htA();
      this.PJX.notifyDataSetChanged();
      break;
      label237:
      this.PJX.H(paramString);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(SosSimilarUI paramSosSimilarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(82497);
      this.PKc.finish();
      AppMethodBeat.o(82497);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$2", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-webview_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(GridLayoutManager paramGridLayoutManager) {}
    
    public final int cx(int paramInt)
    {
      AppMethodBeat.i(82498);
      switch (SosSimilarUI.a(this.PKc).getItemViewType(paramInt))
      {
      case 101: 
      case 102: 
      case 103: 
      default: 
        AppMethodBeat.o(82498);
        return 1;
      }
      paramInt = paramBundle.ku();
      AppMethodBeat.o(82498);
      return paramInt;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$3", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "plugin-webview_release"})
  public static final class d
    implements com.tencent.mm.emoji.panel.a.p
  {
    public final void a(View paramView, Context paramContext, int paramInt)
    {
      AppMethodBeat.i(260646);
      kotlin.g.b.p.k(paramContext, "context");
      Object localObject2 = SosSimilarUI.a(this.PKc).rF(paramInt);
      int i;
      label82:
      Object localObject3;
      Object localObject1;
      if ((localObject2 instanceof com.tencent.mm.emoji.b.b.h))
      {
        paramContext = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr();
        kotlin.g.b.p.j(paramContext, "SubCoreEmoji.getEmojiStorageMgr()");
        paramContext = paramContext.ctY().bxK(((com.tencent.mm.emoji.b.b.h)localObject2).jHh.field_md5);
        if (paramContext == null) {
          break label384;
        }
        i = paramContext.hBy();
        if (i != EmojiInfo.YCD) {
          break label390;
        }
        i = 1;
        localObject3 = new kn();
        ((kn)localObject3).vc(this.PKc.eBv());
        ((kn)localObject3).By(SosSimilarUI.b(this.PKc).sessionId);
        ((kn)localObject3).Bz(SosSimilarUI.b(this.PKc).uMC);
        ((kn)localObject3).BA(((com.tencent.mm.emoji.b.b.h)localObject2).jHh.field_md5);
        paramContext = SosSimilarUI.b(this.PKc).PJV;
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
        ((kn)localObject3).BB(paramContext);
        ((kn)localObject3).vd(SosSimilarUI.b(this.PKc).offset);
        ((kn)localObject3).ve(paramInt);
        ((kn)localObject3).vf(System.currentTimeMillis());
        ((kn)localObject3).BC(SosSimilarUI.b(this.PKc).uMC);
        ((kn)localObject3).vg(1L);
        if (i == 0) {
          break label396;
        }
      }
      label384:
      label390:
      label396:
      for (long l = 1L;; l = 0L)
      {
        ((kn)localObject3).vh(l);
        ((kn)localObject3).bpa();
        com.tencent.mm.plugin.websearch.api.ar.a((com.tencent.mm.plugin.report.a)localObject3);
        if (i == 0)
        {
          paramContext = new com.tencent.mm.ui.widget.b.a((Context)this.PKc);
          localObject1 = (View.OnCreateContextMenuListener)new a((com.tencent.mm.emoji.b.b.h)localObject2);
          localObject2 = (q.g)new b((Context)this.PKc, (com.tencent.mm.emoji.b.b.h)localObject2, SosSimilarUI.b(this.PKc), paramInt);
          localObject3 = TouchableLayout.YOD;
          paramInt = TouchableLayout.igZ();
          localObject3 = TouchableLayout.YOD;
          paramContext.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (q.g)localObject2, paramInt, TouchableLayout.iha());
        }
        AppMethodBeat.o(260646);
        return;
        i = 0;
        break;
        i = 0;
        break label82;
      }
    }
    
    public final void a(View paramView, final Context paramContext, int paramInt, ae paramae)
    {
      StringBuilder localStringBuilder = null;
      AppMethodBeat.i(260648);
      kotlin.g.b.p.k(paramContext, "context");
      if ((paramae == null) || (!(paramae instanceof com.tencent.mm.emoji.b.b.h)) || (((com.tencent.mm.emoji.b.b.h)paramae).jJc != 103))
      {
        AppMethodBeat.o(260648);
        return;
      }
      if (System.currentTimeMillis() - SosSimilarUI.c(this.PKc) < 500L)
      {
        AppMethodBeat.o(260648);
        return;
      }
      SosSimilarUI.a(this.PKc, System.currentTimeMillis());
      Object localObject1 = com.tencent.mm.search.b.a.UWT;
      localObject1 = com.tencent.mm.search.b.a.hto();
      if (localObject1 != null) {
        ((com.tencent.mm.search.b.c)localObject1).a(paramView, paramContext, paramInt, paramae);
      }
      localObject1 = new aa.f();
      ((aa.f)localObject1).aaBC = ((com.tencent.mm.emoji.b.b.h)paramae).jHh;
      Object localObject2;
      if (SosSimilarUI.b(this.PKc).gTo())
      {
        localObject2 = (com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.j.class);
        paramView = SosSimilarUI.b(this.PKc).PJV;
        if (paramView != null)
        {
          paramView = paramView.toUser;
          ((com.tencent.mm.pluginsdk.j)localObject2).c(paramContext, paramView, ((EmojiInfo)((aa.f)localObject1).aaBC).getMd5(), ((EmojiInfo)((aa.f)localObject1).aaBC).ZuN, (y.a)new a(this, (aa.f)localObject1, paramContext));
          localObject2 = new dxu();
          if (!SosSimilarUI.b(this.PKc).gTo()) {
            break label546;
          }
          paramContext = new StringBuilder("logid=17372&sessionid=").append(SosSimilarUI.b(this.PKc).uMC).append("&searchid=").append(SosSimilarUI.b(this.PKc).uMC).append("&scene=59&clickmd5=").append(((EmojiInfo)((aa.f)localObject1).aaBC).getMd5()).append("&querymd5=");
          paramae = SosSimilarUI.b(this.PKc).PJV;
          paramView = localStringBuilder;
          if (paramae != null) {
            paramView = paramae.emojiMD5;
          }
        }
      }
      for (((dxu)localObject2).Udk = (paramView + "&offset=" + SosSimilarUI.b(this.PKc).offset + "&pos=" + paramInt + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + SosSimilarUI.b(this.PKc).uMC);; ((dxu)localObject2).Udk = (paramView + "&sessionid=" + SosSimilarUI.b(this.PKc).sessionId + "&nettype=" + ai.anV() + "&requestid=" + SosSimilarUI.b(this.PKc).uMC + "&reqbusinesstype=256&pageno=" + ((com.tencent.mm.emoji.b.b.h)paramae).jJe))
      {
        paramView = new ad((dxu)localObject2);
        com.tencent.mm.kernel.h.aGY().b((q)paramView);
        Log.i("MicroMsg.WebSearch.SosSimilarUI", ((dxu)localObject2).Udk);
        AppMethodBeat.o(260648);
        return;
        paramView = null;
        break;
        localObject2 = (com.tencent.mm.pluginsdk.j)com.tencent.mm.kernel.h.ae(com.tencent.mm.pluginsdk.j.class);
        paramView = SosSimilarUI.b(this.PKc).PJV;
        if (paramView != null) {}
        for (paramView = paramView.toUser;; paramView = null)
        {
          ((com.tencent.mm.pluginsdk.j)localObject2).b(paramContext, paramView, ((EmojiInfo)((aa.f)localObject1).aaBC).getMd5(), ((EmojiInfo)((aa.f)localObject1).aaBC).field_designerID, "", ((EmojiInfo)((aa.f)localObject1).aaBC).field_thumbUrl, (y.a)new b(this, (aa.f)localObject1, paramContext));
          break;
        }
        label546:
        localStringBuilder = new StringBuilder("scene=78&searchid=").append(SosSimilarUI.b(this.PKc).uMC).append("&businesstype=256&docid=").append(((com.tencent.mm.emoji.b.b.h)paramae).jJd).append("&docpos=").append(paramInt).append("&typepos=0&ishomepage=0&clienttimestamp=").append(cm.bfE()).append("&sceneactiontype=1&query=");
        paramView = SosSimilarUI.b(this.PKc).PJV;
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
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
    static final class a
      implements y.a
    {
      a(SosSimilarUI.d paramd, aa.f paramf, Context paramContext) {}
      
      public final void a(boolean paramBoolean, String paramString, int paramInt)
      {
        AppMethodBeat.i(82499);
        if (paramBoolean)
        {
          paramString = com.tencent.mm.search.b.a.UWT;
          paramString = com.tencent.mm.search.b.a.hto();
          if (paramString != null)
          {
            paramString = paramString.jLH;
            if (paramString != null) {
              paramString.o((EmojiInfo)this.PKe.aaBC);
            }
          }
          w.makeText(paramContext, (CharSequence)paramContext.getString(c.i.app_sent), 1).show();
        }
        this.PKd.PKc.f((EmojiInfo)this.PKe.aaBC, paramBoolean);
        AppMethodBeat.o(82499);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
    static final class b
      implements y.a
    {
      b(SosSimilarUI.d paramd, aa.f paramf, Context paramContext) {}
      
      public final void a(boolean paramBoolean, String paramString, int paramInt)
      {
        Object localObject2 = null;
        AppMethodBeat.i(267708);
        Object localObject3;
        if (paramBoolean)
        {
          localObject3 = com.tencent.mm.plugin.emoji.model.p.cUO();
          localObject1 = SosSimilarUI.b(this.PKd.PKc).PJV;
          if (localObject1 == null) {
            break label166;
          }
        }
        label166:
        for (Object localObject1 = ((SimilarEmojiQueryModel)localObject1).toUser;; localObject1 = null)
        {
          ((com.tencent.mm.plugin.emoji.e.f)localObject3).a((String)localObject1, (EmojiInfo)this.PKe.aaBC, null);
          if (!Util.isNullOrNil(paramString))
          {
            localObject3 = g.eRW();
            SimilarEmojiQueryModel localSimilarEmojiQueryModel = SosSimilarUI.b(this.PKd.PKc).PJV;
            localObject1 = localObject2;
            if (localSimilarEmojiQueryModel != null) {
              localObject1 = localSimilarEmojiQueryModel.toUser;
            }
            ((d)localObject3).iQ(paramString, (String)localObject1);
          }
          w.makeText(paramContext, (CharSequence)paramContext.getString(c.i.app_sent), 1).show();
          this.PKd.PKc.f((EmojiInfo)this.PKe.aaBC, paramBoolean);
          AppMethodBeat.o(267708);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.SosSimilarUI
 * JD-Core Version:    0.7.0.1
 */