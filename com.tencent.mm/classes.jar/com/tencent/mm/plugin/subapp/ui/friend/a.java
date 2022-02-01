package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bv.d;
import junit.framework.Assert;

public final class a
  implements AdapterView.OnItemClickListener
{
  private b BzL;
  private Context context;
  private boolean hQI = false;
  
  public a(Context paramContext, b paramb, boolean paramBoolean)
  {
    this.context = paramContext;
    this.BzL = paramb;
    this.hQI = paramBoolean;
  }
  
  private static void a(Context paramContext, bg parambg, bi parambi, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(29023);
    String str = parambi.field_msgContent;
    ae.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      AppMethodBeat.o(29023);
      return;
    }
    bc.aCg();
    bv.d locald = com.tencent.mm.model.c.azI().aro(str);
    boolean bool1;
    Intent localIntent;
    if ((locald != null) && (!bu.isNullOrNil(locald.cUA)))
    {
      if (locald.cUA.length() <= 0) {
        break label712;
      }
      bool1 = true;
      Assert.assertTrue(bool1);
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(locald.cUA);
      localIntent = new Intent();
      if (paramBoolean == true) {
        localIntent.putExtra("Accept_NewFriend_FromOutside", true);
      }
      localIntent.putExtra("Contact_ShowUserName", false);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      localIntent.putExtra("Contact_Scene", locald.scene);
      localIntent.putExtra("Verify_ticket", locald.tIA);
      localIntent.putExtra("Contact_Source_FMessage", locald.scene);
      if ((localan == null) || ((int)localan.ght <= 0) || (!com.tencent.mm.contact.c.lO(localan.field_type))) {
        break label718;
      }
      localIntent.putExtra("Contact_User", localan.field_username);
      com.tencent.mm.plugin.subapp.b.iUA.a(localIntent, localan.field_username);
      label253:
      str = locald.content;
      parambi = str;
      if (bu.nullAsNil(str).length() <= 0) {}
      switch (locald.scene)
      {
      case 19: 
      case 20: 
      case 21: 
      default: 
        parambi = paramContext.getString(2131757173);
        label347:
        localIntent.putExtra("Contact_Content", parambi);
        if ((locald.Jhj == 1) && (!bu.isNullOrNil(locald.Jhl))) {
          localIntent.putExtra("Safety_Warning_Detail", locald.Jhl);
        }
        localIntent.putExtra("Contact_verify_Scene", locald.scene);
        if (((locald.scene == 14) || (locald.scene == 8)) && (!bu.isNullOrNil(locald.chatroomName)))
        {
          bc.aCg();
          parambi = com.tencent.mm.model.c.azP().Bx(locald.chatroomName);
          if (parambi != null) {
            localIntent.putExtra("Contact_RoomNickname", parambi.zP(locald.cUA));
          }
        }
        localIntent.putExtra("Contact_Uin", locald.xik);
        localIntent.putExtra("Contact_QQNick", locald.jhP);
        localIntent.putExtra("Contact_Mobile_MD5", locald.JgT);
        localIntent.putExtra("User_From_Fmessage", true);
        localIntent.putExtra("Contact_from_msgType", 37);
        if ((localan == null) || (!com.tencent.mm.contact.c.lO(localan.field_type))) {
          localIntent.putExtra("Contact_KSnsIFlag", 0);
        }
        localIntent.putExtra("Contact_KSnsBgUrl", locald.Jhh);
        localIntent.putExtra("verify_gmail", locald.jem);
        localIntent.putExtra("source_from_user_name", locald.kbH);
        localIntent.putExtra("source_from_nick_name", locald.Fnm);
        localIntent.putExtra("share_card_username", locald.Jhm);
        localIntent.putExtra("share_card_nickname", locald.Jhn);
        localIntent.putExtra("room_name", locald.chatroomName);
        if (parambg != null) {
          if (ch.aDb() - parambg.field_lastModifiedTime < 259200000L) {
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
      if ((parambi.field_type == 1) || (parambi.field_type == 2)) {
        localIntent.putExtra("User_Verify", true);
      }
      localIntent.putExtra("Contact_User", locald.cUA);
      localIntent.putExtra("Contact_Alias", locald.fhy);
      localIntent.putExtra("Contact_Nick", locald.nickname);
      localIntent.putExtra("Contact_QuanPin", locald.jhO);
      localIntent.putExtra("Contact_PyInitial", locald.jhN);
      localIntent.putExtra("Contact_Sex", locald.eQV);
      localIntent.putExtra("Contact_Signature", locald.signature);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_City", locald.getCity());
      localIntent.putExtra("Contact_Province", locald.getProvince());
      localIntent.putExtra("Contact_Mobile_MD5", locald.JgT);
      localIntent.putExtra("Contact_full_Mobile_MD5", locald.JgU);
      localIntent.putExtra("Contact_KSnsBgUrl", locald.Jhh);
      break label253;
      parambi = paramContext.getString(2131757177);
      break label347;
    }
  }
  
  private static void a(Context paramContext, bg parambg, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29020);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
      AppMethodBeat.o(29020);
      return;
    }
    ae.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(paramString)));
    com.tencent.mm.bj.d.aMM().aVu(paramString);
    bi localbi = com.tencent.mm.bj.d.aML().aVx(paramString);
    if (localbi == null)
    {
      ae.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(29020);
      return;
    }
    if (localbi.field_type == 0)
    {
      a(paramContext, localbi);
      AppMethodBeat.o(29020);
      return;
    }
    a(paramContext, parambg, localbi, paramBoolean);
    AppMethodBeat.o(29020);
  }
  
  private static void a(Context paramContext, bi parambi)
  {
    AppMethodBeat.i(29021);
    bc.aCg();
    bv.a locala1 = com.tencent.mm.model.c.azI().arp(parambi.field_msgContent);
    if (locala1 == null)
    {
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.cUA.length() <= 0)
    {
      AppMethodBeat.o(29021);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Contact_ShowFMessageList", true);
    localBundle.putInt("Contact_Source_FMessage", locala1.scene);
    bc.aCg();
    an localan = com.tencent.mm.model.c.azF().BH(locala1.cUA);
    if ((localan != null) && ((int)localan.ght > 0) && (com.tencent.mm.contact.c.lO(localan.field_type)))
    {
      com.tencent.mm.plugin.subapp.b.iUA.a(paramContext, localan, locala1, localBundle, "");
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.xik > 0L)
    {
      if ((bu.isNullOrNil(locala1.jhS)) && (bu.isNullOrNil(locala1.jhP)) && (!bu.isNullOrNil(locala1.nickname))) {
        localBundle.putString("Contact_QQNick", locala1.nickname);
      }
      com.tencent.mm.plugin.subapp.b.iUA.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    if ((!bu.isNullOrNil(locala1.JgT)) || (!bu.isNullOrNil(locala1.JgU)))
    {
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW(locala1.JgT);
      if ((locala != null) && (locala.Lj() != null))
      {
        parambi = locala;
        if (locala.Lj().length() > 0) {}
      }
      else
      {
        locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW(locala1.JgU);
        if ((locala != null) && (locala.Lj() != null))
        {
          parambi = locala;
          if (locala.Lj().length() > 0) {}
        }
        else
        {
          if ((localan != null) && ((int)localan.ght > 0)) {
            com.tencent.mm.plugin.subapp.b.iUA.a(paramContext, localan, locala1, localBundle, "");
          }
          for (;;)
          {
            ae.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + locala1.JgT + " fullMD5:" + locala1.JgU);
            AppMethodBeat.o(29021);
            return;
            com.tencent.mm.plugin.subapp.b.iUA.a(paramContext, locala1, localBundle);
          }
        }
      }
      if ((parambi.getUsername() == null) || (parambi.getUsername().length() <= 0))
      {
        parambi.username = locala1.cUA;
        parambi.dEu = 128;
        if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(parambi.Lj(), parambi) == -1)
        {
          ae.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
          AppMethodBeat.o(29021);
          return;
        }
      }
      com.tencent.mm.plugin.subapp.b.iUA.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    com.tencent.mm.plugin.subapp.b.iUA.a(paramContext, locala1, localBundle);
    AppMethodBeat.o(29021);
  }
  
  public static void b(Context paramContext, bi parambi)
  {
    AppMethodBeat.i(29022);
    a(paramContext, null, parambi, false);
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
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    int i = paramInt;
    if (this.hQI) {
      i = paramInt - 2;
    }
    paramAdapterView = (bg)this.BzL.getItem(i);
    if (paramAdapterView == null)
    {
      ae.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i)));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(29018);
      return;
    }
    a(this.context, paramAdapterView, paramAdapterView.field_talker, false);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(29018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.a
 * JD-Core Version:    0.7.0.1
 */