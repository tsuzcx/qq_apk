package com.tencent.mm.ui.widget;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.k;

public final class g
  extends DatePickerDialog
{
  private boolean afSW = true;
  private long afSX;
  private int afSY;
  
  public g(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super(paramContext, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.afSX = paramLong;
    this.afSY = 1;
  }
  
  public g(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong, byte paramByte)
  {
    super(paramContext, 3, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.afSX = paramLong;
    this.afSY = 1;
  }
  
  public g(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong, char paramChar)
  {
    super(paramContext, 3, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.afSX = paramLong;
    this.afSY = 1;
  }
  
  private void oG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143344);
    if (this.afSY > 1) {
      setTitle(getContext().getString(a.k.fmt_year_month_str, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1) }));
    }
    AppMethodBeat.o(143344);
  }
  
  public final void Ay(long paramLong)
  {
    AppMethodBeat.i(143345);
    getDatePicker().setMaxDate(paramLong);
    AppMethodBeat.o(143345);
  }
  
  public final void Az(long paramLong)
  {
    AppMethodBeat.i(143346);
    getDatePicker().setMinDate(paramLong);
    AppMethodBeat.o(143346);
  }
  
  public final void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143343);
    super.onDateChanged(paramDatePicker, paramInt1, paramInt2, paramInt3);
    oG(paramInt1, paramInt2);
    AppMethodBeat.o(143343);
  }
  
  public final void show()
  {
    int j = 1;
    AppMethodBeat.i(143342);
    super.show();
    Object localObject;
    if (this.afSW)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label107;
      }
      localObject = new a().ai((ViewGroup)getWindow().getDecorView());
      if ((localObject != null) && (this.afSY > 1)) {
        ((View)localObject).setVisibility(8);
      }
    }
    label107:
    label244:
    for (;;)
    {
      int i = getDatePicker().getYear();
      j = getDatePicker().getMonth();
      getDatePicker().getDayOfMonth();
      oG(i, j);
      this.afSW = false;
      AppMethodBeat.o(143342);
      return;
      String str = Settings.System.getString(getContext().getContentResolver(), "date_format");
      localObject = str;
      if (str != null) {
        localObject = str.toLowerCase();
      }
      if (("dd/mm/yyyy".equals(localObject)) || ("dd-mm-yyyy".equals(localObject))) {
        i = 0;
      }
      for (;;)
      {
        if (i == -1) {
          break label244;
        }
        localObject = new g.b(this).p((ViewGroup)getWindow().getDecorView(), i);
        if (localObject == null) {
          break;
        }
        ((View)localObject).setVisibility(8);
        break;
        i = j;
        if (!"mm/dd/yyyy".equals(localObject))
        {
          i = j;
          if (!"mm-dd-yyyy".equals(localObject)) {
            if (("yyyy/mm/dd".equals(localObject)) || ("yyyy-mm-dd".equals(localObject))) {
              i = 2;
            } else {
              i = -1;
            }
          }
        }
      }
    }
  }
  
  final class a
  {
    a() {}
    
    public final NumberPicker ai(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(143340);
      if (paramViewGroup != null)
      {
        int j = paramViewGroup.getChildCount();
        int i = 0;
        while (i < j)
        {
          Object localObject = paramViewGroup.getChildAt(i);
          if ((localObject instanceof NumberPicker))
          {
            NumberPicker localNumberPicker = (NumberPicker)localObject;
            if ((localNumberPicker.getMaxValue() >= 28) && (localNumberPicker.getMaxValue() <= 31))
            {
              AppMethodBeat.o(143340);
              return localNumberPicker;
            }
          }
          if ((localObject instanceof ViewGroup))
          {
            localObject = ai((ViewGroup)localObject);
            if (localObject != null)
            {
              AppMethodBeat.o(143340);
              return localObject;
            }
          }
          i += 1;
        }
      }
      AppMethodBeat.o(143340);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */