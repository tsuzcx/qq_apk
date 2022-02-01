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
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.h;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.g.b.a.ex;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import com.tencent.mm.storage.be;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView$IOnLoadingStateChangedListener;", "()V", "adapter", "Lcom/tencent/mm/search/ui/SimilarEmojiAdapter;", "data", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiDataManager;", "emojiList", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SosSimilarEmojiRecyclerView;", "lastClickTimestamp", "", "lastReportExposeStartPosition", "", "dp2px", "context", "Landroid/content/Context;", "dpValue", "", "getLayoutId", "getRecyclerViewPadding", "initHeadInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadMore", "parent", "Lcom/tencent/mm/plugin/webview/emojistore/ui/SimilarEmojiLoadMoreRecyclerView;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "report18742", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "bOk", "", "reportExpose", "Companion", "plugin-webview_release"})
public final class SosSimilarUI
  extends MMActivity
  implements com.tencent.mm.ak.f, SimilarEmojiLoadMoreRecyclerView.a
{
  public static final SosSimilarUI.a Ebx;
  final c Ebn;
  private final com.tencent.mm.search.d.a Ebt;
  private SosSimilarEmojiRecyclerView Ebu;
  private int Ebv;
  private long Ebw;
  
  static
  {
    AppMethodBeat.i(82509);
    Ebx = new SosSimilarUI.a((byte)0);
    AppMethodBeat.o(82509);
  }
  
  public SosSimilarUI()
  {
    AppMethodBeat.i(82508);
    this.Ebn = new c();
    this.Ebt = new com.tencent.mm.search.d.a();
    AppMethodBeat.o(82508);
  }
  
  private final int eRL()
  {
    AppMethodBeat.i(82502);
    int i = al.getDeviceWidth();
    AppCompatActivity localAppCompatActivity = getContext();
    p.g(localAppCompatActivity, "context");
    i = (i - gV((Context)localAppCompatActivity) * 3) / 8;
    ae.i("MicroMsg.WebSearch.SosSimilarUI", "recycler view padding :".concat(String.valueOf(i)));
    if (i > 0)
    {
      AppMethodBeat.o(82502);
      return i;
    }
    AppMethodBeat.o(82502);
    return 0;
  }
  
  private final void eiw()
  {
    AppMethodBeat.i(82504);
    Object localObject1;
    Object localObject2;
    int i;
    Object localObject3;
    if (this.Ebv < this.Ebt.ICK)
    {
      localObject1 = "";
      localObject2 = (Iterable)this.Ebn.Ebr;
      i = 0;
      localObject2 = ((Iterable)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (i < 0) {
          d.a.j.gkd();
        }
        localObject3 = (h)localObject3;
        if ((i <= this.Ebv) || (i > this.Ebt.ICK - 2)) {
          break label316;
        }
        localObject1 = (String)localObject1 + ((h)localObject3).glt.Lj() + ';';
      }
    }
    label316:
    for (;;)
    {
      i += 1;
      break;
      localObject3 = new cvj();
      StringBuilder localStringBuilder = new StringBuilder("logid=17368&sessionid=").append(this.Ebn.pSq).append("&searchid=").append(this.Ebn.pSq).append("&scene=59&md5=");
      localObject2 = this.Ebn.Ebq;
      if (localObject2 != null) {}
      for (localObject2 = ((SimilarEmojiQueryModel)localObject2).emojiMD5;; localObject2 = null)
      {
        ((cvj)localObject3).HFU = ((String)localObject2 + "&md5content=" + (String)localObject1 + "&pos=" + (this.Ebv + 2) + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + this.Ebn.pSq);
        localObject1 = new z((cvj)localObject3);
        g.ajj().b((com.tencent.mm.ak.n)localObject1);
        this.Ebv = this.Ebt.ICK;
        ae.i("MicroMsg.WebSearch.SosSimilarUI", ((cvj)localObject3).HFU);
        AppMethodBeat.o(82504);
        return;
      }
    }
  }
  
  private static int gV(Context paramContext)
  {
    AppMethodBeat.i(82507);
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    int i = (int)(paramContext.getDisplayMetrics().density * 108.0F + 0.5F);
    AppMethodBeat.o(82507);
    return i;
  }
  
  public final void eRJ()
  {
    AppMethodBeat.i(82505);
    if (this.Ebn.rRg)
    {
      SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.Ebu;
      if (localSosSimilarEmojiRecyclerView == null) {
        break label64;
      }
      if (!localSosSimilarEmojiRecyclerView.eRI())
      {
        localSosSimilarEmojiRecyclerView = this.Ebu;
        if (localSosSimilarEmojiRecyclerView != null) {
          localSosSimilarEmojiRecyclerView.showLoading(true);
        }
        this.Ebn.f((com.tencent.mm.ak.f)this);
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
    this.Ebu = new SosSimilarEmojiRecyclerView((Context)new com.tencent.mm.ui.t((Context)paramBundle, 2131820870));
    paramBundle = this.Ebu;
    if (paramBundle != null) {
      paramBundle.setBackgroundColor(getResources().getColor(2131099679));
    }
    paramBundle = this.Ebu;
    if (paramBundle != null) {
      paramBundle.setOnLoadingStateChangedListener((SimilarEmojiLoadMoreRecyclerView.a)this);
    }
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    Object localObject = new TouchableLayout((Context)this);
    SosSimilarEmojiRecyclerView localSosSimilarEmojiRecyclerView = this.Ebu;
    if (localSosSimilarEmojiRecyclerView != null) {
      localSosSimilarEmojiRecyclerView.setPadding(eRL(), 0, eRL(), 0);
    }
    ((TouchableLayout)localObject).addView((View)this.Ebu, (ViewGroup.LayoutParams)paramBundle);
    setContentView((View)localObject, (ViewGroup.LayoutParams)paramBundle);
    setMMTitle(getString(2131764070));
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    getContext();
    paramBundle = new GridLayoutManager(3);
    paramBundle.a((GridLayoutManager.b)new c(this, paramBundle));
    localObject = this.Ebu;
    if (localObject != null) {
      ((SosSimilarEmojiRecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    }
    paramBundle = this.Ebu;
    if (paramBundle != null) {
      paramBundle.setItemViewCacheSize(0);
    }
    paramBundle = this.Ebu;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.Ebt);
    }
    this.Ebt.gpR = ((com.tencent.mm.emoji.panel.a.n)new d(this));
    paramBundle = this.Ebn;
    localObject = getIntent();
    p.g(localObject, "intent");
    p.h(localObject, "intent");
    g.ajj().a(2999, (com.tencent.mm.ak.f)paramBundle);
    paramBundle.Ebq = ((SimilarEmojiQueryModel)((Intent)localObject).getParcelableExtra("KEY_NET_PARAM"));
    this.Ebt.ICJ = false;
    paramBundle = this.Ebn.eRK();
    if (paramBundle != null)
    {
      this.Ebt.F(paramBundle);
      this.Ebt.fqG();
    }
    this.Ebt.notifyDataSetChanged();
    this.Ebn.f((com.tencent.mm.ak.f)this);
    paramBundle = com.tencent.mm.search.c.a.ICC;
    com.tencent.mm.search.c.a.fqy();
    AppMethodBeat.o(82501);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(82506);
    eiw();
    super.onDestroy();
    c localc = this.Ebn;
    localc.callback = null;
    com.tencent.mm.kernel.b localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().cancel(2999);
    localb = g.ajQ();
    p.g(localb, "MMKernel.network()");
    localb.ajj().b(2999, (com.tencent.mm.ak.f)localc);
    AppMethodBeat.o(82506);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(82503);
    paramn = this.Ebu;
    if (paramn != null) {
      paramn.showLoading(false);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (((List)this.Ebn.Ebr).size() > 1))
    {
      paramInt1 = this.Ebt.getItemCount();
      this.Ebt.ICJ = true;
      this.Ebt.V((List)this.Ebn.Ebr);
      if (paramInt1 - 2 <= 0)
      {
        this.Ebt.notifyDataSetChanged();
        AppMethodBeat.o(82503);
        return;
      }
      this.Ebt.cj(paramInt1 - 1);
    }
    for (;;)
    {
      eiw();
      AppMethodBeat.o(82503);
      return;
      ae.i("MicroMsg.WebSearch.SosSimilarUI", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + ' ');
      paramString = new ArrayList();
      this.Ebt.setData((List)paramString);
      paramString = this.Ebn.eRK();
      if (paramString != null) {
        this.Ebt.F(paramString);
      }
      this.Ebt.fqH();
      this.Ebt.notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(SosSimilarUI paramSosSimilarUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(82497);
      this.Eby.finish();
      AppMethodBeat.o(82497);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$2", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "plugin-webview_release"})
  public static final class c
    extends GridLayoutManager.b
  {
    c(GridLayoutManager paramGridLayoutManager) {}
    
    public final int bW(int paramInt)
    {
      AppMethodBeat.i(82498);
      switch (SosSimilarUI.a(this.Eby).getItemViewType(paramInt))
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/webview/emojistore/ui/SosSimilarUI$onCreate$3", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "onClick", "", "context", "Landroid/content/Context;", "position", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "onLongClick", "view", "Landroid/view/View;", "plugin-webview_release"})
  public static final class d
    implements com.tencent.mm.emoji.panel.a.n
  {
    public final void a(final Context paramContext, int paramInt, ac paramac)
    {
      Object localObject1 = null;
      AppMethodBeat.i(82500);
      p.h(paramContext, "context");
      if ((paramac == null) || (!(paramac instanceof h)) || (((h)paramac).gnk != 103))
      {
        AppMethodBeat.o(82500);
        return;
      }
      if (System.currentTimeMillis() - SosSimilarUI.c(this.Eby) < 500L)
      {
        AppMethodBeat.o(82500);
        return;
      }
      SosSimilarUI.a(this.Eby, System.currentTimeMillis());
      Object localObject2 = com.tencent.mm.search.b.a.ICy;
      localObject2 = com.tencent.mm.search.b.a.fqv();
      if (localObject2 != null) {
        ((com.tencent.mm.search.b.c)localObject2).a(paramContext, paramInt, paramac);
      }
      localObject2 = new y.f();
      ((y.f)localObject2).NiY = ((h)paramac).glt;
      Object localObject3 = (com.tencent.mm.pluginsdk.j)g.ab(com.tencent.mm.pluginsdk.j.class);
      paramac = SosSimilarUI.b(this.Eby).Ebq;
      if (paramac != null) {}
      for (paramac = paramac.toUser;; paramac = null)
      {
        ((com.tencent.mm.pluginsdk.j)localObject3).b(paramContext, paramac, ((EmojiInfo)((y.f)localObject2).NiY).Lj(), ((EmojiInfo)((y.f)localObject2).NiY).OAq, (y.a)new a(this, (y.f)localObject2, paramContext));
        paramac = new cvj();
        localObject2 = new StringBuilder("logid=17372&sessionid=").append(SosSimilarUI.b(this.Eby).pSq).append("&searchid=").append(SosSimilarUI.b(this.Eby).pSq).append("&scene=59&clickmd5=").append(((EmojiInfo)((y.f)localObject2).NiY).Lj()).append("&querymd5=");
        localObject3 = SosSimilarUI.b(this.Eby).Ebq;
        paramContext = localObject1;
        if (localObject3 != null) {
          paramContext = ((SimilarEmojiQueryModel)localObject3).emojiMD5;
        }
        paramac.HFU = (paramContext + "&offset=" + SosSimilarUI.b(this.Eby).offset + "&pos=" + paramInt + "&clienttimestamp=" + System.currentTimeMillis() + "&tab=0&requestid=" + SosSimilarUI.b(this.Eby).pSq);
        paramContext = new z(paramac);
        g.ajj().b((com.tencent.mm.ak.n)paramContext);
        ae.i("MicroMsg.WebSearch.SosSimilarUI", paramac.HFU);
        AppMethodBeat.o(82500);
        return;
      }
    }
    
    public final void a(View paramView, Context paramContext, int paramInt)
    {
      AppMethodBeat.i(199327);
      p.h(paramContext, "context");
      Object localObject2 = SosSimilarUI.a(this.Eby).me(paramInt);
      int i;
      label82:
      Object localObject3;
      Object localObject1;
      if ((localObject2 instanceof h))
      {
        paramContext = k.getEmojiStorageMgr();
        p.g(paramContext, "SubCoreEmoji.getEmojiStorageMgr()");
        paramContext = paramContext.bJU().aWl(((h)localObject2).glt.field_md5);
        if (paramContext == null) {
          break label419;
        }
        i = paramContext.getGroup();
        if (i != EmojiInfo.OAa) {
          break label425;
        }
        i = 1;
        localObject3 = new ex();
        ((ex)localObject3).Tq();
        ((ex)localObject3).ot(SosSimilarUI.b(this.Eby).pSq);
        ((ex)localObject3).ou(SosSimilarUI.b(this.Eby).pSq);
        ((ex)localObject3).ov(((h)localObject2).glt.field_md5);
        paramContext = SosSimilarUI.b(this.Eby).Ebq;
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
        ((ex)localObject3).ow(paramContext);
        ((ex)localObject3).kk(SosSimilarUI.b(this.Eby).offset);
        ((ex)localObject3).kl(paramInt);
        ((ex)localObject3).km(System.currentTimeMillis());
        ((ex)localObject3).ox(SosSimilarUI.b(this.Eby).pSq);
        ((ex)localObject3).kn(1L);
        if (i == 0) {
          break label431;
        }
      }
      label419:
      label425:
      label431:
      for (long l = 1L;; l = 0L)
      {
        ((ex)localObject3).ko(l);
        ((ex)localObject3).aLH();
        paramContext = new StringBuilder("report19651 ");
        localObject1 = ((ex)localObject3).RD();
        p.g(localObject1, "struct.toShowString()");
        ae.i("MicroMsg.WebSearch.SosSimilarUI", d.n.n.h((String)localObject1, "\r\n", " ", false));
        if (i == 0)
        {
          paramContext = new com.tencent.mm.ui.widget.b.a((Context)this.Eby);
          localObject1 = (View.OnCreateContextMenuListener)new a((h)localObject2);
          localObject2 = (n.e)new b((Context)this.Eby, (h)localObject2, SosSimilarUI.b(this.Eby), paramInt);
          localObject3 = TouchableLayout.LOL;
          paramInt = TouchableLayout.fUD();
          localObject3 = TouchableLayout.LOL;
          paramContext.a(paramView, 0, 0L, (View.OnCreateContextMenuListener)localObject1, (n.e)localObject2, paramInt, TouchableLayout.fUE());
        }
        AppMethodBeat.o(199327);
        return;
        i = 0;
        break;
        i = 0;
        break label82;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "parsterLen", "", "onDialogClick"})
    static final class a
      implements y.a
    {
      a(SosSimilarUI.d paramd, y.f paramf, Context paramContext) {}
      
      public final void a(boolean paramBoolean, String paramString, int paramInt)
      {
        AppMethodBeat.i(82499);
        if (paramBoolean)
        {
          paramString = com.tencent.mm.search.b.a.ICy;
          paramString = com.tencent.mm.search.b.a.fqv();
          if (paramString != null)
          {
            paramString = paramString.gpJ;
            if (paramString != null) {
              paramString.A((EmojiInfo)this.EbB.NiY);
            }
          }
          com.tencent.mm.ui.base.t.makeText(paramContext, (CharSequence)paramContext.getString(2131755887), 1).show();
        }
        paramString = this.EbA.Eby;
        EmojiInfo localEmojiInfo = (EmojiInfo)this.EbB.NiY;
        p.h(localEmojiInfo, "emojiInfo");
        if (paramBoolean) {}
        for (paramInt = 1;; paramInt = 2)
        {
          e.ywz.f(18742, new Object[] { Integer.valueOf(59), paramString.Ebn.pSq, paramString.Ebn.pSq, paramString.Ebn.pSq, Integer.valueOf(paramInt), localEmojiInfo.Lj() });
          AppMethodBeat.o(82499);
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