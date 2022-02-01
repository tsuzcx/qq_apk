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
  public static DateFormat itf;
  WheelView JjR;
  WheelView JjS;
  WheelView JjT;
  WheelView JjU;
  WheelView JjV;
  WheelView JjW;
  f JjX;
  boolean JjY;
  WheelView.b JjZ;
  a Jka;
  Context ctx;
  int endYear;
  int gravity;
  private int irK;
  float isJ;
  boolean[] ism;
  int itm;
  int itn;
  int ito;
  int itp;
  int itq;
  int itr;
  int its;
  int itt;
  int itu;
  private String[] itw;
  private String[] itx;
  final List<String> ity;
  final List<String> itz;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(199789);
    itf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(199789);
  }
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(199778);
    this.startYear = 1900;
    this.endYear = 2100;
    this.itm = 1;
    this.itn = 12;
    this.ito = 1;
    this.itp = 31;
    this.itq = 0;
    this.itr = 0;
    this.its = 23;
    this.itt = 59;
    this.JjY = false;
    this.itw = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.itx = new String[] { "4", "6", "9", "11" };
    this.ity = Arrays.asList(this.itw);
    this.itz = Arrays.asList(this.itx);
    this.ctx = paramContext;
    AppMethodBeat.o(199778);
  }
  
  static void aG(List<WheelView> paramList)
  {
    AppMethodBeat.i(199780);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(199780);
  }
  
  private void aMU()
  {
    AppMethodBeat.i(199782);
    this.JjT.setDividerColor(this.irK);
    this.JjS.setDividerColor(this.irK);
    this.JjR.setDividerColor(this.irK);
    this.JjU.setDividerColor(this.irK);
    this.JjV.setDividerColor(this.irK);
    this.JjW.setDividerColor(this.irK);
    AppMethodBeat.o(199782);
  }
  
  private static int b(WheelView paramWheelView)
  {
    AppMethodBeat.i(199784);
    if ((paramWheelView.getAdapter() instanceof d))
    {
      paramWheelView = paramWheelView.getAdapter().getItem(paramWheelView.getCurrentItem());
      if (paramWheelView != null)
      {
        int i = ((Integer)paramWheelView).intValue();
        AppMethodBeat.o(199784);
        return i;
      }
    }
    AppMethodBeat.o(199784);
    return 0;
  }
  
  final void a(WheelView paramWheelView)
  {
    AppMethodBeat.i(199781);
    if (this.Jka != null) {
      paramWheelView.setOnItemSelectedListener(new c()
      {
        public final void qm(int paramAnonymousInt)
        {
          AppMethodBeat.i(199777);
          j.k(j.this).aML();
          AppMethodBeat.o(199777);
        }
      });
    }
    AppMethodBeat.o(199781);
  }
  
  public final List<WheelView> aMW()
  {
    AppMethodBeat.i(199779);
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
        localWheelView = this.JjR;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.JjR);
          break;
        }
      case 1: 
        localWheelView = this.JjS;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.JjS);
          break;
        }
      case 2: 
        localWheelView = this.JjT;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.JjT);
          break;
        }
      case 3: 
        localWheelView = this.JjU;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.JjU);
          break;
        }
      case 4: 
        localWheelView = this.JjV;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.JjV);
          break;
        }
      case 5: 
        localWheelView = this.JjW;
        if (this.ism[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.ism[i] == 0) {
            break;
          }
          localArrayList.add(this.JjW);
          break;
        }
      }
    }
    AppMethodBeat.o(199779);
    return localArrayList;
  }
  
  public final String aMX()
  {
    AppMethodBeat.i(199783);
    String str = String.valueOf(b(this.JjR) + "-" + b(this.JjS) + "-" + b(this.JjT) + " " + b(this.JjU) + ":" + b(this.JjV) + ":" + b(this.JjW));
    AppMethodBeat.o(199783);
    return str;
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199787);
    this.JjT.setPadding(0, paramInt1, 0, paramInt2);
    this.JjU.setPadding(0, paramInt1, 0, paramInt2);
    this.JjV.setPadding(0, paramInt1, 0, paramInt2);
    this.JjR.setPadding(0, paramInt1, 0, paramInt2);
    this.JjS.setPadding(0, paramInt1, 0, paramInt2);
    this.JjW.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(199787);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(199785);
    this.irK = paramInt;
    aMU();
    AppMethodBeat.o(199785);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(199786);
    this.JjT.setDividerHeight(paramFloat);
    this.JjU.setDividerHeight(paramFloat);
    this.JjV.setDividerHeight(paramFloat);
    this.JjR.setDividerHeight(paramFloat);
    this.JjS.setDividerHeight(paramFloat);
    this.JjW.setDividerHeight(paramFloat);
    AppMethodBeat.o(199786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.j
 * JD-Core Version:    0.7.0.1
 */