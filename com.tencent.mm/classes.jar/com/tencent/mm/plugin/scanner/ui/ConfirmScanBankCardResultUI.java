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
import com.tencent.mm.g.a.si;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class ConfirmScanBankCardResultUI
  extends MMActivity
{
  protected static final Map<String, Bitmap> yGz;
  protected Bitmap mBmp = null;
  private ImageView yGA;
  private EditText yGB;
  private String yGy = null;
  
  static
  {
    AppMethodBeat.i(118349);
    yGz = new HashMap();
    AppMethodBeat.o(118349);
  }
  
  public static void c(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(118343);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()) || (bu.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(118343);
      return;
    }
    Intent localIntent = new Intent();
    if (((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).TenPaySDKABTestKindaEnable()) {}
    for (Activity localActivity = ((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).getCrossActivity();; localActivity = null)
    {
      Object localObject = localActivity;
      if (localActivity == null)
      {
        localObject = ak.getContext();
        localIntent.addFlags(268435456);
      }
      localIntent.setClass((Context)localObject, ConfirmScanBankCardResultUI.class);
      localIntent.putExtra("_card_num_", paramString);
      paramString = "_image_cache_key_".concat(String.valueOf(paramString));
      yGz.put(paramString, paramBitmap);
      localIntent.putExtra("_image_cache_key_", paramString);
      paramBitmap = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramBitmap.ahE(), "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "startConfirm", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject).startActivity((Intent)paramBitmap.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "startConfirm", "(Landroid/graphics/Bitmap;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(118343);
      return;
    }
  }
  
  private void dOX()
  {
    AppMethodBeat.i(118345);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("BaseScanUI_select_scan_mode", 7);
    ((Intent)localObject).putExtra("scan_bankcard_with_confirm_ui", true);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setClass(this, ScanCardUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "goBackScan", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI", "goBackScan", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    finish();
    AppMethodBeat.o(118345);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493595;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(118346);
    dOX();
    AppMethodBeat.o(118346);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(118344);
    super.onCreate(paramBundle);
    setMMTitle(2131762890);
    int i;
    if (getIntent() == null)
    {
      ae.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
      i = 0;
    }
    while (i == 0)
    {
      finish();
      AppMethodBeat.o(118344);
      return;
      this.yGy = getIntent().getStringExtra("_image_cache_key_");
      if (bu.isNullOrNil(this.yGy))
      {
        ae.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
        i = 0;
      }
      else
      {
        this.mBmp = ((Bitmap)yGz.get(this.yGy));
        if ((this.mBmp == null) || (this.mBmp.isRecycled()))
        {
          ae.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
    }
    paramBundle = getIntent().getStringExtra("_card_num_");
    if (bu.isNullOrNil(paramBundle))
    {
      ae.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
      finish();
      AppMethodBeat.o(118344);
      return;
    }
    this.yGA = ((ImageView)findViewById(2131300915));
    this.yGB = ((EditText)findViewById(2131299248));
    this.yGA.setImageBitmap(this.mBmp);
    this.yGB.setText(paramBundle);
    findViewById(2131297632).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(118341);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (ConfirmScanBankCardResultUI.a(ConfirmScanBankCardResultUI.this) != null)
        {
          paramAnonymousView = ConfirmScanBankCardResultUI.a(ConfirmScanBankCardResultUI.this).getEditableText().toString();
          if (bu.isNullOrNil(paramAnonymousView))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ConfirmScanBankCardResultUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(118341);
            return;
          }
          ConfirmScanBankCardResultUI.this.finish();
          localObject = new si();
          ((si)localObject).dHT.action = 1;
          ((si)localObject).dHT.cardNum = paramAnonymousView;
          ((si)localObject).dHT.dHU = ConfirmScanBankCardResultUI.this.mBmp;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
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
    if (this.yGA != null) {
      this.yGA.setImageBitmap(null);
    }
    if (!bu.isNullOrNil(this.yGy)) {
      yGz.remove(this.yGy);
    }
    if (this.mBmp != null)
    {
      ae.i("MicroMsg.ConfirmScanBankCardResultUI", "bitmap recycle %s", new Object[] { this.mBmp.toString() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ConfirmScanBankCardResultUI
 * JD-Core Version:    0.7.0.1
 */