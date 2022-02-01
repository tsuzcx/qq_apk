package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aw;
import java.util.Calendar;
import java.util.Locale;

public class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private com.google.android.material.bottomsheet.a DpN;
  private LinearLayout XpQ;
  private Button YrC;
  private LinearLayout YrD;
  private CustomDatePickerNew YrE;
  public a YrF;
  private Button kEt;
  private Button kGN;
  private Context mContext;
  private View oFW;
  private int pMB;
  private BottomSheetBehavior pMC;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(159526);
    this.mContext = paramContext;
    this.DpN = new com.google.android.material.bottomsheet.a(this.mContext);
    this.oFW = View.inflate(this.mContext, a.g.date_picker_panel, null);
    this.YrD = ((LinearLayout)this.oFW.findViewById(a.f.date_picker));
    this.XpQ = ((LinearLayout)this.oFW.findViewById(a.f.date_picker_header));
    this.YrE = new CustomDatePickerNew(this.mContext);
    this.YrD.removeAllViews();
    this.YrD.setGravity(17);
    this.YrD.addView(this.YrE.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.kEt = ((Button)this.oFW.findViewById(a.f.ok_btn));
    this.kEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159522);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        a.a(a.this, true, a.a(a.this).getYear(), a.a(a.this).getMonth(), a.a(a.this).getDayOfMonth());
        a.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159522);
      }
    });
    this.kGN = ((Button)this.oFW.findViewById(a.f.cancel_btn));
    this.kGN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159523);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        a.a(a.this, false, 0, 0, 0);
        a.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159523);
      }
    });
    this.YrC = ((Button)this.oFW.findViewById(a.f.btn_single));
    this.YrC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(249958);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        a.a(a.this, true, a.a(a.this).getYear(), a.a(a.this).getMonth(), a.a(a.this).getDayOfMonth());
        a.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249958);
      }
    });
    this.DpN.setContentView(this.oFW);
    this.DpN.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(250019);
        a.a(a.this, false, 0, 0, 0);
        a.this.hide();
        AppMethodBeat.o(250019);
      }
    });
    this.pMB = aw.fromDPToPix(this.mContext, 420);
    this.pMC = BottomSheetBehavior.cg((View)this.oFW.getParent());
    if (this.pMC != null)
    {
      this.pMC.D(this.pMB);
      this.pMC.bxz = false;
    }
    this.DpN.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(250064);
        a.b(a.this);
        AppMethodBeat.o(250064);
      }
    });
    AppMethodBeat.o(159526);
  }
  
  public final void bb(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159527);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159527);
      return;
    }
    if (this.YrE != null) {
      this.YrE.ba(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(159527);
  }
  
  public final void bc(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159529);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159529);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.YrE != null) {
      this.YrE.setMinDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159529);
  }
  
  public final void bd(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159530);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159530);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.YrE != null) {
      this.YrE.setMaxDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159530);
  }
  
  public final void bq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(159528);
    if (this.YrE != null) {
      this.YrE.bq(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(159528);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159532);
    if (this.DpN != null) {
      this.DpN.dismiss();
    }
    AppMethodBeat.o(159532);
  }
  
  public final String idn()
  {
    AppMethodBeat.i(159533);
    String str = null;
    if (this.YrE != null) {
      str = this.YrE.currentValue();
    }
    AppMethodBeat.o(159533);
    return str;
  }
  
  public void onGlobalLayout() {}
  
  public final void setLongTermYear(boolean paramBoolean)
  {
    AppMethodBeat.i(252111);
    if (this.YrE != null) {
      this.YrE.setLongTermYear(paramBoolean);
    }
    AppMethodBeat.o(252111);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159531);
    if (this.DpN != null)
    {
      if (this.YrE != null) {
        this.YrE.onShow();
      }
      this.DpN.show();
    }
    AppMethodBeat.o(159531);
  }
  
  public static abstract interface a<T>
  {
    public abstract void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */