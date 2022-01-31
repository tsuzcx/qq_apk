package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.ap;

public final class c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private BottomSheetBehavior fK;
  private Button fbO;
  private Button hPe;
  private View jdj;
  private Context mContext;
  public android.support.design.widget.c vAB;
  private int vAC;
  public CustomTimePicker wox;
  public c.a woy;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
    this.vAB = new android.support.design.widget.c(this.mContext);
    this.jdj = View.inflate(this.mContext, a.g.time_picker_panel, null);
    this.wox = ((CustomTimePicker)this.jdj.findViewById(a.f.time_picker));
    this.fbO = ((Button)this.jdj.findViewById(a.f.ok_btn));
    this.fbO.setOnClickListener(new c.1(this));
    this.hPe = ((Button)this.jdj.findViewById(a.f.cancel_btn));
    this.hPe.setOnClickListener(new c.2(this));
    this.vAB.setContentView(this.jdj);
    this.vAC = ap.fromDPToPix(this.mContext, 288);
    this.fK = BottomSheetBehavior.i((View)this.jdj.getParent());
    if (this.fK != null)
    {
      this.fK.u(this.vAC);
      this.fK.fq = false;
    }
    this.vAB.setOnDismissListener(new c.3(this));
  }
  
  public final void onGlobalLayout() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */