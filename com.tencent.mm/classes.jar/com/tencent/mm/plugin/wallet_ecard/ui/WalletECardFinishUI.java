package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.bcd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

@com.tencent.mm.ui.base.a(19)
public class WalletECardFinishUI
  extends WalletECardBaseUI
{
  private TextView iIV;
  private Button llQ;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.ecard_finish_ui;
  }
  
  protected final void initView()
  {
    this.iIV = ((TextView)findViewById(a.f.desc_tv));
    Object localObject = this.BX.getByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.qKk);
    try
    {
      localObject = (bcd)new bcd().aH((byte[])localObject);
      if ((localObject != null) && (!bk.bl(((bcd)localObject).desc))) {
        this.iIV.setText(((bcd)localObject).desc);
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.WalletECardFinishUI", localIOException, "", new Object[0]);
      }
    }
    this.llQ = ((Button)findViewById(a.f.finish_btn));
    this.llQ.setOnClickListener(new WalletECardFinishUI.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ta(getResources().getColor(a.c.white));
    czo();
    setMMTitle("");
    enableBackMenu(false);
    setBackBtn(new WalletECardFinishUI.1(this));
    showHomeBtn(false);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI
 * JD-Core Version:    0.7.0.1
 */