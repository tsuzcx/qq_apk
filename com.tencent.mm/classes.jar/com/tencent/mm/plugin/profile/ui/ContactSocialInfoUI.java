package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactSocialInfoUI
  extends MMPreference
{
  private String cDt;
  private f iLA;
  private ad lpe;
  private String pzA;
  private String pzB;
  private String pzC;
  private JSONObject pzD;
  private long pzl;
  private String pzm;
  private com.tencent.mm.plugin.account.friend.a.a pzv;
  private String pzw;
  private String pzx;
  private String pzy;
  private String pzz;
  
  private void Xb(String paramString)
  {
    AppMethodBeat.i(23450);
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    startActivity(localIntent);
    AppMethodBeat.o(23450);
  }
  
  private void ccc()
  {
    AppMethodBeat.i(23451);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.pzD.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", r.Zn());
    com.tencent.mm.bq.d.b(getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(23451);
  }
  
  private boolean q(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(23449);
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      boolean bool = l.a(paramString, getContext(), localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(23449);
      return bool;
    }
    AppMethodBeat.o(23449);
    return false;
  }
  
  private void s(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(23447);
    if ((!bo.isNullOrNil(paramString2)) && (!bo.isNullOrNil(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.iLA.atx(paramString1);
      if (paramString1 != null)
      {
        paramString1.dEM();
        if (paramBoolean) {
          paramString1.kCA = getResources().getColor(2131690214);
        }
        paramString1.setSummary(paramString2);
        paramString1.qJ(false);
      }
      AppMethodBeat.o(23447);
      return;
    }
    this.iLA.aty(paramString1);
    AppMethodBeat.o(23447);
  }
  
  public int getResourceId()
  {
    return 2131165231;
  }
  
  public void initView()
  {
    AppMethodBeat.i(23445);
    setMMTitle(2131298767);
    setBackBtn(new ContactSocialInfoUI.1(this));
    this.iLA = getPreferenceScreen();
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((bo.isNullOrNil((String)localObject1)) && (bo.isNullOrNil((String)localObject2))) {
      if (bo.isNullOrNil(this.lpe.field_username)) {
        this.pzv = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(this.cDt);
      }
    }
    for (;;)
    {
      label156:
      int i;
      if ((this.pzv == null) || (this.pzv.Al() == null) || (this.pzv.Al().length() <= 0))
      {
        ab.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.pzw);
        s("contact_info_social_mobile", this.pzx, true);
        aw.aaz();
        i = bo.g((Integer)c.Ru().get(9, null));
        this.pzl = getIntent().getLongExtra("Contact_Uin", 0L);
        this.pzm = getIntent().getStringExtra("Contact_QQNick");
        if ((this.pzl != 0L) && (i != 0))
        {
          if ((this.pzm == null) || (this.pzm.length() == 0))
          {
            long l = this.pzl;
            localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().hn(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.pzm = ((ao)localObject1).getDisplayName();
            }
          }
          this.pzy = bo.nullAsNil(this.pzm);
          this.pzy = (this.pzy + " " + new p(this.pzl).longValue());
        }
        s("contact_info_social_qq", this.pzy, true);
        localObject1 = g.Nq().getValue("LinkedinPluginClose");
        if ((!bo.isNullOrNil((String)localObject1)) && (Integer.valueOf((String)localObject1).intValue() != 0)) {
          break label834;
        }
        i = 1;
        label386:
        if ((i == 0) || (bo.isNullOrNil(this.lpe.dqV))) {
          break label839;
        }
        this.pzz = this.lpe.dqW;
        label414:
        s("contact_info_social_linkedin", this.pzz, true);
        s("contact_info_social_facebook", this.pzA, false);
        this.pzC = bo.bf(getIntent().getStringExtra("verify_gmail"), "");
        this.pzB = bo.bf(getIntent().getStringExtra("profileName"), bo.aqf(this.pzC));
        if ((bo.isNullOrNil(this.pzC)) || (bo.isNullOrNil(this.pzB))) {
          break label849;
        }
        s("contact_info_social_googlecontacts", this.pzB + '\n' + this.pzC, false);
        label539:
        if (!r.Zn().equals(this.lpe.field_username)) {
          break label863;
        }
        aw.aaz();
        localObject1 = (String)c.Ru().get(ac.a.yAI, null);
        ab.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (bo.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        this.pzD = new JSONObject((String)localObject1);
        if (this.pzD != null)
        {
          s("contact_info_social_weishop", this.pzD.optString("ShopName"), true);
          AppMethodBeat.o(23445);
          return;
          this.pzv = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(this.lpe.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.pzv = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject1);
          if ((this.pzv != null) && (this.pzv.Al() != null) && (this.pzv.Al().length() > 0)) {
            continue;
          }
          this.pzv = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa((String)localObject2);
          if ((this.pzv == null) || (this.pzv.Al() == null)) {
            continue;
          }
          this.pzv.Al().length();
          continue;
          this.pzx = (bo.nullAsNil(this.pzv.apZ()) + " " + bo.nullAsNil(this.pzv.aqf()).replace(" ", ""));
          break label156;
          label834:
          i = 0;
          break label386;
          label839:
          this.pzz = "";
          break label414;
          label849:
          s("contact_info_social_googlecontacts", "", false);
          break label539;
          label863:
          localObject1 = this.lpe.dqY;
          ab.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.pzD = null;
        }
        s("contact_info_social_weishop", "", false);
        AppMethodBeat.o(23445);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(23444);
    super.onCreate(paramBundle);
    this.cDt = bo.nullAsNil(getIntent().getStringExtra("Contact_User"));
    aw.aaz();
    this.lpe = c.YA().arw(this.cDt);
    initView();
    AppMethodBeat.o(23444);
  }
  
  public boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(23448);
    paramf = paramPreference.mKey;
    ab.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.pzv != null) && (this.lpe != null)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(23448);
      return false;
      aw.aaz();
      if (c.YA().arr(this.pzv.getUsername()))
      {
        if ((this.pzv != null) && (!bo.isNullOrNil(this.pzv.fsf))) {}
        for (paramf = getResources().getStringArray(2131755043);; paramf = getResources().getStringArray(2131755044))
        {
          paramPreference = paramf;
          if (com.tencent.mm.plugin.profile.b.gmP.BT())
          {
            paramf = bo.P(paramf);
            paramf.add(getResources().getString(2131298275));
            paramPreference = (String[])paramf.toArray(new String[paramf.size()]);
            com.tencent.mm.plugin.report.service.h.qsU.e(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
          }
          com.tencent.mm.ui.base.h.a(this, null, paramPreference, null, new ContactSocialInfoUI.2(this, paramPreference));
          break;
        }
      }
      if ((this.pzx != null) && (this.pzx.length() != 0))
      {
        int i = this.pzx.lastIndexOf(' ') + 1;
        if (i > 0)
        {
          Xb(this.pzx.substring(i));
          continue;
          if (!paramf.equals("contact_info_social_qq")) {
            if (paramf.equals("contact_info_social_linkedin"))
            {
              paramf = this.lpe.dqX;
              if (bo.isNullOrNil(paramf))
              {
                ab.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
              }
              else
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf);
                paramPreference.putExtra("geta8key_username", r.Zn());
                com.tencent.mm.bq.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
              }
            }
            else if ((!paramf.equals("contact_info_social_facebook")) && (!paramf.equals("contact_info_social_googlecontacts")) && (paramf.equals("contact_info_social_weishop")) && (this.pzD != null))
            {
              aw.aaz();
              if (c.Ru().get(ac.a.yBk, null) == null) {
                com.tencent.mm.ui.base.h.a(this, 2131298769, 2131297087, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(23443);
                    ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                    aw.aaz();
                    c.Ru().set(ac.a.yBk, Integer.valueOf(1));
                    AppMethodBeat.o(23443);
                  }
                }, null);
              } else {
                ccc();
              }
            }
          }
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI
 * JD-Core Version:    0.7.0.1
 */