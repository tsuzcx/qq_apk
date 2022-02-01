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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.vn;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.chatting.viewitems.by;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c
  implements View.OnClickListener, i, u
{
  private static final String Wxr;
  private com.tencent.mm.ui.chatting.e.a Wxs;
  private ProgressDialog iXX;
  
  static
  {
    AppMethodBeat.i(264453);
    Wxr = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect";
    AppMethodBeat.o(264453);
  }
  
  public c(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.Wxs = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(34234);
    Log.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.iXX != null) && (this.iXX.isShowing()))
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    ao.fmC().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cO(this.Wxs.WQv.getContext(), this.Wxs.WQv.getMMResources().getString(R.l.eGh));
      AppMethodBeat.o(34234);
      return;
    }
    if (ac.a.a(this.Wxs.WQv.getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(34234);
      return;
    }
    Toast.makeText(this.Wxs.WQv.getContext(), this.Wxs.WQv.getMMResources().getString(R.l.eGc, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34234);
  }
  
  public final void onClick(final View paramView)
  {
    boolean bool = true;
    int j = 1;
    final int i = 0;
    AppMethodBeat.i(34233);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    if (paramView.getTag() == null)
    {
      Log.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34233);
      return;
    }
    if ((paramView.getTag() instanceof by))
    {
      localObject1 = (by)paramView.getTag();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
      }
      paramView = ((by)localObject1).fQY.appId;
      if (Util.isNullOrNil(paramView)) {
        Log.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
      }
      while (i == 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
        if (com.tencent.mm.pluginsdk.model.app.h.o(paramView, false, false) == null) {
          Log.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(paramView)));
        } else {
          i = 1;
        }
      }
      ao.fmC().a(2, this);
      i = j;
      if (this.Wxs.hRi()) {
        i = 2;
      }
      paramView = this.Wxs.getTalkerUserName();
      if (!com.tencent.mm.model.ab.Lj(paramView)) {
        break label595;
      }
      paramView = bq.RL(((by)localObject1).fNz.field_content);
    }
    label595:
    for (;;)
    {
      localObject1 = ((by)localObject1).fQY;
      com.tencent.mm.ui.base.h.c(this.Wxs.WQv.getContext(), this.Wxs.WQv.getMMResources().getString(R.l.eoC), this.Wxs.WQv.getMMResources().getString(R.l.eoD), this.Wxs.WQv.getMMResources().getString(R.l.emC), this.Wxs.WQv.getMMResources().getString(R.l.eQx), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34230);
          paramAnonymousDialogInterface = new com.tencent.mm.pluginsdk.model.app.ab(2, new ai(this.pqD.appId, "1"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.evu();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).WQv.getContext();
            paramAnonymousDialogInterface.a(paramView, this.pqD.appId, this.pqD.type, i, this.pqD.mediaTagName, 1);
          }
          AppMethodBeat.o(34230);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34231);
          paramAnonymousDialogInterface = new com.tencent.mm.pluginsdk.model.app.ab(2, new ai(this.pqD.appId, "0"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.evu();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).WQv.getContext();
            paramAnonymousDialogInterface.a(paramView, this.pqD.appId, this.pqD.type, i, this.pqD.mediaTagName, 2);
          }
          AppMethodBeat.o(34231);
        }
      });
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
        if ((paramView.getTag() instanceof t.o))
        {
          Object localObject2 = (t.o)paramView.getTag();
          if (localObject2 == null)
          {
            Log.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34233);
            return;
          }
          if ((localObject2 == null) || (Util.isNullOrNil(((t.o)localObject2).lnb)) || (((t.o)localObject2).fNz == null))
          {
            if (localObject2 == null) {}
            for (;;)
            {
              Log.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
              break;
              bool = false;
            }
          }
          paramView = this.Wxs.WQv.getMMResources().getString(R.l.eUm);
          localObject1 = this.Wxs.WQv.getMMResources().getString(R.l.eUn);
          String str = this.Wxs.WQv.getMMResources().getString(R.l.app_cancel);
          Activity localActivity = this.Wxs.WQv.getContext();
          localObject2 = new h.d()
          {
            public final void qy(int paramAnonymousInt)
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
                  localIntent.putExtra("rawUrl", String.format(c.Wxr, new Object[] { URLEncoder.encode(this.Wxt.fcC, "UTF-8"), URLEncoder.encode(this.Wxt.lnb, "UTF-8"), Long.valueOf(this.Wxt.fNz.field_msgSvrId), Integer.valueOf((int)(this.Wxt.fNz.field_createTime / 1000L)), Integer.valueOf(42) }));
                  localIntent.putExtra("show_bottom", false);
                  localIntent.putExtra("showShare", false);
                  com.tencent.mm.by.c.b(c.a(c.this).WQv.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                  AppMethodBeat.o(34229);
                  return;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  Log.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
                  AppMethodBeat.o(34229);
                  return;
                }
                Log.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { this.Wxt.fcC, this.Wxt.lnb });
                bh.aGY().a(1030, c.this);
                Object localObject2 = new ctt();
                ((ctt)localObject2).RIs = 1;
                ((ctt)localObject2).TBB = this.Wxt.lnb;
                ((ctt)localObject2).fwr = "";
                Object localObject1 = new LinkedList();
                ((LinkedList)localObject1).add(localObject2);
                localObject2 = new vn();
                ((vn)localObject2).fUH.fSj = this.Wxt.fcC;
                ((vn)localObject2).fUH.fUI = ((LinkedList)localObject1);
                if (EventCenter.instance.publish((IEvent)localObject2))
                {
                  localObject1 = c.this;
                  localObject2 = c.a(c.this).WQv.getContext();
                  c.a(c.this).WQv.getMMResources().getString(R.l.app_tip);
                  c.a((c)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, c.a(c.this).WQv.getMMResources().getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(34228);
                      bh.aGY().b(1030, c.this);
                      AppMethodBeat.o(34228);
                    }
                  }));
                }
              }
            }
          };
          com.tencent.mm.ui.base.h.b(localActivity, null, new String[] { paramView, localObject1, str }, null, (h.d)localObject2);
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(34235);
    if ((this.iXX != null) && (this.iXX.isShowing()))
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    bh.aGY().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cO(this.Wxs.WQv.getContext(), this.Wxs.WQv.getMMResources().getString(R.l.eGh));
      AppMethodBeat.o(34235);
      return;
    }
    Toast.makeText(this.Wxs.WQv.getContext(), this.Wxs.WQv.getMMResources().getString(R.l.eUo, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c
 * JD-Core Version:    0.7.0.1
 */