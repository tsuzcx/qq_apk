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
  List<SwitchPhoneItemView> ImV;
  private a ImW;
  private View.OnClickListener ImX;
  
  public SwitchPhoneItemGroupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71485);
    this.ImV = new ArrayList();
    this.ImX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71484);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/SwitchPhoneItemGroupView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = SwitchPhoneItemGroupView.this.ImV.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((SwitchPhoneItemView)((Iterator)localObject).next()).Inb.setImageResource(2131691379);
        }
        ((SwitchPhoneItemView)paramAnonymousView).Inb.setImageResource(2131691380);
        if (SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this) != null) {
          SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this).gb(paramAnonymousView);
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
    this.ImV = new ArrayList();
    this.ImX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71484);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/view/SwitchPhoneItemGroupView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        localObject = SwitchPhoneItemGroupView.this.ImV.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((SwitchPhoneItemView)((Iterator)localObject).next()).Inb.setImageResource(2131691379);
        }
        ((SwitchPhoneItemView)paramAnonymousView).Inb.setImageResource(2131691380);
        if (SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this) != null) {
          SwitchPhoneItemGroupView.a(SwitchPhoneItemGroupView.this).gb(paramAnonymousView);
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
    this.ImV.add(paramSwitchPhoneItemView);
    paramSwitchPhoneItemView.setOnClickListener(this.ImX);
    AppMethodBeat.o(71487);
  }
  
  public void setOnItemSelectListener(a parama)
  {
    this.ImW = parama;
  }
  
  public static abstract interface a
  {
    public abstract void gb(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView
 * JD-Core Version:    0.7.0.1
 */