package com.tencent.mm.plugin.wallet.bind;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.bind.a.d;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class a$1
  extends g
{
  private String bMX = null;
  
  a$1(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.qjo.kke.putInt("key_process_result_code", -1);
        if (this.qjo.c(this.gfb, null)) {
          this.wBd.a(new y(this.bMX, 14), true, 1);
        }
        for (;;)
        {
          return true;
          this.qjo.a(this.gfb, 0, null);
          if ((this.gfb instanceof WalletBaseUI)) {
            ((WalletBaseUI)this.gfb).st(0);
          }
          this.gfb.finish();
        }
      }
      this.qjo.kke.putInt("key_process_result_code", 1);
    }
    return false;
  }
  
  public final boolean m(Object... paramVarArgs)
  {
    Object localObject = (Bankcard)a.d(this.qjo).getParcelable("key_bankcard");
    String str1 = (String)paramVarArgs[0];
    this.bMX = ((String)paramVarArgs[1]);
    if (localObject != null)
    {
      paramVarArgs = this.wBd;
      String str2 = ((Bankcard)localObject).field_bankcardType;
      localObject = ((Bankcard)localObject).field_bindSerial;
      if (a.e(this.qjo).getInt("scene", -1) == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramVarArgs.a(new d(str2, (String)localObject, str1, bool), true, 1);
        return true;
      }
    }
    this.qjo.kke.putInt("key_process_result_code", 1);
    return false;
  }
  
  public final boolean s(Object... paramVarArgs)
  {
    Object localObject = (Bankcard)a.a(this.qjo).getParcelable("key_bankcard");
    if ((localObject != null) && (((Bankcard)localObject).field_bankcardState == 1))
    {
      paramVarArgs = this.wBd;
      String str = ((Bankcard)localObject).field_bankcardType;
      localObject = ((Bankcard)localObject).field_bindSerial;
      if (a.b(this.qjo).getInt("scene", -1) == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramVarArgs.a(new d(str, (String)localObject, bool), true, 1);
        a.c(this.qjo).putBoolean("key_is_expired_bankcard", true);
        return true;
      }
    }
    this.qjo.kke.putInt("key_process_result_code", 1);
    return super.s(paramVarArgs);
  }
  
  public final CharSequence vy(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.vy(paramInt);
    }
    return this.gfb.getString(a.i.wallet_index_ui_unbind_bankcard_title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.1
 * JD-Core Version:    0.7.0.1
 */