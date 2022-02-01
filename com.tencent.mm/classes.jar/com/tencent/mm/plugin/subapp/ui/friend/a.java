package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.bu.d;
import junit.framework.Assert;

public final class a
  implements AdapterView.OnItemClickListener
{
  private b Bin;
  private Context context;
  private boolean hNP = false;
  
  public a(Context paramContext, b paramb, boolean paramBoolean)
  {
    this.context = paramContext;
    this.Bin = paramb;
    this.hNP = paramBoolean;
  }
  
  private static void a(Context paramContext, bf parambf, bh parambh, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(29023);
    String str = parambh.field_msgContent;
    ad.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
    if ((str == null) || (str.length() <= 0))
    {
      AppMethodBeat.o(29023);
      return;
    }
    ba.aBQ();
    bu.d locald = c.azs().aqj(str);
    boolean bool1;
    Intent localIntent;
    if ((locald != null) && (!bt.isNullOrNil(locald.dHm)))
    {
      if (locald.dHm.length() <= 0) {
        break label712;
      }
      bool1 = true;
      Assert.assertTrue(bool1);
      ba.aBQ();
      am localam = c.azp().Bf(locald.dHm);
      localIntent = new Intent();
      if (paramBoolean == true) {
        localIntent.putExtra("Accept_NewFriend_FromOutside", true);
      }
      localIntent.putExtra("Contact_ShowUserName", false);
      localIntent.putExtra("Contact_ShowFMessageList", true);
      localIntent.putExtra("Contact_Scene", locald.scene);
      localIntent.putExtra("Verify_ticket", locald.txJ);
      localIntent.putExtra("Contact_Source_FMessage", locald.scene);
      if ((localam == null) || ((int)localam.gfj <= 0) || (!com.tencent.mm.o.b.lM(localam.field_type))) {
        break label718;
      }
      localIntent.putExtra("Contact_User", localam.field_username);
      com.tencent.mm.plugin.subapp.b.iRH.a(localIntent, localam.field_username);
      label253:
      str = locald.content;
      parambh = str;
      if (bt.nullAsNil(str).length() <= 0) {}
      switch (locald.scene)
      {
      case 19: 
      case 20: 
      case 21: 
      default: 
        parambh = paramContext.getString(2131757173);
        label347:
        localIntent.putExtra("Contact_Content", parambh);
        if ((locald.IMC == 1) && (!bt.isNullOrNil(locald.IME))) {
          localIntent.putExtra("Safety_Warning_Detail", locald.IME);
        }
        localIntent.putExtra("Contact_verify_Scene", locald.scene);
        if (((locald.scene == 14) || (locald.scene == 8)) && (!bt.isNullOrNil(locald.chatroomName)))
        {
          ba.aBQ();
          parambh = c.azz().AN(locald.chatroomName);
          if (parambh != null) {
            localIntent.putExtra("Contact_RoomNickname", parambh.zf(locald.dHm));
          }
        }
        localIntent.putExtra("Contact_Uin", locald.wSt);
        localIntent.putExtra("Contact_QQNick", locald.jeW);
        localIntent.putExtra("Contact_Mobile_MD5", locald.IMm);
        localIntent.putExtra("User_From_Fmessage", true);
        localIntent.putExtra("Contact_from_msgType", 37);
        if ((localam == null) || (!com.tencent.mm.o.b.lM(localam.field_type))) {
          localIntent.putExtra("Contact_KSnsIFlag", 0);
        }
        localIntent.putExtra("Contact_KSnsBgUrl", locald.IMA);
        localIntent.putExtra("verify_gmail", locald.jbt);
        localIntent.putExtra("source_from_user_name", locald.jYs);
        localIntent.putExtra("source_from_nick_name", locald.EUR);
        localIntent.putExtra("share_card_username", locald.IMF);
        localIntent.putExtra("share_card_nickname", locald.IMG);
        localIntent.putExtra("room_name", locald.chatroomName);
        if (parambf != null) {
          if (cf.aCL() - parambf.field_lastModifiedTime < 259200000L) {
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
      if ((parambh.field_type == 1) || (parambh.field_type == 2)) {
        localIntent.putExtra("User_Verify", true);
      }
      localIntent.putExtra("Contact_User", locald.dHm);
      localIntent.putExtra("Contact_Alias", locald.ffB);
      localIntent.putExtra("Contact_Nick", locald.nickname);
      localIntent.putExtra("Contact_QuanPin", locald.jeV);
      localIntent.putExtra("Contact_PyInitial", locald.jeU);
      localIntent.putExtra("Contact_Sex", locald.ePk);
      localIntent.putExtra("Contact_Signature", locald.signature);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_City", locald.getCity());
      localIntent.putExtra("Contact_Province", locald.getProvince());
      localIntent.putExtra("Contact_Mobile_MD5", locald.IMm);
      localIntent.putExtra("Contact_full_Mobile_MD5", locald.IMn);
      localIntent.putExtra("Contact_KSnsBgUrl", locald.IMA);
      break label253;
      parambh = paramContext.getString(2131757177);
      break label347;
    }
  }
  
  private static void a(Context paramContext, bf parambf, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(29020);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
      AppMethodBeat.o(29020);
      return;
    }
    ad.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = ".concat(String.valueOf(paramString)));
    com.tencent.mm.bk.d.aMo().aTT(paramString);
    bh localbh = com.tencent.mm.bk.d.aMn().aTW(paramString);
    if (localbh == null)
    {
      ad.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(29020);
      return;
    }
    if (localbh.field_type == 0)
    {
      a(paramContext, localbh);
      AppMethodBeat.o(29020);
      return;
    }
    a(paramContext, parambf, localbh, paramBoolean);
    AppMethodBeat.o(29020);
  }
  
  private static void a(Context paramContext, bh parambh)
  {
    AppMethodBeat.i(29021);
    ba.aBQ();
    bu.a locala1 = c.azs().aqk(parambh.field_msgContent);
    if (locala1 == null)
    {
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.dHm.length() <= 0)
    {
      AppMethodBeat.o(29021);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("Contact_ShowFMessageList", true);
    localBundle.putInt("Contact_Source_FMessage", locala1.scene);
    ba.aBQ();
    am localam = c.azp().Bf(locala1.dHm);
    if ((localam != null) && ((int)localam.gfj > 0) && (com.tencent.mm.o.b.lM(localam.field_type)))
    {
      com.tencent.mm.plugin.subapp.b.iRH.a(paramContext, localam, locala1, localBundle, "");
      AppMethodBeat.o(29021);
      return;
    }
    if (locala1.wSt > 0L)
    {
      if ((bt.isNullOrNil(locala1.jeZ)) && (bt.isNullOrNil(locala1.jeW)) && (!bt.isNullOrNil(locala1.nickname))) {
        localBundle.putString("Contact_QQNick", locala1.nickname);
      }
      com.tencent.mm.plugin.subapp.b.iRH.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    if ((!bt.isNullOrNil(locala1.IMm)) || (!bt.isNullOrNil(locala1.IMn)))
    {
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx(locala1.IMm);
      if ((locala != null) && (locala.Lb() != null))
      {
        parambh = locala;
        if (locala.Lb().length() > 0) {}
      }
      else
      {
        locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx(locala1.IMn);
        if ((locala != null) && (locala.Lb() != null))
        {
          parambh = locala;
          if (locala.Lb().length() > 0) {}
        }
        else
        {
          if ((localam != null) && ((int)localam.gfj > 0)) {
            com.tencent.mm.plugin.subapp.b.iRH.a(paramContext, localam, locala1, localBundle, "");
          }
          for (;;)
          {
            ad.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + locala1.IMm + " fullMD5:" + locala1.IMn);
            AppMethodBeat.o(29021);
            return;
            com.tencent.mm.plugin.subapp.b.iRH.a(paramContext, locala1, localBundle);
          }
        }
      }
      if ((parambh.getUsername() == null) || (parambh.getUsername().length() <= 0))
      {
        parambh.username = locala1.dHm;
        parambh.dDp = 128;
        if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(parambh.Lb(), parambh) == -1)
        {
          ad.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
          AppMethodBeat.o(29021);
          return;
        }
      }
      com.tencent.mm.plugin.subapp.b.iRH.a(paramContext, locala1, localBundle);
      AppMethodBeat.o(29021);
      return;
    }
    com.tencent.mm.plugin.subapp.b.iRH.a(paramContext, locala1, localBundle);
    AppMethodBeat.o(29021);
  }
  
  public static void b(Context paramContext, bh parambh)
  {
    AppMethodBeat.i(29022);
    a(paramContext, null, parambh, false);
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
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/friend/FConversationOnItemClickListener", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    int i = paramInt;
    if (this.hNP) {
      i = paramInt - 2;
    }
    paramAdapterView = (bf)this.Bin.getItem(i);
    if (paramAdapterView == null)
    {
      ad.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = ".concat(String.valueOf(i)));
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