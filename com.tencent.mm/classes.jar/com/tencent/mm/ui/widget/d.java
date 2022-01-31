package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import com.tencent.mm.ac.a.k;

public final class d
  extends DatePickerDialog
{
  private boolean wjd = true;
  private long wje;
  private int wjf;
  
  public d(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super(paramContext, 3, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.wje = paramLong;
    this.wjf = 1;
  }
  
  public d(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong, byte paramByte)
  {
    super(paramContext, 3, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.wje = paramLong;
    this.wjf = 1;
  }
  
  private void fK(int paramInt1, int paramInt2)
  {
    if (this.wjf > 1) {
      setTitle(getContext().getString(a.k.fmt_year_month_str, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1) }));
    }
  }
  
  public final void ih(long paramLong)
  {
    getDatePicker().setMaxDate(paramLong);
  }
  
  public final void ii(long paramLong)
  {
    getDatePicker().setMinDate(paramLong);
  }
  
  public final void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onDateChanged(paramDatePicker, paramInt1, paramInt2, paramInt3);
    fK(paramInt1, paramInt2);
  }
  
  @SuppressLint({"DefaultLocale"})
  public final void show()
  {
    int j = 1;
    super.show();
    Object localObject;
    if (this.wjd)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label97;
      }
      localObject = new d.a(this).s((ViewGroup)getWindow().getDecorView());
      if ((localObject != null) && (this.wjf > 1)) {
        ((View)localObject).setVisibility(8);
      }
    }
    label97:
    label234:
    for (;;)
    {
      int i = getDatePicker().getYear();
      j = getDatePicker().getMonth();
      getDatePicker().getDayOfMonth();
      fK(i, j);
      this.wjd = false;
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
          break label234;
        }
        localObject = new d.b(this).f((ViewGroup)getWindow().getDecorView(), i);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */