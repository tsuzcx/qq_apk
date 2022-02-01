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
  List<SwitchPhoneItemView> Att;
  private a Atu;
  private View.OnClickListener Atv;
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71485);
    this.Att = new ArrayList();
    this.Atv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71484);
        Iterator localIterator = SwitchPhoneItemGroupView.this.Att.iterator();
        while (localIterator.hasNext()) {
          ((SwitchPhoneItemView)localIterator.next()).Atz.setImageResource(2131691077);
        }
        ((SwitchPhoneItemView)paramAnonymousView).Atz.setImageResource(2131691078);
        if (SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this) != null) {
          SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this).fi(paramAnonymousView);
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
    this.Att = new ArrayList();
    this.Atv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71484);
        Iterator localIterator = SwitchPhoneItemGroupView.this.Att.iterator();
        while (localIterator.hasNext()) {
          ((SwitchPhoneItemView)localIterator.next()).Atz.setImageResource(2131691077);
        }
        ((SwitchPhoneItemView)paramAnonymousView).Atz.setImageResource(2131691078);
        if (SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this) != null) {
          SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this).fi(paramAnonymousView);
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
    this.Att.add(paramSwitchPhoneItemView);
    paramSwitchPhoneItemView.setOnClickListener(this.Atv);
    AppMethodBeat.o(71487);
  }
  
  public void setOnItemSelectListener(a parama)
  {
    this.Atu = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fi(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView
 * JD-Core Version:    0.7.0.1
 */