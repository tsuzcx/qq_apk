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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "labelChildren", "Ljava/util/LinkedList;", "Landroid/widget/TextView;", "labelCount", "labelGuideLines", "Landroid/support/constraint/Guideline;", "labelPadding", "labelWidth", "labels", "", "trackView", "Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "refresh", "setLabelCount", "count", "setLabels", "labelList", "", "setSelection", "index", "setTrackColor", "color", "SliderCallback", "plugin-vlog_release"})
public final class LabelSlider
  extends ConstraintLayout
{
  private final LinkedList<Guideline> CbA;
  private final LinkedList<TextView> CbB;
  private final LinkedList<CharSequence> CbC;
  private a CbD;
  private int Cbw;
  private int Cbx;
  private int Cby;
  private final SliderTrackView Cbz;
  private final String TAG;
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(191427);
    AppMethodBeat.o(191427);
  }
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(191426);
    this.TAG = "MicroMsg.LabelSlider";
    this.Cbw = 5;
    this.Cbx = 80;
    this.Cby = 16;
    this.CbA = new LinkedList();
    this.CbB = new LinkedList();
    this.CbC = new LinkedList();
    this.Cbz = new SliderTrackView(paramContext);
    paramContext = paramContext.getDrawable(2131232423);
    if (paramContext != null) {}
    for (paramInt = paramContext.getIntrinsicHeight();; paramInt = 48)
    {
      paramAttributeSet = new ConstraintLayout.LayoutParams(-1, paramInt);
      paramAttributeSet.endToEnd = 0;
      paramAttributeSet.startToStart = 0;
      paramAttributeSet.topToTop = 0;
      addView((View)this.Cbz, (ViewGroup.LayoutParams)paramAttributeSet);
      this.Cbz.setThumbDrawable(paramContext);
      this.Cbz.setCallback((a)new a()
      {
        public final void If(int paramAnonymousInt)
        {
          AppMethodBeat.i(191418);
          LabelSlider.a locala = this.CbE.getCallback();
          if (locala != null)
          {
            locala.If(paramAnonymousInt);
            AppMethodBeat.o(191418);
            return;
          }
          AppMethodBeat.o(191418);
        }
      });
      AppMethodBeat.o(191426);
      return;
    }
  }
  
  public final a getCallback()
  {
    return this.CbD;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(191424);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post((Runnable)new b(this));
    AppMethodBeat.o(191424);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(191425);
    this.Cbz.setPointCount(this.Cbw);
    Object localObject1 = this.Cbz;
    Object localObject2 = getContext();
    p.g(localObject2, "context");
    ((SliderTrackView)localObject1).setStartOffset(((Context)localObject2).getResources().getDimensionPixelOffset(2131165296));
    localObject1 = ((Iterable)this.CbB).iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((View)((Iterator)localObject1).next());
    }
    this.CbB.clear();
    localObject1 = ((Iterable)this.CbA).iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((View)((Iterator)localObject1).next());
    }
    this.CbA.clear();
    if (getWidth() > 0)
    {
      localObject1 = ((Iterable)this.Cbz.getTrackPoint()).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.gkd();
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
        this.CbA.add(localObject2);
        localObject3 = new TextView(getContext());
        ((TextView)localObject3).setText((CharSequence)j.F((List)this.CbC, i));
        ((TextView)localObject3).setTextColor(-855638017);
        ((TextView)localObject3).setGravity(17);
        ConstraintLayout.LayoutParams localLayoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        localLayoutParams.topToBottom = this.Cbz.getId();
        localLayoutParams.startToStart = ((Guideline)localObject2).getId();
        localLayoutParams.endToEnd = ((Guideline)localObject2).getId();
        localLayoutParams.bottomToBottom = 0;
        addView((View)localObject3, (ViewGroup.LayoutParams)localLayoutParams);
        this.CbB.add(localObject3);
        i += 1;
      }
    }
    AppMethodBeat.o(191425);
  }
  
  public final void setCallback(a parama)
  {
    this.CbD = parama;
  }
  
  public final void setLabelCount(int paramInt)
  {
    AppMethodBeat.i(191421);
    this.Cbw = paramInt;
    refresh();
    AppMethodBeat.o(191421);
  }
  
  public final void setLabels(List<? extends CharSequence> paramList)
  {
    AppMethodBeat.i(191422);
    p.h(paramList, "labelList");
    this.CbC.clear();
    this.CbC.addAll((Collection)paramList);
    paramList = ((Iterable)this.CbB).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        j.gkd();
      }
      ((TextView)localObject).setText((CharSequence)j.F((List)this.CbC, i));
      i += 1;
    }
    AppMethodBeat.o(191422);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(191423);
    this.Cbz.setSelection(paramInt);
    AppMethodBeat.o(191423);
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(191420);
    this.Cbz.setTrackColor(paramInt);
    AppMethodBeat.o(191420);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "", "onSelected", "", "index", "", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void If(int paramInt);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(LabelSlider paramLabelSlider) {}
    
    public final void run()
    {
      AppMethodBeat.i(191419);
      this.CbE.refresh();
      AppMethodBeat.o(191419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.LabelSlider
 * JD-Core Version:    0.7.0.1
 */