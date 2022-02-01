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
import com.tencent.mm.g.a.nl;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.d;

@com.tencent.mm.ui.base.a(19)
public class WalletECardFinishUI
  extends WalletECardBaseUI
{
  private TextView kFd;
  private Button lkJ;
  
  public int getLayoutId()
  {
    return 2131493733;
  }
  
  public void initView()
  {
    AppMethodBeat.i(71781);
    this.kFd = ((TextView)findViewById(2131299008));
    Object localObject = getInput().getByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.Awf);
    if (localObject != null) {}
    try
    {
      if (localObject.length != 0)
      {
        localObject = (bwq)new bwq().parseFrom((byte[])localObject);
        if ((localObject != null) && (!bt.isNullOrNil(((bwq)localObject).desc))) {
          this.kFd.setText(((bwq)localObject).desc);
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
    this.lkJ = ((Button)findViewById(2131300100));
    this.lkJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(71779);
        ad.i("MicroMsg.WalletECardFinishUI", "click finish");
        paramAnonymousView = new nl();
        com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
        paramAnonymousView = WalletECardFinishUI.this.getProcess();
        if (paramAnonymousView != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putInt("key_process_result_code", -1);
          paramAnonymousView.b(WalletECardFinishUI.this.getContext(), localBundle);
          AppMethodBeat.o(71779);
          return;
        }
        ad.w("MicroMsg.WalletECardFinishUI", "process is null");
        WalletECardFinishUI.this.finish();
        AppMethodBeat.o(71779);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI
 * JD-Core Version:    0.7.0.1
 */