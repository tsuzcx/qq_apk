package com.tencent.mm.plugin.taskbar.ui.section;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.e;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionEmptyView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "emptyTitle", "Landroid/widget/TextView;", "notifyDataSetChanged", "", "titleName", "", "updateEmptyState", "isFull", "", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends b
{
  private HashMap _$_findViewCache;
  public final TextView tym;
  
  private c(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(214270);
    paramContext = LayoutInflater.from(paramContext).inflate(d.e.MmI, (ViewGroup)getContainerView(), false);
    parama = paramContext.findViewById(d.d.Mmt);
    p.j(parama, "view.findViewById(R.id.empty_title)");
    this.tym = ((TextView)parama);
    p.j(paramContext, "view");
    p.k(paramContext, "view");
    ((FrameLayout)_$_findCachedViewById(d.d.container)).addView(paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(214270);
  }
  
  public c(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(214275);
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
    AppMethodBeat.o(214275);
    return localView1;
  }
  
  public final String gkg()
  {
    return "";
  }
  
  public final void notifyDataSetChanged() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.c
 * JD-Core Version:    0.7.0.1
 */