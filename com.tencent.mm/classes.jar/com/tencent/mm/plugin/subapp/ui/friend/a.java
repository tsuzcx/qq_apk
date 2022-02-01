package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.storage.x;
import junit.framework.Assert;

public final class a
  implements AdapterView.OnItemClickListener
{
  private Context context;
  private boolean hvv = false;
  private b zQL;
  
  public a(Context paramContext, b paramb, boolean paramBoolean)
  {
    this.context = paramContext;
    this.zQL = paramb;
    this.hvv = paramBoolean;
  }
  
  private static void a(Context paramContext, bb parambb, bd parambd, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(29023);
    String str = parambd.field_msgContent;
    ac.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      AppMethodBeat.o(29023);
      return;
    }
    az.ayM();
    bo.d locald = c.awD().alv(str);
    boolean bool1;
    Intent localIntent;
    if ((locald != null) && (!bs.isNullOrNil(locald.zTO)))
    {
      if (locald.zTO.length() <= 0) {
        break label712;
      }
      bool1 = true;
      Assert.assertTrue(bool1);
      az.ayM();
      ai localai = c.awB().aNt(locald.zTO);
      localIntent = new Intent();
      if (paramBoolean == true) {
        localIntent.putExtra("Accept_NewFriend_FromOutside", true);
      }
      localIntent.putExtra("Contact_ShowUserName", false);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      localIntent.putExtra("Contact_Scene", locald.scene);
      localIntent.putExtra("Verify_ticket", locald.sBi);
      localIntent.putExtra("Contact_Source_FMessage", locald.scene);
      if ((localai == null) || ((int)localai.fLJ <= 0) || (!com.tencent.mm.n.b.ln(localai.field_type))) {
        break label718;
      }
      localIntent.putExtra("Contact_User", localai.field_username);
      com.tencent.mm.plugin.subapp.b.iyy.a(localIntent, localai.field_username);
      label253:
      str = locald.content;
      parambd = str;
      if (bs.nullAsNil(str).length() <= 0) {}
      switch (locald.scene)
      {
      case 19: 
      case 20: 
      case 21: 
      default: 
        parambd = paramContext.getString(2131757173);
        label347:
        localIntent.putExtra("Contact_Content", parambd);
        if ((locald.GZn == 1) && (!bs.isNullOrNil(locald.GZp))) {
          localIntent.putExtra("Safety_Warning_Detail", locald.GZp);
        }
        localIntent.putExtra("Contact_verify_Scene", locald.scene);
        if (((locald.scene == 14) || (locald.scene == 8)) && (!bs.isNullOrNil(locald.chatroomName)))
        {
          az.ayM();
          parambd = c.awK().xN(locald.chatroomName);
          if (parambd != null) {
            localIntent.putExtra("Contact_RoomNickname", parambd.wk(locald.zTO));
          }
        }
        localIntent.putExtra("Contact_Uin", locald.vLk);
        localIntent.putExtra("Contact_QQNick", locald.iLN);
        localIntent.putExtra("Contact_Mobile_MD5", locald.GYX);
        localIntent.putExtra("User_From_Fmessage", true);
        localIntent.putExtra("Contact_from_msgType", 37);
        if ((localai == null) || (!com.tencent.mm.n.b.ln(localai.field_type))) {
          localIntent.putExtra("Contact_KSnsIFlag", 0);
        }
        localIntent.putExtra("Contact_KSnsBgUrl", locald.GZl);
        localIntent.putExtra("verify_gmail", locald.iIk);
        localIntent.putExtra("source_from_user_name", locald.jEq);
        localIntent.putExtra("source_from_nick_name", locald.DpN);
        localIntent.putExtra("share_card_username", locald.GZq);
        localIntent.putExtra("share_card_nickname", locald.GZr);
        localIntent.putExtra("room_name", locald.chatroomName);
        if (parambb != null) {
          if (ce.azI() - parambb.field_lastModifiedTime < 259200000L) {
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
      com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(29023);
      return;
      label712:
      bool1 = false;
      break;
      label718:
      if ((parambd.field_type == 1) || (parambd.field_type == 2)) {
        localIntent.putExtra("User_Verify", true);
      }
      localIntent.putExtra("Contact_User", locald.zTO);
      localIntent.putExtra("Contact_Alias", locald.eNf);
      localIntent.putExtra("Contact_Nick", locald.nickname);
      localIntent.putExtra("Contact_QuanPin", locald.iLM);
      localIntent.putExtra("Contact_PyInitial", locald.iLL);
      localIntent.putExtra("Contact_Sex", locald.exL);
      localIntent.putExtra("Contact_Signature", locald.signature);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_City", locald.getCity());
      localIntent.putExtra("Contact_Province", locald.getProvince());
      localIntent.putExtra("Contact_Mobile_MD5", locald.GYX);
      localIntent.putExtra("Contact_full_Mobile_MD5", locald.GYY);
      localIntent.putExtra("Contact_KSnsBgUrl", locald.GZl);
      break label253;
      parambd = paramContext.getString(2131757177);
      break label347;
    }
  }
  
  private static void a(Context paramContext, bb parambb, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29020);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
      AppMethodBeat.o(29020);
      return;
    }
    ac.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(paramString)));
    com.tencent.mm.bj.d.aJe().aOc(paramString);
    bd localbd = com.tencent.mm.bj.d.aJd().aOf(paramString);
    if (localbd == null)
    {
      ac.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(29020);
      return;
    }
    if (localbd.field_type == 0)
    {
      a(paramContext, localbd);
      AppMethodBeat.o(29020);
      return;
    }
    a(paramContext, parambb, localbd, paramBoolean);
    AppMethodBeat.o(29020);
  }
  
  private static void a(Context paramContext, bd parambd)
  {
    AppMethodBeat.i(29021);
    az.ayM();
    bo.a locala1 = c.awD().alw(parambd.field_msgContent);
    if (locala1 == null)
    {
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.zTO.length() <= 0)
    {
      AppMethodBeat.o(29021);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Contact_ShowFMessageList", true);
    localBundle.putInt("Contact_Source_FMessage", locala1.scene);
    az.ayM();
    ai localai = c.awB().aNt(locala1.zTO);
    if ((localai != null) && ((int)localai.fLJ > 0) && (com.tencent.mm.n.b.ln(localai.field_type)))
    {
      com.tencent.mm.plugin.subapp.b.iyy.a(paramContext, localai, locala1, localBundle, "");
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.vLk > 0L)
    {
      if ((bs.isNullOrNil(locala1.iLQ)) && (bs.isNullOrNil(locala1.iLN)) && (!bs.isNullOrNil(locala1.nickname))) {
        localBundle.putString("Contact_QQNick", locala1.nickname);
      }
      com.tencent.mm.plugin.subapp.b.iyy.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    if ((!bs.isNullOrNil(locala1.GYX)) || (!bs.isNullOrNil(locala1.GYY)))
    {
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi(locala1.GYX);
      if ((locala != null) && (locala.JC() != null))
      {
        parambd = locala;
        if (locala.JC().length() > 0) {}
      }
      else
      {
        locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi(locala1.GYY);
        if ((locala != null) && (locala.JC() != null))
        {
          parambd = locala;
          if (locala.JC().length() > 0) {}
        }
        else
        {
          if ((localai != null) && ((int)localai.fLJ > 0)) {
            com.tencent.mm.plugin.subapp.b.iyy.a(paramContext, localai, locala1, localBundle, "");
          }
          for (;;)
          {
            ac.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + locala1.GYX + " fullMD5:" + locala1.GYY);
            AppMethodBeat.o(29021);
            return;
            com.tencent.mm.plugin.subapp.b.iyy.a(paramContext, locala1, localBundle);
          }
        }
      }
      if ((parambd.getUsername() == null) || (parambd.getUsername().length() <= 0))
      {
        parambd.username = locala1.zTO;
        parambd.drx = 128;
        if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(parambd.JC(), parambd) == -1)
        {
          ac.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
          AppMethodBeat.o(29021);
          return;
        }
      }
      com.tencent.mm.plugin.subapp.b.iyy.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    com.tencent.mm.plugin.subapp.b.iyy.a(paramContext, locala1, localBundle);
    AppMethodBeat.o(29021);
  }
  
  public static void b(Context paramContext, bd parambd)
  {
    AppMethodBeat.i(29022);
    a(paramContext, null, parambd, false);
    AppMethodBeat.o(29022);
  }
  
  public static void h(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29019);
    a(paramContext, null, paramString, paramBoolean);
    AppMethodBeat.o(29019);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(29018);
    int i = paramInt;
    if (this.hvv) {
      i = paramInt - 2;
    }
    paramAdapterView = (bb)this.zQL.getItem(i);
    if (paramAdapterView == null)
    {
      ac.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i)));
      AppMethodBeat.o(29018);
      return;
    }
    a(this.context, paramAdapterView, paramAdapterView.field_talker, false);
    AppMethodBeat.o(29018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.a
 * JD-Core Version:    0.7.0.1
 */