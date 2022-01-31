package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView
  extends LinearLayout
{
  List<SwitchPhoneItemView> qHN = new ArrayList();
  private SwitchPhoneItemGroupView.a qHO;
  private View.OnClickListener qHP = new SwitchPhoneItemGroupView.1(this);
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(SwitchPhoneItemView paramSwitchPhoneItemView, int paramInt)
  {
    addView(paramSwitchPhoneItemView, paramInt);
    this.qHN.add(paramSwitchPhoneItemView);
    paramSwitchPhoneItemView.setOnClickListener(this.qHP);
  }
  
  public void setOnItemSelectListener(SwitchPhoneItemGroupView.a parama)
  {
    this.qHO = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView
 * JD-Core Version:    0.7.0.1
 */