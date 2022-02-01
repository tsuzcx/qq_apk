package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.ug;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.aj.a.e;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class ConfirmScanBankCardResultUI
  extends MMActivity
{
  protected static final Map<String, Bitmap> IPP;
  private String IPO = null;
  private ImageView IPQ;
  private EditText IPR;
  protected Bitmap mBmp = null;
  
  static
  {
    AppMethodBeat.i(118349);
    IPP = new HashMap();
    AppMethodBeat.o(118349);
  }
  
  public static void c(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(118343);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(118343);
      return;
    }
    Intent localIntent = new Intent();
    if (((com.tencent.mm.pluginsdk.wallet.a)h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) {}
    for (Activity localActivity = ((com.tencent.mm.pluginsdk.wallet.a)h.ae(com.tencent.mm.pluginsdk.wallet.a.class)).getCrossActivity();; localActivity = null)
    {
      Object localObject = localActivity;
      if (localActivity == null)
      {
        localObject = MMApplicationContext.getContext();
        localIntent.addFlags(268435456);
      }
      localIntent.setClass((Context)localObject, ConfirmScanBankCardResultUI.class);
      localIntent.putExtra("_card_num_", paramString);
      paramString = "_image_cache_key_".concat(String.valueOf(paramString));
      IPP.put(paramString, paramBitmap);
      localIntent.putExtra("_image_cache_key_", paramString);
      paramBitmap = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramBitmap.aFh(), "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "startConfirm", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramBitmap.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "startConfirm", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(118343);
      return;
    }
  }
  
  private void fDI()
  {
    AppMethodBeat.i(118345);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("BaseScanUI_select_scan_mode", 7);
    ((Intent)localObject).putExtra("scan_bankcard_with_confirm_ui", true);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(this, ScanCardUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "goBackScan", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "goBackScan", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(118345);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.e.confirm_scan_bank_card_result_ui;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(118346);
    fDI();
    AppMethodBeat.o(118346);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(118344);
    super.onCreate(paramBundle);
    setMMTitle(a.g.scan_wallet_confirm_card_id_ui_title);
    int i;
    if (getIntent() == null)
    {
      Log.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
      i = 0;
    }
    while (i == 0)
    {
      finish();
      AppMethodBeat.o(118344);
      return;
      this.IPO = getIntent().getStringExtra("_image_cache_key_");
      if (Util.isNullOrNil(this.IPO))
      {
        Log.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
        i = 0;
      }
      else
      {
        this.mBmp = ((Bitmap)IPP.get(this.IPO));
        if ((this.mBmp == null) || (this.mBmp.isRecycled()))
        {
          Log.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
    paramBundle = getIntent().getStringExtra("_card_num_");
    if (Util.isNullOrNil(paramBundle))
    {
      Log.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
      finish();
      AppMethodBeat.o(118344);
      return;
    }
    this.IPQ = ((ImageView)findViewById(a.d.imageBankCard));
    this.IPR = ((EditText)findViewById(a.d.editBankCard));
    this.IPQ.setImageBitmap(this.mBmp);
    this.IPR.setText(paramBundle);
    findViewById(a.d.buttonOK).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(118341);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        if (ConfirmScanBankCardResultUI.a(ConfirmScanBankCardResultUI.this) != null)
        {
          paramAnonymousView = ConfirmScanBankCardResultUI.a(ConfirmScanBankCardResultUI.this).getEditableText().toString();
          if (Util.isNullOrNil(paramAnonymousView))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(118341);
            return;
          }
          ConfirmScanBankCardResultUI.this.finish();
          localObject = new ug();
          ((ug)localObject).fTz.action = 1;
          ((ug)localObject).fTz.cardNum = paramAnonymousView;
          ((ug)localObject).fTz.fTA = ConfirmScanBankCardResultUI.this.mBmp;
          EventCenter.instance.publish((IEvent)localObject);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(118341);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(118342);
        ConfirmScanBankCardResultUI.b(ConfirmScanBankCardResultUI.this);
        AppMethodBeat.o(118342);
        return true;
      }
    });
    AppMethodBeat.o(118344);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(118347);
    super.onDestroy();
    if (this.IPQ != null) {
      this.IPQ.setImageBitmap(null);
    }
    if (!Util.isNullOrNil(this.IPO)) {
      IPP.remove(this.IPO);
    }
    if (this.mBmp != null)
    {
      Log.i("MicroMsg.ConfirmScanBankCardResultUI", "bitmap recycle %s", new Object[] { this.mBmp.toString() });
      this.mBmp.recycle();
    }
    AppMethodBeat.o(118347);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI
 * JD-Core Version:    0.7.0.1
 */