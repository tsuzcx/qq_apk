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
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.au;
import com.tencent.mm.m.e;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.account.friend.a.as;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.c.i;
import com.tencent.mm.plugin.sns.c.i.a;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
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

@j(eFd={ContactInfoUI.class})
public final class k
  implements com.tencent.mm.al.g, i.a, com.tencent.mm.pluginsdk.b.a
{
  af contact;
  String dde;
  private int diF;
  w fql;
  String fss;
  MMActivity imP;
  int ima;
  private String rso;
  private com.tencent.mm.ui.base.preference.f screen;
  private String uAS;
  private boolean uAa;
  private int uBM;
  private cwh uBS;
  private boolean uBT;
  private String uBU;
  private int uBV;
  private boolean uBW;
  private boolean uBX;
  private String uBY;
  private boolean uBZ;
  private String uCa;
  private String uCb;
  private com.tencent.mm.plugin.profile.a.b uCc;
  private int uCd;
  String uCe;
  com.tencent.mm.sdk.b.c<ay> uCf;
  private boolean uzZ;
  
  private void Jt(int paramInt)
  {
    AppMethodBeat.i(27199);
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aKk("contact_info_source");
    if (!this.uAa)
    {
      if (localKeyValuePreference != null)
      {
        if (paramInt == 10)
        {
          localKeyValuePreference.Gfe = false;
          localKeyValuePreference.setTitle(this.imP.getString(2131757874));
          localKeyValuePreference.setSummary(this.imP.getString(2131759466));
          localKeyValuePreference.vR(false);
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
            localKeyValuePreference.Gfe = false;
            localKeyValuePreference.setTitle(this.imP.getString(2131757874));
            localKeyValuePreference.setSummary(2131757862);
            localKeyValuePreference.vR(false);
            AppMethodBeat.o(27199);
            return;
          } while (localKeyValuePreference == null);
          localKeyValuePreference.Gfe = false;
          localKeyValuePreference.setTitle(this.imP.getString(2131757874));
          localKeyValuePreference.setSummary(2131757865);
          localKeyValuePreference.vR(false);
          AppMethodBeat.o(27199);
          return;
        } while (localKeyValuePreference == null);
        localKeyValuePreference.Gfe = false;
        localKeyValuePreference.setTitle(this.imP.getString(2131757874));
        localObject2 = v.sh(this.imP.getIntent().getStringExtra("source_from_user_name"));
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject1 = this.imP.getIntent().getStringExtra("source_from_nick_name");
        }
        if (bt.isNullOrNil((String)localObject1)) {
          localKeyValuePreference.setSummary(2131757842);
        }
        for (;;)
        {
          localKeyValuePreference.vR(false);
          AppMethodBeat.o(27199);
          return;
          localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.imP, this.imP.getString(2131757841, new Object[] { localObject1 })));
        }
      } while (localKeyValuePreference == null);
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localObject1 = com.tencent.mm.bk.d.aCn().agg(this.contact.field_username);
      az.arV();
      Object localObject2 = com.tencent.mm.model.c.apM();
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject1 = ((bg)localObject2).aHY((String)localObject1);
        if (localObject1 == null) {
          break label995;
        }
      }
      break;
    }
    label995:
    for (Object localObject1 = ((au)localObject1).field_nickname;; localObject1 = null)
    {
      if (!bt.isNullOrNil((String)localObject1)) {
        localKeyValuePreference.setSummary(this.imP.getString(2131757848, new Object[] { localObject1 }));
      }
      for (;;)
      {
        localKeyValuePreference.vR(false);
        AppMethodBeat.o(27199);
        return;
        localObject1 = ((ba)localObject1).field_chatroomName;
        break;
        localKeyValuePreference.setSummary(2131757846);
      }
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localKeyValuePreference.setSummary(this.imP.getString(2131759467));
      localKeyValuePreference.vR(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757871);
      localKeyValuePreference.vR(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757837);
      localKeyValuePreference.vR(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757855);
      localKeyValuePreference.vR(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localKeyValuePreference.setSummary(this.imP.getString(2131760022));
      localKeyValuePreference.vR(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localKeyValuePreference.setSummary(this.imP.getString(2131757857));
      localKeyValuePreference.vR(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757859);
      localKeyValuePreference.vR(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.Gfe = false;
      localKeyValuePreference.setTitle(this.imP.getString(2131757874));
      localKeyValuePreference.setSummary(2131757850);
      localKeyValuePreference.vR(false);
      AppMethodBeat.o(27199);
      return;
    }
  }
  
  private void dcD()
  {
    Object localObject4 = null;
    AppMethodBeat.i(27192);
    ContactSocialInfoPreference localContactSocialInfoPreference = (ContactSocialInfoPreference)this.screen.aKk("contact_info_social");
    if (localContactSocialInfoPreference != null)
    {
      if (bt.isNullOrNil(this.uCe)) {
        break label412;
      }
      localContactSocialInfoPreference.Jp(0);
      this.uCd = 1;
    }
    for (;;)
    {
      az.arV();
      int i = bt.l((Integer)com.tencent.mm.model.c.afk().get(9, null));
      long l = this.imP.getIntent().getLongExtra("Contact_Uin", 0L);
      Object localObject1 = this.imP.getIntent().getStringExtra("Contact_QQNick");
      Object localObject2;
      if ((l != 0L) && (i != 0))
      {
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().mN(l);
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
          localContactSocialInfoPreference.Jl(0);
          this.uCd = 1;
        }
      }
      else
      {
        label191:
        if ((bt.isNullOrNil(this.uAS)) || (bt.isNullOrNil(this.uBY))) {
          break label432;
        }
        localContactSocialInfoPreference.Jn(0);
        this.uCd = 1;
        label222:
        localObject1 = com.tencent.mm.m.g.Zd().getValue("LinkedinPluginClose");
        if ((!bt.isNullOrNil((String)localObject1)) && (bt.getInt((String)localObject1, 0) != 0)) {
          break label442;
        }
        i = 1;
        label252:
        if ((i == 0) || (bt.isNullOrNil(this.contact.evK))) {
          break label447;
        }
        localContactSocialInfoPreference.Jm(0);
        this.uCd = 1;
        label280:
        if (!u.aqG().equals(this.contact.field_username)) {
          break label457;
        }
        az.arV();
        localObject1 = (String)com.tencent.mm.model.c.afk().get(ae.a.Fje, null);
        localObject2 = localObject4;
        if (bt.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        localObject2 = new JSONObject((String)localObject1).optString("ShopUrl");
        ad.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[] { localObject1, localObject2 });
        if (!bt.isNullOrNil((String)localObject2))
        {
          localContactSocialInfoPreference.Jo(0);
          this.uCd = 1;
          if (this.uCd == 0) {
            this.screen.aKl("contact_info_social");
          }
          AppMethodBeat.o(27192);
          return;
          label412:
          localContactSocialInfoPreference.Jp(8);
          continue;
          localContactSocialInfoPreference.Jl(8);
          break label191;
          label432:
          localContactSocialInfoPreference.Jn(8);
          break label222;
          label442:
          i = 0;
          break label252;
          label447:
          localContactSocialInfoPreference.Jm(8);
          break label280;
          label457:
          localObject1 = this.contact.evN;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
          Object localObject3 = localObject4;
          continue;
          localContactSocialInfoPreference.Jo(8);
        }
      }
    }
  }
  
  private void dcE()
  {
    AppMethodBeat.i(27195);
    if (com.tencent.mm.n.b.ls(this.contact.field_type))
    {
      this.screen.aKl("contact_info_source");
      AppMethodBeat.o(27195);
      return;
    }
    int i = this.imP.getIntent().getIntExtra("Contact_Source_FMessage", 0);
    ad.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.contact.getSource() + ", sourceFMessage = " + i);
    if (i != 0)
    {
      Jt(i);
      AppMethodBeat.o(27195);
      return;
    }
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aKk("contact_info_source");
    if (this.uAa) {
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
        localKeyValuePreference.Gfe = false;
        localKeyValuePreference.setTitle(this.imP.getString(2131757874));
        localKeyValuePreference.setSummary(2131757850);
        localKeyValuePreference.vR(false);
        AppMethodBeat.o(27195);
        return;
      case 30: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.Gfe = false;
        localKeyValuePreference.setTitle(this.imP.getString(2131757874));
        localKeyValuePreference.setSummary(2131757855);
        localKeyValuePreference.vR(false);
        AppMethodBeat.o(27195);
        return;
      case 48: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.Gfe = false;
        localKeyValuePreference.setTitle(this.imP.getString(2131757874));
        localKeyValuePreference.setSummary(this.imP.getString(2131757857));
        localKeyValuePreference.vR(false);
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
        localKeyValuePreference.Gfe = false;
        localKeyValuePreference.setTitle(this.imP.getString(2131757874));
        localKeyValuePreference.setSummary(2131757868);
        localKeyValuePreference.vR(false);
        AppMethodBeat.o(27195);
        return;
      case 34: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.Gfe = false;
        localKeyValuePreference.setTitle(this.imP.getString(2131757874));
        localKeyValuePreference.setSummary(this.imP.getString(2131757834));
        localKeyValuePreference.vR(false);
        AppMethodBeat.o(27195);
        return;
      case 58: 
      case 59: 
      case 60: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.Gfe = false;
        localKeyValuePreference.setTitle(this.imP.getString(2131757874));
        localKeyValuePreference.setSummary(this.imP.getString(2131760022));
        localKeyValuePreference.vR(false);
        AppMethodBeat.o(27195);
        return;
      case 76: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.Gfe = false;
        localKeyValuePreference.setTitle(this.imP.getString(2131757874));
        localKeyValuePreference.setSummary(this.imP.getString(2131757852));
        localKeyValuePreference.vR(false);
        AppMethodBeat.o(27195);
        return;
      }
    } else {
      this.screen.d(localKeyValuePreference);
    }
    AppMethodBeat.o(27195);
  }
  
  private void dcF()
  {
    AppMethodBeat.i(27196);
    this.screen.cE("contact_info_invite_source", true);
    boolean bool1;
    int i;
    if (this.fql == null)
    {
      bool1 = this.imP.getIntent().getBooleanExtra("Is_RoomOwner", false);
      if ((this.ima == 14) && (bool1) && (this.fql != null) && (!this.contact.field_username.equals(this.fql.field_roomowner))) {
        break label167;
      }
      i = this.ima;
      if (this.fql != null) {
        break label162;
      }
    }
    label162:
    for (boolean bool2 = true;; bool2 = false)
    {
      ad.i("MicroMsg.ContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.screen.cE("contact_info_invite_source", true);
      AppMethodBeat.o(27196);
      return;
      bool1 = this.fql.Vq();
      break;
    }
    label167:
    this.dde = this.imP.getIntent().getStringExtra("inviteer");
    if (bt.isNullOrNil(this.dde)) {
      this.dde = this.fql.aHA(this.contact.field_username);
    }
    if (bt.isNullOrNil(this.dde)) {
      this.dde = com.tencent.mm.model.q.at(this.contact.field_username, this.fss);
    }
    if (bt.isNullOrNil(this.dde))
    {
      ad.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[] { this.fss, this.contact.field_username });
      this.uCf.alive();
      ar.a.gMW.a(this.contact.field_username, this.fss, new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27182);
          ad.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, k.this.fss, Boolean.valueOf(paramAnonymousBoolean) });
          k.this.uCf.dead();
          AppMethodBeat.o(27182);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    this.imP.getIntent().putExtra("inviteer", this.dde);
    String str = sh(this.dde);
    if (bt.isNullOrNil(str))
    {
      ar.a.gMW.a(this.contact.field_username, "", new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27183);
          ad.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, k.this.fss, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            az.arV();
            paramAnonymousString = com.tencent.mm.model.c.apM().aHY(paramAnonymousString).ZW();
            k.this.hV(k.this.dde, paramAnonymousString);
          }
          AppMethodBeat.o(27183);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    hV(this.dde, str);
    AppMethodBeat.o(27196);
  }
  
  private void dcG()
  {
    int j = 1;
    AppMethodBeat.i(27200);
    int[] arrayOfInt = new int[7];
    ContactMoreInfoPreference localContactMoreInfoPreference = (ContactMoreInfoPreference)this.screen.aKk("contact_info_more");
    label117:
    String str;
    int i;
    if (localContactMoreInfoPreference != null)
    {
      long l = this.imP.getIntent().getLongExtra("Contact_Uin", 0L);
      if ((l == -1L) || (new p(l).longValue() <= 0L)) {
        break label319;
      }
      localContactMoreInfoPreference.Jl(0);
      arrayOfInt[0] = 0;
      if ((bt.isNullOrNil(this.uAS)) || (bt.isNullOrNil(this.uBY))) {
        break label335;
      }
      localContactMoreInfoPreference.Jn(0);
      arrayOfInt[1] = 0;
      str = com.tencent.mm.m.g.Zd().getValue("LinkedinPluginClose");
      i = j;
      if (!bt.isNullOrNil(str))
      {
        if (bt.getInt(str, 0) != 0) {
          break label351;
        }
        i = j;
      }
      label149:
      if ((i == 0) || (bt.isNullOrNil(this.contact.evK))) {
        break label356;
      }
      localContactMoreInfoPreference.Jm(0);
      arrayOfInt[2] = 0;
      label177:
      if (!u.aqG().equals(this.contact.field_username)) {
        break label372;
      }
      az.arV();
      str = (String)com.tencent.mm.model.c.afk().get(ae.a.Fje, null);
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
        localContactMoreInfoPreference.Jo(0);
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
        this.screen.cE("contact_info_more", false);
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
      localContactMoreInfoPreference.Jl(8);
      arrayOfInt[0] = 8;
      break;
      localContactMoreInfoPreference.Jn(8);
      arrayOfInt[1] = 8;
      break label117;
      i = 0;
      break label149;
      localContactMoreInfoPreference.Jm(8);
      arrayOfInt[2] = 8;
      break label177;
      str = this.contact.evN;
      break label212;
      label400:
      Object localObject = null;
      continue;
      label406:
      localContactMoreInfoPreference.Jo(8);
      arrayOfInt[3] = 8;
      continue;
      label422:
      arrayOfInt[4] = 0;
      continue;
      label430:
      arrayOfInt[5] = 0;
    }
  }
  
  private void dcu()
  {
    AppMethodBeat.i(27194);
    bRu();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2131951648);
    if (com.tencent.mm.plugin.sns.c.o.wzL != null) {
      com.tencent.mm.plugin.sns.c.o.wzL.a(3, this.contact.field_username, this);
    }
    az.aeS().a(30, this);
    az.aeS().a(453, this);
    this.uCe = "";
    ad.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[] { this.contact.ZT() });
    if (!this.contact.ZT())
    {
      localObject1 = null;
      localObject2 = this.imP.getIntent().getStringExtra("Contact_Mobile_MD5");
      localObject3 = this.imP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!bt.isNullOrNil((String)localObject2)) || (!bt.isNullOrNil((String)localObject3))) {
        break label742;
      }
      if (!bt.isNullOrNil(this.contact.field_username))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(this.contact.field_username);
        localObject3 = this.contact.field_username;
        if (localObject2 != null) {
          break label734;
        }
        localObject1 = "true";
        ad.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject1 });
        localObject1 = localObject2;
      }
      label249:
      if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).JS())))
      {
        this.uCe = bt.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).aIA()).replace(" ", "");
        ad.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[] { this.contact.field_username, this.uCe });
      }
    }
    Object localObject2 = (NormalUserHeaderPreference)this.screen.aKk("contact_info_header_normal");
    label428:
    int j;
    if (localObject2 != null)
    {
      ((NormalUserHeaderPreference)localObject2).a(this.contact, this.ima, this.rso, this.uCe, this.contact.evO);
      ((NormalUserHeaderPreference)localObject2).cs(this.contact.field_username, this.uBW);
      ((NormalUserHeaderPreference)localObject2).Cje = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27181);
          k localk = k.this;
          if (paramAnonymousView.getId() == 2131304604) {
            h.vKh.f(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.c.aA(localk.imP.getIntent())), Integer.valueOf(2), Integer.valueOf(1), localk.contact.field_username });
          }
          if (localk.contact == null)
          {
            ad.e("MicroMsg.ContactWidgetNormal", "contact is null");
            AppMethodBeat.o(27181);
            return;
          }
          if (!com.tencent.mm.n.b.ls(localk.contact.field_type))
          {
            if (!bt.isNullOrNil(localk.contact.field_encryptUsername))
            {
              localk.akG(localk.contact.field_encryptUsername);
              AppMethodBeat.o(27181);
              return;
            }
            localk.akG(localk.contact.field_username);
            AppMethodBeat.o(27181);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("Contact_Scene", localk.ima);
          paramAnonymousView.putExtra("Contact_User", localk.contact.field_username);
          paramAnonymousView.putExtra("Contact_RoomNickname", localk.imP.getIntent().getStringExtra("Contact_RoomNickname"));
          paramAnonymousView.putExtra("view_mode", true);
          paramAnonymousView.putExtra("contact_phone_number_by_md5", localk.uCe);
          paramAnonymousView.putExtra("contact_phone_number_list", localk.contact.evO);
          com.tencent.mm.plugin.profile.b.hYt.m(paramAnonymousView, localk.imP);
          AppMethodBeat.o(27181);
        }
      };
      if (com.tencent.mm.n.b.ls(this.contact.field_type)) {
        this.uBX = false;
      }
      ((NormalUserHeaderPreference)localObject2).ct(this.contact.field_username, this.uBX);
      if ((!af.aHH(this.contact.field_username)) || (this.contact.evR == 0)) {
        break label1182;
      }
      j = this.screen.indexOf("contact_info_category_1");
      localObject1 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_custom_info_header", b.a.hNA);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new PreferenceTitleCategory(this.imP);
        ((Preference)localObject3).setTitle((CharSequence)localObject1);
        this.screen.a((Preference)localObject3, j);
        ((Preference)localObject3).GfO = new Preference.b()
        {
          public final boolean dbW()
          {
            return false;
          }
        };
      }
      localObject1 = new com.tencent.mm.openim.a.c();
      ((com.tencent.mm.openim.a.c)localObject1).Bj(this.contact.evS);
      localObject1 = ((com.tencent.mm.openim.a.c)localObject1).hND.iterator();
      label580:
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (c.a)((Iterator)localObject1).next();
        localObject4 = ((c.a)localObject3).hNE.iterator();
        i = j;
      }
    }
    else
    {
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject4).hasNext()) {
          break label580;
        }
        final c.b localb = (c.b)((Iterator)localObject4).next();
        j = i + 1;
        KeyValuePreference local5 = new KeyValuePreference(this.imP)
        {
          public final void onBindView(View paramAnonymousView)
          {
            AppMethodBeat.i(27184);
            super.onBindView(paramAnonymousView);
            if (this.uCm != null) {
              if ((localb.action != 2) && (localb.action != 3)) {
                break label113;
              }
            }
            label113:
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                this.uCm.setTextColor(com.tencent.mm.sdk.platformtools.aj.getResources().getColorStateList(2131100733));
              }
              if ((this.Gfk != null) && (!TextUtils.isEmpty(localb.dub)))
              {
                this.Gfk.setVisibility(0);
                com.tencent.mm.aw.o.ayJ().loadImage(localb.dub, this.Gfk);
              }
              AppMethodBeat.o(27184);
              return;
            }
          }
        };
        local5.FNA = ((c.a)localObject3).title;
        local5.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.imP, localb.Bk(this.contact.field_openImAppid)));
        this.screen.a(local5, j);
        if ((localb.action == 0) || (localb.action == 1))
        {
          local5.setEnabled(true);
          i = j;
          continue;
          label734:
          localObject1 = "false";
          break;
          label742:
          if ((bt.isNullOrNil((String)localObject2)) && (bt.isNullOrNil((String)localObject3))) {
            break label249;
          }
          ad.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { this.contact.field_username, localObject2, localObject3 });
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).JS())) {}
          }
          else
          {
            localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf((String)localObject3);
          }
          localObject3 = this.contact.field_username;
          if (localObject1 == null) {}
          for (localObject2 = "true";; localObject2 = "false")
          {
            ad.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject2 });
            break;
          }
          this.screen.d((Preference)localObject2);
          break label428;
        }
        if (localb.action == 2)
        {
          local5.GfO = new Preference.b()
          {
            public final boolean dbW()
            {
              AppMethodBeat.i(27185);
              Object localObject1 = localb.hNG;
              try
              {
                localObject2 = new JSONObject(localb.hNG).optString("tel");
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
              h.vKh.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.uzr.title });
              localObject2 = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(localObject1))));
              ((Intent)localObject2).setFlags(268435456);
              localObject1 = k.this.imP;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27185);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 3)
        {
          local5.GfO = new Preference.b()
          {
            public final boolean dbW()
            {
              AppMethodBeat.i(27186);
              Object localObject1 = "";
              try
              {
                localObject2 = new JSONObject(localb.hNG).optString("mailto");
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
              h.vKh.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.uzr.title });
              localObject2 = new Intent("android.intent.action.SENDTO");
              ((Intent)localObject2).setData(Uri.parse("mailto:".concat(String.valueOf(localObject1))));
              localObject1 = k.this.imP;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(27186);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 4)
        {
          local5.GfO = new Preference.b()
          {
            public final boolean dbW()
            {
              AppMethodBeat.i(27187);
              Intent localIntent = new Intent();
              localIntent.setFlags(268435456);
              localIntent.setClassName(com.tencent.mm.sdk.platformtools.aj.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
              Object localObject1 = "";
              try
              {
                localObject2 = new JSONObject(localb.hNG).optString("url");
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
              h.vKh.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.uzr.title });
              localIntent.putExtra("geta8key_scene", 58);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localObject1 = com.tencent.mm.sdk.platformtools.aj.getContext();
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
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
            local5.GfO = new Preference.b()
            {
              public final boolean dbW()
              {
                AppMethodBeat.i(27188);
                try
                {
                  Object localObject = new JSONObject(localb.hNG);
                  String str = ((JSONObject)localObject).optString("name");
                  localObject = ((JSONObject)localObject).optString("pagepath");
                  uj localuj = new uj();
                  localuj.dzH.userName = str;
                  localuj.dzH.dzJ = bt.by((String)localObject, "");
                  com.tencent.mm.sdk.b.a.ESL.l(localuj);
                  h.vKh.f(15319, new Object[] { k.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.uzr.title });
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
    this.screen.a(new PreferenceSmallCategory(this.imP), i);
    Object localObject1 = new KeyValuePreference(this.imP);
    ((KeyValuePreference)localObject1).setTitle(2131757648);
    Object localObject3 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_intro_desc", b.a.hNA);
    ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.imP, (CharSequence)localObject3));
    Object localObject4 = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).c(this.contact.field_openImAppid, "openim_intro_url", b.a.hNB);
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((Preference)localObject1).GfO = new k.10(this, (String)localObject4, (String)localObject3);
    }
    this.screen.a((Preference)localObject1, i + 1);
    label1182:
    if (!bt.isNullOrNil(this.contact.getProvince()))
    {
      localObject3 = (KeyValuePreference)this.screen.aKk("contact_info_district");
      if (localObject3 != null)
      {
        ((KeyValuePreference)localObject3).setTitle(this.imP.getString(2131757646));
        localObject4 = new StringBuilder().append(v.sj(this.contact.getProvince()));
        if (bt.isNullOrNil(this.contact.getCity()))
        {
          localObject1 = "";
          ((KeyValuePreference)localObject3).setSummary((String)localObject1);
          ((KeyValuePreference)localObject3).vR(false);
          ((KeyValuePreference)localObject3).setEnabled(false);
        }
      }
      else
      {
        if ((this.contact.signature == null) || (this.contact.signature.trim().equals("")) || (com.tencent.mm.n.b.ls(this.contact.field_type))) {
          break label1927;
        }
        localObject1 = (KeyValuePreference)this.screen.aKk("contact_info_signature");
        if (localObject1 != null)
        {
          ((KeyValuePreference)localObject1).Gfe = false;
          ((KeyValuePreference)localObject1).setTitle(this.imP.getString(2131757822));
          ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this.imP, this.contact.signature));
          ((KeyValuePreference)localObject1).vR(false);
        }
        label1407:
        this.screen.aKk("contact_info_facebook");
        this.screen.aKl("contact_info_facebook");
        if ((this.uBS.ijX & 0x1) <= 0) {
          break label1943;
        }
        i = 1;
        label1447:
        if (((i & com.tencent.mm.bs.d.axB("sns")) == 0) || (af.aHF(this.contact.field_username)) || (this.contact.ZM())) {
          break label1948;
        }
        localObject1 = (com.tencent.mm.ui.base.preference.g)this.screen.aKk("contact_info_sns");
        if ((localObject1 != null) && (com.tencent.mm.plugin.sns.c.o.wzH != null)) {
          ((com.tencent.mm.ui.base.preference.g)localObject1).aCk(this.contact.field_username);
        }
        label1523:
        this.screen.aKl("contact_info_verifyuser");
        this.screen.aKl("contact_info_footer_normal");
        this.uCc = new com.tencent.mm.plugin.profile.a.b(this.imP, this.contact);
        this.uCc.cKF();
        if (this.ima == 96) {
          this.screen.aKl("contact_info_footer_normal");
        }
        if (!com.tencent.mm.n.b.ls(this.contact.field_type)) {
          break label1964;
        }
        dcG();
        this.screen.aKl("contact_info_social");
        label1626:
        dcE();
        dcF();
        localObject1 = (NormalUserFooterPreference)this.screen.aKk("contact_info_footer_normal");
        boolean bool1 = this.imP.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean bool2 = this.imP.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.imP.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long l = this.imP.getIntent().getLongExtra("Contact_Uin", -1L);
        if ((this.ima == 30) || (this.ima == 45)) {
          this.uBT = false;
        }
        if ((localObject1 == null) || (!((NormalUserFooterPreference)localObject1).a(this.contact, this.rso, this.uzZ, this.uAa, this.uBT, this.ima, this.uBM, bool2, bool1, l, this.uBU))) {
          break label1984;
        }
        ((NormalUserFooterPreference)localObject1).gTG.removeAll();
        ((NormalUserFooterPreference)localObject1).gTG.a(new NormalUserFooterPreference.e() {}, Looper.getMainLooper());
      }
    }
    for (;;)
    {
      label1298:
      this.screen.aKl("clear_lbs_info");
      if (this.uBZ)
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
      this.screen.aKl("contact_info_district");
      break label1298;
      label1927:
      this.screen.aKl("contact_info_signature");
      break label1407;
      label1943:
      i = 0;
      break label1447;
      label1948:
      this.screen.aKl("contact_info_sns");
      break label1523;
      label1964:
      dcD();
      this.screen.aKl("contact_info_more");
      break label1626;
      label1984:
      this.screen.aKl("contact_info_footer_normal");
    }
  }
  
  private String sh(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27198);
    if (this.fql == null)
    {
      AppMethodBeat.o(27198);
      return null;
    }
    az.arV();
    af localaf = com.tencent.mm.model.c.apM().aHY(paramString);
    Object localObject1 = localObject2;
    if (localaf != null)
    {
      localObject1 = localObject2;
      if ((int)localaf.fId > 0) {
        localObject1 = localaf.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (bt.isNullOrNil((String)localObject1)) {
      localObject2 = this.fql.sh(paramString);
    }
    paramString = (String)localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      paramString = (String)localObject2;
      if (localaf != null) {
        paramString = localaf.ZW();
      }
    }
    AppMethodBeat.o(27198);
    return paramString;
  }
  
  public final boolean SN(String paramString)
  {
    AppMethodBeat.i(27190);
    Object localObject2;
    Object localObject1;
    long l;
    if (paramString.equals("contact_info_sns"))
    {
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.imP, null);
        AppMethodBeat.o(27190);
        return true;
      }
      localObject2 = this.imP.getIntent();
      ((Intent)localObject2).putExtra("sns_source", this.diF);
      ((Intent)localObject2).putExtra("sns_signature", this.contact.signature);
      ((Intent)localObject2).putExtra("sns_nickName", this.contact.ZW());
      ((Intent)localObject2).putExtra("sns_title", this.contact.ZX());
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.sns.c.o.wzL != null) {
        localObject1 = com.tencent.mm.plugin.sns.c.o.wzL.f((Intent)localObject2, this.contact.field_username);
      }
      if (localObject1 == null) {
        this.imP.finish();
      }
    }
    else
    {
      if (!paramString.equals("contact_info_more")) {
        break label508;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(this.imP, ContactMoreInfoUI.class);
      ((Intent)localObject2).putExtra("Is_RoomOwner", this.imP.getIntent().getBooleanExtra("Is_RoomOwner", false));
      ((Intent)localObject2).putExtra("Contact_User", this.contact.field_username);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendNickName", this.uCa);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendPubUrl", this.uCb);
      localObject1 = this.imP.getIntent().getStringExtra("room_name");
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = this.imP.getIntent().getStringExtra("Contact_ChatRoomId");
      }
      ((Intent)localObject2).putExtra("Contact_ChatRoomId", paramString);
      ((Intent)localObject2).putExtra("verify_gmail", this.uAS);
      ((Intent)localObject2).putExtra("profileName", this.uBY);
      l = this.imP.getIntent().getLongExtra("Contact_Uin", 0L);
      paramString = this.imP.getIntent().getStringExtra("Contact_QQNick");
      ((Intent)localObject2).putExtra("Contact_Uin", l);
      ((Intent)localObject2).putExtra("Contact_QQNick", paramString);
      paramString = this.imP;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(27190);
      return true;
      ((Intent)localObject1).putExtra("sns_adapter_type", 1);
      com.tencent.mm.bs.d.b(this.imP, "sns", ".ui.SnsTimeLineUserPagerUI", (Intent)localObject1);
      if ((((Intent)localObject1).getFlags() & 0x4000000) == 0) {
        break;
      }
      this.imP.finish();
      break;
      label508:
      if (paramString.equals("contact_info_social"))
      {
        paramString = new Intent();
        paramString.setClass(this.imP, ContactSocialInfoUI.class);
        paramString.putExtra("Contact_User", this.contact.field_username);
        l = this.imP.getIntent().getLongExtra("Contact_Uin", 0L);
        localObject1 = this.imP.getIntent().getStringExtra("Contact_QQNick");
        paramString.putExtra("Contact_Uin", l);
        paramString.putExtra("Contact_QQNick", (String)localObject1);
        paramString.putExtra("profileName", this.uBY);
        paramString.putExtra("verify_gmail", this.uAS);
        localObject1 = this.imP.getIntent().getStringExtra("Contact_Mobile_MD5");
        localObject2 = this.imP.getIntent().getStringExtra("Contact_full_Mobile_MD5");
        paramString.putExtra("Contact_Mobile_MD5", (String)localObject1);
        paramString.putExtra("Contact_full_Mobile_MD5", (String)localObject2);
        localObject1 = this.imP;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bd(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.adn(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)paramString.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.screen.aKk("contact_info_invite_source")).getExtras().getString("inviteer");
        if (!bt.isNullOrNil(paramString))
        {
          localObject1 = sh(paramString);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", paramString);
          ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomMember", true);
          ((Intent)localObject2).putExtra("room_name", this.fss);
          az.arV();
          ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.apM().aHY(paramString).field_nickname);
          ((Intent)localObject2).putExtra("Contact_Scene", 14);
          ((Intent)localObject2).putExtra("Is_RoomOwner", true);
          ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.fss);
          com.tencent.mm.plugin.profile.b.hYt.c((Intent)localObject2, this.imP);
        }
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(27203);
    paramString = (com.tencent.mm.ui.base.preference.g)this.screen.aKk("contact_info_sns");
    if ((paramString != null) && (com.tencent.mm.plugin.sns.c.o.wzH != null)) {
      paramString.aCk(this.contact.field_username);
    }
    this.uBS = com.tencent.mm.plugin.sns.c.o.wzH.b(this.contact.field_username, this.uBS);
    this.screen.notifyDataSetChanged();
    if (paramb.drJ())
    {
      ad.d("MicroMsg.ContactWidgetNormal", "bg Change!");
      if (com.tencent.mm.plugin.sns.c.o.wzL != null) {
        com.tencent.mm.plugin.sns.c.o.wzL.anw(this.contact.field_username);
      }
    }
    AppMethodBeat.o(27203);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, af paramaf, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(27193);
    boolean bool;
    if (paramaf != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (bt.nullAsNil(paramaf.field_username).length() <= 0) {
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
      this.contact = paramaf;
      this.uzZ = paramBoolean;
      this.ima = paramInt;
      this.uAa = this.imP.getIntent().getBooleanExtra("User_Verify", false);
      this.rso = bt.nullAsNil(this.imP.getIntent().getStringExtra("Verify_ticket"));
      this.uBT = this.imP.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
      this.uBM = this.imP.getIntent().getIntExtra("Kdel_from", -1);
      this.uBU = this.imP.getIntent().getStringExtra("Contact_RemarkName");
      this.diF = this.imP.getIntent().getIntExtra("Sns_from_Scene", 0);
      this.uBW = this.imP.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
      this.uBX = this.imP.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
      this.uBV = this.imP.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
      long l = this.imP.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
      paramf = bt.by(this.imP.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
      this.uAS = bt.by(this.imP.getIntent().getStringExtra("verify_gmail"), "");
      this.uBY = bt.by(this.imP.getIntent().getStringExtra("profileName"), bt.aGr(this.uAS));
      this.uBS.ijX = this.uBV;
      this.uBS.ijZ = l;
      this.uBS.ijY = paramf;
      this.uCa = this.imP.getIntent().getStringExtra("KLinkedInAddFriendNickName");
      this.uCb = this.imP.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
      if (com.tencent.mm.plugin.sns.c.o.wzH != null) {
        this.uBS = com.tencent.mm.plugin.sns.c.o.wzH.b(paramaf.field_username, this.uBS);
      }
      this.fss = this.imP.getIntent().getStringExtra("room_name");
      az.arV();
      this.fql = com.tencent.mm.model.c.apV().tH(this.fss);
      if (paramaf.field_deleteFlag != 1) {
        break label613;
      }
    }
    label601:
    label607:
    label613:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.uBZ = paramBoolean;
      dcu();
      az.arV();
      com.tencent.mm.model.c.apM().aHT(paramaf.field_username);
      paramBoolean = u.aqG().equals(paramaf.field_username);
      ad.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[] { Integer.valueOf(this.uBS.ijX) });
      paramInt = i;
      if ((this.uBS.ijX & 0x1) > 0) {
        paramInt = 1;
      }
      if ((!paramaf.ZM()) && (!af.aHF(paramaf.field_username)) && (paramInt != 0) && (com.tencent.mm.plugin.sns.c.o.wzL != null)) {
        com.tencent.mm.plugin.sns.c.o.wzL.a(2, paramaf.field_username, paramBoolean, this.diF);
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
  
  final void akG(String paramString)
  {
    AppMethodBeat.i(27191);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(27191);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.ima);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.contact.field_username);
    paramString.putExtra("Contact_Nick", this.contact.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.contact.field_conRemark);
    com.tencent.mm.plugin.profile.b.hYt.n(paramString, this.imP);
    AppMethodBeat.o(27191);
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27201);
    if (com.tencent.mm.plugin.sns.c.o.wzL != null) {
      com.tencent.mm.plugin.sns.c.o.wzL.a(this, 3);
    }
    az.aeS().b(30, this);
    az.aeS().b(453, this);
    Object localObject = (NormalProfileHeaderPreference)this.screen.aKk("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (NormalUserFooterPreference)this.screen.aKk("contact_info_footer_normal");
    if (localObject != null) {
      ((NormalUserFooterPreference)localObject).bRu();
    }
    localObject = (FriendPreference)this.screen.aKk("contact_info_friend_qq");
    if (localObject != null) {
      ((FriendPreference)localObject).bRu();
    }
    localObject = (FriendPreference)this.screen.aKk("contact_info_friend_mobile");
    if (localObject != null) {
      ((FriendPreference)localObject).bRu();
    }
    localObject = (FriendPreference)this.screen.aKk("contact_info_facebook");
    if (localObject != null) {
      ((FriendPreference)localObject).bRu();
    }
    if (this.uCc != null) {
      this.uCc.destroy();
    }
    this.screen.aKk("contact_info_sns");
    AppMethodBeat.o(27201);
    return true;
  }
  
  final void hV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27197);
    ad.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.aKk("contact_info_invite_source");
    TextPreference localTextPreference = (TextPreference)this.screen.aKk("contact_info_hint");
    this.screen.cE("contact_info_invite_source", false);
    SpannableString localSpannableString = new SpannableString(com.tencent.mm.pluginsdk.ui.span.k.c(this.imP, this.imP.getResources().getString(2131757692, new Object[] { paramString2 })));
    localSpannableString.setSpan(new ForegroundColorSpan(this.imP.getResources().getColor(2131100035)), 0, paramString2.length(), 33);
    localKeyValuePreference.setSummary(localSpannableString);
    localKeyValuePreference.getExtras().putString("inviteer", paramString1);
    this.imP.getIntent().putExtra("inviteer", paramString1);
    if ((this.fql != null) && (!this.fql.awt().contains(this.contact.field_username)))
    {
      this.screen.cE("contact_info_footer_normal", true);
      localTextPreference.al(com.tencent.mm.pluginsdk.ui.span.k.c(this.imP, this.imP.getResources().getString(2131757745, new Object[] { sh(this.contact.field_username) })));
      AppMethodBeat.o(27197);
      return;
    }
    this.screen.cE("contact_info_footer_normal", false);
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
        if ((paramString.djq != 1) && (paramString.djq != 3))
        {
          AppMethodBeat.o(27202);
          return;
        }
        if ((paramString.BOW != null) && (!paramString.BOW.contains(this.contact.field_username)))
        {
          AppMethodBeat.o(27202);
          return;
        }
        paramString = (NormalUserHeaderPreference)this.screen.aKk("contact_info_header_normal");
        NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.aKk("contact_info_footer_normal");
        if ((paramString != null) && (localNormalUserFooterPreference != null) && (localNormalUserFooterPreference.uDL))
        {
          ad.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
          this.uBW = false;
          this.uBX = false;
          paramString.cs(this.contact.field_username, false);
          paramString.ct(this.contact.field_username, false);
          paramString.vZ(this.contact.field_username);
          this.imP.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.uBW);
          this.imP.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.uBX);
        }
      }
      if (paramn.getType() == 453)
      {
        dcu();
        AppMethodBeat.o(27202);
      }
    }
    else if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString)))
    {
      Toast.makeText(this.imP, paramString, 1).show();
    }
    AppMethodBeat.o(27202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.k
 * JD-Core Version:    0.7.0.1
 */