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
  public static DateFormat iPb;
  WheelView LxP;
  WheelView LxQ;
  WheelView LxR;
  WheelView LxS;
  WheelView LxT;
  WheelView LxU;
  f LxV;
  boolean LxW;
  WheelView.b LxX;
  a LxY;
  Context ctx;
  int endYear;
  int gravity;
  private int iNG;
  float iOF;
  boolean[] iOi;
  int iPi;
  int iPj;
  int iPk;
  int iPl;
  int iPm;
  int iPn;
  int iPo;
  int iPp;
  int iPq;
  private String[] iPs;
  private String[] iPt;
  final List<String> iPu;
  final List<String> iPw;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(200508);
    iPb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(200508);
  }
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(200497);
    this.startYear = 1900;
    this.endYear = 2100;
    this.iPi = 1;
    this.iPj = 12;
    this.iPk = 1;
    this.iPl = 31;
    this.iPm = 0;
    this.iPn = 0;
    this.iPo = 23;
    this.iPp = 59;
    this.LxW = false;
    this.iPs = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.iPt = new String[] { "4", "6", "9", "11" };
    this.iPu = Arrays.asList(this.iPs);
    this.iPw = Arrays.asList(this.iPt);
    this.ctx = paramContext;
    AppMethodBeat.o(200497);
  }
  
  static void aH(List<WheelView> paramList)
  {
    AppMethodBeat.i(200499);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(200499);
  }
  
  private void aQE()
  {
    AppMethodBeat.i(200501);
    this.LxR.setDividerColor(this.iNG);
    this.LxQ.setDividerColor(this.iNG);
    this.LxP.setDividerColor(this.iNG);
    this.LxS.setDividerColor(this.iNG);
    this.LxT.setDividerColor(this.iNG);
    this.LxU.setDividerColor(this.iNG);
    AppMethodBeat.o(200501);
  }
  
  private static int b(WheelView paramWheelView)
  {
    AppMethodBeat.i(200503);
    if ((paramWheelView.getAdapter() instanceof d))
    {
      paramWheelView = paramWheelView.getAdapter().getItem(paramWheelView.getCurrentItem());
      if (paramWheelView != null)
      {
        int i = ((Integer)paramWheelView).intValue();
        AppMethodBeat.o(200503);
        return i;
      }
    }
    AppMethodBeat.o(200503);
    return 0;
  }
  
  final void a(WheelView paramWheelView)
  {
    AppMethodBeat.i(200500);
    if (this.LxY != null) {
      paramWheelView.setOnItemSelectedListener(new c()
      {
        public final void onItemSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(200496);
          j.k(j.this).aQv();
          AppMethodBeat.o(200496);
        }
      });
    }
    AppMethodBeat.o(200500);
  }
  
  public final List<WheelView> aQG()
  {
    AppMethodBeat.i(200498);
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
        localWheelView = this.LxP;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.LxP);
          break;
        }
      case 1: 
        localWheelView = this.LxQ;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.LxQ);
          break;
        }
      case 2: 
        localWheelView = this.LxR;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.LxR);
          break;
        }
      case 3: 
        localWheelView = this.LxS;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.LxS);
          break;
        }
      case 4: 
        localWheelView = this.LxT;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.LxT);
          break;
        }
      case 5: 
        localWheelView = this.LxU;
        if (this.iOi[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.iOi[i] == 0) {
            break;
          }
          localArrayList.add(this.LxU);
          break;
        }
      }
    }
    AppMethodBeat.o(200498);
    return localArrayList;
  }
  
  public final String aQH()
  {
    AppMethodBeat.i(200502);
    String str = String.valueOf(b(this.LxP) + "-" + b(this.LxQ) + "-" + b(this.LxR) + " " + b(this.LxS) + ":" + b(this.LxT) + ":" + b(this.LxU));
    AppMethodBeat.o(200502);
    return str;
  }
  
  public final void du(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200506);
    this.LxR.setPadding(0, paramInt1, 0, paramInt2);
    this.LxS.setPadding(0, paramInt1, 0, paramInt2);
    this.LxT.setPadding(0, paramInt1, 0, paramInt2);
    this.LxP.setPadding(0, paramInt1, 0, paramInt2);
    this.LxQ.setPadding(0, paramInt1, 0, paramInt2);
    this.LxU.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(200506);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(200504);
    this.iNG = paramInt;
    aQE();
    AppMethodBeat.o(200504);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(200505);
    this.LxR.setDividerHeight(paramFloat);
    this.LxS.setDividerHeight(paramFloat);
    this.LxT.setDividerHeight(paramFloat);
    this.LxP.setDividerHeight(paramFloat);
    this.LxQ.setDividerHeight(paramFloat);
    this.LxU.setDividerHeight(paramFloat);
    AppMethodBeat.o(200505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.j
 * JD-Core Version:    0.7.0.1
 */