package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart
  extends Chart
{
  private Context context;
  public ArrayList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a> wYg;
  private c wYh;
  public TextView wYi;
  private RadarGrid wYj;
  private RadarDataLayer[] wYk;
  private a wYl;
  private boolean wYm;
  private boolean wYn;
  public int wYo;
  public int wYp;
  private int wYq;
  public Spannable[] wYr;
  private float wYs;
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96338);
    this.wYh = new c();
    this.wYm = true;
    this.wYn = true;
    this.wYo = 3;
    this.wYp = 0;
    this.wYq = 4;
    this.wYs = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96338);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96339);
    this.wYh = new c();
    this.wYm = true;
    this.wYn = true;
    this.wYo = 3;
    this.wYp = 0;
    this.wYq = 4;
    this.wYs = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96339);
  }
  
  public c getGridStyle()
  {
    AppMethodBeat.i(96343);
    if (this.wYj == null)
    {
      localc = this.wYh;
      AppMethodBeat.o(96343);
      return localc;
    }
    this.wYh = this.wYj.getGridStyle();
    c localc = this.wYj.getGridStyle();
    AppMethodBeat.o(96343);
    return localc;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96341);
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      getChildAt(paramInt1).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 += 1;
    }
    AppMethodBeat.o(96341);
  }
  
  public void setData(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a... paramVarArgs)
  {
    int k = 0;
    AppMethodBeat.i(96340);
    removeAllViews();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i].size() <= 0)
      {
        paramVarArgs = new Exception("Not enough elements.");
        AppMethodBeat.o(96340);
        throw paramVarArgs;
      }
      i += 1;
    }
    i = 0;
    while (i < paramVarArgs.length)
    {
      j = 0;
      while (j < paramVarArgs.length)
      {
        if (!paramVarArgs[i].a(paramVarArgs[j]))
        {
          paramVarArgs = new Error("Layer not compatible.");
          AppMethodBeat.o(96340);
          throw paramVarArgs;
        }
        j += 1;
      }
      i += 1;
    }
    this.wYr = paramVarArgs[0].dvH();
    this.wYp = paramVarArgs[0].size();
    if (this.wYg == null) {
      this.wYg = new ArrayList();
    }
    j = paramVarArgs.length;
    i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a locala = paramVarArgs[i];
      this.wYg.add(locala);
      i += 1;
    }
    this.wYj = new RadarGrid(this.context, this.wYp, this.wYq, this.wYs, this.wYr, this.wYh);
    addView(this.wYj);
    this.wYk = new RadarDataLayer[this.wYo];
    i = k;
    while ((i < this.wYk.length) && (this.wYg.size() > i))
    {
      this.wYk[i] = new RadarDataLayer(this.context, this.wYs, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a)this.wYg.get(i));
      addView(this.wYk[i]);
      i += 1;
    }
    if (this.wYl == null) {
      this.wYl = new a(this.context, this.wYh);
    }
    addView(this.wYl);
    AppMethodBeat.o(96340);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96342);
    this.wYh = paramc;
    if (this.wYj != null) {
      this.wYj.setGridStyle(paramc);
    }
    AppMethodBeat.o(96342);
  }
  
  public void setLatitudeNum(int paramInt)
  {
    this.wYq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart
 * JD-Core Version:    0.7.0.1
 */