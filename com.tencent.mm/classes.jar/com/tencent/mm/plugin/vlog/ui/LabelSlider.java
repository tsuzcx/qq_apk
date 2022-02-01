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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;)V", "labelChildren", "Ljava/util/LinkedList;", "Landroid/widget/TextView;", "labelCount", "labelGuideLines", "Landroidx/constraintlayout/widget/Guideline;", "labelPadding", "labelWidth", "labels", "", "trackView", "Lcom/tencent/mm/plugin/vlog/ui/SliderTrackView;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "refresh", "setLabelCount", "count", "setLabels", "labelList", "", "setSelection", "index", "setTrackColor", "color", "SliderCallback", "plugin-vlog_release"})
public final class LabelSlider
  extends ConstraintLayout
{
  private int NqZ;
  private int Nra;
  private int Nrb;
  private final SliderTrackView Nrc;
  private final LinkedList<Guideline> Nrd;
  private final LinkedList<TextView> Nre;
  private final LinkedList<CharSequence> Nrf;
  private a Nrg;
  private final String TAG;
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(242074);
    AppMethodBeat.o(242074);
  }
  
  public LabelSlider(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(242073);
    this.TAG = "MicroMsg.LabelSlider";
    this.NqZ = 5;
    this.Nra = 80;
    this.Nrb = 16;
    this.Nrd = new LinkedList();
    this.Nre = new LinkedList();
    this.Nrf = new LinkedList();
    this.Nrc = new SliderTrackView(paramContext);
    paramContext = paramContext.getDrawable(a.e.font_chooser_slider);
    if (paramContext != null) {}
    for (paramInt = paramContext.getIntrinsicHeight();; paramInt = 48)
    {
      paramAttributeSet = new ConstraintLayout.LayoutParams(-1, paramInt);
      paramAttributeSet.Fo = 0;
      paramAttributeSet.Fm = 0;
      paramAttributeSet.Fd = 0;
      addView((View)this.Nrc, (ViewGroup.LayoutParams)paramAttributeSet);
      this.Nrc.setThumbDrawable(paramContext);
      this.Nrc.setCallback((a)new a()
      {
        public final void Mc(int paramAnonymousInt)
        {
          AppMethodBeat.i(230267);
          LabelSlider.a locala = this.Nrh.getCallback();
          if (locala != null)
          {
            locala.Mc(paramAnonymousInt);
            AppMethodBeat.o(230267);
            return;
          }
          AppMethodBeat.o(230267);
        }
      });
      AppMethodBeat.o(242073);
      return;
    }
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(242072);
    this.Nrc.setPointCount(this.NqZ);
    Object localObject1 = this.Nrc;
    Object localObject2 = getContext();
    p.j(localObject2, "context");
    ((SliderTrackView)localObject1).setStartOffset(((Context)localObject2).getResources().getDimensionPixelOffset(a.d.Edge_5A));
    localObject1 = ((Iterable)this.Nre).iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((View)((Iterator)localObject1).next());
    }
    this.Nre.clear();
    localObject1 = ((Iterable)this.Nrd).iterator();
    while (((Iterator)localObject1).hasNext()) {
      removeView((View)((Iterator)localObject1).next());
    }
    this.Nrd.clear();
    if (getWidth() > 0)
    {
      localObject1 = ((Iterable)this.Nrc.getTrackPoint()).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.iBO();
        }
        float f = ((Number)localObject2).floatValue();
        localObject2 = new Guideline(getContext());
        ((Guideline)localObject2).setId(View.generateViewId());
        Object localObject3 = new ConstraintLayout.LayoutParams(0, 0);
        ((ConstraintLayout.LayoutParams)localObject3).Fm = 0;
        ((ConstraintLayout.LayoutParams)localObject3).Fl = 0;
        ((ConstraintLayout.LayoutParams)localObject3).FO = 1;
        ((ConstraintLayout.LayoutParams)localObject3).EW = ((int)f);
        addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        this.Nrd.add(localObject2);
        localObject3 = new TextView(getContext());
        ((TextView)localObject3).setText((CharSequence)j.M((List)this.Nrf, i));
        ((TextView)localObject3).setTextColor(-855638017);
        ((TextView)localObject3).setGravity(17);
        ConstraintLayout.LayoutParams localLayoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        localLayoutParams.Fe = this.Nrc.getId();
        localLayoutParams.Fm = ((Guideline)localObject2).getId();
        localLayoutParams.Fo = ((Guideline)localObject2).getId();
        localLayoutParams.Fg = 0;
        addView((View)localObject3, (ViewGroup.LayoutParams)localLayoutParams);
        this.Nre.add(localObject3);
        i += 1;
      }
    }
    AppMethodBeat.o(242072);
  }
  
  public final a getCallback()
  {
    return this.Nrg;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(242071);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    post((Runnable)new b(this));
    AppMethodBeat.o(242071);
  }
  
  public final void setCallback(a parama)
  {
    this.Nrg = parama;
  }
  
  public final void setLabelCount(int paramInt)
  {
    AppMethodBeat.i(242067);
    this.NqZ = paramInt;
    bfU();
    AppMethodBeat.o(242067);
  }
  
  public final void setLabels(List<? extends CharSequence> paramList)
  {
    AppMethodBeat.i(242068);
    p.k(paramList, "labelList");
    this.Nrf.clear();
    this.Nrf.addAll((Collection)paramList);
    paramList = ((Iterable)this.Nre).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        j.iBO();
      }
      ((TextView)localObject).setText((CharSequence)j.M((List)this.Nrf, i));
      i += 1;
    }
    AppMethodBeat.o(242068);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(242069);
    this.Nrc.setSelection(paramInt);
    AppMethodBeat.o(242069);
  }
  
  public final void setTrackColor(int paramInt)
  {
    AppMethodBeat.i(242066);
    this.Nrc.setTrackColor(paramInt);
    AppMethodBeat.o(242066);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/LabelSlider$SliderCallback;", "", "onSelected", "", "index", "", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void Mc(int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(LabelSlider paramLabelSlider) {}
    
    public final void run()
    {
      AppMethodBeat.i(248806);
      this.Nrh.bfU();
      AppMethodBeat.o(248806);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.LabelSlider
 * JD-Core Version:    0.7.0.1
 */