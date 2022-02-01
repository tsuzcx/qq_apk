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
  private LinearLayout Jjx;
  private CustomTimePickerNew Jjy;
  public d.a Jjz;
  private Button gAJ;
  private Button gCY;
  private View khe;
  private int lcC;
  private BottomSheetBehavior lcD;
  private Context mContext;
  private a tyZ;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(159555);
    this.mContext = paramContext;
    this.tyZ = new a(this.mContext);
    this.khe = View.inflate(this.mContext, 2131495753, null);
    this.Jjx = ((LinearLayout)this.khe.findViewById(2131305816));
    this.Jjy = new CustomTimePickerNew(this.mContext);
    this.Jjx.removeAllViews();
    this.Jjx.setGravity(17);
    this.Jjx.addView(this.Jjy.getView(), new LinearLayout.LayoutParams(-1, -1));
    this.gAJ = ((Button)this.khe.findViewById(2131302999));
    this.gAJ.setOnClickListener(new View.OnClickListener()
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
          paramAnonymousView.Jjd.aMR();
        }
      }
    });
    this.gCY = ((Button)this.khe.findViewById(2131297690));
    this.gCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159553);
        d.a(d.this, false, null);
        AppMethodBeat.o(159553);
      }
    });
    this.tyZ.setContentView(this.khe);
    this.lcC = ao.fromDPToPix(this.mContext, 420);
    this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
    if (this.lcD != null)
    {
      this.lcD.J(this.lcC);
      this.lcD.mg = false;
    }
    this.tyZ.setOnDismissListener(new DialogInterface.OnDismissListener()
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
    if (this.tyZ != null) {
      this.tyZ.dismiss();
    }
    AppMethodBeat.o(159560);
  }
  
  public final void jY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159558);
    if (this.Jjy != null) {
      this.Jjy.init(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159558);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setMaxTime(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159557);
    if (this.Jjy != null) {
      this.Jjy.setMaxTime(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159557);
  }
  
  public final void setMinTime(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159556);
    if (this.Jjy != null) {
      this.Jjy.setMinTime(paramInt1, paramInt2);
    }
    AppMethodBeat.o(159556);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159559);
    if (this.tyZ != null)
    {
      if (this.Jjy != null) {
        this.Jjy.onShow();
      }
      this.tyZ.show();
    }
    AppMethodBeat.o(159559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */