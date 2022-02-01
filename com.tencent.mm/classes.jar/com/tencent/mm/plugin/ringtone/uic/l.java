package com.tencent.mm.plugin.ringtone.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.plugin.ringtone.b.d;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.b.g.a;
import com.tencent.mm.plugin.ringtone.b.g.a.a;
import com.tencent.mm.plugin.ringtone.ui.RingtoneSearchUI;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
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
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.h;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mFootView", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "mRingtoneList", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getMRingtoneList", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRingtoneList$delegate", "Lkotlin/Lazy;", "ringtoneAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "ringtoneLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "bindDataSource", "", "getNoResultView", "Landroid/view/View;", "getSortView", "initFootView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "reInitAdapter", "refresh", "showFooterView", "showLoadingMore", "showNoResultVIew", "showSearchResultView", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends UIComponent
{
  private final kotlin.j OFE;
  private WxRecyclerAdapter<e> OFa;
  private LinearLayoutManager OFy;
  private i.b OFz;
  
  public l(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273318);
    this.OFE = kotlin.k.cm((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(273318);
  }
  
  private static final void a(l paraml, View paramView)
  {
    AppMethodBeat.i(273376);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    paramView = com.tencent.mm.ui.component.k.aeZF;
    ((m)com.tencent.mm.ui.component.k.d(paraml.getActivity()).q(m.class)).gPb();
    paramView = com.tencent.mm.ui.component.k.aeZF;
    paraml = (b)com.tencent.mm.ui.component.k.d(paraml.getActivity()).q(b.class);
    paramView = new Intent();
    paramView.setClass((Context)paraml.getActivity(), RingtoneSearchUI.class);
    paramView.putExtra("ringtone_caller", paraml.OED);
    paramView.putExtra("channel", paraml.OEE);
    paramView.putExtra("exclusvie_name", paraml.luk);
    paramView.putExtra("enterprise_biz_name", "");
    paramView.putExtra("biz_chat_search_scene", 5);
    paraml.getActivity().startActivityForResult(paramView, 5);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273376);
  }
  
  private final WxRecyclerView gOX()
  {
    AppMethodBeat.i(273325);
    Object localObject = this.OFE.getValue();
    s.s(localObject, "<get-mRingtoneList>(...)");
    localObject = (WxRecyclerView)localObject;
    AppMethodBeat.o(273325);
    return localObject;
  }
  
  private final void gOY()
  {
    AppMethodBeat.i(273336);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = com.tencent.mm.ui.component.k.d(getActivity()).q(b.class);
    s.s(localObject, "UICProvider.of(activity)…gtoneDataUIC::class.java)");
    this.OFa = b.a((b)localObject);
    gOX().setAdapter((RecyclerView.a)this.OFa);
    gOZ();
    gPa();
    AppMethodBeat.o(273336);
  }
  
  private final void gOZ()
  {
    AppMethodBeat.i(273352);
    Object localObject1 = af.mU((Context)getContext()).inflate(b.d.ringtone_end_list_ui, (ViewGroup)gOX(), false);
    if (localObject1 != null)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(-1, -2));
      ((View)localObject1).getLayoutParams().height = bd.fromDPToPix(((View)localObject1).getContext(), 84);
    }
    Object localObject2 = (WeImageView)((View)localObject1).findViewById(b.c.endline_icon);
    if (aw.isDarkMode())
    {
      ((WeImageView)localObject2).setImageDrawable(bb.m((Context)getContext(), b.e.icon_filled_endline_night, getContext().getResources().getColor(b.a.FG_4)));
      ((WeImageView)localObject2).setVisibility(8);
      localObject2 = this.OFa;
      if (localObject2 != null) {
        break label177;
      }
    }
    for (localObject1 = null;; localObject1 = ((WxRecyclerAdapter)localObject2).j((View)localObject1, 0, false))
    {
      this.OFz = ((i.b)localObject1);
      AppMethodBeat.o(273352);
      return;
      ((WeImageView)localObject2).setImageDrawable(bb.m((Context)getContext(), b.e.icon_filled_endline, getContext().getResources().getColor(b.a.FG_4)));
      break;
      label177:
      s.s(localObject1, "footerView");
    }
  }
  
  private final void gPa()
  {
    AppMethodBeat.i(273365);
    Object localObject = this.OFz;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        ((WeImageView)localObject).setVisibility(8);
      }
      localObject = this.OFz;
      if (localObject != null) {
        break label82;
      }
      localObject = null;
    }
    for (;;)
    {
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      AppMethodBeat.o(273365);
      return;
      localObject = ((i.b)localObject).getView();
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = (WeImageView)((View)localObject).findViewById(b.c.endline_icon);
      break;
      label82:
      localObject = ((i.b)localObject).getView();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((View)localObject).findViewById(b.c.loading_more_layout);
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(273448);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 6)
    {
      getActivity().setResult(6, getIntent());
      getActivity().finish();
    }
    AppMethodBeat.o(273448);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(273432);
    super.onCreateAfter(paramBundle);
    gOX().setItemAnimator(null);
    gOX().a((RecyclerView.l)new c(this));
    paramBundle = findViewById(b.c.ringtone_search_layout);
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new l..ExternalSyntheticLambda0(this));
    }
    getActivity();
    this.OFy = new LinearLayoutManager();
    gOX().setLayoutManager((RecyclerView.LayoutManager)this.OFy);
    paramBundle = gOX();
    d locald = new d();
    locald.bD(1, 10);
    ah localah = ah.aiuX;
    paramBundle.setRecycledViewPool((RecyclerView.m)locald);
    kotlinx.coroutines.j.a(getMainScope(), null, null, (kotlin.g.a.m)new a(this, null), 3);
    gOY();
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    ((m)com.tencent.mm.ui.component.k.d(getActivity()).q(m.class)).mScene = 1;
    AppMethodBeat.o(273432);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(273457);
    super.onPause();
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
    AppMethodBeat.o(273457);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(273441);
    super.onResume();
    WxRecyclerAdapter localWxRecyclerAdapter = this.OFa;
    if (localWxRecyclerAdapter != null) {
      localWxRecyclerAdapter.bZE.notifyChanged();
    }
    AppMethodBeat.o(273441);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    int label;
    
    a(l paraml, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(273444);
      paramObject = (d)new a(this.OFG, paramd);
      AppMethodBeat.o(273444);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273437);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273437);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = ((a)com.tencent.mm.ui.component.k.d(this.OFG.getActivity()).q(a.class)).OEB;
        if (paramObject != null)
        {
          paramObject = paramObject.OCf;
          if (paramObject != null)
          {
            paramObject = (kotlinx.coroutines.b.g)paramObject;
            h localh = (h)new a(this.OFG);
            d locald = (d)this;
            this.label = 1;
            if (paramObject.a(localh, locald) == locala)
            {
              AppMethodBeat.o(273437);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(273437);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements h<g.a>
    {
      public a(l paraml) {}
      
      public final Object a(g.a parama, d<? super ah> paramd)
      {
        int m = 0;
        AppMethodBeat.i(273279);
        parama = (g.a)parama;
        if ((parama instanceof g.a.a))
        {
          if (((g.a.a)parama).EcS != 4) {
            break label49;
          }
          l.b(this.OFG);
        }
        for (;;)
        {
          parama = ah.aiuX;
          AppMethodBeat.o(273279);
          return parama;
          label49:
          if (((g.a.a)parama).EcS != 1) {
            break;
          }
          l.c(this.OFG);
        }
        paramd = l.a(this.OFG);
        int j;
        label85:
        int i;
        label109:
        int k;
        if (paramd == null)
        {
          j = 0;
          parama = ((g.a.a)parama).OCh;
          if (parama == null) {
            break label345;
          }
          parama = ((Iterable)parama).iterator();
          i = 0;
          k = i;
          if (!parama.hasNext()) {
            break label348;
          }
          paramd = (e)parama.next();
          Object localObject = l.a(this.OFG);
          if (localObject == null) {
            break label339;
          }
          localObject = (List)((WxRecyclerAdapter)localObject).data;
          if (localObject == null) {
            break label339;
          }
          localObject = (Iterable)localObject;
          if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {
            break label333;
          }
          localObject = ((Iterable)localObject).iterator();
          label197:
          if (!((Iterator)localObject).hasNext()) {
            break label333;
          }
          if (((e)((Iterator)localObject).next()).bZA() != paramd.bZA()) {
            break label327;
          }
          k = 1;
          label231:
          if (k == 0) {
            break label331;
          }
          k = 0;
          label239:
          if (k != 1) {
            break label339;
          }
          k = 1;
          label248:
          if (k == 0) {
            break label464;
          }
          localObject = l.a(this.OFG);
          if (localObject != null)
          {
            localObject = (List)((WxRecyclerAdapter)localObject).data;
            if (localObject != null) {
              ((List)localObject).add(paramd);
            }
          }
          i += 1;
        }
        label327:
        label331:
        label333:
        label464:
        for (;;)
        {
          break label109;
          paramd = (List)paramd.data;
          if (paramd == null)
          {
            j = 0;
            break label85;
          }
          j = paramd.size();
          break label85;
          k = 0;
          break label231;
          break label197;
          k = 1;
          break label239;
          label339:
          k = 0;
          break label248;
          label345:
          k = 0;
          label348:
          parama = l.a(this.OFG);
          i = m;
          if (parama != null)
          {
            parama = (List)parama.data;
            i = m;
            if (parama != null)
            {
              i = m;
              if (parama.isEmpty() == true) {
                i = 1;
              }
            }
          }
          if (i != 0)
          {
            l.d(this.OFG);
            break;
          }
          l.e(this.OFG);
          if (j == 0)
          {
            parama = l.a(this.OFG);
            if (parama == null) {
              break;
            }
            parama.bZE.notifyChanged();
            break;
          }
          parama = l.a(this.OFG);
          if (parama == null) {
            break;
          }
          parama.bA(j, k);
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    b(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC$onCreateAfter$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(l paraml) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(273442);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(273442);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(273433);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (((paramRecyclerView instanceof LinearLayoutManager)) && (paramInt2 > 0) && (((LinearLayoutManager)paramRecyclerView).Jw() >= ((LinearLayoutManager)paramRecyclerView).getItemCount() - 10))
      {
        paramRecyclerView = com.tencent.mm.ui.component.k.aeZF;
        ((k)com.tencent.mm.ui.component.k.d(this.OFG.getActivity()).q(k.class)).aWi();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC$onCreateAfter$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(273433);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/ringtone/uic/RingtoneSelectMainUIC$onCreateAfter$3", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.m
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.l
 * JD-Core Version:    0.7.0.1
 */