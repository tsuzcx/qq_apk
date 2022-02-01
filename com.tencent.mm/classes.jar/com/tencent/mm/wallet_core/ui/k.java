package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class k
  implements View.OnClickListener
{
  private boolean agVl = false;
  private long agVm = 3000L;
  private long lastClickTime;
  
  public k()
  {
    this((byte)0);
  }
  
  private k(byte paramByte)
  {
    this('\000');
  }
  
  private k(char paramChar) {}
  
  public abstract void dr(View paramView);
  
  public void onClick(View paramView)
  {
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/wallet_core/ui/WalletOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    long l1;
    long l2;
    if (this.agVl) {
      if (this.agVm != 0L)
      {
        l1 = this.agVm;
        l2 = System.currentTimeMillis();
        if (l2 - this.lastClickTime < l1) {
          break label124;
        }
      }
    }
    label124:
    for (int i = 0;; i = 1)
    {
      this.lastClickTime = l2;
      if (i != 0)
      {
        a.a(this, "com/tencent/mm/wallet_core/ui/WalletOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        return;
        l1 = 3000L;
        break;
      }
      dr(paramView);
      g.mH(paramView);
      a.a(this, "com/tencent/mm/wallet_core/ui/WalletOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.k
 * JD-Core Version:    0.7.0.1
 */