package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.c.av;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI
  extends MMBaseSelectContactUI
{
  private boolean AFe;
  private boolean Izw;
  private com.tencent.mm.sdk.b.c Izx;
  private List<String> fzw;
  private String talker;
  
  public VoipAddressUI()
  {
    AppMethodBeat.i(38093);
    this.Izw = false;
    this.AFe = false;
    this.talker = "";
    this.Izx = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38093);
  }
  
  private void dqu()
  {
    AppMethodBeat.i(38096);
    boolean bool = b.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
    ac.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this });
    if (!bool)
    {
      AppMethodBeat.o(38096);
      return;
    }
    xh localxh = new xh();
    localxh.dAb.dgL = 5;
    localxh.dAb.talker = this.talker;
    localxh.dAb.context = this;
    if (this.Izw) {}
    for (int i = 2;; i = 1)
    {
      localxh.dAb.dzX = 3;
      com.tencent.mm.plugin.report.service.h.wUl.f(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.GpY.l(localxh);
      hideVKB();
      AppMethodBeat.o(38096);
      return;
    }
  }
  
  private void dqv()
  {
    AppMethodBeat.i(38097);
    boolean bool = b.a(this, "android.permission.CAMERA", 19, "", "");
    ac.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this });
    if (!bool)
    {
      AppMethodBeat.o(38097);
      return;
    }
    bool = b.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
    ac.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bs.eWi(), this });
    if (!bool)
    {
      AppMethodBeat.o(38097);
      return;
    }
    xh localxh = new xh();
    localxh.dAb.dgL = 5;
    localxh.dAb.talker = this.talker;
    localxh.dAb.context = this;
    if (this.Izw) {}
    for (int i = 2;; i = 1)
    {
      localxh.dAb.dzX = 2;
      com.tencent.mm.plugin.report.service.h.wUl.f(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.GpY.l(localxh);
      hideVKB();
      AppMethodBeat.o(38097);
      return;
    }
  }
  
  public static void kd(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(38101);
    boolean bool;
    if (1 == bs.getInt(g.ZY().getValue("VOIPCallType"), 0))
    {
      bool = true;
      Object localObject = new Intent(paramContext, VoipAddressUI.class);
      ((Intent)localObject).putExtra("Add_address_titile", paramContext.getString(2131755234));
      ((Intent)localObject).putExtra("voip_video", bool);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext = com.tencent.mm.plugin.report.service.h.wUl;
      if (!bool) {
        break label161;
      }
    }
    for (;;)
    {
      paramContext.f(11034, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(38101);
      return;
      bool = false;
      break;
      label161:
      i = 1;
    }
  }
  
  protected final void WJ()
  {
    AppMethodBeat.i(38098);
    super.WJ();
    String str = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
    this.AFe = getIntent().getBooleanExtra("voip_video", true);
    if (str != null)
    {
      this.Izw = true;
      if (!str.equals("launch_type_voip")) {
        break label99;
      }
      this.AFe = true;
    }
    for (;;)
    {
      this.fzw = new ArrayList();
      this.fzw.addAll(u.frC());
      this.fzw.addAll(u.frD());
      AppMethodBeat.o(38098);
      return;
      label99:
      if (str.equals("launch_type_voip_audio")) {
        this.AFe = false;
      }
    }
  }
  
  protected final boolean aOi()
  {
    return false;
  }
  
  protected final boolean aOj()
  {
    return true;
  }
  
  protected final String aOk()
  {
    AppMethodBeat.i(38104);
    String str2 = getIntent().getStringExtra("Add_address_titile");
    String str1 = str2;
    if (!bs.isNullOrNil(str2)) {
      str1 = getString(2131755234);
    }
    AppMethodBeat.o(38104);
    return str1;
  }
  
  protected final q aOl()
  {
    AppMethodBeat.i(38099);
    Object localObject = new c.a();
    ((c.a)localObject).ItP = true;
    ((c.a)localObject).ItO = true;
    localObject = new c(this, this.fzw, false, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38099);
    return localObject;
  }
  
  protected final o aOm()
  {
    AppMethodBeat.i(38100);
    s locals = new s(this, this.fzw, false, this.scene);
    AppMethodBeat.o(38100);
    return locals;
  }
  
  public final int[] daw()
  {
    return new int[] { 131072 };
  }
  
  protected final void dax()
  {
    AppMethodBeat.i(38103);
    if (this.Izw)
    {
      Object localObject = new Intent(this, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/VoipAddressUI", "onBackBtnPress", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
    com.tencent.mm.sdk.b.a.GpY.c(this.Izx);
    AppMethodBeat.o(38094);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38102);
    com.tencent.mm.sdk.b.a.GpY.d(this.Izx);
    super.onDestroy();
    AppMethodBeat.o(38102);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38105);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ac.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(38105);
      return;
    }
    ac.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38105);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dqv();
        AppMethodBeat.o(38105);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38090);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = VoipAddressUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/VoipAddressUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/contact/VoipAddressUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(38090);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38091);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(38091);
            }
          });
        }
        AppMethodBeat.o(38105);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        dqu();
        AppMethodBeat.o(38105);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38092);
          paramAnonymousDialogInterface = VoipAddressUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/VoipAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/contact/VoipAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(38092);
        }
      }, null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(38095);
    com.tencent.mm.ui.contact.a.a locala = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(38095);
      return;
    }
    if (locala.contact == null)
    {
      AppMethodBeat.o(38095);
      return;
    }
    this.talker = locala.contact.field_username;
    if (this.AFe)
    {
      dqv();
      AppMethodBeat.o(38095);
      return;
    }
    dqu();
    AppMethodBeat.o(38095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.VoipAddressUI
 * JD-Core Version:    0.7.0.1
 */