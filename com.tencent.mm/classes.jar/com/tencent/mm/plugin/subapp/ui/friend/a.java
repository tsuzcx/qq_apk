package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.u;
import junit.framework.Assert;

public final class a
  implements AdapterView.OnItemClickListener
{
  private Context context;
  private boolean fsZ = false;
  private b sXK;
  
  public a(Context paramContext, b paramb, boolean paramBoolean)
  {
    this.context = paramContext;
    this.sXK = paramb;
    this.fsZ = paramBoolean;
  }
  
  private static void a(Context paramContext, av paramav, ax paramax, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(153669);
    String str = paramax.field_msgContent;
    ab.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      AppMethodBeat.o(153669);
      return;
    }
    com.tencent.mm.model.aw.aaz();
    bi.d locald = c.YC().Tx(str);
    boolean bool1;
    Intent localIntent;
    if ((locald != null) && (!bo.isNullOrNil(locald.tac)))
    {
      if (locald.tac.length() <= 0) {
        break label672;
      }
      bool1 = true;
      Assert.assertTrue(bool1);
      com.tencent.mm.model.aw.aaz();
      ad localad = c.YA().arw(locald.tac);
      localIntent = new Intent();
      if (paramBoolean == true) {
        localIntent.putExtra("Accept_NewFriend_FromOutside", true);
      }
      localIntent.putExtra("Contact_ShowUserName", false);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      localIntent.putExtra("Contact_Scene", locald.scene);
      localIntent.putExtra("Verify_ticket", locald.mVw);
      localIntent.putExtra("Contact_Source_FMessage", locald.scene);
      if ((localad == null) || ((int)localad.euF <= 0) || (!com.tencent.mm.n.a.je(localad.field_type))) {
        break label678;
      }
      localIntent.putExtra("Contact_User", localad.field_username);
      com.tencent.mm.plugin.subapp.b.gmP.a(localIntent, localad.field_username);
      label251:
      str = locald.content;
      paramax = str;
      if (bo.nullAsNil(str).length() <= 0) {}
      switch (locald.scene)
      {
      case 19: 
      case 20: 
      case 21: 
      default: 
        paramax = paramContext.getString(2131298184);
        label347:
        localIntent.putExtra("Contact_Content", paramax);
        if ((locald.yOy == 1) && (!bo.isNullOrNil(locald.yOA))) {
          localIntent.putExtra("Safety_Warning_Detail", locald.yOA);
        }
        localIntent.putExtra("Contact_verify_Scene", locald.scene);
        if (((locald.scene == 14) || (locald.scene == 8)) && (!bo.isNullOrNil(locald.chatroomName)))
        {
          com.tencent.mm.model.aw.aaz();
          paramax = c.YJ().oU(locald.chatroomName);
          if (paramax != null) {
            localIntent.putExtra("Contact_RoomNickname", paramax.nE(locald.tac));
          }
        }
        localIntent.putExtra("Contact_Uin", locald.pAI);
        localIntent.putExtra("Contact_QQNick", locald.gyJ);
        localIntent.putExtra("Contact_Mobile_MD5", locald.yOi);
        localIntent.putExtra("User_From_Fmessage", true);
        localIntent.putExtra("Contact_from_msgType", 37);
        if ((localad == null) || (!com.tencent.mm.n.a.je(localad.field_type))) {
          localIntent.putExtra("Contact_KSnsIFlag", 0);
        }
        localIntent.putExtra("Contact_KSnsBgUrl", locald.yOw);
        localIntent.putExtra("verify_gmail", locald.gvd);
        localIntent.putExtra("source_from_user_name", locald.inF);
        localIntent.putExtra("source_from_nick_name", locald.vSR);
        localIntent.putExtra("room_name", locald.chatroomName);
        if (paramav != null) {
          if (cb.abq() - paramav.field_lastModifiedTime < 259200000L) {
            break label893;
          }
        }
        break;
      }
    }
    label672:
    label678:
    label893:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localIntent.putExtra("isVerifyExpired", paramBoolean);
      com.tencent.mm.bq.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
      AppMethodBeat.o(153669);
      return;
      bool1 = false;
      break;
      if ((paramax.field_type == 1) || (paramax.field_type == 2)) {
        localIntent.putExtra("User_Verify", true);
      }
      localIntent.putExtra("Contact_User", locald.tac);
      localIntent.putExtra("Contact_Alias", locald.dCJ);
      localIntent.putExtra("Contact_Nick", locald.nickname);
      localIntent.putExtra("Contact_QuanPin", locald.gyI);
      localIntent.putExtra("Contact_PyInitial", locald.gyH);
      localIntent.putExtra("Contact_Sex", locald.dqC);
      localIntent.putExtra("Contact_Signature", locald.signature);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_City", locald.getCity());
      localIntent.putExtra("Contact_Province", locald.getProvince());
      localIntent.putExtra("Contact_Mobile_MD5", locald.yOi);
      localIntent.putExtra("Contact_full_Mobile_MD5", locald.yOj);
      localIntent.putExtra("Contact_KSnsBgUrl", locald.yOw);
      break label251;
      paramax = paramContext.getString(2131298188);
      break label347;
    }
  }
  
  private static void a(Context paramContext, av paramav, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(153667);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
      AppMethodBeat.o(153667);
      return;
    }
    ab.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(paramString)));
    com.tencent.mm.bi.d.ali().asa(paramString);
    ax localax = com.tencent.mm.bi.d.alh().ase(paramString);
    if (localax == null)
    {
      ab.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(153667);
      return;
    }
    if (localax.field_type == 0)
    {
      a(paramContext, localax);
      AppMethodBeat.o(153667);
      return;
    }
    a(paramContext, paramav, localax, paramBoolean);
    AppMethodBeat.o(153667);
  }
  
  private static void a(Context paramContext, ax paramax)
  {
    AppMethodBeat.i(25343);
    com.tencent.mm.model.aw.aaz();
    bi.a locala1 = c.YC().Ty(paramax.field_msgContent);
    if (locala1 == null)
    {
      AppMethodBeat.o(25343);
      return;
    }
    if (locala1.tac.length() <= 0)
    {
      AppMethodBeat.o(25343);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Contact_ShowFMessageList", true);
    localBundle.putInt("Contact_Source_FMessage", locala1.scene);
    com.tencent.mm.model.aw.aaz();
    ad localad = c.YA().arw(locala1.tac);
    if ((localad != null) && ((int)localad.euF > 0) && (com.tencent.mm.n.a.je(localad.field_type)))
    {
      com.tencent.mm.plugin.subapp.b.gmP.a(paramContext, localad, locala1, localBundle, "");
      AppMethodBeat.o(25343);
      return;
    }
    if (locala1.pAI > 0L)
    {
      if ((bo.isNullOrNil(locala1.gyM)) && (bo.isNullOrNil(locala1.gyJ)) && (!bo.isNullOrNil(locala1.nickname))) {
        localBundle.putString("Contact_QQNick", locala1.nickname);
      }
      com.tencent.mm.plugin.subapp.b.gmP.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(25343);
      return;
    }
    if ((!bo.isNullOrNil(locala1.yOi)) || (!bo.isNullOrNil(locala1.yOj)))
    {
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(locala1.yOi);
      if ((locala != null) && (locala.Al() != null))
      {
        paramax = locala;
        if (locala.Al().length() > 0) {}
      }
      else
      {
        locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(locala1.yOj);
        if ((locala != null) && (locala.Al() != null))
        {
          paramax = locala;
          if (locala.Al().length() > 0) {}
        }
        else
        {
          if ((localad != null) && ((int)localad.euF > 0)) {
            com.tencent.mm.plugin.subapp.b.gmP.a(paramContext, localad, locala1, localBundle, "");
          }
          for (;;)
          {
            ab.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + locala1.yOi + " fullMD5:" + locala1.yOj);
            AppMethodBeat.o(25343);
            return;
            com.tencent.mm.plugin.subapp.b.gmP.a(paramContext, locala1, localBundle);
          }
        }
      }
      if ((paramax.getUsername() == null) || (paramax.getUsername().length() <= 0))
      {
        paramax.username = locala1.tac;
        paramax.bsY = 128;
        if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramax.Al(), paramax) == -1)
        {
          ab.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
          AppMethodBeat.o(25343);
          return;
        }
      }
      com.tencent.mm.plugin.subapp.b.gmP.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(25343);
      return;
    }
    com.tencent.mm.plugin.subapp.b.gmP.a(paramContext, locala1, localBundle);
    AppMethodBeat.o(25343);
  }
  
  public static void b(Context paramContext, ax paramax)
  {
    AppMethodBeat.i(153668);
    a(paramContext, null, paramax, false);
    AppMethodBeat.o(153668);
  }
  
  public static void g(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(25342);
    a(paramContext, null, paramString, paramBoolean);
    AppMethodBeat.o(25342);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(25341);
    int i = paramInt;
    if (this.fsZ) {
      i = paramInt - 2;
    }
    paramAdapterView = (av)this.sXK.getItem(i);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i)));
      AppMethodBeat.o(25341);
      return;
    }
    a(this.context, paramAdapterView, paramAdapterView.field_talker, false);
    AppMethodBeat.o(25341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.a
 * JD-Core Version:    0.7.0.1
 */