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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.zq;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.egr;
import com.tencent.mm.protocal.protobuf.foz;
import com.tencent.mm.protocal.protobuf.fpz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.appbrand.b.a;
import com.tencent.mm.ui.appbrand.b.b;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
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
  private static final String XcI;
  private com.tencent.mm.ui.base.s LRv;
  private com.tencent.mm.ay.a.a.c VQC;
  private com.tencent.mm.ui.chatting.e.a WBq;
  private View.OnClickListener XcJ;
  private View.OnClickListener XcK;
  private View.OnTouchListener XcL;
  private com.tencent.mm.plugin.appbrand.service.g XcM;
  private boolean XcN;
  private int[] XcO;
  private com.tencent.mm.ui.base.s jhZ;
  private int vmC;
  private View.OnClickListener vol;
  
  static
  {
    AppMethodBeat.i(269472);
    XcI = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d#wechat_redirect";
    AppMethodBeat.o(269472);
  }
  
  public d()
  {
    AppMethodBeat.i(269455);
    this.XcO = new int[2];
    com.tencent.mm.ay.a.a.c.a locala = new com.tencent.mm.ay.a.a.c.a();
    locala.kPz = true;
    locala.lRP = R.g.brand_default_head;
    this.VQC = locala.bmL();
    com.tencent.mm.kernel.h.aHE();
    this.vmC = com.tencent.mm.kernel.b.getUin();
    this.XcM = ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.g.class));
    this.XcJ = new a((byte)0);
    this.XcK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(285701);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = (com.tencent.mm.aj.b.a)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { paramAnonymousView.username });
        d.a(d.this, paramAnonymousView.username, paramAnonymousView.appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285701);
      }
    };
    this.vol = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(291853);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (d.a(d.this) != null) {}
        for (localObject1 = d.a(d.this).bFl();; localObject1 = null)
        {
          Object localObject2 = (by)paramAnonymousView.getTag();
          int i = ((Integer)paramAnonymousView.getTag(R.h.position_layout)).intValue();
          i = d.a(d.this, i);
          Object localObject4 = com.tencent.mm.aj.b.a.OY(((com.tencent.mm.pluginsdk.ui.chat.c)localObject2).fNz.field_content);
          paramAnonymousView = Util.nullAsNil(((com.tencent.mm.aj.b.a)localObject4).appId);
          localObject2 = Util.nullAsNil(((com.tencent.mm.aj.b.a)localObject4).msgId);
          String str = Util.nullAsNil(((com.tencent.mm.aj.b.a)localObject4).fve);
          Object localObject3 = Util.nullAsNil(((com.tencent.mm.aj.b.a)localObject4).username);
          int j = ((com.tencent.mm.aj.b.a)localObject4).version;
          int k = ((com.tencent.mm.aj.b.a)localObject4).type;
          localObject4 = com.tencent.mm.aj.b.a.OZ(((com.tencent.mm.aj.b.a)localObject4).title);
          Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) container click", new Object[] { localObject3 });
          com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
          localg.username = ((String)localObject3);
          localg.cBU = k;
          localg.version = j;
          localg.nBq = str;
          localg.fvd = ("1162:" + (String)localObject2 + ":" + (String)localObject4);
          localg.scene = 1162;
          localObject3 = new AppBrandLaunchFromNotifyReferrer();
          ((AppBrandLaunchFromNotifyReferrer)localObject3).appId = Util.nullAsNil(paramAnonymousView);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).uin = d.b(d.this);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).nYx = 2;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).nYy = Util.nullAsNil((String)localObject2);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).content = ((String)localObject4);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).nYz = i;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).nYA = ((String)localObject1);
          localg.nBB = ((AppBrandLaunchFromNotifyReferrer)localObject3);
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(d.c(d.this).WQv.getContext(), localg);
          ((com.tencent.mm.ui.chatting.d.b.g)d.c(d.this).bC(com.tencent.mm.ui.chatting.d.b.g.class)).avA(i);
          d.a(d.this, 4, paramAnonymousView, (String)localObject2, str, null, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(291853);
          return;
        }
      }
    };
    this.XcL = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(270455);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(270455);
          return false;
          d.d(d.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
          d.d(d.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
        }
      }
    };
    AppMethodBeat.o(269455);
  }
  
  private void d(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(269461);
    String str = null;
    if (this.XcM != null) {
      str = this.XcM.bFl();
    }
    Log.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "appbrand notify report(%d), eventId : %d, appId %s, msgId %s, pagePath %s, label %s", new Object[] { Integer.valueOf(19724), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.h.IzE.a(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString1, paramString3, paramString4, paramString2, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, str });
    AppMethodBeat.o(269461);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(269456);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.ecv, null);
      localView.setTag(new ce().iu(localView));
    }
    AppMethodBeat.o(269456);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(269457);
    this.WBq = parama1;
    paramString = (ce)parama;
    com.tencent.mm.aj.b.a locala = com.tencent.mm.aj.b.a.OY(paramca.field_content);
    if (paramca.field_isSend == 2)
    {
      paramString.XnT.setVisibility(0);
      paramString.timeTV.setVisibility(8);
    }
    for (;;)
    {
      parama = ((k)this.WBq.bC(k.class)).avt(0);
      if ((parama != null) && (parama.field_isSend == 2)) {
        ((k)this.WBq.bC(k.class)).avv(1);
      }
      if (paramca.field_isSend != 2) {
        break;
      }
      paramString.XnU.setVisibility(8);
      if (paramca.field_isSend != 2)
      {
        paramString.titleTv.setText(Util.nullAsNil(locala.title));
        paramString.XnU.setOnClickListener(this.vol);
        paramString.XnU.setTag(new by(paramca, null));
        paramString.XnU.setLongClickable(true);
        paramString.XnU.setTag(R.h.touch_loc, this.XcO);
        paramString.XnU.setTag(R.h.position_layout, Integer.valueOf(paramInt));
        paramString.XnU.setOnLongClickListener(c(this.WBq));
        paramString.XnU.setOnTouchListener(this.XcL);
      }
      AppMethodBeat.o(269457);
      return;
      paramString.XnT.setVisibility(8);
    }
    paramString.XnU.setVisibility(0);
    parama1 = ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.q.class)).aeW(locala.username);
    if ((parama1 != null) && (!Util.isNullOrNil(parama1.field_brandIconURL)) && (!Util.isNullOrNil(parama1.field_nickname)))
    {
      parama = parama1.field_brandIconURL;
      parama1 = parama1.field_nickname;
      label328:
      String str = Util.nullAsNil(locala.username);
      paramString.jiu.setTag(null);
      paramString.xoK.setText(l.b(this.WBq.WQv.getContext(), parama1, paramString.xoK.getTextSize()));
      paramString.xoK.setTag(locala);
      com.tencent.mm.ay.q.bml().a(parama, paramString.jiu, this.VQC);
      paramString.jiu.setTag(new by(paramca, null));
      paramString.jiu.setTag(R.h.position_layout, Integer.valueOf(paramInt));
      paramString.jiu.setOnClickListener(this.vol);
      paramString.jiu.setOnLongClickListener(null);
      paramString.jiu.setContentDescription(aa.PJ(str) + this.WBq.WQv.getContext().getString(R.l.avatar_desc));
      if (Boolean.valueOf(((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.g.class)).cu(locala.appId + "#NotifyMessageStatus", "true")).booleanValue()) {
        break label626;
      }
      paramString.XnV.setVisibility(0);
    }
    for (this.XcN = true;; this.XcN = false)
    {
      paramString.XnW.setTag(paramca);
      paramString.XnW.setTag(R.h.position_layout, Integer.valueOf(paramInt));
      paramString.XnW.setOnClickListener(this.XcJ);
      break;
      parama = Util.nullAsNil(locala.iconUrl);
      parama1 = Util.nullAsNil(locala.nickname);
      break label328;
      label626:
      paramString.XnV.setVisibility(8);
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(269460);
    if ((paramString == null) || (parama.userTV == null))
    {
      AppMethodBeat.o(269460);
      return;
    }
    paramca = ((f)parama1.bC(f.class)).bzg(paramString);
    a(parama, l.b(parama1.WQv.getContext(), paramca, parama.userTV.getTextSize()));
    AppMethodBeat.o(269460);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(269459);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(269459);
      return false;
      paramMenuItem = com.tencent.mm.aj.b.a.OY(paramca.field_content);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Or(paramca.field_msgId);
      parama = Util.nullAsNil(paramMenuItem.appId);
      paramca = Util.nullAsNil(paramMenuItem.fve);
      d(9, parama, Util.nullAsNil(paramMenuItem.msgId), paramca, null, 0);
    }
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(269458);
    paramca = (by)paramView.getTag();
    if (paramca == null)
    {
      AppMethodBeat.o(269458);
      return false;
    }
    paramo.a(paramca.position, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
    AppMethodBeat.o(269458);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == 872415281;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
  
  final boolean hTF()
  {
    return false;
  }
  
  protected final boolean hTH()
  {
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(287393);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      localObject1 = (ca)paramView.getTag();
      final int j = ((Integer)paramView.getTag(R.h.position_layout)).intValue();
      Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener onclick");
      if (localObject1 == null)
      {
        Log.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener, on more view click, but msg is null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287393);
        return;
      }
      Object localObject2 = com.tencent.mm.aj.b.a.OY(((et)localObject1).field_content);
      final String str1 = Util.nullAsNil(((com.tencent.mm.aj.b.a)localObject2).appId);
      final String str2 = Util.nullAsNil(((com.tencent.mm.aj.b.a)localObject2).fve);
      final String str3 = Util.nullAsNil(((com.tencent.mm.aj.b.a)localObject2).nickname);
      final String str4 = Util.nullAsNil(((com.tencent.mm.aj.b.a)localObject2).msgId);
      Context localContext = paramView.getContext();
      if (d.h(d.this)) {}
      for (int i = 1;; i = 0)
      {
        localObject2 = new com.tencent.mm.ui.appbrand.b(localContext, i, ((com.tencent.mm.aj.b.a)localObject2).username);
        ((com.tencent.mm.ui.appbrand.b)localObject2).Wgq = new b.a()
        {
          public final void hJj()
          {
            AppMethodBeat.i(271130);
            this.XcT.dismiss();
            Object localObject = this.XcT.Wgp;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              b.b localb = (b.b)((Iterator)localObject).next();
              if (localb.tsm) {
                localStringBuilder.append(localb.Wgt).append(":");
              }
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.setLength(localStringBuilder.length() - 1);
            }
            d.a(d.this, str3, str1, str4, str2, localStringBuilder.toString(), j);
            AppMethodBeat.o(271130);
          }
          
          public final void hJk()
          {
            AppMethodBeat.i(271132);
            this.XcT.dismiss();
            d.a(d.this, paramView, str1);
            final com.tencent.mm.modelappbrand.s locals = new com.tencent.mm.modelappbrand.s(this.lrk.field_content);
            d locald = d.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(R.l.app_tip);
            d.a(locald, com.tencent.mm.ui.base.h.a(localContext, paramView.getResources().getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(236161);
                bh.aGY().a(locals);
                AppMethodBeat.o(236161);
              }
            }));
            bh.aGY().a(locals, 0);
            int i = d.a(d.this, j);
            d.a(d.this, 3, str1, str4, str2, null, i);
            AppMethodBeat.o(271132);
          }
          
          public final void hJl()
          {
            AppMethodBeat.i(271134);
            this.XcT.dismiss();
            ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Or(this.lrk.field_msgId);
            AppMethodBeat.o(271134);
          }
          
          public final void hJm()
          {
            AppMethodBeat.i(271136);
            this.XcT.dismiss();
            Object localObject = com.tencent.mm.aj.b.a.OY(this.lrk.field_content);
            Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { ((com.tencent.mm.aj.b.a)localObject).username });
            localObject = new Intent().putExtra("key_username", ((com.tencent.mm.aj.b.a)localObject).username);
            com.tencent.mm.by.c.b(paramView.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
            AppMethodBeat.o(271136);
          }
        };
        ((com.tencent.mm.ui.appbrand.b)localObject2).hG(paramView);
        i = d.a(d.this, j);
        d.a(d.this, 7, str1, str4, str2, null, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(287393);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d
 * JD-Core Version:    0.7.0.1
 */