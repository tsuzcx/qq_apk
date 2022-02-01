package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.a.d;
import com.tencent.mm.ui.widget.picker.a.e;
import com.tencent.mm.ui.widget.picker.a.f;
import com.tencent.mm.ui.widget.picker.d.a;
import com.tencent.mm.ui.widget.picker.d.c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class j
{
  public static DateFormat iMi;
  WheelView Lbo;
  WheelView Lbp;
  WheelView Lbq;
  WheelView Lbr;
  WheelView Lbs;
  WheelView Lbt;
  f Lbu;
  boolean Lbv;
  WheelView.b Lbw;
  a Lbx;
  Context ctx;
  int endYear;
  int gravity;
  private int iKN;
  float iLM;
  boolean[] iLp;
  private String[] iMA;
  final List<String> iMB;
  final List<String> iMC;
  int iMp;
  int iMq;
  int iMr;
  int iMs;
  int iMt;
  int iMu;
  int iMv;
  int iMw;
  int iMx;
  private String[] iMz;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(192735);
    iMi = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(192735);
  }
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(192724);
    this.startYear = 1900;
    this.endYear = 2100;
    this.iMp = 1;
    this.iMq = 12;
    this.iMr = 1;
    this.iMs = 31;
    this.iMt = 0;
    this.iMu = 0;
    this.iMv = 23;
    this.iMw = 59;
    this.Lbv = false;
    this.iMz = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.iMA = new String[] { "4", "6", "9", "11" };
    this.iMB = Arrays.asList(this.iMz);
    this.iMC = Arrays.asList(this.iMA);
    this.ctx = paramContext;
    AppMethodBeat.o(192724);
  }
  
  static void aH(List<WheelView> paramList)
  {
    AppMethodBeat.i(192726);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(192726);
  }
  
  private void aQf()
  {
    AppMethodBeat.i(192728);
    this.Lbq.setDividerColor(this.iKN);
    this.Lbp.setDividerColor(this.iKN);
    this.Lbo.setDividerColor(this.iKN);
    this.Lbr.setDividerColor(this.iKN);
    this.Lbs.setDividerColor(this.iKN);
    this.Lbt.setDividerColor(this.iKN);
    AppMethodBeat.o(192728);
  }
  
  private static int b(WheelView paramWheelView)
  {
    AppMethodBeat.i(192730);
    if ((paramWheelView.getAdapter() instanceof d))
    {
      paramWheelView = paramWheelView.getAdapter().getItem(paramWheelView.getCurrentItem());
      if (paramWheelView != null)
      {
        int i = ((Integer)paramWheelView).intValue();
        AppMethodBeat.o(192730);
        return i;
      }
    }
    AppMethodBeat.o(192730);
    return 0;
  }
  
  final void a(WheelView paramWheelView)
  {
    AppMethodBeat.i(192727);
    if (this.Lbx != null) {
      paramWheelView.setOnItemSelectedListener(new c()
      {
        public final void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(192723);
          j.k(j.this).aPW();
          AppMethodBeat.o(192723);
        }
      });
    }
    AppMethodBeat.o(192727);
  }
  
  public final List<WheelView> aQh()
  {
    AppMethodBeat.i(192725);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 6)
    {
      WheelView localWheelView;
      int j;
      switch (i)
      {
      default: 
        i += 1;
        break;
      case 0: 
        localWheelView = this.Lbo;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.Lbo);
          break;
        }
      case 1: 
        localWheelView = this.Lbp;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.Lbp);
          break;
        }
      case 2: 
        localWheelView = this.Lbq;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.Lbq);
          break;
        }
      case 3: 
        localWheelView = this.Lbr;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.Lbr);
          break;
        }
      case 4: 
        localWheelView = this.Lbs;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.Lbs);
          break;
        }
      case 5: 
        localWheelView = this.Lbt;
        if (this.iLp[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iLp[i] == 0) {
            break;
          }
          localArrayList.add(this.Lbt);
          break;
        }
      }
    }
    AppMethodBeat.o(192725);
    return localArrayList;
  }
  
  public final String aQi()
  {
    AppMethodBeat.i(192729);
    String str = String.valueOf(b(this.Lbo) + "-" + b(this.Lbp) + "-" + b(this.Lbq) + " " + b(this.Lbr) + ":" + b(this.Lbs) + ":" + b(this.Lbt));
    AppMethodBeat.o(192729);
    return str;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192733);
    this.Lbq.setPadding(0, paramInt1, 0, paramInt2);
    this.Lbr.setPadding(0, paramInt1, 0, paramInt2);
    this.Lbs.setPadding(0, paramInt1, 0, paramInt2);
    this.Lbo.setPadding(0, paramInt1, 0, paramInt2);
    this.Lbp.setPadding(0, paramInt1, 0, paramInt2);
    this.Lbt.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(192733);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(192731);
    this.iKN = paramInt;
    aQf();
    AppMethodBeat.o(192731);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(192732);
    this.Lbq.setDividerHeight(paramFloat);
    this.Lbr.setDividerHeight(paramFloat);
    this.Lbs.setDividerHeight(paramFloat);
    this.Lbo.setDividerHeight(paramFloat);
    this.Lbp.setDividerHeight(paramFloat);
    this.Lbt.setDividerHeight(paramFloat);
    AppMethodBeat.o(192732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.j
 * JD-Core Version:    0.7.0.1
 */