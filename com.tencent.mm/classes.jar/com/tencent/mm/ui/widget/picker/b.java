package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.at;
import java.util.Calendar;
import java.util.Locale;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout PTf;
  private Button QSR;
  private LinearLayout QSS;
  private CustomDatePickerNew QST;
  public a QSU;
  private Button hPX;
  private Button hSq;
  private View lJI;
  private Context mContext;
  private int mLJ;
  private BottomSheetBehavior mLK;
  private android.support.design.widget.a yfL;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(159526);
    this.mContext = paramContext;
    this.yfL = new android.support.design.widget.a(this.mContext);
    this.lJI = View.inflate(this.mContext, 2131493814, null);
    this.QSS = ((LinearLayout)this.lJI.findViewById(2131299415));
    this.PTf = ((LinearLayout)this.lJI.findViewById(2131299417));
    this.QST = new CustomDatePickerNew(this.mContext);
    this.QSS.removeAllViews();
    this.QSS.setGravity(17);
    this.QSS.addView(this.QST.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.hPX = ((Button)this.lJI.findViewById(2131305592));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159522);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159522);
      }
    });
    this.hSq = ((Button)this.lJI.findViewById(2131297963));
    this.hSq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159523);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159523);
      }
    });
    this.QSR = ((Button)this.lJI.findViewById(2131297850));
    this.QSR.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198420);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198420);
      }
    });
    this.yfL.setContentView(this.lJI);
    this.yfL.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(198421);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(198421);
      }
    });
    this.mLJ = at.fromDPToPix(this.mContext, 420);
    this.mLK = BottomSheetBehavior.l((View)this.lJI.getParent());
    if (this.mLK != null)
    {
      this.mLK.J(this.mLJ);
      this.mLK.ob = false;
    }
    this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(198422);
        b.b(b.this);
        AppMethodBeat.o(198422);
      }
    });
    AppMethodBeat.o(159526);
  }
  
  public final void aX(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159527);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159527);
      return;
    }
    if (this.QST != null) {
      this.QST.aW(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(159527);
  }
  
  public final void aY(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159529);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159529);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.QST != null) {
      this.QST.setMinDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159529);
  }
  
  public final void aZ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159530);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159530);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.QST != null) {
      this.QST.setMaxDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159530);
  }
  
  public final void bg(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(159528);
    if (this.QST != null) {
      this.QST.bg(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(159528);
  }
  
  public final String hcf()
  {
    AppMethodBeat.i(159533);
    String str = null;
    if (this.QST != null) {
      str = this.QST.currentValue();
    }
    AppMethodBeat.o(159533);
    return str;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159532);
    if (this.yfL != null) {
      this.yfL.dismiss();
    }
    AppMethodBeat.o(159532);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setLongTermYear(boolean paramBoolean)
  {
    AppMethodBeat.i(198423);
    if (this.QST != null) {
      this.QST.setLongTermYear(paramBoolean);
    }
    AppMethodBeat.o(198423);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159531);
    if (this.yfL != null)
    {
      if (this.QST != null) {
        this.QST.onShow();
      }
      this.yfL.show();
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