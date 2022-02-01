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
  public ArrayList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a> EaV;
  private c EaW;
  public TextView EaX;
  private RadarGrid EaY;
  private RadarDataLayer[] EaZ;
  private a Eba;
  private boolean Ebb;
  private boolean Ebc;
  public int Ebd;
  public int Ebe;
  private int Ebf;
  public Spannable[] Ebg;
  private Context context;
  private float maxValue;
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96338);
    this.EaW = new c();
    this.Ebb = true;
    this.Ebc = true;
    this.Ebd = 3;
    this.Ebe = 0;
    this.Ebf = 4;
    this.maxValue = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96338);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96339);
    this.EaW = new c();
    this.Ebb = true;
    this.Ebc = true;
    this.Ebd = 3;
    this.Ebe = 0;
    this.Ebf = 4;
    this.maxValue = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96339);
  }
  
  public c getGridStyle()
  {
    AppMethodBeat.i(96343);
    if (this.EaY == null)
    {
      localc = this.EaW;
      AppMethodBeat.o(96343);
      return localc;
    }
    this.EaW = this.EaY.getGridStyle();
    c localc = this.EaY.getGridStyle();
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
    this.Ebg = paramVarArgs[0].fcQ();
    this.Ebe = paramVarArgs[0].size();
    if (this.EaV == null) {
      this.EaV = new ArrayList();
    }
    j = paramVarArgs.length;
    i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a locala = paramVarArgs[i];
      this.EaV.add(locala);
      i += 1;
    }
    this.EaY = new RadarGrid(this.context, this.Ebe, this.Ebf, this.maxValue, this.Ebg, this.EaW);
    addView(this.EaY);
    this.EaZ = new RadarDataLayer[this.Ebd];
    i = k;
    while ((i < this.EaZ.length) && (this.EaV.size() > i))
    {
      this.EaZ[i] = new RadarDataLayer(this.context, this.maxValue, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a)this.EaV.get(i));
      addView(this.EaZ[i]);
      i += 1;
    }
    if (this.Eba == null) {
      this.Eba = new a(this.context, this.EaW);
    }
    addView(this.Eba);
    AppMethodBeat.o(96340);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96342);
    this.EaW = paramc;
    if (this.EaY != null) {
      this.EaY.setGridStyle(paramc);
    }
    AppMethodBeat.o(96342);
  }
  
  public void setLatitudeNum(int paramInt)
  {
    this.Ebf = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart
 * JD-Core Version:    0.7.0.1
 */