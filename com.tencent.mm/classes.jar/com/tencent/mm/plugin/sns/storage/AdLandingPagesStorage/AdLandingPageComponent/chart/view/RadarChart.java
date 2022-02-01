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
  public ArrayList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a> ykU;
  private c ykV;
  public TextView ykW;
  private RadarGrid ykX;
  private RadarDataLayer[] ykY;
  private a ykZ;
  private boolean yla;
  private boolean ylb;
  public int ylc;
  public int yld;
  private int yle;
  public Spannable[] ylf;
  private float ylg;
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96338);
    this.ykV = new c();
    this.yla = true;
    this.ylb = true;
    this.ylc = 3;
    this.yld = 0;
    this.yle = 4;
    this.ylg = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96338);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(96339);
    this.ykV = new c();
    this.yla = true;
    this.ylb = true;
    this.ylc = 3;
    this.yld = 0;
    this.yle = 4;
    this.ylg = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(96339);
  }
  
  public c getGridStyle()
  {
    AppMethodBeat.i(96343);
    if (this.ykX == null)
    {
      localc = this.ykV;
      AppMethodBeat.o(96343);
      return localc;
    }
    this.ykV = this.ykX.getGridStyle();
    c localc = this.ykX.getGridStyle();
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
    this.ylf = paramVarArgs[0].dKg();
    this.yld = paramVarArgs[0].size();
    if (this.ykU == null) {
      this.ykU = new ArrayList();
    }
    j = paramVarArgs.length;
    i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a locala = paramVarArgs[i];
      this.ykU.add(locala);
      i += 1;
    }
    this.ykX = new RadarGrid(this.context, this.yld, this.yle, this.ylg, this.ylf, this.ykV);
    addView(this.ykX);
    this.ykY = new RadarDataLayer[this.ylc];
    i = k;
    while ((i < this.ykY.length) && (this.ykU.size() > i))
    {
      this.ykY[i] = new RadarDataLayer(this.context, this.ylg, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a)this.ykU.get(i));
      addView(this.ykY[i]);
      i += 1;
    }
    if (this.ykZ == null) {
      this.ykZ = new a(this.context, this.ykV);
    }
    addView(this.ykZ);
    AppMethodBeat.o(96340);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(96342);
    this.ykV = paramc;
    if (this.ykX != null) {
      this.ykX.setGridStyle(paramc);
    }
    AppMethodBeat.o(96342);
  }
  
  public void setLatitudeNum(int paramInt)
  {
    this.yle = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart
 * JD-Core Version:    0.7.0.1
 */