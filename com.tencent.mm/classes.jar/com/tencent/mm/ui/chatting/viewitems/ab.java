package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.tencent.mm.av.i;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.n;

public final class ab
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    private ab.d Kzo;
    
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
        localObject = new ah(paramLayoutInflater, 2131493464);
        ((View)localObject).setTag(new ab.e().gL((View)localObject));
      }
      AppMethodBeat.o(37070);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(37071);
      this.JWz = parama1;
      parama = (ab.e)parama;
      if (this.Kzo == null) {
        this.Kzo = new ab.d(this.JWz, this);
      }
      ab.e.a(parama, paramInt, parama1, parambv, false, this.Kzo, c(parama1));
      ((s)com.tencent.mm.kernel.g.ab(s.class)).bby();
      AppMethodBeat.o(37071);
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final bv parambv)
    {
      AppMethodBeat.i(37073);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = bn.E(parambv);
        if (!bu.isNullOrNil(paramMenuItem)) {
          break label110;
        }
        paramMenuItem = k.b.zb(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.g.yxI.f(16979, new Object[] { paramMenuItem.hFd, paramMenuItem.hFb, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, parambv, b(parama, parambv));
      }
      for (;;)
      {
        AppMethodBeat.o(37073);
        return false;
        label110:
        com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.Kkd.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37068);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FGb);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.FFX);
            d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37068);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37069);
            paramAnonymousDialogInterface = k.b.zb(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
            if (paramAnonymousDialogInterface != null) {
              com.tencent.mm.plugin.report.service.g.yxI.f(16979, new Object[] { paramAnonymousDialogInterface.hFd, paramAnonymousDialogInterface.hFb, Integer.valueOf(0), Integer.valueOf(2) });
            }
            e.b.a(parama, parambv, ab.a.this.b(parama, parambv));
            com.tencent.mm.plugin.report.service.g.yxI.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(37069);
          }
        });
      }
    }
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187809);
      boolean bool = ab.a(this.JWz, paraml, paramView, parambv);
      AppMethodBeat.o(187809);
      return bool;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      return true;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 687865905);
    }
    
    final boolean fLA()
    {
      return false;
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    private ab.d Kzo;
    
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
        localObject = new ah(paramLayoutInflater, 2131493507);
        ((View)localObject).setTag(new ab.e().gL((View)localObject));
      }
      AppMethodBeat.o(37074);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37078);
      if (parambv.cVH())
      {
        m.aF(parambv);
        bl.rW(parambv.field_msgId);
        parama.xY(true);
      }
      AppMethodBeat.o(37078);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(37075);
      this.JWz = parama1;
      parama = (ab.e)parama;
      if (this.Kzo == null) {
        this.Kzo = new ab.d(this.JWz, this);
      }
      ab.e.a(parama, paramInt, parama1, parambv, true, this.Kzo, c(parama1));
      a(paramInt, parama, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
      ((s)com.tencent.mm.kernel.g.ab(s.class)).bby();
      AppMethodBeat.o(37075);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37077);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = k.b.zb(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.g.yxI.f(16979, new Object[] { paramMenuItem.hFd, paramMenuItem.hFb, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, parambv, b(parama, parambv));
      }
      AppMethodBeat.o(37077);
      return false;
    }
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187810);
      boolean bool = ab.a(this.JWz, paraml, paramView, parambv);
      AppMethodBeat.o(187810);
      return bool;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      return true;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 687865905);
    }
    
    final boolean fLA()
    {
      return false;
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
  
  static final class d
    extends t.e
  {
    private c KuO;
    
    public d(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.KuO = paramc;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37080);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      k.b localb = k.b.zb(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      if (localb == null)
      {
        ae.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
        AppMethodBeat.o(37080);
        return;
      }
      if ((bu.isNullOrNil(localb.hFd)) && (bu.isNullOrNil(localb.hFc)))
      {
        parambv = new Intent();
        str1 = localb.url;
        if (parama.fJC()) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          parambv.putExtra("rawUrl", com.tencent.mm.pluginsdk.model.app.q.Q(str1, paramView));
          parambv.putExtra("webpageTitle", localb.title);
          parambv.putExtra("shortUrl", localb.url);
          d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", parambv);
          AppMethodBeat.o(37080);
          return;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = this.KuO.b(parama, parambv);
      Bundle localBundle = new Bundle();
      int i;
      label307:
      boolean bool;
      if (parama.fJC())
      {
        i = 2;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambv.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        paramView = com.tencent.mm.pluginsdk.model.app.h.gg(localb.appId, localb.aDD);
        if ((paramView != null) && (paramView.field_appName != null) && (paramView.field_appName.trim().length() > 0)) {
          break label537;
        }
        paramView = localb.appName;
        localBundle.putString("stat_weishi_app_name", paramView);
        localBundle.putString("stat_weishi_app_id", localb.appId);
        localBundle.putString("stat_weishi_source_username", localb.dIt);
        paramView = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
        if ((paramView == null) || (paramView.hBe != 1)) {
          break label545;
        }
        bool = true;
        label365:
        localBundle.putBoolean("stat_weishi_from_opensdk", bool);
        localBundle.putString("stat_weishi_msg_img_path", parambv.field_imgPath);
        localBundle.putString("stat_weishi_thumb_path", com.tencent.mm.av.q.aIX().c(parambv.field_imgPath, false, true));
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
        com.tencent.mm.plugin.report.service.g.yxI.f(16979, new Object[] { localb.hFd, localb.hFb, Integer.valueOf(0), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1129L, 0L, 1L, false);
        ((p)com.tencent.mm.kernel.g.ab(p.class)).b(parama.Kkd.getContext(), str1, str2, parama.fJC(), localb, localBundle);
        AppMethodBeat.o(37080);
        return;
        if (x.Ao(str1))
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
    public ImageView KxS;
    public ImageView Kzq;
    public ImageView ndr;
    public ProgressBar progressBar;
    public TextView rLB;
    
    @SuppressLint({"ResourceType"})
    public static void a(e parame, int paramInt, com.tencent.mm.ui.chatting.e.a parama, bv parambv, boolean paramBoolean, ab.d paramd, c.c paramc)
    {
      AppMethodBeat.i(37082);
      k.b localb = k.b.zb(bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      if (localb == null)
      {
        ae.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
        AppMethodBeat.o(37082);
        return;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.gg(localb.appId, localb.aDD);
      String str;
      if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
      {
        str = localb.appName;
        if ((localb.appId == null) || (localb.appId.length() <= 0) || (!c.fD(str))) {
          break label682;
        }
        parame.rLB.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama.Kkd.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, str));
        parame.rLB.setVisibility(0);
        c.a(parama, parame.rLB, localb.appId);
        label161:
        parame.ndr.setImageDrawable(com.tencent.mm.cb.a.l(parama.Kkd.getContext(), 2131691166));
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(8);
        }
        str = com.tencent.mm.av.q.aIX().c(parambv.field_imgPath, false, true);
        ae.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", new Object[] { parambv.field_imgPath, str });
        localObject = com.tencent.mm.av.q.aIX().a(str, com.tencent.mm.cb.a.getDensity(parama.Kkd.getContext()), parama.Kkd.getContext(), 2131231564);
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label694;
        }
        parame.KxS.setImageBitmap((Bitmap)localObject);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.KxS.setLayoutParams(localLayoutParams);
        localObject = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.Kzq.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label340:
        if (paramBoolean)
        {
          if ((parambv.field_status != 5) && (parambv.field_status != 2)) {
            break label837;
          }
          if (parame.progressBar != null) {
            parame.progressBar.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        parame.olI.setTag(new bk(parambv, parama.fJC(), paramInt, parambv.field_talker, '\000'));
        parame.olI.setOnClickListener(paramd);
        parame.olI.setOnLongClickListener(paramc);
        parame.olI.setOnTouchListener(((k)parama.bh(k.class)).fGw());
        com.tencent.mm.plugin.report.service.g.yxI.f(16979, new Object[] { localb.hFd, localb.hFb, Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.modelappbrand.a.b.aEl().CU("file://".concat(String.valueOf(str)));
        parame = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
        if ((parame != null) && (!bu.isNullOrNil(parame.appThumbUrl))) {
          com.tencent.mm.modelappbrand.a.b.aEl().CU(parame.appThumbUrl);
        }
        if (com.tencent.mm.kernel.g.ab(f.class) != null) {
          ((f)com.tencent.mm.kernel.g.ab(f.class)).aYS();
        }
        if ((!az.isWifi(ak.getContext())) || (parame == null) || (bu.isNullOrNil(parame.videoSource))) {
          break label863;
        }
        parame = parame.videoSource;
        if (com.tencent.mm.kernel.g.ab(j.class) == null) {
          break label863;
        }
        parama = (j)com.tencent.mm.kernel.g.ab(j.class);
        if (!parama.byY()) {
          break label855;
        }
        int i = parama.byZ();
        paramInt = i;
        if (i != -1) {
          paramInt = i * 1024 * 1024;
        }
        XIPCInvoker.a("com.tencent.mm:appbrand0", new AppBrandWeishiVideoOperation(parame, paramInt), ab.c.class, null);
        AppMethodBeat.o(37082);
        return;
        str = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label682:
        parame.rLB.setVisibility(8);
        break label161;
        label694:
        ae.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
        parame.Kzq.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        i = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), 85);
        int j = com.tencent.mm.cb.a.ax(parama.Kkd.getContext(), 2131165213);
        localObject = com.tencent.mm.sdk.platformtools.h.b(com.tencent.mm.sdk.platformtools.h.aK(parama.Kkd.getContext().getResources().getColor(2131100478), i, j), 2131231564, i, j);
        parame.KxS.setImageBitmap((Bitmap)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.KxS.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.Kzq.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label340;
        label837:
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(0);
        }
      }
      label855:
      ae.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload disabled");
      label863:
      AppMethodBeat.o(37082);
    }
    
    public final c.a gL(View paramView)
    {
      AppMethodBeat.i(37081);
      super.gs(paramView);
      this.KxS = ((ImageView)paramView.findViewById(2131298074));
      this.Kzq = ((ImageView)paramView.findViewById(2131298076));
      this.olI = paramView.findViewById(2131298069);
      this.ndr = ((ImageView)paramView.findViewById(2131298175));
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      this.rLB = ((TextView)paramView.findViewById(2131298044));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131298183));
      this.KuL = ((ImageView)paramView.findViewById(2131298174));
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.hcH = paramView.findViewById(2131298147);
      AppMethodBeat.o(37081);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab
 * JD-Core Version:    0.7.0.1
 */