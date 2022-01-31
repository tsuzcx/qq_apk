package com.tencent.mm.plugin.product.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.g;

public abstract class MallBaseUI
  extends MMActivity
{
  protected String ghs;
  
  protected final void KQ(String paramString)
  {
    this.ghs = paramString;
    showDialog(-10001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new MallBaseUI.1(this));
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case -10001: 
      if (bk.bl(this.ghs)) {
        this.ghs = getString(a.i.mall_product_data_err);
      }
      return h.a(this, this.ghs, null, false, new MallBaseUI.2(this));
    }
    return g.a(this.mController.uMN, false, new MallBaseUI.3(this));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 1)) {
      this.mController.callBackMenu();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void vN(int paramInt)
  {
    this.mController.contentView.setVisibility(paramInt);
    if (paramInt == 0)
    {
      this.mController.showTitleView();
      return;
    }
    this.mController.hideTitleView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallBaseUI
 * JD-Core Version:    0.7.0.1
 */