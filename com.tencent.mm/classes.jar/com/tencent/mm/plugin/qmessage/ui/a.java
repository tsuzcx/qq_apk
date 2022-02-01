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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.e;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.al.f, com.tencent.mm.pluginsdk.b.a
{
  private am contact;
  Context context;
  private ProgressDialog fMu;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cdo()
  {
    AppMethodBeat.i(27740);
    d locald = g.dBT().auT(this.contact.field_username);
    if ((locald == null) || (bt.nullAsNil(locald.getUsername()).length() <= 0))
    {
      ad.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      AppMethodBeat.o(27740);
      return;
    }
    if (bt.nullAsNil(locald.dBR()).length() <= 0) {
      ad.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference1 = this.screen.aVD("contact_info_qcontact_sex");
    Preference localPreference2 = this.screen.aVD("contact_info_qcontact_age");
    Preference localPreference3 = this.screen.aVD("contact_info_qcontact_birthday");
    Preference localPreference4 = this.screen.aVD("contact_info_qcontact_address");
    a locala = new a((byte)0);
    locala.parse(locald.dBR());
    if (localPreference1 != null) {
      localPreference1.setSummary(locala.dBW());
    }
    if (localPreference2 != null) {
      localPreference2.setSummary(locala.dBX());
    }
    if (localPreference3 != null) {
      localPreference3.setSummary(locala.dBZ());
    }
    if (localPreference4 != null) {
      localPreference4.setSummary(locala.dBY());
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(27740);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27739);
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paramam == null) {
        break label328;
      }
      paramBoolean = true;
      label25:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(am.aSP(paramam.field_username));
      ba.aiU().a(140, this);
      this.contact = paramam;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131951649);
      paramf = (NormalUserHeaderPreference)paramf.aVD("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.FgD = "ContactWidgetQContact";
        paramf.a(paramam, 0, null);
      }
      cdo();
      paramam = g.dBT().auT(this.contact.field_username);
      if (paramam != null)
      {
        paramf = paramam;
        if (bt.nullAsNil(paramam.getUsername()).length() > 0) {}
      }
      else
      {
        ad.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
        paramf = new d();
        paramf.username = this.contact.field_username;
        paramf.dDp = -1;
        g.dBT().a(paramf);
      }
      if (paramf.xad == 1)
      {
        paramam = this.contact.field_username;
        if (bt.nullAsNil(paramf.dBR()).length() > 0) {
          break label333;
        }
      }
    }
    label328:
    label333:
    for (paramInt = 1;; paramInt = 0)
    {
      paramBoolean = bool;
      if (bt.nullAsNil(paramam).length() > 0) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      paramf = new HashSet();
      paramf.add(paramam);
      paramf = new b(paramf);
      new ap().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27736);
          ba.aiU().a(paramf, 0);
          AppMethodBeat.o(27736);
        }
      });
      if (paramInt != 0)
      {
        paramam = this.context;
        this.context.getString(2131755906);
        this.fMu = h.b(paramam, this.context.getString(2131755805), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(27737);
            ba.aiU().a(paramf);
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
  
  public final boolean aaG(String paramString)
  {
    return true;
  }
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27741);
    ba.aiU().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.screen.aVD("contact_info_header_normal");
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
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
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
        if (!ac.iOb) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131759510, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
        continue;
        if (!ac.iOb) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131759511, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      }
    }
    label183:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = g.dBT().auT(this.contact.field_username);
      if ((paramString != null) && (bt.nullAsNil(paramString.getUsername()).length() > 0)) {
        break label261;
      }
      ad.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
    }
    for (;;)
    {
      cdo();
      AppMethodBeat.o(27742);
      return;
      label261:
      paramString.dDp = 8;
      paramString.xad = 0;
      if (!g.dBT().a(this.contact.field_username, paramString)) {
        ad.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
      }
    }
  }
  
  public final class a
  {
    private String country = "";
    private String ePu = "";
    private String ePv = "";
    private String hWY = "";
    private String xaq = "";
    private String xar = "";
    private String xas = "";
    
    private a() {}
    
    public final String dBW()
    {
      if (this.xaq == null) {
        return "";
      }
      return this.xaq;
    }
    
    public final String dBX()
    {
      if (this.xar == null) {
        return "";
      }
      return this.xar;
    }
    
    public final String dBY()
    {
      if (this.hWY == null) {
        return "";
      }
      return this.hWY;
    }
    
    public final String dBZ()
    {
      if (this.xas == null) {
        return "";
      }
      return this.xas;
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
      paramString = bw.M(paramString, "extinfo");
      if (paramString != null)
      {
        this.xaq = ((String)paramString.get(".extinfo.sex"));
        this.xar = ((String)paramString.get(".extinfo.age"));
        this.xas = ((String)paramString.get(".extinfo.bd"));
        this.country = ((String)paramString.get(".extinfo.country"));
        this.ePu = ((String)paramString.get(".extinfo.province"));
        this.ePv = ((String)paramString.get(".extinfo.city"));
      }
      if ((this.xaq != null) && (this.xaq.equals("1"))) {}
      for (this.xaq = a.this.context.getString(2131763533);; this.xaq = a.this.context.getString(2131763532))
      {
        if (this.country != null) {
          this.hWY = (this.hWY + this.country + " ");
        }
        if (this.ePu != null) {
          this.hWY = (this.hWY + this.ePu + " ");
        }
        if (this.ePv != null) {
          this.hWY += this.ePv;
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