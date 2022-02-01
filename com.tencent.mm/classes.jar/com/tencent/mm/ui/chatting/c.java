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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.uk;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.cla;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.chatting.viewitems.bq;
import com.tencent.mm.ui.z.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c
  implements View.OnClickListener, i, u
{
  private static final String PdY;
  private com.tencent.mm.ui.chatting.e.a PdZ;
  private ProgressDialog gtM;
  
  static
  {
    AppMethodBeat.i(232833);
    PdY = "https://" + WeChatHosts.domainString(2131761726) + "/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect";
    AppMethodBeat.o(232833);
  }
  
  public c(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.PdZ = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(34234);
    Log.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    ao.eAV().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cD(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(2131761329));
      AppMethodBeat.o(34234);
      return;
    }
    if (z.a.a(this.PdZ.Pwc.getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(34234);
      return;
    }
    Toast.makeText(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(2131761248, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34234);
  }
  
  public final void onClick(final View paramView)
  {
    boolean bool = true;
    int j = 1;
    final int i = 0;
    AppMethodBeat.i(34233);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    if (paramView.getTag() == null)
    {
      Log.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34233);
      return;
    }
    if ((paramView.getTag() instanceof bq))
    {
      localObject1 = (bq)paramView.getTag();
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
      }
      paramView = ((bq)localObject1).dXm.appId;
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
      ao.eAV().a(2, this);
      i = j;
      if (this.PdZ.gRM()) {
        i = 2;
      }
      paramView = this.PdZ.getTalkerUserName();
      if (!com.tencent.mm.model.ab.Eq(paramView)) {
        break label593;
      }
      paramView = bp.Ks(((bq)localObject1).dTX.field_content);
    }
    label593:
    for (;;)
    {
      localObject1 = ((bq)localObject1).dXm;
      com.tencent.mm.ui.base.h.c(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(2131755892), this.PdZ.Pwc.getMMResources().getString(2131755893), this.PdZ.Pwc.getMMResources().getString(2131755125), this.PdZ.Pwc.getMMResources().getString(2131764335), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34230);
          paramAnonymousDialogInterface = new com.tencent.mm.pluginsdk.model.app.ab(2, new ai(this.msv.appId, "1"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.dSQ();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).Pwc.getContext();
            paramAnonymousDialogInterface.a(paramView, this.msv.appId, this.msv.type, i, this.msv.mediaTagName, 1);
          }
          AppMethodBeat.o(34230);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34231);
          paramAnonymousDialogInterface = new com.tencent.mm.pluginsdk.model.app.ab(2, new ai(this.msv.appId, "0"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.dSQ();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).Pwc.getContext();
            paramAnonymousDialogInterface.a(paramView, this.msv.appId, this.msv.type, i, this.msv.mediaTagName, 2);
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
          if ((localObject2 == null) || (Util.isNullOrNil(((t.o)localObject2).ixM)) || (((t.o)localObject2).dTX == null))
          {
            if (localObject2 == null) {}
            for (;;)
            {
              Log.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
              break;
              bool = false;
            }
          }
          paramView = this.PdZ.Pwc.getMMResources().getString(2131766696);
          localObject1 = this.PdZ.Pwc.getMMResources().getString(2131766697);
          String str = this.PdZ.Pwc.getMMResources().getString(2131755761);
          Activity localActivity = this.PdZ.Pwc.getContext();
          localObject2 = new h.d()
          {
            public final void oj(int paramAnonymousInt)
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
                  localIntent.putExtra("rawUrl", String.format(c.PdY, new Object[] { URLEncoder.encode(this.Pea.dkU, "UTF-8"), URLEncoder.encode(this.Pea.ixM, "UTF-8"), Long.valueOf(this.Pea.dTX.field_msgSvrId), Integer.valueOf((int)(this.Pea.dTX.field_createTime / 1000L)), Integer.valueOf(42) }));
                  localIntent.putExtra("show_bottom", false);
                  localIntent.putExtra("showShare", false);
                  com.tencent.mm.br.c.b(c.a(c.this).Pwc.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                  AppMethodBeat.o(34229);
                  return;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  Log.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
                  AppMethodBeat.o(34229);
                  return;
                }
                Log.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { this.Pea.dkU, this.Pea.ixM });
                bg.azz().a(1030, c.this);
                Object localObject2 = new cla();
                ((cla)localObject2).KHa = 1;
                ((cla)localObject2).Mqy = this.Pea.ixM;
                ((cla)localObject2).Title = "";
                Object localObject1 = new LinkedList();
                ((LinkedList)localObject1).add(localObject2);
                localObject2 = new uk();
                ((uk)localObject2).eaK.dYs = this.Pea.dkU;
                ((uk)localObject2).eaK.eaL = ((LinkedList)localObject1);
                if (EventCenter.instance.publish((IEvent)localObject2))
                {
                  localObject1 = c.this;
                  localObject2 = c.a(c.this).Pwc.getContext();
                  c.a(c.this).Pwc.getMMResources().getString(2131755998);
                  c.a((c)localObject1, com.tencent.mm.ui.base.h.a((Context)localObject2, c.a(c.this).Pwc.getMMResources().getString(2131756029), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(34228);
                      bg.azz().b(1030, c.this);
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
    if ((this.gtM != null) && (this.gtM.isShowing()))
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    bg.azz().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cD(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(2131761329));
      AppMethodBeat.o(34235);
      return;
    }
    Toast.makeText(this.PdZ.Pwc.getContext(), this.PdZ.Pwc.getMMResources().getString(2131766698, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c
 * JD-Core Version:    0.7.0.1
 */