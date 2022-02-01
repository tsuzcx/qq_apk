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
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.d.a;
import com.tencent.mm.al.a.d.a.a;
import com.tencent.mm.al.a.d.a.b;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.a.o;
import com.tencent.mm.al.a.y;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.chatroom.ui.preference.SignaturePreference;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl.a;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.protocal.protobuf.nd;
import com.tencent.mm.protocal.protobuf.ne;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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
  implements com.tencent.mm.ak.f, p
{
  private static boolean fPl = false;
  private boolean Brw;
  private int GbJ;
  private com.tencent.mm.al.d JPK;
  private d.a JPM;
  private com.tencent.mm.al.a.c JPa;
  private String JQS;
  private boolean JQT;
  private boolean JQU;
  private com.tencent.mm.al.a.k JQV;
  private ProgressDialog fOC;
  private ContactListExpandPreference fOK;
  private CheckBoxPreference fOL;
  private CheckBoxPreference fOM;
  private CheckBoxPreference fON;
  private boolean fOU;
  private int fOW;
  private boolean fOX;
  private com.tencent.mm.pluginsdk.ui.e fPf;
  boolean fPg;
  private SignaturePreference fTo;
  private int fromScene;
  private boolean isDeleteCancel;
  private String oeQ;
  private long oex;
  private com.tencent.mm.ui.base.preference.f screen;
  private SharedPreferences sp;
  private com.tencent.mm.al.a.k xhi;
  
  public BizChatroomInfoUI()
  {
    AppMethodBeat.i(34063);
    this.fOC = null;
    this.sp = null;
    this.fOU = false;
    this.JQT = false;
    this.JPa = null;
    this.xhi = null;
    this.JQV = null;
    this.fPf = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(34048);
        com.tencent.mm.av.q.aJb().cp(paramAnonymousInt);
        AppMethodBeat.o(34048);
      }
    });
    this.fPg = false;
    this.isDeleteCancel = false;
    this.JPM = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(34051);
        if ((paramAnonymousb != null) && (paramAnonymousb.hUC != null) && (paramAnonymousb.hUr == BizChatroomInfoUI.g(BizChatroomInfoUI.this)) && (paramAnonymousb.hUB != d.a.a.hUy))
        {
          ae.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
          paramAnonymousb = ag.aGr().bd(BizChatroomInfoUI.g(BizChatroomInfoUI.this));
          BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousb);
          BizChatroomInfoUI.h(BizChatroomInfoUI.this);
        }
        AppMethodBeat.o(34051);
      }
    };
    AppMethodBeat.o(34063);
  }
  
  private void YK()
  {
    AppMethodBeat.i(34075);
    Object localObject;
    if (this.fOK != null)
    {
      if (!this.JQT) {
        break label103;
      }
      localObject = com.tencent.mm.al.a.e.sm(this.oex);
      if (localObject == null) {
        break label128;
      }
      this.fOW = ((List)localObject).size();
      label41:
      if (this.fOW > 1) {
        break label136;
      }
      this.fOK.vW(true).vX(false);
    }
    for (;;)
    {
      if (this.JPK.field_hide_mod_chat_member) {
        this.fOK.vW(false).vX(false);
      }
      this.fOK.B(this.oeQ, (List)localObject);
      AppMethodBeat.o(34075);
      return;
      label103:
      localObject = new LinkedList();
      ((List)localObject).add(this.JPa.field_bizChatServId);
      break;
      label128:
      this.fOW = 0;
      break label41;
      label136:
      this.fOK.vW(true).vX(this.fOU);
    }
  }
  
  private void YL()
  {
    AppMethodBeat.i(34078);
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.JQT)
    {
      this.fOX = this.JPa.hk(1);
      this.GbJ = this.JPa.field_bitFlag;
      if (!this.fOX) {
        break label156;
      }
      setTitleMuteIconVisibility(0);
      if (this.fOL != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34078);
      return;
      this.fOX = this.xhi.hk(1);
      this.GbJ = this.xhi.field_bitFlag;
      break;
      label156:
      setTitleMuteIconVisibility(8);
      if (this.fOL != null) {
        this.sp.edit().putBoolean("room_notify_new_msg", false).commit();
      }
    }
  }
  
  private void YN()
  {
    AppMethodBeat.i(34079);
    if (this.fTo != null)
    {
      if (YO())
      {
        Object localObject2 = this.JPa.field_chatName;
        Object localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 50) {
            localObject1 = ((String)localObject2).substring(0, 32);
          }
        }
        ae.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[] { localObject1 });
        SignaturePreference localSignaturePreference = this.fTo;
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
      this.fTo.setSummary(getString(2131762622));
    }
    AppMethodBeat.o(34079);
  }
  
  private boolean YO()
  {
    AppMethodBeat.i(34081);
    if (this.JQT) {}
    for (String str = this.JPa.field_chatName; bu.isNullOrNil(str); str = this.xhi.field_userName)
    {
      AppMethodBeat.o(34081);
      return false;
    }
    AppMethodBeat.o(34081);
    return true;
  }
  
  private void a(final ne paramne1, ne paramne2)
  {
    AppMethodBeat.i(34070);
    ae.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
    if (paramne1 == null) {}
    for (String str = getString(2131762595);; str = getString(2131755168))
    {
      ag.aGx();
      paramne1 = com.tencent.mm.al.a.h.a(this.JPa.field_brandUserName, this.JPa.field_bizChatServId, paramne1, paramne2, this);
      getString(2131755906);
      this.fOC = com.tencent.mm.ui.base.h.b(this, str, true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34054);
          bc.ajj().a(paramne1);
          AppMethodBeat.o(34054);
        }
      });
      AppMethodBeat.o(34070);
      return;
    }
  }
  
  private boolean aXo(String paramString)
  {
    AppMethodBeat.i(34069);
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        ne localne = new ne();
        int i = 0;
        if (i < localJSONArray.length())
        {
          localObject = localJSONArray.getJSONObject(i);
          String str = ((JSONObject)localObject).getString("id");
          paramString = ag.aGt().eP(str);
          if (paramString != null) {
            break label264;
          }
          paramString = new com.tencent.mm.al.a.k();
          paramString.field_userId = str;
          paramString.field_userName = ((JSONObject)localObject).getString("nick_name");
          paramString.field_brandUserName = this.oeQ;
          paramString.field_headImageUrl = ((JSONObject)localObject).getString("head_img_url");
          paramString.field_profileUrl = ((JSONObject)localObject).getString("profile_url");
          paramString.field_UserVersion = ((JSONObject)localObject).getInt("ver");
          if (this.JQV == null) {
            break label267;
          }
          localObject = this.JQV.field_addMemberUrl;
          paramString.field_addMemberUrl = ((String)localObject);
          if (!ag.aGt().b(paramString)) {
            ag.aGt().a(paramString);
          }
          localObject = new nd();
          ((nd)localObject).FZy = paramString.field_userId;
          localne.FZz.add(localObject);
          i += 1;
          continue;
        }
        a(localne, null);
        AppMethodBeat.o(34069);
        return true;
      }
      catch (JSONException paramString)
      {
        ae.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", new Object[] { paramString.getMessage() });
        ae.printErrStackTrace("MicroMsg.BizChatroomInfoUI", paramString, "", new Object[0]);
      }
      AppMethodBeat.o(34069);
      return false;
      label264:
      continue;
      label267:
      Object localObject = null;
    }
  }
  
  private void ab(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(34073);
    this.GbJ = this.JPa.field_bitFlag;
    this.JQS = this.JPa.field_chatName;
    Object localObject;
    if (this.JQT)
    {
      if (paramBoolean) {
        localObject = this.JPa;
      }
      for (((com.tencent.mm.al.a.c)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.al.a.c)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
      {
        ae.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[] { Integer.valueOf(this.JPa.field_bitFlag) });
        ag.aGr().b(this.JPa);
        localObject = new nb();
        ((nb)localObject).FZq = this.JPa.field_bizChatServId;
        ((nb)localObject).FZs = this.JPa.field_bitFlag;
        ag.aGx();
        com.tencent.mm.al.a.h.a(this.JPa.field_brandUserName, (nb)localObject, this);
        AppMethodBeat.o(34073);
        return;
        localObject = this.JPa;
      }
    }
    if (paramBoolean) {
      localObject = this.xhi;
    }
    for (((com.tencent.mm.al.a.k)localObject).field_bitFlag |= paramInt;; ((com.tencent.mm.al.a.k)localObject).field_bitFlag &= (paramInt ^ 0xFFFFFFFF))
    {
      ag.aGt().b(this.xhi);
      this.JPa.field_bitFlag = this.xhi.field_bitFlag;
      ag.aGr().b(this.JPa);
      break;
      localObject = this.xhi;
    }
  }
  
  private void dEb()
  {
    AppMethodBeat.i(34077);
    ae.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.JQT) {
      this.JQU = this.JPa.hk(16);
    }
    for (this.GbJ = this.JPa.field_bitFlag;; this.GbJ = this.xhi.field_bitFlag)
    {
      if (this.fON != null) {
        this.sp.edit().putBoolean("room_placed_to_the_top", this.JQU).commit();
      }
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34077);
      return;
      this.JQU = this.xhi.hk(16);
    }
  }
  
  private void fEc()
  {
    AppMethodBeat.i(34076);
    ae.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
    if (this.sp == null) {
      this.sp = getSharedPreferences(getPackageName() + "_preferences", 0);
    }
    if (this.JQT)
    {
      this.Brw = this.JPa.hk(8);
      this.GbJ = this.JPa.field_bitFlag;
      if (!this.Brw) {
        break label165;
      }
      if (this.fOM != null) {
        this.sp.edit().putBoolean("room_save_to_contact", true).commit();
      }
    }
    for (;;)
    {
      this.screen.notifyDataSetChanged();
      AppMethodBeat.o(34076);
      return;
      this.Brw = this.xhi.hk(8);
      this.GbJ = this.xhi.field_bitFlag;
      break;
      label165:
      if (this.fOM != null) {
        this.sp.edit().putBoolean("room_save_to_contact", false).commit();
      }
    }
  }
  
  private void fEd()
  {
    AppMethodBeat.i(34085);
    ae.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
    this.JPa.field_chatName = this.JQS;
    this.JPa.field_bitFlag = this.GbJ;
    this.fOX = this.JPa.hk(1);
    this.Brw = this.JPa.hk(8);
    this.JQU = this.JPa.hk(16);
    ag.aGr().b(this.JPa);
    if (this.JQU) {
      ag.aGs().sj(this.JPa.field_bizChatLocalId);
    }
    for (;;)
    {
      this.sp.edit().putBoolean("room_placed_to_the_top", ag.aGs().si(this.JPa.field_bizChatLocalId)).commit();
      YN();
      YL();
      dEb();
      fEc();
      Toast.makeText(this, getString(2131762584), 0).show();
      AppMethodBeat.o(34085);
      return;
      if (!this.JQU) {
        ag.aGs().sk(this.JPa.field_bizChatLocalId);
      }
    }
  }
  
  private void onDataChanged()
  {
    AppMethodBeat.i(34084);
    if (this.fOK != null)
    {
      YN();
      updateTitle();
      YL();
      YK();
      fEc();
      dEb();
      this.fOK.notifyChanged();
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(34084);
  }
  
  private void updateTitle()
  {
    AppMethodBeat.i(34080);
    if (this.JQT)
    {
      this.fOW = com.tencent.mm.al.a.e.sl(this.oex);
      if (this.fOW != 0)
      {
        setMMTitle(getString(2131759496, new Object[] { getString(2131762729), Integer.valueOf(this.fOW) }));
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
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (paramn.getType() == 1355)
    {
      Object localObject = ((o)paramn).aGK();
      paramn = ((o)paramn).aGL();
      localObject = ag.aGr().EQ(((aca)localObject).GtU.GLl.FZq);
      if (localObject == null)
      {
        Toast.makeText(ak.getContext(), getString(2131762583), 0).show();
        AppMethodBeat.o(34082);
        return;
      }
      if (this.fromScene == 2)
      {
        localIntent = new Intent();
        localIntent.addFlags(67108864);
        localIntent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
        localIntent.putExtra("Contact_User", paramn.FZx);
        localIntent.putExtra("biz_chat_chat_id", ((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
        com.tencent.mm.br.d.f(this, ".ui.bizchat.BizChatConversationUI", localIntent);
        AppMethodBeat.o(34082);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", paramn.FZx);
      localIntent.putExtra("key_biz_chat_id", ((com.tencent.mm.al.a.c)localObject).field_bizChatLocalId);
      localIntent.putExtra("finish_direct", true);
      localIntent.putExtra("key_need_send_video", false);
      localIntent.putExtra("key_is_biz_chat", true);
      localIntent.setClass(this, ChattingUI.class);
      paramn = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramn.ahE(), "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramn.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatroomInfoUI", "onBizChatSceneEnd", "(ILcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(34082);
      return;
    }
    if (paramn.getType() == 1356)
    {
      if (paramInt != 0)
      {
        fEd();
        AppMethodBeat.o(34082);
      }
    }
    else if ((paramn.getType() == 1353) && (paramInt >= 0) && (this.xhi != null))
    {
      this.xhi = ag.aGt().eP(this.xhi.field_userId);
      onDataChanged();
    }
    AppMethodBeat.o(34082);
  }
  
  public final com.tencent.mm.al.a.k adj(int paramInt)
  {
    AppMethodBeat.i(34074);
    if ((this.fOK.getItem(paramInt) instanceof com.tencent.mm.al.a.k))
    {
      com.tencent.mm.al.a.k localk = (com.tencent.mm.al.a.k)this.fOK.getItem(paramInt);
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
    Object localObject = this.JPa.field_ownerUserId;
    this.fOW = this.JPa.aGE().size();
    if (bu.isNullOrNil((String)localObject))
    {
      this.fOU = false;
      localObject = ag.aGp().Ef(this.oeQ);
      this.JPK = ag.aGy().Ea(((com.tencent.mm.api.c)localObject).KD());
      ae.i("MicroMsg.BizChatroomInfoUI", "getMainBrandAttr father %s", new Object[] { ((com.tencent.mm.api.c)localObject).KD() });
      ae.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
      this.fOK = ((ContactListExpandPreference)this.screen.aXe("roominfo_contact_anchor"));
      this.fOK.a(this.screen, this.fOK.mKey);
      this.fTo = ((SignaturePreference)this.screen.aXe("room_name"));
      this.fOL = ((CheckBoxPreference)this.screen.aXe("room_notify_new_msg"));
      this.fON = ((CheckBoxPreference)this.screen.aXe("room_placed_to_the_top"));
      this.fOM = ((CheckBoxPreference)this.screen.aXe("room_save_to_contact"));
      localObject = this.fOK;
      boolean bool = this.JQT;
      if (((ContactListExpandPreference)localObject).Fph != null) {
        ((ContactListExpandPreference)localObject).Fph.Fox.FoK = bool;
      }
      localObject = this.fOK;
      bool = this.fOU;
      if (((ContactListExpandPreference)localObject).Fph != null) {
        ((ContactListExpandPreference)localObject).Fph.Fox.FoJ = bool;
      }
      if (!this.fOU) {
        break label488;
      }
      this.fOK.vW(true).vX(true);
    }
    for (;;)
    {
      if (this.JPK.field_hide_mod_chat_member) {
        this.fOK.vW(false).vX(false);
      }
      this.fOK.aOr(this.JPa.field_ownerUserId);
      this.fOK.fgx();
      this.fOK.fgr();
      if (!this.JQT)
      {
        this.screen.cT("room_save_to_contact", true);
        this.screen.cT("room_name", true);
        this.screen.cT("room_del_quit", true);
      }
      fEc();
      dEb();
      YL();
      if (this.fOK != null)
      {
        getListView().setOnScrollListener(this.fPf);
        this.fOK.a(this.fPf);
        this.fOK.a(new ContactListExpandPreference.a()
        {
          public final void YS()
          {
            AppMethodBeat.i(34057);
            if (BizChatroomInfoUI.b(BizChatroomInfoUI.this) != null) {
              BizChatroomInfoUI.b(BizChatroomInfoUI.this).fgv();
            }
            AppMethodBeat.o(34057);
          }
          
          public final void e(ViewGroup paramAnonymousViewGroup, int paramAnonymousInt)
          {
            boolean bool = true;
            AppMethodBeat.i(187108);
            paramAnonymousViewGroup = BizChatroomInfoUI.this.adj(paramAnonymousInt);
            if ((paramAnonymousViewGroup == null) || (bu.isNullOrNil(paramAnonymousViewGroup.field_profileUrl)))
            {
              if (paramAnonymousViewGroup == null) {}
              for (;;)
              {
                ae.w("MicroMsg.BizChatroomInfoUI", "onItemNormalClick userInfo == null:%s", new Object[] { Boolean.valueOf(bool) });
                AppMethodBeat.o(187108);
                return;
                bool = false;
              }
            }
            ae.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[] { paramAnonymousViewGroup.field_profileUrl });
            ag.aGx();
            com.tencent.mm.al.a.h.a(paramAnonymousViewGroup.field_userId, paramAnonymousViewGroup.field_brandUserName, BizChatroomInfoUI.this);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousViewGroup.field_profileUrl);
            localIntent.putExtra("useJs", true);
            com.tencent.mm.br.d.b(BizChatroomInfoUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(187108);
          }
          
          public final void le(int paramAnonymousInt)
          {
            AppMethodBeat.i(34055);
            BizChatroomInfoUI.a(BizChatroomInfoUI.this, paramAnonymousInt);
            AppMethodBeat.o(34055);
          }
          
          public final void lf(int paramAnonymousInt)
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
      this.fOU = ((String)localObject).equals(ag.aGt().eQ(this.oeQ));
      break;
      label488:
      this.fOK.vW(true).vX(false);
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
      ae.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
      str = paramIntent.getString("enterprise_members");
      ae.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", new Object[] { str });
      if (this.JQT) {
        bool = aXo(str);
      }
    }
    for (;;)
    {
      if (!bool)
      {
        Toast.makeText(this, getString(2131762583), 0).show();
        AppMethodBeat.o(34068);
        return;
        auj localauj = new auj();
        com.tencent.mm.al.a.c localc = new com.tencent.mm.al.a.c();
        if (this.JQV != null) {}
        for (paramIntent = this.JQV.field_addMemberUrl;; paramIntent = null)
        {
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.oeQ;
          if (!com.tencent.mm.al.a.e.a(localc, str, this.xhi.field_userId, localauj)) {
            break label267;
          }
          ag.aGx();
          paramIntent = com.tencent.mm.al.a.h.a(this.oeQ, localauj, this);
          getString(2131755906);
          this.fOC = com.tencent.mm.ui.base.h.b(this, getString(2131755168), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(34053);
              bc.ajj().a(paramIntent);
              AppMethodBeat.o(34053);
            }
          });
          bool = true;
          break;
        }
        label267:
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
    ag.aGr().a(this.JPM, Looper.getMainLooper());
    this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
    this.oeQ = getIntent().getStringExtra("Chat_User");
    this.oex = getIntent().getLongExtra("key_biz_chat_id", -1L);
    this.JPa = ag.aGr().bd(this.oex);
    this.JQS = this.JPa.field_chatName;
    this.JQT = com.tencent.mm.al.a.e.ES(this.JPa.field_bizChatServId);
    if (!this.JQT) {
      this.xhi = ag.aGt().eP(this.JPa.field_bizChatServId);
    }
    this.JQV = ag.aGt().Fd(this.oeQ);
    initView();
    if ((this.JPa == null) || (this.JPa.field_bizChatServId == null) || (this.oeQ == null))
    {
      AppMethodBeat.o(34064);
      return;
    }
    if (this.JPa.isGroup())
    {
      ag.aGx();
      com.tencent.mm.al.a.h.bj(this.JPa.field_bizChatServId, this.oeQ);
      AppMethodBeat.o(34064);
      return;
    }
    ag.aGx();
    com.tencent.mm.al.a.h.a(this.JPa.field_bizChatServId, this.oeQ, this);
    AppMethodBeat.o(34064);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34067);
    com.tencent.mm.ui.h.a.dismiss();
    com.tencent.mm.ui.h.a.dismiss();
    ag.aGr().a(this.JPM);
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
      if (YO()) {
        paramf = this.JPa.field_chatName;
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
    label188:
    do
    {
      for (;;)
      {
        AppMethodBeat.o(34072);
        return false;
        if (paramf.equals("room_notify_new_msg"))
        {
          if (!this.fOX) {}
          for (bool1 = true;; bool1 = false)
          {
            this.fOX = bool1;
            ab(this.fOX, 1);
            YL();
            break;
          }
        }
        if (paramf.equals("room_placed_to_the_top"))
        {
          if (!this.JQU) {}
          for (;;)
          {
            this.JQU = bool1;
            ab(this.JQU, 16);
            if (!this.JQU) {
              break label188;
            }
            ag.aGs().sj(this.JPa.field_bizChatLocalId);
            break;
            bool1 = false;
          }
          ag.aGs().sk(this.JPa.field_bizChatLocalId);
        }
        else
        {
          if (!paramf.equals("room_del_quit")) {
            break;
          }
          ae.d("MicroMsg.BizChatroomInfoUI", " quit " + this.oex);
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
    if (!this.Brw) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.Brw = bool1;
      ab(this.Brw, 8);
      fEc();
      break;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34065);
    YN();
    updateTitle();
    YL();
    dEb();
    fEc();
    YK();
    this.screen.notifyDataSetChanged();
    super.onResume();
    if (!this.fPg)
    {
      String str = getIntent().getStringExtra("need_matte_high_light_item");
      if (!bu.isNullOrNil(str))
      {
        final int i = this.screen.aXg(str);
        setSelection(i - 3);
        new aq().postDelayed(new Runnable()
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
      this.fPg = true;
    }
    AppMethodBeat.o(34065);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34083);
    if (paramn == null)
    {
      ae.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(34083);
      return;
    }
    ae.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    this.fOW = com.tencent.mm.al.a.e.sl(this.oex);
    ae.d("MicroMsg.BizChatroomInfoUI", "now is " + this.fOW);
    if (this.fOC != null) {
      this.fOC.dismiss();
    }
    paramString = com.tencent.mm.h.a.uU(paramString);
    if (paramString != null)
    {
      paramString.a(this, null, null);
      AppMethodBeat.o(34083);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
      fEd();
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