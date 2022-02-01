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
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.ao.a.b;
import com.tencent.mm.ao.a.d.a;
import com.tencent.mm.ao.a.d.a.a;
import com.tencent.mm.ao.a.d.a.b;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.a.o;
import com.tencent.mm.ao.a.y;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.p;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.aei;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.protocal.protobuf.nm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h.b;
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
  implements i, p
{
  private static boolean iYG = false;
  private k GYT;
  private boolean LWn;
  private int RWT;
  private com.tencent.mm.ao.a.c Wtt;
  private com.tencent.mm.ao.d Wub;
  private d.a Wud;
  private String Wvk;
  private boolean Wvl;
  private k Wvm;
  private int fromScene;
  private ProgressDialog iXX;
  private com.tencent.mm.pluginsdk.ui.e iYA;
  boolean iYB;
  private ContactListExpandPreference iYf;
  private CheckBoxPreference iYg;
  private CheckBoxPreference iYh;
  private CheckBoxPreference iYi;
  private boolean iYp;
  private int iYr;
  private boolean iYs;
  private boolean isDeleteCancel;
  private boolean isGroupChat;
  private SignaturePreference jiy;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private String syN;
  private long syu;
  
  public BizChatroomInfoUI()
  {
    AppMethodBeat.i(34063);
    this.iXX = null;
    this.sp = null;
    this.iYp = false;
    this.isGroupChat = false;
    this.Wtt = null;
    this.GYT = null;
    this.Wvm = null;
    this.iYA = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34048);
        com.tencent.mm.ay.q.bml().onScrollStateChanged(paramAnonymousInt);
        AppMethodBeat.o(34048);
      }
    });
    this.iYB = false;
    this.isDeleteCancel = false;
    this.Wud = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(34051);
        if ((paramAnonymousb != null) && (paramAnonymousb.lGf != null) && (paramAnonymousb.lFU == BizChatroomInfoUI.g(BizChatroomInfoUI.this)) && (paramAnonymousb.lGe != d.a.a.lGb))
        {
          Log.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
          paramAnonymousb = af.bjx().bF(BizChatroomInfoUI.g(BizChatroomInfoUI.this));
          BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousb);
          BizChatroomInfoUI.h(BizChatroomInfoUI.this);
        }
        AppMethodBeat.o(34051);
      }
    };
    AppMethodBeat.o(34063);
  }
  
  private void a(final nm paramnm1, nm paramnm2)
  {
    AppMethodBeat.i(34070);
    Log.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (paramnm1 == null) {}
    for (String str = getString(R.l.eQQ);; str = getString(R.l.emP))
    {
      af.bjE();
      paramnm1 = com.tencent.mm.ao.a.h.a(this.Wtt.field_brandUserName, this.Wtt.field_bizChatServId, paramnm1, paramnm2, this);
      getString(R.l.app_tip);
      this.iXX = com.tencent.mm.ui.base.h.a(this, str, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34054);
          bh.aGY().a(paramnm1);
          AppMethodBeat.o(34054);
        }
      });
      AppMethodBeat.o(34070);
      return;
    }
  }
  
  private void ar(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(34073);
    this.RWT = this.Wtt.field_bitFlag;
    this.Wvk = this.Wtt.field_chatName;
    Object localObject;
    if (this.isGroupChat)
    {
      if (paramBoolean) {
        localObject = this.Wtt;
      }
      for (((com.tencent.mm.ao.a.c)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.ao.a.c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        Log.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.Wtt.field_bitFlag) });
        af.bjx().b(this.Wtt);
        localObject = new nj();
        ((nj)localObject).RUi = this.Wtt.field_bizChatServId;
        ((nj)localObject).RUk = this.Wtt.field_bitFlag;
        af.bjE();
        com.tencent.mm.ao.a.h.a(this.Wtt.field_brandUserName, (nj)localObject, this);
        AppMethodBeat.o(34073);
        return;
        localObject = this.Wtt;
      }
    }
    if (paramBoolean) {
      localObject = this.GYT;
    }
    for (((k)localObject).field_bitFlag |= paramInt;; ((k)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      af.bjz().b(this.GYT);
      this.Wtt.field_bitFlag = this.GYT.field_bitFlag;
      af.bjx().b(this.Wtt);
      break;
      localObject = this.GYT;
    }
  }
  
  private void asB()
  {
    AppMethodBeat.i(34079);
    if (this.jiy != null)
    {
      if (asC())
      {
        Object localObject2 = this.Wtt.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        Log.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.jiy;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          localObject2 = getString(R.l.settings_signature_empty);
        }
        localSignaturePreference.aF(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject2));
        AppMethodBeat.o(34079);
        return;
      }
      this.jiy.aF(getString(R.l.eRg));
    }
    AppMethodBeat.o(34079);
  }
  
  private boolean asC()
  {
    AppMethodBeat.i(34081);
    if (this.isGroupChat) {}
    for (String str = this.Wtt.field_chatName; Util.isNullOrNil(str); str = this.GYT.field_userName)
    {
      AppMethodBeat.o(34081);
      return false;
    }
    AppMethodBeat.o(34081);
    return true;
  }
  
  private void asy()
  {
    AppMethodBeat.i(34075);
    Object localObject;
    if (this.iYf != null)
    {
      if (!this.isGroupChat) {
        break label105;
      }
      localObject = com.tencent.mm.ao.a.e.GA(this.syu);
      if (localObject == null) {
        break label130;
      }
      this.iYr = ((List)localObject).size();
      label42:
      if (this.iYr > 1) {
        break label138;
      }
      this.iYf.DZ(true).Ea(false);
    }
    for (;;)
    {
      if (this.Wub.field_hide_mod_chat_member) {
        this.iYf.DZ(false).Ea(false);
      }
      this.iYf.s(this.syN, (List)localObject);
      AppMethodBeat.o(34075);
      return;
      label105:
      localObject = new LinkedList();
      ((List)localObject).add(this.Wtt.field_bizChatServId);
      break;
      label130:
      this.iYr = 0;
      break label42;
      label138:
      this.iYf.DZ(true).Ea(this.iYp);
    }
  }
  
  private void asz()
  {
    AppMethodBeat.i(34078);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.isGroupChat)
    {
      this.iYs = this.Wtt.jQ(1);
      this.RWT = this.Wtt.field_bitFlag;
      if (!this.iYs) {
        break label160;
      }
      setTitleMuteIconVisibility(0);
      if (this.iYg != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34078);
      return;
      this.iYs = this.GYT.jQ(1);
      this.RWT = this.GYT.field_bitFlag;
      break;
      label160:
      setTitleMuteIconVisibility(8);
      if (this.iYg != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private boolean byR(String paramString)
  {
    AppMethodBeat.i(34069);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        nm localnm = new nm();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = af.bjz().gm(str);
          if (paramString != null) {
            break label261;
          }
          paramString = new k();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.syN;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.Wvm == null) {
            break label264;
          }
          localObject = this.Wvm.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!af.bjz().b(paramString)) {
            af.bjz().a(paramString);
          }
          localObject = new nl();
          ((nl)localObject).RUq = paramString.field_userId;
          localnm.RUr.add(localObject);
          i += 1;
          continue;
        }
        a(localnm, null);
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
  
  private void fqm()
  {
    AppMethodBeat.i(34077);
    Log.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.isGroupChat) {
      this.Wvl = this.Wtt.jQ(16);
    }
    for (this.RWT = this.Wtt.field_bitFlag;; this.RWT = this.GYT.field_bitFlag)
    {
      if (this.iYi != null) {
        this.sp.edit().putBoolean("room_placed_to_the_top", this.Wvl).commit();
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34077);
      return;
      this.Wvl = this.GYT.jQ(16);
    }
  }
  
  private void hLq()
  {
    AppMethodBeat.i(34076);
    Log.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.isGroupChat)
    {
      this.LWn = this.Wtt.jQ(8);
      this.RWT = this.Wtt.field_bitFlag;
      if (!this.LWn) {
        break label165;
      }
      if (this.iYh != null) {
        this.sp.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34076);
      return;
      this.LWn = this.GYT.jQ(8);
      this.RWT = this.GYT.field_bitFlag;
      break;
      label165:
      if (this.iYh != null) {
        this.sp.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void hLr()
  {
    AppMethodBeat.i(34085);
    Log.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.Wtt.field_chatName = this.Wvk;
    this.Wtt.field_bitFlag = this.RWT;
    this.iYs = this.Wtt.jQ(1);
    this.LWn = this.Wtt.jQ(8);
    this.Wvl = this.Wtt.jQ(16);
    af.bjx().b(this.Wtt);
    if (this.Wvl) {
      af.bjy().Gx(this.Wtt.field_bizChatLocalId);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", af.bjy().Gw(this.Wtt.field_bizChatLocalId)).commit();
      asB();
      asz();
      fqm();
      hLq();
      Toast.makeText(this, getString(R.l.eQK), 0).show();
      AppMethodBeat.o(34085);
      return;
      if (!this.Wvl) {
        af.bjy().Gy(this.Wtt.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    AppMethodBeat.i(34084);
    if (this.iYf != null)
    {
      asB();
      updateTitle();
      asz();
      asy();
      hLq();
      fqm();
      this.iYf.notifyChanged();
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(34084);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(34080);
    if (this.isGroupChat)
    {
      this.iYr = com.tencent.mm.ao.a.e.Gz(this.syu);
      if (this.iYr != 0)
      {
        setMMTitle(getString(R.l.eFv, new Object[] { getString(R.l.eRt), Integer.valueOf(this.iYr) }));
        AppMethodBeat.o(34080);
        return;
      }
    }
    setMMTitle(getString(R.l.eRt));
    AppMethodBeat.o(34080);
  }
  
  public final void a(int paramInt, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(34082);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (paramq.getType() == 1355)
    {
      Object localObject = ((o)paramq).bjS();
      paramq = ((o)paramq).bjT();
      localObject = af.bjx().Va(((aej)localObject).SqS.SXD.RUi);
      if (localObject == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(R.l.eQJ), 0).show();
        AppMethodBeat.o(34082);
        return;
      }
      if (this.fromScene == 2)
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Contact_User", paramq.RUp);
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ao.a.c)localObject).field_bizChatLocalId);
        com.tencent.mm.by.c.f(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        AppMethodBeat.o(34082);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramq.RUp);
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.ao.a.c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      localIntent.setClass(this, ChattingUI.class);
      paramq = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramq.aFh(), "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramq.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34082);
      return;
    }
    if (paramq.getType() == 1356)
    {
      if (paramInt != 0)
      {
        hLr();
        AppMethodBeat.o(34082);
      }
    }
    else if ((paramq.getType() == 1353) && (paramInt >= 0) && (this.GYT != null))
    {
      this.GYT = af.bjz().gm(this.GYT.field_userId);
      onDataChanged();
    }
    AppMethodBeat.o(34082);
  }
  
  public final k auT(int paramInt)
  {
    AppMethodBeat.i(34074);
    if ((this.iYf.getItem(paramInt) instanceof k))
    {
      k localk = (k)this.iYf.getItem(paramInt);
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
    return R.o.eXh;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34071);
    this.screen = getPreferenceScreen();
    Object localObject = this.Wtt.field_ownerUserId;
    this.iYr = this.Wtt.bjL().size();
    if (Util.isNullOrNil((String)localObject))
    {
      this.iYp = false;
      localObject = af.bjv().Uo(this.syN);
      this.Wub = af.bjF().Uj(((com.tencent.mm.api.c)localObject).Zf());
      Log.i("MicroMsg.BizChatroomInfoUI", "getMainBrandAttr father %s", new Object[] { ((com.tencent.mm.api.c)localObject).Zf() });
      Log.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.iYf = ((ContactListExpandPreference)this.screen.byG("roominfo_contact_anchor"));
      this.iYf.a(this.screen, this.iYf.mKey);
      this.jiy = ((SignaturePreference)this.screen.byG("room_name"));
      this.iYg = ((CheckBoxPreference)this.screen.byG("room_notify_new_msg"));
      this.iYi = ((CheckBoxPreference)this.screen.byG("room_placed_to_the_top"));
      this.iYh = ((CheckBoxPreference)this.screen.byG("room_save_to_contact"));
      localObject = this.iYf;
      boolean bool = this.isGroupChat;
      if (((ContactListExpandPreference)localObject).RgM != null) {
        ((ContactListExpandPreference)localObject).RgM.Rgc.Rgp = bool;
      }
      localObject = this.iYf;
      bool = this.iYp;
      if (((ContactListExpandPreference)localObject).RgM != null) {
        ((ContactListExpandPreference)localObject).RgM.Rgc.Rgo = bool;
      }
      if (!this.iYp) {
        break label487;
      }
      this.iYf.DZ(true).Ea(true);
    }
    for (;;)
    {
      if (this.Wub.field_hide_mod_chat_member) {
        this.iYf.DZ(false).Ea(false);
      }
      this.iYf.brp(this.Wtt.field_ownerUserId);
      this.iYf.hkE();
      this.iYf.hky();
      if (!this.isGroupChat)
      {
        this.screen.dz("room_save_to_contact", true);
        this.screen.dz("room_name", true);
        this.screen.dz("room_del_quit", true);
      }
      hLq();
      fqm();
      asz();
      if (this.iYf != null)
      {
        getListView().setOnScrollListener(this.iYA);
        this.iYf.a(this.iYA);
        this.iYf.a(new ContactListExpandPreference.a()
        {
          public final void asG()
          {
            AppMethodBeat.i(34057);
            if (BizChatroomInfoUI.b(BizChatroomInfoUI.this) != null) {
              BizChatroomInfoUI.b(BizChatroomInfoUI.this).hkC();
            }
            AppMethodBeat.o(34057);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            boolean bool = true;
            AppMethodBeat.i(268744);
            paramAnonymousViewGroup = BizChatroomInfoUI.this.auT(paramAnonymousInt);
            if ((paramAnonymousViewGroup == null) || (Util.isNullOrNil(paramAnonymousViewGroup.field_profileUrl)))
            {
              if (paramAnonymousViewGroup == null) {}
              for (;;)
              {
                Log.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
                AppMethodBeat.o(268744);
                return;
                bool = false;
              }
            }
            Log.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { paramAnonymousViewGroup.field_profileUrl });
            af.bjE();
            com.tencent.mm.ao.a.h.a(paramAnonymousViewGroup.field_userId, paramAnonymousViewGroup.field_brandUserName, BizChatroomInfoUI.this);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousViewGroup.field_profileUrl);
            localIntent.putExtra("useJs", true);
            com.tencent.mm.by.c.b(BizChatroomInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(268744);
          }
          
          public final void qv(int paramAnonymousInt)
          {
            AppMethodBeat.i(34055);
            BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousInt);
            AppMethodBeat.o(34055);
          }
          
          public final void qw(int paramAnonymousInt)
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
      this.iYp = ((String)localObject).equals(af.bjz().gn(this.syN));
      break;
      label487:
      this.iYf.DZ(true).Ea(false);
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
        bool = byR(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(R.l.eQJ), 0).show();
        AppMethodBeat.o(34068);
        return;
        bms localbms = new bms();
        com.tencent.mm.ao.a.c localc = new com.tencent.mm.ao.a.c();
        if (this.Wvm != null) {}
        for (paramIntent = this.Wvm.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.syN;
          if (!com.tencent.mm.ao.a.e.a(localc, str, this.GYT.field_userId, localbms)) {
            break label265;
          }
          af.bjE();
          paramIntent = com.tencent.mm.ao.a.h.a(this.syN, localbms, this);
          getString(R.l.app_tip);
          this.iXX = com.tencent.mm.ui.base.h.a(this, getString(R.l.emP), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(34053);
              bh.aGY().a(paramIntent);
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
    af.bjx().a(this.Wud, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.syN = getIntent().getStringExtra("Chat_User");
    this.syu = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.Wtt = af.bjx().bF(this.syu);
    this.Wvk = this.Wtt.field_chatName;
    this.isGroupChat = com.tencent.mm.ao.a.e.Vc(this.Wtt.field_bizChatServId);
    if (!this.isGroupChat) {
      this.GYT = af.bjz().gm(this.Wtt.field_bizChatServId);
    }
    this.Wvm = af.bjz().Vn(this.syN);
    initView();
    if ((this.Wtt == null) || (this.Wtt.field_bizChatServId == null) || (this.syN == null))
    {
      AppMethodBeat.o(34064);
      return;
    }
    if (this.Wtt.bjM())
    {
      af.bjE();
      com.tencent.mm.ao.a.h.br(this.Wtt.field_bizChatServId, this.syN);
      AppMethodBeat.o(34064);
      return;
    }
    af.bjE();
    com.tencent.mm.ao.a.h.a(this.Wtt.field_bizChatServId, this.syN, this);
    AppMethodBeat.o(34064);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34067);
    com.tencent.mm.ui.j.a.dismiss();
    com.tencent.mm.ui.j.a.dismiss();
    af.bjx().a(this.Wud);
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
      if (asC()) {
        paramf = this.Wtt.field_chatName;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.eRm), paramf, "", 32, new h.b()
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
          if (!this.iYs) {}
          for (bool1 = true;; bool1 = false)
          {
            this.iYs = bool1;
            ar(this.iYs, 1);
            asz();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.Wvl) {}
          for (;;)
          {
            this.Wvl = bool1;
            ar(this.Wvl, 16);
            if (!this.Wvl) {
              break label187;
            }
            af.bjy().Gx(this.Wtt.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          af.bjy().Gy(this.Wtt.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          Log.d("MicroMsg.BizChatroomInfoUI", " quit " + this.syu);
          com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.eBa), "", new DialogInterface.OnClickListener()
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
    if (!this.LWn) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.LWn = bool1;
      ar(this.LWn, 8);
      hLq();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34065);
    asB();
    updateTitle();
    asz();
    fqm();
    hLq();
    asy();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.iYB)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!Util.isNullOrNil(str))
      {
        final int i = this.screen.byJ(str);
        setSelection(i - 3);
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34052);
            View localView = ((com.tencent.mm.ui.base.preference.a)BizChatroomInfoUI.a(BizChatroomInfoUI.this)).a(i, BizChatroomInfoUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.j.a.c(BizChatroomInfoUI.this.getContext(), localView);
            }
            AppMethodBeat.o(34052);
          }
        }, 10L);
      }
      this.iYB = true;
    }
    AppMethodBeat.o(34065);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(34083);
    if (paramq == null)
    {
      Log.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(34083);
      return;
    }
    Log.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    this.iYr = com.tencent.mm.ao.a.e.Gz(this.syu);
    Log.d("MicroMsg.BizChatroomInfoUI", "now is " + this.iYr);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    paramString = com.tencent.mm.h.a.Kb(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(34083);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      hLr();
      AppMethodBeat.o(34083);
      return;
    }
    paramq.getType();
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