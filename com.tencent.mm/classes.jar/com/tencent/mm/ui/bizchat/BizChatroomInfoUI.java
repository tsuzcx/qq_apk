package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.b;
import com.tencent.mm.aj.a.c;
import com.tencent.mm.aj.a.d.a;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.o;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.i;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.protocal.protobuf.kr;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BizChatroomInfoUI
  extends MMPreference
  implements com.tencent.mm.ai.f, com.tencent.mm.aj.n
{
  private static boolean efv = false;
  private ProgressDialog eeN;
  private ContactListExpandPreference eeU;
  private CheckBoxPreference eeV;
  private CheckBoxPreference eeW;
  private CheckBoxPreference eeX;
  private boolean efd;
  private int eff;
  private boolean efg;
  private com.tencent.mm.pluginsdk.ui.d efo;
  boolean efp;
  private SignaturePreference ehA;
  private int fromScene;
  private boolean isDeleteCancel;
  private String jUE;
  private long jUy;
  private com.tencent.mm.aj.a.j pzG;
  private boolean sMD;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private c zsO;
  private d.a ztt;
  private String zuq;
  private boolean zur;
  private boolean zus;
  private int zut;
  private com.tencent.mm.aj.a.j zuu;
  
  public BizChatroomInfoUI()
  {
    AppMethodBeat.i(30211);
    this.eeN = null;
    this.sp = null;
    this.efd = false;
    this.zur = false;
    this.zsO = null;
    this.pzG = null;
    this.zuu = null;
    this.efo = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(30196);
        o.ahG().bX(paramAnonymousInt);
        AppMethodBeat.o(30196);
      }
    });
    this.efp = false;
    this.isDeleteCancel = false;
    this.ztt = new BizChatroomInfoUI.3(this);
    AppMethodBeat.o(30211);
  }
  
  private void I(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(30223);
    this.zut = this.zsO.field_bitFlag;
    this.zuq = this.zsO.field_chatName;
    Object localObject;
    if (this.zur)
    {
      if (paramBoolean) {
        localObject = this.zsO;
      }
      for (((c)localObject).field_bitFlag |= paramInt;; ((c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        ab.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.zsO.field_bitFlag) });
        z.afk().b(this.zsO);
        localObject = new kp();
        ((kp)localObject).wyb = this.zsO.field_bizChatServId;
        ((kp)localObject).wyd = this.zsO.field_bitFlag;
        z.afq();
        com.tencent.mm.aj.a.h.a(this.zsO.field_brandUserName, (kp)localObject, this);
        AppMethodBeat.o(30223);
        return;
        localObject = this.zsO;
      }
    }
    if (paramBoolean) {
      localObject = this.pzG;
    }
    for (((com.tencent.mm.aj.a.j)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.aj.a.j)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      z.afm().b(this.pzG);
      this.zsO.field_bitFlag = this.pzG.field_bitFlag;
      z.afk().b(this.zsO);
      break;
      localObject = this.pzG;
    }
  }
  
  private void JH()
  {
    AppMethodBeat.i(30225);
    Object localObject;
    if (this.eeU != null)
    {
      if (!this.zur) {
        break label82;
      }
      localObject = e.gM(this.jUy);
      if (localObject == null) {
        break label107;
      }
      this.eff = ((List)localObject).size();
      label42:
      if (this.eff > 1) {
        break label115;
      }
      this.eeU.pf(true).pg(false);
    }
    for (;;)
    {
      this.eeU.v(this.jUE, (List)localObject);
      AppMethodBeat.o(30225);
      return;
      label82:
      localObject = new LinkedList();
      ((List)localObject).add(this.zsO.field_bizChatServId);
      break;
      label107:
      this.eff = 0;
      break label42;
      label115:
      this.eeU.pf(true).pg(this.efd);
    }
  }
  
  private void JJ()
  {
    AppMethodBeat.i(30228);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.zur)
    {
      this.efg = this.zsO.kY(1);
      this.zut = this.zsO.field_bitFlag;
      if (!this.efg) {
        break label159;
      }
      setTitleMuteIconVisibility(0);
      if (this.eeV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(30228);
      return;
      this.efg = this.pzG.kY(1);
      this.zut = this.pzG.field_bitFlag;
      break;
      label159:
      setTitleMuteIconVisibility(8);
      if (this.eeV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void JL()
  {
    AppMethodBeat.i(30229);
    if (this.ehA != null)
    {
      if (JM())
      {
        Object localObject2 = this.zsO.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        ab.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.ehA;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          localObject2 = getString(2131303427);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject2));
        AppMethodBeat.o(30229);
        return;
      }
      this.ehA.setSummary(getString(2131302711));
    }
    AppMethodBeat.o(30229);
  }
  
  private boolean JM()
  {
    AppMethodBeat.i(30231);
    if (this.zur) {}
    for (String str = this.zsO.field_chatName; bo.isNullOrNil(str); str = this.pzG.field_userName)
    {
      AppMethodBeat.o(30231);
      return false;
    }
    AppMethodBeat.o(30231);
    return true;
  }
  
  private void a(ks paramks1, ks paramks2)
  {
    AppMethodBeat.i(30218);
    ab.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (paramks1 == null) {}
    for (String str = getString(2131302684);; str = getString(2131296440))
    {
      z.afq();
      paramks1 = com.tencent.mm.aj.a.h.a(this.zsO.field_brandUserName, this.zsO.field_bizChatServId, paramks1, paramks2, this);
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b(this, str, true, new BizChatroomInfoUI.6(this, paramks1));
      AppMethodBeat.o(30218);
      return;
    }
  }
  
  private boolean atG(String paramString)
  {
    AppMethodBeat.i(30217);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        ks localks = new ks();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = z.afm().df(str);
          if (paramString != null) {
            break label262;
          }
          paramString = new com.tencent.mm.aj.a.j();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.jUE;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.zuu == null) {
            break label265;
          }
          localObject = this.zuu.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!z.afm().b(paramString)) {
            z.afm().a(paramString);
          }
          localObject = new kr();
          ((kr)localObject).wyi = paramString.field_userId;
          localks.wyj.add(localObject);
          i += 1;
          continue;
        }
        a(localks, null);
        AppMethodBeat.o(30217);
        return true;
      }
      catch (JSONException paramString)
      {
        ab.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", new Object[] { paramString.getMessage() });
        ab.printErrStackTrace("MicroMsg.BizChatroomInfoUI", paramString, "", new Object[0]);
      }
      AppMethodBeat.o(30217);
      return false;
      label262:
      continue;
      label265:
      Object localObject = null;
    }
  }
  
  private void cci()
  {
    AppMethodBeat.i(30227);
    ab.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.zur) {
      this.zus = this.zsO.kY(16);
    }
    for (this.zut = this.zsO.field_bitFlag;; this.zut = this.pzG.field_bitFlag)
    {
      if (this.eeX != null) {
        this.sp.edit().putBoolean("room_placed_to_the_top", this.zus).commit();
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(30227);
      return;
      this.zus = this.pzG.kY(16);
    }
  }
  
  private void dFf()
  {
    AppMethodBeat.i(30226);
    ab.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.zur)
    {
      this.sMD = this.zsO.kY(8);
      this.zut = this.zsO.field_bitFlag;
      if (!this.sMD) {
        break label164;
      }
      if (this.eeW != null) {
        this.sp.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(30226);
      return;
      this.sMD = this.pzG.kY(8);
      this.zut = this.pzG.field_bitFlag;
      break;
      label164:
      if (this.eeW != null) {
        this.sp.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void dFg()
  {
    AppMethodBeat.i(30235);
    ab.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.zsO.field_chatName = this.zuq;
    this.zsO.field_bitFlag = this.zut;
    this.efg = this.zsO.kY(1);
    this.sMD = this.zsO.kY(8);
    this.zus = this.zsO.kY(16);
    z.afk().b(this.zsO);
    if (this.zus) {
      z.afl().gJ(this.zsO.field_bizChatLocalId);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", z.afl().gI(this.zsO.field_bizChatLocalId)).commit();
      JL();
      JJ();
      cci();
      dFf();
      Toast.makeText(this, getString(2131302675), 0).show();
      AppMethodBeat.o(30235);
      return;
      if (!this.zus) {
        z.afl().gK(this.zsO.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    AppMethodBeat.i(30234);
    if (this.eeU != null)
    {
      JL();
      updateTitle();
      JJ();
      JH();
      dFf();
      cci();
      this.eeU.notifyChanged();
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(30234);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(30230);
    if (this.zur)
    {
      this.eff = e.gL(this.jUy);
      if (this.eff != 0)
      {
        setMMTitle(getString(2131300029, new Object[] { getString(2131302817), Integer.valueOf(this.eff) }));
        AppMethodBeat.o(30230);
        return;
      }
    }
    setMMTitle(getString(2131302817));
    AppMethodBeat.o(30230);
  }
  
  public final com.tencent.mm.aj.a.j Pa(int paramInt)
  {
    AppMethodBeat.i(30224);
    if ((this.eeU.getItem(paramInt) instanceof com.tencent.mm.aj.a.j))
    {
      com.tencent.mm.aj.a.j localj = (com.tencent.mm.aj.a.j)this.eeU.getItem(paramInt);
      AppMethodBeat.o(30224);
      return localj;
    }
    AppMethodBeat.o(30224);
    return null;
  }
  
  public final void a(int paramInt, m paramm)
  {
    AppMethodBeat.i(30232);
    if (this.eeN != null)
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if (paramm.getType() == 1355)
    {
      Object localObject = ((com.tencent.mm.aj.a.n)paramm).afD();
      paramm = ((com.tencent.mm.aj.a.n)paramm).afE();
      localObject = z.afk().sl(((vs)localObject).wOs.wXl.wyb);
      if (localObject == null)
      {
        Toast.makeText(ah.getContext(), getString(2131302674), 0).show();
        AppMethodBeat.o(30232);
        return;
      }
      if (this.fromScene == 2)
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Contact_User", paramm.wyh);
        localIntent.putExtra("biz_chat_chat_id", ((c)localObject).field_bizChatLocalId);
        com.tencent.mm.bq.d.f(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        AppMethodBeat.o(30232);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramm.wyh);
      localIntent.putExtra("key_biz_chat_id", ((c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      localIntent.setClass(this, ChattingUI.class);
      startActivity(localIntent);
      AppMethodBeat.o(30232);
      return;
    }
    if (paramm.getType() == 1356)
    {
      if (paramInt != 0)
      {
        dFg();
        AppMethodBeat.o(30232);
      }
    }
    else if ((paramm.getType() == 1353) && (paramInt >= 0) && (this.pzG != null))
    {
      this.pzG = z.afm().df(this.pzG.field_userId);
      onDataChanged();
    }
    AppMethodBeat.o(30232);
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(30236);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(30236);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131165198;
  }
  
  public void initView()
  {
    AppMethodBeat.i(30220);
    this.screen = getPreferenceScreen();
    Object localObject = this.zsO.field_ownerUserId;
    this.eff = this.zsO.afx().size();
    if (bo.isNullOrNil((String)localObject))
    {
      this.efd = false;
      ab.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.eeU = ((ContactListExpandPreference)this.screen.atx("roominfo_contact_anchor"));
      this.eeU.a(this.screen, this.eeU.mKey);
      this.ehA = ((SignaturePreference)this.screen.atx("room_name"));
      this.eeV = ((CheckBoxPreference)this.screen.atx("room_notify_new_msg"));
      this.eeX = ((CheckBoxPreference)this.screen.atx("room_placed_to_the_top"));
      this.eeW = ((CheckBoxPreference)this.screen.atx("room_save_to_contact"));
      localObject = this.eeU;
      boolean bool = this.zur;
      if (((ContactListExpandPreference)localObject).vUk != null) {
        ((ContactListExpandPreference)localObject).vUk.vTA.vTN = bool;
      }
      localObject = this.eeU;
      bool = this.efd;
      if (((ContactListExpandPreference)localObject).vUk != null) {
        ((ContactListExpandPreference)localObject).vUk.vTA.vTM = bool;
      }
      if (!this.efd) {
        break label417;
      }
      this.eeU.pf(true).pg(true);
    }
    for (;;)
    {
      this.eeU.amp(this.zsO.field_ownerUserId);
      this.eeU.dnH();
      this.eeU.dnB();
      if (!this.zur)
      {
        this.screen.cl("room_save_to_contact", true);
        this.screen.cl("room_name", true);
        this.screen.cl("room_del_quit", true);
      }
      dFf();
      cci();
      JJ();
      if (this.eeU != null)
      {
        getListView().setOnScrollListener(this.efo);
        this.eeU.a(this.efo);
        this.eeU.a(new BizChatroomInfoUI.7(this));
      }
      setBackBtn(new BizChatroomInfoUI.8(this));
      AppMethodBeat.o(30220);
      return;
      this.efd = ((String)localObject).equals(z.afm().dg(this.jUE));
      break;
      label417:
      this.eeU.pf(true).pg(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(30216);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(30216);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(30216);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    String str;
    boolean bool;
    if (paramIntent != null)
    {
      ab.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
      str = paramIntent.getString("enterprise_members");
      ab.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", new Object[] { str });
      if (this.zur) {
        bool = atG(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(2131302674), 0).show();
        AppMethodBeat.o(30216);
        return;
        aeh localaeh = new aeh();
        c localc = new c();
        if (this.zuu != null) {}
        for (paramIntent = this.zuu.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.jUE;
          if (!e.a(localc, str, this.pzG.field_userId, localaeh)) {
            break label265;
          }
          z.afq();
          paramIntent = com.tencent.mm.aj.a.h.a(this.jUE, localaeh, this);
          getString(2131297087);
          this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131296440), true, new BizChatroomInfoUI.5(this, paramIntent));
          bool = true;
          break;
        }
        label265:
        bool = false;
      }
      else
      {
        AppMethodBeat.o(30216);
        return;
        bool = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(30212);
    super.onCreate(paramBundle);
    z.afk().a(this.ztt, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.jUE = getIntent().getStringExtra("Chat_User");
    this.jUy = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.zsO = z.afk().aG(this.jUy);
    this.zuq = this.zsO.field_chatName;
    this.zur = e.sn(this.zsO.field_bizChatServId);
    if (!this.zur) {
      this.pzG = z.afm().df(this.zsO.field_bizChatServId);
    }
    this.zuu = z.afm().sy(this.jUE);
    initView();
    if ((this.zsO == null) || (this.zsO.field_bizChatServId == null) || (this.jUE == null))
    {
      AppMethodBeat.o(30212);
      return;
    }
    if (this.zsO.isGroup())
    {
      z.afq();
      com.tencent.mm.aj.a.h.aL(this.zsO.field_bizChatServId, this.jUE);
      AppMethodBeat.o(30212);
      return;
    }
    z.afq();
    com.tencent.mm.aj.a.h.a(this.zsO.field_bizChatServId, this.jUE, this);
    AppMethodBeat.o(30212);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30215);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.ui.h.a.dismiss();
    z.afk().a(this.ztt);
    super.onDestroy();
    AppMethodBeat.o(30215);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(30214);
    super.onPause();
    AppMethodBeat.o(30214);
  }
  
  public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(30222);
    paramf = paramPreference.mKey;
    if (paramf.equals("room_name"))
    {
      paramf = "";
      if (JM()) {
        paramf = this.zsO.field_chatName;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131302743), paramf, "", 32, new BizChatroomInfoUI.9(this, paramf));
    }
    label189:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(30222);
        return false;
        if (paramf.equals("room_notify_new_msg"))
        {
          if (!this.efg) {}
          for (bool1 = true;; bool1 = false)
          {
            this.efg = bool1;
            I(this.efg, 1);
            JJ();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.zus) {}
          for (;;)
          {
            this.zus = bool1;
            I(this.zus, 16);
            if (!this.zus) {
              break label189;
            }
            z.afl().gJ(this.zsO.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          z.afl().gK(this.zsO.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          ab.d("MicroMsg.BizChatroomInfoUI", " quit " + this.jUy);
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131298940), "", new BizChatroomInfoUI.10(this), null);
        }
      }
    } while (!paramf.equals("room_save_to_contact"));
    if (!this.sMD) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.sMD = bool1;
      I(this.sMD, 8);
      dFf();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(30213);
    JL();
    updateTitle();
    JJ();
    cci();
    dFf();
    JH();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.efp)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bo.isNullOrNil(str))
      {
        int i = this.screen.atz(str);
        setSelection(i - 3);
        new ak().postDelayed(new BizChatroomInfoUI.4(this, i), 10L);
      }
      this.efp = true;
    }
    AppMethodBeat.o(30213);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(30233);
    if (paramm == null)
    {
      ab.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(30233);
      return;
    }
    ab.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramm.getType()) });
    this.eff = e.gL(this.jUy);
    ab.d("MicroMsg.BizChatroomInfoUI", "now is " + this.eff);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    paramString = com.tencent.mm.h.a.kO(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(30233);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      dFg();
      AppMethodBeat.o(30233);
      return;
    }
    paramm.getType();
    AppMethodBeat.o(30233);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */