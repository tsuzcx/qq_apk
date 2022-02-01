package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
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
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements i, com.tencent.mm.pluginsdk.c.a
{
  private as contact;
  private Context context;
  private ProgressDialog iXX;
  private com.tencent.mm.ui.base.preference.f screen;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private void cQY()
  {
    AppMethodBeat.i(27740);
    d locald = g.fsa().aVb(this.contact.field_username);
    if ((locald == null) || (Util.nullAsNil(locald.getUsername()).length() <= 0))
    {
      Log.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
      AppMethodBeat.o(27740);
      return;
    }
    if (Util.nullAsNil(locald.bsH()).length() <= 0) {
      Log.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
    }
    Preference localPreference1 = this.screen.byG("contact_info_qcontact_sex");
    Preference localPreference2 = this.screen.byG("contact_info_qcontact_age");
    Preference localPreference3 = this.screen.byG("contact_info_qcontact_birthday");
    Preference localPreference4 = this.screen.byG("contact_info_qcontact_address");
    a locala = new a((byte)0);
    locala.aVc(locald.bsH());
    if (localPreference1 != null) {
      localPreference1.aF(locala.fsd());
    }
    if (localPreference2 != null) {
      localPreference2.aF(locala.fse());
    }
    if (localPreference3 != null) {
      localPreference3.aF(locala.fsg());
    }
    if (localPreference4 != null) {
      localPreference4.aF(locala.fsf());
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(27740);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(27739);
    if (paramf != null)
    {
      paramBoolean = true;
      Assert.assertTrue(paramBoolean);
      if (paramas == null) {
        break label558;
      }
      paramBoolean = true;
      label25:
      Assert.assertTrue(paramBoolean);
      Assert.assertTrue(as.bvJ(paramas.field_username));
      bh.aGY().a(140, this);
      this.contact = paramas;
      this.screen = paramf;
      paramf.auC(R.o.eXs);
      paramf = (NormalUserHeaderPreference)paramf.byG("contact_info_header_normal");
      if (paramf != null)
      {
        paramf.RqQ = "ContactWidgetQContact";
        paramf.onDetach();
        bh.beI();
        c.bbL().add(paramf);
        bh.beI();
        c.bbM().a(paramf);
        com.tencent.mm.am.q.bhz().d(paramf);
        paramf.contact = paramas;
        paramf.JpE = 0;
        paramf.BLy = null;
        paramf.RqA = paramf.iXq.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        paramf.RqJ = paramf.iXq.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        paramf.RqG = paramf.iXq.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        paramf.RqH = paramf.iXq.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        paramf.RqI = paramf.iXq.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        paramf.Hbo = paramf.iXq.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        paramf.RqK = paramf.iXq.getIntent().getStringExtra("Contact_RoomNickname");
        if (paramas.field_deleteFlag != 1) {
          break label563;
        }
        paramBoolean = true;
        label275:
        paramf.HaU = paramBoolean;
        paramf.jaK = paramf.iXq.getIntent().getStringExtra("room_name");
        if (Util.nullAsNil(paramas.field_username).length() <= 0) {
          break label568;
        }
        paramBoolean = true;
        label312:
        Assert.assertTrue("initView: contact username is null", paramBoolean);
        paramf.initView();
      }
      cQY();
      paramas = g.fsa().aVb(this.contact.field_username);
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
        paramf.cUP = -1;
        g.fsa().a(paramf);
      }
      if (paramf.Hkz == 1)
      {
        paramas = this.contact.field_username;
        if (Util.nullAsNil(paramf.bsH()).length() > 0) {
          break label573;
        }
      }
    }
    label558:
    label563:
    label568:
    label573:
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
          bh.aGY().a(paramf, 0);
          AppMethodBeat.o(27736);
        }
      });
      if (paramInt != 0)
      {
        paramas = this.context;
        this.context.getString(R.l.app_tip);
        this.iXX = h.a(paramas, this.context.getString(R.l.app_loading_data), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(27737);
            bh.aGY().a(paramf);
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
      paramBoolean = false;
      break label275;
      paramBoolean = false;
      break label312;
    }
  }
  
  public final boolean atw(String paramString)
  {
    return true;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27741);
    bh.aGY().b(140, this);
    NormalUserHeaderPreference localNormalUserHeaderPreference = (NormalUserHeaderPreference)this.screen.byG("contact_info_header_normal");
    if (localNormalUserHeaderPreference != null) {
      localNormalUserHeaderPreference.onDetach();
    }
    AppMethodBeat.o(27741);
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int i = 1;
    AppMethodBeat.i(27742);
    if (paramq.getType() != 140)
    {
      AppMethodBeat.o(27742);
      return;
    }
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
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
        if (!ac.mEX) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(R.l.fmt_http_err, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt2) }), 3000).show();
        continue;
        if (!ac.mEX) {
          break;
        }
        Toast.makeText(this.context, this.context.getString(R.l.fmt_iap_err, new Object[] { Integer.valueOf(2), Integer.valueOf(paramInt2) }), 3000).show();
      }
    }
    label183:
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = g.fsa().aVb(this.contact.field_username);
      if ((paramString != null) && (Util.nullAsNil(paramString.getUsername()).length() > 0)) {
        break label261;
      }
      Log.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.contact.field_username);
    }
    for (;;)
    {
      cQY();
      AppMethodBeat.o(27742);
      return;
      label261:
      paramString.cUP = 8;
      paramString.Hkz = 0;
      if (!g.fsa().a(this.contact.field_username, paramString)) {
        Log.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.contact.field_username);
      }
    }
  }
  
  public final class a
  {
    private String HkM = "";
    private String HkN = "";
    private String HkO = "";
    private String city = "";
    private String country = "";
    private String lLg = "";
    private String province = "";
    
    private a() {}
    
    public final void aVc(String paramString)
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
        this.HkM = ((String)paramString.get(".extinfo.sex"));
        this.HkN = ((String)paramString.get(".extinfo.age"));
        this.HkO = ((String)paramString.get(".extinfo.bd"));
        this.country = ((String)paramString.get(".extinfo.country"));
        this.province = ((String)paramString.get(".extinfo.province"));
        this.city = ((String)paramString.get(".extinfo.city"));
      }
      if ((this.HkM != null) && (this.HkM.equals("1"))) {}
      for (this.HkM = a.a(a.this).getString(R.l.sex_male);; this.HkM = a.a(a.this).getString(R.l.sex_female))
      {
        if (this.country != null) {
          this.lLg = (this.lLg + this.country + " ");
        }
        if (this.province != null) {
          this.lLg = (this.lLg + this.province + " ");
        }
        if (this.city != null) {
          this.lLg += this.city;
        }
        AppMethodBeat.o(27738);
        return;
      }
    }
    
    public final String fsd()
    {
      if (this.HkM == null) {
        return "";
      }
      return this.HkM;
    }
    
    public final String fse()
    {
      if (this.HkN == null) {
        return "";
      }
      return this.HkN;
    }
    
    public final String fsf()
    {
      if (this.lLg == null) {
        return "";
      }
      return this.lLg;
    }
    
    public final String fsg()
    {
      if (this.HkO == null) {
        return "";
      }
      return this.HkO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.ui.a
 * JD-Core Version:    0.7.0.1
 */