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
import com.tencent.mm.al.n;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.a.d.a;
import com.tencent.mm.am.a.d.a.a;
import com.tencent.mm.am.a.d.a.b;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.a.o;
import com.tencent.mm.am.a.y;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.p;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.nc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements com.tencent.mm.al.f, p
{
  private static boolean fNd = false;
  private boolean AZY;
  private int FJk;
  private com.tencent.mm.am.d JuU;
  private d.a JuW;
  private com.tencent.mm.am.a.c Jul;
  private String Jwc;
  private boolean Jwd;
  private boolean Jwe;
  private com.tencent.mm.am.a.k Jwf;
  private ContactListExpandPreference fMC;
  private CheckBoxPreference fMD;
  private CheckBoxPreference fME;
  private CheckBoxPreference fMF;
  private boolean fMM;
  private int fMO;
  private boolean fMP;
  private com.tencent.mm.pluginsdk.ui.e fMX;
  boolean fMY;
  private ProgressDialog fMu;
  private SignaturePreference fRi;
  private int fromScene;
  private boolean isDeleteCancel;
  private long nYO;
  private String nZh;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private com.tencent.mm.am.a.k wRr;
  
  public BizChatroomInfoUI()
  {
    AppMethodBeat.i(34063);
    this.fMu = null;
    this.sp = null;
    this.fMM = false;
    this.Jwd = false;
    this.Jul = null;
    this.wRr = null;
    this.Jwf = null;
    this.fMX = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34048);
        com.tencent.mm.aw.q.aIJ().cp(paramAnonymousInt);
        AppMethodBeat.o(34048);
      }
    });
    this.fMY = false;
    this.isDeleteCancel = false;
    this.JuW = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(34051);
        if ((paramAnonymousb != null) && (paramAnonymousb.hRK != null) && (paramAnonymousb.hRz == BizChatroomInfoUI.g(BizChatroomInfoUI.this)) && (paramAnonymousb.hRJ != d.a.a.hRG))
        {
          ad.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
          paramAnonymousb = ag.aGb().bd(BizChatroomInfoUI.g(BizChatroomInfoUI.this));
          BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousb);
          BizChatroomInfoUI.h(BizChatroomInfoUI.this);
        }
        AppMethodBeat.o(34051);
      }
    };
    AppMethodBeat.o(34063);
  }
  
  private void X(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(34073);
    this.FJk = this.Jul.field_bitFlag;
    this.Jwc = this.Jul.field_chatName;
    Object localObject;
    if (this.Jwd)
    {
      if (paramBoolean) {
        localObject = this.Jul;
      }
      for (((com.tencent.mm.am.a.c)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.am.a.c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        ad.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.Jul.field_bitFlag) });
        ag.aGb().b(this.Jul);
        localObject = new mz();
        ((mz)localObject).FGU = this.Jul.field_bizChatServId;
        ((mz)localObject).FGW = this.Jul.field_bitFlag;
        ag.aGh();
        com.tencent.mm.am.a.h.a(this.Jul.field_brandUserName, (mz)localObject, this);
        AppMethodBeat.o(34073);
        return;
        localObject = this.Jul;
      }
    }
    if (paramBoolean) {
      localObject = this.wRr;
    }
    for (((com.tencent.mm.am.a.k)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.am.a.k)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      ag.aGd().b(this.wRr);
      this.Jul.field_bitFlag = this.wRr.field_bitFlag;
      ag.aGb().b(this.Jul);
      break;
      localObject = this.wRr;
    }
  }
  
  private void YB()
  {
    AppMethodBeat.i(34075);
    Object localObject;
    if (this.fMC != null)
    {
      if (!this.Jwd) {
        break label103;
      }
      localObject = com.tencent.mm.am.a.e.rZ(this.nYO);
      if (localObject == null) {
        break label128;
      }
      this.fMO = ((List)localObject).size();
      label41:
      if (this.fMO > 1) {
        break label136;
      }
      this.fMC.vO(true).vP(false);
    }
    for (;;)
    {
      if (this.JuU.field_hide_mod_chat_member) {
        this.fMC.vO(false).vP(false);
      }
      this.fMC.A(this.nZh, (List)localObject);
      AppMethodBeat.o(34075);
      return;
      label103:
      localObject = new LinkedList();
      ((List)localObject).add(this.Jul.field_bizChatServId);
      break;
      label128:
      this.fMO = 0;
      break label41;
      label136:
      this.fMC.vO(true).vP(this.fMM);
    }
  }
  
  private void YC()
  {
    AppMethodBeat.i(34078);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.Jwd)
    {
      this.fMP = this.Jul.hj(1);
      this.FJk = this.Jul.field_bitFlag;
      if (!this.fMP) {
        break label158;
      }
      setTitleMuteIconVisibility(0);
      if (this.fMD != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34078);
      return;
      this.fMP = this.wRr.hj(1);
      this.FJk = this.wRr.field_bitFlag;
      break;
      label158:
      setTitleMuteIconVisibility(8);
      if (this.fMD != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void YE()
  {
    AppMethodBeat.i(34079);
    if (this.fRi != null)
    {
      if (YF())
      {
        Object localObject2 = this.Jul.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        ad.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.fRi;
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
      this.fRi.setSummary(getString(2131762622));
    }
    AppMethodBeat.o(34079);
  }
  
  private boolean YF()
  {
    AppMethodBeat.i(34081);
    if (this.Jwd) {}
    for (String str = this.Jul.field_chatName; bt.isNullOrNil(str); str = this.wRr.field_userName)
    {
      AppMethodBeat.o(34081);
      return false;
    }
    AppMethodBeat.o(34081);
    return true;
  }
  
  private void a(final nc paramnc1, nc paramnc2)
  {
    AppMethodBeat.i(34070);
    ad.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (paramnc1 == null) {}
    for (String str = getString(2131762595);; str = getString(2131755168))
    {
      ag.aGh();
      paramnc1 = com.tencent.mm.am.a.h.a(this.Jul.field_brandUserName, this.Jul.field_bizChatServId, paramnc1, paramnc2, this);
      getString(2131755906);
      this.fMu = com.tencent.mm.ui.base.h.b(this, str, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34054);
          ba.aiU().a(paramnc1);
          AppMethodBeat.o(34054);
        }
      });
      AppMethodBeat.o(34070);
      return;
    }
  }
  
  private boolean aVN(String paramString)
  {
    AppMethodBeat.i(34069);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        nc localnc = new nc();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = ag.aGd().eK(str);
          if (paramString != null) {
            break label262;
          }
          paramString = new com.tencent.mm.am.a.k();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.nZh;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.Jwf == null) {
            break label265;
          }
          localObject = this.Jwf.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!ag.aGd().b(paramString)) {
            ag.aGd().a(paramString);
          }
          localObject = new nb();
          ((nb)localObject).FHc = paramString.field_userId;
          localnc.FHd.add(localObject);
          i += 1;
          continue;
        }
        a(localnc, null);
        AppMethodBeat.o(34069);
        return true;
      }
      catch (JSONException paramString)
      {
        ad.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", new Object[] { paramString.getMessage() });
        ad.printErrStackTrace("MicroMsg.BizChatroomInfoUI", paramString, "", new Object[0]);
      }
      AppMethodBeat.o(34069);
      return false;
      label262:
      continue;
      label265:
      Object localObject = null;
    }
  }
  
  private void dAK()
  {
    AppMethodBeat.i(34077);
    ad.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.Jwd) {
      this.Jwe = this.Jul.hj(16);
    }
    for (this.FJk = this.Jul.field_bitFlag;; this.FJk = this.wRr.field_bitFlag)
    {
      if (this.fMF != null) {
        this.sp.edit().putBoolean("room_placed_to_the_top", this.Jwe).commit();
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34077);
      return;
      this.Jwe = this.wRr.hj(16);
    }
  }
  
  private void fAa()
  {
    AppMethodBeat.i(34076);
    ad.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.Jwd)
    {
      this.AZY = this.Jul.hj(8);
      this.FJk = this.Jul.field_bitFlag;
      if (!this.AZY) {
        break label165;
      }
      if (this.fME != null) {
        this.sp.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34076);
      return;
      this.AZY = this.wRr.hj(8);
      this.FJk = this.wRr.field_bitFlag;
      break;
      label165:
      if (this.fME != null) {
        this.sp.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void fAb()
  {
    AppMethodBeat.i(34085);
    ad.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.Jul.field_chatName = this.Jwc;
    this.Jul.field_bitFlag = this.FJk;
    this.fMP = this.Jul.hj(1);
    this.AZY = this.Jul.hj(8);
    this.Jwe = this.Jul.hj(16);
    ag.aGb().b(this.Jul);
    if (this.Jwe) {
      ag.aGc().rW(this.Jul.field_bizChatLocalId);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", ag.aGc().rV(this.Jul.field_bizChatLocalId)).commit();
      YE();
      YC();
      dAK();
      fAa();
      Toast.makeText(this, getString(2131762584), 0).show();
      AppMethodBeat.o(34085);
      return;
      if (!this.Jwe) {
        ag.aGc().rX(this.Jul.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    AppMethodBeat.i(34084);
    if (this.fMC != null)
    {
      YE();
      updateTitle();
      YC();
      YB();
      fAa();
      dAK();
      this.fMC.notifyChanged();
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(34084);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(34080);
    if (this.Jwd)
    {
      this.fMO = com.tencent.mm.am.a.e.rY(this.nYO);
      if (this.fMO != 0)
      {
        setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fMO) }));
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
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (paramn.getType() == 1355)
    {
      Object localObject = ((o)paramn).aGu();
      paramn = ((o)paramn).aGv();
      localObject = ag.aGb().Eo(((abr)localObject).Gbn.GrN.FGU);
      if (localObject == null)
      {
        Toast.makeText(aj.getContext(), getString(2131762583), 0).show();
        AppMethodBeat.o(34082);
        return;
      }
      if (this.fromScene == 2)
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Contact_User", paramn.FHb);
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.am.a.c)localObject).field_bizChatLocalId);
        com.tencent.mm.bs.d.f(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        AppMethodBeat.o(34082);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramn.FHb);
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.am.a.c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      localIntent.setClass(this, ChattingUI.class);
      paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahp(), "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramn.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34082);
      return;
    }
    if (paramn.getType() == 1356)
    {
      if (paramInt != 0)
      {
        fAb();
        AppMethodBeat.o(34082);
      }
    }
    else if ((paramn.getType() == 1353) && (paramInt >= 0) && (this.wRr != null))
    {
      this.wRr = ag.aGd().eK(this.wRr.field_userId);
      onDataChanged();
    }
    AppMethodBeat.o(34082);
  }
  
  public final com.tencent.mm.am.a.k acB(int paramInt)
  {
    AppMethodBeat.i(34074);
    if ((this.fMC.getItem(paramInt) instanceof com.tencent.mm.am.a.k))
    {
      com.tencent.mm.am.a.k localk = (com.tencent.mm.am.a.k)this.fMC.getItem(paramInt);
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
    Object localObject = this.Jul.field_ownerUserId;
    this.fMO = this.Jul.aGo().size();
    if (bt.isNullOrNil((String)localObject))
    {
      this.fMM = false;
      localObject = ag.aFZ().DD(this.nZh);
      this.JuU = ag.aGi().Dy(((com.tencent.mm.api.c)localObject).Kv());
      ad.i("MicroMsg.BizChatroomInfoUI", "getMainBrandAttr father %s", new Object[] { ((com.tencent.mm.api.c)localObject).Kv() });
      ad.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.fMC = ((ContactListExpandPreference)this.screen.aVD("roominfo_contact_anchor"));
      this.fMC.a(this.screen, this.fMC.mKey);
      this.fRi = ((SignaturePreference)this.screen.aVD("room_name"));
      this.fMD = ((CheckBoxPreference)this.screen.aVD("room_notify_new_msg"));
      this.fMF = ((CheckBoxPreference)this.screen.aVD("room_placed_to_the_top"));
      this.fME = ((CheckBoxPreference)this.screen.aVD("room_save_to_contact"));
      localObject = this.fMC;
      boolean bool = this.Jwd;
      if (((ContactListExpandPreference)localObject).EWM != null) {
        ((ContactListExpandPreference)localObject).EWM.EWc.EWp = bool;
      }
      localObject = this.fMC;
      bool = this.fMM;
      if (((ContactListExpandPreference)localObject).EWM != null) {
        ((ContactListExpandPreference)localObject).EWM.EWc.EWo = bool;
      }
      if (!this.fMM) {
        break label487;
      }
      this.fMC.vO(true).vP(true);
    }
    for (;;)
    {
      if (this.JuU.field_hide_mod_chat_member) {
        this.fMC.vO(false).vP(false);
      }
      this.fMC.aMV(this.Jul.field_ownerUserId);
      this.fMC.fcJ();
      this.fMC.fcD();
      if (!this.Jwd)
      {
        this.screen.cP("room_save_to_contact", true);
        this.screen.cP("room_name", true);
        this.screen.cP("room_del_quit", true);
      }
      fAa();
      dAK();
      YC();
      if (this.fMC != null)
      {
        getListView().setOnScrollListener(this.fMX);
        this.fMC.a(this.fMX);
        this.fMC.a(new ContactListExpandPreference.a()
        {
          public final void YJ()
          {
            AppMethodBeat.i(34057);
            if (BizChatroomInfoUI.b(BizChatroomInfoUI.this) != null) {
              BizChatroomInfoUI.b(BizChatroomInfoUI.this).fcH();
            }
            AppMethodBeat.o(34057);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            boolean bool = true;
            AppMethodBeat.i(193812);
            paramAnonymousViewGroup = BizChatroomInfoUI.this.acB(paramAnonymousInt);
            if ((paramAnonymousViewGroup == null) || (bt.isNullOrNil(paramAnonymousViewGroup.field_profileUrl)))
            {
              if (paramAnonymousViewGroup == null) {}
              for (;;)
              {
                ad.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
                AppMethodBeat.o(193812);
                return;
                bool = false;
              }
            }
            ad.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { paramAnonymousViewGroup.field_profileUrl });
            ag.aGh();
            com.tencent.mm.am.a.h.a(paramAnonymousViewGroup.field_userId, paramAnonymousViewGroup.field_brandUserName, BizChatroomInfoUI.this);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousViewGroup.field_profileUrl);
            localIntent.putExtra("useJs", true);
            com.tencent.mm.bs.d.b(BizChatroomInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(193812);
          }
          
          public final void lc(int paramAnonymousInt)
          {
            AppMethodBeat.i(34055);
            BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousInt);
            AppMethodBeat.o(34055);
          }
          
          public final void ld(int paramAnonymousInt)
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
      this.fMM = ((String)localObject).equals(ag.aGd().eL(this.nZh));
      break;
      label487:
      this.fMC.vO(true).vP(false);
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
      ad.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
      str = paramIntent.getString("enterprise_members");
      ad.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", new Object[] { str });
      if (this.Jwd) {
        bool = aVN(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(2131762583), 0).show();
        AppMethodBeat.o(34068);
        return;
        att localatt = new att();
        com.tencent.mm.am.a.c localc = new com.tencent.mm.am.a.c();
        if (this.Jwf != null) {}
        for (paramIntent = this.Jwf.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.nZh;
          if (!com.tencent.mm.am.a.e.a(localc, str, this.wRr.field_userId, localatt)) {
            break label265;
          }
          ag.aGh();
          paramIntent = com.tencent.mm.am.a.h.a(this.nZh, localatt, this);
          getString(2131755906);
          this.fMu = com.tencent.mm.ui.base.h.b(this, getString(2131755168), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(34053);
              ba.aiU().a(paramIntent);
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
    ag.aGb().a(this.JuW, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.nZh = getIntent().getStringExtra("Chat_User");
    this.nYO = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.Jul = ag.aGb().bd(this.nYO);
    this.Jwc = this.Jul.field_chatName;
    this.Jwd = com.tencent.mm.am.a.e.Eq(this.Jul.field_bizChatServId);
    if (!this.Jwd) {
      this.wRr = ag.aGd().eK(this.Jul.field_bizChatServId);
    }
    this.Jwf = ag.aGd().EB(this.nZh);
    initView();
    if ((this.Jul == null) || (this.Jul.field_bizChatServId == null) || (this.nZh == null))
    {
      AppMethodBeat.o(34064);
      return;
    }
    if (this.Jul.isGroup())
    {
      ag.aGh();
      com.tencent.mm.am.a.h.bj(this.Jul.field_bizChatServId, this.nZh);
      AppMethodBeat.o(34064);
      return;
    }
    ag.aGh();
    com.tencent.mm.am.a.h.a(this.Jul.field_bizChatServId, this.nZh, this);
    AppMethodBeat.o(34064);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34067);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.ui.h.a.dismiss();
    ag.aGb().a(this.JuW);
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
      if (YF()) {
        paramf = this.Jul.field_chatName;
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
          if (!this.fMP) {}
          for (bool1 = true;; bool1 = false)
          {
            this.fMP = bool1;
            X(this.fMP, 1);
            YC();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.Jwe) {}
          for (;;)
          {
            this.Jwe = bool1;
            X(this.Jwe, 16);
            if (!this.Jwe) {
              break label189;
            }
            ag.aGc().rW(this.Jul.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          ag.aGc().rX(this.Jul.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          ad.d("MicroMsg.BizChatroomInfoUI", " quit " + this.nYO);
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
    if (!this.AZY) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.AZY = bool1;
      X(this.AZY, 8);
      fAa();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34065);
    YE();
    updateTitle();
    YC();
    dAK();
    fAa();
    YB();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.fMY)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bt.isNullOrNil(str))
      {
        final int i = this.screen.aVF(str);
        setSelection(i - 3);
        new ap().postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34052);
            View localView = ((com.tencent.mm.ui.base.preference.a)BizChatroomInfoUI.a(BizChatroomInfoUI.this)).a(i, BizChatroomInfoUI.this.getListView());
            if (localView != null) {
              com.tencent.mm.ui.h.a.c(BizChatroomInfoUI.this.getContext(), localView);
            }
            AppMethodBeat.o(34052);
          }
        }, 10L);
      }
      this.fMY = true;
    }
    AppMethodBeat.o(34065);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34083);
    if (paramn == null)
    {
      ad.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(34083);
      return;
    }
    ad.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    this.fMO = com.tencent.mm.am.a.e.rY(this.nYO);
    ad.d("MicroMsg.BizChatroomInfoUI", "now is " + this.fMO);
    if (this.fMu != null) {
      this.fMu.dismiss();
    }
    paramString = com.tencent.mm.h.a.uz(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(34083);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      fAb();
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