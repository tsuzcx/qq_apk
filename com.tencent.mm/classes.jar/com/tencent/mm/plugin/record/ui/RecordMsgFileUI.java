package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cf;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecordMsgFileUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.d
{
  private static final long rzP;
  private bu dBd;
  private ajn dsC;
  private ap gIf;
  private TextView jfJ;
  private TextView lZb;
  private String mediaId;
  private long msgId;
  private com.tencent.mm.pluginsdk.ui.tools.h oHt = null;
  private Button pHV;
  private ProgressBar progressBar;
  private boolean rAd = false;
  private boolean rAe = false;
  private Button rzQ;
  private Button rzR;
  private MMImageView rzS;
  private TextView rzT;
  private View rzU;
  private View rzV;
  private boolean rzZ = false;
  private boolean srt = false;
  private HandOffFile xso;
  private com.tencent.mm.plugin.record.b.n xsp;
  private boolean xsq;
  
  static
  {
    AppMethodBeat.i(193343);
    rzP = com.tencent.mm.n.b.aci();
    AppMethodBeat.o(193343);
  }
  
  private void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(27929);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.i.a.fIy) || (paramj.field_fileType == com.tencent.mm.i.a.MediaType_FILE)) && (this.srt)) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(false, paramj.field_dataId, localbu.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(27929);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(27929);
  }
  
  private void boN()
  {
    AppMethodBeat.i(27927);
    if (this.rAd)
    {
      AppMethodBeat.o(27927);
      return;
    }
    this.rAd = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_fav_path", p.c(this.dsC, this.msgId));
    localIntent.putExtra("key_detail_fav_thumb_path", p.f(this.dsC, this.msgId));
    localIntent.putExtra("key_detail_fav_video_duration", this.dsC.duration);
    localIntent.putExtra("key_detail_statExtStr", this.dsC.dHv);
    localIntent.putExtra("key_detail_fav_video_scene_from", 1);
    localIntent.putExtra("key_detail_msg_uuid", this.dsC.iuq);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", localIntent);
    finish();
    AppMethodBeat.o(27927);
  }
  
  private void c(j paramj)
  {
    AppMethodBeat.i(27925);
    final int j;
    final int i;
    final int k;
    if (paramj != null)
    {
      j = (int)(paramj.field_offset / Math.max(1, paramj.field_totalLen) * 100.0F);
      i = paramj.field_offset;
      k = paramj.field_totalLen;
    }
    for (;;)
    {
      this.gIf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27898);
          RecordMsgFileUI.o(RecordMsgFileUI.this).setProgress(j);
          RecordMsgFileUI.p(RecordMsgFileUI.this).setText(RecordMsgFileUI.this.getString(2131758872, new Object[] { bt.ba(i), bt.ba(k) }));
          AppMethodBeat.o(27898);
        }
      });
      AppMethodBeat.o(27925);
      return;
      k = (int)this.dsC.Ghm;
      i = 0;
      j = 0;
    }
  }
  
  private void cwR()
  {
    AppMethodBeat.i(27916);
    this.rzR.setVisibility(8);
    this.pHV.setVisibility(8);
    this.rzQ.setVisibility(8);
    this.rzU.setVisibility(8);
    this.lZb.setVisibility(0);
    if (this.dsC.dataType == 4)
    {
      this.lZb.setGravity(17);
      this.lZb.setText(2131758941);
      AppMethodBeat.o(27916);
      return;
    }
    this.lZb.setGravity(17);
    this.lZb.setText(2131758940);
    if (!this.xsq)
    {
      this.xsq = true;
      fB(8, 6);
    }
    AppMethodBeat.o(27916);
  }
  
  private void cwS()
  {
    AppMethodBeat.i(27917);
    this.rzR.setVisibility(8);
    this.pHV.setVisibility(8);
    this.rzQ.setVisibility(8);
    this.lZb.setVisibility(8);
    this.rzU.setVisibility(0);
    c(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(this.mediaId));
    AppMethodBeat.o(27917);
  }
  
  private void cwT()
  {
    AppMethodBeat.i(27918);
    this.rzU.setVisibility(8);
    this.rzQ.setVisibility(8);
    if (bt.isNullOrNil(this.dsC.GgY)) {
      this.pHV.setVisibility(8);
    }
    for (;;)
    {
      this.rzR.setVisibility(0);
      this.rzR.setText(2131758918);
      this.lZb.setVisibility(8);
      AppMethodBeat.o(27918);
      return;
      this.pHV.setVisibility(0);
    }
  }
  
  private void cwV()
  {
    AppMethodBeat.i(27919);
    if (this.xso.uDP != 1)
    {
      this.xso.uDP = 1;
      this.xso.ane(bt.nullAsNil(p.c(this.dsC, this.msgId)));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.xso);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.xso);
    }
    if ((getType() == 15) && (this.dsC.GhR != null) && (!bt.isNullOrNil(this.dsC.GhR.hCe)) && (!bt.isNullOrNil(this.dsC.GhR.hCi)))
    {
      this.rAe = true;
      this.rzS.setVisibility(8);
      this.rzU.setVisibility(8);
      this.rzR.setVisibility(8);
      this.pHV.setVisibility(8);
      this.rzQ.setVisibility(8);
      this.lZb.setVisibility(8);
      String str = p.c(this.dsC, this.msgId);
      ad.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.abh() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131306317);
      this.oHt = t.hE(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.oHt, 0, localLayoutParams);
      this.oHt.setVideoCallback(new h.a()
      {
        public final int eT(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void onCompletion() {}
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27911);
          RecordMsgFileUI.j(RecordMsgFileUI.this).stop();
          if (RecordMsgFileUI.k(RecordMsgFileUI.this))
          {
            AppMethodBeat.o(27911);
            return;
          }
          RecordMsgFileUI.l(RecordMsgFileUI.this);
          final Bitmap localBitmap = RecordMsgFileUI.m(RecordMsgFileUI.this).b(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          final String str = RecordMsgFileUI.j(RecordMsgFileUI.this).getVideoPath();
          com.tencent.mm.sdk.a.b.O(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dPZ() + "[RecordMsgFileUI] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + bt.bI(str, "")).getBytes(), 2), "FullScreenPlaySight");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27909);
              Object localObject1 = (ImageView)RecordMsgFileUI.this.findViewById(2131306415);
              ((ImageView)localObject1).setImageBitmap(localBitmap);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              com.tencent.mm.sdk.platformtools.n.a(RecordMsgFileUI.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.e(str), "video/*");
              try
              {
                localObject1 = RecordMsgFileUI.this;
                localObject2 = Intent.createChooser((Intent)localObject2, RecordMsgFileUI.this.getString(2131759030));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((RecordMsgFileUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(27909);
                return;
              }
              catch (Exception localException)
              {
                ad.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.l(RecordMsgFileUI.this.getContext(), 2131758931, 2131758932);
                AppMethodBeat.o(27909);
              }
            }
          });
          AppMethodBeat.o(27911);
        }
        
        public final void ta()
        {
          AppMethodBeat.i(27910);
          ad.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.abh() + " onPrepared");
          RecordMsgFileUI.j(RecordMsgFileUI.this).setLoop(true);
          RecordMsgFileUI.j(RecordMsgFileUI.this).start();
          AppMethodBeat.o(27910);
        }
      });
      ad.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.abh() + " initView :" + str);
      if (str != null)
      {
        this.oHt.stop();
        this.oHt.setVideoPath(str);
      }
      ad.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.abh() + " initView");
      if (ba.Nb() != null) {
        ba.Nb().Wv();
      }
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.rAe)
      {
        this.rzU.setVisibility(8);
        this.rzR.setVisibility(8);
        this.pHV.setVisibility(8);
        this.rzQ.setVisibility(0);
        this.rzQ.setText(2131758920);
        this.lZb.setVisibility(8);
        boN();
        AppMethodBeat.o(27919);
      }
    }
    else
    {
      this.rzU.setVisibility(8);
      this.rzR.setVisibility(4);
      if (!bt.isNullOrNil(this.dsC.GgY)) {
        break label553;
      }
      this.pHV.setVisibility(8);
    }
    for (;;)
    {
      this.rzQ.setVisibility(0);
      this.lZb.setVisibility(0);
      AppMethodBeat.o(27919);
      return;
      label553:
      this.pHV.setVisibility(0);
    }
  }
  
  private String dEx()
  {
    AppMethodBeat.i(27924);
    Object localObject = new com.tencent.mm.vfs.e(p.f(this.dsC, this.msgId));
    if (((com.tencent.mm.vfs.e)localObject).exists()) {}
    for (localObject = q.B(((com.tencent.mm.vfs.e)localObject).fOK());; localObject = com.tencent.mm.model.c.azK() + "web/" + com.tencent.mm.b.g.getMessageDigest(bt.bI(this.dsC.dnv, "").getBytes()))
    {
      AppMethodBeat.o(27924);
      return localObject;
      localObject = new StringBuilder();
      ba.aBQ();
    }
  }
  
  private void fB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27928);
    if (8 == getType()) {
      if (this.dsC.Ghm <= 26214400L) {
        break label220;
      }
    }
    label220:
    for (int i = 7;; i = 5)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1203L, paramInt2, 1L, false);
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.dsC.GgR, Integer.valueOf(i), Long.valueOf(this.dsC.Ghm), Integer.valueOf(paramInt1), Long.valueOf((cf.aCL() - this.dBd.field_createTime) / 1000L), this.dsC.Ghg, this.dBd.field_talker, Integer.valueOf(2), this.dsC.dsU, Long.valueOf(this.dBd.field_msgSvrId), Long.valueOf(this.dBd.field_createTime) });
      ad.i("MicroMsg.RecordMsgFileUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(14665, str);
      AppMethodBeat.o(27928);
      return;
    }
  }
  
  private int getType()
  {
    int j = this.dsC.dataType;
    int i = j;
    if (j == 15) {
      i = 4;
    }
    return i;
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(27926);
    if (paramj == null)
    {
      ad.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
      AppMethodBeat.o(27926);
      return;
    }
    ad.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[] { this.mediaId, paramj.field_mediaId });
    if (!this.mediaId.equals(paramj.field_mediaId))
    {
      AppMethodBeat.o(27926);
      return;
    }
    switch (paramj.field_status)
    {
    default: 
      c(paramj);
      AppMethodBeat.o(27926);
      return;
    case 2: 
      this.gIf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27899);
          RecordMsgFileUI.this.enableOptionMenu(true);
          RecordMsgFileUI.q(RecordMsgFileUI.this);
          AppMethodBeat.o(27899);
        }
      });
      a(paramj, true);
      fB(0, 2);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1203L, 5L, this.dsC.Ghm, false);
      AppMethodBeat.o(27926);
      return;
    case 4: 
      a(paramj, false);
      this.gIf.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27900);
          RecordMsgFileUI.r(RecordMsgFileUI.this);
          AppMethodBeat.o(27900);
        }
      });
      fB(1, 3);
      AppMethodBeat.o(27926);
      return;
    }
    this.gIf.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27901);
        RecordMsgFileUI.h(RecordMsgFileUI.this);
        com.tencent.mm.ui.base.h.cl(RecordMsgFileUI.this.getContext(), RecordMsgFileUI.this.getString(2131758104));
        AppMethodBeat.o(27901);
      }
    });
    a(paramj, false);
    fB(1, 4);
    AppMethodBeat.o(27926);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494002;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(27923);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131758111, 2131758112, 5);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(27923);
      return;
    }
    if (paramInt1 == 1001)
    {
      if (paramIntent == null)
      {
        localObject1 = null;
        if (paramIntent != null) {
          break label140;
        }
      }
      Object localObject2;
      label140:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        localObject2 = com.tencent.mm.ui.base.h.b(getContext(), getString(2131758906), false, null);
        ad.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27912);
            this.rvc.dismiss();
            AppMethodBeat.o(27912);
          }
        };
        if (!bt.isNullOrNil((String)localObject1)) {
          break label151;
        }
        AppMethodBeat.o(27923);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label151:
      Object localObject1 = bt.U(((String)localObject1).split(","));
      if ((getType() == 4) || (getType() == 15))
      {
        ba.ajF().ay(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27913);
            com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
            Iterator localIterator = this.xss.iterator();
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              Object localObject1;
              if (locale.exists())
              {
                localObject1 = RecordMsgFileUI.n(RecordMsgFileUI.this);
                ad.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[] { q.B(locale.fOK()), localObject1 });
                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 15) {
                  com.tencent.mm.plugin.messenger.a.g.dlD().a(RecordMsgFileUI.this.getContext(), str1, q.B(locale.fOK()), (String)localObject1, 62, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).iuq);
                }
              }
              for (;;)
              {
                com.tencent.mm.plugin.messenger.a.g.dlD().hP(paramIntent, str1);
                break;
                com.tencent.mm.plugin.messenger.a.g.dlD().a(RecordMsgFileUI.this.getContext(), str1, q.B(locale.fOK()), (String)localObject1, 1, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).iuq);
                continue;
                Object localObject2 = RecordMsgFileUI.a(RecordMsgFileUI.this).GgY;
                if (!bt.isNullOrNil((String)localObject2))
                {
                  localObject1 = new WXVideoObject();
                  ((WXVideoObject)localObject1).videoUrl = ((String)localObject2);
                  localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
                  String str2 = bt.bI(RecordMsgFileUI.a(RecordMsgFileUI.this).title, RecordMsgFileUI.this.getContext().getResources().getString(2131759030));
                  ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                  ((WXMediaMessage)localObject2).title = str2;
                  ((WXMediaMessage)localObject2).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
                  ((WXMediaMessage)localObject2).thumbData = bt.readFromFile(p.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
                  if (((WXMediaMessage)localObject2).thumbData == null)
                  {
                    localObject1 = new StringBuilder();
                    ba.aBQ();
                    ((WXMediaMessage)localObject2).thumbData = bt.readFromFile(com.tencent.mm.model.c.azK() + "web/" + com.tencent.mm.b.g.getMessageDigest(bt.bI(RecordMsgFileUI.a(RecordMsgFileUI.this).dnv, "").getBytes()));
                  }
                  m.a((WXMediaMessage)localObject2, "", "", str1, 3, null);
                }
              }
            }
            RecordMsgFileUI.a(RecordMsgFileUI.this, 2, 7);
            aq.f(this.val$callback);
            AppMethodBeat.o(27913);
          }
          
          public final String toString()
          {
            AppMethodBeat.i(27914);
            String str = super.toString() + "|onActivityResult1";
            AppMethodBeat.o(27914);
            return str;
          }
        });
        AppMethodBeat.o(27923);
        return;
      }
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27896);
          Object localObject1 = p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          Object localObject2 = new WXFileObject();
          ((WXFileObject)localObject2).setFilePath((String)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          ((WXMediaMessage)localObject1).title = RecordMsgFileUI.a(RecordMsgFileUI.this).title;
          ((WXMediaMessage)localObject1).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
          ((WXMediaMessage)localObject1).thumbData = bt.readFromFile(p.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
          localObject2 = this.xss.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            m.a((WXMediaMessage)localObject1, "", "", str, 3, null);
            com.tencent.mm.plugin.messenger.a.g.dlD().hP(paramIntent, str);
          }
          aq.f(this.val$callback);
          AppMethodBeat.o(27896);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(27897);
          String str = super.toString() + "|onActivityResult2";
          AppMethodBeat.o(27897);
          return str;
        }
      });
    }
    AppMethodBeat.o(27923);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(27915);
    super.onCreate(paramBundle);
    this.gIf = new ap();
    this.xsp = new com.tencent.mm.plugin.record.b.n();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dBd = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(this.msgId);
    paramBundle = getIntent().getStringExtra("record_data_id");
    Object localObject = p.avr(getIntent().getStringExtra("record_xml"));
    if (localObject == null)
    {
      ad.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    localObject = ((com.tencent.mm.protocal.b.a.c)localObject).hDb.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajn localajn = (ajn)((Iterator)localObject).next();
      if (localajn.dsU.equals(paramBundle)) {
        this.dsC = localajn;
      }
    }
    if (this.dsC == null)
    {
      ad.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    this.mediaId = p.g(this.dsC.dsU, this.msgId, true);
    this.pHV = ((Button)findViewById(2131303391));
    this.rzQ = ((Button)findViewById(2131303020));
    this.rzR = ((Button)findViewById(2131299195));
    this.rzS = ((MMImageView)findViewById(2131300891));
    this.jfJ = ((TextView)findViewById(2131302666));
    this.lZb = ((TextView)findViewById(2131305896));
    this.rzV = findViewById(2131299221);
    this.rzU = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.rzT = ((TextView)findViewById(2131299217));
    label393:
    int i;
    label564:
    int j;
    if (4 == getType())
    {
      setMMTitle(2131759030);
      if (getType() != 4) {
        break label813;
      }
      this.rzS.setImageResource(2131689581);
      this.jfJ.setText(this.dsC.title);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27895);
          RecordMsgFileUI.this.finish();
          AppMethodBeat.o(27895);
          return true;
        }
      });
      this.rzQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27902);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          paramAnonymousView = p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          new Intent().setAction("android.intent.action.VIEW");
          if (4 == RecordMsgFileUI.c(RecordMsgFileUI.this))
          {
            RecordMsgFileUI.d(RecordMsgFileUI.this);
            RecordMsgFileUI.e(RecordMsgFileUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27902);
            return;
            RecordMsgFileUI.a(RecordMsgFileUI.this, paramAnonymousView);
          }
        }
      });
      localObject = this.dsC.GgY;
      if (!bt.isNullOrNil((String)localObject)) {
        this.pHV.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27903);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", this.rAp);
            com.tencent.mm.bs.d.b(RecordMsgFileUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27903);
          }
        });
      }
      this.rzR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27904);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!com.tencent.mm.compatible.util.e.abf())
          {
            com.tencent.mm.ui.base.h.l(RecordMsgFileUI.this.getContext(), 2131758934, 2131755906);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27904);
            return;
          }
          p.b(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this), true);
          RecordMsgFileUI.f(RecordMsgFileUI.this);
          RecordMsgFileUI.g(RecordMsgFileUI.this);
          RecordMsgFileUI.a(RecordMsgFileUI.this, 7, 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27904);
        }
      });
      this.rzV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27905);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          RecordMsgFileUI.h(RecordMsgFileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27905);
        }
      });
      ba.aBQ();
      localObject = com.tencent.mm.model.c.azs().xY(this.msgId);
      this.xso = HandOffFile.a(this.dsC, null, (bu)localObject);
      this.xso.dnh = 1;
      boolean bool = p.d(this.dsC, this.msgId);
      localObject = this.xso;
      if (!bool) {
        break label833;
      }
      i = 1;
      ((HandOffFile)localObject).uDP = i;
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.xso);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.xso);
      if ((getType() != 15) || (bt.aRe(com.tencent.mm.n.g.acA().getValue("SightForwardEnable")) == 1)) {
        break label838;
      }
      ad.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
      label640:
      if ((!bt.isNullOrNil(this.dsC.GgR)) && (!bt.isNullOrNil(this.dsC.GgT))) {
        break label857;
      }
      i = 1;
      label668:
      if ((!bt.isNullOrNil(this.dsC.Gij)) && (!bt.isNullOrNil(this.dsC.Gig))) {
        break label862;
      }
      j = 1;
      label696:
      if ((i != 0) || (j != 0)) {
        break label867;
      }
      cwR();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
      if (8 == getType()) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aa(paramBundle, this.dBd.field_msgSvrId);
      }
      fB(4, 0);
      AppMethodBeat.o(27915);
      return;
      if (15 == getType())
      {
        setMMTitle(2131759002);
        findViewById(2131306317).setBackgroundResource(2131100017);
        break;
      }
      setMMTitle(2131758904);
      break;
      label813:
      this.rzS.setImageResource(com.tencent.mm.pluginsdk.f.aLi(this.dsC.Ghg));
      break label393;
      label833:
      i = 2;
      break label564;
      label838:
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27908);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RecordMsgFileUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.KJy = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27906);
              paramAnonymous2l.c(0, RecordMsgFileUI.this.getString(2131759001));
              AppMethodBeat.o(27906);
            }
          };
          paramAnonymousMenuItem.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(27907);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(27907);
                return;
                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 8)
                {
                  paramAnonymous2MenuItem = p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
                  if (!com.tencent.mm.vfs.i.fv(paramAnonymous2MenuItem))
                  {
                    ad.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(2131758999), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                  if (new com.tencent.mm.vfs.e(paramAnonymous2MenuItem).length() > RecordMsgFileUI.uP())
                  {
                    ad.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(2131759000), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                }
                RecordMsgFileUI.i(RecordMsgFileUI.this);
              }
            }
          };
          paramAnonymousMenuItem.cMW();
          AppMethodBeat.o(27908);
          return true;
        }
      });
      break label640;
      label857:
      i = 0;
      break label668;
      label862:
      j = 0;
      break label696;
      label867:
      if (!p.d(this.dsC, this.msgId)) {
        break label893;
      }
      enableOptionMenu(true);
      cwV();
    }
    label893:
    localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().avq(this.mediaId);
    if ((localObject == null) || (2 == ((j)localObject).field_status)) {
      cwT();
    }
    for (;;)
    {
      enableOptionMenu(false);
      break;
      if (4 == ((j)localObject).field_status)
      {
        cwR();
      }
      else if ((((j)localObject).field_status == 0) || (1 == ((j)localObject).field_status))
      {
        cwS();
      }
      else
      {
        ad.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        cwT();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27920);
    if (this.oHt != null)
    {
      this.oHt.setVideoCallback(null);
      this.oHt.stop();
      this.oHt.onDetach();
      if (ba.Nb() != null) {
        ba.Nb().Wu();
      }
    }
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    if (this.xso != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.xso);
    }
    this.xsp.destory();
    AppMethodBeat.o(27920);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27922);
    super.onPause();
    if (this.oHt != null) {
      this.oHt.stop();
    }
    AppMethodBeat.o(27922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27921);
    super.onResume();
    if (this.oHt != null) {
      this.oHt.start();
    }
    AppMethodBeat.o(27921);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI
 * JD-Core Version:    0.7.0.1
 */