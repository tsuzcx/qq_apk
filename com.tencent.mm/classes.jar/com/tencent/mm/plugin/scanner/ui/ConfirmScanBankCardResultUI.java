package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI
  extends MMActivity
{
  protected static final Map<String, Bitmap> nJq = new HashMap();
  protected Bitmap mBmp = null;
  private String nJp = null;
  private ImageView nJr;
  private EditText nJs;
  
  public static void c(Bitmap paramBitmap, String paramString)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (bk.bl(paramString))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(ae.getContext(), ConfirmScanBankCardResultUI.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("_card_num_", paramString);
    paramString = "_image_cache_key_" + paramString;
    nJq.put(paramString, paramBitmap);
    localIntent.putExtra("_image_cache_key_", paramString);
    ae.getContext().startActivity(localIntent);
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("scan_bankcard_with_confirm_ui", true);
    localIntent.addFlags(268435456);
    localIntent.setClass(this, BaseScanUI.class);
    startActivity(localIntent);
    super.finish();
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.confirm_scan_bank_card_result_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(R.l.scan_wallet_confirm_card_id_ui_title);
    int i;
    if (getIntent() == null)
    {
      y.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
      i = 0;
    }
    while (i == 0)
    {
      finish();
      return;
      this.nJp = getIntent().getStringExtra("_image_cache_key_");
      if (bk.bl(this.nJp))
      {
        y.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
        i = 0;
      }
      else
      {
        this.mBmp = ((Bitmap)nJq.get(this.nJp));
        if ((this.mBmp == null) || (this.mBmp.isRecycled()))
        {
          y.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
    paramBundle = getIntent().getStringExtra("_card_num_");
    if (bk.bl(paramBundle))
    {
      y.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
      finish();
      return;
    }
    this.nJr = ((ImageView)findViewById(R.h.imageBankCard));
    this.nJs = ((EditText)findViewById(R.h.editBankCard));
    this.nJr.setImageBitmap(this.mBmp);
    this.nJs.setText(paramBundle);
    findViewById(R.h.buttonOK).setOnClickListener(new ConfirmScanBankCardResultUI.1(this));
    setBackBtn(new ConfirmScanBankCardResultUI.2(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.nJr != null) {
      this.nJr.setImageBitmap(null);
    }
    if (!bk.bl(this.nJp)) {
      nJq.remove(this.nJp);
    }
    if (this.mBmp != null) {
      this.mBmp.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI
 * JD-Core Version:    0.7.0.1
 */