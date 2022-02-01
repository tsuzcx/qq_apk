package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.b.a.ka;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.progress.RoundProgressBtn;
import java.util.Arrays;
import kotlin.g.b.aa.a;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile;", "", "()V", "AppMsgFileViewHolder", "ChattingItemAppMsgFileFrom", "ChattingItemAppMsgFileTo", "Companion", "app_release"})
public final class o
{
  public static final d XfQ;
  
  static
  {
    AppMethodBeat.i(290814);
    XfQ = new d((byte)0);
    AppMethodBeat.o(290814);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "appMsgLayout", "Landroid/widget/LinearLayout;", "getAppMsgLayout", "()Landroid/widget/LinearLayout;", "setAppMsgLayout", "(Landroid/widget/LinearLayout;)V", "chatWidth", "", "getChatWidth", "()I", "setChatWidth", "(I)V", "contentArea", "getContentArea", "setContentArea", "continueBtn", "Landroid/widget/ImageView;", "getContinueBtn", "()Landroid/widget/ImageView;", "setContinueBtn", "(Landroid/widget/ImageView;)V", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "setDescTV", "(Landroid/widget/TextView;)V", "descTipTV", "getDescTipTV", "setDescTipTV", "fileMask", "getFileMask", "setFileMask", "imgMPFootLine", "getImgMPFootLine", "setImgMPFootLine", "mediaIcon", "getMediaIcon", "setMediaIcon", "pauseBtn", "getPauseBtn", "setPauseBtn", "progressPB", "Lcom/tencent/mm/ui/widget/progress/RoundProgressBtn;", "getProgressPB", "()Lcom/tencent/mm/ui/widget/progress/RoundProgressBtn;", "setProgressPB", "(Lcom/tencent/mm/ui/widget/progress/RoundProgressBtn;)V", "receiveLoadingPb", "Landroid/widget/ProgressBar;", "getReceiveLoadingPb", "()Landroid/widget/ProgressBar;", "setReceiveLoadingPb", "(Landroid/widget/ProgressBar;)V", "sourceArea", "getSourceArea", "setSourceArea", "sourceIV", "getSourceIV", "setSourceIV", "sourceTV", "getSourceTV", "setSourceTV", "sourceTagIV", "getSourceTagIV", "setSourceTagIV", "sourceTagTV", "getSourceTagTV", "setSourceTagTV", "subMenuIcon", "getSubMenuIcon", "setSubMenuIcon", "thumbArea", "Landroid/widget/RelativeLayout;", "getThumbArea", "()Landroid/widget/RelativeLayout;", "setThumbArea", "(Landroid/widget/RelativeLayout;)V", "thumbIV", "Lcom/tencent/mm/ui/MMImageView;", "getThumbIV", "()Lcom/tencent/mm/ui/MMImageView;", "setThumbIV", "(Lcom/tencent/mm/ui/MMImageView;)V", "tickImageView", "getTickImageView", "setTickImageView", "titleTV", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTV", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setTitleTV", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "continueDownload", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "mediaId", "", "createAppMsgItem", "view", "Landroid/view/View;", "from", "", "reportKVStat", "msgInfo", "appmsgContent", "Lcom/tencent/mm/message/AppMessage$Content;", "action", "showIconArea", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "content", "isBitmapNull", "attachName", "updateAttachStatus", "holder", "updateProgress", "xml", "attachlen", "app_release"})
  public static final class a
    extends c.a
  {
    private ProgressBar Wxe;
    RelativeLayout XdB;
    LinearLayout XdD;
    private ImageView XdI;
    MMImageView Xdh;
    MMNeat7extView Xdi;
    ImageView Xdj;
    ImageView Xdk;
    TextView Xdl;
    LinearLayout Xdm;
    ImageView Xdo;
    private ImageView Xdq;
    ImageView Xdr;
    ImageView Xds;
    private ImageView Xdt;
    LinearLayout Xdx;
    private ImageView Xer;
    int Xev;
    private TextView XfR;
    RoundProgressBtn XfS;
    TextView mrM;
    TextView wRL;
    
    public static void a(a parama, String paramString, int paramInt)
    {
      AppMethodBeat.i(232693);
      p.k(parama, "holder");
      int i = com.tencent.mm.pluginsdk.model.app.m.bqe(paramString);
      if ((i == -1) || (i >= 100) || (paramInt <= 0))
      {
        parama = parama.XfS;
        if (parama != null)
        {
          parama.setVisibility(8);
          AppMethodBeat.o(232693);
          return;
        }
        AppMethodBeat.o(232693);
        return;
      }
      paramString = parama.XfS;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
      parama = parama.XfS;
      if (parama != null)
      {
        parama.setProgress(i);
        AppMethodBeat.o(232693);
        return;
      }
      AppMethodBeat.o(232693);
    }
    
    public final a L(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(232689);
      p.k(paramView, "view");
      super.create(paramView);
      View localView2 = paramView.findViewById(R.h.dwE);
      View localView1 = localView2;
      if (!(localView2 instanceof LinearLayout)) {
        localView1 = null;
      }
      this.Xdm = ((LinearLayout)localView1);
      localView2 = paramView.findViewById(R.h.dwF);
      localView1 = localView2;
      if (!(localView2 instanceof ImageView)) {
        localView1 = null;
      }
      this.Xdj = ((ImageView)localView1);
      localView2 = paramView.findViewById(R.h.dwI);
      localView1 = localView2;
      if (!(localView2 instanceof TextView)) {
        localView1 = null;
      }
      this.wRL = ((TextView)localView1);
      localView2 = paramView.findViewById(R.h.dwG);
      localView1 = localView2;
      if (!(localView2 instanceof ImageView)) {
        localView1 = null;
      }
      this.Xdk = ((ImageView)localView1);
      localView2 = paramView.findViewById(R.h.dwH);
      localView1 = localView2;
      if (!(localView2 instanceof TextView)) {
        localView1 = null;
      }
      this.Xdl = ((TextView)localView1);
      localView2 = paramView.findViewById(R.h.dwJ);
      localView1 = localView2;
      if (!(localView2 instanceof ImageView)) {
        localView1 = null;
      }
      this.Xdo = ((ImageView)localView1);
      localView2 = paramView.findViewById(R.h.dwL);
      localView1 = localView2;
      if (!(localView2 instanceof MMImageView)) {
        localView1 = null;
      }
      this.Xdh = ((MMImageView)localView1);
      localView2 = paramView.findViewById(R.h.dYz);
      localView1 = localView2;
      if (!(localView2 instanceof ProgressBar)) {
        localView1 = null;
      }
      this.uploadingPB = ((ProgressBar)localView1);
      localView2 = paramView.findViewById(R.h.dzp);
      localView1 = localView2;
      if (!(localView2 instanceof ImageView)) {
        localView1 = null;
      }
      this.stateIV = ((ImageView)localView1);
      localView2 = paramView.findViewById(R.h.chatting_user_tv);
      localView1 = localView2;
      if (!(localView2 instanceof TextView)) {
        localView1 = null;
      }
      this.userTV = ((TextView)localView1);
      localView2 = paramView.findViewById(R.h.dwZ);
      localView1 = localView2;
      if (!(localView2 instanceof CheckBox)) {
        localView1 = null;
      }
      this.checkBox = ((CheckBox)localView1);
      this.maskView = paramView.findViewById(R.h.dyD);
      if (!paramBoolean)
      {
        localView2 = this.convertView.findViewById(R.h.chatting_status_tick);
        localView1 = localView2;
        if (!(localView2 instanceof ImageView)) {
          localView1 = null;
        }
        this.XdI = ((ImageView)localView1);
        localView2 = this.convertView.findViewById(R.h.dYz);
        localView1 = localView2;
        if (!(localView2 instanceof ProgressBar)) {
          localView1 = null;
        }
        this.uploadingPB = ((ProgressBar)localView1);
      }
      localView2 = this.convertView.findViewById(R.h.dzr);
      localView1 = localView2;
      if (!(localView2 instanceof ImageView)) {
        localView1 = null;
      }
      this.Xds = ((ImageView)localView1);
      localView2 = this.convertView.findViewById(R.h.dxi);
      localView1 = localView2;
      if (!(localView2 instanceof ImageView)) {
        localView1 = null;
      }
      this.Xdr = ((ImageView)localView1);
      localView2 = paramView.findViewById(R.h.chatting_click_area);
      localView1 = localView2;
      if (!(localView2 instanceof FrameLayout)) {
        localView1 = null;
      }
      this.clickArea = ((View)localView1);
      localView2 = paramView.findViewById(R.h.dwn);
      localView1 = localView2;
      if (!(localView2 instanceof LinearLayout)) {
        localView1 = null;
      }
      this.XdD = ((LinearLayout)localView1);
      localView2 = paramView.findViewById(R.h.dwN);
      localView1 = localView2;
      if (!(localView2 instanceof MMNeat7extView)) {
        localView1 = null;
      }
      this.Xdi = ((MMNeat7extView)localView1);
      localView2 = paramView.findViewById(R.h.dwq);
      localView1 = localView2;
      if (!(localView2 instanceof TextView)) {
        localView1 = null;
      }
      this.mrM = ((TextView)localView1);
      localView2 = paramView.findViewById(R.h.dwp);
      localView1 = localView2;
      if (!(localView2 instanceof TextView)) {
        localView1 = null;
      }
      this.XfR = ((TextView)localView1);
      localView2 = paramView.findViewById(R.h.dwK);
      localView1 = localView2;
      if (!(localView2 instanceof RelativeLayout)) {
        localView1 = null;
      }
      this.XdB = ((RelativeLayout)localView1);
      localView2 = paramView.findViewById(R.h.dxt);
      localView1 = localView2;
      if (!(localView2 instanceof RoundProgressBtn)) {
        localView1 = null;
      }
      this.XfS = ((RoundProgressBtn)localView1);
      localView2 = this.convertView.findViewById(R.h.dxs);
      localView1 = localView2;
      if (!(localView2 instanceof ImageView)) {
        localView1 = null;
      }
      this.Xdq = ((ImageView)localView1);
      localView2 = paramView.findViewById(R.h.dws);
      localView1 = localView2;
      if (!(localView2 instanceof ImageView)) {
        localView1 = null;
      }
      this.Xdt = ((ImageView)localView1);
      localView2 = paramView.findViewById(R.h.app_msg_layout);
      localView1 = localView2;
      if (!(localView2 instanceof LinearLayout)) {
        localView1 = null;
      }
      this.Xdx = ((LinearLayout)localView1);
      this.Xer = ((ImageView)paramView.findViewById(R.h.dMR));
      localView1 = paramView.findViewById(R.h.dSf);
      paramView = localView1;
      if (!(localView1 instanceof ProgressBar)) {
        paramView = null;
      }
      this.Wxe = ((ProgressBar)paramView);
      this.Xev = c.li(MMApplicationContext.getContext());
      AppMethodBeat.o(232689);
      return this;
    }
    
    public final void a(final com.tencent.mm.ui.chatting.e.a parama, final k.b paramb, final ca paramca, boolean paramBoolean, final String paramString1, final String paramString2)
    {
      AppMethodBeat.i(232700);
      p.k(parama, "ui");
      p.k(paramb, "content");
      p.k(paramca, "msg");
      Object localObject1 = this.XfS;
      if (localObject1 != null) {
        ((RoundProgressBtn)localObject1).setVisibility(8);
      }
      localObject1 = this.Xdt;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      localObject1 = this.XfR;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.Wxe;
      if (localObject1 != null) {
        ((ProgressBar)localObject1).setVisibility(8);
      }
      localObject1 = new aa.a();
      ((aa.a)localObject1).aaBx = false;
      final aa.a locala = new aa.a();
      locala.aaBx = true;
      if (paramb.type == 74)
      {
        if ((paramca.getFileStatus() != 2) && (cm.bfC() - paramca.getCreateTime() > 432000000L))
        {
          paramca.setFileStatus(2);
          com.tencent.e.h.ZvG.be((Runnable)new c(paramca));
        }
        switch (paramca.getFileStatus())
        {
        case 0: 
        default: 
          Log.d("MicroMsg.ChattingItemAppMsgFile", "showIconArea(UPLOADING) msgId:" + paramca.apG() + " fileStatus:" + paramca.getFileStatus());
          label255:
          Log.d("MicroMsg.ChattingItemAppMsgFile", "showIconArea msgId:" + paramca.apG() + " hasMask:" + ((aa.a)localObject1).aaBx + " hasIcon:" + locala.aaBx + " isBitmapNull:" + paramBoolean);
          parama = this.Xdq;
          if (parama != null)
          {
            if (((aa.a)localObject1).aaBx)
            {
              i = 0;
              label340:
              parama.setVisibility(i);
            }
          }
          else
          {
            if (!paramBoolean) {
              break label1657;
            }
            if (!locala.aaBx) {
              break label1572;
            }
            if (!e.b.bzG(paramb.llY)) {
              break label1498;
            }
            parama = this.Xdh;
            if (parama == null) {
              break label1491;
            }
            if (!ar.isDarkMode()) {
              break label1483;
            }
          }
          break;
        }
      }
      label1483:
      for (int i = R.k.app_attach_file_icon_photo_dark;; i = R.k.app_attach_file_icon_photo)
      {
        parama.setImageResource(i);
        AppMethodBeat.o(232700);
        return;
        parama = this.Wxe;
        if (parama != null) {
          parama.setVisibility(0);
        }
        ((aa.a)localObject1).aaBx = true;
        locala.aaBx = false;
        break;
        ((aa.a)localObject1).aaBx = true;
        break;
        if (paramb.type != 6) {
          break label255;
        }
        com.tencent.mm.pluginsdk.model.app.c localc = ao.ctZ().TR(paramca.apG());
        if (localc == null) {
          break label255;
        }
        long l;
        Object localObject2;
        if (paramca.apS() == 1)
        {
          switch (paramca.getFileStatus())
          {
          default: 
            l = localc.field_status;
            if (l == 101L)
            {
              ((aa.a)localObject1).aaBx = true;
              locala.aaBx = false;
              localObject2 = this.Xdt;
              if (localObject2 != null) {
                ((ImageView)localObject2).setVisibility(8);
              }
              localObject2 = this.XfS;
              if (localObject2 != null) {
                ((RoundProgressBtn)localObject2).setHasPause(true);
              }
              localObject2 = this.XfS;
              if (localObject2 != null) {
                ((RoundProgressBtn)localObject2).setVisibility(0);
              }
            }
            break;
          }
          for (;;)
          {
            localObject2 = this.XdB;
            if (localObject2 != null) {
              ((RelativeLayout)localObject2).setOnClickListener((View.OnClickListener)new a(localc, this, paramca, (aa.a)localObject1, locala, parama, paramString1, paramString2, paramb));
            }
            Log.d("MicroMsg.ChattingItemAppMsgFile", "showIconArea msgId:" + paramca.apG() + " isFileSender:" + paramca.apS() + " fileStatus:" + localc.field_status + ", hasMask:" + ((aa.a)localObject1).aaBx + " fileStatus:" + paramca.getFileStatus());
            break;
            ((aa.a)localObject1).aaBx = true;
            locala.aaBx = false;
            localObject2 = this.XfS;
            if (localObject2 != null) {
              ((RoundProgressBtn)localObject2).setHasPause(false);
            }
            localObject2 = this.XfS;
            if (localObject2 != null) {
              ((RoundProgressBtn)localObject2).setVisibility(0);
            }
            localObject2 = this.Xdt;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(0);
            }
            localObject2 = this.Xdt;
            if (localObject2 != null) {
              ((ImageView)localObject2).setImageResource(R.k.app_attach_file_arrow_down);
            }
            localObject2 = this.XfR;
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(0);
            }
            localObject2 = this.XfR;
            if (localObject2 != null)
            {
              ((TextView)localObject2).setText((CharSequence)parama.getContext().getString(R.l.eoG));
              continue;
              ((aa.a)localObject1).aaBx = true;
              continue;
              if (l == 102L)
              {
                ((aa.a)localObject1).aaBx = true;
                locala.aaBx = false;
                localObject2 = this.XfS;
                if (localObject2 != null) {
                  ((RoundProgressBtn)localObject2).setHasPause(false);
                }
                localObject2 = this.XfS;
                if (localObject2 != null) {
                  ((RoundProgressBtn)localObject2).setVisibility(0);
                }
                localObject2 = this.Xdt;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(0);
                }
                localObject2 = this.Xdt;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setImageResource(R.k.app_attach_file_arrow_down);
                }
              }
              else if (l == 198L)
              {
                ((aa.a)localObject1).aaBx = true;
                localObject2 = this.XfS;
                if (localObject2 != null) {
                  ((RoundProgressBtn)localObject2).setVisibility(8);
                }
                localObject2 = this.Xdt;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(8);
                }
              }
              else
              {
                localObject2 = this.XfS;
                if (localObject2 != null) {
                  ((RoundProgressBtn)localObject2).setVisibility(8);
                }
                localObject2 = this.Xdt;
                if (localObject2 != null) {
                  ((ImageView)localObject2).setVisibility(8);
                }
              }
            }
          }
        }
        if ((paramca.getStatus() < 2) || (paramca.getStatus() == 5)) {
          ((aa.a)localObject1).aaBx = true;
        }
        for (;;)
        {
          localObject2 = this.XdB;
          if (localObject2 == null) {
            break;
          }
          ((RelativeLayout)localObject2).setOnClickListener((View.OnClickListener)new b(localc, this, paramca, (aa.a)localObject1, locala, parama, paramString1, paramString2, paramb));
          break;
          switch (paramca.getFileStatus())
          {
          default: 
            l = localc.field_status;
            if (l == 101L)
            {
              ((aa.a)localObject1).aaBx = true;
              locala.aaBx = false;
              localObject2 = this.Xdt;
              if (localObject2 != null) {
                ((ImageView)localObject2).setVisibility(8);
              }
              localObject2 = this.XfS;
              if (localObject2 != null) {
                ((RoundProgressBtn)localObject2).setHasPause(true);
              }
              localObject2 = this.XfS;
              if (localObject2 == null) {
                continue;
              }
              ((RoundProgressBtn)localObject2).setVisibility(0);
            }
            break;
          case 100: 
            ((aa.a)localObject1).aaBx = true;
            locala.aaBx = false;
            localObject2 = this.XfS;
            if (localObject2 != null) {
              ((RoundProgressBtn)localObject2).setHasPause(false);
            }
            localObject2 = this.XfS;
            if (localObject2 != null) {
              ((RoundProgressBtn)localObject2).setVisibility(0);
            }
            localObject2 = this.Xdt;
            if (localObject2 != null) {
              ((ImageView)localObject2).setVisibility(0);
            }
            localObject2 = this.Xdt;
            if (localObject2 != null) {
              ((ImageView)localObject2).setImageResource(R.k.app_attach_file_arrow_up);
            }
            localObject2 = this.XfR;
            if (localObject2 != null) {
              ((TextView)localObject2).setVisibility(0);
            }
            localObject2 = this.XfR;
            if (localObject2 != null) {
              ((TextView)localObject2).setText((CharSequence)parama.getContext().getString(R.l.eoI));
            }
            break;
          case 101: 
            ((aa.a)localObject1).aaBx = true;
            continue;
            if (l == 105L)
            {
              ((aa.a)localObject1).aaBx = true;
              locala.aaBx = false;
              localObject2 = this.XfS;
              if (localObject2 != null) {
                ((RoundProgressBtn)localObject2).setHasPause(false);
              }
              localObject2 = this.XfS;
              if (localObject2 != null) {
                ((RoundProgressBtn)localObject2).setVisibility(0);
              }
              localObject2 = this.Xdt;
              if (localObject2 != null) {
                ((ImageView)localObject2).setVisibility(0);
              }
              localObject2 = this.Xdt;
              if (localObject2 != null) {
                ((ImageView)localObject2).setImageResource(R.k.app_attach_file_arrow_up);
              }
            }
            else
            {
              localObject2 = this.XfS;
              if (localObject2 != null) {
                ((RoundProgressBtn)localObject2).setVisibility(8);
              }
              localObject2 = this.Xdt;
              if (localObject2 != null) {
                ((ImageView)localObject2).setVisibility(8);
              }
            }
            break;
          }
        }
        i = 8;
        break label340;
      }
      label1491:
      AppMethodBeat.o(232700);
      return;
      label1498:
      if (e.b.bzH(paramb.llY))
      {
        parama = this.Xdh;
        if (parama != null)
        {
          parama.setImageResource(R.k.app_attach_file_icon_video);
          AppMethodBeat.o(232700);
          return;
        }
        AppMethodBeat.o(232700);
        return;
      }
      parama = this.Xdh;
      if (parama != null)
      {
        parama.setImageResource(v.bpK(paramb.llY));
        AppMethodBeat.o(232700);
        return;
      }
      AppMethodBeat.o(232700);
      return;
      label1572:
      if (e.b.bzG(paramb.llY))
      {
        parama = this.Xdh;
        if (parama != null)
        {
          if (ar.isDarkMode()) {}
          for (i = R.k.app_attach_file_icon_simple_dark;; i = R.k.app_attach_file_icon_simple)
          {
            parama.setImageResource(i);
            AppMethodBeat.o(232700);
            return;
          }
        }
        AppMethodBeat.o(232700);
        return;
      }
      parama = this.Xdh;
      if (parama != null)
      {
        parama.setImageResource(v.bpM(paramb.llY));
        AppMethodBeat.o(232700);
        return;
      }
      label1657:
      AppMethodBeat.o(232700);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder$showIconArea$2$1"})
    static final class a
      implements View.OnClickListener
    {
      a(com.tencent.mm.pluginsdk.model.app.c paramc, o.a parama, ca paramca, aa.a parama1, aa.a parama2, com.tencent.mm.ui.chatting.e.a parama3, String paramString1, String paramString2, k.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(281176);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder$showIconArea$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        localObject1 = new StringBuilder("progressPB(msgId:").append(paramca.apG()).append(") click, status:").append(this.XfT.field_status).append(", progressPB:");
        paramView = jdField_this.XfS;
        if (paramView != null) {}
        for (paramView = Integer.valueOf(paramView.getVisibility());; paramView = null)
        {
          Log.i("MicroMsg.ChattingItemAppMsgFile", paramView);
          paramView = jdField_this.XfS;
          if ((paramView != null) && (paramView.getVisibility() == 0)) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder$showIconArea$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(281176);
          return;
        }
        switch (paramca.getFileStatus())
        {
        default: 
          if (this.XfT.field_status == 102L) {
            o.a.m(paramca, paramString1);
          }
          break;
        }
        do
        {
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder$showIconArea$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(281176);
            return;
            p.j(bh.beI(), "MMCore.getAccStg()");
            paramView = com.tencent.mm.model.c.bbO().Oq(paramca.apG());
            p.j(paramView, "msgInfo");
            paramView.setFileStatus(0);
            p.j(bh.beI(), "MMCore.getAccStg()");
            com.tencent.mm.model.c.bbO().a(paramca.apG(), paramView);
            o.a.m(paramca, paramString1);
          }
          com.tencent.mm.pluginsdk.model.app.m.aa(paramca.apG(), paramString2);
          com.tencent.mm.pluginsdk.model.a.b.QXV.ba(paramca);
          paramView = paramca;
          localObject1 = paramb;
        } while ((6 != ((k.b)localObject1).type) && (74 != ((k.b)localObject1).type));
        long l1 = paramView.apH();
        Object localObject2 = (com.tencent.mm.aj.a.b)((k.b)localObject1).ar(com.tencent.mm.aj.a.b.class);
        if ((localObject2 != null) && (((com.tencent.mm.aj.a.b)localObject2).lqB != 0L)) {
          l1 = ((com.tencent.mm.aj.a.b)localObject2).lqB;
        }
        for (;;)
        {
          localObject2 = af.aaBG;
          localObject2 = ((k.b)localObject1).lml;
          if (((k.b)localObject1).lmb == 1) {}
          int j;
          long l2;
          for (int i = 7;; i = 5)
          {
            j = ((k.b)localObject1).llX;
            l2 = (cm.bfD() - paramView.getCreateTime()) / 1000L;
            localObject1 = Util.nullAsNil(((k.b)localObject1).llY);
            p.j(localObject1, "Util.nullAsNil(appmsgContent.fileext)");
            if (localObject1 != null) {
              break;
            }
            paramView = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(281176);
            throw paramView;
          }
          localObject1 = ((String)localObject1).toLowerCase();
          p.j(localObject1, "(this as java.lang.String).toLowerCase()");
          paramView = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", Arrays.copyOf(new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(15), Long.valueOf(l2), localObject1, paramView.apJ(), Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(paramView.getCreateTime()), Long.valueOf(cm.bfC()), Integer.valueOf(1) }, 13));
          p.j(paramView, "java.lang.String.format(format, *args)");
          Log.i("MicroMsg.ChattingItemAppMsgFile", "reportKVStat 14665 %s", new Object[] { paramView });
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(14665, paramView);
          break;
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder$showIconArea$2$2"})
    static final class b
      implements View.OnClickListener
    {
      b(com.tencent.mm.pluginsdk.model.app.c paramc, o.a parama, ca paramca, aa.a parama1, aa.a parama2, com.tencent.mm.ui.chatting.e.a parama3, String paramString1, String paramString2, k.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(279113);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder$showIconArea$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = new StringBuilder("progressPB(msgId:").append(paramca.apG()).append(") click, status:").append(this.XfT.field_status).append(", progressPB:");
        paramView = jdField_this.XfS;
        if (paramView != null) {}
        for (paramView = Integer.valueOf(paramView.getVisibility());; paramView = null)
        {
          Log.i("MicroMsg.ChattingItemAppMsgFile", paramView);
          paramView = jdField_this.XfS;
          if ((paramView != null) && (paramView.getVisibility() == 0)) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder$showIconArea$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279113);
          return;
        }
        switch (paramca.getFileStatus())
        {
        default: 
          if (this.XfT.field_status == 105L) {
            if (cm.bfC() - this.XfT.field_createTime < 432000000L)
            {
              com.tencent.mm.pluginsdk.model.app.m.Y(paramca.apG(), paramString2);
              paramView = com.tencent.mm.pluginsdk.model.a.c.QXY;
              paramView = o.XfQ;
              o.d.a(4, paramb, paramca);
            }
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder$showIconArea$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(279113);
          return;
          if (cm.bfC() - this.XfT.field_createTime < 432000000L)
          {
            p.j(bh.beI(), "MMCore.getAccStg()");
            paramView = com.tencent.mm.model.c.bbO().Oq(paramca.apG());
            p.j(paramView, "msgInfo");
            paramView.setFileStatus(0);
            p.j(bh.beI(), "MMCore.getAccStg()");
            com.tencent.mm.model.c.bbO().a(paramca.apG(), paramView);
            com.tencent.mm.pluginsdk.model.app.m.Z(paramca.apG(), paramString2);
            paramView = com.tencent.mm.pluginsdk.model.a.c.QXY;
            paramView = o.XfQ;
            o.d.a(4, paramb, paramca);
          }
          else
          {
            com.tencent.mm.pluginsdk.model.app.m.a(parama, paramca, R.l.eoJ, paramb);
            continue;
            com.tencent.mm.pluginsdk.model.app.m.a(parama, paramca, R.l.eoK, paramb);
            continue;
            com.tencent.mm.pluginsdk.model.app.m.X(paramca.apG(), paramString2);
            paramView = com.tencent.mm.pluginsdk.model.a.c.QXY;
            com.tencent.mm.pluginsdk.model.a.c.bk(paramca);
            paramView = o.XfQ;
            o.d.a(2, paramb, paramca);
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class c
      implements Runnable
    {
      c(ca paramca) {}
      
      public final void run()
      {
        AppMethodBeat.i(290514);
        Object localObject = com.tencent.mm.kernel.h.ae(n.class);
        p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
        localObject = ((n)localObject).eSe().Oq(this.lEd.apG());
        p.j(localObject, "msgInfo");
        ((ca)localObject).setFileStatus(2);
        com.tencent.mm.kernel.c.a locala = com.tencent.mm.kernel.h.ae(n.class);
        p.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
        ((n)locala).eSe().a(this.lEd.apG(), (ca)localObject);
        AppMethodBeat.o(290514);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileFrom;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "support", "msgType", "Companion", "app_release"})
  public static final class b
    extends c
  {
    private static final String TAG = "MicroMsg.ChattingItemAppMsgFileFrom";
    public static final o.b.a Xga;
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    static
    {
      AppMethodBeat.i(291810);
      Xga = new o.b.a((byte)0);
      TAG = "MicroMsg.ChattingItemAppMsgFileFrom";
      AppMethodBeat.o(291810);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(291804);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramLayoutInflater = new aq(paramLayoutInflater, R.i.ecM);
        paramLayoutInflater.setTag(new o.a().L((View)paramLayoutInflater, false));
        paramLayoutInflater = (View)paramLayoutInflater;
        AppMethodBeat.o(291804);
        return paramLayoutInflater;
      }
      AppMethodBeat.o(291804);
      return paramView;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(291806);
      p.k(parama1, "ui");
      p.k(paramca, "msg");
      if (parama == null)
      {
        parama = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChattingItemAppMsgFile.AppMsgFileViewHolder");
        AppMethodBeat.o(291806);
        throw parama;
      }
      o.a locala = (o.a)parama;
      this.WBq = parama1;
      String str = paramca.getContent();
      parama = (com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class);
      parama.cr(paramca);
      parama.cs(paramca);
      parama.ct(paramca);
      if (str != null) {}
      label670:
      label1572:
      label1597:
      label1616:
      for (parama = k.b.aG(str, paramca.apL());; parama = null)
      {
        by localby = new by(paramca, parama1.hRi(), paramInt, null, '\000');
        Object localObject1;
        label631:
        boolean bool1;
        Object localObject2;
        label879:
        boolean bool2;
        if (parama != null)
        {
          paramString = locala.Xdi;
          if (paramString != null) {
            paramString.aL((CharSequence)parama.getTitle());
          }
          paramString = locala.Xdi;
          if (paramString != null) {
            paramString.setContentDescription((CharSequence)parama.getTitle());
          }
          paramString = locala.mrM;
          if (paramString != null) {
            paramString.setText((CharSequence)parama.getDescription());
          }
          paramString = locala.Xdi;
          if (paramString != null)
          {
            localObject1 = parama1.getContext();
            p.j(localObject1, "ui.context");
            paramString.setTextColor(((Activity)localObject1).getResources().getColor(R.e.FG_0));
          }
          paramString = locala.mrM;
          if (paramString != null)
          {
            localObject1 = parama1.getContext();
            p.j(localObject1, "ui.context");
            paramString.setTextColor(((Activity)localObject1).getResources().getColor(R.e.half_alpha_black));
          }
          paramString = locala.XdD;
          if (paramString != null) {
            paramString.setBackgroundResource(R.g.chatfrom_bg_app);
          }
          paramString = locala.XdD;
          if (paramString != null)
          {
            localObject1 = parama1.getContext();
            p.j(localObject1, "ui.context");
            paramString.setPadding(0, ((Activity)localObject1).getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
          }
          paramString = locala.Xdh;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.XdB;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.mrM;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.XfS;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.Xds;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.Xdr;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.XdD;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.Xdk;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.Xdl;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
          locala.clickArea.setBackgroundResource(R.g.chatfrom_bg_app);
          localObject1 = com.tencent.mm.pluginsdk.model.app.h.hn(parama.appId, parama.appVersion);
          if (localObject1 != null) {
            b(parama1, parama, paramca);
          }
          if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName != null))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName;
            p.j(paramString, "appInfo.field_appName");
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
                if (paramString.charAt(k) > ' ') {
                  break label670;
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
                    break label631;
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
              break label1562;
            }
          }
          paramString = parama.appName;
          bool1 = true;
          if ((parama.type == 20) || (p.h("wxaf060266bfa9a35c", parama.appId)))
          {
            localObject2 = com.tencent.mm.pluginsdk.o.a.hfN();
            p.j(localObject2, "IPluginEvent.Factory.getShakeMgr()");
            bool1 = ((com.tencent.mm.pluginsdk.o.b)localObject2).fHm();
          }
          if ((!bool1) || (parama.appId == null) || (parama.appId.length() <= 0) || (!gZ(paramString))) {
            break label1616;
          }
          paramString = com.tencent.mm.pluginsdk.model.app.h.a((Context)parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramString);
          if (parama.type != 19) {
            break label1572;
          }
          localObject2 = locala.wRL;
          if (localObject2 != null)
          {
            Activity localActivity = parama1.getContext();
            p.j(localActivity, "ui.context");
            ((TextView)localObject2).setText((CharSequence)localActivity.getResources().getString(R.l.opensdk_source_tv_record, new Object[] { paramString }));
          }
          paramString = locala.wRL;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.wRL;
          if (paramString != null) {
            paramString.setCompoundDrawables(null, null, null, null);
          }
          paramString = locala.Xdm;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.Xdj;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject1).Qv())) {
            break label1597;
          }
          a(parama1, (View)locala.wRL, paramca, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName, paramca.apH());
          label992:
          paramString = locala.Xdj;
          if (paramString != null) {
            paramString.setImageResource(R.g.dnd);
          }
          a(parama1, locala.Xdj, parama.appId);
          if (parama.bbu())
          {
            paramString = locala.Xdm;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
          }
          paramString = locala.Xdm;
          if (paramString != null) {
            paramString.setBackgroundResource(R.g.mm_trans);
          }
          bool2 = false;
          paramString = locala.Xdh;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if ((parama.bbv()) || (!this.tMW)) {
            break label1696;
          }
          if ((parama.type == 33) || (parama.type == 36) || (parama.type == 44) || (parama.type == 48) || (e.b.bzI(paramca.apK()))) {
            break label1761;
          }
        }
        label1236:
        label1761:
        for (paramString = q.bmh().d(paramca.apK(), com.tencent.mm.ci.a.getDensity((Context)parama1.getContext()));; paramString = null)
        {
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramString = BitmapUtil.getRoundedCornerBitmap(paramString, false, com.tencent.mm.ci.a.fromDPToPix((Context)parama1.getContext(), 1));
            localObject1 = locala.Xdh;
            bool1 = bool2;
            if (localObject1 != null)
            {
              ((MMImageView)localObject1).setImageBitmap(paramString);
              bool1 = bool2;
            }
            paramString = locala.Xdx;
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = locala.Xdo;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            if (parama.title == null) {
              break label1739;
            }
            paramString = parama.title;
            p.j(paramString, "content.title");
            if (((CharSequence)paramString).length() <= 0) {
              break label1734;
            }
            paramInt = 1;
            if (paramInt == 0) {
              break label1739;
            }
            paramString = locala.Xdi;
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = locala.Xdi;
            if (paramString != null) {
              paramString.setMaxLines(2);
            }
          }
          for (;;)
          {
            paramString = locala.mrM;
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = locala.Xdo;
            if (paramString != null) {
              paramString.setVisibility(4);
            }
            paramString = locala.mrM;
            if (paramString != null) {
              paramString.setMaxLines(2);
            }
            paramString = locala.mrM;
            if (paramString != null) {
              paramString.setText((CharSequence)Util.getSizeKB(parama.llX));
            }
            o.a.a(locala, str, parama.llX);
            locala.a(parama1, parama, paramca, bool1, parama.fvr, parama.title);
            parama = locala.clickArea;
            p.j(parama, "holder.clickArea");
            parama.setTag(localby);
            locala.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
            if (this.tMW)
            {
              locala.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
              parama = locala.clickArea;
              parama1 = parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class);
              p.j(parama1, "ui.component(IChattingLi…terComponent::class.java)");
              parama.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.d.b.k)parama1).hNO());
            }
            AppMethodBeat.o(291806);
            return;
            paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName;
            break;
            localObject2 = locala.wRL;
            if (localObject2 == null) {
              break label879;
            }
            ((TextView)localObject2).setText((CharSequence)paramString);
            break label879;
            a(parama1, (View)locala.wRL, parama.appId);
            break label992;
            paramString = o.XfQ;
            if (o.d.a(parama, locala)) {
              break label1025;
            }
            paramString = locala.Xdm;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            paramString = locala.wRL;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            paramString = locala.Xdj;
            if (paramString == null) {
              break label1025;
            }
            paramString.setVisibility(8);
            break label1025;
            bool1 = true;
            break label1236;
            paramString = locala.Xdh;
            bool1 = bool2;
            if (paramString == null) {
              break label1236;
            }
            paramString.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.dok));
            bool1 = bool2;
            break label1236;
            paramInt = 0;
            break label1309;
            paramString = locala.Xdi;
            if (paramString != null) {
              paramString.setVisibility(8);
            }
          }
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
    {
      AppMethodBeat.i(291808);
      if (paramca == null)
      {
        AppMethodBeat.o(291808);
        return false;
      }
      if (paramMenuItem == null) {
        p.iCn();
      }
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(291808);
        return false;
        AppMethodBeat.o(291808);
        return false;
        if (!ac.bV(paramca))
        {
          if (parama == null) {
            p.iCn();
          }
          com.tencent.mm.ui.base.h.a((Context)parama.getContext(), parama.getContext().getString(R.l.eEx), "", parama.getContext().getString(R.l.welcome_i_know), null);
          AppMethodBeat.o(291808);
          return false;
        }
        paramMenuItem = bs.T(paramca);
        if (Util.isNullOrNil(paramMenuItem)) {
          e.b.a(parama, paramca, a(parama, paramca));
        }
        for (;;)
        {
          AppMethodBeat.o(291808);
          return false;
          com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
          if (parama == null) {
            p.iCn();
          }
          com.tencent.mm.ui.base.h.a((Context)parama.getContext(), R.l.eRO, R.l.eRP, R.l.app_view_detail, R.l.ewL, true, (DialogInterface.OnClickListener)new b(paramMenuItem, parama), (DialogInterface.OnClickListener)new c(this, parama, paramca, paramMenuItem));
        }
        paramMenuItem = paramca.getContent();
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(291808);
          return false;
        }
        if (k.b.OQ(paramMenuItem) != null)
        {
          if (parama == null) {
            p.iCn();
          }
          an.b(paramca, bq.b(parama.hRi(), paramca.getContent(), paramca.apA()), (Context)parama.getContext());
        }
        AppMethodBeat.o(291808);
        return false;
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Chat_Msg_Id", paramca.apG());
        if (parama == null) {
          p.iCn();
        }
        com.tencent.mm.by.c.b((Context)parama.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(291807);
      p.k(paramo, "menu");
      p.k(paramView, "v");
      p.k(paramca, "msg");
      Object localObject1 = paramView.getTag();
      if (localObject1 == null)
      {
        paramo = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(291807);
        throw paramo;
      }
      int i = ((by)localObject1).position;
      localObject1 = this.WBq;
      if (localObject1 == null) {
        p.iCn();
      }
      int j = com.tencent.mm.pluginsdk.model.app.m.bqe(bq.b(((com.tencent.mm.ui.chatting.e.a)localObject1).hRi(), paramca.getContent(), paramca.apA()));
      localObject1 = this.WBq;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = k.b.OQ(bq.b(((com.tencent.mm.ui.chatting.e.a)localObject1).hRi(), paramca.getContent(), paramca.apA()));
      Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.bpS(((k.b)localObject1).appId);
      Object localObject3;
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject2)) && (!com.tencent.mm.ui.chatting.k.bF(paramca)) && (((k.b)localObject1).type == 6))
      {
        localObject3 = com.tencent.mm.pluginsdk.model.app.m.bqf(((k.b)localObject1).fvr);
        if (((localObject3 == null) || (!e.b.j(paramca, ((com.tencent.mm.pluginsdk.model.app.c)localObject3).field_fileFullPath))) && (!paramca.Ic()))
        {
          localObject3 = this.WBq;
          if (localObject3 == null) {
            p.iCn();
          }
          paramo.a(i, 111, (CharSequence)((com.tencent.mm.ui.chatting.e.a)localObject3).getResources().getString(R.l.retransmit), R.k.icons_filled_share);
        }
      }
      if ((((k.b)localObject1).llX <= 0) || ((((k.b)localObject1).llX > 0) && (j >= 100)))
      {
        boolean bool = com.tencent.mm.ao.g.bjf();
        if (!Util.isImageExt(((k.b)localObject1).llY))
        {
          localObject3 = this.WBq;
          if (localObject3 == null) {
            p.iCn();
          }
          paramo.a(i, 150, (CharSequence)((com.tencent.mm.ui.chatting.e.a)localObject3).getResources().getString(R.l.evV), R.k.icons_filled_otherapp);
        }
        if (bool)
        {
          localObject3 = this.WBq;
          if (localObject3 == null) {
            p.iCn();
          }
          if (!((com.tencent.mm.ui.chatting.e.a)localObject3).hRj()) {
            paramo.add(i, 114, 0, (CharSequence)paramView.getContext().getString(R.l.evJ));
          }
        }
      }
      if ((com.tencent.mm.by.c.blP("favorite")) && ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject2).Qv())) && (localObject1 != null) && (((k.b)localObject1).type != 74)) {
        paramo.a(i, 116, (CharSequence)paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      localObject2 = new em();
      ((em)localObject2).fAp.msgId = paramca.apG();
      EventCenter.instance.publish((IEvent)localObject2);
      if (!((em)localObject2).fAq.fzO)
      {
        localObject2 = this.WBq;
        if (localObject2 == null) {
          p.iCn();
        }
        if (!e.b.a((Context)((com.tencent.mm.ui.chatting.e.a)localObject2).getContext(), (k.b)localObject1)) {}
      }
      else
      {
        paramo.a(i, 129, (CharSequence)paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      if (bs.D(paramca)) {
        paramo.clear();
      }
      paramca = this.WBq;
      if (paramca == null) {
        p.iCn();
      }
      if (!paramca.hRj())
      {
        paramca = this.WBq;
        if (paramca == null) {
          p.iCn();
        }
        paramo.a(i, 100, (CharSequence)paramca.getResources().getString(R.l.evO), R.k.icons_filled_delete);
      }
      if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
        paramo.a(i, 144, (CharSequence)paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
      }
      AppMethodBeat.o(291807);
      return true;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 1090519089);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(291809);
      p.k(paramca, "msg");
      com.tencent.mm.modelstat.a.a(paramca, a.a.mcb);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.apJ());
      Object localObject = paramca.getContent();
      if (localObject == null)
      {
        AppMethodBeat.o(291809);
        return false;
      }
      if (parama == null) {
        p.iCn();
      }
      paramView = k.b.OQ(bq.b(parama.hRi(), paramca.getContent(), paramca.apA()));
      localObject = com.tencent.mm.aj.t.OV((String)localObject);
      if (paramView == null)
      {
        AppMethodBeat.o(291809);
        return false;
      }
      if (((com.tencent.mm.aj.t)localObject).lpH != 0) {
        paramView.type = ((com.tencent.mm.aj.t)localObject).lpH;
      }
      localObject = com.tencent.mm.pluginsdk.model.app.h.bpS(paramView.appId);
      String str = d(parama, paramca);
      if (localObject != null) {
        a(parama, paramView, str, (com.tencent.mm.pluginsdk.model.app.g)localObject, paramca.apH(), parama.getTalkerUserName());
      }
      if (!this.tMW)
      {
        paramView = (Context)parama.getContext();
        parama = parama.hRf();
        p.j(parama, "ui!!.fragment");
        w.g(paramView, parama.getContentView());
        AppMethodBeat.o(291809);
        return true;
      }
      paramView = new Intent();
      paramView.setClassName((Context)parama.getContext(), "com.tencent.mm.ui.chatting.AppAttachNewDownloadUI");
      paramView.putExtra("scene", 2);
      paramView.putExtra("app_msg_id", paramca.apG());
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileFrom", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(291809);
      return true;
    }
    
    public final boolean hTD()
    {
      return false;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    static final class b
      implements DialogInterface.OnClickListener
    {
      b(String paramString, com.tencent.mm.ui.chatting.e.a parama) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(264960);
        paramDialogInterface = new Intent();
        paramDialogInterface.putExtra("rawUrl", this.Xgb);
        paramDialogInterface.putExtra("hardcode_jspermission", (Parcelable)JsapiPermissionWrapper.RBc);
        paramDialogInterface.putExtra("hardcode_general_ctrl", (Parcelable)GeneralControlWrapper.RAX);
        com.tencent.mm.ui.chatting.e.a locala = parama;
        if (locala == null) {
          p.iCn();
        }
        com.tencent.mm.by.c.b((Context)locala.getContext(), "webview", ".ui.tools.WebViewUI", paramDialogInterface);
        com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(1), this.Xgb });
        AppMethodBeat.o(264960);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialogInterface", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
    static final class c
      implements DialogInterface.OnClickListener
    {
      c(o.b paramb, com.tencent.mm.ui.chatting.e.a parama, ca paramca, String paramString) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(271195);
        e.b.a(parama, paramca, this.Xgc.a(parama, paramca));
        com.tencent.mm.plugin.report.service.h.IzE.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
        AppMethodBeat.o(271195);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileTo;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "support", "msgType", "Companion", "app_release"})
  public static final class c
    extends c
    implements t.n
  {
    public static final o.c.a Xgd;
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    static
    {
      AppMethodBeat.i(217054);
      Xgd = new o.c.a((byte)0);
      AppMethodBeat.o(217054);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(217032);
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramLayoutInflater = new aq(paramLayoutInflater, R.i.edM);
        paramLayoutInflater.setTag(new o.a().L((View)paramLayoutInflater, true));
        paramLayoutInflater = (View)paramLayoutInflater;
        AppMethodBeat.o(217032);
        return paramLayoutInflater;
      }
      AppMethodBeat.o(217032);
      return paramView;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(217036);
      p.k(parama1, "ui");
      p.k(paramca, "msg");
      if (parama == null)
      {
        parama = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ChattingItemAppMsgFile.AppMsgFileViewHolder");
        AppMethodBeat.o(217036);
        throw parama;
      }
      o.a locala = (o.a)parama;
      this.WBq = parama1;
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).ct(paramca);
      String str = paramca.getContent();
      ((com.tencent.mm.ui.chatting.d.b.m)parama1.bC(com.tencent.mm.ui.chatting.d.b.m.class)).cr(paramca);
      if (str != null) {}
      label648:
      label1547:
      label1681:
      for (parama = k.b.aG(str, paramca.apL());; parama = null)
      {
        by localby = new by(paramca, parama1.hRi(), paramInt, null, '\000');
        Object localObject1;
        Object localObject2;
        int i;
        label608:
        boolean bool1;
        label860:
        label1006:
        boolean bool2;
        if (parama != null)
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.h.hn(parama.appId, parama.appVersion);
          paramString = locala.Xdi;
          if (paramString != null) {
            paramString.aL((CharSequence)parama.getTitle());
          }
          paramString = locala.Xdi;
          if (paramString != null) {
            paramString.setContentDescription((CharSequence)parama.getTitle());
          }
          paramString = locala.mrM;
          if (paramString != null) {
            paramString.setText((CharSequence)parama.description);
          }
          paramString = locala.Xdi;
          if (paramString != null)
          {
            localObject2 = parama1.getContext();
            p.j(localObject2, "ui.context");
            paramString.setTextColor(((Activity)localObject2).getResources().getColor(R.e.FG_0));
          }
          paramString = locala.mrM;
          if (paramString != null)
          {
            localObject2 = parama1.getContext();
            p.j(localObject2, "ui.context");
            paramString.setTextColor(((Activity)localObject2).getResources().getColor(R.e.half_alpha_black));
          }
          paramString = locala.XdD;
          if (paramString != null) {
            paramString.setBackgroundResource(R.g.chatto_bg_app);
          }
          paramString = locala.XdD;
          if (paramString != null)
          {
            localObject2 = parama1.getContext();
            p.j(localObject2, "ui.context");
            paramString.setPadding(0, ((Activity)localObject2).getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, 0);
          }
          paramString = locala.Xdh;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.XdB;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.mrM;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.Xds;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.Xdr;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.Xdo;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.Xdk;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.Xdl;
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = locala.XdD;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
          if ((localObject1 != null) && (((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName != null))
          {
            paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName;
            p.j(paramString, "appInfo.field_appName");
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
                if (paramString.charAt(m) > ' ') {
                  break label648;
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
                    break label608;
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
              break label1493;
            }
          }
          paramString = parama.appName;
          bool1 = true;
          if ((parama.type == 20) || (p.h("wxaf060266bfa9a35c", parama.appId)))
          {
            localObject2 = com.tencent.mm.pluginsdk.o.a.hfN();
            p.j(localObject2, "IPluginEvent.Factory.getShakeMgr()");
            bool1 = ((com.tencent.mm.pluginsdk.o.b)localObject2).fHm();
          }
          if ((!bool1) || (parama.appId == null) || (parama.appId.length() <= 0) || (!gZ(paramString))) {
            break label1547;
          }
          paramString = com.tencent.mm.pluginsdk.model.app.h.a((Context)parama1.getContext(), (com.tencent.mm.pluginsdk.model.app.g)localObject1, paramString);
          if (parama.type != 19) {
            break label1503;
          }
          localObject2 = locala.wRL;
          if (localObject2 != null)
          {
            Activity localActivity = parama1.getContext();
            p.j(localActivity, "ui.context");
            ((TextView)localObject2).setText((CharSequence)localActivity.getResources().getString(R.l.opensdk_source_tv_record, new Object[] { paramString }));
          }
          paramString = locala.Xdm;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.wRL;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = locala.wRL;
          if (paramString != null) {
            paramString.setCompoundDrawables(null, null, null, null);
          }
          paramString = locala.Xdj;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject1).Qv())) {
            break label1528;
          }
          a(parama1, (View)locala.wRL, paramca, parama, ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_packageName, paramca.apH());
          label973:
          paramString = locala.Xdj;
          if (paramString != null) {
            paramString.setImageResource(R.g.dnd);
          }
          a(parama1, locala.Xdj, parama.appId);
          paramString = locala.Xdm;
          if (paramString != null) {
            paramString.setBackgroundResource(R.g.mm_trans);
          }
          bool2 = false;
          paramString = locala.Xdh;
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          if (!this.tMW) {
            break label1627;
          }
          if ((parama.type == 33) || (parama.type == 36) || (parama.type == 44) || (parama.type == 48) || (e.b.bzI(paramca.apK()))) {
            break label1708;
          }
        }
        label1184:
        label1705:
        label1708:
        for (paramString = q.bmh().d(paramca.apK(), com.tencent.mm.ci.a.getDensity((Context)parama1.getContext()));; paramString = null)
        {
          if ((paramString != null) && (!paramString.isRecycled()))
          {
            paramString = BitmapUtil.getRoundedCornerBitmap(paramString, false, com.tencent.mm.ci.a.fromDPToPix((Context)parama1.getContext(), 1));
            localObject1 = locala.Xdh;
            bool1 = bool2;
            if (localObject1 != null)
            {
              ((MMImageView)localObject1).setImageBitmap(paramString);
              bool1 = bool2;
            }
            paramString = locala.Xdi;
            if (paramString != null)
            {
              if (parama.title == null) {
                break label1671;
              }
              localObject1 = parama.title;
              p.j(localObject1, "content.title");
              if (((CharSequence)localObject1).length() <= 0) {
                break label1665;
              }
              i = 1;
              label1233:
              if (i == 0) {
                break label1671;
              }
              paramString.setVisibility(0);
              paramString.setMaxLines(2);
            }
            label1250:
            paramString = locala.mrM;
            if (paramString != null)
            {
              paramString.setVisibility(0);
              paramString.setMaxLines(2);
              paramString.setText((CharSequence)Util.getSizeKB(parama.llX));
            }
            paramString = locala.Xdo;
            if (paramString != null) {
              paramString.setVisibility(4);
            }
            o.a.a(locala, str, parama.llX);
            locala.a(parama1, parama, paramca, bool1, parama.fvr, parama.title);
            if (!c.hTG()) {
              break label1681;
            }
            parama = (c.a)locala;
          }
          for (;;)
          {
            bool1 = false;
            for (paramString = this;; paramString = this)
            {
              paramString.b(parama, bool1);
              parama = locala.clickArea;
              p.j(parama, "holder.clickArea");
              parama.setTag(localby);
              locala.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
              if (this.tMW)
              {
                locala.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
                parama = locala.clickArea;
                paramString = parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class);
                p.j(paramString, "ui.component(IChattingLi…terComponent::class.java)");
                parama.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.d.b.k)paramString).hNO());
              }
              a(paramInt, (c.a)locala, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, (t.n)this);
              AppMethodBeat.o(217036);
              return;
              label1493:
              paramString = ((com.tencent.mm.pluginsdk.model.app.g)localObject1).field_appName;
              break;
              label1503:
              localObject2 = locala.wRL;
              if (localObject2 == null) {
                break label860;
              }
              ((TextView)localObject2).setText((CharSequence)paramString);
              break label860;
              label1528:
              a(parama1, (View)locala.wRL, parama.appId);
              break label973;
              paramString = o.XfQ;
              if (o.d.a(parama, locala)) {
                break label1006;
              }
              paramString = locala.Xdm;
              if (paramString != null) {
                paramString.setVisibility(8);
              }
              paramString = locala.wRL;
              if (paramString != null) {
                paramString.setVisibility(8);
              }
              paramString = locala.Xdj;
              if (paramString == null) {
                break label1006;
              }
              paramString.setVisibility(8);
              break label1006;
              bool1 = true;
              break label1184;
              label1627:
              paramString = locala.Xdh;
              bool1 = bool2;
              if (paramString == null) {
                break label1184;
              }
              paramString.setImageBitmap(BitmapFactory.decodeResource(parama1.getResources(), R.g.dok));
              bool1 = bool2;
              break label1184;
              i = 0;
              break label1233;
              paramString.setVisibility(8);
              break label1250;
              parama = (c.a)locala;
              if (paramca.getStatus() >= 2) {
                break label1705;
              }
              bool1 = true;
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(217042);
      p.k(parama, "ui");
      p.k(paramca, "msg");
      if (paramMenuItem == null) {
        p.iCn();
      }
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(217042);
        return false;
        AppMethodBeat.o(217042);
        return false;
        if (paramca.erk())
        {
          paramMenuItem = k.b.OQ(paramca.getContent());
          if (paramMenuItem != null)
          {
            if (paramMenuItem.type == 40)
            {
              com.tencent.mm.ui.base.h.a((Context)parama.getContext(), parama.getContext().getString(R.l.eEx), "", parama.getContext().getString(R.l.welcome_i_know), null);
              AppMethodBeat.o(217042);
              return false;
            }
            if ((paramMenuItem.type == 33) && (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable((Context)parama.getContext())))
            {
              AppMethodBeat.o(217042);
              return false;
            }
          }
        }
        e.b.a(parama, paramca, a(parama, paramca));
        continue;
        paramMenuItem = paramca.getContent();
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(217042);
          return false;
        }
        if (k.b.OQ(paramMenuItem) != null) {
          an.b(paramca, bq.b(parama.hRi(), paramca.getContent(), paramca.apA()), (Context)parama.getContext());
        }
        AppMethodBeat.o(217042);
        return false;
        AppMethodBeat.o(217042);
        return false;
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Chat_Msg_Id", paramca.apG());
        com.tencent.mm.by.c.b((Context)parama.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", paramMenuItem);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(217038);
      p.k(paramo, "menu");
      p.k(paramView, "v");
      p.k(paramca, "msg");
      Object localObject1 = paramView.getTag();
      if (localObject1 == null)
      {
        paramo = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(217038);
        throw paramo;
      }
      int i = ((by)localObject1).position;
      if (paramca.getContent() == null)
      {
        AppMethodBeat.o(217038);
        return true;
      }
      localObject1 = this.WBq;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = k.b.OQ(bq.b(((com.tencent.mm.ui.chatting.e.a)localObject1).hRi(), paramca.getContent(), paramca.apA()));
      if (localObject1 == null)
      {
        AppMethodBeat.o(217038);
        return true;
      }
      Object localObject2 = com.tencent.mm.pluginsdk.model.app.h.bpS(((k.b)localObject1).appId);
      com.tencent.mm.ui.chatting.e.a locala;
      if ((com.tencent.mm.pluginsdk.model.app.h.l((com.tencent.mm.pluginsdk.model.app.g)localObject2)) && (!com.tencent.mm.ui.chatting.k.bF(paramca)) && (paramca.getStatus() != 1) && (((k.b)localObject1).type == 6))
      {
        locala = this.WBq;
        if (locala == null) {
          p.iCn();
        }
        paramo.a(i, 111, (CharSequence)locala.getResources().getString(R.l.retransmit), R.k.icons_filled_share);
      }
      if (((paramca.getStatus() == 2) || (paramca.apO() == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.apJ())))
      {
        locala = this.WBq;
        if (locala == null) {
          p.iCn();
        }
        if (!locala.hRk()) {
          paramo.a(i, 123, (CharSequence)paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
      }
      boolean bool = com.tencent.mm.ao.g.bjf();
      if (!Util.isImageExt(((k.b)localObject1).llY))
      {
        locala = this.WBq;
        if (locala == null) {
          p.iCn();
        }
        paramo.a(i, 150, (CharSequence)locala.getResources().getString(R.l.evV), R.k.icons_filled_otherapp);
      }
      if (bool)
      {
        locala = this.WBq;
        if (locala == null) {
          p.iCn();
        }
        if (!locala.hRj()) {
          paramo.add(i, 114, 0, (CharSequence)paramView.getContext().getString(R.l.evJ));
        }
      }
      if ((com.tencent.mm.by.c.blP("favorite")) && ((localObject2 == null) || (!((com.tencent.mm.pluginsdk.model.app.g)localObject2).Qv())) && (localObject1 != null) && (((k.b)localObject1).type != 74)) {
        paramo.a(i, 116, (CharSequence)paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
      }
      localObject2 = new em();
      ((em)localObject2).fAp.msgId = paramca.apG();
      EventCenter.instance.publish((IEvent)localObject2);
      if (!((em)localObject2).fAq.fzO)
      {
        paramca = this.WBq;
        if (paramca == null) {
          p.iCn();
        }
        if (!e.b.a((Context)paramca.getContext(), (k.b)localObject1)) {}
      }
      else
      {
        paramo.a(i, 129, (CharSequence)paramView.getContext().getString(R.l.evU), R.k.icons_filled_open);
      }
      paramca = this.WBq;
      if (paramca == null) {
        p.iCn();
      }
      if (!paramca.hRj())
      {
        paramca = this.WBq;
        if (paramca == null) {
          p.iCn();
        }
        paramo.a(i, 100, (CharSequence)paramca.getResources().getString(R.l.evO), R.k.icons_filled_delete);
      }
      if ((BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.hasDebugger())) {
        paramo.a(i, 144, (CharSequence)paramView.getContext().getString(R.l.menu_show_app_msg_content), R.k.fix_tools_entry);
      }
      AppMethodBeat.o(217038);
      return true;
    }
    
    public final void b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(217050);
      if (parama == null) {
        p.iCn();
      }
      com.tencent.mm.ui.base.h.c((Context)parama.getContext(), parama.getResources().getString(R.l.ewI), "", parama.getResources().getString(R.l.app_resend), parama.getResources().getString(R.l.app_cancel), (DialogInterface.OnClickListener)new b(paramca, parama), (DialogInterface.OnClickListener)o.c.c.Xge);
      AppMethodBeat.o(217050);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 1090519089);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(217047);
      p.k(paramca, "msg");
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.apJ());
      paramView = paramca.getContent();
      if (paramView == null)
      {
        AppMethodBeat.o(217047);
        return false;
      }
      paramView = k.b.OQ(paramView);
      if (paramView == null)
      {
        AppMethodBeat.o(217047);
        return false;
      }
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.aTS(paramView.appId);
      if ((localg != null) && (!Util.isNullOrNil(localg.field_appId)))
      {
        String str = z.bcZ();
        long l = paramca.apH();
        if (parama == null) {
          p.iCn();
        }
        a(parama, paramView, str, localg, l, parama.getTalkerUserName());
      }
      p.j(bh.beI(), "MMCore.getAccStg()");
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        if (parama == null) {
          p.iCn();
        }
        paramView = (Context)parama.getContext();
        parama = parama.hRf();
        p.j(parama, "ui.fragment");
        w.g(paramView, parama.getContentView());
        AppMethodBeat.o(217047);
        return true;
      }
      if ((e.b.bzG(paramView.llY)) && (e.e.a(paramca.apG(), paramView.fvr, parama)))
      {
        AppMethodBeat.o(217047);
        return true;
      }
      paramView = new Intent();
      if (parama == null) {
        p.iCn();
      }
      paramView.setClassName((Context)parama.getContext(), "com.tencent.mm.ui.chatting.AppAttachNewDownloadUI");
      paramView.putExtra("scene", 2);
      paramView.putExtra("app_msg_id", paramca.apG());
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$ChattingItemAppMsgFileTo", "onItemClick", "(Landroid/view/View;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(217047);
      return false;
    }
    
    public final boolean hTD()
    {
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class b
      implements DialogInterface.OnClickListener
    {
      b(ca paramca, com.tencent.mm.ui.chatting.e.a parama) {}
      
      public final void onClick(DialogInterface paramDialogInterface, int paramInt)
      {
        AppMethodBeat.i(290582);
        paramDialogInterface = this.lEd;
        if (paramDialogInterface == null) {
          p.iCn();
        }
        if (paramDialogInterface.erk())
        {
          com.tencent.mm.pluginsdk.model.app.m.bh(this.lEd);
          parama.Gi(true);
          AppMethodBeat.o(290582);
          return;
        }
        AppMethodBeat.o(290582);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$Companion;", "", "()V", "MAX_SHOW_LINES", "", "MIN_SECOND_LINE_SHOW_CNT", "TAG", "", "adjustEllipsizeMiddle", "", "textView", "Landroid/widget/TextView;", "sourceStr", "isWebSearchBlock", "", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "reportSendFileAction", "action", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "setWebSearchBlock", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFile$AppMsgFileViewHolder;", "app_release"})
  public static final class d
  {
    public static void a(final int paramInt, k.b paramb, final ca paramca)
    {
      AppMethodBeat.i(280456);
      if (paramca == null)
      {
        AppMethodBeat.o(280456);
        return;
      }
      com.tencent.e.h.ZvG.be((Runnable)new a(paramb, paramca, paramInt));
      AppMethodBeat.o(280456);
    }
    
    public static boolean a(k.b paramb, o.a parama)
    {
      AppMethodBeat.i(280453);
      p.k(paramb, "content");
      p.k(parama, "holder");
      if (l(paramb))
      {
        paramb = parama.Xdm;
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramb = parama.wRL;
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramb = parama.wRL;
        if (paramb != null) {
          paramb.setText(R.l.top_story_chatting_app_msg_brand_name);
        }
        paramb = parama.Xdj;
        if (paramb != null) {
          paramb.setVisibility(0);
        }
        paramb = parama.Xdj;
        if (paramb != null) {
          paramb.setImageResource(R.g.dpp);
        }
        AppMethodBeat.o(280453);
        return true;
      }
      AppMethodBeat.o(280453);
      return false;
    }
    
    private static boolean l(k.b paramb)
    {
      AppMethodBeat.i(280454);
      p.k(paramb, "content");
      paramb = (aj)paramb.ar(aj.class);
      if ((paramb != null) && (!Util.isNullOrNil(paramb.PyQ)))
      {
        AppMethodBeat.o(280454);
        return true;
      }
      AppMethodBeat.o(280454);
      return false;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(k.b paramb, ca paramca, int paramInt) {}
      
      public final void run()
      {
        Object localObject3 = null;
        AppMethodBeat.i(285873);
        Object localObject2 = this.PAC;
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = k.b.OQ(paramca.getContent());
        }
        ka localka = new ka();
        localka.uC(paramInt);
        long l;
        if (localObject1 != null)
        {
          l = ((k.b)localObject1).llX;
          localka.uD(l);
          if (localObject1 == null) {
            break label121;
          }
        }
        label121:
        for (localObject2 = ((k.b)localObject1).llY;; localObject2 = null)
        {
          localObject2 = Util.nullAsNil((String)localObject2);
          p.j(localObject2, "Util.nullAsNil(amc?.fileext)");
          if (localObject2 != null) {
            break label127;
          }
          localObject1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(285873);
          throw ((Throwable)localObject1);
          l = 0L;
          break;
        }
        label127:
        localObject2 = ((String)localObject2).toLowerCase();
        p.j(localObject2, "(this as java.lang.String).toLowerCase()");
        localka.AW((String)localObject2);
        localka.AX(paramca.apJ());
        if (localObject1 != null) {}
        for (localObject1 = (com.tencent.mm.aj.a.b)((k.b)localObject1).ar(com.tencent.mm.aj.a.b.class);; localObject1 = null)
        {
          localObject2 = localObject3;
          if (localObject1 != null) {
            localObject2 = Long.valueOf(((com.tencent.mm.aj.a.b)localObject1).lqB);
          }
          localka.AY(String.valueOf(localObject2));
          localka.amh();
          localka.bpa();
          AppMethodBeat.o(285873);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o
 * JD-Core Version:    0.7.0.1
 */