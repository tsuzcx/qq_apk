package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.picker.b.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.f;
import com.tencent.mm.picker.f.c;
import com.tencent.mm.ui.bc;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CustomDatePickerNew
  extends FrameLayout
{
  private boolean agjN;
  private Context context;
  private View mView;
  private c pvTime;
  private int spR;
  private int spS;
  private int spT;
  private boolean uMX;
  private boolean uMY;
  private boolean uMZ;
  private Date uNd;
  private Date uNe;
  private int uNi;
  private int uNj;
  private int uNk;
  
  public CustomDatePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker));
    AppMethodBeat.i(252567);
    this.mView = null;
    this.uMZ = true;
    this.uMY = true;
    this.uMX = true;
    this.agjN = false;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(252567);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker), paramAttributeSet);
    AppMethodBeat.i(252574);
    this.mView = null;
    this.uMZ = true;
    this.uMY = true;
    this.uMX = true;
    this.agjN = false;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(252574);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(252579);
    this.mView = null;
    this.uMZ = true;
    this.uMY = true;
    this.uMX = true;
    this.agjN = false;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(252579);
  }
  
  public final void bB(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(252595);
    this.spR = paramInt1;
    this.spS = paramInt2;
    this.spT = paramInt3;
    if (this.mView == null) {
      this.mView = this.pvTime.bTg();
    }
    AppMethodBeat.o(252595);
  }
  
  public final void bP(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.uMZ = paramBoolean2;
    this.uMY = paramBoolean1;
    this.uMX = true;
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(252585);
    this.pvTime.bTe();
    if (this.uMZ)
    {
      str = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(this.uNi), Integer.valueOf(this.uNj), Integer.valueOf(this.uNk) });
      AppMethodBeat.o(252585);
      return str;
    }
    if (this.uMY)
    {
      str = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(this.uNi), Integer.valueOf(this.uNj) });
      AppMethodBeat.o(252585);
      return str;
    }
    String str = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(this.uNi) });
    AppMethodBeat.o(252585);
    return str;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(252621);
    if (this.pvTime != null) {
      this.pvTime.bTe();
    }
    int i = this.uNk;
    AppMethodBeat.o(252621);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(252615);
    if (this.pvTime != null) {
      this.pvTime.bTe();
    }
    int i = this.uNj;
    AppMethodBeat.o(252615);
    return i;
  }
  
  public View getView()
  {
    AppMethodBeat.i(252589);
    if (this.mView == null) {
      this.mView = this.pvTime.bTg();
    }
    View localView = this.mView;
    AppMethodBeat.o(252589);
    return localView;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(252609);
    if (this.pvTime != null) {
      this.pvTime.bTe();
    }
    int i = this.uNi;
    AppMethodBeat.o(252609);
    return i;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(252642);
    if (this.agjN) {
      this.spR += 1;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(this.spR, this.spS - 1, this.spT);
    Object localObject2 = Calendar.getInstance();
    if (this.uNd == null) {
      this.uNd = new Date(((Calendar)localObject1).getTimeInMillis());
    }
    ((Calendar)localObject2).setTime(this.uNd);
    Calendar localCalendar = Calendar.getInstance();
    if (this.uNe == null)
    {
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(this.spR + 100, this.spS - 1, this.spT);
      this.uNe = new Date(((Calendar)localObject3).getTimeInMillis());
    }
    localCalendar.setTime(this.uNe);
    Object localObject3 = this.pvTime;
    boolean bool = this.agjN;
    ((c)localObject3).pzw = bool;
    if (((c)localObject3).pzv != null) {
      ((c)localObject3).pzv.pyg = bool;
    }
    new b(this.context, new f()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(252572);
        CustomDatePickerNew.a(CustomDatePickerNew.this, paramAnonymousDate);
        bc.i("pvTime", "onTimeSelect", new Object[0]);
        AppMethodBeat.o(252572);
      }
    }).a(new com.tencent.mm.picker.d.e()
    {
      public final void bSY()
      {
        AppMethodBeat.i(252575);
        bc.i("pvTime", "onTimeSelectChanged", new Object[0]);
        AppMethodBeat.o(252575);
      }
    }).bSW().d(new boolean[] { this.uMX, this.uMY, this.uMZ, false, false, false }).a((Calendar)localObject1).a((Calendar)localObject2, localCalendar).xW(this.context.getResources().getDimensionPixelSize(a.d.Edge_3A)).a(this.pvTime);
    this.pvTime.setDividerHeight(this.context.getResources().getDimensionPixelSize(a.d.bottomsheet_dividing_line_height));
    this.context.getResources().getDimensionPixelSize(a.d.Edge_3A);
    localObject1 = this.pvTime;
    bool = this.agjN;
    if (((c)localObject1).pzv != null)
    {
      localObject1 = ((c)localObject1).pzv;
      ((com.tencent.mm.picker.f.e)localObject1).pyg = bool;
      ((com.tencent.mm.picker.f.e)localObject1).pzJ.pxL = bool;
      ((com.tencent.mm.picker.f.e)localObject1).pzD.setLongTermYear(bool);
      ((com.tencent.mm.picker.f.e)localObject1).pzE.setLongTermMonthDay(bool);
      ((com.tencent.mm.picker.f.e)localObject1).pzF.setLongTermMonthDay(bool);
    }
    this.pvTime.setDividerColor(a.w(this.context, a.c.BW_0_Alpha_0_1));
    this.pvTime.eV(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
    localObject1 = this.pvTime.bTh().iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WheelView)((Iterator)localObject1).next();
      if ((this.agjN) && (this.spR == 2) && (i > 0)) {
        ((WheelView)localObject2).xS(0).xR(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A)).setBackgroundColor(a.w(this.context, a.c.BG_5));
      }
      for (;;)
      {
        i += 1;
        break;
        ((WheelView)localObject2).xS(a.w(this.context, a.c.BW_0_Alpha_0_9)).xR(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A)).setBackgroundColor(a.w(this.context, a.c.BG_5));
      }
    }
    localObject1 = this.pvTime.bTh();
    if (((List)localObject1).size() == 1)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      AppMethodBeat.o(252642);
      return;
    }
    if (((List)localObject1).size() == 2)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      AppMethodBeat.o(252642);
      return;
    }
    if (((List)localObject1).size() == 3)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject1).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
    }
    AppMethodBeat.o(252642);
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.agjN = paramBoolean;
  }
  
  public void setMaxDate(Long paramLong)
  {
    AppMethodBeat.i(252601);
    this.uNe = new Date(paramLong.longValue());
    AppMethodBeat.o(252601);
  }
  
  public void setMinDate(Long paramLong)
  {
    AppMethodBeat.i(252606);
    this.uNd = new Date(paramLong.longValue());
    AppMethodBeat.o(252606);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew
 * JD-Core Version:    0.7.0.1
 */