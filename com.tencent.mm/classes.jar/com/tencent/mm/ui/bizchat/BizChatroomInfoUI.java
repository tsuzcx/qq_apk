package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.a.y;
import com.tencent.mm.al.af;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.mk;
import com.tencent.mm.protocal.protobuf.mm;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.protocal.protobuf.zr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.chatting.ChattingUI;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BizChatroomInfoUI
  extends MMPreference
  implements g, com.tencent.mm.al.o
{
  private static boolean fuc = false;
  private int Ede;
  private com.tencent.mm.al.a.c HGu;
  private com.tencent.mm.al.c HHd;
  private d.a HHf;
  private String HIl;
  private boolean HIm;
  private boolean HIn;
  private com.tencent.mm.al.a.k HIo;
  private int fromScene;
  private ContactListExpandPreference ftA;
  private CheckBoxPreference ftB;
  private CheckBoxPreference ftC;
  private CheckBoxPreference ftD;
  private boolean ftK;
  private int ftM;
  private boolean ftN;
  private com.tencent.mm.pluginsdk.ui.d ftW;
  boolean ftX;
  private ProgressDialog fts;
  private SignaturePreference fxV;
  private boolean isDeleteCancel;
  private String nxJ;
  private long nxq;
  private f screen;
  private SharedPreferences sp;
  private com.tencent.mm.al.a.k vKi;
  private boolean zIx;
  
  public BizChatroomInfoUI()
  {
    AppMethodBeat.i(34063);
    this.fts = null;
    this.sp = null;
    this.ftK = false;
    this.HIm = false;
    this.HGu = null;
    this.vKi = null;
    this.HIo = null;
    this.ftW = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34048);
        com.tencent.mm.av.o.aFB().cp(paramAnonymousInt);
        AppMethodBeat.o(34048);
      }
    });
    this.ftX = false;
    this.isDeleteCancel = false;
    this.HHf = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(34051);
        if ((paramAnonymousb != null) && (paramAnonymousb.hzp != null) && (paramAnonymousb.hze == BizChatroomInfoUI.g(BizChatroomInfoUI.this)) && (paramAnonymousb.hzo != d.a.a.hzl))
        {
          ac.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
          paramAnonymousb = af.aCY().bd(BizChatroomInfoUI.g(BizChatroomInfoUI.this));
          BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousb);
          BizChatroomInfoUI.h(BizChatroomInfoUI.this);
        }
        AppMethodBeat.o(34051);
      }
    };
    AppMethodBeat.o(34063);
  }
  
  private void W(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(34073);
    this.Ede = this.HGu.field_bitFlag;
    this.HIl = this.HGu.field_chatName;
    Object localObject;
    if (this.HIm)
    {
      if (paramBoolean) {
        localObject = this.HGu;
      }
      for (((com.tencent.mm.al.a.c)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.al.a.c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        ac.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.HGu.field_bitFlag) });
        af.aCY().b(this.HGu);
        localObject = new mk();
        ((mk)localObject).Ebl = this.HGu.field_bizChatServId;
        ((mk)localObject).Ebn = this.HGu.field_bitFlag;
        af.aDe();
        com.tencent.mm.al.a.h.a(this.HGu.field_brandUserName, (mk)localObject, this);
        AppMethodBeat.o(34073);
        return;
        localObject = this.HGu;
      }
    }
    if (paramBoolean) {
      localObject = this.vKi;
    }
    for (((com.tencent.mm.al.a.k)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.al.a.k)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      af.aDa().b(this.vKi);
      this.HGu.field_bitFlag = this.vKi.field_bitFlag;
      af.aCY().b(this.HGu);
      break;
      localObject = this.vKi;
    }
  }
  
  private void Wi()
  {
    AppMethodBeat.i(34075);
    Object localObject;
    if (this.ftA != null)
    {
      if (!this.HIm) {
        break label103;
      }
      localObject = com.tencent.mm.al.a.e.qa(this.nxq);
      if (localObject == null) {
        break label128;
      }
      this.ftM = ((List)localObject).size();
      label41:
      if (this.ftM > 1) {
        break label136;
      }
      this.ftA.vc(true).vd(false);
    }
    for (;;)
    {
      if (this.HHd.field_hide_mod_chat_member) {
        this.ftA.vc(false).vd(false);
      }
      this.ftA.y(this.nxJ, (List)localObject);
      AppMethodBeat.o(34075);
      return;
      label103:
      localObject = new LinkedList();
      ((List)localObject).add(this.HGu.field_bizChatServId);
      break;
      label128:
      this.ftM = 0;
      break label41;
      label136:
      this.ftA.vc(true).vd(this.ftK);
    }
  }
  
  private void Wj()
  {
    AppMethodBeat.i(34078);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.HIm)
    {
      this.ftN = this.HGu.hc(1);
      this.Ede = this.HGu.field_bitFlag;
      if (!this.ftN) {
        break label158;
      }
      setTitleMuteIconVisibility(0);
      if (this.ftB != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34078);
      return;
      this.ftN = this.vKi.hc(1);
      this.Ede = this.vKi.field_bitFlag;
      break;
      label158:
      setTitleMuteIconVisibility(8);
      if (this.ftB != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void Wl()
  {
    AppMethodBeat.i(34079);
    if (this.fxV != null)
    {
      if (Wm())
      {
        Object localObject2 = this.HGu.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        ac.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.fxV;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          localObject2 = getString(2131763409);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.k.c(this, (CharSequence)localObject2));
        AppMethodBeat.o(34079);
        return;
      }
      this.fxV.setSummary(getString(2131762622));
    }
    AppMethodBeat.o(34079);
  }
  
  private boolean Wm()
  {
    AppMethodBeat.i(34081);
    if (this.HIm) {}
    for (String str = this.HGu.field_chatName; bs.isNullOrNil(str); str = this.vKi.field_userName)
    {
      AppMethodBeat.o(34081);
      return false;
    }
    AppMethodBeat.o(34081);
    return true;
  }
  
  private void a(final mn parammn1, mn parammn2)
  {
    AppMethodBeat.i(34070);
    ac.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (parammn1 == null) {}
    for (String str = getString(2131762595);; str = getString(2131755168))
    {
      af.aDe();
      parammn1 = com.tencent.mm.al.a.h.a(this.HGu.field_brandUserName, this.HGu.field_bizChatServId, parammn1, parammn2, this);
      getString(2131755906);
      this.fts = com.tencent.mm.ui.base.h.b(this, str, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34054);
          az.agi().a(parammn1);
          AppMethodBeat.o(34054);
        }
      });
      AppMethodBeat.o(34070);
      return;
    }
  }
  
  private boolean aPX(String paramString)
  {
    AppMethodBeat.i(34069);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        mn localmn = new mn();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = af.aDa().dP(str);
          if (paramString != null) {
            break label262;
          }
          paramString = new com.tencent.mm.al.a.k();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.nxJ;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.HIo == null) {
            break label265;
          }
          localObject = this.HIo.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!af.aDa().b(paramString)) {
            af.aDa().a(paramString);
          }
          localObject = new mm();
          ((mm)localObject).Ebt = paramString.field_userId;
          localmn.Ebu.add(localObject);
          i += 1;
          continue;
        }
        a(localmn, null);
        AppMethodBeat.o(34069);
        return true;
      }
      catch (JSONException paramString)
      {
        ac.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", new Object[] { paramString.getMessage() });
        ac.printErrStackTrace("MicroMsg.BizChatroomInfoUI", paramString, "", new Object[0]);
      }
      AppMethodBeat.o(34069);
      return false;
      label262:
      continue;
      label265:
      Object localObject = null;
    }
  }
  
  private void dqh()
  {
    AppMethodBeat.i(34077);
    ac.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.HIm) {
      this.HIn = this.HGu.hc(16);
    }
    for (this.Ede = this.HGu.field_bitFlag;; this.Ede = this.vKi.field_bitFlag)
    {
      if (this.ftD != null) {
        this.sp.edit().putBoolean("room_placed_to_the_top", this.HIn).commit();
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34077);
      return;
      this.HIn = this.vKi.hc(16);
    }
  }
  
  private void fjL()
  {
    AppMethodBeat.i(34076);
    ac.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.HIm)
    {
      this.zIx = this.HGu.hc(8);
      this.Ede = this.HGu.field_bitFlag;
      if (!this.zIx) {
        break label165;
      }
      if (this.ftC != null) {
        this.sp.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34076);
      return;
      this.zIx = this.vKi.hc(8);
      this.Ede = this.vKi.field_bitFlag;
      break;
      label165:
      if (this.ftC != null) {
        this.sp.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void fjM()
  {
    AppMethodBeat.i(34085);
    ac.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.HGu.field_chatName = this.HIl;
    this.HGu.field_bitFlag = this.Ede;
    this.ftN = this.HGu.hc(1);
    this.zIx = this.HGu.hc(8);
    this.HIn = this.HGu.hc(16);
    af.aCY().b(this.HGu);
    if (this.HIn) {
      af.aCZ().pX(this.HGu.field_bizChatLocalId);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", af.aCZ().pW(this.HGu.field_bizChatLocalId)).commit();
      Wl();
      Wj();
      dqh();
      fjL();
      Toast.makeText(this, getString(2131762584), 0).show();
      AppMethodBeat.o(34085);
      return;
      if (!this.HIn) {
        af.aCZ().pY(this.HGu.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    AppMethodBeat.i(34084);
    if (this.ftA != null)
    {
      Wl();
      updateTitle();
      Wj();
      Wi();
      fjL();
      dqh();
      this.ftA.notifyChanged();
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(34084);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(34080);
    if (this.HIm)
    {
      this.ftM = com.tencent.mm.al.a.e.pZ(this.nxq);
      if (this.ftM != 0)
      {
        setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.ftM) }));
        AppMethodBeat.o(34080);
        return;
      }
    }
    setMMTitle(getString(2131762729));
    AppMethodBeat.o(34080);
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(34082);
    if (this.fts != null)
    {
      this.fts.dismiss();
      this.fts = null;
    }
    if (paramn.getType() == 1355)
    {
      Object localObject = ((com.tencent.mm.al.a.o)paramn).aDr();
      paramn = ((com.tencent.mm.al.a.o)paramn).aDs();
      localObject = af.aCY().Bp(((zr)localObject).EtV.EIW.Ebl);
      if (localObject == null)
      {
        Toast.makeText(ai.getContext(), getString(2131762583), 0).show();
        AppMethodBeat.o(34082);
        return;
      }
      if (this.fromScene == 2)
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Contact_User", paramn.Ebs);
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
        com.tencent.mm.br.d.e(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        AppMethodBeat.o(34082);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramn.Ebs);
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      localIntent.setClass(this, ChattingUI.class);
      paramn = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramn.aeD(), "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramn.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34082);
      return;
    }
    if (paramn.getType() == 1356)
    {
      if (paramInt != 0)
      {
        fjM();
        AppMethodBeat.o(34082);
      }
    }
    else if ((paramn.getType() == 1353) && (paramInt >= 0) && (this.vKi != null))
    {
      this.vKi = af.aDa().dP(this.vKi.field_userId);
      onDataChanged();
    }
    AppMethodBeat.o(34082);
  }
  
  public final com.tencent.mm.al.a.k aar(int paramInt)
  {
    AppMethodBeat.i(34074);
    if ((this.ftA.getItem(paramInt) instanceof com.tencent.mm.al.a.k))
    {
      com.tencent.mm.al.a.k localk = (com.tencent.mm.al.a.k)this.ftA.getItem(paramInt);
      AppMethodBeat.o(34074);
      return localk;
    }
    AppMethodBeat.o(34074);
    return null;
  }
  
  public com.tencent.mm.ui.base.preference.h createAdapter(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(34086);
    paramSharedPreferences = new com.tencent.mm.ui.base.preference.a(this, getListView(), paramSharedPreferences);
    AppMethodBeat.o(34086);
    return paramSharedPreferences;
  }
  
  public int getResourceId()
  {
    return 2131951632;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34071);
    this.screen = getPreferenceScreen();
    Object localObject = this.HGu.field_ownerUserId;
    this.ftM = this.HGu.aDl().size();
    if (bs.isNullOrNil((String)localObject))
    {
      this.ftK = false;
      localObject = af.aCW().AE(this.nxJ);
      this.HHd = af.aDf().Az(((com.tencent.mm.api.c)localObject).IV());
      ac.i("MicroMsg.BizChatroomInfoUI", "getMainBrandAttr father %s", new Object[] { ((com.tencent.mm.api.c)localObject).IV() });
      ac.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.ftA = ((ContactListExpandPreference)this.screen.aPN("roominfo_contact_anchor"));
      this.ftA.a(this.screen, this.ftA.mKey);
      this.fxV = ((SignaturePreference)this.screen.aPN("room_name"));
      this.ftB = ((CheckBoxPreference)this.screen.aPN("room_notify_new_msg"));
      this.ftD = ((CheckBoxPreference)this.screen.aPN("room_placed_to_the_top"));
      this.ftC = ((CheckBoxPreference)this.screen.aPN("room_save_to_contact"));
      localObject = this.ftA;
      boolean bool = this.HIm;
      if (((ContactListExpandPreference)localObject).DrI != null) {
        ((ContactListExpandPreference)localObject).DrI.DqY.Drl = bool;
      }
      localObject = this.ftA;
      bool = this.ftK;
      if (((ContactListExpandPreference)localObject).DrI != null) {
        ((ContactListExpandPreference)localObject).DrI.DqY.Drk = bool;
      }
      if (!this.ftK) {
        break label487;
      }
      this.ftA.vc(true).vd(true);
    }
    for (;;)
    {
      if (this.HHd.field_hide_mod_chat_member) {
        this.ftA.vc(false).vd(false);
      }
      this.ftA.aHs(this.HGu.field_ownerUserId);
      this.ftA.eNK();
      this.ftA.eNE();
      if (!this.HIm)
      {
        this.screen.cK("room_save_to_contact", true);
        this.screen.cK("room_name", true);
        this.screen.cK("room_del_quit", true);
      }
      fjL();
      dqh();
      Wj();
      if (this.ftA != null)
      {
        getListView().setOnScrollListener(this.ftW);
        this.ftA.a(this.ftW);
        this.ftA.a(new ContactListExpandPreference.a()
        {
          public final void a(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(196390);
            BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousInt);
            AppMethodBeat.o(196390);
          }
          
          public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            boolean bool = true;
            AppMethodBeat.i(196391);
            paramAnonymousViewGroup = BizChatroomInfoUI.this.aar(paramAnonymousInt);
            if ((paramAnonymousViewGroup == null) || (bs.isNullOrNil(paramAnonymousViewGroup.field_profileUrl)))
            {
              if (paramAnonymousViewGroup == null) {}
              for (;;)
              {
                ac.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
                AppMethodBeat.o(196391);
                return;
                bool = false;
              }
            }
            ac.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { paramAnonymousViewGroup.field_profileUrl });
            af.aDe();
            com.tencent.mm.al.a.h.a(paramAnonymousViewGroup.field_userId, paramAnonymousViewGroup.field_brandUserName, BizChatroomInfoUI.this);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramAnonymousViewGroup.field_profileUrl);
            paramAnonymousView.putExtra("useJs", true);
            com.tencent.mm.br.d.b(BizChatroomInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            AppMethodBeat.o(196391);
          }
          
          public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(196393);
            BizChatroomInfoUI.c(BizChatroomInfoUI.this);
            AppMethodBeat.o(196393);
          }
          
          public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
          
          public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
          {
            AppMethodBeat.i(196392);
            if (BizChatroomInfoUI.b(BizChatroomInfoUI.this) != null) {
              BizChatroomInfoUI.b(BizChatroomInfoUI.this).eNI();
            }
            AppMethodBeat.o(196392);
          }
        });
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34059);
          BizChatroomInfoUI.this.finish();
          AppMethodBeat.o(34059);
          return true;
        }
      });
      AppMethodBeat.o(34071);
      return;
      this.ftK = ((String)localObject).equals(af.aDa().dQ(this.nxJ));
      break;
      label487:
      this.ftA.vc(true).vd(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(34068);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(34068);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(34068);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    String str;
    boolean bool;
    if (paramIntent != null)
    {
      ac.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
      str = paramIntent.getString("enterprise_members");
      ac.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", new Object[] { str });
      if (this.HIm) {
        bool = aPX(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(2131762583), 0).show();
        AppMethodBeat.o(34068);
        return;
        apz localapz = new apz();
        com.tencent.mm.al.a.c localc = new com.tencent.mm.al.a.c();
        if (this.HIo != null) {}
        for (paramIntent = this.HIo.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.nxJ;
          if (!com.tencent.mm.al.a.e.a(localc, str, this.vKi.field_userId, localapz)) {
            break label265;
          }
          af.aDe();
          paramIntent = com.tencent.mm.al.a.h.a(this.nxJ, localapz, this);
          getString(2131755906);
          this.fts = com.tencent.mm.ui.base.h.b(this, getString(2131755168), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(34053);
              az.agi().a(paramIntent);
              AppMethodBeat.o(34053);
            }
          });
          bool = true;
          break;
        }
        label265:
        bool = false;
      }
      else
      {
        AppMethodBeat.o(34068);
        return;
        bool = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34064);
    super.onCreate(paramBundle);
    af.aCY().a(this.HHf, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.nxJ = getIntent().getStringExtra("Chat_User");
    this.nxq = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.HGu = af.aCY().bd(this.nxq);
    this.HIl = this.HGu.field_chatName;
    this.HIm = com.tencent.mm.al.a.e.Br(this.HGu.field_bizChatServId);
    if (!this.HIm) {
      this.vKi = af.aDa().dP(this.HGu.field_bizChatServId);
    }
    this.HIo = af.aDa().BC(this.nxJ);
    initView();
    if ((this.HGu == null) || (this.HGu.field_bizChatServId == null) || (this.nxJ == null))
    {
      AppMethodBeat.o(34064);
      return;
    }
    if (this.HGu.isGroup())
    {
      af.aDe();
      com.tencent.mm.al.a.h.bi(this.HGu.field_bizChatServId, this.nxJ);
      AppMethodBeat.o(34064);
      return;
    }
    af.aDe();
    com.tencent.mm.al.a.h.a(this.HGu.field_bizChatServId, this.nxJ, this);
    AppMethodBeat.o(34064);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34067);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.ui.h.a.dismiss();
    af.aCY().a(this.HHf);
    super.onDestroy();
    AppMethodBeat.o(34067);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34066);
    super.onPause();
    AppMethodBeat.o(34066);
  }
  
  public boolean onPreferenceTreeClick(final f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(34072);
    paramf = paramPreference.mKey;
    if (paramf.equals("room_name"))
    {
      paramf = "";
      if (Wm()) {
        paramf = this.HGu.field_chatName;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131762654), paramf, "", 32, new h.b()
      {
        public final boolean onFinish(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(34060);
          boolean bool = BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramf, paramAnonymousCharSequence);
          AppMethodBeat.o(34060);
          return bool;
        }
      });
    }
    label189:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(34072);
        return false;
        if (paramf.equals("room_notify_new_msg"))
        {
          if (!this.ftN) {}
          for (bool1 = true;; bool1 = false)
          {
            this.ftN = bool1;
            W(this.ftN, 1);
            Wj();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.HIn) {}
          for (;;)
          {
            this.HIn = bool1;
            W(this.HIn, 16);
            if (!this.HIn) {
              break label189;
            }
            af.aCZ().pX(this.HGu.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          af.aCZ().pY(this.HGu.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          ac.d("MicroMsg.BizChatroomInfoUI", " quit " + this.nxq);
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131758025), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(34061);
              BizChatroomInfoUI.d(BizChatroomInfoUI.this);
              AppMethodBeat.o(34061);
            }
          }, null);
        }
      }
    } while (!paramf.equals("room_save_to_contact"));
    if (!this.zIx) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.zIx = bool1;
      W(this.zIx, 8);
      fjL();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34065);
    Wl();
    updateTitle();
    Wj();
    dqh();
    fjL();
    Wi();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.ftX)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bs.isNullOrNil(str))
      {
        final int i = this.screen.aPP(str);
        setSelection(i - 3);
        new ao().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34052);
            View localView = ((com.tencent.mm.ui.base.preference.a)BizChatroomInfoUI.a(BizChatroomInfoUI.this)).a(i, BizChatroomInfoUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.h.a.b(BizChatroomInfoUI.this.getContext(), localView);
            }
            AppMethodBeat.o(34052);
          }
        }, 10L);
      }
      this.ftX = true;
    }
    AppMethodBeat.o(34065);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34083);
    if (paramn == null)
    {
      ac.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(34083);
      return;
    }
    ac.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    this.ftM = com.tencent.mm.al.a.e.pZ(this.nxq);
    ac.d("MicroMsg.BizChatroomInfoUI", "now is " + this.ftM);
    if (this.fts != null) {
      this.fts.dismiss();
    }
    paramString = com.tencent.mm.h.a.rM(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(34083);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      fjM();
      AppMethodBeat.o(34083);
      return;
    }
    paramn.getType();
    AppMethodBeat.o(34083);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */