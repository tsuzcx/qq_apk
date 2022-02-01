package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.picker.d.f;
import com.tencent.mm.ui.widget.picker.d.g;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CustomDatePickerNew
  extends FrameLayout
{
  private h LaA;
  private boolean LaB;
  private Context context;
  private int ldB;
  private int ldC;
  private int ldD;
  private View mView;
  private boolean nkm;
  private boolean nkn;
  private boolean nko;
  private Date nks;
  private Date nkt;
  private int nkx;
  private int nky;
  private int nkz;
  
  public CustomDatePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(192671);
    this.mView = null;
    this.nko = true;
    this.nkn = true;
    this.nkm = true;
    this.LaB = false;
    this.context = paramContext;
    this.LaA = new h(paramContext);
    AppMethodBeat.o(192671);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(192672);
    this.mView = null;
    this.nko = true;
    this.nkn = true;
    this.nkm = true;
    this.LaB = false;
    this.context = paramContext;
    this.LaA = new h(paramContext);
    AppMethodBeat.o(192672);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192673);
    this.mView = null;
    this.nko = true;
    this.nkn = true;
    this.nkm = true;
    this.LaB = false;
    this.context = paramContext;
    this.LaA = new h(paramContext);
    AppMethodBeat.o(192673);
  }
  
  public final void aO(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(192676);
    this.ldB = paramInt1;
    this.ldC = paramInt2;
    this.ldD = paramInt3;
    if (this.mView == null) {
      this.mView = this.LaA.aQe();
    }
    AppMethodBeat.o(192676);
  }
  
  public final void aX(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.nko = paramBoolean2;
    this.nkn = paramBoolean1;
    this.nkm = true;
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(192674);
    this.LaA.aQc();
    if (this.nko)
    {
      str = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(this.nkx), Integer.valueOf(this.nky), Integer.valueOf(this.nkz) });
      AppMethodBeat.o(192674);
      return str;
    }
    if (this.nkn)
    {
      str = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(this.nkx), Integer.valueOf(this.nky) });
      AppMethodBeat.o(192674);
      return str;
    }
    String str = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(this.nkx) });
    AppMethodBeat.o(192674);
    return str;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(192681);
    if (this.LaA != null) {
      this.LaA.aQc();
    }
    int i = this.nkz;
    AppMethodBeat.o(192681);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(192680);
    if (this.LaA != null) {
      this.LaA.aQc();
    }
    int i = this.nky;
    AppMethodBeat.o(192680);
    return i;
  }
  
  public View getView()
  {
    AppMethodBeat.i(192675);
    if (this.mView == null) {
      this.mView = this.LaA.aQe();
    }
    View localView = this.mView;
    AppMethodBeat.o(192675);
    return localView;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(192679);
    if (this.LaA != null) {
      this.LaA.aQc();
    }
    int i = this.nkx;
    AppMethodBeat.o(192679);
    return i;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(192682);
    if (this.LaB) {
      this.ldB += 1;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(this.ldB, this.ldC - 1, this.ldD);
    Object localObject2 = Calendar.getInstance();
    if (this.nks == null) {
      this.nks = new Date(((Calendar)localObject1).getTimeInMillis());
    }
    ((Calendar)localObject2).setTime(this.nks);
    Calendar localCalendar = Calendar.getInstance();
    if (this.nkt == null)
    {
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(this.ldB + 100, this.ldC - 1, this.ldD);
      this.nkt = new Date(((Calendar)localObject3).getTimeInMillis());
    }
    localCalendar.setTime(this.nkt);
    Object localObject3 = this.LaA;
    boolean bool = this.LaB;
    ((h)localObject3).Lbj = bool;
    if (((h)localObject3).Lbi != null) {
      ((h)localObject3).Lbi.Lbv = bool;
    }
    localObject3 = new com.tencent.mm.ui.widget.picker.b.b(this.context, new g()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(192670);
        CustomDatePickerNew.a(CustomDatePickerNew.this, paramAnonymousDate);
        ap.i("pvTime", "onTimeSelect", new Object[0]);
        AppMethodBeat.o(192670);
      }
    });
    f local1 = new f()
    {
      public final void fMK()
      {
        AppMethodBeat.i(192669);
        ap.i("pvTime", "onTimeSelectChanged", new Object[0]);
        AppMethodBeat.o(192669);
      }
    };
    ((com.tencent.mm.ui.widget.picker.b.b)localObject3).Lax.Lck = local1;
    localObject1 = ((com.tencent.mm.ui.widget.picker.b.b)localObject3).fMY().c(new boolean[] { this.nkm, this.nkn, this.nko, false, false, false }).b((Calendar)localObject1).b((Calendar)localObject2, localCalendar);
    int i = this.context.getResources().getDimensionPixelSize(2131165292);
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).Lax.kl = i;
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).c(this.LaA);
    this.LaA.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131165292);
    localObject1 = this.LaA;
    bool = this.LaB;
    if (((h)localObject1).Lbi != null)
    {
      localObject1 = ((h)localObject1).Lbi;
      ((j)localObject1).Lbv = bool;
      ((j)localObject1).Lbu.Lcg = bool;
      ((j)localObject1).Lbo.setLongTermYear(bool);
      ((j)localObject1).Lbp.setLongTermMonthDay(bool);
      ((j)localObject1).Lbq.setLongTermMonthDay(bool);
    }
    localObject1 = this.LaA;
    i = android.support.v4.content.b.n(this.context, 2131099656);
    ((h)localObject1).Lbi.setDividerColor(i);
    this.LaA.du(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    localObject1 = this.LaA.fMP().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WheelView)((Iterator)localObject1).next();
      if ((this.LaB) && (this.ldB == 2) && (i > 0)) {
        ((WheelView)localObject2).afG(0).afF(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
      for (;;)
      {
        i += 1;
        break;
        ((WheelView)localObject2).afG(android.support.v4.content.b.n(this.context, 2131099664)).afF(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
    }
    localObject1 = this.LaA.fMP();
    if (((List)localObject1).size() == 1)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(192682);
      return;
    }
    if (((List)localObject1).size() == 2)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(192682);
      return;
    }
    if (((List)localObject1).size() == 3)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
    }
    AppMethodBeat.o(192682);
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.LaB = paramBoolean;
  }
  
  public void setMaxDate(Long paramLong)
  {
    AppMethodBeat.i(192677);
    this.nkt = new Date(paramLong.longValue());
    AppMethodBeat.o(192677);
  }
  
  public void setMinDate(Long paramLong)
  {
    AppMethodBeat.i(192678);
    this.nks = new Date(paramLong.longValue());
    AppMethodBeat.o(192678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew
 * JD-Core Version:    0.7.0.1
 */