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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.chatting.s.n;

public final class z
{
  public static final class a
    extends c
  {
    private z.d GMw;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493464);
        ((View)localObject).setTag(new z.e().gc((View)localObject));
      }
      AppMethodBeat.o(37070);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(37071);
      this.Gob = parama1;
      parama = (z.e)parama;
      if (this.GMw == null) {
        this.GMw = new z.d(this.Gob, this);
      }
      z.e.a(parama, paramInt, parama1, parambl, false, this.GMw, c(parama1));
      ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).aQG();
      AppMethodBeat.o(37071);
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37072);
      boolean bool = z.a(this.Gob, paramContextMenu, paramView, parambl);
      AppMethodBeat.o(37072);
      return bool;
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(37073);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = bk.C(parambl);
        if (!bt.isNullOrNil(paramMenuItem)) {
          break label110;
        }
        paramMenuItem = k.b.rx(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.vKh.f(16979, new Object[] { paramMenuItem.gJF, paramMenuItem.gJD, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, parambl, b(parama, parambl));
      }
      for (;;)
      {
        AppMethodBeat.o(37073);
        return false;
        label110:
        com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.GzJ.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37068);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
            d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37068);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37069);
            paramAnonymousDialogInterface = k.b.rx(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
            if (paramAnonymousDialogInterface != null) {
              com.tencent.mm.plugin.report.service.h.vKh.f(16979, new Object[] { paramAnonymousDialogInterface.gJF, paramAnonymousDialogInterface.gJD, Integer.valueOf(0), Integer.valueOf(2) });
            }
            e.b.a(parama, parambl, z.a.this.b(parama, parambl));
            com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(37069);
          }
        });
      }
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      return true;
    }
    
    public final boolean faE()
    {
      return false;
    }
    
    final boolean faF()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private z.d GMw;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493507);
        ((View)localObject).setTag(new z.e().gc((View)localObject));
      }
      AppMethodBeat.o(37074);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37078);
      if (parambl.cxB())
      {
        m.aB(parambl);
        com.tencent.mm.model.bi.lW(parambl.field_msgId);
        parama.wc(true);
      }
      AppMethodBeat.o(37078);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(37075);
      this.Gob = parama1;
      parama = (z.e)parama;
      if (this.GMw == null) {
        this.GMw = new z.d(this.Gob, this);
      }
      z.e.a(parama, paramInt, parama1, parambl, true, this.GMw, c(parama1));
      a(paramInt, parama, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
      ((com.tencent.mm.plugin.appbrand.service.q)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.q.class)).aQG();
      AppMethodBeat.o(37075);
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37076);
      boolean bool = z.a(this.Gob, paramContextMenu, paramView, parambl);
      AppMethodBeat.o(37076);
      return bool;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37077);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = k.b.rx(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.vKh.f(16979, new Object[] { paramMenuItem.gJF, paramMenuItem.gJD, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, parambl, b(parama, parambl));
      }
      AppMethodBeat.o(37077);
      return false;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      return true;
    }
    
    public final boolean faE()
    {
      return true;
    }
    
    final boolean faF()
    {
      return false;
    }
  }
  
  static final class d
    extends s.e
  {
    private c GIb;
    
    public d(com.tencent.mm.ui.chatting.d.a parama, c paramc)
    {
      super();
      this.GIb = paramc;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37080);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      k.b localb = k.b.rx(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
      if (localb == null)
      {
        ad.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
        AppMethodBeat.o(37080);
        return;
      }
      if ((bt.isNullOrNil(localb.gJF)) && (bt.isNullOrNil(localb.gJE)))
      {
        parambl = new Intent();
        str1 = localb.url;
        if (parama.eZb()) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          parambl.putExtra("rawUrl", com.tencent.mm.pluginsdk.model.app.q.O(str1, paramView));
          parambl.putExtra("webpageTitle", localb.title);
          parambl.putExtra("shortUrl", localb.url);
          d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", parambl);
          AppMethodBeat.o(37080);
          return;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = this.GIb.b(parama, parambl);
      Bundle localBundle = new Bundle();
      int i;
      label307:
      boolean bool;
      if (parama.eZb())
      {
        i = 2;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambl.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        paramView = com.tencent.mm.pluginsdk.model.app.h.fv(localb.appId, localb.aAS);
        if ((paramView != null) && (paramView.field_appName != null) && (paramView.field_appName.trim().length() > 0)) {
          break label537;
        }
        paramView = localb.appName;
        localBundle.putString("stat_weishi_app_name", paramView);
        localBundle.putString("stat_weishi_app_id", localb.appId);
        localBundle.putString("stat_weishi_source_username", localb.dxz);
        paramView = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
        if ((paramView == null) || (paramView.gFG != 1)) {
          break label545;
        }
        bool = true;
        label365:
        localBundle.putBoolean("stat_weishi_from_opensdk", bool);
        localBundle.putString("stat_weishi_msg_img_path", parambl.field_imgPath);
        localBundle.putString("stat_weishi_thumb_path", o.ayF().b(parambl.field_imgPath, false, true));
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
        com.tencent.mm.plugin.report.service.h.vKh.f(16979, new Object[] { localb.gJF, localb.gJD, Integer.valueOf(0), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1129L, 0L, 1L, false);
        ((n)com.tencent.mm.kernel.g.ab(n.class)).b(parama.GzJ.getContext(), str1, str2, parama.eZb(), localb, localBundle);
        AppMethodBeat.o(37080);
        return;
        if (w.sE(str1))
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
    public ImageView GLf;
    public ImageView GMy;
    public ImageView lVB;
    public ProgressBar progressBar;
    public TextView qkL;
    
    @SuppressLint({"ResourceType"})
    public static void a(e parame, int paramInt, com.tencent.mm.ui.chatting.d.a parama, bl parambl, boolean paramBoolean, z.d paramd, c.c paramc)
    {
      AppMethodBeat.i(37082);
      k.b localb = k.b.rx(com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
      if (localb == null)
      {
        ad.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
        AppMethodBeat.o(37082);
        return;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.fv(localb.appId, localb.aAS);
      String str;
      if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
      {
        str = localb.appName;
        if ((localb.appId == null) || (localb.appId.length() <= 0) || (!c.eM(str))) {
          break label682;
        }
        parame.qkL.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama.GzJ.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, str));
        parame.qkL.setVisibility(0);
        c.a(parama, parame.qkL, localb.appId);
        label161:
        parame.lVB.setImageDrawable(com.tencent.mm.cd.a.l(parama.GzJ.getContext(), 2131691166));
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(8);
        }
        str = o.ayF().b(parambl.field_imgPath, false, true);
        ad.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", new Object[] { parambl.field_imgPath, str });
        localObject = o.ayF().a(str, com.tencent.mm.cd.a.getDensity(parama.GzJ.getContext()), parama.GzJ.getContext(), 2131231564);
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label694;
        }
        parame.GLf.setImageBitmap((Bitmap)localObject);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.GLf.setLayoutParams(localLayoutParams);
        localObject = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.GMy.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label340:
        if (paramBoolean)
        {
          if ((parambl.field_status != 5) && (parambl.field_status != 2)) {
            break label837;
          }
          if (parame.progressBar != null) {
            parame.progressBar.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        parame.naN.setTag(new bi(parambl, parama.eZb(), paramInt, parambl.field_talker, '\000'));
        parame.naN.setOnClickListener(paramd);
        parame.naN.setOnLongClickListener(paramc);
        parame.naN.setOnTouchListener(((i)parama.be(i.class)).eWp());
        com.tencent.mm.plugin.report.service.h.vKh.f(16979, new Object[] { localb.gJF, localb.gJD, Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.modelappbrand.a.b.aub().vn("file://".concat(String.valueOf(str)));
        parame = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
        if ((parame != null) && (!bt.isNullOrNil(parame.appThumbUrl))) {
          com.tencent.mm.modelappbrand.a.b.aub().vn(parame.appThumbUrl);
        }
        if (com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class) != null) {
          ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.g.class)).aOn();
        }
        if ((!ay.isWifi(aj.getContext())) || (parame == null) || (bt.isNullOrNil(parame.videoSource))) {
          break label863;
        }
        parame = parame.videoSource;
        if (com.tencent.mm.kernel.g.ab(j.class) == null) {
          break label863;
        }
        parama = (j)com.tencent.mm.kernel.g.ab(j.class);
        if (!parama.bne()) {
          break label855;
        }
        int i = parama.bnf();
        paramInt = i;
        if (i != -1) {
          paramInt = i * 1024 * 1024;
        }
        XIPCInvoker.a("com.tencent.mm:appbrand0", new AppBrandWeishiVideoOperation(parame, paramInt), z.c.class, null);
        AppMethodBeat.o(37082);
        return;
        str = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label682:
        parame.qkL.setVisibility(8);
        break label161;
        label694:
        ad.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
        parame.GMy.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        i = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), 85);
        int j = com.tencent.mm.cd.a.ao(parama.GzJ.getContext(), 2131165213);
        localObject = f.b(f.aG(parama.GzJ.getContext().getResources().getColor(2131100478), i, j), 2131231564, i, j);
        parame.GLf.setImageBitmap((Bitmap)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.GLf.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.GMy.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    
    public final c.a gc(View paramView)
    {
      AppMethodBeat.i(37081);
      super.fK(paramView);
      this.GLf = ((ImageView)paramView.findViewById(2131298074));
      this.GMy = ((ImageView)paramView.findViewById(2131298076));
      this.naN = paramView.findViewById(2131298069);
      this.lVB = ((ImageView)paramView.findViewById(2131298175));
      this.wet = ((TextView)paramView.findViewById(2131298185));
      this.qkL = ((TextView)paramView.findViewById(2131298044));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131298183));
      this.GHZ = ((ImageView)paramView.findViewById(2131298174));
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.lRB = paramView.findViewById(2131298147);
      AppMethodBeat.o(37081);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z
 * JD-Core Version:    0.7.0.1
 */