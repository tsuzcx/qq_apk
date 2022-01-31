package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI
  extends MMBaseSelectContactUI
{
  private boolean AfM;
  private boolean AfN;
  private com.tencent.mm.sdk.b.c AfO;
  private List<String> ejc;
  private String talker;
  
  public VoipAddressUI()
  {
    AppMethodBeat.i(33972);
    this.AfM = false;
    this.AfN = false;
    this.talker = "";
    this.AfO = new VoipAddressUI.1(this);
    AppMethodBeat.o(33972);
  }
  
  private void ccv()
  {
    AppMethodBeat.i(33975);
    boolean bool = b.a(this, "android.permission.RECORD_AUDIO", 82, "", "");
    ab.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(33975);
      return;
    }
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = this.talker;
    localux.cLs.context = this;
    if (this.AfM) {}
    for (int i = 2;; i = 1)
    {
      localux.cLs.cLm = 3;
      com.tencent.mm.plugin.report.service.h.qsU.e(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.ymk.l(localux);
      hideVKB();
      AppMethodBeat.o(33975);
      return;
    }
  }
  
  private void ccw()
  {
    AppMethodBeat.i(33976);
    boolean bool = b.a(this, "android.permission.CAMERA", 19, "", "");
    ab.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(33976);
      return;
    }
    bool = b.a(this, "android.permission.RECORD_AUDIO", 19, "", "");
    ab.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bo.dtY(), this });
    if (!bool)
    {
      AppMethodBeat.o(33976);
      return;
    }
    ux localux = new ux();
    localux.cLs.cut = 5;
    localux.cLs.talker = this.talker;
    localux.cLs.context = this;
    if (this.AfM) {}
    for (int i = 2;; i = 1)
    {
      localux.cLs.cLm = 2;
      com.tencent.mm.plugin.report.service.h.qsU.e(11033, new Object[] { Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0) });
      com.tencent.mm.sdk.b.a.ymk.l(localux);
      hideVKB();
      AppMethodBeat.o(33976);
      return;
    }
  }
  
  public static void iq(Context paramContext)
  {
    int i = 0;
    AppMethodBeat.i(33980);
    boolean bool;
    if (1 == bo.getInt(g.Nq().getValue("VOIPCallType"), 0))
    {
      bool = true;
      Intent localIntent = new Intent(paramContext, VoipAddressUI.class);
      localIntent.putExtra("Add_address_titile", paramContext.getString(2131296502));
      localIntent.putExtra("voip_video", bool);
      paramContext.startActivity(localIntent);
      paramContext = com.tencent.mm.plugin.report.service.h.qsU;
      if (!bool) {
        break label106;
      }
    }
    for (;;)
    {
      paramContext.e(11034, new Object[] { Integer.valueOf(1), Integer.valueOf(i) });
      AppMethodBeat.o(33980);
      return;
      bool = false;
      break;
      label106:
      i = 1;
    }
  }
  
  protected final void Kc()
  {
    AppMethodBeat.i(33977);
    super.Kc();
    String str = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
    this.AfN = getIntent().getBooleanExtra("voip_video", true);
    if (str != null)
    {
      this.AfM = true;
      if (!str.equals("launch_type_voip")) {
        break label99;
      }
      this.AfN = true;
    }
    for (;;)
    {
      this.ejc = new ArrayList();
      this.ejc.addAll(t.dMg());
      this.ejc.addAll(t.dMh());
      AppMethodBeat.o(33977);
      return;
      label99:
      if (str.equals("launch_type_voip_audio")) {
        this.AfN = false;
      }
    }
  }
  
  protected final boolean apa()
  {
    return false;
  }
  
  protected final boolean apb()
  {
    return true;
  }
  
  protected final String apc()
  {
    AppMethodBeat.i(33983);
    String str2 = getIntent().getStringExtra("Add_address_titile");
    String str1 = str2;
    if (!bo.isNullOrNil(str2)) {
      str1 = getString(2131296502);
    }
    AppMethodBeat.o(33983);
    return str1;
  }
  
  protected final p apd()
  {
    AppMethodBeat.i(33978);
    Object localObject = new c.a();
    ((c.a)localObject).Abg = true;
    ((c.a)localObject).Abf = true;
    localObject = new c(this, this.ejc, false, (c.a)localObject);
    AppMethodBeat.o(33978);
    return localObject;
  }
  
  protected final n ape()
  {
    AppMethodBeat.i(33979);
    r localr = new r(this, this.ejc, false, this.scene);
    AppMethodBeat.o(33979);
    return localr;
  }
  
  public final int[] bOp()
  {
    return new int[] { 131072 };
  }
  
  protected final void bOq()
  {
    AppMethodBeat.i(33982);
    if (this.AfM)
    {
      Intent localIntent = new Intent(this, LauncherUI.class);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    hideVKB();
    finish();
    AppMethodBeat.o(33982);
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(33974);
    com.tencent.mm.ui.contact.a.a locala = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(33974);
      return;
    }
    if (locala.contact == null)
    {
      AppMethodBeat.o(33974);
      return;
    }
    this.talker = locala.contact.field_username;
    if (this.AfN)
    {
      ccw();
      AppMethodBeat.o(33974);
      return;
    }
    ccv();
    AppMethodBeat.o(33974);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(33973);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.b.a.ymk.c(this.AfO);
    AppMethodBeat.o(33973);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33981);
    com.tencent.mm.sdk.b.a.ymk.d(this.AfO);
    super.onDestroy();
    AppMethodBeat.o(33981);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(33984);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      ab.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(33984);
      return;
    }
    ab.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33984);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        ccw();
        AppMethodBeat.o(33984);
        return;
      }
      if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
      for (paramInt = 2131302067;; paramInt = 2131302075)
      {
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.h.a(this, getString(paramInt), getString(2131302083), getString(2131300996), getString(2131297837), false, new VoipAddressUI.2(this), new VoipAddressUI.3(this));
        }
        AppMethodBeat.o(33984);
        return;
      }
      if (paramArrayOfInt[0] == 0)
      {
        ccv();
        AppMethodBeat.o(33984);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302073), getString(2131302083), getString(2131300996), getString(2131297837), false, new VoipAddressUI.4(this), null);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.VoipAddressUI
 * JD-Core Version:    0.7.0.1
 */