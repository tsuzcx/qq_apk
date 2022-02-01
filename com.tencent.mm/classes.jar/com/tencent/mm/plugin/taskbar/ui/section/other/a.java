package com.tencent.mm.plugin.taskbar.ui.section.other;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.b.e;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.PluginTaskBar;
import com.tencent.mm.plugin.taskbar.c;
import com.tencent.mm.plugin.taskbar.d.b;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.taskbar.ui.d.a;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper$Callback;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$Adapter;", "layoutManager", "com/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$layoutManager$1", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$layoutManager$1;", "recyclerView", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$OtherRecyclerView;", "thumbLoaderOption", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getThumbLoaderOption", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "type2ViewHelper", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherViewBaseHelper;", "Lkotlin/collections/HashMap;", "canAddToMinimize", "", "pos", "initView", "", "notifyDataSetChanged", "notifyLiveStatusChanged", "removeItem", "reportViewAttachOnWindow", "titleName", "", "tryCloseOnPause", "Adapter", "BaseViewHolder", "Companion", "OtherRecyclerView", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.taskbar.ui.section.b
  implements b.a
{
  public static final a.c SUg;
  private static final int SUl;
  private static final int bGt;
  private final e LGf;
  private final a.d SUh;
  private final TaskBarSectionOtherView.layoutManager.1 SUi;
  public final a SUj;
  private final HashMap<Integer, b> SUk;
  
  static
  {
    AppMethodBeat.i(264326);
    SUg = new a.c((byte)0);
    bGt = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), d.b.Edge_4A);
    SUl = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), d.b.Edge_1_5_A);
    AppMethodBeat.o(264326);
  }
  
  private a(Context paramContext, com.tencent.mm.plugin.taskbar.ui.section.b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(264290);
    parama = new e.a();
    parama.nqd = true;
    parama.nqc = true;
    this.LGf = parama.blI();
    this.SUh = new a.d(this, paramContext);
    this.SUi = new TaskBarSectionOtherView.layoutManager.1(paramContext);
    this.SUj = new a();
    this.SUk = ak.g(new r[] { v.Y(Integer.valueOf(2), new com.tencent.mm.plugin.taskbar.ui.section.e.a((b.a)this)), v.Y(Integer.valueOf(6), new com.tencent.mm.plugin.taskbar.ui.section.c.a((b.a)this)), v.Y(Integer.valueOf(21), new com.tencent.mm.plugin.taskbar.ui.section.b.a((b.a)this)), v.Y(Integer.valueOf(3), new com.tencent.mm.plugin.taskbar.ui.section.a.a((b.a)this)), v.Y(Integer.valueOf(4), new com.tencent.mm.plugin.taskbar.ui.section.a.a((b.a)this)), v.Y(Integer.valueOf(22), new com.tencent.mm.plugin.taskbar.ui.section.d.a((b.a)this)) });
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.setMargins(bGt - SUl / 2, 0, bGt - SUl / 2, 0);
    getContainerView().addView((View)this.SUh, (ViewGroup.LayoutParams)paramContext);
    this.SUh.setLayoutManager((RecyclerView.LayoutManager)this.SUi);
    this.SUh.setAdapter((RecyclerView.a)this.SUj);
    this.SUh.setOverScrollMode(2);
    AppMethodBeat.o(264290);
  }
  
  public a(Context paramContext, com.tencent.mm.plugin.taskbar.ui.section.b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
    AppMethodBeat.i(264301);
    AppMethodBeat.o(264301);
  }
  
  public final boolean aoc(int paramInt)
  {
    AppMethodBeat.i(264363);
    switch (((MultiTaskInfo)getViewModel().SUd.get(paramInt)).field_type)
    {
    default: 
      AppMethodBeat.o(264363);
      return true;
    }
    AppMethodBeat.o(264363);
    return false;
  }
  
  public final boolean aod(int paramInt)
  {
    AppMethodBeat.i(264357);
    switch (((MultiTaskInfo)getViewModel().SUd.get(paramInt)).field_type)
    {
    case 3: 
    default: 
      AppMethodBeat.o(264357);
      return false;
    }
    AppMethodBeat.o(264357);
    return true;
  }
  
  public final void aoh(int paramInt)
  {
    AppMethodBeat.i(264369);
    super.o((MultiTaskInfo)getViewModel().SUd.get(paramInt));
    AppMethodBeat.o(264369);
  }
  
  protected final e getThumbLoaderOption()
  {
    return this.LGf;
  }
  
  public final String hEf()
  {
    AppMethodBeat.i(264336);
    Object localObject = com.tencent.mm.plugin.taskbar.ui.d.STj;
    int j = (int)Math.floor(d.a.hDV() / 3600000.0D);
    localObject = am.aixg;
    localObject = getContext();
    if (j > 1) {}
    for (int i = d.g.SQk;; i = d.g.SQl)
    {
      localObject = com.tencent.mm.cd.a.bt((Context)localObject, i);
      s.s(localObject, "getString(context,\n     …bar_section_other_single)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(j) }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(264336);
      return localObject;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(264343);
    TextView localTextView = getTitle();
    if (localTextView != null) {
      localTextView.setText((CharSequence)hEf());
    }
    this.SUj.bZE.notifyChanged();
    AppMethodBeat.o(264343);
  }
  
  public final void removeItem(int paramInt)
  {
    AppMethodBeat.i(264353);
    if ((paramInt < 0) || (paramInt >= getViewModel().SUd.size()))
    {
      Log.i("MicroMsg.TaskBarSectionOtherView", "remove item outOfBounds " + paramInt + ' ' + getViewModel().SUd.size());
      AppMethodBeat.o(264353);
      return;
    }
    MultiTaskInfo localMultiTaskInfo = (MultiTaskInfo)getViewModel().SUd.remove(paramInt);
    Log.i("MicroMsg.TaskBarSectionOtherView", "remove item " + paramInt + ' ' + localMultiTaskInfo.gkh().title + ' ' + localMultiTaskInfo.field_id);
    ((PluginTaskBar)h.az(PluginTaskBar.class)).notifyRemoveTaskBarItem$plugin_taskbar_release(localMultiTaskInfo);
    ((c)h.az(c.class)).removeTaskInfo(localMultiTaskInfo.field_id, true, 3);
    if (getViewModel().SUd.size() != 0)
    {
      this.SUj.fX(paramInt);
      this.SUj.e(0, this.SUj.getItemCount(), Boolean.TRUE);
    }
    getCallback().anZ(getSectionType());
    AppMethodBeat.o(264353);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "(Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView;)V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "pos", "holder", "position", "payloads", "", "", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.a<a.b>
  {
    public a()
    {
      AppMethodBeat.i(264293);
      AppMethodBeat.o(264293);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(264298);
      int i = this.SUm.getViewModel().SUd.size();
      AppMethodBeat.o(264298);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/other/TaskBarSectionOtherView$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "closeBtn", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getCloseBtn", "()Landroid/widget/ImageView;", "defaultImage", "getDefaultImage", "image", "getImage", "liveEndWidget", "getLiveEndWidget", "()Landroid/view/View;", "liveWidget", "getLiveWidget", "playBtn", "getPlayBtn", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "title", "getTitle", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.v
  {
    public final ImageView Fjt;
    public final ImageView RfJ;
    public final ImageView SUn;
    public final View SUo;
    public final View SUp;
    public final TextView mll;
    final ImageView nkq;
    final TextView uCY;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(264285);
      this.SUn = ((ImageView)paramView.findViewById(d.d.LDH));
      this.Fjt = ((ImageView)paramView.findViewById(d.d.image));
      this.mll = ((TextView)paramView.findViewById(d.d.title));
      this.uCY = ((TextView)paramView.findViewById(d.d.sub_title));
      this.nkq = ((ImageView)paramView.findViewById(d.d.close_btn));
      this.SUo = paramView.findViewById(d.d.finder_live_icon);
      this.SUp = paramView.findViewById(d.d.finder_live_end_tag);
      this.RfJ = ((ImageView)paramView.findViewById(d.d.play_btn));
      AppMethodBeat.o(264285);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.other.a
 * JD-Core Version:    0.7.0.1
 */