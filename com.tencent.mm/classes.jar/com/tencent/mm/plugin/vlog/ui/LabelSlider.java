package com.tencent.mm.plugin.vlog.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.Guideline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.a.e;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "labelChildren", "Ljava/util/LinkedList;", "Landroid/widget/TextView;", "labelCount", "labelGuideLines", "Landroidx/constraintlayout/widget/Guideline;", "labelPadding", "labelWidth", "labels", "", "trackView", "Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "refresh", "setLabelCount", "count", "setLabels", "labelList", "", "setSelection", "index", "setTrackColor", "color", "SliderCallback", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LabelSlider
  extends ConstraintLayout
{
  private final String TAG;
  private int UeJ;
  private int UeK;
  private int UeL;
  private final SliderTrackView UeM;
  private final LinkedList<Guideline> UeN;
  private final LinkedList<TextView> UeO;
  private final LinkedList<CharSequence> UeP;
  private a UeQ;
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(281382);
    AppMethodBeat.o(281382);
  }
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281377);
    this.TAG = "MicroMsg.LabelSlider";
    this.UeJ = 5;
    this.UeK = 80;
    this.UeL = 16;
    this.UeN = new LinkedList();
    this.UeO = new LinkedList();
    this.UeP = new LinkedList();
    this.UeM = new SliderTrackView(paramContext);
    paramContext = paramContext.getDrawable(a.e.font_chooser_slider);
    if (paramContext == null) {}
    for (paramInt = 48;; paramInt = paramContext.getIntrinsicHeight())
    {
      paramAttributeSet = new ConstraintLayout.LayoutParams(-1, paramInt);
      paramAttributeSet.blv = 0;
      paramAttributeSet.blt = 0;
      paramAttributeSet.blk = 0;
      addView((View)this.UeM, (ViewGroup.LayoutParams)paramAttributeSet);
      this.UeM.setThumbDrawable(paramContext);
      this.UeM.setCallback((a)new a()
      {
        public final void Ng(int paramAnonymousInt)
        {
          AppMethodBeat.i(281526);
          LabelSlider.a locala = this.UeR.getCallback();
          if (locala != null) {
            locala.Ng(paramAnonymousInt);
          }
          AppMethodBeat.o(281526);
        }
      });
      AppMethodBeat.o(281377);
      return;
    }
  }
  
  private static final void a(LabelSlider paramLabelSlider)
  {
    AppMethodBeat.i(281394);
    s.u(paramLabelSlider, "this$0");
    paramLabelSlider.bDL();
    AppMethodBeat.o(281394);
  }
  
  private void bDL()
  {
    AppMethodBeat.i(281391);
    this.UeM.setPointCount(this.UeJ);
    this.UeM.setStartOffset(getContext().getResources().getDimensionPixelOffset(a.d.Edge_5A));
    Iterator localIterator = ((Iterable)this.UeO).iterator();
    while (localIterator.hasNext()) {
      removeView((View)localIterator.next());
    }
    this.UeO.clear();
    localIterator = ((Iterable)this.UeN).iterator();
    while (localIterator.hasNext()) {
      removeView((View)localIterator.next());
    }
    this.UeN.clear();
    if (getWidth() > 0)
    {
      localIterator = ((Iterable)this.UeM.getTrackPoint()).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        float f = ((Number)localObject1).floatValue();
        localObject1 = new Guideline(getContext());
        ((Guideline)localObject1).setId(View.generateViewId());
        Object localObject2 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams)localObject2).blt = 0;
        ((ConstraintLayout.LayoutParams)localObject2).bls = 0;
        ((ConstraintLayout.LayoutParams)localObject2).orientation = 1;
        ((ConstraintLayout.LayoutParams)localObject2).bld = ((int)f);
        addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        this.UeN.add(localObject1);
        localObject2 = new TextView(getContext());
        ((TextView)localObject2).setText((CharSequence)p.ae((List)this.UeP, i));
        ((TextView)localObject2).setTextColor(-855638017);
        ((TextView)localObject2).setGravity(17);
        ConstraintLayout.LayoutParams localLayoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        localLayoutParams.bll = this.UeM.getId();
        localLayoutParams.blt = ((Guideline)localObject1).getId();
        localLayoutParams.blv = ((Guideline)localObject1).getId();
        localLayoutParams.bln = 0;
        addView((View)localObject2, (ViewGroup.LayoutParams)localLayoutParams);
        this.UeO.add(localObject2);
        i += 1;
      }
    }
    AppMethodBeat.o(281391);
  }
  
  public final a getCallback()
  {
    return this.UeQ;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(281427);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post(new LabelSlider..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(281427);
  }
  
  public final void setCallback(a parama)
  {
    this.UeQ = parama;
  }
  
  public final void setLabelCount(int paramInt)
  {
    AppMethodBeat.i(281413);
    this.UeJ = paramInt;
    bDL();
    AppMethodBeat.o(281413);
  }
  
  public final void setLabels(List<? extends CharSequence> paramList)
  {
    AppMethodBeat.i(281418);
    s.u(paramList, "labelList");
    this.UeP.clear();
    this.UeP.addAll((Collection)paramList);
    paramList = ((Iterable)this.UeO).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      ((TextView)localObject).setText((CharSequence)p.ae((List)this.UeP, i));
      i += 1;
    }
    AppMethodBeat.o(281418);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(281422);
    this.UeM.setSelection(paramInt);
    AppMethodBeat.o(281422);
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(281409);
    this.UeM.setTrackColor(paramInt);
    AppMethodBeat.o(281409);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "", "onSelected", "", "index", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void Ng(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.LabelSlider
 * JD-Core Version:    0.7.0.1
 */