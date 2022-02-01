package com.tencent.mm.ui.bizchat;

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
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.am.s;
import com.tencent.mm.an.a.b;
import com.tencent.mm.an.a.d.a;
import com.tencent.mm.an.a.d.a.a;
import com.tencent.mm.an.a.d.a.b;
import com.tencent.mm.an.a.l;
import com.tencent.mm.an.a.o;
import com.tencent.mm.an.a.y;
import com.tencent.mm.an.af;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.protocal.protobuf.os;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k.b;
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
  implements com.tencent.mm.am.h, com.tencent.mm.an.p
{
  private static boolean lAu = false;
  private com.tencent.mm.an.a.k MWW;
  private boolean Syg;
  private int YUC;
  private com.tencent.mm.pluginsdk.ui.e adKd;
  private com.tencent.mm.an.a.c aeaM;
  private com.tencent.mm.an.d aebt;
  private d.a aebv;
  private String aecC;
  private boolean aecD;
  private com.tencent.mm.an.a.k aecE;
  private int fromScene;
  private boolean isDeleteCancel;
  private boolean isGroupChat;
  private CheckBoxPreference lAb;
  private boolean lAh;
  private int lAi;
  private boolean lAj;
  boolean lAt;
  private SignaturePreference lKS;
  private ProgressDialog lzP;
  private ContactListExpandPreference lzX;
  private CheckBoxPreference lzY;
  private CheckBoxPreference lzZ;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private long vEb;
  private String vEu;
  
  public BizChatroomInfoUI()
  {
    AppMethodBeat.i(34063);
    this.lzP = null;
    this.sp = null;
    this.lAh = false;
    this.isGroupChat = false;
    this.aeaM = null;
    this.MWW = null;
    this.aecE = null;
    this.adKd = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34048);
        r.bKe().onScrollStateChanged(paramAnonymousInt);
        AppMethodBeat.o(34048);
      }
    });
    this.lAt = false;
    this.isDeleteCancel = false;
    this.aebv = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(34051);
        if ((paramAnonymousb != null) && (paramAnonymousb.oxM != null) && (paramAnonymousb.oxB == BizChatroomInfoUI.g(BizChatroomInfoUI.this)) && (paramAnonymousb.oxL != d.a.a.oxI))
        {
          Log.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
          paramAnonymousb = af.bHh().dW(BizChatroomInfoUI.g(BizChatroomInfoUI.this));
          BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousb);
          BizChatroomInfoUI.h(BizChatroomInfoUI.this);
        }
        AppMethodBeat.o(34051);
      }
    };
    AppMethodBeat.o(34063);
  }
  
  private void a(final os paramos1, os paramos2)
  {
    AppMethodBeat.i(34070);
    Log.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (paramos1 == null) {}
    for (String str = getString(R.l.gTw);; str = getString(R.l.gpQ))
    {
      af.bHp();
      paramos1 = com.tencent.mm.an.a.h.a(this.aeaM.field_brandUserName, this.aeaM.field_bizChatServId, paramos1, paramos2, this);
      getString(R.l.app_tip);
      this.lzP = com.tencent.mm.ui.base.k.a(this, str, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34054);
          bh.aZW().a(paramos1);
          AppMethodBeat.o(34054);
        }
      });
      AppMethodBeat.o(34070);
      return;
    }
  }
  
  private boolean aMC()
  {
    AppMethodBeat.i(34081);
    if (this.isGroupChat) {}
    for (String str = this.aeaM.field_chatName; Util.isNullOrNil(str); str = this.MWW.field_userName)
    {
      AppMethodBeat.o(34081);
      return false;
    }
    AppMethodBeat.o(34081);
    return true;
  }
  
  private void aMl()
  {
    AppMethodBeat.i(34080);
    if (this.isGroupChat)
    {
      this.lAi = com.tencent.mm.an.a.e.iK(this.vEb);
      if (this.lAi != 0)
      {
        setMMTitle(getString(R.l.gIp, new Object[] { getString(R.l.gTZ), Integer.valueOf(this.lAi) }));
        AppMethodBeat.o(34080);
        return;
      }
    }
    setMMTitle(getString(R.l.gTZ));
    AppMethodBeat.o(34080);
  }
  
  private void aMm()
  {
    AppMethodBeat.i(34075);
    Object localObject;
    if (this.lzX != null)
    {
      if (!this.isGroupChat) {
        break label112;
      }
      localObject = com.tencent.mm.an.a.e.iL(this.vEb);
      if (localObject == null) {
        break label137;
      }
      this.lAi = ((List)localObject).size();
      label42:
      if (this.lAi > 1) {
        break label145;
      }
      this.lzX.JJ(true).JK(false);
    }
    for (;;)
    {
      if ((this.aebt != null) && (this.aebt.field_hide_mod_chat_member)) {
        this.lzX.JJ(false).JK(false);
      }
      this.lzX.y(this.vEu, (List)localObject);
      AppMethodBeat.o(34075);
      return;
      label112:
      localObject = new LinkedList();
      ((List)localObject).add(this.aeaM.field_bizChatServId);
      break;
      label137:
      this.lAi = 0;
      break label42;
      label145:
      this.lzX.JJ(true).JK(this.lAh);
    }
  }
  
  private void aMn()
  {
    AppMethodBeat.i(34079);
    if (this.lKS != null)
    {
      if (aMC())
      {
        Object localObject2 = this.aeaM.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        Log.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.lKS;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          localObject2 = getString(R.l.settings_signature_empty);
        }
        localSignaturePreference.aS(com.tencent.mm.pluginsdk.ui.span.p.b(this, (CharSequence)localObject2));
        AppMethodBeat.o(34079);
        return;
      }
      this.lKS.aS(getString(R.l.gTM));
    }
    AppMethodBeat.o(34079);
  }
  
  private void aMp()
  {
    AppMethodBeat.i(34078);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.isGroupChat)
    {
      this.lAj = this.aeaM.nG(1);
      this.YUC = this.aeaM.field_bitFlag;
      if (!this.lAj) {
        break label160;
      }
      setTitleMuteIconVisibility(0);
      if (this.lzY != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34078);
      return;
      this.lAj = this.MWW.nG(1);
      this.YUC = this.MWW.field_bitFlag;
      break;
      label160:
      setTitleMuteIconVisibility(8);
      if (this.lzY != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void at(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(34073);
    this.YUC = this.aeaM.field_bitFlag;
    this.aecC = this.aeaM.field_chatName;
    Object localObject;
    if (this.isGroupChat)
    {
      if (paramBoolean) {
        localObject = this.aeaM;
      }
      for (((com.tencent.mm.an.a.c)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.an.a.c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        Log.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.aeaM.field_bitFlag) });
        af.bHh().b(this.aeaM);
        localObject = new op();
        ((op)localObject).YRJ = this.aeaM.field_bizChatServId;
        ((op)localObject).YRL = this.aeaM.field_bitFlag;
        af.bHp();
        com.tencent.mm.an.a.h.a(this.aeaM.field_brandUserName, (op)localObject, this);
        AppMethodBeat.o(34073);
        return;
        localObject = this.aeaM;
      }
    }
    if (paramBoolean) {
      localObject = this.MWW;
    }
    for (((com.tencent.mm.an.a.k)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.an.a.k)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      af.bHj().b(this.MWW);
      this.aeaM.field_bitFlag = this.MWW.field_bitFlag;
      af.bHh().b(this.aeaM);
      break;
      localObject = this.MWW;
    }
  }
  
  private boolean bAu(String paramString)
  {
    AppMethodBeat.i(34069);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        os localos = new os();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = af.bHj().hM(str);
          if (paramString != null) {
            break label261;
          }
          paramString = new com.tencent.mm.an.a.k();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.vEu;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.aecE == null) {
            break label264;
          }
          localObject = this.aecE.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!af.bHj().b(paramString)) {
            af.bHj().a(paramString);
          }
          localObject = new or();
          ((or)localObject).YRR = paramString.field_userId;
          localos.YRS.add(localObject);
          i += 1;
          continue;
        }
        a(localos, null);
        AppMethodBeat.o(34069);
        return true;
      }
      catch (JSONException paramString)
      {
        Log.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", new Object[] { paramString.getMessage() });
        Log.printErrStackTrace("MicroMsg.BizChatroomInfoUI", paramString, "", new Object[0]);
      }
      AppMethodBeat.o(34069);
      return false;
      label261:
      continue;
      label264:
      Object localObject = null;
    }
  }
  
  private void gBC()
  {
    AppMethodBeat.i(34077);
    Log.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.isGroupChat) {
      this.aecD = this.aeaM.nG(16);
    }
    for (this.YUC = this.aeaM.field_bitFlag;; this.YUC = this.MWW.field_bitFlag)
    {
      if (this.lAb != null) {
        this.sp.edit().putBoolean("room_placed_to_the_top", this.aecD).commit();
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34077);
      return;
      this.aecD = this.MWW.nG(16);
    }
  }
  
  private void jnS()
  {
    AppMethodBeat.i(34076);
    Log.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.isGroupChat)
    {
      this.Syg = this.aeaM.nG(8);
      this.YUC = this.aeaM.field_bitFlag;
      if (!this.Syg) {
        break label165;
      }
      if (this.lzZ != null) {
        this.sp.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34076);
      return;
      this.Syg = this.MWW.nG(8);
      this.YUC = this.MWW.field_bitFlag;
      break;
      label165:
      if (this.lzZ != null) {
        this.sp.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void jnT()
  {
    AppMethodBeat.i(34085);
    Log.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.aeaM.field_chatName = this.aecC;
    this.aeaM.field_bitFlag = this.YUC;
    this.lAj = this.aeaM.nG(1);
    this.Syg = this.aeaM.nG(8);
    this.aecD = this.aeaM.nG(16);
    af.bHh().b(this.aeaM);
    if (this.aecD) {
      af.bHi().iH(this.aeaM.field_bizChatLocalId);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", af.bHi().iG(this.aeaM.field_bizChatLocalId)).commit();
      aMn();
      aMp();
      gBC();
      jnS();
      Toast.makeText(this, getString(R.l.gTq), 0).show();
      AppMethodBeat.o(34085);
      return;
      if (!this.aecD) {
        af.bHi().iI(this.aeaM.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    AppMethodBeat.i(34084);
    if (this.lzX != null)
    {
      aMn();
      aMl();
      aMp();
      aMm();
      jnS();
      gBC();
      this.lzX.notifyChanged();
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(34084);
  }
  
  public final void a(int paramInt, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(34082);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if (paramp.getType() == 1355)
    {
      Object localObject = ((o)paramp).bHE();
      paramp = ((o)paramp).bHF();
      localObject = af.bHh().MZ(((agv)localObject).ZpT.aajx.YRJ);
      if (localObject == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(R.l.gTp), 0).show();
        AppMethodBeat.o(34082);
        return;
      }
      if (this.fromScene == 2)
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Contact_User", paramp.YRQ);
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.an.a.c)localObject).field_bizChatLocalId);
        com.tencent.mm.br.c.g(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        AppMethodBeat.o(34082);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramp.YRQ);
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.an.a.c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      localIntent.setClass(this, ChattingUI.class);
      paramp = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramp.aYi(), "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramp.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34082);
      return;
    }
    if (paramp.getType() == 1356)
    {
      if (paramInt != 0)
      {
        jnT();
        AppMethodBeat.o(34082);
      }
    }
    else if ((paramp.getType() == 1353) && (paramInt >= 0) && (this.MWW != null))
    {
      this.MWW = af.bHj().hM(this.MWW.field_userId);
      onDataChanged();
    }
    AppMethodBeat.o(34082);
  }
  
  public final com.tencent.mm.an.a.k aBv(int paramInt)
  {
    AppMethodBeat.i(34074);
    if ((this.lzX.getItem(paramInt) instanceof com.tencent.mm.an.a.k))
    {
      com.tencent.mm.an.a.k localk = (com.tencent.mm.an.a.k)this.lzX.getItem(paramInt);
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
    return R.o.bizchat_roominfo_pref;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34071);
    this.screen = getPreferenceScreen();
    Object localObject = this.aeaM.field_ownerUserId;
    this.lAi = this.aeaM.bHw().size();
    if (Util.isNullOrNil((String)localObject))
    {
      this.lAh = false;
      localObject = af.bHf().Mn(this.vEu);
      this.aebt = af.bHq().Mi(((com.tencent.mm.api.c)localObject).aAX());
      Log.i("MicroMsg.BizChatroomInfoUI", "getMainBrandAttr father %s", new Object[] { ((com.tencent.mm.api.c)localObject).aAX() });
      Log.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.lzX = ((ContactListExpandPreference)this.screen.bAi("roominfo_contact_anchor"));
      this.lzX.a(this.screen, this.lzX.mKey);
      this.lKS = ((SignaturePreference)this.screen.bAi("room_name"));
      this.lzY = ((CheckBoxPreference)this.screen.bAi("room_notify_new_msg"));
      this.lAb = ((CheckBoxPreference)this.screen.bAi("room_placed_to_the_top"));
      this.lzZ = ((CheckBoxPreference)this.screen.bAi("room_save_to_contact"));
      localObject = this.lzX;
      boolean bool = this.isGroupChat;
      if (((ContactListExpandPreference)localObject).YcP != null) {
        ((ContactListExpandPreference)localObject).YcP.Yce.Ycs = bool;
      }
      localObject = this.lzX;
      bool = this.lAh;
      if (((ContactListExpandPreference)localObject).YcP != null) {
        ((ContactListExpandPreference)localObject).YcP.Yce.Ycr = bool;
      }
      if (!this.lAh) {
        break label494;
      }
      this.lzX.JJ(true).JK(true);
    }
    for (;;)
    {
      if ((this.aebt != null) && (this.aebt.field_hide_mod_chat_member)) {
        this.lzX.JJ(false).JK(false);
      }
      this.lzX.brd(this.aeaM.field_ownerUserId);
      this.lzX.iLv();
      this.lzX.iLp();
      if (!this.isGroupChat)
      {
        this.screen.eh("room_save_to_contact", true);
        this.screen.eh("room_name", true);
        this.screen.eh("room_del_quit", true);
      }
      jnS();
      gBC();
      aMp();
      if (this.lzX != null)
      {
        getListView().setOnScrollListener(this.adKd);
        this.lzX.a(this.adKd);
        this.lzX.a(new ContactListExpandPreference.a()
        {
          public final void aMI()
          {
            AppMethodBeat.i(34057);
            if (BizChatroomInfoUI.b(BizChatroomInfoUI.this) != null) {
              BizChatroomInfoUI.b(BizChatroomInfoUI.this).iLt();
            }
            AppMethodBeat.o(34057);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            boolean bool = true;
            AppMethodBeat.i(250758);
            paramAnonymousViewGroup = BizChatroomInfoUI.this.aBv(paramAnonymousInt);
            if ((paramAnonymousViewGroup == null) || (Util.isNullOrNil(paramAnonymousViewGroup.field_profileUrl)))
            {
              if (paramAnonymousViewGroup == null) {}
              for (;;)
              {
                Log.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
                AppMethodBeat.o(250758);
                return;
                bool = false;
              }
            }
            Log.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { paramAnonymousViewGroup.field_profileUrl });
            af.bHp();
            com.tencent.mm.an.a.h.a(paramAnonymousViewGroup.field_userId, paramAnonymousViewGroup.field_brandUserName, BizChatroomInfoUI.this);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousViewGroup.field_profileUrl);
            localIntent.putExtra("useJs", true);
            com.tencent.mm.br.c.b(BizChatroomInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(250758);
          }
          
          public final void qw(int paramAnonymousInt)
          {
            AppMethodBeat.i(34055);
            BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousInt);
            AppMethodBeat.o(34055);
          }
          
          public final void qx(int paramAnonymousInt)
          {
            AppMethodBeat.i(34058);
            BizChatroomInfoUI.c(BizChatroomInfoUI.this);
            AppMethodBeat.o(34058);
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
      this.lAh = ((String)localObject).equals(af.bHj().hN(this.vEu));
      break;
      label494:
      this.lzX.JJ(true).JK(false);
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
      Log.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
      str = paramIntent.getString("enterprise_members");
      Log.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", new Object[] { str });
      if (this.isGroupChat) {
        bool = bAu(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(R.l.gTp), 0).show();
        AppMethodBeat.o(34068);
        return;
        cam localcam = new cam();
        com.tencent.mm.an.a.c localc = new com.tencent.mm.an.a.c();
        if (this.aecE != null) {}
        for (paramIntent = this.aecE.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.vEu;
          if (!com.tencent.mm.an.a.e.a(localc, str, this.MWW.field_userId, localcam)) {
            break label265;
          }
          af.bHp();
          paramIntent = com.tencent.mm.an.a.h.a(this.vEu, localcam, this);
          getString(R.l.app_tip);
          this.lzP = com.tencent.mm.ui.base.k.a(this, getString(R.l.gpQ), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(34053);
              bh.aZW().a(paramIntent);
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
    af.bHh().a(this.aebv, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.vEu = getIntent().getStringExtra("Chat_User");
    this.vEb = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.aeaM = af.bHh().dW(this.vEb);
    this.aecC = this.aeaM.field_chatName;
    this.isGroupChat = com.tencent.mm.an.a.e.Nb(this.aeaM.field_bizChatServId);
    if (!this.isGroupChat) {
      this.MWW = af.bHj().hM(this.aeaM.field_bizChatServId);
    }
    this.aecE = af.bHj().Nm(this.vEu);
    initView();
    if ((this.aeaM == null) || (this.aeaM.field_bizChatServId == null) || (this.vEu == null))
    {
      AppMethodBeat.o(34064);
      return;
    }
    if (this.aeaM.bHx())
    {
      af.bHp();
      com.tencent.mm.an.a.h.bC(this.aeaM.field_bizChatServId, this.vEu);
      AppMethodBeat.o(34064);
      return;
    }
    af.bHp();
    com.tencent.mm.an.a.h.a(this.aeaM.field_bizChatServId, this.vEu, this);
    AppMethodBeat.o(34064);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34067);
    com.tencent.mm.ui.j.a.dismiss();
    com.tencent.mm.ui.j.a.dismiss();
    af.bHh().a(this.aebv);
    super.onDestroy();
    AppMethodBeat.o(34067);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34066);
    super.onPause();
    AppMethodBeat.o(34066);
  }
  
  public boolean onPreferenceTreeClick(final com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(34072);
    paramf = paramPreference.mKey;
    if (paramf.equals("room_name"))
    {
      paramf = "";
      if (aMC()) {
        paramf = this.aeaM.field_chatName;
      }
      com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.gTS), paramf, "", 32, new k.b()
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
    label187:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(34072);
        return false;
        if (paramf.equals("room_notify_new_msg"))
        {
          if (!this.lAj) {}
          for (bool1 = true;; bool1 = false)
          {
            this.lAj = bool1;
            at(this.lAj, 1);
            aMp();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.aecD) {}
          for (;;)
          {
            this.aecD = bool1;
            at(this.aecD, 16);
            if (!this.aecD) {
              break label187;
            }
            af.bHi().iH(this.aeaM.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          af.bHi().iI(this.aeaM.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          Log.d("MicroMsg.BizChatroomInfoUI", " quit " + this.vEb);
          com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.gEc), "", new DialogInterface.OnClickListener()
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
    if (!this.Syg) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.Syg = bool1;
      at(this.Syg, 8);
      jnS();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34065);
    aMn();
    aMl();
    aMp();
    gBC();
    jnS();
    aMm();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.lAt)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!Util.isNullOrNil(str))
      {
        final int i = this.screen.bAl(str);
        setSelection(i - 3);
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34052);
            View localView = ((com.tencent.mm.ui.base.preference.a)BizChatroomInfoUI.a(BizChatroomInfoUI.this)).a(i, BizChatroomInfoUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.j.a.d(BizChatroomInfoUI.this.getContext(), localView);
            }
            AppMethodBeat.o(34052);
          }
        }, 10L);
      }
      this.lAt = true;
    }
    AppMethodBeat.o(34065);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(34083);
    if (paramp == null)
    {
      Log.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(34083);
      return;
    }
    Log.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramp.getType()) });
    this.lAi = com.tencent.mm.an.a.e.iK(this.vEb);
    Log.d("MicroMsg.BizChatroomInfoUI", "now is " + this.lAi);
    if (this.lzP != null) {
      this.lzP.dismiss();
    }
    paramString = com.tencent.mm.broadcast.a.CH(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(34083);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      jnT();
      AppMethodBeat.o(34083);
      return;
    }
    paramp.getType();
    AppMethodBeat.o(34083);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */