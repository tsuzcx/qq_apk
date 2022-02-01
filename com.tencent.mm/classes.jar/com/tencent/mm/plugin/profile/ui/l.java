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
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.bd;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.openim.a.b.b;
import com.tencent.mm.plugin.account.friend.a.at;
import com.tencent.mm.plugin.sns.b.i.a;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.DoNotCheckLeakForActivities;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.b;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;
import org.json.JSONException;
import org.json.JSONObject;

@DoNotCheckLeakForActivities({ContactInfoUI.class})
public final class l
  implements com.tencent.mm.ak.i, i.a, com.tencent.mm.pluginsdk.b.a
{
  private boolean Bdx;
  private boolean Bdy;
  private String Bey;
  private ebj BfF;
  private boolean BfG;
  private String BfH;
  private int BfI;
  private boolean BfJ;
  private boolean BfK;
  private String BfL;
  private boolean BfM;
  private String BfN;
  private String BfO;
  private com.tencent.mm.plugin.profile.a.b BfP;
  private int BfQ;
  String BfR;
  IListener<bd> BfS;
  private int Bft;
  com.tencent.mm.storage.as contact;
  String dEn;
  private int dJN;
  ah gtd;
  MMActivity gte;
  String gwx;
  int kgm;
  private com.tencent.mm.ui.base.preference.f screen;
  private String wZz;
  
  private void UN(int paramInt)
  {
    AppMethodBeat.i(27199);
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.bmg("contact_info_source");
    if (!this.Bdy)
    {
      if (localKeyValuePreference != null)
      {
        if (paramInt == 10)
        {
          localKeyValuePreference.OYB = false;
          localKeyValuePreference.setTitle(this.gte.getString(2131758114));
          localKeyValuePreference.setSummary(this.gte.getString(2131760781));
          localKeyValuePreference.BC(false);
          AppMethodBeat.o(27199);
          return;
        }
        this.screen.e(localKeyValuePreference);
      }
      AppMethodBeat.o(27199);
      return;
    }
    switch (paramInt)
    {
    default: 
      this.screen.e(localKeyValuePreference);
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
            localKeyValuePreference.OYB = false;
            localKeyValuePreference.setTitle(this.gte.getString(2131758114));
            localKeyValuePreference.setSummary(2131758102);
            localKeyValuePreference.BC(false);
            AppMethodBeat.o(27199);
            return;
          } while (localKeyValuePreference == null);
          localKeyValuePreference.OYB = false;
          localKeyValuePreference.setTitle(this.gte.getString(2131758114));
          localKeyValuePreference.setSummary(2131758105);
          localKeyValuePreference.BC(false);
          AppMethodBeat.o(27199);
          return;
        } while (localKeyValuePreference == null);
        localKeyValuePreference.OYB = false;
        localKeyValuePreference.setTitle(this.gte.getString(2131758114));
        localObject2 = aa.getDisplayName(this.gte.getIntent().getStringExtra("source_from_user_name"));
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = this.gte.getIntent().getStringExtra("source_from_nick_name");
        }
        if (Util.isNullOrNil((String)localObject1)) {
          localKeyValuePreference.setSummary(2131758082);
        }
        for (;;)
        {
          localKeyValuePreference.BC(false);
          AppMethodBeat.o(27199);
          return;
          localKeyValuePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getString(2131758081, new Object[] { localObject1 })));
        }
      } while (localKeyValuePreference == null);
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localObject1 = com.tencent.mm.bj.d.bgM().aEm(this.contact.field_username);
      bg.aVF();
      Object localObject2 = com.tencent.mm.model.c.aSN();
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject1 = ((bv)localObject2).Kn((String)localObject1);
        if (localObject1 == null) {
          break label995;
        }
      }
      break;
    }
    label995:
    for (Object localObject1 = ((ax)localObject1).field_nickname;; localObject1 = null)
    {
      if (!Util.isNullOrNil((String)localObject1)) {
        localKeyValuePreference.setSummary(this.gte.getString(2131758088, new Object[] { localObject1 }));
      }
      for (;;)
      {
        localKeyValuePreference.BC(false);
        AppMethodBeat.o(27199);
        return;
        localObject1 = ((bn)localObject1).field_chatroomName;
        break;
        localKeyValuePreference.setSummary(2131758086);
      }
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localKeyValuePreference.setSummary(this.gte.getString(2131760782));
      localKeyValuePreference.BC(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localKeyValuePreference.setSummary(2131758111);
      localKeyValuePreference.BC(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localKeyValuePreference.setSummary(2131758077);
      localKeyValuePreference.BC(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localKeyValuePreference.setSummary(2131758095);
      localKeyValuePreference.BC(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localKeyValuePreference.setSummary(this.gte.getString(2131761400));
      localKeyValuePreference.BC(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localKeyValuePreference.setSummary(this.gte.getString(2131758097));
      localKeyValuePreference.BC(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localKeyValuePreference.setSummary(2131758099);
      localKeyValuePreference.BC(false);
      AppMethodBeat.o(27199);
      return;
      if (localKeyValuePreference == null) {
        break;
      }
      localKeyValuePreference.OYB = false;
      localKeyValuePreference.setTitle(this.gte.getString(2131758114));
      localKeyValuePreference.setSummary(2131758090);
      localKeyValuePreference.BC(false);
      AppMethodBeat.o(27199);
      return;
    }
  }
  
  private void eEA()
  {
    Object localObject4 = null;
    AppMethodBeat.i(27192);
    ContactSocialInfoPreference localContactSocialInfoPreference = (ContactSocialInfoPreference)this.screen.bmg("contact_info_social");
    if (localContactSocialInfoPreference != null)
    {
      if (Util.isNullOrNil(this.BfR)) {
        break label412;
      }
      localContactSocialInfoPreference.UJ(0);
      this.BfQ = 1;
    }
    for (;;)
    {
      bg.aVF();
      int i = Util.nullAsNil((Integer)com.tencent.mm.model.c.azQ().get(9, null));
      long l = this.gte.getIntent().getLongExtra("Contact_Uin", 0L);
      Object localObject1 = this.gte.getIntent().getStringExtra("Contact_QQNick");
      Object localObject2;
      if ((l != 0L) && (i != 0))
      {
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          localObject2 = com.tencent.mm.plugin.account.a.getQQListStg().AT(l);
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = null;
          }
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.account.friend.a.as)localObject1).getDisplayName();
          }
        }
        if ((l != -1L) && (new com.tencent.mm.b.p(l).longValue() > 0L))
        {
          localContactSocialInfoPreference.UF(0);
          this.BfQ = 1;
        }
      }
      else
      {
        label191:
        if ((Util.isNullOrNil(this.Bey)) || (Util.isNullOrNil(this.BfL))) {
          break label432;
        }
        localContactSocialInfoPreference.UH(0);
        this.BfQ = 1;
        label222:
        localObject1 = com.tencent.mm.n.h.aqJ().getValue("LinkedinPluginClose");
        if ((!Util.isNullOrNil((String)localObject1)) && (Util.getInt((String)localObject1, 0) != 0)) {
          break label442;
        }
        i = 1;
        label252:
        if ((i == 0) || (Util.isNullOrNil(this.contact.fuT))) {
          break label447;
        }
        localContactSocialInfoPreference.UG(0);
        this.BfQ = 1;
        label280:
        if (!z.aTY().equals(this.contact.field_username)) {
          break label457;
        }
        bg.aVF();
        localObject1 = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVK, null);
        localObject2 = localObject4;
        if (Util.isNullOrNil((String)localObject1)) {}
      }
      try
      {
        localObject2 = new JSONObject((String)localObject1).optString("ShopUrl");
        Log.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[] { localObject1, localObject2 });
        if (!Util.isNullOrNil((String)localObject2))
        {
          localContactSocialInfoPreference.UI(0);
          this.BfQ = 1;
          if (this.BfQ == 0) {
            this.screen.bmi("contact_info_social");
          }
          AppMethodBeat.o(27192);
          return;
          label412:
          localContactSocialInfoPreference.UJ(8);
          continue;
          localContactSocialInfoPreference.UF(8);
          break label191;
          label432:
          localContactSocialInfoPreference.UH(8);
          break label222;
          label442:
          i = 0;
          break label252;
          label447:
          localContactSocialInfoPreference.UG(8);
          break label280;
          label457:
          localObject1 = this.contact.fuW;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
          Object localObject3 = localObject4;
          continue;
          localContactSocialInfoPreference.UI(8);
        }
      }
    }
  }
  
  private void eEB()
  {
    AppMethodBeat.i(27195);
    if (com.tencent.mm.contact.c.oR(this.contact.field_type))
    {
      this.screen.bmi("contact_info_source");
      AppMethodBeat.o(27195);
      return;
    }
    int i = this.gte.getIntent().getIntExtra("Contact_Source_FMessage", 0);
    Log.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.contact.getSource() + ", sourceFMessage = " + i);
    if (i != 0)
    {
      UN(i);
      AppMethodBeat.o(27195);
      return;
    }
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.bmg("contact_info_source");
    if (this.Bdy) {
      switch (this.contact.getSource())
      {
      default: 
        this.screen.e(localKeyValuePreference);
        AppMethodBeat.o(27195);
        return;
      case 18: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.OYB = false;
        localKeyValuePreference.setTitle(this.gte.getString(2131758114));
        localKeyValuePreference.setSummary(2131758090);
        localKeyValuePreference.BC(false);
        AppMethodBeat.o(27195);
        return;
      case 30: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.OYB = false;
        localKeyValuePreference.setTitle(this.gte.getString(2131758114));
        localKeyValuePreference.setSummary(2131758095);
        localKeyValuePreference.BC(false);
        AppMethodBeat.o(27195);
        return;
      case 48: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.OYB = false;
        localKeyValuePreference.setTitle(this.gte.getString(2131758114));
        localKeyValuePreference.setSummary(this.gte.getString(2131758097));
        localKeyValuePreference.BC(false);
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
        localKeyValuePreference.OYB = false;
        localKeyValuePreference.setTitle(this.gte.getString(2131758114));
        localKeyValuePreference.setSummary(2131758108);
        localKeyValuePreference.BC(false);
        AppMethodBeat.o(27195);
        return;
      case 34: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.OYB = false;
        localKeyValuePreference.setTitle(this.gte.getString(2131758114));
        localKeyValuePreference.setSummary(this.gte.getString(2131758074));
        localKeyValuePreference.BC(false);
        AppMethodBeat.o(27195);
        return;
      case 58: 
      case 59: 
      case 60: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.OYB = false;
        localKeyValuePreference.setTitle(this.gte.getString(2131758114));
        localKeyValuePreference.setSummary(this.gte.getString(2131761400));
        localKeyValuePreference.BC(false);
        AppMethodBeat.o(27195);
        return;
      case 76: 
        if (localKeyValuePreference == null) {
          break;
        }
        localKeyValuePreference.OYB = false;
        localKeyValuePreference.setTitle(this.gte.getString(2131758114));
        localKeyValuePreference.setSummary(this.gte.getString(2131758092));
        localKeyValuePreference.BC(false);
        AppMethodBeat.o(27195);
        return;
      }
    } else {
      this.screen.e(localKeyValuePreference);
    }
    AppMethodBeat.o(27195);
  }
  
  private void eEC()
  {
    AppMethodBeat.i(27196);
    this.screen.jdMethod_do("contact_info_invite_source", true);
    boolean bool1;
    int i;
    if (this.gtd == null)
    {
      bool1 = this.gte.getIntent().getBooleanExtra("Is_RoomOwner", false);
      if ((this.kgm == 14) && (bool1) && (this.gtd != null) && (!this.contact.field_username.equals(this.gtd.field_roomowner))) {
        break label167;
      }
      i = this.kgm;
      if (this.gtd != null) {
        break label162;
      }
    }
    label162:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.ContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      this.screen.jdMethod_do("contact_info_invite_source", true);
      AppMethodBeat.o(27196);
      return;
      bool1 = this.gtd.amD();
      break;
    }
    label167:
    this.dEn = this.gte.getIntent().getStringExtra("inviteer");
    if (Util.isNullOrNil(this.dEn)) {
      this.dEn = this.gtd.bjg(this.contact.field_username);
    }
    if (Util.isNullOrNil(this.dEn)) {
      this.dEn = v.aF(this.contact.field_username, this.gwx);
    }
    if (Util.isNullOrNil(this.dEn))
    {
      Log.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[] { this.gwx, this.contact.field_username });
      this.BfS.alive();
      ay.a.iDq.a(this.contact.field_username, this.gwx, new ay.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27182);
          Log.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, l.this.gwx, Boolean.valueOf(paramAnonymousBoolean) });
          l.this.BfS.dead();
          AppMethodBeat.o(27182);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    this.gte.getIntent().putExtra("inviteer", this.dEn);
    String str = getDisplayName(this.dEn);
    if (Util.isNullOrNil(str))
    {
      ay.a.iDq.a(this.contact.field_username, "", new ay.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(27183);
          Log.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, l.this.gwx, Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousBoolean)
          {
            bg.aVF();
            paramAnonymousString = com.tencent.mm.model.c.aSN().Kn(paramAnonymousString).arI();
            l.this.jv(l.this.dEn, paramAnonymousString);
          }
          AppMethodBeat.o(27183);
        }
      });
      AppMethodBeat.o(27196);
      return;
    }
    jv(this.dEn, str);
    AppMethodBeat.o(27196);
  }
  
  private void eED()
  {
    int j = 1;
    AppMethodBeat.i(27200);
    int[] arrayOfInt = new int[7];
    ContactMoreInfoPreference localContactMoreInfoPreference = (ContactMoreInfoPreference)this.screen.bmg("contact_info_more");
    label117:
    String str;
    int i;
    if (localContactMoreInfoPreference != null)
    {
      long l = this.gte.getIntent().getLongExtra("Contact_Uin", 0L);
      if ((l == -1L) || (new com.tencent.mm.b.p(l).longValue() <= 0L)) {
        break label319;
      }
      localContactMoreInfoPreference.UF(0);
      arrayOfInt[0] = 0;
      if ((Util.isNullOrNil(this.Bey)) || (Util.isNullOrNil(this.BfL))) {
        break label335;
      }
      localContactMoreInfoPreference.UH(0);
      arrayOfInt[1] = 0;
      str = com.tencent.mm.n.h.aqJ().getValue("LinkedinPluginClose");
      i = j;
      if (!Util.isNullOrNil(str))
      {
        if (Util.getInt(str, 0) != 0) {
          break label351;
        }
        i = j;
      }
      label149:
      if ((i == 0) || (Util.isNullOrNil(this.contact.fuT))) {
        break label356;
      }
      localContactMoreInfoPreference.UG(0);
      arrayOfInt[2] = 0;
      label177:
      if (!z.aTY().equals(this.contact.field_username)) {
        break label372;
      }
      bg.aVF();
      str = (String)com.tencent.mm.model.c.azQ().get(ar.a.NVK, null);
      label212:
      if (Util.isNullOrNil(str)) {
        break label400;
      }
    }
    for (;;)
    {
      try
      {
        str = new JSONObject(str).optString("ShopUrl");
        if (Util.isNullOrNil(str)) {
          break label406;
        }
        localContactMoreInfoPreference.UI(0);
        arrayOfInt[3] = 0;
        if (!Util.isNullOrNil(this.contact.signature)) {
          break label422;
        }
        arrayOfInt[4] = 8;
        if (this.contact.getSource() > 0) {
          break label430;
        }
        arrayOfInt[5] = 8;
        arrayOfInt[6] = 8;
        this.screen.jdMethod_do("contact_info_more", false);
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
        Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "", new Object[0]);
      }
      localContactMoreInfoPreference.UF(8);
      arrayOfInt[0] = 8;
      break;
      localContactMoreInfoPreference.UH(8);
      arrayOfInt[1] = 8;
      break label117;
      i = 0;
      break label149;
      localContactMoreInfoPreference.UG(8);
      arrayOfInt[2] = 8;
      break label177;
      str = this.contact.fuW;
      break label212;
      label400:
      Object localObject = null;
      continue;
      label406:
      localContactMoreInfoPreference.UI(8);
      arrayOfInt[3] = 8;
      continue;
      label422:
      arrayOfInt[4] = 0;
      continue;
      label430:
      arrayOfInt[5] = 0;
    }
  }
  
  private void eEp()
  {
    AppMethodBeat.i(27194);
    cCs();
    this.screen.removeAll();
    this.screen.addPreferencesFromResource(2132017186);
    if (o.DCR != null) {
      o.DCR.a(3, this.contact.field_username, this);
    }
    bg.azz().a(30, this);
    bg.azz().a(453, this);
    this.BfR = "";
    Log.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[] { this.contact.arF() });
    if (!this.contact.arF())
    {
      localObject1 = null;
      localObject2 = this.gte.getIntent().getStringExtra("Contact_Mobile_MD5");
      localObject3 = this.gte.getIntent().getStringExtra("Contact_full_Mobile_MD5");
      if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil((String)localObject3))) {
        break label742;
      }
      if (!Util.isNullOrNil(this.contact.field_username))
      {
        localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(this.contact.field_username);
        localObject3 = this.contact.field_username;
        if (localObject2 != null) {
          break label734;
        }
        localObject1 = "true";
        Log.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject1 });
        localObject1 = localObject2;
      }
      label249:
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).getMd5())))
      {
        this.BfR = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).bnP()).replace(" ", "");
        Log.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[] { this.contact.field_username, this.BfR });
      }
    }
    Object localObject2 = (NormalUserHeaderPreference)this.screen.bmg("contact_info_header_normal");
    label428:
    int j;
    if (localObject2 != null)
    {
      ((NormalUserHeaderPreference)localObject2).a(this.contact, this.kgm, this.wZz, this.BfR, this.contact.fuX);
      ((NormalUserHeaderPreference)localObject2).dc(this.contact.field_username, this.BfJ);
      ((NormalUserHeaderPreference)localObject2).KpZ = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27181);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          localObject = l.this;
          if (paramAnonymousView.getId() == 2131307653) {
            com.tencent.mm.plugin.report.service.h.CyF.a(16055, new Object[] { Integer.valueOf(com.tencent.mm.plugin.profile.d.aP(((l)localObject).gte.getIntent())), Integer.valueOf(2), Integer.valueOf(1), ((l)localObject).contact.field_username });
          }
          if (((l)localObject).contact == null) {
            Log.e("MicroMsg.ContactWidgetNormal", "contact is null");
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27181);
            return;
            if (!com.tencent.mm.contact.c.oR(((l)localObject).contact.field_type))
            {
              if (!Util.isNullOrNil(((l)localObject).contact.field_encryptUsername)) {
                ((l)localObject).aKs(((l)localObject).contact.field_encryptUsername);
              } else {
                ((l)localObject).aKs(((l)localObject).contact.field_username);
              }
            }
            else
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_Scene", ((l)localObject).kgm);
              paramAnonymousView.putExtra("Contact_User", ((l)localObject).contact.field_username);
              paramAnonymousView.putExtra("Contact_RoomNickname", ((l)localObject).gte.getIntent().getStringExtra("Contact_RoomNickname"));
              paramAnonymousView.putExtra("view_mode", true);
              paramAnonymousView.putExtra("contact_phone_number_by_md5", ((l)localObject).BfR);
              paramAnonymousView.putExtra("contact_phone_number_list", ((l)localObject).contact.fuX);
              com.tencent.mm.plugin.profile.b.jRt.l(paramAnonymousView, ((l)localObject).gte);
            }
          }
        }
      };
      if (com.tencent.mm.contact.c.oR(this.contact.field_type)) {
        this.BfK = false;
      }
      ((NormalUserHeaderPreference)localObject2).dd(this.contact.field_username, this.BfK);
      if ((!com.tencent.mm.storage.as.bjp(this.contact.field_username)) || (this.contact.fva == 0)) {
        break label1182;
      }
      j = this.screen.indexOf("contact_info_category_1");
      localObject1 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_custom_info_header", a.a.jGS);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new PreferenceTitleCategory(this.gte);
        ((Preference)localObject3).setTitle((CharSequence)localObject1);
        this.screen.a((Preference)localObject3, j);
        ((Preference)localObject3).OZp = new Preference.b()
        {
          public final boolean a(Preference paramAnonymousPreference)
          {
            return false;
          }
        };
      }
      localObject1 = new com.tencent.mm.openim.a.b();
      ((com.tencent.mm.openim.a.b)localObject1).Sa(this.contact.fvb);
      localObject1 = ((com.tencent.mm.openim.a.b)localObject1).jGV.iterator();
      label580:
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (b.a)((Iterator)localObject1).next();
        localObject4 = ((b.a)localObject3).jGW.iterator();
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
        final b.b localb = (b.b)((Iterator)localObject4).next();
        j = i + 1;
        KeyValuePreference local5 = new KeyValuePreference(this.gte)
        {
          public final void onBindView(View paramAnonymousView)
          {
            AppMethodBeat.i(27184);
            super.onBindView(paramAnonymousView);
            if (this.BfZ != null) {
              if ((localb.action != 2) && (localb.action != 3)) {
                break label113;
              }
            }
            label113:
            for (int i = 1;; i = 0)
            {
              if (i != 0) {
                this.BfZ.setTextColor(MMApplicationContext.getResources().getColorStateList(2131100927));
              }
              if ((this.OYH != null) && (!TextUtils.isEmpty(localb.icon)))
              {
                this.OYH.setVisibility(0);
                com.tencent.mm.av.q.bcV().loadImage(localb.icon, this.OYH);
              }
              AppMethodBeat.o(27184);
              return;
            }
          }
        };
        local5.OFU = ((b.a)localObject3).title;
        local5.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, localb.Sb(this.contact.field_openImAppid)));
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
          if ((Util.isNullOrNil((String)localObject2)) && (Util.isNullOrNil((String)localObject3))) {
            break label249;
          }
          Log.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { this.contact.field_username, localObject2, localObject3 });
          localObject2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject2);
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject2).getMd5())) {}
          }
          else
          {
            localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU((String)localObject3);
          }
          localObject3 = this.contact.field_username;
          if (localObject1 == null) {}
          for (localObject2 = "true";; localObject2 = "false")
          {
            Log.i("MicroMsg.ContactWidgetNormal", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject3, localObject2 });
            break;
          }
          this.screen.e((Preference)localObject2);
          break label428;
        }
        if (localb.action == 2)
        {
          local5.OZp = new Preference.b()
          {
            public final boolean a(Preference paramAnonymousPreference)
            {
              AppMethodBeat.i(231877);
              paramAnonymousPreference = localb.jGY;
              try
              {
                localObject = new JSONObject(localb.jGY).optString("tel");
                paramAnonymousPreference = (Preference)localObject;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject;
                  Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "OpenIMCustomDetail.OPENIM_ACTION_DIAL_PHONE click parse error", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(15319, new Object[] { l.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.BcJ.title });
              localObject = new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(paramAnonymousPreference))));
              ((Intent)localObject).setFlags(268435456);
              paramAnonymousPreference = l.this.gte;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousPreference, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousPreference.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousPreference, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$4", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(231877);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 3)
        {
          local5.OZp = new Preference.b()
          {
            public final boolean a(Preference paramAnonymousPreference)
            {
              AppMethodBeat.i(231878);
              paramAnonymousPreference = "";
              try
              {
                localObject = new JSONObject(localb.jGY).optString("mailto");
                paramAnonymousPreference = (Preference)localObject;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject;
                  Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(15319, new Object[] { l.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.BcJ.title });
              localObject = new Intent("android.intent.action.SENDTO");
              ((Intent)localObject).setData(Uri.parse("mailto:".concat(String.valueOf(paramAnonymousPreference))));
              paramAnonymousPreference = l.this.gte;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousPreference, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousPreference.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousPreference, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$5", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(231878);
              return true;
            }
          };
          i = j;
        }
        else if (localb.action == 4)
        {
          local5.OZp = new Preference.b()
          {
            public final boolean a(Preference paramAnonymousPreference)
            {
              AppMethodBeat.i(231879);
              Intent localIntent = new Intent();
              localIntent.setFlags(268435456);
              localIntent.setClassName(MMApplicationContext.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
              paramAnonymousPreference = "";
              try
              {
                localObject = new JSONObject(localb.jGY).optString("url");
                paramAnonymousPreference = (Preference)localObject;
              }
              catch (JSONException localJSONException)
              {
                for (;;)
                {
                  Object localObject;
                  Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", localJSONException, "loadProfile", new Object[0]);
                }
              }
              com.tencent.mm.plugin.report.service.h.CyF.a(15319, new Object[] { l.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.BcJ.title });
              localIntent.putExtra("geta8key_scene", 58);
              localIntent.putExtra("rawUrl", paramAnonymousPreference);
              paramAnonymousPreference = MMApplicationContext.getContext();
              localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousPreference, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousPreference.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousPreference, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal$6", "onPreferenceClick", "(Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(231879);
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
            local5.OZp = new Preference.b()
            {
              public final boolean a(Preference paramAnonymousPreference)
              {
                AppMethodBeat.i(231880);
                try
                {
                  Object localObject = new JSONObject(localb.jGY);
                  paramAnonymousPreference = ((JSONObject)localObject).optString("name");
                  localObject = ((JSONObject)localObject).optString("pagepath");
                  wq localwq = new wq();
                  localwq.ecI.userName = paramAnonymousPreference;
                  localwq.ecI.ecK = Util.nullAs((String)localObject, "");
                  EventCenter.instance.publish(localwq);
                  com.tencent.mm.plugin.report.service.h.CyF.a(15319, new Object[] { l.this.contact.field_openImAppid, Integer.valueOf(localb.action), this.BcJ.title });
                  AppMethodBeat.o(231880);
                  return true;
                }
                catch (JSONException paramAnonymousPreference)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.ContactWidgetNormal", paramAnonymousPreference, "loadProfile", new Object[0]);
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
    this.screen.a(new PreferenceSmallCategory(this.gte), i);
    Object localObject1 = new KeyValuePreference(this.gte);
    ((KeyValuePreference)localObject1).setTitle(2131757876);
    Object localObject3 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_intro_desc", a.a.jGS);
    ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, (CharSequence)localObject3));
    Object localObject4 = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).c(this.contact.field_openImAppid, "openim_intro_url", a.a.jGT);
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      ((Preference)localObject1).OZp = new l.10(this, (String)localObject4, (String)localObject3);
    }
    this.screen.a((Preference)localObject1, i + 1);
    label1182:
    if (!Util.isNullOrNil(this.contact.getProvince()))
    {
      localObject3 = (KeyValuePreference)this.screen.bmg("contact_info_district");
      if (localObject3 != null)
      {
        ((KeyValuePreference)localObject3).setTitle(this.gte.getString(2131757874));
        localObject4 = new StringBuilder().append(aa.It(this.contact.getProvince()));
        if (Util.isNullOrNil(this.contact.getCity()))
        {
          localObject1 = "";
          ((KeyValuePreference)localObject3).setSummary((String)localObject1);
          ((KeyValuePreference)localObject3).BC(false);
          ((KeyValuePreference)localObject3).setEnabled(false);
        }
      }
      else
      {
        if ((this.contact.signature == null) || (this.contact.signature.trim().equals("")) || (com.tencent.mm.contact.c.oR(this.contact.field_type))) {
          break label1927;
        }
        localObject1 = (KeyValuePreference)this.screen.bmg("contact_info_signature");
        if (localObject1 != null)
        {
          ((KeyValuePreference)localObject1).OYB = false;
          ((KeyValuePreference)localObject1).setTitle(this.gte.getString(2131758062));
          ((KeyValuePreference)localObject1).setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.contact.signature));
          ((KeyValuePreference)localObject1).BC(false);
        }
        label1407:
        this.screen.bmg("contact_info_facebook");
        this.screen.bmi("contact_info_facebook");
        if ((this.BfF.kej & 0x1) <= 0) {
          break label1943;
        }
        i = 1;
        label1447:
        if (((i & com.tencent.mm.br.c.aZU("sns")) == 0) || (com.tencent.mm.storage.as.bjn(this.contact.field_username)) || (this.contact.ary())) {
          break label1948;
        }
        localObject1 = (com.tencent.mm.ui.base.preference.g)this.screen.bmg("contact_info_sns");
        if ((localObject1 != null) && (o.DCN != null)) {
          ((com.tencent.mm.ui.base.preference.g)localObject1).bfe(this.contact.field_username);
        }
        label1523:
        this.screen.bmi("contact_info_verifyuser");
        this.screen.bmi("contact_info_footer_normal");
        this.BfP = new com.tencent.mm.plugin.profile.a.b(this.gte, this.contact);
        this.BfP.eeh();
        if (this.kgm == 96) {
          this.screen.bmi("contact_info_footer_normal");
        }
        if (!com.tencent.mm.contact.c.oR(this.contact.field_type)) {
          break label1964;
        }
        eED();
        this.screen.bmi("contact_info_social");
        label1626:
        eEB();
        eEC();
        localObject1 = (NormalUserFooterPreference)this.screen.bmg("contact_info_footer_normal");
        boolean bool1 = this.gte.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean bool2 = this.gte.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.gte.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long l = this.gte.getIntent().getLongExtra("Contact_Uin", -1L);
        if ((this.kgm == 30) || (this.kgm == 45)) {
          this.BfG = false;
        }
        if ((localObject1 == null) || (!((NormalUserFooterPreference)localObject1).a(this.contact, this.wZz, this.Bdx, this.Bdy, this.BfG, this.kgm, this.Bft, bool2, bool1, l, this.BfH))) {
          break label1984;
        }
        ((NormalUserFooterPreference)localObject1).iKx.removeAll();
        ((NormalUserFooterPreference)localObject1).iKx.add(new NormalUserFooterPreference.e() {}, Looper.getMainLooper());
      }
    }
    for (;;)
    {
      label1298:
      this.screen.bmi("clear_lbs_info");
      if (this.BfM)
      {
        this.screen.removeAll();
        if (localObject2 != null) {
          this.screen.c((Preference)localObject2);
        }
        if (localObject1 != null) {
          this.screen.c((Preference)localObject1);
        }
      }
      AppMethodBeat.o(27194);
      return;
      localObject1 = "  " + this.contact.getCity();
      break;
      this.screen.bmi("contact_info_district");
      break label1298;
      label1927:
      this.screen.bmi("contact_info_signature");
      break label1407;
      label1943:
      i = 0;
      break label1447;
      label1948:
      this.screen.bmi("contact_info_sns");
      break label1523;
      label1964:
      eEA();
      this.screen.bmi("contact_info_more");
      break label1626;
      label1984:
      this.screen.bmi("contact_info_footer_normal");
    }
  }
  
  private String getDisplayName(String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(27198);
    if (this.gtd == null)
    {
      AppMethodBeat.o(27198);
      return null;
    }
    bg.aVF();
    com.tencent.mm.storage.as localas = com.tencent.mm.model.c.aSN().Kn(paramString);
    Object localObject1 = localObject2;
    if (localas != null)
    {
      localObject1 = localObject2;
      if ((int)localas.gMZ > 0) {
        localObject1 = localas.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = this.gtd.getDisplayName(paramString);
    }
    paramString = (String)localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      paramString = (String)localObject2;
      if (localas != null) {
        paramString = localas.arI();
      }
    }
    AppMethodBeat.o(27198);
    return paramString;
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb)
  {
    AppMethodBeat.i(27203);
    paramString = (com.tencent.mm.ui.base.preference.g)this.screen.bmg("contact_info_sns");
    if ((paramString != null) && (o.DCN != null)) {
      paramString.bfe(this.contact.field_username);
    }
    this.BfF = o.DCN.b(this.contact.field_username, this.BfF);
    this.screen.notifyDataSetChanged();
    if (paramb.eZe())
    {
      Log.d("MicroMsg.ContactWidgetNormal", "bg Change!");
      if (o.DCR != null) {
        o.DCR.aNX(this.contact.field_username);
      }
    }
    AppMethodBeat.o(27203);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, com.tencent.mm.storage.as paramas, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(27193);
    boolean bool;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
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
      this.contact = paramas;
      this.Bdx = paramBoolean;
      this.kgm = paramInt;
      this.Bdy = this.gte.getIntent().getBooleanExtra("User_Verify", false);
      this.wZz = Util.nullAsNil(this.gte.getIntent().getStringExtra("Verify_ticket"));
      this.BfG = this.gte.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
      this.Bft = this.gte.getIntent().getIntExtra("Kdel_from", -1);
      this.BfH = this.gte.getIntent().getStringExtra("Contact_RemarkName");
      this.dJN = this.gte.getIntent().getIntExtra("Sns_from_Scene", 0);
      this.BfJ = this.gte.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
      this.BfK = this.gte.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
      this.BfI = this.gte.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
      long l = this.gte.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
      paramf = Util.nullAs(this.gte.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
      this.Bey = Util.nullAs(this.gte.getIntent().getStringExtra("verify_gmail"), "");
      this.BfL = Util.nullAs(this.gte.getIntent().getStringExtra("profileName"), Util.subStringEmail(this.Bey));
      this.BfF.kej = this.BfI;
      this.BfF.kel = l;
      this.BfF.kek = paramf;
      this.BfN = this.gte.getIntent().getStringExtra("KLinkedInAddFriendNickName");
      this.BfO = this.gte.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
      if (o.DCN != null) {
        this.BfF = o.DCN.b(paramas.field_username, this.BfF);
      }
      this.gwx = this.gte.getIntent().getStringExtra("room_name");
      bg.aVF();
      this.gtd = com.tencent.mm.model.c.aSX().Kd(this.gwx);
      if (paramas.field_deleteFlag != 1) {
        break label613;
      }
    }
    label601:
    label607:
    label613:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.BfM = paramBoolean;
      eEp();
      bg.aVF();
      com.tencent.mm.model.c.aSN().bjG(paramas.field_username);
      paramBoolean = z.aTY().equals(paramas.field_username);
      Log.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[] { Integer.valueOf(this.BfF.kej) });
      paramInt = i;
      if ((this.BfF.kej & 0x1) > 0) {
        paramInt = 1;
      }
      if ((!paramas.ary()) && (!com.tencent.mm.storage.as.bjn(paramas.field_username)) && (paramInt != 0) && (o.DCR != null)) {
        o.DCR.a(2, paramas.field_username, paramBoolean, this.dJN);
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
  
  final void aKs(String paramString)
  {
    AppMethodBeat.i(27191);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(27191);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.kgm);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", this.contact.field_username);
    paramString.putExtra("Contact_Nick", this.contact.field_nickname);
    paramString.putExtra("Contact_RemarkName", this.contact.field_conRemark);
    com.tencent.mm.plugin.profile.b.jRt.m(paramString, this.gte);
    AppMethodBeat.o(27191);
  }
  
  public final boolean alD(String paramString)
  {
    AppMethodBeat.i(27190);
    Object localObject2;
    Object localObject1;
    long l;
    if (paramString.equals("contact_info_sns"))
    {
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        u.g(this.gte, null);
        AppMethodBeat.o(27190);
        return true;
      }
      localObject2 = this.gte.getIntent();
      ((Intent)localObject2).putExtra("sns_source", this.dJN);
      ((Intent)localObject2).putExtra("sns_signature", this.contact.signature);
      ((Intent)localObject2).putExtra("sns_nickName", this.contact.arI());
      ((Intent)localObject2).putExtra("sns_title", this.contact.arJ());
      localObject1 = localObject2;
      if (o.DCR != null) {
        localObject1 = o.DCR.g((Intent)localObject2, this.contact.field_username);
      }
      if (localObject1 == null) {
        this.gte.finish();
      }
    }
    else
    {
      if (!paramString.equals("contact_info_more")) {
        break label508;
      }
      localObject2 = new Intent();
      ((Intent)localObject2).setClass(this.gte, ContactMoreInfoUI.class);
      ((Intent)localObject2).putExtra("Is_RoomOwner", this.gte.getIntent().getBooleanExtra("Is_RoomOwner", false));
      ((Intent)localObject2).putExtra("Contact_User", this.contact.field_username);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendNickName", this.BfN);
      ((Intent)localObject2).putExtra("KLinkedInAddFriendPubUrl", this.BfO);
      localObject1 = this.gte.getIntent().getStringExtra("room_name");
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = this.gte.getIntent().getStringExtra("Contact_ChatRoomId");
      }
      ((Intent)localObject2).putExtra("Contact_ChatRoomId", paramString);
      ((Intent)localObject2).putExtra("verify_gmail", this.Bey);
      ((Intent)localObject2).putExtra("profileName", this.BfL);
      l = this.gte.getIntent().getLongExtra("Contact_Uin", 0L);
      paramString = this.gte.getIntent().getStringExtra("Contact_QQNick");
      ((Intent)localObject2).putExtra("Contact_Uin", l);
      ((Intent)localObject2).putExtra("Contact_QQNick", paramString);
      paramString = this.gte;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "goToMoreInfoUI", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(27190);
      return true;
      ((Intent)localObject1).putExtra("sns_adapter_type", 1);
      com.tencent.mm.br.c.b(this.gte, "sns", ".ui.SnsTimeLineUserPagerUI", (Intent)localObject1);
      if ((((Intent)localObject1).getFlags() & 0x4000000) == 0) {
        break;
      }
      this.gte.finish();
      break;
      label508:
      if (paramString.equals("contact_info_social"))
      {
        paramString = new Intent();
        paramString.setClass(this.gte, ContactSocialInfoUI.class);
        paramString.putExtra("Contact_User", this.contact.field_username);
        l = this.gte.getIntent().getLongExtra("Contact_Uin", 0L);
        localObject1 = this.gte.getIntent().getStringExtra("Contact_QQNick");
        paramString.putExtra("Contact_Uin", l);
        paramString.putExtra("Contact_QQNick", (String)localObject1);
        paramString.putExtra("profileName", this.BfL);
        paramString.putExtra("verify_gmail", this.Bey);
        localObject1 = this.gte.getIntent().getStringExtra("Contact_Mobile_MD5");
        localObject2 = this.gte.getIntent().getStringExtra("Contact_full_Mobile_MD5");
        paramString.putExtra("Contact_Mobile_MD5", (String)localObject1);
        paramString.putExtra("Contact_full_Mobile_MD5", (String)localObject2);
        localObject1 = this.gte;
        paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramString.axQ(), "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        ((MMActivity)localObject1).startActivity((Intent)paramString.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/profile/ui/ContactWidgetNormal", "viewSocialInfo", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
      else if (paramString.equals("contact_info_invite_source"))
      {
        paramString = ((KeyValuePreference)this.screen.bmg("contact_info_invite_source")).getExtras().getString("inviteer");
        if (!Util.isNullOrNil(paramString))
        {
          localObject1 = getDisplayName(paramString);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", paramString);
          ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
          ((Intent)localObject2).putExtra("Contact_RoomMember", true);
          ((Intent)localObject2).putExtra("room_name", this.gwx);
          bg.aVF();
          ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.aSN().Kn(paramString).field_nickname);
          ((Intent)localObject2).putExtra("Contact_Scene", 14);
          ((Intent)localObject2).putExtra("Is_RoomOwner", true);
          ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.gwx);
          com.tencent.mm.plugin.profile.b.jRt.c((Intent)localObject2, this.gte);
        }
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.b.b paramb) {}
  
  public final boolean cCs()
  {
    AppMethodBeat.i(27201);
    if (o.DCR != null) {
      o.DCR.a(this, 3);
    }
    bg.azz().b(30, this);
    bg.azz().b(453, this);
    Object localObject = (NormalProfileHeaderPreference)this.screen.bmg("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (NormalUserFooterPreference)this.screen.bmg("contact_info_footer_normal");
    if (localObject != null) {
      ((NormalUserFooterPreference)localObject).cCs();
    }
    localObject = (FriendPreference)this.screen.bmg("contact_info_friend_qq");
    if (localObject != null) {
      ((FriendPreference)localObject).cCs();
    }
    localObject = (FriendPreference)this.screen.bmg("contact_info_friend_mobile");
    if (localObject != null) {
      ((FriendPreference)localObject).cCs();
    }
    localObject = (FriendPreference)this.screen.bmg("contact_info_facebook");
    if (localObject != null) {
      ((FriendPreference)localObject).cCs();
    }
    if (this.BfP != null) {
      this.BfP.destroy();
    }
    this.screen.bmg("contact_info_sns");
    AppMethodBeat.o(27201);
    return true;
  }
  
  final void jv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27197);
    Log.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)this.screen.bmg("contact_info_invite_source");
    TextPreference localTextPreference = (TextPreference)this.screen.bmg("contact_info_hint");
    this.screen.jdMethod_do("contact_info_invite_source", false);
    SpannableString localSpannableString = new SpannableString(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getResources().getString(2131757923, new Object[] { paramString2 })));
    localSpannableString.setSpan(new ForegroundColorSpan(this.gte.getResources().getColor(2131100063)), 0, paramString2.length(), 33);
    localKeyValuePreference.setSummary(localSpannableString);
    localKeyValuePreference.getExtras().putString("inviteer", paramString1);
    this.gte.getIntent().putExtra("inviteer", paramString1);
    if ((this.gtd != null) && (!this.gtd.bax().contains(this.contact.field_username)))
    {
      this.screen.jdMethod_do("contact_info_footer_normal", true);
      localTextPreference.ar(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getResources().getString(2131757982, new Object[] { getDisplayName(this.contact.field_username) })));
      AppMethodBeat.o(27197);
      return;
    }
    this.screen.jdMethod_do("contact_info_footer_normal", false);
    AppMethodBeat.o(27197);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(27202);
    if ((paramq.getType() != 30) && (paramq.getType() != 458))
    {
      Log.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + paramq.getType());
      AppMethodBeat.o(27202);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq.getType() == 30)
      {
        paramString = (com.tencent.mm.pluginsdk.model.p)paramq;
        if ((paramString.dKy != 1) && (paramString.dKy != 3))
        {
          AppMethodBeat.o(27202);
          return;
        }
        if ((paramString.JVj != null) && (!paramString.JVj.contains(this.contact.field_username)))
        {
          AppMethodBeat.o(27202);
          return;
        }
        paramString = (NormalUserHeaderPreference)this.screen.bmg("contact_info_header_normal");
        NormalUserFooterPreference localNormalUserFooterPreference = (NormalUserFooterPreference)this.screen.bmg("contact_info_footer_normal");
        if ((paramString != null) && (localNormalUserFooterPreference != null) && (localNormalUserFooterPreference.Bhz))
        {
          Log.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
          this.BfJ = false;
          this.BfK = false;
          paramString.dc(this.contact.field_username, false);
          paramString.dd(this.contact.field_username, false);
          paramString.Mr(this.contact.field_username);
          this.gte.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.BfJ);
          this.gte.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.BfK);
        }
      }
      if (paramq.getType() == 453)
      {
        eEp();
        AppMethodBeat.o(27202);
      }
    }
    else if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString)))
    {
      Toast.makeText(this.gte, paramString, 1).show();
    }
    AppMethodBeat.o(27202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.l
 * JD-Core Version:    0.7.0.1
 */