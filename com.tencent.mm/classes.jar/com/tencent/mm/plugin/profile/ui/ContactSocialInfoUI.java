package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.b.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.f.d;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.account.friend.model.ap;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
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
  private long MWA;
  private String MWB;
  private com.tencent.mm.plugin.account.friend.model.a MWL;
  private String MWM;
  private String MWN;
  private String MWO;
  private String MWP;
  private String MWQ;
  private String MWR;
  private String MWS;
  private JSONObject MWT;
  private String hVQ;
  private com.tencent.mm.ui.base.preference.f pkD;
  private au xVS;
  
  private void E(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(27062);
    if ((!Util.isNullOrNil(paramString2)) && (!Util.isNullOrNil(paramString1)))
    {
      paramString1 = (KeyValuePreference)this.pkD.bAi(paramString1);
      if (paramString1 != null)
      {
        paramString1.jnp();
        if (paramBoolean) {
          paramString1.wKL = getResources().getColor(R.e.link_color);
        }
        paramString1.aS(paramString2);
        paramString1.LG(false);
      }
      AppMethodBeat.o(27062);
      return;
    }
    this.pkD.bAk(paramString1);
    AppMethodBeat.o(27062);
  }
  
  private void aRV(String paramString)
  {
    AppMethodBeat.i(27065);
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setFlags(268435456);
    localIntent.setData(Uri.parse("tel:".concat(String.valueOf(paramString))));
    paramString = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(this, paramString.aYi(), "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)paramString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/profile/ui/ContactSocialInfoUI", "dial", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(27065);
  }
  
  private void gBw()
  {
    AppMethodBeat.i(27066);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.MWT.optString("ShopUrl"));
    localIntent.putExtra("geta8key_username", z.bAM());
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
      boolean bool = com.tencent.mm.plugin.account.friend.model.i.a(paramString, getContext(), localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(27064);
      return bool;
    }
    AppMethodBeat.o(27064);
    return false;
  }
  
  public int getResourceId()
  {
    return R.o.hbb;
  }
  
  public void initView()
  {
    AppMethodBeat.i(27061);
    setMMTitle(R.l.gCh);
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
    this.pkD = getPreferenceScreen();
    Object localObject1 = getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
    if ((Util.isNullOrNil((String)localObject1)) && (Util.isNullOrNil((String)localObject2))) {
      if (Util.isNullOrNil(this.xVS.field_username)) {
        this.MWL = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(this.hVQ);
      }
    }
    for (;;)
    {
      label156:
      int i;
      if ((this.MWL == null) || (this.MWL.getMd5() == null) || (this.MWL.getMd5().length() <= 0))
      {
        Log.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.MWM);
        E("contact_info_social_mobile", this.MWN, true);
        bh.bCz();
        i = Util.nullAsNil((Integer)com.tencent.mm.model.c.ban().d(9, null));
        this.MWA = getIntent().getLongExtra("Contact_Uin", 0L);
        this.MWB = getIntent().getStringExtra("Contact_QQNick");
        if ((this.MWA != 0L) && (i != 0))
        {
          if ((this.MWB == null) || (this.MWB.length() == 0))
          {
            long l = this.MWA;
            localObject2 = com.tencent.mm.plugin.account.b.getQQListStg().jt(l);
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = null;
            }
            if (localObject1 != null) {
              this.MWB = ((ap)localObject1).getDisplayName();
            }
          }
          this.MWO = Util.nullAsNil(this.MWB);
          this.MWO = (this.MWO + " " + new p(this.MWA).longValue());
        }
        E("contact_info_social_qq", this.MWO, true);
        localObject1 = com.tencent.mm.k.i.aRC().getValue("LinkedinPluginClose");
        if ((!Util.isNullOrNil((String)localObject1)) && (Util.getInt((String)localObject1, 0) != 0)) {
          break label832;
        }
        i = 1;
        label384:
        if ((i == 0) || (Util.isNullOrNil(this.xVS.kan))) {
          break label837;
        }
        this.MWP = this.xVS.kao;
        label412:
        E("contact_info_social_linkedin", this.MWP, true);
        E("contact_info_social_facebook", this.MWQ, false);
        this.MWS = Util.nullAs(getIntent().getStringExtra("verify_gmail"), "");
        this.MWR = Util.nullAs(getIntent().getStringExtra("profileName"), Util.subStringEmail(this.MWS));
        if ((Util.isNullOrNil(this.MWS)) || (Util.isNullOrNil(this.MWR))) {
          break label847;
        }
        E("contact_info_social_googlecontacts", this.MWR + '\n' + this.MWS, false);
        label537:
        if (!z.bAM().equals(this.xVS.field_username)) {
          break label861;
        }
        bh.bCz();
        localObject1 = (String)com.tencent.mm.model.c.ban().get(at.a.acLe, null);
        Log.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[] { localObject1 });
        if (Util.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        this.MWT = new JSONObject((String)localObject1);
        if (this.MWT != null)
        {
          E("contact_info_social_weishop", this.MWT.optString("ShopName"), true);
          AppMethodBeat.o(27061);
          return;
          this.MWL = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(this.xVS.field_username);
          continue;
          if (((localObject1 == null) || (((String)localObject1).length() <= 0)) && ((localObject2 == null) || (((String)localObject2).length() <= 0))) {
            continue;
          }
          this.MWL = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU((String)localObject1);
          if ((this.MWL != null) && (this.MWL.getMd5() != null) && (this.MWL.getMd5().length() > 0)) {
            continue;
          }
          this.MWL = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU((String)localObject2);
          if ((this.MWL == null) || (this.MWL.getMd5() == null)) {
            continue;
          }
          this.MWL.getMd5().length();
          continue;
          this.MWN = (Util.nullAsNil(this.MWL.bWI()) + " " + Util.nullAsNil(this.MWL.bWN()).replace(" ", ""));
          break label156;
          label832:
          i = 0;
          break label384;
          label837:
          this.MWP = "";
          break label412;
          label847:
          E("contact_info_social_googlecontacts", "", false);
          break label537;
          label861:
          localObject1 = this.xVS.kaq;
          Log.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[] { localObject1 });
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ContactSocialInfoUI", localJSONException, "", new Object[0]);
          this.MWT = null;
        }
        E("contact_info_social_weishop", "", false);
        AppMethodBeat.o(27061);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27060);
    super.onCreate(paramBundle);
    this.hVQ = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
    bh.bCz();
    this.xVS = com.tencent.mm.model.c.bzA().JE(this.hVQ);
    initView();
    AppMethodBeat.o(27060);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(27063);
    paramf = paramPreference.mKey;
    Log.i("MicroMsg.ContactSocialInfoUI", paramf + " item has been clicked!");
    if (paramf.equals("contact_info_social_mobile")) {
      if ((this.MWL != null) && (this.xVS != null)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(27063);
      return false;
      bh.bCz();
      if (com.tencent.mm.model.c.bzA().bxr(this.MWL.getUsername()))
      {
        if ((this.MWL != null) && (!Util.isNullOrNil(this.MWL.osA))) {}
        for (paramf = getResources().getStringArray(R.c.fjT);; paramf = getResources().getStringArray(R.c.fjU))
        {
          paramPreference = paramf;
          if (com.tencent.mm.plugin.profile.b.pFo.aDC())
          {
            paramf = Util.stringsToList(paramf);
            paramf.add(getResources().getString(R.l.gyY));
            paramPreference = (String[])paramf.toArray(new String[paramf.size()]);
            h.OAn.b(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
          }
          k.a(this, null, paramPreference, null, new k.d()
          {
            public final void qz(int paramAnonymousInt)
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
                  if ((paramPreference == null) || (paramPreference.length <= 2) || (ContactSocialInfoUI.c(ContactSocialInfoUI.this) == null) || (ContactSocialInfoUI.b(ContactSocialInfoUI.this) == null))
                  {
                    AppMethodBeat.o(27057);
                    return;
                  }
                  if ((ContactSocialInfoUI.c(ContactSocialInfoUI.this) != null) && (!Util.isNullOrNil(ContactSocialInfoUI.c(ContactSocialInfoUI.this).osA)))
                  {
                    ContactSocialInfoUI.a(ContactSocialInfoUI.this, ContactSocialInfoUI.b(ContactSocialInfoUI.this).field_username, ContactSocialInfoUI.c(ContactSocialInfoUI.this).osA);
                    AppMethodBeat.o(27057);
                    return;
                  }
                  localObject = new Intent();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("fromScene", 2);
                  ((Intent)localObject).putExtra("reportArgs", localBundle);
                  com.tencent.mm.plugin.profile.b.pFn.i((Intent)localObject, ContactSocialInfoUI.this);
                }
              }
            }
          });
          break;
        }
      }
      if ((this.MWN != null) && (this.MWN.length() != 0))
      {
        int i = this.MWN.lastIndexOf(' ') + 1;
        if (i > 0)
        {
          aRV(this.MWN.substring(i));
          continue;
          if (!paramf.equals("contact_info_social_qq")) {
            if (paramf.equals("contact_info_social_linkedin"))
            {
              paramf = this.xVS.kap;
              if (Util.isNullOrNil(paramf))
              {
                Log.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
              }
              else
              {
                paramPreference = new Intent();
                paramPreference.putExtra("rawUrl", paramf);
                paramPreference.putExtra("geta8key_username", z.bAM());
                com.tencent.mm.br.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramPreference);
              }
            }
            else if ((!paramf.equals("contact_info_social_facebook")) && (!paramf.equals("contact_info_social_googlecontacts")) && (paramf.equals("contact_info_social_weishop")) && (this.MWT != null))
            {
              bh.bCz();
              if (com.tencent.mm.model.c.ban().get(at.a.acLG, null) == null) {
                k.a(this, R.l.gCi, R.l.app_tip, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(27059);
                    ContactSocialInfoUI.d(ContactSocialInfoUI.this);
                    bh.bCz();
                    com.tencent.mm.model.c.ban().set(at.a.acLG, Integer.valueOf(1));
                    AppMethodBeat.o(27059);
                  }
                }, null);
              } else {
                gBw();
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