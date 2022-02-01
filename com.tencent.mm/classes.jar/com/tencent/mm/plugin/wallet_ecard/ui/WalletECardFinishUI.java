package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.od;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.d;

@com.tencent.mm.ui.base.a(19)
public class WalletECardFinishUI
  extends WalletECardBaseUI
{
  private TextView lHT;
  private Button mpo;
  
  public int getLayoutId()
  {
    return 2131493733;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71781);
    this.lHT = ((TextView)findViewById(2131299008));
    Object localObject = getInput().getByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.DGx);
    if (localObject != null) {}
    try
    {
      if (localObject.length != 0)
      {
        localObject = (cgv)new cgv().parseFrom((byte[])localObject);
        if ((localObject != null) && (!bu.isNullOrNil(((cgv)localObject).desc))) {
          this.lHT.setText(((cgv)localObject).desc);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.WalletECardFinishUI", localException, "", new Object[0]);
      }
    }
    this.mpo = ((Button)findViewById(2131300100));
    this.mpo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71779);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        ae.i("MicroMsg.WalletECardFinishUI", "click finish");
        paramAnonymousView = new od();
        com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
        paramAnonymousView = WalletECardFinishUI.this.getProcess();
        if (paramAnonymousView != null)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putInt("key_process_result_code", -1);
          paramAnonymousView.b(WalletECardFinishUI.this.getContext(), (Bundle)localObject);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_ecard/ui/WalletECardFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(71779);
          return;
          ae.w("MicroMsg.WalletECardFinishUI", "process is null");
          WalletECardFinishUI.this.finish();
        }
      }
    });
    AppMethodBeat.o(71781);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(71780);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    setMMTitle("");
    enableBackMenu(false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(71778);
        ae.i("MicroMsg.WalletECardFinishUI", "press back btn");
        WalletECardFinishUI.a(WalletECardFinishUI.this).performClick();
        AppMethodBeat.o(71778);
        return false;
      }
    });
    showHomeBtn(false);
    initView();
    AppMethodBeat.o(71780);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI
 * JD-Core Version:    0.7.0.1
 */