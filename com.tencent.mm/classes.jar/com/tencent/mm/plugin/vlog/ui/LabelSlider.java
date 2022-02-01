package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.Guideline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "labelChildren", "Ljava/util/LinkedList;", "Landroid/widget/TextView;", "labelCount", "labelGuideLines", "Landroid/support/constraint/Guideline;", "labelPadding", "labelWidth", "labels", "", "trackView", "Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "refresh", "setLabelCount", "count", "setLabels", "labelList", "", "setSelection", "index", "setTrackColor", "color", "SliderCallback", "plugin-vlog_release"})
public final class LabelSlider
  extends ConstraintLayout
{
  private int BJX;
  private int BJY;
  private int BJZ;
  private final SliderTrackView BKa;
  private final LinkedList<Guideline> BKb;
  private final LinkedList<TextView> BKc;
  private final LinkedList<CharSequence> BKd;
  private LabelSlider.a BKe;
  private final String TAG;
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(195967);
    AppMethodBeat.o(195967);
  }
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195966);
    this.TAG = "MicroMsg.LabelSlider";
    this.BJX = 5;
    this.BJY = 80;
    this.BJZ = 16;
    this.BKb = new LinkedList();
    this.BKc = new LinkedList();
    this.BKd = new LinkedList();
    this.BKa = new SliderTrackView(paramContext);
    paramContext = paramContext.getDrawable(2131232423);
    if (paramContext != null) {}
    for (paramInt = paramContext.getIntrinsicHeight();; paramInt = 48)
    {
      paramAttributeSet = new ConstraintLayout.LayoutParams(-1, paramInt);
      paramAttributeSet.endToEnd = 0;
      paramAttributeSet.startToStart = 0;
      paramAttributeSet.topToTop = 0;
      addView((View)this.BKa, (ViewGroup.LayoutParams)paramAttributeSet);
      this.BKa.setThumbDrawable(paramContext);
      this.BKa.setCallback((LabelSlider.a)new LabelSlider.1(this));
      AppMethodBeat.o(195966);
      return;
    }
  }
  
  public final LabelSlider.a getCallback()
  {
    return this.BKe;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(195964);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post((Runnable)new LabelSlider.b(this));
    AppMethodBeat.o(195964);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(195965);
    this.BKa.setPointCount(this.BJX);
    Object localObject1 = this.BKa;
    Object localObject2 = getContext();
    p.g(localObject2, "context");
    ((SliderTrackView)localObject1).setStartOffset(((Context)localObject2).getResources().getDimensionPixelOffset(2131165296));
    localObject1 = ((Iterable)this.BKc).iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((View)((Iterator)localObject1).next());
    }
    this.BKc.clear();
    localObject1 = ((Iterable)this.BKb).iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((View)((Iterator)localObject1).next());
    }
    this.BKb.clear();
    if (getWidth() > 0)
    {
      localObject1 = ((Iterable)this.BKa.getTrackPoint()).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.gfB();
        }
        float f = ((Number)localObject2).floatValue();
        localObject2 = new Guideline(getContext());
        ((Guideline)localObject2).setId(View.generateViewId());
        Object localObject3 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams)localObject3).startToStart = 0;
        ((ConstraintLayout.LayoutParams)localObject3).startToEnd = 0;
        ((ConstraintLayout.LayoutParams)localObject3).orientation = 1;
        ((ConstraintLayout.LayoutParams)localObject3).guideBegin = ((int)f);
        addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        this.BKb.add(localObject2);
        localObject3 = new TextView(getContext());
        ((TextView)localObject3).setText((CharSequence)j.E((List)this.BKd, i));
        ((TextView)localObject3).setTextColor(-855638017);
        ((TextView)localObject3).setGravity(17);
        ConstraintLayout.LayoutParams localLayoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        localLayoutParams.topToBottom = this.BKa.getId();
        localLayoutParams.startToStart = ((Guideline)localObject2).getId();
        localLayoutParams.endToEnd = ((Guideline)localObject2).getId();
        localLayoutParams.bottomToBottom = 0;
        addView((View)localObject3, (ViewGroup.LayoutParams)localLayoutParams);
        this.BKc.add(localObject3);
        i += 1;
      }
    }
    AppMethodBeat.o(195965);
  }
  
  public final void setCallback(LabelSlider.a parama)
  {
    this.BKe = parama;
  }
  
  public final void setLabelCount(int paramInt)
  {
    AppMethodBeat.i(195961);
    this.BJX = paramInt;
    refresh();
    AppMethodBeat.o(195961);
  }
  
  public final void setLabels(List<? extends CharSequence> paramList)
  {
    AppMethodBeat.i(195962);
    p.h(paramList, "labelList");
    this.BKd.clear();
    this.BKd.addAll((Collection)paramList);
    paramList = ((Iterable)this.BKc).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        j.gfB();
      }
      ((TextView)localObject).setText((CharSequence)j.E((List)this.BKd, i));
      i += 1;
    }
    AppMethodBeat.o(195962);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(195963);
    this.BKa.setSelection(paramInt);
    AppMethodBeat.o(195963);
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(195960);
    this.BKa.setTrackColor(paramInt);
    AppMethodBeat.o(195960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.LabelSlider
 * JD-Core Version:    0.7.0.1
 */