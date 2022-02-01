package com.tencent.mm.plugin.webview.emojistore.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.g.b.a.dx;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.TouchableLayout;
import d.g.b.v.f;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$IOnLoadingStateChangedListener;", "()V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "emojiList", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiRecyclerView;", "lastClickTimestamp", "", "lastReportExposeStartPosition", "", "dp2px", "context", "Landroid/content/Context;", "dpValue", "", "getLayoutId", "getRecyclerViewPadding", "initHeadInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadMore", "parent", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "report18742", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "bOk", "", "reportExpose", "Companion", "plugin-webview_release"})
public final class SosSimilarUI
  extends MMActivity
  implements com.tencent.mm.ak.g, SimilarEmojiLoadMoreRecyclerView.a
{
  public static final SosSimilarUI.a Cgw;
  final c Cgm;
  private final com.tencent.mm.search.d.a Cgs;
  private SosSimilarEmojiRecyclerView Cgt;
  private int Cgu;
  private long Cgv;
  
  static
  {
    AppMethodBeat.i(82509);
    Cgw = new SosSimilarUI.a((byte)0);
    AppMethodBeat.o(82509);
  }
  
  public SosSimilarUI()
  {
    AppMethodBeat.i(82508);
    this.Cgm = new c();
    this.Cgs = new com.tencent.mm.search.d.a();
    AppMethodBeat.o(82508);
  }
  
  private final void dSv()
  {
    AppMethodBeat.i(82504);
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (this.Cgu < this.Cgs.GwF)
    {
      localObject1 = "";
      localObject2 = (Iterable)this.Cgm.Cgq;
      i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          d.a.j.fOc();
        }
        localObject3 = (h)localObject3;
        if ((i <= this.Cgu) || (i > this.Cgs.GwF - 2)) {
          break label315;
        }
        localObject1 = (String)localObject1 + ((h)localObject3).fPB.JC() + ';';
      }
    }
    label315:
    for (;;)
    {
      i += 1;
      break;
      localObject3 = new cpk();
      StringBuilder localStringBuilder = new StringBuilder("logid=17368&sessionid=").append(this.Cgm.pik).append("&searchid=").append(this.Cgm.pik).append("&scene=59&md5=");
      localObject2 = this.Cgm.Cgp;
      if (localObject2 != null) {}
      for (localObject2 = ((SimilarEmojiQueryModel)localObject2).emojiMD5;; localObject2 = null)
      {
        ((cpk)localObject3).FCf = ((String)localObject2 + "&md5content=" + (String)localObject1 + "&pos=" + (this.Cgu + 2) + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + this.Cgm.pik);
        localObject1 = new v((cpk)localObject3);
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)localObject1);
        this.Cgu = this.Cgs.GwF;
        ac.i("MicroMsg.WebSearch.SosSimilarUI", ((cpk)localObject3).FCf);
        AppMethodBeat.o(82504);
        return;
      }
    }
  }
  
  private final int ezl()
  {
    AppMethodBeat.i(82502);
    int i = aj.getDeviceWidth();
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.k.g(localAppCompatActivity, "context");
    i = (i - gL((Context)localAppCompatActivity) * 3) / 8;
    ac.i("MicroMsg.WebSearch.SosSimilarUI", "recycler view padding :".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(82502);
      return i;
    }
    AppMethodBeat.o(82502);
    return 0;
  }
  
  private static int gL(Context paramContext)
  {
    AppMethodBeat.i(82507);
    paramContext = paramContext.getResources();
    d.g.b.k.g(paramContext, "context.resources");
    int i = (int)(paramContext.getDisplayMetrics().density * 108.0F + 0.5F);
    AppMethodBeat.o(82507);
    return i;
  }
  
  public final void ezj()
  {
    AppMethodBeat.i(82505);
    if (this.Cgm.qYO)
    {
      SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.Cgt;
      if (localSosSimilarEmojiRecyclerView == null) {
        break label64;
      }
      if (!localSosSimilarEmojiRecyclerView.ezi())
      {
        localSosSimilarEmojiRecyclerView = this.Cgt;
        if (localSosSimilarEmojiRecyclerView != null) {
          localSosSimilarEmojiRecyclerView.showLoading(true);
        }
        this.Cgm.d((com.tencent.mm.ak.g)this);
      }
    }
    AppMethodBeat.o(82505);
    return;
    label64:
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
    d.g.b.k.g(paramBundle, "window");
    paramBundle.getDecorView().setBackgroundColor(getResources().getColor(2131099679));
    paramBundle = getContext();
    d.g.b.k.g(paramBundle, "context");
    this.Cgt = new SosSimilarEmojiRecyclerView((Context)new com.tencent.mm.ui.t((Context)paramBundle, 2131820870));
    paramBundle = this.Cgt;
    if (paramBundle != null) {
      paramBundle.setBackgroundColor(getResources().getColor(2131099679));
    }
    paramBundle = this.Cgt;
    if (paramBundle != null) {
      paramBundle.setOnLoadingStateChangedListener((SimilarEmojiLoadMoreRecyclerView.a)this);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    Object localObject = new TouchableLayout((Context)this);
    SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.Cgt;
    if (localSosSimilarEmojiRecyclerView != null) {
      localSosSimilarEmojiRecyclerView.setPadding(ezl(), 0, ezl(), 0);
    }
    ((TouchableLayout)localObject).addView((View)this.Cgt, (ViewGroup.LayoutParams)paramBundle);
    setContentView((View)localObject, (ViewGroup.LayoutParams)paramBundle);
    setMMTitle(getString(2131764070));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    getContext();
    paramBundle = new GridLayoutManager(3);
    paramBundle.a((GridLayoutManager.b)new c(this, paramBundle));
    localObject = this.Cgt;
    if (localObject != null) {
      ((SosSimilarEmojiRecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    }
    paramBundle = this.Cgt;
    if (paramBundle != null) {
      paramBundle.setItemViewCacheSize(0);
    }
    paramBundle = this.Cgt;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.Cgs);
    }
    this.Cgs.fTR = ((com.tencent.mm.emoji.panel.a.n)new d(this));
    paramBundle = this.Cgm;
    localObject = getIntent();
    d.g.b.k.g(localObject, "intent");
    d.g.b.k.h(localObject, "intent");
    com.tencent.mm.kernel.g.agi().a(2999, (com.tencent.mm.ak.g)paramBundle);
    paramBundle.Cgp = ((SimilarEmojiQueryModel)((Intent)localObject).getParcelableExtra("KEY_NET_PARAM"));
    this.Cgs.GwE = false;
    paramBundle = this.Cgm.ezk();
    if (paramBundle != null)
    {
      this.Cgs.G(paramBundle);
      this.Cgs.eXb();
    }
    this.Cgs.notifyDataSetChanged();
    this.Cgm.d((com.tencent.mm.ak.g)this);
    paramBundle = com.tencent.mm.search.c.a.Gwx;
    com.tencent.mm.search.c.a.eWT();
    AppMethodBeat.o(82501);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(82506);
    dSv();
    super.onDestroy();
    c localc = this.Cgm;
    localc.callback = null;
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().cancel(2999);
    localb = com.tencent.mm.kernel.g.agQ();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.agi().b(2999, (com.tencent.mm.ak.g)localc);
    AppMethodBeat.o(82506);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(82503);
    paramn = this.Cgt;
    if (paramn != null) {
      paramn.showLoading(false);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((List)this.Cgm.Cgq).size() > 1))
    {
      paramInt1 = this.Cgs.getItemCount();
      this.Cgs.GwE = true;
      this.Cgs.U((List)this.Cgm.Cgq);
      if (paramInt1 - 2 <= 0)
      {
        this.Cgs.notifyDataSetChanged();
        AppMethodBeat.o(82503);
        return;
      }
      this.Cgs.cj(paramInt1 - 1);
    }
    for (;;)
    {
      dSv();
      AppMethodBeat.o(82503);
      return;
      ac.i("MicroMsg.WebSearch.SosSimilarUI", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + ' ');
      paramString = new ArrayList();
      this.Cgs.setData((List)paramString);
      paramString = this.Cgm.ezk();
      if (paramString != null) {
        this.Cgs.G(paramString);
      }
      this.Cgs.eXc();
      this.Cgs.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(SosSimilarUI paramSosSimilarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(82497);
      this.Cgx.finish();
      AppMethodBeat.o(82497);
      return false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$2", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-webview_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(GridLayoutManager paramGridLayoutManager) {}
    
    public final int bW(int paramInt)
    {
      AppMethodBeat.i(82498);
      switch (SosSimilarUI.a(this.Cgx).getItemViewType(paramInt))
      {
      case 101: 
      case 102: 
      case 103: 
      default: 
        AppMethodBeat.o(82498);
        return 1;
      }
      paramInt = paramBundle.jJ();
      AppMethodBeat.o(82498);
      return paramInt;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$3", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "plugin-webview_release"})
  public static final class d
    implements com.tencent.mm.emoji.panel.a.n
  {
    public final void a(final Context paramContext, int paramInt, y paramy)
    {
      Object localObject1 = null;
      AppMethodBeat.i(82500);
      d.g.b.k.h(paramContext, "context");
      if ((paramy == null) || (!(paramy instanceof h)) || (((h)paramy).fRp != 103))
      {
        AppMethodBeat.o(82500);
        return;
      }
      if (System.currentTimeMillis() - SosSimilarUI.c(this.Cgx) < 500L)
      {
        AppMethodBeat.o(82500);
        return;
      }
      SosSimilarUI.a(this.Cgx, System.currentTimeMillis());
      Object localObject2 = com.tencent.mm.search.b.a.Gwt;
      localObject2 = com.tencent.mm.search.b.a.eWQ();
      if (localObject2 != null) {
        ((com.tencent.mm.search.b.c)localObject2).a(paramContext, paramInt, paramy);
      }
      localObject2 = new v.f();
      ((v.f)localObject2).KUQ = ((h)paramy).fPB;
      Object localObject3 = (i)com.tencent.mm.kernel.g.ab(i.class);
      paramy = SosSimilarUI.b(this.Cgx).Cgp;
      if (paramy != null) {}
      for (paramy = paramy.toUser;; paramy = null)
      {
        ((i)localObject3).b(paramContext, paramy, ((EmojiInfo)((v.f)localObject2).KUQ).JC(), ((EmojiInfo)((v.f)localObject2).KUQ).Kgn, (y.a)new a(this, (v.f)localObject2, paramContext));
        paramy = new cpk();
        localObject2 = new StringBuilder("logid=17372&sessionid=").append(SosSimilarUI.b(this.Cgx).pik).append("&searchid=").append(SosSimilarUI.b(this.Cgx).pik).append("&scene=59&clickmd5=").append(((EmojiInfo)((v.f)localObject2).KUQ).JC()).append("&querymd5=");
        localObject3 = SosSimilarUI.b(this.Cgx).Cgp;
        paramContext = localObject1;
        if (localObject3 != null) {
          paramContext = ((SimilarEmojiQueryModel)localObject3).emojiMD5;
        }
        paramy.FCf = (paramContext + "&offset=" + SosSimilarUI.b(this.Cgx).offset + "&pos=" + paramInt + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + SosSimilarUI.b(this.Cgx).pik);
        paramContext = new v(paramy);
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)paramContext);
        ac.i("MicroMsg.WebSearch.SosSimilarUI", paramy.FCf);
        AppMethodBeat.o(82500);
        return;
      }
    }
    
    public final void a(View paramView, Context paramContext, int paramInt)
    {
      AppMethodBeat.i(189444);
      d.g.b.k.h(paramContext, "context");
      Object localObject2 = SosSimilarUI.a(this.Cgx).lB(paramInt);
      int i;
      label82:
      Object localObject3;
      Object localObject1;
      if ((localObject2 instanceof h))
      {
        paramContext = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr();
        d.g.b.k.g(paramContext, "SubCoreEmoji.getEmojiStorageMgr()");
        paramContext = paramContext.bEN().aOT(((h)localObject2).fPB.field_md5);
        if (paramContext == null) {
          break label419;
        }
        i = paramContext.getGroup();
        if (i != EmojiInfo.Jsy) {
          break label425;
        }
        i = 1;
        localObject3 = new dx();
        ((dx)localObject3).Rd();
        ((dx)localObject3).lO(SosSimilarUI.b(this.Cgx).pik);
        ((dx)localObject3).lP(SosSimilarUI.b(this.Cgx).pik);
        ((dx)localObject3).lQ(((h)localObject2).fPB.field_md5);
        paramContext = SosSimilarUI.b(this.Cgx).Cgp;
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
        ((dx)localObject3).lR(paramContext);
        ((dx)localObject3).in(SosSimilarUI.b(this.Cgx).offset);
        ((dx)localObject3).io(paramInt);
        ((dx)localObject3).ip(System.currentTimeMillis());
        ((dx)localObject3).lS(SosSimilarUI.b(this.Cgx).pik);
        ((dx)localObject3).iq(1L);
        if (i == 0) {
          break label431;
        }
      }
      label419:
      label425:
      label431:
      for (long l = 1L;; l = 0L)
      {
        ((dx)localObject3).ir(l);
        ((dx)localObject3).aHZ();
        paramContext = new StringBuilder("report19651 ");
        localObject1 = ((dx)localObject3).PS();
        d.g.b.k.g(localObject1, "struct.toShowString()");
        ac.i("MicroMsg.WebSearch.SosSimilarUI", d.n.n.h((String)localObject1, "\r\n", " ", false));
        if (i == 0)
        {
          paramContext = new com.tencent.mm.ui.widget.b.a((Context)this.Cgx);
          localObject1 = (View.OnCreateContextMenuListener)new a((h)localObject2);
          localObject2 = (n.d)new b((Context)this.Cgx, (h)localObject2, SosSimilarUI.b(this.Cgx), paramInt);
          localObject3 = TouchableLayout.JyS;
          paramInt = TouchableLayout.fyY();
          localObject3 = TouchableLayout.JyS;
          paramContext.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (n.d)localObject2, paramInt, TouchableLayout.fyZ());
        }
        AppMethodBeat.o(189444);
        return;
        i = 0;
        break;
        i = 0;
        break label82;
      }
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
    static final class a
      implements y.a
    {
      a(SosSimilarUI.d paramd, v.f paramf, Context paramContext) {}
      
      public final void a(boolean paramBoolean, String paramString, int paramInt)
      {
        AppMethodBeat.i(82499);
        if (paramBoolean)
        {
          paramString = com.tencent.mm.search.b.a.Gwt;
          paramString = com.tencent.mm.search.b.a.eWQ();
          if (paramString != null)
          {
            paramString = paramString.fTJ;
            if (paramString != null) {
              paramString.B((EmojiInfo)this.CgA.KUQ);
            }
          }
          com.tencent.mm.ui.base.t.makeText(paramContext, (CharSequence)paramContext.getString(2131755887), 1).show();
        }
        paramString = this.Cgz.Cgx;
        EmojiInfo localEmojiInfo = (EmojiInfo)this.CgA.KUQ;
        d.g.b.k.h(localEmojiInfo, "emojiInfo");
        if (paramBoolean) {}
        for (paramInt = 1;; paramInt = 2)
        {
          e.wTc.f(18742, new Object[] { Integer.valueOf(59), paramString.Cgm.pik, paramString.Cgm.pik, paramString.Cgm.pik, Integer.valueOf(paramInt), localEmojiInfo.JC() });
          AppMethodBeat.o(82499);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.SosSimilarUI
 * JD-Core Version:    0.7.0.1
 */