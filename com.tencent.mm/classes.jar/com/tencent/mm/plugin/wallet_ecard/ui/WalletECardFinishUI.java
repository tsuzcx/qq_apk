package com.tencent.mm.plugin.wallet_ecard.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@com.tencent.mm.ui.base.a(19)
public class WalletECardFinishUI
  extends WalletECardBaseUI
{
  private TextView kPB;
  private Button nJm;
  
  public int getLayoutId()
  {
    return 2130969344;
  }
  
  public void initView()
  {
    AppMethodBeat.i(48147);
    this.kPB = ((TextView)findViewById(2131821007));
    Object localObject = getInput().getByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.uzc);
    if (localObject != null) {}
    try
    {
      if (localObject.length != 0)
      {
        localObject = (bje)new bje().parseFrom((byte[])localObject);
        if ((localObject != null) && (!bo.isNullOrNil(((bje)localObject).desc))) {
          this.kPB.setText(((bje)localObject).desc);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletECardFinishUI", localException, "", new Object[0]);
      }
    }
    this.nJm = ((Button)findViewById(2131823481));
    this.nJm.setOnClickListener(new WalletECardFinishUI.2(this));
    AppMethodBeat.o(48147);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48146);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    setMMTitle("");
    enableBackMenu(false);
    setBackBtn(new WalletECardFinishUI.1(this));
    showHomeBtn(false);
    initView();
    AppMethodBeat.o(48146);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
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