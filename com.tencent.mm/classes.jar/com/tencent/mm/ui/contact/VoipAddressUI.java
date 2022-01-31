package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.R.l;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI
  extends MMBaseSelectContactUI
{
  private List<String> dru;
  private String talker = "";
  private boolean vOe = false;
  private boolean vOf = false;
  private com.tencent.mm.sdk.b.c vOg = new VoipAddressUI.1(this);
  
  private void bsG()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
    y.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
    if (!bool) {
      return;
    }
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = this.talker;
    localtd.ccJ.context = this;
    if (this.vOe) {}
    for (int i = 2;; i = 1)
    {
      localtd.ccJ.ccE = 3;
      com.tencent.mm.plugin.report.service.h.nFQ.f(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.udP.m(localtd);
      XM();
      return;
    }
  }
  
  private void bsH()
  {
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 19, "", "");
    y.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
    if (!bool) {}
    do
    {
      return;
      bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
      y.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this });
    } while (!bool);
    td localtd = new td();
    localtd.ccJ.bNb = 5;
    localtd.ccJ.talker = this.talker;
    localtd.ccJ.context = this;
    if (this.vOe) {}
    for (int i = 2;; i = 1)
    {
      localtd.ccJ.ccE = 2;
      com.tencent.mm.plugin.report.service.h.nFQ.f(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.udP.m(localtd);
      XM();
      return;
    }
  }
  
  public static void gV(Context paramContext)
  {
    int i = 0;
    boolean bool;
    if (1 == bk.getInt(g.AA().getValue("VOIPCallType"), 0))
    {
      bool = true;
      Intent localIntent = new Intent(paramContext, VoipAddressUI.class);
      localIntent.putExtra("Add_address_titile", paramContext.getString(R.l.address_title_select_contact));
      localIntent.putExtra("voip_video", bool);
      paramContext.startActivity(localIntent);
      paramContext = com.tencent.mm.plugin.report.service.h.nFQ;
      if (!bool) {
        break label97;
      }
    }
    for (;;)
    {
      paramContext.f(11034, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      return;
      bool = false;
      break;
      label97:
      i = 1;
    }
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return true;
  }
  
  protected final String VE()
  {
    String str2 = getIntent().getStringExtra("Add_address_titile");
    String str1 = str2;
    if (!bk.bl(str2)) {
      str1 = getString(R.l.address_title_select_contact);
    }
    return str1;
  }
  
  protected final o VF()
  {
    c.a locala = new c.a();
    locala.vJK = true;
    locala.vJJ = true;
    return new c(this, this.dru, false, locala);
  }
  
  protected final m VG()
  {
    return new q(this, this.dru, false, this.scene);
  }
  
  public final int[] bgw()
  {
    return new int[] { 131072 };
  }
  
  protected final void bgx()
  {
    if (this.vOe)
    {
      Intent localIntent = new Intent(this, LauncherUI.class);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    XM();
    finish();
  }
  
  public final void jP(int paramInt)
  {
    com.tencent.mm.ui.contact.a.a locala = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (locala == null) {}
    while (locala.dnp == null) {
      return;
    }
    this.talker = locala.dnp.field_username;
    if (this.vOf)
    {
      bsH();
      return;
    }
    bsG();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.udP.c(this.vOg);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.vOg);
    super.onDestroy();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.VoipAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    case 19: 
      if (paramArrayOfInt[0] == 0)
      {
        bsH();
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = R.l.permission_camera_request_again_msg; paramArrayOfInt[0] != 0; paramInt = R.l.permission_microphone_request_again_msg)
      {
        com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new VoipAddressUI.2(this), new VoipAddressUI.3(this));
        return;
      }
    }
    if (paramArrayOfInt[0] == 0)
    {
      bsG();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
      }
    }, null);
  }
  
  protected final void xK()
  {
    super.xK();
    String str = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
    this.vOf = getIntent().getBooleanExtra("voip_video", true);
    if (str != null)
    {
      this.vOe = true;
      if (!str.equals("launch_type_voip")) {
        break label91;
      }
      this.vOf = true;
    }
    for (;;)
    {
      this.dru = new ArrayList();
      this.dru.addAll(s.cHO());
      this.dru.addAll(s.cHP());
      return;
      label91:
      if (str.equals("launch_type_voip_audio")) {
        this.vOf = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.VoipAddressUI
 * JD-Core Version:    0.7.0.1
 */