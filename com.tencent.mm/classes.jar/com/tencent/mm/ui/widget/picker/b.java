package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.ap;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private BottomSheetBehavior fK;
  private Button fbO;
  private Button hPe;
  private View jdj;
  private Context mContext;
  private c vAB;
  private int vAC;
  private String[] woq;
  private ArrayList<List<String>> wor = null;
  private int wos;
  private OptionPicker wot;
  private OptionPicker wou;
  public a wov;
  
  public b(Context paramContext, ArrayList<String> paramArrayList)
  {
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.woq = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
  }
  
  public b(Context paramContext, String[] paramArrayOfString)
  {
    this.mContext = paramContext;
    this.woq = paramArrayOfString;
    initView();
  }
  
  private String[] ID(int paramInt)
  {
    if (this.wor != null)
    {
      ArrayList localArrayList = (ArrayList)this.wor.get(paramInt);
      if (localArrayList != null) {
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
    }
    return null;
  }
  
  private void initView()
  {
    this.vAB = new c(this.mContext);
    this.jdj = View.inflate(this.mContext, a.g.option_picker_panel, null);
    this.wot = ((OptionPicker)this.jdj.findViewById(a.f.option_picker));
    this.wot.setOptionsArray(this.woq);
    this.wou = ((OptionPicker)this.jdj.findViewById(a.f.option_second_picker));
    if (this.wor != null)
    {
      this.wou.setVisibility(0);
      this.wou.setOptionsArray(ID(this.wot.getValue()));
      this.wot.setOnValueChangedListener(new b.1(this));
    }
    for (;;)
    {
      this.wos = ap.fromDPToPix(this.mContext, 288);
      this.fbO = ((Button)this.jdj.findViewById(a.f.ok_btn));
      this.fbO.setOnClickListener(new b.2(this));
      this.hPe = ((Button)this.jdj.findViewById(a.f.cancel_btn));
      this.hPe.setOnClickListener(new b.3(this));
      this.vAB.setContentView(this.jdj);
      this.vAC = ap.fromDPToPix(this.mContext, 350);
      this.fK = BottomSheetBehavior.i((View)this.jdj.getParent());
      if (this.fK != null)
      {
        this.fK.u(this.vAC);
        this.fK.fq = false;
      }
      this.vAB.setOnDismissListener(new b.4(this));
      return;
      this.wou.setVisibility(8);
    }
  }
  
  public final void IB(int paramInt)
  {
    if (paramInt != 0) {
      this.wos = paramInt;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdj.getLayoutParams();
    localLayoutParams.height = this.wos;
    this.jdj.setLayoutParams(localLayoutParams);
    this.jdj.invalidate();
  }
  
  public final void IC(int paramInt)
  {
    if (this.wot != null) {
      this.wot.setValue(paramInt);
    }
  }
  
  public final int cKk()
  {
    int i = 0;
    if (this.wot != null) {
      i = this.wot.getValue();
    }
    return i;
  }
  
  public final void hide()
  {
    if (this.vAB != null) {
      this.vAB.dismiss();
    }
  }
  
  public final void onGlobalLayout() {}
  
  public final void show()
  {
    if (this.vAB != null) {
      this.vAB.show();
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void f(boolean paramBoolean, T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */