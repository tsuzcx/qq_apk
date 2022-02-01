package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.xd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.ae;
import com.tencent.mm.pluginsdk.model.app.af;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.chatting.viewitems.bz;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c
  implements View.OnClickListener, com.tencent.mm.am.h, y
{
  private static final String aeeJ;
  private com.tencent.mm.ui.chatting.d.a aeeK;
  private ProgressDialog lzP;
  
  static
  {
    AppMethodBeat.i(253921);
    aeeJ = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect";
    AppMethodBeat.o(253921);
  }
  
  public c(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.aeeK = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, ae paramae)
  {
    AppMethodBeat.i(34234);
    Log.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.lzP != null) && (this.lzP.isShowing()))
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    as.gxq().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      k.cZ(this.aeeK.aezO.getContext(), this.aeeK.aezO.getMMResources().getString(R.l.gJc));
      AppMethodBeat.o(34234);
      return;
    }
    if (ae.a.a(this.aeeK.aezO.getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(34234);
      return;
    }
    Toast.makeText(this.aeeK.aezO.getContext(), this.aeeK.aezO.getMMResources().getString(R.l.gIX, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34234);
  }
  
  public final void onClick(final View paramView)
  {
    boolean bool = true;
    int j = 1;
    final int i = 0;
    AppMethodBeat.i(34233);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
    if (paramView.getTag() == null)
    {
      Log.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34233);
      return;
    }
    if ((paramView.getTag() instanceof bz))
    {
      localObject1 = (bz)paramView.getTag();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
      }
      paramView = ((bz)localObject1).hWV.appId;
      if (Util.isNullOrNil(paramView)) {
        Log.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
      }
      while (i == 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
        if (com.tencent.mm.pluginsdk.model.app.h.s(paramView, false, false) == null) {
          Log.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(paramView)));
        } else {
          i = 1;
        }
      }
      as.gxq().a(2, this);
      i = j;
      if (this.aeeK.juG()) {
        i = 2;
      }
      paramView = this.aeeK.getTalkerUserName();
      if (!au.bwE(paramView)) {
        break label595;
      }
      paramView = br.JJ(((bz)localObject1).hTm.field_content);
    }
    label595:
    for (;;)
    {
      localObject1 = ((bz)localObject1).hWV;
      k.b(this.aeeK.aezO.getContext(), this.aeeK.aezO.getMMResources().getString(R.l.grB), this.aeeK.aezO.getMMResources().getString(R.l.grC), this.aeeK.aezO.getMMResources().getString(R.l.gpF), this.aeeK.aezO.getMMResources().getString(R.l.gTc), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34230);
          paramAnonymousDialogInterface = new af(2, new am(this.svq.appId, "1"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.fCn();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).aezO.getContext();
            paramAnonymousDialogInterface.a(paramView, this.svq.appId, this.svq.type, i, this.svq.mediaTagName, 1);
          }
          AppMethodBeat.o(34230);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34231);
          paramAnonymousDialogInterface = new af(2, new am(this.svq.appId, "0"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.fCn();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).aezO.getContext();
            paramAnonymousDialogInterface.a(paramView, this.svq.appId, this.svq.type, i, this.svq.mediaTagName, 2);
          }
          AppMethodBeat.o(34231);
        }
      });
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
        if ((paramView.getTag() instanceof v.o))
        {
          Object localObject2 = (v.o)paramView.getTag();
          if (localObject2 == null)
          {
            Log.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34233);
            return;
          }
          if ((localObject2 == null) || (Util.isNullOrNil(((v.o)localObject2).nSg)) || (((v.o)localObject2).hTm == null))
          {
            if (localObject2 == null) {}
            for (;;)
            {
              Log.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
              break;
              bool = false;
            }
          }
          paramView = this.aeeK.aezO.getMMResources().getString(R.l.template_msg_btn_expose);
          localObject1 = this.aeeK.aezO.getMMResources().getString(R.l.template_msg_btn_refuse);
          String str = this.aeeK.aezO.getMMResources().getString(R.l.app_cancel);
          Activity localActivity = this.aeeK.aezO.getContext();
          localObject2 = new k.d()
          {
            public final void qz(int paramAnonymousInt)
            {
              AppMethodBeat.i(34229);
              switch (paramAnonymousInt)
              {
              }
              for (;;)
              {
                AppMethodBeat.o(34229);
                return;
                Intent localIntent = new Intent();
                try
                {
                  localIntent.putExtra("rawUrl", String.format(c.aeeJ, new Object[] { URLEncoder.encode(this.aeeL.hgk, "UTF-8"), URLEncoder.encode(this.aeeL.nSg, "UTF-8"), Long.valueOf(this.aeeL.hTm.field_msgSvrId), Integer.valueOf((int)(this.aeeL.hTm.getCreateTime() / 1000L)), Integer.valueOf(42) }));
                  localIntent.putExtra("show_bottom", false);
                  localIntent.putExtra("showShare", false);
                  com.tencent.mm.br.c.b(c.a(c.this).aezO.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                  AppMethodBeat.o(34229);
                  return;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  Log.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
                  AppMethodBeat.o(34229);
                  return;
                }
                Log.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { this.aeeL.hgk, this.aeeL.nSg });
                bh.aZW().a(1030, c.this);
                Object localObject2 = new dkv();
                ((dkv)localObject2).YFu = 1;
                ((dkv)localObject2).aaQP = this.aeeL.nSg;
                ((dkv)localObject2).hAP = "";
                Object localObject1 = new LinkedList();
                ((LinkedList)localObject1).add(localObject2);
                localObject2 = new xd();
                ((xd)localObject2).iaE.hYg = this.aeeL.hgk;
                ((xd)localObject2).iaE.iaF = ((LinkedList)localObject1);
                if (((xd)localObject2).publish())
                {
                  localObject1 = c.this;
                  localObject2 = c.a(c.this).aezO.getContext();
                  c.a(c.this).aezO.getMMResources().getString(R.l.app_tip);
                  c.a((c)localObject1, k.a((Context)localObject2, c.a(c.this).aezO.getMMResources().getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(34228);
                      bh.aZW().b(1030, c.this);
                      AppMethodBeat.o(34228);
                    }
                  }));
                }
              }
            }
          };
          k.b(localActivity, null, new String[] { paramView, localObject1, str }, null, (k.d)localObject2);
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(34235);
    if ((this.lzP != null) && (this.lzP.isShowing()))
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    bh.aZW().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      k.cZ(this.aeeK.aezO.getContext(), this.aeeK.aezO.getMMResources().getString(R.l.gJc));
      AppMethodBeat.o(34235);
      return;
    }
    Toast.makeText(this.aeeK.aezO.getContext(), this.aeeK.aezO.getMMResources().getString(R.l.template_msg_refuse_success, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c
 * JD-Core Version:    0.7.0.1
 */