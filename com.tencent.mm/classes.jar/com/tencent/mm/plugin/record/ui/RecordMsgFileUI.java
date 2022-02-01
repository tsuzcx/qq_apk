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
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.an;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.pluginsdk.ui.tools.v;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecordMsgFileUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.d
{
  private static final long thH;
  private HandOffFile BIm;
  private n BIn;
  private boolean BIo;
  private aml dKT;
  private ca dTX;
  private MMHandler hAk;
  private TextView kgE;
  private String mediaId;
  private long msgId;
  private TextView nnM;
  private ProgressBar progressBar;
  private com.tencent.mm.pluginsdk.ui.tools.j qbJ = null;
  private Button reX;
  private Button thI;
  private Button thJ;
  private MMImageView thK;
  private TextView thL;
  private View thM;
  private View thN;
  private boolean thR = false;
  private boolean thV = false;
  private boolean thW = false;
  private boolean wir = false;
  
  static
  {
    AppMethodBeat.i(232043);
    thH = com.tencent.mm.n.c.aqr();
    AppMethodBeat.o(232043);
  }
  
  private void a(com.tencent.mm.plugin.record.a.j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(27929);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.i.a.gpO) || (paramj.field_fileType == com.tencent.mm.i.a.MediaType_FILE)) && (this.wir)) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        ca localca = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).a(false, paramj.field_dataId, localca.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(27929);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(27929);
  }
  
  private void bLd()
  {
    AppMethodBeat.i(27927);
    if (this.thV)
    {
      AppMethodBeat.o(27927);
      return;
    }
    this.thV = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_fav_path", p.c(this.dKT, this.msgId));
    localIntent.putExtra("key_detail_fav_thumb_path", p.f(this.dKT, this.msgId));
    localIntent.putExtra("key_detail_fav_video_duration", this.dKT.duration);
    localIntent.putExtra("key_detail_statExtStr", this.dKT.ean);
    localIntent.putExtra("key_detail_fav_video_scene_from", 1);
    localIntent.putExtra("key_detail_msg_uuid", this.dKT.jsz);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", localIntent);
    finish();
    AppMethodBeat.o(27927);
  }
  
  private void c(com.tencent.mm.plugin.record.a.j paramj)
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
      this.hAk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27898);
          RecordMsgFileUI.p(RecordMsgFileUI.this).setProgress(j);
          RecordMsgFileUI.q(RecordMsgFileUI.this).setText(RecordMsgFileUI.this.getString(2131759196, new Object[] { Util.getLengthStr(i), Util.getLengthStr(k) }));
          AppMethodBeat.o(27898);
        }
      });
      AppMethodBeat.o(27925);
      return;
      k = (int)this.dKT.LvI;
      i = 0;
      j = 0;
    }
  }
  
  private void cWA()
  {
    AppMethodBeat.i(27919);
    if (this.BIm.getFileStatus() != 1)
    {
      this.BIm.setFileStatus(1);
      this.BIm.setFullPath(Util.nullAsNil(p.c(this.dKT, this.msgId)));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.BIm);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).e(this.BIm);
    }
    if ((getType() == 15) && (this.dKT.Lwn != null) && (!Util.isNullOrNil(this.dKT.Lwn.iyZ)) && (!Util.isNullOrNil(this.dKT.Lwn.izd)))
    {
      this.thW = true;
      this.thK.setVisibility(8);
      this.thM.setVisibility(8);
      this.thJ.setVisibility(8);
      this.reX.setVisibility(8);
      this.thI.setVisibility(8);
      this.nnM.setVisibility(8);
      String str = p.c(this.dKT, this.msgId);
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.app() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131309736);
      this.qbJ = v.iE(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.qbJ, 0, localLayoutParams);
      this.qbJ.setVideoCallback(new j.a()
      {
        public final void eo(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int fh(int paramAnonymousInt1, int paramAnonymousInt2)
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
          CrashReportFactory.reportRawMessage(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.eVv() + "[RecordMsgFileUI] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + Util.nullAs(str, "")).getBytes(), 2), "FullScreenPlaySight");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27909);
              Object localObject1 = (ImageView)RecordMsgFileUI.this.findViewById(2131309846);
              ((ImageView)localObject1).setImageBitmap(localBitmap);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              FileProviderHelper.setIntentDataAndType(RecordMsgFileUI.this.getContext(), (Intent)localObject2, new o(str), "video/*", false);
              try
              {
                localObject1 = RecordMsgFileUI.this;
                localObject2 = Intent.createChooser((Intent)localObject2, RecordMsgFileUI.this.getString(2131759356));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((RecordMsgFileUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(27909);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.n(RecordMsgFileUI.this.getContext(), 2131759255, 2131759256);
                AppMethodBeat.o(27909);
              }
            }
          });
          AppMethodBeat.o(27911);
        }
        
        public final void tf()
        {
          AppMethodBeat.i(27910);
          Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.app() + " onPrepared");
          RecordMsgFileUI.k(RecordMsgFileUI.this).setLoop(true);
          RecordMsgFileUI.k(RecordMsgFileUI.this).start();
          AppMethodBeat.o(27910);
        }
      });
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.app() + " initView :" + str);
      if (str != null)
      {
        this.qbJ.stop();
        this.qbJ.setVideoPath(str);
      }
      Log.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.app() + " initView");
      if (bg.Xi() != null) {
        bg.Xi().akr();
      }
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.thW)
      {
        this.thM.setVisibility(8);
        this.thJ.setVisibility(8);
        this.reX.setVisibility(8);
        this.thI.setVisibility(0);
        this.thI.setText(2131759244);
        this.nnM.setVisibility(8);
        bLd();
        AppMethodBeat.o(27919);
      }
    }
    else
    {
      this.thM.setVisibility(8);
      this.thJ.setVisibility(4);
      if (!Util.isNullOrNil(this.dKT.Lvu)) {
        break label553;
      }
      this.reX.setVisibility(8);
    }
    for (;;)
    {
      this.thI.setVisibility(0);
      this.nnM.setVisibility(0);
      AppMethodBeat.o(27919);
      return;
      label553:
      this.reX.setVisibility(0);
    }
  }
  
  private void cWw()
  {
    AppMethodBeat.i(27916);
    this.thJ.setVisibility(8);
    this.reX.setVisibility(8);
    this.thI.setVisibility(8);
    this.thM.setVisibility(8);
    this.nnM.setVisibility(0);
    if (this.dKT.dataType == 4)
    {
      this.nnM.setGravity(17);
      this.nnM.setText(2131759265);
      AppMethodBeat.o(27916);
      return;
    }
    this.nnM.setGravity(17);
    this.nnM.setText(2131759264);
    if (!this.BIo)
    {
      this.BIo = true;
      fP(8, 6);
    }
    AppMethodBeat.o(27916);
  }
  
  private void cWx()
  {
    AppMethodBeat.i(27917);
    this.thJ.setVisibility(8);
    this.reX.setVisibility(8);
    this.thI.setVisibility(8);
    this.nnM.setVisibility(8);
    this.thM.setVisibility(0);
    c(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(this.mediaId));
    AppMethodBeat.o(27917);
  }
  
  private void cWy()
  {
    AppMethodBeat.i(27918);
    this.thM.setVisibility(8);
    this.thI.setVisibility(8);
    if (Util.isNullOrNil(this.dKT.Lvu)) {
      this.reX.setVisibility(8);
    }
    for (;;)
    {
      this.thJ.setVisibility(0);
      this.thJ.setText(2131759242);
      this.nnM.setVisibility(8);
      AppMethodBeat.o(27918);
      return;
      this.reX.setVisibility(0);
    }
  }
  
  private String eIB()
  {
    AppMethodBeat.i(27924);
    Object localObject = new o(p.f(this.dKT, this.msgId));
    if (((o)localObject).exists()) {}
    for (localObject = aa.z(((o)localObject).her());; localObject = com.tencent.mm.model.c.aTi() + "web/" + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(this.dKT.dFN, "").getBytes()))
    {
      AppMethodBeat.o(27924);
      return localObject;
      localObject = new StringBuilder();
      bg.aVF();
    }
  }
  
  private void fP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27928);
    if (8 == getType()) {
      if (this.dKT.LvI <= 26214400L) {
        break label220;
      }
    }
    label220:
    for (int i = 7;; i = 5)
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1203L, paramInt2, 1L, false);
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.dKT.KuR, Integer.valueOf(i), Long.valueOf(this.dKT.LvI), Integer.valueOf(paramInt1), Long.valueOf((cl.aWz() - this.dTX.field_createTime) / 1000L), this.dKT.LvC, this.dTX.field_talker, Integer.valueOf(2), this.dKT.dLl, Long.valueOf(this.dTX.field_msgSvrId), Long.valueOf(this.dTX.field_createTime) });
      Log.i("MicroMsg.RecordMsgFileUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(14665, str);
      AppMethodBeat.o(27928);
      return;
    }
  }
  
  private int getType()
  {
    int j = this.dKT.dataType;
    int i = j;
    if (j == 15) {
      i = 4;
    }
    return i;
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.j paramj)
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
      this.hAk.post(new Runnable()
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
      fP(0, 2);
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1203L, 5L, this.dKT.LvI, false);
      AppMethodBeat.o(27926);
      return;
    case 4: 
      a(paramj, false);
      this.hAk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27900);
          RecordMsgFileUI.s(RecordMsgFileUI.this);
          AppMethodBeat.o(27900);
        }
      });
      fP(1, 3);
      AppMethodBeat.o(27926);
      return;
    }
    this.hAk.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27901);
        RecordMsgFileUI.h(RecordMsgFileUI.this);
        com.tencent.mm.ui.base.h.cD(RecordMsgFileUI.this.getContext(), RecordMsgFileUI.this.getString(2131758370));
        AppMethodBeat.o(27901);
      }
    });
    a(paramj, false);
    fP(1, 4);
    AppMethodBeat.o(27926);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494177;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(27923);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.pluginsdk.ui.tools.a.a(this, paramInt1, paramInt2, paramIntent, true, 2131758379, 2131758380, 5);
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
        localObject2 = com.tencent.mm.ui.base.h.a(getContext(), getString(2131759230), false, null);
        Log.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27912);
            this.tcT.dismiss();
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
        bg.aAk().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27913);
            o localo = new o(p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
            Iterator localIterator = this.BIq.iterator();
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              Object localObject1;
              if (localo.exists())
              {
                localObject1 = RecordMsgFileUI.o(RecordMsgFileUI.this);
                Log.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[] { aa.z(localo.her()), localObject1 });
                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 15) {
                  com.tencent.mm.plugin.messenger.a.g.eir().a(RecordMsgFileUI.this.getContext(), str1, aa.z(localo.her()), (String)localObject1, 62, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).jsz);
                }
              }
              for (;;)
              {
                com.tencent.mm.plugin.messenger.a.g.eir().iF(paramIntent, str1);
                break;
                com.tencent.mm.plugin.messenger.a.g.eir().a(RecordMsgFileUI.this.getContext(), str1, aa.z(localo.her()), (String)localObject1, 1, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).jsz);
                continue;
                Object localObject2 = RecordMsgFileUI.a(RecordMsgFileUI.this).Lvu;
                if (!Util.isNullOrNil((String)localObject2))
                {
                  localObject1 = new WXVideoObject();
                  ((WXVideoObject)localObject1).videoUrl = ((String)localObject2);
                  localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
                  String str2 = Util.nullAs(RecordMsgFileUI.a(RecordMsgFileUI.this).title, RecordMsgFileUI.this.getContext().getResources().getString(2131759356));
                  ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                  ((WXMediaMessage)localObject2).title = str2;
                  ((WXMediaMessage)localObject2).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
                  ((WXMediaMessage)localObject2).thumbData = Util.readFromFile(p.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
                  if (((WXMediaMessage)localObject2).thumbData == null)
                  {
                    localObject1 = new StringBuilder();
                    bg.aVF();
                    ((WXMediaMessage)localObject2).thumbData = Util.readFromFile(com.tencent.mm.model.c.aTi() + "web/" + com.tencent.mm.b.g.getMessageDigest(Util.nullAs(RecordMsgFileUI.a(RecordMsgFileUI.this).dFN, "").getBytes()));
                  }
                  com.tencent.mm.pluginsdk.model.app.m.a((WXMediaMessage)localObject2, "", "", str1, 3, null);
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
      bg.aAk().postToWorker(new Runnable()
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
          localObject2 = this.BIq.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            com.tencent.mm.pluginsdk.model.app.m.a((WXMediaMessage)localObject1, "", "", str, 3, null);
            com.tencent.mm.plugin.messenger.a.g.eir().iF(paramIntent, str);
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
    this.hAk = new MMHandler();
    this.BIn = new n();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dTX = ((l)com.tencent.mm.kernel.g.af(l.class)).eiy().Hb(this.msgId);
    paramBundle = getIntent().getStringExtra("record_data_id");
    Object localObject = p.aKY(getIntent().getStringExtra("record_xml"));
    if (localObject == null)
    {
      Log.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    localObject = ((com.tencent.mm.protocal.b.a.c)localObject).iAd.iterator();
    while (((Iterator)localObject).hasNext())
    {
      aml localaml = (aml)((Iterator)localObject).next();
      if (localaml.dLl.equals(paramBundle)) {
        this.dKT = localaml;
      }
    }
    if (this.dKT == null)
    {
      Log.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    this.mediaId = p.g(this.dKT.dLl, this.msgId, true);
    this.reX = ((Button)findViewById(2131306105));
    this.thI = ((Button)findViewById(2131305616));
    this.thJ = ((Button)findViewById(2131299751));
    this.thK = ((MMImageView)findViewById(2131302497));
    this.kgE = ((TextView)findViewById(2131305220));
    this.nnM = ((TextView)findViewById(2131309187));
    this.thN = findViewById(2131299784);
    this.thM = findViewById(2131299778);
    this.progressBar = ((ProgressBar)findViewById(2131299776));
    this.thL = ((TextView)findViewById(2131299780));
    label393:
    int i;
    label568:
    int j;
    if (4 == getType())
    {
      setMMTitle(2131759356);
      if (getType() != 4) {
        break label817;
      }
      this.thK.setImageResource(2131689584);
      this.kgE.setText(this.dKT.title);
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
      this.thI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27902);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      localObject = this.dKT.Lvu;
      if (!Util.isNullOrNil((String)localObject)) {
        this.reX.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27903);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", this.tii);
            com.tencent.mm.br.c.b(RecordMsgFileUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27903);
          }
        });
      }
      this.thJ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27904);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!com.tencent.mm.compatible.util.e.apn())
          {
            com.tencent.mm.ui.base.h.n(RecordMsgFileUI.this.getContext(), 2131759258, 2131755998);
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
      this.thN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27905);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          RecordMsgFileUI.h(RecordMsgFileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27905);
        }
      });
      bg.aVF();
      localObject = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
      this.BIm = HandOffFile.fromFavItem(this.dKT, null, (ca)localObject, com.tencent.mm.plugin.fav.a.b.d(null));
      this.BIm.setSource(1);
      boolean bool = p.d(this.dKT, this.msgId);
      localObject = this.BIm;
      if (!bool) {
        break label837;
      }
      i = 1;
      ((HandOffFile)localObject).setFileStatus(i);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(this.BIm);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).c(this.BIm);
      if ((getType() != 15) || (Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SightForwardEnable")) == 1)) {
        break label842;
      }
      Log.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
      label644:
      if ((!Util.isNullOrNil(this.dKT.KuR)) && (!Util.isNullOrNil(this.dKT.Lvp))) {
        break label861;
      }
      i = 1;
      label672:
      if ((!Util.isNullOrNil(this.dKT.LwF)) && (!Util.isNullOrNil(this.dKT.LwC))) {
        break label866;
      }
      j = 1;
      label700:
      if ((i != 0) || (j != 0)) {
        break label871;
      }
      cWw();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
      if (8 == getType()) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).Z(paramBundle, this.dTX.field_msgSvrId);
      }
      fP(4, 0);
      AppMethodBeat.o(27915);
      return;
      if (15 == getType())
      {
        setMMTitle(2131759327);
        findViewById(2131309736).setBackgroundResource(2131100042);
        break;
      }
      setMMTitle(2131759228);
      break;
      label817:
      this.thK.setImageResource(com.tencent.mm.pluginsdk.f.bcX(this.dKT.LvC));
      break label393;
      label837:
      i = 2;
      break label568;
      label842:
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(27908);
          paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(RecordMsgFileUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
            {
              AppMethodBeat.i(27906);
              paramAnonymous2m.d(0, RecordMsgFileUI.this.getString(2131759326));
              String str = s.akC(p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
              if ((((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).dYl()) && (RecordMsgFileUI.i(RecordMsgFileUI.this) != null) && (HandOffFile.isSupportOpenFile(str))) {
                paramAnonymous2m.d(1, RecordMsgFileUI.this.getString(2131759414));
              }
              AppMethodBeat.o(27906);
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
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
                  if (!s.YS(paramAnonymous2MenuItem))
                  {
                    Log.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(2131759324), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                  if (new o(paramAnonymous2MenuItem).length() > RecordMsgFileUI.uV())
                  {
                    Log.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(2131759325), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                }
                RecordMsgFileUI.j(RecordMsgFileUI.this);
                AppMethodBeat.o(27907);
                return;
                if (RecordMsgFileUI.i(RecordMsgFileUI.this) != null) {
                  ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).f(RecordMsgFileUI.i(RecordMsgFileUI.this));
                }
              }
            }
          };
          paramAnonymousMenuItem.dGm();
          AppMethodBeat.o(27908);
          return true;
        }
      });
      break label644;
      label861:
      i = 0;
      break label672;
      label866:
      j = 0;
      break label700;
      label871:
      if (!p.d(this.dKT, this.msgId)) {
        break label897;
      }
      enableOptionMenu(true);
      cWA();
    }
    label897:
    localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aKX(this.mediaId);
    if ((localObject == null) || (2 == ((com.tencent.mm.plugin.record.a.j)localObject).field_status)) {
      cWy();
    }
    for (;;)
    {
      enableOptionMenu(false);
      break;
      if (4 == ((com.tencent.mm.plugin.record.a.j)localObject).field_status)
      {
        cWw();
      }
      else if ((((com.tencent.mm.plugin.record.a.j)localObject).field_status == 0) || (1 == ((com.tencent.mm.plugin.record.a.j)localObject).field_status))
      {
        cWx();
      }
      else
      {
        Log.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        cWy();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27920);
    if (this.qbJ != null)
    {
      this.qbJ.setVideoCallback(null);
      this.qbJ.stop();
      this.qbJ.onDetach();
      if (bg.Xi() != null) {
        bg.Xi().akq();
      }
    }
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    if (this.BIm != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.handoff.a.a.class)).d(this.BIm);
    }
    this.BIn.destory();
    AppMethodBeat.o(27920);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27922);
    super.onPause();
    if (this.qbJ != null) {
      this.qbJ.stop();
    }
    AppMethodBeat.o(27922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27921);
    super.onResume();
    if (this.qbJ != null) {
      this.qbJ.start();
    }
    AppMethodBeat.o(27921);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgFileUI
 * JD-Core Version:    0.7.0.1
 */