package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.model.lqt.CgiLqtPlanIndex;
import com.tencent.mm.plugin.wallet.balance.model.lqt.s;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.model.a;
import com.tencent.mm.wallet_core.model.a.a;

public class WalletLqtPlanBeforeHomeUI
  extends AppCompatActivity
{
  private void ift()
  {
    AppMethodBeat.i(68901);
    s locals = new s();
    locals.d(new CgiLqtPlanIndex());
    locals.a(new a.a() {}, 0L);
    AppMethodBeat.o(68901);
  }
  
  public void finish()
  {
    AppMethodBeat.i(68900);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(68900);
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(316409);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(316409);
    return localResources;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(68902);
    Log.i("MicroMsg.WalletLqtPlanBeforeHomeUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 65281)
    {
      if (paramInt2 == -1)
      {
        ift();
        AppMethodBeat.o(68902);
        return;
      }
      finish();
    }
    AppMethodBeat.o(68902);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68899);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    aw.t(this, getResources().getColor(a.c.transparent));
    ift();
    AppMethodBeat.o(68899);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanBeforeHomeUI
 * JD-Core Version:    0.7.0.1
 */