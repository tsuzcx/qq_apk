package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview.Chart;
import java.util.ArrayList;

public class RadarChart
  extends Chart
{
  private Context context;
  public TextView oEA;
  private RadarGrid oEB;
  private RadarDataLayer[] oEC;
  private a oED;
  private boolean oEE = true;
  private boolean oEF = true;
  public int oEG = 3;
  public int oEH = 0;
  private int oEI = 4;
  public Spannable[] oEJ;
  private float oEK = 1.0F;
  public ArrayList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a> oEy;
  private c oEz = new c();
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public c getGridStyle()
  {
    if (this.oEB == null) {
      return this.oEz;
    }
    this.oEz = this.oEB.getGridStyle();
    return this.oEB.getGridStyle();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      getChildAt(paramInt1).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 += 1;
    }
  }
  
  public void setData(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a... paramVarArgs)
  {
    int k = 0;
    removeAllViews();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i].size() <= 0) {
        throw new Exception("Not enough elements.");
      }
      i += 1;
    }
    i = 0;
    while (i < paramVarArgs.length)
    {
      j = 0;
      while (j < paramVarArgs.length)
      {
        if (!paramVarArgs[i].a(paramVarArgs[j])) {
          throw new Error("Layer not compatible.");
        }
        j += 1;
      }
      i += 1;
    }
    this.oEJ = paramVarArgs[0].bFb();
    this.oEH = paramVarArgs[0].size();
    if (this.oEy == null) {
      this.oEy = new ArrayList();
    }
    j = paramVarArgs.length;
    i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a locala = paramVarArgs[i];
      this.oEy.add(locala);
      i += 1;
    }
    this.oEB = new RadarGrid(this.context, this.oEH, this.oEI, this.oEK, this.oEJ, this.oEz);
    addView(this.oEB);
    this.oEC = new RadarDataLayer[this.oEG];
    i = k;
    while ((i < this.oEC.length) && (this.oEy.size() > i))
    {
      this.oEC[i] = new RadarDataLayer(this.context, this.oEK, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a)this.oEy.get(i));
      addView(this.oEC[i]);
      i += 1;
    }
    if (this.oED == null) {
      this.oED = new a(this.context, this.oEz);
    }
    addView(this.oED);
  }
  
  public void setGridStyle(c paramc)
  {
    this.oEz = paramc;
    if (this.oEB != null) {
      this.oEB.setGridStyle(paramc);
    }
  }
  
  public void setLatitudeNum(int paramInt)
  {
    this.oEI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart
 * JD-Core Version:    0.7.0.1
 */