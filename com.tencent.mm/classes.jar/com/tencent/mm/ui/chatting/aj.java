package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3;
import com.tencent.mm.pluginsdk.ui.applet.ab.b;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.f.e;
import java.util.LinkedList;

public final class aj
  implements m
{
  private com.tencent.mm.ui.chatting.d.a hlc;
  
  public aj(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.hlc = parama;
  }
  
  public final Object a(u paramu)
  {
    AppMethodBeat.i(34836);
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(6);
    switch (paramu.type)
    {
    case 3: 
    case 5: 
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 19: 
    case 24: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 32: 
    default: 
    case 4: 
    case 2: 
    case 6: 
    case 7: 
    case 9: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
      for (;;)
      {
        AppMethodBeat.o(34836);
        return null;
        Object localObject1 = new LinkedList();
        int i;
        if (au.bwE(this.hlc.getTalkerUserName()))
        {
          i = paramu.url.lastIndexOf("/");
          if (i >= 0) {
            ((LinkedList)localObject1).add(paramu.url.substring(i + 1));
          }
        }
        else
        {
          Object localObject2;
          for (;;)
          {
            localObject2 = new LinkedList();
            i = 0;
            while (i < ((LinkedList)localObject1).size())
            {
              ((LinkedList)localObject2).add(Integer.valueOf(6));
              i += 1;
            }
            ((LinkedList)localObject1).add(this.hlc.getTalkerUserName());
          }
          if ((this.hlc.Uxa != null) && (au.bwO(this.hlc.Uxa.field_username)))
          {
            new com.tencent.mm.pluginsdk.ui.applet.ab(this.hlc.aezO.getContext(), new ab.b()
            {
              public final void sendEnd(boolean paramAnonymousBoolean) {}
            }).a((LinkedList)localObject1, (LinkedList)localObject2, null);
          }
          else
          {
            localObject2 = this.hlc.aezO.getContext();
            au localau = this.hlc.Uxa;
            long l = 0L;
            if (paramu.hTm != null) {
              l = paramu.hTm.field_msgId;
            }
            i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zpi, 2);
            int j = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zpl, 5000);
            localObject1 = SayHiWithSnsPermissionUI.class;
            if ((!au.bwO(localau.field_username)) && (i == 1)) {
              paramu = SayHiWithSnsPermissionUI2.class;
            }
            for (;;)
            {
              paramu = new Intent((Context)localObject2, paramu);
              paramu.putExtra("Contact_User", localau.field_username);
              paramu.putExtra("Contact_Nick", localau.field_nickname);
              paramu.putExtra("Contact_RemarkName", localau.field_conRemark);
              paramu.putExtra("Contact_IsForceVerifyFriend", true);
              paramu.putExtra("Contact_Scene", 6);
              paramu.putExtra("Contact_Source_Add", 184);
              paramu.putExtra("key_force_use_contact_label", true);
              paramu.putExtra("sayhi_with_sns_perm_send_verify", true);
              paramu.putExtra("sayhi_with_sns_perm_add_remark", true);
              paramu.putExtra("sayhi_with_sns_perm_set_label", false);
              paramu.putExtra(f.e.adwe, "");
              paramu.putExtra("sayhi_verify_add_errcode", -1);
              paramu.putExtra("key_msg_id", l);
              paramu = new com.tencent.mm.hellhoundlib.b.a().cG(paramu);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramu.aYi(), "com/tencent/mm/ui/chatting/MMChattingSpanClickCallback", "gotoSayHiPage", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ILcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject2).startActivity((Intent)paramu.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/MMChattingSpanClickCallback", "gotoSayHiPage", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ILcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              paramu = (u)localObject1;
              if (!au.bwO(localau.field_username))
              {
                paramu = (u)localObject1;
                if (i == 2)
                {
                  paramu = (u)localObject1;
                  if (com.tencent.mm.model.ab.bBW() >= j) {
                    paramu = SayHiWithSnsPermissionUI3.class;
                  }
                }
              }
            }
            this.hlc.aezO.joU();
          }
        }
      }
    case 25: 
    case 30: 
    case 31: 
    case 33: 
      paramu = this.hlc.getTalkerUserName();
      AppMethodBeat.o(34836);
      return paramu;
    }
    paramu = this.hlc.getTalkerUserName();
    AppMethodBeat.o(34836);
    return paramu;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(34837);
    switch (paramu.type)
    {
    default: 
      AppMethodBeat.o(34837);
      return null;
    }
    if (bh.baz())
    {
      if (com.tencent.mm.an.g.Dn(this.hlc.getTalkerUserName()))
      {
        AppMethodBeat.o(34837);
        return null;
      }
      if (com.tencent.mm.an.g.MB(this.hlc.getTalkerUserName()))
      {
        AppMethodBeat.o(34837);
        return null;
      }
      if (com.tencent.mm.an.g.MA(this.hlc.getTalkerUserName()))
      {
        AppMethodBeat.o(34837);
        return null;
      }
    }
    String str2 = new String(Base64.decode(paramu.url, 0));
    String str1 = (String)paramu.cf(String.class);
    paramu = "";
    Object localObject1 = paramu;
    for (;;)
    {
      try
      {
        localObject2 = new i(str1);
        localObject1 = paramu;
        paramu = ((i)localObject2).optString("fullText");
        localObject1 = paramu;
        str1 = ((i)localObject2).optString("linkText");
        localObject1 = str1;
      }
      catch (com.tencent.mm.ad.g paramu)
      {
        try
        {
          str1 = new String(Base64.decode(Util.nullAs(((i)localObject2).optString("path"), ""), 0));
          Log.i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", new Object[] { str2, str1 });
          localObject2 = new AppBrandStatObject();
          if (!au.bwQ(this.hlc.getTalkerUserName())) {
            break label309;
          }
          ((AppBrandStatObject)localObject2).scene = 1207;
          ((AppBrandStatObject)localObject2).hzx = this.hlc.getTalkerUserName();
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a(this.hlc.aezO.getContext(), null, str2, 0, 0, str1, (AppBrandStatObject)localObject2);
        }
        catch (com.tencent.mm.ad.g localg)
        {
          Object localObject2;
          break label303;
        }
        paramu = paramu;
        str1 = "";
        paramu = (u)localObject1;
        localObject1 = str1;
      }
      label303:
      str1 = "";
      continue;
      label309:
      ((AppBrandStatObject)localObject2).scene = 1082;
      ((AppBrandStatObject)localObject2).hzx = (this.hlc.getTalkerUserName() + ":1:" + paramu + ":" + (String)localObject1 + ":" + str1);
      Log.d("MicroMsg.MMChattingSpanClickCallback", "sceneNote = %s", new Object[] { ((AppBrandStatObject)localObject2).hzx });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aj
 * JD-Core Version:    0.7.0.1
 */