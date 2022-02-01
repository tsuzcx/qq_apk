package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.e;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements i, com.tencent.mm.pluginsdk.b.a
{
  private as contact;
  Context context;
  private ProgressDialog gtM;
  private f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cCt()
  {
    AppMethodBeat.i(27740);
    d locald = g.eFZ().aKB(this.contact.field_username);
    if ((locald == null) || (Util.nullAsNil(locald.getUsername()).length() <= 0))
    {
      Log.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      AppMethodBeat.o(27740);
      return;
    }
    if (Util.nullAsNil(locald.bjg()).length() <= 0) {
      Log.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference1 = this.screen.bmg("contact_info_qcontact_sex");
    Preference localPreference2 = this.screen.bmg("contact_info_qcontact_age");
    Preference localPreference3 = this.screen.bmg("contact_info_qcontact_birthday");
    Preference localPreference4 = this.screen.bmg("contact_info_qcontact_address");
    a locala = new a((byte)0);
    locala.parse(locald.bjg());
    if (localPreference1 != null) {
      localPreference1.setSummary(locala.eGc());
    }
    if (localPreference2 != null) {
      localPreference2.setSummary(locala.eGd());
    }
    if (localPreference3 != null) {
      localPreference3.setSummary(locala.eGf());
    }
    if (localPreference4 != null) {
      localPreference4.setSummary(locala.eGe());
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(27740);
  }
  
  public final boolean a(final f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27739);
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paramas == null) {
        break label328;
      }
      paramBoolean = true;
      label25:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(as.bjo(paramas.field_username));
      bg.azz().a(140, this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2132017187);
      paramf = (NormalUserHeaderPreference)paramf.bmg("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.Kqa = "ContactWidgetQContact";
        paramf.a(paramas, 0, null);
      }
      cCt();
      paramas = g.eFZ().aKB(this.contact.field_username);
      if (paramas != null)
      {
        paramf = paramas;
        if (Util.nullAsNil(paramas.getUsername()).length() > 0) {}
      }
      else
      {
        Log.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
        paramf = new d();
        paramf.username = this.contact.field_username;
        paramf.cSx = -1;
        g.eFZ().a(paramf);
      }
      if (paramf.Bqg == 1)
      {
        paramas = this.contact.field_username;
        if (Util.nullAsNil(paramf.bjg()).length() > 0) {
          break label333;
        }
      }
    }
    label328:
    label333:
    for (paramInt = 1;; paramInt = 0)
    {
      paramBoolean = bool;
      if (Util.nullAsNil(paramas).length() > 0) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      paramf = new HashSet();
      paramf.add(paramas);
      paramf = new b(paramf);
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27736);
          bg.azz().a(paramf, 0);
          AppMethodBeat.o(27736);
        }
      });
      if (paramInt != 0)
      {
        paramas = this.context;
        this.context.getString(2131755998);
        this.gtM = h.a(paramas, this.context.getString(2131755887), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(27737);
            bg.azz().a(paramf);
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
  
  public final boolean alD(String paramString)
  {
    return true;
  }
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27741);
    bg.azz().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.screen.bmg("contact_info_header_normal");
    if (localNormalUserHeaderPreference != null) {
      localNormalUserHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27741);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 1;
    AppMethodBeat.i(27742);
    if (paramq.getType() != 140)
    {
      AppMethodBeat.o(27742);
      return;
    }
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
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
        if (!ac.jNP) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131760825, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
        continue;
        if (!ac.jNP) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131760826, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      }
    }
    label183:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = g.eFZ().aKB(this.contact.field_username);
      if ((paramString != null) && (Util.nullAsNil(paramString.getUsername()).length() > 0)) {
        break label261;
      }
      Log.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
    }
    for (;;)
    {
      cCt();
      AppMethodBeat.o(27742);
      return;
      label261:
      paramString.cSx = 8;
      paramString.Bqg = 0;
      if (!g.eFZ().a(this.contact.field_username, paramString)) {
        Log.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
      }
    }
  }
  
  public final class a
  {
    private String Bqt = "";
    private String Bqu = "";
    private String Bqv = "";
    private String country = "";
    private String fuJ = "";
    private String fuK = "";
    private String iUO = "";
    
    private a() {}
    
    public final String eGc()
    {
      if (this.Bqt == null) {
        return "";
      }
      return this.Bqt;
    }
    
    public final String eGd()
    {
      if (this.Bqu == null) {
        return "";
      }
      return this.Bqu;
    }
    
    public final String eGe()
    {
      if (this.iUO == null) {
        return "";
      }
      return this.iUO;
    }
    
    public final String eGf()
    {
      if (this.Bqv == null) {
        return "";
      }
      return this.Bqv;
    }
    
    public final void parse(String paramString)
    {
      AppMethodBeat.i(27738);
      if (Util.nullAsNil(paramString).length() <= 0)
      {
        Log.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
        AppMethodBeat.o(27738);
        return;
      }
      paramString = XmlParser.parseXml(paramString, "extinfo", null);
      if (paramString != null)
      {
        this.Bqt = ((String)paramString.get(".extinfo.sex"));
        this.Bqu = ((String)paramString.get(".extinfo.age"));
        this.Bqv = ((String)paramString.get(".extinfo.bd"));
        this.country = ((String)paramString.get(".extinfo.country"));
        this.fuJ = ((String)paramString.get(".extinfo.province"));
        this.fuK = ((String)paramString.get(".extinfo.city"));
      }
      if ((this.Bqt != null) && (this.Bqt.equals("1"))) {}
      for (this.Bqt = a.this.context.getString(2131765721);; this.Bqt = a.this.context.getString(2131765720))
      {
        if (this.country != null) {
          this.iUO = (this.iUO + this.country + " ");
        }
        if (this.fuJ != null) {
          this.iUO = (this.iUO + this.fuJ + " ");
        }
        if (this.fuK != null) {
          this.iUO += this.fuK;
        }
        AppMethodBeat.o(27738);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a
 * JD-Core Version:    0.7.0.1
 */