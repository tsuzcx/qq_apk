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
import com.tencent.mm.al.n;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.n.e;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
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

@com.tencent.mm.sdk.platformtools.k(fkb={ContactInfoUI.class})
public final class k
  implements com.tencent.mm.al.f, i.a, com.tencent.mm.pluginsdk.b.a
{
  am contact;
  String dlW;
  private int drw;
  ab fLO;
  MMActivity fLP;
  String fPi;
  int jfq;
  private com.tencent.mm.ui.base.preference.f screen;
  private String txJ;
  private boolean wPZ;
  private String wQU;
  private boolean wQa;
  private int wRO;
  private dhg wRU;
  private boolean wRV;
  private String wRW;
  private int wRX;
  private boolean wRY;
  private boolean wRZ;
  private String wSa;
  private boolean wSb;
  private String wSc;
  private String wSd;
  private com.tencent.mm.plugin.profile.a.b wSe;
  private int wSf;
  String wSg;
  com.tencent.mm.sdk.b.c<bb> wSh;
  
  private void MU(int paramInt)
  {
    AppMethodBeat.i(27199);
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aVD("contact_info_source");
    if (!this.wQa)
    {
      if (localKeyValuePreference != null)
      {
        if (paramInt == 10)
        {
          localKeyValuePreference.JsK = false;
          localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
          localKeyValuePreference.setSummary(this.fLP.getString(2131759466));
          localKeyValuePreference.xG(false);
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
            localKeyValuePreference.JsK = false;
            localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
            localKeyValuePreference.setSummary(2131757862);
            localKeyValuePreference.xG(false);
            AppMethodBeat.o(27199);
            return;
          } while (localKeyValuePreference == null);
          localKeyValuePreference.JsK = false;
          localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
          localKeyValuePreference.setSummary(2131757865);
          localKeyValuePreference.xG(false);
          AppMethodBeat.o(27199);
          return;
        } while (localKeyValuePreference == null);
        localKeyValuePreference.JsK = false;
        localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
        localObject2 = v.zf(this.fLP.getIntent().getStringExtra("source_from_user_name"));
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject1 = this.fLP.getIntent().getStringExtra("source_from_nick_name");
        }
        if (bt.isNullOrNil((String)localObject1)) {
          localKeyValuePreference.setSummary(2131757842);
        }
        for (;;)
        {
          localKeyValuePreference.xG(false);
          AppMethodBeat.o(27199);
          return;
          localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fLP, this.fLP.getString(2131757841, new Object[] { localObject1 })));
        }
      } while (localKeyValuePreference == null);
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localObject1 = com.tencent.mm.bk.d.aMn().apM(this.contact.field_username);
      ba.aBQ();
      Object localObject2 = com.tencent.mm.model.c.azp();
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject1 = ((bp)localObject2).Bf((String)localObject1);
        if (localObject1 == null) {
          break label995;
        }
      }
      break;
    }
    label995:
    for (Object localObject1 = ((aw)localObject1).field_nickname;; localObject1 = null)
    {
      if (!bt.isNullOrNil((String)localObject1)) {
        localKeyValuePreference.setSummary(this.fLP.getString(2131757848, new Object[] { localObject1 }));
      }
      for (;;)
      {
        localKeyValuePreference.xG(false);
        AppMethodBeat.o(27199);
        return;
        localObject1 = ((bh)localObject1).field_chatroomName;
        break;
        localKeyValuePreference.setSummary(2131757846);
      }
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localKeyValuePreference.setSummary(this.fLP.getString(2131759467));
      localKeyValuePreference.xG(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757871);
      localKeyValuePreference.xG(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757837);
      localKeyValuePreference.xG(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757855);
      localKeyValuePreference.xG(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localKeyValuePreference.setSummary(this.fLP.getString(2131760022));
      localKeyValuePreference.xG(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localKeyValuePreference.setSummary(this.fLP.getString(2131757857));
      localKeyValuePreference.xG(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757859);
      localKeyValuePreference.xG(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JsK = false;
      localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757850);
      localKeyValuePreference.xG(false);
      AppMethodBeat.o(27199);
      return;
    }
  }
  
  private void dAF()
  {
    AppMethodBeat.i(27194);
    cdn();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951648);
    if (com.tencent.mm.plugin.sns.b.o.zbX != null) {
      com.tencent.mm.plugin.sns.b.o.zbX.a(3, this.contact.field_username, this);
    }
    ba.aiU().a(30, this);
    ba.aiU().a(453, this);
    this.wSg = "";
    ad.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[] { this.contact.adr() });
    if (!this.contact.adr())
    {
      localObject1 = null;
      localObject2 = this.fLP.getIntent().getStringExtra("Contact_Mobile_MD5");
      localObject3 = this.fLP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil((String)localObject3))) {
        break label741;
      }
      if (!bt.isNullOrNil(this.contact.field_username))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(this.contact.field_username);
        localObject3 = this.contact.field_username;
        if (localObject2 != null) {
          break label733;
        }
        localObject1 = "true";
        ad.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject1 });
        localObject1 = localObject2;
      }
      label248:
      if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Lb())))
      {
        this.wSg = bt.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aSD()).replace(" ", "");
        ad.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[] { this.contact.field_username, this.wSg });
      }
    }
    Object localObject2 = (NormalUserHeaderPreference)this.screen.aVD("contact_info_header_normal");
    label427:
    int j;
    if (localObject2 != null)
    {
      ((NormalUserHeaderPreference)localObject2).a(this.contact, this.jfq, this.txJ, this.wSg, this.contact.ePJ);
      ((NormalUserHeaderPreference)localObject2).cD(this.contact.field_username, this.wRY);
      ((NormalUserHeaderPreference)localObject2).FgC = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27181);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = k.this;
          if (paramAnonymousView.getId() == 2131304604) {
            com.tencent.mm.plugin.report.service.g.yhR.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aG(((k)localObject).fLP.getIntent())), Integer.valueOf(2), Integer.valueOf(1), ((k)localObject).contact.field_username });
          }
          if (((k)localObject).contact == null) {
            ad.e("MicroMsg.ContactWidgetNormal", "contact is null");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27181);
            return;
            if (!com.tencent.mm.o.b.lM(((k)localObject).contact.field_type))
            {
              if (!bt.isNullOrNil(((k)localObject).contact.field_encryptUsername)) {
                ((k)localObject).auL(((k)localObject).contact.field_encryptUsername);
              } else {
                ((k)localObject).auL(((k)localObject).contact.field_username);
              }
            }
            else
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_Scene", ((k)localObject).jfq);
              paramAnonymousView.putExtra("Contact_User", ((k)localObject).contact.field_username);
              paramAnonymousView.putExtra("Contact_RoomNickname", ((k)localObject).fLP.getIntent().getStringExtra("Contact_RoomNickname"));
              paramAnonymousView.putExtra("view_mode", true);
              paramAnonymousView.putExtra("contact_phone_number_by_md5", ((k)localObject).wSg);
              paramAnonymousView.putExtra("contact_phone_number_list", ((k)localObject).contact.ePJ);
              com.tencent.mm.plugin.profile.b.iRG.m(paramAnonymousView, ((k)localObject).fLP);
            }
          }
        }
      };
      if (com.tencent.mm.o.b.lM(this.contact.field_type)) {
        this.wRZ = false;
      }
      ((NormalUserHeaderPreference)localObject2).cE(this.contact.field_username, this.wRZ);
      if ((!am.aSQ(this.contact.field_username)) || (this.contact.ePM == 0)) {
        break label1181;
      }
      j = this.screen.indexOf("contact_info_category_1");
      localObject1 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_custom_info_header", b.a.iHt);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new PreferenceTitleCategory(this.fLP);
        ((Preference)localObject3).setTitle((CharSequence)localObject1);
        this.screen.a((Preference)localObject3, j);
        ((Preference)localObject3).Jtu = new Preference.b()
        {
          public final boolean dAh()
          {
            return false;
          }
        };
      }
      localObject1 = new com.tencent.mm.openim.a.c();
      ((com.tencent.mm.openim.a.c)localObject1).IE(this.contact.ePN);
      localObject1 = ((com.tencent.mm.openim.a.c)localObject1).iHw.iterator();
      label579:
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (c.a)((Iterator)localObject1).next();
        localObject4 = ((c.a)localObject3).iHx.iterator();
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
        KeyValuePreference local5 = new KeyValuePreference(this.fLP)
        {
          public final void onBindView(View paramAnonymousView)
          {
            AppMethodBeat.i(27184);
            super.onBindView(paramAnonymousView);
            if (this.wSo != null) {
              if ((localb.action != 2) && (localb.action != 3)) {
                break label113;
              }
            }
            label113:
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                this.wSo.setTextColor(aj.getResources().getColorStateList(2131100733));
              }
              if ((this.JsQ != null) && (!TextUtils.isEmpty(localb.dDH)))
              {
                this.JsQ.setVisibility(0);
                com.tencent.mm.aw.q.aIJ().loadImage(localb.dDH, this.JsQ);
              }
              AppMethodBeat.o(27184);
              return;
            }
          }
        };
        local5.JaR = ((c.a)localObject3).title;
        local5.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fLP, localb.IF(this.contact.field_openImAppid)));
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
          if ((bt.isNullOrNil((String)localObject2)) && (bt.isNullOrNil((String)localObject3))) {
            break label248;
          }
          ad.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { this.contact.field_username, localObject2, localObject3 });
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).Lb())) {}
          }
          else
          {
            localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx((String)localObject3);
          }
          localObject3 = this.contact.field_username;
          if (localObject1 == null) {}
          for (localObject2 = "true";; localObject2 = "false")
          {
            ad.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject2 });
            break;
          }
          this.screen.d((Preference)localObject2);
          break label427;
        }
        if (localb.action == 2)
        {
          local5.Jtu = new Preference.b()
          {
            public final boolean dAh()
            {
              AppMethodBeat.i(27185);
              Object localObject1 = localb.iHz;
              try
              {
                localObject2 = new JSONObject(localb.iHz).optString("tel");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ad.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.wPr.title });
              localObject2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(localObject1))));
              ((Intent)localObject2).setFlags(268435456);
              localObject1 = k.this.fLP;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27185);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 3)
        {
          local5.Jtu = new Preference.b()
          {
            public final boolean dAh()
            {
              AppMethodBeat.i(27186);
              Object localObject1 = "";
              try
              {
                localObject2 = new JSONObject(localb.iHz).optString("mailto");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ad.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.wPr.title });
              localObject2 = new Intent("android.intent.action.SENDTO");
              ((Intent)localObject2).setData(Uri.parse("mailto:".concat(String.valueOf(localObject1))));
              localObject1 = k.this.fLP;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27186);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 4)
        {
          local5.Jtu = new Preference.b()
          {
            public final boolean dAh()
            {
              AppMethodBeat.i(27187);
              Intent localIntent = new Intent();
              localIntent.setFlags(268435456);
              localIntent.setClassName(aj.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
              Object localObject1 = "";
              try
              {
                localObject2 = new JSONObject(localb.iHz).optString("url");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ad.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.g.yhR.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.wPr.title });
              localIntent.putExtra("geta8key_scene", 58);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localObject1 = aj.getContext();
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
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
            local5.Jtu = new Preference.b()
            {
              public final boolean dAh()
              {
                AppMethodBeat.i(27188);
                try
                {
                  Object localObject = new JSONObject(localb.iHz);
                  String str = ((JSONObject)localObject).optString("name");
                  localObject = ((JSONObject)localObject).optString("pagepath");
                  vm localvm = new vm();
                  localvm.dJF.userName = str;
                  localvm.dJF.dJH = bt.bI((String)localObject, "");
                  com.tencent.mm.sdk.b.a.IbL.l(localvm);
                  com.tencent.mm.plugin.report.service.g.yhR.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.wPr.title });
                  AppMethodBeat.o(27188);
                  return true;
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    ad.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
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
    this.screen.a(new PreferenceSmallCategory(this.fLP), i);
    Object localObject1 = new KeyValuePreference(this.fLP);
    ((KeyValuePreference)localObject1).setTitle(2131757648);
    Object localObject3 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_intro_desc", b.a.iHt);
    ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fLP, (CharSequence)localObject3));
    Object localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_intro_url", b.a.iHu);
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((Preference)localObject1).Jtu = new k.10(this, (String)localObject4, (String)localObject3);
    }
    this.screen.a((Preference)localObject1, i + 1);
    label1181:
    if (!bt.isNullOrNil(this.contact.getProvince()))
    {
      localObject3 = (KeyValuePreference)this.screen.aVD("contact_info_district");
      if (localObject3 != null)
      {
        ((KeyValuePreference)localObject3).setTitle(this.fLP.getString(2131757646));
        localObject4 = new StringBuilder().append(v.zh(this.contact.getProvince()));
        if (bt.isNullOrNil(this.contact.getCity()))
        {
          localObject1 = "";
          ((KeyValuePreference)localObject3).setSummary((String)localObject1);
          ((KeyValuePreference)localObject3).xG(false);
          ((KeyValuePreference)localObject3).setEnabled(false);
        }
      }
      else
      {
        if ((this.contact.signature == null) || (this.contact.signature.trim().equals("")) || (com.tencent.mm.o.b.lM(this.contact.field_type))) {
          break label1927;
        }
        localObject1 = (KeyValuePreference)this.screen.aVD("contact_info_signature");
        if (localObject1 != null)
        {
          ((KeyValuePreference)localObject1).JsK = false;
          ((KeyValuePreference)localObject1).setTitle(this.fLP.getString(2131757822));
          ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fLP, this.contact.signature));
          ((KeyValuePreference)localObject1).xG(false);
        }
        label1406:
        this.screen.aVD("contact_info_facebook");
        this.screen.aVE("contact_info_facebook");
        if ((this.wRU.jdn & 0x1) <= 0) {
          break label1943;
        }
        i = 1;
        label1446:
        if (((i & com.tencent.mm.bs.d.aIu("sns")) == 0) || (am.aSO(this.contact.field_username)) || (this.contact.adk())) {
          break label1948;
        }
        localObject1 = (com.tencent.mm.ui.base.preference.g)this.screen.aVD("contact_info_sns");
        if ((localObject1 != null) && (com.tencent.mm.plugin.sns.b.o.zbT != null)) {
          ((com.tencent.mm.ui.base.preference.g)localObject1).aNf(this.contact.field_username);
        }
        label1522:
        this.screen.aVE("contact_info_verifyuser");
        this.screen.aVE("contact_info_footer_normal");
        this.wSe = new com.tencent.mm.plugin.profile.a.b(this.fLP, this.contact);
        this.wSe.dhw();
        if (this.jfq == 96) {
          this.screen.aVE("contact_info_footer_normal");
        }
        if (!com.tencent.mm.o.b.lM(this.contact.field_type)) {
          break label1964;
        }
        dAR();
        this.screen.aVE("contact_info_social");
        label1626:
        dAP();
        dAQ();
        localObject1 = (NormalUserFooterPreference)this.screen.aVD("contact_info_footer_normal");
        boolean bool1 = this.fLP.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean bool2 = this.fLP.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.fLP.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long l = this.fLP.getIntent().getLongExtra("Contact_Uin", -1L);
        if ((this.jfq == 30) || (this.jfq == 45)) {
          this.wRV = false;
        }
        if ((localObject1 == null) || (!((NormalUserFooterPreference)localObject1).a(this.contact, this.txJ, this.wPZ, this.wQa, this.wRV, this.jfq, this.wRO, bool2, bool1, l, this.wRW))) {
          break label1984;
        }
        ((NormalUserFooterPreference)localObject1).hMx.removeAll();
        ((NormalUserFooterPreference)localObject1).hMx.a(new NormalUserFooterPreference.e() {}, Looper.getMainLooper());
      }
    }
    for (;;)
    {
      label1297:
      this.screen.aVE("clear_lbs_info");
      if (this.wSb)
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
      this.screen.aVE("contact_info_district");
      break label1297;
      label1927:
      this.screen.aVE("contact_info_signature");
      break label1406;
      label1943:
      i = 0;
      break label1446;
      label1948:
      this.screen.aVE("contact_info_sns");
      break label1522;
      label1964:
      dAO();
      this.screen.aVE("contact_info_more");
      break label1626;
      label1984:
      this.screen.aVE("contact_info_footer_normal");
    }
  }
  
  private void dAO()
  {
    Object localObject4 = null;
    AppMethodBeat.i(27192);
    ContactSocialInfoPreference localContactSocialInfoPreference = (ContactSocialInfoPreference)this.screen.aVD("contact_info_social");
    if (localContactSocialInfoPreference != null)
    {
      if (bt.isNullOrNil(this.wSg)) {
        break label414;
      }
      localContactSocialInfoPreference.MQ(0);
      this.wSf = 1;
    }
    for (;;)
    {
      ba.aBQ();
      int i = bt.n((Integer)com.tencent.mm.model.c.ajl().get(9, null));
      long l = this.fLP.getIntent().getLongExtra("Contact_Uin", 0L);
      Object localObject1 = this.fLP.getIntent().getStringExtra("Contact_QQNick");
      Object localObject2;
      if ((l != 0L) && (i != 0))
      {
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().sB(l);
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
          localContactSocialInfoPreference.MM(0);
          this.wSf = 1;
        }
      }
      else
      {
        label192:
        if ((bt.isNullOrNil(this.wQU)) || (bt.isNullOrNil(this.wSa))) {
          break label434;
        }
        localContactSocialInfoPreference.MO(0);
        this.wSf = 1;
        label223:
        localObject1 = com.tencent.mm.n.g.acA().getValue("LinkedinPluginClose");
        if ((!bt.isNullOrNil((String)localObject1)) && (bt.getInt((String)localObject1, 0) != 0)) {
          break label444;
        }
        i = 1;
        label253:
        if ((i == 0) || (bt.isNullOrNil(this.contact.ePF))) {
          break label449;
        }
        localContactSocialInfoPreference.MN(0);
        this.wSf = 1;
        label281:
        if (!u.aAm().equals(this.contact.field_username)) {
          break label459;
        }
        ba.aBQ();
        localObject1 = (String)com.tencent.mm.model.c.ajl().get(al.a.Itl, null);
        localObject2 = localObject4;
        if (bt.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        localObject2 = new JSONObject((String)localObject1).optString("ShopUrl");
        ad.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[] { localObject1, localObject2 });
        if (!bt.isNullOrNil((String)localObject2))
        {
          localContactSocialInfoPreference.MP(0);
          this.wSf = 1;
          if (this.wSf == 0) {
            this.screen.aVE("contact_info_social");
          }
          AppMethodBeat.o(27192);
          return;
          label414:
          localContactSocialInfoPreference.MQ(8);
          continue;
          localContactSocialInfoPreference.MM(8);
          break label192;
          label434:
          localContactSocialInfoPreference.MO(8);
          break label223;
          label444:
          i = 0;
          break label253;
          label449:
          localContactSocialInfoPreference.MN(8);
          break label281;
          label459:
          localObject1 = this.contact.ePI;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
          Object localObject3 = localObject4;
          continue;
          localContactSocialInfoPreference.MP(8);
        }
      }
    }
  }
  
  private void dAP()
  {
    AppMethodBeat.i(27195);
    if (com.tencent.mm.o.b.lM(this.contact.field_type))
    {
      this.screen.aVE("contact_info_source");
      AppMethodBeat.o(27195);
      return;
    }
    int i = this.fLP.getIntent().getIntExtra("Contact_Source_FMessage", 0);
    ad.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.contact.getSource() + ", sourceFMessage = " + i);
    if (i != 0)
    {
      MU(i);
      AppMethodBeat.o(27195);
      return;
    }
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aVD("contact_info_source");
    if (this.wQa) {
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
        localKeyValuePreference.JsK = false;
        localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
        localKeyValuePreference.setSummary(2131757850);
        localKeyValuePreference.xG(false);
        AppMethodBeat.o(27195);
        return;
      case 30: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JsK = false;
        localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
        localKeyValuePreference.setSummary(2131757855);
        localKeyValuePreference.xG(false);
        AppMethodBeat.o(27195);
        return;
      case 48: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JsK = false;
        localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
        localKeyValuePreference.setSummary(this.fLP.getString(2131757857));
        localKeyValuePreference.xG(false);
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
        localKeyValuePreference.JsK = false;
        localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
        localKeyValuePreference.setSummary(2131757868);
        localKeyValuePreference.xG(false);
        AppMethodBeat.o(27195);
        return;
      case 34: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JsK = false;
        localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
        localKeyValuePreference.setSummary(this.fLP.getString(2131757834));
        localKeyValuePreference.xG(false);
        AppMethodBeat.o(27195);
        return;
      case 58: 
      case 59: 
      case 60: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JsK = false;
        localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
        localKeyValuePreference.setSummary(this.fLP.getString(2131760022));
        localKeyValuePreference.xG(false);
        AppMethodBeat.o(27195);
        return;
      case 76: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JsK = false;
        localKeyValuePreference.setTitle(this.fLP.getString(2131757874));
        localKeyValuePreference.setSummary(this.fLP.getString(2131757852));
        localKeyValuePreference.xG(false);
        AppMethodBeat.o(27195);
        return;
      }
    } else {
      this.screen.d(localKeyValuePreference);
    }
    AppMethodBeat.o(27195);
  }
  
  private void dAQ()
  {
    AppMethodBeat.i(27196);
    this.screen.cP("contact_info_invite_source", true);
    boolean bool1;
    int i;
    if (this.fLO == null)
    {
      bool1 = this.fLP.getIntent().getBooleanExtra("Is_RoomOwner", false);
      if ((this.jfq == 14) && (bool1) && (this.fLO != null) && (!this.contact.field_username.equals(this.fLO.field_roomowner))) {
        break label167;
      }
      i = this.jfq;
      if (this.fLO != null) {
        break label162;
      }
    }
    label162:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.i("MicroMsg.ContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.screen.cP("contact_info_invite_source", true);
      AppMethodBeat.o(27196);
      return;
      bool1 = this.fLO.YH();
      break;
    }
    label167:
    this.dlW = this.fLP.getIntent().getStringExtra("inviteer");
    if (bt.isNullOrNil(this.dlW)) {
      this.dlW = this.fLO.aSI(this.contact.field_username);
    }
    if (bt.isNullOrNil(this.dlW)) {
      this.dlW = com.tencent.mm.model.q.aC(this.contact.field_username, this.fPi);
    }
    if (bt.isNullOrNil(this.dlW))
    {
      ad.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[] { this.fPi, this.contact.field_username });
      this.wSh.alive();
      as.a.hFO.a(this.contact.field_username, this.fPi, new as.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27182);
          ad.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, k.this.fPi, Boolean.valueOf(paramAnonymousBoolean) });
          k.this.wSh.dead();
          AppMethodBeat.o(27182);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    this.fLP.getIntent().putExtra("inviteer", this.dlW);
    String str = zf(this.dlW);
    if (bt.isNullOrNil(str))
    {
      as.a.hFO.a(this.contact.field_username, "", new as.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27183);
          ad.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, k.this.fPi, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            ba.aBQ();
            paramAnonymousString = com.tencent.mm.model.c.azp().Bf(paramAnonymousString).adu();
            k.this.iC(k.this.dlW, paramAnonymousString);
          }
          AppMethodBeat.o(27183);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    iC(this.dlW, str);
    AppMethodBeat.o(27196);
  }
  
  private void dAR()
  {
    int j = 1;
    AppMethodBeat.i(27200);
    int[] arrayOfInt = new int[7];
    ContactMoreInfoPreference localContactMoreInfoPreference = (ContactMoreInfoPreference)this.screen.aVD("contact_info_more");
    label117:
    String str;
    int i;
    if (localContactMoreInfoPreference != null)
    {
      long l = this.fLP.getIntent().getLongExtra("Contact_Uin", 0L);
      if ((l == -1L) || (new p(l).longValue() <= 0L)) {
        break label319;
      }
      localContactMoreInfoPreference.MM(0);
      arrayOfInt[0] = 0;
      if ((bt.isNullOrNil(this.wQU)) || (bt.isNullOrNil(this.wSa))) {
        break label335;
      }
      localContactMoreInfoPreference.MO(0);
      arrayOfInt[1] = 0;
      str = com.tencent.mm.n.g.acA().getValue("LinkedinPluginClose");
      i = j;
      if (!bt.isNullOrNil(str))
      {
        if (bt.getInt(str, 0) != 0) {
          break label351;
        }
        i = j;
      }
      label149:
      if ((i == 0) || (bt.isNullOrNil(this.contact.ePF))) {
        break label356;
      }
      localContactMoreInfoPreference.MN(0);
      arrayOfInt[2] = 0;
      label177:
      if (!u.aAm().equals(this.contact.field_username)) {
        break label372;
      }
      ba.aBQ();
      str = (String)com.tencent.mm.model.c.ajl().get(al.a.Itl, null);
      label212:
      if (bt.isNullOrNil(str)) {
        break label400;
      }
    }
    for (;;)
    {
      try
      {
        str = new JSONObject(str).optString("ShopUrl");
        if (bt.isNullOrNil(str)) {
          break label406;
        }
        localContactMoreInfoPreference.MP(0);
        arrayOfInt[3] = 0;
        if (!bt.isNullOrNil(this.contact.signature)) {
          break label422;
        }
        arrayOfInt[4] = 8;
        if (this.contact.getSource() > 0) {
          break label430;
        }
        arrayOfInt[5] = 8;
        arrayOfInt[6] = 8;
        this.screen.cP("contact_info_more", false);
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
        ad.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
      }
      localContactMoreInfoPreference.MM(8);
      arrayOfInt[0] = 8;
      break;
      localContactMoreInfoPreference.MO(8);
      arrayOfInt[1] = 8;
      break label117;
      i = 0;
      break label149;
      localContactMoreInfoPreference.MN(8);
      arrayOfInt[2] = 8;
      break label177;
      str = this.contact.ePI;
      break label212;
      label400:
      Object localObject = null;
      continue;
      label406:
      localContactMoreInfoPreference.MP(8);
      arrayOfInt[3] = 8;
      continue;
      label422:
      arrayOfInt[4] = 0;
      continue;
      label430:
      arrayOfInt[5] = 0;
    }
  }
  
  private String zf(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27198);
    if (this.fLO == null)
    {
      AppMethodBeat.o(27198);
      return null;
    }
    ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().Bf(paramString);
    Object localObject1 = localObject2;
    if (localam != null)
    {
      localObject1 = localObject2;
      if ((int)localam.gfj > 0) {
        localObject1 = localam.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      localObject2 = this.fLO.zf(paramString);
    }
    paramString = (String)localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      paramString = (String)localObject2;
      if (localam != null) {
        paramString = localam.adu();
      }
    }
    AppMethodBeat.o(27198);
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(27203);
    paramString = (com.tencent.mm.ui.base.preference.g)this.screen.aVD("contact_info_sns");
    if ((paramString != null) && (com.tencent.mm.plugin.sns.b.o.zbT != null)) {
      paramString.aNf(this.contact.field_username);
    }
    this.wRU = com.tencent.mm.plugin.sns.b.o.zbT.b(this.contact.field_username, this.wRU);
    this.screen.notifyDataSetChanged();
    if (paramb.dSv())
    {
      ad.d("MicroMsg.ContactWidgetNormal", "bg Change!");
      if (com.tencent.mm.plugin.sns.b.o.zbX != null) {
        com.tencent.mm.plugin.sns.b.o.zbX.axK(this.contact.field_username);
      }
    }
    AppMethodBeat.o(27203);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, am paramam, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(27193);
    boolean bool;
    if (paramam != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramam.field_username).length() <= 0) {
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
      this.contact = paramam;
      this.wPZ = paramBoolean;
      this.jfq = paramInt;
      this.wQa = this.fLP.getIntent().getBooleanExtra("User_Verify", false);
      this.txJ = bt.nullAsNil(this.fLP.getIntent().getStringExtra("Verify_ticket"));
      this.wRV = this.fLP.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
      this.wRO = this.fLP.getIntent().getIntExtra("Kdel_from", -1);
      this.wRW = this.fLP.getIntent().getStringExtra("Contact_RemarkName");
      this.drw = this.fLP.getIntent().getIntExtra("Sns_from_Scene", 0);
      this.wRY = this.fLP.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
      this.wRZ = this.fLP.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
      this.wRX = this.fLP.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
      long l = this.fLP.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
      paramf = bt.bI(this.fLP.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
      this.wQU = bt.bI(this.fLP.getIntent().getStringExtra("verify_gmail"), "");
      this.wSa = bt.bI(this.fLP.getIntent().getStringExtra("profileName"), bt.aRo(this.wQU));
      this.wRU.jdn = this.wRX;
      this.wRU.jdp = l;
      this.wRU.jdo = paramf;
      this.wSc = this.fLP.getIntent().getStringExtra("KLinkedInAddFriendNickName");
      this.wSd = this.fLP.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
      if (com.tencent.mm.plugin.sns.b.o.zbT != null) {
        this.wRU = com.tencent.mm.plugin.sns.b.o.zbT.b(paramam.field_username, this.wRU);
      }
      this.fPi = this.fLP.getIntent().getStringExtra("room_name");
      ba.aBQ();
      this.fLO = com.tencent.mm.model.c.azz().AN(this.fPi);
      if (paramam.field_deleteFlag != 1) {
        break label613;
      }
    }
    label601:
    label607:
    label613:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.wSb = paramBoolean;
      dAF();
      ba.aBQ();
      com.tencent.mm.model.c.azp().aTg(paramam.field_username);
      paramBoolean = u.aAm().equals(paramam.field_username);
      ad.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[] { Integer.valueOf(this.wRU.jdn) });
      paramInt = i;
      if ((this.wRU.jdn & 0x1) > 0) {
        paramInt = 1;
      }
      if ((!paramam.adk()) && (!am.aSO(paramam.field_username)) && (paramInt != 0) && (com.tencent.mm.plugin.sns.b.o.zbX != null)) {
        com.tencent.mm.plugin.sns.b.o.zbX.a(2, paramam.field_username, paramBoolean, this.drw);
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
  
  public final boolean aaG(String paramString)
  {
    AppMethodBeat.i(27190);
    Object localObject2;
    Object localObject1;
    long l;
    if (paramString.equals("contact_info_sns"))
    {
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.fLP, null);
        AppMethodBeat.o(27190);
        return true;
      }
      localObject2 = this.fLP.getIntent();
      ((Intent)localObject2).putExtra("sns_source", this.drw);
      ((Intent)localObject2).putExtra("sns_signature", this.contact.signature);
      ((Intent)localObject2).putExtra("sns_nickName", this.contact.adu());
      ((Intent)localObject2).putExtra("sns_title", this.contact.adv());
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.b.o.zbX != null) {
        localObject1 = com.tencent.mm.plugin.sns.b.o.zbX.f((Intent)localObject2, this.contact.field_username);
      }
      if (localObject1 == null) {
        this.fLP.finish();
      }
    }
    else
    {
      if (!paramString.equals("contact_info_more")) {
        break label508;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(this.fLP, ContactMoreInfoUI.class);
      ((Intent)localObject2).putExtra("Is_RoomOwner", this.fLP.getIntent().getBooleanExtra("Is_RoomOwner", false));
      ((Intent)localObject2).putExtra("Contact_User", this.contact.field_username);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendNickName", this.wSc);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendPubUrl", this.wSd);
      localObject1 = this.fLP.getIntent().getStringExtra("room_name");
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = this.fLP.getIntent().getStringExtra("Contact_ChatRoomId");
      }
      ((Intent)localObject2).putExtra("Contact_ChatRoomId", paramString);
      ((Intent)localObject2).putExtra("verify_gmail", this.wQU);
      ((Intent)localObject2).putExtra("profileName", this.wSa);
      l = this.fLP.getIntent().getLongExtra("Contact_Uin", 0L);
      paramString = this.fLP.getIntent().getStringExtra("Contact_QQNick");
      ((Intent)localObject2).putExtra("Contact_Uin", l);
      ((Intent)localObject2).putExtra("Contact_QQNick", paramString);
      paramString = this.fLP;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(27190);
      return true;
      ((Intent)localObject1).putExtra("sns_adapter_type", 1);
      com.tencent.mm.bs.d.b(this.fLP, "sns", ".ui.SnsTimeLineUserPagerUI", (Intent)localObject1);
      if ((((Intent)localObject1).getFlags() & 0x4000000) == 0) {
        break;
      }
      this.fLP.finish();
      break;
      label508:
      if (paramString.equals("contact_info_social"))
      {
        paramString = new Intent();
        paramString.setClass(this.fLP, ContactSocialInfoUI.class);
        paramString.putExtra("Contact_User", this.contact.field_username);
        l = this.fLP.getIntent().getLongExtra("Contact_Uin", 0L);
        localObject1 = this.fLP.getIntent().getStringExtra("Contact_QQNick");
        paramString.putExtra("Contact_Uin", l);
        paramString.putExtra("Contact_QQNick", (String)localObject1);
        paramString.putExtra("profileName", this.wSa);
        paramString.putExtra("verify_gmail", this.wQU);
        localObject1 = this.fLP.getIntent().getStringExtra("Contact_Mobile_MD5");
        localObject2 = this.fLP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
        paramString.putExtra("Contact_Mobile_MD5", (String)localObject1);
        paramString.putExtra("Contact_full_Mobile_MD5", (String)localObject2);
        localObject1 = this.fLP;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.ahp(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)paramString.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.screen.aVD("contact_info_invite_source")).getExtras().getString("inviteer");
        if (!bt.isNullOrNil(paramString))
        {
          localObject1 = zf(paramString);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", paramString);
          ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomMember", true);
          ((Intent)localObject2).putExtra("room_name", this.fPi);
          ba.aBQ();
          ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.azp().Bf(paramString).field_nickname);
          ((Intent)localObject2).putExtra("Contact_Scene", 14);
          ((Intent)localObject2).putExtra("Is_RoomOwner", true);
          ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fPi);
          com.tencent.mm.plugin.profile.b.iRG.c((Intent)localObject2, this.fLP);
        }
      }
    }
  }
  
  final void auL(String paramString)
  {
    AppMethodBeat.i(27191);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(27191);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.jfq);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.contact.field_username);
    paramString.putExtra("Contact_Nick", this.contact.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.contact.field_conRemark);
    com.tencent.mm.plugin.profile.b.iRG.n(paramString, this.fLP);
    AppMethodBeat.o(27191);
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final boolean cdn()
  {
    AppMethodBeat.i(27201);
    if (com.tencent.mm.plugin.sns.b.o.zbX != null) {
      com.tencent.mm.plugin.sns.b.o.zbX.a(this, 3);
    }
    ba.aiU().b(30, this);
    ba.aiU().b(453, this);
    Object localObject = (NormalProfileHeaderPreference)this.screen.aVD("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (NormalUserFooterPreference)this.screen.aVD("contact_info_footer_normal");
    if (localObject != null) {
      ((NormalUserFooterPreference)localObject).cdn();
    }
    localObject = (FriendPreference)this.screen.aVD("contact_info_friend_qq");
    if (localObject != null) {
      ((FriendPreference)localObject).cdn();
    }
    localObject = (FriendPreference)this.screen.aVD("contact_info_friend_mobile");
    if (localObject != null) {
      ((FriendPreference)localObject).cdn();
    }
    localObject = (FriendPreference)this.screen.aVD("contact_info_facebook");
    if (localObject != null) {
      ((FriendPreference)localObject).cdn();
    }
    if (this.wSe != null) {
      this.wSe.destroy();
    }
    this.screen.aVD("contact_info_sns");
    AppMethodBeat.o(27201);
    return true;
  }
  
  final void iC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27197);
    ad.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aVD("contact_info_invite_source");
    TextPreference localTextPreference = (TextPreference)this.screen.aVD("contact_info_hint");
    this.screen.cP("contact_info_invite_source", false);
    SpannableString localSpannableString = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.c(this.fLP, this.fLP.getResources().getString(2131757692, new Object[] { paramString2 })));
    localSpannableString.setSpan(new ForegroundColorSpan(this.fLP.getResources().getColor(2131100035)), 0, paramString2.length(), 33);
    localKeyValuePreference.setSummary(localSpannableString);
    localKeyValuePreference.getExtras().putString("inviteer", paramString1);
    this.fLP.getIntent().putExtra("inviteer", paramString1);
    if ((this.fLO != null) && (!this.fLO.aGo().contains(this.contact.field_username)))
    {
      this.screen.cP("contact_info_footer_normal", true);
      localTextPreference.am(com.tencent.mm.pluginsdk.ui.span.k.c(this.fLP, this.fLP.getResources().getString(2131757745, new Object[] { zf(this.contact.field_username) })));
      AppMethodBeat.o(27197);
      return;
    }
    this.screen.cP("contact_info_footer_normal", false);
    AppMethodBeat.o(27197);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27202);
    if ((paramn.getType() != 30) && (paramn.getType() != 458))
    {
      ad.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(27202);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 30)
      {
        paramString = (com.tencent.mm.pluginsdk.model.o)paramn;
        if ((paramString.dsi != 1) && (paramString.dsi != 3))
        {
          AppMethodBeat.o(27202);
          return;
        }
        if ((paramString.ELU != null) && (!paramString.ELU.contains(this.contact.field_username)))
        {
          AppMethodBeat.o(27202);
          return;
        }
        paramString = (NormalUserHeaderPreference)this.screen.aVD("contact_info_header_normal");
        NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.aVD("contact_info_footer_normal");
        if ((paramString != null) && (localNormalUserFooterPreference != null) && (localNormalUserFooterPreference.wTL))
        {
          ad.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
          this.wRY = false;
          this.wRZ = false;
          paramString.cD(this.contact.field_username, false);
          paramString.cE(this.contact.field_username, false);
          paramString.De(this.contact.field_username);
          this.fLP.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.wRY);
          this.fLP.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.wRZ);
        }
      }
      if (paramn.getType() == 453)
      {
        dAF();
        AppMethodBeat.o(27202);
      }
    }
    else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString)))
    {
      Toast.makeText(this.fLP, paramString, 1).show();
    }
    AppMethodBeat.o(27202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */