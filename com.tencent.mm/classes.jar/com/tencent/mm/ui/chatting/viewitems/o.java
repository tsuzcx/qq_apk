package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.mr;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.pluginsdk.model.app.ar.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile;", "", "()V", "AppMsgFileViewHolder", "ChattingItemAppMsgFileFrom", "ChattingItemAppMsgFileTo", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final d aePR;
  
  static
  {
    AppMethodBeat.i(254931);
    aePR = new d((byte)0);
    AppMethodBeat.o(254931);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "appMsgLayout", "Landroid/widget/LinearLayout;", "getAppMsgLayout", "()Landroid/widget/LinearLayout;", "setAppMsgLayout", "(Landroid/widget/LinearLayout;)V", "chatWidth", "", "getChatWidth", "()I", "setChatWidth", "(I)V", "contentArea", "getContentArea", "setContentArea", "continueBtn", "Landroid/widget/ImageView;", "getContinueBtn", "()Landroid/widget/ImageView;", "setContinueBtn", "(Landroid/widget/ImageView;)V", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "setDescTV", "(Landroid/widget/TextView;)V", "descTipTV", "getDescTipTV", "setDescTipTV", "fileMask", "getFileMask", "setFileMask", "imgMPFootLine", "getImgMPFootLine", "setImgMPFootLine", "mediaIcon", "getMediaIcon", "setMediaIcon", "pauseBtn", "getPauseBtn", "setPauseBtn", "progressPB", "Lcom/tencent/mm/ui/widget/progress/RoundProgressBtn;", "getProgressPB", "()Lcom/tencent/mm/ui/widget/progress/RoundProgressBtn;", "setProgressPB", "(Lcom/tencent/mm/ui/widget/progress/RoundProgressBtn;)V", "receiveLoadingPb", "Landroid/widget/ProgressBar;", "getReceiveLoadingPb", "()Landroid/widget/ProgressBar;", "setReceiveLoadingPb", "(Landroid/widget/ProgressBar;)V", "sourceArea", "getSourceArea", "setSourceArea", "sourceIV", "getSourceIV", "setSourceIV", "sourceTV", "getSourceTV", "setSourceTV", "sourceTagIV", "getSourceTagIV", "setSourceTagIV", "sourceTagTV", "getSourceTagTV", "setSourceTagTV", "subMenuIcon", "getSubMenuIcon", "setSubMenuIcon", "thumbArea", "Landroid/widget/RelativeLayout;", "getThumbArea", "()Landroid/widget/RelativeLayout;", "setThumbArea", "(Landroid/widget/RelativeLayout;)V", "thumbIV", "Lcom/tencent/mm/ui/MMImageView;", "getThumbIV", "()Lcom/tencent/mm/ui/MMImageView;", "setThumbIV", "(Lcom/tencent/mm/ui/MMImageView;)V", "tickImageView", "getTickImageView", "setTickImageView", "titleTV", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTV", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setTitleTV", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "continueDownload", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "mediaId", "", "createAppMsgItem", "view", "Landroid/view/View;", "from", "", "reportKVStat", "msgInfo", "appmsgContent", "Lcom/tencent/mm/message/AppMessage$Content;", "action", "showIconArea", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "content", "isBitmapNull", "attachName", "updateAttachStatus", "holder", "updateProgress", "xml", "attachlen", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c.a
  {
    TextView Aoo;
    LinearLayout aeNB;
    private ImageView aeNG;
    MMImageView aeNf;
    MMNeat7extView aeNg;
    ImageView aeNh;
    ImageView aeNi;
    TextView aeNj;
    LinearLayout aeNk;
    ImageView aeNm;
    private ImageView aeNo;
    ImageView aeNp;
    ImageView aeNq;
    private ImageView aeNr;
    LinearLayout aeNv;
    RelativeLayout aeNz;
    private ImageView aeOp;
    int aeOt;
    private TextView aePS;
    RoundProgressBtn aePT;
    private ProgressBar aeev;
    TextView plr;
    
    private static final void a(cc paramcc, com.tencent.mm.pluginsdk.model.app.c paramc, a parama, String paramString, k.b paramb, com.tencent.mm.ui.chatting.d.a parama1, View paramView)
    {
      AppMethodBeat.i(255120);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramcc);
      localb.cH(paramc);
      localb.cH(parama);
      localb.cH(paramString);
      localb.cH(paramb);
      localb.cH(parama1);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramcc, "$msg");
      kotlin.g.b.s.u(paramc, "$attachInfo");
      kotlin.g.b.s.u(parama, "this$0");
      kotlin.g.b.s.u(paramb, "$content");
      kotlin.g.b.s.u(parama1, "$ui");
      localObject = new StringBuilder("progressPB(msgId:").append(paramcc.field_msgId).append(") click, status:").append(paramc.field_status).append(", progressPB:");
      paramView = parama.aePT;
      if (paramView == null)
      {
        paramView = null;
        Log.i("MicroMsg.ChattingItemAppMsgFile", paramView);
        parama = parama.aePT;
        if ((parama == null) || (parama.getVisibility() != 0)) {
          break label245;
        }
      }
      label245:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label251;
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255120);
        return;
        paramView = Integer.valueOf(paramView.getVisibility());
        break;
      }
      label251:
      switch (paramcc.fileStatus)
      {
      default: 
        if (paramc.field_status == 105L) {
          if (cn.bDu() - paramc.field_createTime < 432000000L)
          {
            com.tencent.mm.pluginsdk.model.app.n.an(paramcc.field_msgId, paramString);
            paramc = com.tencent.mm.pluginsdk.model.file.c.XTU;
            paramc = o.aePR;
            o.d.a(4, paramb, paramcc);
          }
        }
        break;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255120);
        return;
        if (cn.bDu() - paramc.field_createTime < 432000000L)
        {
          bh.bCz();
          paramc = com.tencent.mm.model.c.bzD().sl(paramcc.field_msgId);
          paramc.setFileStatus(0);
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramc);
          long l = paramcc.field_msgId;
          paramc = as.cWJ().yi(l);
          if (paramc == null) {
            Log.e("MicroMsg.AppMsgLogic", "ERR:" + f.aPX() + " getinfo failed: " + paramString);
          }
          for (;;)
          {
            paramc = com.tencent.mm.pluginsdk.model.file.c.XTU;
            paramc = o.aePR;
            o.d.a(4, paramb, paramcc);
            break;
            if (paramc.field_status != 198L)
            {
              Log.e("MicroMsg.AppMsgLogic", "ERR:" + f.aPX() + " get status failed: " + paramString + " status:" + paramc.field_status);
            }
            else
            {
              paramc.field_status = 101L;
              paramc.field_lastModifyTime = Util.nowSecond();
              as.cWJ().a(paramc, new String[0]);
              as.iIL().run();
            }
          }
        }
        com.tencent.mm.pluginsdk.model.app.n.a(parama1, paramcc, R.l.grI, paramb);
        continue;
        com.tencent.mm.pluginsdk.model.app.n.a(parama1, paramcc, R.l.grJ, paramb);
        continue;
        com.tencent.mm.pluginsdk.model.app.n.am(paramcc.field_msgId, paramString);
        paramc = com.tencent.mm.pluginsdk.model.file.c.XTU;
        com.tencent.mm.pluginsdk.model.file.c.bA(paramcc);
        paramc = o.aePR;
        o.d.a(2, paramb, paramcc);
      }
    }
    
    private static final void a(cc paramcc, com.tencent.mm.pluginsdk.model.app.c paramc, a parama, String paramString1, String paramString2, k.b paramb, View paramView)
    {
      AppMethodBeat.i(255114);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramcc);
      localb.cH(paramc);
      localb.cH(parama);
      localb.cH(paramString1);
      localb.cH(paramString2);
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramcc, "$msg");
      kotlin.g.b.s.u(paramc, "$attachInfo");
      kotlin.g.b.s.u(parama, "this$0");
      kotlin.g.b.s.u(paramb, "$content");
      localObject = new StringBuilder("progressPB(msgId:").append(paramcc.field_msgId).append(") click, status:").append(paramc.field_status).append(", progressPB:");
      paramView = parama.aePT;
      if (paramView == null)
      {
        paramView = null;
        Log.i("MicroMsg.ChattingItemAppMsgFile", paramView);
        parama = parama.aePT;
        if ((parama == null) || (parama.getVisibility() != 0)) {
          break label240;
        }
      }
      label240:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label246;
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255114);
        return;
        paramView = Integer.valueOf(paramView.getVisibility());
        break;
      }
      label246:
      switch (paramcc.fileStatus)
      {
      default: 
        if (paramc.field_status == 102L) {
          m(paramcc, paramString1);
        }
        break;
      }
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(255114);
          return;
          bh.bCz();
          paramc = com.tencent.mm.model.c.bzD().sl(paramcc.field_msgId);
          paramc.setFileStatus(0);
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramc);
          m(paramcc, paramString1);
        }
        com.tencent.mm.pluginsdk.model.app.n.i(paramcc.field_msgId, paramcc.field_talker, paramString2);
        com.tencent.mm.pluginsdk.model.file.b.XTS.br(paramcc);
      } while ((6 != paramb.type) && (74 != paramb.type));
      long l1 = paramcc.field_msgSvrId;
      paramc = (com.tencent.mm.message.a.b)paramb.aK(com.tencent.mm.message.a.b.class);
      if ((paramc != null) && (paramc.nVD != 0L)) {
        l1 = paramc.nVD;
      }
      for (;;)
      {
        paramc = am.aixg;
        paramc = paramb.nRq;
        if (paramb.nRh == 1) {}
        for (i = 7;; i = 5)
        {
          int j = paramb.nRd;
          long l2 = (cn.bDv() - paramcc.getCreateTime()) / 1000L;
          parama = Util.nullAsNil(paramb.nRe);
          kotlin.g.b.s.s(parama, "nullAsNil(appmsgContent.fileext)");
          parama = parama.toLowerCase();
          kotlin.g.b.s.s(parama, "(this as java.lang.String).toLowerCase()");
          paramcc = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Arrays.copyOf(new Object[] { paramc, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(15), Long.valueOf(l2), parama, paramcc.field_talker, Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(paramcc.getCreateTime()), Long.valueOf(cn.bDu()), Integer.valueOf(1) }, 13));
          kotlin.g.b.s.s(paramcc, "java.lang.String.format(format, *args)");
          Log.i("MicroMsg.ChattingItemAppMsgFile", "reportKVStat 14665 %s", new Object[] { paramcc });
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(14665, paramcc);
          break;
        }
      }
    }
    
    public static void a(a parama, String paramString, int paramInt)
    {
      AppMethodBeat.i(255091);
      kotlin.g.b.s.u(parama, "holder");
      int i = com.tencent.mm.pluginsdk.model.app.n.bpT(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        parama = parama.aePT;
        if (parama != null)
        {
          parama.setVisibility(8);
          AppMethodBeat.o(255091);
        }
      }
      else
      {
        paramString = parama.aePT;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        parama = parama.aePT;
        if (parama != null) {
          parama.setProgress(i);
        }
      }
      AppMethodBeat.o(255091);
    }
    
    private static final void dD(cc paramcc)
    {
      AppMethodBeat.i(255104);
      kotlin.g.b.s.u(paramcc, "$msg");
      cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(paramcc.field_msgId);
      localcc.setFileStatus(2);
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(paramcc.field_msgId, localcc);
      AppMethodBeat.o(255104);
    }
    
    private static void m(cc paramcc, String paramString)
    {
      AppMethodBeat.i(255099);
      com.tencent.mm.pluginsdk.model.app.c localc = as.cWJ().yi(paramcc.field_msgId);
      if (localc != null)
      {
        localc.field_status = 101L;
        localc.field_lastModifyTime = Util.nowSecond();
        as.cWJ().a(localc, new String[0]);
        paramString = new com.tencent.mm.plugin.record.model.g(paramcc.field_msgId, paramString, null);
        bh.aZW().a((p)paramString, 0);
        com.tencent.mm.pluginsdk.model.file.b.XTS.by(paramcc);
      }
      AppMethodBeat.o(255099);
    }
    
    public final a R(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(255134);
      kotlin.g.b.s.u(paramView, "view");
      super.create(paramView);
      Object localObject = paramView.findViewById(R.h.fwV);
      if ((localObject instanceof LinearLayout))
      {
        localObject = (LinearLayout)localObject;
        this.aeNk = ((LinearLayout)localObject);
        localObject = paramView.findViewById(R.h.fwW);
        if (!(localObject instanceof ImageView)) {
          break label738;
        }
        localObject = (ImageView)localObject;
        label63:
        this.aeNh = ((ImageView)localObject);
        localObject = paramView.findViewById(R.h.fwZ);
        if (!(localObject instanceof TextView)) {
          break label743;
        }
        localObject = (TextView)localObject;
        label88:
        this.Aoo = ((TextView)localObject);
        localObject = paramView.findViewById(R.h.fwX);
        if (!(localObject instanceof ImageView)) {
          break label748;
        }
        localObject = (ImageView)localObject;
        label113:
        this.aeNi = ((ImageView)localObject);
        localObject = paramView.findViewById(R.h.fwY);
        if (!(localObject instanceof TextView)) {
          break label753;
        }
        localObject = (TextView)localObject;
        label138:
        this.aeNj = ((TextView)localObject);
        localObject = paramView.findViewById(R.h.fxa);
        if (!(localObject instanceof ImageView)) {
          break label758;
        }
        localObject = (ImageView)localObject;
        label163:
        this.aeNm = ((ImageView)localObject);
        localObject = paramView.findViewById(R.h.fxc);
        if (!(localObject instanceof MMImageView)) {
          break label763;
        }
        localObject = (MMImageView)localObject;
        label188:
        this.aeNf = ((MMImageView)localObject);
        localObject = paramView.findViewById(R.h.gbo);
        if (!(localObject instanceof ProgressBar)) {
          break label768;
        }
        localObject = (ProgressBar)localObject;
        label213:
        this.uploadingPB = ((ProgressBar)localObject);
        localObject = paramView.findViewById(R.h.fAj);
        if (!(localObject instanceof ImageView)) {
          break label773;
        }
        localObject = (ImageView)localObject;
        label238:
        this.stateIV = ((ImageView)localObject);
        localObject = paramView.findViewById(R.h.fAr);
        if (!(localObject instanceof TextView)) {
          break label778;
        }
        localObject = (TextView)localObject;
        label263:
        this.userTV = ((TextView)localObject);
        localObject = paramView.findViewById(R.h.fxt);
        if (!(localObject instanceof CheckBox)) {
          break label783;
        }
        localObject = (CheckBox)localObject;
        label288:
        this.checkBox = ((CheckBox)localObject);
        this.maskView = paramView.findViewById(R.h.fzn);
        if (!paramBoolean)
        {
          localObject = this.convertView.findViewById(R.h.chatting_status_tick);
          if (!(localObject instanceof ImageView)) {
            break label788;
          }
          localObject = (ImageView)localObject;
          label331:
          this.aeNG = ((ImageView)localObject);
          localObject = this.convertView.findViewById(R.h.gbo);
          if (!(localObject instanceof ProgressBar)) {
            break label793;
          }
          localObject = (ProgressBar)localObject;
          label359:
          this.uploadingPB = ((ProgressBar)localObject);
        }
        localObject = this.convertView.findViewById(R.h.fAl);
        if (!(localObject instanceof ImageView)) {
          break label798;
        }
        localObject = (ImageView)localObject;
        label387:
        this.aeNq = ((ImageView)localObject);
        localObject = this.convertView.findViewById(R.h.fxD);
        if (!(localObject instanceof ImageView)) {
          break label803;
        }
        localObject = (ImageView)localObject;
        label415:
        this.aeNp = ((ImageView)localObject);
        localObject = paramView.findViewById(R.h.chatting_click_area);
        if (!(localObject instanceof FrameLayout)) {
          break label808;
        }
        localObject = (FrameLayout)localObject;
        label440:
        this.clickArea = ((View)localObject);
        localObject = paramView.findViewById(R.h.fwE);
        if (!(localObject instanceof LinearLayout)) {
          break label813;
        }
        localObject = (LinearLayout)localObject;
        label468:
        this.aeNB = ((LinearLayout)localObject);
        localObject = paramView.findViewById(R.h.fxe);
        if (!(localObject instanceof MMNeat7extView)) {
          break label818;
        }
        localObject = (MMNeat7extView)localObject;
        label493:
        this.aeNg = ((MMNeat7extView)localObject);
        localObject = paramView.findViewById(R.h.fwH);
        if (!(localObject instanceof TextView)) {
          break label823;
        }
        localObject = (TextView)localObject;
        label518:
        this.plr = ((TextView)localObject);
        localObject = paramView.findViewById(R.h.fwG);
        if (!(localObject instanceof TextView)) {
          break label828;
        }
        localObject = (TextView)localObject;
        label543:
        this.aePS = ((TextView)localObject);
        localObject = paramView.findViewById(R.h.fxb);
        if (!(localObject instanceof RelativeLayout)) {
          break label833;
        }
        localObject = (RelativeLayout)localObject;
        label568:
        this.aeNz = ((RelativeLayout)localObject);
        localObject = paramView.findViewById(R.h.fxO);
        if (!(localObject instanceof RoundProgressBtn)) {
          break label838;
        }
        localObject = (RoundProgressBtn)localObject;
        label593:
        this.aePT = ((RoundProgressBtn)localObject);
        localObject = this.convertView.findViewById(R.h.fxN);
        if (!(localObject instanceof ImageView)) {
          break label843;
        }
        localObject = (ImageView)localObject;
        label621:
        this.aeNo = ((ImageView)localObject);
        localObject = paramView.findViewById(R.h.fwJ);
        if (!(localObject instanceof ImageView)) {
          break label848;
        }
        localObject = (ImageView)localObject;
        label646:
        this.aeNr = ((ImageView)localObject);
        localObject = paramView.findViewById(R.h.app_msg_layout);
        if (!(localObject instanceof LinearLayout)) {
          break label853;
        }
        localObject = (LinearLayout)localObject;
        label671:
        this.aeNv = ((LinearLayout)localObject);
        this.aeOp = ((ImageView)paramView.findViewById(R.h.fOD));
        paramView = paramView.findViewById(R.h.fUf);
        if (!(paramView instanceof ProgressBar)) {
          break label858;
        }
      }
      label768:
      label773:
      label778:
      label783:
      label788:
      label793:
      label798:
      label803:
      label808:
      label813:
      label818:
      label823:
      label828:
      label833:
      label838:
      label843:
      label848:
      label853:
      label858:
      for (paramView = (ProgressBar)paramView;; paramView = null)
      {
        this.aeev = paramView;
        this.aeOt = c.nm(MMApplicationContext.getContext());
        AppMethodBeat.o(255134);
        return this;
        localObject = null;
        break;
        label738:
        localObject = null;
        break label63;
        label743:
        localObject = null;
        break label88;
        label748:
        localObject = null;
        break label113;
        label753:
        localObject = null;
        break label138;
        label758:
        localObject = null;
        break label163;
        label763:
        localObject = null;
        break label188;
        localObject = null;
        break label213;
        localObject = null;
        break label238;
        localObject = null;
        break label263;
        localObject = null;
        break label288;
        localObject = null;
        break label331;
        localObject = null;
        break label359;
        localObject = null;
        break label387;
        localObject = null;
        break label415;
        localObject = null;
        break label440;
        localObject = null;
        break label468;
        localObject = null;
        break label493;
        localObject = null;
        break label518;
        localObject = null;
        break label543;
        localObject = null;
        break label568;
        localObject = null;
        break label593;
        localObject = null;
        break label621;
        localObject = null;
        break label646;
        localObject = null;
        break label671;
      }
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, k.b paramb, cc paramcc, boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(255142);
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramb, "content");
      kotlin.g.b.s.u(paramcc, "msg");
      Object localObject1 = this.aePT;
      if (localObject1 != null) {
        ((RoundProgressBtn)localObject1).setVisibility(8);
      }
      localObject1 = this.aeNr;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = this.aePS;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.aeev;
      if (localObject1 != null) {
        ((ProgressBar)localObject1).setVisibility(8);
      }
      boolean bool8 = false;
      boolean bool4 = false;
      boolean bool5 = false;
      boolean bool7 = false;
      boolean bool9 = true;
      boolean bool3 = true;
      boolean bool6 = true;
      boolean bool2 = true;
      boolean bool1;
      if (paramb.type == 74)
      {
        if ((paramcc.fileStatus != 2) && (cn.bDu() - paramcc.getCreateTime() > 432000000L))
        {
          paramcc.setFileStatus(2);
          com.tencent.threadpool.h.ahAA.bm(new o.a..ExternalSyntheticLambda2(paramcc));
        }
        bool3 = bool2;
        bool1 = bool7;
        switch (paramcc.fileStatus)
        {
        default: 
          bool1 = bool7;
          bool3 = bool2;
        case 0: 
          Log.d("MicroMsg.ChattingItemAppMsgFile", "showIconArea(UPLOADING) msgId:" + paramcc.field_msgId + " fileStatus:" + paramcc.fileStatus);
          bool2 = bool1;
          bool1 = bool3;
        }
      }
      int i;
      label347:
      do
      {
        do
        {
          Log.d("MicroMsg.ChattingItemAppMsgFile", "showIconArea msgId:" + paramcc.field_msgId + " hasMask:" + bool2 + " hasIcon:" + bool1 + " isBitmapNull:" + paramBoolean);
          parama = this.aeNo;
          if (parama != null)
          {
            if (!bool2) {
              break label1521;
            }
            i = 0;
            parama.setVisibility(i);
          }
          if (!paramBoolean) {
            break label1667;
          }
          if (!bool1) {
            break label1596;
          }
          if (!Util.isImageExt(paramb.nRe)) {
            break label1536;
          }
          parama = this.aeNf;
          if (parama == null) {
            break label1667;
          }
          if (!aw.isDarkMode()) {
            break label1528;
          }
          i = R.k.app_attach_file_icon_photo_dark;
          parama.setImageResource(i);
          AppMethodBeat.o(255142);
          return;
          parama = this.aeev;
          if (parama != null) {
            parama.setVisibility(0);
          }
          bool1 = true;
          bool3 = false;
          break;
          bool1 = true;
          bool3 = bool2;
          break;
          bool1 = bool9;
          bool2 = bool8;
        } while (paramb.type != 6);
        localObject1 = as.cWJ().yi(paramcc.field_msgId);
        bool1 = bool9;
        bool2 = bool8;
      } while (localObject1 == null);
      label393:
      long l;
      if (paramcc.kLw == 1) {
        switch (paramcc.fileStatus)
        {
        default: 
          l = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status;
          if (l == 101L)
          {
            bool1 = true;
            bool2 = false;
            parama = this.aeNr;
            if (parama != null) {
              parama.setVisibility(8);
            }
            parama = this.aePT;
            if (parama != null) {
              parama.setHasPause(true);
            }
            parama = this.aePT;
            if (parama == null) {
              break label1040;
            }
            parama.setVisibility(0);
            bool1 = false;
            bool2 = true;
          }
          break;
        }
      }
      for (;;)
      {
        parama = this.aeNz;
        bool4 = bool1;
        bool3 = bool2;
        if (parama != null)
        {
          parama.setOnClickListener(new o.a..ExternalSyntheticLambda1(paramcc, (com.tencent.mm.pluginsdk.model.app.c)localObject1, this, paramString1, paramString2, paramb));
          bool3 = bool2;
          bool4 = bool1;
        }
        label632:
        Log.d("MicroMsg.ChattingItemAppMsgFile", "showIconArea msgId:" + paramcc.field_msgId + " isFileSender:" + paramcc.kLw + " fileStatus:" + ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status + ", hasMask:" + bool3 + " fileStatus:" + paramcc.fileStatus);
        bool1 = bool4;
        bool2 = bool3;
        break;
        Object localObject2 = this.aePT;
        if (localObject2 != null) {
          ((RoundProgressBtn)localObject2).setHasPause(false);
        }
        localObject2 = this.aePT;
        if (localObject2 != null) {
          ((RoundProgressBtn)localObject2).setVisibility(0);
        }
        localObject2 = this.aeNr;
        if (localObject2 != null) {
          ((ImageView)localObject2).setVisibility(0);
        }
        localObject2 = this.aeNr;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageResource(R.k.app_attach_file_arrow_down);
        }
        localObject2 = this.aePS;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(0);
        }
        localObject2 = this.aePS;
        if (localObject2 != null)
        {
          ((TextView)localObject2).setText((CharSequence)parama.aezO.getContext().getString(R.l.grF));
          bool1 = false;
          bool2 = true;
          continue;
          bool1 = true;
          bool2 = true;
          continue;
          if (l == 102L)
          {
            bool1 = true;
            bool2 = false;
            parama = this.aePT;
            if (parama != null) {
              parama.setHasPause(false);
            }
            parama = this.aePT;
            if (parama != null) {
              parama.setVisibility(0);
            }
            parama = this.aeNr;
            if (parama != null) {
              parama.setVisibility(0);
            }
            parama = this.aeNr;
            if (parama != null)
            {
              parama.setImageResource(R.k.app_attach_file_arrow_down);
              bool1 = false;
              bool2 = true;
            }
          }
          else if (l == 198L)
          {
            bool1 = true;
            parama = this.aePT;
            if (parama != null) {
              parama.setVisibility(8);
            }
            parama = this.aeNr;
            bool2 = bool3;
            if (parama != null)
            {
              parama.setVisibility(8);
              bool1 = true;
              bool2 = true;
            }
          }
          else
          {
            parama = this.aePT;
            if (parama != null) {
              parama.setVisibility(8);
            }
            parama = this.aeNr;
            bool2 = bool3;
            bool1 = bool4;
            if (parama != null)
            {
              parama.setVisibility(8);
              bool1 = bool4;
              bool2 = bool3;
            }
          }
          label1040:
          bool3 = bool1;
          bool1 = bool2;
          bool2 = bool3;
          continue;
          if ((paramcc.field_status < 2) || (paramcc.field_status == 5))
          {
            bool1 = true;
            bool2 = true;
          }
          for (;;)
          {
            paramString1 = this.aeNz;
            bool4 = bool1;
            bool3 = bool2;
            if (paramString1 == null) {
              break label632;
            }
            paramString1.setOnClickListener(new o.a..ExternalSyntheticLambda0(paramcc, (com.tencent.mm.pluginsdk.model.app.c)localObject1, this, paramString2, paramb, parama));
            bool4 = bool1;
            bool3 = bool2;
            break label632;
            switch (paramcc.fileStatus)
            {
            default: 
              l = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_status;
              if (l == 101L)
              {
                bool2 = true;
                bool1 = false;
                paramString1 = this.aeNr;
                if (paramString1 != null) {
                  paramString1.setVisibility(8);
                }
                paramString1 = this.aePT;
                if (paramString1 != null) {
                  paramString1.setHasPause(true);
                }
                paramString1 = this.aePT;
                if (paramString1 == null) {
                  break label1518;
                }
                paramString1.setVisibility(0);
                bool1 = false;
                bool2 = true;
              }
              break;
            case 100: 
              paramString1 = this.aePT;
              if (paramString1 != null) {
                paramString1.setHasPause(false);
              }
              paramString1 = this.aePT;
              if (paramString1 != null) {
                paramString1.setVisibility(0);
              }
              paramString1 = this.aeNr;
              if (paramString1 != null) {
                paramString1.setVisibility(0);
              }
              paramString1 = this.aeNr;
              if (paramString1 != null) {
                paramString1.setImageResource(R.k.app_attach_file_arrow_up);
              }
              paramString1 = this.aePS;
              if (paramString1 != null) {
                paramString1.setVisibility(0);
              }
              paramString1 = this.aePS;
              if (paramString1 != null)
              {
                paramString1.setText((CharSequence)parama.aezO.getContext().getString(R.l.grH));
                bool1 = false;
                bool2 = true;
              }
              break;
            case 101: 
              bool1 = true;
              bool2 = true;
              continue;
              if (l == 105L)
              {
                bool2 = true;
                bool1 = false;
                paramString1 = this.aePT;
                if (paramString1 != null) {
                  paramString1.setHasPause(false);
                }
                paramString1 = this.aePT;
                if (paramString1 != null) {
                  paramString1.setVisibility(0);
                }
                paramString1 = this.aeNr;
                if (paramString1 != null) {
                  paramString1.setVisibility(0);
                }
                paramString1 = this.aeNr;
                if (paramString1 != null)
                {
                  paramString1.setImageResource(R.k.app_attach_file_arrow_up);
                  bool1 = false;
                  bool2 = true;
                }
              }
              else
              {
                paramString1 = this.aePT;
                if (paramString1 != null) {
                  paramString1.setVisibility(8);
                }
                paramString1 = this.aeNr;
                bool1 = bool6;
                bool2 = bool5;
                if (paramString1 != null)
                {
                  paramString1.setVisibility(8);
                  bool2 = bool5;
                  bool1 = bool6;
                }
              }
              label1518:
              continue;
              label1521:
              i = 8;
              break label347;
              label1528:
              i = R.k.app_attach_file_icon_photo;
              break label393;
              label1536:
              if (e.b.bBv(paramb.nRe))
              {
                parama = this.aeNf;
                if (parama != null)
                {
                  parama.setImageResource(R.k.app_attach_file_icon_video);
                  AppMethodBeat.o(255142);
                }
              }
              else
              {
                parama = this.aeNf;
                if (parama != null)
                {
                  parama.setImageResource(x.bpB(paramb.nRe));
                  AppMethodBeat.o(255142);
                  return;
                  label1596:
                  if (Util.isImageExt(paramb.nRe))
                  {
                    parama = this.aeNf;
                    if (parama != null)
                    {
                      if (aw.isDarkMode()) {}
                      for (i = R.k.app_attach_file_icon_simple_dark;; i = R.k.app_attach_file_icon_simple)
                      {
                        parama.setImageResource(i);
                        AppMethodBeat.o(255142);
                        return;
                      }
                    }
                  }
                  else
                  {
                    parama = this.aeNf;
                    if (parama != null) {
                      parama.setImageResource(x.bpD(paramb.nRe));
                    }
                  }
                }
              }
              label1667:
              AppMethodBeat.o(255142);
              return;
              bool1 = false;
              bool2 = true;
            }
          }
        }
        else
        {
          bool1 = false;
          bool2 = true;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileFrom;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "support", "msgType", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c
  {
    private static final String TAG;
    public static final o.b.a aePU;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    static
    {
      AppMethodBeat.i(255098);
      aePU = new o.b.a((byte)0);
      TAG = "MicroMsg.ChattingItemAppMsgFileFrom";
      AppMethodBeat.o(255098);
    }
    
    private static final void a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, b paramb, String paramString, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(255094);
      kotlin.g.b.s.u(paramb, "this$0");
      e.b.a(parama, paramcc, paramb.a(parama, paramcc));
      com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(2), paramString });
      AppMethodBeat.o(255094);
    }
    
    private static final void a(String paramString, com.tencent.mm.ui.chatting.d.a parama, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(255087);
      paramDialogInterface = new Intent();
      paramDialogInterface.putExtra("rawUrl", paramString);
      paramDialogInterface.putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.YxF);
      paramDialogInterface.putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.YxA);
      kotlin.g.b.s.checkNotNull(parama);
      com.tencent.mm.br.c.b((Context)parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramDialogInterface);
      com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(1), paramString });
      AppMethodBeat.o(255087);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255116);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramLayoutInflater = new ap(paramLayoutInflater, R.i.gfC);
        paramLayoutInflater.setTag(new o.a().R((View)paramLayoutInflater, false));
        paramLayoutInflater = (View)paramLayoutInflater;
        AppMethodBeat.o(255116);
        return paramLayoutInflater;
      }
      AppMethodBeat.o(255116);
      return paramView;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255131);
      kotlin.g.b.s.u(parama1, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if (parama == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChattingItemAppMsgFile.AppMsgFileViewHolder");
        AppMethodBeat.o(255131);
        throw parama;
      }
      o.a locala = (o.a)parama;
      this.aeiK = parama1;
      String str = paramcc.field_content;
      parama = (com.tencent.mm.ui.chatting.component.api.o)parama1.cm(com.tencent.mm.ui.chatting.component.api.o.class);
      parama.cN(paramcc);
      parama.cO(paramcc);
      parama.cP(paramcc);
      if (str != null) {}
      label649:
      label1546:
      label1686:
      label1691:
      for (parama = k.b.aP(str, paramcc.field_reserved);; parama = null)
      {
        bz localbz = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
        Object localObject;
        label607:
        boolean bool1;
        TextView localTextView;
        label841:
        label987:
        boolean bool2;
        if (parama != null)
        {
          paramString = locala.aeNg;
          if (paramString != null) {
            paramString.aZ((CharSequence)parama.getTitle());
          }
          paramString = locala.aeNg;
          if (paramString != null) {
            paramString.setContentDescription((CharSequence)parama.getTitle());
          }
          paramString = locala.plr;
          if (paramString != null) {
            paramString.setText((CharSequence)parama.getDescription());
          }
          paramString = locala.aeNg;
          if (paramString != null) {
            paramString.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_0));
          }
          paramString = locala.plr;
          if (paramString != null) {
            paramString.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.half_alpha_black));
          }
          paramString = locala.aeNB;
          if (paramString != null) {
            paramString.setBackgroundResource(R.g.chatfrom_bg_app);
          }
          paramString = locala.aeNB;
          if (paramString != null) {
            paramString.setPadding(0, parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
          }
          paramString = locala.aeNf;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.aeNz;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.plr;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.aePT;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNq;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNp;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNB;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.aeNi;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNj;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
          locala.clickArea.setBackgroundResource(R.g.chatfrom_bg_app);
          localObject = com.tencent.mm.pluginsdk.model.app.h.is(parama.appId, parama.appVersion);
          if (localObject != null) {
            b(parama1, parama, paramcc);
          }
          if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName != null))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
            kotlin.g.b.s.s(paramString, "appInfo.field_appName");
            paramString = (CharSequence)paramString;
            int i = 0;
            paramInt = paramString.length() - 1;
            int j = 0;
            while (i <= paramInt)
            {
              int k;
              if (j == 0)
              {
                k = i;
                if (kotlin.g.b.s.compare(paramString.charAt(k), 32) > 0) {
                  break label649;
                }
                k = 1;
              }
              for (;;)
              {
                if (j == 0)
                {
                  if (k == 0)
                  {
                    j = 1;
                    break;
                    k = paramInt;
                    break label607;
                    k = 0;
                    continue;
                  }
                  i += 1;
                  break;
                }
              }
              if (k == 0) {
                break;
              }
              paramInt -= 1;
            }
            if (paramString.subSequence(i, paramInt + 1).toString().length() > 0) {
              break label1511;
            }
          }
          paramString = parama.appName;
          bool1 = true;
          if ((parama.type == 20) || (kotlin.g.b.s.p("wxaf060266bfa9a35c", parama.appId))) {
            bool1 = com.tencent.mm.pluginsdk.o.a.iGH().gXa();
          }
          if ((!bool1) || (parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.iA(paramString))) {
            break label1565;
          }
          paramString = com.tencent.mm.pluginsdk.model.app.h.a((Context)parama1.aezO.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString);
          if (parama.type != 19) {
            break label1521;
          }
          localTextView = locala.Aoo;
          if (localTextView != null) {
            localTextView.setText((CharSequence)parama1.aezO.getContext().getResources().getString(R.l.opensdk_source_tv_record, new Object[] { paramString }));
          }
          paramString = locala.Aoo;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.Aoo;
          if (paramString != null) {
            paramString.setCompoundDrawables(null, null, null, null);
          }
          paramString = locala.aeNk;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.aeNh;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).aqJ())) {
            break label1546;
          }
          a(parama1, (View)locala.Aoo, paramcc, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_packageName, paramcc.field_msgSvrId);
          label954:
          paramString = locala.aeNh;
          if (paramString != null) {
            paramString.setImageResource(R.g.fnp);
          }
          a(parama1, locala.aeNh, parama.appId);
          if (parama.bwn())
          {
            paramString = locala.aeNk;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
          }
          paramString = locala.aeNk;
          if (paramString != null) {
            paramString.setBackgroundResource(R.g.mm_trans);
          }
          bool2 = false;
          paramString = locala.aeNf;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if ((parama.bwo()) || (!this.wQm)) {
            break label1645;
          }
          if ((parama.type == 33) || (parama.type == 36) || (parama.type == 44) || (parama.type == 48) || (e.b.bBw(paramcc.field_imgPath))) {
            break label1713;
          }
        }
        label1565:
        label1713:
        for (paramString = r.bKa().a(paramcc.field_imgPath, com.tencent.mm.cd.a.getDensity((Context)parama1.aezO.getContext()), false);; paramString = null)
        {
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramString = BitmapUtil.getRoundedCornerBitmap(paramString, false, com.tencent.mm.cd.a.fromDPToPix((Context)parama1.aezO.getContext(), 1));
            localObject = locala.aeNf;
            bool1 = bool2;
            if (localObject != null)
            {
              ((MMImageView)localObject).setImageBitmap(paramString);
              bool1 = bool2;
            }
            label1205:
            paramString = locala.aeNv;
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = locala.aeNm;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            if (parama.title == null) {
              break label1691;
            }
            paramString = parama.title;
            kotlin.g.b.s.s(paramString, "content.title");
            if (((CharSequence)paramString).length() <= 0) {
              break label1686;
            }
            paramInt = 1;
            label1278:
            if (paramInt == 0) {
              break label1691;
            }
            paramString = locala.aeNg;
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = locala.aeNg;
            if (paramString != null) {
              paramString.setMaxLines(2);
            }
          }
          for (;;)
          {
            paramString = locala.plr;
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = locala.aeNm;
            if (paramString != null) {
              paramString.setVisibility(4);
            }
            paramString = locala.plr;
            if (paramString != null) {
              paramString.setMaxLines(2);
            }
            paramString = locala.plr;
            if (paramString != null) {
              paramString.setText((CharSequence)Util.getSizeKB(parama.nRd));
            }
            o.a.a(locala, str, parama.nRd);
            locala.a(parama1, parama, paramcc, bool1, parama.hzM, parama.title);
            locala.clickArea.setTag(localbz);
            locala.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
            if (this.wQm)
            {
              locala.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
              locala.clickArea.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
            }
            AppMethodBeat.o(255131);
            return;
            label1511:
            paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
            break;
            label1521:
            localTextView = locala.Aoo;
            if (localTextView == null) {
              break label841;
            }
            localTextView.setText((CharSequence)paramString);
            break label841;
            a(parama1, (View)locala.Aoo, parama.appId);
            break label954;
            paramString = o.aePR;
            if (o.d.a(parama, locala)) {
              break label987;
            }
            paramString = locala.aeNk;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            paramString = locala.Aoo;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            paramString = locala.aeNh;
            if (paramString == null) {
              break label987;
            }
            paramString.setVisibility(8);
            break label987;
            bool1 = true;
            break label1205;
            label1645:
            paramString = locala.aeNf;
            bool1 = bool2;
            if (paramString == null) {
              break label1205;
            }
            paramString.setImageBitmap(BitmapFactory.decodeResource(parama1.aezO.getMMResources(), R.g.foI));
            bool1 = bool2;
            break label1205;
            paramInt = 0;
            break label1278;
            paramString = locala.aeNg;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255140);
      if (paramcc == null)
      {
        AppMethodBeat.o(255140);
        return false;
      }
      kotlin.g.b.s.checkNotNull(paramMenuItem);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(255140);
        return false;
      case 100: 
        AppMethodBeat.o(255140);
        return false;
      case 111: 
        if (!ae.cj(paramcc))
        {
          kotlin.g.b.s.checkNotNull(parama);
          k.a((Context)parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gHq), "", parama.aezO.getContext().getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(255140);
          return false;
        }
        paramMenuItem = bt.X(paramcc);
        if (Util.isNullOrNil(paramMenuItem)) {
          e.b.a(parama, paramcc, a(parama, paramcc));
        }
        for (;;)
        {
          AppMethodBeat.o(255140);
          return false;
          com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          kotlin.g.b.s.checkNotNull(parama);
          k.a((Context)parama.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new o.b..ExternalSyntheticLambda1(paramMenuItem, parama), new o.b..ExternalSyntheticLambda0(parama, paramcc, this, paramMenuItem));
        }
      }
      paramMenuItem = paramcc.field_content;
      if (paramMenuItem == null)
      {
        AppMethodBeat.o(255140);
        return false;
      }
      if (k.b.Hf(paramMenuItem) != null)
      {
        kotlin.g.b.s.checkNotNull(parama);
        com.tencent.mm.ui.chatting.ap.b(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), (Context)parama.aezO.getContext());
      }
      AppMethodBeat.o(255140);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255135);
      kotlin.g.b.s.u(params, "menu");
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(paramcc, "msg");
      paramContextMenuInfo = paramView.getTag();
      if (paramContextMenuInfo == null)
      {
        params = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(255135);
        throw params;
      }
      int i = ((bz)paramContextMenuInfo).position;
      paramContextMenuInfo = this.aeiK;
      kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
      int j = com.tencent.mm.pluginsdk.model.app.n.bpT(br.a(paramContextMenuInfo.juG(), paramcc.field_content, paramcc.field_isSend));
      paramContextMenuInfo = this.aeiK;
      kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
      paramContextMenuInfo = k.b.Hf(br.a(paramContextMenuInfo.juG(), paramcc.field_content, paramcc.field_isSend));
      Object localObject1 = com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false);
      Object localObject2;
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject1)) && (!com.tencent.mm.ui.chatting.m.bR(paramcc)) && (paramContextMenuInfo.type == 6))
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.n.bpU(paramContextMenuInfo.hzM);
        if (((localObject2 == null) || (!e.b.j(paramcc, ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath))) && (!paramcc.isClean()))
        {
          localObject2 = this.aeiK;
          kotlin.g.b.s.checkNotNull(localObject2);
          params.a(i, 111, (CharSequence)((com.tencent.mm.ui.chatting.d.a)localObject2).aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
      if ((paramContextMenuInfo.nRd <= 0) || ((paramContextMenuInfo.nRd > 0) && (j >= 100)))
      {
        boolean bool = com.tencent.mm.an.g.bGP();
        if (!Util.isImageExt(paramContextMenuInfo.nRe))
        {
          localObject2 = this.aeiK;
          kotlin.g.b.s.checkNotNull(localObject2);
          params.a(i, 150, (CharSequence)((com.tencent.mm.ui.chatting.d.a)localObject2).aezO.getMMResources().getString(R.l.gyv), R.k.icons_filled_otherapp);
        }
        if (bool)
        {
          localObject2 = this.aeiK;
          kotlin.g.b.s.checkNotNull(localObject2);
          if (!((com.tencent.mm.ui.chatting.d.a)localObject2).juH()) {
            params.add(i, 114, 0, (CharSequence)paramView.getContext().getString(R.l.gyk));
          }
        }
      }
      if ((com.tencent.mm.br.c.blq("favorite")) && ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject1).aqJ())) && (paramContextMenuInfo != null) && (paramContextMenuInfo.type != 74)) {
        params.a(i, 116, (CharSequence)paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      localObject1 = new ex();
      ((ex)localObject1).hFc.msgId = paramcc.field_msgId;
      ((ex)localObject1).publish();
      if (!((ex)localObject1).hFd.hEn)
      {
        localObject1 = this.aeiK;
        kotlin.g.b.s.checkNotNull(localObject1);
        if (!e.b.a((Context)((com.tencent.mm.ui.chatting.d.a)localObject1).aezO.getContext(), paramContextMenuInfo)) {}
      }
      else
      {
        params.a(i, 129, (CharSequence)paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      if (bt.F(paramcc)) {
        params.clear();
      }
      paramView = this.aeiK;
      kotlin.g.b.s.checkNotNull(paramView);
      if (!paramView.juH())
      {
        paramView = this.aeiK;
        kotlin.g.b.s.checkNotNull(paramView);
        params.a(i, 100, (CharSequence)paramView.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(255135);
      return true;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255143);
      kotlin.g.b.s.u(paramcc, "msg");
      com.tencent.mm.modelstat.a.a(paramcc, a.a.oUW);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      Object localObject = paramcc.field_content;
      if (localObject == null)
      {
        AppMethodBeat.o(255143);
        return false;
      }
      kotlin.g.b.s.checkNotNull(parama);
      paramView = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      localObject = t.Hk((String)localObject);
      if (paramView == null)
      {
        AppMethodBeat.o(255143);
        return false;
      }
      if ((localObject != null) && (((t)localObject).nUJ != 0)) {
        paramView.type = ((t)localObject).nUJ;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.h.s(paramView.appId, false, false);
      String str = d(parama, paramcc);
      if (localObject != null) {
        a(parama, paramView, str, (com.tencent.mm.pluginsdk.model.app.g)localObject, paramcc.field_msgSvrId, parama.getTalkerUserName());
      }
      if (!this.wQm)
      {
        aa.j((Context)parama.aezO.getContext(), parama.aezO.getContentView());
        AppMethodBeat.o(255143);
        return true;
      }
      paramView = new Intent();
      paramView.setClassName((Context)parama.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachNewDownloadUI");
      paramView.putExtra("scene", 2);
      paramView.putExtra("app_msg_id", paramcc.field_msgId);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(255143);
      return true;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1090519089);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileTo;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "support", "msgType", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends c
    implements v.n
  {
    public static final o.c.a aePV;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    static
    {
      AppMethodBeat.i(255100);
      aePV = new o.c.a((byte)0);
      AppMethodBeat.o(255100);
    }
    
    private static final void W(DialogInterface paramDialogInterface, int paramInt) {}
    
    private static final void a(cc paramcc, com.tencent.mm.ui.chatting.d.a parama, DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(255092);
      kotlin.g.b.s.checkNotNull(paramcc);
      if (paramcc.fxR())
      {
        com.tencent.mm.pluginsdk.model.app.n.bx(paramcc);
        parama.jpK();
        AppMethodBeat.o(255092);
        return;
      }
      AppMethodBeat.o(255092);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255117);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramLayoutInflater = new ap(paramLayoutInflater, R.i.ggC);
        paramLayoutInflater.setTag(new o.a().R((View)paramLayoutInflater, true));
        paramLayoutInflater = (View)paramLayoutInflater;
        AppMethodBeat.o(255117);
        return paramLayoutInflater;
      }
      AppMethodBeat.o(255117);
      return paramView;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255133);
      kotlin.g.b.s.u(parama1, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if (parama == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChattingItemAppMsgFile.AppMsgFileViewHolder");
        AppMethodBeat.o(255133);
        throw parama;
      }
      o.a locala = (o.a)parama;
      this.aeiK = parama1;
      ((com.tencent.mm.ui.chatting.component.api.o)parama1.cm(com.tencent.mm.ui.chatting.component.api.o.class)).cP(paramcc);
      String str = paramcc.field_content;
      ((com.tencent.mm.ui.chatting.component.api.o)parama1.cm(com.tencent.mm.ui.chatting.component.api.o.class)).cN(paramcc);
      if (str != null) {}
      label584:
      label968:
      label1614:
      label1620:
      for (parama = k.b.aP(str, paramcc.field_reserved);; parama = null)
      {
        bz localbz = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
        Object localObject;
        int i;
        label627:
        boolean bool1;
        TextView localTextView;
        boolean bool2;
        if (parama != null)
        {
          localObject = com.tencent.mm.pluginsdk.model.app.h.is(parama.appId, parama.appVersion);
          paramString = locala.aeNg;
          if (paramString != null) {
            paramString.aZ((CharSequence)parama.getTitle());
          }
          paramString = locala.aeNg;
          if (paramString != null) {
            paramString.setContentDescription((CharSequence)parama.getTitle());
          }
          paramString = locala.plr;
          if (paramString != null) {
            paramString.setText((CharSequence)parama.description);
          }
          paramString = locala.aeNg;
          if (paramString != null) {
            paramString.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_0));
          }
          paramString = locala.plr;
          if (paramString != null) {
            paramString.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.half_alpha_black));
          }
          paramString = locala.aeNB;
          if (paramString != null) {
            paramString.setBackgroundResource(R.g.chatto_bg_app);
          }
          paramString = locala.aeNB;
          if (paramString != null) {
            paramString.setPadding(0, parama1.aezO.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
          }
          paramString = locala.aeNf;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.aeNz;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.plr;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.aeNq;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNp;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNm;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNi;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNj;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.aeNB;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
          if ((localObject != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName != null))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
            kotlin.g.b.s.s(paramString, "appInfo.field_appName");
            paramString = (CharSequence)paramString;
            int j = 0;
            i = paramString.length() - 1;
            int k = 0;
            while (j <= i)
            {
              int m;
              if (k == 0)
              {
                m = j;
                if (kotlin.g.b.s.compare(paramString.charAt(m), 32) > 0) {
                  break label627;
                }
                m = 1;
              }
              for (;;)
              {
                if (k == 0)
                {
                  if (m == 0)
                  {
                    k = 1;
                    break;
                    m = i;
                    break label584;
                    m = 0;
                    continue;
                  }
                  j += 1;
                  break;
                }
              }
              if (m == 0) {
                break;
              }
              i -= 1;
            }
            if (paramString.subSequence(j, i + 1).toString().length() > 0) {
              break label1439;
            }
          }
          paramString = parama.appName;
          bool1 = true;
          if ((parama.type == 20) || (kotlin.g.b.s.p("wxaf060266bfa9a35c", parama.appId))) {
            bool1 = com.tencent.mm.pluginsdk.o.a.iGH().gXa();
          }
          if ((!bool1) || (parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.iA(paramString))) {
            break label1493;
          }
          paramString = com.tencent.mm.pluginsdk.model.app.h.a((Context)parama1.aezO.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject, paramString);
          if (parama.type != 19) {
            break label1449;
          }
          localTextView = locala.Aoo;
          if (localTextView != null) {
            localTextView.setText((CharSequence)parama1.aezO.getContext().getResources().getString(R.l.opensdk_source_tv_record, new Object[] { paramString }));
          }
          paramString = locala.aeNk;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.Aoo;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.Aoo;
          if (paramString != null) {
            paramString.setCompoundDrawables(null, null, null, null);
          }
          paramString = locala.aeNh;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).aqJ())) {
            break label1474;
          }
          a(parama1, (View)locala.Aoo, paramcc, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_packageName, paramcc.field_msgSvrId);
          paramString = locala.aeNh;
          if (paramString != null) {
            paramString.setImageResource(R.g.fnp);
          }
          a(parama1, locala.aeNh, parama.appId);
          paramString = locala.aeNk;
          if (paramString != null) {
            paramString.setBackgroundResource(R.g.mm_trans);
          }
          bool2 = false;
          paramString = locala.aeNf;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if (!this.wQm) {
            break label1573;
          }
          if ((parama.type == 33) || (parama.type == 36) || (parama.type == 44) || (parama.type == 48) || (e.b.bBw(paramcc.field_imgPath))) {
            break label1657;
          }
        }
        label1493:
        label1630:
        label1654:
        label1657:
        for (paramString = r.bKa().a(paramcc.field_imgPath, com.tencent.mm.cd.a.getDensity((Context)parama1.aezO.getContext()), false);; paramString = null)
        {
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramString = BitmapUtil.getRoundedCornerBitmap(paramString, false, com.tencent.mm.cd.a.fromDPToPix((Context)parama1.aezO.getContext(), 1));
            localObject = locala.aeNf;
            bool1 = bool2;
            if (localObject != null)
            {
              ((MMImageView)localObject).setImageBitmap(paramString);
              bool1 = bool2;
            }
            paramString = locala.aeNg;
            if (paramString != null)
            {
              if (parama.title == null) {
                break label1620;
              }
              localObject = parama.title;
              kotlin.g.b.s.s(localObject, "content.title");
              if (((CharSequence)localObject).length() <= 0) {
                break label1614;
              }
              i = 1;
              if (i == 0) {
                break label1620;
              }
              paramString.setVisibility(0);
              paramString.setMaxLines(2);
            }
            paramString = locala.plr;
            if (paramString != null)
            {
              paramString.setVisibility(0);
              paramString.setMaxLines(2);
              paramString.setText((CharSequence)Util.getSizeKB(parama.nRd));
            }
            paramString = locala.aeNm;
            if (paramString != null) {
              paramString.setVisibility(4);
            }
            o.a.a(locala, str, parama.nRd);
            locala.a(parama1, parama, paramcc, bool1, parama.hzM, parama.title);
            if (!c.jxj()) {
              break label1630;
            }
            parama = (c.a)locala;
          }
          for (;;)
          {
            bool1 = false;
            for (paramString = this;; paramString = this)
            {
              paramString.b(parama, bool1);
              locala.clickArea.setTag(localbz);
              locala.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
              if (this.wQm)
              {
                locala.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
                locala.clickArea.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.component.api.m)parama1.cm(com.tencent.mm.ui.chatting.component.api.m.class)).jqv());
              }
              a(paramInt, (c.a)locala, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, (v.n)this);
              AppMethodBeat.o(255133);
              return;
              paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName;
              break;
              localTextView = locala.Aoo;
              if (localTextView == null) {
                break label822;
              }
              localTextView.setText((CharSequence)paramString);
              break label822;
              a(parama1, (View)locala.Aoo, parama.appId);
              break label935;
              paramString = o.aePR;
              if (o.d.a(parama, locala)) {
                break label968;
              }
              paramString = locala.aeNk;
              if (paramString != null) {
                paramString.setVisibility(8);
              }
              paramString = locala.Aoo;
              if (paramString != null) {
                paramString.setVisibility(8);
              }
              paramString = locala.aeNh;
              if (paramString == null) {
                break label968;
              }
              paramString.setVisibility(8);
              break label968;
              bool1 = true;
              break label1153;
              paramString = locala.aeNf;
              bool1 = bool2;
              if (paramString == null) {
                break label1153;
              }
              paramString.setImageBitmap(BitmapFactory.decodeResource(parama1.aezO.getMMResources(), R.g.foI));
              bool1 = bool2;
              break label1153;
              i = 0;
              break label1202;
              paramString.setVisibility(8);
              break label1219;
              parama = (c.a)locala;
              if (paramcc.field_status >= 2) {
                break label1654;
              }
              bool1 = true;
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255141);
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      kotlin.g.b.s.checkNotNull(paramMenuItem);
      switch (paramMenuItem.getItemId())
      {
      default: 
      case 100: 
      case 111: 
        for (;;)
        {
          AppMethodBeat.o(255141);
          return false;
          AppMethodBeat.o(255141);
          return false;
          if (paramcc.fxR())
          {
            paramMenuItem = k.b.Hf(paramcc.field_content);
            if (paramMenuItem != null)
            {
              if (paramMenuItem.type == 40)
              {
                k.a((Context)parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gHq), "", parama.aezO.getContext().getString(R.l.welcome_i_know), null);
                AppMethodBeat.o(255141);
                return false;
              }
              if ((paramMenuItem.type == 33) && (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable((Context)parama.aezO.getContext())))
              {
                AppMethodBeat.o(255141);
                return false;
              }
            }
          }
          e.b.a(parama, paramcc, a(parama, paramcc));
        }
      case 114: 
        paramMenuItem = paramcc.field_content;
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(255141);
          return false;
        }
        if (k.b.Hf(paramMenuItem) != null) {
          com.tencent.mm.ui.chatting.ap.b(paramcc, br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend), (Context)parama.aezO.getContext());
        }
        AppMethodBeat.o(255141);
        return false;
      }
      AppMethodBeat.o(255141);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255136);
      kotlin.g.b.s.u(params, "menu");
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(paramcc, "msg");
      paramContextMenuInfo = paramView.getTag();
      if (paramContextMenuInfo == null)
      {
        params = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(255136);
        throw params;
      }
      int i = ((bz)paramContextMenuInfo).position;
      if (paramcc.field_content == null)
      {
        AppMethodBeat.o(255136);
        return true;
      }
      paramContextMenuInfo = this.aeiK;
      kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
      paramContextMenuInfo = k.b.Hf(br.a(paramContextMenuInfo.juG(), paramcc.field_content, paramcc.field_isSend));
      if (paramContextMenuInfo == null)
      {
        AppMethodBeat.o(255136);
        return true;
      }
      Object localObject = com.tencent.mm.pluginsdk.model.app.h.s(paramContextMenuInfo.appId, false, false);
      com.tencent.mm.ui.chatting.d.a locala;
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject)) && (!com.tencent.mm.ui.chatting.m.bR(paramcc)) && (paramcc.field_status != 1) && (paramContextMenuInfo.type == 6))
      {
        locala = this.aeiK;
        kotlin.g.b.s.checkNotNull(locala);
        params.a(i, 111, (CharSequence)locala.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)))
      {
        locala = this.aeiK;
        kotlin.g.b.s.checkNotNull(locala);
        if (!au.Hh(locala.getTalkerUserName())) {
          params.a(i, 123, (CharSequence)paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
        }
      }
      boolean bool = com.tencent.mm.an.g.bGP();
      if (!Util.isImageExt(paramContextMenuInfo.nRe))
      {
        locala = this.aeiK;
        kotlin.g.b.s.checkNotNull(locala);
        params.a(i, 150, (CharSequence)locala.aezO.getMMResources().getString(R.l.gyv), R.k.icons_filled_otherapp);
      }
      if (bool)
      {
        locala = this.aeiK;
        kotlin.g.b.s.checkNotNull(locala);
        if (!locala.juH()) {
          params.add(i, 114, 0, (CharSequence)paramView.getContext().getString(R.l.gyk));
        }
      }
      if ((com.tencent.mm.br.c.blq("favorite")) && ((localObject == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject).aqJ())) && (paramContextMenuInfo.type != 74)) {
        params.a(i, 116, (CharSequence)paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      localObject = new ex();
      ((ex)localObject).hFc.msgId = paramcc.field_msgId;
      ((ex)localObject).publish();
      if (!((ex)localObject).hFd.hEn)
      {
        paramcc = this.aeiK;
        kotlin.g.b.s.checkNotNull(paramcc);
        if (!e.b.a((Context)paramcc.aezO.getContext(), paramContextMenuInfo)) {}
      }
      else
      {
        params.a(i, 129, (CharSequence)paramView.getContext().getString(R.l.gyu), R.k.icons_filled_open);
      }
      paramView = this.aeiK;
      kotlin.g.b.s.checkNotNull(paramView);
      if (!paramView.juH())
      {
        paramView = this.aeiK;
        kotlin.g.b.s.checkNotNull(paramView);
        params.a(i, 100, (CharSequence)paramView.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
      }
      AppMethodBeat.o(255136);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255147);
      kotlin.g.b.s.checkNotNull(parama);
      k.b((Context)parama.aezO.getContext(), parama.aezO.getMMResources().getString(R.l.gzl), "", parama.aezO.getMMResources().getString(R.l.app_resend), parama.aezO.getMMResources().getString(R.l.app_cancel), new o.c..ExternalSyntheticLambda0(paramcc, parama), o.c..ExternalSyntheticLambda1.INSTANCE);
      AppMethodBeat.o(255147);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255144);
      kotlin.g.b.s.u(paramcc, "msg");
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      paramView = paramcc.field_content;
      if (paramView == null)
      {
        AppMethodBeat.o(255144);
        return false;
      }
      paramView = k.b.Hf(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(255144);
        return false;
      }
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.s(paramView.appId, true, false);
      if ((localg != null) && (!Util.isNullOrNil(localg.field_appId)))
      {
        String str = z.bAM();
        long l = paramcc.field_msgSvrId;
        kotlin.g.b.s.checkNotNull(parama);
        a(parama, paramView, str, localg, l, parama.getTalkerUserName());
      }
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        kotlin.g.b.s.checkNotNull(parama);
        aa.j((Context)parama.aezO.getContext(), parama.aezO.getContentView());
        AppMethodBeat.o(255144);
        return true;
      }
      if ((Util.isImageExt(paramView.nRe)) && (e.e.a(paramcc.field_msgId, paramView.hzM, parama)))
      {
        AppMethodBeat.o(255144);
        return true;
      }
      paramView = new Intent();
      kotlin.g.b.s.checkNotNull(parama);
      paramView.setClassName((Context)parama.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachNewDownloadUI");
      paramView.putExtra("scene", 2);
      paramView.putExtra("app_msg_id", paramcc.field_msgId);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(255144);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1090519089);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$Companion;", "", "()V", "MAX_SHOW_LINES", "", "MIN_SECOND_LINE_SHOW_CNT", "TAG", "", "adjustEllipsizeMiddle", "", "textView", "Landroid/widget/TextView;", "sourceStr", "isWebSearchBlock", "", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "reportSendFileAction", "action", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "setWebSearchBlock", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    public static void a(int paramInt, k.b paramb, cc paramcc)
    {
      AppMethodBeat.i(255070);
      if (paramcc == null)
      {
        AppMethodBeat.o(255070);
        return;
      }
      com.tencent.threadpool.h.ahAA.bm(new o.d..ExternalSyntheticLambda0(paramb, paramcc, paramInt));
      AppMethodBeat.o(255070);
    }
    
    private static final void a(k.b paramb, cc paramcc, int paramInt)
    {
      Object localObject = null;
      AppMethodBeat.i(255074);
      k.b localb = paramb;
      if (paramb == null) {
        localb = k.b.Hf(paramcc.field_content);
      }
      mr localmr = new mr();
      localmr.ikE = paramInt;
      long l;
      if (localb == null)
      {
        l = 0L;
        localmr.iIE = l;
        if (localb != null) {
          break label172;
        }
        paramb = null;
        label60:
        paramb = Util.nullAsNil(paramb);
        kotlin.g.b.s.s(paramb, "nullAsNil(amc?.fileext)");
        paramb = paramb.toLowerCase();
        kotlin.g.b.s.s(paramb, "(this as java.lang.String).toLowerCase()");
        localmr.jbY = localmr.F("FileExt", paramb, true);
        localmr.imN = localmr.F("ChatName", paramcc.field_talker, true);
        if (localb != null) {
          break label181;
        }
        paramb = null;
        label120:
        if (paramb != null) {
          break label195;
        }
      }
      label172:
      label181:
      label195:
      for (paramb = localObject;; paramb = Long.valueOf(paramb.nVD))
      {
        localmr.jbZ = localmr.F("MsgSvrId", String.valueOf(paramb), true);
        localmr.jca = 1L;
        localmr.bMH();
        AppMethodBeat.o(255074);
        return;
        l = localb.nRd;
        break;
        paramb = localb.nRe;
        break label60;
        paramb = (com.tencent.mm.message.a.b)localb.aK(com.tencent.mm.message.a.b.class);
        break label120;
      }
    }
    
    public static boolean a(k.b paramb, o.a parama)
    {
      AppMethodBeat.i(255060);
      kotlin.g.b.s.u(paramb, "content");
      kotlin.g.b.s.u(parama, "holder");
      if (m(paramb))
      {
        paramb = parama.aeNk;
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramb = parama.Aoo;
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramb = parama.Aoo;
        if (paramb != null) {
          paramb.setText(R.l.top_story_chatting_app_msg_brand_name);
        }
        paramb = parama.aeNh;
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramb = parama.aeNh;
        if (paramb != null) {
          paramb.setImageResource(R.g.fpE);
        }
        AppMethodBeat.o(255060);
        return true;
      }
      AppMethodBeat.o(255060);
      return false;
    }
    
    private static boolean m(k.b paramb)
    {
      AppMethodBeat.i(255064);
      kotlin.g.b.s.u(paramb, "content");
      paramb = (ak)paramb.aK(ak.class);
      if ((paramb != null) && (!Util.isNullOrNil(paramb.WoZ)))
      {
        AppMethodBeat.o(255064);
        return true;
      }
      AppMethodBeat.o(255064);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o
 * JD-Core Version:    0.7.0.1
 */