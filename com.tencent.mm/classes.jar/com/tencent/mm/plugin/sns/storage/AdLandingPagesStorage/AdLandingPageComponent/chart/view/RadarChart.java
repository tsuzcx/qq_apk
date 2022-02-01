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
  public ArrayList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a> zSL;
  private c zSM;
  public TextView zSN;
  private RadarGrid zSO;
  private RadarDataLayer[] zSP;
  private a zSQ;
  private boolean zSR;
  private boolean zSS;
  public int zST;
  public int zSU;
  private int zSV;
  public Spannable[] zSW;
  private float zSX;
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96338);
    this.zSM = new c();
    this.zSR = true;
    this.zSS = true;
    this.zST = 3;
    this.zSU = 0;
    this.zSV = 4;
    this.zSX = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96338);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96339);
    this.zSM = new c();
    this.zSR = true;
    this.zSS = true;
    this.zST = 3;
    this.zSU = 0;
    this.zSV = 4;
    this.zSX = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96339);
  }
  
  public c getGridStyle()
  {
    AppMethodBeat.i(96343);
    if (this.zSO == null)
    {
      localc = this.zSM;
      AppMethodBeat.o(96343);
      return localc;
    }
    this.zSM = this.zSO.getGridStyle();
    c localc = this.zSO.getGridStyle();
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
    this.zSW = paramVarArgs[0].dZW();
    this.zSU = paramVarArgs[0].size();
    if (this.zSL == null) {
      this.zSL = new ArrayList();
    }
    j = paramVarArgs.length;
    i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a locala = paramVarArgs[i];
      this.zSL.add(locala);
      i += 1;
    }
    this.zSO = new RadarGrid(this.context, this.zSU, this.zSV, this.zSX, this.zSW, this.zSM);
    addView(this.zSO);
    this.zSP = new RadarDataLayer[this.zST];
    i = k;
    while ((i < this.zSP.length) && (this.zSL.size() > i))
    {
      this.zSP[i] = new RadarDataLayer(this.context, this.zSX, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a)this.zSL.get(i));
      addView(this.zSP[i]);
      i += 1;
    }
    if (this.zSQ == null) {
      this.zSQ = new a(this.context, this.zSM);
    }
    addView(this.zSQ);
    AppMethodBeat.o(96340);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96342);
    this.zSM = paramc;
    if (this.zSO != null) {
      this.zSO.setGridStyle(paramc);
    }
    AppMethodBeat.o(96342);
  }
  
  public void setLatitudeNum(int paramInt)
  {
    this.zSV = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart
 * JD-Core Version:    0.7.0.1
 */