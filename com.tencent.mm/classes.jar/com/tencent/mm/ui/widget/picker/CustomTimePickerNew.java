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
import com.tencent.mm.picker.f.e;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomTimePickerNew
  extends FrameLayout
{
  private Context context;
  int currentHour;
  int currentMinute;
  public int mMaxTimeHour;
  public int mMaxTimeMinute;
  public int mMinTimeHour;
  public int mMinTimeMinute;
  private View mView;
  c pvTime;
  public int sqv;
  public int sqw;
  
  public CustomTimePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker));
    AppMethodBeat.i(252583);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.sqv = -1;
    this.sqw = -1;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(252583);
  }
  
  public CustomTimePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, a.j.Widget_Picker), paramAttributeSet);
    AppMethodBeat.i(252587);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.sqv = -1;
    this.sqw = -1;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(252587);
  }
  
  public CustomTimePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(252593);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.sqv = -1;
    this.sqw = -1;
    this.context = paramContext;
    this.pvTime = new c(paramContext);
    AppMethodBeat.o(252593);
  }
  
  public View getView()
  {
    AppMethodBeat.i(252603);
    if (this.mView == null) {
      this.mView = this.pvTime.bTg();
    }
    View localView = this.mView;
    AppMethodBeat.o(252603);
    return localView;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(252619);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(11, this.sqv);
    ((Calendar)localObject).set(12, this.sqw);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(11, this.mMinTimeHour);
    localCalendar1.set(12, this.mMinTimeMinute);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(11, this.mMaxTimeHour);
    localCalendar2.set(12, this.mMaxTimeMinute);
    new b(this.context, new f()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(252646);
        CustomTimePickerNew.a(CustomTimePickerNew.this, paramAnonymousDate);
        AppMethodBeat.o(252646);
      }
    }).d(new boolean[] { 0, 0, 0, 1, 1, 0 }).a((Calendar)localObject).a(localCalendar1, localCalendar2).bSW().xV(a.w(this.context, a.c.BW_0_Alpha_0_1)).a(this.pvTime);
    this.pvTime.setDividerHeight(this.context.getResources().getDimensionPixelSize(a.d.bottomsheet_dividing_line_height));
    this.context.getResources().getDimensionPixelSize(a.d.Edge_3A);
    this.pvTime.eV(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
    localObject = this.pvTime.pzv.bTk().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).xS(a.w(this.context, a.c.BW_0_Alpha_0_9)).xR(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A)).setBackgroundColor(a.w(this.context, a.c.BG_5));
    }
    localObject = this.pvTime.pzv.bTk();
    if (((List)localObject).size() == 1)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      AppMethodBeat.o(252619);
      return;
    }
    if (((List)localObject).size() == 2)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      AppMethodBeat.o(252619);
      return;
    }
    if (((List)localObject).size() == 3)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
      ((WheelView)((List)localObject).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(a.d.Edge_0_5_A), this.context.getResources().getDimensionPixelSize(a.d.Edge_2A), 0, this.context.getResources().getDimensionPixelSize(a.d.Edge_2A));
    }
    AppMethodBeat.o(252619);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePickerNew
 * JD-Core Version:    0.7.0.1
 */