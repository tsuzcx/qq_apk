package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView
  extends LinearLayout
{
  private View.OnClickListener uwA;
  List<SwitchPhoneItemView> uwy;
  private SwitchPhoneItemGroupView.a uwz;
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47881);
    this.uwy = new ArrayList();
    this.uwA = new SwitchPhoneItemGroupView.1(this);
    AppMethodBeat.o(47881);
  }
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(47882);
    this.uwy = new ArrayList();
    this.uwA = new SwitchPhoneItemGroupView.1(this);
    AppMethodBeat.o(47882);
  }
  
  public final void a(SwitchPhoneItemView paramSwitchPhoneItemView, int paramInt)
  {
    AppMethodBeat.i(47883);
    addView(paramSwitchPhoneItemView, paramInt);
    this.uwy.add(paramSwitchPhoneItemView);
    paramSwitchPhoneItemView.setOnClickListener(this.uwA);
    AppMethodBeat.o(47883);
  }
  
  public void setOnItemSelectListener(SwitchPhoneItemGroupView.a parama)
  {
    this.uwz = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView
 * JD-Core Version:    0.7.0.1
 */