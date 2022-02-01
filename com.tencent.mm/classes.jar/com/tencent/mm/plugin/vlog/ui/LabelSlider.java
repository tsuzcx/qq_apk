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
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "Landroid/support/constraint/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "labelChildren", "Ljava/util/LinkedList;", "Landroid/widget/TextView;", "labelCount", "labelGuideLines", "Landroid/support/constraint/Guideline;", "labelPadding", "labelWidth", "labels", "", "trackView", "Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "refresh", "setLabelCount", "count", "setLabels", "labelList", "", "setSelection", "index", "setTrackColor", "color", "SliderCallback", "plugin-vlog_release"})
public final class LabelSlider
  extends ConstraintLayout
{
  private int GDn;
  private int GDo;
  private int GDp;
  private final SliderTrackView GDq;
  private final LinkedList<Guideline> GDr;
  private final LinkedList<TextView> GDs;
  private final LinkedList<CharSequence> GDt;
  private a GDu;
  private final String TAG;
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(190904);
    AppMethodBeat.o(190904);
  }
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190903);
    this.TAG = "MicroMsg.LabelSlider";
    this.GDn = 5;
    this.GDo = 80;
    this.GDp = 16;
    this.GDr = new LinkedList();
    this.GDs = new LinkedList();
    this.GDt = new LinkedList();
    this.GDq = new SliderTrackView(paramContext);
    paramContext = paramContext.getDrawable(2131232802);
    if (paramContext != null) {}
    for (paramInt = paramContext.getIntrinsicHeight();; paramInt = 48)
    {
      paramAttributeSet = new ConstraintLayout.LayoutParams(-1, paramInt);
      paramAttributeSet.endToEnd = 0;
      paramAttributeSet.startToStart = 0;
      paramAttributeSet.topToTop = 0;
      addView((View)this.GDq, (ViewGroup.LayoutParams)paramAttributeSet);
      this.GDq.setThumbDrawable(paramContext);
      this.GDq.setCallback((a)new a()
      {
        public final void Ir(int paramAnonymousInt)
        {
          AppMethodBeat.i(190895);
          LabelSlider.a locala = this.GDv.getCallback();
          if (locala != null)
          {
            locala.Ir(paramAnonymousInt);
            AppMethodBeat.o(190895);
            return;
          }
          AppMethodBeat.o(190895);
        }
      });
      AppMethodBeat.o(190903);
      return;
    }
  }
  
  public final a getCallback()
  {
    return this.GDu;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190901);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post((Runnable)new b(this));
    AppMethodBeat.o(190901);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(190902);
    this.GDq.setPointCount(this.GDn);
    Object localObject1 = this.GDq;
    Object localObject2 = getContext();
    p.g(localObject2, "context");
    ((SliderTrackView)localObject1).setStartOffset(((Context)localObject2).getResources().getDimensionPixelOffset(2131165306));
    localObject1 = ((Iterable)this.GDs).iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((View)((Iterator)localObject1).next());
    }
    this.GDs.clear();
    localObject1 = ((Iterable)this.GDr).iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((View)((Iterator)localObject1).next());
    }
    this.GDr.clear();
    if (getWidth() > 0)
    {
      localObject1 = ((Iterable)this.GDq.getTrackPoint()).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.hxH();
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
        this.GDr.add(localObject2);
        localObject3 = new TextView(getContext());
        ((TextView)localObject3).setText((CharSequence)j.L((List)this.GDt, i));
        ((TextView)localObject3).setTextColor(-855638017);
        ((TextView)localObject3).setGravity(17);
        ConstraintLayout.LayoutParams localLayoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        localLayoutParams.topToBottom = this.GDq.getId();
        localLayoutParams.startToStart = ((Guideline)localObject2).getId();
        localLayoutParams.endToEnd = ((Guideline)localObject2).getId();
        localLayoutParams.bottomToBottom = 0;
        addView((View)localObject3, (ViewGroup.LayoutParams)localLayoutParams);
        this.GDs.add(localObject3);
        i += 1;
      }
    }
    AppMethodBeat.o(190902);
  }
  
  public final void setCallback(a parama)
  {
    this.GDu = parama;
  }
  
  public final void setLabelCount(int paramInt)
  {
    AppMethodBeat.i(190898);
    this.GDn = paramInt;
    refresh();
    AppMethodBeat.o(190898);
  }
  
  public final void setLabels(List<? extends CharSequence> paramList)
  {
    AppMethodBeat.i(190899);
    p.h(paramList, "labelList");
    this.GDt.clear();
    this.GDt.addAll((Collection)paramList);
    paramList = ((Iterable)this.GDs).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        j.hxH();
      }
      ((TextView)localObject).setText((CharSequence)j.L((List)this.GDt, i));
      i += 1;
    }
    AppMethodBeat.o(190899);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(190900);
    this.GDq.setSelection(paramInt);
    AppMethodBeat.o(190900);
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(190897);
    this.GDq.setTrackColor(paramInt);
    AppMethodBeat.o(190897);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "", "onSelected", "", "index", "", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void Ir(int paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(LabelSlider paramLabelSlider) {}
    
    public final void run()
    {
      AppMethodBeat.i(190896);
      this.GDv.refresh();
      AppMethodBeat.o(190896);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.LabelSlider
 * JD-Core Version:    0.7.0.1
 */