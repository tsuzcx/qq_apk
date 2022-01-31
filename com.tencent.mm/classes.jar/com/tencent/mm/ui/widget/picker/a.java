package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.NumberPicker;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.ap;
import java.util.Calendar;
import java.util.Locale;

public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private BottomSheetBehavior fK;
  private Button fbO;
  private Button hPe;
  private View jdj;
  private Context mContext;
  private c vAB;
  private int vAC;
  public CustomDatePicker won;
  public a.a woo;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.vAB = new c(this.mContext);
    this.jdj = View.inflate(this.mContext, a.g.date_picker_panel, null);
    this.won = ((CustomDatePicker)this.jdj.findViewById(a.f.date_picker));
    this.fbO = ((Button)this.jdj.findViewById(a.f.ok_btn));
    this.fbO.setOnClickListener(new a.1(this));
    this.hPe = ((Button)this.jdj.findViewById(a.f.cancel_btn));
    this.hPe.setOnClickListener(new a.2(this));
    this.vAB.setContentView(this.jdj);
    this.vAB.setOnCancelListener(new a.3(this));
    this.vAC = ap.fromDPToPix(this.mContext, 288);
    this.fK = BottomSheetBehavior.i((View)this.jdj.getParent());
    if (this.fK != null)
    {
      this.fK.u(this.vAC);
      this.fK.fq = false;
    }
    this.vAB.setOnDismissListener(new a.4(this));
  }
  
  public final void Z(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    Object localObject;
    if (this.won != null)
    {
      localObject = this.won;
      ((CustomDatePicker)localObject).hzK = paramBoolean1;
      ((CustomDatePicker)localObject).hzL = paramBoolean2;
      if (((CustomDatePicker)localObject).hzM != null)
      {
        ((CustomDatePicker)localObject).hzM.setEnabled(true);
        ((CustomDatePicker)localObject).hzM.setVisibility(0);
      }
      if (((CustomDatePicker)localObject).hzN != null)
      {
        ((CustomDatePicker)localObject).hzN.setEnabled(paramBoolean1);
        NumberPicker localNumberPicker = ((CustomDatePicker)localObject).hzN;
        if (!paramBoolean1) {
          break label128;
        }
        i = 0;
        localNumberPicker.setVisibility(i);
      }
      if (((CustomDatePicker)localObject).hzO != null)
      {
        ((CustomDatePicker)localObject).hzO.setEnabled(paramBoolean2);
        localObject = ((CustomDatePicker)localObject).hzO;
        if (!paramBoolean2) {
          break label134;
        }
      }
    }
    label128:
    label134:
    for (int i = j;; i = 8)
    {
      ((NumberPicker)localObject).setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  public final void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0)) {}
    while (this.won == null) {
      return;
    }
    this.won.an(paramInt1, paramInt2, paramInt3);
  }
  
  public final void ap(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0)) {}
    Calendar localCalendar;
    do
    {
      return;
      localCalendar = Calendar.getInstance(Locale.US);
      localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    } while (this.won == null);
    this.won.setMinDate(localCalendar.getTimeInMillis());
  }
  
  public final void aq(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0)) {}
    Calendar localCalendar;
    do
    {
      return;
      localCalendar = Calendar.getInstance(Locale.US);
      localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    } while (this.won == null);
    this.won.setMaxDate(localCalendar.getTimeInMillis());
  }
  
  public final void hide()
  {
    if (this.vAB != null) {
      this.vAB.dismiss();
    }
  }
  
  public final void onGlobalLayout() {}
  
  public final void show()
  {
    if (this.vAB != null)
    {
      if (this.won != null) {
        this.won.asO();
      }
      this.vAB.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */