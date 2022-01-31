package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R.i;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class h
  implements com.tencent.mm.pluginsdk.b.a
{
  Context context;
  private String dmT;
  u dnL;
  private f dnn;
  private ad dnp;
  private int fhj;
  private boolean mVI;
  private boolean mVJ;
  private int mXi;
  ContactListExpandPreference mXj;
  
  public h(Context paramContext)
  {
    this.context = paramContext;
    this.mXj = new ContactListExpandPreference(paramContext, 0);
  }
  
  public final boolean a(f paramf, ad paramad, boolean paramBoolean, int paramInt)
  {
    if (paramad != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bk.pm(paramad.field_username).length() <= 0) {
        break label353;
      }
      bool = true;
      label28:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label359;
      }
    }
    label353:
    label359:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.dnn = paramf;
      this.dnp = paramad;
      this.mVI = paramBoolean;
      this.fhj = paramInt;
      this.mVJ = ((Activity)this.context).getIntent().getBooleanExtra("User_Verify", false);
      this.mXi = ((Activity)this.context).getIntent().getIntExtra("Kdel_from", -1);
      this.dmT = paramad.field_username;
      au.Hx();
      this.dnL = c.FF().io(this.dmT);
      this.dnn.removeAll();
      paramf = new PreferenceSmallCategory(this.context);
      this.dnn.a(paramf);
      this.mXj.setKey("roominfo_contact_anchor");
      this.dnn.a(this.mXj);
      paramf = new PreferenceCategory(this.context);
      this.dnn.a(paramf);
      paramf = new NormalUserFooterPreference(this.context);
      paramf.setLayoutResource(R.i.contact_info_footer_normal);
      paramf.setKey("contact_info_footer_normal");
      if (paramf.a(this.dnp, "", this.mVI, this.mVJ, false, this.fhj, this.mXi, false, false, 0L, "")) {
        this.dnn.a(paramf);
      }
      this.mXj.a(this.dnn, this.mXj.mKey);
      paramf = m.gK(this.dmT);
      this.mXj.lS(false).lT(false);
      this.mXj.s(this.dmT, paramf);
      this.mXj.a(new h.1(this));
      return true;
      bool = false;
      break;
      bool = false;
      break label28;
    }
  }
  
  public final boolean awZ()
  {
    NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.dnn.add("contact_info_footer_normal");
    if (localNormalUserFooterPreference != null) {
      localNormalUserFooterPreference.awZ();
    }
    return true;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean xQ(String paramString)
  {
    y.d("MicroMsg.ContactWidgetGroupCard", "handleEvent " + paramString);
    au.Hx();
    paramString = c.Fw().abl(paramString);
    if ((paramString == null) || ((int)paramString.dBe <= 0)) {
      return true;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.context, ContactInfoUI.class);
    localIntent.putExtra("Contact_User", paramString.field_username);
    this.context.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.h
 * JD-Core Version:    0.7.0.1
 */