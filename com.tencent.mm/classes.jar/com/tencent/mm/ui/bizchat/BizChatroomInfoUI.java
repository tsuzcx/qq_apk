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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.o;
import com.tencent.mm.al.a.y;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
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
  private static boolean guv = false;
  private k BeV;
  private boolean FCj;
  private int KVI;
  private com.tencent.mm.al.d PaO;
  private d.a PaQ;
  private com.tencent.mm.al.a.c Pag;
  private String PbX;
  private boolean PbY;
  private boolean PbZ;
  private k Pca;
  private int fromScene;
  private ProgressDialog gtM;
  private ContactListExpandPreference gtU;
  private CheckBoxPreference gtV;
  private CheckBoxPreference gtW;
  private CheckBoxPreference gtX;
  private boolean gue;
  private int gug;
  private boolean guh;
  private com.tencent.mm.pluginsdk.ui.e gup;
  boolean guq;
  private SignaturePreference gyv;
  private boolean isDeleteCancel;
  private String ppO;
  private long ppv;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  
  public BizChatroomInfoUI()
  {
    AppMethodBeat.i(34063);
    this.gtM = null;
    this.sp = null;
    this.gue = false;
    this.PbY = false;
    this.Pag = null;
    this.BeV = null;
    this.Pca = null;
    this.gup = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34048);
        com.tencent.mm.av.q.bcV().onScrollStateChanged(paramAnonymousInt);
        AppMethodBeat.o(34048);
      }
    });
    this.guq = false;
    this.isDeleteCancel = false;
    this.PaQ = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(34051);
        if ((paramAnonymousb != null) && (paramAnonymousb.iPP != null) && (paramAnonymousb.iPE == BizChatroomInfoUI.g(BizChatroomInfoUI.this)) && (paramAnonymousb.iPO != d.a.a.iPL))
        {
          Log.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
          paramAnonymousb = ag.baj().bs(BizChatroomInfoUI.g(BizChatroomInfoUI.this));
          BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousb);
          BizChatroomInfoUI.h(BizChatroomInfoUI.this);
        }
        AppMethodBeat.o(34051);
      }
    };
    AppMethodBeat.o(34063);
  }
  
  private void a(final nw paramnw1, nw paramnw2)
  {
    AppMethodBeat.i(34070);
    Log.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (paramnw1 == null) {}
    for (String str = getString(2131764675);; str = getString(2131755186))
    {
      ag.baq();
      paramnw1 = com.tencent.mm.al.a.h.a(this.Pag.field_brandUserName, this.Pag.field_bizChatServId, paramnw1, paramnw2, this);
      getString(2131755998);
      this.gtM = com.tencent.mm.ui.base.h.a(this, str, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34054);
          bg.azz().a(paramnw1);
          AppMethodBeat.o(34054);
        }
      });
      AppMethodBeat.o(34070);
      return;
    }
  }
  
  private void ad(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(34073);
    this.KVI = this.Pag.field_bitFlag;
    this.PbX = this.Pag.field_chatName;
    Object localObject;
    if (this.PbY)
    {
      if (paramBoolean) {
        localObject = this.Pag;
      }
      for (((com.tencent.mm.al.a.c)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.al.a.c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        Log.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.Pag.field_bitFlag) });
        ag.baj().b(this.Pag);
        localObject = new nt();
        ((nt)localObject).KTl = this.Pag.field_bizChatServId;
        ((nt)localObject).KTn = this.Pag.field_bitFlag;
        ag.baq();
        com.tencent.mm.al.a.h.a(this.Pag.field_brandUserName, (nt)localObject, this);
        AppMethodBeat.o(34073);
        return;
        localObject = this.Pag;
      }
    }
    if (paramBoolean) {
      localObject = this.BeV;
    }
    for (((k)localObject).field_bitFlag |= paramInt;; ((k)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      ag.bal().b(this.BeV);
      this.Pag.field_bitFlag = this.BeV.field_bitFlag;
      ag.baj().b(this.Pag);
      break;
      localObject = this.BeV;
    }
  }
  
  private void amA()
  {
    AppMethodBeat.i(34079);
    if (this.gyv != null)
    {
      if (amB())
      {
        Object localObject2 = this.Pag.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        Log.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.gyv;
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          localObject2 = getString(2131765591);
        }
        localSignaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, (CharSequence)localObject2));
        AppMethodBeat.o(34079);
        return;
      }
      this.gyv.setSummary(getString(2131764704));
    }
    AppMethodBeat.o(34079);
  }
  
  private boolean amB()
  {
    AppMethodBeat.i(34081);
    if (this.PbY) {}
    for (String str = this.Pag.field_chatName; Util.isNullOrNil(str); str = this.BeV.field_userName)
    {
      AppMethodBeat.o(34081);
      return false;
    }
    AppMethodBeat.o(34081);
    return true;
  }
  
  private void amx()
  {
    AppMethodBeat.i(34075);
    Object localObject;
    if (this.gtU != null)
    {
      if (!this.PbY) {
        break label105;
      }
      localObject = com.tencent.mm.al.a.e.As(this.ppv);
      if (localObject == null) {
        break label130;
      }
      this.gug = ((List)localObject).size();
      label42:
      if (this.gug > 1) {
        break label138;
      }
      this.gtU.zU(true).zV(false);
    }
    for (;;)
    {
      if (this.PaO.field_hide_mod_chat_member) {
        this.gtU.zU(false).zV(false);
      }
      this.gtU.H(this.ppO, (List)localObject);
      AppMethodBeat.o(34075);
      return;
      label105:
      localObject = new LinkedList();
      ((List)localObject).add(this.Pag.field_bizChatServId);
      break;
      label130:
      this.gug = 0;
      break label42;
      label138:
      this.gtU.zU(true).zV(this.gue);
    }
  }
  
  private void amy()
  {
    AppMethodBeat.i(34078);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.PbY)
    {
      this.guh = this.Pag.iE(1);
      this.KVI = this.Pag.field_bitFlag;
      if (!this.guh) {
        break label160;
      }
      setTitleMuteIconVisibility(0);
      if (this.gtV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34078);
      return;
      this.guh = this.BeV.iE(1);
      this.KVI = this.BeV.field_bitFlag;
      break;
      label160:
      setTitleMuteIconVisibility(8);
      if (this.gtV != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private boolean bms(String paramString)
  {
    AppMethodBeat.i(34069);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        nw localnw = new nw();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = ag.bal().fB(str);
          if (paramString != null) {
            break label261;
          }
          paramString = new k();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.ppO;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.Pca == null) {
            break label264;
          }
          localObject = this.Pca.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!ag.bal().b(paramString)) {
            ag.bal().a(paramString);
          }
          localObject = new nv();
          ((nv)localObject).KTu = paramString.field_userId;
          localnw.KTv.add(localObject);
          i += 1;
          continue;
        }
        a(localnw, null);
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
  
  private void eEu()
  {
    AppMethodBeat.i(34077);
    Log.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.PbY) {
      this.PbZ = this.Pag.iE(16);
    }
    for (this.KVI = this.Pag.field_bitFlag;; this.KVI = this.BeV.field_bitFlag)
    {
      if (this.gtX != null) {
        this.sp.edit().putBoolean("room_placed_to_the_top", this.PbZ).commit();
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34077);
      return;
      this.PbZ = this.BeV.iE(16);
    }
  }
  
  private void gMj()
  {
    AppMethodBeat.i(34076);
    Log.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.PbY)
    {
      this.FCj = this.Pag.iE(8);
      this.KVI = this.Pag.field_bitFlag;
      if (!this.FCj) {
        break label165;
      }
      if (this.gtW != null) {
        this.sp.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34076);
      return;
      this.FCj = this.BeV.iE(8);
      this.KVI = this.BeV.field_bitFlag;
      break;
      label165:
      if (this.gtW != null) {
        this.sp.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void gMk()
  {
    AppMethodBeat.i(34085);
    Log.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.Pag.field_chatName = this.PbX;
    this.Pag.field_bitFlag = this.KVI;
    this.guh = this.Pag.iE(1);
    this.FCj = this.Pag.iE(8);
    this.PbZ = this.Pag.iE(16);
    ag.baj().b(this.Pag);
    if (this.PbZ) {
      ag.bak().Ap(this.Pag.field_bizChatLocalId);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", ag.bak().Ao(this.Pag.field_bizChatLocalId)).commit();
      amA();
      amy();
      eEu();
      gMj();
      Toast.makeText(this, getString(2131764662), 0).show();
      AppMethodBeat.o(34085);
      return;
      if (!this.PbZ) {
        ag.bak().Aq(this.Pag.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    AppMethodBeat.i(34084);
    if (this.gtU != null)
    {
      amA();
      updateTitle();
      amy();
      amx();
      gMj();
      eEu();
      this.gtU.notifyChanged();
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(34084);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(34080);
    if (this.PbY)
    {
      this.gug = com.tencent.mm.al.a.e.Ar(this.ppv);
      if (this.gug != 0)
      {
        setMMTitle(getString(2131760811, new Object[] { getString(2131764812), Integer.valueOf(this.gug) }));
        AppMethodBeat.o(34080);
        return;
      }
    }
    setMMTitle(getString(2131764812));
    AppMethodBeat.o(34080);
  }
  
  public final void a(int paramInt, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(34082);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (paramq.getType() == 1355)
    {
      Object localObject = ((o)paramq).baD();
      paramq = ((o)paramq).baE();
      localObject = ag.baj().NE(((aec)localObject).Lpw.LPp.KTl);
      if (localObject == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(2131764661), 0).show();
        AppMethodBeat.o(34082);
        return;
      }
      if (this.fromScene == 2)
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Contact_User", paramq.KTt);
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
        com.tencent.mm.br.c.f(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        AppMethodBeat.o(34082);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramq.KTt);
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      localIntent.setClass(this, ChattingUI.class);
      paramq = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramq.axQ(), "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramq.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34082);
      return;
    }
    if (paramq.getType() == 1356)
    {
      if (paramInt != 0)
      {
        gMk();
        AppMethodBeat.o(34082);
      }
    }
    else if ((paramq.getType() == 1353) && (paramInt >= 0) && (this.BeV != null))
    {
      this.BeV = ag.bal().fB(this.BeV.field_userId);
      onDataChanged();
    }
    AppMethodBeat.o(34082);
  }
  
  public final k alT(int paramInt)
  {
    AppMethodBeat.i(34074);
    if ((this.gtU.getItem(paramInt) instanceof k))
    {
      k localk = (k)this.gtU.getItem(paramInt);
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
    return 2132017169;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34071);
    this.screen = getPreferenceScreen();
    Object localObject = this.Pag.field_ownerUserId;
    this.gug = this.Pag.bax().size();
    if (Util.isNullOrNil((String)localObject))
    {
      this.gue = false;
      localObject = ag.bah().MT(this.ppO);
      this.PaO = ag.bar().MO(((com.tencent.mm.api.c)localObject).UN());
      Log.i("MicroMsg.BizChatroomInfoUI", "getMainBrandAttr father %s", new Object[] { ((com.tencent.mm.api.c)localObject).UN() });
      Log.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.gtU = ((ContactListExpandPreference)this.screen.bmg("roominfo_contact_anchor"));
      this.gtU.a(this.screen, this.gtU.mKey);
      this.gyv = ((SignaturePreference)this.screen.bmg("room_name"));
      this.gtV = ((CheckBoxPreference)this.screen.bmg("room_notify_new_msg"));
      this.gtX = ((CheckBoxPreference)this.screen.bmg("room_placed_to_the_top"));
      this.gtW = ((CheckBoxPreference)this.screen.bmg("room_save_to_contact"));
      localObject = this.gtU;
      boolean bool = this.PbY;
      if (((ContactListExpandPreference)localObject).KfY != null) {
        ((ContactListExpandPreference)localObject).KfY.Kfo.KfB = bool;
      }
      localObject = this.gtU;
      bool = this.gue;
      if (((ContactListExpandPreference)localObject).KfY != null) {
        ((ContactListExpandPreference)localObject).KfY.Kfo.KfA = bool;
      }
      if (!this.gue) {
        break label487;
      }
      this.gtU.zU(true).zV(true);
    }
    for (;;)
    {
      if (this.PaO.field_hide_mod_chat_member) {
        this.gtU.zU(false).zV(false);
      }
      this.gtU.beT(this.Pag.field_ownerUserId);
      this.gtU.gpG();
      this.gtU.gpA();
      if (!this.PbY)
      {
        this.screen.jdMethod_do("room_save_to_contact", true);
        this.screen.jdMethod_do("room_name", true);
        this.screen.jdMethod_do("room_del_quit", true);
      }
      gMj();
      eEu();
      amy();
      if (this.gtU != null)
      {
        getListView().setOnScrollListener(this.gup);
        this.gtU.a(this.gup);
        this.gtU.a(new ContactListExpandPreference.a()
        {
          public final void amF()
          {
            AppMethodBeat.i(34057);
            if (BizChatroomInfoUI.b(BizChatroomInfoUI.this) != null) {
              BizChatroomInfoUI.b(BizChatroomInfoUI.this).gpE();
            }
            AppMethodBeat.o(34057);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            boolean bool = true;
            AppMethodBeat.i(232794);
            paramAnonymousViewGroup = BizChatroomInfoUI.this.alT(paramAnonymousInt);
            if ((paramAnonymousViewGroup == null) || (Util.isNullOrNil(paramAnonymousViewGroup.field_profileUrl)))
            {
              if (paramAnonymousViewGroup == null) {}
              for (;;)
              {
                Log.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
                AppMethodBeat.o(232794);
                return;
                bool = false;
              }
            }
            Log.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { paramAnonymousViewGroup.field_profileUrl });
            ag.baq();
            com.tencent.mm.al.a.h.a(paramAnonymousViewGroup.field_userId, paramAnonymousViewGroup.field_brandUserName, BizChatroomInfoUI.this);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousViewGroup.field_profileUrl);
            localIntent.putExtra("useJs", true);
            com.tencent.mm.br.c.b(BizChatroomInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(232794);
          }
          
          public final void og(int paramAnonymousInt)
          {
            AppMethodBeat.i(34055);
            BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousInt);
            AppMethodBeat.o(34055);
          }
          
          public final void oh(int paramAnonymousInt)
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
      this.gue = ((String)localObject).equals(ag.bal().fC(this.ppO));
      break;
      label487:
      this.gtU.zU(true).zV(false);
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
      if (this.PbY) {
        bool = bms(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(2131764661), 0).show();
        AppMethodBeat.o(34068);
        return;
        bfs localbfs = new bfs();
        com.tencent.mm.al.a.c localc = new com.tencent.mm.al.a.c();
        if (this.Pca != null) {}
        for (paramIntent = this.Pca.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.ppO;
          if (!com.tencent.mm.al.a.e.a(localc, str, this.BeV.field_userId, localbfs)) {
            break label263;
          }
          ag.baq();
          paramIntent = com.tencent.mm.al.a.h.a(this.ppO, localbfs, this);
          getString(2131755998);
          this.gtM = com.tencent.mm.ui.base.h.a(this, getString(2131755186), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(34053);
              bg.azz().a(paramIntent);
              AppMethodBeat.o(34053);
            }
          });
          bool = true;
          break;
        }
        label263:
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
    ag.baj().a(this.PaQ, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.ppO = getIntent().getStringExtra("Chat_User");
    this.ppv = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.Pag = ag.baj().bs(this.ppv);
    this.PbX = this.Pag.field_chatName;
    this.PbY = com.tencent.mm.al.a.e.NG(this.Pag.field_bizChatServId);
    if (!this.PbY) {
      this.BeV = ag.bal().fB(this.Pag.field_bizChatServId);
    }
    this.Pca = ag.bal().NQ(this.ppO);
    initView();
    if ((this.Pag == null) || (this.Pag.field_bizChatServId == null) || (this.ppO == null))
    {
      AppMethodBeat.o(34064);
      return;
    }
    if (this.Pag.isGroup())
    {
      ag.baq();
      com.tencent.mm.al.a.h.bn(this.Pag.field_bizChatServId, this.ppO);
      AppMethodBeat.o(34064);
      return;
    }
    ag.baq();
    com.tencent.mm.al.a.h.a(this.Pag.field_bizChatServId, this.ppO, this);
    AppMethodBeat.o(34064);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34067);
    com.tencent.mm.ui.i.a.dismiss();
    com.tencent.mm.ui.i.a.dismiss();
    ag.baj().a(this.PaQ);
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
      if (amB()) {
        paramf = this.Pag.field_chatName;
      }
      com.tencent.mm.ui.base.h.a(getContext(), getString(2131764737), paramf, "", 32, new h.b()
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
          if (!this.guh) {}
          for (bool1 = true;; bool1 = false)
          {
            this.guh = bool1;
            ad(this.guh, 1);
            amy();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.PbZ) {}
          for (;;)
          {
            this.PbZ = bool1;
            ad(this.PbZ, 16);
            if (!this.PbZ) {
              break label187;
            }
            ag.bak().Ap(this.Pag.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          ag.bak().Aq(this.Pag.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          Log.d("MicroMsg.BizChatroomInfoUI", " quit " + this.ppv);
          com.tencent.mm.ui.base.h.a(getContext(), getString(2131758277), "", new DialogInterface.OnClickListener()
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
    if (!this.FCj) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.FCj = bool1;
      ad(this.FCj, 8);
      gMj();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34065);
    amA();
    updateTitle();
    amy();
    eEu();
    gMj();
    amx();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.guq)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!Util.isNullOrNil(str))
      {
        final int i = this.screen.bmj(str);
        setSelection(i - 3);
        new MMHandler().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34052);
            View localView = ((com.tencent.mm.ui.base.preference.a)BizChatroomInfoUI.a(BizChatroomInfoUI.this)).a(i, BizChatroomInfoUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.i.a.c(BizChatroomInfoUI.this.getContext(), localView);
            }
            AppMethodBeat.o(34052);
          }
        }, 10L);
      }
      this.guq = true;
    }
    AppMethodBeat.o(34065);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(34083);
    if (paramq == null)
    {
      Log.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(34083);
      return;
    }
    Log.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    this.gug = com.tencent.mm.al.a.e.Ar(this.ppv);
    Log.d("MicroMsg.BizChatroomInfoUI", "now is " + this.gug);
    if (this.gtM != null) {
      this.gtM.dismiss();
    }
    paramString = com.tencent.mm.h.a.Dk(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(34083);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      gMk();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */