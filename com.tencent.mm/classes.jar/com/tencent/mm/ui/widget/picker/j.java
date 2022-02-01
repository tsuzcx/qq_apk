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
  public static DateFormat hTa;
  f HJA;
  boolean HJB;
  WheelView.b HJC;
  a HJD;
  WheelView HJu;
  WheelView HJv;
  WheelView HJw;
  WheelView HJx;
  WheelView HJy;
  WheelView HJz;
  Context ctx;
  int endYear;
  int gravity;
  private int hRF;
  float hSE;
  boolean[] hSh;
  int hTh;
  int hTi;
  int hTj;
  int hTk;
  int hTl;
  int hTm;
  int hTn;
  int hTo;
  int hTp;
  private String[] hTr;
  private String[] hTs;
  final List<String> hTt;
  final List<String> hTu;
  int startYear;
  View view;
  
  static
  {
    AppMethodBeat.i(195319);
    hTa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    AppMethodBeat.o(195319);
  }
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(195308);
    this.startYear = 1900;
    this.endYear = 2100;
    this.hTh = 1;
    this.hTi = 12;
    this.hTj = 1;
    this.hTk = 31;
    this.hTl = 0;
    this.hTm = 0;
    this.hTn = 23;
    this.hTo = 59;
    this.HJB = false;
    this.hTr = new String[] { "1", "3", "5", "7", "8", "10", "12" };
    this.hTs = new String[] { "4", "6", "9", "11" };
    this.hTt = Arrays.asList(this.hTr);
    this.hTu = Arrays.asList(this.hTs);
    this.ctx = paramContext;
    AppMethodBeat.o(195308);
  }
  
  private void aGh()
  {
    AppMethodBeat.i(195312);
    this.HJw.setDividerColor(this.hRF);
    this.HJv.setDividerColor(this.hRF);
    this.HJu.setDividerColor(this.hRF);
    this.HJx.setDividerColor(this.hRF);
    this.HJy.setDividerColor(this.hRF);
    this.HJz.setDividerColor(this.hRF);
    AppMethodBeat.o(195312);
  }
  
  static void aJ(List<WheelView> paramList)
  {
    AppMethodBeat.i(195310);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((WheelView)paramList.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0F));
    }
    AppMethodBeat.o(195310);
  }
  
  private static int b(WheelView paramWheelView)
  {
    AppMethodBeat.i(195314);
    if ((paramWheelView.getAdapter() instanceof d))
    {
      paramWheelView = paramWheelView.getAdapter().getItem(paramWheelView.getCurrentItem());
      if (paramWheelView != null)
      {
        int i = ((Integer)paramWheelView).intValue();
        AppMethodBeat.o(195314);
        return i;
      }
    }
    AppMethodBeat.o(195314);
    return 0;
  }
  
  final void a(WheelView paramWheelView)
  {
    AppMethodBeat.i(195311);
    if (this.HJD != null) {
      paramWheelView.setOnItemSelectedListener(new c()
      {
        public final void pz(int paramAnonymousInt)
        {
          AppMethodBeat.i(195307);
          j.k(j.this).aFY();
          AppMethodBeat.o(195307);
        }
      });
    }
    AppMethodBeat.o(195311);
  }
  
  public final List<WheelView> aGj()
  {
    AppMethodBeat.i(195309);
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
        localWheelView = this.HJu;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.HJu);
          break;
        }
      case 1: 
        localWheelView = this.HJv;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.HJv);
          break;
        }
      case 2: 
        localWheelView = this.HJw;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.HJw);
          break;
        }
      case 3: 
        localWheelView = this.HJx;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.HJx);
          break;
        }
      case 4: 
        localWheelView = this.HJy;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.HJy);
          break;
        }
      case 5: 
        localWheelView = this.HJz;
        if (this.hSh[i] != 0) {}
        for (j = 0;; j = 8)
        {
          localWheelView.setVisibility(j);
          if (this.hSh[i] == 0) {
            break;
          }
          localArrayList.add(this.HJz);
          break;
        }
      }
    }
    AppMethodBeat.o(195309);
    return localArrayList;
  }
  
  public final String aGk()
  {
    AppMethodBeat.i(195313);
    String str = String.valueOf(b(this.HJu) + "-" + b(this.HJv) + "-" + b(this.HJw) + " " + b(this.HJx) + ":" + b(this.HJy) + ":" + b(this.HJz));
    AppMethodBeat.o(195313);
    return str;
  }
  
  public final void ds(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(195317);
    this.HJw.setPadding(0, paramInt1, 0, paramInt2);
    this.HJx.setPadding(0, paramInt1, 0, paramInt2);
    this.HJy.setPadding(0, paramInt1, 0, paramInt2);
    this.HJu.setPadding(0, paramInt1, 0, paramInt2);
    this.HJv.setPadding(0, paramInt1, 0, paramInt2);
    this.HJz.setPadding(0, paramInt1, 0, paramInt2);
    AppMethodBeat.o(195317);
  }
  
  public final void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(195315);
    this.hRF = paramInt;
    aGh();
    AppMethodBeat.o(195315);
  }
  
  public final void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(195316);
    this.HJw.setDividerHeight(paramFloat);
    this.HJx.setDividerHeight(paramFloat);
    this.HJy.setDividerHeight(paramFloat);
    this.HJu.setDividerHeight(paramFloat);
    this.HJv.setDividerHeight(paramFloat);
    this.HJz.setDividerHeight(paramFloat);
    AppMethodBeat.o(195316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.j
 * JD-Core Version:    0.7.0.1
 */