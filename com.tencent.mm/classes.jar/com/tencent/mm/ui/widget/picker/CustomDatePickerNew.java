package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CustomDatePickerNew
  extends FrameLayout
{
  private h Jjd;
  private boolean Jje;
  private Context context;
  private int kHi;
  private int kHj;
  private int kHk;
  private boolean mJQ;
  private boolean mJR;
  private boolean mJS;
  private Date mJW;
  private Date mJX;
  private int mKb;
  private int mKc;
  private int mKd;
  private View mView;
  
  public CustomDatePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(199725);
    this.mView = null;
    this.mJS = true;
    this.mJR = true;
    this.mJQ = true;
    this.Jje = false;
    this.context = paramContext;
    this.Jjd = new h(paramContext);
    AppMethodBeat.o(199725);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(199726);
    this.mView = null;
    this.mJS = true;
    this.mJR = true;
    this.mJQ = true;
    this.Jje = false;
    this.context = paramContext;
    this.Jjd = new h(paramContext);
    AppMethodBeat.o(199726);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199727);
    this.mView = null;
    this.mJS = true;
    this.mJR = true;
    this.mJQ = true;
    this.Jje = false;
    this.context = paramContext;
    this.Jjd = new h(paramContext);
    AppMethodBeat.o(199727);
  }
  
  public final void aN(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(199730);
    this.kHi = paramInt1;
    this.kHj = paramInt2;
    this.kHk = paramInt3;
    if (this.mView == null) {
      this.mView = this.Jjd.aMT();
    }
    AppMethodBeat.o(199730);
  }
  
  public final void aP(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mJS = paramBoolean2;
    this.mJR = paramBoolean1;
    this.mJQ = true;
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(199728);
    this.Jjd.aMR();
    if (this.mJS)
    {
      str = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(this.mKb), Integer.valueOf(this.mKc), Integer.valueOf(this.mKd) });
      AppMethodBeat.o(199728);
      return str;
    }
    if (this.mJR)
    {
      str = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(this.mKb), Integer.valueOf(this.mKc) });
      AppMethodBeat.o(199728);
      return str;
    }
    String str = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(this.mKb) });
    AppMethodBeat.o(199728);
    return str;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(199735);
    if (this.Jjd != null) {
      this.Jjd.aMR();
    }
    int i = this.mKd;
    AppMethodBeat.o(199735);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(199734);
    if (this.Jjd != null) {
      this.Jjd.aMR();
    }
    int i = this.mKc;
    AppMethodBeat.o(199734);
    return i;
  }
  
  public View getView()
  {
    AppMethodBeat.i(199729);
    if (this.mView == null) {
      this.mView = this.Jjd.aMT();
    }
    View localView = this.mView;
    AppMethodBeat.o(199729);
    return localView;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(199733);
    if (this.Jjd != null) {
      this.Jjd.aMR();
    }
    int i = this.mKb;
    AppMethodBeat.o(199733);
    return i;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(199736);
    if (this.Jje) {
      this.kHi += 1;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(this.kHi, this.kHj - 1, this.kHk);
    Object localObject2 = Calendar.getInstance();
    if (this.mJW == null) {
      this.mJW = new Date(((Calendar)localObject1).getTimeInMillis());
    }
    ((Calendar)localObject2).setTime(this.mJW);
    Calendar localCalendar = Calendar.getInstance();
    if (this.mJX == null)
    {
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(this.kHi + 100, this.kHj - 1, this.kHk);
      this.mJX = new Date(((Calendar)localObject3).getTimeInMillis());
    }
    localCalendar.setTime(this.mJX);
    Object localObject3 = this.Jjd;
    boolean bool = this.Jje;
    ((h)localObject3).JjM = bool;
    if (((h)localObject3).JjL != null) {
      ((h)localObject3).JjL.JjY = bool;
    }
    localObject3 = new com.tencent.mm.ui.widget.picker.b.b(this.context, new CustomDatePickerNew.2(this));
    CustomDatePickerNew.1 local1 = new CustomDatePickerNew.1(this);
    ((com.tencent.mm.ui.widget.picker.b.b)localObject3).Jja.JkN = local1;
    localObject1 = ((com.tencent.mm.ui.widget.picker.b.b)localObject3).fwk().c(new boolean[] { this.mJQ, this.mJR, this.mJS, false, false, false }).b((Calendar)localObject1).b((Calendar)localObject2, localCalendar);
    int i = this.context.getResources().getDimensionPixelSize(2131165292);
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).Jja.it = i;
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).c(this.Jjd);
    this.Jjd.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131165292);
    localObject1 = this.Jjd;
    bool = this.Jje;
    if (((h)localObject1).JjL != null)
    {
      localObject1 = ((h)localObject1).JjL;
      ((j)localObject1).JjY = bool;
      ((j)localObject1).JjX.JkJ = bool;
      ((j)localObject1).JjR.setLongTermYear(bool);
      ((j)localObject1).JjS.setLongTermMonthDay(bool);
      ((j)localObject1).JjT.setLongTermMonthDay(bool);
    }
    localObject1 = this.Jjd;
    i = android.support.v4.content.b.n(this.context, 2131099656);
    ((h)localObject1).JjL.setDividerColor(i);
    this.Jjd.ds(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    localObject1 = this.Jjd.fwb().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WheelView)((Iterator)localObject1).next();
      if ((this.Jje) && (this.kHi == 2) && (i > 0)) {
        ((WheelView)localObject2).adg(0).adf(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
      for (;;)
      {
        i += 1;
        break;
        ((WheelView)localObject2).adg(android.support.v4.content.b.n(this.context, 2131099664)).adf(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
    }
    localObject1 = this.Jjd.fwb();
    if (((List)localObject1).size() == 1)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(199736);
      return;
    }
    if (((List)localObject1).size() == 2)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(199736);
      return;
    }
    if (((List)localObject1).size() == 3)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
    }
    AppMethodBeat.o(199736);
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.Jje = paramBoolean;
  }
  
  public void setMaxDate(Long paramLong)
  {
    AppMethodBeat.i(199731);
    this.mJX = new Date(paramLong.longValue());
    AppMethodBeat.o(199731);
  }
  
  public void setMinDate(Long paramLong)
  {
    AppMethodBeat.i(199732);
    this.mJW = new Date(paramLong.longValue());
    AppMethodBeat.o(199732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew
 * JD-Core Version:    0.7.0.1
 */