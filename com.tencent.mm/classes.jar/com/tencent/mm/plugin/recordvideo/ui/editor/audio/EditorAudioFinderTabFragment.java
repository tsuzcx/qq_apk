package com.tencent.mm.plugin.recordvideo.ui.editor.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.recordvideo.b.b;
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderItem;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "emptyState", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getEmptyState", "()Landroid/view/View;", "emptyState$delegate", "Lkotlin/Lazy;", "finderRecycler", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getFinderRecycler", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "finderRecycler$delegate", "hasLoadData", "", "lastSelect", "loadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getLoadMoreLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "loadMoreLayout$delegate", "loadingState", "getLoadingState", "loadingState$delegate", "onFinderVideoSelectListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "fragment", "position", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "finderObject", "", "getOnFinderVideoSelectListener", "()Lkotlin/jvm/functions/Function3;", "setOnFinderVideoSelectListener", "(Lkotlin/jvm/functions/Function3;)V", "checkLoadData", "clearSelect", "destroy", "loadData", "onLoadData", "newData", "", "hasMoreData", "reset", "showContent", "showEmpty", "showLoading", "plugin-recordvideo_release"})
public abstract class EditorAudioFinderTabFragment
  extends FrameLayout
  implements com.tencent.mm.an.i
{
  private int IaX = -1;
  private final kotlin.f IaY = g.ar((kotlin.g.a.a)new c(this));
  private final kotlin.f IaZ = g.ar((kotlin.g.a.a)new b(this));
  private final kotlin.f Iba = g.ar((kotlin.g.a.a)new d(this));
  private final kotlin.f Ibb = g.ar((kotlin.g.a.a)new a(this));
  private kotlin.g.a.q<? super EditorAudioFinderTabFragment, ? super Integer, ? super FinderObject, x> Ibc;
  private final ArrayList<b> mXB = new ArrayList();
  private final WxRecyclerAdapter<b> xnR;
  private boolean zHJ;
  
  public EditorAudioFinderTabFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(b.f.video_editor_audio_finder_select_layout, (ViewGroup)this, true);
    this.xnR = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new com.tencent.mm.view.recyclerview.f()
    {
      public final e<?> yx(int paramAnonymousInt)
      {
        AppMethodBeat.i(219779);
        e locale = (e)new a();
        AppMethodBeat.o(219779);
        return locale;
      }
    }, this.mXB, true);
    this.xnR.YSn = ((h.c)new h.c() {});
    getLoadMoreLayout().setEnablePullDownHeader(false);
    getLoadMoreLayout().setEnableRefresh(false);
    getLoadMoreLayout().setActionCallback((RefreshLoadMoreLayout.a)new RefreshLoadMoreLayout.a()
    {
      public final void Ie(int paramAnonymousInt)
      {
        AppMethodBeat.i(220026);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
        super.Ie(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(220026);
      }
      
      public final void a(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(220025);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
        p.k(paramAnonymousc, "reason");
        if (!paramAnonymousc.YNF) {
          RefreshLoadMoreLayout.e(EditorAudioFinderTabFragment.c(this.Ibd));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(220025);
      }
      
      public final void cKQ()
      {
        AppMethodBeat.i(220022);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        this.Ibd.dlN();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(220022);
      }
      
      public final void onRefreshEnd(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(220027);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
        super.onRefreshEnd(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(220027);
      }
    });
    paramContext = getFinderRecycler();
    p.j(paramContext, "finderRecycler");
    paramContext.setAdapter((RecyclerView.a)this.xnR);
    paramContext = getFinderRecycler();
    p.j(paramContext, "finderRecycler");
    getContext();
    paramContext.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(3));
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = new c.a(paramContext).acI(b.c.editor_audio_select_finder_video_item_divider_space).acH(b.c.editor_audio_select_finder_video_item_divider_space).acG(b.b.BW_0);
    paramContext.CbQ = false;
    paramContext = paramContext.fyD();
    paramAttributeSet = getFinderRecycler();
    if (paramAttributeSet != null) {
      paramAttributeSet.b((RecyclerView.h)paramContext);
    }
    showLoading();
  }
  
  public EditorAudioFinderTabFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(b.f.video_editor_audio_finder_select_layout, (ViewGroup)this, true);
    this.xnR = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new com.tencent.mm.view.recyclerview.f()
    {
      public final e<?> yx(int paramAnonymousInt)
      {
        AppMethodBeat.i(219779);
        e locale = (e)new a();
        AppMethodBeat.o(219779);
        return locale;
      }
    }, this.mXB, true);
    this.xnR.YSn = ((h.c)new h.c() {});
    getLoadMoreLayout().setEnablePullDownHeader(false);
    getLoadMoreLayout().setEnableRefresh(false);
    getLoadMoreLayout().setActionCallback((RefreshLoadMoreLayout.a)new RefreshLoadMoreLayout.a()
    {
      public final void Ie(int paramAnonymousInt)
      {
        AppMethodBeat.i(220026);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.sg(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
        super.Ie(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(220026);
      }
      
      public final void a(RefreshLoadMoreLayout.c<Object> paramAnonymousc)
      {
        AppMethodBeat.i(220025);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
        p.k(paramAnonymousc, "reason");
        if (!paramAnonymousc.YNF) {
          RefreshLoadMoreLayout.e(EditorAudioFinderTabFragment.c(this.Ibd));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(220025);
      }
      
      public final void cKQ()
      {
        AppMethodBeat.i(220022);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        this.Ibd.dlN();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(220022);
      }
      
      public final void onRefreshEnd(RefreshLoadMoreLayout.c paramAnonymousc)
      {
        AppMethodBeat.i(220027);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
        super.onRefreshEnd(paramAnonymousc);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(220027);
      }
    });
    paramContext = getFinderRecycler();
    p.j(paramContext, "finderRecycler");
    paramContext.setAdapter((RecyclerView.a)this.xnR);
    paramContext = getFinderRecycler();
    p.j(paramContext, "finderRecycler");
    getContext();
    paramContext.setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(3));
    paramContext = getContext();
    p.j(paramContext, "context");
    paramContext = new c.a(paramContext).acI(b.c.editor_audio_select_finder_video_item_divider_space).acH(b.c.editor_audio_select_finder_video_item_divider_space).acG(b.b.BW_0);
    paramContext.CbQ = false;
    paramContext = paramContext.fyD();
    paramAttributeSet = getFinderRecycler();
    if (paramAttributeSet != null) {
      paramAttributeSet.b((RecyclerView.h)paramContext);
    }
    showLoading();
  }
  
  private final View getEmptyState()
  {
    return (View)this.Ibb.getValue();
  }
  
  private final WxRecyclerView getFinderRecycler()
  {
    return (WxRecyclerView)this.IaZ.getValue();
  }
  
  private final RefreshLoadMoreLayout getLoadMoreLayout()
  {
    return (RefreshLoadMoreLayout)this.IaY.getValue();
  }
  
  private final View getLoadingState()
  {
    return (View)this.Iba.getValue();
  }
  
  private final void showLoading()
  {
    Object localObject = getLoadingState();
    p.j(localObject, "loadingState");
    ((View)localObject).setVisibility(0);
    localObject = getEmptyState();
    p.j(localObject, "emptyState");
    ((View)localObject).setVisibility(8);
    localObject = getLoadMoreLayout();
    p.j(localObject, "loadMoreLayout");
    ((RefreshLoadMoreLayout)localObject).setVisibility(8);
  }
  
  public abstract void dlN();
  
  public final void fyC()
  {
    b localb = (b)j.M((List)this.mXB, this.IaX);
    if (localb != null) {
      localb.tsm = false;
    }
    this.xnR.d(this.IaX, Integer.valueOf(1));
    this.IaX = -1;
  }
  
  public final kotlin.g.a.q<EditorAudioFinderTabFragment, Integer, FinderObject, x> getOnFinderVideoSelectListener()
  {
    return this.Ibc;
  }
  
  protected final void n(List<? extends FinderObject> paramList, boolean paramBoolean)
  {
    p.k(paramList, "newData");
    int i = this.mXB.size();
    int j = paramList.size();
    int k = this.mXB.size();
    ArrayList localArrayList = this.mXB;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(new b((FinderObject)((Iterator)localObject).next(), (byte)0));
    }
    localArrayList.addAll((Collection)paramList);
    this.xnR.aG(i, j);
    if ((k == 0) && (j == 0))
    {
      paramList = getLoadingState();
      p.j(paramList, "loadingState");
      paramList.setVisibility(8);
      paramList = getEmptyState();
      p.j(paramList, "emptyState");
      paramList.setVisibility(0);
      paramList = getLoadMoreLayout();
      p.j(paramList, "loadMoreLayout");
      paramList.setVisibility(8);
      return;
    }
    if ((k == 0) && (j > 0))
    {
      paramList = getLoadingState();
      p.j(paramList, "loadingState");
      paramList.setVisibility(8);
      paramList = getEmptyState();
      p.j(paramList, "emptyState");
      paramList.setVisibility(8);
      paramList = getLoadMoreLayout();
      p.j(paramList, "loadMoreLayout");
      paramList.setVisibility(0);
      return;
    }
    paramList = RefreshLoadMoreLayout.c.YNO;
    paramList = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.iht());
    paramList.YNF = paramBoolean;
    getLoadMoreLayout().k(paramList);
  }
  
  public void reset()
  {
    fyC();
    WxRecyclerView localWxRecyclerView = getFinderRecycler();
    com.tencent.mm.hellhoundlib.b.a locala = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, locala.aFh(), "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    localWxRecyclerView.scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/recordvideo/ui/editor/audio/EditorAudioFinderTabFragment", "reset", "()V", "Undefined", "scrollToPosition", "(I)V");
    if (!this.zHJ)
    {
      this.zHJ = true;
      dlN();
    }
  }
  
  public final void setOnFinderVideoSelectListener(kotlin.g.a.q<? super EditorAudioFinderTabFragment, ? super Integer, ? super FinderObject, x> paramq)
  {
    this.Ibc = paramq;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    a(EditorAudioFinderTabFragment paramEditorAudioFinderTabFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WxRecyclerView>
  {
    b(EditorAudioFinderTabFragment paramEditorAudioFinderTabFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RefreshLoadMoreLayout>
  {
    c(EditorAudioFinderTabFragment paramEditorAudioFinderTabFragment)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    d(EditorAudioFinderTabFragment paramEditorAudioFinderTabFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioFinderTabFragment
 * JD-Core Version:    0.7.0.1
 */