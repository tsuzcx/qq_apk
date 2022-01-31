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
  public ArrayList<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a> rtZ;
  private c rua;
  public TextView rub;
  private RadarGrid ruc;
  private RadarDataLayer[] rud;
  private a rue;
  private boolean ruf;
  private boolean rug;
  public int ruh;
  public int rui;
  private int ruj;
  public Spannable[] ruk;
  private float rul;
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(36958);
    this.rua = new c();
    this.ruf = true;
    this.rug = true;
    this.ruh = 3;
    this.rui = 0;
    this.ruj = 4;
    this.rul = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(36958);
  }
  
  public RadarChart(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(36959);
    this.rua = new c();
    this.ruf = true;
    this.rug = true;
    this.ruh = 3;
    this.rui = 0;
    this.ruj = 4;
    this.rul = 1.0F;
    this.context = paramContext;
    AppMethodBeat.o(36959);
  }
  
  public c getGridStyle()
  {
    AppMethodBeat.i(36963);
    if (this.ruc == null)
    {
      localc = this.rua;
      AppMethodBeat.o(36963);
      return localc;
    }
    this.rua = this.ruc.getGridStyle();
    c localc = this.ruc.getGridStyle();
    AppMethodBeat.o(36963);
    return localc;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(36961);
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      getChildAt(paramInt1).layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
      paramInt1 += 1;
    }
    AppMethodBeat.o(36961);
  }
  
  public void setData(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a... paramVarArgs)
  {
    int k = 0;
    AppMethodBeat.i(36960);
    removeAllViews();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i].size() <= 0)
      {
        paramVarArgs = new Exception("Not enough elements.");
        AppMethodBeat.o(36960);
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
          AppMethodBeat.o(36960);
          throw paramVarArgs;
        }
        j += 1;
      }
      i += 1;
    }
    this.ruk = paramVarArgs[0].cqI();
    this.rui = paramVarArgs[0].size();
    if (this.rtZ == null) {
      this.rtZ = new ArrayList();
    }
    j = paramVarArgs.length;
    i = 0;
    while (i < j)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a locala = paramVarArgs[i];
      this.rtZ.add(locala);
      i += 1;
    }
    this.ruc = new RadarGrid(this.context, this.rui, this.ruj, this.rul, this.ruk, this.rua);
    addView(this.ruc);
    this.rud = new RadarDataLayer[this.ruh];
    i = k;
    while ((i < this.rud.length) && (this.rtZ.size() > i))
    {
      this.rud[i] = new RadarDataLayer(this.context, this.rul, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a)this.rtZ.get(i));
      addView(this.rud[i]);
      i += 1;
    }
    if (this.rue == null) {
      this.rue = new a(this.context, this.rua);
    }
    addView(this.rue);
    AppMethodBeat.o(36960);
  }
  
  public void setGridStyle(c paramc)
  {
    AppMethodBeat.i(36962);
    this.rua = paramc;
    if (this.ruc != null) {
      this.ruc.setGridStyle(paramc);
    }
    AppMethodBeat.o(36962);
  }
  
  public void setLatitudeNum(int paramInt)
  {
    this.ruj = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart
 * JD-Core Version:    0.7.0.1
 */