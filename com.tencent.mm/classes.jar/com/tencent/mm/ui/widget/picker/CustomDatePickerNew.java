package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
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
  private h HIG;
  private boolean HIH;
  private Context context;
  private int kgs;
  private int kgt;
  private int kgu;
  private View mView;
  private boolean mhP;
  private boolean mhQ;
  private boolean mhR;
  private Date mhV;
  private Date mhW;
  private int mia;
  private int mib;
  private int mic;
  
  public CustomDatePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(195255);
    this.mView = null;
    this.mhR = true;
    this.mhQ = true;
    this.mhP = true;
    this.HIH = false;
    this.context = paramContext;
    this.HIG = new h(paramContext);
    AppMethodBeat.o(195255);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(195256);
    this.mView = null;
    this.mhR = true;
    this.mhQ = true;
    this.mhP = true;
    this.HIH = false;
    this.context = paramContext;
    this.HIG = new h(paramContext);
    AppMethodBeat.o(195256);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195257);
    this.mView = null;
    this.mhR = true;
    this.mhQ = true;
    this.mhP = true;
    this.HIH = false;
    this.context = paramContext;
    this.HIG = new h(paramContext);
    AppMethodBeat.o(195257);
  }
  
  public final void aL(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195260);
    this.kgs = paramInt1;
    this.kgt = paramInt2;
    this.kgu = paramInt3;
    if (this.mView == null) {
      this.mView = this.HIG.aGg();
    }
    AppMethodBeat.o(195260);
  }
  
  public final void aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mhR = paramBoolean2;
    this.mhQ = paramBoolean1;
    this.mhP = true;
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(195258);
    this.HIG.aGe();
    if (this.mhR)
    {
      str = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(this.mia), Integer.valueOf(this.mib), Integer.valueOf(this.mic) });
      AppMethodBeat.o(195258);
      return str;
    }
    if (this.mhQ)
    {
      str = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(this.mia), Integer.valueOf(this.mib) });
      AppMethodBeat.o(195258);
      return str;
    }
    String str = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(this.mia) });
    AppMethodBeat.o(195258);
    return str;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(195265);
    if (this.HIG != null) {
      this.HIG.aGe();
    }
    int i = this.mic;
    AppMethodBeat.o(195265);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(195264);
    if (this.HIG != null) {
      this.HIG.aGe();
    }
    int i = this.mib;
    AppMethodBeat.o(195264);
    return i;
  }
  
  public View getView()
  {
    AppMethodBeat.i(195259);
    if (this.mView == null) {
      this.mView = this.HIG.aGg();
    }
    View localView = this.mView;
    AppMethodBeat.o(195259);
    return localView;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(195263);
    if (this.HIG != null) {
      this.HIG.aGe();
    }
    int i = this.mia;
    AppMethodBeat.o(195263);
    return i;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(195266);
    if (this.HIH) {
      this.kgs += 1;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(this.kgs, this.kgt - 1, this.kgu);
    Object localObject2 = Calendar.getInstance();
    if (this.mhV == null) {
      this.mhV = new Date(((Calendar)localObject1).getTimeInMillis());
    }
    ((Calendar)localObject2).setTime(this.mhV);
    Calendar localCalendar = Calendar.getInstance();
    if (this.mhW == null)
    {
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(this.kgs + 100, this.kgt - 1, this.kgu);
      this.mhW = new Date(((Calendar)localObject3).getTimeInMillis());
    }
    localCalendar.setTime(this.mhW);
    Object localObject3 = this.HIG;
    boolean bool = this.HIH;
    ((h)localObject3).HJp = bool;
    if (((h)localObject3).HJo != null) {
      ((h)localObject3).HJo.HJB = bool;
    }
    localObject3 = new com.tencent.mm.ui.widget.picker.b.b(this.context, new g()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(195254);
        CustomDatePickerNew.a(CustomDatePickerNew.this, paramAnonymousDate);
        an.i("pvTime", "onTimeSelect", new Object[0]);
        AppMethodBeat.o(195254);
      }
    });
    f local1 = new f()
    {
      public final void ffX()
      {
        AppMethodBeat.i(195253);
        an.i("pvTime", "onTimeSelectChanged", new Object[0]);
        AppMethodBeat.o(195253);
      }
    };
    ((com.tencent.mm.ui.widget.picker.b.b)localObject3).HID.HKq = local1;
    localObject1 = ((com.tencent.mm.ui.widget.picker.b.b)localObject3).fgk().c(new boolean[] { this.mhP, this.mhQ, this.mhR, false, false, false }).b((Calendar)localObject1).b((Calendar)localObject2, localCalendar);
    int i = this.context.getResources().getDimensionPixelSize(2131165292);
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).HID.hr = i;
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).c(this.HIG);
    this.HIG.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131165292);
    localObject1 = this.HIG;
    bool = this.HIH;
    if (((h)localObject1).HJo != null)
    {
      localObject1 = ((h)localObject1).HJo;
      ((j)localObject1).HJB = bool;
      ((j)localObject1).HJA.HKm = bool;
      ((j)localObject1).HJu.setLongTermYear(bool);
      ((j)localObject1).HJv.setLongTermMonthDay(bool);
      ((j)localObject1).HJw.setLongTermMonthDay(bool);
    }
    localObject1 = this.HIG;
    i = android.support.v4.content.b.n(this.context, 2131099656);
    ((h)localObject1).HJo.setDividerColor(i);
    this.HIG.ds(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    localObject1 = this.HIG.fgc().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WheelView)((Iterator)localObject1).next();
      if ((this.HIH) && (this.kgs == 2) && (i > 0)) {
        ((WheelView)localObject2).aaU(0).aaT(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
      for (;;)
      {
        i += 1;
        break;
        ((WheelView)localObject2).aaU(android.support.v4.content.b.n(this.context, 2131099664)).aaT(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
    }
    localObject1 = this.HIG.fgc();
    if (((List)localObject1).size() == 1)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(195266);
      return;
    }
    if (((List)localObject1).size() == 2)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(195266);
      return;
    }
    if (((List)localObject1).size() == 3)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
    }
    AppMethodBeat.o(195266);
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.HIH = paramBoolean;
  }
  
  public void setMaxDate(Long paramLong)
  {
    AppMethodBeat.i(195261);
    this.mhW = new Date(paramLong.longValue());
    AppMethodBeat.o(195261);
  }
  
  public void setMinDate(Long paramLong)
  {
    AppMethodBeat.i(195262);
    this.mhV = new Date(paramLong.longValue());
    AppMethodBeat.o(195262);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew
 * JD-Core Version:    0.7.0.1
 */