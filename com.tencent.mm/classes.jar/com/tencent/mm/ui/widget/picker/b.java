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
import com.tencent.mm.ui.aq;
import java.util.Calendar;
import java.util.Locale;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout KjP;
  private Button LaH;
  private LinearLayout LaI;
  private CustomDatePickerNew LaJ;
  public b.a LaK;
  private Button gUt;
  private Button gWI;
  private View kBS;
  private int lzC;
  private BottomSheetBehavior lzD;
  private Context mContext;
  private android.support.design.widget.a uBI;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(159526);
    this.mContext = paramContext;
    this.uBI = new android.support.design.widget.a(this.mContext);
    this.kBS = View.inflate(this.mContext, 2131493683, null);
    this.LaI = ((LinearLayout)this.kBS.findViewById(2131298931));
    this.KjP = ((LinearLayout)this.kBS.findViewById(2131307182));
    this.LaJ = new CustomDatePickerNew(this.mContext);
    this.LaI.removeAllViews();
    this.LaI.setGravity(17);
    this.LaI.addView(this.LaJ.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.gUt = ((Button)this.kBS.findViewById(2131302999));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159522);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159522);
      }
    });
    this.gWI = ((Button)this.kBS.findViewById(2131297690));
    this.gWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159523);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159523);
      }
    });
    this.LaH = ((Button)this.kBS.findViewById(2131297600));
    this.LaH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(192704);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(192704);
      }
    });
    this.uBI.setContentView(this.kBS);
    this.uBI.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(192705);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(192705);
      }
    });
    this.lzC = aq.fromDPToPix(this.mContext, 420);
    this.lzD = BottomSheetBehavior.l((View)this.kBS.getParent());
    if (this.lzD != null)
    {
      this.lzD.J(this.lzC);
      this.lzD.nZ = false;
    }
    this.uBI.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(192706);
        b.b(b.this);
        AppMethodBeat.o(192706);
      }
    });
    AppMethodBeat.o(159526);
  }
  
  public final void aP(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159527);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159527);
      return;
    }
    if (this.LaJ != null) {
      this.LaJ.aO(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(159527);
  }
  
  public final void aQ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159529);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159529);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.LaJ != null) {
      this.LaJ.setMinDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159529);
  }
  
  public final void aR(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159530);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159530);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.LaJ != null) {
      this.LaJ.setMaxDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159530);
  }
  
  public final void aX(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(159528);
    if (this.LaJ != null) {
      this.LaJ.aX(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(159528);
  }
  
  public final String fML()
  {
    AppMethodBeat.i(159533);
    String str = null;
    if (this.LaJ != null) {
      str = this.LaJ.currentValue();
    }
    AppMethodBeat.o(159533);
    return str;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159532);
    if (this.uBI != null) {
      this.uBI.dismiss();
    }
    AppMethodBeat.o(159532);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setLongTermYear(boolean paramBoolean)
  {
    AppMethodBeat.i(192707);
    if (this.LaJ != null) {
      this.LaJ.setLongTermYear(paramBoolean);
    }
    AppMethodBeat.o(192707);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159531);
    if (this.uBI != null)
    {
      if (this.LaJ != null) {
        this.LaJ.onShow();
      }
      this.uBI.show();
    }
    AppMethodBeat.o(159531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */