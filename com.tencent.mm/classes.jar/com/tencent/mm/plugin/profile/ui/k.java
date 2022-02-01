package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.c.av;
import com.tencent.mm.m.e;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.t;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

@j(eUx={ContactInfoUI.class})
public final class k
  implements com.tencent.mm.ak.g, i.a, com.tencent.mm.pluginsdk.b.a
{
  com.tencent.mm.storage.ai contact;
  String daC;
  private int dga;
  x ftP;
  String fvZ;
  MMActivity iMV;
  int iMg;
  private String sBi;
  private com.tencent.mm.ui.base.preference.f screen;
  private boolean vIS;
  private boolean vIT;
  private String vJL;
  private int vKF;
  private dbt vKL;
  private boolean vKM;
  private String vKN;
  private int vKO;
  private boolean vKP;
  private boolean vKQ;
  private String vKR;
  private boolean vKS;
  private String vKT;
  private String vKU;
  private com.tencent.mm.plugin.profile.a.b vKV;
  private int vKW;
  String vKX;
  com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.az> vKY;
  
  private void Ls(int paramInt)
  {
    AppMethodBeat.i(27199);
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aPN("contact_info_source");
    if (!this.vIT)
    {
      if (localKeyValuePreference != null)
      {
        if (paramInt == 10)
        {
          localKeyValuePreference.HET = false;
          localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
          localKeyValuePreference.setSummary(this.iMV.getString(2131759466));
          localKeyValuePreference.wV(false);
          AppMethodBeat.o(27199);
          return;
        }
        this.screen.d(localKeyValuePreference);
      }
      AppMethodBeat.o(27199);
      return;
    }
    switch (paramInt)
    {
    default: 
      this.screen.d(localKeyValuePreference);
    case 1: 
    case 3: 
    case 17: 
    case 8: 
    case 14: 
      do
      {
        do
        {
          do
          {
            do
            {
              AppMethodBeat.o(27199);
              return;
            } while (localKeyValuePreference == null);
            localKeyValuePreference.HET = false;
            localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
            localKeyValuePreference.setSummary(2131757862);
            localKeyValuePreference.wV(false);
            AppMethodBeat.o(27199);
            return;
          } while (localKeyValuePreference == null);
          localKeyValuePreference.HET = false;
          localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
          localKeyValuePreference.setSummary(2131757865);
          localKeyValuePreference.wV(false);
          AppMethodBeat.o(27199);
          return;
        } while (localKeyValuePreference == null);
        localKeyValuePreference.HET = false;
        localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
        localObject2 = v.wk(this.iMV.getIntent().getStringExtra("source_from_user_name"));
        localObject1 = localObject2;
        if (bs.isNullOrNil((String)localObject2)) {
          localObject1 = this.iMV.getIntent().getStringExtra("source_from_nick_name");
        }
        if (bs.isNullOrNil((String)localObject1)) {
          localKeyValuePreference.setSummary(2131757842);
        }
        for (;;)
        {
          localKeyValuePreference.wV(false);
          AppMethodBeat.o(27199);
          return;
          localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.iMV, this.iMV.getString(2131757841, new Object[] { localObject1 })));
        }
      } while (localKeyValuePreference == null);
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localObject1 = com.tencent.mm.bj.d.aJd().ala(this.contact.field_username);
      com.tencent.mm.model.az.ayM();
      Object localObject2 = com.tencent.mm.model.c.awB();
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject1 = ((bj)localObject2).aNt((String)localObject1);
        if (localObject1 == null) {
          break label995;
        }
      }
      break;
    }
    label995:
    for (Object localObject1 = ((av)localObject1).field_nickname;; localObject1 = null)
    {
      if (!bs.isNullOrNil((String)localObject1)) {
        localKeyValuePreference.setSummary(this.iMV.getString(2131757848, new Object[] { localObject1 }));
      }
      for (;;)
      {
        localKeyValuePreference.wV(false);
        AppMethodBeat.o(27199);
        return;
        localObject1 = ((bd)localObject1).field_chatroomName;
        break;
        localKeyValuePreference.setSummary(2131757846);
      }
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localKeyValuePreference.setSummary(this.iMV.getString(2131759467));
      localKeyValuePreference.wV(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localKeyValuePreference.setSummary(2131757871);
      localKeyValuePreference.wV(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localKeyValuePreference.setSummary(2131757837);
      localKeyValuePreference.wV(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localKeyValuePreference.setSummary(2131757855);
      localKeyValuePreference.wV(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localKeyValuePreference.setSummary(this.iMV.getString(2131760022));
      localKeyValuePreference.wV(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localKeyValuePreference.setSummary(this.iMV.getString(2131757857));
      localKeyValuePreference.wV(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localKeyValuePreference.setSummary(2131757859);
      localKeyValuePreference.wV(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.HET = false;
      localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
      localKeyValuePreference.setSummary(2131757850);
      localKeyValuePreference.wV(false);
      AppMethodBeat.o(27199);
      return;
    }
  }
  
  private void dqc()
  {
    AppMethodBeat.i(27194);
    bYJ();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951648);
    if (com.tencent.mm.plugin.sns.b.o.xMf != null) {
      com.tencent.mm.plugin.sns.b.o.xMf.a(3, this.contact.field_username, this);
    }
    com.tencent.mm.model.az.agi().a(30, this);
    com.tencent.mm.model.az.agi().a(453, this);
    this.vKX = "";
    ac.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[] { this.contact.aaO() });
    if (!this.contact.aaO())
    {
      localObject1 = null;
      localObject2 = this.iMV.getIntent().getStringExtra("Contact_Mobile_MD5");
      localObject3 = this.iMV.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bs.isNullOrNil((String)localObject2)) || (!bs.isNullOrNil((String)localObject3))) {
        break label741;
      }
      if (!bs.isNullOrNil(this.contact.field_username))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(this.contact.field_username);
        localObject3 = this.contact.field_username;
        if (localObject2 != null) {
          break label733;
        }
        localObject1 = "true";
        ac.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject1 });
        localObject1 = localObject2;
      }
      label248:
      if ((localObject1 != null) && (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).JC())))
      {
        this.vKX = bs.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aPr()).replace(" ", "");
        ac.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[] { this.contact.field_username, this.vKX });
      }
    }
    Object localObject2 = (NormalUserHeaderPreference)this.screen.aPN("contact_info_header_normal");
    label427:
    int j;
    if (localObject2 != null)
    {
      ((NormalUserHeaderPreference)localObject2).a(this.contact, this.iMg, this.sBi, this.vKX, this.contact.eyl);
      ((NormalUserHeaderPreference)localObject2).cy(this.contact.field_username, this.vKP);
      ((NormalUserHeaderPreference)localObject2).DBv = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27181);
          k localk = k.this;
          if (paramAnonymousView.getId() == 2131304604) {
            h.wUl.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aB(localk.iMV.getIntent())), Integer.valueOf(2), Integer.valueOf(1), localk.contact.field_username });
          }
          if (localk.contact == null)
          {
            ac.e("MicroMsg.ContactWidgetNormal", "contact is null");
            AppMethodBeat.o(27181);
            return;
          }
          if (!com.tencent.mm.n.b.ln(localk.contact.field_type))
          {
            if (!bs.isNullOrNil(localk.contact.field_encryptUsername))
            {
              localk.apF(localk.contact.field_encryptUsername);
              AppMethodBeat.o(27181);
              return;
            }
            localk.apF(localk.contact.field_username);
            AppMethodBeat.o(27181);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_Scene", localk.iMg);
          paramAnonymousView.putExtra("Contact_User", localk.contact.field_username);
          paramAnonymousView.putExtra("Contact_RoomNickname", localk.iMV.getIntent().getStringExtra("Contact_RoomNickname"));
          paramAnonymousView.putExtra("view_mode", true);
          paramAnonymousView.putExtra("contact_phone_number_by_md5", localk.vKX);
          paramAnonymousView.putExtra("contact_phone_number_list", localk.contact.eyl);
          com.tencent.mm.plugin.profile.b.iyx.m(paramAnonymousView, localk.iMV);
          AppMethodBeat.o(27181);
        }
      };
      if (com.tencent.mm.n.b.ln(this.contact.field_type)) {
        this.vKQ = false;
      }
      ((NormalUserHeaderPreference)localObject2).cz(this.contact.field_username, this.vKQ);
      if ((!com.tencent.mm.storage.ai.aNc(this.contact.field_username)) || (this.contact.eyo == 0)) {
        break label1181;
      }
      j = this.screen.indexOf("contact_info_category_1");
      localObject1 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_custom_info_header", b.a.inW);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new PreferenceTitleCategory(this.iMV);
        ((Preference)localObject3).setTitle((CharSequence)localObject1);
        this.screen.a((Preference)localObject3, j);
        ((Preference)localObject3).HFD = new Preference.b()
        {
          public final boolean dpE()
          {
            return false;
          }
        };
      }
      localObject1 = new com.tencent.mm.openim.a.c();
      ((com.tencent.mm.openim.a.c)localObject1).Fo(this.contact.eyp);
      localObject1 = ((com.tencent.mm.openim.a.c)localObject1).inZ.iterator();
      label579:
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (c.a)((Iterator)localObject1).next();
        localObject4 = ((c.a)localObject3).ioa.iterator();
        i = j;
      }
    }
    else
    {
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject4).hasNext()) {
          break label579;
        }
        final c.b localb = (c.b)((Iterator)localObject4).next();
        j = i + 1;
        KeyValuePreference local5 = new KeyValuePreference(this.iMV)
        {
          public final void onBindView(View paramAnonymousView)
          {
            AppMethodBeat.i(27184);
            super.onBindView(paramAnonymousView);
            if (this.vLf != null) {
              if ((localb.action != 2) && (localb.action != 3)) {
                break label113;
              }
            }
            label113:
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                this.vLf.setTextColor(com.tencent.mm.sdk.platformtools.ai.getResources().getColorStateList(2131100733));
              }
              if ((this.HEZ != null) && (!TextUtils.isEmpty(localb.drM)))
              {
                this.HEZ.setVisibility(0);
                com.tencent.mm.av.o.aFB().loadImage(localb.drM, this.HEZ);
              }
              AppMethodBeat.o(27184);
              return;
            }
          }
        };
        local5.Hnl = ((c.a)localObject3).title;
        local5.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.iMV, localb.Fp(this.contact.field_openImAppid)));
        this.screen.a(local5, j);
        if ((localb.action == 0) || (localb.action == 1))
        {
          local5.setEnabled(true);
          i = j;
          continue;
          label733:
          localObject1 = "false";
          break;
          label741:
          if ((bs.isNullOrNil((String)localObject2)) && (bs.isNullOrNil((String)localObject3))) {
            break label248;
          }
          ac.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { this.contact.field_username, localObject2, localObject3 });
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).JC())) {}
          }
          else
          {
            localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi((String)localObject3);
          }
          localObject3 = this.contact.field_username;
          if (localObject1 == null) {}
          for (localObject2 = "true";; localObject2 = "false")
          {
            ac.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject2 });
            break;
          }
          this.screen.d((Preference)localObject2);
          break label427;
        }
        if (localb.action == 2)
        {
          local5.HFD = new Preference.b()
          {
            public final boolean dpE()
            {
              AppMethodBeat.i(27185);
              Object localObject1 = localb.ioc;
              try
              {
                localObject2 = new JSONObject(localb.ioc).optString("tel");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ac.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
                }
              }
              h.wUl.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.vIk.title });
              localObject2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(localObject1))));
              ((Intent)localObject2).setFlags(268435456);
              localObject1 = k.this.iMV;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27185);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 3)
        {
          local5.HFD = new Preference.b()
          {
            public final boolean dpE()
            {
              AppMethodBeat.i(27186);
              Object localObject1 = "";
              try
              {
                localObject2 = new JSONObject(localb.ioc).optString("mailto");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ac.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                }
              }
              h.wUl.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.vIk.title });
              localObject2 = new Intent("android.intent.action.SENDTO");
              ((Intent)localObject2).setData(Uri.parse("mailto:".concat(String.valueOf(localObject1))));
              localObject1 = k.this.iMV;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27186);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 4)
        {
          local5.HFD = new Preference.b()
          {
            public final boolean dpE()
            {
              AppMethodBeat.i(27187);
              Intent localIntent = new Intent();
              localIntent.setFlags(268435456);
              localIntent.setClassName(com.tencent.mm.sdk.platformtools.ai.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
              Object localObject1 = "";
              try
              {
                localObject2 = new JSONObject(localb.ioc).optString("url");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ac.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                }
              }
              h.wUl.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.vIk.title });
              localIntent.putExtra("geta8key_scene", 58);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext();
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27187);
              return true;
            }
          };
          i = j;
        }
        else
        {
          i = j;
          if (localb.action == 5)
          {
            local5.HFD = new Preference.b()
            {
              public final boolean dpE()
              {
                AppMethodBeat.i(27188);
                try
                {
                  Object localObject = new JSONObject(localb.ioc);
                  String str = ((JSONObject)localObject).optString("name");
                  localObject = ((JSONObject)localObject).optString("pagepath");
                  ut localut = new ut();
                  localut.dxt.userName = str;
                  localut.dxt.dxv = bs.bG((String)localObject, "");
                  com.tencent.mm.sdk.b.a.GpY.l(localut);
                  h.wUl.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.vIk.title });
                  AppMethodBeat.o(27188);
                  return true;
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    ac.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                  }
                }
              }
            };
            i = j;
          }
        }
      }
    }
    int i = j + 1;
    this.screen.a(new PreferenceSmallCategory(this.iMV), i);
    Object localObject1 = new KeyValuePreference(this.iMV);
    ((KeyValuePreference)localObject1).setTitle(2131757648);
    Object localObject3 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_intro_desc", b.a.inW);
    ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.iMV, (CharSequence)localObject3));
    Object localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_intro_url", b.a.inX);
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((Preference)localObject1).HFD = new k.10(this, (String)localObject4, (String)localObject3);
    }
    this.screen.a((Preference)localObject1, i + 1);
    label1181:
    if (!bs.isNullOrNil(this.contact.getProvince()))
    {
      localObject3 = (KeyValuePreference)this.screen.aPN("contact_info_district");
      if (localObject3 != null)
      {
        ((KeyValuePreference)localObject3).setTitle(this.iMV.getString(2131757646));
        localObject4 = new StringBuilder().append(v.wm(this.contact.getProvince()));
        if (bs.isNullOrNil(this.contact.getCity()))
        {
          localObject1 = "";
          ((KeyValuePreference)localObject3).setSummary((String)localObject1);
          ((KeyValuePreference)localObject3).wV(false);
          ((KeyValuePreference)localObject3).setEnabled(false);
        }
      }
      else
      {
        if ((this.contact.signature == null) || (this.contact.signature.trim().equals("")) || (com.tencent.mm.n.b.ln(this.contact.field_type))) {
          break label1927;
        }
        localObject1 = (KeyValuePreference)this.screen.aPN("contact_info_signature");
        if (localObject1 != null)
        {
          ((KeyValuePreference)localObject1).HET = false;
          ((KeyValuePreference)localObject1).setTitle(this.iMV.getString(2131757822));
          ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.iMV, this.contact.signature));
          ((KeyValuePreference)localObject1).wV(false);
        }
        label1406:
        this.screen.aPN("contact_info_facebook");
        this.screen.aPO("contact_info_facebook");
        if ((this.vKL.iKe & 0x1) <= 0) {
          break label1943;
        }
        i = 1;
        label1446:
        if (((i & com.tencent.mm.br.d.aCT("sns")) == 0) || (com.tencent.mm.storage.ai.aNa(this.contact.field_username)) || (this.contact.aaH())) {
          break label1948;
        }
        localObject1 = (com.tencent.mm.ui.base.preference.g)this.screen.aPN("contact_info_sns");
        if ((localObject1 != null) && (com.tencent.mm.plugin.sns.b.o.xMb != null)) {
          ((com.tencent.mm.ui.base.preference.g)localObject1).aHC(this.contact.field_username);
        }
        label1522:
        this.screen.aPO("contact_info_verifyuser");
        this.screen.aPO("contact_info_footer_normal");
        this.vKV = new com.tencent.mm.plugin.profile.a.b(this.iMV, this.contact);
        this.vKV.cYk();
        if (this.iMg == 96) {
          this.screen.aPO("contact_info_footer_normal");
        }
        if (!com.tencent.mm.n.b.ln(this.contact.field_type)) {
          break label1964;
        }
        dqo();
        this.screen.aPO("contact_info_social");
        label1626:
        dqm();
        dqn();
        localObject1 = (NormalUserFooterPreference)this.screen.aPN("contact_info_footer_normal");
        boolean bool1 = this.iMV.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean bool2 = this.iMV.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.iMV.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long l = this.iMV.getIntent().getLongExtra("Contact_Uin", -1L);
        if ((this.iMg == 30) || (this.iMg == 45)) {
          this.vKM = false;
        }
        if ((localObject1 == null) || (!((NormalUserFooterPreference)localObject1).a(this.contact, this.sBi, this.vIS, this.vIT, this.vKM, this.iMg, this.vKF, bool2, bool1, l, this.vKN))) {
          break label1984;
        }
        ((NormalUserFooterPreference)localObject1).huf.removeAll();
        ((NormalUserFooterPreference)localObject1).huf.a(new NormalUserFooterPreference.e() {}, Looper.getMainLooper());
      }
    }
    for (;;)
    {
      label1297:
      this.screen.aPO("clear_lbs_info");
      if (this.vKS)
      {
        this.screen.removeAll();
        if (localObject2 != null) {
          this.screen.b((Preference)localObject2);
        }
        if (localObject1 != null) {
          this.screen.b((Preference)localObject1);
        }
      }
      AppMethodBeat.o(27194);
      return;
      localObject1 = "  " + this.contact.getCity();
      break;
      this.screen.aPO("contact_info_district");
      break label1297;
      label1927:
      this.screen.aPO("contact_info_signature");
      break label1406;
      label1943:
      i = 0;
      break label1446;
      label1948:
      this.screen.aPO("contact_info_sns");
      break label1522;
      label1964:
      dql();
      this.screen.aPO("contact_info_more");
      break label1626;
      label1984:
      this.screen.aPO("contact_info_footer_normal");
    }
  }
  
  private void dql()
  {
    Object localObject4 = null;
    AppMethodBeat.i(27192);
    ContactSocialInfoPreference localContactSocialInfoPreference = (ContactSocialInfoPreference)this.screen.aPN("contact_info_social");
    if (localContactSocialInfoPreference != null)
    {
      if (bs.isNullOrNil(this.vKX)) {
        break label414;
      }
      localContactSocialInfoPreference.Lo(0);
      this.vKW = 1;
    }
    for (;;)
    {
      com.tencent.mm.model.az.ayM();
      int i = bs.m((Integer)com.tencent.mm.model.c.agA().get(9, null));
      long l = this.iMV.getIntent().getLongExtra("Contact_Uin", 0L);
      Object localObject1 = this.iMV.getIntent().getStringExtra("Contact_QQNick");
      Object localObject2;
      if ((l != 0L) && (i != 0))
      {
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().qC(l);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = null;
          }
          if (localObject1 != null) {
            ((as)localObject1).getDisplayName();
          }
        }
        if ((l != -1L) && (new p(l).longValue() > 0L))
        {
          localContactSocialInfoPreference.Lk(0);
          this.vKW = 1;
        }
      }
      else
      {
        label192:
        if ((bs.isNullOrNil(this.vJL)) || (bs.isNullOrNil(this.vKR))) {
          break label434;
        }
        localContactSocialInfoPreference.Lm(0);
        this.vKW = 1;
        label223:
        localObject1 = com.tencent.mm.m.g.ZY().getValue("LinkedinPluginClose");
        if ((!bs.isNullOrNil((String)localObject1)) && (bs.getInt((String)localObject1, 0) != 0)) {
          break label444;
        }
        i = 1;
        label253:
        if ((i == 0) || (bs.isNullOrNil(this.contact.eyh))) {
          break label449;
        }
        localContactSocialInfoPreference.Ll(0);
        this.vKW = 1;
        label281:
        if (!u.axw().equals(this.contact.field_username)) {
          break label459;
        }
        com.tencent.mm.model.az.ayM();
        localObject1 = (String)com.tencent.mm.model.c.agA().get(ah.a.GGT, null);
        localObject2 = localObject4;
        if (bs.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        localObject2 = new JSONObject((String)localObject1).optString("ShopUrl");
        ac.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[] { localObject1, localObject2 });
        if (!bs.isNullOrNil((String)localObject2))
        {
          localContactSocialInfoPreference.Ln(0);
          this.vKW = 1;
          if (this.vKW == 0) {
            this.screen.aPO("contact_info_social");
          }
          AppMethodBeat.o(27192);
          return;
          label414:
          localContactSocialInfoPreference.Lo(8);
          continue;
          localContactSocialInfoPreference.Lk(8);
          break label192;
          label434:
          localContactSocialInfoPreference.Lm(8);
          break label223;
          label444:
          i = 0;
          break label253;
          label449:
          localContactSocialInfoPreference.Ll(8);
          break label281;
          label459:
          localObject1 = this.contact.eyk;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
          Object localObject3 = localObject4;
          continue;
          localContactSocialInfoPreference.Ln(8);
        }
      }
    }
  }
  
  private void dqm()
  {
    AppMethodBeat.i(27195);
    if (com.tencent.mm.n.b.ln(this.contact.field_type))
    {
      this.screen.aPO("contact_info_source");
      AppMethodBeat.o(27195);
      return;
    }
    int i = this.iMV.getIntent().getIntExtra("Contact_Source_FMessage", 0);
    ac.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.contact.getSource() + ", sourceFMessage = " + i);
    if (i != 0)
    {
      Ls(i);
      AppMethodBeat.o(27195);
      return;
    }
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aPN("contact_info_source");
    if (this.vIT) {
      switch (this.contact.getSource())
      {
      default: 
        this.screen.d(localKeyValuePreference);
        AppMethodBeat.o(27195);
        return;
      case 18: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.HET = false;
        localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
        localKeyValuePreference.setSummary(2131757850);
        localKeyValuePreference.wV(false);
        AppMethodBeat.o(27195);
        return;
      case 30: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.HET = false;
        localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
        localKeyValuePreference.setSummary(2131757855);
        localKeyValuePreference.wV(false);
        AppMethodBeat.o(27195);
        return;
      case 48: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.HET = false;
        localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
        localKeyValuePreference.setSummary(this.iMV.getString(2131757857));
        localKeyValuePreference.wV(false);
        AppMethodBeat.o(27195);
        return;
      case 22: 
      case 23: 
      case 24: 
      case 26: 
      case 27: 
      case 28: 
      case 29: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.HET = false;
        localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
        localKeyValuePreference.setSummary(2131757868);
        localKeyValuePreference.wV(false);
        AppMethodBeat.o(27195);
        return;
      case 34: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.HET = false;
        localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
        localKeyValuePreference.setSummary(this.iMV.getString(2131757834));
        localKeyValuePreference.wV(false);
        AppMethodBeat.o(27195);
        return;
      case 58: 
      case 59: 
      case 60: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.HET = false;
        localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
        localKeyValuePreference.setSummary(this.iMV.getString(2131760022));
        localKeyValuePreference.wV(false);
        AppMethodBeat.o(27195);
        return;
      case 76: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.HET = false;
        localKeyValuePreference.setTitle(this.iMV.getString(2131757874));
        localKeyValuePreference.setSummary(this.iMV.getString(2131757852));
        localKeyValuePreference.wV(false);
        AppMethodBeat.o(27195);
        return;
      }
    } else {
      this.screen.d(localKeyValuePreference);
    }
    AppMethodBeat.o(27195);
  }
  
  private void dqn()
  {
    AppMethodBeat.i(27196);
    this.screen.cK("contact_info_invite_source", true);
    boolean bool1;
    int i;
    if (this.ftP == null)
    {
      bool1 = this.iMV.getIntent().getBooleanExtra("Is_RoomOwner", false);
      if ((this.iMg == 14) && (bool1) && (this.ftP != null) && (!this.contact.field_username.equals(this.ftP.field_roomowner))) {
        break label167;
      }
      i = this.iMg;
      if (this.ftP != null) {
        break label162;
      }
    }
    label162:
    for (boolean bool2 = true;; bool2 = false)
    {
      ac.i("MicroMsg.ContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.screen.cK("contact_info_invite_source", true);
      AppMethodBeat.o(27196);
      return;
      bool1 = this.ftP.Wp();
      break;
    }
    label167:
    this.daC = this.iMV.getIntent().getStringExtra("inviteer");
    if (bs.isNullOrNil(this.daC)) {
      this.daC = this.ftP.aMV(this.contact.field_username);
    }
    if (bs.isNullOrNil(this.daC)) {
      this.daC = com.tencent.mm.model.q.aB(this.contact.field_username, this.fvZ);
    }
    if (bs.isNullOrNil(this.daC))
    {
      ac.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[] { this.fvZ, this.contact.field_username });
      this.vKY.alive();
      ar.a.hnw.a(this.contact.field_username, this.fvZ, new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27182);
          ac.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, k.this.fvZ, Boolean.valueOf(paramAnonymousBoolean) });
          k.this.vKY.dead();
          AppMethodBeat.o(27182);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    this.iMV.getIntent().putExtra("inviteer", this.daC);
    String str = wk(this.daC);
    if (bs.isNullOrNil(str))
    {
      ar.a.hnw.a(this.contact.field_username, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27183);
          ac.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, k.this.fvZ, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            com.tencent.mm.model.az.ayM();
            paramAnonymousString = com.tencent.mm.model.c.awB().aNt(paramAnonymousString).aaR();
            k.this.io(k.this.daC, paramAnonymousString);
          }
          AppMethodBeat.o(27183);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    io(this.daC, str);
    AppMethodBeat.o(27196);
  }
  
  private void dqo()
  {
    int j = 1;
    AppMethodBeat.i(27200);
    int[] arrayOfInt = new int[7];
    ContactMoreInfoPreference localContactMoreInfoPreference = (ContactMoreInfoPreference)this.screen.aPN("contact_info_more");
    label117:
    String str;
    int i;
    if (localContactMoreInfoPreference != null)
    {
      long l = this.iMV.getIntent().getLongExtra("Contact_Uin", 0L);
      if ((l == -1L) || (new p(l).longValue() <= 0L)) {
        break label319;
      }
      localContactMoreInfoPreference.Lk(0);
      arrayOfInt[0] = 0;
      if ((bs.isNullOrNil(this.vJL)) || (bs.isNullOrNil(this.vKR))) {
        break label335;
      }
      localContactMoreInfoPreference.Lm(0);
      arrayOfInt[1] = 0;
      str = com.tencent.mm.m.g.ZY().getValue("LinkedinPluginClose");
      i = j;
      if (!bs.isNullOrNil(str))
      {
        if (bs.getInt(str, 0) != 0) {
          break label351;
        }
        i = j;
      }
      label149:
      if ((i == 0) || (bs.isNullOrNil(this.contact.eyh))) {
        break label356;
      }
      localContactMoreInfoPreference.Ll(0);
      arrayOfInt[2] = 0;
      label177:
      if (!u.axw().equals(this.contact.field_username)) {
        break label372;
      }
      com.tencent.mm.model.az.ayM();
      str = (String)com.tencent.mm.model.c.agA().get(ah.a.GGT, null);
      label212:
      if (bs.isNullOrNil(str)) {
        break label400;
      }
    }
    for (;;)
    {
      try
      {
        str = new JSONObject(str).optString("ShopUrl");
        if (bs.isNullOrNil(str)) {
          break label406;
        }
        localContactMoreInfoPreference.Ln(0);
        arrayOfInt[3] = 0;
        if (!bs.isNullOrNil(this.contact.signature)) {
          break label422;
        }
        arrayOfInt[4] = 8;
        if (this.contact.getSource() > 0) {
          break label430;
        }
        arrayOfInt[5] = 8;
        arrayOfInt[6] = 8;
        this.screen.cK("contact_info_more", false);
        AppMethodBeat.o(27200);
        return;
      }
      catch (JSONException localJSONException)
      {
        label319:
        label335:
        label351:
        label356:
        label372:
        ac.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
      }
      localContactMoreInfoPreference.Lk(8);
      arrayOfInt[0] = 8;
      break;
      localContactMoreInfoPreference.Lm(8);
      arrayOfInt[1] = 8;
      break label117;
      i = 0;
      break label149;
      localContactMoreInfoPreference.Ll(8);
      arrayOfInt[2] = 8;
      break label177;
      str = this.contact.eyk;
      break label212;
      label400:
      Object localObject = null;
      continue;
      label406:
      localContactMoreInfoPreference.Ln(8);
      arrayOfInt[3] = 8;
      continue;
      label422:
      arrayOfInt[4] = 0;
      continue;
      label430:
      arrayOfInt[5] = 0;
    }
  }
  
  private String wk(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27198);
    if (this.ftP == null)
    {
      AppMethodBeat.o(27198);
      return null;
    }
    com.tencent.mm.model.az.ayM();
    com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(paramString);
    Object localObject1 = localObject2;
    if (localai != null)
    {
      localObject1 = localObject2;
      if ((int)localai.fLJ > 0) {
        localObject1 = localai.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bs.isNullOrNil((String)localObject1)) {
      localObject2 = this.ftP.wk(paramString);
    }
    paramString = (String)localObject2;
    if (bs.isNullOrNil((String)localObject2))
    {
      paramString = (String)localObject2;
      if (localai != null) {
        paramString = localai.aaR();
      }
    }
    AppMethodBeat.o(27198);
    return paramString;
  }
  
  public final boolean WZ(String paramString)
  {
    AppMethodBeat.i(27190);
    Object localObject2;
    Object localObject1;
    long l;
    if (paramString.equals("contact_info_sns"))
    {
      com.tencent.mm.model.az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.iMV, null);
        AppMethodBeat.o(27190);
        return true;
      }
      localObject2 = this.iMV.getIntent();
      ((Intent)localObject2).putExtra("sns_source", this.dga);
      ((Intent)localObject2).putExtra("sns_signature", this.contact.signature);
      ((Intent)localObject2).putExtra("sns_nickName", this.contact.aaR());
      ((Intent)localObject2).putExtra("sns_title", this.contact.aaS());
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.b.o.xMf != null) {
        localObject1 = com.tencent.mm.plugin.sns.b.o.xMf.f((Intent)localObject2, this.contact.field_username);
      }
      if (localObject1 == null) {
        this.iMV.finish();
      }
    }
    else
    {
      if (!paramString.equals("contact_info_more")) {
        break label508;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(this.iMV, ContactMoreInfoUI.class);
      ((Intent)localObject2).putExtra("Is_RoomOwner", this.iMV.getIntent().getBooleanExtra("Is_RoomOwner", false));
      ((Intent)localObject2).putExtra("Contact_User", this.contact.field_username);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendNickName", this.vKT);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendPubUrl", this.vKU);
      localObject1 = this.iMV.getIntent().getStringExtra("room_name");
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = this.iMV.getIntent().getStringExtra("Contact_ChatRoomId");
      }
      ((Intent)localObject2).putExtra("Contact_ChatRoomId", paramString);
      ((Intent)localObject2).putExtra("verify_gmail", this.vJL);
      ((Intent)localObject2).putExtra("profileName", this.vKR);
      l = this.iMV.getIntent().getLongExtra("Contact_Uin", 0L);
      paramString = this.iMV.getIntent().getStringExtra("Contact_QQNick");
      ((Intent)localObject2).putExtra("Contact_Uin", l);
      ((Intent)localObject2).putExtra("Contact_QQNick", paramString);
      paramString = this.iMV;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(27190);
      return true;
      ((Intent)localObject1).putExtra("sns_adapter_type", 1);
      com.tencent.mm.br.d.b(this.iMV, "sns", ".ui.SnsTimeLineUserPagerUI", (Intent)localObject1);
      if ((((Intent)localObject1).getFlags() & 0x4000000) == 0) {
        break;
      }
      this.iMV.finish();
      break;
      label508:
      if (paramString.equals("contact_info_social"))
      {
        paramString = new Intent();
        paramString.setClass(this.iMV, ContactSocialInfoUI.class);
        paramString.putExtra("Contact_User", this.contact.field_username);
        l = this.iMV.getIntent().getLongExtra("Contact_Uin", 0L);
        localObject1 = this.iMV.getIntent().getStringExtra("Contact_QQNick");
        paramString.putExtra("Contact_Uin", l);
        paramString.putExtra("Contact_QQNick", (String)localObject1);
        paramString.putExtra("profileName", this.vKR);
        paramString.putExtra("verify_gmail", this.vJL);
        localObject1 = this.iMV.getIntent().getStringExtra("Contact_Mobile_MD5");
        localObject2 = this.iMV.getIntent().getStringExtra("Contact_full_Mobile_MD5");
        paramString.putExtra("Contact_Mobile_MD5", (String)localObject1);
        paramString.putExtra("Contact_full_Mobile_MD5", (String)localObject2);
        localObject1 = this.iMV;
        paramString = new com.tencent.mm.hellhoundlib.b.a().ba(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.aeD(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)paramString.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.screen.aPN("contact_info_invite_source")).getExtras().getString("inviteer");
        if (!bs.isNullOrNil(paramString))
        {
          localObject1 = wk(paramString);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", paramString);
          ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomMember", true);
          ((Intent)localObject2).putExtra("room_name", this.fvZ);
          com.tencent.mm.model.az.ayM();
          ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.awB().aNt(paramString).field_nickname);
          ((Intent)localObject2).putExtra("Contact_Scene", 14);
          ((Intent)localObject2).putExtra("Is_RoomOwner", true);
          ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fvZ);
          com.tencent.mm.plugin.profile.b.iyx.c((Intent)localObject2, this.iMV);
        }
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(27203);
    paramString = (com.tencent.mm.ui.base.preference.g)this.screen.aPN("contact_info_sns");
    if ((paramString != null) && (com.tencent.mm.plugin.sns.b.o.xMb != null)) {
      paramString.aHC(this.contact.field_username);
    }
    this.vKL = com.tencent.mm.plugin.sns.b.o.xMb.b(this.contact.field_username, this.vKL);
    this.screen.notifyDataSetChanged();
    if (paramb.dGi())
    {
      ac.d("MicroMsg.ContactWidgetNormal", "bg Change!");
      if (com.tencent.mm.plugin.sns.b.o.xMf != null) {
        com.tencent.mm.plugin.sns.b.o.xMf.asI(this.contact.field_username);
      }
    }
    AppMethodBeat.o(27203);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, com.tencent.mm.storage.ai paramai, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(27193);
    boolean bool;
    if (paramai != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bs.nullAsNil(paramai.field_username).length() <= 0) {
        break label601;
      }
      bool = true;
      label37:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label607;
      }
      bool = true;
      label49:
      Assert.assertTrue(bool);
      this.screen = paramf;
      this.contact = paramai;
      this.vIS = paramBoolean;
      this.iMg = paramInt;
      this.vIT = this.iMV.getIntent().getBooleanExtra("User_Verify", false);
      this.sBi = bs.nullAsNil(this.iMV.getIntent().getStringExtra("Verify_ticket"));
      this.vKM = this.iMV.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
      this.vKF = this.iMV.getIntent().getIntExtra("Kdel_from", -1);
      this.vKN = this.iMV.getIntent().getStringExtra("Contact_RemarkName");
      this.dga = this.iMV.getIntent().getIntExtra("Sns_from_Scene", 0);
      this.vKP = this.iMV.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
      this.vKQ = this.iMV.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
      this.vKO = this.iMV.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
      long l = this.iMV.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
      paramf = bs.bG(this.iMV.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
      this.vJL = bs.bG(this.iMV.getIntent().getStringExtra("verify_gmail"), "");
      this.vKR = bs.bG(this.iMV.getIntent().getStringExtra("profileName"), bs.aLI(this.vJL));
      this.vKL.iKe = this.vKO;
      this.vKL.iKg = l;
      this.vKL.iKf = paramf;
      this.vKT = this.iMV.getIntent().getStringExtra("KLinkedInAddFriendNickName");
      this.vKU = this.iMV.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
      if (com.tencent.mm.plugin.sns.b.o.xMb != null) {
        this.vKL = com.tencent.mm.plugin.sns.b.o.xMb.b(paramai.field_username, this.vKL);
      }
      this.fvZ = this.iMV.getIntent().getStringExtra("room_name");
      com.tencent.mm.model.az.ayM();
      this.ftP = com.tencent.mm.model.c.awK().xN(this.fvZ);
      if (paramai.field_deleteFlag != 1) {
        break label613;
      }
    }
    label601:
    label607:
    label613:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.vKS = paramBoolean;
      dqc();
      com.tencent.mm.model.az.ayM();
      com.tencent.mm.model.c.awB().aNo(paramai.field_username);
      paramBoolean = u.axw().equals(paramai.field_username);
      ac.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[] { Integer.valueOf(this.vKL.iKe) });
      paramInt = i;
      if ((this.vKL.iKe & 0x1) > 0) {
        paramInt = 1;
      }
      if ((!paramai.aaH()) && (!com.tencent.mm.storage.ai.aNa(paramai.field_username)) && (paramInt != 0) && (com.tencent.mm.plugin.sns.b.o.xMf != null)) {
        com.tencent.mm.plugin.sns.b.o.xMf.a(2, paramai.field_username, paramBoolean, this.dga);
      }
      AppMethodBeat.o(27193);
      return true;
      bool = false;
      break;
      bool = false;
      break label37;
      bool = false;
      break label49;
    }
  }
  
  final void apF(String paramString)
  {
    AppMethodBeat.i(27191);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(27191);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.iMg);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.contact.field_username);
    paramString.putExtra("Contact_Nick", this.contact.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.contact.field_conRemark);
    com.tencent.mm.plugin.profile.b.iyx.n(paramString, this.iMV);
    AppMethodBeat.o(27191);
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27201);
    if (com.tencent.mm.plugin.sns.b.o.xMf != null) {
      com.tencent.mm.plugin.sns.b.o.xMf.a(this, 3);
    }
    com.tencent.mm.model.az.agi().b(30, this);
    com.tencent.mm.model.az.agi().b(453, this);
    Object localObject = (NormalProfileHeaderPreference)this.screen.aPN("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (NormalUserFooterPreference)this.screen.aPN("contact_info_footer_normal");
    if (localObject != null) {
      ((NormalUserFooterPreference)localObject).bYJ();
    }
    localObject = (FriendPreference)this.screen.aPN("contact_info_friend_qq");
    if (localObject != null) {
      ((FriendPreference)localObject).bYJ();
    }
    localObject = (FriendPreference)this.screen.aPN("contact_info_friend_mobile");
    if (localObject != null) {
      ((FriendPreference)localObject).bYJ();
    }
    localObject = (FriendPreference)this.screen.aPN("contact_info_facebook");
    if (localObject != null) {
      ((FriendPreference)localObject).bYJ();
    }
    if (this.vKV != null) {
      this.vKV.destroy();
    }
    this.screen.aPN("contact_info_sns");
    AppMethodBeat.o(27201);
    return true;
  }
  
  final void io(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27197);
    ac.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aPN("contact_info_invite_source");
    TextPreference localTextPreference = (TextPreference)this.screen.aPN("contact_info_hint");
    this.screen.cK("contact_info_invite_source", false);
    SpannableString localSpannableString = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.c(this.iMV, this.iMV.getResources().getString(2131757692, new Object[] { paramString2 })));
    localSpannableString.setSpan(new ForegroundColorSpan(this.iMV.getResources().getColor(2131100035)), 0, paramString2.length(), 33);
    localKeyValuePreference.setSummary(localSpannableString);
    localKeyValuePreference.getExtras().putString("inviteer", paramString1);
    this.iMV.getIntent().putExtra("inviteer", paramString1);
    if ((this.ftP != null) && (!this.ftP.aDl().contains(this.contact.field_username)))
    {
      this.screen.cK("contact_info_footer_normal", true);
      localTextPreference.am(com.tencent.mm.pluginsdk.ui.span.k.c(this.iMV, this.iMV.getResources().getString(2131757745, new Object[] { wk(this.contact.field_username) })));
      AppMethodBeat.o(27197);
      return;
    }
    this.screen.cK("contact_info_footer_normal", false);
    AppMethodBeat.o(27197);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27202);
    if ((paramn.getType() != 30) && (paramn.getType() != 458))
    {
      ac.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(27202);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 30)
      {
        paramString = (com.tencent.mm.pluginsdk.model.o)paramn;
        if ((paramString.dgL != 1) && (paramString.dgL != 3))
        {
          AppMethodBeat.o(27202);
          return;
        }
        if ((paramString.Dhk != null) && (!paramString.Dhk.contains(this.contact.field_username)))
        {
          AppMethodBeat.o(27202);
          return;
        }
        paramString = (NormalUserHeaderPreference)this.screen.aPN("contact_info_header_normal");
        NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.aPN("contact_info_footer_normal");
        if ((paramString != null) && (localNormalUserFooterPreference != null) && (localNormalUserFooterPreference.vMC))
        {
          ac.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
          this.vKP = false;
          this.vKQ = false;
          paramString.cy(this.contact.field_username, false);
          paramString.cz(this.contact.field_username, false);
          paramString.Af(this.contact.field_username);
          this.iMV.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.vKP);
          this.iMV.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.vKQ);
        }
      }
      if (paramn.getType() == 453)
      {
        dqc();
        AppMethodBeat.o(27202);
      }
    }
    else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bs.isNullOrNil(paramString)))
    {
      Toast.makeText(this.iMV, paramString, 1).show();
    }
    AppMethodBeat.o(27202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */