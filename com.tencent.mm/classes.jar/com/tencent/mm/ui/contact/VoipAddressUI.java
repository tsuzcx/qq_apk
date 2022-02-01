package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.n.f;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI
  extends MMBaseSelectContactUI
{
  private boolean GZt;
  private boolean PZW;
  private IListener PZX;
  private List<String> gzY;
  private String talker;
  
  public VoipAddressUI()
  {
    AppMethodBeat.i(38093);
    this.PZW = false;
    this.GZt = false;
    this.talker = "";
    this.PZX = new VoipAddressUI.1(this);
    AppMethodBeat.o(38093);
  }
  
  private void eEK()
  {
    AppMethodBeat.i(38096);
    boolean bool = b.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
    Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      AppMethodBeat.o(38096);
      return;
    }
    zj localzj = new zj();
    localzj.efx.dKy = 5;
    localzj.efx.talker = this.talker;
    localzj.efx.context = this;
    if (this.PZW) {}
    for (int i = 2;; i = 1)
    {
      localzj.efx.eft = 3;
      com.tencent.mm.plugin.report.service.h.CyF.a(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0) });
      EventCenter.instance.publish(localzj);
      hideVKB();
      AppMethodBeat.o(38096);
      return;
    }
  }
  
  private void eEL()
  {
    AppMethodBeat.i(38097);
    boolean bool = b.a(this, "android.permission.CAMERA", 19, "", "");
    Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      AppMethodBeat.o(38097);
      return;
    }
    bool = b.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
    Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      AppMethodBeat.o(38097);
      return;
    }
    zj localzj = new zj();
    localzj.efx.dKy = 5;
    localzj.efx.talker = this.talker;
    localzj.efx.context = this;
    if (this.PZW) {}
    for (int i = 2;; i = 1)
    {
      localzj.efx.eft = 2;
      com.tencent.mm.plugin.report.service.h.CyF.a(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      EventCenter.instance.publish(localzj);
      hideVKB();
      AppMethodBeat.o(38097);
      return;
    }
  }
  
  public static void kp(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(38101);
    boolean bool;
    if (1 == Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCallType"), 0))
    {
      bool = true;
      Object localObject = new Intent(paramContext, VoipAddressUI.class);
      ((Intent)localObject).putExtra("Add_address_titile", paramContext.getString(2131755268));
      ((Intent)localObject).putExtra("voip_video", bool);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext = com.tencent.mm.plugin.report.service.h.CyF;
      if (!bool) {
        break label161;
      }
    }
    for (;;)
    {
      paramContext.a(11034, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(38101);
      return;
      bool = false;
      break;
      label161:
      i = 1;
    }
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(234094);
    paramView = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(234094);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(234094);
      return;
    }
    this.talker = paramView.contact.field_username;
    if (this.GZt)
    {
      eEL();
      AppMethodBeat.o(234094);
      return;
    }
    eEK();
    AppMethodBeat.o(234094);
  }
  
  protected final void amZ()
  {
    AppMethodBeat.i(38098);
    super.amZ();
    String str = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
    this.GZt = getIntent().getBooleanExtra("voip_video", true);
    if (str != null)
    {
      this.PZW = true;
      if (!str.equals("launch_type_voip")) {
        break label100;
      }
      this.GZt = true;
    }
    for (;;)
    {
      this.gzY = new ArrayList();
      this.gzY.addAll(u.gVb());
      this.gzY.addAll(u.gVc());
      AppMethodBeat.o(38098);
      return;
      label100:
      if (str.equals("launch_type_voip_audio")) {
        this.GZt = false;
      }
    }
  }
  
  protected final boolean bmA()
  {
    return true;
  }
  
  protected final String bmB()
  {
    AppMethodBeat.i(38104);
    String str2 = getIntent().getStringExtra("Add_address_titile");
    String str1 = str2;
    if (!Util.isNullOrNil(str2)) {
      str1 = getString(2131755268);
    }
    AppMethodBeat.o(38104);
    return str1;
  }
  
  protected final q bmC()
  {
    AppMethodBeat.i(38099);
    Object localObject = new c.a();
    ((c.a)localObject).PTM = true;
    ((c.a)localObject).PTL = true;
    localObject = new c(this, this.gzY, false, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38099);
    return localObject;
  }
  
  protected final o bmD()
  {
    AppMethodBeat.i(38100);
    s locals = new s(this, this.gzY, false, this.scene);
    AppMethodBeat.o(38100);
    return locals;
  }
  
  protected final boolean bmz()
  {
    return false;
  }
  
  public final int[] egI()
  {
    return new int[] { 131072 };
  }
  
  protected final void egJ()
  {
    AppMethodBeat.i(38103);
    if (this.PZW)
    {
      Object localObject = new Intent(this, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/VoipAddressUI", "onBackBtnPress", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/VoipAddressUI", "onBackBtnPress", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    hideVKB();
    finish();
    AppMethodBeat.o(38103);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38094);
    super.onCreate(paramBundle);
    EventCenter.instance.addListener(this.PZX);
    AppMethodBeat.o(38094);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38102);
    EventCenter.instance.removeListener(this.PZX);
    super.onDestroy();
    AppMethodBeat.o(38102);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38105);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(38105);
      return;
    }
    Log.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38105);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        eEL();
        AppMethodBeat.o(38105);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131763864;; paramInt = 2131763876)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131763890), getString(2131762043), getString(2131756929), false, new VoipAddressUI.2(this), new VoipAddressUI.3(this));
        }
        AppMethodBeat.o(38105);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        eEK();
        AppMethodBeat.o(38105);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131763874), getString(2131763890), getString(2131762043), getString(2131756929), false, new VoipAddressUI.4(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.VoipAddressUI
 * JD-Core Version:    0.7.0.1
 */