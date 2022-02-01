package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public class ShortCutDispatchActivity
  extends AutoLoginActivity
{
  private String aaLL;
  private com.tencent.mm.plugin.wallet_index.model.b adBL;
  private boolean adJY = false;
  
  public final void a(AutoLoginActivity.a parama, Intent paramIntent)
  {
    AppMethodBeat.i(249619);
    Log.d("MicroMsg.ControlLauncherActivity", "login code".concat(String.valueOf(parama)));
    switch (1.vrD[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(249619);
      return;
    }
    Log.d("MicroMsg.ControlLauncherActivity", "switchLaunchType");
    if (this.adJY)
    {
      Log.d("MicroMsg.ControlLauncherActivity", "in ControlLaunchActivity ScanQR");
      if (WeChatBrands.Business.Entries.GlobalScan.checkAvailable(this))
      {
        Log.d("MicroMsg.ControlLauncherActivity", "in LaunchTypeScanQRCode");
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        parama = com.tencent.mm.plugin.secdata.ui.a.PlI;
        parama = (dgs)a.a.a(this, "BaseScanUI", 3, dgs.class);
        if (parama != null) {
          parama.aaLL = "launch_type_scan_qrcode";
        }
        parama = new Intent().setClassName(this, "com.tencent.mm.plugin.scanner.ui.BaseScanUI");
        parama.putExtra("key_enable_multi_code", true);
        parama.putExtra("key_scan_goods_enable_dynamic_wording", true);
        parama.putExtra("key_enable_scan_code_product_merge", true);
        parama.putExtra("key_scan_entry_scene", 5);
        parama.putExtra("key_check_camera_using", true);
        parama.addFlags(67108864);
        parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
        com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)parama.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    for (;;)
    {
      finish();
      break;
      if (this.aaLL == null)
      {
        Log.e("MicroMsg.ControlLauncherActivity", "error: launchType == null! ");
        parama = new Intent();
        parama.setClassName(this, "com.tencent.mm.ui.LauncherUI").addFlags(67108864);
        parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
        com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)parama.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (this.aaLL.equals("launch_type_scan_qrcode"))
      {
        Log.d("MicroMsg.ControlLauncherActivity", "in ControlLaunchActivity ScanQR");
        if (WeChatBrands.Business.Entries.GlobalScan.checkAvailable(this))
        {
          Log.d("MicroMsg.ControlLauncherActivity", "in LaunchTypeScanQRCode");
          getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
          parama = com.tencent.mm.plugin.secdata.ui.a.PlI;
          parama = (dgs)a.a.a(this, "BaseScanUI", 3, dgs.class);
          if (parama != null) {
            parama.aaLL = "launch_type_scan_qrcode";
          }
          parama = new Intent().setClassName(this, "com.tencent.mm.plugin.scanner.ui.BaseScanUI");
          parama.putExtra("key_enable_multi_code", true);
          parama.putExtra("key_scan_goods_enable_dynamic_wording", true);
          parama.putExtra("key_enable_scan_code_product_merge", true);
          parama.putExtra("key_scan_entry_scene", 5);
          parama.putExtra("key_check_camera_using", true);
          parama.addFlags(67108864);
          parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
          com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)parama.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      else if (this.aaLL.equals("launch_type_my_qrcode"))
      {
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        Log.d("MicroMsg.ControlLauncherActivity", "in LaunchTypeSMycanQRCode");
        parama = com.tencent.mm.plugin.secdata.ui.a.PlI;
        parama = (dgs)a.a.a(this, "SelfQRCodeUI", 3, dgs.class);
        if (parama != null) {
          parama.aaLL = "launch_type_my_qrcode";
        }
        parama = new Intent().setClassName(this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
        parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
        com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)parama.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (this.aaLL.equals("launch_type_voip"))
      {
        Log.d("MicroMsg.ControlLauncherActivity", "launch, LaunchTypeVOIP");
        parama = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
        parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
        com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)parama.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.OAn.b(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(0) });
      }
      else if (this.aaLL.equals("launch_type_voip_audio"))
      {
        Log.d("MicroMsg.ControlLauncherActivity", "launch, LaunchTypeVOIPAudio");
        parama = new Intent().setClassName(this, "com.tencent.mm.ui.contact.VoipAddressUI").putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
        parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
        com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)parama.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.plugin.report.service.h.OAn.b(11034, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      }
      else if (this.aaLL.equals("launch_type_offline_wallet"))
      {
        getIntent().putExtra("LauncherUI.Shortcut.LaunchType", "");
        Log.d("MicroMsg.ControlLauncherActivity", "in LaunchTypeOfflineWallet");
        parama = com.tencent.mm.plugin.secdata.ui.a.PlI;
        parama = (dgs)a.a.a(this, "WalletOfflineEntranceUI", 3, dgs.class);
        if (parama != null) {
          parama.aaLL = "launch_type_offline_wallet";
        }
        int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
        if ((i == 0) || (i == 1))
        {
          if (!((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.wallet.a.class)).isUseCaseAlive("offline"))
          {
            parama = new Intent().setClassName(this, "com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI");
            parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
            com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)parama.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            parama = new Intent();
            parama.addFlags(67108864);
            parama.setClassName(this, "com.tencent.mm.framework.app.UIPageFragmentActivity");
            parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
            com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)parama.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        else if (i == 8)
        {
          if (this.adBL == null) {
            this.adBL = new com.tencent.mm.plugin.wallet_index.model.b();
          }
          this.adBL.kL(this);
        }
      }
      else
      {
        Log.e("MicroMsg.ControlLauncherActivity", "error: launchType:%s doesn`t match all types! ", new Object[] { this.aaLL });
        parama = new Intent();
        parama.setClassName(this, "com.tencent.mm.ui.LauncherUI").addFlags(67108864);
        parama = new com.tencent.mm.hellhoundlib.b.a().cG(parama);
        com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)parama.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/ShortCutDispatchActivity", "switchLaunchType", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
  }
  
  public final boolean ad(Intent paramIntent)
  {
    return true;
  }
  
  public final boolean gtu()
  {
    AppMethodBeat.i(249610);
    com.tencent.mm.kernel.h.baC();
    if ((!com.tencent.mm.kernel.b.aZM()) || (com.tencent.mm.kernel.b.aZG()))
    {
      Log.w("MicroMsg.ControlLauncherActivity", "not login");
      Intent localIntent1 = new Intent(this, getClass());
      localIntent1.putExtras(getIntent());
      localIntent1.addFlags(268468224);
      localIntent1.setDataAndType(getIntent().getData(), getIntent().getType());
      localIntent1.setAction(getIntent().getAction());
      Intent localIntent2 = new Intent();
      localIntent2.putExtras(getIntent());
      c.a(this, "account", "com.tencent.mm.plugin.account.ui.LoginPasswordUI", localIntent2, localIntent1);
      AppMethodBeat.o(249610);
      return true;
    }
    AppMethodBeat.o(249610);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(249604);
    Intent localIntent = getIntent();
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(249604);
      return;
    }
    this.aaLL = localIntent.getStringExtra("LauncherUI.Shortcut.LaunchType");
    this.adJY = localIntent.getBooleanExtra("LauncherUI.From.Scaner.Shortcut", false);
    if (this.aaLL != null) {
      Log.i("MicroMsg.ControlLauncherActivity", "launchType: " + this.aaLL + "  isFromHomeScan " + this.adJY);
    }
    super.onCreate(paramBundle);
    AppMethodBeat.o(249604);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(249620);
    super.onPause();
    AppMethodBeat.o(249620);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(249624);
    super.onResume();
    AppMethodBeat.o(249624);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.ShortCutDispatchActivity
 * JD-Core Version:    0.7.0.1
 */