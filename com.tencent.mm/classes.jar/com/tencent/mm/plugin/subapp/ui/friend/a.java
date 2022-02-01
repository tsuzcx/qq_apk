package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.storage.w;
import junit.framework.Assert;

public final class a
  implements AdapterView.OnItemClickListener
{
  private Context context;
  private boolean gUW = false;
  private b yDx;
  
  public a(Context paramContext, b paramb, boolean paramBoolean)
  {
    this.context = paramContext;
    this.yDx = paramb;
    this.gUW = paramBoolean;
  }
  
  private static void a(Context paramContext, ay paramay, ba paramba, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(29023);
    String str = paramba.field_msgContent;
    ad.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      AppMethodBeat.o(29023);
      return;
    }
    com.tencent.mm.model.az.arV();
    bl.d locald = c.apO().agB(str);
    boolean bool1;
    Intent localIntent;
    if ((locald != null) && (!bt.isNullOrNil(locald.yGA)))
    {
      if (locald.yGA.length() <= 0) {
        break label712;
      }
      bool1 = true;
      Assert.assertTrue(bool1);
      com.tencent.mm.model.az.arV();
      af localaf = c.apM().aHY(locald.yGA);
      localIntent = new Intent();
      if (paramBoolean == true) {
        localIntent.putExtra("Accept_NewFriend_FromOutside", true);
      }
      localIntent.putExtra("Contact_ShowUserName", false);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      localIntent.putExtra("Contact_Scene", locald.scene);
      localIntent.putExtra("Verify_ticket", locald.rso);
      localIntent.putExtra("Contact_Source_FMessage", locald.scene);
      if ((localaf == null) || ((int)localaf.fId <= 0) || (!com.tencent.mm.n.b.ls(localaf.field_type))) {
        break label718;
      }
      localIntent.putExtra("Contact_User", localaf.field_username);
      com.tencent.mm.plugin.subapp.b.hYu.a(localIntent, localaf.field_username);
      label253:
      str = locald.content;
      paramba = str;
      if (bt.nullAsNil(str).length() <= 0) {}
      switch (locald.scene)
      {
      case 19: 
      case 20: 
      case 21: 
      default: 
        paramba = paramContext.getString(2131757173);
        label347:
        localIntent.putExtra("Contact_Content", paramba);
        if ((locald.FAl == 1) && (!bt.isNullOrNil(locald.FAn))) {
          localIntent.putExtra("Safety_Warning_Detail", locald.FAn);
        }
        localIntent.putExtra("Contact_verify_Scene", locald.scene);
        if (((locald.scene == 14) || (locald.scene == 8)) && (!bt.isNullOrNil(locald.chatroomName)))
        {
          com.tencent.mm.model.az.arV();
          paramba = c.apV().tH(locald.chatroomName);
          if (paramba != null) {
            localIntent.putExtra("Contact_RoomNickname", paramba.sh(locald.yGA));
          }
        }
        localIntent.putExtra("Contact_Uin", locald.uCr);
        localIntent.putExtra("Contact_QQNick", locald.ilG);
        localIntent.putExtra("Contact_Mobile_MD5", locald.FzV);
        localIntent.putExtra("User_From_Fmessage", true);
        localIntent.putExtra("Contact_from_msgType", 37);
        if ((localaf == null) || (!com.tencent.mm.n.b.ls(localaf.field_type))) {
          localIntent.putExtra("Contact_KSnsIFlag", 0);
        }
        localIntent.putExtra("Contact_KSnsBgUrl", locald.FAj);
        localIntent.putExtra("verify_gmail", locald.iic);
        localIntent.putExtra("source_from_user_name", locald.jec);
        localIntent.putExtra("source_from_nick_name", locald.BXw);
        localIntent.putExtra("share_card_username", locald.FAo);
        localIntent.putExtra("share_card_nickname", locald.FAp);
        localIntent.putExtra("room_name", locald.chatroomName);
        if (paramay != null) {
          if (ce.asR() - paramay.field_lastModifiedTime < 259200000L) {
            break label933;
          }
        }
        break;
      }
    }
    label933:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localIntent.putExtra("isVerifyExpired", paramBoolean);
      localIntent.putExtra("CONTACT_INFO_UI_SOURCE", 7);
      com.tencent.mm.bs.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(29023);
      return;
      label712:
      bool1 = false;
      break;
      label718:
      if ((paramba.field_type == 1) || (paramba.field_type == 2)) {
        localIntent.putExtra("User_Verify", true);
      }
      localIntent.putExtra("Contact_User", locald.yGA);
      localIntent.putExtra("Contact_Alias", locald.eKn);
      localIntent.putExtra("Contact_Nick", locald.nickname);
      localIntent.putExtra("Contact_QuanPin", locald.ilF);
      localIntent.putExtra("Contact_PyInitial", locald.ilE);
      localIntent.putExtra("Contact_Sex", locald.evp);
      localIntent.putExtra("Contact_Signature", locald.signature);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_City", locald.getCity());
      localIntent.putExtra("Contact_Province", locald.getProvince());
      localIntent.putExtra("Contact_Mobile_MD5", locald.FzV);
      localIntent.putExtra("Contact_full_Mobile_MD5", locald.FzW);
      localIntent.putExtra("Contact_KSnsBgUrl", locald.FAj);
      break label253;
      paramba = paramContext.getString(2131757177);
      break label347;
    }
  }
  
  private static void a(Context paramContext, ay paramay, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29020);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
      AppMethodBeat.o(29020);
      return;
    }
    ad.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(paramString)));
    com.tencent.mm.bk.d.aCo().aIG(paramString);
    ba localba = com.tencent.mm.bk.d.aCn().aIJ(paramString);
    if (localba == null)
    {
      ad.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(29020);
      return;
    }
    if (localba.field_type == 0)
    {
      a(paramContext, localba);
      AppMethodBeat.o(29020);
      return;
    }
    a(paramContext, paramay, localba, paramBoolean);
    AppMethodBeat.o(29020);
  }
  
  private static void a(Context paramContext, ba paramba)
  {
    AppMethodBeat.i(29021);
    com.tencent.mm.model.az.arV();
    bl.a locala1 = c.apO().agC(paramba.field_msgContent);
    if (locala1 == null)
    {
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.yGA.length() <= 0)
    {
      AppMethodBeat.o(29021);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Contact_ShowFMessageList", true);
    localBundle.putInt("Contact_Source_FMessage", locala1.scene);
    com.tencent.mm.model.az.arV();
    af localaf = c.apM().aHY(locala1.yGA);
    if ((localaf != null) && ((int)localaf.fId > 0) && (com.tencent.mm.n.b.ls(localaf.field_type)))
    {
      com.tencent.mm.plugin.subapp.b.hYu.a(paramContext, localaf, locala1, localBundle, "");
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.uCr > 0L)
    {
      if ((bt.isNullOrNil(locala1.ilJ)) && (bt.isNullOrNil(locala1.ilG)) && (!bt.isNullOrNil(locala1.nickname))) {
        localBundle.putString("Contact_QQNick", locala1.nickname);
      }
      com.tencent.mm.plugin.subapp.b.hYu.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    if ((!bt.isNullOrNil(locala1.FzV)) || (!bt.isNullOrNil(locala1.FzW)))
    {
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf(locala1.FzV);
      if ((locala != null) && (locala.JS() != null))
      {
        paramba = locala;
        if (locala.JS().length() > 0) {}
      }
      else
      {
        locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf(locala1.FzW);
        if ((locala != null) && (locala.JS() != null))
        {
          paramba = locala;
          if (locala.JS().length() > 0) {}
        }
        else
        {
          if ((localaf != null) && ((int)localaf.fId > 0)) {
            com.tencent.mm.plugin.subapp.b.hYu.a(paramContext, localaf, locala1, localBundle, "");
          }
          for (;;)
          {
            ad.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + locala1.FzV + " fullMD5:" + locala1.FzW);
            AppMethodBeat.o(29021);
            return;
            com.tencent.mm.plugin.subapp.b.hYu.a(paramContext, locala1, localBundle);
          }
        }
      }
      if ((paramba.getUsername() == null) || (paramba.getUsername().length() <= 0))
      {
        paramba.username = locala1.yGA;
        paramba.dtM = 128;
        if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramba.JS(), paramba) == -1)
        {
          ad.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
          AppMethodBeat.o(29021);
          return;
        }
      }
      com.tencent.mm.plugin.subapp.b.hYu.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    com.tencent.mm.plugin.subapp.b.hYu.a(paramContext, locala1, localBundle);
    AppMethodBeat.o(29021);
  }
  
  public static void b(Context paramContext, ba paramba)
  {
    AppMethodBeat.i(29022);
    a(paramContext, null, paramba, false);
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
    int i = paramInt;
    if (this.gUW) {
      i = paramInt - 2;
    }
    paramAdapterView = (ay)this.yDx.getItem(i);
    if (paramAdapterView == null)
    {
      ad.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i)));
      AppMethodBeat.o(29018);
      return;
    }
    a(this.context, paramAdapterView, paramAdapterView.field_talker, false);
    AppMethodBeat.o(29018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.a
 * JD-Core Version:    0.7.0.1
 */