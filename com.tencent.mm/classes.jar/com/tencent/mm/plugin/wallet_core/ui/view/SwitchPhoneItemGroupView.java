package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwitchPhoneItemGroupView
  extends LinearLayout
{
  List<SwitchPhoneItemView> BLN;
  private a BLO;
  private View.OnClickListener BLP;
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71485);
    this.BLN = new ArrayList();
    this.BLP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71484);
        Iterator localIterator = SwitchPhoneItemGroupView.this.BLN.iterator();
        while (localIterator.hasNext()) {
          ((SwitchPhoneItemView)localIterator.next()).BLT.setImageResource(2131691077);
        }
        ((SwitchPhoneItemView)paramAnonymousView).BLT.setImageResource(2131691078);
        if (SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this) != null) {
          SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this).fv(paramAnonymousView);
        }
        AppMethodBeat.o(71484);
      }
    };
    AppMethodBeat.o(71485);
  }
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71486);
    this.BLN = new ArrayList();
    this.BLP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71484);
        Iterator localIterator = SwitchPhoneItemGroupView.this.BLN.iterator();
        while (localIterator.hasNext()) {
          ((SwitchPhoneItemView)localIterator.next()).BLT.setImageResource(2131691077);
        }
        ((SwitchPhoneItemView)paramAnonymousView).BLT.setImageResource(2131691078);
        if (SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this) != null) {
          SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this).fv(paramAnonymousView);
        }
        AppMethodBeat.o(71484);
      }
    };
    AppMethodBeat.o(71486);
  }
  
  public final void a(SwitchPhoneItemView paramSwitchPhoneItemView, int paramInt)
  {
    AppMethodBeat.i(71487);
    addView(paramSwitchPhoneItemView, paramInt);
    this.BLN.add(paramSwitchPhoneItemView);
    paramSwitchPhoneItemView.setOnClickListener(this.BLP);
    AppMethodBeat.o(71487);
  }
  
  public void setOnItemSelectListener(a parama)
  {
    this.BLO = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fv(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView
 * JD-Core Version:    0.7.0.1
 */