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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.am.a.b;
import com.tencent.mm.am.a.d.a;
import com.tencent.mm.am.a.d.a.a;
import com.tencent.mm.am.a.d.a.b;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.a.y;
import com.tencent.mm.am.af;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements g, com.tencent.mm.am.o
{
  private static boolean fqy = false;
  private int CKC;
  private com.tencent.mm.am.a.c GgE;
  private com.tencent.mm.am.c Gho;
  private d.a Ghq;
  private String Giw;
  private boolean Gix;
  private boolean Giy;
  private com.tencent.mm.am.a.k Giz;
  private ProgressDialog fpP;
  private ContactListExpandPreference fpW;
  private CheckBoxPreference fpX;
  private CheckBoxPreference fpY;
  private CheckBoxPreference fpZ;
  private boolean fqg;
  private int fqi;
  private boolean fqj;
  private com.tencent.mm.pluginsdk.ui.d fqs;
  boolean fqt;
  private int fromScene;
  private SignaturePreference fuo;
  private boolean isDeleteCancel;
  private long mUQ;
  private String mVj;
  private f screen;
  private SharedPreferences sp;
  private com.tencent.mm.am.a.k uBp;
  private boolean yvf;
  
  public BizChatroomInfoUI()
  {
    AppMethodBeat.i(34063);
    this.fpP = null;
    this.sp = null;
    this.fqg = false;
    this.Gix = false;
    this.GgE = null;
    this.uBp = null;
    this.Giz = null;
    this.fqs = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34048);
        com.tencent.mm.aw.o.ayJ().cq(paramAnonymousInt);
        AppMethodBeat.o(34048);
      }
    });
    this.fqt = false;
    this.isDeleteCancel = false;
    this.Ghq = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(34051);
        if ((paramAnonymousb != null) && (paramAnonymousb.gYQ != null) && (paramAnonymousb.gYF == BizChatroomInfoUI.g(BizChatroomInfoUI.this)) && (paramAnonymousb.gYP != d.a.a.gYM))
        {
          ad.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
          paramAnonymousb = af.awg().bg(BizChatroomInfoUI.g(BizChatroomInfoUI.this));
          BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousb);
          BizChatroomInfoUI.h(BizChatroomInfoUI.this);
        }
        AppMethodBeat.o(34051);
      }
    };
    AppMethodBeat.o(34063);
  }
  
  private void T(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(34073);
    this.CKC = this.GgE.field_bitFlag;
    this.Giw = this.GgE.field_chatName;
    Object localObject;
    if (this.Gix)
    {
      if (paramBoolean) {
        localObject = this.GgE;
      }
      for (((com.tencent.mm.am.a.c)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.am.a.c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        ad.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.GgE.field_bitFlag) });
        af.awg().b(this.GgE);
        localObject = new md();
        ((md)localObject).CIJ = this.GgE.field_bizChatServId;
        ((md)localObject).CIL = this.GgE.field_bitFlag;
        af.awm();
        com.tencent.mm.am.a.h.a(this.GgE.field_brandUserName, (md)localObject, this);
        AppMethodBeat.o(34073);
        return;
        localObject = this.GgE;
      }
    }
    if (paramBoolean) {
      localObject = this.uBp;
    }
    for (((com.tencent.mm.am.a.k)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.am.a.k)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      af.awi().b(this.uBp);
      this.GgE.field_bitFlag = this.uBp.field_bitFlag;
      af.awg().b(this.GgE);
      break;
      localObject = this.uBp;
    }
  }
  
  private void Vj()
  {
    AppMethodBeat.i(34075);
    Object localObject;
    if (this.fpW != null)
    {
      if (!this.Gix) {
        break label103;
      }
      localObject = com.tencent.mm.am.a.e.mm(this.mUQ);
      if (localObject == null) {
        break label128;
      }
      this.fqi = ((List)localObject).size();
      label41:
      if (this.fqi > 1) {
        break label136;
      }
      this.fpW.ub(true).uc(false);
    }
    for (;;)
    {
      if (this.Gho.field_hide_mod_chat_member) {
        this.fpW.ub(false).uc(false);
      }
      this.fpW.B(this.mVj, (List)localObject);
      AppMethodBeat.o(34075);
      return;
      label103:
      localObject = new LinkedList();
      ((List)localObject).add(this.GgE.field_bizChatServId);
      break;
      label128:
      this.fqi = 0;
      break label41;
      label136:
      this.fpW.ub(true).uc(this.fqg);
    }
  }
  
  private void Vk()
  {
    AppMethodBeat.i(34078);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.Gix)
    {
      this.fqj = this.GgE.ht(1);
      this.CKC = this.GgE.field_bitFlag;
      if (!this.fqj) {
        break label158;
      }
      setTitleMuteIconVisibility(0);
      if (this.fpX != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34078);
      return;
      this.fqj = this.uBp.ht(1);
      this.CKC = this.uBp.field_bitFlag;
      break;
      label158:
      setTitleMuteIconVisibility(8);
      if (this.fpX != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void Vm()
  {
    AppMethodBeat.i(34079);
    if (this.fuo != null)
    {
      if (Vn())
      {
        Object localObject2 = this.GgE.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        ad.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.fuo;
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
      this.fuo.setSummary(getString(2131762622));
    }
    AppMethodBeat.o(34079);
  }
  
  private boolean Vn()
  {
    AppMethodBeat.i(34081);
    if (this.Gix) {}
    for (String str = this.GgE.field_chatName; bt.isNullOrNil(str); str = this.uBp.field_userName)
    {
      AppMethodBeat.o(34081);
      return false;
    }
    AppMethodBeat.o(34081);
    return true;
  }
  
  private void a(final mg parammg1, mg parammg2)
  {
    AppMethodBeat.i(34070);
    ad.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (parammg1 == null) {}
    for (String str = getString(2131762595);; str = getString(2131755168))
    {
      af.awm();
      parammg1 = com.tencent.mm.am.a.h.a(this.GgE.field_brandUserName, this.GgE.field_bizChatServId, parammg1, parammg2, this);
      getString(2131755906);
      this.fpP = com.tencent.mm.ui.base.h.b(this, str, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34054);
          az.aeS().a(parammg1);
          AppMethodBeat.o(34054);
        }
      });
      AppMethodBeat.o(34070);
      return;
    }
  }
  
  private boolean aKu(String paramString)
  {
    AppMethodBeat.i(34069);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        mg localmg = new mg();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = af.awi().ea(str);
          if (paramString != null) {
            break label262;
          }
          paramString = new com.tencent.mm.am.a.k();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.mVj;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.Giz == null) {
            break label265;
          }
          localObject = this.Giz.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!af.awi().b(paramString)) {
            af.awi().a(paramString);
          }
          localObject = new mf();
          ((mf)localObject).CIR = paramString.field_userId;
          localmg.CIS.add(localObject);
          i += 1;
          continue;
        }
        a(localmg, null);
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
  
  private void dcz()
  {
    AppMethodBeat.i(34077);
    ad.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.Gix) {
      this.Giy = this.GgE.ht(16);
    }
    for (this.CKC = this.GgE.field_bitFlag;; this.CKC = this.uBp.field_bitFlag)
    {
      if (this.fpZ != null) {
        this.sp.edit().putBoolean("room_placed_to_the_top", this.Giy).commit();
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34077);
      return;
      this.Giy = this.uBp.ht(16);
    }
  }
  
  private void eTY()
  {
    AppMethodBeat.i(34076);
    ad.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.Gix)
    {
      this.yvf = this.GgE.ht(8);
      this.CKC = this.GgE.field_bitFlag;
      if (!this.yvf) {
        break label165;
      }
      if (this.fpY != null) {
        this.sp.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34076);
      return;
      this.yvf = this.uBp.ht(8);
      this.CKC = this.uBp.field_bitFlag;
      break;
      label165:
      if (this.fpY != null) {
        this.sp.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void eTZ()
  {
    AppMethodBeat.i(34085);
    ad.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.GgE.field_chatName = this.Giw;
    this.GgE.field_bitFlag = this.CKC;
    this.fqj = this.GgE.ht(1);
    this.yvf = this.GgE.ht(8);
    this.Giy = this.GgE.ht(16);
    af.awg().b(this.GgE);
    if (this.Giy) {
      af.awh().mj(this.GgE.field_bizChatLocalId);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", af.awh().mi(this.GgE.field_bizChatLocalId)).commit();
      Vm();
      Vk();
      dcz();
      eTY();
      Toast.makeText(this, getString(2131762584), 0).show();
      AppMethodBeat.o(34085);
      return;
      if (!this.Giy) {
        af.awh().mk(this.GgE.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    AppMethodBeat.i(34084);
    if (this.fpW != null)
    {
      Vm();
      updateTitle();
      Vk();
      Vj();
      eTY();
      dcz();
      this.fpW.notifyChanged();
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(34084);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(34080);
    if (this.Gix)
    {
      this.fqi = com.tencent.mm.am.a.e.ml(this.mUQ);
      if (this.fqi != 0)
      {
        setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fqi) }));
        AppMethodBeat.o(34080);
        return;
      }
    }
    setMMTitle(getString(2131762729));
    AppMethodBeat.o(34080);
  }
  
  public final com.tencent.mm.am.a.k Yg(int paramInt)
  {
    AppMethodBeat.i(34074);
    if ((this.fpW.getItem(paramInt) instanceof com.tencent.mm.am.a.k))
    {
      com.tencent.mm.am.a.k localk = (com.tencent.mm.am.a.k)this.fpW.getItem(paramInt);
      AppMethodBeat.o(34074);
      return localk;
    }
    AppMethodBeat.o(34074);
    return null;
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(34082);
    if (this.fpP != null)
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    if (paramn.getType() == 1355)
    {
      Object localObject = ((com.tencent.mm.am.a.o)paramn).awz();
      paramn = ((com.tencent.mm.am.a.o)paramn).awA();
      localObject = af.awg().xj(((yw)localObject).DaY.DnW.CIJ);
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
        localIntent.putExtra("Contact_User", paramn.CIQ);
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.am.a.c)localObject).field_bizChatLocalId);
        com.tencent.mm.bs.d.e(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        AppMethodBeat.o(34082);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramn.CIQ);
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.am.a.c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      localIntent.setClass(this, ChattingUI.class);
      paramn = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramn.adn(), "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramn.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34082);
      return;
    }
    if (paramn.getType() == 1356)
    {
      if (paramInt != 0)
      {
        eTZ();
        AppMethodBeat.o(34082);
      }
    }
    else if ((paramn.getType() == 1353) && (paramInt >= 0) && (this.uBp != null))
    {
      this.uBp = af.awi().ea(this.uBp.field_userId);
      onDataChanged();
    }
    AppMethodBeat.o(34082);
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
    Object localObject = this.GgE.field_ownerUserId;
    this.fqi = this.GgE.awt().size();
    if (bt.isNullOrNil((String)localObject))
    {
      this.fqg = false;
      localObject = af.awe().wy(this.mVj);
      this.Gho = af.awn().wt(((com.tencent.mm.api.c)localObject).Jm());
      ad.i("MicroMsg.BizChatroomInfoUI", "getMainBrandAttr father %s", new Object[] { ((com.tencent.mm.api.c)localObject).Jm() });
      ad.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.fpW = ((ContactListExpandPreference)this.screen.aKk("roominfo_contact_anchor"));
      this.fpW.a(this.screen, this.fpW.mKey);
      this.fuo = ((SignaturePreference)this.screen.aKk("room_name"));
      this.fpX = ((CheckBoxPreference)this.screen.aKk("room_notify_new_msg"));
      this.fpZ = ((CheckBoxPreference)this.screen.aKk("room_placed_to_the_top"));
      this.fpY = ((CheckBoxPreference)this.screen.aKk("room_save_to_contact"));
      localObject = this.fpW;
      boolean bool = this.Gix;
      if (((ContactListExpandPreference)localObject).BZr != null) {
        ((ContactListExpandPreference)localObject).BZr.BYH.BYU = bool;
      }
      localObject = this.fpW;
      bool = this.fqg;
      if (((ContactListExpandPreference)localObject).BZr != null) {
        ((ContactListExpandPreference)localObject).BZr.BYH.BYT = bool;
      }
      if (!this.fqg) {
        break label487;
      }
      this.fpW.ub(true).uc(true);
    }
    for (;;)
    {
      if (this.Gho.field_hide_mod_chat_member) {
        this.fpW.ub(false).uc(false);
      }
      this.fpW.aCa(this.GgE.field_ownerUserId);
      this.fpW.eyq();
      this.fpW.eyk();
      if (!this.Gix)
      {
        this.screen.cE("room_save_to_contact", true);
        this.screen.cE("room_name", true);
        this.screen.cE("room_del_quit", true);
      }
      eTY();
      dcz();
      Vk();
      if (this.fpW != null)
      {
        getListView().setOnScrollListener(this.fqs);
        this.fpW.a(this.fqs);
        this.fpW.a(new ContactListExpandPreference.a()
        {
          public final void b(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(204944);
            BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousInt);
            AppMethodBeat.o(204944);
          }
          
          public final void c(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            boolean bool = true;
            AppMethodBeat.i(204945);
            paramAnonymousViewGroup = BizChatroomInfoUI.this.Yg(paramAnonymousInt);
            if ((paramAnonymousViewGroup == null) || (bt.isNullOrNil(paramAnonymousViewGroup.field_profileUrl)))
            {
              if (paramAnonymousViewGroup == null) {}
              for (;;)
              {
                ad.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
                AppMethodBeat.o(204945);
                return;
                bool = false;
              }
            }
            ad.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { paramAnonymousViewGroup.field_profileUrl });
            af.awm();
            com.tencent.mm.am.a.h.a(paramAnonymousViewGroup.field_userId, paramAnonymousViewGroup.field_brandUserName, BizChatroomInfoUI.this);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", paramAnonymousViewGroup.field_profileUrl);
            paramAnonymousView.putExtra("useJs", true);
            com.tencent.mm.bs.d.b(BizChatroomInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            AppMethodBeat.o(204945);
          }
          
          public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView) {}
          
          public final void d(ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
          {
            AppMethodBeat.i(204947);
            BizChatroomInfoUI.c(BizChatroomInfoUI.this);
            AppMethodBeat.o(204947);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, View paramAnonymousView)
          {
            AppMethodBeat.i(204946);
            if (BizChatroomInfoUI.b(BizChatroomInfoUI.this) != null) {
              BizChatroomInfoUI.b(BizChatroomInfoUI.this).eyo();
            }
            AppMethodBeat.o(204946);
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
      this.fqg = ((String)localObject).equals(af.awi().eb(this.mVj));
      break;
      label487:
      this.fpW.ub(true).uc(false);
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
      if (this.Gix) {
        bool = aKu(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(2131762583), 0).show();
        AppMethodBeat.o(34068);
        return;
        amv localamv = new amv();
        com.tencent.mm.am.a.c localc = new com.tencent.mm.am.a.c();
        if (this.Giz != null) {}
        for (paramIntent = this.Giz.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.mVj;
          if (!com.tencent.mm.am.a.e.a(localc, str, this.uBp.field_userId, localamv)) {
            break label265;
          }
          af.awm();
          paramIntent = com.tencent.mm.am.a.h.a(this.mVj, localamv, this);
          getString(2131755906);
          this.fpP = com.tencent.mm.ui.base.h.b(this, getString(2131755168), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(34053);
              az.aeS().a(paramIntent);
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
    af.awg().a(this.Ghq, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.mVj = getIntent().getStringExtra("Chat_User");
    this.mUQ = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.GgE = af.awg().bg(this.mUQ);
    this.Giw = this.GgE.field_chatName;
    this.Gix = com.tencent.mm.am.a.e.xl(this.GgE.field_bizChatServId);
    if (!this.Gix) {
      this.uBp = af.awi().ea(this.GgE.field_bizChatServId);
    }
    this.Giz = af.awi().xw(this.mVj);
    initView();
    if ((this.GgE == null) || (this.GgE.field_bizChatServId == null) || (this.mVj == null))
    {
      AppMethodBeat.o(34064);
      return;
    }
    if (this.GgE.isGroup())
    {
      af.awm();
      com.tencent.mm.am.a.h.ba(this.GgE.field_bizChatServId, this.mVj);
      AppMethodBeat.o(34064);
      return;
    }
    af.awm();
    com.tencent.mm.am.a.h.a(this.GgE.field_bizChatServId, this.mVj, this);
    AppMethodBeat.o(34064);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34067);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.ui.h.a.dismiss();
    af.awg().a(this.Ghq);
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
      if (Vn()) {
        paramf = this.GgE.field_chatName;
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
          if (!this.fqj) {}
          for (bool1 = true;; bool1 = false)
          {
            this.fqj = bool1;
            T(this.fqj, 1);
            Vk();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.Giy) {}
          for (;;)
          {
            this.Giy = bool1;
            T(this.Giy, 16);
            if (!this.Giy) {
              break label189;
            }
            af.awh().mj(this.GgE.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          af.awh().mk(this.GgE.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          ad.d("MicroMsg.BizChatroomInfoUI", " quit " + this.mUQ);
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
    if (!this.yvf) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.yvf = bool1;
      T(this.yvf, 8);
      eTY();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34065);
    Vm();
    updateTitle();
    Vk();
    dcz();
    eTY();
    Vj();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.fqt)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bt.isNullOrNil(str))
      {
        final int i = this.screen.aKm(str);
        setSelection(i - 3);
        new ap().postDelayed(new Runnable()
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
      this.fqt = true;
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
    this.fqi = com.tencent.mm.am.a.e.ml(this.mUQ);
    ad.d("MicroMsg.BizChatroomInfoUI", "now is " + this.fqi);
    if (this.fpP != null) {
      this.fpP.dismiss();
    }
    paramString = com.tencent.mm.h.a.oG(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(34083);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      eTZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatroomInfoUI
 * JD-Core Version:    0.7.0.1
 */