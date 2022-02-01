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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.i;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;

public final class ab
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    private ab.d KcW;
    
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
        ((View)localObject).setTag(new ab.e().gG((View)localObject));
      }
      AppMethodBeat.o(37070);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(37071);
      this.JBI = parama1;
      parama = (ab.e)parama;
      if (this.KcW == null) {
        this.KcW = new ab.d(this.JBI, this);
      }
      ab.e.a(parama, paramInt, parama1, parambu, false, this.KcW, c(parama1));
      ((r)com.tencent.mm.kernel.g.ab(r.class)).baZ();
      AppMethodBeat.o(37071);
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final bu parambu)
    {
      AppMethodBeat.i(37073);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = bl.E(parambu);
        if (!bt.isNullOrNil(paramMenuItem)) {
          break label110;
        }
        paramMenuItem = k.b.yr(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.g.yhR.f(16979, new Object[] { paramMenuItem.hCo, paramMenuItem.hCm, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, parambu, b(parama, parambu));
      }
      for (;;)
      {
        AppMethodBeat.o(37073);
        return false;
        label110:
        com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37068);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
            d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37068);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37069);
            paramAnonymousDialogInterface = k.b.yr(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
            if (paramAnonymousDialogInterface != null) {
              com.tencent.mm.plugin.report.service.g.yhR.f(16979, new Object[] { paramAnonymousDialogInterface.hCo, paramAnonymousDialogInterface.hCm, Integer.valueOf(0), Integer.valueOf(2) });
            }
            e.b.a(parama, parambu, ab.a.this.b(parama, parambu));
            com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(37069);
          }
        });
      }
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194414);
      boolean bool = ab.a(this.JBI, paraml, paramView, parambu);
      AppMethodBeat.o(194414);
      return bool;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      return true;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean fHh()
    {
      return false;
    }
    
    final boolean fHi()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    private ab.d KcW;
    
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
        ((View)localObject).setTag(new ab.e().gG((View)localObject));
      }
      AppMethodBeat.o(37074);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37078);
      if (parambu.cTc())
      {
        m.aG(parambu);
        bj.rJ(parambu.field_msgId);
        parama.xR(true);
      }
      AppMethodBeat.o(37078);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(37075);
      this.JBI = parama1;
      parama = (ab.e)parama;
      if (this.KcW == null) {
        this.KcW = new ab.d(this.JBI, this);
      }
      ab.e.a(parama, paramInt, parama1, parambu, true, this.KcW, c(parama1));
      a(paramInt, parama, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
      ((r)com.tencent.mm.kernel.g.ab(r.class)).baZ();
      AppMethodBeat.o(37075);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37077);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = k.b.yr(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.g.yhR.f(16979, new Object[] { paramMenuItem.hCo, paramMenuItem.hCm, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, parambu, b(parama, parambu));
      }
      AppMethodBeat.o(37077);
      return false;
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194415);
      boolean bool = ab.a(this.JBI, paraml, paramView, parambu);
      AppMethodBeat.o(194415);
      return bool;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      return true;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean fHh()
    {
      return true;
    }
    
    final boolean fHi()
    {
      return false;
    }
  }
  
  static final class c
    implements com.tencent.mm.ipcinvoker.b<AppBrandWeishiVideoOperation, IPCVoid>
  {}
  
  static final class d
    extends s.e
  {
    private c JYv;
    
    public d(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.JYv = paramc;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37080);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      k.b localb = k.b.yr(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      if (localb == null)
      {
        ad.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
        AppMethodBeat.o(37080);
        return;
      }
      if ((bt.isNullOrNil(localb.hCo)) && (bt.isNullOrNil(localb.hCn)))
      {
        parambu = new Intent();
        str1 = localb.url;
        if (parama.fFv()) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          parambu.putExtra("rawUrl", com.tencent.mm.pluginsdk.model.app.q.Q(str1, paramView));
          parambu.putExtra("webpageTitle", localb.title);
          parambu.putExtra("shortUrl", localb.url);
          d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", parambu);
          AppMethodBeat.o(37080);
          return;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = this.JYv.b(parama, parambu);
      Bundle localBundle = new Bundle();
      int i;
      label307:
      boolean bool;
      if (parama.fFv())
      {
        i = 2;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambu.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        paramView = com.tencent.mm.pluginsdk.model.app.h.fX(localb.appId, localb.aDD);
        if ((paramView != null) && (paramView.field_appName != null) && (paramView.field_appName.trim().length() > 0)) {
          break label537;
        }
        paramView = localb.appName;
        localBundle.putString("stat_weishi_app_name", paramView);
        localBundle.putString("stat_weishi_app_id", localb.appId);
        localBundle.putString("stat_weishi_source_username", localb.dHo);
        paramView = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
        if ((paramView == null) || (paramView.hyq != 1)) {
          break label545;
        }
        bool = true;
        label365:
        localBundle.putBoolean("stat_weishi_from_opensdk", bool);
        localBundle.putString("stat_weishi_msg_img_path", parambu.field_imgPath);
        localBundle.putString("stat_weishi_thumb_path", com.tencent.mm.aw.q.aIF().c(parambu.field_imgPath, false, true));
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
        com.tencent.mm.plugin.report.service.g.yhR.f(16979, new Object[] { localb.hCo, localb.hCm, Integer.valueOf(0), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1129L, 0L, 1L, false);
        ((o)com.tencent.mm.kernel.g.ab(o.class)).b(parama.JOR.getContext(), str1, str2, parama.fFv(), localb, localBundle);
        AppMethodBeat.o(37080);
        return;
        if (w.zE(str1))
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
    public ImageView KbA;
    public ImageView KcY;
    public ImageView mYk;
    public ProgressBar progressBar;
    public TextView rDq;
    
    @SuppressLint({"ResourceType"})
    public static void a(e parame, int paramInt, com.tencent.mm.ui.chatting.e.a parama, bu parambu, boolean paramBoolean, ab.d paramd, c.c paramc)
    {
      AppMethodBeat.i(37082);
      k.b localb = k.b.yr(bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      if (localb == null)
      {
        ad.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
        AppMethodBeat.o(37082);
        return;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.fX(localb.appId, localb.aDD);
      String str;
      if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
      {
        str = localb.appName;
        if ((localb.appId == null) || (localb.appId.length() <= 0) || (!c.fx(str))) {
          break label682;
        }
        parame.rDq.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama.JOR.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, str));
        parame.rDq.setVisibility(0);
        c.a(parama, parame.rDq, localb.appId);
        label161:
        parame.mYk.setImageDrawable(com.tencent.mm.cc.a.l(parama.JOR.getContext(), 2131691166));
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(8);
        }
        str = com.tencent.mm.aw.q.aIF().c(parambu.field_imgPath, false, true);
        ad.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", new Object[] { parambu.field_imgPath, str });
        localObject = com.tencent.mm.aw.q.aIF().a(str, com.tencent.mm.cc.a.getDensity(parama.JOR.getContext()), parama.JOR.getContext(), 2131231564);
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label694;
        }
        parame.KbA.setImageBitmap((Bitmap)localObject);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.KbA.setLayoutParams(localLayoutParams);
        localObject = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.KcY.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label340:
        if (paramBoolean)
        {
          if ((parambu.field_status != 5) && (parambu.field_status != 2)) {
            break label837;
          }
          if (parame.progressBar != null) {
            parame.progressBar.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        parame.ofK.setTag(new bk(parambu, parama.fFv(), paramInt, parambu.field_talker, '\000'));
        parame.ofK.setOnClickListener(paramd);
        parame.ofK.setOnLongClickListener(paramc);
        parame.ofK.setOnTouchListener(((k)parama.bh(k.class)).fCu());
        com.tencent.mm.plugin.report.service.g.yhR.f(16979, new Object[] { localb.hCo, localb.hCm, Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.modelappbrand.a.b.aDV().Cs("file://".concat(String.valueOf(str)));
        parame = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
        if ((parame != null) && (!bt.isNullOrNil(parame.appThumbUrl))) {
          com.tencent.mm.modelappbrand.a.b.aDV().Cs(parame.appThumbUrl);
        }
        if (com.tencent.mm.kernel.g.ab(f.class) != null) {
          ((f)com.tencent.mm.kernel.g.ab(f.class)).aYx();
        }
        if ((!ay.isWifi(aj.getContext())) || (parame == null) || (bt.isNullOrNil(parame.videoSource))) {
          break label863;
        }
        parame = parame.videoSource;
        if (com.tencent.mm.kernel.g.ab(j.class) == null) {
          break label863;
        }
        parama = (j)com.tencent.mm.kernel.g.ab(j.class);
        if (!parama.byf()) {
          break label855;
        }
        int i = parama.byg();
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
        parame.rDq.setVisibility(8);
        break label161;
        label694:
        ad.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
        parame.KcY.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        i = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), 85);
        int j = com.tencent.mm.cc.a.ax(parama.JOR.getContext(), 2131165213);
        localObject = com.tencent.mm.sdk.platformtools.g.b(com.tencent.mm.sdk.platformtools.g.aJ(parama.JOR.getContext().getResources().getColor(2131100478), i, j), 2131231564, i, j);
        parame.KbA.setImageBitmap((Bitmap)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.KbA.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.KcY.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label340;
        label837:
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(0);
        }
      }
      label855:
      ad.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload disabled");
      label863:
      AppMethodBeat.o(37082);
    }
    
    public final c.a gG(View paramView)
    {
      AppMethodBeat.i(37081);
      super.gn(paramView);
      this.KbA = ((ImageView)paramView.findViewById(2131298074));
      this.KcY = ((ImageView)paramView.findViewById(2131298076));
      this.ofK = paramView.findViewById(2131298069);
      this.mYk = ((ImageView)paramView.findViewById(2131298175));
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.rDq = ((TextView)paramView.findViewById(2131298044));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131298183));
      this.JYs = ((ImageView)paramView.findViewById(2131298174));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      AppMethodBeat.o(37081);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab
 * JD-Core Version:    0.7.0.1
 */