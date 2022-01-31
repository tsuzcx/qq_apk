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
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends DatePickerDialog
{
  private boolean ACK = true;
  private long ACL;
  private int ACM;
  
  public e(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    super(paramContext, 3, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.ACL = paramLong;
    this.ACM = 1;
  }
  
  public e(Context paramContext, DatePickerDialog.OnDateSetListener paramOnDateSetListener, int paramInt1, int paramInt2, int paramInt3, long paramLong, byte paramByte)
  {
    super(paramContext, 3, paramOnDateSetListener, paramInt1, paramInt2, paramInt3);
    this.ACL = paramLong;
    this.ACM = 1;
  }
  
  private void hS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(107867);
    if (this.ACM > 1) {
      setTitle(getContext().getString(2131300114, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2 + 1) }));
    }
    AppMethodBeat.o(107867);
  }
  
  public final void oT(long paramLong)
  {
    AppMethodBeat.i(107868);
    getDatePicker().setMaxDate(paramLong);
    AppMethodBeat.o(107868);
  }
  
  public final void oU(long paramLong)
  {
    AppMethodBeat.i(107869);
    getDatePicker().setMinDate(paramLong);
    AppMethodBeat.o(107869);
  }
  
  public final void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(107866);
    super.onDateChanged(paramDatePicker, paramInt1, paramInt2, paramInt3);
    hS(paramInt1, paramInt2);
    AppMethodBeat.o(107866);
  }
  
  @SuppressLint({"DefaultLocale"})
  public final void show()
  {
    int j = 1;
    AppMethodBeat.i(107865);
    super.show();
    Object localObject;
    if (this.ACK)
    {
      if (Build.VERSION.SDK_INT < 11) {
        break label107;
      }
      localObject = new e.a(this).x((ViewGroup)getWindow().getDecorView());
      if ((localObject != null) && (this.ACM > 1)) {
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
      hS(i, j);
      this.ACK = false;
      AppMethodBeat.o(107865);
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
        localObject = new e.b(this).e((ViewGroup)getWindow().getDecorView(), i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.e
 * JD-Core Version:    0.7.0.1
 */