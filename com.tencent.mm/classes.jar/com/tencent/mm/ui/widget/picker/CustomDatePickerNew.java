package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
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
  private h QSK;
  private boolean QSL;
  private Context context;
  private View mView;
  private int mmI;
  private int mmJ;
  private int mmK;
  private boolean ozb;
  private boolean ozc;
  private boolean ozd;
  private Date ozh;
  private Date ozi;
  private int ozm;
  private int ozn;
  private int ozo;
  
  public CustomDatePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821727));
    AppMethodBeat.i(198387);
    this.mView = null;
    this.ozd = true;
    this.ozc = true;
    this.ozb = true;
    this.QSL = false;
    this.context = paramContext;
    this.QSK = new h(paramContext);
    AppMethodBeat.o(198387);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821727), paramAttributeSet);
    AppMethodBeat.i(198388);
    this.mView = null;
    this.ozd = true;
    this.ozc = true;
    this.ozb = true;
    this.QSL = false;
    this.context = paramContext;
    this.QSK = new h(paramContext);
    AppMethodBeat.o(198388);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198389);
    this.mView = null;
    this.ozd = true;
    this.ozc = true;
    this.ozb = true;
    this.QSL = false;
    this.context = paramContext;
    this.QSK = new h(paramContext);
    AppMethodBeat.o(198389);
  }
  
  public final void aW(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(198392);
    this.mmI = paramInt1;
    this.mmJ = paramInt2;
    this.mmK = paramInt3;
    if (this.mView == null) {
      this.mView = this.QSK.bli();
    }
    AppMethodBeat.o(198392);
  }
  
  public final void bg(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.ozd = paramBoolean2;
    this.ozc = paramBoolean1;
    this.ozb = true;
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(198390);
    this.QSK.blg();
    if (this.ozd)
    {
      str = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(this.ozm), Integer.valueOf(this.ozn), Integer.valueOf(this.ozo) });
      AppMethodBeat.o(198390);
      return str;
    }
    if (this.ozc)
    {
      str = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(this.ozm), Integer.valueOf(this.ozn) });
      AppMethodBeat.o(198390);
      return str;
    }
    String str = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(this.ozm) });
    AppMethodBeat.o(198390);
    return str;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(198397);
    if (this.QSK != null) {
      this.QSK.blg();
    }
    int i = this.ozo;
    AppMethodBeat.o(198397);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(198396);
    if (this.QSK != null) {
      this.QSK.blg();
    }
    int i = this.ozn;
    AppMethodBeat.o(198396);
    return i;
  }
  
  public View getView()
  {
    AppMethodBeat.i(198391);
    if (this.mView == null) {
      this.mView = this.QSK.bli();
    }
    View localView = this.mView;
    AppMethodBeat.o(198391);
    return localView;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(198395);
    if (this.QSK != null) {
      this.QSK.blg();
    }
    int i = this.ozm;
    AppMethodBeat.o(198395);
    return i;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(198398);
    if (this.QSL) {
      this.mmI += 1;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(this.mmI, this.mmJ - 1, this.mmK);
    Object localObject2 = Calendar.getInstance();
    if (this.ozh == null) {
      this.ozh = new Date(((Calendar)localObject1).getTimeInMillis());
    }
    ((Calendar)localObject2).setTime(this.ozh);
    Calendar localCalendar = Calendar.getInstance();
    if (this.ozi == null)
    {
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(this.mmI + 100, this.mmJ - 1, this.mmK);
      this.ozi = new Date(((Calendar)localObject3).getTimeInMillis());
    }
    localCalendar.setTime(this.ozi);
    Object localObject3 = this.QSK;
    boolean bool = this.QSL;
    ((h)localObject3).QTz = bool;
    if (((h)localObject3).QTy != null) {
      ((h)localObject3).QTy.QTL = bool;
    }
    localObject3 = new com.tencent.mm.ui.widget.picker.b.b(this.context, new g()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(198386);
        CustomDatePickerNew.a(CustomDatePickerNew.this, paramAnonymousDate);
        as.i("pvTime", "onTimeSelect", new Object[0]);
        AppMethodBeat.o(198386);
      }
    });
    f local1 = new f()
    {
      public final void hce()
      {
        AppMethodBeat.i(198385);
        as.i("pvTime", "onTimeSelectChanged", new Object[0]);
        AppMethodBeat.o(198385);
      }
    };
    ((com.tencent.mm.ui.widget.picker.b.b)localObject3).QSH.QUB = local1;
    localObject1 = ((com.tencent.mm.ui.widget.picker.b.b)localObject3).hcv().c(new boolean[] { this.ozb, this.ozc, this.ozd, false, false, false }).b((Calendar)localObject1).b((Calendar)localObject2, localCalendar);
    int i = this.context.getResources().getDimensionPixelSize(2131165299);
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).QSH.kn = i;
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).c(this.QSK);
    this.QSK.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165950));
    this.context.getResources().getDimensionPixelSize(2131165299);
    localObject1 = this.QSK;
    bool = this.QSL;
    if (((h)localObject1).QTy != null)
    {
      localObject1 = ((h)localObject1).QTy;
      ((j)localObject1).QTL = bool;
      ((j)localObject1).QTK.QUx = bool;
      ((j)localObject1).QTE.setLongTermYear(bool);
      ((j)localObject1).QTF.setLongTermMonthDay(bool);
      ((j)localObject1).QTG.setLongTermMonthDay(bool);
    }
    localObject1 = this.QSK;
    i = android.support.v4.content.b.n(this.context, 2131099657);
    ((h)localObject1).QTy.setDividerColor(i);
    this.QSK.dE(this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296));
    localObject1 = this.QSK.hcm().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WheelView)((Iterator)localObject1).next();
      if ((this.QSL) && (this.mmI == 2) && (i > 0)) {
        ((WheelView)localObject2).aps(0).apr(this.context.getResources().getDimensionPixelSize(2131165296)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
      for (;;)
      {
        i += 1;
        break;
        ((WheelView)localObject2).aps(android.support.v4.content.b.n(this.context, 2131099669)).apr(this.context.getResources().getDimensionPixelSize(2131165296)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
    }
    localObject1 = this.QSK.hcm();
    if (((List)localObject1).size() == 1)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
      AppMethodBeat.o(198398);
      return;
    }
    if (((List)localObject1).size() == 2)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
      AppMethodBeat.o(198398);
      return;
    }
    if (((List)localObject1).size() == 3)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject1).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
    }
    AppMethodBeat.o(198398);
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.QSL = paramBoolean;
  }
  
  public void setMaxDate(Long paramLong)
  {
    AppMethodBeat.i(198393);
    this.ozi = new Date(paramLong.longValue());
    AppMethodBeat.o(198393);
  }
  
  public void setMinDate(Long paramLong)
  {
    AppMethodBeat.i(198394);
    this.ozh = new Date(paramLong.longValue());
    AppMethodBeat.o(198394);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew
 * JD-Core Version:    0.7.0.1
 */