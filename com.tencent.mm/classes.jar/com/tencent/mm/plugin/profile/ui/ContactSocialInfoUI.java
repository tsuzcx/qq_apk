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
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactSocialInfoUI
  extends MMPreference
{
  private long BeA;
  private String BeB;
  private com.tencent.mm.plugin.account.friend.a.a BeK;
  private String BeL;
  private String BeM;
  private String BeN;
  private String BeO;
  private String BeP;
  private String BeQ;
  private String BeR;
  private JSONObject BeS;
  private String dWq;
  private com.tencent.mm.ui.base.preference.f nRm;
  private com.tencent.mm.storage.as rjX;
  
  private void aKo(String paramString)
  {
    AppMethodBeat.i(27065);
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.axQ(), "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27065);
  }
  
  private void eEo()
  {
    AppMethodBeat.i(27066);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.BeS.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", z.aTY());
    com.tencent.mm.br.c.b(getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(27066);
  }
  
  private boolean q(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(27064);
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      boolean bool = l.a(paramString, getContext(), localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(27064);
      return bool;
    }
    AppMethodBeat.o(27064);
    return false;
  }
  
  private void u(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(27062);
    if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.nRm.bmg(paramString1);
      if (paramString1 != null)
      {
        paramString1.gLI();
        if (paramBoolean) {
          paramString1.qlp = getResources().getColor(2131100685);
        }
        paramString1.setSummary(paramString2);
        paramString1.BC(false);
      }
      AppMethodBeat.o(27062);
      return;
    }
    this.nRm.bmi(paramString1);
    AppMethodBeat.o(27062);
  }
  
  public int getResourceId()
  {
    return 2132017205;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27061);
    setMMTitle(2131758070);
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
    this.nRm = getPreferenceScreen();
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((Util.isNullOrNil((String)localObject1)) && (Util.isNullOrNil((String)localObject2))) {
      if (Util.isNullOrNil(this.rjX.field_username)) {
        this.BeK = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.dWq);
      }
    }
    for (;;)
    {
      label156:
      int i;
      if ((this.BeK == null) || (this.BeK.getMd5() == null) || (this.BeK.getMd5().length() <= 0))
      {
        Log.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.BeL);
        u("contact_info_social_mobile", this.BeM, true);
        bg.aVF();
        i = Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(9, null));
        this.BeA = getIntent().getLongExtra("Contact_Uin", 0L);
        this.BeB = getIntent().getStringExtra("Contact_QQNick");
        if ((this.BeA != 0L) && (i != 0))
        {
          if ((this.BeB == null) || (this.BeB.length() == 0))
          {
            long l = this.BeA;
            localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().AT(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.BeB = ((com.tencent.mm.plugin.account.friend.a.as)localObject1).getDisplayName();
            }
          }
          this.BeN = Util.nullAsNil(this.BeB);
          this.BeN = (this.BeN + " " + new com.tencent.mm.b.p(this.BeA).longValue());
        }
        u("contact_info_social_qq", this.BeN, true);
        localObject1 = com.tencent.mm.n.h.aqJ().getValue("LinkedinPluginClose");
        if ((!Util.isNullOrNil((String)localObject1)) && (Util.getInt((String)localObject1, 0) != 0)) {
          break label832;
        }
        i = 1;
        label384:
        if ((i == 0) || (Util.isNullOrNil(this.rjX.fuT))) {
          break label837;
        }
        this.BeO = this.rjX.fuU;
        label412:
        u("contact_info_social_linkedin", this.BeO, true);
        u("contact_info_social_facebook", this.BeP, false);
        this.BeR = Util.nullAs(getIntent().getStringExtra("verify_gmail"), "");
        this.BeQ = Util.nullAs(getIntent().getStringExtra("profileName"), Util.subStringEmail(this.BeR));
        if ((Util.isNullOrNil(this.BeR)) || (Util.isNullOrNil(this.BeQ))) {
          break label847;
        }
        u("contact_info_social_googlecontacts", this.BeQ + '\n' + this.BeR, false);
        label537:
        if (!z.aTY().equals(this.rjX.field_username)) {
          break label861;
        }
        bg.aVF();
        localObject1 = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVK, null);
        Log.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (Util.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        this.BeS = new JSONObject((String)localObject1);
        if (this.BeS != null)
        {
          u("contact_info_social_weishop", this.BeS.optString("ShopName"), true);
          AppMethodBeat.o(27061);
          return;
          this.BeK = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.rjX.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.BeK = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject1);
          if ((this.BeK != null) && (this.BeK.getMd5() != null) && (this.BeK.getMd5().length() > 0)) {
            continue;
          }
          this.BeK = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject2);
          if ((this.BeK == null) || (this.BeK.getMd5() == null)) {
            continue;
          }
          this.BeK.getMd5().length();
          continue;
          this.BeM = (Util.nullAsNil(this.BeK.bnK()) + " " + Util.nullAsNil(this.BeK.bnP()).replace(" ", ""));
          break label156;
          label832:
          i = 0;
          break label384;
          label837:
          this.BeO = "";
          break label412;
          label847:
          u("contact_info_social_googlecontacts", "", false);
          break label537;
          label861:
          localObject1 = this.rjX.fuW;
          Log.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.BeS = null;
        }
        u("contact_info_social_weishop", "", false);
        AppMethodBeat.o(27061);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27060);
    super.onCreate(paramBundle);
    this.dWq = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    bg.aVF();
    this.rjX = com.tencent.mm.model.c.aSN().Kn(this.dWq);
    initView();
    AppMethodBeat.o(27060);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27063);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.BeK != null) && (this.rjX != null)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(27063);
      return false;
      bg.aVF();
      if (com.tencent.mm.model.c.aSN().bjG(this.BeK.getUsername()))
      {
        if ((this.BeK != null) && (!Util.isNullOrNil(this.BeK.iKR))) {}
        for (paramf = getResources().getStringArray(2130903077);; paramf = getResources().getStringArray(2130903078))
        {
          com.tencent.mm.ui.base.h.a(this, null, paramf, null, new h.d()
          {
            public final void oj(int paramAnonymousInt)
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
                  ab.c(ContactSocialInfoUI.b(ContactSocialInfoUI.this), ((String)localObject).trim());
                  AppMethodBeat.o(27057);
                  return;
                  if ((paramf == null) || (paramf.length <= 2) || (ContactSocialInfoUI.c(ContactSocialInfoUI.this) == null) || (ContactSocialInfoUI.b(ContactSocialInfoUI.this) == null))
                  {
                    AppMethodBeat.o(27057);
                    return;
                  }
                  if ((ContactSocialInfoUI.c(ContactSocialInfoUI.this) != null) && (!Util.isNullOrNil(ContactSocialInfoUI.c(ContactSocialInfoUI.this).iKR)))
                  {
                    ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.b(ContactSocialInfoUI.this).field_username, ContactSocialInfoUI.c(ContactSocialInfoUI.this).iKR);
                    AppMethodBeat.o(27057);
                    return;
                  }
                  localObject = new Intent();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("fromScene", 2);
                  ((Intent)localObject).putExtra("reportArgs", localBundle);
                  com.tencent.mm.plugin.profile.b.jRt.j((Intent)localObject, ContactSocialInfoUI.this);
                }
              }
            }
          });
          break;
        }
      }
      if ((this.BeM != null) && (this.BeM.length() != 0))
      {
        int i = this.BeM.lastIndexOf(' ') + 1;
        if (i > 0)
        {
          aKo(this.BeM.substring(i));
          continue;
          if (!paramf.equals("contact_info_social_qq")) {
            if (paramf.equals("contact_info_social_linkedin"))
            {
              paramf = this.rjX.fuV;
              if (Util.isNullOrNil(paramf))
              {
                Log.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
              }
              else
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf);
                paramPreference.putExtra("geta8key_username", z.aTY());
                com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
              }
            }
            else if ((!paramf.equals("contact_info_social_facebook")) && (!paramf.equals("contact_info_social_googlecontacts")) && (paramf.equals("contact_info_social_weishop")) && (this.BeS != null))
            {
              bg.aVF();
              if (com.tencent.mm.model.c.azQ().get(ar.a.NWm, null) == null) {
                com.tencent.mm.ui.base.h.a(this, 2131758072, 2131755998, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27059);
                    ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                    bg.aVF();
                    com.tencent.mm.model.c.azQ().set(ar.a.NWm, Integer.valueOf(1));
                    AppMethodBeat.o(27059);
                  }
                }, null);
              } else {
                eEo();
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