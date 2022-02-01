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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.ddn;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.protocal.protobuf.ekf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.appbrand.b.a;
import com.tencent.mm.ui.appbrand.b.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  private com.tencent.mm.ui.base.p BmD;
  private com.tencent.mm.ui.chatting.e.a JWz;
  private com.tencent.mm.av.a.a.c JnE;
  private View.OnClickListener KuZ;
  private View.OnClickListener Kva;
  private View.OnTouchListener Kvb;
  private com.tencent.mm.plugin.appbrand.service.g Kvc;
  private boolean Kvd;
  private int[] Kve;
  private com.tencent.mm.ui.base.p fSP;
  private int qpM;
  private View.OnClickListener qri;
  
  public d()
  {
    AppMethodBeat.i(187695);
    this.Kve = new int[2];
    com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
    locala.hhW = true;
    locala.igv = 2131231342;
    this.JnE = locala.aJu();
    com.tencent.mm.kernel.g.ajP();
    this.qpM = com.tencent.mm.kernel.a.getUin();
    this.Kvc = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class));
    this.KuZ = new a((byte)0);
    this.Kva = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187679);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = (com.tencent.mm.ah.a.a)paramAnonymousView.getTag();
        ae.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { paramAnonymousView.username });
        d.a(d.this, paramAnonymousView.username, paramAnonymousView.appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187679);
      }
    };
    this.qri = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(187681);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (d.a(d.this) != null) {}
        for (localObject1 = d.a(d.this).aYW();; localObject1 = null)
        {
          Object localObject2 = (bk)paramAnonymousView.getTag();
          int i = ((Integer)paramAnonymousView.getTag(2131303355)).intValue();
          i = d.a(d.this, i);
          Object localObject4 = com.tencent.mm.ah.a.a.zi(((com.tencent.mm.pluginsdk.ui.chat.c)localObject2).dCi.field_content);
          paramAnonymousView = bu.nullAsNil(((com.tencent.mm.ah.a.a)localObject4).appId);
          localObject2 = bu.nullAsNil(((com.tencent.mm.ah.a.a)localObject4).msgId);
          String str = bu.nullAsNil(((com.tencent.mm.ah.a.a)localObject4).dlk);
          Object localObject3 = bu.nullAsNil(((com.tencent.mm.ah.a.a)localObject4).username);
          int j = ((com.tencent.mm.ah.a.a)localObject4).version;
          int k = ((com.tencent.mm.ah.a.a)localObject4).type;
          localObject4 = com.tencent.mm.ah.a.a.zj(((com.tencent.mm.ah.a.a)localObject4).title);
          ae.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) container click", new Object[] { localObject3 });
          com.tencent.mm.plugin.appbrand.api.f localf = new com.tencent.mm.plugin.appbrand.api.f();
          localf.username = ((String)localObject3);
          localf.hSZ = k;
          localf.version = j;
          localf.jFL = str;
          localf.dlj = ("1162:" + (String)localObject2 + ":" + (String)localObject4);
          localf.scene = 1162;
          localObject3 = new AppBrandLaunchFromNotifyReferrer();
          ((AppBrandLaunchFromNotifyReferrer)localObject3).appId = bu.nullAsNil(paramAnonymousView);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).uin = d.b(d.this);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).kbc = 2;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).kbd = bu.nullAsNil((String)localObject2);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).content = ((String)localObject4);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).kbe = i;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).kbf = ((String)localObject1);
          localf.jFX = ((AppBrandLaunchFromNotifyReferrer)localObject3);
          ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(d.c(d.this).Kkd.getContext(), localf);
          ((com.tencent.mm.ui.chatting.d.b.g)d.c(d.this).bh(com.tencent.mm.ui.chatting.d.b.g.class)).adO(i);
          d.a(d.this, 4, paramAnonymousView, (String)localObject2, str, null, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187681);
          return;
        }
      }
    };
    this.Kvb = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(187682);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(187682);
          return false;
          d.d(d.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          d.d(d.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    AppMethodBeat.o(187695);
  }
  
  private void c(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(187701);
    String str = null;
    if (this.Kvc != null) {
      str = this.Kvc.aYW();
    }
    ae.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "appbrand notify report(%d), eventId : %d, appId %s, msgId %s, pagePath %s, label %s", new Object[] { Integer.valueOf(19724), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.g.yxI.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString1, paramString3, paramString4, paramString2, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, str });
    AppMethodBeat.o(187701);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(187696);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493408, null);
      localView.setTag(new bq().gS(localView));
    }
    AppMethodBeat.o(187696);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(187697);
    this.JWz = parama1;
    paramString = (bq)parama;
    com.tencent.mm.ah.a.a locala = com.tencent.mm.ah.a.a.zi(parambv.field_content);
    if (parambv.field_isSend == 2)
    {
      paramString.KER.setVisibility(0);
      paramString.fVV.setVisibility(8);
    }
    for (;;)
    {
      parama = ((com.tencent.mm.ui.chatting.d.b.k)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.k.class)).adI(0);
      if ((parama != null) && (parama.field_isSend == 2)) {
        ((com.tencent.mm.ui.chatting.d.b.k)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.k.class)).adK(1);
      }
      if (parambv.field_isSend != 2) {
        break;
      }
      paramString.KES.setVisibility(8);
      if (parambv.field_isSend != 2)
      {
        paramString.titleTv.setText(bu.nullAsNil(locala.title));
        paramString.KES.setOnClickListener(this.qri);
        paramString.KES.setTag(new bk(parambv, null));
        paramString.KES.setLongClickable(true);
        paramString.KES.setTag(2131306044, this.Kve);
        paramString.KES.setTag(2131303355, Integer.valueOf(paramInt));
        paramString.KES.setOnLongClickListener(c(this.JWz));
        paramString.KES.setOnTouchListener(this.Kvb);
      }
      AppMethodBeat.o(187697);
      return;
      paramString.KER.setVisibility(8);
    }
    paramString.KES.setVisibility(0);
    parama1 = ((o)com.tencent.mm.kernel.g.ab(o.class)).Ob(locala.username);
    if ((parama1 != null) && (!bu.isNullOrNil(parama1.field_brandIconURL)) && (!bu.isNullOrNil(parama1.field_nickname)))
    {
      parama = parama1.field_brandIconURL;
      parama1 = parama1.field_nickname;
      label328:
      String str = bu.nullAsNil(locala.username);
      paramString.fTj.setTag(null);
      paramString.ovs.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.JWz.Kkd.getContext(), parama1, paramString.ovs.getTextSize()));
      paramString.ovs.setTag(locala);
      com.tencent.mm.av.q.aJb().a(parama, paramString.fTj, this.JnE);
      paramString.fTj.setTag(new bk(parambv, null));
      paramString.fTj.setTag(2131303355, Integer.valueOf(paramInt));
      paramString.fTj.setOnClickListener(this.qri);
      paramString.fTj.setOnLongClickListener(null);
      paramString.fTj.setContentDescription(w.zP(str) + this.JWz.Kkd.getContext().getString(2131756087));
      if (Boolean.valueOf(((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).cc(locala.appId + "#NotifyMessageStatus", "true")).booleanValue()) {
        break label626;
      }
      paramString.KET.setVisibility(0);
    }
    for (this.Kvd = true;; this.Kvd = false)
    {
      paramString.KEU.setTag(parambv);
      paramString.KEU.setTag(2131303355, Integer.valueOf(paramInt));
      paramString.KEU.setOnClickListener(this.KuZ);
      break;
      parama = bu.nullAsNil(locala.iconUrl);
      parama1 = bu.nullAsNil(locala.nickname);
      break label328;
      label626:
      paramString.KET.setVisibility(8);
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(187700);
    if ((paramString == null) || (parama.yUp == null))
    {
      AppMethodBeat.o(187700);
      return;
    }
    parambv = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aXB(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), parambv, parama.yUp.getTextSize()));
    AppMethodBeat.o(187700);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(187699);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(187699);
      return false;
      paramMenuItem = com.tencent.mm.ah.a.a.zi(parambv.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().yt(parambv.field_msgId);
      parama = bu.nullAsNil(paramMenuItem.appId);
      parambv = bu.nullAsNil(paramMenuItem.dlk);
      c(9, parama, bu.nullAsNil(paramMenuItem.msgId), parambv, null, 0);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187698);
    parambv = (bk)paramView.getTag();
    if (parambv == null)
    {
      AppMethodBeat.o(187698);
      return false;
    }
    paraml.a(parambv.position, 100, paramView.getContext().getString(2131757221), 2131690384);
    AppMethodBeat.o(187698);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == 872415281;
  }
  
  final boolean fLA()
  {
    return false;
  }
  
  protected final boolean fLC()
  {
    return false;
  }
  
  protected final boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(187694);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      localObject1 = (bv)paramView.getTag();
      final int j = ((Integer)paramView.getTag(2131303355)).intValue();
      ae.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener onclick");
      if (localObject1 == null)
      {
        ae.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener, on more view click, but msg is null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187694);
        return;
      }
      Object localObject2 = com.tencent.mm.ah.a.a.zi(((ei)localObject1).field_content);
      final String str1 = bu.nullAsNil(((com.tencent.mm.ah.a.a)localObject2).appId);
      final String str2 = bu.nullAsNil(((com.tencent.mm.ah.a.a)localObject2).dlk);
      final String str3 = bu.nullAsNil(((com.tencent.mm.ah.a.a)localObject2).nickname);
      final String str4 = bu.nullAsNil(((com.tencent.mm.ah.a.a)localObject2).msgId);
      Context localContext = paramView.getContext();
      if (d.h(d.this)) {}
      for (int i = 1;; i = 0)
      {
        localObject2 = new com.tencent.mm.ui.appbrand.b(localContext, i, ((com.tencent.mm.ah.a.a)localObject2).username);
        ((com.tencent.mm.ui.appbrand.b)localObject2).JBZ = new b.a()
        {
          public final void fCj()
          {
            AppMethodBeat.i(187690);
            this.Kvj.dismiss();
            Object localObject = this.Kvj.JBY;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              b.b localb = (b.b)((Iterator)localObject).next();
              if (localb.oIB) {
                localStringBuilder.append(localb.JCc).append(":");
              }
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.setLength(localStringBuilder.length() - 1);
            }
            d.a(d.this, str3, str1, str4, str2, localStringBuilder.toString(), j);
            AppMethodBeat.o(187690);
          }
          
          public final void fCk()
          {
            AppMethodBeat.i(187691);
            this.Kvj.dismiss();
            d.a(d.this, paramView, str1);
            final s locals = new s(this.hHv.field_content);
            d locald = d.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755906);
            d.a(locald, h.b(localContext, paramView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(187689);
                bc.ajj().a(locals);
                AppMethodBeat.o(187689);
              }
            }));
            bc.ajj().a(locals, 0);
            int i = d.a(d.this, j);
            d.a(d.this, 3, str1, str4, str2, null, i);
            AppMethodBeat.o(187691);
          }
          
          public final void fCl()
          {
            AppMethodBeat.i(187692);
            this.Kvj.dismiss();
            ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().yt(this.hHv.field_msgId);
            AppMethodBeat.o(187692);
          }
          
          public final void fCm()
          {
            AppMethodBeat.i(187693);
            this.Kvj.dismiss();
            Object localObject = com.tencent.mm.ah.a.a.zi(this.hHv.field_content);
            ae.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { ((com.tencent.mm.ah.a.a)localObject).username });
            localObject = new Intent().putExtra("key_username", ((com.tencent.mm.ah.a.a)localObject).username);
            com.tencent.mm.br.d.b(paramView.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
            AppMethodBeat.o(187693);
          }
        };
        ((com.tencent.mm.ui.appbrand.b)localObject2).gd(paramView);
        i = d.a(d.this, j);
        d.a(d.this, 7, str1, str4, str2, null, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(187694);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d
 * JD-Core Version:    0.7.0.1
 */