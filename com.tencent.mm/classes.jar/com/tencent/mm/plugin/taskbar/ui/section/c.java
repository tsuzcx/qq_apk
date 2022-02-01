package com.tencent.mm.plugin.taskbar.ui.section;

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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionEmptyView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "emptyTitle", "Landroid/widget/TextView;", "notifyDataSetChanged", "", "titleName", "", "updateEmptyState", "isFull", "", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  public final TextView wCJ;
  
  private c(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(264267);
    paramContext = LayoutInflater.from(paramContext).inflate(d.e.SQa, (ViewGroup)getContainerView(), false);
    parama = paramContext.findViewById(d.d.SPJ);
    s.s(parama, "view.findViewById(R.id.empty_title)");
    this.wCJ = ((TextView)parama);
    s.s(paramContext, "view");
    s.u(paramContext, "view");
    ((FrameLayout)findViewById(d.d.container)).addView(paramContext, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
    AppMethodBeat.o(264267);
  }
  
  public c(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
    AppMethodBeat.i(264278);
    AppMethodBeat.o(264278);
  }
  
  public final String hEf()
  {
    return "";
  }
  
  public final void notifyDataSetChanged() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.c
 * JD-Core Version:    0.7.0.1
 */