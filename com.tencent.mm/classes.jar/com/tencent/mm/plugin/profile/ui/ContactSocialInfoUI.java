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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.h;
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
  private String dED;
  private com.tencent.mm.ui.base.preference.f mEx;
  private an pSY;
  private long xgN;
  private String xgO;
  private com.tencent.mm.plugin.account.friend.a.a xgX;
  private String xgY;
  private String xgZ;
  private String xha;
  private String xhb;
  private String xhc;
  private String xhd;
  private String xhe;
  private JSONObject xhf;
  
  private void avW(String paramString)
  {
    AppMethodBeat.i(27065);
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahE(), "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27065);
  }
  
  private void dDV()
  {
    AppMethodBeat.i(27066);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.xhf.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", v.aAC());
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
    if ((!bu.isNullOrNil(paramString2)) && (!bu.isNullOrNil(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.mEx.aXe(paramString1);
      if (paramString1 != null)
      {
        paramString1.fDF();
        if (paramBoolean) {
          paramString1.oWv = getResources().getColor(2131100547);
        }
        paramString1.setSummary(paramString2);
        paramString1.xN(false);
      }
      AppMethodBeat.o(27062);
      return;
    }
    this.mEx.aXf(paramString1);
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
    this.mEx = getPreferenceScreen();
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((bu.isNullOrNil((String)localObject1)) && (bu.isNullOrNil((String)localObject2))) {
      if (bu.isNullOrNil(this.pSY.field_username)) {
        this.xgX = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(this.dED);
      }
    }
    for (;;)
    {
      label156:
      int i;
      if ((this.xgX == null) || (this.xgX.Lj() == null) || (this.xgX.Lj().length() <= 0))
      {
        ae.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.xgY);
        s("contact_info_social_mobile", this.xgZ, true);
        bc.aCg();
        i = bu.o((Integer)c.ajA().get(9, null));
        this.xgN = getIntent().getLongExtra("Contact_Uin", 0L);
        this.xgO = getIntent().getStringExtra("Contact_QQNick");
        if ((this.xgN != 0L) && (i != 0))
        {
          if ((this.xgO == null) || (this.xgO.length() == 0))
          {
            long l = this.xgN;
            localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().sO(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.xgO = ((as)localObject1).getDisplayName();
            }
          }
          this.xha = bu.nullAsNil(this.xgO);
          this.xha = (this.xha + " " + new com.tencent.mm.b.p(this.xgN).longValue());
        }
        s("contact_info_social_qq", this.xha, true);
        localObject1 = com.tencent.mm.n.g.acL().getValue("LinkedinPluginClose");
        if ((!bu.isNullOrNil((String)localObject1)) && (bu.getInt((String)localObject1, 0) != 0)) {
          break label832;
        }
        i = 1;
        label384:
        if ((i == 0) || (bu.isNullOrNil(this.pSY.eRq))) {
          break label837;
        }
        this.xhb = this.pSY.eRr;
        label412:
        s("contact_info_social_linkedin", this.xhb, true);
        s("contact_info_social_facebook", this.xhc, false);
        this.xhe = bu.bI(getIntent().getStringExtra("verify_gmail"), "");
        this.xhd = bu.bI(getIntent().getStringExtra("profileName"), bu.aSL(this.xhe));
        if ((bu.isNullOrNil(this.xhe)) || (bu.isNullOrNil(this.xhd))) {
          break label847;
        }
        s("contact_info_social_googlecontacts", this.xhd + '\n' + this.xhe, false);
        label537:
        if (!v.aAC().equals(this.pSY.field_username)) {
          break label861;
        }
        bc.aCg();
        localObject1 = (String)c.ajA().get(am.a.INH, null);
        ae.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (bu.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        this.xhf = new JSONObject((String)localObject1);
        if (this.xhf != null)
        {
          s("contact_info_social_weishop", this.xhf.optString("ShopName"), true);
          AppMethodBeat.o(27061);
          return;
          this.xgX = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(this.pSY.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.xgX = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject1);
          if ((this.xgX != null) && (this.xgX.Lj() != null) && (this.xgX.Lj().length() > 0)) {
            continue;
          }
          this.xgX = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject2);
          if ((this.xgX == null) || (this.xgX.Lj() == null)) {
            continue;
          }
          this.xgX.Lj().length();
          continue;
          this.xgZ = (bu.nullAsNil(this.xgX.aSX()) + " " + bu.nullAsNil(this.xgX.aTc()).replace(" ", ""));
          break label156;
          label832:
          i = 0;
          break label384;
          label837:
          this.xhb = "";
          break label412;
          label847:
          s("contact_info_social_googlecontacts", "", false);
          break label537;
          label861:
          localObject1 = this.pSY.eRt;
          ae.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.xhf = null;
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
    this.dED = bu.nullAsNil(getIntent().getStringExtra("Contact_User"));
    bc.aCg();
    this.pSY = c.azF().BH(this.dED);
    initView();
    AppMethodBeat.o(27060);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(27063);
    paramf = paramPreference.mKey;
    ae.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.xgX != null) && (this.pSY != null)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(27063);
      return false;
      bc.aCg();
      if (c.azF().aUH(this.xgX.getUsername()))
      {
        if ((this.xgX != null) && (!bu.isNullOrNil(this.xgX.hPK))) {}
        for (paramf = getResources().getStringArray(2130903076);; paramf = getResources().getStringArray(2130903077))
        {
          paramPreference = paramf;
          if (com.tencent.mm.plugin.profile.b.iUA.MR())
          {
            paramf = bu.U(paramf);
            paramf.add(getResources().getString(2131757266));
            paramPreference = (String[])paramf.toArray(new String[paramf.size()]);
            com.tencent.mm.plugin.report.service.g.yxI.f(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
          }
          h.a(this, null, paramPreference, null, new h.c()
          {
            public final void lh(int paramAnonymousInt)
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
                  x.c(ContactSocialInfoUI.b(ContactSocialInfoUI.this), ((String)localObject).trim());
                  AppMethodBeat.o(27057);
                  return;
                  if ((paramPreference == null) || (paramPreference.length <= 2) || (ContactSocialInfoUI.c(ContactSocialInfoUI.this) == null) || (ContactSocialInfoUI.b(ContactSocialInfoUI.this) == null))
                  {
                    AppMethodBeat.o(27057);
                    return;
                  }
                  if ((ContactSocialInfoUI.c(ContactSocialInfoUI.this) != null) && (!bu.isNullOrNil(ContactSocialInfoUI.c(ContactSocialInfoUI.this).hPK)))
                  {
                    ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.b(ContactSocialInfoUI.this).field_username, ContactSocialInfoUI.c(ContactSocialInfoUI.this).hPK);
                    AppMethodBeat.o(27057);
                    return;
                  }
                  localObject = new Intent();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("fromScene", 2);
                  ((Intent)localObject).putExtra("reportArgs", localBundle);
                  com.tencent.mm.plugin.profile.b.iUz.j((Intent)localObject, ContactSocialInfoUI.this);
                }
              }
            }
          });
          break;
        }
      }
      if ((this.xgZ != null) && (this.xgZ.length() != 0))
      {
        int i = this.xgZ.lastIndexOf(' ') + 1;
        if (i > 0)
        {
          avW(this.xgZ.substring(i));
          continue;
          if (!paramf.equals("contact_info_social_qq")) {
            if (paramf.equals("contact_info_social_linkedin"))
            {
              paramf = this.pSY.eRs;
              if (bu.isNullOrNil(paramf))
              {
                ae.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
              }
              else
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf);
                paramPreference.putExtra("geta8key_username", v.aAC());
                d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
              }
            }
            else if ((!paramf.equals("contact_info_social_facebook")) && (!paramf.equals("contact_info_social_googlecontacts")) && (paramf.equals("contact_info_social_weishop")) && (this.xhf != null))
            {
              bc.aCg();
              if (c.ajA().get(am.a.IOk, null) == null) {
                h.a(this, 2131757832, 2131755906, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27059);
                    ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                    bc.aCg();
                    c.ajA().set(am.a.IOk, Integer.valueOf(1));
                    AppMethodBeat.o(27059);
                  }
                }, null);
              } else {
                dDV();
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