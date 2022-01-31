package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.e;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements com.tencent.mm.ah.f, com.tencent.mm.pluginsdk.b.a
{
  Context context;
  private ProgressDialog dnm;
  private com.tencent.mm.ui.base.preference.f dnn;
  private ad dnp;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void awY()
  {
    Object localObject = g.btk().Lc(this.dnp.field_username);
    if ((localObject == null) || (bk.pm(((d)localObject).getUsername()).length() <= 0))
    {
      y.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      return;
    }
    if (bk.pm(((d)localObject).bti()).length() <= 0) {
      y.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference4 = this.dnn.add("contact_info_qcontact_sex");
    Preference localPreference3 = this.dnn.add("contact_info_qcontact_age");
    Preference localPreference2 = this.dnn.add("contact_info_qcontact_birthday");
    Preference localPreference1 = this.dnn.add("contact_info_qcontact_address");
    a.a locala = new a.a(this, (byte)0);
    localObject = ((d)localObject).bti();
    if (bk.pm((String)localObject).length() <= 0)
    {
      y.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
      if (localPreference4 != null)
      {
        if (locala.ncH != null) {
          break label535;
        }
        localObject = "";
        label158:
        localPreference4.setSummary((CharSequence)localObject);
      }
      if (localPreference3 != null)
      {
        if (locala.ncI != null) {
          break label544;
        }
        localObject = "";
        label180:
        localPreference3.setSummary((CharSequence)localObject);
      }
      if (localPreference2 != null)
      {
        if (locala.ncJ != null) {
          break label553;
        }
        localObject = "";
        label201:
        localPreference2.setSummary((CharSequence)localObject);
      }
      if (localPreference1 != null) {
        if (locala.ekZ != null) {
          break label562;
        }
      }
    }
    label535:
    label544:
    label553:
    label562:
    for (localObject = "";; localObject = locala.ekZ)
    {
      localPreference1.setSummary((CharSequence)localObject);
      this.dnn.notifyDataSetChanged();
      return;
      localObject = bn.s((String)localObject, "extinfo");
      if (localObject != null)
      {
        locala.ncH = ((String)((Map)localObject).get(".extinfo.sex"));
        locala.ncI = ((String)((Map)localObject).get(".extinfo.age"));
        locala.ncJ = ((String)((Map)localObject).get(".extinfo.bd"));
        locala.country = ((String)((Map)localObject).get(".extinfo.country"));
        locala.cCA = ((String)((Map)localObject).get(".extinfo.province"));
        locala.cCB = ((String)((Map)localObject).get(".extinfo.city"));
      }
      if ((locala.ncH != null) && (locala.ncH.equals("1"))) {}
      for (locala.ncH = locala.ncG.context.getString(R.l.sex_male);; locala.ncH = locala.ncG.context.getString(R.l.sex_female))
      {
        if (locala.country != null) {
          locala.ekZ = (locala.ekZ + locala.country + " ");
        }
        if (locala.cCA != null) {
          locala.ekZ = (locala.ekZ + locala.cCA + " ");
        }
        if (locala.cCB == null) {
          break;
        }
        locala.ekZ += locala.cCB;
        break;
      }
      localObject = locala.ncH;
      break label158;
      localObject = locala.ncI;
      break label180;
      localObject = locala.ncJ;
      break label201;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paramad == null) {
        break label319;
      }
      paramBoolean = true;
      label19:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(ad.aaT(paramad.field_username));
      au.Dk().a(140, this);
      this.dnp = paramad;
      this.dnn = paramf;
      paramf.addPreferencesFromResource(R.o.contact_info_pref_qcontact);
      paramf = (NormalUserHeaderPreference)paramf.add("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.siY = "ContactWidgetQContact";
        paramf.a(paramad, 0, null);
      }
      awY();
      paramad = g.btk().Lc(this.dnp.field_username);
      if (paramad != null)
      {
        paramf = paramad;
        if (bk.pm(paramad.getUsername()).length() > 0) {}
      }
      else
      {
        y.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
        paramf = new d();
        paramf.username = this.dnp.field_username;
        paramf.bcw = -1;
        g.btk().a(paramf);
      }
      if (paramf.ncu == 1)
      {
        paramad = this.dnp.field_username;
        if (bk.pm(paramf.bti()).length() > 0) {
          break label324;
        }
      }
    }
    label319:
    label324:
    for (paramInt = 1;; paramInt = 0)
    {
      paramBoolean = bool;
      if (bk.pm(paramad).length() > 0) {
        paramBoolean = true;
      }
      Assert.assertTrue(paramBoolean);
      paramf = new HashSet();
      paramf.add(paramad);
      paramf = new b(paramf);
      new ah().post(new a.1(this, paramf));
      if (paramInt != 0)
      {
        paramad = this.context;
        this.context.getString(R.l.app_tip);
        this.dnm = h.b(paramad, this.context.getString(R.l.app_loading_data), true, new a.2(this, paramf));
      }
      return true;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label19;
    }
  }
  
  public final boolean awZ()
  {
    au.Dk().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.dnn.add("contact_info_header_normal");
    if (localNormalUserHeaderPreference != null) {
      localNormalUserHeaderPreference.onDetach();
    }
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    if (paramm.getType() != 140) {}
    label59:
    do
    {
      do
      {
        return;
        if (this.dnm == null) {
          break;
        }
        this.dnm.dismiss();
        this.dnm = null;
        switch (paramInt1)
        {
        default: 
          i = 0;
        }
      } while (i != 0);
    } while ((paramInt1 != 0) || (paramInt2 != 0));
    paramString = g.btk().Lc(this.dnp.field_username);
    if ((paramString == null) || (bk.pm(paramString.getUsername()).length() <= 0)) {
      y.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.dnp.field_username);
    }
    for (;;)
    {
      awY();
      return;
      if (!ae.eSd) {
        break;
      }
      Toast.makeText(this.context, this.context.getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
      break label59;
      if (!ae.eSd) {
        break;
      }
      Toast.makeText(this.context, this.context.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      break label59;
      paramString.bcw = 8;
      paramString.ncu = 0;
      if (!g.btk().a(this.dnp.field_username, paramString)) {
        y.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.dnp.field_username);
      }
    }
  }
  
  public final boolean xQ(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a
 * JD-Core Version:    0.7.0.1
 */