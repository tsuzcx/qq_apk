package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.appbrand.b.a;
import com.tencent.mm.ui.appbrand.b.b;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class d
  extends c
{
  private static final String PHp;
  private com.tencent.mm.ui.base.q Fxt;
  private com.tencent.mm.av.a.a.c Oxy;
  private View.OnClickListener PHq;
  private View.OnClickListener PHr;
  private View.OnTouchListener PHs;
  private com.tencent.mm.plugin.appbrand.service.g PHt;
  private boolean PHu;
  private int[] PHv;
  private com.tencent.mm.ui.chatting.e.a PhN;
  private com.tencent.mm.ui.base.q gxX;
  private int rGT;
  private View.OnClickListener rID;
  
  static
  {
    AppMethodBeat.i(233585);
    PHp = "https://" + WeChatHosts.domainString(2131761726) + "/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d#wechat_redirect";
    AppMethodBeat.o(233585);
  }
  
  public d()
  {
    AppMethodBeat.i(233571);
    this.PHv = new int[2];
    com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
    locala.iaT = true;
    locala.jbq = 2131231405;
    this.Oxy = locala.bdv();
    com.tencent.mm.kernel.g.aAf();
    this.rGT = com.tencent.mm.kernel.a.getUin();
    this.PHt = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class));
    this.PHq = new a((byte)0);
    this.PHr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233555);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = (com.tencent.mm.ag.a.a)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { paramAnonymousView.username });
        d.a(d.this, paramAnonymousView.username, paramAnonymousView.appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233555);
      }
    };
    this.rID = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(233557);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (d.a(d.this) != null) {}
        for (localObject1 = d.a(d.this).bul();; localObject1 = null)
        {
          Object localObject2 = (bq)paramAnonymousView.getTag();
          int i = ((Integer)paramAnonymousView.getTag(2131306042)).intValue();
          i = d.a(d.this, i);
          Object localObject4 = com.tencent.mm.ag.a.a.HK(((com.tencent.mm.pluginsdk.ui.chat.c)localObject2).dTX.field_content);
          paramAnonymousView = Util.nullAsNil(((com.tencent.mm.ag.a.a)localObject4).appId);
          localObject2 = Util.nullAsNil(((com.tencent.mm.ag.a.a)localObject4).msgId);
          String str = Util.nullAsNil(((com.tencent.mm.ag.a.a)localObject4).dCx);
          Object localObject3 = Util.nullAsNil(((com.tencent.mm.ag.a.a)localObject4).username);
          int j = ((com.tencent.mm.ag.a.a)localObject4).version;
          int k = ((com.tencent.mm.ag.a.a)localObject4).type;
          localObject4 = com.tencent.mm.ag.a.a.HL(((com.tencent.mm.ag.a.a)localObject4).title);
          Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) container click", new Object[] { localObject3 });
          com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
          localg.username = ((String)localObject3);
          localg.iOo = k;
          localg.version = j;
          localg.kHw = str;
          localg.dCw = ("1162:" + (String)localObject2 + ":" + (String)localObject4);
          localg.scene = 1162;
          localObject3 = new AppBrandLaunchFromNotifyReferrer();
          ((AppBrandLaunchFromNotifyReferrer)localObject3).appId = Util.nullAsNil(paramAnonymousView);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).uin = d.b(d.this);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).lej = 2;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).lek = Util.nullAsNil((String)localObject2);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).content = ((String)localObject4);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).lel = i;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).lem = ((String)localObject1);
          localg.kHI = ((AppBrandLaunchFromNotifyReferrer)localObject3);
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(d.c(d.this).Pwc.getContext(), localg);
          ((com.tencent.mm.ui.chatting.d.b.g)d.c(d.this).bh(com.tencent.mm.ui.chatting.d.b.g.class)).amz(i);
          d.a(d.this, 4, paramAnonymousView, (String)localObject2, str, null, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(233557);
          return;
        }
      }
    };
    this.PHs = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(233558);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(233558);
          return false;
          d.d(d.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          d.d(d.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    AppMethodBeat.o(233571);
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(233577);
    String str = null;
    if (this.PHt != null) {
      str = this.PHt.bul();
    }
    Log.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "appbrand notify report(%d), eventId : %d, appId %s, msgId %s, pagePath %s, label %s", new Object[] { Integer.valueOf(19724), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.h.CyF.a(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString1, paramString3, paramString4, paramString2, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, str });
    AppMethodBeat.o(233577);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233572);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493502, null);
      localView.setTag(new bw().hi(localView));
    }
    AppMethodBeat.o(233572);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(233573);
    this.PhN = parama1;
    paramString = (bw)parama;
    com.tencent.mm.ag.a.a locala = com.tencent.mm.ag.a.a.HK(paramca.field_content);
    if (paramca.field_isSend == 2)
    {
      paramString.PRF.setVisibility(0);
      paramString.timeTV.setVisibility(8);
    }
    for (;;)
    {
      parama = ((k)this.PhN.bh(k.class)).amt(0);
      if ((parama != null) && (parama.field_isSend == 2)) {
        ((k)this.PhN.bh(k.class)).amv(1);
      }
      if (paramca.field_isSend != 2) {
        break;
      }
      paramString.PRG.setVisibility(8);
      if (paramca.field_isSend != 2)
      {
        paramString.titleTv.setText(Util.nullAsNil(locala.title));
        paramString.PRG.setOnClickListener(this.rID);
        paramString.PRG.setTag(new bq(paramca, null));
        paramString.PRG.setLongClickable(true);
        paramString.PRG.setTag(2131309367, this.PHv);
        paramString.PRG.setTag(2131306042, Integer.valueOf(paramInt));
        paramString.PRG.setOnLongClickListener(c(this.PhN));
        paramString.PRG.setOnTouchListener(this.PHs);
      }
      AppMethodBeat.o(233573);
      return;
      paramString.PRF.setVisibility(8);
    }
    paramString.PRG.setVisibility(0);
    parama1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(locala.username);
    if ((parama1 != null) && (!Util.isNullOrNil(parama1.field_brandIconURL)) && (!Util.isNullOrNil(parama1.field_nickname)))
    {
      parama = parama1.field_brandIconURL;
      parama1 = parama1.field_nickname;
      label328:
      String str = Util.nullAsNil(locala.username);
      paramString.gyr.setTag(null);
      paramString.pIN.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.PhN.Pwc.getContext(), parama1, paramString.pIN.getTextSize()));
      paramString.pIN.setTag(locala);
      com.tencent.mm.av.q.bcV().a(parama, paramString.gyr, this.Oxy);
      paramString.gyr.setTag(new bq(paramca, null));
      paramString.gyr.setTag(2131306042, Integer.valueOf(paramInt));
      paramString.gyr.setOnClickListener(this.rID);
      paramString.gyr.setOnLongClickListener(null);
      paramString.gyr.setContentDescription(aa.getDisplayName(str) + this.PhN.Pwc.getContext().getString(2131756221));
      if (Boolean.valueOf(((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.g.class)).cp(locala.appId + "#NotifyMessageStatus", "true")).booleanValue()) {
        break label626;
      }
      paramString.PRH.setVisibility(0);
    }
    for (this.PHu = true;; this.PHu = false)
    {
      paramString.PRI.setTag(paramca);
      paramString.PRI.setTag(2131306042, Integer.valueOf(paramInt));
      paramString.PRI.setOnClickListener(this.PHq);
      break;
      parama = Util.nullAsNil(locala.iconUrl);
      parama1 = Util.nullAsNil(locala.nickname);
      break label328;
      label626:
      paramString.PRH.setVisibility(8);
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(233576);
    if ((paramString == null) || (parama.userTV == null))
    {
      AppMethodBeat.o(233576);
      return;
    }
    paramca = ((f)parama1.bh(f.class)).bmF(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), paramca, parama.userTV.getTextSize()));
    AppMethodBeat.o(233576);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233575);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(233575);
      return false;
      paramMenuItem = com.tencent.mm.ag.a.a.HK(paramca.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hc(paramca.field_msgId);
      parama = Util.nullAsNil(paramMenuItem.appId);
      paramca = Util.nullAsNil(paramMenuItem.dCx);
      d(9, parama, Util.nullAsNil(paramMenuItem.msgId), paramca, null, 0);
    }
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233574);
    paramca = (bq)paramView.getTag();
    if (paramca == null)
    {
      AppMethodBeat.o(233574);
      return false;
    }
    paramm.a(paramca.position, 100, paramView.getContext().getString(2131757433), 2131690529);
    AppMethodBeat.o(233574);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 872415281;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
  {
    return false;
  }
  
  final boolean gTV()
  {
    return false;
  }
  
  protected final boolean gTX()
  {
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(233570);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = (ca)paramView.getTag();
      final int j = ((Integer)paramView.getTag(2131306042)).intValue();
      Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener onclick");
      if (localObject1 == null)
      {
        Log.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener, on more view click, but msg is null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233570);
        return;
      }
      Object localObject2 = com.tencent.mm.ag.a.a.HK(((eo)localObject1).field_content);
      final String str1 = Util.nullAsNil(((com.tencent.mm.ag.a.a)localObject2).appId);
      final String str2 = Util.nullAsNil(((com.tencent.mm.ag.a.a)localObject2).dCx);
      final String str3 = Util.nullAsNil(((com.tencent.mm.ag.a.a)localObject2).nickname);
      final String str4 = Util.nullAsNil(((com.tencent.mm.ag.a.a)localObject2).msgId);
      Context localContext = paramView.getContext();
      if (d.h(d.this)) {}
      for (int i = 1;; i = 0)
      {
        localObject2 = new com.tencent.mm.ui.appbrand.b(localContext, i, ((com.tencent.mm.ag.a.a)localObject2).username);
        ((com.tencent.mm.ui.appbrand.b)localObject2).OMR = new b.a()
        {
          public final void gKh()
          {
            AppMethodBeat.i(233566);
            this.PHA.dismiss();
            Object localObject = this.PHA.OMQ;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              b.b localb = (b.b)((Iterator)localObject).next();
              if (localb.pWp) {
                localStringBuilder.append(localb.OMU).append(":");
              }
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.setLength(localStringBuilder.length() - 1);
            }
            d.a(d.this, str3, str1, str4, str2, localStringBuilder.toString(), j);
            AppMethodBeat.o(233566);
          }
          
          public final void gKi()
          {
            AppMethodBeat.i(233567);
            this.PHA.dismiss();
            d.a(d.this, paramView, str1);
            final s locals = new s(this.iBF.field_content);
            d locald = d.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755998);
            d.a(locald, com.tencent.mm.ui.base.h.a(localContext, paramView.getResources().getString(2131756029), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(233565);
                bg.azz().a(locals);
                AppMethodBeat.o(233565);
              }
            }));
            bg.azz().a(locals, 0);
            int i = d.a(d.this, j);
            d.a(d.this, 3, str1, str4, str2, null, i);
            AppMethodBeat.o(233567);
          }
          
          public final void gKj()
          {
            AppMethodBeat.i(233568);
            this.PHA.dismiss();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hc(this.iBF.field_msgId);
            AppMethodBeat.o(233568);
          }
          
          public final void gKk()
          {
            AppMethodBeat.i(233569);
            this.PHA.dismiss();
            Object localObject = com.tencent.mm.ag.a.a.HK(this.iBF.field_content);
            Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { ((com.tencent.mm.ag.a.a)localObject).username });
            localObject = new Intent().putExtra("key_username", ((com.tencent.mm.ag.a.a)localObject).username);
            com.tencent.mm.br.c.b(paramView.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
            AppMethodBeat.o(233569);
          }
        };
        ((com.tencent.mm.ui.appbrand.b)localObject2).gv(paramView);
        i = d.a(d.this, j);
        d.a(d.this, 7, str1, str4, str2, null, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(233570);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d
 * JD-Core Version:    0.7.0.1
 */