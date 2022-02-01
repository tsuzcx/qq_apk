package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.e;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ak.g, com.tencent.mm.pluginsdk.b.a
{
  private ai contact;
  Context context;
  private ProgressDialog fts;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bYK()
  {
    AppMethodBeat.i(27740);
    d locald = com.tencent.mm.plugin.qmessage.a.g.drr().apN(this.contact.field_username);
    if ((locald == null) || (bs.nullAsNil(locald.getUsername()).length() <= 0))
    {
      ac.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      AppMethodBeat.o(27740);
      return;
    }
    if (bs.nullAsNil(locald.drp()).length() <= 0) {
      ac.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference1 = this.screen.aPN("contact_info_qcontact_sex");
    Preference localPreference2 = this.screen.aPN("contact_info_qcontact_age");
    Preference localPreference3 = this.screen.aPN("contact_info_qcontact_birthday");
    Preference localPreference4 = this.screen.aPN("contact_info_qcontact_address");
    a locala = new a((byte)0);
    locala.parse(locald.drp());
    if (localPreference1 != null) {
      localPreference1.setSummary(locala.dru());
    }
    if (localPreference2 != null) {
      localPreference2.setSummary(locala.drv());
    }
    if (localPreference3 != null) {
      localPreference3.setSummary(locala.drx());
    }
    if (localPreference4 != null) {
      localPreference4.setSummary(locala.drw());
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(27740);
  }
  
  public final boolean WZ(String paramString)
  {
    return true;
  }
  
  public final boolean a(final f paramf, ai paramai, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27739);
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paramai == null) {
        break label328;
      }
      paramBoolean = true;
      label25:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ai.aNb(paramai.field_username));
      az.agi().a(140, this);
      this.contact = paramai;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951649);
      paramf = (NormalUserHeaderPreference)paramf.aPN("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.DBw = "ContactWidgetQContact";
        paramf.a(paramai, 0, null);
      }
      bYK();
      paramai = com.tencent.mm.plugin.qmessage.a.g.drr().apN(this.contact.field_username);
      if (paramai != null)
      {
        paramf = paramai;
        if (bs.nullAsNil(paramai.getUsername()).length() > 0) {}
      }
      else
      {
        ac.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
        paramf = new d();
        paramf.username = this.contact.field_username;
        paramf.drx = -1;
        com.tencent.mm.plugin.qmessage.a.g.drr().a(paramf);
      }
      if (paramf.vST == 1)
      {
        paramai = this.contact.field_username;
        if (bs.nullAsNil(paramf.drp()).length() > 0) {
          break label333;
        }
      }
    }
    label328:
    label333:
    for (paramInt = 1;; paramInt = 0)
    {
      paramBoolean = bool;
      if (bs.nullAsNil(paramai).length() > 0) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      paramf = new HashSet();
      paramf.add(paramai);
      paramf = new b(paramf);
      new ao().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27736);
          az.agi().a(paramf, 0);
          AppMethodBeat.o(27736);
        }
      });
      if (paramInt != 0)
      {
        paramai = this.context;
        this.context.getString(2131755906);
        this.fts = h.b(paramai, this.context.getString(2131755805), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(27737);
            az.agi().a(paramf);
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
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27741);
    az.agi().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.screen.aPN("contact_info_header_normal");
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
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
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
        if (!ab.iuU) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
        continue;
        if (!ab.iuU) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      }
    }
    label183:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = com.tencent.mm.plugin.qmessage.a.g.drr().apN(this.contact.field_username);
      if ((paramString != null) && (bs.nullAsNil(paramString.getUsername()).length() > 0)) {
        break label261;
      }
      ac.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
    }
    for (;;)
    {
      bYK();
      AppMethodBeat.o(27742);
      return;
      label261:
      paramString.drx = 8;
      paramString.vST = 0;
      if (!com.tencent.mm.plugin.qmessage.a.g.drr().a(this.contact.field_username, paramString)) {
        ac.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
      }
    }
  }
  
  public final class a
  {
    private String country = "";
    private String exV = "";
    private String exW = "";
    private String hEt = "";
    private String vTg = "";
    private String vTh = "";
    private String vTi = "";
    
    private a() {}
    
    public final String dru()
    {
      if (this.vTg == null) {
        return "";
      }
      return this.vTg;
    }
    
    public final String drv()
    {
      if (this.vTh == null) {
        return "";
      }
      return this.vTh;
    }
    
    public final String drw()
    {
      if (this.hEt == null) {
        return "";
      }
      return this.hEt;
    }
    
    public final String drx()
    {
      if (this.vTi == null) {
        return "";
      }
      return this.vTi;
    }
    
    public final void parse(String paramString)
    {
      AppMethodBeat.i(27738);
      if (bs.nullAsNil(paramString).length() <= 0)
      {
        ac.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
        AppMethodBeat.o(27738);
        return;
      }
      paramString = bv.L(paramString, "extinfo");
      if (paramString != null)
      {
        this.vTg = ((String)paramString.get(".extinfo.sex"));
        this.vTh = ((String)paramString.get(".extinfo.age"));
        this.vTi = ((String)paramString.get(".extinfo.bd"));
        this.country = ((String)paramString.get(".extinfo.country"));
        this.exV = ((String)paramString.get(".extinfo.province"));
        this.exW = ((String)paramString.get(".extinfo.city"));
      }
      if ((this.vTg != null) && (this.vTg.equals("1"))) {}
      for (this.vTg = a.this.context.getString(2131763533);; this.vTg = a.this.context.getString(2131763532))
      {
        if (this.country != null) {
          this.hEt = (this.hEt + this.country + " ");
        }
        if (this.exV != null) {
          this.hEt = (this.hEt + this.exV + " ");
        }
        if (this.exW != null) {
          this.hEt += this.exW;
        }
        AppMethodBeat.o(27738);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a
 * JD-Core Version:    0.7.0.1
 */