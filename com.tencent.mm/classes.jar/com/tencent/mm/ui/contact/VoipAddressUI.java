package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.k.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI
  extends MMBaseSelectContactUI
{
  private boolean UvH;
  private boolean afiW;
  private IListener afiX;
  private List<String> lMF;
  private String talker;
  
  public VoipAddressUI()
  {
    AppMethodBeat.i(38093);
    this.afiW = false;
    this.UvH = false;
    this.talker = "";
    this.afiX = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(38093);
  }
  
  private void gBT()
  {
    AppMethodBeat.i(38096);
    boolean bool = b.a(this, "android.permission.RECORD_AUDIO", 82, "");
    Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      AppMethodBeat.o(38096);
      return;
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = this.talker;
    localacn.ifU.context = this;
    if (this.afiW) {}
    for (int i = 2;; i = 1)
    {
      localacn.ifU.ifQ = 3;
      h.OAn.b(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0) });
      localacn.publish();
      hideVKB();
      AppMethodBeat.o(38096);
      return;
    }
  }
  
  private void gBU()
  {
    AppMethodBeat.i(38097);
    boolean bool = b.a(this, "android.permission.CAMERA", 19, "");
    Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      AppMethodBeat.o(38097);
      return;
    }
    bool = b.a(this, "android.permission.RECORD_AUDIO", 19, "");
    Log.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
    if (!bool)
    {
      AppMethodBeat.o(38097);
      return;
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = this.talker;
    localacn.ifU.context = this;
    if (this.afiW) {}
    for (int i = 2;; i = 1)
    {
      localacn.ifU.ifQ = 2;
      h.OAn.b(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      localacn.publish();
      hideVKB();
      AppMethodBeat.o(38097);
      return;
    }
  }
  
  public static void nr(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(38101);
    boolean bool;
    if (1 == Util.getInt(i.aRC().getValue("VOIPCallType"), 0))
    {
      bool = true;
      Object localObject = new Intent(paramContext, VoipAddressUI.class);
      ((Intent)localObject).putExtra("Add_address_titile", paramContext.getString(R.l.address_title_select_contact));
      ((Intent)localObject).putExtra("voip_video", bool);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/contact/VoipAddressUI", "inviteVoip", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext = h.OAn;
      if (!bool) {
        break label162;
      }
    }
    for (;;)
    {
      paramContext.b(11034, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(38101);
      return;
      bool = false;
      break;
      label162:
      i = 1;
    }
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253008);
    paramAdapterView = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(253008);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(253008);
      return;
    }
    this.talker = paramAdapterView.contact.field_username;
    if (this.UvH)
    {
      gBU();
      AppMethodBeat.o(253008);
      return;
    }
    gBT();
    AppMethodBeat.o(253008);
  }
  
  protected final void aNi()
  {
    AppMethodBeat.i(38098);
    super.aNi();
    String str = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
    this.UvH = getIntent().getBooleanExtra("voip_video", true);
    if (str != null)
    {
      this.afiW = true;
      if (!str.equals("launch_type_voip")) {
        break label103;
      }
      this.UvH = true;
    }
    for (;;)
    {
      this.lMF = new ArrayList();
      this.lMF.addAll(w.jyV());
      this.lMF.addAll(w.jyW());
      AppMethodBeat.o(38098);
      return;
      label103:
      if (str.equals("launch_type_voip_audio")) {
        this.UvH = false;
      }
    }
  }
  
  protected final r bVA()
  {
    AppMethodBeat.i(38099);
    Object localObject = new c.a();
    ((c.a)localObject).afbY = true;
    ((c.a)localObject).afbX = true;
    localObject = new c(this, this.lMF, false, (c.a)localObject, (byte)0);
    AppMethodBeat.o(38099);
    return localObject;
  }
  
  protected final p bVB()
  {
    AppMethodBeat.i(38100);
    u localu = new u(this, this.lMF, false, this.scene);
    AppMethodBeat.o(38100);
    return localu;
  }
  
  protected final boolean bVx()
  {
    return false;
  }
  
  protected final boolean bVy()
  {
    return true;
  }
  
  protected final String bVz()
  {
    AppMethodBeat.i(38104);
    String str2 = getIntent().getStringExtra("Add_address_titile");
    String str1 = str2;
    if (!Util.isNullOrNil(str2)) {
      str1 = getString(R.l.address_title_select_contact);
    }
    AppMethodBeat.o(38104);
    return str1;
  }
  
  public final int[] efu()
  {
    return new int[] { 131072 };
  }
  
  protected final void fYZ()
  {
    AppMethodBeat.i(38103);
    if (this.afiW)
    {
      Object localObject = new Intent(this, LauncherUI.class);
      ((Intent)localObject).addFlags(67108864);
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/VoipAddressUI", "onBackBtnPress", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/VoipAddressUI", "onBackBtnPress", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    hideVKB();
    finish();
    AppMethodBeat.o(38103);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38094);
    super.onCreate(paramBundle);
    this.afiX.alive();
    AppMethodBeat.o(38094);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38102);
    this.afiX.dead();
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
        gBU();
        AppMethodBeat.o(38105);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg;; paramInt = R.l.permission_microphone_request_again_msg)
      {
        if (paramArrayOfInt[0] != 0) {
          k.a(this, getString(paramInt), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(38090);
              paramAnonymousDialogInterface.dismiss();
              b.lx(VoipAddressUI.this.getContext());
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
        gBT();
        AppMethodBeat.o(38105);
        return;
      }
      k.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(38092);
          b.lx(VoipAddressUI.this.getContext());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.VoipAddressUI
 * JD-Core Version:    0.7.0.1
 */