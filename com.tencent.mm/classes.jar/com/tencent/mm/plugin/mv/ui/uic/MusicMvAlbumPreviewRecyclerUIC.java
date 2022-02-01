package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.panel.layout.a.b;
import com.tencent.mm.emoji.panel.layout.a.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.ui.b.a.c.a;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.plugin.thumbplayer.view.recycler.MMRecyclerVideoLayout;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/plugin/mvvmlist/MvvmRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewDataSource;", "layoutManager", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;", "layoutManager$delegate", "Lkotlin/Lazy;", "liveList", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$MvPreviewLiveList;", "pagerSelectedListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSelectedListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSelectedListener$1;", "pagerSettleListener", "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSettleListener$1", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSettleListener$1;", "pagerSnapHelper", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "getPagerSnapHelper", "()Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;", "pagerSnapHelper$delegate", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "recyclerView$delegate", "selectCB", "Landroid/widget/CheckBox;", "getSelectCB", "()Landroid/widget/CheckBox;", "selectCB$delegate", "videoRecycler", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "getVideoRecycler", "()Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;", "videoRecycler$delegate", "buildItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "findClickPosition", "", "obj", "Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "listId", "", "itemId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "stopAllVideo", "Companion", "MvPreviewLiveList", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvAlbumPreviewRecyclerUIC
  extends UIComponent
{
  public static final MusicMvAlbumPreviewRecyclerUIC.a Mds;
  private final j CNQ;
  private final j EKZ;
  private final g MdA;
  private final j Mdt;
  private final j Mdu;
  private com.tencent.mm.plugin.mv.model.b.c Mdv;
  private MvPreviewLiveList Mdw;
  private com.tencent.mm.plugin.mvvmlist.g<com.tencent.mm.plugin.mv.model.b.e> Mdx;
  private final j Mdy;
  private final h Mdz;
  
  static
  {
    AppMethodBeat.i(287844);
    Mds = new MusicMvAlbumPreviewRecyclerUIC.a((byte)0);
    AppMethodBeat.o(287844);
  }
  
  public MusicMvAlbumPreviewRecyclerUIC(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287694);
    this.CNQ = kotlin.k.cm((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.EKZ = kotlin.k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.Mdt = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.Mdu = kotlin.k.cm((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.Mdy = kotlin.k.cm((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.Mdz = new h(this, paramAppCompatActivity);
    this.MdA = new g(this, paramAppCompatActivity);
    AppMethodBeat.o(287694);
  }
  
  private static int a(egz paramegz, String paramString1, String paramString2)
  {
    AppMethodBeat.i(287749);
    paramegz = paramegz.TZE;
    s.s(paramegz, "obj.sourceList");
    Object localObject1 = (Iterable)paramegz;
    paramegz = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (s.p(((egy)localObject2).LZD, paramString1)) {
        paramegz.add(localObject2);
      }
    }
    paramegz = (egy)p.ae((List)paramegz, 0);
    if (paramegz != null)
    {
      paramegz = paramegz.mew;
      if (paramegz != null)
      {
        paramegz = ((Iterable)paramegz).iterator();
        int i = 0;
        while (paramegz.hasNext())
        {
          paramString1 = paramegz.next();
          if (i < 0) {
            p.kkW();
          }
          if (s.p(((egx)paramString1).id, paramString2))
          {
            AppMethodBeat.o(287749);
            return i;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(287749);
    return 0;
  }
  
  private static final void a(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC, final com.tencent.mm.plugin.mv.ui.b.a.a parama)
  {
    AppMethodBeat.i(287762);
    s.u(paramMusicMvAlbumPreviewRecyclerUIC, "this$0");
    s.u(parama, "state");
    parama = parama.getAction();
    if ((parama != null) && ((parama instanceof com.tencent.mm.plugin.mv.ui.b.a.b)))
    {
      paramMusicMvAlbumPreviewRecyclerUIC.Mdv = new com.tencent.mm.plugin.mv.model.b.c(((com.tencent.mm.plugin.mv.ui.b.a.b)parama).McW);
      Object localObject = paramMusicMvAlbumPreviewRecyclerUIC.Mdv;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mv.model.b.c)localObject).LZD = ((com.tencent.mm.plugin.mv.ui.b.a.b)parama).McW.abmn;
      }
      localObject = paramMusicMvAlbumPreviewRecyclerUIC.Mdv;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.plugin.mvvmlist.a.f)localObject;
        com.tencent.mm.plugin.mvvmlist.e locale = new com.tencent.mm.plugin.mvvmlist.e();
        locale.wDG = true;
        ah localah = ah.aiuX;
        paramMusicMvAlbumPreviewRecyclerUIC.Mdw = new MvPreviewLiveList((com.tencent.mm.plugin.mvvmlist.a.f)localObject, locale);
      }
      localObject = paramMusicMvAlbumPreviewRecyclerUIC.Mdw;
      if (localObject != null) {
        paramMusicMvAlbumPreviewRecyclerUIC.Mdx = new com.tencent.mm.plugin.mvvmlist.g((MvvmList)localObject, (com.tencent.mm.view.recyclerview.g)new c(paramMusicMvAlbumPreviewRecyclerUIC), (byte)0);
      }
      paramMusicMvAlbumPreviewRecyclerUIC.getRecyclerView().setAdapter((RecyclerView.a)paramMusicMvAlbumPreviewRecyclerUIC.Mdx);
      paramMusicMvAlbumPreviewRecyclerUIC.getRecyclerView().setLayoutManager((RecyclerView.LayoutManager)paramMusicMvAlbumPreviewRecyclerUIC.fcq());
      paramMusicMvAlbumPreviewRecyclerUIC.gqv().a((RecyclerView)paramMusicMvAlbumPreviewRecyclerUIC.getRecyclerView());
      localObject = paramMusicMvAlbumPreviewRecyclerUIC.Mdw;
      if (localObject != null) {
        ((MvvmList)localObject).MmR.a((q)paramMusicMvAlbumPreviewRecyclerUIC.getActivity(), (y)new f(paramMusicMvAlbumPreviewRecyclerUIC, parama));
      }
    }
    AppMethodBeat.o(287762);
  }
  
  private static final void a(b paramb, MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC, View paramView)
  {
    AppMethodBeat.i(287771);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramMusicMvAlbumPreviewRecyclerUIC);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$dataUIC");
    s.u(paramMusicMvAlbumPreviewRecyclerUIC, "this$0");
    paramView = ((com.tencent.mm.plugin.mv.ui.b.a.a)paramb.getStateCenter().getState()).McX;
    if (paramView != null)
    {
      if ((paramView.LZI instanceof GalleryItem.VideoMediaItem))
      {
        localObject = paramView.LZI;
        if (localObject == null)
        {
          paramb = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem");
          AppMethodBeat.o(287771);
          throw paramb;
        }
        if (((GalleryItem.VideoMediaItem)localObject).oTN <= 2000)
        {
          new g.a((Context)paramMusicMvAlbumPreviewRecyclerUIC.getActivity()).bDE(paramMusicMvAlbumPreviewRecyclerUIC.getResources().getString(b.h.music_mv_flex_min_video_limit)).bDI(paramMusicMvAlbumPreviewRecyclerUIC.getResources().getString(b.h.app_i_know)).show();
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(287771);
          return;
        }
      }
      if (paramView.idG) {
        break label286;
      }
    }
    label286:
    for (boolean bool = true;; bool = false)
    {
      paramView.idG = bool;
      paramb.getStateCenter().dispatch((IStateAction)new com.tencent.mm.plugin.mv.ui.b.a.c(c.a.Mdc, paramView));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287771);
      return;
    }
  }
  
  private static final void b(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC, com.tencent.mm.plugin.mv.ui.b.a.a parama)
  {
    AppMethodBeat.i(287783);
    s.u(paramMusicMvAlbumPreviewRecyclerUIC, "this$0");
    s.u(parama, "state");
    IStateAction localIStateAction = parama.getAction();
    Object localObject;
    if ((localIStateAction != null) && ((localIStateAction instanceof com.tencent.mm.plugin.mv.ui.b.a.c)))
    {
      localObject = ((com.tencent.mm.plugin.mv.ui.b.a.c)localIStateAction).McY;
      switch (b.$EnumSwitchMapping$0[localObject.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(287783);
      return;
      paramMusicMvAlbumPreviewRecyclerUIC.gqx().setChecked(((com.tencent.mm.plugin.mv.ui.b.a.c)localIStateAction).McZ.idG);
      AppMethodBeat.o(287783);
      return;
      paramMusicMvAlbumPreviewRecyclerUIC.gqx().setChecked(((com.tencent.mm.plugin.mv.ui.b.a.c)localIStateAction).McZ.idG);
      localObject = paramMusicMvAlbumPreviewRecyclerUIC.Mdv;
      if (localObject != null) {
        ((com.tencent.mm.plugin.mv.model.b.c)localObject).LZD = ((com.tencent.mm.plugin.mv.ui.b.a.c)localIStateAction).McZ.LZD;
      }
      localObject = paramMusicMvAlbumPreviewRecyclerUIC.Mdw;
      if (localObject != null) {
        ((MvPreviewLiveList)localObject).gsy();
      }
      parama = parama.McW;
      if (parama != null)
      {
        paramMusicMvAlbumPreviewRecyclerUIC = paramMusicMvAlbumPreviewRecyclerUIC.Mdw;
        if (paramMusicMvAlbumPreviewRecyclerUIC != null) {
          paramMusicMvAlbumPreviewRecyclerUIC.MmM.pyl = a(parama, ((com.tencent.mm.plugin.mv.ui.b.a.c)localIStateAction).McZ.LZD, ((com.tencent.mm.plugin.mv.ui.b.a.c)localIStateAction).McZ.id);
        }
      }
    }
  }
  
  private final WxLinearLayoutManager fcq()
  {
    AppMethodBeat.i(287708);
    WxLinearLayoutManager localWxLinearLayoutManager = (WxLinearLayoutManager)this.EKZ.getValue();
    AppMethodBeat.o(287708);
    return localWxLinearLayoutManager;
  }
  
  private final WxRecyclerView getRecyclerView()
  {
    AppMethodBeat.i(287702);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(287702);
    return localWxRecyclerView;
  }
  
  private final com.tencent.mm.emoji.panel.layout.a gqv()
  {
    AppMethodBeat.i(287718);
    com.tencent.mm.emoji.panel.layout.a locala = (com.tencent.mm.emoji.panel.layout.a)this.Mdt.getValue();
    AppMethodBeat.o(287718);
    return locala;
  }
  
  private final com.tencent.mm.plugin.thumbplayer.view.recycler.a gqw()
  {
    AppMethodBeat.i(287728);
    com.tencent.mm.plugin.thumbplayer.view.recycler.a locala = (com.tencent.mm.plugin.thumbplayer.view.recycler.a)this.Mdu.getValue();
    AppMethodBeat.o(287728);
    return locala;
  }
  
  private final CheckBox gqx()
  {
    AppMethodBeat.i(287734);
    CheckBox localCheckBox = (CheckBox)this.Mdy.getValue();
    AppMethodBeat.o(287734);
    return localCheckBox;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287875);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = com.tencent.mm.ui.component.k.d(getActivity()).q(b.class);
    s.s(paramBundle, "UICProvider.of(activity)…eviewDataUIC::class.java)");
    paramBundle = (b)paramBundle;
    paramBundle.getStateCenter().process((q)getActivity(), (kotlin.g.a.b)e.MdC);
    paramBundle.getStateCenter().observe((q)getActivity(), new MusicMvAlbumPreviewRecyclerUIC..ExternalSyntheticLambda1(this));
    Util.expandViewTouchArea((View)gqx(), 100, 100, 100, 100);
    gqx().setOnClickListener(new MusicMvAlbumPreviewRecyclerUIC..ExternalSyntheticLambda0(paramBundle, this));
    paramBundle.getStateCenter().observe((q)getActivity(), new MusicMvAlbumPreviewRecyclerUIC..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(287875);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287884);
    com.tencent.mm.plugin.thumbplayer.view.recycler.a locala = gqw();
    Iterator localIterator = ((Iterable)locala.THN).iterator();
    com.tencent.mm.plugin.thumbplayer.e.b localb;
    while (localIterator.hasNext())
    {
      localb = ((MMRecyclerVideoLayout)localIterator.next()).getPlayer$plugin_thumbplayer_release();
      if (localb != null) {
        localb.recycle();
      }
    }
    localIterator = ((Map)locala.THO).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localb = ((MMRecyclerVideoLayout)((Map.Entry)localIterator.next()).getKey()).getPlayer$plugin_thumbplayer_release();
      if (localb != null) {
        localb.recycle();
      }
    }
    locala.THN.clear();
    locala.THO.clear();
    AppMethodBeat.o(287884);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$MvPreviewLiveList;", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC;Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;)V", "getLogTag", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class MvPreviewLiveList
    extends MvvmList<com.tencent.mm.plugin.mv.model.b.e>
  {
    public MvPreviewLiveList(com.tencent.mm.plugin.mvvmlist.e parame)
    {
      super(localObject, (q)MusicMvAlbumPreviewRecyclerUIC.this.getActivity());
      AppMethodBeat.i(288041);
      AppMethodBeat.o(288041);
    }
    
    public final String getLogTag()
    {
      return "MicroMsg.Mv.MusicMvAlbumPreviewRecyclerUIC";
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.g
  {
    c(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(287853);
      switch (paramInt)
      {
      case 2: 
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.mv.model.b.b(MusicMvAlbumPreviewRecyclerUIC.a(this.MdB));
        AppMethodBeat.o(287853);
        return localf;
      case 1: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.mv.model.b.a();
        AppMethodBeat.o(287853);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.mv.model.b.d(MusicMvAlbumPreviewRecyclerUIC.a(this.MdB));
      AppMethodBeat.o(287853);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxLinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<WxLinearLayoutManager>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/mv/ui/state/album/AlbumState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.mv.ui.b.a.a, ah>
  {
    public static final e MdC;
    
    static
    {
      AppMethodBeat.i(287817);
      MdC = new e();
      AppMethodBeat.o(287817);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$onCreate$2$1$3", "Landroidx/lifecycle/Observer;", "", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "onChanged", "", "t", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements y<List<? extends com.tencent.mm.plugin.mv.model.b.e>>
  {
    f(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC, IStateAction paramIStateAction) {}
    
    private static final void a(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC, IStateAction paramIStateAction)
    {
      AppMethodBeat.i(287831);
      s.u(paramMusicMvAlbumPreviewRecyclerUIC, "this$0");
      s.u(paramIStateAction, "$action");
      egz localegz = ((com.tencent.mm.plugin.mv.ui.b.a.b)paramIStateAction).McW;
      String str = ((com.tencent.mm.plugin.mv.ui.b.a.b)paramIStateAction).McW.abmn;
      Object localObject = str;
      if (str == null) {
        localObject = "";
      }
      str = ((com.tencent.mm.plugin.mv.ui.b.a.b)paramIStateAction).McW.abmo;
      paramIStateAction = str;
      if (str == null) {
        paramIStateAction = "";
      }
      int i = MusicMvAlbumPreviewRecyclerUIC.b(localegz, (String)localObject, paramIStateAction);
      paramIStateAction = MusicMvAlbumPreviewRecyclerUIC.e(paramMusicMvAlbumPreviewRecyclerUIC);
      localObject = com.tencent.mm.hellhoundlib.b.c.a(i, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramIStateAction, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$onCreate$2$1$3", "onChanged$lambda-1", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC;Lcom/tencent/mm/sdk/statecenter/IStateAction;)V", "Undefined", "scrollToPosition", "(I)V");
      paramIStateAction.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramIStateAction, "com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$onCreate$2$1$3", "onChanged$lambda-1", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC;Lcom/tencent/mm/sdk/statecenter/IStateAction;)V", "Undefined", "scrollToPosition", "(I)V");
      MusicMvAlbumPreviewRecyclerUIC.b(paramMusicMvAlbumPreviewRecyclerUIC).post(new MusicMvAlbumPreviewRecyclerUIC.f..ExternalSyntheticLambda0(paramMusicMvAlbumPreviewRecyclerUIC));
      AppMethodBeat.o(287831);
    }
    
    private static final void i(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC)
    {
      AppMethodBeat.i(287813);
      s.u(paramMusicMvAlbumPreviewRecyclerUIC, "this$0");
      MusicMvAlbumPreviewRecyclerUIC.d(paramMusicMvAlbumPreviewRecyclerUIC).aVV();
      AppMethodBeat.o(287813);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSelectedListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSelectedListener;", "onPageSelected", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements a.b
  {
    g(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC, AppCompatActivity paramAppCompatActivity) {}
    
    public final void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(287812);
      Object localObject1 = MusicMvAlbumPreviewRecyclerUIC.c(this.MdB);
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.mv.model.b.e)p.ae((List)((MvvmList)localObject1).pUj, paramInt);
        if (localObject1 != null)
        {
          Object localObject2 = paramAppCompatActivity;
          com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
          localObject2 = com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject2).q(b.class);
          s.s(localObject2, "UICProvider.of(activity)…eviewDataUIC::class.java)");
          ((b)localObject2).getStateCenter().dispatch((IStateAction)new com.tencent.mm.plugin.mv.ui.b.a.c(c.a.Mda, (com.tencent.mm.plugin.mv.model.b.e)localObject1));
        }
      }
      MusicMvAlbumPreviewRecyclerUIC.h(this.MdB);
      AppMethodBeat.o(287812);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/uic/MusicMvAlbumPreviewRecyclerUIC$pagerSettleListener$1", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper$OnPageSettledListener;", "onPageSettle", "", "position", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements a.c
  {
    h(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC, AppCompatActivity paramAppCompatActivity) {}
    
    public final void rL(int paramInt)
    {
      AppMethodBeat.i(287795);
      Object localObject1 = MusicMvAlbumPreviewRecyclerUIC.c(this.MdB);
      if (localObject1 != null)
      {
        localObject1 = (com.tencent.mm.plugin.mv.model.b.e)p.ae((List)((MvvmList)localObject1).pUj, paramInt);
        if (localObject1 != null)
        {
          Object localObject2 = paramAppCompatActivity;
          com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
          localObject2 = com.tencent.mm.ui.component.k.d((AppCompatActivity)localObject2).q(b.class);
          s.s(localObject2, "UICProvider.of(activity)…eviewDataUIC::class.java)");
          ((b)localObject2).getStateCenter().dispatch((IStateAction)new com.tencent.mm.plugin.mv.ui.b.a.c(c.a.Mda, (com.tencent.mm.plugin.mv.model.b.e)localObject1));
        }
      }
      AppMethodBeat.o(287795);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/emoji/panel/layout/CenterPagerSnapHelper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<com.tencent.mm.emoji.panel.layout.a>
  {
    i(MusicMvAlbumPreviewRecyclerUIC paramMusicMvAlbumPreviewRecyclerUIC)
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<CheckBox>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/thumbplayer/view/recycler/MMVideoLayoutRecycler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.thumbplayer.view.recycler.a>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvAlbumPreviewRecyclerUIC
 * JD-Core Version:    0.7.0.1
 */