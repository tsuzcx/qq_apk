package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextMenu;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.av.o;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.ebk;
import com.tencent.mm.protocal.protobuf.eci;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.appbrand.b.a;
import com.tencent.mm.ui.appbrand.b.b;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.widget.a.e;
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
  private com.tencent.mm.ui.chatting.d.a HNS;
  private com.tencent.mm.av.a.a.c HfF;
  private View.OnClickListener Iih;
  private View.OnClickListener Iii;
  private View.OnTouchListener Iij;
  private com.tencent.mm.plugin.appbrand.service.g Iik;
  private boolean Iil;
  private int[] Iim;
  private p fxw;
  private int pFC;
  private View.OnClickListener pGY;
  private p zDG;
  
  public d()
  {
    AppMethodBeat.i(196676);
    this.Iim = new int[2];
    com.tencent.mm.av.a.a.c.a locala = new com.tencent.mm.av.a.a.c.a();
    locala.gLt = true;
    locala.hKI = 2131231342;
    this.HfF = locala.aFT();
    com.tencent.mm.kernel.g.agP();
    this.pFC = com.tencent.mm.kernel.a.getUin();
    this.Iik = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class));
    this.Iih = new a((byte)0);
    this.Iii = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196660);
        paramAnonymousView = (com.tencent.mm.ah.a.a)paramAnonymousView.getTag();
        ac.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { paramAnonymousView.username });
        d.a(d.this, paramAnonymousView.username, paramAnonymousView.appId);
        AppMethodBeat.o(196660);
      }
    };
    this.pGY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196662);
        if (d.a(d.this) != null) {}
        for (String str1 = d.a(d.this).aVg();; str1 = null)
        {
          Object localObject1 = (bj)paramAnonymousView.getTag();
          int i = ((Integer)paramAnonymousView.getTag(2131303355)).intValue();
          i = d.a(d.this, i);
          Object localObject3 = com.tencent.mm.ah.a.a.vH(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).dpq.field_content);
          paramAnonymousView = bs.nullAsNil(((com.tencent.mm.ah.a.a)localObject3).appId);
          localObject1 = bs.nullAsNil(((com.tencent.mm.ah.a.a)localObject3).dtG);
          String str2 = bs.nullAsNil(((com.tencent.mm.ah.a.a)localObject3).cYQ);
          Object localObject2 = bs.nullAsNil(((com.tencent.mm.ah.a.a)localObject3).username);
          int j = ((com.tencent.mm.ah.a.a)localObject3).version;
          int k = ((com.tencent.mm.ah.a.a)localObject3).type;
          localObject3 = com.tencent.mm.ah.a.a.vI(((com.tencent.mm.ah.a.a)localObject3).title);
          ac.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) container click", new Object[] { localObject2 });
          com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
          localf.username = ((String)localObject2);
          localf.hxM = k;
          localf.version = j;
          localf.jjf = str2;
          localf.cYP = ("1162:" + (String)localObject1 + ":" + (String)localObject3);
          localf.scene = 1162;
          localObject2 = new AppBrandLaunchFromNotifyReferrer();
          ((AppBrandLaunchFromNotifyReferrer)localObject2).appId = bs.nullAsNil(paramAnonymousView);
          ((AppBrandLaunchFromNotifyReferrer)localObject2).uin = d.b(d.this);
          ((AppBrandLaunchFromNotifyReferrer)localObject2).jDM = 2;
          ((AppBrandLaunchFromNotifyReferrer)localObject2).jDN = bs.nullAsNil((String)localObject1);
          ((AppBrandLaunchFromNotifyReferrer)localObject2).content = ((String)localObject3);
          ((AppBrandLaunchFromNotifyReferrer)localObject2).jDO = i;
          ((AppBrandLaunchFromNotifyReferrer)localObject2).jDP = str1;
          localf.jjr = ((AppBrandLaunchFromNotifyReferrer)localObject2);
          ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(d.c(d.this).HZF.getContext(), localf);
          ((com.tencent.mm.ui.chatting.c.b.g)d.c(d.this).bf(com.tencent.mm.ui.chatting.c.b.g.class)).aaV(i);
          d.a(d.this, 4, paramAnonymousView, (String)localObject1, str2, null, i);
          AppMethodBeat.o(196662);
          return;
        }
      }
    };
    this.Iij = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(196663);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(196663);
          return false;
          d.d(d.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          d.d(d.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    AppMethodBeat.o(196676);
  }
  
  private void c(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(196682);
    String str = null;
    if (this.Iik != null) {
      str = this.Iik.aVg();
    }
    ac.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "appbrand notify report(%d), eventId : %d, appId %s, msgId %s, pagePath %s, label %s", new Object[] { Integer.valueOf(19724), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.h.wUl.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString1, paramString3, paramString4, paramString2, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, str });
    AppMethodBeat.o(196682);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(196677);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493408, null);
      localView.setTag(new bp().gw(localView));
    }
    AppMethodBeat.o(196677);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(196678);
    this.HNS = parama1;
    paramString = (bp)parama;
    com.tencent.mm.ah.a.a locala = com.tencent.mm.ah.a.a.vH(parambo.field_content);
    if (parambo.field_isSend == 2)
    {
      paramString.IrS.setVisibility(0);
      paramString.fAz.setVisibility(8);
    }
    for (;;)
    {
      parama = ((i)this.HNS.bf(i.class)).aaP(0);
      if ((parama != null) && (parama.field_isSend == 2)) {
        ((i)this.HNS.bf(i.class)).aaR(1);
      }
      if (parambo.field_isSend != 2) {
        break;
      }
      paramString.IrT.setVisibility(8);
      if (parambo.field_isSend != 2)
      {
        paramString.titleTv.setText(bs.nullAsNil(locala.title));
        paramString.IrT.setOnClickListener(this.pGY);
        paramString.IrT.setTag(new bj(parambo, null));
        paramString.IrT.setLongClickable(true);
        paramString.IrT.setTag(2131306044, this.Iim);
        paramString.IrT.setTag(2131303355, Integer.valueOf(paramInt));
        paramString.IrT.setOnLongClickListener(c(this.HNS));
        paramString.IrT.setOnTouchListener(this.Iij);
      }
      AppMethodBeat.o(196678);
      return;
      paramString.IrS.setVisibility(8);
    }
    paramString.IrT.setVisibility(0);
    parama1 = ((m)com.tencent.mm.kernel.g.ab(m.class)).Ka(locala.username);
    if ((parama1 != null) && (!bs.isNullOrNil(parama1.field_brandIconURL)) && (!bs.isNullOrNil(parama1.field_nickname)))
    {
      parama = parama1.field_brandIconURL;
      parama1 = parama1.field_nickname;
      label328:
      String str = bs.nullAsNil(locala.username);
      paramString.fxQ.setTag(null);
      paramString.nMU.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.HNS.HZF.getContext(), parama1, paramString.nMU.getTextSize()));
      paramString.nMU.setTag(locala);
      o.aFB().a(parama, paramString.fxQ, this.HfF);
      paramString.fxQ.setTag(new bj(parambo, null));
      paramString.fxQ.setTag(2131303355, Integer.valueOf(paramInt));
      paramString.fxQ.setOnClickListener(this.pGY);
      paramString.fxQ.setOnLongClickListener(null);
      paramString.fxQ.setContentDescription(v.wk(str) + this.HNS.HZF.getContext().getString(2131756087));
      if (Boolean.valueOf(((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).ca(locala.appId + "#NotifyMessageStatus", "true")).booleanValue()) {
        break label626;
      }
      paramString.IrU.setVisibility(0);
    }
    for (this.Iil = true;; this.Iil = false)
    {
      paramString.IrV.setTag(parambo);
      paramString.IrV.setTag(2131303355, Integer.valueOf(paramInt));
      paramString.IrV.setOnClickListener(this.Iih);
      break;
      parama = bs.nullAsNil(locala.iconUrl);
      parama1 = bs.nullAsNil(locala.nickname);
      break label328;
      label626:
      paramString.IrU.setVisibility(8);
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(196681);
    if ((paramString == null) || (parama.xpH == null))
    {
      AppMethodBeat.o(196681);
      return;
    }
    parambo = ((com.tencent.mm.ui.chatting.c.b.f)parama1.bf(com.tencent.mm.ui.chatting.c.b.f.class)).aQj(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.k.b(parama1.HZF.getContext(), parambo, parama.xpH.getTextSize()));
    AppMethodBeat.o(196681);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(196679);
    parambo = (bj)paramView.getTag();
    if (parambo == null)
    {
      AppMethodBeat.o(196679);
      return false;
    }
    paramContextMenu.add(parambo.position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(196679);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(196680);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(196680);
      return false;
      paramMenuItem = com.tencent.mm.ah.a.a.vH(parambo.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vQ(parambo.field_msgId);
      parama = bs.nullAsNil(paramMenuItem.appId);
      parambo = bs.nullAsNil(paramMenuItem.cYQ);
      c(9, parama, bs.nullAsNil(paramMenuItem.dtG), parambo, null, 0);
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == 872415281;
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
  
  final boolean fqv()
  {
    return false;
  }
  
  protected final boolean fqx()
  {
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(196675);
      final bo localbo = (bo)paramView.getTag();
      final int j = ((Integer)paramView.getTag(2131303355)).intValue();
      ac.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener onclick");
      if (localbo == null)
      {
        ac.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener, on more view click, but msg is null.");
        AppMethodBeat.o(196675);
        return;
      }
      Object localObject = com.tencent.mm.ah.a.a.vH(localbo.field_content);
      final String str1 = bs.nullAsNil(((com.tencent.mm.ah.a.a)localObject).appId);
      final String str2 = bs.nullAsNil(((com.tencent.mm.ah.a.a)localObject).cYQ);
      final String str3 = bs.nullAsNil(((com.tencent.mm.ah.a.a)localObject).nickname);
      final String str4 = bs.nullAsNil(((com.tencent.mm.ah.a.a)localObject).dtG);
      Context localContext = paramView.getContext();
      if (d.h(d.this)) {}
      for (int i = 1;; i = 0)
      {
        localObject = new com.tencent.mm.ui.appbrand.b(localContext, i, ((com.tencent.mm.ah.a.a)localObject).username);
        ((com.tencent.mm.ui.appbrand.b)localObject).Hty = new b.a()
        {
          public final void fhR()
          {
            AppMethodBeat.i(196671);
            this.Iir.dismiss();
            Object localObject = this.Iir.Htx;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              b.b localb = (b.b)((Iterator)localObject).next();
              if (localb.nYF) {
                localStringBuilder.append(localb.HtB).append(":");
              }
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.setLength(localStringBuilder.length() - 1);
            }
            d.a(d.this, str3, str1, str4, str2, localStringBuilder.toString(), j);
            AppMethodBeat.o(196671);
          }
          
          public final void fhS()
          {
            AppMethodBeat.i(196672);
            this.Iir.dismiss();
            d.a(d.this, paramView, str1);
            final s locals = new s(localbo.field_content);
            d locald = d.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755906);
            d.a(locald, com.tencent.mm.ui.base.h.b(localContext, paramView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(196670);
                az.agi().a(locals);
                AppMethodBeat.o(196670);
              }
            }));
            az.agi().a(locals, 0);
            int i = d.a(d.this, j);
            d.a(d.this, 3, str1, str4, str2, null, i);
            AppMethodBeat.o(196672);
          }
          
          public final void fhT()
          {
            AppMethodBeat.i(196673);
            this.Iir.dismiss();
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vQ(localbo.field_msgId);
            AppMethodBeat.o(196673);
          }
          
          public final void fhU()
          {
            AppMethodBeat.i(196674);
            this.Iir.dismiss();
            Object localObject = com.tencent.mm.ah.a.a.vH(localbo.field_content);
            ac.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { ((com.tencent.mm.ah.a.a)localObject).username });
            localObject = new Intent().putExtra("key_username", ((com.tencent.mm.ah.a.a)localObject).username);
            com.tencent.mm.br.d.b(paramView.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
            AppMethodBeat.o(196674);
          }
        };
        ((com.tencent.mm.ui.appbrand.b)localObject).fP(paramView);
        i = d.a(d.this, j);
        d.a(d.this, 7, str1, str4, str2, null, i);
        AppMethodBeat.o(196675);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d
 * JD-Core Version:    0.7.0.1
 */