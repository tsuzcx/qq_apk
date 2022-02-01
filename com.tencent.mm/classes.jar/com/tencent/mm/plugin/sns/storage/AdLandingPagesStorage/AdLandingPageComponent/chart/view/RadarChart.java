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
  public ArrayList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a> zBJ;
  private c zBK;
  public TextView zBL;
  private RadarGrid zBM;
  private RadarDataLayer[] zBN;
  private a zBO;
  private boolean zBP;
  private boolean zBQ;
  public int zBR;
  public int zBS;
  private int zBT;
  public Spannable[] zBU;
  private float zBV;
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96338);
    this.zBK = new c();
    this.zBP = true;
    this.zBQ = true;
    this.zBR = 3;
    this.zBS = 0;
    this.zBT = 4;
    this.zBV = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96338);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96339);
    this.zBK = new c();
    this.zBP = true;
    this.zBQ = true;
    this.zBR = 3;
    this.zBS = 0;
    this.zBT = 4;
    this.zBV = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96339);
  }
  
  public c getGridStyle()
  {
    AppMethodBeat.i(96343);
    if (this.zBM == null)
    {
      localc = this.zBK;
      AppMethodBeat.o(96343);
      return localc;
    }
    this.zBK = this.zBM.getGridStyle();
    c localc = this.zBM.getGridStyle();
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
    this.zBU = paramVarArgs[0].dWu();
    this.zBS = paramVarArgs[0].size();
    if (this.zBJ == null) {
      this.zBJ = new ArrayList();
    }
    j = paramVarArgs.length;
    i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a locala = paramVarArgs[i];
      this.zBJ.add(locala);
      i += 1;
    }
    this.zBM = new RadarGrid(this.context, this.zBS, this.zBT, this.zBV, this.zBU, this.zBK);
    addView(this.zBM);
    this.zBN = new RadarDataLayer[this.zBR];
    i = k;
    while ((i < this.zBN.length) && (this.zBJ.size() > i))
    {
      this.zBN[i] = new RadarDataLayer(this.context, this.zBV, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a)this.zBJ.get(i));
      addView(this.zBN[i]);
      i += 1;
    }
    if (this.zBO == null) {
      this.zBO = new a(this.context, this.zBK);
    }
    addView(this.zBO);
    AppMethodBeat.o(96340);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96342);
    this.zBK = paramc;
    if (this.zBM != null) {
      this.zBM.setGridStyle(paramc);
    }
    AppMethodBeat.o(96342);
  }
  
  public void setLatitudeNum(int paramInt)
  {
    this.zBT = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart
 * JD-Core Version:    0.7.0.1
 */