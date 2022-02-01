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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.e;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ak.f, com.tencent.mm.pluginsdk.b.a
{
  private an contact;
  Context context;
  private ProgressDialog fOC;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void ceD()
  {
    AppMethodBeat.i(27740);
    d locald = g.dFk().awi(this.contact.field_username);
    if ((locald == null) || (bu.nullAsNil(locald.getUsername()).length() <= 0))
    {
      ae.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      AppMethodBeat.o(27740);
      return;
    }
    if (bu.nullAsNil(locald.dFi()).length() <= 0) {
      ae.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference1 = this.screen.aXe("contact_info_qcontact_sex");
    Preference localPreference2 = this.screen.aXe("contact_info_qcontact_age");
    Preference localPreference3 = this.screen.aXe("contact_info_qcontact_birthday");
    Preference localPreference4 = this.screen.aXe("contact_info_qcontact_address");
    a locala = new a((byte)0);
    locala.parse(locald.dFi());
    if (localPreference1 != null) {
      localPreference1.setSummary(locala.dFn());
    }
    if (localPreference2 != null) {
      localPreference2.setSummary(locala.dFo());
    }
    if (localPreference3 != null) {
      localPreference3.setSummary(locala.dFq());
    }
    if (localPreference4 != null) {
      localPreference4.setSummary(locala.dFp());
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(27740);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27739);
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paraman == null) {
        break label328;
      }
      paramBoolean = true;
      label25:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(an.aUp(paraman.field_username));
      bc.ajj().a(140, this);
      this.contact = paraman;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951649);
      paramf = (NormalUserHeaderPreference)paramf.aXe("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.Fzb = "ContactWidgetQContact";
        paramf.a(paraman, 0, null);
      }
      ceD();
      paraman = g.dFk().awi(this.contact.field_username);
      if (paraman != null)
      {
        paramf = paraman;
        if (bu.nullAsNil(paraman.getUsername()).length() > 0) {}
      }
      else
      {
        ae.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
        paramf = new d();
        paramf.username = this.contact.field_username;
        paramf.dEu = -1;
        g.dFk().a(paramf);
      }
      if (paramf.xpU == 1)
      {
        paraman = this.contact.field_username;
        if (bu.nullAsNil(paramf.dFi()).length() > 0) {
          break label333;
        }
      }
    }
    label328:
    label333:
    for (paramInt = 1;; paramInt = 0)
    {
      paramBoolean = bool;
      if (bu.nullAsNil(paraman).length() > 0) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      paramf = new HashSet();
      paramf.add(paraman);
      paramf = new b(paramf);
      new aq().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27736);
          bc.ajj().a(paramf, 0);
          AppMethodBeat.o(27736);
        }
      });
      if (paramInt != 0)
      {
        paraman = this.context;
        this.context.getString(2131755906);
        this.fOC = h.b(paraman, this.context.getString(2131755805), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(27737);
            bc.ajj().a(paramf);
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
  
  public final boolean abx(String paramString)
  {
    return true;
  }
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27741);
    bc.ajj().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.screen.aXe("contact_info_header_normal");
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
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
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
        if (!ac.iQV) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
        continue;
        if (!ac.iQV) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      }
    }
    label183:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = g.dFk().awi(this.contact.field_username);
      if ((paramString != null) && (bu.nullAsNil(paramString.getUsername()).length() > 0)) {
        break label261;
      }
      ae.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
    }
    for (;;)
    {
      ceD();
      AppMethodBeat.o(27742);
      return;
      label261:
      paramString.dEu = 8;
      paramString.xpU = 0;
      if (!g.dFk().a(this.contact.field_username, paramString)) {
        ae.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
      }
    }
  }
  
  public final class a
  {
    private String country = "";
    private String eRf = "";
    private String eRg = "";
    private String hZQ = "";
    private String xqh = "";
    private String xqi = "";
    private String xqj = "";
    
    private a() {}
    
    public final String dFn()
    {
      if (this.xqh == null) {
        return "";
      }
      return this.xqh;
    }
    
    public final String dFo()
    {
      if (this.xqi == null) {
        return "";
      }
      return this.xqi;
    }
    
    public final String dFp()
    {
      if (this.hZQ == null) {
        return "";
      }
      return this.hZQ;
    }
    
    public final String dFq()
    {
      if (this.xqj == null) {
        return "";
      }
      return this.xqj;
    }
    
    public final void parse(String paramString)
    {
      AppMethodBeat.i(27738);
      if (bu.nullAsNil(paramString).length() <= 0)
      {
        ae.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
        AppMethodBeat.o(27738);
        return;
      }
      paramString = bx.M(paramString, "extinfo");
      if (paramString != null)
      {
        this.xqh = ((String)paramString.get(".extinfo.sex"));
        this.xqi = ((String)paramString.get(".extinfo.age"));
        this.xqj = ((String)paramString.get(".extinfo.bd"));
        this.country = ((String)paramString.get(".extinfo.country"));
        this.eRf = ((String)paramString.get(".extinfo.province"));
        this.eRg = ((String)paramString.get(".extinfo.city"));
      }
      if ((this.xqh != null) && (this.xqh.equals("1"))) {}
      for (this.xqh = a.this.context.getString(2131763533);; this.xqh = a.this.context.getString(2131763532))
      {
        if (this.country != null) {
          this.hZQ = (this.hZQ + this.country + " ");
        }
        if (this.eRf != null) {
          this.hZQ = (this.hZQ + this.eRf + " ");
        }
        if (this.eRg != null) {
          this.hZQ += this.eRg;
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