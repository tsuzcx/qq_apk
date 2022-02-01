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
  public static DateFormat dateFormat;
  WheelView QTE;
  WheelView QTF;
  WheelView QTG;
  WheelView QTH;
  WheelView QTI;
  WheelView QTJ;
  f QTK;
  boolean QTL;
  WheelView.b QTM;
  a QTN;
  Context ctx;
  int endYear;
  int gravity;
  boolean[] jKX;
  private int jKu;
  int jLW;
  int jLX;
  int jLY;
  int jLZ;
  float jLu;
  int jMa;
  int jMb;
  int jMc;
  int jMd;
  int jMe;
  private String[] jMg;
  private String[] jMh;
  final List<String> jMi;
  final List<String> jMj;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(198466);
    dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(198466);
  }
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(198455);
    this.startYear = 1900;
    this.endYear = 2100;
    this.jLW = 1;
    this.jLX = 12;
    this.jLY = 1;
    this.jLZ = 31;
    this.jMa = 0;
    this.jMb = 0;
    this.jMc = 23;
    this.jMd = 59;
    this.QTL = false;
    this.jMg = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.jMh = new String[] { "4", "6", "9", "11" };
    this.jMi = Arrays.asList(this.jMg);
    this.jMj = Arrays.asList(this.jMh);
    this.ctx = paramContext;
    AppMethodBeat.o(198455);
  }
  
  static void aP(List<WheelView> paramList)
  {
    AppMethodBeat.i(198457);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(198457);
  }
  
  private static int b(WheelView paramWheelView)
  {
    AppMethodBeat.i(198461);
    if ((paramWheelView.getAdapter() instanceof d))
    {
      paramWheelView = paramWheelView.getAdapter().getItem(paramWheelView.getCurrentItem());
      if (paramWheelView != null)
      {
        int i = ((Integer)paramWheelView).intValue();
        AppMethodBeat.o(198461);
        return i;
      }
    }
    AppMethodBeat.o(198461);
    return 0;
  }
  
  private void blj()
  {
    AppMethodBeat.i(198459);
    this.QTG.setDividerColor(this.jKu);
    this.QTF.setDividerColor(this.jKu);
    this.QTE.setDividerColor(this.jKu);
    this.QTH.setDividerColor(this.jKu);
    this.QTI.setDividerColor(this.jKu);
    this.QTJ.setDividerColor(this.jKu);
    AppMethodBeat.o(198459);
  }
  
  final void a(WheelView paramWheelView)
  {
    AppMethodBeat.i(198458);
    if (this.QTN != null) {
      paramWheelView.setOnItemSelectedListener(new c()
      {
        public final void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(198454);
          j.k(j.this).bla();
          AppMethodBeat.o(198454);
        }
      });
    }
    AppMethodBeat.o(198458);
  }
  
  public final List<WheelView> bll()
  {
    AppMethodBeat.i(198456);
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
        localWheelView = this.QTE;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.QTE);
          break;
        }
      case 1: 
        localWheelView = this.QTF;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.QTF);
          break;
        }
      case 2: 
        localWheelView = this.QTG;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.QTG);
          break;
        }
      case 3: 
        localWheelView = this.QTH;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.QTH);
          break;
        }
      case 4: 
        localWheelView = this.QTI;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.QTI);
          break;
        }
      case 5: 
        localWheelView = this.QTJ;
        if (this.jKX[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.jKX[i] == 0) {
            break;
          }
          localArrayList.add(this.QTJ);
          break;
        }
      }
    }
    AppMethodBeat.o(198456);
    return localArrayList;
  }
  
  public final void dE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198464);
    this.QTG.setPadding(0, paramInt1, 0, paramInt2);
    this.QTH.setPadding(0, paramInt1, 0, paramInt2);
    this.QTI.setPadding(0, paramInt1, 0, paramInt2);
    this.QTE.setPadding(0, paramInt1, 0, paramInt2);
    this.QTF.setPadding(0, paramInt1, 0, paramInt2);
    this.QTJ.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(198464);
  }
  
  public final String getTime()
  {
    AppMethodBeat.i(198460);
    String str = String.valueOf(b(this.QTE) + "-" + b(this.QTF) + "-" + b(this.QTG) + " " + b(this.QTH) + ":" + b(this.QTI) + ":" + b(this.QTJ));
    AppMethodBeat.o(198460);
    return str;
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(198462);
    this.jKu = paramInt;
    blj();
    AppMethodBeat.o(198462);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(198463);
    this.QTG.setDividerHeight(paramFloat);
    this.QTH.setDividerHeight(paramFloat);
    this.QTI.setDividerHeight(paramFloat);
    this.QTE.setDividerHeight(paramFloat);
    this.QTF.setDividerHeight(paramFloat);
    this.QTJ.setDividerHeight(paramFloat);
    AppMethodBeat.o(198463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.j
 * JD-Core Version:    0.7.0.1
 */