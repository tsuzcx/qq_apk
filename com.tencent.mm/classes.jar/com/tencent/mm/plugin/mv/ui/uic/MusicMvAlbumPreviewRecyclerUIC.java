package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.livebase.redux.ReduxRootReducer;
import com.tencent.mm.plugin.livebase.redux.ReduxRootReducer.c;
import com.tencent.mm.plugin.livelist.MMLiveList;
import com.tencent.mm.plugin.livelist.h;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.ui.b.a.c.a;
import com.tencent.mm.plugin.thumbplayer.view.recycler.MMRecyclerVideoLayout;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/plugin/livelist/MMLiveRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewDataSource;", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$MvPreviewLiveList;", "pagerSelectedListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSelectedListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSelectedListener$1;", "pagerSettleListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSettleListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSettleListener$1;", "pagerSnapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getPagerSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "pagerSnapHelper$delegate", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "selectCB", "Landroid/widget/CheckBox;", "getSelectCB", "()Landroid/widget/CheckBox;", "selectCB$delegate", "videoRecycler", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "getVideoRecycler", "()Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "videoRecycler$delegate", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "findClickPosition", "", "obj", "Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "listId", "", "itemId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "stopAllVideo", "Companion", "MvPreviewLiveList", "plugin-mv_release"})
public final class MusicMvAlbumPreviewRecyclerUIC
  extends UIComponent
{
  public static final MusicMvAlbumPreviewRecyclerUIC.a Giw;
  private final kotlin.f Gio;
  private final kotlin.f Gip;
  private com.tencent.mm.plugin.mv.model.b.c Giq;
  private MvPreviewLiveList Gir;
  private h<com.tencent.mm.plugin.mv.model.b.e> Gis;
  private final kotlin.f Git;
  private final i Giu;
  private final h Giv;
  private final kotlin.f zQC;
  private final kotlin.f zQD;
  
  static
  {
    AppMethodBeat.i(241496);
    Giw = new MusicMvAlbumPreviewRecyclerUIC.a((byte)0);
    AppMethodBeat.o(241496);
  }
  
  public MusicMvAlbumPreviewRecyclerUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(241494);
    this.zQD = kotlin.g.ar((kotlin.g.a.a)new MusicMvAlbumPreviewRecyclerUIC.k(paramAppCompatActivity));
    this.zQC = kotlin.g.ar((kotlin.g.a.a)new MusicMvAlbumPreviewRecyclerUIC.c(paramAppCompatActivity));
    this.Gio = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.Gip = kotlin.g.ar((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.Git = kotlin.g.ar((kotlin.g.a.a)new MusicMvAlbumPreviewRecyclerUIC.l(paramAppCompatActivity));
    this.Giu = new i(this, paramAppCompatActivity);
    this.Giv = new h(this, paramAppCompatActivity);
    AppMethodBeat.o(241494);
  }
  
  private final com.tencent.mm.plugin.thumbplayer.view.recycler.a fgO()
  {
    AppMethodBeat.i(241482);
    com.tencent.mm.plugin.thumbplayer.view.recycler.a locala = (com.tencent.mm.plugin.thumbplayer.view.recycler.a)this.Gip.getValue();
    AppMethodBeat.o(241482);
    return locala;
  }
  
  private final CheckBox fgP()
  {
    AppMethodBeat.i(241485);
    CheckBox localCheckBox = (CheckBox)this.Git.getValue();
    AppMethodBeat.o(241485);
    return localCheckBox;
  }
  
  private final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(241480);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.zQD.getValue();
    AppMethodBeat.o(241480);
    return localWxRecyclerView;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(241488);
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    paramBundle = com.tencent.mm.ui.component.g.b(getActivity()).i(b.class);
    p.j(paramBundle, "UICProvider.of(activity)…eviewDataUIC::class.java)");
    paramBundle = (b)paramBundle;
    ReduxRootReducer localReduxRootReducer = paramBundle.fgM();
    com.tencent.mm.plugin.livebase.redux.b localb = (com.tencent.mm.plugin.livebase.redux.b)new d();
    p.k(localb, "subReducer");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new ReduxRootReducer.c(localReduxRootReducer, localb));
    paramBundle.fgN().Ehx.a((androidx.lifecycle.l)getActivity(), (s)new e(this));
    Util.expandViewTouchArea((View)fgP(), 100, 100, 100, 100);
    fgP().setOnClickListener((View.OnClickListener)new f(this, paramBundle));
    paramBundle.fgN().Ehx.a((androidx.lifecycle.l)getActivity(), (s)new g(this));
    AppMethodBeat.o(241488);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(241490);
    com.tencent.mm.plugin.thumbplayer.view.recycler.a locala = fgO();
    Iterator localIterator = ((Iterable)locala.MVj).iterator();
    com.tencent.mm.plugin.thumbplayer.f.b localb;
    while (localIterator.hasNext())
    {
      localb = ((MMRecyclerVideoLayout)localIterator.next()).getPlayer$plugin_thumbplayer_release();
      if (localb != null) {
        localb.recycle();
      }
    }
    localIterator = ((Map)locala.MVk).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localb = ((MMRecyclerVideoLayout)((Map.Entry)localIterator.next()).getKey()).getPlayer$plugin_thumbplayer_release();
      if (localb != null) {
        localb.recycle();
      }
    }
    locala.MVj.clear();
    locala.MVk.clear();
    AppMethodBeat.o(241490);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$MvPreviewLiveList;", "Lcom/tencent/mm/plugin/livelist/MMLiveList;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC;Lcom/tencent/mm/plugin/livelist/datasource/IDataSource;Lcom/tencent/mm/plugin/livelist/MMLiveListConfig;)V", "getLogTag", "", "plugin-mv_release"})
  public final class MvPreviewLiveList
    extends MMLiveList<com.tencent.mm.plugin.mv.model.b.e>
  {
    public MvPreviewLiveList(com.tencent.mm.plugin.livelist.f paramf)
    {
      super(localObject, (androidx.lifecycle.l)MusicMvAlbumPreviewRecyclerUIC.this.getActivity());
      AppMethodBeat.i(228714);
      AppMethodBeat.o(228714);
    }
    
    public final String getLogTag()
    {
      return "MicroMsg.Mv.MusicMvAlbumPreviewRecyclerUIC";
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(226556);
      switch (paramInt)
      {
      case 2: 
      default: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.mv.model.b.b(MusicMvAlbumPreviewRecyclerUIC.i(this.Gix));
        AppMethodBeat.o(226556);
        return locale;
      case 1: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.mv.model.b.a();
        AppMethodBeat.o(226556);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.mv.model.b.d(MusicMvAlbumPreviewRecyclerUIC.i(this.Gix));
      AppMethodBeat.o(226556);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$onCreate$1", "Lcom/tencent/mm/plugin/livebase/redux/SyncReduxReducer;", "Lcom/tencent/mm/plugin/mv/ui/redux/album/AlbumState;", "reduceSync", "state", "action", "Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;", "plugin-mv_release"})
  public static final class d
    extends com.tencent.mm.plugin.livebase.redux.d<com.tencent.mm.plugin.mv.ui.b.a.a>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/mv/ui/redux/album/AlbumState;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class e<T>
    implements s<com.tencent.mm.plugin.mv.ui.b.a.a>
  {
    e(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC) {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$onCreate$2$1$3", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "onChanged", "", "t", "plugin-mv_release"})
    public static final class a
      implements s<List<? extends com.tencent.mm.plugin.mv.model.b.e>>
    {
      a(Object paramObject, MusicMvAlbumPreviewRecyclerUIC.e parame) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC, b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(228921);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = ((com.tencent.mm.plugin.mv.ui.b.a.a)paramBundle.fgN()._state).Ghj;
      if (localObject != null)
      {
        if ((((com.tencent.mm.plugin.mv.model.b.e)localObject).GdY instanceof GalleryItem.VideoMediaItem))
        {
          paramView = ((com.tencent.mm.plugin.mv.model.b.e)localObject).GdY;
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
            AppMethodBeat.o(228921);
            throw paramView;
          }
          paramView = (GalleryItem.VideoMediaItem)paramView;
          if (paramView != null) {}
          for (paramView = Integer.valueOf(paramView.maT); paramView.intValue() <= 2000; paramView = null)
          {
            new f.a((Context)this.Gix.getActivity()).bBl(this.Gix.getResources().getString(b.h.music_mv_flex_min_video_limit)).bBp(this.Gix.getResources().getString(b.h.app_i_know)).show();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228921);
            return;
          }
        }
        if (((com.tencent.mm.plugin.mv.model.b.e)localObject).fXF) {
          break label249;
        }
      }
      label249:
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.mv.model.b.e)localObject).fXF = bool;
        paramBundle.fgN().a((com.tencent.mm.plugin.livebase.redux.a)new com.tencent.mm.plugin.mv.ui.b.a.c(c.a.Ghp, (com.tencent.mm.plugin.mv.model.b.e)localObject));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(228921);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/mv/ui/redux/album/AlbumState;", "kotlin.jvm.PlatformType", "onChanged"})
  static final class g<T>
    implements s<com.tencent.mm.plugin.mv.ui.b.a.a>
  {
    g(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSelectedListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-mv_release"})
  public static final class h
    implements a.b
  {
    h(AppCompatActivity paramAppCompatActivity) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(232378);
      Object localObject1 = MusicMvAlbumPreviewRecyclerUIC.b(this.Gix);
      if (localObject1 != null)
      {
        localObject1 = (List)((MMLiveList)localObject1).mXB;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.plugin.mv.model.b.e)j.M((List)localObject1, paramInt);
          if (localObject1 != null)
          {
            Object localObject2 = com.tencent.mm.ui.component.g.Xox;
            localObject2 = com.tencent.mm.ui.component.g.b(paramAppCompatActivity).i(b.class);
            p.j(localObject2, "UICProvider.of(activity)…eviewDataUIC::class.java)");
            ((b)localObject2).fgN().a((com.tencent.mm.plugin.livebase.redux.a)new com.tencent.mm.plugin.mv.ui.b.a.c(c.a.Ghn, (com.tencent.mm.plugin.mv.model.b.e)localObject1));
          }
        }
      }
      MusicMvAlbumPreviewRecyclerUIC.l(this.Gix);
      AppMethodBeat.o(232378);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSettleListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"})
  public static final class i
    implements a.c
  {
    i(AppCompatActivity paramAppCompatActivity) {}
    
    public final void rJ(int paramInt)
    {
      AppMethodBeat.i(228246);
      Object localObject1 = MusicMvAlbumPreviewRecyclerUIC.b(this.Gix);
      if (localObject1 != null)
      {
        localObject1 = (List)((MMLiveList)localObject1).mXB;
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.plugin.mv.model.b.e)j.M((List)localObject1, paramInt);
          if (localObject1 != null)
          {
            Object localObject2 = com.tencent.mm.ui.component.g.Xox;
            localObject2 = com.tencent.mm.ui.component.g.b(paramAppCompatActivity).i(b.class);
            p.j(localObject2, "UICProvider.of(activity)…eviewDataUIC::class.java)");
            ((b)localObject2).fgN().a((com.tencent.mm.plugin.livebase.redux.a)new com.tencent.mm.plugin.mv.ui.b.a.c(c.a.Ghn, (com.tencent.mm.plugin.mv.model.b.e)localObject1));
            AppMethodBeat.o(228246);
            return;
          }
        }
      }
      AppMethodBeat.o(228246);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<com.tencent.mm.emoji.panel.layout.a>
  {
    j(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "invoke"})
  static final class m
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.thumbplayer.view.recycler.a>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewRecyclerUIC
 * JD-Core Version:    0.7.0.1
 */