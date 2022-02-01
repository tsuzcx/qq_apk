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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.c;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.g;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.q;
import com.tencent.mm.b.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
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
  private com.tencent.mm.plugin.account.friend.a.a GYI;
  private String GYJ;
  private String GYK;
  private String GYL;
  private String GYM;
  private String GYN;
  private String GYO;
  private String GYP;
  private JSONObject GYQ;
  private long GYx;
  private String GYy;
  private String fPV;
  private com.tencent.mm.ui.base.preference.f mrf;
  private com.tencent.mm.storage.as uNk;
  
  private void aUN(String paramString)
  {
    AppMethodBeat.i(27065);
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aFh(), "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27065);
  }
  
  private void fqg()
  {
    AppMethodBeat.i(27066);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.GYQ.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", z.bcZ());
    com.tencent.mm.by.c.b(getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
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
  
  private void y(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(27062);
    if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.mrf.byG(paramString1);
      if (paramString1 != null)
      {
        paramString1.hKM();
        if (paramBoolean) {
          paramString1.tHk = getResources().getColor(R.e.link_color);
        }
        paramString1.aF(paramString2);
        paramString1.FU(false);
      }
      AppMethodBeat.o(27062);
      return;
    }
    this.mrf.byI(paramString1);
    AppMethodBeat.o(27062);
  }
  
  public int getResourceId()
  {
    return R.o.eXA;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27061);
    setMMTitle(R.l.ezs);
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
    this.mrf = getPreferenceScreen();
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((Util.isNullOrNil((String)localObject1)) && (Util.isNullOrNil((String)localObject2))) {
      if (Util.isNullOrNil(this.uNk.field_username)) {
        this.GYI = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(this.fPV);
      }
    }
    for (;;)
    {
      label156:
      int i;
      if ((this.GYI == null) || (this.GYI.getMd5() == null) || (this.GYI.getMd5().length() <= 0))
      {
        Log.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.GYJ);
        y("contact_info_social_mobile", this.GYK, true);
        bh.beI();
        i = Util.nullAsNil((Integer)com.tencent.mm.model.c.aHp().b(9, null));
        this.GYx = getIntent().getLongExtra("Contact_Uin", 0L);
        this.GYy = getIntent().getStringExtra("Contact_QQNick");
        if ((this.GYx != 0L) && (i != 0))
        {
          if ((this.GYy == null) || (this.GYy.length() == 0))
          {
            long l = this.GYx;
            localObject2 = com.tencent.mm.plugin.account.b.getQQListStg().Hd(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.GYy = ((com.tencent.mm.plugin.account.friend.a.as)localObject1).getDisplayName();
            }
          }
          this.GYL = Util.nullAsNil(this.GYy);
          this.GYL = (this.GYL + " " + new p(this.GYx).longValue());
        }
        y("contact_info_social_qq", this.GYL, true);
        localObject1 = com.tencent.mm.n.h.axc().getValue("LinkedinPluginClose");
        if ((!Util.isNullOrNil((String)localObject1)) && (Util.getInt((String)localObject1, 0) != 0)) {
          break label832;
        }
        i = 1;
        label384:
        if ((i == 0) || (Util.isNullOrNil(this.uNk.hDs))) {
          break label837;
        }
        this.GYM = this.uNk.hDt;
        label412:
        y("contact_info_social_linkedin", this.GYM, true);
        y("contact_info_social_facebook", this.GYN, false);
        this.GYP = Util.nullAs(getIntent().getStringExtra("verify_gmail"), "");
        this.GYO = Util.nullAs(getIntent().getStringExtra("profileName"), Util.subStringEmail(this.GYP));
        if ((Util.isNullOrNil(this.GYP)) || (Util.isNullOrNil(this.GYO))) {
          break label847;
        }
        y("contact_info_social_googlecontacts", this.GYO + '\n' + this.GYP, false);
        label537:
        if (!z.bcZ().equals(this.uNk.field_username)) {
          break label861;
        }
        bh.beI();
        localObject1 = (String)com.tencent.mm.model.c.aHp().get(ar.a.VjK, null);
        Log.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (Util.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        this.GYQ = new JSONObject((String)localObject1);
        if (this.GYQ != null)
        {
          y("contact_info_social_weishop", this.GYQ.optString("ShopName"), true);
          AppMethodBeat.o(27061);
          return;
          this.GYI = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(this.uNk.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.GYI = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA((String)localObject1);
          if ((this.GYI != null) && (this.GYI.getMd5() != null) && (this.GYI.getMd5().length() > 0)) {
            continue;
          }
          this.GYI = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA((String)localObject2);
          if ((this.GYI == null) || (this.GYI.getMd5() == null)) {
            continue;
          }
          this.GYI.getMd5().length();
          continue;
          this.GYK = (Util.nullAsNil(this.GYI.bxT()) + " " + Util.nullAsNil(this.GYI.bxY()).replace(" ", ""));
          break label156;
          label832:
          i = 0;
          break label384;
          label837:
          this.GYM = "";
          break label412;
          label847:
          y("contact_info_social_googlecontacts", "", false);
          break label537;
          label861:
          localObject1 = this.uNk.hDv;
          Log.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.GYQ = null;
        }
        y("contact_info_social_weishop", "", false);
        AppMethodBeat.o(27061);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27060);
    super.onCreate(paramBundle);
    this.fPV = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    bh.beI();
    this.uNk = com.tencent.mm.model.c.bbL().RG(this.fPV);
    initView();
    AppMethodBeat.o(27060);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(27063);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.GYI != null) && (this.uNk != null)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(27063);
      return false;
      bh.beI();
      if (com.tencent.mm.model.c.bbL().bwd(this.GYI.getUsername()))
      {
        if ((this.GYI != null) && (!Util.isNullOrNil(this.GYI.lAY))) {}
        for (paramf = getResources().getStringArray(R.c.djS);; paramf = getResources().getStringArray(R.c.djT))
        {
          paramPreference = com.tencent.mm.plugin.profile.b.mIH;
          com.tencent.mm.ui.base.h.a(this, null, paramf, null, new h.d()
          {
            public final void qy(int paramAnonymousInt)
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
                  if ((ContactSocialInfoUI.c(ContactSocialInfoUI.this) != null) && (!Util.isNullOrNil(ContactSocialInfoUI.c(ContactSocialInfoUI.this).lAY)))
                  {
                    ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.b(ContactSocialInfoUI.this).field_username, ContactSocialInfoUI.c(ContactSocialInfoUI.this).lAY);
                    AppMethodBeat.o(27057);
                    return;
                  }
                  localObject = new Intent();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("fromScene", 2);
                  ((Intent)localObject).putExtra("reportArgs", localBundle);
                  com.tencent.mm.plugin.profile.b.mIG.i((Intent)localObject, ContactSocialInfoUI.this);
                }
              }
            }
          });
          break;
        }
      }
      if ((this.GYK != null) && (this.GYK.length() != 0))
      {
        int i = this.GYK.lastIndexOf(' ') + 1;
        if (i > 0)
        {
          aUN(this.GYK.substring(i));
          continue;
          if (!paramf.equals("contact_info_social_qq")) {
            if (paramf.equals("contact_info_social_linkedin"))
            {
              paramf = this.uNk.hDu;
              if (Util.isNullOrNil(paramf))
              {
                Log.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
              }
              else
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf);
                paramPreference.putExtra("geta8key_username", z.bcZ());
                com.tencent.mm.by.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
              }
            }
            else if ((!paramf.equals("contact_info_social_facebook")) && (!paramf.equals("contact_info_social_googlecontacts")) && (paramf.equals("contact_info_social_weishop")) && (this.GYQ != null))
            {
              bh.beI();
              if (com.tencent.mm.model.c.aHp().get(ar.a.Vkm, null) == null) {
                com.tencent.mm.ui.base.h.a(this, R.l.ezt, R.l.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27059);
                    ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                    bh.beI();
                    com.tencent.mm.model.c.aHp().set(ar.a.Vkm, Integer.valueOf(1));
                    AppMethodBeat.o(27059);
                  }
                }, null);
              } else {
                fqg();
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