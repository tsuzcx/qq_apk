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
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.cgb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d;

@com.tencent.mm.ui.base.a(19)
public class WalletECardFinishUI
  extends WalletECardBaseUI
{
  private TextView lDu;
  private Button mkr;
  
  public int getLayoutId()
  {
    return 2131493733;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71781);
    this.lDu = ((TextView)findViewById(2131299008));
    Object localObject = getInput().getByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.DoR);
    if (localObject != null) {}
    try
    {
      if (localObject.length != 0)
      {
        localObject = (cgb)new cgb().parseFrom((byte[])localObject);
        if ((localObject != null) && (!bt.isNullOrNil(((cgb)localObject).desc))) {
          this.lDu.setText(((cgb)localObject).desc);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.WalletECardFinishUI", localException, "", new Object[0]);
      }
    }
    this.mkr = ((Button)findViewById(2131300100));
    this.mkr.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71779);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_ecard/ui/WalletECardFinishUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        ad.i("MicroMsg.WalletECardFinishUI", "click finish");
        paramAnonymousView = new oc();
        com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
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
          ad.w("MicroMsg.WalletECardFinishUI", "process is null");
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
        ad.i("MicroMsg.WalletECardFinishUI", "press back btn");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI
 * JD-Core Version:    0.7.0.1
 */