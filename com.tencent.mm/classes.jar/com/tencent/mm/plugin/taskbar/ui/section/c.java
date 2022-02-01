package com.tencent.mm.plugin.taskbar.ui.section;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionEmptyView;", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView;", "context", "Landroid/content/Context;", "callback", "Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;", "sectionType", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionBaseView$Callback;ILandroid/util/AttributeSet;I)V", "emptyTitle", "Landroid/widget/TextView;", "notifyDataSetChanged", "", "titleName", "", "updateEmptyState", "isFull", "", "plugin-taskbar_release"})
@SuppressLint({"ViewConstructor"})
public final class c
  extends b
{
  private HashMap _$_findViewCache;
  public final TextView qco;
  
  private c(Context paramContext, b.a parama, int paramInt)
  {
    super(paramContext, parama, paramInt, null, 0);
    AppMethodBeat.i(238499);
    paramContext = LayoutInflater.from(paramContext).inflate(2131496662, (ViewGroup)getContainerView(), false);
    parama = paramContext.findViewById(2131300108);
    p.g(parama, "view.findViewById(R.id.empty_title)");
    this.qco = ((TextView)parama);
    p.g(paramContext, "view");
    fS(paramContext);
    AppMethodBeat.o(238499);
  }
  
  public c(Context paramContext, b.a parama, int paramInt, char paramChar)
  {
    this(paramContext, parama, paramInt, (byte)0);
  }
  
  public final View ewN()
  {
    AppMethodBeat.i(238500);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(2131299174));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(2131299174);
      this._$_findViewCache.put(Integer.valueOf(2131299174), localView1);
    }
    AppMethodBeat.o(238500);
    return localView1;
  }
  
  public final String fvi()
  {
    return "";
  }
  
  public final void notifyDataSetChanged() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.c
 * JD-Core Version:    0.7.0.1
 */