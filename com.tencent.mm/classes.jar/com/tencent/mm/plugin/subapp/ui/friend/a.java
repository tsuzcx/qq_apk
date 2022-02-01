package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.d;
import junit.framework.Assert;

public final class a
  implements AdapterView.OnItemClickListener
{
  private b FKw;
  private Context context;
  private boolean iLQ = false;
  
  public a(Context paramContext, b paramb, boolean paramBoolean)
  {
    this.context = paramContext;
    this.FKw = paramb;
    this.iLQ = paramBoolean;
  }
  
  private static void a(Context paramContext, bl parambl, bn parambn, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(29023);
    String str = parambn.field_msgContent;
    Log.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      AppMethodBeat.o(29023);
      return;
    }
    bg.aVF();
    ca.d locald = com.tencent.mm.model.c.aSQ().aEJ(str);
    if ((locald != null) && (!Util.isNullOrNil(locald.dkU)))
    {
      boolean bool1;
      as localas;
      Intent localIntent;
      if (locald.dkU.length() > 0)
      {
        bool1 = true;
        Assert.assertTrue(bool1);
        bg.aVF();
        localas = com.tencent.mm.model.c.aSN().Kn(locald.dkU);
        localIntent = new Intent();
        if (paramBoolean == true) {
          localIntent.putExtra("Accept_NewFriend_FromOutside", true);
        }
        localIntent.putExtra("Contact_ShowUserName", false);
        localIntent.putExtra("Contact_ShowFMessageList", true);
        localIntent.putExtra("Contact_Scene", locald.scene);
        localIntent.putExtra("Verify_ticket", locald.wZz);
        localIntent.putExtra("Contact_Source_FMessage", locald.scene);
        if ((localas == null) || ((int)localas.gMZ <= 0) || (!com.tencent.mm.contact.c.oR(localas.field_type))) {
          break label743;
        }
        localIntent.putExtra("Contact_User", localas.field_username);
        com.tencent.mm.plugin.subapp.b.jRu.a(localIntent, localas.field_username);
        label253:
        str = locald.content;
        parambn = str;
        if (Util.nullAsNil(str).length() <= 0) {}
        switch (locald.scene)
        {
        case 19: 
        case 20: 
        case 21: 
        default: 
          parambn = paramContext.getString(2131757377);
          label347:
          localIntent.putExtra("Contact_Content", parambn);
          if ((locald.Ora == 1) && (!Util.isNullOrNil(locald.Orc))) {
            localIntent.putExtra("Safety_Warning_Detail", locald.Orc);
          }
          localIntent.putExtra("Contact_verify_Scene", locald.scene);
          if (((locald.scene == 14) || (locald.scene == 8)) && (!Util.isNullOrNil(locald.chatroomName)))
          {
            bg.aVF();
            parambn = com.tencent.mm.model.c.aSX().Kd(locald.chatroomName);
            if (parambn != null) {
              localIntent.putExtra("Contact_RoomNickname", parambn.getDisplayName(locald.dkU));
            }
          }
          localIntent.putExtra("Contact_Uin", locald.Bge);
          localIntent.putExtra("Contact_QQNick", locald.kfS);
          localIntent.putExtra("Contact_Mobile_MD5", locald.OqK);
          localIntent.putExtra("User_From_Fmessage", true);
          localIntent.putExtra("Contact_from_msgType", 37);
          if ((localas == null) || (!com.tencent.mm.contact.c.oR(localas.field_type))) {
            localIntent.putExtra("Contact_KSnsIFlag", 0);
          }
          localIntent.putExtra("Contact_KSnsBgUrl", locald.OqY);
          localIntent.putExtra("verify_gmail", locald.kcp);
          localIntent.putExtra("source_from_user_name", locald.sourceUserName);
          localIntent.putExtra("source_from_nick_name", locald.sourceNickName);
          localIntent.putExtra("share_card_username", locald.Ord);
          localIntent.putExtra("share_card_nickname", locald.Ore);
          localIntent.putExtra("room_name", locald.chatroomName);
          if (parambl != null) {
            if (cl.aWz() - parambl.field_lastModifiedTime < 259200000L) {
              break label958;
            }
          }
          break;
        }
      }
      label958:
      for (paramBoolean = bool2;; paramBoolean = false)
      {
        localIntent.putExtra("isVerifyExpired", paramBoolean);
        localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 7);
        if ((localas == null) || ((!as.bjp(localas.field_username)) && (!as.bjq(localas.field_username))) || (WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(paramContext))) {
          break label963;
        }
        AppMethodBeat.o(29023);
        return;
        bool1 = false;
        break;
        label743:
        if ((parambn.field_type == 1) || (parambn.field_type == 2)) {
          localIntent.putExtra("User_Verify", true);
        }
        localIntent.putExtra("Contact_User", locald.dkU);
        localIntent.putExtra("Contact_Alias", locald.fMb);
        localIntent.putExtra("Contact_Nick", locald.nickname);
        localIntent.putExtra("Contact_QuanPin", locald.kfR);
        localIntent.putExtra("Contact_PyInitial", locald.kfQ);
        localIntent.putExtra("Contact_Sex", locald.fuA);
        localIntent.putExtra("Contact_Signature", locald.signature);
        localIntent.putExtra("Contact_FMessageCard", true);
        localIntent.putExtra("Contact_City", locald.getCity());
        localIntent.putExtra("Contact_Province", locald.getProvince());
        localIntent.putExtra("Contact_Mobile_MD5", locald.OqK);
        localIntent.putExtra("Contact_full_Mobile_MD5", locald.OqL);
        localIntent.putExtra("Contact_KSnsBgUrl", locald.OqY);
        break label253;
        parambn = paramContext.getString(2131757381);
        break label347;
      }
      label963:
      com.tencent.mm.br.c.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
    }
    AppMethodBeat.o(29023);
  }
  
  private static void a(Context paramContext, bl parambl, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29020);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
      AppMethodBeat.o(29020);
      return;
    }
    Log.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(paramString)));
    d.bgN().bks(paramString);
    bn localbn = d.bgM().bkv(paramString);
    if (localbn == null)
    {
      Log.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(29020);
      return;
    }
    if (localbn.field_type == 0)
    {
      a(paramContext, localbn);
      AppMethodBeat.o(29020);
      return;
    }
    a(paramContext, parambl, localbn, paramBoolean);
    AppMethodBeat.o(29020);
  }
  
  private static void a(Context paramContext, bn parambn)
  {
    AppMethodBeat.i(29021);
    bg.aVF();
    ca.a locala1 = com.tencent.mm.model.c.aSQ().aEK(parambn.field_msgContent);
    if (locala1 == null)
    {
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.dkU.length() <= 0)
    {
      AppMethodBeat.o(29021);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Contact_ShowFMessageList", true);
    localBundle.putInt("Contact_Source_FMessage", locala1.scene);
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().Kn(locala1.dkU);
    if ((localas != null) && ((int)localas.gMZ > 0) && (com.tencent.mm.contact.c.oR(localas.field_type)))
    {
      com.tencent.mm.plugin.subapp.b.jRu.a(paramContext, localas, locala1, localBundle, "");
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.Bge > 0L)
    {
      if ((Util.isNullOrNil(locala1.kfV)) && (Util.isNullOrNil(locala1.kfS)) && (!Util.isNullOrNil(locala1.nickname))) {
        localBundle.putString("Contact_QQNick", locala1.nickname);
      }
      com.tencent.mm.plugin.subapp.b.jRu.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    if ((!Util.isNullOrNil(locala1.OqK)) || (!Util.isNullOrNil(locala1.OqL)))
    {
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(locala1.OqK);
      if ((locala != null) && (locala.getMd5() != null))
      {
        parambn = locala;
        if (locala.getMd5().length() > 0) {}
      }
      else
      {
        locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(locala1.OqL);
        if ((locala != null) && (locala.getMd5() != null))
        {
          parambn = locala;
          if (locala.getMd5().length() > 0) {}
        }
        else
        {
          if ((localas != null) && ((int)localas.gMZ > 0)) {
            com.tencent.mm.plugin.subapp.b.jRu.a(paramContext, localas, locala1, localBundle, "");
          }
          for (;;)
          {
            Log.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + locala1.OqK + " fullMD5:" + locala1.OqL);
            AppMethodBeat.o(29021);
            return;
            com.tencent.mm.plugin.subapp.b.jRu.a(paramContext, locala1, localBundle);
          }
        }
      }
      if ((parambn.getUsername() == null) || (parambn.getUsername().length() <= 0))
      {
        parambn.username = locala1.dkU;
        parambn.cSx = 128;
        if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(parambn.getMd5(), parambn) == -1)
        {
          Log.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
          AppMethodBeat.o(29021);
          return;
        }
      }
      com.tencent.mm.plugin.subapp.b.jRu.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    com.tencent.mm.plugin.subapp.b.jRu.a(paramContext, locala1, localBundle);
    AppMethodBeat.o(29021);
  }
  
  public static void b(Context paramContext, bn parambn)
  {
    AppMethodBeat.i(29022);
    a(paramContext, null, parambn, false);
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
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    int i = paramInt;
    if (this.iLQ) {
      i = paramInt - 2;
    }
    paramAdapterView = (bl)this.FKw.getItem(i);
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