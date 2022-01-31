package com.tencent.mm.plugin.wallet.bind;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.bind.a.d;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class a$1
  extends g
{
  private String cnI = null;
  
  a$1(a parama, MMActivity paramMMActivity, i parami)
  {
    super(paramMMActivity, parami);
  }
  
  public final CharSequence getTips(int paramInt)
  {
    AppMethodBeat.i(45717);
    switch (paramInt)
    {
    default: 
      localObject = super.getTips(paramInt);
      AppMethodBeat.o(45717);
      return localObject;
    }
    Object localObject = this.hwZ.getString(2131305128);
    AppMethodBeat.o(45717);
    return localObject;
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45714);
    if ((paramm instanceof d))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.tSo.mEJ.putInt("key_process_result_code", -1);
        if (this.tSo.c(this.hwZ, null)) {
          this.AXB.a(new ab(this.cnI, 14), true, 1);
        }
        for (;;)
        {
          AppMethodBeat.o(45714);
          return true;
          this.tSo.a(this.hwZ, 0, null);
          if ((this.hwZ instanceof WalletBaseUI)) {
            ((WalletBaseUI)this.hwZ).cleanUiData(0);
          }
          this.hwZ.finish();
        }
      }
      this.tSo.mEJ.putInt("key_process_result_code", 1);
    }
    AppMethodBeat.o(45714);
    return false;
  }
  
  public final boolean p(Object... paramVarArgs)
  {
    AppMethodBeat.i(45716);
    Object localObject = (Bankcard)a.d(this.tSo).getParcelable("key_bankcard");
    String str1 = (String)paramVarArgs[0];
    this.cnI = ((String)paramVarArgs[1]);
    if (localObject != null)
    {
      paramVarArgs = this.AXB;
      String str2 = ((Bankcard)localObject).field_bankcardType;
      localObject = ((Bankcard)localObject).field_bindSerial;
      if (a.e(this.tSo).getInt("scene", -1) == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramVarArgs.a(new d(str2, (String)localObject, str1, bool), true, 1);
        AppMethodBeat.o(45716);
        return true;
      }
    }
    this.tSo.mEJ.putInt("key_process_result_code", 1);
    AppMethodBeat.o(45716);
    return false;
  }
  
  public final boolean x(Object... paramVarArgs)
  {
    AppMethodBeat.i(45715);
    Object localObject = (Bankcard)a.a(this.tSo).getParcelable("key_bankcard");
    if ((localObject != null) && (((Bankcard)localObject).field_bankcardState == 1))
    {
      paramVarArgs = this.AXB;
      String str = ((Bankcard)localObject).field_bankcardType;
      localObject = ((Bankcard)localObject).field_bindSerial;
      if (a.b(this.tSo).getInt("scene", -1) == 2) {}
      for (bool = true;; bool = false)
      {
        paramVarArgs.a(new d(str, (String)localObject, bool), true, 1);
        a.c(this.tSo).putBoolean("key_is_expired_bankcard", true);
        AppMethodBeat.o(45715);
        return true;
      }
    }
    this.tSo.mEJ.putInt("key_process_result_code", 1);
    boolean bool = super.x(paramVarArgs);
    AppMethodBeat.o(45715);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.a.1
 * JD-Core Version:    0.7.0.1
 */