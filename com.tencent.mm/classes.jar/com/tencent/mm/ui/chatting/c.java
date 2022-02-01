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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.x.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c
  implements View.OnClickListener, g, u
{
  private com.tencent.mm.ui.chatting.d.a Gkx;
  private ProgressDialog fpP;
  
  public c(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.Gkx = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(34234);
    ad.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.fpP != null) && (this.fpP.isShowing()))
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    ap.cZT().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cf(this.Gkx.GzJ.getContext(), this.Gkx.GzJ.getMMResources().getString(2131759967));
      AppMethodBeat.o(34234);
      return;
    }
    if (x.a.a(this.Gkx.GzJ.getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(34234);
      return;
    }
    Toast.makeText(this.Gkx.GzJ.getContext(), this.Gkx.GzJ.getMMResources().getString(2131759900, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34234);
  }
  
  public final void onClick(final View paramView)
  {
    boolean bool = true;
    final int i = 0;
    AppMethodBeat.i(34233);
    if (paramView.getTag() == null)
    {
      ad.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      AppMethodBeat.o(34233);
      return;
    }
    Object localObject1;
    if ((paramView.getTag() instanceof com.tencent.mm.ui.chatting.viewitems.bi))
    {
      localObject1 = (com.tencent.mm.ui.chatting.viewitems.bi)paramView.getTag();
      if (localObject1 == null)
      {
        ad.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        AppMethodBeat.o(34233);
        return;
      }
      paramView = ((com.tencent.mm.ui.chatting.viewitems.bi)localObject1).duP.appId;
      if (bt.isNullOrNil(paramView)) {
        ad.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
      }
      while (i == 0)
      {
        AppMethodBeat.o(34233);
        return;
        if (com.tencent.mm.pluginsdk.model.app.h.j(paramView, false, false) == null) {
          ad.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(paramView)));
        } else {
          i = 1;
        }
      }
      ap.cZT().a(2, this);
      if (this.Gkx.eZb())
      {
        i = 2;
        paramView = this.Gkx.getTalkerUserName();
        if (!w.pF(paramView)) {
          break label501;
        }
        paramView = com.tencent.mm.model.bi.uf(((com.tencent.mm.ui.chatting.viewitems.bi)localObject1).drF.field_content);
      }
    }
    label501:
    for (;;)
    {
      localObject1 = ((com.tencent.mm.ui.chatting.viewitems.bi)localObject1).duP;
      com.tencent.mm.ui.base.h.d(this.Gkx.GzJ.getContext(), this.Gkx.GzJ.getMMResources().getString(2131755810), this.Gkx.GzJ.getMMResources().getString(2131755811), this.Gkx.GzJ.getMMResources().getString(2131755112), this.Gkx.GzJ.getMMResources().getString(2131762269), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34230);
          paramAnonymousDialogInterface = new ab(2, new aj(this.kkS.appId, "1"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.cBi();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).GzJ.getContext();
            paramAnonymousDialogInterface.a(paramView, this.kkS.appId, this.kkS.type, i, this.kkS.mediaTagName, 1);
          }
          AppMethodBeat.o(34230);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34231);
          paramAnonymousDialogInterface = new ab(2, new aj(this.kkS.appId, "0"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.cBi();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).GzJ.getContext();
            paramAnonymousDialogInterface.a(paramView, this.kkS.appId, this.kkS.type, i, this.kkS.mediaTagName, 2);
          }
          AppMethodBeat.o(34231);
        }
      });
      AppMethodBeat.o(34233);
      return;
      i = 1;
      break;
      if ((paramView.getTag() instanceof s.o))
      {
        Object localObject2 = (s.o)paramView.getTag();
        if (localObject2 == null)
        {
          ad.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
          AppMethodBeat.o(34233);
          return;
        }
        if ((localObject2 == null) || (bt.isNullOrNil(((s.o)localObject2).gIj)) || (((s.o)localObject2).drF == null))
        {
          if (localObject2 == null) {}
          for (;;)
          {
            ad.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(34233);
            return;
            bool = false;
          }
        }
        paramView = this.Gkx.GzJ.getMMResources().getString(2131764394);
        localObject1 = this.Gkx.GzJ.getMMResources().getString(2131764395);
        String str = this.Gkx.GzJ.getMMResources().getString(2131755691);
        Activity localActivity = this.Gkx.GzJ.getContext();
        localObject2 = new h.c()
        {
          public final void kM(int paramAnonymousInt)
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
                localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[] { URLEncoder.encode(this.Gky.yGA, "UTF-8"), URLEncoder.encode(this.Gky.gIj, "UTF-8"), Long.valueOf(this.Gky.drF.field_msgSvrId), Integer.valueOf((int)(this.Gky.drF.field_createTime / 1000L)), Integer.valueOf(42) }));
                localIntent.putExtra("show_bottom", false);
                localIntent.putExtra("showShare", false);
                d.b(c.a(c.this).GzJ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                AppMethodBeat.o(34229);
                return;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                ad.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
                AppMethodBeat.o(34229);
                return;
              }
              ad.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { this.Gky.yGA, this.Gky.gIj });
              az.aeS().a(1030, c.this);
              Object localObject2 = new bnl();
              ((bnl)localObject2).Cxm = 1;
              ((bnl)localObject2).DKS = this.Gky.gIj;
              ((bnl)localObject2).Title = "";
              Object localObject1 = new LinkedList();
              ((LinkedList)localObject1).add(localObject2);
              localObject2 = new sl();
              ((sl)localObject2).dxY.dvQ = this.Gky.yGA;
              ((sl)localObject2).dxY.dxZ = ((LinkedList)localObject1);
              if (com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2))
              {
                localObject1 = c.this;
                localObject2 = c.a(c.this).GzJ.getContext();
                c.a(c.this).GzJ.getMMResources().getString(2131755906);
                c.a((c)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, c.a(c.this).GzJ.getMMResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(34228);
                    az.aeS().b(1030, c.this);
                    AppMethodBeat.o(34228);
                  }
                }));
              }
            }
          }
        };
        com.tencent.mm.ui.base.h.b(localActivity, null, new String[] { paramView, localObject1, str }, null, (h.c)localObject2);
      }
      AppMethodBeat.o(34233);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34235);
    if ((this.fpP != null) && (this.fpP.isShowing()))
    {
      this.fpP.dismiss();
      this.fpP = null;
    }
    az.aeS().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cf(this.Gkx.GzJ.getContext(), this.Gkx.GzJ.getMMResources().getString(2131759967));
      AppMethodBeat.o(34235);
      return;
    }
    Toast.makeText(this.Gkx.GzJ.getContext(), this.Gkx.GzJ.getMMResources().getString(2131764396, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c
 * JD-Core Version:    0.7.0.1
 */