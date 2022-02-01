package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
  private boolean Ybe = true;
  private long Ybf;
  private int Ybg;
  
  public g(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super(paramContext, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.Ybf = paramLong;
    this.Ybg = 1;
  }
  
  public g(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong, byte paramByte)
  {
    super(paramContext, 3, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.Ybf = paramLong;
    this.Ybg = 1;
  }
  
  public g(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong, char paramChar)
  {
    super(paramContext, 3, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.Ybf = paramLong;
    this.Ybg = 1;
  }
  
  private void mN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143344);
    if (this.Ybg > 1) {
      setTitle(getContext().getString(a.k.fmt_year_month_str, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1) }));
    }
    AppMethodBeat.o(143344);
  }
  
  public final void Wm(long paramLong)
  {
    AppMethodBeat.i(143345);
    getDatePicker().setMaxDate(paramLong);
    AppMethodBeat.o(143345);
  }
  
  public final void Wn(long paramLong)
  {
    AppMethodBeat.i(143346);
    getDatePicker().setMinDate(paramLong);
    AppMethodBeat.o(143346);
  }
  
  public final void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(143343);
    super.onDateChanged(paramDatePicker, paramInt1, paramInt2, paramInt3);
    mN(paramInt1, paramInt2);
    AppMethodBeat.o(143343);
  }
  
  @SuppressLint({"DefaultLocale"})
  public final void show()
  {
    int j = 1;
    AppMethodBeat.i(143342);
    super.show();
    Object localObject;
    if (this.Ybe)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label107;
      }
      localObject = new a().Y((ViewGroup)getWindow().getDecorView());
      if ((localObject != null) && (this.Ybg > 1)) {
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
      mN(i, j);
      this.Ybe = false;
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
    
    @TargetApi(11)
    public final NumberPicker Y(ViewGroup paramViewGroup)
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
            localObject = Y((ViewGroup)localObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */