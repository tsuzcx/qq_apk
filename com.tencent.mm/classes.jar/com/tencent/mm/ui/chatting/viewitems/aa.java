package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;

public final class aa
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    private aa.d Imy;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37070);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ag(paramLayoutInflater, 2131493464);
        ((View)localObject).setTag(new aa.e().gp((View)localObject));
      }
      AppMethodBeat.o(37070);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(37071);
      this.HNS = parama1;
      parama = (aa.e)parama;
      if (this.Imy == null) {
        this.Imy = new aa.d(this.HNS, this);
      }
      aa.e.a(parama, paramInt, parama1, parambo, false, this.Imy, c(parama1));
      ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).aXB();
      AppMethodBeat.o(37071);
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37072);
      boolean bool = aa.a(this.HNS, paramContextMenu, paramView, parambo);
      AppMethodBeat.o(37072);
      return bool;
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(37073);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = bk.C(parambo);
        if (!bs.isNullOrNil(paramMenuItem)) {
          break label110;
        }
        paramMenuItem = k.b.vA(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.wUl.f(16979, new Object[] { paramMenuItem.hkf, paramMenuItem.hkd, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, parambo, b(parama, parambo));
      }
      for (;;)
      {
        AppMethodBeat.o(37073);
        return false;
        label110:
        com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.HZF.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37068);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
            d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37068);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37069);
            paramAnonymousDialogInterface = k.b.vA(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
            if (paramAnonymousDialogInterface != null) {
              com.tencent.mm.plugin.report.service.h.wUl.f(16979, new Object[] { paramAnonymousDialogInterface.hkf, paramAnonymousDialogInterface.hkd, Integer.valueOf(0), Integer.valueOf(2) });
            }
            e.b.a(parama, parambo, aa.a.this.b(parama, parambo));
            com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(37069);
          }
        });
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      return true;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean fqu()
    {
      return false;
    }
    
    final boolean fqv()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    private aa.d Imy;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37074);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ag(paramLayoutInflater, 2131493507);
        ((View)localObject).setTag(new aa.e().gp((View)localObject));
      }
      AppMethodBeat.o(37074);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37078);
      if (parambo.cKN())
      {
        m.aD(parambo);
        bi.pK(parambo.field_msgId);
        parama.xg(true);
      }
      AppMethodBeat.o(37078);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(37075);
      this.HNS = parama1;
      parama = (aa.e)parama;
      if (this.Imy == null) {
        this.Imy = new aa.d(this.HNS, this);
      }
      aa.e.a(parama, paramInt, parama1, parambo, true, this.Imy, c(parama1));
      a(paramInt, parama, parambo, parama1.foM(), parama1.foQ(), parama1, this);
      ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).aXB();
      AppMethodBeat.o(37075);
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37076);
      boolean bool = aa.a(this.HNS, paramContextMenu, paramView, parambo);
      AppMethodBeat.o(37076);
      return bool;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37077);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = k.b.vA(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.wUl.f(16979, new Object[] { paramMenuItem.hkf, paramMenuItem.hkd, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, parambo, b(parama, parambo));
      }
      AppMethodBeat.o(37077);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      return true;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean fqu()
    {
      return true;
    }
    
    final boolean fqv()
    {
      return false;
    }
  }
  
  static final class d
    extends s.e
  {
    private c IhY;
    
    public d(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.IhY = paramc;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37080);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      k.b localb = k.b.vA(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      if (localb == null)
      {
        ac.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
        AppMethodBeat.o(37080);
        return;
      }
      if ((bs.isNullOrNil(localb.hkf)) && (bs.isNullOrNil(localb.hke)))
      {
        parambo = new Intent();
        str1 = localb.url;
        if (parama.foQ()) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          parambo.putExtra("rawUrl", com.tencent.mm.pluginsdk.model.app.q.P(str1, paramView));
          parambo.putExtra("webpageTitle", localb.title);
          parambo.putExtra("shortUrl", localb.url);
          d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", parambo);
          AppMethodBeat.o(37080);
          return;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = this.IhY.b(parama, parambo);
      Bundle localBundle = new Bundle();
      int i;
      label307:
      boolean bool;
      if (parama.foQ())
      {
        i = 2;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambo.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        paramView = com.tencent.mm.pluginsdk.model.app.h.fA(localb.appId, localb.aBM);
        if ((paramView != null) && (paramView.field_appName != null) && (paramView.field_appName.trim().length() > 0)) {
          break label537;
        }
        paramView = localb.appName;
        localBundle.putString("stat_weishi_app_name", paramView);
        localBundle.putString("stat_weishi_app_id", localb.appId);
        localBundle.putString("stat_weishi_source_username", localb.dvl);
        paramView = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
        if ((paramView == null) || (paramView.hgh != 1)) {
          break label545;
        }
        bool = true;
        label365:
        localBundle.putBoolean("stat_weishi_from_opensdk", bool);
        localBundle.putString("stat_weishi_msg_img_path", parambo.field_imgPath);
        localBundle.putString("stat_weishi_thumb_path", o.aFx().b(parambo.field_imgPath, false, true));
        if (paramView == null) {
          break label551;
        }
      }
      label537:
      label545:
      label551:
      for (paramView = paramView.appThumbUrl;; paramView = null)
      {
        localBundle.putString("stat_weishi_thumb_url", paramView);
        com.tencent.mm.plugin.report.service.h.wUl.f(16979, new Object[] { localb.hkf, localb.hkd, Integer.valueOf(0), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1129L, 0L, 1L, false);
        ((n)com.tencent.mm.kernel.g.ab(n.class)).b(parama.HZF.getContext(), str1, str2, parama.foQ(), localb, localBundle);
        AppMethodBeat.o(37080);
        return;
        if (w.wH(str1))
        {
          i = 7;
          break;
        }
        i = 1;
        break;
        paramView = paramView.field_appName;
        break label307;
        bool = false;
        break label365;
      }
    }
  }
  
  static final class e
    extends c.a
  {
    public ImageView Ilc;
    public ImageView ImA;
    public ImageView mxD;
    public ProgressBar progressBar;
    public TextView qTn;
    
    @SuppressLint({"ResourceType"})
    public static void a(e parame, int paramInt, com.tencent.mm.ui.chatting.d.a parama, bo parambo, boolean paramBoolean, aa.d paramd, c.c paramc)
    {
      AppMethodBeat.i(37082);
      k.b localb = k.b.vA(bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      if (localb == null)
      {
        ac.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
        AppMethodBeat.o(37082);
        return;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.fA(localb.appId, localb.aBM);
      String str;
      if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
      {
        str = localb.appName;
        if ((localb.appId == null) || (localb.appId.length() <= 0) || (!c.eC(str))) {
          break label682;
        }
        parame.qTn.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama.HZF.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, str));
        parame.qTn.setVisibility(0);
        c.a(parama, parame.qTn, localb.appId);
        label161:
        parame.mxD.setImageDrawable(com.tencent.mm.cc.a.l(parama.HZF.getContext(), 2131691166));
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(8);
        }
        str = o.aFx().b(parambo.field_imgPath, false, true);
        ac.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", new Object[] { parambo.field_imgPath, str });
        localObject = o.aFx().a(str, com.tencent.mm.cc.a.getDensity(parama.HZF.getContext()), parama.HZF.getContext(), 2131231564);
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label694;
        }
        parame.Ilc.setImageBitmap((Bitmap)localObject);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.Ilc.setLayoutParams(localLayoutParams);
        localObject = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.ImA.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label340:
        if (paramBoolean)
        {
          if ((parambo.field_status != 5) && (parambo.field_status != 2)) {
            break label837;
          }
          if (parame.progressBar != null) {
            parame.progressBar.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        parame.nDl.setTag(new bj(parambo, parama.foQ(), paramInt, parambo.field_talker, '\000'));
        parame.nDl.setOnClickListener(paramd);
        parame.nDl.setOnLongClickListener(paramc);
        parame.nDl.setOnTouchListener(((i)parama.bf(i.class)).fmb());
        com.tencent.mm.plugin.report.service.h.wUl.f(16979, new Object[] { localb.hkf, localb.hkd, Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.modelappbrand.a.b.aAS().zt("file://".concat(String.valueOf(str)));
        parame = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
        if ((parame != null) && (!bs.isNullOrNil(parame.appThumbUrl))) {
          com.tencent.mm.modelappbrand.a.b.aAS().zt(parame.appThumbUrl);
        }
        if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class) != null) {
          ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.f.class)).aVd();
        }
        if ((!ax.isWifi(ai.getContext())) || (parame == null) || (bs.isNullOrNil(parame.videoSource))) {
          break label863;
        }
        parame = parame.videoSource;
        if (com.tencent.mm.kernel.g.ab(j.class) == null) {
          break label863;
        }
        parama = (j)com.tencent.mm.kernel.g.ab(j.class);
        if (!parama.bua()) {
          break label855;
        }
        int i = parama.bub();
        paramInt = i;
        if (i != -1) {
          paramInt = i * 1024 * 1024;
        }
        XIPCInvoker.a("com.tencent.mm:appbrand0", new AppBrandWeishiVideoOperation(parame, paramInt), aa.c.class, null);
        AppMethodBeat.o(37082);
        return;
        str = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label682:
        parame.qTn.setVisibility(8);
        break label161;
        label694:
        ac.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
        parame.ImA.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        i = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), 85);
        int j = com.tencent.mm.cc.a.au(parama.HZF.getContext(), 2131165213);
        localObject = com.tencent.mm.sdk.platformtools.f.b(com.tencent.mm.sdk.platformtools.f.aH(parama.HZF.getContext().getResources().getColor(2131100478), i, j), 2131231564, i, j);
        parame.Ilc.setImageBitmap((Bitmap)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.Ilc.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.ImA.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label340;
        label837:
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(0);
        }
      }
      label855:
      ac.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload disabled");
      label863:
      AppMethodBeat.o(37082);
    }
    
    public final c.a gp(View paramView)
    {
      AppMethodBeat.i(37081);
      super.fX(paramView);
      this.Ilc = ((ImageView)paramView.findViewById(2131298074));
      this.ImA = ((ImageView)paramView.findViewById(2131298076));
      this.nDl = paramView.findViewById(2131298069);
      this.mxD = ((ImageView)paramView.findViewById(2131298175));
      this.xpH = ((TextView)paramView.findViewById(2131298185));
      this.qTn = ((TextView)paramView.findViewById(2131298044));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131298183));
      this.IhW = ((ImageView)paramView.findViewById(2131298174));
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.gGk = paramView.findViewById(2131298147);
      AppMethodBeat.o(37081);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa
 * JD-Core Version:    0.7.0.1
 */