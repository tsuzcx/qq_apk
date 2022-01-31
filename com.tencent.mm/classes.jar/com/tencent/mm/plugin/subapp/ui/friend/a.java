package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
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
  private boolean ecL = false;
  private b pwe;
  
  public a(Context paramContext, b paramb, boolean paramBoolean)
  {
    this.context = paramContext;
    this.pwe = paramb;
    this.ecL = paramBoolean;
  }
  
  public static void a(Context paramContext, ax paramax, boolean paramBoolean)
  {
    String str = paramax.field_msgContent;
    y.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : " + str);
    if ((str == null) || (str.length() <= 0)) {}
    bi.d locald;
    do
    {
      return;
      au.Hx();
      locald = c.Fy().HM(str);
    } while ((locald == null) || (bk.bl(locald.pyp)));
    boolean bool;
    ad localad;
    Intent localIntent;
    if (locald.pyp.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      au.Hx();
      localad = c.Fw().abl(locald.pyp);
      localIntent = new Intent();
      if (paramBoolean == true) {
        localIntent.putExtra("Accept_NewFriend_FromOutside", true);
      }
      localIntent.putExtra("Contact_ShowUserName", false);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      localIntent.putExtra("Contact_Scene", locald.scene);
      localIntent.putExtra("Verify_ticket", locald.kzG);
      localIntent.putExtra("Contact_Source_FMessage", locald.scene);
      if ((localad == null) || ((int)localad.dBe <= 0) || (!com.tencent.mm.n.a.gR(localad.field_type))) {
        break label619;
      }
      localIntent.putExtra("Contact_User", localad.field_username);
      com.tencent.mm.plugin.subapp.b.eUS.a(localIntent, localad.field_username);
      label243:
      str = locald.content;
      paramax = str;
      if (bk.pm(str).length() <= 0) {
        switch (locald.scene)
        {
        }
      }
    }
    for (paramax = paramContext.getString(R.l.chatting_from_verify_contact_tip);; paramax = paramContext.getString(R.l.chatting_from_verify_lbs_tip))
    {
      localIntent.putExtra("Contact_Content", paramax);
      if ((locald.uCm == 1) && (!bk.bl(locald.uCo))) {
        localIntent.putExtra("Safety_Warning_Detail", locald.uCo);
      }
      localIntent.putExtra("Contact_verify_Scene", locald.scene);
      if (((locald.scene == 14) || (locald.scene == 8)) && (!bk.bl(locald.chatroomName)))
      {
        au.Hx();
        paramax = c.FF().in(locald.chatroomName);
        if (paramax != null) {
          localIntent.putExtra("Contact_RoomNickname", paramax.gV(locald.pyp));
        }
      }
      localIntent.putExtra("Contact_Uin", locald.mXV);
      localIntent.putExtra("Contact_QQNick", locald.fhb);
      localIntent.putExtra("Contact_Mobile_MD5", locald.uBW);
      localIntent.putExtra("User_From_Fmessage", true);
      localIntent.putExtra("Contact_from_msgType", 37);
      if ((localad == null) || (!com.tencent.mm.n.a.gR(localad.field_type))) {
        localIntent.putExtra("Contact_KSnsIFlag", 0);
      }
      localIntent.putExtra("Contact_KSnsBgUrl", locald.uCk);
      localIntent.putExtra("verify_gmail", locald.fds);
      localIntent.putExtra("source_from_user_name", locald.sbK);
      localIntent.putExtra("source_from_nick_name", locald.sbL);
      com.tencent.mm.br.d.b(paramContext, "profile", ".ui.ContactInfoUI", localIntent);
      return;
      bool = false;
      break;
      label619:
      if ((paramax.field_type == 1) || (paramax.field_type == 2)) {
        localIntent.putExtra("User_Verify", true);
      }
      localIntent.putExtra("Contact_User", locald.pyp);
      localIntent.putExtra("Contact_Alias", locald.cMT);
      localIntent.putExtra("Contact_Nick", locald.nickname);
      localIntent.putExtra("Contact_QuanPin", locald.fha);
      localIntent.putExtra("Contact_PyInitial", locald.fgZ);
      localIntent.putExtra("Contact_Sex", locald.sex);
      localIntent.putExtra("Contact_Signature", locald.signature);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_City", locald.getCity());
      localIntent.putExtra("Contact_Province", locald.getProvince());
      localIntent.putExtra("Contact_Mobile_MD5", locald.uBW);
      localIntent.putExtra("Contact_full_Mobile_MD5", locald.uBX);
      localIntent.putExtra("Contact_KSnsBgUrl", locald.uCk);
      break label243;
    }
  }
  
  public static void g(Context paramContext, String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      y.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
    }
    Object localObject;
    bi.a locala;
    do
    {
      return;
      y.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = " + paramString);
      com.tencent.mm.bh.d.RY().abQ(paramString);
      localObject = com.tencent.mm.bh.d.RX().abU(paramString);
      if (localObject == null)
      {
        y.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = " + paramString);
        return;
      }
      if (((ax)localObject).field_type != 0) {
        break;
      }
      au.Hx();
      locala = c.Fy().HN(((ax)localObject).field_msgContent);
    } while ((locala == null) || (locala.pyp.length() <= 0));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Contact_ShowFMessageList", true);
    localBundle.putInt("Contact_Source_FMessage", locala.scene);
    au.Hx();
    ad localad = c.Fw().abl(locala.pyp);
    if ((localad != null) && ((int)localad.dBe > 0) && (com.tencent.mm.n.a.gR(localad.field_type)))
    {
      com.tencent.mm.plugin.subapp.b.eUS.a(paramContext, localad, locala, localBundle, "");
      return;
    }
    if (locala.mXV > 0L)
    {
      if ((bk.bl(locala.fhe)) && (bk.bl(locala.fhb)) && (!bk.bl(locala.nickname))) {
        localBundle.putString("Contact_QQNick", locala.nickname);
      }
      com.tencent.mm.plugin.subapp.b.eUS.a(paramContext, locala, localBundle);
      return;
    }
    if ((!bk.bl(locala.uBW)) || (!bk.bl(locala.uBX)))
    {
      localObject = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI(locala.uBW);
      if ((localObject != null) && (((com.tencent.mm.plugin.account.friend.a.a)localObject).Wv() != null))
      {
        paramString = (String)localObject;
        if (((com.tencent.mm.plugin.account.friend.a.a)localObject).Wv().length() > 0) {}
      }
      else
      {
        localObject = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI(locala.uBX);
        if ((localObject != null) && (((com.tencent.mm.plugin.account.friend.a.a)localObject).Wv() != null))
        {
          paramString = (String)localObject;
          if (((com.tencent.mm.plugin.account.friend.a.a)localObject).Wv().length() > 0) {}
        }
        else
        {
          if ((localad != null) && ((int)localad.dBe > 0)) {
            com.tencent.mm.plugin.subapp.b.eUS.a(paramContext, localad, locala, localBundle, "");
          }
          for (;;)
          {
            y.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + locala.uBW + " fullMD5:" + locala.uBX);
            return;
            com.tencent.mm.plugin.subapp.b.eUS.a(paramContext, locala, localBundle);
          }
        }
      }
      if ((paramString.getUsername() == null) || (paramString.getUsername().length() <= 0))
      {
        paramString.username = locala.pyp;
        paramString.bcw = 128;
        if (com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramString.Wv(), paramString) == -1)
        {
          y.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
          return;
        }
      }
      com.tencent.mm.plugin.subapp.b.eUS.a(paramContext, locala, localBundle);
      return;
    }
    com.tencent.mm.plugin.subapp.b.eUS.a(paramContext, locala, localBundle);
    return;
    a(paramContext, (ax)localObject, paramBoolean);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt;
    if (this.ecL) {
      i = paramInt - 1;
    }
    paramAdapterView = (av)this.pwe.getItem(i);
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = " + i);
      return;
    }
    g(this.context, paramAdapterView.field_talker, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.a
 * JD-Core Version:    0.7.0.1
 */