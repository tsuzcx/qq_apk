package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.picker.b.b;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.d.d;
import com.tencent.mm.picker.f.c;
import com.tencent.mm.ui.av;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CustomDatePickerNew
  extends FrameLayout
{
  private boolean Yrx;
  private Context context;
  private View mView;
  private int pkQ;
  private int pkR;
  private int pkS;
  private c pvTime;
  private boolean rBI;
  private boolean rBJ;
  private boolean rBK;
  private Date rBO;
  private Date rBP;
  private int rBT;
  private int rBU;
  private int rBV;
  
  public CustomDatePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker));
    AppMethodBeat.i(249915);
    this.mView = null;
    this.rBK = true;
    this.rBJ = true;
    this.rBI = true;
    this.Yrx = false;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(249915);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker), paramAttributeSet);
    AppMethodBeat.i(249917);
    this.mView = null;
    this.rBK = true;
    this.rBJ = true;
    this.rBI = true;
    this.Yrx = false;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(249917);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(249919);
    this.mView = null;
    this.rBK = true;
    this.rBJ = true;
    this.rBI = true;
    this.Yrx = false;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(249919);
  }
  
  public final void ba(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(249926);
    this.pkQ = paramInt1;
    this.pkR = paramInt2;
    this.pkS = paramInt3;
    if (this.mView == null) {
      this.mView = this.pvTime.buX();
    }
    AppMethodBeat.o(249926);
  }
  
  public final void bq(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.rBK = paramBoolean2;
    this.rBJ = paramBoolean1;
    this.rBI = true;
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(249921);
    this.pvTime.buV();
    if (this.rBK)
    {
      str = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(this.rBT), Integer.valueOf(this.rBU), Integer.valueOf(this.rBV) });
      AppMethodBeat.o(249921);
      return str;
    }
    if (this.rBJ)
    {
      str = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(this.rBT), Integer.valueOf(this.rBU) });
      AppMethodBeat.o(249921);
      return str;
    }
    String str = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(this.rBT) });
    AppMethodBeat.o(249921);
    return str;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(249933);
    if (this.pvTime != null) {
      this.pvTime.buV();
    }
    int i = this.rBV;
    AppMethodBeat.o(249933);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(249932);
    if (this.pvTime != null) {
      this.pvTime.buV();
    }
    int i = this.rBU;
    AppMethodBeat.o(249932);
    return i;
  }
  
  public View getView()
  {
    AppMethodBeat.i(249924);
    if (this.mView == null) {
      this.mView = this.pvTime.buX();
    }
    View localView = this.mView;
    AppMethodBeat.o(249924);
    return localView;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(249931);
    if (this.pvTime != null) {
      this.pvTime.buV();
    }
    int i = this.rBT;
    AppMethodBeat.o(249931);
    return i;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(249934);
    if (this.Yrx) {
      this.pkQ += 1;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(this.pkQ, this.pkR - 1, this.pkS);
    Object localObject2 = Calendar.getInstance();
    if (this.rBO == null) {
      this.rBO = new Date(((Calendar)localObject1).getTimeInMillis());
    }
    ((Calendar)localObject2).setTime(this.rBO);
    Calendar localCalendar = Calendar.getInstance();
    if (this.rBP == null)
    {
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(this.pkQ + 100, this.pkR - 1, this.pkS);
      this.rBP = new Date(((Calendar)localObject3).getTimeInMillis());
    }
    localCalendar.setTime(this.rBP);
    Object localObject3 = this.pvTime;
    boolean bool = this.Yrx;
    ((c)localObject3).mCO = bool;
    if (((c)localObject3).mCN != null) {
      ((c)localObject3).mCN.mBy = bool;
    }
    new b(this.context, new com.tencent.mm.picker.d.e()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(252175);
        CustomDatePickerNew.a(CustomDatePickerNew.this, paramAnonymousDate);
        av.i("pvTime", "onTimeSelect", new Object[0]);
        AppMethodBeat.o(252175);
      }
    }).a(new d()
    {
      public final void buP()
      {
        AppMethodBeat.i(251364);
        av.i("pvTime", "onTimeSelectChanged", new Object[0]);
        AppMethodBeat.o(251364);
      }
    }).buN().c(new boolean[] { this.rBI, this.rBJ, this.rBK, false, false, false }).a((Calendar)localObject1).a((Calendar)localObject2, localCalendar).xR(this.context.getResources().getDimensionPixelSize(a.d.Edge_3A)).a(this.pvTime);
    this.pvTime.setDividerHeight(this.context.getResources().getDimensionPixelSize(a.d.bottomsheet_dividing_line_height));
    this.context.getResources().getDimensionPixelSize(a.d.Edge_3A);
    localObject1 = this.pvTime;
    bool = this.Yrx;
    if (((c)localObject1).mCN != null)
    {
      localObject1 = ((c)localObject1).mCN;
      ((com.tencent.mm.picker.f.e)localObject1).mBy = bool;
      ((com.tencent.mm.picker.f.e)localObject1).mDc.mBb = bool;
      ((com.tencent.mm.picker.f.e)localObject1).mCV.setLongTermYear(bool);
      ((com.tencent.mm.picker.f.e)localObject1).mCW.setLongTermMonthDay(bool);
      ((com.tencent.mm.picker.f.e)localObject1).mCX.setLongTermMonthDay(bool);
    }
    this.pvTime.setDividerColor(a.w(this.context, a.c.BW_0_Alpha_0_1));
    this.pvTime.ec(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
    localObject1 = this.pvTime.buY().iterator();
    int i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WheelView)((Iterator)localObject1).next();
      if ((this.Yrx) && (this.pkQ == 2) && (i > 0)) {
        ((WheelView)localObject2).xN(0).xM(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A)).setBackgroundColor(a.w(this.context, a.c.BG_5));
      }
      for (;;)
      {
        i += 1;
        break;
        ((WheelView)localObject2).xN(a.w(this.context, a.c.BW_0_Alpha_0_9)).xM(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A)).setBackgroundColor(a.w(this.context, a.c.BG_5));
      }
    }
    localObject1 = this.pvTime.buY();
    if (((List)localObject1).size() == 1)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      AppMethodBeat.o(249934);
      return;
    }
    if (((List)localObject1).size() == 2)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      AppMethodBeat.o(249934);
      return;
    }
    if (((List)localObject1).size() == 3)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject1).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
    }
    AppMethodBeat.o(249934);
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.Yrx = paramBoolean;
  }
  
  public void setMaxDate(Long paramLong)
  {
    AppMethodBeat.i(249928);
    this.rBP = new Date(paramLong.longValue());
    AppMethodBeat.o(249928);
  }
  
  public void setMinDate(Long paramLong)
  {
    AppMethodBeat.i(249929);
    this.rBO = new Date(paramLong.longValue());
    AppMethodBeat.o(249929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew
 * JD-Core Version:    0.7.0.1
 */