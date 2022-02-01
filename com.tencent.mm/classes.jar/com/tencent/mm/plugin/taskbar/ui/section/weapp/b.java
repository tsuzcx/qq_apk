package com.tencent.mm.plugin.taskbar.ui.section.weapp;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.taskbar.ui.section.b.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionSearchView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "notifyDataSetChanged", "", "titleName", "", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.taskbar.ui.section.b
{
  private b(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(264392);
    getContainerView().setOnClickListener(new b..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(264392);
  }
  
  public b(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
    AppMethodBeat.i(264405);
    AppMethodBeat.o(264405);
  }
  
  private static final void a(b.a parama, View paramView)
  {
    AppMethodBeat.i(264416);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$callback");
    parama.hDI();
    a.a(new Object(), "com/tencent/mm/plugin/taskbar/ui/section/weapp/TaskBarSectionSearchView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(264416);
  }
  
  public final String hEf()
  {
    return "";
  }
  
  public final void notifyDataSetChanged() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.weapp.b
 * JD-Core Version:    0.7.0.1
 */