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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.i;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.t.e;
import com.tencent.mm.ui.chatting.t.n;

public final class ah
{
  public static final class a
    extends c
  {
    private ah.d PLO;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493566);
        ((View)localObject).setTag(new ah.e().hb((View)localObject));
      }
      AppMethodBeat.o(37070);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37071);
      this.PhN = parama1;
      parama = (ah.e)parama;
      if (this.PLO == null) {
        this.PLO = new ah.d(this.PhN, this);
      }
      ah.e.a(parama, paramInt, parama1, paramca, false, this.PLO, c(parama1));
      ((w)com.tencent.mm.kernel.g.af(w.class)).bwL();
      AppMethodBeat.o(37071);
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(37073);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = br.N(paramca);
        if (!Util.isNullOrNil(paramMenuItem)) {
          break label110;
        }
        paramMenuItem = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.CyF.a(16979, new Object[] { paramMenuItem.izj, paramMenuItem.izh, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, paramca, a(parama, paramca));
      }
      for (;;)
      {
        AppMethodBeat.o(37073);
        return false;
        label110:
        com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37068);
            paramAnonymousDialogInterface = new Intent();
            paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
            paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
            paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
            com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
            com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
            AppMethodBeat.o(37068);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37069);
            paramAnonymousDialogInterface = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
            if (paramAnonymousDialogInterface != null) {
              com.tencent.mm.plugin.report.service.h.CyF.a(16979, new Object[] { paramAnonymousDialogInterface.izj, paramAnonymousDialogInterface.izh, Integer.valueOf(0), Integer.valueOf(2) });
            }
            e.b.a(parama, paramca, ah.a.this.a(parama, paramca));
            com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(37069);
          }
        });
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233807);
      boolean bool = ah.a(this.PhN, paramm, paramView, paramca);
      AppMethodBeat.o(233807);
      return bool;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return true;
    }
    
    public final boolean gTT()
    {
      return false;
    }
    
    final boolean gTV()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private ah.d PLO;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493616);
        ((View)localObject).setTag(new ah.e().hb((View)localObject));
      }
      AppMethodBeat.o(37074);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37075);
      this.PhN = parama1;
      parama = (ah.e)parama;
      if (this.PLO == null) {
        this.PLO = new ah.d(this.PhN, this);
      }
      ah.e.a(parama, paramInt, parama1, paramca, true, this.PLO, c(parama1));
      a(paramInt, parama, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
      ((w)com.tencent.mm.kernel.g.af(w.class)).bwL();
      AppMethodBeat.o(37075);
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37077);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.CyF.a(16979, new Object[] { paramMenuItem.izj, paramMenuItem.izh, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, paramca, a(parama, paramca));
      }
      AppMethodBeat.o(37077);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(233808);
      boolean bool = ah.a(this.PhN, paramm, paramView, paramca);
      AppMethodBeat.o(233808);
      return bool;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233809);
      if (paramca.dOQ())
      {
        com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
        bp.Ad(paramca.field_msgId);
        parama.BN(true);
      }
      AppMethodBeat.o(233809);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      return true;
    }
    
    public final boolean gTT()
    {
      return true;
    }
    
    final boolean gTV()
    {
      return false;
    }
  }
  
  static final class c
    implements com.tencent.mm.ipcinvoker.b<AppBrandWeishiVideoOperation, IPCVoid>
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
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      k.b localb = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
      if (localb == null)
      {
        Log.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
        AppMethodBeat.o(37080);
        return;
      }
      if ((Util.isNullOrNil(localb.izj)) && (Util.isNullOrNil(localb.izi)))
      {
        paramca = new Intent();
        str1 = localb.url;
        if (parama.gRM()) {}
        for (paramView = "groupmessage";; paramView = "singlemessage")
        {
          paramca.putExtra("rawUrl", com.tencent.mm.pluginsdk.model.app.q.R(str1, paramView));
          paramca.putExtra("webpageTitle", localb.title);
          paramca.putExtra("shortUrl", localb.url);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramca);
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
      if (parama.gRM())
      {
        i = 2;
        localBundle.putInt("stat_scene", i);
        localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramca.field_msgSvrId));
        localBundle.putString("stat_chat_talker_username", str1);
        localBundle.putString("stat_send_msg_user", str2);
        paramView = com.tencent.mm.pluginsdk.model.app.h.gE(localb.appId, localb.appVersion);
        if ((paramView != null) && (paramView.field_appName != null) && (paramView.field_appName.trim().length() > 0)) {
          break label537;
        }
        paramView = localb.appName;
        localBundle.putString("stat_weishi_app_name", paramView);
        localBundle.putString("stat_weishi_app_id", localb.appId);
        localBundle.putString("stat_weishi_source_username", localb.eag);
        paramView = (com.tencent.mm.ag.a)localb.as(com.tencent.mm.ag.a.class);
        if ((paramView == null) || (paramView.ivk != 1)) {
          break label545;
        }
        bool = true;
        label365:
        localBundle.putBoolean("stat_weishi_from_opensdk", bool);
        localBundle.putString("stat_weishi_msg_img_path", paramca.field_imgPath);
        localBundle.putString("stat_weishi_thumb_path", com.tencent.mm.av.q.bcR().d(paramca.field_imgPath, false, true));
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
        com.tencent.mm.plugin.report.service.h.CyF.a(16979, new Object[] { localb.izj, localb.izh, Integer.valueOf(0), Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(1129L, 0L, 1L, false);
        ((r)com.tencent.mm.kernel.g.af(r.class)).b(parama.Pwc.getContext(), str1, str2, parama.gRM(), localb, localBundle);
        AppMethodBeat.o(37080);
        return;
        if (ab.IT(str1))
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
    public ImageView PKi;
    public ImageView PLQ;
    public ImageView ooE;
    public ProgressBar progressBar;
    public TextView tln;
    
    @SuppressLint({"ResourceType"})
    public static void a(e parame, int paramInt, com.tencent.mm.ui.chatting.e.a parama, ca paramca, boolean paramBoolean, ah.d paramd, c.c paramc)
    {
      AppMethodBeat.i(37082);
      k.b localb = k.b.HD(bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
      if (localb == null)
      {
        Log.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
        AppMethodBeat.o(37082);
        return;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.gE(localb.appId, localb.appVersion);
      String str;
      if ((localObject == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName == null) || (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName.trim().length() <= 0))
      {
        str = localb.appName;
        if ((localb.appId == null) || (localb.appId.length() <= 0) || (!c.gp(str))) {
          break label702;
        }
        parame.tln.setText(com.tencent.mm.pluginsdk.model.app.h.a(parama.Pwc.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, str));
        parame.tln.setVisibility(0);
        c.a(parama, parame.tln, localb.appId);
        label161:
        parame.ooE.setImageDrawable(com.tencent.mm.cb.a.l(parama.Pwc.getContext(), 2131691480));
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(8);
        }
        str = com.tencent.mm.av.q.bcR().d(paramca.field_imgPath, false, true);
        Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", new Object[] { paramca.field_imgPath, str });
        localObject = com.tencent.mm.av.q.bcR();
        float f = com.tencent.mm.cb.a.getDensity(parama.Pwc.getContext());
        parama.Pwc.getContext();
        localObject = ((i)localObject).a(str, f, 2131231628);
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label714;
        }
        parame.PKi.setImageBitmap((Bitmap)localObject);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.PKi.setLayoutParams(localLayoutParams);
        localObject = new FrameLayout.LayoutParams(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        parame.PLQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label349:
        if (paramBoolean)
        {
          if ((paramca.field_status != 5) && (paramca.field_status != 2)) {
            break label857;
          }
          if (parame.progressBar != null) {
            parame.progressBar.setVisibility(8);
          }
        }
      }
      for (;;)
      {
        parame.clickArea.setTag(new bq(paramca, parama.gRM(), paramInt, paramca.field_talker, '\000'));
        parame.clickArea.setOnClickListener(paramd);
        parame.clickArea.setOnLongClickListener(paramc);
        parame.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
        com.tencent.mm.plugin.report.service.h.CyF.a(16979, new Object[] { localb.izj, localb.izh, Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.modelappbrand.a.b.aXY().LF("file://".concat(String.valueOf(str)));
        parame = (com.tencent.mm.ag.a)localb.as(com.tencent.mm.ag.a.class);
        if ((parame != null) && (!Util.isNullOrNil(parame.appThumbUrl))) {
          com.tencent.mm.modelappbrand.a.b.aXY().LF(parame.appThumbUrl);
        }
        if (com.tencent.mm.kernel.g.af(f.class) != null) {
          ((f)com.tencent.mm.kernel.g.af(f.class)).a(z.nMO);
        }
        if ((!NetStatusUtil.isWifi(MMApplicationContext.getContext())) || (parame == null) || (Util.isNullOrNil(parame.videoSource))) {
          break label883;
        }
        parame = parame.videoSource;
        if (com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.k.class) == null) {
          break label883;
        }
        parama = (com.tencent.mm.plugin.appbrand.service.k)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.k.class);
        if (!parama.bVs()) {
          break label875;
        }
        Log.i("MicroMsg.WeishiVideoItemViewHolder", "[weishi] parseMsgInfo, invoke video cache task");
        int i = parama.bVt();
        paramInt = i;
        if (i != -1) {
          paramInt = i * 1024 * 1024;
        }
        XIPCInvoker.a(Appbrand0IPCService.dkO, new AppBrandWeishiVideoOperation(parame, paramInt), ah.c.class, null);
        AppMethodBeat.o(37082);
        return;
        str = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
        break;
        label702:
        parame.tln.setVisibility(8);
        break label161;
        label714:
        Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
        parame.PLQ.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        i = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), 85);
        int j = com.tencent.mm.cb.a.aG(parama.Pwc.getContext(), 2131165216);
        localObject = BitmapUtil.createMaskImage(BitmapUtil.createColorBitmap(parama.Pwc.getContext().getResources().getColor(2131100580), i, j), 2131231628, i, j);
        parame.PKi.setImageBitmap((Bitmap)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.PKi.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new FrameLayout.LayoutParams(i, j);
        parame.PLQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
        break label349;
        label857:
        if (parame.progressBar != null) {
          parame.progressBar.setVisibility(0);
        }
      }
      label875:
      Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload disabled");
      label883:
      AppMethodBeat.o(37082);
    }
    
    public final c.a hb(View paramView)
    {
      AppMethodBeat.i(37081);
      super.create(paramView);
      this.PKi = ((ImageView)paramView.findViewById(2131298417));
      this.PLQ = ((ImageView)paramView.findViewById(2131298419));
      this.clickArea = paramView.findViewById(2131298411);
      this.ooE = ((ImageView)paramView.findViewById(2131298555));
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.tln = ((TextView)paramView.findViewById(2131298385));
      this.progressBar = ((ProgressBar)paramView.findViewById(2131298563));
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      AppMethodBeat.o(37081);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah
 * JD-Core Version:    0.7.0.1
 */