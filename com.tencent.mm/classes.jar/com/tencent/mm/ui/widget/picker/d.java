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
import com.tencent.mm.ui.at;
import java.util.Locale;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout QTk;
  public CustomTimePickerNew QTl;
  public a QTm;
  private Button hPX;
  private Button hSq;
  private View lJI;
  private Context mContext;
  private int mLJ;
  private BottomSheetBehavior mLK;
  public android.support.design.widget.a yfL;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(159555);
    this.mContext = paramContext;
    this.yfL = new android.support.design.widget.a(this.mContext);
    this.lJI = View.inflate(this.mContext, 2131496709, null);
    this.QTk = ((LinearLayout)this.lJI.findViewById(2131309094));
    this.QTl = new CustomTimePickerNew(this.mContext);
    this.QTk.removeAllViews();
    this.QTk.setGravity(17);
    this.QTk.addView(this.QTl.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.hPX = ((Button)this.lJI.findViewById(2131305592));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159552);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = d.this;
        if (d.a(d.this) == null) {}
        for (paramAnonymousView = null;; paramAnonymousView = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(paramAnonymousView.currentHour), Integer.valueOf(paramAnonymousView.currentMinute) }))
        {
          d.a((d)localObject, true, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159552);
          return;
          paramAnonymousView = d.a(d.this);
          paramAnonymousView.QSK.blg();
        }
      }
    });
    this.hSq = ((Button)this.lJI.findViewById(2131297963));
    this.hSq.setOnClickListener(new d.2(this));
    this.yfL.setContentView(this.lJI);
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
        AppMethodBeat.i(159554);
        d.b(d.this);
        AppMethodBeat.o(159554);
      }
    });
    AppMethodBeat.o(159555);
  }
  
  public final void onGlobalLayout() {}
  
  public static abstract interface a<T>
  {
    public abstract void a(boolean paramBoolean, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */