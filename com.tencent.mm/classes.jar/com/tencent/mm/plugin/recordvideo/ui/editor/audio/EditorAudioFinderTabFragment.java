package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderItem;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "emptyState", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getEmptyState", "()Landroid/view/View;", "emptyState$delegate", "Lkotlin/Lazy;", "finderRecycler", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getFinderRecycler", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "finderRecycler$delegate", "hasLoadData", "", "lastSelect", "loadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getLoadMoreLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "loadMoreLayout$delegate", "loadingState", "getLoadingState", "loadingState$delegate", "onFinderVideoSelectListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "fragment", "position", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderObject", "", "getOnFinderVideoSelectListener", "()Lkotlin/jvm/functions/Function3;", "setOnFinderVideoSelectListener", "(Lkotlin/jvm/functions/Function3;)V", "checkLoadData", "clearSelect", "destroy", "loadData", "onLoadData", "newData", "", "hasMoreData", "reset", "showContent", "showEmpty", "showLoading", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class EditorAudioFinderTabFragment
  extends FrameLayout
  implements h
{
  private final WxRecyclerAdapter<b> ALE;
  private boolean EPm;
  private final kotlin.j NXA = k.cm((kotlin.g.a.a)new d(this));
  private final kotlin.j NXB = k.cm((kotlin.g.a.a)new a(this));
  private q<? super EditorAudioFinderTabFragment, ? super Integer, ? super FinderObject, ah> NXC;
  private int NXx = -1;
  private final kotlin.j NXy = k.cm((kotlin.g.a.a)new c(this));
  private final kotlin.j NXz = k.cm((kotlin.g.a.a)new b(this));
  private final ArrayList<b> pUj = new ArrayList();
  
  public EditorAudioFinderTabFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(b.f.video_editor_audio_finder_select_layout, (ViewGroup)this, true);
    this.ALE = new WxRecyclerAdapter((g)new g()
    {
      public final f<?> yF(int paramAnonymousInt)
      {
        AppMethodBeat.i(280045);
        f localf = (f)new a();
        AppMethodBeat.o(280045);
        return localf;
      }
    }, this.pUj, true);
    this.ALE.agOe = ((i.c)new i.c() {});
    getLoadMoreLayout().setEnablePullDownHeader(false);
    getLoadMoreLayout().setEnableRefresh(false);
    getLoadMoreLayout().setActionCallback((RefreshLoadMoreLayout.b)new RefreshLoadMoreLayout.b()
    {
      public final void a(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(280071);
        s.u(paramAnonymousd, "reason");
        if (!paramAnonymousd.agJu)
        {
          paramAnonymousd = EditorAudioFinderTabFragment.c(this.NXD);
          s.s(paramAnonymousd, "loadMoreLayout");
          RefreshLoadMoreLayout.e(paramAnonymousd);
        }
        AppMethodBeat.o(280071);
      }
      
      public final void qI(int paramAnonymousInt)
      {
        AppMethodBeat.i(280056);
        this.NXD.dSD();
        AppMethodBeat.o(280056);
      }
    });
    getFinderRecycler().setAdapter((RecyclerView.a)this.ALE);
    paramContext = getFinderRecycler();
    getContext();
    paramContext.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(3));
    paramContext = getContext();
    s.s(paramContext, "context");
    paramContext = new c.a(paramContext).agY(b.c.editor_audio_select_finder_video_item_divider_space).agX(b.c.editor_audio_select_finder_video_item_divider_space).agW(b.b.BW_0);
    paramContext.HNS = false;
    paramContext = paramContext.gKo();
    paramAttributeSet = getFinderRecycler();
    if (paramAttributeSet != null) {
      paramAttributeSet.a((RecyclerView.h)paramContext);
    }
    showLoading();
  }
  
  public EditorAudioFinderTabFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(b.f.video_editor_audio_finder_select_layout, (ViewGroup)this, true);
    this.ALE = new WxRecyclerAdapter((g)new g()
    {
      public final f<?> yF(int paramAnonymousInt)
      {
        AppMethodBeat.i(280045);
        f localf = (f)new a();
        AppMethodBeat.o(280045);
        return localf;
      }
    }, this.pUj, true);
    this.ALE.agOe = ((i.c)new i.c() {});
    getLoadMoreLayout().setEnablePullDownHeader(false);
    getLoadMoreLayout().setEnableRefresh(false);
    getLoadMoreLayout().setActionCallback((RefreshLoadMoreLayout.b)new RefreshLoadMoreLayout.b()
    {
      public final void a(RefreshLoadMoreLayout.d<Object> paramAnonymousd)
      {
        AppMethodBeat.i(280071);
        s.u(paramAnonymousd, "reason");
        if (!paramAnonymousd.agJu)
        {
          paramAnonymousd = EditorAudioFinderTabFragment.c(this.NXD);
          s.s(paramAnonymousd, "loadMoreLayout");
          RefreshLoadMoreLayout.e(paramAnonymousd);
        }
        AppMethodBeat.o(280071);
      }
      
      public final void qI(int paramAnonymousInt)
      {
        AppMethodBeat.i(280056);
        this.NXD.dSD();
        AppMethodBeat.o(280056);
      }
    });
    getFinderRecycler().setAdapter((RecyclerView.a)this.ALE);
    paramContext = getFinderRecycler();
    getContext();
    paramContext.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(3));
    paramContext = getContext();
    s.s(paramContext, "context");
    paramContext = new c.a(paramContext).agY(b.c.editor_audio_select_finder_video_item_divider_space).agX(b.c.editor_audio_select_finder_video_item_divider_space).agW(b.b.BW_0);
    paramContext.HNS = false;
    paramContext = paramContext.gKo();
    paramAttributeSet = getFinderRecycler();
    if (paramAttributeSet != null) {
      paramAttributeSet.a((RecyclerView.h)paramContext);
    }
    showLoading();
  }
  
  private final View getEmptyState()
  {
    return (View)this.NXB.getValue();
  }
  
  private final WxRecyclerView getFinderRecycler()
  {
    return (WxRecyclerView)this.NXz.getValue();
  }
  
  private final RefreshLoadMoreLayout getLoadMoreLayout()
  {
    return (RefreshLoadMoreLayout)this.NXy.getValue();
  }
  
  private final View getLoadingState()
  {
    return (View)this.NXA.getValue();
  }
  
  private final void showLoading()
  {
    getLoadingState().setVisibility(0);
    getEmptyState().setVisibility(8);
    getLoadMoreLayout().setVisibility(8);
  }
  
  protected final void B(List<? extends FinderObject> paramList, boolean paramBoolean)
  {
    s.u(paramList, "newData");
    int i = this.pUj.size();
    int j = paramList.size();
    int k = this.pUj.size();
    ArrayList localArrayList = this.pUj;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(new b((FinderObject)((Iterator)localObject).next(), (byte)0));
    }
    localArrayList.addAll((Collection)paramList);
    this.ALE.bA(i, j);
    if ((k == 0) && (j == 0))
    {
      getLoadingState().setVisibility(8);
      getEmptyState().setVisibility(0);
      getLoadMoreLayout().setVisibility(8);
      return;
    }
    if ((k == 0) && (j > 0))
    {
      getLoadingState().setVisibility(8);
      getEmptyState().setVisibility(8);
      getLoadMoreLayout().setVisibility(0);
      return;
    }
    paramList = RefreshLoadMoreLayout.d.agJr;
    paramList = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMH());
    paramList.agJu = paramBoolean;
    getLoadMoreLayout().l(paramList);
  }
  
  public abstract void dSD();
  
  public final void gKn()
  {
    b localb = (b)p.ae((List)this.pUj, this.NXx);
    if (localb != null) {
      localb.wwJ = false;
    }
    this.ALE.t(this.NXx, Integer.valueOf(1));
    this.NXx = -1;
  }
  
  public final q<EditorAudioFinderTabFragment, Integer, FinderObject, ah> getOnFinderVideoSelectListener()
  {
    return this.NXC;
  }
  
  public void reset()
  {
    gKn();
    WxRecyclerView localWxRecyclerView = getFinderRecycler();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, locala.aYi(), "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    localWxRecyclerView.scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    if (!this.EPm)
    {
      this.EPm = true;
      dSD();
    }
  }
  
  public final void setOnFinderVideoSelectListener(q<? super EditorAudioFinderTabFragment, ? super Integer, ? super FinderObject, ah> paramq)
  {
    this.NXC = paramq;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<View>
  {
    a(EditorAudioFinderTabFragment paramEditorAudioFinderTabFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<WxRecyclerView>
  {
    b(EditorAudioFinderTabFragment paramEditorAudioFinderTabFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    c(EditorAudioFinderTabFragment paramEditorAudioFinderTabFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(EditorAudioFinderTabFragment paramEditorAudioFinderTabFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioFinderTabFragment
 * JD-Core Version:    0.7.0.1
 */