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
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.n.e;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
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

@com.tencent.mm.sdk.platformtools.l(fnV={ContactInfoUI.class})
public final class k
  implements com.tencent.mm.ak.f, i.a, com.tencent.mm.pluginsdk.b.a
{
  an contact;
  String dmY;
  private int dsC;
  ac fNS;
  MMActivity fNT;
  String fRo;
  int jij;
  private com.tencent.mm.ui.base.preference.f screen;
  private String tIA;
  private boolean xfQ;
  private boolean xfR;
  private String xgL;
  private int xhF;
  private dia xhL;
  private boolean xhM;
  private String xhN;
  private int xhO;
  private boolean xhP;
  private boolean xhQ;
  private String xhR;
  private boolean xhS;
  private String xhT;
  private String xhU;
  private com.tencent.mm.plugin.profile.a.b xhV;
  private int xhW;
  String xhX;
  com.tencent.mm.sdk.b.c<bb> xhY;
  
  private void NA(int paramInt)
  {
    AppMethodBeat.i(27199);
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aXe("contact_info_source");
    if (!this.xfR)
    {
      if (localKeyValuePreference != null)
      {
        if (paramInt == 10)
        {
          localKeyValuePreference.JNz = false;
          localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
          localKeyValuePreference.setSummary(this.fNT.getString(2131759466));
          localKeyValuePreference.xN(false);
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
            localKeyValuePreference.JNz = false;
            localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
            localKeyValuePreference.setSummary(2131757862);
            localKeyValuePreference.xN(false);
            AppMethodBeat.o(27199);
            return;
          } while (localKeyValuePreference == null);
          localKeyValuePreference.JNz = false;
          localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
          localKeyValuePreference.setSummary(2131757865);
          localKeyValuePreference.xN(false);
          AppMethodBeat.o(27199);
          return;
        } while (localKeyValuePreference == null);
        localKeyValuePreference.JNz = false;
        localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
        localObject2 = w.zP(this.fNT.getIntent().getStringExtra("source_from_user_name"));
        localObject1 = localObject2;
        if (bu.isNullOrNil((String)localObject2)) {
          localObject1 = this.fNT.getIntent().getStringExtra("source_from_nick_name");
        }
        if (bu.isNullOrNil((String)localObject1)) {
          localKeyValuePreference.setSummary(2131757842);
        }
        for (;;)
        {
          localKeyValuePreference.xN(false);
          AppMethodBeat.o(27199);
          return;
          localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fNT, this.fNT.getString(2131757841, new Object[] { localObject1 })));
        }
      } while (localKeyValuePreference == null);
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localObject1 = com.tencent.mm.bj.d.aML().aqR(this.contact.field_username);
      bc.aCg();
      Object localObject2 = com.tencent.mm.model.c.azF();
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject1 = ((bq)localObject2).BH((String)localObject1);
        if (localObject1 == null) {
          break label995;
        }
      }
      break;
    }
    label995:
    for (Object localObject1 = ((aw)localObject1).field_nickname;; localObject1 = null)
    {
      if (!bu.isNullOrNil((String)localObject1)) {
        localKeyValuePreference.setSummary(this.fNT.getString(2131757848, new Object[] { localObject1 }));
      }
      for (;;)
      {
        localKeyValuePreference.xN(false);
        AppMethodBeat.o(27199);
        return;
        localObject1 = ((bi)localObject1).field_chatroomName;
        break;
        localKeyValuePreference.setSummary(2131757846);
      }
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localKeyValuePreference.setSummary(this.fNT.getString(2131759467));
      localKeyValuePreference.xN(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localKeyValuePreference.setSummary(2131757871);
      localKeyValuePreference.xN(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localKeyValuePreference.setSummary(2131757837);
      localKeyValuePreference.xN(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localKeyValuePreference.setSummary(2131757855);
      localKeyValuePreference.xN(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localKeyValuePreference.setSummary(this.fNT.getString(2131760022));
      localKeyValuePreference.xN(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localKeyValuePreference.setSummary(this.fNT.getString(2131757857));
      localKeyValuePreference.xN(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localKeyValuePreference.setSummary(2131757859);
      localKeyValuePreference.xN(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.JNz = false;
      localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
      localKeyValuePreference.setSummary(2131757850);
      localKeyValuePreference.xN(false);
      AppMethodBeat.o(27199);
      return;
    }
  }
  
  private void dDW()
  {
    AppMethodBeat.i(27194);
    ceC();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951648);
    if (com.tencent.mm.plugin.sns.b.o.zsA != null) {
      com.tencent.mm.plugin.sns.b.o.zsA.a(3, this.contact.field_username, this);
    }
    bc.ajj().a(30, this);
    bc.ajj().a(453, this);
    this.xhX = "";
    ae.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[] { this.contact.adC() });
    if (!this.contact.adC())
    {
      localObject1 = null;
      localObject2 = this.fNT.getIntent().getStringExtra("Contact_Mobile_MD5");
      localObject3 = this.fNT.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bu.isNullOrNil((String)localObject2)) || (!bu.isNullOrNil((String)localObject3))) {
        break label741;
      }
      if (!bu.isNullOrNil(this.contact.field_username))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(this.contact.field_username);
        localObject3 = this.contact.field_username;
        if (localObject2 != null) {
          break label733;
        }
        localObject1 = "true";
        ae.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject1 });
        localObject1 = localObject2;
      }
      label248:
      if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).Lj())))
      {
        this.xhX = bu.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aTc()).replace(" ", "");
        ae.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[] { this.contact.field_username, this.xhX });
      }
    }
    Object localObject2 = (NormalUserHeaderPreference)this.screen.aXe("contact_info_header_normal");
    label427:
    int j;
    if (localObject2 != null)
    {
      ((NormalUserHeaderPreference)localObject2).a(this.contact, this.jij, this.tIA, this.xhX, this.contact.eRu);
      ((NormalUserHeaderPreference)localObject2).cH(this.contact.field_username, this.xhP);
      ((NormalUserHeaderPreference)localObject2).Fza = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27181);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          localObject = k.this;
          if (paramAnonymousView.getId() == 2131304604) {
            com.tencent.mm.plugin.report.service.g.yxI.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aH(((k)localObject).fNT.getIntent())), Integer.valueOf(2), Integer.valueOf(1), ((k)localObject).contact.field_username });
          }
          if (((k)localObject).contact == null) {
            ae.e("MicroMsg.ContactWidgetNormal", "contact is null");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27181);
            return;
            if (!com.tencent.mm.contact.c.lO(((k)localObject).contact.field_type))
            {
              if (!bu.isNullOrNil(((k)localObject).contact.field_encryptUsername)) {
                ((k)localObject).awa(((k)localObject).contact.field_encryptUsername);
              } else {
                ((k)localObject).awa(((k)localObject).contact.field_username);
              }
            }
            else
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_Scene", ((k)localObject).jij);
              paramAnonymousView.putExtra("Contact_User", ((k)localObject).contact.field_username);
              paramAnonymousView.putExtra("Contact_RoomNickname", ((k)localObject).fNT.getIntent().getStringExtra("Contact_RoomNickname"));
              paramAnonymousView.putExtra("view_mode", true);
              paramAnonymousView.putExtra("contact_phone_number_by_md5", ((k)localObject).xhX);
              paramAnonymousView.putExtra("contact_phone_number_list", ((k)localObject).contact.eRu);
              com.tencent.mm.plugin.profile.b.iUz.m(paramAnonymousView, ((k)localObject).fNT);
            }
          }
        }
      };
      if (com.tencent.mm.contact.c.lO(this.contact.field_type)) {
        this.xhQ = false;
      }
      ((NormalUserHeaderPreference)localObject2).cI(this.contact.field_username, this.xhQ);
      if ((!an.aUq(this.contact.field_username)) || (this.contact.eRx == 0)) {
        break label1181;
      }
      j = this.screen.indexOf("contact_info_category_1");
      localObject1 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_custom_info_header", a.a.iKm);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new PreferenceTitleCategory(this.fNT);
        ((Preference)localObject3).setTitle((CharSequence)localObject1);
        this.screen.a((Preference)localObject3, j);
        ((Preference)localObject3).JOj = new Preference.b()
        {
          public final boolean dDy()
          {
            return false;
          }
        };
      }
      localObject1 = new com.tencent.mm.openim.a.b();
      ((com.tencent.mm.openim.a.b)localObject1).Jd(this.contact.eRy);
      localObject1 = ((com.tencent.mm.openim.a.b)localObject1).iKp.iterator();
      label579:
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (b.a)((Iterator)localObject1).next();
        localObject4 = ((b.a)localObject3).iKq.iterator();
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
        final b.b localb = (b.b)((Iterator)localObject4).next();
        j = i + 1;
        KeyValuePreference local5 = new KeyValuePreference(this.fNT)
        {
          public final void onBindView(View paramAnonymousView)
          {
            AppMethodBeat.i(27184);
            super.onBindView(paramAnonymousView);
            if (this.xif != null) {
              if ((localb.action != 2) && (localb.action != 3)) {
                break label113;
              }
            }
            label113:
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                this.xif.setTextColor(ak.getResources().getColorStateList(2131100733));
              }
              if ((this.JNF != null) && (!TextUtils.isEmpty(localb.dEM)))
              {
                this.JNF.setVisibility(0);
                com.tencent.mm.av.q.aJb().loadImage(localb.dEM, this.JNF);
              }
              AppMethodBeat.o(27184);
              return;
            }
          }
        };
        local5.Jvz = ((b.a)localObject3).title;
        local5.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fNT, localb.Je(this.contact.field_openImAppid)));
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
          if ((bu.isNullOrNil((String)localObject2)) && (bu.isNullOrNil((String)localObject3))) {
            break label248;
          }
          ae.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { this.contact.field_username, localObject2, localObject3 });
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).Lj())) {}
          }
          else
          {
            localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW((String)localObject3);
          }
          localObject3 = this.contact.field_username;
          if (localObject1 == null) {}
          for (localObject2 = "true";; localObject2 = "false")
          {
            ae.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject2 });
            break;
          }
          this.screen.d((Preference)localObject2);
          break label427;
        }
        if (localb.action == 2)
        {
          local5.JOj = new Preference.b()
          {
            public final boolean dDy()
            {
              AppMethodBeat.i(27185);
              Object localObject1 = localb.iKs;
              try
              {
                localObject2 = new JSONObject(localb.iKs).optString("tel");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ae.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.xff.title });
              localObject2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(localObject1))));
              ((Intent)localObject2).setFlags(268435456);
              localObject1 = k.this.fNT;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27185);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 3)
        {
          local5.JOj = new Preference.b()
          {
            public final boolean dDy()
            {
              AppMethodBeat.i(27186);
              Object localObject1 = "";
              try
              {
                localObject2 = new JSONObject(localb.iKs).optString("mailto");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ae.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.xff.title });
              localObject2 = new Intent("android.intent.action.SENDTO");
              ((Intent)localObject2).setData(Uri.parse("mailto:".concat(String.valueOf(localObject1))));
              localObject1 = k.this.fNT;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27186);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 4)
        {
          local5.JOj = new Preference.b()
          {
            public final boolean dDy()
            {
              AppMethodBeat.i(27187);
              Intent localIntent = new Intent();
              localIntent.setFlags(268435456);
              localIntent.setClassName(ak.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
              Object localObject1 = "";
              try
              {
                localObject2 = new JSONObject(localb.iKs).optString("url");
                localObject1 = localObject2;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject2;
                  ae.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.g.yxI.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.xff.title });
              localIntent.putExtra("geta8key_scene", 58);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localObject1 = ak.getContext();
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
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
            local5.JOj = new Preference.b()
            {
              public final boolean dDy()
              {
                AppMethodBeat.i(27188);
                try
                {
                  Object localObject = new JSONObject(localb.iKs);
                  String str = ((JSONObject)localObject).optString("name");
                  localObject = ((JSONObject)localObject).optString("pagepath");
                  vq localvq = new vq();
                  localvq.dKT.userName = str;
                  localvq.dKT.dKV = bu.bI((String)localObject, "");
                  com.tencent.mm.sdk.b.a.IvT.l(localvq);
                  com.tencent.mm.plugin.report.service.g.yxI.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.xff.title });
                  AppMethodBeat.o(27188);
                  return true;
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    ae.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
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
    this.screen.a(new PreferenceSmallCategory(this.fNT), i);
    Object localObject1 = new KeyValuePreference(this.fNT);
    ((KeyValuePreference)localObject1).setTitle(2131757648);
    Object localObject3 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_intro_desc", a.a.iKm);
    ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fNT, (CharSequence)localObject3));
    Object localObject4 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_intro_url", a.a.iKn);
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((Preference)localObject1).JOj = new k.10(this, (String)localObject4, (String)localObject3);
    }
    this.screen.a((Preference)localObject1, i + 1);
    label1181:
    if (!bu.isNullOrNil(this.contact.getProvince()))
    {
      localObject3 = (KeyValuePreference)this.screen.aXe("contact_info_district");
      if (localObject3 != null)
      {
        ((KeyValuePreference)localObject3).setTitle(this.fNT.getString(2131757646));
        localObject4 = new StringBuilder().append(w.zR(this.contact.getProvince()));
        if (bu.isNullOrNil(this.contact.getCity()))
        {
          localObject1 = "";
          ((KeyValuePreference)localObject3).setSummary((String)localObject1);
          ((KeyValuePreference)localObject3).xN(false);
          ((KeyValuePreference)localObject3).setEnabled(false);
        }
      }
      else
      {
        if ((this.contact.signature == null) || (this.contact.signature.trim().equals("")) || (com.tencent.mm.contact.c.lO(this.contact.field_type))) {
          break label1927;
        }
        localObject1 = (KeyValuePreference)this.screen.aXe("contact_info_signature");
        if (localObject1 != null)
        {
          ((KeyValuePreference)localObject1).JNz = false;
          ((KeyValuePreference)localObject1).setTitle(this.fNT.getString(2131757822));
          ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.fNT, this.contact.signature));
          ((KeyValuePreference)localObject1).xN(false);
        }
        label1406:
        this.screen.aXe("contact_info_facebook");
        this.screen.aXf("contact_info_facebook");
        if ((this.xhL.jgg & 0x1) <= 0) {
          break label1943;
        }
        i = 1;
        label1446:
        if (((i & com.tencent.mm.br.d.aJN("sns")) == 0) || (an.aUo(this.contact.field_username)) || (this.contact.adv())) {
          break label1948;
        }
        localObject1 = (com.tencent.mm.ui.base.preference.g)this.screen.aXe("contact_info_sns");
        if ((localObject1 != null) && (com.tencent.mm.plugin.sns.b.o.zsw != null)) {
          ((com.tencent.mm.ui.base.preference.g)localObject1).aOC(this.contact.field_username);
        }
        label1522:
        this.screen.aXf("contact_info_verifyuser");
        this.screen.aXf("contact_info_footer_normal");
        this.xhV = new com.tencent.mm.plugin.profile.a.b(this.fNT, this.contact);
        this.xhV.dkv();
        if (this.jij == 96) {
          this.screen.aXf("contact_info_footer_normal");
        }
        if (!com.tencent.mm.contact.c.lO(this.contact.field_type)) {
          break label1964;
        }
        dEi();
        this.screen.aXf("contact_info_social");
        label1626:
        dEg();
        dEh();
        localObject1 = (NormalUserFooterPreference)this.screen.aXe("contact_info_footer_normal");
        boolean bool1 = this.fNT.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean bool2 = this.fNT.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.fNT.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long l = this.fNT.getIntent().getLongExtra("Contact_Uin", -1L);
        if ((this.jij == 30) || (this.jij == 45)) {
          this.xhM = false;
        }
        if ((localObject1 == null) || (!((NormalUserFooterPreference)localObject1).a(this.contact, this.tIA, this.xfQ, this.xfR, this.xhM, this.jij, this.xhF, bool2, bool1, l, this.xhN))) {
          break label1984;
        }
        ((NormalUserFooterPreference)localObject1).hPq.removeAll();
        ((NormalUserFooterPreference)localObject1).hPq.a(new NormalUserFooterPreference.e() {}, Looper.getMainLooper());
      }
    }
    for (;;)
    {
      label1297:
      this.screen.aXf("clear_lbs_info");
      if (this.xhS)
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
      this.screen.aXf("contact_info_district");
      break label1297;
      label1927:
      this.screen.aXf("contact_info_signature");
      break label1406;
      label1943:
      i = 0;
      break label1446;
      label1948:
      this.screen.aXf("contact_info_sns");
      break label1522;
      label1964:
      dEf();
      this.screen.aXf("contact_info_more");
      break label1626;
      label1984:
      this.screen.aXf("contact_info_footer_normal");
    }
  }
  
  private void dEf()
  {
    Object localObject4 = null;
    AppMethodBeat.i(27192);
    ContactSocialInfoPreference localContactSocialInfoPreference = (ContactSocialInfoPreference)this.screen.aXe("contact_info_social");
    if (localContactSocialInfoPreference != null)
    {
      if (bu.isNullOrNil(this.xhX)) {
        break label414;
      }
      localContactSocialInfoPreference.Nw(0);
      this.xhW = 1;
    }
    for (;;)
    {
      bc.aCg();
      int i = bu.o((Integer)com.tencent.mm.model.c.ajA().get(9, null));
      long l = this.fNT.getIntent().getLongExtra("Contact_Uin", 0L);
      Object localObject1 = this.fNT.getIntent().getStringExtra("Contact_QQNick");
      Object localObject2;
      if ((l != 0L) && (i != 0))
      {
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().sO(l);
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
          localContactSocialInfoPreference.Ns(0);
          this.xhW = 1;
        }
      }
      else
      {
        label192:
        if ((bu.isNullOrNil(this.xgL)) || (bu.isNullOrNil(this.xhR))) {
          break label434;
        }
        localContactSocialInfoPreference.Nu(0);
        this.xhW = 1;
        label223:
        localObject1 = com.tencent.mm.n.g.acL().getValue("LinkedinPluginClose");
        if ((!bu.isNullOrNil((String)localObject1)) && (bu.getInt((String)localObject1, 0) != 0)) {
          break label444;
        }
        i = 1;
        label253:
        if ((i == 0) || (bu.isNullOrNil(this.contact.eRq))) {
          break label449;
        }
        localContactSocialInfoPreference.Nt(0);
        this.xhW = 1;
        label281:
        if (!v.aAC().equals(this.contact.field_username)) {
          break label459;
        }
        bc.aCg();
        localObject1 = (String)com.tencent.mm.model.c.ajA().get(am.a.INH, null);
        localObject2 = localObject4;
        if (bu.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        localObject2 = new JSONObject((String)localObject1).optString("ShopUrl");
        ae.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[] { localObject1, localObject2 });
        if (!bu.isNullOrNil((String)localObject2))
        {
          localContactSocialInfoPreference.Nv(0);
          this.xhW = 1;
          if (this.xhW == 0) {
            this.screen.aXf("contact_info_social");
          }
          AppMethodBeat.o(27192);
          return;
          label414:
          localContactSocialInfoPreference.Nw(8);
          continue;
          localContactSocialInfoPreference.Ns(8);
          break label192;
          label434:
          localContactSocialInfoPreference.Nu(8);
          break label223;
          label444:
          i = 0;
          break label253;
          label449:
          localContactSocialInfoPreference.Nt(8);
          break label281;
          label459:
          localObject1 = this.contact.eRt;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
          Object localObject3 = localObject4;
          continue;
          localContactSocialInfoPreference.Nv(8);
        }
      }
    }
  }
  
  private void dEg()
  {
    AppMethodBeat.i(27195);
    if (com.tencent.mm.contact.c.lO(this.contact.field_type))
    {
      this.screen.aXf("contact_info_source");
      AppMethodBeat.o(27195);
      return;
    }
    int i = this.fNT.getIntent().getIntExtra("Contact_Source_FMessage", 0);
    ae.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.contact.getSource() + ", sourceFMessage = " + i);
    if (i != 0)
    {
      NA(i);
      AppMethodBeat.o(27195);
      return;
    }
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aXe("contact_info_source");
    if (this.xfR) {
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
        localKeyValuePreference.JNz = false;
        localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
        localKeyValuePreference.setSummary(2131757850);
        localKeyValuePreference.xN(false);
        AppMethodBeat.o(27195);
        return;
      case 30: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JNz = false;
        localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
        localKeyValuePreference.setSummary(2131757855);
        localKeyValuePreference.xN(false);
        AppMethodBeat.o(27195);
        return;
      case 48: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JNz = false;
        localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
        localKeyValuePreference.setSummary(this.fNT.getString(2131757857));
        localKeyValuePreference.xN(false);
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
        localKeyValuePreference.JNz = false;
        localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
        localKeyValuePreference.setSummary(2131757868);
        localKeyValuePreference.xN(false);
        AppMethodBeat.o(27195);
        return;
      case 34: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JNz = false;
        localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
        localKeyValuePreference.setSummary(this.fNT.getString(2131757834));
        localKeyValuePreference.xN(false);
        AppMethodBeat.o(27195);
        return;
      case 58: 
      case 59: 
      case 60: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JNz = false;
        localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
        localKeyValuePreference.setSummary(this.fNT.getString(2131760022));
        localKeyValuePreference.xN(false);
        AppMethodBeat.o(27195);
        return;
      case 76: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.JNz = false;
        localKeyValuePreference.setTitle(this.fNT.getString(2131757874));
        localKeyValuePreference.setSummary(this.fNT.getString(2131757852));
        localKeyValuePreference.xN(false);
        AppMethodBeat.o(27195);
        return;
      }
    } else {
      this.screen.d(localKeyValuePreference);
    }
    AppMethodBeat.o(27195);
  }
  
  private void dEh()
  {
    AppMethodBeat.i(27196);
    this.screen.cT("contact_info_invite_source", true);
    boolean bool1;
    int i;
    if (this.fNS == null)
    {
      bool1 = this.fNT.getIntent().getBooleanExtra("Is_RoomOwner", false);
      if ((this.jij == 14) && (bool1) && (this.fNS != null) && (!this.contact.field_username.equals(this.fNS.field_roomowner))) {
        break label167;
      }
      i = this.jij;
      if (this.fNS != null) {
        break label162;
      }
    }
    label162:
    for (boolean bool2 = true;; bool2 = false)
    {
      ae.i("MicroMsg.ContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.screen.cT("contact_info_invite_source", true);
      AppMethodBeat.o(27196);
      return;
      bool1 = this.fNS.YQ();
      break;
    }
    label167:
    this.dmY = this.fNT.getIntent().getStringExtra("inviteer");
    if (bu.isNullOrNil(this.dmY)) {
      this.dmY = this.fNS.aUh(this.contact.field_username);
    }
    if (bu.isNullOrNil(this.dmY)) {
      this.dmY = r.aD(this.contact.field_username, this.fRo);
    }
    if (bu.isNullOrNil(this.dmY))
    {
      ae.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[] { this.fRo, this.contact.field_username });
      this.xhY.alive();
      au.a.hIG.a(this.contact.field_username, this.fRo, new au.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27182);
          ae.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, k.this.fRo, Boolean.valueOf(paramAnonymousBoolean) });
          k.this.xhY.dead();
          AppMethodBeat.o(27182);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    this.fNT.getIntent().putExtra("inviteer", this.dmY);
    String str = zP(this.dmY);
    if (bu.isNullOrNil(str))
    {
      au.a.hIG.a(this.contact.field_username, "", new au.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27183);
          ae.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, k.this.fRo, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            bc.aCg();
            paramAnonymousString = com.tencent.mm.model.c.azF().BH(paramAnonymousString).adF();
            k.this.iI(k.this.dmY, paramAnonymousString);
          }
          AppMethodBeat.o(27183);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    iI(this.dmY, str);
    AppMethodBeat.o(27196);
  }
  
  private void dEi()
  {
    int j = 1;
    AppMethodBeat.i(27200);
    int[] arrayOfInt = new int[7];
    ContactMoreInfoPreference localContactMoreInfoPreference = (ContactMoreInfoPreference)this.screen.aXe("contact_info_more");
    label117:
    String str;
    int i;
    if (localContactMoreInfoPreference != null)
    {
      long l = this.fNT.getIntent().getLongExtra("Contact_Uin", 0L);
      if ((l == -1L) || (new p(l).longValue() <= 0L)) {
        break label319;
      }
      localContactMoreInfoPreference.Ns(0);
      arrayOfInt[0] = 0;
      if ((bu.isNullOrNil(this.xgL)) || (bu.isNullOrNil(this.xhR))) {
        break label335;
      }
      localContactMoreInfoPreference.Nu(0);
      arrayOfInt[1] = 0;
      str = com.tencent.mm.n.g.acL().getValue("LinkedinPluginClose");
      i = j;
      if (!bu.isNullOrNil(str))
      {
        if (bu.getInt(str, 0) != 0) {
          break label351;
        }
        i = j;
      }
      label149:
      if ((i == 0) || (bu.isNullOrNil(this.contact.eRq))) {
        break label356;
      }
      localContactMoreInfoPreference.Nt(0);
      arrayOfInt[2] = 0;
      label177:
      if (!v.aAC().equals(this.contact.field_username)) {
        break label372;
      }
      bc.aCg();
      str = (String)com.tencent.mm.model.c.ajA().get(am.a.INH, null);
      label212:
      if (bu.isNullOrNil(str)) {
        break label400;
      }
    }
    for (;;)
    {
      try
      {
        str = new JSONObject(str).optString("ShopUrl");
        if (bu.isNullOrNil(str)) {
          break label406;
        }
        localContactMoreInfoPreference.Nv(0);
        arrayOfInt[3] = 0;
        if (!bu.isNullOrNil(this.contact.signature)) {
          break label422;
        }
        arrayOfInt[4] = 8;
        if (this.contact.getSource() > 0) {
          break label430;
        }
        arrayOfInt[5] = 8;
        arrayOfInt[6] = 8;
        this.screen.cT("contact_info_more", false);
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
        ae.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
      }
      localContactMoreInfoPreference.Ns(8);
      arrayOfInt[0] = 8;
      break;
      localContactMoreInfoPreference.Nu(8);
      arrayOfInt[1] = 8;
      break label117;
      i = 0;
      break label149;
      localContactMoreInfoPreference.Nt(8);
      arrayOfInt[2] = 8;
      break label177;
      str = this.contact.eRt;
      break label212;
      label400:
      Object localObject = null;
      continue;
      label406:
      localContactMoreInfoPreference.Nv(8);
      arrayOfInt[3] = 8;
      continue;
      label422:
      arrayOfInt[4] = 0;
      continue;
      label430:
      arrayOfInt[5] = 0;
    }
  }
  
  private String zP(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27198);
    if (this.fNS == null)
    {
      AppMethodBeat.o(27198);
      return null;
    }
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(paramString);
    Object localObject1 = localObject2;
    if (localan != null)
    {
      localObject1 = localObject2;
      if ((int)localan.ght > 0) {
        localObject1 = localan.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bu.isNullOrNil((String)localObject1)) {
      localObject2 = this.fNS.zP(paramString);
    }
    paramString = (String)localObject2;
    if (bu.isNullOrNil((String)localObject2))
    {
      paramString = (String)localObject2;
      if (localan != null) {
        paramString = localan.adF();
      }
    }
    AppMethodBeat.o(27198);
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(27203);
    paramString = (com.tencent.mm.ui.base.preference.g)this.screen.aXe("contact_info_sns");
    if ((paramString != null) && (com.tencent.mm.plugin.sns.b.o.zsw != null)) {
      paramString.aOC(this.contact.field_username);
    }
    this.xhL = com.tencent.mm.plugin.sns.b.o.zsw.b(this.contact.field_username, this.xhL);
    this.screen.notifyDataSetChanged();
    if (paramb.dVT())
    {
      ae.d("MicroMsg.ContactWidgetNormal", "bg Change!");
      if (com.tencent.mm.plugin.sns.b.o.zsA != null) {
        com.tencent.mm.plugin.sns.b.o.zsA.azb(this.contact.field_username);
      }
    }
    AppMethodBeat.o(27203);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, an paraman, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(27193);
    boolean bool;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bu.nullAsNil(paraman.field_username).length() <= 0) {
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
      this.contact = paraman;
      this.xfQ = paramBoolean;
      this.jij = paramInt;
      this.xfR = this.fNT.getIntent().getBooleanExtra("User_Verify", false);
      this.tIA = bu.nullAsNil(this.fNT.getIntent().getStringExtra("Verify_ticket"));
      this.xhM = this.fNT.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
      this.xhF = this.fNT.getIntent().getIntExtra("Kdel_from", -1);
      this.xhN = this.fNT.getIntent().getStringExtra("Contact_RemarkName");
      this.dsC = this.fNT.getIntent().getIntExtra("Sns_from_Scene", 0);
      this.xhP = this.fNT.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
      this.xhQ = this.fNT.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
      this.xhO = this.fNT.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
      long l = this.fNT.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
      paramf = bu.bI(this.fNT.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
      this.xgL = bu.bI(this.fNT.getIntent().getStringExtra("verify_gmail"), "");
      this.xhR = bu.bI(this.fNT.getIntent().getStringExtra("profileName"), bu.aSL(this.xgL));
      this.xhL.jgg = this.xhO;
      this.xhL.jgi = l;
      this.xhL.jgh = paramf;
      this.xhT = this.fNT.getIntent().getStringExtra("KLinkedInAddFriendNickName");
      this.xhU = this.fNT.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
      if (com.tencent.mm.plugin.sns.b.o.zsw != null) {
        this.xhL = com.tencent.mm.plugin.sns.b.o.zsw.b(paraman.field_username, this.xhL);
      }
      this.fRo = this.fNT.getIntent().getStringExtra("room_name");
      bc.aCg();
      this.fNS = com.tencent.mm.model.c.azP().Bx(this.fRo);
      if (paraman.field_deleteFlag != 1) {
        break label613;
      }
    }
    label601:
    label607:
    label613:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.xhS = paramBoolean;
      dDW();
      bc.aCg();
      com.tencent.mm.model.c.azF().aUH(paraman.field_username);
      paramBoolean = v.aAC().equals(paraman.field_username);
      ae.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[] { Integer.valueOf(this.xhL.jgg) });
      paramInt = i;
      if ((this.xhL.jgg & 0x1) > 0) {
        paramInt = 1;
      }
      if ((!paraman.adv()) && (!an.aUo(paraman.field_username)) && (paramInt != 0) && (com.tencent.mm.plugin.sns.b.o.zsA != null)) {
        com.tencent.mm.plugin.sns.b.o.zsA.a(2, paraman.field_username, paramBoolean, this.dsC);
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
  
  public final boolean abx(String paramString)
  {
    AppMethodBeat.i(27190);
    Object localObject2;
    Object localObject1;
    long l;
    if (paramString.equals("contact_info_sns"))
    {
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.fNT, null);
        AppMethodBeat.o(27190);
        return true;
      }
      localObject2 = this.fNT.getIntent();
      ((Intent)localObject2).putExtra("sns_source", this.dsC);
      ((Intent)localObject2).putExtra("sns_signature", this.contact.signature);
      ((Intent)localObject2).putExtra("sns_nickName", this.contact.adF());
      ((Intent)localObject2).putExtra("sns_title", this.contact.adG());
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.b.o.zsA != null) {
        localObject1 = com.tencent.mm.plugin.sns.b.o.zsA.f((Intent)localObject2, this.contact.field_username);
      }
      if (localObject1 == null) {
        this.fNT.finish();
      }
    }
    else
    {
      if (!paramString.equals("contact_info_more")) {
        break label508;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(this.fNT, ContactMoreInfoUI.class);
      ((Intent)localObject2).putExtra("Is_RoomOwner", this.fNT.getIntent().getBooleanExtra("Is_RoomOwner", false));
      ((Intent)localObject2).putExtra("Contact_User", this.contact.field_username);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendNickName", this.xhT);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendPubUrl", this.xhU);
      localObject1 = this.fNT.getIntent().getStringExtra("room_name");
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = this.fNT.getIntent().getStringExtra("Contact_ChatRoomId");
      }
      ((Intent)localObject2).putExtra("Contact_ChatRoomId", paramString);
      ((Intent)localObject2).putExtra("verify_gmail", this.xgL);
      ((Intent)localObject2).putExtra("profileName", this.xhR);
      l = this.fNT.getIntent().getLongExtra("Contact_Uin", 0L);
      paramString = this.fNT.getIntent().getStringExtra("Contact_QQNick");
      ((Intent)localObject2).putExtra("Contact_Uin", l);
      ((Intent)localObject2).putExtra("Contact_QQNick", paramString);
      paramString = this.fNT;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(27190);
      return true;
      ((Intent)localObject1).putExtra("sns_adapter_type", 1);
      com.tencent.mm.br.d.b(this.fNT, "sns", ".ui.SnsTimeLineUserPagerUI", (Intent)localObject1);
      if ((((Intent)localObject1).getFlags() & 0x4000000) == 0) {
        break;
      }
      this.fNT.finish();
      break;
      label508:
      if (paramString.equals("contact_info_social"))
      {
        paramString = new Intent();
        paramString.setClass(this.fNT, ContactSocialInfoUI.class);
        paramString.putExtra("Contact_User", this.contact.field_username);
        l = this.fNT.getIntent().getLongExtra("Contact_Uin", 0L);
        localObject1 = this.fNT.getIntent().getStringExtra("Contact_QQNick");
        paramString.putExtra("Contact_Uin", l);
        paramString.putExtra("Contact_QQNick", (String)localObject1);
        paramString.putExtra("profileName", this.xhR);
        paramString.putExtra("verify_gmail", this.xgL);
        localObject1 = this.fNT.getIntent().getStringExtra("Contact_Mobile_MD5");
        localObject2 = this.fNT.getIntent().getStringExtra("Contact_full_Mobile_MD5");
        paramString.putExtra("Contact_Mobile_MD5", (String)localObject1);
        paramString.putExtra("Contact_full_Mobile_MD5", (String)localObject2);
        localObject1 = this.fNT;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bc(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.ahE(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)paramString.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.screen.aXe("contact_info_invite_source")).getExtras().getString("inviteer");
        if (!bu.isNullOrNil(paramString))
        {
          localObject1 = zP(paramString);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", paramString);
          ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomMember", true);
          ((Intent)localObject2).putExtra("room_name", this.fRo);
          bc.aCg();
          ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.azF().BH(paramString).field_nickname);
          ((Intent)localObject2).putExtra("Contact_Scene", 14);
          ((Intent)localObject2).putExtra("Is_RoomOwner", true);
          ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fRo);
          com.tencent.mm.plugin.profile.b.iUz.c((Intent)localObject2, this.fNT);
        }
      }
    }
  }
  
  final void awa(String paramString)
  {
    AppMethodBeat.i(27191);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(27191);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.jij);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.contact.field_username);
    paramString.putExtra("Contact_Nick", this.contact.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.contact.field_conRemark);
    com.tencent.mm.plugin.profile.b.iUz.n(paramString, this.fNT);
    AppMethodBeat.o(27191);
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final boolean ceC()
  {
    AppMethodBeat.i(27201);
    if (com.tencent.mm.plugin.sns.b.o.zsA != null) {
      com.tencent.mm.plugin.sns.b.o.zsA.a(this, 3);
    }
    bc.ajj().b(30, this);
    bc.ajj().b(453, this);
    Object localObject = (NormalProfileHeaderPreference)this.screen.aXe("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (NormalUserFooterPreference)this.screen.aXe("contact_info_footer_normal");
    if (localObject != null) {
      ((NormalUserFooterPreference)localObject).ceC();
    }
    localObject = (FriendPreference)this.screen.aXe("contact_info_friend_qq");
    if (localObject != null) {
      ((FriendPreference)localObject).ceC();
    }
    localObject = (FriendPreference)this.screen.aXe("contact_info_friend_mobile");
    if (localObject != null) {
      ((FriendPreference)localObject).ceC();
    }
    localObject = (FriendPreference)this.screen.aXe("contact_info_facebook");
    if (localObject != null) {
      ((FriendPreference)localObject).ceC();
    }
    if (this.xhV != null) {
      this.xhV.destroy();
    }
    this.screen.aXe("contact_info_sns");
    AppMethodBeat.o(27201);
    return true;
  }
  
  final void iI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27197);
    ae.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aXe("contact_info_invite_source");
    TextPreference localTextPreference = (TextPreference)this.screen.aXe("contact_info_hint");
    this.screen.cT("contact_info_invite_source", false);
    SpannableString localSpannableString = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.c(this.fNT, this.fNT.getResources().getString(2131757692, new Object[] { paramString2 })));
    localSpannableString.setSpan(new ForegroundColorSpan(this.fNT.getResources().getColor(2131100035)), 0, paramString2.length(), 33);
    localKeyValuePreference.setSummary(localSpannableString);
    localKeyValuePreference.getExtras().putString("inviteer", paramString1);
    this.fNT.getIntent().putExtra("inviteer", paramString1);
    if ((this.fNS != null) && (!this.fNS.aGE().contains(this.contact.field_username)))
    {
      this.screen.cT("contact_info_footer_normal", true);
      localTextPreference.al(com.tencent.mm.pluginsdk.ui.span.k.c(this.fNT, this.fNT.getResources().getString(2131757745, new Object[] { zP(this.contact.field_username) })));
      AppMethodBeat.o(27197);
      return;
    }
    this.screen.cT("contact_info_footer_normal", false);
    AppMethodBeat.o(27197);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27202);
    if ((paramn.getType() != 30) && (paramn.getType() != 458))
    {
      ae.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + paramn.getType());
      AppMethodBeat.o(27202);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn.getType() == 30)
      {
        paramString = (com.tencent.mm.pluginsdk.model.o)paramn;
        if ((paramString.dto != 1) && (paramString.dto != 3))
        {
          AppMethodBeat.o(27202);
          return;
        }
        if ((paramString.Fes != null) && (!paramString.Fes.contains(this.contact.field_username)))
        {
          AppMethodBeat.o(27202);
          return;
        }
        paramString = (NormalUserHeaderPreference)this.screen.aXe("contact_info_header_normal");
        NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.aXe("contact_info_footer_normal");
        if ((paramString != null) && (localNormalUserFooterPreference != null) && (localNormalUserFooterPreference.xjC))
        {
          ae.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
          this.xhP = false;
          this.xhQ = false;
          paramString.cH(this.contact.field_username, false);
          paramString.cI(this.contact.field_username, false);
          paramString.DG(this.contact.field_username);
          this.fNT.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.xhP);
          this.fNT.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.xhQ);
        }
      }
      if (paramn.getType() == 453)
      {
        dDW();
        AppMethodBeat.o(27202);
      }
    }
    else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bu.isNullOrNil(paramString)))
    {
      Toast.makeText(this.fNT, paramString, 1).show();
    }
    AppMethodBeat.o(27202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */