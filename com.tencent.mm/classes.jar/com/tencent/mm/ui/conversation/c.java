package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.f;
import com.tencent.mm.h.a.mr;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.p;

public final class c
{
  public static void a(String paramString, Context paramContext, ak paramak, Runnable paramRunnable, boolean paramBoolean1, boolean paramBoolean2)
  {
    PBool localPBool = new PBool();
    Object localObject;
    if (s.fn(paramString))
    {
      paramak = null;
      au.Hx();
      localObject = com.tencent.mm.model.c.Fy().Hz(paramString);
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.c(paramString, ((cs)localObject).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(R.l.app_tip);
      localObject = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(R.l.app_waiting), true, new c.1(localPBool));
      if (!localPBool.value) {
        paramak = e.Xe(paramString);
      }
      if (!ah.bl(paramak))
      {
        ((ProgressDialog)localObject).dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(R.l.wallet_chatting_del_conversation_note, new Object[] { paramak }), null, paramContext.getString(R.l.goto_conversation), paramContext.getString(R.l.del_conversation), new c.7(localPBool, paramContext, paramBoolean2, paramString, paramBoolean1), new c.8((ProgressDialog)localObject, localPBool, paramString, paramBoolean1, paramRunnable), -1, R.e.alert_btn_color_warn);
        if (!s.hs(paramString)) {
          break label731;
        }
        y.i("MicroMsg.ConvDelLogic", "del all qmessage");
        com.tencent.mm.model.bd.HO();
        au.Hx();
        com.tencent.mm.model.c.FB().HH("@qqim");
      }
    }
    label731:
    while (!s.hq(paramString))
    {
      return;
      ((ProgressDialog)localObject).dismiss();
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.fmt_delconvmsg_confirm_group), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new c.9(paramString, localPBool, (ProgressDialog)localObject, paramRunnable), null, R.e.alert_btn_color_warn);
      break;
      if (s.hB(paramString))
      {
        au.Hx();
        com.tencent.mm.model.c.FB().HH(paramString);
        paramContext = new mr();
        paramContext.bWk.opType = 4;
        paramContext.bWk.bWp = 20;
        com.tencent.mm.sdk.b.a.udP.m(paramContext);
        break;
      }
      if (s.hr(paramString))
      {
        au.Hx();
        com.tencent.mm.model.c.FB().HH(paramString);
        break;
      }
      if (s.hu(paramString))
      {
        au.Hx();
        com.tencent.mm.model.c.FB().abu(paramString);
        break;
      }
      if (f.eW(paramString))
      {
        localPBool.value = false;
        paramContext.getString(R.l.app_tip);
        paramak = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(R.l.app_waiting), true, new c.10(localPBool));
        paramak.dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.fmt_delconvmsg_confirm), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new c.11(paramString, localPBool, paramak, paramString), null, R.e.alert_btn_color_warn);
        break;
      }
      au.Hx();
      localObject = com.tencent.mm.model.c.Fy().Hz(paramString);
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.c(paramString, ((cs)localObject).field_msgSvrId));
      localPBool.value = false;
      paramContext.getString(R.l.app_tip);
      p localp = com.tencent.mm.ui.base.h.b(paramContext, paramContext.getString(R.l.app_waiting), true, new c.12(localPBool));
      localObject = null;
      if (!localPBool.value) {
        localObject = e.Xe(paramString);
      }
      if (!ah.bl((String)localObject))
      {
        localp.dismiss();
        com.tencent.mm.ui.base.h.a(paramContext, false, paramContext.getString(R.l.wallet_chatting_del_conversation_note, new Object[] { localObject }), null, paramContext.getString(R.l.goto_conversation), paramContext.getString(R.l.del_conversation), new c.13(localPBool, paramContext, paramBoolean2, paramString, paramBoolean1), new c.14(localp, localPBool, paramContext, paramString, paramak, paramRunnable, paramBoolean1), -1, R.e.alert_btn_color_warn);
        break;
      }
      localp.dismiss();
      if (s.hK(paramString)) {}
      for (int i = R.l.fmt_delconvmsg_confirm_biz;; i = R.l.fmt_delconvmsg_confirm)
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(i), "", paramContext.getString(R.l.app_delete), paramContext.getString(R.l.app_cancel), new c.2(paramContext, paramString, paramak, localPBool, localp, paramRunnable), null, R.e.alert_btn_color_warn);
        break;
      }
    }
    y.i("MicroMsg.ConvDelLogic", "del all tmessage");
    com.tencent.mm.model.bd.HP();
    au.Hx();
    com.tencent.mm.model.c.FB().HH("@t.qq.com");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.c
 * JD-Core Version:    0.7.0.1
 */