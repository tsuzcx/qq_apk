package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI
  extends MMActivity
{
  protected static final Map<String, Bitmap> qwS;
  protected Bitmap mBmp = null;
  private String qwR = null;
  private ImageView qwT;
  private EditText qwU;
  
  static
  {
    AppMethodBeat.i(81017);
    qwS = new HashMap();
    AppMethodBeat.o(81017);
  }
  
  public static void c(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(81012);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(81012);
      return;
    }
    Intent localIntent = new Intent();
    if (((b)g.E(b.class)).TenPaySDKABTestKindaEnable()) {}
    for (Activity localActivity = ((b)g.E(b.class)).getCrossActivity();; localActivity = null)
    {
      Object localObject = localActivity;
      if (localActivity == null)
      {
        localObject = ah.getContext();
        localIntent.addFlags(268435456);
      }
      localIntent.setClass((Context)localObject, ConfirmScanBankCardResultUI.class);
      localIntent.putExtra("_card_num_", paramString);
      paramString = "_image_cache_key_".concat(String.valueOf(paramString));
      qwS.put(paramString, paramBitmap);
      localIntent.putExtra("_image_cache_key_", paramString);
      ((Context)localObject).startActivity(localIntent);
      AppMethodBeat.o(81012);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(81015);
    Intent localIntent = new Intent();
    localIntent.putExtra("BaseScanUI_select_scan_mode", 7);
    localIntent.putExtra("scan_bankcard_with_confirm_ui", true);
    localIntent.addFlags(268435456);
    localIntent.setClass(this, BaseScanUI.class);
    startActivity(localIntent);
    super.finish();
    AppMethodBeat.o(81015);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130969210;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(81013);
    super.onCreate(paramBundle);
    setMMTitle(2131302952);
    int i;
    if (getIntent() == null)
    {
      ab.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
      i = 0;
    }
    while (i == 0)
    {
      finish();
      AppMethodBeat.o(81013);
      return;
      this.qwR = getIntent().getStringExtra("_image_cache_key_");
      if (bo.isNullOrNil(this.qwR))
      {
        ab.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
        i = 0;
      }
      else
      {
        this.mBmp = ((Bitmap)qwS.get(this.qwR));
        if ((this.mBmp == null) || (this.mBmp.isRecycled()))
        {
          ab.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
    paramBundle = getIntent().getStringExtra("_card_num_");
    if (bo.isNullOrNil(paramBundle))
    {
      ab.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
      finish();
      AppMethodBeat.o(81013);
      return;
    }
    this.qwT = ((ImageView)findViewById(2131823018));
    this.qwU = ((EditText)findViewById(2131823019));
    this.qwT.setImageBitmap(this.mBmp);
    this.qwU.setText(paramBundle);
    findViewById(2131823020).setOnClickListener(new ConfirmScanBankCardResultUI.1(this));
    setBackBtn(new ConfirmScanBankCardResultUI.2(this));
    AppMethodBeat.o(81013);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(81014);
    super.onDestroy();
    if (this.qwT != null) {
      this.qwT.setImageBitmap(null);
    }
    if (!bo.isNullOrNil(this.qwR)) {
      qwS.remove(this.qwR);
    }
    if (this.mBmp != null)
    {
      ab.i("MicroMsg.ConfirmScanBankCardResultUI", "bitmap recycle %s", new Object[] { this.mBmp.toString() });
      this.mBmp.recycle();
    }
    AppMethodBeat.o(81014);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI
 * JD-Core Version:    0.7.0.1
 */