package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.e;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ai.f, com.tencent.mm.pluginsdk.b.a
{
  private ad contact;
  Context context;
  private ProgressDialog eeN;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void bkc()
  {
    AppMethodBeat.i(24100);
    d locald = g.cdr().Xl(this.contact.field_username);
    if ((locald == null) || (bo.nullAsNil(locald.getUsername()).length() <= 0))
    {
      ab.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      AppMethodBeat.o(24100);
      return;
    }
    if (bo.nullAsNil(locald.cdp()).length() <= 0) {
      ab.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference1 = this.screen.atx("contact_info_qcontact_sex");
    Preference localPreference2 = this.screen.atx("contact_info_qcontact_age");
    Preference localPreference3 = this.screen.atx("contact_info_qcontact_birthday");
    Preference localPreference4 = this.screen.atx("contact_info_qcontact_address");
    a.a locala = new a.a(this, (byte)0);
    locala.parse(locald.cdp());
    if (localPreference1 != null) {
      localPreference1.setSummary(locala.cdu());
    }
    if (localPreference2 != null) {
      localPreference2.setSummary(locala.cdv());
    }
    if (localPreference3 != null) {
      localPreference3.setSummary(locala.cdx());
    }
    if (localPreference4 != null) {
      localPreference4.setSummary(locala.cdw());
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(24100);
  }
  
  public final boolean Ke(String paramString)
  {
    return true;
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(24099);
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paramad == null) {
        break label328;
      }
      paramBoolean = true;
      label25:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ad.are(paramad.field_username));
      aw.Rc().a(140, this);
      this.contact = paramad;
      this.screen = paramf;
      paramf.addPreferencesFromResource(2131165215);
      paramf = (NormalUserHeaderPreference)paramf.atx("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.wbz = "ContactWidgetQContact";
        paramf.a(paramad, 0, null);
      }
      bkc();
      paramad = g.cdr().Xl(this.contact.field_username);
      if (paramad != null)
      {
        paramf = paramad;
        if (bo.nullAsNil(paramad.getUsername()).length() > 0) {}
      }
      else
      {
        ab.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
        paramf = new d();
        paramf.username = this.contact.field_username;
        paramf.bsY = -1;
        g.cdr().a(paramf);
      }
      if (paramf.pHM == 1)
      {
        paramad = this.contact.field_username;
        if (bo.nullAsNil(paramf.cdp()).length() > 0) {
          break label333;
        }
      }
    }
    label328:
    label333:
    for (paramInt = 1;; paramInt = 0)
    {
      paramBoolean = bool;
      if (bo.nullAsNil(paramad).length() > 0) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      paramf = new HashSet();
      paramf.add(paramad);
      paramf = new b(paramf);
      new ak().post(new a.1(this, paramf));
      if (paramInt != 0)
      {
        paramad = this.context;
        this.context.getString(2131297087);
        this.eeN = h.b(paramad, this.context.getString(2131296988), true, new a.2(this, paramf));
      }
      AppMethodBeat.o(24099);
      return true;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label25;
    }
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(24101);
    aw.Rc().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.screen.atx("contact_info_header_normal");
    if (localNormalUserHeaderPreference != null) {
      localNormalUserHeaderPreference.onDetach();
    }
    AppMethodBeat.o(24101);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(24102);
    if (paramm.getType() != 140)
    {
      AppMethodBeat.o(24102);
      return;
    }
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
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
        AppMethodBeat.o(24102);
        return;
        if (!ae.gjY) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131300043, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
        continue;
        if (!ae.gjY) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(2131300044, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      }
    }
    label183:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = g.cdr().Xl(this.contact.field_username);
      if ((paramString != null) && (bo.nullAsNil(paramString.getUsername()).length() > 0)) {
        break label261;
      }
      ab.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
    }
    for (;;)
    {
      bkc();
      AppMethodBeat.o(24102);
      return;
      label261:
      paramString.bsY = 8;
      paramString.pHM = 0;
      if (!g.cdr().a(this.contact.field_username, paramString)) {
        ab.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a
 * JD-Core Version:    0.7.0.1
 */