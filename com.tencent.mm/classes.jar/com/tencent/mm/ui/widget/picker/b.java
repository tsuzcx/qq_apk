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
  private LinearLayout KGj;
  private Button Lxf;
  private LinearLayout Lxg;
  private CustomDatePickerNew Lxh;
  public b.a Lxi;
  private Button gXc;
  private Button gZv;
  private View kFh;
  private int lEa;
  private BottomSheetBehavior lEb;
  private Context mContext;
  private android.support.design.widget.a uNn;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(159526);
    this.mContext = paramContext;
    this.uNn = new android.support.design.widget.a(this.mContext);
    this.kFh = View.inflate(this.mContext, 2131493683, null);
    this.Lxg = ((LinearLayout)this.kFh.findViewById(2131298931));
    this.KGj = ((LinearLayout)this.kFh.findViewById(2131307182));
    this.Lxh = new CustomDatePickerNew(this.mContext);
    this.Lxg.removeAllViews();
    this.Lxg.setGravity(17);
    this.Lxg.addView(this.Lxh.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.gXc = ((Button)this.kFh.findViewById(2131302999));
    this.gXc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159522);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159522);
      }
    });
    this.gZv = ((Button)this.kFh.findViewById(2131297690));
    this.gZv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159523);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159523);
      }
    });
    this.Lxf = ((Button)this.kFh.findViewById(2131297600));
    this.Lxf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200474);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200474);
      }
    });
    this.uNn.setContentView(this.kFh);
    this.uNn.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(200475);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(200475);
      }
    });
    this.lEa = aq.fromDPToPix(this.mContext, 420);
    this.lEb = BottomSheetBehavior.l((View)this.kFh.getParent());
    if (this.lEb != null)
    {
      this.lEb.J(this.lEa);
      this.lEb.nZ = false;
    }
    this.uNn.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(200476);
        b.b(b.this);
        AppMethodBeat.o(200476);
      }
    });
    AppMethodBeat.o(159526);
  }
  
  public final void aQ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159527);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159527);
      return;
    }
    if (this.Lxh != null) {
      this.Lxh.aP(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(159527);
  }
  
  public final void aR(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159529);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159529);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.Lxh != null) {
      this.Lxh.setMinDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159529);
  }
  
  public final void aS(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159530);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159530);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.Lxh != null) {
      this.Lxh.setMaxDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159530);
  }
  
  public final void aW(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(159528);
    if (this.Lxh != null) {
      this.Lxh.aW(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(159528);
  }
  
  public final String fRf()
  {
    AppMethodBeat.i(159533);
    String str = null;
    if (this.Lxh != null) {
      str = this.Lxh.currentValue();
    }
    AppMethodBeat.o(159533);
    return str;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159532);
    if (this.uNn != null) {
      this.uNn.dismiss();
    }
    AppMethodBeat.o(159532);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setLongTermYear(boolean paramBoolean)
  {
    AppMethodBeat.i(200477);
    if (this.Lxh != null) {
      this.Lxh.setLongTermYear(paramBoolean);
    }
    AppMethodBeat.o(200477);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159531);
    if (this.uNn != null)
    {
      if (this.Lxh != null) {
        this.Lxh.onShow();
      }
      this.uNn.show();
    }
    AppMethodBeat.o(159531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */