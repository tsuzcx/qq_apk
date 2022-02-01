package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import java.util.Calendar;
import java.util.Locale;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout Itj;
  private Button Jjk;
  private LinearLayout Jjl;
  private CustomDatePickerNew Jjm;
  public a Jjn;
  private Button gAJ;
  private Button gCY;
  private View khe;
  private int lcC;
  private BottomSheetBehavior lcD;
  private Context mContext;
  private a tyZ;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(159526);
    this.mContext = paramContext;
    this.tyZ = new a(this.mContext);
    this.khe = View.inflate(this.mContext, 2131493683, null);
    this.Jjl = ((LinearLayout)this.khe.findViewById(2131298931));
    this.Itj = ((LinearLayout)this.khe.findViewById(2131307182));
    this.Jjm = new CustomDatePickerNew(this.mContext);
    this.Jjl.removeAllViews();
    this.Jjl.setGravity(17);
    this.Jjl.addView(this.Jjm.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.gAJ = ((Button)this.khe.findViewById(2131302999));
    this.gAJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159522);
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        AppMethodBeat.o(159522);
      }
    });
    this.gCY = ((Button)this.khe.findViewById(2131297690));
    this.gCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159523);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(159523);
      }
    });
    this.Jjk = ((Button)this.khe.findViewById(2131297600));
    this.Jjk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(199758);
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        AppMethodBeat.o(199758);
      }
    });
    this.tyZ.setContentView(this.khe);
    this.tyZ.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(199759);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(199759);
      }
    });
    this.lcC = ao.fromDPToPix(this.mContext, 420);
    this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
    if (this.lcD != null)
    {
      this.lcD.J(this.lcC);
      this.lcD.mg = false;
    }
    this.tyZ.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(199760);
        b.b(b.this);
        AppMethodBeat.o(199760);
      }
    });
    AppMethodBeat.o(159526);
  }
  
  public final void aO(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159527);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159527);
      return;
    }
    if (this.Jjm != null) {
      this.Jjm.aN(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(159527);
  }
  
  public final void aP(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159529);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159529);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.Jjm != null) {
      this.Jjm.setMinDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159529);
  }
  
  public final void aP(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(159528);
    if (this.Jjm != null) {
      this.Jjm.aP(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(159528);
  }
  
  public final void aQ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159530);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159530);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.Jjm != null) {
      this.Jjm.setMaxDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159530);
  }
  
  public final String fvX()
  {
    AppMethodBeat.i(159533);
    String str = null;
    if (this.Jjm != null) {
      str = this.Jjm.currentValue();
    }
    AppMethodBeat.o(159533);
    return str;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159532);
    if (this.tyZ != null) {
      this.tyZ.dismiss();
    }
    AppMethodBeat.o(159532);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setLongTermYear(boolean paramBoolean)
  {
    AppMethodBeat.i(199761);
    if (this.Jjm != null) {
      this.Jjm.setLongTermYear(paramBoolean);
    }
    AppMethodBeat.o(199761);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159531);
    if (this.tyZ != null)
    {
      if (this.Jjm != null) {
        this.Jjm.onShow();
      }
      this.tyZ.show();
    }
    AppMethodBeat.o(159531);
  }
  
  public static abstract interface a<T>
  {
    public abstract void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */