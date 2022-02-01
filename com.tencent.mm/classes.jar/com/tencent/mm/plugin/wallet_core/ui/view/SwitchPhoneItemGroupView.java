package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwitchPhoneItemGroupView
  extends LinearLayout
{
  List<SwitchPhoneItemView> DDJ;
  private a DDK;
  private View.OnClickListener DDL;
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71485);
    this.DDJ = new ArrayList();
    this.DDL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71484);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/SwitchPhoneItemGroupView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = SwitchPhoneItemGroupView.this.DDJ.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((SwitchPhoneItemView)((Iterator)localObject).next()).DDP.setImageResource(2131691077);
        }
        ((SwitchPhoneItemView)paramAnonymousView).DDP.setImageResource(2131691078);
        if (SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this) != null) {
          SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this).fJ(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/SwitchPhoneItemGroupView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71484);
      }
    };
    AppMethodBeat.o(71485);
  }
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71486);
    this.DDJ = new ArrayList();
    this.DDL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71484);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/SwitchPhoneItemGroupView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        localObject = SwitchPhoneItemGroupView.this.DDJ.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((SwitchPhoneItemView)((Iterator)localObject).next()).DDP.setImageResource(2131691077);
        }
        ((SwitchPhoneItemView)paramAnonymousView).DDP.setImageResource(2131691078);
        if (SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this) != null) {
          SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this).fJ(paramAnonymousView);
        }
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/SwitchPhoneItemGroupView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71484);
      }
    };
    AppMethodBeat.o(71486);
  }
  
  public final void a(SwitchPhoneItemView paramSwitchPhoneItemView, int paramInt)
  {
    AppMethodBeat.i(71487);
    addView(paramSwitchPhoneItemView, paramInt);
    this.DDJ.add(paramSwitchPhoneItemView);
    paramSwitchPhoneItemView.setOnClickListener(this.DDL);
    AppMethodBeat.o(71487);
  }
  
  public void setOnItemSelectListener(a parama)
  {
    this.DDK = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fJ(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView
 * JD-Core Version:    0.7.0.1
 */