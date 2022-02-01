package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.e;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.al.g, com.tencent.mm.pluginsdk.b.a
{
  private af contact;
  Context context;
  private ProgressDialog fpP;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bRv()
  {
    AppMethodBeat.i(27740);
    d locald = com.tencent.mm.plugin.qmessage.a.g.ddJ().akO(this.contact.field_username);
    if ((locald == null) || (bt.nullAsNil(locald.getUsername()).length() <= 0))
    {
      ad.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      AppMethodBeat.o(27740);
      return;
    }
    if (bt.nullAsNil(locald.ddH()).length() <= 0) {
      ad.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference1 = this.screen.aKk("contact_info_qcontact_sex");
    Preference localPreference2 = this.screen.aKk("contact_info_qcontact_age");
    Preference localPreference3 = this.screen.aKk("contact_info_qcontact_birthday");
    Preference localPreference4 = this.screen.aKk("contact_info_qcontact_address");
    a locala = new a((byte)0);
    locala.parse(locald.ddH());
    if (localPreference1 != null) {
      localPreference1.setSummary(locala.ddM());
    }
    if (localPreference2 != null) {
      localPreference2.setSummary(locala.ddN());
    }
    if (localPreference3 != null) {
      localPreference3.setSummary(locala.ddP());
    }
    if (localPreference4 != null) {
      localPreference4.setSummary(locala.ddO());
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(27740);
  }
  
  public final boolean SN(String paramString)
  {
    return true;
  }
  
  public final boolean a(final f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27739);
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paramaf == null) {
        break label328;
      }
      paramBoolean = true;
      label25:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(af.aHG(paramaf.field_username));
      az.aeS().a(140, this);
      this.contact = paramaf;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951649);
      paramf = (NormalUserHeaderPreference)paramf.aKk("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.Cjf = "ContactWidgetQContact";
        paramf.a(paramaf, 0, null);
      }
      bRv();
      paramaf = com.tencent.mm.plugin.qmessage.a.g.ddJ().akO(this.contact.field_username);
      if (paramaf != null)
      {
        paramf = paramaf;
        if (bt.nullAsNil(paramaf.getUsername()).length() > 0) {}
      }
      else
      {
        ad.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
        paramf = new d();
        paramf.username = this.contact.field_username;
        paramf.dtM = -1;
        com.tencent.mm.plugin.qmessage.a.g.ddJ().a(paramf);
      }
      if (paramf.uKc == 1)
      {
        paramaf = this.contact.field_username;
        if (bt.nullAsNil(paramf.ddH()).length() > 0) {
          break label333;
        }
      }
    }
    label328:
    label333:
    for (paramInt = 1;; paramInt = 0)
    {
      paramBoolean = bool;
      if (bt.nullAsNil(paramaf).length() > 0) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      paramf = new HashSet();
      paramf.add(paramaf);
      paramf = new b(paramf);
      new ap().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27736);
          az.aeS().a(paramf, 0);
          AppMethodBeat.o(27736);
        }
      });
      if (paramInt != 0)
      {
        paramaf = this.context;
        this.context.getString(2131755906);
        this.fpP = h.b(paramaf, this.context.getString(2131755805), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(27737);
            az.aeS().a(paramf);
            AppMethodBeat.o(27737);
          }
        });
      }
      AppMethodBeat.o(27739);
      return true;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label25;
    }
  }
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27741);
    az.aeS().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.screen.aKk("contact_info_header_normal");
    if (localNormalUserHeaderPreference != null) {
      localNormalUserHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27741);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(27742);
    if (paramn.getType() != 140)
    {
      AppMethodBeat.o(27742);
      return;
    }
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
      switch (paramInt1)
      {
      default: 
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label183;
        }
        AppMethodBeat.o(27742);
        return;
        if (!ab.hUQ) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
        continue;
        if (!ab.hUQ) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      }
    }
    label183:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.qmessage.a.g.ddJ().akO(this.contact.field_username);
      if ((paramString != null) && (bt.nullAsNil(paramString.getUsername()).length() > 0)) {
        break label261;
      }
      ad.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
    }
    for (;;)
    {
      bRv();
      AppMethodBeat.o(27742);
      return;
      label261:
      paramString.dtM = 8;
      paramString.uKc = 0;
      if (!com.tencent.mm.plugin.qmessage.a.g.ddJ().a(this.contact.field_username, paramString)) {
        ad.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
      }
    }
  }
  
  public final class a
  {
    private String country = "";
    private String evA = "";
    private String evz = "";
    private String hdQ = "";
    private String uKp = "";
    private String uKq = "";
    private String uKr = "";
    
    private a() {}
    
    public final String ddM()
    {
      if (this.uKp == null) {
        return "";
      }
      return this.uKp;
    }
    
    public final String ddN()
    {
      if (this.uKq == null) {
        return "";
      }
      return this.uKq;
    }
    
    public final String ddO()
    {
      if (this.hdQ == null) {
        return "";
      }
      return this.hdQ;
    }
    
    public final String ddP()
    {
      if (this.uKr == null) {
        return "";
      }
      return this.uKr;
    }
    
    public final void parse(String paramString)
    {
      AppMethodBeat.i(27738);
      if (bt.nullAsNil(paramString).length() <= 0)
      {
        ad.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
        AppMethodBeat.o(27738);
        return;
      }
      paramString = bw.K(paramString, "extinfo");
      if (paramString != null)
      {
        this.uKp = ((String)paramString.get(".extinfo.sex"));
        this.uKq = ((String)paramString.get(".extinfo.age"));
        this.uKr = ((String)paramString.get(".extinfo.bd"));
        this.country = ((String)paramString.get(".extinfo.country"));
        this.evz = ((String)paramString.get(".extinfo.province"));
        this.evA = ((String)paramString.get(".extinfo.city"));
      }
      if ((this.uKp != null) && (this.uKp.equals("1"))) {}
      for (this.uKp = a.this.context.getString(2131763533);; this.uKp = a.this.context.getString(2131763532))
      {
        if (this.country != null) {
          this.hdQ = (this.hdQ + this.country + " ");
        }
        if (this.evz != null) {
          this.hdQ = (this.hdQ + this.evz + " ");
        }
        if (this.evA != null) {
          this.hdQ += this.evA;
        }
        AppMethodBeat.o(27738);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a
 * JD-Core Version:    0.7.0.1
 */