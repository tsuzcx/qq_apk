package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.k.f;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.cc.f;
import junit.framework.Assert;

public final class a
  implements AdapterView.OnItemClickListener
{
  private b SFJ;
  private Context context;
  private boolean otH = false;
  
  public a(Context paramContext, b paramb, boolean paramBoolean)
  {
    this.context = paramContext;
    this.SFJ = paramb;
    this.otH = paramBoolean;
  }
  
  private static void a(Context paramContext, bn parambn, bp parambp, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292044);
    String str = parambp.field_msgContent;
    Log.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      AppMethodBeat.o(292044);
      return;
    }
    bh.bCz();
    cc.f localf = com.tencent.mm.model.c.bzD().aLT(str);
    Intent localIntent;
    if ((localf != null) && (!Util.isNullOrNil(localf.hgk)))
    {
      boolean bool;
      au localau;
      label251:
      int j;
      if (localf.hgk.length() > 0)
      {
        bool = true;
        Assert.assertTrue(bool);
        bh.bCz();
        localau = com.tencent.mm.model.c.bzA().JE(localf.hgk);
        localIntent = new Intent();
        if (paramBoolean1 == true) {
          localIntent.putExtra("Accept_NewFriend_FromOutside", true);
        }
        localIntent.putExtra("Contact_ShowUserName", false);
        localIntent.putExtra("Contact_ShowFMessageList", true);
        localIntent.putExtra("Contact_Scene", localf.scene);
        localIntent.putExtra("Verify_ticket", localf.pPi);
        localIntent.putExtra("Contact_Source_FMessage", localf.scene);
        if (((parambp.field_isSend != 1) || (parambp.field_type != 1)) && ((!parambp.jbg()) || (parambp.field_type != 3)) && ((parambp.field_isSend != 1) || (parambp.field_type != 2))) {
          break label989;
        }
        localIntent.putExtra("Contact_Conversation_IsSelfSendAdd", true);
        if ((parambn != null) && (!com.tencent.mm.contact.d.rs(localau.field_type)))
        {
          l = com.tencent.mm.k.i.aRC().getInt("VerifyUserTicketTimeExceed", 259200) * 1000L;
          Log.i("MicroMsg.FConversationOnItemClickListener", "expired time , defaultExpireTime = ".concat(String.valueOf(l)));
          if (((parambn.field_state != 0) && (parambn.field_state != 2)) || (cn.bDv() - parambn.field_lastModifiedTime < l)) {
            break label1047;
          }
          i = 1;
          label330:
          if ((au.bwO(localau.field_username)) && (i != 0))
          {
            localIntent.putExtra("Contact_Conversation_IsExpireTimeAndOpenIm", true);
            Log.i("MicroMsg.FConversationOnItemClickListener", "dealVerifyMsg is openim need hide reply.");
          }
        }
        if (au.bwO(localau.field_username))
        {
          paramBoolean2 = true;
          Log.i("MicroMsg.FConversationOnItemClickListener", "dealVerifyMsg is openim need hide reply.");
        }
        localIntent.putExtra("Contact_Conversation_IsFromNewFriendToProfile", true);
        localIntent.putExtra("Contact_Conversation_IsForceHideReplyBtn", paramBoolean2);
        j = 0;
        i = 0;
        if ((localau == null) || ((int)localau.maN <= 0) || (!com.tencent.mm.contact.d.rs(localau.field_type))) {
          break label1053;
        }
        localIntent.putExtra("Contact_User", localau.field_username);
        com.tencent.mm.plugin.subapp.a.pFo.a(localIntent, localau.field_username);
        localIntent.putExtra("Contact_Conversation_IsContact", true);
        j = i;
        label474:
        str = localf.content;
        parambp = str;
        if (Util.nullAsNil(str).length() <= 0) {}
        switch (localf.scene)
        {
        case 19: 
        case 20: 
        case 21: 
        default: 
          parambp = paramContext.getString(R.l.gxw);
          label572:
          localIntent.putExtra("Contact_Content", parambp);
          if ((localf.adkR == 1) && (!Util.isNullOrNil(localf.adkT))) {
            localIntent.putExtra("Safety_Warning_Detail", localf.adkT);
          }
          localIntent.putExtra("Contact_verify_Scene", localf.scene);
          if (((localf.scene == 14) || (localf.scene == 8)) && (!Util.isNullOrNil(localf.chatroomName)))
          {
            bh.bCz();
            parambp = com.tencent.mm.model.c.bzK().Ju(localf.chatroomName);
            if (parambp != null) {
              localIntent.putExtra("Contact_RoomNickname", parambp.getDisplayName(localf.hgk));
            }
          }
          localIntent.putExtra("Contact_Uin", localf.MXS);
          localIntent.putExtra("Contact_QQNick", localf.pTZ);
          localIntent.putExtra("Contact_Mobile_MD5", localf.adkz);
          localIntent.putExtra("User_From_Fmessage", true);
          localIntent.putExtra("Contact_from_msgType", 37);
          if ((localau == null) || (!com.tencent.mm.contact.d.rs(localau.field_type))) {
            localIntent.putExtra("Contact_KSnsIFlag", 0);
          }
          localIntent.putExtra("Contact_KSnsBgUrl", localf.adkP);
          localIntent.putExtra("verify_gmail", localf.pQw);
          localIntent.putExtra("source_from_user_name", localf.sourceUserName);
          localIntent.putExtra("source_from_nick_name", localf.sourceNickName);
          localIntent.putExtra("share_card_username", localf.adkU);
          localIntent.putExtra("share_card_nickname", localf.adkV);
          localIntent.putExtra("room_name", localf.chatroomName);
          if (parambn != null) {
            if (cn.bDv() - parambn.field_lastModifiedTime < 259200000L) {
              break label1325;
            }
          }
          break;
        }
      }
      label1047:
      label1053:
      label1325:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localIntent.putExtra("isVerifyExpired", paramBoolean1);
        localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 7);
        localIntent.putExtra("Contact_ToProfilePageFromSource", true);
        if ((localau == null) || ((!au.bwO(localau.field_username)) && (!au.bwP(localau.field_username))) || (WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(paramContext))) {
          break label1330;
        }
        AppMethodBeat.o(292044);
        return;
        bool = false;
        break;
        label989:
        if (((parambp.field_isSend != 1) || (parambp.field_type != 3)) && ((!parambp.jbg()) || (parambp.field_type != 1)) && ((!parambp.jbg()) || (parambp.field_type != 2))) {
          break label251;
        }
        localIntent.putExtra("Contact_Conversation_IsSelfSendAdd", false);
        break label251;
        i = 0;
        break label330;
        i = j;
        if (parambp.field_type == 2)
        {
          i = j;
          if (parambp.jbg())
          {
            localIntent.putExtra("User_Verify", true);
            i = 1;
          }
        }
        j = i;
        if (parambp.field_type == 1)
        {
          j = i;
          if (parambp.jbg())
          {
            localIntent.putExtra("User_Verify", true);
            j = 1;
          }
        }
        localIntent.putExtra("Contact_Conversation_IsContact", false);
        localIntent.putExtra("Contact_User", localf.hgk);
        localIntent.putExtra("Contact_Alias", localf.kDc);
        localIntent.putExtra("Contact_Nick", localf.nickname);
        localIntent.putExtra("Contact_QuanPin", localf.pTY);
        localIntent.putExtra("Contact_PyInitial", localf.pTX);
        localIntent.putExtra("Contact_Sex", localf.sex);
        localIntent.putExtra("Contact_Signature", localf.signature);
        localIntent.putExtra("Contact_FMessageCard", true);
        localIntent.putExtra("Contact_City", localf.getCity());
        localIntent.putExtra("Contact_Province", localf.getProvince());
        localIntent.putExtra("Contact_Mobile_MD5", localf.adkz);
        localIntent.putExtra("Contact_full_Mobile_MD5", localf.adkA);
        localIntent.putExtra("Contact_KSnsBgUrl", localf.adkP);
        break label474;
        parambp = paramContext.getString(R.l.chatting_from_verify_lbs_tip);
        break label572;
      }
      label1330:
      long l = com.tencent.mm.k.i.aRC().getInt("VerifyUserTicketTimeExceed", 259200) * 1000L;
      Log.i("MicroMsg.FConversationOnItemClickListener", "expired time, defaultExpireTime = ".concat(String.valueOf(l)));
      if (parambn != null)
      {
        if (cn.bDv() - parambn.field_lastModifiedTime < l) {
          break label1466;
        }
        localIntent.putExtra("Contact_Conversation_Isexpired", true);
      }
      if ((parambn != null) && (j != 0)) {
        if (((parambn.field_state != 0) && (parambn.field_state != 2)) || (cn.bDv() - parambn.field_lastModifiedTime < l)) {
          break label1479;
        }
      }
    }
    label1466:
    label1479:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localIntent.putExtra("Contact_Scene", 184);
      }
      com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(292044);
      return;
      localIntent.putExtra("Contact_Conversation_Isexpired", false);
      break;
    }
  }
  
  private static void a(Context paramContext, bn parambn, String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(29020);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
      AppMethodBeat.o(29020);
      return;
    }
    Log.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(paramString)));
    com.tencent.mm.modelverify.d.bNI().byk(paramString);
    bp localbp = com.tencent.mm.modelverify.d.bNH().aLv(paramString);
    if ((localbp != null) && (localbp.field_isSend == 1) && (localbp.field_type == 1)) {}
    while (localbp == null)
    {
      Log.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(29020);
      return;
      localbp = com.tencent.mm.modelverify.d.bNH().byn(paramString);
      bool = false;
    }
    Log.i("MicroMsg.FConversationOnItemClickListener", "isforceHideReply = ".concat(String.valueOf(bool)));
    if (localbp.field_type == 0)
    {
      a(paramContext, localbp);
      AppMethodBeat.o(29020);
      return;
    }
    a(paramContext, parambn, localbp, paramBoolean, bool);
    AppMethodBeat.o(29020);
  }
  
  private static void a(Context paramContext, bp parambp)
  {
    AppMethodBeat.i(29021);
    bh.bCz();
    cc.a locala1 = com.tencent.mm.model.c.bzD().aLU(parambp.field_msgContent);
    if (locala1 == null)
    {
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.hgk.length() <= 0)
    {
      AppMethodBeat.o(29021);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Contact_ShowFMessageList", true);
    localBundle.putInt("Contact_Source_FMessage", locala1.scene);
    bh.bCz();
    au localau = com.tencent.mm.model.c.bzA().JE(locala1.hgk);
    if ((localau != null) && ((int)localau.maN > 0) && (com.tencent.mm.contact.d.rs(localau.field_type)))
    {
      com.tencent.mm.plugin.subapp.a.pFo.a(paramContext, localau, locala1, localBundle, "");
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.MXS > 0L)
    {
      if ((Util.isNullOrNil(locala1.pUc)) && (Util.isNullOrNil(locala1.pTZ)) && (!Util.isNullOrNil(locala1.nickname))) {
        localBundle.putString("Contact_QQNick", locala1.nickname);
      }
      com.tencent.mm.plugin.subapp.a.pFo.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    if ((!Util.isNullOrNil(locala1.adkz)) || (!Util.isNullOrNil(locala1.adkA)))
    {
      com.tencent.mm.plugin.account.friend.model.a locala = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(locala1.adkz);
      if ((locala != null) && (locala.getMd5() != null))
      {
        parambp = locala;
        if (locala.getMd5().length() > 0) {}
      }
      else
      {
        locala = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(locala1.adkA);
        if ((locala != null) && (locala.getMd5() != null))
        {
          parambp = locala;
          if (locala.getMd5().length() > 0) {}
        }
        else
        {
          if ((localau != null) && ((int)localau.maN > 0)) {
            com.tencent.mm.plugin.subapp.a.pFo.a(paramContext, localau, locala1, localBundle, "");
          }
          for (;;)
          {
            Log.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + locala1.adkz + " fullMD5:" + locala1.adkA);
            AppMethodBeat.o(29021);
            return;
            com.tencent.mm.plugin.subapp.a.pFo.a(paramContext, locala1, localBundle);
          }
        }
      }
      if ((parambp.getUsername() == null) || (parambp.getUsername().length() <= 0))
      {
        parambp.username = locala1.hgk;
        parambp.eQp = 128;
        if (com.tencent.mm.plugin.account.b.getAddrUploadStg().a(parambp.getMd5(), parambp) == -1)
        {
          Log.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
          AppMethodBeat.o(29021);
          return;
        }
      }
      com.tencent.mm.plugin.subapp.a.pFo.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    com.tencent.mm.plugin.subapp.a.pFo.a(paramContext, locala1, localBundle);
    AppMethodBeat.o(29021);
  }
  
  public static void b(Context paramContext, bp parambp)
  {
    AppMethodBeat.i(29022);
    a(paramContext, null, parambp, false, false);
    AppMethodBeat.o(29022);
  }
  
  public static void i(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29019);
    a(paramContext, null, paramString, paramBoolean);
    AppMethodBeat.o(29019);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(29018);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    int i = paramInt;
    if (this.otH) {
      i = paramInt - 2;
    }
    paramAdapterView = (bn)this.SFJ.getItem(i);
    if (paramAdapterView == null)
    {
      Log.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i)));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(29018);
      return;
    }
    a(this.context, paramAdapterView, paramAdapterView.field_talker, false);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(29018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.a
 * JD-Core Version:    0.7.0.1
 */