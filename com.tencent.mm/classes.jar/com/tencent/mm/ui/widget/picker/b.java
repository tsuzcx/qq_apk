package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.List;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private String[] AIS;
  private ArrayList<List<String>> AIT;
  private OptionPicker AIU;
  private OptionPicker AIV;
  public a AIW;
  private BottomSheetBehavior gE;
  private Button gtF;
  private View iDS;
  private Button jIG;
  private Context mContext;
  private int vWH;
  private c zRa;
  private int zRb;
  
  public b(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(112825);
    this.AIT = null;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.AIS = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
    AppMethodBeat.o(112825);
  }
  
  public b(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(112824);
    this.AIT = null;
    this.mContext = paramContext;
    this.AIS = paramArrayOfString;
    initView();
    AppMethodBeat.o(112824);
  }
  
  private String[] Rx(int paramInt)
  {
    AppMethodBeat.i(112832);
    if (this.AIT != null)
    {
      Object localObject = (ArrayList)this.AIT.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(112832);
        return localObject;
      }
    }
    AppMethodBeat.o(112832);
    return null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(112826);
    this.zRa = new c(this.mContext);
    this.iDS = View.inflate(this.mContext, 2130970395, null);
    this.AIU = ((OptionPicker)this.iDS.findViewById(2131826643));
    this.AIU.setOptionsArray(this.AIS);
    this.AIV = ((OptionPicker)this.iDS.findViewById(2131826644));
    if (this.AIT != null)
    {
      this.AIV.setVisibility(0);
      this.AIV.setOptionsArray(Rx(this.AIU.getValue()));
      this.AIU.setOnValueChangedListener(new b.1(this));
    }
    for (;;)
    {
      this.vWH = al.fromDPToPix(this.mContext, 288);
      this.gtF = ((Button)this.iDS.findViewById(2131823301));
      this.gtF.setOnClickListener(new b.2(this));
      this.jIG = ((Button)this.iDS.findViewById(2131822887));
      this.jIG.setOnClickListener(new b.3(this));
      this.zRa.setContentView(this.iDS);
      this.zRb = al.fromDPToPix(this.mContext, 350);
      this.gE = BottomSheetBehavior.i((View)this.iDS.getParent());
      if (this.gE != null)
      {
        this.gE.t(this.zRb);
        this.gE.go = false;
      }
      this.zRa.setOnDismissListener(new b.4(this));
      AppMethodBeat.o(112826);
      return;
      this.AIV.setVisibility(8);
    }
  }
  
  public final void Rv(int paramInt)
  {
    AppMethodBeat.i(112827);
    if (paramInt != 0) {
      this.vWH = paramInt;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.iDS.getLayoutParams();
    localLayoutParams.height = this.vWH;
    this.iDS.setLayoutParams(localLayoutParams);
    this.iDS.invalidate();
    AppMethodBeat.o(112827);
  }
  
  public final void Rw(int paramInt)
  {
    AppMethodBeat.i(112831);
    if (this.AIU != null) {
      this.AIU.setValue(paramInt);
    }
    AppMethodBeat.o(112831);
  }
  
  public final int dPp()
  {
    AppMethodBeat.i(112830);
    int i = 0;
    if (this.AIU != null) {
      i = this.AIU.getValue();
    }
    AppMethodBeat.o(112830);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(112829);
    if (this.zRa != null) {
      this.zRa.dismiss();
    }
    AppMethodBeat.o(112829);
  }
  
  public final void onGlobalLayout() {}
  
  public final void show()
  {
    AppMethodBeat.i(112828);
    if (this.zRa != null) {
      this.zRa.show();
    }
    AppMethodBeat.o(112828);
  }
  
  public static abstract interface a<T>
  {
    public abstract void onResult(boolean paramBoolean, T paramT1, T paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */