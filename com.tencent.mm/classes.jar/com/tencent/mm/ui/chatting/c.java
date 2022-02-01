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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.bxi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.y.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c
  implements View.OnClickListener, f, u
{
  private com.tencent.mm.ui.chatting.e.a JST;
  private ProgressDialog fOC;
  
  public c(com.tencent.mm.ui.chatting.e.a parama)
  {
    this.JST = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(34234);
    ae.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.fOC != null) && (this.fOC.isShowing()))
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    ao.dBj().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cm(this.JST.Kkd.getContext(), this.JST.Kkd.getMMResources().getString(2131759967));
      AppMethodBeat.o(34234);
      return;
    }
    if (y.a.a(this.JST.Kkd.getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(34234);
      return;
    }
    Toast.makeText(this.JST.Kkd.getContext(), this.JST.Kkd.getMMResources().getString(2131759900, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34234);
  }
  
  public final void onClick(final View paramView)
  {
    boolean bool = true;
    int j = 1;
    final int i = 0;
    AppMethodBeat.i(34233);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    if (paramView.getTag() == null)
    {
      ae.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(34233);
      return;
    }
    if ((paramView.getTag() instanceof bk))
    {
      localObject1 = (bk)paramView.getTag();
      if (localObject1 == null)
      {
        ae.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
      }
      paramView = ((bk)localObject1).dFz.appId;
      if (bu.isNullOrNil(paramView)) {
        ae.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
      }
      while (i == 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34233);
        return;
        if (com.tencent.mm.pluginsdk.model.app.h.m(paramView, false, false) == null) {
          ae.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(paramView)));
        } else {
          i = 1;
        }
      }
      ao.dBj().a(2, this);
      i = j;
      if (this.JST.fJC()) {
        i = 2;
      }
      paramView = this.JST.getTalkerUserName();
      if (!x.wb(paramView)) {
        break label593;
      }
      paramView = bl.BM(((bk)localObject1).dCi.field_content);
    }
    label593:
    for (;;)
    {
      localObject1 = ((bk)localObject1).dFz;
      com.tencent.mm.ui.base.h.e(this.JST.Kkd.getContext(), this.JST.Kkd.getMMResources().getString(2131755810), this.JST.Kkd.getMMResources().getString(2131755811), this.JST.Kkd.getMMResources().getString(2131755112), this.JST.Kkd.getMMResources().getString(2131762269), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34230);
          paramAnonymousDialogInterface = new ab(2, new ai(this.lmz.appId, "1"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.cZq();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).Kkd.getContext();
            paramAnonymousDialogInterface.a(paramView, this.lmz.appId, this.lmz.type, i, this.lmz.mediaTagName, 1);
          }
          AppMethodBeat.o(34230);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34231);
          paramAnonymousDialogInterface = new ab(2, new ai(this.lmz.appId, "0"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.cZq();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).Kkd.getContext();
            paramAnonymousDialogInterface.a(paramView, this.lmz.appId, this.lmz.type, i, this.lmz.mediaTagName, 2);
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
            ae.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AppSpamClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34233);
            return;
          }
          if ((localObject2 == null) || (bu.isNullOrNil(((t.o)localObject2).hDH)) || (((t.o)localObject2).dCi == null))
          {
            if (localObject2 == null) {}
            for (;;)
            {
              ae.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
              break;
              bool = false;
            }
          }
          paramView = this.JST.Kkd.getMMResources().getString(2131764394);
          localObject1 = this.JST.Kkd.getMMResources().getString(2131764395);
          String str = this.JST.Kkd.getMMResources().getString(2131755691);
          Activity localActivity = this.JST.Kkd.getContext();
          localObject2 = new h.c()
          {
            public final void lh(int paramAnonymousInt)
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
                  localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[] { URLEncoder.encode(this.JSU.cUA, "UTF-8"), URLEncoder.encode(this.JSU.hDH, "UTF-8"), Long.valueOf(this.JSU.dCi.field_msgSvrId), Integer.valueOf((int)(this.JSU.dCi.field_createTime / 1000L)), Integer.valueOf(42) }));
                  localIntent.putExtra("show_bottom", false);
                  localIntent.putExtra("showShare", false);
                  d.b(c.a(c.this).Kkd.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                  AppMethodBeat.o(34229);
                  return;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  ae.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
                  AppMethodBeat.o(34229);
                  return;
                }
                ae.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { this.JSU.cUA, this.JSU.hDH });
                bc.ajj().a(1030, c.this);
                Object localObject2 = new bxi();
                ((bxi)localObject2).FNv = 1;
                ((bxi)localObject2).Hkk = this.JSU.hDH;
                ((bxi)localObject2).Title = "";
                Object localObject1 = new LinkedList();
                ((LinkedList)localObject1).add(localObject2);
                localObject2 = new tm();
                ((tm)localObject2).dIX.dGJ = this.JSU.cUA;
                ((tm)localObject2).dIX.dIY = ((LinkedList)localObject1);
                if (com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2))
                {
                  localObject1 = c.this;
                  localObject2 = c.a(c.this).Kkd.getContext();
                  c.a(c.this).Kkd.getMMResources().getString(2131755906);
                  c.a((c)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, c.a(c.this).Kkd.getMMResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
                  {
                    public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                    {
                      AppMethodBeat.i(34228);
                      bc.ajj().b(1030, c.this);
                      AppMethodBeat.o(34228);
                    }
                  }));
                }
              }
            }
          };
          com.tencent.mm.ui.base.h.b(localActivity, null, new String[] { paramView, localObject1, str }, null, (h.c)localObject2);
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34235);
    if ((this.fOC != null) && (this.fOC.isShowing()))
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    bc.ajj().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cm(this.JST.Kkd.getContext(), this.JST.Kkd.getMMResources().getString(2131759967));
      AppMethodBeat.o(34235);
      return;
    }
    Toast.makeText(this.JST.Kkd.getContext(), this.JST.Kkd.getMMResources().getString(2131764396, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c
 * JD-Core Version:    0.7.0.1
 */