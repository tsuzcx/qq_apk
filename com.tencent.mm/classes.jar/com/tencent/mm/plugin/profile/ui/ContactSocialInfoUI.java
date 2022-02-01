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
import com.tencent.mm.aj.f.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.m.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  private String drG;
  private com.tencent.mm.ui.base.preference.f lZC;
  private ai piT;
  private long vJN;
  private String vJO;
  private com.tencent.mm.plugin.account.friend.a.a vJX;
  private String vJY;
  private String vJZ;
  private String vKa;
  private String vKb;
  private String vKc;
  private String vKd;
  private String vKe;
  private JSONObject vKf;
  
  private void apB(String paramString)
  {
    AppMethodBeat.i(27065);
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.aeD(), "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27065);
  }
  
  private void dqb()
  {
    AppMethodBeat.i(27066);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.vKf.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", u.axw());
    d.b(getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27066);
  }
  
  private boolean q(String paramString, Bitmap paramBitmap)
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
    if ((!bs.isNullOrNil(paramString2)) && (!bs.isNullOrNil(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.lZC.aPN(paramString1);
      if (paramString1 != null)
      {
        paramString1.fjo();
        if (paramBoolean) {
          paramString1.omy = getResources().getColor(2131100547);
        }
        paramString1.setSummary(paramString2);
        paramString1.wV(false);
      }
      AppMethodBeat.o(27062);
      return;
    }
    this.lZC.aPO(paramString1);
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
    this.lZC = getPreferenceScreen();
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((bs.isNullOrNil((String)localObject1)) && (bs.isNullOrNil((String)localObject2))) {
      if (bs.isNullOrNil(this.piT.field_username)) {
        this.vJX = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(this.drG);
      }
    }
    for (;;)
    {
      label156:
      int i;
      if ((this.vJX == null) || (this.vJX.JC() == null) || (this.vJX.JC().length() <= 0))
      {
        ac.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.vJY);
        s("contact_info_social_mobile", this.vJZ, true);
        az.ayM();
        i = bs.m((Integer)c.agA().get(9, null));
        this.vJN = getIntent().getLongExtra("Contact_Uin", 0L);
        this.vJO = getIntent().getStringExtra("Contact_QQNick");
        if ((this.vJN != 0L) && (i != 0))
        {
          if ((this.vJO == null) || (this.vJO.length() == 0))
          {
            long l = this.vJN;
            localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().qC(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.vJO = ((as)localObject1).getDisplayName();
            }
          }
          this.vKa = bs.nullAsNil(this.vJO);
          this.vKa = (this.vKa + " " + new com.tencent.mm.b.p(this.vJN).longValue());
        }
        s("contact_info_social_qq", this.vKa, true);
        localObject1 = g.ZY().getValue("LinkedinPluginClose");
        if ((!bs.isNullOrNil((String)localObject1)) && (bs.getInt((String)localObject1, 0) != 0)) {
          break label832;
        }
        i = 1;
        label384:
        if ((i == 0) || (bs.isNullOrNil(this.piT.eyh))) {
          break label837;
        }
        this.vKb = this.piT.eyi;
        label412:
        s("contact_info_social_linkedin", this.vKb, true);
        s("contact_info_social_facebook", this.vKc, false);
        this.vKe = bs.bG(getIntent().getStringExtra("verify_gmail"), "");
        this.vKd = bs.bG(getIntent().getStringExtra("profileName"), bs.aLI(this.vKe));
        if ((bs.isNullOrNil(this.vKe)) || (bs.isNullOrNil(this.vKd))) {
          break label847;
        }
        s("contact_info_social_googlecontacts", this.vKd + '\n' + this.vKe, false);
        label537:
        if (!u.axw().equals(this.piT.field_username)) {
          break label861;
        }
        az.ayM();
        localObject1 = (String)c.agA().get(ah.a.GGT, null);
        ac.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (bs.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        this.vKf = new JSONObject((String)localObject1);
        if (this.vKf != null)
        {
          s("contact_info_social_weishop", this.vKf.optString("ShopName"), true);
          AppMethodBeat.o(27061);
          return;
          this.vJX = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(this.piT.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.vJX = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject1);
          if ((this.vJX != null) && (this.vJX.JC() != null) && (this.vJX.JC().length() > 0)) {
            continue;
          }
          this.vJX = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject2);
          if ((this.vJX == null) || (this.vJX.JC() == null)) {
            continue;
          }
          this.vJX.JC().length();
          continue;
          this.vJZ = (bs.nullAsNil(this.vJX.aPm()) + " " + bs.nullAsNil(this.vJX.aPr()).replace(" ", ""));
          break label156;
          label832:
          i = 0;
          break label384;
          label837:
          this.vKb = "";
          break label412;
          label847:
          s("contact_info_social_googlecontacts", "", false);
          break label537;
          label861:
          localObject1 = this.piT.eyk;
          ac.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.vKf = null;
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
    this.drG = bs.nullAsNil(getIntent().getStringExtra("Contact_User"));
    az.ayM();
    this.piT = c.awB().aNt(this.drG);
    initView();
    AppMethodBeat.o(27060);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(27063);
    paramf = paramPreference.mKey;
    ac.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.vJX != null) && (this.piT != null)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(27063);
      return false;
      az.ayM();
      if (c.awB().aNo(this.vJX.getUsername()))
      {
        if ((this.vJX != null) && (!bs.isNullOrNil(this.vJX.huz))) {}
        for (paramf = getResources().getStringArray(2130903076);; paramf = getResources().getStringArray(2130903077))
        {
          paramPreference = paramf;
          if (com.tencent.mm.plugin.profile.b.iyy.Lo())
          {
            paramf = bs.S(paramf);
            paramf.add(getResources().getString(2131757266));
            paramPreference = (String[])paramf.toArray(new String[paramf.size()]);
            com.tencent.mm.plugin.report.service.h.wUl.f(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
          }
          com.tencent.mm.ui.base.h.a(this, null, paramPreference, null, new h.c()
          {
            public final void kG(int paramAnonymousInt)
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
                  if ((ContactSocialInfoUI.c(ContactSocialInfoUI.this) != null) && (!bs.isNullOrNil(ContactSocialInfoUI.c(ContactSocialInfoUI.this).huz)))
                  {
                    ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.b(ContactSocialInfoUI.this).field_username, ContactSocialInfoUI.c(ContactSocialInfoUI.this).huz);
                    AppMethodBeat.o(27057);
                    return;
                  }
                  localObject = new Intent();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("fromScene", 2);
                  ((Intent)localObject).putExtra("reportArgs", localBundle);
                  com.tencent.mm.plugin.profile.b.iyx.j((Intent)localObject, ContactSocialInfoUI.this);
                }
              }
            }
          });
          break;
        }
      }
      if ((this.vJZ != null) && (this.vJZ.length() != 0))
      {
        int i = this.vJZ.lastIndexOf(' ') + 1;
        if (i > 0)
        {
          apB(this.vJZ.substring(i));
          continue;
          if (!paramf.equals("contact_info_social_qq")) {
            if (paramf.equals("contact_info_social_linkedin"))
            {
              paramf = this.piT.eyj;
              if (bs.isNullOrNil(paramf))
              {
                ac.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
              }
              else
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf);
                paramPreference.putExtra("geta8key_username", u.axw());
                d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
              }
            }
            else if ((!paramf.equals("contact_info_social_facebook")) && (!paramf.equals("contact_info_social_googlecontacts")) && (paramf.equals("contact_info_social_weishop")) && (this.vKf != null))
            {
              az.ayM();
              if (c.agA().get(ah.a.GHv, null) == null) {
                com.tencent.mm.ui.base.h.a(this, 2131757832, 2131755906, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27059);
                    ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                    az.ayM();
                    c.agA().set(ah.a.GHv, Integer.valueOf(1));
                    AppMethodBeat.o(27059);
                  }
                }, null);
              } else {
                dqb();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactSocialInfoUI
 * JD-Core Version:    0.7.0.1
 */