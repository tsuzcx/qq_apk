package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R.c;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.a.o;
import com.tencent.mm.br.d;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactSocialInfoUI
  extends MMPreference
{
  private String bVI;
  private f hcp;
  private ad jgl;
  private String mWA;
  private String mWB;
  private String mWC;
  private String mWD;
  private String mWE;
  private String mWF;
  private String mWG;
  private JSONObject mWH;
  private long mWq;
  private String mWr;
  private com.tencent.mm.plugin.account.friend.a.a mWz;
  
  private void KS(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:" + paramString));
    startActivity(localIntent);
  }
  
  private void bsw()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.mWH.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", q.Gj());
    d.b(this.mController.uMN, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
  }
  
  private boolean o(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      return com.tencent.mm.plugin.account.friend.a.l.a(paramString, this.mController.uMN, localByteArrayOutputStream.toByteArray());
    }
    return false;
  }
  
  private void p(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!bk.bl(paramString2)) && (!bk.bl(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.hcp.add(paramString1);
      if (paramString1 != null)
      {
        paramString1.vcV = true;
        paramString1.vcX = 5;
        if (paramBoolean) {
          paramString1.izu = getResources().getColor(R.e.link_color);
        }
        paramString1.setSummary(paramString2);
        paramString1.nf(false);
      }
      return;
    }
    this.hcp.ade(paramString1);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    paramf = paramPreference.mKey;
    y.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.mWz != null) && (this.jgl != null)) {}
    }
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            return false;
            au.Hx();
            if (c.Fw().abg(this.mWz.getUsername()))
            {
              if ((this.mWz != null) && (!bk.bl(this.mWz.ebN))) {}
              for (paramf = getResources().getStringArray(R.c.profile_alert_all);; paramf = getResources().getStringArray(R.c.profile_alert_short))
              {
                paramPreference = paramf;
                if (com.tencent.mm.plugin.profile.a.eUS.tp())
                {
                  paramf = bk.G(paramf);
                  paramf.add(getResources().getString(R.l.chatting_phone_download_wxpb));
                  paramPreference = (String[])paramf.toArray(new String[paramf.size()]);
                  com.tencent.mm.plugin.report.service.h.nFQ.f(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
                }
                com.tencent.mm.ui.base.h.a(this, null, paramPreference, null, new ContactSocialInfoUI.2(this, paramPreference));
                return false;
              }
            }
          } while ((this.mWB == null) || (this.mWB.length() == 0));
          i = this.mWB.lastIndexOf(' ') + 1;
        } while (i <= 0);
        KS(this.mWB.substring(i));
        return false;
      } while (paramf.equals("contact_info_social_qq"));
      if (paramf.equals("contact_info_social_linkedin"))
      {
        paramf = this.jgl.cCN;
        if (bk.bl(paramf))
        {
          y.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
          return false;
        }
        paramPreference = new Intent();
        paramPreference.putExtra("rawUrl", paramf);
        paramPreference.putExtra("geta8key_username", q.Gj());
        d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
        return false;
      }
    } while ((paramf.equals("contact_info_social_facebook")) || (paramf.equals("contact_info_social_googlecontacts")) || (!paramf.equals("contact_info_social_weishop")) || (this.mWH == null));
    au.Hx();
    if (c.Dz().get(ac.a.urk, null) == null)
    {
      com.tencent.mm.ui.base.h.a(this, R.l.contact_info_social_weishop_jump_alert, R.l.app_tip, new ContactSocialInfoUI.4(this), null);
      return false;
    }
    bsw();
    return false;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.contact_info_social_title);
    setBackBtn(new ContactSocialInfoUI.1(this));
    this.hcp = this.vdd;
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((bk.bl((String)localObject1)) && (bk.bl((String)localObject2))) {
      if (bk.bl(this.jgl.field_username)) {
        this.mWz = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(this.bVI);
      }
    }
    for (;;)
    {
      label150:
      int i;
      if ((this.mWz == null) || (this.mWz.Wv() == null) || (this.mWz.Wv().length() <= 0))
      {
        y.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.mWA);
        p("contact_info_social_mobile", this.mWB, true);
        au.Hx();
        i = bk.g((Integer)c.Dz().get(9, null));
        this.mWq = getIntent().getLongExtra("Contact_Uin", 0L);
        this.mWr = getIntent().getStringExtra("Contact_QQNick");
        if ((this.mWq != 0L) && (i != 0))
        {
          if ((this.mWr == null) || (this.mWr.length() == 0))
          {
            long l = this.mWq;
            localObject2 = com.tencent.mm.plugin.account.b.getQQListStg().cr(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.mWr = ((com.tencent.mm.plugin.account.friend.a.ao)localObject1).getDisplayName();
            }
          }
          this.mWC = bk.pm(this.mWr);
          this.mWC = (this.mWC + " " + new o(this.mWq).longValue());
        }
        p("contact_info_social_qq", this.mWC, true);
        localObject1 = g.AA().getValue("LinkedinPluginClose");
        if ((!bk.bl((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() != 0)) {
          break label822;
        }
        i = 1;
        label380:
        if ((i == 0) || (bk.bl(this.jgl.cCL))) {
          break label827;
        }
        this.mWD = this.jgl.cCM;
        label408:
        p("contact_info_social_linkedin", this.mWD, true);
        p("contact_info_social_facebook", this.mWE, false);
        this.mWG = bk.aM(getIntent().getStringExtra("verify_gmail"), "");
        this.mWF = bk.aM(getIntent().getStringExtra("profileName"), bk.aab(this.mWG));
        if ((bk.bl(this.mWG)) || (bk.bl(this.mWF))) {
          break label837;
        }
        p("contact_info_social_googlecontacts", this.mWF + '\n' + this.mWG, false);
        label533:
        if (!q.Gj().equals(this.jgl.field_username)) {
          break label851;
        }
        au.Hx();
        localObject1 = (String)c.Dz().get(ac.a.uqI, null);
        y.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (bk.bl((String)localObject1)) {}
      }
      try
      {
        this.mWH = new JSONObject((String)localObject1);
        if (this.mWH != null)
        {
          p("contact_info_social_weishop", this.mWH.optString("ShopName"), true);
          return;
          this.mWz = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(this.jgl.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.mWz = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI((String)localObject1);
          if ((this.mWz != null) && (this.mWz.Wv() != null) && (this.mWz.Wv().length() > 0)) {
            continue;
          }
          this.mWz = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI((String)localObject2);
          if ((this.mWz == null) || (this.mWz.Wv() == null)) {
            continue;
          }
          this.mWz.Wv().length();
          continue;
          this.mWB = (bk.pm(this.mWz.Wx()) + " " + bk.pm(this.mWz.WD()).replace(" ", ""));
          break label150;
          label822:
          i = 0;
          break label380;
          label827:
          this.mWD = "";
          break label408;
          label837:
          p("contact_info_social_googlecontacts", "", false);
          break label533;
          label851:
          localObject1 = this.jgl.cCO;
          y.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.mWH = null;
        }
        p("contact_info_social_weishop", "", false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.bVI = bk.pm(getIntent().getStringExtra("Contact_User"));
    au.Hx();
    this.jgl = c.Fw().abl(this.bVI);
    initView();
  }
  
  public final int xj()
  {
    return R.o.contact_social_infos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI
 * JD-Core Version:    0.7.0.1
 */