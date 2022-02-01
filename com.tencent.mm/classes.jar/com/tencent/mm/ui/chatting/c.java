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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.su;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.e;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.chatting.viewitems.bj;
import com.tencent.mm.ui.y.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;

public final class c
  implements View.OnClickListener, g, u
{
  private com.tencent.mm.ui.chatting.d.a HKm;
  private ProgressDialog fts;
  
  public c(com.tencent.mm.ui.chatting.d.a parama)
  {
    this.HKm = parama;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, aa paramaa)
  {
    AppMethodBeat.i(34234);
    ac.d("MicroMsg.AppSpamClickListener", "appsettings errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((this.fts != null) && (this.fts.isShowing()))
    {
      this.fts.dismiss();
      this.fts = null;
    }
    ap.dnB().b(2, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cg(this.HKm.HZF.getContext(), this.HKm.HZF.getMMResources().getString(2131759967));
      AppMethodBeat.o(34234);
      return;
    }
    if (y.a.a(this.HKm.HZF.getContext(), paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(34234);
      return;
    }
    Toast.makeText(this.HKm.HZF.getContext(), this.HKm.HZF.getMMResources().getString(2131759900, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34234);
  }
  
  public final void onClick(final View paramView)
  {
    boolean bool = true;
    final int i = 0;
    AppMethodBeat.i(34233);
    if (paramView.getTag() == null)
    {
      ac.e("MicroMsg.AppSpamClickListener", "onClick tag is null");
      AppMethodBeat.o(34233);
      return;
    }
    Object localObject1;
    if ((paramView.getTag() instanceof bj))
    {
      localObject1 = (bj)paramView.getTag();
      if (localObject1 == null)
      {
        ac.e("MicroMsg.AppSpamClickListener", "ItemDataTag is null");
        AppMethodBeat.o(34233);
        return;
      }
      paramView = ((bj)localObject1).dsB.appId;
      if (bs.isNullOrNil(paramView)) {
        ac.e("MicroMsg.AppSpamClickListener", "appId is null or nil");
      }
      while (i == 0)
      {
        AppMethodBeat.o(34233);
        return;
        if (com.tencent.mm.pluginsdk.model.app.h.k(paramView, false, false) == null) {
          ac.e("MicroMsg.AppSpamClickListener", "get null appinfo : appid = ".concat(String.valueOf(paramView)));
        } else {
          i = 1;
        }
      }
      ap.dnB().a(2, this);
      if (this.HKm.foQ())
      {
        i = 2;
        paramView = this.HKm.getTalkerUserName();
        if (!w.sQ(paramView)) {
          break label501;
        }
        paramView = bi.yl(((bj)localObject1).dpq.field_content);
      }
    }
    label501:
    for (;;)
    {
      localObject1 = ((bj)localObject1).dsB;
      com.tencent.mm.ui.base.h.d(this.HKm.HZF.getContext(), this.HKm.HZF.getMMResources().getString(2131755810), this.HKm.HZF.getMMResources().getString(2131755811), this.HKm.HZF.getMMResources().getString(2131755112), this.HKm.HZF.getMMResources().getString(2131762269), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34230);
          paramAnonymousDialogInterface = new ab(2, new aj(this.kMk.appId, "1"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.cOr();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).HZF.getContext();
            paramAnonymousDialogInterface.a(paramView, this.kMk.appId, this.kMk.type, i, this.kMk.mediaTagName, 1);
          }
          AppMethodBeat.o(34230);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34231);
          paramAnonymousDialogInterface = new ab(2, new aj(this.kMk.appId, "0"));
          c.a(c.this, paramAnonymousDialogInterface);
          paramAnonymousDialogInterface = b.a.cOr();
          if (paramAnonymousDialogInterface != null)
          {
            c.a(c.this).HZF.getContext();
            paramAnonymousDialogInterface.a(paramView, this.kMk.appId, this.kMk.type, i, this.kMk.mediaTagName, 2);
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
          ac.e("MicroMsg.AppSpamClickListener", "TemplateItemDataTag is null");
          AppMethodBeat.o(34233);
          return;
        }
        if ((localObject2 == null) || (bs.isNullOrNil(((s.o)localObject2).hiK)) || (((s.o)localObject2).dpq == null))
        {
          if (localObject2 == null) {}
          for (;;)
          {
            ac.e("MicroMsg.AppSpamClickListener", "wrong args, tag is null ? ", new Object[] { Boolean.valueOf(bool) });
            AppMethodBeat.o(34233);
            return;
            bool = false;
          }
        }
        paramView = this.HKm.HZF.getMMResources().getString(2131764394);
        localObject1 = this.HKm.HZF.getMMResources().getString(2131764395);
        String str = this.HKm.HZF.getMMResources().getString(2131755691);
        Activity localActivity = this.HKm.HZF.getContext();
        localObject2 = new h.c()
        {
          public final void kG(int paramAnonymousInt)
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
                localIntent.putExtra("rawUrl", String.format("https://mp.weixin.qq.com/mp/readtemplate?t=wxm-appmsg-inform&bizusername=%s&tid=%s&mid=%s&mtime=%s&scene=%s#wechat_redirect", new Object[] { URLEncoder.encode(this.HKn.zTO, "UTF-8"), URLEncoder.encode(this.HKn.hiK, "UTF-8"), Long.valueOf(this.HKn.dpq.field_msgSvrId), Integer.valueOf((int)(this.HKn.dpq.field_createTime / 1000L)), Integer.valueOf(42) }));
                localIntent.putExtra("show_bottom", false);
                localIntent.putExtra("showShare", false);
                d.b(c.a(c.this).HZF.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
                AppMethodBeat.o(34229);
                return;
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException)
              {
                ac.e("MicroMsg.AppSpamClickListener", "exception in expore, %s", new Object[] { localUnsupportedEncodingException.getMessage() });
                AppMethodBeat.o(34229);
                return;
              }
              ac.d("MicroMsg.AppSpamClickListener", "hakon refulse, fromUserName = %s, templateId = %s", new Object[] { this.HKn.zTO, this.HKn.hiK });
              az.agi().a(1030, c.this);
              Object localObject2 = new bsb();
              ((bsb)localObject2).DPI = 1;
              ((bsb)localObject2).Fhh = this.HKn.hiK;
              ((bsb)localObject2).Title = "";
              Object localObject1 = new LinkedList();
              ((LinkedList)localObject1).add(localObject2);
              localObject2 = new su();
              ((su)localObject2).dvK.dtD = this.HKn.zTO;
              ((su)localObject2).dvK.dvL = ((LinkedList)localObject1);
              if (com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2))
              {
                localObject1 = c.this;
                localObject2 = c.a(c.this).HZF.getContext();
                c.a(c.this).HZF.getMMResources().getString(2131755906);
                c.a((c)localObject1, com.tencent.mm.ui.base.h.b((Context)localObject2, c.a(c.this).HZF.getMMResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
                  {
                    AppMethodBeat.i(34228);
                    az.agi().b(1030, c.this);
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
    if ((this.fts != null) && (this.fts.isShowing()))
    {
      this.fts.dismiss();
      this.fts = null;
    }
    az.agi().b(1030, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.ui.base.h.cg(this.HKm.HZF.getContext(), this.HKm.HZF.getMMResources().getString(2131759967));
      AppMethodBeat.o(34235);
      return;
    }
    Toast.makeText(this.HKm.HZF.getContext(), this.HKm.HZF.getMMResources().getString(2131764396, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0).show();
    AppMethodBeat.o(34235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c
 * JD-Core Version:    0.7.0.1
 */