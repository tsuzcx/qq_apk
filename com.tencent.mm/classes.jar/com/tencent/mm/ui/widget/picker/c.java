package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
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
import java.util.Locale;

public final class c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public com.google.android.material.bottomsheet.a Jjv;
  private LinearLayout agkk;
  public CustomTimePickerNew agkl;
  public a agkm;
  private Context mContext;
  private Button nhC;
  private Button njI;
  private View rootView;
  private int sRu;
  private BottomSheetBehavior sRv;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(159555);
    this.mContext = paramContext;
    this.Jjv = new com.google.android.material.bottomsheet.a(this.mContext);
    this.rootView = View.inflate(this.mContext, a.g.time_picker_panel, null);
    this.agkk = ((LinearLayout)this.rootView.findViewById(a.f.time_picker));
    this.agkl = new CustomTimePickerNew(this.mContext);
    this.agkk.removeAllViews();
    this.agkk.setGravity(17);
    this.agkk.addView(this.agkl.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.nhC = ((Button)this.rootView.findViewById(a.f.ok_btn));
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159552);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = c.this;
        if (c.a(c.this) == null) {}
        for (paramAnonymousView = null;; paramAnonymousView = String.format(Locale.US, "%02d:%02d", new Object[] { Integer.valueOf(paramAnonymousView.currentHour), Integer.valueOf(paramAnonymousView.currentMinute) }))
        {
          c.a((c)localObject, true, paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMTimePicker$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159552);
          return;
          paramAnonymousView = c.a(c.this);
          paramAnonymousView.pvTime.bTe();
        }
      }
    });
    this.njI = ((Button)this.rootView.findViewById(a.f.cancel_btn));
    this.njI.setOnClickListener(new c.2(this));
    this.Jjv.setContentView(this.rootView);
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
        AppMethodBeat.i(159554);
        c.b(c.this);
        AppMethodBeat.o(159554);
      }
    });
    AppMethodBeat.o(159555);
  }
  
  public final void onGlobalLayout() {}
  
  public static abstract interface a<T>
  {
    public abstract void c(boolean paramBoolean, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */