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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.i;
import com.tencent.mm.f.c.et;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.n;

public final class ak
{
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private ak.d XhI;
    
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
        localObject = new aq(paramLayoutInflater, R.i.edv);
        ((View)localObject).setTag(new ak.e().in((View)localObject));
      }
      AppMethodBeat.o(37070);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37071);
      this.WBq = parama1;
      parama = (ak.e)parama;
      if (this.XhI == null) {
        this.XhI = new ak.d(this.WBq, this);
      }
      ak.e.a(parama, paramInt, parama1, paramca, false, this.XhI, c(parama1));
      ((w)com.tencent.mm.kernel.h.ae(w.class)).bHS();
      AppMethodBeat.o(37071);
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(37073);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = bs.T(paramca);
        if (!Util.isNullOrNil(paramMenuItem)) {
          break label110;
        }
        paramMenuItem = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(16979, new Object[] { paramMenuItem.loB, paramMenuItem.loz, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, paramca, a(parama, paramca));
      }
      for (;;)
      {
        AppMethodBeat.o(37073);
        return false;
        label110:
        com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, new ak.a.1(this, paramMenuItem, parama), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37069);
            paramAnonymousDialogInterface = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
            if (paramAnonymousDialogInterface != null) {
              com.tencent.mm.plugin.report.service.h.IzE.a(16979, new Object[] { paramAnonymousDialogInterface.loB, paramAnonymousDialogInterface.loz, Integer.valueOf(0), Integer.valueOf(2) });
            }
            e.b.a(parama, paramca, ak.a.this.a(parama, paramca));
            com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(37069);
          }
        });
      }
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(275326);
      boolean bool = ak.a(this.WBq, paramo, paramView, paramca);
      AppMethodBeat.o(275326);
      return bool;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return true;
    }
    
    public final boolean hTD()
    {
      return false;
    }
    
    final boolean hTF()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private ak.d XhI;
    
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
        localObject = new aq(paramLayoutInflater, R.i.eet);
        ((View)localObject).setTag(new ak.e().in((View)localObject));
      }
      AppMethodBeat.o(37074);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37075);
      this.WBq = parama1;
      parama = (ak.e)parama;
      if (this.XhI == null) {
        this.XhI = new ak.d(this.WBq, this);
      }
      ak.e.a(parama, paramInt, parama1, paramca, true, this.XhI, c(parama1));
      a(paramInt, parama, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
      ((w)com.tencent.mm.kernel.h.ae(w.class)).bHS();
      AppMethodBeat.o(37075);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37077);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(16979, new Object[] { paramMenuItem.loB, paramMenuItem.loz, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, paramca, a(parama, paramca));
      }
      AppMethodBeat.o(37077);
      return false;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(286944);
      boolean bool = ak.a(this.WBq, paramo, paramView, paramca);
      AppMethodBeat.o(286944);
      return bool;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(286945);
      if (paramca.erk())
      {
        m.bh(paramca);
        bq.Gk(paramca.field_msgId);
        parama.Gi(true);
      }
      AppMethodBeat.o(286945);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return true;
    }
    
    public final boolean hTD()
    {
      return true;
    }
    
    final boolean hTF()
    {
      return false;
    }
  }
  
  static final class c
    implements d<AppBrandWeishiVideoOperation, IPCVoid>
  {}
  
  static final class d
    extends t.e
  {
    private c chattingItem;
    
    public d(com.tencent.mm.ui.chatting.e.a parama, c paramc)
    {
      super();
      this.chattingItem = paramc;
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37080);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      k.b localb = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
      if (localb == null)
      {
        Log.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
        AppMethodBeat.o(37080);
        return;
      }
      if ((Util.isNullOrNil(localb.loB)) && (Util.isNullOrNil(localb.loA)))
      {
        paramca = new Intent();
        str1 = localb.url;
        if (parama.hRi()) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          paramca.putExtra("rawUrl", com.tencent.mm.pluginsdk.model.app.q.V(str1, paramView));
          paramca.putExtra("webpageTitle", localb.title);
          paramca.putExtra("shortUrl", localb.url);
          com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
          AppMethodBeat.o(37080);
          return;
        }
      }
      String str1 = parama.getTalkerUserName();
      String str2 = this.chattingItem.a(parama, paramca);
      Bundle localBundle = new Bundle();
      int i;
      label307:
      boolean bool;
      if (parama.hRi())
      {
        i = 2;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        paramView = com.tencent.mm.pluginsdk.model.app.h.hn(localb.appId, localb.appVersion);
        if ((paramView != null) && (paramView.field_appName != null) && (paramView.field_appName.trim().length() > 0)) {
          break label537;
        }
        paramView = localb.appName;
        localBundle.putString("stat_weishi_app_name", paramView);
        localBundle.putString("stat_weishi_app_id", localb.appId);
        localBundle.putString("stat_weishi_source_username", localb.fUd);
        paramView = (com.tencent.mm.aj.a)localb.ar(com.tencent.mm.aj.a.class);
        if ((paramView == null) || (paramView.lkt != 1)) {
          break label545;
        }
        bool = true;
        label365:
        localBundle.putBoolean("stat_weishi_from_opensdk", bool);
        localBundle.putString("stat_weishi_msg_img_path", paramca.field_imgPath);
        localBundle.putString("stat_weishi_thumb_path", com.tencent.mm.ay.q.bmh().d(paramca.field_imgPath, false, true));
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
        com.tencent.mm.plugin.report.service.h.IzE.a(16979, new Object[] { localb.loB, localb.loz, Integer.valueOf(0), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1129L, 0L, 1L, false);
        ((r)com.tencent.mm.kernel.h.ae(r.class)).b(parama.WQv.getContext(), str1, str2, parama.hRi(), localb, localBundle);
        AppMethodBeat.o(37080);
        return;
        if (ab.Qm(str1))
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
    public ImageView XfI;
    public ImageView XhK;
    public ProgressBar progressBar;
    public ImageView rql;
    public TextView wRL;
    
    @SuppressLint({"ResourceType"})
    public static void a(e parame, int paramInt, com.tencent.mm.ui.chatting.e.a parama, ca paramca, boolean paramBoolean, ak.d paramd, c.c paramc)
    {
      AppMethodBeat.i(37082);
      k.b localb = k.b.OQ(bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
      if (localb == null)
      {
        Log.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
        AppMethodBeat.o(37082);
        return;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.hn(localb.appId, localb.appVersion);
      String str;
      label161:
      int i;
      if ((localObject == null) || (((g)localObject).field_appName == null) || (((g)localObject).field_appName.trim().length() <= 0))
      {
        str = localb.appName;
        if ((localb.appId == null) || (localb.appId.length() <= 0) || (!c.gZ(str))) {
          break label699;
        }
        parame.wRL.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama.WQv.getContext(), (g)localObject, str));
        parame.wRL.setVisibility(0);
        c.a(parama, parame.wRL, localb.appId);
        parame.rql.setImageDrawable(com.tencent.mm.ci.a.m(parama.WQv.getContext(), R.k.shortvideo_play_btn));
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(8);
        }
        str = com.tencent.mm.ay.q.bmh().d(paramca.field_imgPath, false, true);
        Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", new Object[] { paramca.field_imgPath, str });
        i = R.g.chat_img_template;
        localObject = com.tencent.mm.ay.q.bmh();
        float f = com.tencent.mm.ci.a.getDensity(parama.WQv.getContext());
        parama.WQv.getContext();
        localObject = ((i)localObject).a(str, f, i);
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label711;
        }
        parame.XfI.setImageBitmap((Bitmap)localObject);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.XfI.setLayoutParams(localLayoutParams);
        localObject = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.XhK.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label355:
        if (paramBoolean)
        {
          if ((paramca.field_status != 5) && (paramca.field_status != 2)) {
            break label854;
          }
          if (parame.progressBar != null) {
            parame.progressBar.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        parame.clickArea.setTag(new by(paramca, parama.hRi(), paramInt, paramca.field_talker, '\000'));
        parame.clickArea.setOnClickListener(paramd);
        parame.clickArea.setOnLongClickListener(paramc);
        parame.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
        com.tencent.mm.plugin.report.service.h.IzE.a(16979, new Object[] { localb.loB, localb.loz, Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.modelappbrand.a.b.bhh().SX("file://".concat(String.valueOf(str)));
        parame = (com.tencent.mm.aj.a)localb.ar(com.tencent.mm.aj.a.class);
        if ((parame != null) && (!Util.isNullOrNil(parame.appThumbUrl))) {
          com.tencent.mm.modelappbrand.a.b.bhh().SX(parame.appThumbUrl);
        }
        if (com.tencent.mm.kernel.h.ae(f.class) != null) {
          ((f)com.tencent.mm.kernel.h.ae(f.class)).a(z.qPg);
        }
        if ((NetStatusUtil.isWifi(MMApplicationContext.getContext())) && (parame != null) && (!Util.isNullOrNil(parame.videoSource)))
        {
          parame = parame.videoSource;
          if (com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.k.class) != null)
          {
            parama = (com.tencent.mm.plugin.appbrand.service.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.k.class);
            Log.i("MicroMsg.WeishiVideoItemViewHolder", "[weishi] parseMsgInfo, invoke video cache task");
            i = parama.ciD();
            paramInt = i;
            if (i != -1) {
              paramInt = i * 1024 * 1024;
            }
            XIPCInvoker.a(Appbrand0IPCService.PROCESS_NAME, new AppBrandWeishiVideoOperation(parame, paramInt), ak.c.class, null);
          }
        }
        AppMethodBeat.o(37082);
        return;
        str = ((g)localObject).field_appName;
        break;
        label699:
        parame.wRL.setVisibility(8);
        break label161;
        label711:
        Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
        parame.XhK.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        int j = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), 85);
        int k = com.tencent.mm.ci.a.aY(parama.WQv.getContext(), R.f.ChatImgLimitWidth);
        localObject = BitmapUtil.createMaskImage(BitmapUtil.createColorBitmap(parama.WQv.getContext().getResources().getColor(R.e.grey_color_01), j, k), i, j, k);
        parame.XfI.setImageBitmap((Bitmap)localObject);
        localObject = new FrameLayout.LayoutParams(j, k);
        parame.XfI.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new FrameLayout.LayoutParams(j, k);
        parame.XhK.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label355;
        label854:
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(0);
        }
      }
    }
    
    public final c.a in(View paramView)
    {
      AppMethodBeat.i(37081);
      super.create(paramView);
      this.XfI = ((ImageView)paramView.findViewById(R.h.dxe));
      this.XhK = ((ImageView)paramView.findViewById(R.h.dxg));
      this.clickArea = paramView.findViewById(R.h.chatting_click_area);
      this.rql = ((ImageView)paramView.findViewById(R.h.dzq));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.wRL = ((TextView)paramView.findViewById(R.h.dwI));
      this.progressBar = ((ProgressBar)paramView.findViewById(R.h.dzw));
      this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      AppMethodBeat.o(37081);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak
 * JD-Core Version:    0.7.0.1
 */