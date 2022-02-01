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
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.a.a.y;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.g.b.a.cj;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.w;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s;
import com.tencent.mm.view.TouchableLayout;
import d.g.b.v.e;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$IOnLoadingStateChangedListener;", "()V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "emojiList", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiRecyclerView;", "lastClickTimestamp", "", "lastReportExposeStartPosition", "", "dp2px", "context", "Landroid/content/Context;", "dpValue", "", "getLayoutId", "getRecyclerViewPadding", "initHeadInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadMore", "parent", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "report18742", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "bOk", "", "reportExpose", "Companion", "plugin-webview_release"})
public final class SosSimilarUI
  extends MMActivity
  implements com.tencent.mm.al.g, SimilarEmojiLoadMoreRecyclerView.a
{
  public static final a AOe;
  final c ANU;
  private final com.tencent.mm.search.c.a AOa;
  private SosSimilarEmojiRecyclerView AOb;
  private int AOc;
  private long AOd;
  
  static
  {
    AppMethodBeat.i(82509);
    AOe = new a((byte)0);
    AppMethodBeat.o(82509);
  }
  
  public SosSimilarUI()
  {
    AppMethodBeat.i(82508);
    this.ANU = new c();
    this.AOa = new com.tencent.mm.search.c.a();
    AppMethodBeat.o(82508);
  }
  
  private final void dDX()
  {
    AppMethodBeat.i(82504);
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (this.AOc < this.AOa.EZq)
    {
      localObject1 = "";
      localObject2 = (Iterable)this.ANU.ANY;
      i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          d.a.j.fvx();
        }
        localObject3 = (h)localObject3;
        if ((i <= this.AOc) || (i > this.AOa.EZq - 2)) {
          break label315;
        }
        localObject1 = (String)localObject1 + ((h)localObject3).fLP.JS() + ';';
      }
    }
    label315:
    for (;;)
    {
      i += 1;
      break;
      localObject3 = new ckd();
      StringBuilder localStringBuilder = new StringBuilder("logid=17368&sessionid=").append(this.ANU.oEK).append("&searchid=").append(this.ANU.oEK).append("&scene=59&md5=");
      localObject2 = this.ANU.ANX;
      if (localObject2 != null) {}
      for (localObject2 = ((SimilarEmojiQueryModel)localObject2).emojiMD5;; localObject2 = null)
      {
        ((ckd)localObject3).Eff = ((String)localObject2 + "&md5content=" + (String)localObject1 + "&pos=" + (this.AOc + 2) + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + this.ANU.oEK);
        localObject1 = new w((ckd)localObject3);
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)localObject1);
        this.AOc = this.AOa.EZq;
        ad.i("MicroMsg.WebSearch.SosSimilarUI", ((ckd)localObject3).Eff);
        AppMethodBeat.o(82504);
        return;
      }
    }
  }
  
  private final int ejQ()
  {
    AppMethodBeat.i(82502);
    int i = ai.getDeviceWidth();
    AppCompatActivity localAppCompatActivity = getContext();
    d.g.b.k.g(localAppCompatActivity, "context");
    i = (i - gA((Context)localAppCompatActivity) * 3) / 8;
    ad.i("MicroMsg.WebSearch.SosSimilarUI", "recycler view padding :".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(82502);
      return i;
    }
    AppMethodBeat.o(82502);
    return 0;
  }
  
  private static int gA(Context paramContext)
  {
    AppMethodBeat.i(82507);
    paramContext = paramContext.getResources();
    d.g.b.k.g(paramContext, "context.resources");
    int i = (int)(paramContext.getDisplayMetrics().density * 108.0F + 0.5F);
    AppMethodBeat.o(82507);
    return i;
  }
  
  public final void ejO()
  {
    AppMethodBeat.i(82505);
    if (this.ANU.qpI)
    {
      SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.AOb;
      if (localSosSimilarEmojiRecyclerView == null) {
        break label64;
      }
      if (!localSosSimilarEmojiRecyclerView.ejN())
      {
        localSosSimilarEmojiRecyclerView = this.AOb;
        if (localSosSimilarEmojiRecyclerView != null) {
          localSosSimilarEmojiRecyclerView.showLoading(true);
        }
        this.ANU.d((com.tencent.mm.al.g)this);
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
    this.AOb = new SosSimilarEmojiRecyclerView((Context)new s((Context)paramBundle, 2131820870));
    paramBundle = this.AOb;
    if (paramBundle != null) {
      paramBundle.setBackgroundColor(getResources().getColor(2131099679));
    }
    paramBundle = this.AOb;
    if (paramBundle != null) {
      paramBundle.setOnLoadingStateChangedListener((SimilarEmojiLoadMoreRecyclerView.a)this);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    Object localObject = new TouchableLayout((Context)this);
    SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.AOb;
    if (localSosSimilarEmojiRecyclerView != null) {
      localSosSimilarEmojiRecyclerView.setPadding(ejQ(), 0, ejQ(), 0);
    }
    ((TouchableLayout)localObject).addView((View)this.AOb, (ViewGroup.LayoutParams)paramBundle);
    setContentView((View)localObject, (ViewGroup.LayoutParams)paramBundle);
    setMMTitle(getString(2131764070));
    setBackBtn((MenuItem.OnMenuItemClickListener)new SosSimilarUI.b(this));
    getContext();
    paramBundle = new GridLayoutManager(3);
    paramBundle.a((GridLayoutManager.b)new c(this, paramBundle));
    localObject = this.AOb;
    if (localObject != null) {
      ((SosSimilarEmojiRecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    }
    paramBundle = this.AOb;
    if (paramBundle != null) {
      paramBundle.setItemViewCacheSize(0);
    }
    paramBundle = this.AOb;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.AOa);
    }
    this.AOa.fPW = ((com.tencent.mm.emoji.panel.a.n)new d(this));
    paramBundle = this.ANU;
    localObject = getIntent();
    d.g.b.k.g(localObject, "intent");
    d.g.b.k.h(localObject, "intent");
    com.tencent.mm.kernel.g.aeS().a(2999, (com.tencent.mm.al.g)paramBundle);
    paramBundle.ANX = ((SimilarEmojiQueryModel)((Intent)localObject).getParcelableExtra("KEY_NET_PARAM"));
    this.AOa.EZp = false;
    paramBundle = this.ANU.ejP();
    if (paramBundle != null)
    {
      this.AOa.G(paramBundle);
      this.AOa.eHF();
    }
    this.AOa.notifyDataSetChanged();
    this.ANU.d((com.tencent.mm.al.g)this);
    paramBundle = com.tencent.mm.search.b.a.EZj;
    com.tencent.mm.search.b.a.eHy();
    AppMethodBeat.o(82501);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(82506);
    dDX();
    super.onDestroy();
    c localc = this.ANU;
    localc.callback = null;
    com.tencent.mm.kernel.b localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().cancel(2999);
    localb = com.tencent.mm.kernel.g.afA();
    d.g.b.k.g(localb, "MMKernel.network()");
    localb.aeS().b(2999, (com.tencent.mm.al.g)localc);
    AppMethodBeat.o(82506);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(82503);
    paramn = this.AOb;
    if (paramn != null) {
      paramn.showLoading(false);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((List)this.ANU.ANY).size() > 1))
    {
      paramInt1 = this.AOa.getItemCount();
      this.AOa.EZp = true;
      this.AOa.ad((List)this.ANU.ANY);
      if (paramInt1 - 2 <= 0)
      {
        this.AOa.notifyDataSetChanged();
        AppMethodBeat.o(82503);
        return;
      }
      this.AOa.ck(paramInt1 - 1);
    }
    for (;;)
    {
      dDX();
      AppMethodBeat.o(82503);
      return;
      ad.i("MicroMsg.WebSearch.SosSimilarUI", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + ' ');
      paramString = new ArrayList();
      this.AOa.setData((List)paramString);
      paramString = this.ANU.ejP();
      if (paramString != null) {
        this.AOa.G(paramString);
      }
      this.AOa.eHG();
      this.AOa.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$Companion;", "", "()V", "COLUMN_COUNT", "", "TAG", "", "plugin-webview_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$2", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-webview_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(GridLayoutManager paramGridLayoutManager) {}
    
    public final int bW(int paramInt)
    {
      AppMethodBeat.i(82498);
      switch (SosSimilarUI.a(this.AOf).getItemViewType(paramInt))
      {
      case 101: 
      case 102: 
      case 103: 
      default: 
        AppMethodBeat.o(82498);
        return 1;
      }
      paramInt = paramBundle.jB();
      AppMethodBeat.o(82498);
      return paramInt;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$3", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "plugin-webview_release"})
  public static final class d
    implements com.tencent.mm.emoji.panel.a.n
  {
    public final void a(final Context paramContext, int paramInt, y paramy)
    {
      Object localObject1 = null;
      AppMethodBeat.i(82500);
      d.g.b.k.h(paramContext, "context");
      if ((paramy == null) || (!(paramy instanceof h)) || (((h)paramy).fNE != 103))
      {
        AppMethodBeat.o(82500);
        return;
      }
      if (System.currentTimeMillis() - SosSimilarUI.c(this.AOf) < 500L)
      {
        AppMethodBeat.o(82500);
        return;
      }
      SosSimilarUI.a(this.AOf, System.currentTimeMillis());
      Object localObject2 = com.tencent.mm.search.a.a.EZf;
      localObject2 = com.tencent.mm.search.a.a.eHv();
      if (localObject2 != null) {
        ((com.tencent.mm.search.a.c)localObject2).a(paramContext, paramInt, paramy);
      }
      localObject2 = new v.e();
      ((v.e)localObject2).Jhw = ((h)paramy).fLP;
      Object localObject3 = (i)com.tencent.mm.kernel.g.ab(i.class);
      paramy = SosSimilarUI.b(this.AOf).ANX;
      if (paramy != null) {}
      for (paramy = paramy.toUser;; paramy = null)
      {
        ((i)localObject3).b(paramContext, paramy, ((EmojiInfo)((v.e)localObject2).Jhw).JS(), ((EmojiInfo)((v.e)localObject2).Jhw).LCm, (y.a)new a(this, (v.e)localObject2, paramContext));
        paramy = new ckd();
        localObject2 = new StringBuilder("logid=17372&sessionid=").append(SosSimilarUI.b(this.AOf).oEK).append("&searchid=").append(SosSimilarUI.b(this.AOf).oEK).append("&scene=59&clickmd5=").append(((EmojiInfo)((v.e)localObject2).Jhw).JS()).append("&querymd5=");
        localObject3 = SosSimilarUI.b(this.AOf).ANX;
        paramContext = localObject1;
        if (localObject3 != null) {
          paramContext = ((SimilarEmojiQueryModel)localObject3).emojiMD5;
        }
        paramy.Eff = (paramContext + "&offset=" + SosSimilarUI.b(this.AOf).offset + "&pos=" + paramInt + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + SosSimilarUI.b(this.AOf).oEK);
        paramContext = new w(paramy);
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramContext);
        ad.i("MicroMsg.WebSearch.SosSimilarUI", paramy.Eff);
        AppMethodBeat.o(82500);
        return;
      }
    }
    
    public final void a(View paramView, Context paramContext, int paramInt)
    {
      AppMethodBeat.i(188875);
      d.g.b.k.h(paramContext, "context");
      Object localObject2 = SosSimilarUI.a(this.AOf).lE(paramInt);
      int i;
      label82:
      Object localObject3;
      Object localObject1;
      if ((localObject2 instanceof h))
      {
        paramContext = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr();
        d.g.b.k.g(paramContext, "SubCoreEmoji.getEmojiStorageMgr()");
        paramContext = paramContext.bxR().aJx(((h)localObject2).fLP.field_md5);
        if (paramContext == null) {
          break label419;
        }
        i = paramContext.getGroup();
        if (i != EmojiInfo.LBW) {
          break label425;
        }
        i = 1;
        localObject3 = new cj();
        ((cj)localObject3).QB();
        ((cj)localObject3).iY(SosSimilarUI.b(this.AOf).oEK);
        ((cj)localObject3).iZ(SosSimilarUI.b(this.AOf).oEK);
        ((cj)localObject3).ja(((h)localObject2).fLP.field_md5);
        paramContext = SosSimilarUI.b(this.AOf).ANX;
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
        ((cj)localObject3).jb(paramContext);
        ((cj)localObject3).fa(SosSimilarUI.b(this.AOf).offset);
        ((cj)localObject3).fb(paramInt);
        ((cj)localObject3).fc(System.currentTimeMillis());
        ((cj)localObject3).jc(SosSimilarUI.b(this.AOf).oEK);
        ((cj)localObject3).fd(1L);
        if (i == 0) {
          break label431;
        }
      }
      label419:
      label425:
      label431:
      for (long l = 1L;; l = 0L)
      {
        ((cj)localObject3).fe(l);
        ((cj)localObject3).aBj();
        paramContext = new StringBuilder("report19651 ");
        localObject1 = ((cj)localObject3).PW();
        d.g.b.k.g(localObject1, "struct.toShowString()");
        ad.i("MicroMsg.WebSearch.SosSimilarUI", d.n.n.h((String)localObject1, "\r\n", " ", false));
        if (i == 0)
        {
          paramContext = new com.tencent.mm.ui.widget.b.a((Context)this.AOf);
          localObject1 = (View.OnCreateContextMenuListener)new a((h)localObject2);
          localObject2 = (n.d)new b((Context)this.AOf, (h)localObject2, SosSimilarUI.b(this.AOf), paramInt);
          localObject3 = TouchableLayout.HYe;
          paramInt = TouchableLayout.fiK();
          localObject3 = TouchableLayout.HYe;
          paramContext.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (n.d)localObject2, paramInt, TouchableLayout.fiL());
        }
        AppMethodBeat.o(188875);
        return;
        i = 0;
        break;
        i = 0;
        break label82;
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
    static final class a
      implements y.a
    {
      a(SosSimilarUI.d paramd, v.e parame, Context paramContext) {}
      
      public final void a(boolean paramBoolean, String paramString, int paramInt)
      {
        AppMethodBeat.i(82499);
        if (paramBoolean)
        {
          paramString = com.tencent.mm.search.a.a.EZf;
          paramString = com.tencent.mm.search.a.a.eHv();
          if (paramString != null)
          {
            paramString = paramString.fPO;
            if (paramString != null) {
              paramString.B((EmojiInfo)this.AOi.Jhw);
            }
          }
          t.makeText(paramContext, (CharSequence)paramContext.getString(2131755887), 1).show();
        }
        paramString = this.AOh.AOf;
        EmojiInfo localEmojiInfo = (EmojiInfo)this.AOi.Jhw;
        d.g.b.k.h(localEmojiInfo, "emojiInfo");
        if (paramBoolean) {}
        for (paramInt = 1;; paramInt = 2)
        {
          e.vIY.f(18742, new Object[] { Integer.valueOf(59), paramString.ANU.oEK, paramString.ANU.oEK, paramString.ANU.oEK, Integer.valueOf(paramInt), localEmojiInfo.JS() });
          AppMethodBeat.o(82499);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.emojistore.ui.SosSimilarUI
 * JD-Core Version:    0.7.0.1
 */