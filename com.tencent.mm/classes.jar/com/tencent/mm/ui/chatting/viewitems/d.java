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
import com.tencent.mm.al.q;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.appbrand.b.a;
import com.tencent.mm.ui.appbrand.b.b;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class d
  extends c
{
  private com.tencent.mm.aw.a.a.c FGx;
  private View.OnClickListener GIk;
  private View.OnClickListener GIl;
  private View.OnTouchListener GIm;
  private boolean GIn;
  private int[] GIo;
  private com.tencent.mm.ui.chatting.d.a Gob;
  private p ftP;
  private int pcr;
  private View.OnClickListener pdN;
  private p yqi;
  
  public d()
  {
    AppMethodBeat.i(191610);
    this.GIo = new int[2];
    com.tencent.mm.aw.a.a.c.a locala = new com.tencent.mm.aw.a.a.c.a();
    locala.gkG = true;
    locala.hkf = 2131231342;
    this.FGx = locala.azc();
    com.tencent.mm.kernel.g.afz();
    this.pcr = com.tencent.mm.kernel.a.getUin();
    this.GIk = new a((byte)0);
    this.GIl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191594);
        paramAnonymousView = (com.tencent.mm.ai.a.a)paramAnonymousView.getTag();
        ad.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { paramAnonymousView.username });
        d.a(d.this, paramAnonymousView.username, paramAnonymousView.appId);
        AppMethodBeat.o(191594);
      }
    };
    this.pdN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191596);
        Object localObject1 = (bi)paramAnonymousView.getTag();
        int i = ((Integer)paramAnonymousView.getTag(2131303355)).intValue();
        i = d.a(d.this, i);
        Object localObject3 = com.tencent.mm.ai.a.a.rE(((com.tencent.mm.pluginsdk.ui.chat.c)localObject1).drF.field_content);
        paramAnonymousView = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject3).appId);
        localObject1 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject3).dvT);
        String str = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject3).dbu);
        Object localObject2 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject3).username);
        int j = ((com.tencent.mm.ai.a.a)localObject3).version;
        int k = ((com.tencent.mm.ai.a.a)localObject3).type;
        localObject3 = com.tencent.mm.ai.a.a.rF(((com.tencent.mm.ai.a.a)localObject3).title);
        ad.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) container click", new Object[] { localObject2 });
        com.tencent.mm.plugin.appbrand.a.f localf = new com.tencent.mm.plugin.appbrand.a.f();
        localf.username = ((String)localObject2);
        localf.gXn = k;
        localf.version = j;
        localf.iJb = str;
        localf.dbt = ("1162:" + (String)localObject1 + ":" + (String)localObject3);
        localf.scene = 1162;
        localObject2 = new AppBrandLaunchFromNotifyReferrer();
        ((AppBrandLaunchFromNotifyReferrer)localObject2).appId = bt.nullAsNil(paramAnonymousView);
        ((AppBrandLaunchFromNotifyReferrer)localObject2).uin = d.a(d.this);
        ((AppBrandLaunchFromNotifyReferrer)localObject2).jdz = 2;
        ((AppBrandLaunchFromNotifyReferrer)localObject2).jdA = bt.nullAsNil((String)localObject1);
        ((AppBrandLaunchFromNotifyReferrer)localObject2).content = ((String)localObject3);
        ((AppBrandLaunchFromNotifyReferrer)localObject2).jdB = i;
        localf.iJn = ((AppBrandLaunchFromNotifyReferrer)localObject2);
        ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(d.b(d.this).GzJ.getContext(), localf);
        ((com.tencent.mm.ui.chatting.c.b.g)d.b(d.this).be(com.tencent.mm.ui.chatting.c.b.g.class)).YK(i);
        d.d(4, paramAnonymousView, (String)localObject1, str, null, i);
        AppMethodBeat.o(191596);
      }
    };
    this.GIm = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(191597);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(191597);
          return false;
          d.c(d.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          d.c(d.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    AppMethodBeat.o(191610);
  }
  
  private static void c(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(191616);
    ad.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "appbrand notify report(%d), eventId : %d, appId %s, msgId %s, pagePath %s, label %s", new Object[] { Integer.valueOf(19724), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.h.vKh.f(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString1, paramString3, paramString4, paramString2, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null });
    AppMethodBeat.o(191616);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(191611);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493408, null);
      localView.setTag(new bo().gj(localView));
    }
    AppMethodBeat.o(191611);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(191612);
    this.Gob = parama1;
    paramString = (bo)parama;
    com.tencent.mm.ai.a.a locala = com.tencent.mm.ai.a.a.rE(parambl.field_content);
    if (parambl.field_isSend == 2)
    {
      paramString.GRR.setVisibility(0);
      paramString.fwS.setVisibility(8);
    }
    for (;;)
    {
      parama = ((i)this.Gob.be(i.class)).YE(0);
      if ((parama != null) && (parama.field_isSend == 2)) {
        ((i)this.Gob.be(i.class)).YG(1);
      }
      if (parambl.field_isSend != 2) {
        break;
      }
      paramString.GRS.setVisibility(8);
      if (parambl.field_isSend != 2)
      {
        paramString.titleTv.setText(bt.nullAsNil(locala.title));
        paramString.GRS.setOnClickListener(this.pdN);
        paramString.GRS.setTag(new bi(parambl, null));
        paramString.GRS.setLongClickable(true);
        paramString.GRS.setTag(2131306044, this.GIo);
        paramString.GRS.setTag(2131303355, Integer.valueOf(paramInt));
        paramString.GRS.setOnLongClickListener(c(this.Gob));
        paramString.GRS.setOnTouchListener(this.GIm);
      }
      AppMethodBeat.o(191612);
      return;
      paramString.GRR.setVisibility(8);
    }
    paramString.GRS.setVisibility(0);
    parama1 = ((m)com.tencent.mm.kernel.g.ab(m.class)).FW(locala.username);
    if ((parama1 != null) && (!bt.isNullOrNil(parama1.field_brandIconURL)) && (!bt.isNullOrNil(parama1.field_nickname)))
    {
      parama = parama1.field_brandIconURL;
      parama1 = parama1.field_nickname;
      label328:
      String str = bt.nullAsNil(locala.username);
      paramString.fuj.setTag(null);
      paramString.nkb.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.Gob.GzJ.getContext(), parama1, paramString.nkb.getTextSize()));
      paramString.nkb.setTag(locala);
      o.ayJ().a(parama, paramString.fuj, this.FGx);
      paramString.fuj.setTag(new bi(parambl, null));
      paramString.fuj.setTag(2131303355, Integer.valueOf(paramInt));
      paramString.fuj.setOnClickListener(this.pdN);
      paramString.fuj.setOnLongClickListener(null);
      paramString.fuj.setContentDescription(v.sh(str) + this.Gob.GzJ.getContext().getString(2131756087));
      if (Boolean.valueOf(((com.tencent.mm.plugin.appbrand.service.e)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.e.class)).get(locala.appId + "#NotifyMessageStatus", "true")).booleanValue()) {
        break label627;
      }
      paramString.GRT.setVisibility(0);
    }
    for (this.GIn = true;; this.GIn = false)
    {
      paramString.GRU.setTag(parambl);
      paramString.GRU.setTag(2131303355, Integer.valueOf(paramInt));
      paramString.GRU.setOnClickListener(this.GIk);
      break;
      parama = bt.nullAsNil(locala.iconUrl);
      parama1 = bt.nullAsNil(locala.nickname);
      break label328;
      label627:
      paramString.GRT.setVisibility(8);
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(191615);
    if ((paramString == null) || (parama.wet == null))
    {
      AppMethodBeat.o(191615);
      return;
    }
    parambl = ((com.tencent.mm.ui.chatting.c.b.f)parama1.be(com.tencent.mm.ui.chatting.c.b.f.class)).aKG(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.k.b(parama1.GzJ.getContext(), parambl, parama.wet.getTextSize()));
    AppMethodBeat.o(191615);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(191613);
    parambl = (bi)paramView.getTag();
    if (parambl == null)
    {
      AppMethodBeat.o(191613);
      return false;
    }
    paramContextMenu.add(parambl.position, 100, 0, paramView.getContext().getString(2131757221));
    AppMethodBeat.o(191613);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(191614);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191614);
      return false;
      paramMenuItem = com.tencent.mm.ai.a.a.rE(parambl.field_content);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rn(parambl.field_msgId);
      parama = bt.nullAsNil(paramMenuItem.appId);
      parambl = bt.nullAsNil(paramMenuItem.dbu);
      c(9, parama, bt.nullAsNil(paramMenuItem.dvT), parambl, null, 0);
    }
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == 872415281;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  final boolean faF()
  {
    return false;
  }
  
  protected final boolean faH()
  {
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(191609);
      final bl localbl = (bl)paramView.getTag();
      final int j = ((Integer)paramView.getTag(2131303355)).intValue();
      ad.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener onclick");
      if (localbl == null)
      {
        ad.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener, on more view click, but msg is null.");
        AppMethodBeat.o(191609);
        return;
      }
      Object localObject = com.tencent.mm.ai.a.a.rE(localbl.field_content);
      final String str1 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject).appId);
      final String str2 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject).dbu);
      final String str3 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject).nickname);
      final String str4 = bt.nullAsNil(((com.tencent.mm.ai.a.a)localObject).dvT);
      Context localContext = paramView.getContext();
      if (d.g(d.this)) {}
      for (int i = 1;; i = 0)
      {
        localObject = new b(localContext, i, ((com.tencent.mm.ai.a.a)localObject).username);
        ((b)localObject).FTJ = new b.a()
        {
          public final void eSh()
          {
            AppMethodBeat.i(191605);
            this.GIt.dismiss();
            Object localObject = this.GIt.FTI;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              b.b localb = (b.b)((Iterator)localObject).next();
              if (localb.nvF) {
                localStringBuilder.append(localb.FTM).append(":");
              }
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.setLength(localStringBuilder.length() - 1);
            }
            d.a(d.this, str3, str1, str4, str2, localStringBuilder.toString(), j);
            AppMethodBeat.o(191605);
          }
          
          public final void eSi()
          {
            AppMethodBeat.i(191606);
            this.GIt.dismiss();
            d.a(d.this, paramView, str1);
            final s locals = new s(localbl.field_content);
            d locald = d.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(2131755906);
            d.a(locald, com.tencent.mm.ui.base.h.b(localContext, paramView.getResources().getString(2131755936), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(191604);
                az.aeS().a(locals);
                AppMethodBeat.o(191604);
              }
            }));
            az.aeS().a(locals, 0);
            int i = d.a(d.this, j);
            d.d(3, str1, str4, str2, null, i);
            AppMethodBeat.o(191606);
          }
          
          public final void eSj()
          {
            AppMethodBeat.i(191607);
            this.GIt.dismiss();
            ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rn(localbl.field_msgId);
            AppMethodBeat.o(191607);
          }
          
          public final void eSk()
          {
            AppMethodBeat.i(191608);
            this.GIt.dismiss();
            Object localObject = com.tencent.mm.ai.a.a.rE(localbl.field_content);
            ad.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { ((com.tencent.mm.ai.a.a)localObject).username });
            localObject = new Intent().putExtra("key_username", ((com.tencent.mm.ai.a.a)localObject).username);
            com.tencent.mm.bs.d.b(paramView.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
            AppMethodBeat.o(191608);
          }
        };
        ((b)localObject).fC(paramView);
        d.d(7, str1, str4, str2, null, d.a(d.this, j));
        AppMethodBeat.o(191609);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d
 * JD-Core Version:    0.7.0.1
 */