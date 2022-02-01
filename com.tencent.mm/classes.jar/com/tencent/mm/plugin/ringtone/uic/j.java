package com.tencent.mm.plugin.ringtone.uic;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.b.g.a;
import com.tencent.mm.plugin.ringtone.b.g.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneSearchMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelvoiceaddr/ui/VoiceSearchViewHelper$IVoiceSearchListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "mFootView", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "mSortView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMSortView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mSortView$delegate", "Lkotlin/Lazy;", "ringtoneAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "ringtoneLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "searchViewHelper", "Lcom/tencent/mm/modelvoiceaddr/ui/VoiceSearchViewHelper;", "bindDataSource", "", "getLoadingView", "Landroid/view/View;", "getNoResultView", "getSearchViewHelper", "getSortView", "initFootView", "onClickClearText", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onEnterSearch", "onPause", "onQuitSearch", "onResume", "onSearchChange", "searchText", "onSearchEditTextReady", "onSearchKeyDown", "", "onVoiceReturn", "success", "voiceText", "", "voiceId", "", "searchType", "", "(Z[Ljava/lang/String;JI)V", "onVoiceSearchCancel", "onVoiceSearchStart", "reInitAdapter", "showFooterView", "showInitView", "showLoadingMore", "showLoadingView", "showNoResultVIew", "showSearchResultView", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends UIComponent
  implements b.a
{
  private WxRecyclerAdapter<e> OFa;
  private final kotlin.j OFx;
  private LinearLayoutManager OFy;
  private i.b OFz;
  private final String TAG;
  public final com.tencent.mm.modelvoiceaddr.ui.b vDu;
  
  public j(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273322);
    this.TAG = "MicroMsg.RingtoneSearchMainUIC";
    this.vDu = new com.tencent.mm.modelvoiceaddr.ui.b();
    this.OFx = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.OFy = new LinearLayoutManager();
    AppMethodBeat.o(273322);
  }
  
  private final WxRecyclerView gOW()
  {
    AppMethodBeat.i(273330);
    Object localObject = this.OFx.getValue();
    kotlin.g.b.s.s(localObject, "<get-mSortView>(...)");
    localObject = (WxRecyclerView)localObject;
    AppMethodBeat.o(273330);
    return localObject;
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(273435);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    ((b)com.tencent.mm.ui.component.k.d(getActivity()).q(b.class)).OEF.t(Boolean.TRUE);
    Log.i(this.TAG, "search biz, key word : %s", new Object[] { paramString });
    localObject = (CharSequence)paramString;
    label101:
    long l;
    com.tencent.mm.ui.component.k localk;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject = (CharSequence)paramString;
        if ((localObject != null) && (!n.bp((CharSequence)localObject))) {
          break label360;
        }
        i = 1;
        if (i == 0)
        {
          localObject = com.tencent.mm.ui.component.k.aeZF;
          localObject = (m)com.tencent.mm.ui.component.k.d(getActivity()).q(m.class);
          kotlin.g.b.s.u(paramString, "key");
          if (!kotlin.g.b.s.p(((m)localObject).OFL, ""))
          {
            l = Util.ticksToNow(((m)localObject).OFI);
            localk = com.tencent.mm.ui.component.k.aeZF;
            if (!((b)com.tencent.mm.ui.component.k.d(((m)localObject).getActivity()).q(b.class)).gOP()) {
              break label365;
            }
          }
        }
      }
    }
    label360:
    label365:
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.plugin.ringtone.h.a.a(String.valueOf(((m)localObject).OFI), ((m)localObject).OFJ, ((m)localObject).mScene, l, i, ((m)localObject).luk, ((m)localObject).OFK, ((m)localObject).channel, ((m)localObject).OFL);
      ((m)localObject).OFI = Util.currentTicks();
      ((m)localObject).OFJ = 0;
      ((m)localObject).OFL = paramString;
      localObject = com.tencent.mm.ui.component.k.aeZF;
      ((h)com.tencent.mm.ui.component.k.d(getActivity()).q(h.class)).gOV();
      localObject = com.tencent.mm.ui.component.k.aeZF;
      localObject = (i)com.tencent.mm.ui.component.k.d(getActivity()).q(i.class);
      kotlin.g.b.s.u(paramString, "str");
      localk = com.tencent.mm.ui.component.k.aeZF;
      ((a)com.tencent.mm.ui.component.k.d(((i)localObject).getActivity()).q(a.class)).gOw();
      ((i)localObject).NTq = paramString;
      ((i)localObject).OFt = true;
      ((i)localObject).BQ(true);
      AppMethodBeat.o(273435);
      return true;
      i = 0;
      break;
      i = 0;
      break label101;
    }
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(273423);
    Log.i(this.TAG, kotlin.g.b.s.X("onSearchChange: ", paramString));
    paramString = com.tencent.mm.ui.component.k.aeZF;
    ((h)com.tencent.mm.ui.component.k.d(getActivity()).q(h.class)).gOV();
    paramString = com.tencent.mm.ui.component.k.aeZF;
    ((i)com.tencent.mm.ui.component.k.d(getActivity()).q(i.class)).clearData();
    AppMethodBeat.o(273423);
  }
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final void bPQ() {}
  
  public final void bWw()
  {
    AppMethodBeat.i(273410);
    getActivity().finish();
    AppMethodBeat.o(273410);
  }
  
  public final void bWx() {}
  
  public final void bWy()
  {
    AppMethodBeat.i(273460);
    Log.i(this.TAG, "onClickClearText");
    Object localObject = this.OFa;
    if (localObject != null)
    {
      localObject = (List)((WxRecyclerAdapter)localObject).data;
      if (localObject != null) {
        ((List)localObject).clear();
      }
    }
    localObject = this.OFa;
    if (localObject != null) {
      ((RecyclerView.a)localObject).bZE.notifyChanged();
    }
    localObject = com.tencent.mm.ui.component.k.aeZF;
    ((h)com.tencent.mm.ui.component.k.d(getActivity()).q(h.class)).gOV();
    localObject = com.tencent.mm.ui.component.k.aeZF;
    ((i)com.tencent.mm.ui.component.k.d(getActivity()).q(i.class)).clearData();
    AppMethodBeat.o(273460);
  }
  
  public final void bWz() {}
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(273393);
    super.onCreateAfter(paramBundle);
    gOW().setItemAnimator(null);
    gOW().a((RecyclerView.l)new c(this));
    getActivity();
    this.OFy = new LinearLayoutManager();
    gOW().setLayoutManager((RecyclerView.LayoutManager)this.OFy);
    paramBundle = gOW();
    d locald = new d();
    locald.bD(1, 10);
    ah localah = ah.aiuX;
    paramBundle.setRecycledViewPool((RecyclerView.m)locald);
    this.vDu.MY(true);
    this.vDu.a((b.a)this);
    this.vDu.pgU = false;
    kotlinx.coroutines.j.a(getMainScope(), null, null, (kotlin.g.a.m)new a(this, null), 3);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    ((m)com.tencent.mm.ui.component.k.d(getActivity()).q(m.class)).mScene = 2;
    AppMethodBeat.o(273393);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(273445);
    super.onPause();
    this.vDu.cancel();
    this.vDu.clearFocus();
    Object localObject = this.OFa;
    if (localObject != null)
    {
      localObject = (List)((WxRecyclerAdapter)localObject).data;
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((e)((Iterator)localObject).next()).hJg = false;
        }
      }
    }
    AppMethodBeat.o(273445);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273452);
    super.onResume();
    WxRecyclerAdapter localWxRecyclerAdapter = this.OFa;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.bZE.notifyChanged();
    }
    AppMethodBeat.o(273452);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(j paramj, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(273416);
      paramObject = (d)new a(this.OFA, paramd);
      AppMethodBeat.o(273416);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273407);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273407);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = ((a)com.tencent.mm.ui.component.k.d(this.OFA.getActivity()).q(a.class)).OEB;
        if (paramObject != null)
        {
          paramObject = paramObject.OCf;
          if (paramObject != null)
          {
            paramObject = (kotlinx.coroutines.b.g)paramObject;
            kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.OFA);
            d locald = (d)this;
            this.label = 1;
            if (paramObject.a(localh, locald) == locala)
            {
              AppMethodBeat.o(273407);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(273407);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<g.a>
    {
      public a(j paramj) {}
      
      public final Object a(g.a parama, d<? super ah> paramd)
      {
        int k = 0;
        AppMethodBeat.i(273285);
        parama = (g.a)parama;
        if ((parama instanceof g.a.a))
        {
          if (((g.a.a)parama).EcS != 1) {
            break label49;
          }
          j.b(this.OFA);
        }
        label49:
        label209:
        label470:
        label599:
        for (;;)
        {
          parama = ah.aiuX;
          AppMethodBeat.o(273285);
          return parama;
          if (((g.a.a)parama).EcS == 2)
          {
            j.c(this.OFA);
          }
          else
          {
            int i;
            if (((g.a.a)parama).EcS == 4)
            {
              j.d(this.OFA);
              paramd = j.a(this.OFA);
              if (paramd != null) {
                break label316;
              }
              i = 0;
              label102:
              parama = ((g.a.a)parama).OCh;
              if (parama == null) {
                break label361;
              }
              parama = ((Iterable)parama).iterator();
            }
            label347:
            label355:
            label359:
            for (;;)
            {
              label124:
              if (!parama.hasNext()) {
                break label361;
              }
              paramd = (e)parama.next();
              Object localObject = j.a(this.OFA);
              if (localObject != null)
              {
                localObject = (List)((WxRecyclerAdapter)localObject).data;
                if (localObject != null)
                {
                  localObject = (Iterable)localObject;
                  if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
                  {
                    localObject = ((Iterable)localObject).iterator();
                    if (((Iterator)localObject).hasNext()) {
                      if (((e)((Iterator)localObject).next()).bZA() == paramd.bZA())
                      {
                        j = 1;
                        label243:
                        if (j == 0) {
                          break label347;
                        }
                        j = 0;
                        label251:
                        if (j != 1) {
                          break label355;
                        }
                      }
                    }
                  }
                }
              }
              for (j = 1;; j = 0)
              {
                if (j == 0) {
                  break label359;
                }
                localObject = j.a(this.OFA);
                if (localObject == null) {
                  break label124;
                }
                localObject = (List)((WxRecyclerAdapter)localObject).data;
                if (localObject == null) {
                  break label124;
                }
                ((List)localObject).add(paramd);
                break label124;
                j.e(this.OFA);
                break;
                paramd = (List)paramd.data;
                if (paramd == null)
                {
                  i = 0;
                  break label102;
                }
                i = paramd.size();
                break label102;
                j = 0;
                break label243;
                break label209;
                j = 1;
                break label251;
              }
            }
            label361:
            parama = j.a(this.OFA);
            if (parama != null)
            {
              parama = (List)parama.data;
              if ((parama == null) || (parama.isEmpty() != true)) {}
            }
            for (int j = 1;; j = 0)
            {
              if (j == 0) {
                break label470;
              }
              parama = this.OFA;
              paramd = parama.findViewById(b.c.loading_layout);
              if (paramd != null) {
                paramd.setVisibility(8);
              }
              paramd = parama.findViewById(b.c.no_result);
              if (paramd != null) {
                paramd.setVisibility(0);
              }
              parama = parama.findViewById(b.c.ringtone_sort_and_search_ui);
              if (parama == null) {
                break;
              }
              parama.setVisibility(8);
              break;
            }
            parama = this.OFA;
            paramd = parama.findViewById(b.c.loading_layout);
            if (paramd != null) {
              paramd.setVisibility(8);
            }
            paramd = parama.findViewById(b.c.no_result);
            if (paramd != null) {
              paramd.setVisibility(8);
            }
            parama = parama.findViewById(b.c.ringtone_sort_and_search_ui);
            if (parama != null) {
              parama.setVisibility(0);
            }
            parama = j.a(this.OFA);
            if (parama == null) {
              j = k;
            }
            for (;;)
            {
              if (j <= i) {
                break label599;
              }
              parama = j.a(this.OFA);
              if (parama == null) {
                break;
              }
              parama.bA(i, j - i);
              break;
              parama = (List)parama.data;
              j = k;
              if (parama != null) {
                j = parama.size();
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneSearchMainUIC$onCreateAfter$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(j paramj) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(273438);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneSearchMainUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 1)
      {
        paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
        ((b)com.tencent.mm.ui.component.k.d(this.OFA.getActivity()).q(b.class)).OEF.t(Boolean.TRUE);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ringtone/uic/RingtoneSearchMainUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(273438);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(273429);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneSearchMainUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (paramInt2 > 0) && (((LinearLayoutManager)paramRecyclerView).Jw() >= ((LinearLayoutManager)paramRecyclerView).getItemCount() - 10))
      {
        paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
        paramRecyclerView = com.tencent.mm.ui.component.k.d(this.OFA.getActivity()).q(i.class);
        kotlin.g.b.s.s(paramRecyclerView, "UICProvider.of(activity)…earchDataUIC::class.java)");
        i.a((i)paramRecyclerView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ringtone/uic/RingtoneSearchMainUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(273429);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneSearchMainUIC$onCreateAfter$2", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.m
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.j
 * JD-Core Version:    0.7.0.1
 */