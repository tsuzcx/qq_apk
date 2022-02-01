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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private String dDy;
  private com.tencent.mm.ui.base.preference.f mzx;
  private am pMt;
  private long wQW;
  private String wQX;
  private com.tencent.mm.plugin.account.friend.a.a wRg;
  private String wRh;
  private String wRi;
  private String wRj;
  private String wRk;
  private String wRl;
  private String wRm;
  private String wRn;
  private JSONObject wRo;
  
  private void auH(String paramString)
  {
    AppMethodBeat.i(27065);
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
    com.tencent.mm.hellhoundlib.a.a.a(this, paramString.ahp(), "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27065);
  }
  
  private void dAE()
  {
    AppMethodBeat.i(27066);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.wRo.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", u.aAm());
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
    if ((!bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.mzx.aVD(paramString1);
      if (paramString1 != null)
      {
        paramString1.fzD();
        if (paramBoolean) {
          paramString1.oPT = getResources().getColor(2131100547);
        }
        paramString1.setSummary(paramString2);
        paramString1.xG(false);
      }
      AppMethodBeat.o(27062);
      return;
    }
    this.mzx.aVE(paramString1);
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
    this.mzx = getPreferenceScreen();
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((bt.isNullOrNil((String)localObject1)) && (bt.isNullOrNil((String)localObject2))) {
      if (bt.isNullOrNil(this.pMt.field_username)) {
        this.wRg = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(this.dDy);
      }
    }
    for (;;)
    {
      label156:
      int i;
      if ((this.wRg == null) || (this.wRg.Lb() == null) || (this.wRg.Lb().length() <= 0))
      {
        ad.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.wRh);
        s("contact_info_social_mobile", this.wRi, true);
        ba.aBQ();
        i = bt.n((Integer)c.ajl().get(9, null));
        this.wQW = getIntent().getLongExtra("Contact_Uin", 0L);
        this.wQX = getIntent().getStringExtra("Contact_QQNick");
        if ((this.wQW != 0L) && (i != 0))
        {
          if ((this.wQX == null) || (this.wQX.length() == 0))
          {
            long l = this.wQW;
            localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().sB(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.wQX = ((as)localObject1).getDisplayName();
            }
          }
          this.wRj = bt.nullAsNil(this.wQX);
          this.wRj = (this.wRj + " " + new com.tencent.mm.b.p(this.wQW).longValue());
        }
        s("contact_info_social_qq", this.wRj, true);
        localObject1 = com.tencent.mm.n.g.acA().getValue("LinkedinPluginClose");
        if ((!bt.isNullOrNil((String)localObject1)) && (bt.getInt((String)localObject1, 0) != 0)) {
          break label832;
        }
        i = 1;
        label384:
        if ((i == 0) || (bt.isNullOrNil(this.pMt.ePF))) {
          break label837;
        }
        this.wRk = this.pMt.ePG;
        label412:
        s("contact_info_social_linkedin", this.wRk, true);
        s("contact_info_social_facebook", this.wRl, false);
        this.wRn = bt.bI(getIntent().getStringExtra("verify_gmail"), "");
        this.wRm = bt.bI(getIntent().getStringExtra("profileName"), bt.aRo(this.wRn));
        if ((bt.isNullOrNil(this.wRn)) || (bt.isNullOrNil(this.wRm))) {
          break label847;
        }
        s("contact_info_social_googlecontacts", this.wRm + '\n' + this.wRn, false);
        label537:
        if (!u.aAm().equals(this.pMt.field_username)) {
          break label861;
        }
        ba.aBQ();
        localObject1 = (String)c.ajl().get(al.a.Itl, null);
        ad.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (bt.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        this.wRo = new JSONObject((String)localObject1);
        if (this.wRo != null)
        {
          s("contact_info_social_weishop", this.wRo.optString("ShopName"), true);
          AppMethodBeat.o(27061);
          return;
          this.wRg = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(this.pMt.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.wRg = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject1);
          if ((this.wRg != null) && (this.wRg.Lb() != null) && (this.wRg.Lb().length() > 0)) {
            continue;
          }
          this.wRg = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject2);
          if ((this.wRg == null) || (this.wRg.Lb() == null)) {
            continue;
          }
          this.wRg.Lb().length();
          continue;
          this.wRi = (bt.nullAsNil(this.wRg.aSy()) + " " + bt.nullAsNil(this.wRg.aSD()).replace(" ", ""));
          break label156;
          label832:
          i = 0;
          break label384;
          label837:
          this.wRk = "";
          break label412;
          label847:
          s("contact_info_social_googlecontacts", "", false);
          break label537;
          label861:
          localObject1 = this.pMt.ePI;
          ad.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.wRo = null;
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
    this.dDy = bt.nullAsNil(getIntent().getStringExtra("Contact_User"));
    ba.aBQ();
    this.pMt = c.azp().Bf(this.dDy);
    initView();
    AppMethodBeat.o(27060);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(27063);
    paramf = paramPreference.mKey;
    ad.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.wRg != null) && (this.pMt != null)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(27063);
      return false;
      ba.aBQ();
      if (c.azp().aTg(this.wRg.getUsername()))
      {
        if ((this.wRg != null) && (!bt.isNullOrNil(this.wRg.hMR))) {}
        for (paramf = getResources().getStringArray(2130903076);; paramf = getResources().getStringArray(2130903077))
        {
          paramPreference = paramf;
          if (com.tencent.mm.plugin.profile.b.iRH.MW())
          {
            paramf = bt.U(paramf);
            paramf.add(getResources().getString(2131757266));
            paramPreference = (String[])paramf.toArray(new String[paramf.size()]);
            com.tencent.mm.plugin.report.service.g.yhR.f(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
          }
          h.a(this, null, paramPreference, null, new h.c()
          {
            public final void lf(int paramAnonymousInt)
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
                  if ((ContactSocialInfoUI.c(ContactSocialInfoUI.this) != null) && (!bt.isNullOrNil(ContactSocialInfoUI.c(ContactSocialInfoUI.this).hMR)))
                  {
                    ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.b(ContactSocialInfoUI.this).field_username, ContactSocialInfoUI.c(ContactSocialInfoUI.this).hMR);
                    AppMethodBeat.o(27057);
                    return;
                  }
                  localObject = new Intent();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("fromScene", 2);
                  ((Intent)localObject).putExtra("reportArgs", localBundle);
                  com.tencent.mm.plugin.profile.b.iRG.j((Intent)localObject, ContactSocialInfoUI.this);
                }
              }
            }
          });
          break;
        }
      }
      if ((this.wRi != null) && (this.wRi.length() != 0))
      {
        int i = this.wRi.lastIndexOf(' ') + 1;
        if (i > 0)
        {
          auH(this.wRi.substring(i));
          continue;
          if (!paramf.equals("contact_info_social_qq")) {
            if (paramf.equals("contact_info_social_linkedin"))
            {
              paramf = this.pMt.ePH;
              if (bt.isNullOrNil(paramf))
              {
                ad.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
              }
              else
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf);
                paramPreference.putExtra("geta8key_username", u.aAm());
                d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
              }
            }
            else if ((!paramf.equals("contact_info_social_facebook")) && (!paramf.equals("contact_info_social_googlecontacts")) && (paramf.equals("contact_info_social_weishop")) && (this.wRo != null))
            {
              ba.aBQ();
              if (c.ajl().get(al.a.ItN, null) == null) {
                h.a(this, 2131757832, 2131755906, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27059);
                    ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                    ba.aBQ();
                    c.ajl().set(al.a.ItN, Integer.valueOf(1));
                    AppMethodBeat.o(27059);
                  }
                }, null);
              } else {
                dAE();
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