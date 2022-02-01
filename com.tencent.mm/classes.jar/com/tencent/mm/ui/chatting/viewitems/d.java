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
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.dct;
import com.tencent.mm.protocal.protobuf.eho;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.appbrand.b.a;
import com.tencent.mm.ui.appbrand.b.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
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
  private p AVf;
  private com.tencent.mm.aw.a.a.c ISW;
  private com.tencent.mm.ui.chatting.e.a JBI;
  private View.OnClickListener JYG;
  private View.OnClickListener JYH;
  private View.OnTouchListener JYI;
  private com.tencent.mm.plugin.appbrand.service.g JYJ;
  private boolean JYK;
  private int[] JYL;
  private p fQJ;
  private int qjh;
  private View.OnClickListener qkD;
  
  public d()
  {
    AppMethodBeat.i(194303);
    this.JYL = new int[2];
    com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
    locala.hfi = true;
    locala.idD = 2131231342;
    this.ISW = locala.aJc();
    com.tencent.mm.kernel.g.ajA();
    this.qjh = com.tencent.mm.kernel.a.getUin();
    this.JYJ = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class));
    this.JYG = new a((byte)0);
    this.JYH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194287);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = (com.tencent.mm.ai.a.a)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { paramAnonymousView.username });
        d.a(d.this, paramAnonymousView.username, paramAnonymousView.appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(194287);
      }
    };
    this.qkD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194289);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (d.a(d.this) != null) {}
        for (localObject1 = d.a(d.this).aYA();; localObject1 = null)
        {
          Object localObject2 = (bk)paramAnonymousView.getTag();
          int i = ((Integer)paramAnonymousView.getTag(2131303355)).intValue();
          i = d.a(d.this, i);
          Object localObject4 = com.tencent.mm.ai.a.a.yy(((com.tencent.mm.pluginsdk.ui.chat.c)localObject2).dBd.field_content);
          paramAnonymousView = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject4).appId);
          localObject2 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject4).msgId);
          String str = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject4).dki);
          Object localObject3 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject4).username);
          int j = ((com.tencent.mm.ai.a.a)localObject4).version;
          int k = ((com.tencent.mm.ai.a.a)localObject4).type;
          localObject4 = com.tencent.mm.ai.a.a.yz(((com.tencent.mm.ai.a.a)localObject4).title);
          ad.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) container click", new Object[] { localObject3 });
          com.tencent.mm.plugin.appbrand.api.f localf = new com.tencent.mm.plugin.appbrand.api.f();
          localf.username = ((String)localObject3);
          localf.hQh = k;
          localf.version = j;
          localf.jCN = str;
          localf.dkh = ("1162:" + (String)localObject2 + ":" + (String)localObject4);
          localf.scene = 1162;
          localObject3 = new AppBrandLaunchFromNotifyReferrer();
          ((AppBrandLaunchFromNotifyReferrer)localObject3).appId = bt.nullAsNil(paramAnonymousView);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).uin = d.b(d.this);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).jXN = 2;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).jXO = bt.nullAsNil((String)localObject2);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).content = ((String)localObject4);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).jXP = i;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).jXQ = ((String)localObject1);
          localf.jCZ = ((AppBrandLaunchFromNotifyReferrer)localObject3);
          ((o)com.tencent.mm.kernel.g.ab(o.class)).a(d.c(d.this).JOR.getContext(), localf);
          ((com.tencent.mm.ui.chatting.d.b.g)d.c(d.this).bh(com.tencent.mm.ui.chatting.d.b.g.class)).adh(i);
          d.a(d.this, 4, paramAnonymousView, (String)localObject2, str, null, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194289);
          return;
        }
      }
    };
    this.JYI = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194290);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(194290);
          return false;
          d.d(d.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          d.d(d.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    AppMethodBeat.o(194303);
  }
  
  private void c(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(194309);
    String str = null;
    if (this.JYJ != null) {
      str = this.JYJ.aYA();
    }
    ad.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "appbrand notify report(%d), eventId : %d, appId %s, msgId %s, pagePath %s, label %s", new Object[] { Integer.valueOf(19724), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.g.yhR.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString1, paramString3, paramString4, paramString2, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, str });
    AppMethodBeat.o(194309);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(194304);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493408, null);
      localView.setTag(new bq().gN(localView));
    }
    AppMethodBeat.o(194304);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(194305);
    this.JBI = parama1;
    paramString = (bq)parama;
    com.tencent.mm.ai.a.a locala = com.tencent.mm.ai.a.a.yy(parambu.field_content);
    if (parambu.field_isSend == 2)
    {
      paramString.Kix.setVisibility(0);
      paramString.fTP.setVisibility(8);
    }
    for (;;)
    {
      parama = ((com.tencent.mm.ui.chatting.d.b.k)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.k.class)).ada(0);
      if ((parama != null) && (parama.field_isSend == 2)) {
        ((com.tencent.mm.ui.chatting.d.b.k)this.JBI.bh(com.tencent.mm.ui.chatting.d.b.k.class)).adc(1);
      }
      if (parambu.field_isSend != 2) {
        break;
      }
      paramString.Kiy.setVisibility(8);
      if (parambu.field_isSend != 2)
      {
        paramString.titleTv.setText(bt.nullAsNil(locala.title));
        paramString.Kiy.setOnClickListener(this.qkD);
        paramString.Kiy.setTag(new bk(parambu, null));
        paramString.Kiy.setLongClickable(true);
        paramString.Kiy.setTag(2131306044, this.JYL);
        paramString.Kiy.setTag(2131303355, Integer.valueOf(paramInt));
        paramString.Kiy.setOnLongClickListener(c(this.JBI));
        paramString.Kiy.setOnTouchListener(this.JYI);
      }
      AppMethodBeat.o(194305);
      return;
      paramString.Kix.setVisibility(8);
    }
    paramString.Kiy.setVisibility(0);
    parama1 = ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).Nt(locala.username);
    if ((parama1 != null) && (!bt.isNullOrNil(parama1.field_brandIconURL)) && (!bt.isNullOrNil(parama1.field_nickname)))
    {
      parama = parama1.field_brandIconURL;
      parama1 = parama1.field_nickname;
      label328:
      String str = bt.nullAsNil(locala.username);
      paramString.fRd.setTag(null);
      paramString.opA.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.JBI.JOR.getContext(), parama1, paramString.opA.getTextSize()));
      paramString.opA.setTag(locala);
      com.tencent.mm.aw.q.aIJ().a(parama, paramString.fRd, this.ISW);
      paramString.fRd.setTag(new bk(parambu, null));
      paramString.fRd.setTag(2131303355, Integer.valueOf(paramInt));
      paramString.fRd.setOnClickListener(this.qkD);
      paramString.fRd.setOnLongClickListener(null);
      paramString.fRd.setContentDescription(v.zf(str) + this.JBI.JOR.getContext().getString(2131756087));
      if (Boolean.valueOf(((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).cc(locala.appId + "#NotifyMessageStatus", "true")).booleanValue()) {
        break label626;
      }
      paramString.Kiz.setVisibility(0);
    }
    for (this.JYK = true;; this.JYK = false)
    {
      paramString.KiA.setTag(parambu);
      paramString.KiA.setTag(2131303355, Integer.valueOf(paramInt));
      paramString.KiA.setOnClickListener(this.JYG);
      break;
      parama = bt.nullAsNil(locala.iconUrl);
      parama1 = bt.nullAsNil(locala.nickname);
      break label328;
      label626:
      paramString.Kiz.setVisibility(8);
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(194308);
    if ((paramString == null) || (parama.yEk == null))
    {
      AppMethodBeat.o(194308);
      return;
    }
    parambu = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aWa(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), parambu, parama.yEk.getTextSize()));
    AppMethodBeat.o(194308);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(194307);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194307);
      return false;
      paramMenuItem = com.tencent.mm.ai.a.a.yy(parambu.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xZ(parambu.field_msgId);
      parama = bt.nullAsNil(paramMenuItem.appId);
      parambu = bt.nullAsNil(paramMenuItem.dki);
      c(9, parama, bt.nullAsNil(paramMenuItem.msgId), parambu, null, 0);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194306);
    parambu = (bk)paramView.getTag();
    if (parambu == null)
    {
      AppMethodBeat.o(194306);
      return false;
    }
    paraml.a(parambu.position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(194306);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == 872415281;
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
  
  final boolean fHi()
  {
    return false;
  }
  
  protected final boolean fHk()
  {
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(194302);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      localObject1 = (bu)paramView.getTag();
      final int j = ((Integer)paramView.getTag(2131303355)).intValue();
      ad.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener onclick");
      if (localObject1 == null)
      {
        ad.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener, on more view click, but msg is null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(194302);
        return;
      }
      Object localObject2 = com.tencent.mm.ai.a.a.yy(((ei)localObject1).field_content);
      final String str1 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject2).appId);
      final String str2 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject2).dki);
      final String str3 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject2).nickname);
      final String str4 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject2).msgId);
      Context localContext = paramView.getContext();
      if (d.h(d.this)) {}
      for (int i = 1;; i = 0)
      {
        localObject2 = new com.tencent.mm.ui.appbrand.b(localContext, i, ((com.tencent.mm.ai.a.a)localObject2).username);
        ((com.tencent.mm.ui.appbrand.b)localObject2).Jho = new b.a()
        {
          public final void fyh()
          {
            AppMethodBeat.i(194298);
            this.JYQ.dismiss();
            Object localObject = this.JYQ.Jhn;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              b.b localb = (b.b)((Iterator)localObject).next();
              if (localb.oBZ) {
                localStringBuilder.append(localb.Jhr).append(":");
              }
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.setLength(localStringBuilder.length() - 1);
            }
            d.a(d.this, str3, str1, str4, str2, localStringBuilder.toString(), j);
            AppMethodBeat.o(194298);
          }
          
          public final void fyi()
          {
            AppMethodBeat.i(194299);
            this.JYQ.dismiss();
            d.a(d.this, paramView, str1);
            final s locals = new s(this.hED.field_content);
            d locald = d.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755906);
            d.a(locald, h.b(localContext, paramView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(194297);
                ba.aiU().a(locals);
                AppMethodBeat.o(194297);
              }
            }));
            ba.aiU().a(locals, 0);
            int i = d.a(d.this, j);
            d.a(d.this, 3, str1, str4, str2, null, i);
            AppMethodBeat.o(194299);
          }
          
          public final void fyj()
          {
            AppMethodBeat.i(194300);
            this.JYQ.dismiss();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xZ(this.hED.field_msgId);
            AppMethodBeat.o(194300);
          }
          
          public final void fyk()
          {
            AppMethodBeat.i(194301);
            this.JYQ.dismiss();
            Object localObject = com.tencent.mm.ai.a.a.yy(this.hED.field_content);
            ad.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { ((com.tencent.mm.ai.a.a)localObject).username });
            localObject = new Intent().putExtra("key_username", ((com.tencent.mm.ai.a.a)localObject).username);
            com.tencent.mm.bs.d.b(paramView.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
            AppMethodBeat.o(194301);
          }
        };
        ((com.tencent.mm.ui.appbrand.b)localObject2).ge(paramView);
        i = d.a(d.this, j);
        d.a(d.this, 7, str1, str4, str2, null, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(194302);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d
 * JD-Core Version:    0.7.0.1
 */