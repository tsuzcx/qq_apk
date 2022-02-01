package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.livelist.a.d;
import com.tencent.mm.plugin.livelist.h;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.protocal.protobuf.edf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewSelectedDataSource;", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$MvPreviewLiveList;", "nextBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getNextBtn", "()Landroid/widget/Button;", "nextBtn$delegate", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "nextStep", "", "action", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ItemDecoration", "MvPreviewLiveList", "plugin-mv_release"})
public final class MusicMvAlbumPreviewSelectedUIC
  extends UIComponent
{
  public static final MusicMvAlbumPreviewSelectedUIC.a GiF;
  private final kotlin.f Gen;
  private com.tencent.mm.plugin.mv.model.b.f GiD;
  private MvPreviewLiveList GiE;
  private h<com.tencent.mm.plugin.mv.model.b.e> Gis;
  private final kotlin.f zQC;
  private final kotlin.f zQD;
  
  static
  {
    AppMethodBeat.i(231403);
    GiF = new MusicMvAlbumPreviewSelectedUIC.a((byte)0);
    AppMethodBeat.o(231403);
  }
  
  public MusicMvAlbumPreviewSelectedUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(231401);
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new MusicMvAlbumPreviewSelectedUIC.i(paramAppCompatActivity));
    this.Gen = kotlin.g.ar((kotlin.g.a.a)new MusicMvAlbumPreviewSelectedUIC.e(paramAppCompatActivity));
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new MusicMvAlbumPreviewSelectedUIC.d(paramAppCompatActivity));
    AppMethodBeat.o(231401);
  }
  
  private final Button fgQ()
  {
    AppMethodBeat.i(231394);
    Button localButton = (Button)this.Gen.getValue();
    AppMethodBeat.o(231394);
    return localButton;
  }
  
  public final void ZO(int paramInt)
  {
    AppMethodBeat.i(231398);
    Object localObject = this.GiE;
    if (localObject != null)
    {
      Intent localIntent = new Intent();
      doi localdoi = new doi();
      localObject = ((Iterable)((MMLiveList)localObject).mXB).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.mv.model.b.e locale = (com.tencent.mm.plugin.mv.model.b.e)((Iterator)localObject).next();
        LinkedList localLinkedList = localdoi.TVz;
        edf localedf = new edf();
        localedf.GdS = locale.GdS;
        localedf.UhH = locale.Gea;
        localLinkedList.add(localedf);
      }
      localIntent.putExtra("PreviewItemObjCallbackAction", paramInt);
      localIntent.putExtra("PreviewItemObjCallback", localdoi.toByteArray());
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
      AppMethodBeat.o(231398);
      return;
    }
    AppMethodBeat.o(231398);
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(231397);
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    paramBundle = com.tencent.mm.ui.component.g.b(getActivity()).i(b.class);
    p.j(paramBundle, "UICProvider.of(activity)…eviewDataUIC::class.java)");
    paramBundle = (b)paramBundle;
    paramBundle.fgN().Ehx.a((androidx.lifecycle.l)getActivity(), (s)new f(this, paramBundle));
    paramBundle.fgN().Ehx.a((androidx.lifecycle.l)getActivity(), (s)new g(this));
    fgQ().setOnClickListener((View.OnClickListener)new h(this));
    AppMethodBeat.o(231397);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$MvPreviewLiveList;", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC;Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;)V", "getLogTag", "", "plugin-mv_release"})
  public final class MvPreviewLiveList
    extends MMLiveList<com.tencent.mm.plugin.mv.model.b.e>
  {
    public MvPreviewLiveList(com.tencent.mm.plugin.livelist.f paramf)
    {
      super(localObject, (androidx.lifecycle.l)MusicMvAlbumPreviewSelectedUIC.this.getActivity());
      AppMethodBeat.i(232081);
      AppMethodBeat.o(232081);
    }
    
    public final String getLogTag()
    {
      return "MicroMsg.Mv.MusicMvAlbumPreviewSelectedUIC";
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(225402);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.mv.model.b.g();
      AppMethodBeat.o(225402);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/mv/ui/redux/album/AlbumState;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class f<T>
    implements s<com.tencent.mm.plugin.mv.ui.b.a.a>
  {
    f(MusicMvAlbumPreviewSelectedUIC paramMusicMvAlbumPreviewSelectedUIC, b paramb) {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "kotlin.jvm.PlatformType", "onChanged", "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$onCreate$1$1$2"})
    static final class a<T>
      implements s<List<? extends com.tencent.mm.plugin.mv.model.b.e>>
    {
      a(MusicMvAlbumPreviewSelectedUIC.f paramf) {}
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$onCreate$1$1$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
    public static final class b
      implements h.c<i>
    {
      b(MusicMvAlbumPreviewSelectedUIC.f paramf) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/mv/ui/redux/album/AlbumState;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class g<T>
    implements s<com.tencent.mm.plugin.mv.ui.b.a.a>
  {
    g(MusicMvAlbumPreviewSelectedUIC paramMusicMvAlbumPreviewSelectedUIC) {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<ArrayList<com.tencent.mm.plugin.mv.model.b.e>, x>
    {
      a(com.tencent.mm.plugin.mv.model.b.e parame)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.b<ArrayList<com.tencent.mm.plugin.mv.model.b.e>, x>
    {
      b(com.tencent.mm.plugin.mv.model.b.e parame)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(MusicMvAlbumPreviewSelectedUIC paramMusicMvAlbumPreviewSelectedUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230128);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.GiG.ZO(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewSelectedUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewSelectedUIC
 * JD-Core Version:    0.7.0.1
 */