package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.applet.aa.b;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.f.d;
import java.util.LinkedList;

public final class ag
  implements i
{
  private com.tencent.mm.ui.chatting.e.a fgR;
  
  public ag(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.fgR = parama;
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
        if (ab.PO(this.fgR.getTalkerUserName()))
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
            ((LinkedList)localObject1).add(this.fgR.getTalkerUserName());
          }
          if ((this.fgR.NKq != null) && (as.bvK(this.fgR.NKq.field_username)))
          {
            new aa(this.fgR.WQv.getContext(), new aa.b()
            {
              public final void dO(boolean paramAnonymousBoolean) {}
            }).a((LinkedList)localObject1, (LinkedList)localObject2, null);
          }
          else
          {
            localObject2 = this.fgR.WQv.getContext();
            as localas = this.fgR.NKq;
            long l = 0L;
            if (paramu.fNz != null) {
              l = paramu.fNz.field_msgId;
            }
            i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vWD, 2);
            int j = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vWG, 5000);
            localObject1 = SayHiWithSnsPermissionUI.class;
            if ((!as.bvK(localas.field_username)) && (i == 1)) {
              paramu = SayHiWithSnsPermissionUI2.class;
            }
            for (;;)
            {
              paramu = new Intent((Context)localObject2, paramu);
              paramu.putExtra("Contact_User", localas.field_username);
              paramu.putExtra("Contact_Nick", localas.field_nickname);
              paramu.putExtra("Contact_RemarkName", localas.field_conRemark);
              paramu.putExtra("Contact_IsForceVerifyFriend", true);
              paramu.putExtra("Contact_Scene", 6);
              paramu.putExtra("Contact_Source_Add", 184);
              paramu.putExtra("key_force_use_contact_label", true);
              paramu.putExtra("sayhi_with_sns_perm_send_verify", true);
              paramu.putExtra("sayhi_with_sns_perm_add_remark", true);
              paramu.putExtra("sayhi_with_sns_perm_set_label", false);
              paramu.putExtra(f.d.VRW, "");
              paramu.putExtra("sayhi_verify_add_errcode", -1);
              paramu.putExtra("key_msg_id", l);
              paramu = new com.tencent.mm.hellhoundlib.b.a().bm(paramu);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramu.aFh(), "com/tencent/mm/ui/chatting/MMChattingSpanClickCallback", "gotoSayHiPage", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ILcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject2).startActivity((Intent)paramu.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/MMChattingSpanClickCallback", "gotoSayHiPage", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ILcom/tencent/mm/pluginsdk/ui/applet/HrefInfo;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              break;
              paramu = (u)localObject1;
              if (!as.bvK(localas.field_username))
              {
                paramu = (u)localObject1;
                if (i == 2)
                {
                  paramu = (u)localObject1;
                  if (ab.bef() >= j) {
                    paramu = SayHiWithSnsPermissionUI3.class;
                  }
                }
              }
            }
            this.fgR.WQv.hMr();
          }
        }
      }
    case 25: 
    case 30: 
    case 31: 
    case 33: 
      paramu = this.fgR.getTalkerUserName();
      AppMethodBeat.o(34836);
      return paramu;
    }
    paramu = this.fgR.getTalkerUserName();
    AppMethodBeat.o(34836);
    return paramu;
  }
  
  public final Object b(u paramu)
  {
    AppMethodBeat.i(34837);
    switch (paramu.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34837);
      return null;
      if (bh.aHB())
      {
        if (g.KI(this.fgR.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
        if (g.UC(this.fgR.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
        if (g.UB(this.fgR.getTalkerUserName()))
        {
          AppMethodBeat.o(34837);
          return null;
        }
      }
      String str = new String(Base64.decode(paramu.url, 0));
      paramu = new String(Base64.decode(Util.nullAs((String)paramu.bv(String.class), ""), 0));
      Log.i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", new Object[] { str, paramu });
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1082;
      localAppBrandStatObject.fvd = (this.fgR.getTalkerUserName() + "|1");
      ((r)com.tencent.mm.kernel.h.ae(r.class)).a(this.fgR.WQv.getContext(), null, str, 0, 0, paramu, localAppBrandStatObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ag
 * JD-Core Version:    0.7.0.1
 */