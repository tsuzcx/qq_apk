package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.e.d;

public final class am
{
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString, ca.a parama1, am.a parama2)
  {
    AppMethodBeat.i(37189);
    if (!as.bjp(paramString))
    {
      AppMethodBeat.o(37189);
      return;
    }
    String str = parama1.OqO;
    str = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(str, "openim_card_type_name", a.a.jGS);
    if (TextUtils.isEmpty(str))
    {
      parama2.PKu.setText(2131757474);
      parama2.PKt.setBackgroundResource(2131231957);
      c.D(parama2.PKt, paramString);
      str = parama1.OqQ;
      paramString = parama1.OqP;
      if (af.isNullOrNil(str)) {
        break label171;
      }
    }
    label171:
    for (parama = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(parama.Pwc.getContext(), str, paramString, parama2.PKv.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label176;
      }
      parama2.PKv.setVisibility(0);
      parama2.PKv.setText(parama);
      AppMethodBeat.o(37189);
      return;
      parama2.PKu.setText(str);
      break;
    }
    label176:
    parama2.PKv.setVisibility(8);
    AppMethodBeat.o(37189);
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, ca paramca)
  {
    AppMethodBeat.i(37190);
    Log.i("MicroMsg.ChattingItemCard", "dealClickCardMsgEvent, fromUser:%s, groupChat:%s, recv:%s, msgType:%s,msgContent:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramca.getType()), paramString2 });
    Object localObject1 = paramString2;
    if (paramBoolean1)
    {
      localObject1 = paramString2;
      if (paramBoolean2) {
        localObject1 = bp.Kt(paramString2);
      }
    }
    bg.aVF();
    localObject1 = com.tencent.mm.model.c.aSQ().aEK((String)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(37190);
      return;
    }
    paramString2 = ((ca.a)localObject1).dkU;
    if (((as.bjp(paramString2)) || (ab.Iy(paramString2))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(parama.Pwc.getContext())))
    {
      AppMethodBeat.o(37190);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject2;
    if (!ab.rR(((ca.a)localObject1).IOs))
    {
      h.CyF.dN(1430, 0);
      bg.aVF();
      localObject2 = com.tencent.mm.model.c.aSN().Kn(paramString2);
      if ((localObject2 != null) && (com.tencent.mm.contact.c.oR(((ax)localObject2).field_type)))
      {
        paramString2 = ((ax)localObject2).field_username;
        Log.i("MicroMsg.ChattingItemCard", "find in contact, friend:%s", new Object[] { ((ax)localObject2).field_username });
        h.CyF.dN(1430, 1);
      }
    }
    label1304:
    label1317:
    for (;;)
    {
      localIntent.putExtra("Contact_User", paramString2);
      localIntent.putExtra("Contact_Alias", ((ca.a)localObject1).fMb);
      localIntent.putExtra("Contact_Nick", ((ca.a)localObject1).nickname);
      localIntent.putExtra("Contact_QuanPin", ((ca.a)localObject1).kfR);
      localIntent.putExtra("Contact_PyInitial", ((ca.a)localObject1).kfQ);
      localIntent.putExtra("Contact_Uin", ((ca.a)localObject1).Bge);
      localIntent.putExtra("Contact_Mobile_MD5", ((ca.a)localObject1).OqK);
      localIntent.putExtra("Contact_full_Mobile_MD5", ((ca.a)localObject1).OqL);
      localIntent.putExtra("Contact_QQNick", ((ca.a)localObject1).gDZ());
      localIntent.putExtra("User_From_Fmessage", false);
      localIntent.putExtra("Contact_Scene", ((ca.a)localObject1).scene);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_RemarkName", ((ca.a)localObject1).kfV);
      localIntent.putExtra("Contact_VUser_Info_Flag", ((ca.a)localObject1).IOs);
      localIntent.putExtra("Contact_VUser_Info", ((ca.a)localObject1).fuN);
      localIntent.putExtra("Contact_BrandIconURL", ((ca.a)localObject1).BdC);
      localIntent.putExtra("Contact_Province", ((ca.a)localObject1).getProvince());
      localIntent.putExtra("Contact_City", ((ca.a)localObject1).getCity());
      localIntent.putExtra("Contact_Sex", ((ca.a)localObject1).fuA);
      localIntent.putExtra("Contact_Signature", ((ca.a)localObject1).signature);
      localIntent.putExtra("Contact_ShowUserName", true);
      localIntent.putExtra("Contact_KSnsIFlag", 0);
      localIntent.putExtra("Contact_Source_FMessage", 17);
      localIntent.putExtra("source_from_user_name", paramString1);
      localIntent.putExtra("source_from_nick_name", aa.Ir(paramString1));
      localIntent.putExtra(e.d.OyT, ((ca.a)localObject1).Kpf);
      localIntent.putExtra("key_add_contact_openim_appid", ((ca.a)localObject1).OqO);
      localIntent.putExtra("key_add_contact_custom_detail", ((ca.a)localObject1).OqR);
      localIntent.putExtra("key_forward_flag", paramca.gDD());
      localIntent.putExtra("key_msg_id", paramca.field_msgId);
      if ((((ca.a)localObject1).IOs & 0x8) > 0)
      {
        if (!af.isNullOrNil(paramString1))
        {
          bg.aVF();
          if (com.tencent.mm.model.c.aSN().Kn(paramString1).gBM()) {}
        }
        else
        {
          localIntent.putExtra("Contact_Scene", 17);
          h.CyF.kvStat(10298, ((ca.a)localObject1).dkU + ",17");
        }
      }
      else
      {
        label707:
        if ((as.bjp(((ca.a)localObject1).dkU)) && (((ca.a)localObject1).scene == 0)) {
          localIntent.putExtra("Contact_Scene", 17);
        }
        if (ab.rR(((ca.a)localObject1).IOs))
        {
          if (!parama.gRM()) {
            break label1304;
          }
          localIntent.putExtra("preChatTYPE", 2);
        }
      }
      for (;;)
      {
        localIntent.putExtra("prePublishId", "msg_" + paramca.field_msgSvrId);
        paramString2 = paramString1;
        if (af.isNullOrNil(paramString1)) {
          paramString2 = z.aTY();
        }
        localIntent.putExtra("preUsername", paramString2);
        localIntent.putExtra("preChatName", paramca.field_talker);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        com.tencent.mm.bs.a.aiT(((ca.a)localObject1).scene);
        AppMethodBeat.o(37190);
        return;
        bg.aVF();
        bq localbq = com.tencent.mm.model.c.aSP().aEo(paramString2);
        if ((localbq != null) && (!af.isNullOrNil(localbq.field_username)))
        {
          paramString2 = localbq.field_username;
          Log.i("MicroMsg.ChattingItemCard", "find in FriendUser Map, friend:%s", new Object[] { ((ax)localObject2).field_username });
          h.CyF.dN(1430, 2);
          break;
        }
        if ((localbq == null) || (af.isNullOrNil(localbq.field_encryptUsername)))
        {
          localObject2 = new bq(paramString2);
          ((bq)localObject2).field_modifyTime = System.currentTimeMillis();
          bg.aVF();
          if (!com.tencent.mm.model.c.aSP().replace((IAutoDBItem)localObject2)) {
            Log.e("MicroMsg.ChattingItemCard", "add friendUser fail, encryptUsername:%s", new Object[] { paramString2 });
          }
        }
        localIntent.putExtra("force_get_contact", true);
        Log.i("MicroMsg.ChattingItemCard", "need to get contact to judge if Friend, KForceGetContact is true");
        h.CyF.dN(1430, 3);
        break;
        if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(parama.Pwc.getContext()))
        {
          AppMethodBeat.o(37190);
          return;
        }
        bg.aVF();
        localObject2 = com.tencent.mm.model.c.aSN().Kn(paramString2);
        if ((localObject2 == null) || (!((b)g.af(b.class)).Vt())) {
          break label1317;
        }
        int i = ((b)g.af(b.class)).fvo();
        if ((i == 0) && (!com.tencent.mm.contact.c.oR(((ax)localObject2).field_type)))
        {
          ((b)g.af(b.class)).hr(parama.Pwc.getContext());
          parama = (q)g.af(q.class);
          if (paramBoolean1) {}
          for (i = 2;; i = 1)
          {
            parama.d(i, paramString2, ((ca.a)localObject1).nickname);
            AppMethodBeat.o(37190);
            return;
          }
        }
        if (i != 2) {
          break label1317;
        }
        ((b)g.af(b.class)).hr(parama.Pwc.getContext());
        parama = (q)g.af(q.class);
        if (paramBoolean1) {}
        for (i = 2;; i = 1)
        {
          parama.d(i, paramString2, ((ca.a)localObject1).nickname);
          AppMethodBeat.o(37190);
          return;
        }
        localIntent.putExtra("Contact_Scene", 41);
        h.CyF.kvStat(10298, ((ca.a)localObject1).dkU + ",41");
        break label707;
        localIntent.putExtra("preChatTYPE", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am
 * JD-Core Version:    0.7.0.1
 */