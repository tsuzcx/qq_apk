package com.tencent.mm.ui.widget.picker;

import android.content.Context;
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
  private LinearLayout Lxv;
  private CustomTimePickerNew Lxw;
  public a Lxx;
  private Button gXc;
  private Button gZv;
  private View kFh;
  private int lEa;
  private BottomSheetBehavior lEb;
  private Context mContext;
  private android.support.design.widget.a uNn;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(159555);
    this.mContext = paramContext;
    this.uNn = new android.support.design.widget.a(this.mContext);
    this.kFh = View.inflate(this.mContext, 2131495753, null);
    this.Lxv = ((LinearLayout)this.kFh.findViewById(2131305816));
    this.Lxw = new CustomTimePickerNew(this.mContext);
    this.Lxv.removeAllViews();
    this.Lxv.setGravity(17);
    this.Lxv.addView(this.Lxw.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.gXc = ((Button)this.kFh.findViewById(2131302999));
    this.gXc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159552);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = d.this;
        if (d.a(d.this) == null) {}
        for (paramAnonymousView = null;; paramAnonymousView = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(paramAnonymousView.currentHour), Integer.valueOf(paramAnonymousView.currentMinute) }))
        {
          d.a((d)localObject, true, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159552);
          return;
          paramAnonymousView = d.a(d.this);
          paramAnonymousView.LwY.aQB();
        }
      }
    });
    this.gZv = ((Button)this.kFh.findViewById(2131297690));
    this.gZv.setOnClickListener(new d.2(this));
    this.uNn.setContentView(this.kFh);
    this.lEa = aq.fromDPToPix(this.mContext, 420);
    this.lEb = BottomSheetBehavior.l((View)this.kFh.getParent());
    if (this.lEb != null)
    {
      this.lEb.J(this.lEa);
      this.lEb.nZ = false;
    }
    this.uNn.setOnDismissListener(new d.3(this));
    AppMethodBeat.o(159555);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159560);
    if (this.uNn != null) {
      this.uNn.dismiss();
    }
    AppMethodBeat.o(159560);
  }
  
  public final void ks(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159558);
    if (this.Lxw != null) {
      this.Lxw.init(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159558);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setMaxTime(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159557);
    if (this.Lxw != null) {
      this.Lxw.setMaxTime(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159557);
  }
  
  public final void setMinTime(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159556);
    if (this.Lxw != null) {
      this.Lxw.setMinTime(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159556);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159559);
    if (this.uNn != null)
    {
      if (this.Lxw != null) {
        this.Lxw.onShow();
      }
      this.uNn.show();
    }
    AppMethodBeat.o(159559);
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(boolean paramBoolean, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */