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
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.bd;
import java.util.Calendar;
import java.util.Locale;

public class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private Button ErU;
  private com.google.android.material.bottomsheet.a Jjv;
  private LinearLayout afbs;
  private LinearLayout agjS;
  private CustomDatePickerNew agjT;
  public a agjU;
  private Context mContext;
  private Button nhC;
  private Button njI;
  private View rootView;
  private int sRu;
  private BottomSheetBehavior sRv;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(159526);
    this.mContext = paramContext;
    this.Jjv = new com.google.android.material.bottomsheet.a(this.mContext);
    this.rootView = View.inflate(this.mContext, a.g.date_picker_panel, null);
    this.agjS = ((LinearLayout)this.rootView.findViewById(a.f.date_picker));
    this.afbs = ((LinearLayout)this.rootView.findViewById(a.f.date_picker_header));
    this.agjT = new CustomDatePickerNew(this.mContext);
    this.agjS.removeAllViews();
    this.agjS.setGravity(17);
    this.agjS.addView(this.agjT.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.nhC = ((Button)this.rootView.findViewById(a.f.ok_btn));
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159522);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.a(a.this, true, a.a(a.this).getYear(), a.a(a.this).getMonth(), a.a(a.this).getDayOfMonth());
        a.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159522);
      }
    });
    this.njI = ((Button)this.rootView.findViewById(a.f.cancel_btn));
    this.njI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159523);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.a(a.this, false, 0, 0, 0);
        a.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159523);
      }
    });
    this.ErU = ((Button)this.rootView.findViewById(a.f.btn_single));
    this.ErU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(252618);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        a.a(a.this, true, a.a(a.this).getYear(), a.a(a.this).getMonth(), a.a(a.this).getDayOfMonth());
        a.this.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(252618);
      }
    });
    this.Jjv.setContentView(this.rootView);
    this.Jjv.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(252617);
        a.a(a.this, false, 0, 0, 0);
        a.this.hide();
        AppMethodBeat.o(252617);
      }
    });
    this.sRu = bd.fromDPToPix(this.mContext, 420);
    this.sRv = BottomSheetBehavior.cC((View)this.rootView.getParent());
    if (this.sRv != null)
    {
      this.sRv.setPeekHeight(this.sRu);
      this.sRv.dqC = false;
    }
    this.Jjv.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(252626);
        a.b(a.this);
        AppMethodBeat.o(252626);
      }
    });
    AppMethodBeat.o(159526);
  }
  
  public final void bC(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159527);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159527);
      return;
    }
    if (this.agjT != null) {
      this.agjT.bB(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(159527);
  }
  
  public final void bD(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159529);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159529);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.agjT != null) {
      this.agjT.setMinDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159529);
  }
  
  public final void bE(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159530);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159530);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.agjT != null) {
      this.agjT.setMaxDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159530);
  }
  
  public final void bP(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(159528);
    if (this.agjT != null) {
      this.agjT.bP(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(159528);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159532);
    if (this.Jjv != null) {
      this.Jjv.dismiss();
    }
    AppMethodBeat.o(159532);
  }
  
  public final String jIy()
  {
    AppMethodBeat.i(159533);
    String str = null;
    if (this.agjT != null) {
      str = this.agjT.currentValue();
    }
    AppMethodBeat.o(159533);
    return str;
  }
  
  public void onGlobalLayout() {}
  
  public final void setLongTermYear(boolean paramBoolean)
  {
    AppMethodBeat.i(252688);
    if (this.agjT != null) {
      this.agjT.setLongTermYear(paramBoolean);
    }
    AppMethodBeat.o(252688);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159531);
    if (this.Jjv != null)
    {
      if (this.agjT != null) {
        this.agjT.onShow();
      }
      this.Jjv.show();
    }
    AppMethodBeat.o(159531);
  }
  
  public static abstract interface a<T>
  {
    public abstract void onResult(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.a
 * JD-Core Version:    0.7.0.1
 */