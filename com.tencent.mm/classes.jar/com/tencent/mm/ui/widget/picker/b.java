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
  private LinearLayout GSX;
  private Button HIN;
  private LinearLayout HIO;
  private CustomDatePickerNew HIP;
  public a HIQ;
  private Button hJg;
  private Button hJh;
  private View jGG;
  private int kBk;
  private BottomSheetBehavior kBl;
  private Context mContext;
  private a sri;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(159526);
    this.mContext = paramContext;
    this.sri = new a(this.mContext);
    this.jGG = View.inflate(this.mContext, 2131493683, null);
    this.HIO = ((LinearLayout)this.jGG.findViewById(2131298931));
    this.GSX = ((LinearLayout)this.jGG.findViewById(2131307182));
    this.HIP = new CustomDatePickerNew(this.mContext);
    this.HIO.removeAllViews();
    this.HIO.setGravity(17);
    this.HIO.addView(this.HIP.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.hJh = ((Button)this.jGG.findViewById(2131302999));
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159522);
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        AppMethodBeat.o(159522);
      }
    });
    this.hJg = ((Button)this.jGG.findViewById(2131297690));
    this.hJg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159523);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(159523);
      }
    });
    this.HIN = ((Button)this.jGG.findViewById(2131297600));
    this.HIN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(195288);
        b.a(b.this, true, b.a(b.this).getYear(), b.a(b.this).getMonth(), b.a(b.this).getDayOfMonth());
        b.this.hide();
        AppMethodBeat.o(195288);
      }
    });
    this.sri.setContentView(this.jGG);
    this.sri.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(195289);
        b.a(b.this, false, 0, 0, 0);
        b.this.hide();
        AppMethodBeat.o(195289);
      }
    });
    this.kBk = ao.fromDPToPix(this.mContext, 420);
    this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
    if (this.kBl != null)
    {
      this.kBl.J(this.kBk);
      this.kBl.lh = false;
    }
    this.sri.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(195290);
        b.b(b.this);
        AppMethodBeat.o(195290);
      }
    });
    AppMethodBeat.o(159526);
  }
  
  public final void aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(159528);
    if (this.HIP != null) {
      this.HIP.aL(paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(159528);
  }
  
  public final void aM(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159527);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159527);
      return;
    }
    if (this.HIP != null) {
      this.HIP.aL(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(159527);
  }
  
  public final void aN(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159529);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159529);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.HIP != null) {
      this.HIP.setMinDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159529);
  }
  
  public final void aO(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159530);
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0))
    {
      AppMethodBeat.o(159530);
      return;
    }
    Calendar localCalendar = Calendar.getInstance(Locale.US);
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    if (this.HIP != null) {
      this.HIP.setMaxDate(Long.valueOf(localCalendar.getTimeInMillis()));
    }
    AppMethodBeat.o(159530);
  }
  
  public final String ffY()
  {
    AppMethodBeat.i(159533);
    String str = null;
    if (this.HIP != null) {
      str = this.HIP.currentValue();
    }
    AppMethodBeat.o(159533);
    return str;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159532);
    if (this.sri != null) {
      this.sri.dismiss();
    }
    AppMethodBeat.o(159532);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setLongTermYear(boolean paramBoolean)
  {
    AppMethodBeat.i(195291);
    if (this.HIP != null) {
      this.HIP.setLongTermYear(paramBoolean);
    }
    AppMethodBeat.o(195291);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159531);
    if (this.sri != null)
    {
      if (this.HIP != null) {
        this.HIP.onShow();
      }
      this.sri.show();
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