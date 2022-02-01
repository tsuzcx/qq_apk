package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.protocal.protobuf.eww;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewSelectedDataSource;", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$MvPreviewLiveList;", "nextBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getNextBtn", "()Landroid/widget/Button;", "nextBtn$delegate", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "nextStep", "", "action", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ItemDecoration", "MvPreviewLiveList", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvAlbumPreviewSelectedUIC
  extends UIComponent
{
  public static final MusicMvAlbumPreviewSelectedUIC.a MdD;
  private final kotlin.j CNQ;
  private final kotlin.j EKZ;
  private final kotlin.j LZT;
  private com.tencent.mm.plugin.mv.model.b.f MdE;
  private MvPreviewLiveList MdF;
  private com.tencent.mm.plugin.mvvmlist.g<com.tencent.mm.plugin.mv.model.b.e> Mdx;
  
  static
  {
    AppMethodBeat.i(288193);
    MdD = new MusicMvAlbumPreviewSelectedUIC.a((byte)0);
    AppMethodBeat.o(288193);
  }
  
  public MusicMvAlbumPreviewSelectedUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(288144);
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.LZT = kotlin.k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    AppMethodBeat.o(288144);
  }
  
  private static final void a(MusicMvAlbumPreviewSelectedUIC paramMusicMvAlbumPreviewSelectedUIC, View paramView)
  {
    AppMethodBeat.i(288188);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvAlbumPreviewSelectedUIC);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvAlbumPreviewSelectedUIC, "this$0");
    paramMusicMvAlbumPreviewSelectedUIC.aed(1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(288188);
  }
  
  private static final void a(MusicMvAlbumPreviewSelectedUIC paramMusicMvAlbumPreviewSelectedUIC, com.tencent.mm.plugin.mv.ui.b.a.a parama)
  {
    AppMethodBeat.i(288184);
    s.u(paramMusicMvAlbumPreviewSelectedUIC, "this$0");
    s.u(parama, "state");
    Object localObject = parama.getAction();
    if ((localObject != null) && ((localObject instanceof com.tencent.mm.plugin.mv.ui.b.a.c)))
    {
      parama = ((com.tencent.mm.plugin.mv.ui.b.a.c)localObject).McZ;
      localObject = ((com.tencent.mm.plugin.mv.ui.b.a.c)localObject).McY;
      switch (c.$EnumSwitchMapping$0[localObject.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(288184);
      return;
      if (parama.idG)
      {
        localObject = (com.tencent.mm.plugin.mv.model.b.e)parama.gsx();
        ((com.tencent.mm.plugin.mv.model.b.e)localObject).FWs = 0;
        MvPreviewLiveList localMvPreviewLiveList = paramMusicMvAlbumPreviewSelectedUIC.MdF;
        if (localMvPreviewLiveList != null) {
          localMvPreviewLiveList.b((com.tencent.mm.plugin.mvvmlist.b)localObject, true);
        }
        paramMusicMvAlbumPreviewSelectedUIC = paramMusicMvAlbumPreviewSelectedUIC.MdF;
        if (paramMusicMvAlbumPreviewSelectedUIC != null)
        {
          paramMusicMvAlbumPreviewSelectedUIC.aA((kotlin.g.a.b)new h(parama));
          AppMethodBeat.o(288184);
        }
      }
      else
      {
        paramMusicMvAlbumPreviewSelectedUIC = paramMusicMvAlbumPreviewSelectedUIC.MdF;
        if (paramMusicMvAlbumPreviewSelectedUIC != null)
        {
          paramMusicMvAlbumPreviewSelectedUIC.a((com.tencent.mm.plugin.mvvmlist.b)parama);
          AppMethodBeat.o(288184);
          return;
          paramMusicMvAlbumPreviewSelectedUIC = paramMusicMvAlbumPreviewSelectedUIC.MdF;
          if (paramMusicMvAlbumPreviewSelectedUIC != null) {
            paramMusicMvAlbumPreviewSelectedUIC.aA((kotlin.g.a.b)new i(parama));
          }
        }
      }
    }
  }
  
  private static final void a(MusicMvAlbumPreviewSelectedUIC paramMusicMvAlbumPreviewSelectedUIC, b paramb, com.tencent.mm.plugin.mv.ui.b.a.a parama)
  {
    AppMethodBeat.i(288172);
    s.u(paramMusicMvAlbumPreviewSelectedUIC, "this$0");
    s.u(paramb, "$dataUIC");
    s.u(parama, "state");
    if ((parama.getAction() instanceof com.tencent.mm.plugin.mv.ui.b.a.b))
    {
      parama = parama.McW;
      if (parama != null)
      {
        paramMusicMvAlbumPreviewSelectedUIC.MdE = new com.tencent.mm.plugin.mv.model.b.f(parama);
        Object localObject1 = paramMusicMvAlbumPreviewSelectedUIC.MdE;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.plugin.mvvmlist.a.f)localObject1;
          localObject2 = new com.tencent.mm.plugin.mvvmlist.e();
          ((com.tencent.mm.plugin.mvvmlist.e)localObject2).wDG = true;
          ah localah = ah.aiuX;
          paramMusicMvAlbumPreviewSelectedUIC.MdF = new MvPreviewLiveList((com.tencent.mm.plugin.mvvmlist.a.f)localObject1, (com.tencent.mm.plugin.mvvmlist.e)localObject2);
        }
        localObject1 = paramMusicMvAlbumPreviewSelectedUIC.MdF;
        if (localObject1 != null) {
          ((MvvmList)localObject1).MmR.a((q)paramMusicMvAlbumPreviewSelectedUIC.getActivity(), new MusicMvAlbumPreviewSelectedUIC..ExternalSyntheticLambda1(paramMusicMvAlbumPreviewSelectedUIC));
        }
        localObject1 = paramMusicMvAlbumPreviewSelectedUIC.MdF;
        if (localObject1 != null) {
          paramMusicMvAlbumPreviewSelectedUIC.Mdx = new com.tencent.mm.plugin.mvvmlist.g((MvvmList)localObject1, (com.tencent.mm.view.recyclerview.g)new d(), (byte)0);
        }
        paramMusicMvAlbumPreviewSelectedUIC.getRecyclerView().setAdapter((RecyclerView.a)paramMusicMvAlbumPreviewSelectedUIC.Mdx);
        paramMusicMvAlbumPreviewSelectedUIC.getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)paramMusicMvAlbumPreviewSelectedUIC.EKZ.getValue());
        paramMusicMvAlbumPreviewSelectedUIC.getRecyclerView().a((RecyclerView.h)new MusicMvAlbumPreviewSelectedUIC.b(paramMusicMvAlbumPreviewSelectedUIC));
        int i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 10);
        localObject1 = new View((Context)paramMusicMvAlbumPreviewSelectedUIC.getActivity());
        ((View)localObject1).setPadding(i, 0, 0, 0);
        Object localObject2 = paramMusicMvAlbumPreviewSelectedUIC.Mdx;
        if (localObject2 != null) {
          i.a((i)localObject2, (View)localObject1, ((View)localObject1).hashCode());
        }
        localObject1 = new View((Context)paramMusicMvAlbumPreviewSelectedUIC.getActivity());
        ((View)localObject1).setPadding(i, 0, 0, 0);
        localObject2 = paramMusicMvAlbumPreviewSelectedUIC.Mdx;
        if (localObject2 != null) {
          i.b((i)localObject2, (View)localObject1, ((View)localObject1).hashCode());
        }
        localObject1 = paramMusicMvAlbumPreviewSelectedUIC.Mdx;
        if (localObject1 != null) {
          ((i)localObject1).agOe = ((i.c)new g(paramb));
        }
        if (parama.abmm.size() > 0)
        {
          paramMusicMvAlbumPreviewSelectedUIC.getRecyclerView().setVisibility(0);
          paramMusicMvAlbumPreviewSelectedUIC.gqy().setEnabled(true);
          AppMethodBeat.o(288172);
          return;
        }
        paramMusicMvAlbumPreviewSelectedUIC.getRecyclerView().setVisibility(8);
        paramMusicMvAlbumPreviewSelectedUIC.gqy().setEnabled(false);
      }
    }
    AppMethodBeat.o(288172);
  }
  
  private static final void a(MusicMvAlbumPreviewSelectedUIC paramMusicMvAlbumPreviewSelectedUIC, List paramList)
  {
    AppMethodBeat.i(288162);
    s.u(paramMusicMvAlbumPreviewSelectedUIC, "this$0");
    s.s(paramList, "it");
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      if (((com.tencent.mm.plugin.mv.model.b.e)localObject).LZH)
      {
        localObject = paramMusicMvAlbumPreviewSelectedUIC.Mdx;
        if (localObject != null) {
          break label176;
        }
      }
      label176:
      for (int j = 0;; j = ((i)localObject).agOb.size())
      {
        localObject = paramMusicMvAlbumPreviewSelectedUIC.getRecyclerView();
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(i + j, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC", "onCreate$lambda-6$lambda-5$lambda-3", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC;Ljava/util/List;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        ((WxRecyclerView)localObject).smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC", "onCreate$lambda-6$lambda-5$lambda-3", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC;Ljava/util/List;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        i += 1;
        break;
      }
    }
    if (!((Collection)paramList).isEmpty()) {}
    for (i = 1; i != 0; i = 0)
    {
      paramMusicMvAlbumPreviewSelectedUIC.getRecyclerView().setVisibility(0);
      paramMusicMvAlbumPreviewSelectedUIC.gqy().setEnabled(true);
      paramMusicMvAlbumPreviewSelectedUIC.gqy().setText((CharSequence)(paramMusicMvAlbumPreviewSelectedUIC.getActivity().getString(b.h.app_nextstep) + '(' + paramList.size() + ')'));
      AppMethodBeat.o(288162);
      return;
    }
    paramMusicMvAlbumPreviewSelectedUIC.getRecyclerView().setVisibility(8);
    paramMusicMvAlbumPreviewSelectedUIC.gqy().setEnabled(false);
    paramMusicMvAlbumPreviewSelectedUIC.gqy().setText((CharSequence)paramMusicMvAlbumPreviewSelectedUIC.getActivity().getString(b.h.app_nextstep));
    AppMethodBeat.o(288162);
  }
  
  private final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(288147);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(288147);
    return localWxRecyclerView;
  }
  
  private final Button gqy()
  {
    AppMethodBeat.i(288152);
    Button localButton = (Button)this.LZT.getValue();
    AppMethodBeat.o(288152);
    return localButton;
  }
  
  public final void aed(int paramInt)
  {
    AppMethodBeat.i(288233);
    Object localObject1 = this.MdF;
    if (localObject1 != null)
    {
      Intent localIntent = new Intent();
      egz localegz = new egz();
      localObject1 = ((Iterable)((MvvmList)localObject1).pUj).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (com.tencent.mm.plugin.mv.model.b.e)((Iterator)localObject1).next();
        LinkedList localLinkedList = localegz.abmm;
        eww localeww = new eww();
        localeww.LZD = ((com.tencent.mm.plugin.mv.model.b.e)localObject2).LZD;
        localeww.abyX = ((com.tencent.mm.plugin.mv.model.b.e)localObject2).LZG;
        localObject2 = ah.aiuX;
        localLinkedList.add(localeww);
      }
      localIntent.putExtra("PreviewItemObjCallbackAction", paramInt);
      localIntent.putExtra("PreviewItemObjCallback", localegz.toByteArray());
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
    AppMethodBeat.o(288233);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288225);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = com.tencent.mm.ui.component.k.d(getActivity()).q(b.class);
    s.s(paramBundle, "UICProvider.of(activity)…eviewDataUIC::class.java)");
    paramBundle = (b)paramBundle;
    paramBundle.getStateCenter().observe((q)getActivity(), new MusicMvAlbumPreviewSelectedUIC..ExternalSyntheticLambda3(this, paramBundle));
    paramBundle.getStateCenter().observe((q)getActivity(), new MusicMvAlbumPreviewSelectedUIC..ExternalSyntheticLambda2(this));
    gqy().setOnClickListener(new MusicMvAlbumPreviewSelectedUIC..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(288225);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$MvPreviewLiveList;", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC;Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;)V", "getLogTag", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class MvPreviewLiveList
    extends MvvmList<com.tencent.mm.plugin.mv.model.b.e>
  {
    public MvPreviewLiveList(com.tencent.mm.plugin.mvvmlist.e parame)
    {
      super(localObject, (q)MusicMvAlbumPreviewSelectedUIC.this.getActivity());
      AppMethodBeat.i(288052);
      AppMethodBeat.o(288052);
    }
    
    public final String getLogTag()
    {
      return "MicroMsg.Mv.MusicMvAlbumPreviewSelectedUIC";
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.view.recyclerview.g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(287535);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.mv.model.b.g();
      AppMethodBeat.o(287535);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WxLinearLayoutManager>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Button>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$onCreate$1$1$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    g(b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<ArrayList<com.tencent.mm.plugin.mv.model.b.e>, ah>
  {
    h(com.tencent.mm.plugin.mv.model.b.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<ArrayList<com.tencent.mm.plugin.mv.model.b.e>, ah>
  {
    i(com.tencent.mm.plugin.mv.model.b.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewSelectedUIC
 * JD-Core Version:    0.7.0.1
 */