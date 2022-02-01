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
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.n.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI
  extends MMBaseSelectContactUI
{
  private boolean CvF;
  private boolean KMW;
  private com.tencent.mm.sdk.b.c KMX;
  private List<String> fUR;
  private String talker;
  
  public VoipAddressUI()
  {
    AppMethodBeat.i(38093);
    this.KMW = false;
    this.CvF = false;
    this.talker = "";
    this.KMX = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(38093);
  }
  
  private void dEo()
  {
    AppMethodBeat.i(38096);
    boolean bool = b.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
    ae.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
    if (!bool)
    {
      AppMethodBeat.o(38096);
      return;
    }
    yh localyh = new yh();
    localyh.dNE.dto = 5;
    localyh.dNE.talker = this.talker;
    localyh.dNE.context = this;
    if (this.KMW) {}
    for (int i = 2;; i = 1)
    {
      localyh.dNE.dNA = 3;
      com.tencent.mm.plugin.report.service.g.yxI.f(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.IvT.l(localyh);
      hideVKB();
      AppMethodBeat.o(38096);
      return;
    }
  }
  
  private void dEp()
  {
    AppMethodBeat.i(38097);
    boolean bool = b.a(this, "android.permission.CAMERA", 19, "", "");
    ae.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
    if (!bool)
    {
      AppMethodBeat.o(38097);
      return;
    }
    bool = b.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
    ae.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bu.fpN(), this });
    if (!bool)
    {
      AppMethodBeat.o(38097);
      return;
    }
    yh localyh = new yh();
    localyh.dNE.dto = 5;
    localyh.dNE.talker = this.talker;
    localyh.dNE.context = this;
    if (this.KMW) {}
    for (int i = 2;; i = 1)
    {
      localyh.dNE.dNA = 2;
      com.tencent.mm.plugin.report.service.g.yxI.f(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.IvT.l(localyh);
      hideVKB();
      AppMethodBeat.o(38097);
      return;
    }
  }
  
  public static void kw(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(38101);
    boolean bool;
    if (1 == bu.getInt(com.tencent.mm.n.g.acL().getValue("VOIPCallType"), 0))
    {
      bool = true;
      Object localObject = new Intent(paramContext, VoipAddressUI.class);
      ((Intent)localObject).putExtra("Add_address_titile", paramContext.getString(2131755234));
      ((Intent)localObject).putExtra("voip_video", bool);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext = com.tencent.mm.plugin.report.service.g.yxI;
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
  
  protected final void Zm()
  {
    AppMethodBeat.i(38098);
    super.Zm();
    String str = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
    this.CvF = getIntent().getBooleanExtra("voip_video", true);
    if (str != null)
    {
      this.KMW = true;
      if (!str.equals("launch_type_voip")) {
        break label99;
      }
      this.CvF = true;
    }
    for (;;)
    {
      this.fUR = new ArrayList();
      this.fUR.addAll(u.fMH());
      this.fUR.addAll(u.fMI());
      AppMethodBeat.o(38098);
      return;
      label99:
      if (str.equals("launch_type_voip_audio")) {
        this.CvF = false;
      }
    }
  }
  
  protected final boolean aRT()
  {
    return false;
  }
  
  protected final boolean aRU()
  {
    return true;
  }
  
  protected final String aRV()
  {
    AppMethodBeat.i(38104);
    String str2 = getIntent().getStringExtra("Add_address_titile");
    String str1 = str2;
    if (!bu.isNullOrNil(str2)) {
      str1 = getString(2131755234);
    }
    AppMethodBeat.o(38104);
    return str1;
  }
  
  protected final q aRW()
  {
    AppMethodBeat.i(38099);
    Object localObject = new c.a();
    ((c.a)localObject).KGP = true;
    ((c.a)localObject).KGO = true;
    localObject = new c(this, this.fUR, false, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38099);
    return localObject;
  }
  
  protected final o aRX()
  {
    AppMethodBeat.i(38100);
    s locals = new s(this, this.fUR, false, this.scene);
    AppMethodBeat.o(38100);
    return locals;
  }
  
  public final int[] dmI()
  {
    return new int[] { 131072 };
  }
  
  protected final void dmJ()
  {
    AppMethodBeat.i(38103);
    if (this.KMW)
    {
      Object localObject = new Intent(this, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/VoipAddressUI", "onBackBtnPress", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
    com.tencent.mm.sdk.b.a.IvT.c(this.KMX);
    AppMethodBeat.o(38094);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38102);
    com.tencent.mm.sdk.b.a.IvT.d(this.KMX);
    super.onDestroy();
    AppMethodBeat.o(38102);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(38105);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ae.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(38105);
      return;
    }
    ae.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38105);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        dEp();
        AppMethodBeat.o(38105);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131761860;; paramInt = 2131761871)
      {
        if (paramArrayOfInt[0] != 0) {
          h.a(this, getString(paramInt), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38090);
              paramAnonymousDialogInterface.dismiss();
              paramAnonymousDialogInterface = VoipAddressUI.this;
              Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/VoipAddressUI$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        dEo();
        AppMethodBeat.o(38105);
        return;
      }
      h.a(this, getString(2131761869), getString(2131761885), getString(2131760598), getString(2131756766), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38092);
          paramAnonymousDialogInterface = VoipAddressUI.this;
          Object localObject = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/VoipAddressUI$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
  
  public final void rj(int paramInt)
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
    if (this.CvF)
    {
      dEp();
      AppMethodBeat.o(38095);
      return;
    }
    dEo();
    AppMethodBeat.o(38095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.VoipAddressUI
 * JD-Core Version:    0.7.0.1
 */