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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactSocialInfoUI
  extends MMPreference
{
  private String dtV;
  private com.tencent.mm.ui.base.preference.f lxI;
  private af oFt;
  private long uAU;
  private String uAV;
  private com.tencent.mm.plugin.account.friend.a.a uBe;
  private String uBf;
  private String uBg;
  private String uBh;
  private String uBi;
  private String uBj;
  private String uBk;
  private String uBl;
  private JSONObject uBm;
  
  private void akC(String paramString)
  {
    AppMethodBeat.i(27065);
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.adn(), "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27065);
  }
  
  private void dct()
  {
    AppMethodBeat.i(27066);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.uBm.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", u.aqG());
    d.b(getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27066);
  }
  
  private boolean r(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(27064);
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      boolean bool = com.tencent.mm.plugin.account.friend.a.l.a(paramString, getContext(), localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(27064);
      return bool;
    }
    AppMethodBeat.o(27064);
    return false;
  }
  
  private void s(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(27062);
    if ((!bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.lxI.aKk(paramString1);
      if (paramString1 != null)
      {
        paramString1.eTC();
        if (paramBoolean) {
          paramString1.nJy = getResources().getColor(2131100547);
        }
        paramString1.setSummary(paramString2);
        paramString1.vR(false);
      }
      AppMethodBeat.o(27062);
      return;
    }
    this.lxI.aKl(paramString1);
    AppMethodBeat.o(27062);
  }
  
  public int getResourceId()
  {
    return 2131951667;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27061);
    setMMTitle(2131757830);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27056);
        ContactSocialInfoUI.this.finish();
        AppMethodBeat.o(27056);
        return true;
      }
    });
    this.lxI = getPreferenceScreen();
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((bt.isNullOrNil((String)localObject1)) && (bt.isNullOrNil((String)localObject2))) {
      if (bt.isNullOrNil(this.oFt.field_username)) {
        this.uBe = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(this.dtV);
      }
    }
    for (;;)
    {
      label156:
      int i;
      if ((this.uBe == null) || (this.uBe.JS() == null) || (this.uBe.JS().length() <= 0))
      {
        ad.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.uBf);
        s("contact_info_social_mobile", this.uBg, true);
        az.arV();
        i = bt.l((Integer)c.afk().get(9, null));
        this.uAU = getIntent().getLongExtra("Contact_Uin", 0L);
        this.uAV = getIntent().getStringExtra("Contact_QQNick");
        if ((this.uAU != 0L) && (i != 0))
        {
          if ((this.uAV == null) || (this.uAV.length() == 0))
          {
            long l = this.uAU;
            localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().mN(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.uAV = ((as)localObject1).getDisplayName();
            }
          }
          this.uBh = bt.nullAsNil(this.uAV);
          this.uBh = (this.uBh + " " + new com.tencent.mm.b.p(this.uAU).longValue());
        }
        s("contact_info_social_qq", this.uBh, true);
        localObject1 = g.Zd().getValue("LinkedinPluginClose");
        if ((!bt.isNullOrNil((String)localObject1)) && (bt.getInt((String)localObject1, 0) != 0)) {
          break label832;
        }
        i = 1;
        label384:
        if ((i == 0) || (bt.isNullOrNil(this.oFt.evK))) {
          break label837;
        }
        this.uBi = this.oFt.evL;
        label412:
        s("contact_info_social_linkedin", this.uBi, true);
        s("contact_info_social_facebook", this.uBj, false);
        this.uBl = bt.by(getIntent().getStringExtra("verify_gmail"), "");
        this.uBk = bt.by(getIntent().getStringExtra("profileName"), bt.aGr(this.uBl));
        if ((bt.isNullOrNil(this.uBl)) || (bt.isNullOrNil(this.uBk))) {
          break label847;
        }
        s("contact_info_social_googlecontacts", this.uBk + '\n' + this.uBl, false);
        label537:
        if (!u.aqG().equals(this.oFt.field_username)) {
          break label861;
        }
        az.arV();
        localObject1 = (String)c.afk().get(ae.a.Fje, null);
        ad.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (bt.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        this.uBm = new JSONObject((String)localObject1);
        if (this.uBm != null)
        {
          s("contact_info_social_weishop", this.uBm.optString("ShopName"), true);
          AppMethodBeat.o(27061);
          return;
          this.uBe = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(this.oFt.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.uBe = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject1);
          if ((this.uBe != null) && (this.uBe.JS() != null) && (this.uBe.JS().length() > 0)) {
            continue;
          }
          this.uBe = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject2);
          if ((this.uBe == null) || (this.uBe.JS() == null)) {
            continue;
          }
          this.uBe.JS().length();
          continue;
          this.uBg = (bt.nullAsNil(this.uBe.aIv()) + " " + bt.nullAsNil(this.uBe.aIA()).replace(" ", ""));
          break label156;
          label832:
          i = 0;
          break label384;
          label837:
          this.uBi = "";
          break label412;
          label847:
          s("contact_info_social_googlecontacts", "", false);
          break label537;
          label861:
          localObject1 = this.oFt.evN;
          ad.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.uBm = null;
        }
        s("contact_info_social_weishop", "", false);
        AppMethodBeat.o(27061);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27060);
    super.onCreate(paramBundle);
    this.dtV = bt.nullAsNil(getIntent().getStringExtra("Contact_User"));
    az.arV();
    this.oFt = c.apM().aHY(this.dtV);
    initView();
    AppMethodBeat.o(27060);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(27063);
    paramf = paramPreference.mKey;
    ad.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.uBe != null) && (this.oFt != null)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(27063);
      return false;
      az.arV();
      if (c.apM().aHT(this.uBe.getUsername()))
      {
        if ((this.uBe != null) && (!bt.isNullOrNil(this.uBe.gUa))) {}
        for (paramf = getResources().getStringArray(2130903076);; paramf = getResources().getStringArray(2130903077))
        {
          paramPreference = paramf;
          if (com.tencent.mm.plugin.profile.b.hYu.Lq())
          {
            paramf = bt.S(paramf);
            paramf.add(getResources().getString(2131757266));
            paramPreference = (String[])paramf.toArray(new String[paramf.size()]);
            com.tencent.mm.plugin.report.service.h.vKh.f(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
          }
          com.tencent.mm.ui.base.h.a(this, null, paramPreference, null, new h.c()
          {
            public final void kM(int paramAnonymousInt)
            {
              AppMethodBeat.i(27057);
              switch (paramAnonymousInt)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(27057);
                return;
                if ((ContactSocialInfoUI.a(ContactSocialInfoUI.this) == null) || (ContactSocialInfoUI.a(ContactSocialInfoUI.this).length() == 0))
                {
                  AppMethodBeat.o(27057);
                  return;
                }
                paramAnonymousInt = ContactSocialInfoUI.a(ContactSocialInfoUI.this).lastIndexOf(' ') + 1;
                if (paramAnonymousInt > 0)
                {
                  ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.a(ContactSocialInfoUI.this).substring(paramAnonymousInt));
                  AppMethodBeat.o(27057);
                  return;
                  if ((ContactSocialInfoUI.a(ContactSocialInfoUI.this) == null) || (ContactSocialInfoUI.a(ContactSocialInfoUI.this).length() == 0))
                  {
                    AppMethodBeat.o(27057);
                    return;
                  }
                  paramAnonymousInt = ContactSocialInfoUI.a(ContactSocialInfoUI.this).lastIndexOf(' ');
                  Object localObject = ContactSocialInfoUI.a(ContactSocialInfoUI.this).substring(0, paramAnonymousInt);
                  if ((localObject == null) || (((String)localObject).length() == 0))
                  {
                    AppMethodBeat.o(27057);
                    return;
                  }
                  w.c(ContactSocialInfoUI.b(ContactSocialInfoUI.this), ((String)localObject).trim());
                  AppMethodBeat.o(27057);
                  return;
                  if ((paramPreference == null) || (paramPreference.length <= 2) || (ContactSocialInfoUI.c(ContactSocialInfoUI.this) == null) || (ContactSocialInfoUI.b(ContactSocialInfoUI.this) == null))
                  {
                    AppMethodBeat.o(27057);
                    return;
                  }
                  if ((ContactSocialInfoUI.c(ContactSocialInfoUI.this) != null) && (!bt.isNullOrNil(ContactSocialInfoUI.c(ContactSocialInfoUI.this).gUa)))
                  {
                    ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.b(ContactSocialInfoUI.this).field_username, ContactSocialInfoUI.c(ContactSocialInfoUI.this).gUa);
                    AppMethodBeat.o(27057);
                    return;
                  }
                  localObject = new Intent();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("fromScene", 2);
                  ((Intent)localObject).putExtra("reportArgs", localBundle);
                  com.tencent.mm.plugin.profile.b.hYt.j((Intent)localObject, ContactSocialInfoUI.this);
                }
              }
            }
          });
          break;
        }
      }
      if ((this.uBg != null) && (this.uBg.length() != 0))
      {
        int i = this.uBg.lastIndexOf(' ') + 1;
        if (i > 0)
        {
          akC(this.uBg.substring(i));
          continue;
          if (!paramf.equals("contact_info_social_qq")) {
            if (paramf.equals("contact_info_social_linkedin"))
            {
              paramf = this.oFt.evM;
              if (bt.isNullOrNil(paramf))
              {
                ad.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
              }
              else
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf);
                paramPreference.putExtra("geta8key_username", u.aqG());
                d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
              }
            }
            else if ((!paramf.equals("contact_info_social_facebook")) && (!paramf.equals("contact_info_social_googlecontacts")) && (paramf.equals("contact_info_social_weishop")) && (this.uBm != null))
            {
              az.arV();
              if (c.afk().get(ae.a.FjG, null) == null) {
                com.tencent.mm.ui.base.h.a(this, 2131757832, 2131755906, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27059);
                    ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                    az.arV();
                    c.afk().set(ae.a.FjG, Integer.valueOf(1));
                    AppMethodBeat.o(27059);
                  }
                }, null);
              } else {
                dct();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI
 * JD-Core Version:    0.7.0.1
 */