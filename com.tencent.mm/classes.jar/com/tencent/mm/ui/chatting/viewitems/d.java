package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.abl;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.far;
import com.tencent.mm.protocal.protobuf.glz;
import com.tencent.mm.protocal.protobuf.gnc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.appbrand.b.a;
import com.tencent.mm.ui.appbrand.b.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
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
  private static final String aeMG;
  private w Sub;
  private com.tencent.mm.modelimage.loader.a.c aduK;
  private View.OnClickListener aeMH;
  private View.OnClickListener aeMI;
  private View.OnTouchListener aeMJ;
  private com.tencent.mm.plugin.appbrand.service.h aeMK;
  private boolean aeML;
  private int[] aeMM;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private w lKp;
  private View.OnClickListener yAH;
  private int yze;
  
  static
  {
    AppMethodBeat.i(255007);
    aeMG = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d#wechat_redirect";
    AppMethodBeat.o(255007);
  }
  
  public d()
  {
    AppMethodBeat.i(254959);
    this.aeMM = new int[2];
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.nrc = true;
    locala.oKB = R.g.brand_default_head;
    this.aduK = locala.bKx();
    com.tencent.mm.kernel.h.baC();
    this.yze = com.tencent.mm.kernel.b.getUin();
    this.aeMK = ((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.h.class));
    this.aeMH = new a((byte)0);
    this.aeMI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254985);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = (com.tencent.mm.message.c.a)paramAnonymousView.getTag();
        Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { paramAnonymousView.username });
        d.a(d.this, paramAnonymousView.username, paramAnonymousView.appId);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254985);
      }
    };
    this.yAH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(254983);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (d.a(d.this) != null) {}
        for (localObject1 = d.a(d.this).cez();; localObject1 = null)
        {
          Object localObject2 = (bz)paramAnonymousView.getTag();
          int i = ((Integer)paramAnonymousView.getTag(R.h.position_layout)).intValue();
          i = d.a(d.this, i);
          Object localObject4 = com.tencent.mm.message.c.a.Hr(((com.tencent.mm.pluginsdk.ui.chat.c)localObject2).hTm.field_content);
          paramAnonymousView = Util.nullAsNil(((com.tencent.mm.message.c.a)localObject4).appId);
          localObject2 = Util.nullAsNil(((com.tencent.mm.message.c.a)localObject4).msgId);
          String str = Util.nullAsNil(((com.tencent.mm.message.c.a)localObject4).hzy);
          Object localObject3 = Util.nullAsNil(((com.tencent.mm.message.c.a)localObject4).username);
          int j = ((com.tencent.mm.message.c.a)localObject4).version;
          int k = ((com.tencent.mm.message.c.a)localObject4).type;
          localObject4 = com.tencent.mm.message.c.a.Hs(((com.tencent.mm.message.c.a)localObject4).title);
          Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) container click", new Object[] { localObject3 });
          com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
          localg.username = ((String)localObject3);
          localg.euz = k;
          localg.version = j;
          localg.qAF = str;
          localg.hzx = ("1162:" + (String)localObject2 + ":" + (String)localObject4);
          localg.scene = 1162;
          localObject3 = new AppBrandLaunchFromNotifyReferrer();
          ((AppBrandLaunchFromNotifyReferrer)localObject3).appId = Util.nullAsNil(paramAnonymousView);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).uin = d.b(d.this);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).qYz = 2;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).qYA = Util.nullAsNil((String)localObject2);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).content = ((String)localObject4);
          ((AppBrandLaunchFromNotifyReferrer)localObject3).qYB = i;
          ((AppBrandLaunchFromNotifyReferrer)localObject3).qYC = ((String)localObject1);
          localg.qAQ = ((AppBrandLaunchFromNotifyReferrer)localObject3);
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a(d.c(d.this).aezO.getContext(), localg);
          ((com.tencent.mm.ui.chatting.component.api.h)d.c(d.this).cm(com.tencent.mm.ui.chatting.component.api.h.class)).aCc(i);
          d.a(d.this, 4, paramAnonymousView, (String)localObject2, str, null, i);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254983);
          return;
        }
      }
    };
    this.aeMJ = new d.4(this);
    AppMethodBeat.o(254959);
  }
  
  private void e(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(254961);
    String str = null;
    if (this.aeMK != null) {
      str = this.aeMK.cez();
    }
    Log.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "appbrand notify report(%d), eventId : %d, appId %s, msgId %s, pagePath %s, label %s", new Object[] { Integer.valueOf(19724), Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4 });
    com.tencent.mm.plugin.report.service.h.OAn.b(19724, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), paramString1, paramString3, paramString4, paramString2, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, str });
    AppMethodBeat.o(254961);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(255016);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.gfg, null);
      localView.setTag(new cf().lR(localView));
    }
    AppMethodBeat.o(255016);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(255037);
    this.aeiK = parama1;
    paramString = (cf)parama;
    com.tencent.mm.message.c.a locala = com.tencent.mm.message.c.a.Hr(paramcc.field_content);
    if (paramcc.field_isSend == 2)
    {
      paramString.aeZc.setVisibility(0);
      paramString.timeTV.setVisibility(8);
    }
    for (;;)
    {
      parama = ((m)this.aeiK.cm(m.class)).aBV(0);
      if ((parama != null) && (parama.field_isSend == 2)) {
        ((m)this.aeiK.cm(m.class)).aBX(1);
      }
      if (paramcc.field_isSend != 2) {
        break;
      }
      paramString.aeZd.setVisibility(8);
      if (paramcc.field_isSend != 2)
      {
        paramString.titleTv.setText(Util.nullAsNil(locala.title));
        paramString.aeZd.setOnClickListener(this.yAH);
        paramString.aeZd.setTag(new bz(paramcc, null));
        paramString.aeZd.setLongClickable(true);
        paramString.aeZd.setTag(R.h.touch_loc, this.aeMM);
        paramString.aeZd.setTag(R.h.position_layout, Integer.valueOf(paramInt));
        paramString.aeZd.setOnLongClickListener(c(this.aeiK));
        paramString.aeZd.setOnTouchListener(this.aeMJ);
      }
      AppMethodBeat.o(255037);
      return;
      paramString.aeZc.setVisibility(8);
    }
    paramString.aeZd.setVisibility(0);
    parama1 = ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xy(locala.username);
    if ((parama1 != null) && (!Util.isNullOrNil(parama1.field_brandIconURL)) && (!Util.isNullOrNil(parama1.field_nickname)))
    {
      parama = parama1.field_brandIconURL;
      parama1 = parama1.field_nickname;
      label328:
      String str = Util.nullAsNil(locala.username);
      paramString.lKK.setTag(null);
      paramString.nicknameTv.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this.aeiK.aezO.getContext(), parama1, paramString.nicknameTv.getTextSize()));
      paramString.nicknameTv.setTag(locala);
      r.bKe().a(parama, paramString.lKK, this.aduK);
      paramString.lKK.setTag(new bz(paramcc, null));
      paramString.lKK.setTag(R.h.position_layout, Integer.valueOf(paramInt));
      paramString.lKK.setOnClickListener(this.yAH);
      paramString.lKK.setOnLongClickListener(null);
      paramString.lKK.setContentDescription(com.tencent.mm.model.aa.getDisplayName(str) + this.aeiK.aezO.getContext().getString(R.l.avatar_desc));
      if (Boolean.valueOf(((com.tencent.mm.plugin.appbrand.service.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.h.class)).cL(locala.appId + "#NotifyMessageStatus", "true")).booleanValue()) {
        break label626;
      }
      paramString.aeZe.setVisibility(0);
    }
    for (this.aeML = true;; this.aeML = false)
    {
      paramString.aeZf.setTag(paramcc);
      paramString.aeZf.setTag(R.h.position_layout, Integer.valueOf(paramInt));
      paramString.aeZf.setOnClickListener(this.aeMH);
      break;
      parama = Util.nullAsNil(locala.iconUrl);
      parama1 = Util.nullAsNil(locala.nickname);
      break label328;
      label626:
      paramString.aeZe.setVisibility(8);
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(255058);
    if ((paramString == null) || (parama.userTV == null))
    {
      AppMethodBeat.o(255058);
      return;
    }
    paramcc = ((com.tencent.mm.ui.chatting.component.api.g)parama1.cm(com.tencent.mm.ui.chatting.component.api.g.class)).bAK(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), paramcc, parama.userTV.getTextSize()));
    AppMethodBeat.o(255058);
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255056);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(255056);
      return false;
      paramMenuItem = com.tencent.mm.message.c.a.Hr(paramcc.field_content);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sm(paramcc.field_msgId);
      parama = Util.nullAsNil(paramMenuItem.appId);
      paramcc = Util.nullAsNil(paramMenuItem.hzy);
      e(9, parama, Util.nullAsNil(paramMenuItem.msgId), paramcc, null, 0);
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255041);
    paramContextMenuInfo = (bz)paramView.getTag();
    if (paramContextMenuInfo == null)
    {
      AppMethodBeat.o(255041);
      return false;
    }
    params.a(paramContextMenuInfo.position, 100, paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
    AppMethodBeat.o(255041);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == 872415281;
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxh()
  {
    return false;
  }
  
  final boolean jxi()
  {
    return false;
  }
  
  protected final boolean jxk()
  {
    return false;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final void onClick(final View paramView)
    {
      AppMethodBeat.i(255758);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      localObject1 = (cc)paramView.getTag();
      final int j = ((Integer)paramView.getTag(R.h.position_layout)).intValue();
      Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener onclick");
      if (localObject1 == null)
      {
        Log.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener, on more view click, but msg is null.");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255758);
        return;
      }
      Object localObject2 = com.tencent.mm.message.c.a.Hr(((fi)localObject1).field_content);
      final String str1 = Util.nullAsNil(((com.tencent.mm.message.c.a)localObject2).appId);
      final String str2 = Util.nullAsNil(((com.tencent.mm.message.c.a)localObject2).hzy);
      final String str3 = Util.nullAsNil(((com.tencent.mm.message.c.a)localObject2).nickname);
      final String str4 = Util.nullAsNil(((com.tencent.mm.message.c.a)localObject2).msgId);
      Context localContext = paramView.getContext();
      if (d.h(d.this)) {}
      for (int i = 1;; i = 0)
      {
        localObject2 = new com.tencent.mm.ui.appbrand.b(localContext, i, ((com.tencent.mm.message.c.a)localObject2).username);
        ((com.tencent.mm.ui.appbrand.b)localObject2).adNm = new b.a()
        {
          public final void esm()
          {
            AppMethodBeat.i(255721);
            this.aeMR.dismiss();
            Object localObject = com.tencent.mm.message.c.a.Hr(this.oiL.field_content);
            Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", new Object[] { ((com.tencent.mm.message.c.a)localObject).username });
            localObject = new Intent().putExtra("key_username", ((com.tencent.mm.message.c.a)localObject).username);
            com.tencent.mm.br.c.b(paramView.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", (Intent)localObject);
            AppMethodBeat.o(255721);
          }
          
          public final void jlN()
          {
            AppMethodBeat.i(255703);
            this.aeMR.dismiss();
            Object localObject = this.aeMR.adNl;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              b.b localb = (b.b)((Iterator)localObject).next();
              if (localb.wwJ) {
                localStringBuilder.append(localb.adNp).append(":");
              }
            }
            if (localStringBuilder.length() > 0) {
              localStringBuilder.setLength(localStringBuilder.length() - 1);
            }
            d.a(d.this, str3, str1, str4, str2, localStringBuilder.toString(), j);
            AppMethodBeat.o(255703);
          }
          
          public final void jlO()
          {
            AppMethodBeat.i(255710);
            this.aeMR.dismiss();
            d.a(d.this, paramView, str1);
            final com.tencent.mm.modelappbrand.s locals = new com.tencent.mm.modelappbrand.s(this.oiL.field_content);
            d locald = d.this;
            Context localContext = paramView.getContext();
            paramView.getResources().getString(R.l.app_tip);
            d.a(locald, k.a(localContext, paramView.getResources().getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
            {
              public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
              {
                AppMethodBeat.i(255759);
                bh.aZW().a(locals);
                AppMethodBeat.o(255759);
              }
            }));
            bh.aZW().a(locals, 0);
            int i = d.a(d.this, j);
            d.a(d.this, 3, str1, str4, str2, null, i);
            AppMethodBeat.o(255710);
          }
          
          public final void jlP()
          {
            AppMethodBeat.i(255716);
            this.aeMR.dismiss();
            ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sm(this.oiL.field_msgId);
            AppMethodBeat.o(255716);
          }
        };
        ((com.tencent.mm.ui.appbrand.b)localObject2).lc(paramView);
        i = d.a(d.this, j);
        d.a(d.this, 7, str1, str4, str2, null, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255758);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d
 * JD-Core Version:    0.7.0.1
 */