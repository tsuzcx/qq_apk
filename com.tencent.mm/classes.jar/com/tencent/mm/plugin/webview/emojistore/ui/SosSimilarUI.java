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
import com.tencent.mm.al.q;
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.g.b.a.ev;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.TouchableLayout;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$IOnLoadingStateChangedListener;", "()V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "emojiList", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiRecyclerView;", "lastClickTimestamp", "", "lastReportExposeStartPosition", "", "dp2px", "context", "Landroid/content/Context;", "dpValue", "", "getLayoutId", "getRecyclerViewPadding", "initHeadInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadMore", "parent", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "report18742", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "bOk", "", "reportExpose", "Companion", "plugin-webview_release"})
public final class SosSimilarUI
  extends MMActivity
  implements com.tencent.mm.al.f, SimilarEmojiLoadMoreRecyclerView.a
{
  public static final SosSimilarUI.a DJz;
  final c DJp;
  private final com.tencent.mm.search.d.a DJv;
  private SosSimilarEmojiRecyclerView DJw;
  private int DJx;
  private long DJy;
  
  static
  {
    AppMethodBeat.i(82509);
    DJz = new SosSimilarUI.a((byte)0);
    AppMethodBeat.o(82509);
  }
  
  public SosSimilarUI()
  {
    AppMethodBeat.i(82508);
    this.DJp = new c();
    this.DJv = new com.tencent.mm.search.d.a();
    AppMethodBeat.o(82508);
  }
  
  private final int eOa()
  {
    AppMethodBeat.i(82502);
    int i = al.getDeviceWidth();
    AppCompatActivity localAppCompatActivity = getContext();
    p.g(localAppCompatActivity, "context");
    i = (i - gQ((Context)localAppCompatActivity) * 3) / 8;
    ad.i("MicroMsg.WebSearch.SosSimilarUI", "recycler view padding :".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(82502);
      return i;
    }
    AppMethodBeat.o(82502);
    return 0;
  }
  
  private final void eeP()
  {
    AppMethodBeat.i(82504);
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (this.DJx < this.DJv.Iiz)
    {
      localObject1 = "";
      localObject2 = (Iterable)this.DJp.DJt;
      i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          d.a.j.gfB();
        }
        localObject3 = (h)localObject3;
        if ((i <= this.DJx) || (i > this.DJv.Iiz - 2)) {
          break label316;
        }
        localObject1 = (String)localObject1 + ((h)localObject3).gjb.Lb() + ';';
      }
    }
    label316:
    for (;;)
    {
      i += 1;
      break;
      localObject3 = new cup();
      StringBuilder localStringBuilder = new StringBuilder("logid=17368&sessionid=").append(this.DJp.pLL).append("&searchid=").append(this.DJp.pLL).append("&scene=59&md5=");
      localObject2 = this.DJp.DJs;
      if (localObject2 != null) {}
      for (localObject2 = ((SimilarEmojiQueryModel)localObject2).emojiMD5;; localObject2 = null)
      {
        ((cup)localObject3).Hmu = ((String)localObject2 + "&md5content=" + (String)localObject1 + "&pos=" + (this.DJx + 2) + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + this.DJp.pLL);
        localObject1 = new z((cup)localObject3);
        g.aiU().b((com.tencent.mm.al.n)localObject1);
        this.DJx = this.DJv.Iiz;
        ad.i("MicroMsg.WebSearch.SosSimilarUI", ((cup)localObject3).Hmu);
        AppMethodBeat.o(82504);
        return;
      }
    }
  }
  
  private static int gQ(Context paramContext)
  {
    AppMethodBeat.i(82507);
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    int i = (int)(paramContext.getDisplayMetrics().density * 108.0F + 0.5F);
    AppMethodBeat.o(82507);
    return i;
  }
  
  public final void eNY()
  {
    AppMethodBeat.i(82505);
    if (this.DJp.rKf)
    {
      SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.DJw;
      if (localSosSimilarEmojiRecyclerView == null) {
        break label64;
      }
      if (!localSosSimilarEmojiRecyclerView.eNX())
      {
        localSosSimilarEmojiRecyclerView = this.DJw;
        if (localSosSimilarEmojiRecyclerView != null) {
          localSosSimilarEmojiRecyclerView.showLoading(true);
        }
        this.DJp.d((com.tencent.mm.al.f)this);
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
    p.g(paramBundle, "window");
    paramBundle.getDecorView().setBackgroundColor(getResources().getColor(2131099679));
    paramBundle = getContext();
    p.g(paramBundle, "context");
    this.DJw = new SosSimilarEmojiRecyclerView((Context)new com.tencent.mm.ui.t((Context)paramBundle, 2131820870));
    paramBundle = this.DJw;
    if (paramBundle != null) {
      paramBundle.setBackgroundColor(getResources().getColor(2131099679));
    }
    paramBundle = this.DJw;
    if (paramBundle != null) {
      paramBundle.setOnLoadingStateChangedListener((SimilarEmojiLoadMoreRecyclerView.a)this);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    Object localObject = new TouchableLayout((Context)this);
    SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.DJw;
    if (localSosSimilarEmojiRecyclerView != null) {
      localSosSimilarEmojiRecyclerView.setPadding(eOa(), 0, eOa(), 0);
    }
    ((TouchableLayout)localObject).addView((View)this.DJw, (ViewGroup.LayoutParams)paramBundle);
    setContentView((View)localObject, (ViewGroup.LayoutParams)paramBundle);
    setMMTitle(getString(2131764070));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    getContext();
    paramBundle = new GridLayoutManager(3);
    paramBundle.a((GridLayoutManager.b)new c(this, paramBundle));
    localObject = this.DJw;
    if (localObject != null) {
      ((SosSimilarEmojiRecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    }
    paramBundle = this.DJw;
    if (paramBundle != null) {
      paramBundle.setItemViewCacheSize(0);
    }
    paramBundle = this.DJw;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.DJv);
    }
    this.DJv.gnv = ((com.tencent.mm.emoji.panel.a.n)new d(this));
    paramBundle = this.DJp;
    localObject = getIntent();
    p.g(localObject, "intent");
    p.h(localObject, "intent");
    g.aiU().a(2999, (com.tencent.mm.al.f)paramBundle);
    paramBundle.DJs = ((SimilarEmojiQueryModel)((Intent)localObject).getParcelableExtra("KEY_NET_PARAM"));
    this.DJv.Iiy = false;
    paramBundle = this.DJp.eNZ();
    if (paramBundle != null)
    {
      this.DJv.F(paramBundle);
      this.DJv.fmL();
    }
    this.DJv.notifyDataSetChanged();
    this.DJp.d((com.tencent.mm.al.f)this);
    paramBundle = com.tencent.mm.search.c.a.Iir;
    com.tencent.mm.search.c.a.fmD();
    AppMethodBeat.o(82501);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(82506);
    eeP();
    super.onDestroy();
    c localc = this.DJp;
    localc.callback = null;
    com.tencent.mm.kernel.b localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().cancel(2999);
    localb = g.ajB();
    p.g(localb, "MMKernel.network()");
    localb.aiU().b(2999, (com.tencent.mm.al.f)localc);
    AppMethodBeat.o(82506);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(82503);
    paramn = this.DJw;
    if (paramn != null) {
      paramn.showLoading(false);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((List)this.DJp.DJt).size() > 1))
    {
      paramInt1 = this.DJv.getItemCount();
      this.DJv.Iiy = true;
      this.DJv.V((List)this.DJp.DJt);
      if (paramInt1 - 2 <= 0)
      {
        this.DJv.notifyDataSetChanged();
        AppMethodBeat.o(82503);
        return;
      }
      this.DJv.cj(paramInt1 - 1);
    }
    for (;;)
    {
      eeP();
      AppMethodBeat.o(82503);
      return;
      ad.i("MicroMsg.WebSearch.SosSimilarUI", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + ' ');
      paramString = new ArrayList();
      this.DJv.setData((List)paramString);
      paramString = this.DJp.eNZ();
      if (paramString != null) {
        this.DJv.F(paramString);
      }
      this.DJv.fmM();
      this.DJv.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(SosSimilarUI paramSosSimilarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(82497);
      this.DJA.finish();
      AppMethodBeat.o(82497);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$2", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-webview_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(GridLayoutManager paramGridLayoutManager) {}
    
    public final int bW(int paramInt)
    {
      AppMethodBeat.i(82498);
      switch (SosSimilarUI.a(this.DJA).getItemViewType(paramInt))
      {
      case 101: 
      case 102: 
      case 103: 
      default: 
        AppMethodBeat.o(82498);
        return 1;
      }
      paramInt = paramBundle.jZ();
      AppMethodBeat.o(82498);
      return paramInt;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$3", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "plugin-webview_release"})
  public static final class d
    implements com.tencent.mm.emoji.panel.a.n
  {
    public final void a(final Context paramContext, int paramInt, ac paramac)
    {
      Object localObject1 = null;
      AppMethodBeat.i(82500);
      p.h(paramContext, "context");
      if ((paramac == null) || (!(paramac instanceof h)) || (((h)paramac).gkP != 103))
      {
        AppMethodBeat.o(82500);
        return;
      }
      if (System.currentTimeMillis() - SosSimilarUI.c(this.DJA) < 500L)
      {
        AppMethodBeat.o(82500);
        return;
      }
      SosSimilarUI.a(this.DJA, System.currentTimeMillis());
      Object localObject2 = com.tencent.mm.search.b.a.Iin;
      localObject2 = com.tencent.mm.search.b.a.fmA();
      if (localObject2 != null) {
        ((com.tencent.mm.search.b.c)localObject2).a(paramContext, paramInt, paramac);
      }
      localObject2 = new y.f();
      ((y.f)localObject2).MLV = ((h)paramac).gjb;
      Object localObject3 = (com.tencent.mm.pluginsdk.j)g.ab(com.tencent.mm.pluginsdk.j.class);
      paramac = SosSimilarUI.b(this.DJA).DJs;
      if (paramac != null) {}
      for (paramac = paramac.toUser;; paramac = null)
      {
        ((com.tencent.mm.pluginsdk.j)localObject3).b(paramContext, paramac, ((EmojiInfo)((y.f)localObject2).MLV).Lb(), ((EmojiInfo)((y.f)localObject2).MLV).Ofj, (y.a)new a(this, (y.f)localObject2, paramContext));
        paramac = new cup();
        localObject2 = new StringBuilder("logid=17372&sessionid=").append(SosSimilarUI.b(this.DJA).pLL).append("&searchid=").append(SosSimilarUI.b(this.DJA).pLL).append("&scene=59&clickmd5=").append(((EmojiInfo)((y.f)localObject2).MLV).Lb()).append("&querymd5=");
        localObject3 = SosSimilarUI.b(this.DJA).DJs;
        paramContext = localObject1;
        if (localObject3 != null) {
          paramContext = ((SimilarEmojiQueryModel)localObject3).emojiMD5;
        }
        paramac.Hmu = (paramContext + "&offset=" + SosSimilarUI.b(this.DJA).offset + "&pos=" + paramInt + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + SosSimilarUI.b(this.DJA).pLL);
        paramContext = new z(paramac);
        g.aiU().b((com.tencent.mm.al.n)paramContext);
        ad.i("MicroMsg.WebSearch.SosSimilarUI", paramac.Hmu);
        AppMethodBeat.o(82500);
        return;
      }
    }
    
    public final void a(View paramView, Context paramContext, int paramInt)
    {
      AppMethodBeat.i(207571);
      p.h(paramContext, "context");
      Object localObject2 = SosSimilarUI.a(this.DJA).mb(paramInt);
      int i;
      label82:
      Object localObject3;
      Object localObject1;
      if ((localObject2 instanceof h))
      {
        paramContext = k.getEmojiStorageMgr();
        p.g(paramContext, "SubCoreEmoji.getEmojiStorageMgr()");
        paramContext = paramContext.bIW().aUK(((h)localObject2).gjb.field_md5);
        if (paramContext == null) {
          break label419;
        }
        i = paramContext.getGroup();
        if (i != EmojiInfo.OeT) {
          break label425;
        }
        i = 1;
        localObject3 = new ev();
        ((ev)localObject3).Tk();
        ((ev)localObject3).nY(SosSimilarUI.b(this.DJA).pLL);
        ((ev)localObject3).nZ(SosSimilarUI.b(this.DJA).pLL);
        ((ev)localObject3).oa(((h)localObject2).gjb.field_md5);
        paramContext = SosSimilarUI.b(this.DJA).DJs;
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
        ((ev)localObject3).ob(paramContext);
        ((ev)localObject3).jZ(SosSimilarUI.b(this.DJA).offset);
        ((ev)localObject3).ka(paramInt);
        ((ev)localObject3).kb(System.currentTimeMillis());
        ((ev)localObject3).oc(SosSimilarUI.b(this.DJA).pLL);
        ((ev)localObject3).kc(1L);
        if (i == 0) {
          break label431;
        }
      }
      label419:
      label425:
      label431:
      for (long l = 1L;; l = 0L)
      {
        ((ev)localObject3).kd(l);
        ((ev)localObject3).aLk();
        paramContext = new StringBuilder("report19651 ");
        localObject1 = ((ev)localObject3).RE();
        p.g(localObject1, "struct.toShowString()");
        ad.i("MicroMsg.WebSearch.SosSimilarUI", d.n.n.h((String)localObject1, "\r\n", " ", false));
        if (i == 0)
        {
          paramContext = new com.tencent.mm.ui.widget.b.a((Context)this.DJA);
          localObject1 = (View.OnCreateContextMenuListener)new a((h)localObject2);
          localObject2 = (n.e)new b((Context)this.DJA, (h)localObject2, SosSimilarUI.b(this.DJA), paramInt);
          localObject3 = TouchableLayout.LrZ;
          paramInt = TouchableLayout.fQh();
          localObject3 = TouchableLayout.LrZ;
          paramContext.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (n.e)localObject2, paramInt, TouchableLayout.fQi());
        }
        AppMethodBeat.o(207571);
        return;
        i = 0;
        break;
        i = 0;
        break label82;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
    static final class a
      implements y.a
    {
      a(SosSimilarUI.d paramd, y.f paramf, Context paramContext) {}
      
      public final void a(boolean paramBoolean, String paramString, int paramInt)
      {
        AppMethodBeat.i(82499);
        if (paramBoolean)
        {
          paramString = com.tencent.mm.search.b.a.Iin;
          paramString = com.tencent.mm.search.b.a.fmA();
          if (paramString != null)
          {
            paramString = paramString.gnn;
            if (paramString != null) {
              paramString.B((EmojiInfo)this.DJD.MLV);
            }
          }
          com.tencent.mm.ui.base.t.makeText(paramContext, (CharSequence)paramContext.getString(2131755887), 1).show();
        }
        paramString = this.DJC.DJA;
        EmojiInfo localEmojiInfo = (EmojiInfo)this.DJD.MLV;
        p.h(localEmojiInfo, "emojiInfo");
        if (paramBoolean) {}
        for (paramInt = 1;; paramInt = 2)
        {
          e.ygI.f(18742, new Object[] { Integer.valueOf(59), paramString.DJp.pLL, paramString.DJp.pLL, paramString.DJp.pLL, Integer.valueOf(paramInt), localEmojiInfo.Lb() });
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