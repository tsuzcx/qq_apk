package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;

public class RecordMsgFileUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.d
{
  private static final long wNY;
  private boolean ASg = false;
  private HandOffFile HEt;
  private com.tencent.mm.plugin.record.b.n HEu;
  private boolean HEv;
  private anm fDI;
  private ca fNz;
  private MMHandler knk;
  private TextView mYd;
  private String mediaId;
  private long msgId;
  private ProgressBar progressBar;
  private TextView qpt;
  private k txH = null;
  private Button uId;
  private Button wNZ;
  private Button wOa;
  private MMImageView wOb;
  private TextView wOc;
  private View wOd;
  private View wOe;
  private boolean wOi = false;
  private boolean wOm = false;
  private boolean wOn = false;
  
  static
  {
    AppMethodBeat.i(278796);
    wNY = com.tencent.mm.n.c.awK();
    AppMethodBeat.o(278796);
  }
  
  private void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(27929);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.i.a.iTW) || (paramj.field_fileType == com.tencent.mm.i.a.MediaType_FILE)) && (this.ASg)) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).a(false, paramj.field_dataId, localca.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(27929);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(27929);
  }
  
  private void bXd()
  {
    AppMethodBeat.i(27927);
    if (this.wOm)
    {
      AppMethodBeat.o(27927);
      return;
    }
    this.wOm = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_fav_path", p.c(this.fDI, this.msgId));
    localIntent.putExtra("key_detail_fav_thumb_path", p.f(this.fDI, this.msgId));
    localIntent.putExtra("key_detail_fav_video_duration", this.fDI.duration);
    localIntent.putExtra("key_detail_statExtStr", this.fDI.fUk);
    localIntent.putExtra("key_detail_fav_video_scene_from", 1);
    localIntent.putExtra("key_detail_msg_uuid", this.fDI.mic);
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
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27898);
          RecordMsgFileUI.p(RecordMsgFileUI.this).setProgress(j);
          RecordMsgFileUI.q(RecordMsgFileUI.this).setText(RecordMsgFileUI.this.getString(R.l.favorite_downloading, new Object[] { Util.getLengthStr(i), Util.getLengthStr(k) }));
          AppMethodBeat.o(27898);
        }
      });
      AppMethodBeat.o(27925);
      return;
      k = (int)this.fDI.Syi;
      i = 0;
      j = 0;
    }
  }
  
  private void dlD()
  {
    AppMethodBeat.i(27916);
    this.wOa.setVisibility(8);
    this.uId.setVisibility(8);
    this.wNZ.setVisibility(8);
    this.wOd.setVisibility(8);
    this.qpt.setVisibility(0);
    if (this.fDI.dataType == 4)
    {
      this.qpt.setGravity(17);
      this.qpt.setText(R.l.favorite_out_of_date_video);
      AppMethodBeat.o(27916);
      return;
    }
    this.qpt.setGravity(17);
    this.qpt.setText(R.l.favorite_out_of_date_file);
    if (!this.HEv)
    {
      this.HEv = true;
      gm(8, 6);
    }
    AppMethodBeat.o(27916);
  }
  
  private void dlE()
  {
    AppMethodBeat.i(27917);
    this.wOa.setVisibility(8);
    this.uId.setVisibility(8);
    this.wNZ.setVisibility(8);
    this.qpt.setVisibility(8);
    this.wOd.setVisibility(0);
    c(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(this.mediaId));
    AppMethodBeat.o(27917);
  }
  
  private void dlF()
  {
    AppMethodBeat.i(27918);
    this.wOd.setVisibility(8);
    this.wNZ.setVisibility(8);
    if (Util.isNullOrNil(this.fDI.SxU)) {
      this.uId.setVisibility(8);
    }
    for (;;)
    {
      this.wOa.setVisibility(0);
      this.wOa.setText(R.l.favorite_item_download);
      this.qpt.setVisibility(8);
      AppMethodBeat.o(27918);
      return;
      this.uId.setVisibility(0);
    }
  }
  
  private void dlH()
  {
    AppMethodBeat.i(27919);
    if (this.HEt.getFileStatus() != 1)
    {
      this.HEt.setFileStatus(1);
      this.HEt.setFullPath(Util.nullAsNil(p.c(this.fDI, this.msgId)));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).g(this.HEt);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.HEt);
    }
    if ((getType() == 15) && (this.fDI.SyM != null) && (!Util.isNullOrNil(this.fDI.SyM.lor)) && (!Util.isNullOrNil(this.fDI.SyM.lov)))
    {
      this.wOn = true;
      this.wOb.setVisibility(8);
      this.wOd.setVisibility(8);
      this.wOa.setVisibility(8);
      this.uId.setVisibility(8);
      this.wNZ.setVisibility(8);
      this.qpt.setVisibility(8);
      String str = p.c(this.fDI, this.msgId);
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.avC() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(R.h.video_container);
      this.txH = x.jH(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.txH, 0, localLayoutParams);
      this.txH.setVideoCallback(new k.a()
      {
        public final void eM(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fE(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
        public final void onCompletion() {}
        
        public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(27911);
          RecordMsgFileUI.k(RecordMsgFileUI.this).stop();
          if (RecordMsgFileUI.l(RecordMsgFileUI.this))
          {
            AppMethodBeat.o(27911);
            return;
          }
          RecordMsgFileUI.m(RecordMsgFileUI.this);
          final Bitmap localBitmap = RecordMsgFileUI.n(RecordMsgFileUI.this).b(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          final String str = RecordMsgFileUI.k(RecordMsgFileUI.this).getVideoPath();
          CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.f.fIy() + "[RecordMsgFileUI] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + Util.nullAs(str, "")).getBytes(), 2), "FullScreenPlaySight");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27909);
              Object localObject1 = (ImageView)RecordMsgFileUI.this.findViewById(R.h.videoplayer_maskview);
              ((ImageView)localObject1).setImageBitmap(localBitmap);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              FileProviderHelper.setIntentDataAndType(RecordMsgFileUI.this.getContext(), (Intent)localObject2, new q(str), "video/*", false);
              try
              {
                localObject1 = RecordMsgFileUI.this;
                localObject2 = Intent.createChooser((Intent)localObject2, RecordMsgFileUI.this.getString(R.l.favorite_video));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((RecordMsgFileUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(27909);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.p(RecordMsgFileUI.this.getContext(), R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
                AppMethodBeat.o(27909);
              }
            }
          });
          AppMethodBeat.o(27911);
        }
        
        public final void qX()
        {
          AppMethodBeat.i(27910);
          Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.avC() + " onPrepared");
          RecordMsgFileUI.k(RecordMsgFileUI.this).setLoop(true);
          RecordMsgFileUI.k(RecordMsgFileUI.this).start();
          AppMethodBeat.o(27910);
        }
      });
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.avC() + " initView :" + str);
      if (str != null)
      {
        this.txH.stop();
        this.txH.setVideoPath(str);
      }
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.avC() + " initView");
      if (bh.abL() != null) {
        bh.abL().aqn();
      }
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.wOn)
      {
        this.wOd.setVisibility(8);
        this.wOa.setVisibility(8);
        this.uId.setVisibility(8);
        this.wNZ.setVisibility(0);
        this.wNZ.setText(R.l.favorite_item_preview);
        this.qpt.setVisibility(8);
        bXd();
        AppMethodBeat.o(27919);
      }
    }
    else
    {
      this.wOd.setVisibility(8);
      this.wOa.setVisibility(4);
      if (!Util.isNullOrNil(this.fDI.SxU)) {
        break label553;
      }
      this.uId.setVisibility(8);
    }
    for (;;)
    {
      this.wNZ.setVisibility(0);
      this.qpt.setVisibility(0);
      AppMethodBeat.o(27919);
      return;
      label553:
      this.uId.setVisibility(0);
    }
  }
  
  private String fuG()
  {
    AppMethodBeat.i(27924);
    Object localObject = new q(p.f(this.fDI, this.msgId));
    if (((q)localObject).ifE()) {}
    for (localObject = ((q)localObject).bOF();; localObject = com.tencent.mm.model.c.bcg() + "web/" + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(this.fDI.fyu, "").getBytes()))
    {
      AppMethodBeat.o(27924);
      return localObject;
      localObject = new StringBuilder();
      bh.beI();
    }
  }
  
  private int getType()
  {
    int j = this.fDI.dataType;
    int i = j;
    if (j == 15) {
      i = 4;
    }
    return i;
  }
  
  private void gm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27928);
    if (8 == getType()) {
      if (this.fDI.Syi <= 26214400L) {
        break label238;
      }
    }
    label238:
    for (int i = 7;; i = 5)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1203L, paramInt2, 1L, false);
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.fDI.Rwb, Integer.valueOf(i), Long.valueOf(this.fDI.Syi), Integer.valueOf(paramInt1), Long.valueOf((cm.bfD() - this.fNz.field_createTime) / 1000L), this.fDI.Syc, this.fNz.field_talker, Integer.valueOf(2), this.fDI.fEa, Long.valueOf(this.fNz.field_msgSvrId), Long.valueOf(this.fNz.field_createTime), Long.valueOf(cm.bfC()), Integer.valueOf(1) });
      Log.i("MicroMsg.RecordMsgFileUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(14665, str);
      AppMethodBeat.o(27928);
      return;
    }
  }
  
  public final void a(int paramInt, j paramj)
  {
    AppMethodBeat.i(27926);
    if (paramj == null)
    {
      Log.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
      AppMethodBeat.o(27926);
      return;
    }
    Log.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[] { this.mediaId, paramj.field_mediaId });
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
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27899);
          RecordMsgFileUI.this.enableOptionMenu(true);
          RecordMsgFileUI.r(RecordMsgFileUI.this);
          AppMethodBeat.o(27899);
        }
      });
      a(paramj, true);
      gm(0, 2);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1203L, 5L, this.fDI.Syi, false);
      AppMethodBeat.o(27926);
      return;
    case 4: 
      a(paramj, false);
      this.knk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27900);
          RecordMsgFileUI.s(RecordMsgFileUI.this);
          AppMethodBeat.o(27900);
        }
      });
      gm(1, 3);
      AppMethodBeat.o(27926);
      return;
    }
    this.knk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27901);
        RecordMsgFileUI.h(RecordMsgFileUI.this);
        com.tencent.mm.ui.base.h.cO(RecordMsgFileUI.this.getContext(), RecordMsgFileUI.this.getString(R.l.download_fail));
        AppMethodBeat.o(27901);
      }
    });
    a(paramj, false);
    gm(1, 4);
    AppMethodBeat.o(27926);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.egW;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(27923);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 5);
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
        localObject2 = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
        Log.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27912);
            this.wJe.dismiss();
            AppMethodBeat.o(27912);
          }
        };
        if (!Util.isNullOrNil((String)localObject1)) {
          break label151;
        }
        AppMethodBeat.o(27923);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label151:
      Object localObject1 = Util.stringsToList(((String)localObject1).split(","));
      if ((getType() == 4) || (getType() == 15))
      {
        bh.aHJ().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27913);
            q localq = new q(p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
            Iterator localIterator = this.HEx.iterator();
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              Object localObject1;
              if (localq.ifE())
              {
                localObject1 = RecordMsgFileUI.o(RecordMsgFileUI.this);
                Log.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[] { localq.bOF(), localObject1 });
                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 15) {
                  com.tencent.mm.plugin.messenger.a.g.eRW().a(RecordMsgFileUI.this.getContext(), str1, localq.bOF(), (String)localObject1, 62, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).mic);
                }
              }
              for (;;)
              {
                com.tencent.mm.plugin.messenger.a.g.eRW().iQ(paramIntent, str1);
                break;
                com.tencent.mm.plugin.messenger.a.g.eRW().a(RecordMsgFileUI.this.getContext(), str1, localq.bOF(), (String)localObject1, 1, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).mic);
                continue;
                Object localObject2 = RecordMsgFileUI.a(RecordMsgFileUI.this).SxU;
                if (!Util.isNullOrNil((String)localObject2))
                {
                  localObject1 = new WXVideoObject();
                  ((WXVideoObject)localObject1).videoUrl = ((String)localObject2);
                  localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
                  String str2 = Util.nullAs(RecordMsgFileUI.a(RecordMsgFileUI.this).title, RecordMsgFileUI.this.getContext().getResources().getString(R.l.favorite_video));
                  ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                  ((WXMediaMessage)localObject2).title = str2;
                  ((WXMediaMessage)localObject2).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
                  ((WXMediaMessage)localObject2).thumbData = Util.readFromFile(p.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
                  if (((WXMediaMessage)localObject2).thumbData == null)
                  {
                    localObject1 = new StringBuilder();
                    bh.beI();
                    ((WXMediaMessage)localObject2).thumbData = Util.readFromFile(com.tencent.mm.model.c.bcg() + "web/" + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(RecordMsgFileUI.a(RecordMsgFileUI.this).fyu, "").getBytes()));
                  }
                  m.a((WXMediaMessage)localObject2, "", "", str1, 3, null);
                }
              }
            }
            RecordMsgFileUI.a(RecordMsgFileUI.this, 2, 7);
            MMHandlerThread.postToMainThread(this.val$callback);
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
      bh.aHJ().postToWorker(new Runnable()
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
          ((WXMediaMessage)localObject1).thumbData = Util.readFromFile(p.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
          localObject2 = this.HEx.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            m.a((WXMediaMessage)localObject1, "", "", str, 3, null);
            com.tencent.mm.plugin.messenger.a.g.eRW().iQ(paramIntent, str);
          }
          MMHandlerThread.postToMainThread(this.val$callback);
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
    this.knk = new MMHandler();
    this.HEu = new com.tencent.mm.plugin.record.b.n();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.fNz = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().Oq(this.msgId);
    paramBundle = getIntent().getStringExtra("record_data_id");
    if (this.fNz == null)
    {
      Log.w("MicroMsg.RecordMsgFileUI", "get record msg data error, msg null");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    this.fDI = p.jM(getIntent().getStringExtra("record_xml"), paramBundle);
    if (this.fDI == null)
    {
      localObject = k.b.aG(this.fNz.field_content, this.fNz.field_reserved);
      if (localObject == null)
      {
        Log.w("MicroMsg.RecordMsgFileUI", "get record msg data error, content null");
        finish();
        AppMethodBeat.o(27915);
        return;
      }
      this.fDI = p.jM(((k.b)localObject).lmA, paramBundle);
    }
    if (this.fDI == null)
    {
      Log.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    this.mediaId = p.f(this.fDI.fEa, this.msgId, true);
    this.uId = ((Button)findViewById(R.h.preview_btn));
    this.wNZ = ((Button)findViewById(R.h.open_btn));
    this.wOa = ((Button)findViewById(R.h.download_btn));
    this.wOb = ((MMImageView)findViewById(R.h.icon_iv));
    this.mYd = ((TextView)findViewById(R.h.name_tv));
    this.qpt = ((TextView)findViewById(R.h.tips_tv));
    this.wOe = findViewById(R.h.download_stop_btn);
    this.wOd = findViewById(R.h.download_progress_area);
    this.progressBar = ((ProgressBar)findViewById(R.h.download_pb));
    this.wOc = ((TextView)findViewById(R.h.download_progress_tips));
    label409:
    int i;
    label584:
    int j;
    if (4 == getType())
    {
      setMMTitle(R.l.favorite_video);
      if (getType() != 4) {
        break label833;
      }
      this.wOb.setImageResource(R.k.app_attach_file_icon_video);
      this.mYd.setText(this.fDI.title);
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
      this.wNZ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27902);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      localObject = this.fDI.SxU;
      if (!Util.isNullOrNil((String)localObject)) {
        this.uId.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27903);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", this.wOz);
            com.tencent.mm.by.c.b(RecordMsgFileUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27903);
          }
        });
      }
      this.wOa.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27904);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!com.tencent.mm.compatible.util.e.avA())
          {
            com.tencent.mm.ui.base.h.p(RecordMsgFileUI.this.getContext(), R.l.favorite_no_sdcard, R.l.app_tip);
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
      this.wOe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27905);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          RecordMsgFileUI.h(RecordMsgFileUI.this);
          p.g(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27905);
        }
      });
      bh.beI();
      localObject = com.tencent.mm.model.c.bbO().Oq(this.msgId);
      this.HEt = HandOffFile.fromFavItem(this.fDI, null, (ca)localObject, com.tencent.mm.plugin.fav.a.b.d(null));
      this.HEt.setSource(1);
      boolean bool = p.d(this.fDI, this.msgId);
      localObject = this.HEt;
      if (!bool) {
        break label853;
      }
      i = 1;
      ((HandOffFile)localObject).setFileStatus(i);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).g(this.HEt);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).c(this.HEt);
      if ((getType() != 15) || (Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("SightForwardEnable")) == 1)) {
        break label858;
      }
      Log.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
      label660:
      if ((!Util.isNullOrNil(this.fDI.Rwb)) && (!Util.isNullOrNil(this.fDI.SxP))) {
        break label877;
      }
      i = 1;
      label688:
      if ((!Util.isNullOrNil(this.fDI.Sze)) && (!Util.isNullOrNil(this.fDI.Szb))) {
        break label882;
      }
      j = 1;
      label716:
      if ((i != 0) || (j != 0)) {
        break label887;
      }
      dlD();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
      if (8 == getType()) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).aa(paramBundle, this.fNz.field_msgSvrId);
      }
      gm(4, 0);
      AppMethodBeat.o(27915);
      return;
      if (15 == getType())
      {
        setMMTitle(R.l.favorite_sight);
        findViewById(R.h.video_container).setBackgroundResource(R.e.black);
        break;
      }
      setMMTitle(R.l.favorite_file);
      break;
      label833:
      this.wOb.setImageResource(com.tencent.mm.pluginsdk.f.boX(this.fDI.Syc));
      break label409;
      label853:
      i = 2;
      break label584;
      label858:
      addIconOptionMenu(0, R.k.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27908);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RecordMsgFileUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(o paramAnonymous2o)
            {
              AppMethodBeat.i(27906);
              paramAnonymous2o.d(0, RecordMsgFileUI.this.getString(R.l.favorite_share_with_friend));
              String str = u.asq(p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
              if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).eBJ()) && (RecordMsgFileUI.i(RecordMsgFileUI.this) != null) && (HandOffFile.isSupportOpenFile(str))) {
                paramAnonymous2o.d(1, RecordMsgFileUI.this.getString(R.l.files_open_in_computer));
              }
              AppMethodBeat.o(27906);
            }
          };
          paramAnonymousMenuItem.ODU = new q.g()
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
                  if (!u.agG(paramAnonymous2MenuItem))
                  {
                    Log.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.l.favorite_share_file_not_exists), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                  if (new q(paramAnonymous2MenuItem).length() > RecordMsgFileUI.sQ())
                  {
                    Log.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.l.favorite_share_too_large), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                }
                RecordMsgFileUI.j(RecordMsgFileUI.this);
                AppMethodBeat.o(27907);
                return;
                if (RecordMsgFileUI.i(RecordMsgFileUI.this) != null) {
                  ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).f(RecordMsgFileUI.i(RecordMsgFileUI.this));
                }
              }
            }
          };
          paramAnonymousMenuItem.eik();
          AppMethodBeat.o(27908);
          return true;
        }
      });
      break label660;
      label877:
      i = 0;
      break label688;
      label882:
      j = 0;
      break label716;
      label887:
      if (!p.d(this.fDI, this.msgId)) {
        break label913;
      }
      enableOptionMenu(true);
      dlH();
    }
    label913:
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aVy(this.mediaId);
    if ((localObject == null) || (2 == ((j)localObject).field_status)) {
      dlF();
    }
    for (;;)
    {
      enableOptionMenu(false);
      break;
      if (4 == ((j)localObject).field_status)
      {
        dlD();
      }
      else if ((((j)localObject).field_status == 0) || (1 == ((j)localObject).field_status))
      {
        dlE();
      }
      else
      {
        Log.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        dlF();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27920);
    if (this.txH != null)
    {
      this.txH.setVideoCallback(null);
      this.txH.stop();
      this.txH.onDetach();
      if (bh.abL() != null) {
        bh.abL().aqm();
      }
    }
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    if (this.HEt != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.handoff.a.a.class)).d(this.HEt);
    }
    this.HEu.destory();
    AppMethodBeat.o(27920);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27922);
    super.onPause();
    if (this.txH != null) {
      this.txH.stop();
    }
    AppMethodBeat.o(27922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27921);
    super.onResume();
    if (this.txH != null) {
      this.txH.start();
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