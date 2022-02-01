package com.tencent.mm.plugin.taskbar.ui.section.other;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.c;
import com.tencent.mm.plugin.taskbar.d.b;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.d.a;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.a.ae;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.s;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$Adapter;", "layoutManager", "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$layoutManager$1", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$layoutManager$1;", "recyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView;", "thumbLoaderOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getThumbLoaderOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "type2ViewHelper", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "Lkotlin/collections/HashMap;", "canAddToMinimize", "", "pos", "initView", "", "notifyDataSetChanged", "notifyLiveStatusChanged", "removeItem", "reportViewAttachOnWindow", "titleName", "", "tryCloseOnPause", "Adapter", "BaseViewHolder", "Companion", "OtherRecyclerView", "plugin-taskbar_release"})
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.b
  implements b.a
{
  private static final int Mri;
  public static final a.c Mrj;
  private static final int YY;
  private final e FKT;
  private final d Mre;
  private final TaskBarSectionOtherView.layoutManager.1 Mrf;
  public final a Mrg;
  private final HashMap<Integer, b> Mrh;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(214322);
    Mrj = new a.c((byte)0);
    YY = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), d.b.Edge_4A);
    Mri = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), d.b.Edge_1_5_A);
    AppMethodBeat.o(214322);
  }
  
  private a(Context paramContext, com.tencent.mm.plugin.taskbar.ui.section.b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(214316);
    parama = new e.a();
    parama.kOp = true;
    parama.kOo = true;
    this.FKT = parama.aRT();
    this.Mre = new d(paramContext);
    this.Mrf = new TaskBarSectionOtherView.layoutManager.1(paramContext);
    this.Mrg = new a();
    this.Mrh = ae.g(new o[] { s.M(Integer.valueOf(2), new com.tencent.mm.plugin.taskbar.ui.section.e.a((b.a)this)), s.M(Integer.valueOf(6), new com.tencent.mm.plugin.taskbar.ui.section.c.a((b.a)this)), s.M(Integer.valueOf(21), new com.tencent.mm.plugin.taskbar.ui.section.b.a((b.a)this)), s.M(Integer.valueOf(3), new com.tencent.mm.plugin.taskbar.ui.section.a.a((b.a)this)), s.M(Integer.valueOf(4), new com.tencent.mm.plugin.taskbar.ui.section.a.a((b.a)this)), s.M(Integer.valueOf(22), new com.tencent.mm.plugin.taskbar.ui.section.d.a((b.a)this)) });
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.setMargins(YY - Mri / 2, 0, YY - Mri / 2, 0);
    getContainerView().addView((View)this.Mre, (ViewGroup.LayoutParams)paramContext);
    this.Mre.setLayoutManager((RecyclerView.LayoutManager)this.Mrf);
    this.Mre.setAdapter((RecyclerView.a)this.Mrg);
    this.Mre.setOverScrollMode(2);
    AppMethodBeat.o(214316);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.taskbar.ui.section.b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(214331);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(214331);
    return localView1;
  }
  
  public final boolean aja(int paramInt)
  {
    AppMethodBeat.i(214309);
    switch (((MultiTaskInfo)getViewModel().MqV.get(paramInt)).field_type)
    {
    default: 
      AppMethodBeat.o(214309);
      return true;
    }
    AppMethodBeat.o(214309);
    return false;
  }
  
  public final boolean ajb(int paramInt)
  {
    AppMethodBeat.i(214307);
    switch (((MultiTaskInfo)getViewModel().MqV.get(paramInt)).field_type)
    {
    case 3: 
    default: 
      AppMethodBeat.o(214307);
      return false;
    }
    AppMethodBeat.o(214307);
    return true;
  }
  
  public final void ajf(int paramInt)
  {
    AppMethodBeat.i(214312);
    super.o((MultiTaskInfo)getViewModel().MqV.get(paramInt));
    AppMethodBeat.o(214312);
  }
  
  protected final e getThumbLoaderOption()
  {
    return this.FKT;
  }
  
  public final String gkg()
  {
    AppMethodBeat.i(214298);
    Object localObject = com.tencent.mm.plugin.taskbar.ui.d.Mqf;
    int j = (int)Math.floor(d.a.gjV() / 3600000.0D);
    localObject = af.aaBG;
    localObject = getContext();
    if (j > 1) {}
    for (int i = d.g.MmR;; i = d.g.MmS)
    {
      localObject = com.tencent.mm.ci.a.ba((Context)localObject, i);
      p.j(localObject, "ResourceHelper.getString…bar_section_other_single)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
      p.j(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(214298);
      return localObject;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(214300);
    TextView localTextView = getTitle();
    if (localTextView != null) {
      localTextView.setText((CharSequence)gkg());
    }
    this.Mrg.notifyDataSetChanged();
    AppMethodBeat.o(214300);
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(214304);
    if ((paramInt < 0) || (paramInt >= getViewModel().MqV.size()))
    {
      Log.i("MicroMsg.TaskBarSectionOtherView", "remove item outOfBounds " + paramInt + ' ' + getViewModel().MqV.size());
      AppMethodBeat.o(214304);
      return;
    }
    MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)getViewModel().MqV.remove(paramInt);
    Log.i("MicroMsg.TaskBarSectionOtherView", "remove item " + paramInt + ' ' + localMultiTaskInfo.fbc().title + ' ' + localMultiTaskInfo.field_id);
    ((PluginTaskBar)h.ag(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
    ((c)h.ag(c.class)).removeTaskInfo(localMultiTaskInfo.field_id, true, 3);
    if (getViewModel().MqV.size() != 0)
    {
      this.Mrg.cN(paramInt);
      this.Mrg.e(0, this.Mrg.getItemCount(), Boolean.TRUE);
    }
    getCallback().aiX(getSectionType());
    AppMethodBeat.o(214304);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;)V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "pos", "holder", "position", "payloads", "", "", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "plugin-taskbar_release"})
  public final class a
    extends RecyclerView.a<a.b>
  {
    public final int getItemCount()
    {
      AppMethodBeat.i(214733);
      int i = this.Mrk.getViewModel().MqV.size();
      AppMethodBeat.o(214733);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "closeBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCloseBtn", "()Landroid/widget/ImageView;", "defaultImage", "getDefaultImage", "image", "getImage", "liveEndWidget", "getLiveEndWidget", "()Landroid/view/View;", "liveWidget", "getLiveWidget", "playBtn", "getPlayBtn", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "title", "getTitle", "plugin-taskbar_release"})
  public static final class b
    extends RecyclerView.v
  {
    public final ImageView KGj;
    public final ImageView Mrl;
    public final View Mrm;
    public final View Mrn;
    public final ImageView image;
    public final TextView jMg;
    final ImageView kHA;
    final TextView rsy;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(214791);
      this.Mrl = ((ImageView)paramView.findViewById(d.d.FIx));
      this.image = ((ImageView)paramView.findViewById(d.d.image));
      this.jMg = ((TextView)paramView.findViewById(d.d.title));
      this.rsy = ((TextView)paramView.findViewById(d.d.sub_title));
      this.kHA = ((ImageView)paramView.findViewById(d.d.close_btn));
      this.Mrm = paramView.findViewById(d.d.finder_live_icon);
      this.Mrn = paramView.findViewById(d.d.finder_live_end_tag);
      this.KGj = ((ImageView)paramView.findViewById(d.d.play_btn));
      AppMethodBeat.o(214791);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;Landroid/content/Context;)V", "viewWidth", "", "onAttachedToWindow", "", "onMeasure", "widthSpec", "heightSpec", "setClipChild", "updateItemOffset", "width", "plugin-taskbar_release"})
  public final class d
    extends RecyclerView
  {
    private int jBZ;
    
    public d()
    {
      super();
      AppMethodBeat.i(215286);
      AppMethodBeat.o(215286);
    }
    
    public final void onAttachedToWindow()
    {
      AppMethodBeat.i(215285);
      super.onAttachedToWindow();
      setClipChildren(false);
      View localView = getRootView();
      Object localObject = getParent();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(215285);
        throw ((Throwable)localObject);
      }
      for (localObject = (View)localObject; (localObject != localView) && ((localObject instanceof ViewGroup)); localObject = (View)localObject)
      {
        ((ViewGroup)localObject).setClipChildren(false);
        if ((localObject instanceof RecyclerView)) {
          break;
        }
        localObject = ((View)localObject).getParent();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(215285);
          throw ((Throwable)localObject);
        }
      }
      AppMethodBeat.o(215285);
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(215284);
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.jBZ)
      {
        this.jBZ = getMeasuredWidth();
        Context localContext = getContext();
        p.j(localContext, "context");
        while (getItemDecorationCount() > 0) {
          la();
        }
        b((RecyclerView.h)new a(localContext));
      }
      AppMethodBeat.o(215284);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView$updateItemOffset$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-taskbar_release"})
    public static final class a
      extends RecyclerView.h
    {
      a(Context paramContext) {}
      
      public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
      {
        AppMethodBeat.i(214915);
        p.k(paramRect, "outRect");
        p.k(paramView, "view");
        p.k(paramRecyclerView, "parent");
        p.k(params, "state");
        super.a(paramRect, paramView, paramRecyclerView, params);
        int j = RecyclerView.bh(paramView);
        int i = j;
        if (j == -1)
        {
          paramView = paramRecyclerView.aQ(paramView);
          p.j(paramView, "parent.getChildViewHolder(view)");
          i = paramView.me();
        }
        paramView = a.Mrj;
        paramRect.left = (a.gkj() / 2);
        paramView = a.Mrj;
        paramRect.right = (a.gkj() / 2);
        if (i / 3 > 0) {}
        for (paramRect.top = com.tencent.mm.ci.a.aZ(this.$context, d.b.Edge_2_5_A);; paramRect.top = 0)
        {
          paramRect.bottom = 0;
          AppMethodBeat.o(214915);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.other.a
 * JD-Core Version:    0.7.0.1
 */