package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aq;
import java.util.Locale;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout LaU;
  private CustomTimePickerNew LaV;
  public a LaW;
  private Button gUt;
  private Button gWI;
  private View kBS;
  private int lzC;
  private BottomSheetBehavior lzD;
  private Context mContext;
  private android.support.design.widget.a uBI;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(159555);
    this.mContext = paramContext;
    this.uBI = new android.support.design.widget.a(this.mContext);
    this.kBS = View.inflate(this.mContext, 2131495753, null);
    this.LaU = ((LinearLayout)this.kBS.findViewById(2131305816));
    this.LaV = new CustomTimePickerNew(this.mContext);
    this.LaU.removeAllViews();
    this.LaU.setGravity(17);
    this.LaU.addView(this.LaV.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.gUt = ((Button)this.kBS.findViewById(2131302999));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159552);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        localObject = d.this;
        if (d.a(d.this) == null) {}
        for (paramAnonymousView = null;; paramAnonymousView = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(paramAnonymousView.currentHour), Integer.valueOf(paramAnonymousView.currentMinute) }))
        {
          d.a((d)localObject, true, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159552);
          return;
          paramAnonymousView = d.a(d.this);
          paramAnonymousView.LaA.aQc();
        }
      }
    });
    this.gWI = ((Button)this.kBS.findViewById(2131297690));
    this.gWI.setOnClickListener(new d.2(this));
    this.uBI.setContentView(this.kBS);
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
    if (this.uBI != null) {
      this.uBI.dismiss();
    }
    AppMethodBeat.o(159560);
  }
  
  public final void kl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159558);
    if (this.LaV != null) {
      this.LaV.init(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159558);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setMaxTime(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159557);
    if (this.LaV != null) {
      this.LaV.setMaxTime(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159557);
  }
  
  public final void setMinTime(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159556);
    if (this.LaV != null) {
      this.LaV.setMinTime(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159556);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159559);
    if (this.uBI != null)
    {
      if (this.LaV != null) {
        this.LaV.onShow();
      }
      this.uBI.show();
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