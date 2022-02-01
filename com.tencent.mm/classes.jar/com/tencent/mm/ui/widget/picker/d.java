package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
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
import java.util.Locale;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout HJa;
  private CustomTimePickerNew HJb;
  public a HJc;
  private Button hJg;
  private Button hJh;
  private View jGG;
  private int kBk;
  private BottomSheetBehavior kBl;
  private Context mContext;
  private a sri;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(159555);
    this.mContext = paramContext;
    this.sri = new a(this.mContext);
    this.jGG = View.inflate(this.mContext, 2131495753, null);
    this.HJa = ((LinearLayout)this.jGG.findViewById(2131305816));
    this.HJb = new CustomTimePickerNew(this.mContext);
    this.HJa.removeAllViews();
    this.HJa.setGravity(17);
    this.HJa.addView(this.HJb.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.hJh = ((Button)this.jGG.findViewById(2131302999));
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159552);
        d locald = d.this;
        if (d.a(d.this) == null) {}
        for (paramAnonymousView = null;; paramAnonymousView = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(paramAnonymousView.currentHour), Integer.valueOf(paramAnonymousView.currentMinute) }))
        {
          d.a(locald, true, paramAnonymousView);
          AppMethodBeat.o(159552);
          return;
          paramAnonymousView = d.a(d.this);
          paramAnonymousView.HIG.aGe();
        }
      }
    });
    this.hJg = ((Button)this.jGG.findViewById(2131297690));
    this.hJg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159553);
        d.a(d.this, false, null);
        AppMethodBeat.o(159553);
      }
    });
    this.sri.setContentView(this.jGG);
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
        AppMethodBeat.i(159554);
        d.b(d.this);
        AppMethodBeat.o(159554);
      }
    });
    AppMethodBeat.o(159555);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159560);
    if (this.sri != null) {
      this.sri.dismiss();
    }
    AppMethodBeat.o(159560);
  }
  
  public final void jM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159558);
    if (this.HJb != null) {
      this.HJb.init(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159558);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setMaxTime(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159557);
    if (this.HJb != null) {
      this.HJb.setMaxTime(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159557);
  }
  
  public final void setMinTime(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159556);
    if (this.HJb != null) {
      this.HJb.setMinTime(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159556);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159559);
    if (this.sri != null)
    {
      if (this.HJb != null) {
        this.HJb.onShow();
      }
      this.sri.show();
    }
    AppMethodBeat.o(159559);
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(boolean paramBoolean, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */