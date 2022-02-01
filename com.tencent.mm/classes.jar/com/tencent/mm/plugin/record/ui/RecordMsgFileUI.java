package com.tencent.mm.plugin.record.ui;

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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.model.o;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.pluginsdk.ui.tools.w;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;

public class RecordMsgFileUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.d
{
  private static final long AkA;
  private Button AkB;
  private Button AkC;
  private MMImageView AkD;
  private TextView AkE;
  private View AkF;
  private View AkG;
  private boolean AkK = false;
  private boolean AkO = false;
  private boolean AkP = false;
  private boolean Gud = false;
  private HandOffFile NBV;
  private o NBW;
  private boolean NBX;
  private arf hIy;
  private cc hTm;
  private MMHandler mRi;
  private String mediaId;
  private long msgId;
  private TextView pUL;
  private ProgressBar progressBar;
  private TextView ttU;
  private com.tencent.mm.pluginsdk.ui.tools.i wCd = null;
  private Button xQS;
  
  static
  {
    AppMethodBeat.i(305365);
    AkA = com.tencent.mm.k.c.aRk();
    AppMethodBeat.o(305365);
  }
  
  private void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(27929);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.g.a.lwb) || (paramj.field_fileType == com.tencent.mm.g.a.MediaType_FILE)) && (this.Gud)) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        cc localcc = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(l);
        ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).a(false, paramj.field_dataId, localcc.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(27929);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(27929);
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
      this.mRi.post(new Runnable()
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
      k = (int)this.hIy.Zza;
      i = 0;
      j = 0;
    }
  }
  
  private void cxo()
  {
    AppMethodBeat.i(27927);
    if (this.AkO)
    {
      AppMethodBeat.o(27927);
      return;
    }
    this.AkO = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_fav_path", q.c(this.hIy, this.msgId));
    localIntent.putExtra("key_detail_fav_thumb_path", q.f(this.hIy, this.msgId));
    localIntent.putExtra("key_detail_fav_video_duration", this.hIy.duration);
    localIntent.putExtra("key_detail_statExtStr", this.hIy.iah);
    localIntent.putExtra("key_detail_fav_video_scene_from", 1);
    localIntent.putExtra("key_detail_msg_uuid", this.hIy.pbn);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", localIntent);
    finish();
    AppMethodBeat.o(27927);
  }
  
  private void dSt()
  {
    AppMethodBeat.i(27916);
    this.AkC.setVisibility(8);
    this.xQS.setVisibility(8);
    this.AkB.setVisibility(8);
    this.AkF.setVisibility(8);
    this.ttU.setVisibility(0);
    if (this.hIy.dataType == 4)
    {
      this.ttU.setGravity(17);
      this.ttU.setText(R.l.favorite_out_of_date_video);
      AppMethodBeat.o(27916);
      return;
    }
    this.ttU.setGravity(17);
    this.ttU.setText(R.l.favorite_out_of_date_file);
    if (!this.NBX)
    {
      this.NBX = true;
      hf(8, 6);
    }
    AppMethodBeat.o(27916);
  }
  
  private void dSu()
  {
    AppMethodBeat.i(27917);
    this.AkC.setVisibility(8);
    this.xQS.setVisibility(8);
    this.AkB.setVisibility(8);
    this.ttU.setVisibility(8);
    this.AkF.setVisibility(0);
    c(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(this.mediaId));
    AppMethodBeat.o(27917);
  }
  
  private void dSv()
  {
    AppMethodBeat.i(27918);
    this.AkF.setVisibility(8);
    this.AkB.setVisibility(8);
    if (Util.isNullOrNil(this.hIy.ZyM)) {
      this.xQS.setVisibility(8);
    }
    for (;;)
    {
      this.AkC.setVisibility(0);
      this.AkC.setText(R.l.favorite_item_download);
      this.ttU.setVisibility(8);
      AppMethodBeat.o(27918);
      return;
      this.xQS.setVisibility(0);
    }
  }
  
  private void dSx()
  {
    AppMethodBeat.i(27919);
    if (this.NBV.getFileStatus() != 1)
    {
      this.NBV.setFileStatus(1);
      this.NBV.setFullPath(Util.nullAsNil(q.c(this.hIy, this.msgId)));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).g(this.NBV);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).e(this.NBV);
    }
    if ((getType() == 15) && (this.hIy.ZzE != null) && (!Util.isNullOrNil(this.hIy.ZzE.nTu)) && (!Util.isNullOrNil(this.hIy.ZzE.nTy)))
    {
      this.AkP = true;
      this.AkD.setVisibility(8);
      this.AkF.setVisibility(8);
      this.AkC.setVisibility(8);
      this.xQS.setVisibility(8);
      this.AkB.setVisibility(8);
      this.ttU.setVisibility(8);
      String str = q.c(this.hIy, this.msgId);
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.aPW() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(R.h.video_container);
      this.wCd = w.lG(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.wCd, 0, localLayoutParams);
      this.wCd.setVideoCallback(new i.a()
      {
        public final void Qz()
        {
          AppMethodBeat.i(27910);
          Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.aPW() + " onPrepared");
          RecordMsgFileUI.k(RecordMsgFileUI.this).setLoop(true);
          RecordMsgFileUI.k(RecordMsgFileUI.this).start();
          AppMethodBeat.o(27910);
        }
        
        public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int gw(int paramAnonymousInt1, int paramAnonymousInt2)
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
          CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.f.gYr() + "[RecordMsgFileUI] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + Util.nullAs(str, "")).getBytes(), 2), "FullScreenPlaySight");
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
              FileProviderHelper.setIntentDataAndType(RecordMsgFileUI.this.getContext(), (Intent)localObject2, new u(str), "video/*", false);
              try
              {
                localObject1 = RecordMsgFileUI.this;
                localObject2 = Intent.createChooser((Intent)localObject2, RecordMsgFileUI.this.getString(R.l.favorite_video));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((RecordMsgFileUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(27909);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                k.s(RecordMsgFileUI.this.getContext(), R.l.favorite_no_match_msg, R.l.favorite_no_match_title);
                AppMethodBeat.o(27909);
              }
            }
          });
          AppMethodBeat.o(27911);
        }
      });
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.aPW() + " initView :" + str);
      if (str != null)
      {
        this.wCd.stop();
        this.wCd.setVideoPath(str);
      }
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.aPW() + " initView");
      if (bh.aDI() != null) {
        bh.aDI().aKl();
      }
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.AkP)
      {
        this.AkF.setVisibility(8);
        this.AkC.setVisibility(8);
        this.xQS.setVisibility(8);
        this.AkB.setVisibility(0);
        this.AkB.setText(R.l.favorite_item_preview);
        this.ttU.setVisibility(8);
        cxo();
        AppMethodBeat.o(27919);
      }
    }
    else
    {
      this.AkF.setVisibility(8);
      this.AkC.setVisibility(4);
      if (!Util.isNullOrNil(this.hIy.ZyM)) {
        break label553;
      }
      this.xQS.setVisibility(8);
    }
    for (;;)
    {
      this.AkB.setVisibility(0);
      this.ttU.setVisibility(0);
      AppMethodBeat.o(27919);
      return;
      label553:
      this.xQS.setVisibility(0);
    }
  }
  
  private String gGw()
  {
    AppMethodBeat.i(27924);
    Object localObject = new u(q.f(this.hIy, this.msgId));
    if (((u)localObject).jKS()) {}
    for (localObject = ah.v(((u)localObject).jKT());; localObject = com.tencent.mm.model.c.bzV() + "web/" + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(this.hIy.hDd, "").getBytes()))
    {
      AppMethodBeat.o(27924);
      return localObject;
      localObject = new StringBuilder();
      bh.bCz();
    }
  }
  
  private int getType()
  {
    int j = this.hIy.dataType;
    int i = j;
    if (j == 15) {
      i = 4;
    }
    return i;
  }
  
  private void hf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27928);
    if (8 == getType()) {
      if (this.hIy.Zza <= 26214400L) {
        break label238;
      }
    }
    label238:
    for (int i = 7;; i = 5)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1203L, paramInt2, 1L, false);
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.hIy.Ysw, Integer.valueOf(i), Long.valueOf(this.hIy.Zza), Integer.valueOf(paramInt1), Long.valueOf((cn.bDv() - this.hTm.getCreateTime()) / 1000L), this.hIy.ZyU, this.hTm.field_talker, Integer.valueOf(2), this.hIy.hIQ, Long.valueOf(this.hTm.field_msgSvrId), Long.valueOf(this.hTm.getCreateTime()), Long.valueOf(cn.bDu()), Integer.valueOf(1) });
      Log.i("MicroMsg.RecordMsgFileUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(14665, str);
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
      this.mRi.post(new Runnable()
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
      hf(0, 2);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1203L, 5L, this.hIy.Zza, false);
      AppMethodBeat.o(27926);
      return;
    case 4: 
      a(paramj, false);
      this.mRi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27900);
          RecordMsgFileUI.s(RecordMsgFileUI.this);
          AppMethodBeat.o(27900);
        }
      });
      hf(1, 3);
      AppMethodBeat.o(27926);
      return;
    }
    this.mRi.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27901);
        RecordMsgFileUI.h(RecordMsgFileUI.this);
        k.cZ(RecordMsgFileUI.this.getContext(), RecordMsgFileUI.this.getString(R.l.download_fail));
        AppMethodBeat.o(27901);
      }
    });
    a(paramj, false);
    hf(1, 4);
    AppMethodBeat.o(27926);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return R.i.gjS;
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
        localObject2 = k.a(getContext(), getString(R.l.favorite_forward_tips), false, null);
        Log.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27912);
            this.Afz.dismiss();
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
        bh.baH().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27913);
            u localu = new u(q.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
            Iterator localIterator = this.NBZ.iterator();
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              Object localObject1;
              if (localu.jKS())
              {
                localObject1 = RecordMsgFileUI.o(RecordMsgFileUI.this);
                Log.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[] { ah.v(localu.jKT()), localObject1 });
                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 15) {
                  com.tencent.mm.plugin.messenger.a.g.gaI().a(RecordMsgFileUI.this.getContext(), str1, ah.v(localu.jKT()), (String)localObject1, 62, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).pbn);
                }
              }
              for (;;)
              {
                com.tencent.mm.plugin.messenger.a.g.gaI().ke(paramIntent, str1);
                break;
                com.tencent.mm.plugin.messenger.a.g.gaI().a(RecordMsgFileUI.this.getContext(), str1, ah.v(localu.jKT()), (String)localObject1, 1, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).pbn);
                continue;
                Object localObject2 = RecordMsgFileUI.a(RecordMsgFileUI.this).ZyM;
                if (!Util.isNullOrNil((String)localObject2))
                {
                  localObject1 = new WXVideoObject();
                  ((WXVideoObject)localObject1).videoUrl = ((String)localObject2);
                  localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
                  String str2 = Util.nullAs(RecordMsgFileUI.a(RecordMsgFileUI.this).title, RecordMsgFileUI.this.getContext().getResources().getString(R.l.favorite_video));
                  ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                  ((WXMediaMessage)localObject2).title = str2;
                  ((WXMediaMessage)localObject2).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
                  ((WXMediaMessage)localObject2).thumbData = Util.readFromFile(q.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
                  if (((WXMediaMessage)localObject2).thumbData == null)
                  {
                    localObject1 = new StringBuilder();
                    bh.bCz();
                    ((WXMediaMessage)localObject2).thumbData = Util.readFromFile(com.tencent.mm.model.c.bzV() + "web/" + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(RecordMsgFileUI.a(RecordMsgFileUI.this).hDd, "").getBytes()));
                  }
                  com.tencent.mm.pluginsdk.model.app.n.a((WXMediaMessage)localObject2, "", "", str1, 3, null);
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
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27896);
          Object localObject1 = q.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          Object localObject2 = new WXFileObject();
          ((WXFileObject)localObject2).setFilePath((String)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          ((WXMediaMessage)localObject1).title = RecordMsgFileUI.a(RecordMsgFileUI.this).title;
          ((WXMediaMessage)localObject1).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
          ((WXMediaMessage)localObject1).thumbData = Util.readFromFile(q.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
          localObject2 = this.NBZ.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            com.tencent.mm.pluginsdk.model.app.n.a((WXMediaMessage)localObject1, "", "", str, 3, null);
            com.tencent.mm.plugin.messenger.a.g.gaI().ke(paramIntent, str);
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
    this.mRi = new MMHandler();
    this.NBW = new o();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.hTm = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().sl(this.msgId);
    paramBundle = getIntent().getStringExtra("record_data_id");
    if (this.hTm == null)
    {
      Log.w("MicroMsg.RecordMsgFileUI", "get record msg data error, msg null");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    this.hIy = q.lh(getIntent().getStringExtra("record_xml"), paramBundle);
    if (this.hIy == null)
    {
      localObject = k.b.aP(this.hTm.field_content, this.hTm.field_reserved);
      if (localObject == null)
      {
        Log.w("MicroMsg.RecordMsgFileUI", "get record msg data error, content null");
        finish();
        AppMethodBeat.o(27915);
        return;
      }
      this.hIy = q.lh(((k.b)localObject).nRF, paramBundle);
    }
    if (this.hIy == null)
    {
      Log.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    this.mediaId = q.f(this.hIy.hIQ, this.msgId, true);
    this.xQS = ((Button)findViewById(R.h.preview_btn));
    this.AkB = ((Button)findViewById(R.h.open_btn));
    this.AkC = ((Button)findViewById(R.h.download_btn));
    this.AkD = ((MMImageView)findViewById(R.h.icon_iv));
    this.pUL = ((TextView)findViewById(R.h.name_tv));
    this.ttU = ((TextView)findViewById(R.h.tips_tv));
    this.AkG = findViewById(R.h.download_stop_btn);
    this.AkF = findViewById(R.h.download_progress_area);
    this.progressBar = ((ProgressBar)findViewById(R.h.download_pb));
    this.AkE = ((TextView)findViewById(R.h.download_progress_tips));
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
      this.AkD.setImageResource(R.k.app_attach_file_icon_video);
      this.pUL.setText(this.hIy.title);
      setBackBtn(new RecordMsgFileUI.1(this));
      this.AkB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27902);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramAnonymousView = q.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
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
      localObject = this.hIy.ZyM;
      if (!Util.isNullOrNil((String)localObject)) {
        this.xQS.setOnClickListener(new RecordMsgFileUI.8(this, (String)localObject));
      }
      this.AkC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27904);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!com.tencent.mm.compatible.util.e.aPU())
          {
            k.s(RecordMsgFileUI.this.getContext(), R.l.favorite_no_sdcard, R.l.app_tip);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27904);
            return;
          }
          q.b(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this), true);
          RecordMsgFileUI.f(RecordMsgFileUI.this);
          RecordMsgFileUI.g(RecordMsgFileUI.this);
          RecordMsgFileUI.a(RecordMsgFileUI.this, 7, 1);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27904);
        }
      });
      this.AkG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27905);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          RecordMsgFileUI.h(RecordMsgFileUI.this);
          q.g(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27905);
        }
      });
      bh.bCz();
      localObject = com.tencent.mm.model.c.bzD().sl(this.msgId);
      this.NBV = HandOffFile.fromFavItem(this.hIy, null, (cc)localObject, com.tencent.mm.plugin.fav.a.b.d(null));
      this.NBV.setSource(1);
      boolean bool = q.d(this.hIy, this.msgId);
      localObject = this.NBV;
      if (!bool) {
        break label853;
      }
      i = 1;
      ((HandOffFile)localObject).setFileStatus(i);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).g(this.NBV);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).c(this.NBV);
      if ((getType() != 15) || (Util.safeParseInt(com.tencent.mm.k.i.aRC().getValue("SightForwardEnable")) == 1)) {
        break label858;
      }
      Log.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
      label660:
      if ((!Util.isNullOrNil(this.hIy.Ysw)) && (!Util.isNullOrNil(this.hIy.ZyH))) {
        break label877;
      }
      i = 1;
      label688:
      if ((!Util.isNullOrNil(this.hIy.ZzW)) && (!Util.isNullOrNil(this.hIy.ZzT))) {
        break label882;
      }
      j = 1;
      label716:
      if ((i != 0) || (j != 0)) {
        break label887;
      }
      dSt();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
      if (8 == getType()) {
        ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).ae(paramBundle, this.hTm.field_msgSvrId);
      }
      hf(4, 0);
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
      this.AkD.setImageResource(com.tencent.mm.pluginsdk.f.boR(this.hIy.ZyU));
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
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.f(RecordMsgFileUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(27906);
              paramAnonymous2s.c(0, RecordMsgFileUI.this.getString(R.l.favorite_share_with_friend));
              String str = y.alV(q.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
              if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).fJL()) && (RecordMsgFileUI.i(RecordMsgFileUI.this) != null) && (HandOffFile.isSupportOpenFile(str))) {
                paramAnonymous2s.c(1, RecordMsgFileUI.this.getString(R.l.files_open_in_computer));
              }
              AppMethodBeat.o(27906);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
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
                  paramAnonymous2MenuItem = q.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
                  if (!y.ZC(paramAnonymous2MenuItem))
                  {
                    Log.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.l.favorite_share_file_not_exists), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                  if (new u(paramAnonymous2MenuItem).length() > RecordMsgFileUI.Su())
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
                  ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).f(RecordMsgFileUI.i(RecordMsgFileUI.this));
                }
              }
            }
          };
          paramAnonymousMenuItem.dDn();
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
      if (!q.d(this.hIy, this.msgId)) {
        break label913;
      }
      enableOptionMenu(true);
      dSx();
    }
    label913:
    Object localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aSG(this.mediaId);
    if ((localObject == null) || (2 == ((j)localObject).field_status)) {
      dSv();
    }
    for (;;)
    {
      enableOptionMenu(false);
      break;
      if (4 == ((j)localObject).field_status)
      {
        dSt();
      }
      else if ((((j)localObject).field_status == 0) || (1 == ((j)localObject).field_status))
      {
        dSu();
      }
      else
      {
        Log.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        dSv();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27920);
    if (this.wCd != null)
    {
      this.wCd.setVideoCallback(null);
      this.wCd.stop();
      this.wCd.onDetach();
      if (bh.aDI() != null) {
        bh.aDI().aKk();
      }
    }
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    if (this.NBV != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).d(this.NBV);
    }
    this.NBW.destory();
    AppMethodBeat.o(27920);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27922);
    super.onPause();
    if (this.wCd != null) {
      this.wCd.stop();
    }
    AppMethodBeat.o(27922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27921);
    super.onResume();
    if (this.wCd != null) {
      this.wCd.start();
    }
    AppMethodBeat.o(27921);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI
 * JD-Core Version:    0.7.0.1
 */