package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.api.r;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.f.e;

public final class ao
{
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString, cc.a parama1, ao.a parama2)
  {
    AppMethodBeat.i(37189);
    if (!au.bwO(paramString))
    {
      AppMethodBeat.o(37189);
      return;
    }
    String str = parama1.adkD;
    str = ((e)com.tencent.mm.kernel.h.ax(e.class)).a(str, "openim_card_type_name", e.a.prb);
    if (TextUtils.isEmpty(str))
    {
      parama2.aeQc.setText(R.l.gyT);
      parama2.aeQb.setBackgroundResource(R.g.default_avatar);
      c.x(parama2.aeQb, paramString);
      str = parama1.adkF;
      paramString = parama1.adkE;
      if (com.tencent.mm.platformtools.ab.isNullOrNil(str)) {
        break label173;
      }
    }
    label173:
    for (parama = ((e)com.tencent.mm.kernel.h.ax(e.class)).a(parama.aezO.getContext(), str, paramString, parama2.aeQd.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label178;
      }
      parama2.aeQd.setVisibility(0);
      parama2.aeQd.setText(parama);
      AppMethodBeat.o(37189);
      return;
      parama2.aeQc.setText(str);
      break;
    }
    label178:
    parama2.aeQd.setVisibility(8);
    AppMethodBeat.o(37189);
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, cc paramcc)
  {
    AppMethodBeat.i(37190);
    Log.i("MicroMsg.ChattingItemCard", "dealClickCardMsgEvent, fromUser:%s, groupChat:%s, recv:%s, msgType:%s,msgContent:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramcc.getType()), paramString2 });
    Object localObject1 = paramString2;
    if (paramBoolean1)
    {
      localObject1 = paramString2;
      if (paramBoolean2) {
        localObject1 = br.JK(paramString2);
      }
    }
    bh.bCz();
    localObject1 = com.tencent.mm.model.c.bzD().aLU((String)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(37190);
      return;
    }
    paramString2 = ((cc.a)localObject1).hgk;
    if (((au.bwO(paramString2)) || (au.bwF(paramString2))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(parama.aezO.getContext())))
    {
      AppMethodBeat.o(37190);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject2;
    if (!com.tencent.mm.model.ab.uY(((cc.a)localObject1).WAW))
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1430, 0);
      bh.bCz();
      localObject2 = com.tencent.mm.model.c.bzA().JE(paramString2);
      if ((localObject2 != null) && (com.tencent.mm.contact.d.rs(((az)localObject2).field_type)))
      {
        paramString2 = ((az)localObject2).field_username;
        Log.i("MicroMsg.ChattingItemCard", "find in contact, friend:%s", new Object[] { ((az)localObject2).field_username });
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1430, 1);
      }
    }
    label1305:
    label1318:
    for (;;)
    {
      localIntent.putExtra("Contact_User", paramString2);
      localIntent.putExtra("Contact_Alias", ((cc.a)localObject1).kDc);
      localIntent.putExtra("Contact_Nick", ((cc.a)localObject1).nickname);
      localIntent.putExtra("Contact_QuanPin", ((cc.a)localObject1).pTY);
      localIntent.putExtra("Contact_PyInitial", ((cc.a)localObject1).pTX);
      localIntent.putExtra("Contact_Uin", ((cc.a)localObject1).MXS);
      localIntent.putExtra("Contact_Mobile_MD5", ((cc.a)localObject1).adkz);
      localIntent.putExtra("Contact_full_Mobile_MD5", ((cc.a)localObject1).adkA);
      localIntent.putExtra("Contact_QQNick", ((cc.a)localObject1).jcv());
      localIntent.putExtra("User_From_Fmessage", false);
      localIntent.putExtra("Contact_Scene", ((cc.a)localObject1).scene);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_RemarkName", ((cc.a)localObject1).pUc);
      localIntent.putExtra("Contact_VUser_Info_Flag", ((cc.a)localObject1).WAW);
      localIntent.putExtra("Contact_VUser_Info", ((cc.a)localObject1).verifyInfo);
      localIntent.putExtra("Contact_BrandIconURL", ((cc.a)localObject1).MVy);
      localIntent.putExtra("Contact_Province", ((cc.a)localObject1).getProvince());
      localIntent.putExtra("Contact_City", ((cc.a)localObject1).getCity());
      localIntent.putExtra("Contact_Sex", ((cc.a)localObject1).sex);
      localIntent.putExtra("Contact_Signature", ((cc.a)localObject1).signature);
      localIntent.putExtra("Contact_ShowUserName", true);
      localIntent.putExtra("Contact_KSnsIFlag", 0);
      localIntent.putExtra("Contact_Source_FMessage", 17);
      localIntent.putExtra("source_from_user_name", paramString1);
      localIntent.putExtra("source_from_nick_name", aa.ID(paramString1));
      localIntent.putExtra(f.e.adwe, ((cc.a)localObject1).Ymm);
      localIntent.putExtra("key_add_contact_openim_appid", ((cc.a)localObject1).adkD);
      localIntent.putExtra("key_add_contact_custom_detail", ((cc.a)localObject1).adkG);
      localIntent.putExtra("key_forward_flag", paramcc.jbV());
      localIntent.putExtra("key_msg_id", paramcc.field_msgId);
      if ((((cc.a)localObject1).WAW & 0x8) > 0)
      {
        if (!com.tencent.mm.platformtools.ab.isNullOrNil(paramString1))
        {
          bh.bCz();
          if (com.tencent.mm.model.c.bzA().JE(paramString1).iZC()) {}
        }
        else
        {
          localIntent.putExtra("Contact_Scene", 17);
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, ((cc.a)localObject1).hgk + ",17");
        }
      }
      else
      {
        label708:
        if ((au.bwO(((cc.a)localObject1).hgk)) && (((cc.a)localObject1).scene == 0)) {
          localIntent.putExtra("Contact_Scene", 17);
        }
        if (com.tencent.mm.model.ab.uY(((cc.a)localObject1).WAW))
        {
          if (!parama.juG()) {
            break label1305;
          }
          localIntent.putExtra("preChatTYPE", 2);
        }
      }
      for (;;)
      {
        localIntent.putExtra("prePublishId", "msg_" + paramcc.field_msgSvrId);
        paramString2 = paramString1;
        if (com.tencent.mm.platformtools.ab.isNullOrNil(paramString1)) {
          paramString2 = z.bAM();
        }
        localIntent.putExtra("preUsername", paramString2);
        localIntent.putExtra("preChatName", paramcc.field_talker);
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        com.tencent.mm.bs.a.axl(((cc.a)localObject1).scene);
        AppMethodBeat.o(37190);
        return;
        bh.bCz();
        bs localbs = com.tencent.mm.model.c.bzC().aLx(paramString2);
        if ((localbs != null) && (!com.tencent.mm.platformtools.ab.isNullOrNil(localbs.field_username)))
        {
          paramString2 = localbs.field_username;
          Log.i("MicroMsg.ChattingItemCard", "find in FriendUser Map, friend:%s", new Object[] { ((az)localObject2).field_username });
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1430, 2);
          break;
        }
        if ((localbs == null) || (com.tencent.mm.platformtools.ab.isNullOrNil(localbs.field_encryptUsername)))
        {
          localObject2 = new bs(paramString2);
          ((bs)localObject2).field_modifyTime = System.currentTimeMillis();
          bh.bCz();
          if (!com.tencent.mm.model.c.bzC().replace((IAutoDBItem)localObject2)) {
            Log.e("MicroMsg.ChattingItemCard", "add friendUser fail, encryptUsername:%s", new Object[] { paramString2 });
          }
        }
        localIntent.putExtra("force_get_contact", true);
        Log.i("MicroMsg.ChattingItemCard", "need to get contact to judge if Friend, KForceGetContact is true");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1430, 3);
        break;
        if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(parama.aezO.getContext()))
        {
          AppMethodBeat.o(37190);
          return;
        }
        bh.bCz();
        localObject2 = com.tencent.mm.model.c.bzA().JE(paramString2);
        if ((localObject2 == null) || (!((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu())) {
          break label1318;
        }
        int i = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEq();
        if ((i == 0) && (!com.tencent.mm.contact.d.rs(((az)localObject2).field_type)))
        {
          ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(parama.aezO.getContext());
          parama = (r)com.tencent.mm.kernel.h.ax(r.class);
          if (paramBoolean1) {}
          for (i = 2;; i = 1)
          {
            parama.e(i, paramString2, ((cc.a)localObject1).nickname);
            AppMethodBeat.o(37190);
            return;
          }
        }
        if (i != 2) {
          break label1318;
        }
        ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).kg(parama.aezO.getContext());
        parama = (r)com.tencent.mm.kernel.h.ax(r.class);
        if (paramBoolean1) {}
        for (i = 2;; i = 1)
        {
          parama.e(i, paramString2, ((cc.a)localObject1).nickname);
          AppMethodBeat.o(37190);
          return;
        }
        localIntent.putExtra("Contact_Scene", 41);
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, ((cc.a)localObject1).hgk + ",41");
        break label708;
        localIntent.putExtra("preChatTYPE", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao
 * JD-Core Version:    0.7.0.1
 */