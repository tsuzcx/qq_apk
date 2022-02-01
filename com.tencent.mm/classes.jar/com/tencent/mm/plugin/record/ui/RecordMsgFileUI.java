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
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecordMsgFileUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.d
{
  private static final long rIa;
  private bv dCi;
  private ajx dtI;
  private aq gKO;
  private TextView jiC;
  private TextView mdu;
  private String mediaId;
  private long msgId;
  private com.tencent.mm.pluginsdk.ui.tools.h oNV = null;
  private Button pOz;
  private ProgressBar progressBar;
  private Button rIb;
  private Button rIc;
  private MMImageView rId;
  private TextView rIe;
  private View rIf;
  private View rIg;
  private boolean rIk = false;
  private boolean rIo = false;
  private boolean rIp = false;
  private boolean sBD = false;
  private HandOffFile xIl;
  private n xIm;
  private boolean xIn;
  
  static
  {
    AppMethodBeat.i(186618);
    rIa = com.tencent.mm.n.b.acs();
    AppMethodBeat.o(186618);
  }
  
  private void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(27929);
    if ((1 == paramj.field_type) && ((paramj.field_fileType == com.tencent.mm.i.a.fKC) || (paramj.field_fileType == com.tencent.mm.i.a.MediaType_FILE)) && (this.sBD)) {
      try
      {
        long l = Long.valueOf(paramj.field_mediaId.split("@")[2]).longValue();
        bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(false, paramj.field_dataId, localbv.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(27929);
        return;
      }
      catch (Exception paramj) {}
    }
    AppMethodBeat.o(27929);
  }
  
  private void bpx()
  {
    AppMethodBeat.i(27927);
    if (this.rIo)
    {
      AppMethodBeat.o(27927);
      return;
    }
    this.rIo = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_fav_path", p.c(this.dtI, this.msgId));
    localIntent.putExtra("key_detail_fav_thumb_path", p.f(this.dtI, this.msgId));
    localIntent.putExtra("key_detail_fav_video_duration", this.dtI.duration);
    localIntent.putExtra("key_detail_statExtStr", this.dtI.dIA);
    localIntent.putExtra("key_detail_fav_video_scene_from", 1);
    localIntent.putExtra("key_detail_msg_uuid", this.dtI.ixk);
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
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27898);
          RecordMsgFileUI.o(RecordMsgFileUI.this).setProgress(j);
          RecordMsgFileUI.p(RecordMsgFileUI.this).setText(RecordMsgFileUI.this.getString(2131758872, new Object[] { bu.ba(i), bu.ba(k) }));
          AppMethodBeat.o(27898);
        }
      });
      AppMethodBeat.o(27925);
      return;
      k = (int)this.dtI.GzV;
      i = 0;
      j = 0;
    }
  }
  
  private void cys()
  {
    AppMethodBeat.i(27916);
    this.rIc.setVisibility(8);
    this.pOz.setVisibility(8);
    this.rIb.setVisibility(8);
    this.rIf.setVisibility(8);
    this.mdu.setVisibility(0);
    if (this.dtI.dataType == 4)
    {
      this.mdu.setGravity(17);
      this.mdu.setText(2131758941);
      AppMethodBeat.o(27916);
      return;
    }
    this.mdu.setGravity(17);
    this.mdu.setText(2131758940);
    if (!this.xIn)
    {
      this.xIn = true;
      fz(8, 6);
    }
    AppMethodBeat.o(27916);
  }
  
  private void cyt()
  {
    AppMethodBeat.i(27917);
    this.rIc.setVisibility(8);
    this.pOz.setVisibility(8);
    this.rIb.setVisibility(8);
    this.mdu.setVisibility(8);
    this.rIf.setVisibility(0);
    c(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(this.mediaId));
    AppMethodBeat.o(27917);
  }
  
  private void cyu()
  {
    AppMethodBeat.i(27918);
    this.rIf.setVisibility(8);
    this.rIb.setVisibility(8);
    if (bu.isNullOrNil(this.dtI.GzH)) {
      this.pOz.setVisibility(8);
    }
    for (;;)
    {
      this.rIc.setVisibility(0);
      this.rIc.setText(2131758918);
      this.mdu.setVisibility(8);
      AppMethodBeat.o(27918);
      return;
      this.pOz.setVisibility(0);
    }
  }
  
  private void cyw()
  {
    AppMethodBeat.i(27919);
    if (this.xIl.uPu != 1)
    {
      this.xIl.uPu = 1;
      this.xIl.aof(bu.nullAsNil(p.c(this.dtI, this.msgId)));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).g(this.xIl);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.xIl);
    }
    if ((getType() == 15) && (this.dtI.GAA != null) && (!bu.isNullOrNil(this.dtI.GAA.hET)) && (!bu.isNullOrNil(this.dtI.GAA.hEX)))
    {
      this.rIp = true;
      this.rId.setVisibility(8);
      this.rIf.setVisibility(8);
      this.rIc.setVisibility(8);
      this.pOz.setVisibility(8);
      this.rIb.setVisibility(8);
      this.mdu.setVisibility(8);
      String str = p.c(this.dtI, this.msgId);
      ae.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.abq() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131306317);
      this.oNV = t.hK(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.oNV, 0, localLayoutParams);
      this.oNV.setVideoCallback(new h.a()
      {
        public final int eU(int paramAnonymousInt1, int paramAnonymousInt2)
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
          com.tencent.mm.sdk.a.b.O(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dTw() + "[RecordMsgFileUI] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + bu.bI(str, "")).getBytes(), 2), "FullScreenPlaySight");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27909);
              Object localObject1 = (ImageView)RecordMsgFileUI.this.findViewById(2131306415);
              ((ImageView)localObject1).setImageBitmap(localBitmap);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              com.tencent.mm.sdk.platformtools.o.a(RecordMsgFileUI.this.getContext(), (Intent)localObject2, new k(str), "video/*");
              try
              {
                localObject1 = RecordMsgFileUI.this;
                localObject2 = Intent.createChooser((Intent)localObject2, RecordMsgFileUI.this.getString(2131759030));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((RecordMsgFileUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(27909);
                return;
              }
              catch (Exception localException)
              {
                ae.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
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
          ae.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.abq() + " onPrepared");
          RecordMsgFileUI.j(RecordMsgFileUI.this).setLoop(true);
          RecordMsgFileUI.j(RecordMsgFileUI.this).start();
          AppMethodBeat.o(27910);
        }
      });
      ae.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.abq() + " initView :" + str);
      if (str != null)
      {
        this.oNV.stop();
        this.oNV.setVideoPath(str);
      }
      ae.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.f.abq() + " initView");
      if (bc.MW() != null) {
        bc.MW().WD();
      }
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.rIp)
      {
        this.rIf.setVisibility(8);
        this.rIc.setVisibility(8);
        this.pOz.setVisibility(8);
        this.rIb.setVisibility(0);
        this.rIb.setText(2131758920);
        this.mdu.setVisibility(8);
        bpx();
        AppMethodBeat.o(27919);
      }
    }
    else
    {
      this.rIf.setVisibility(8);
      this.rIc.setVisibility(4);
      if (!bu.isNullOrNil(this.dtI.GzH)) {
        break label553;
      }
      this.pOz.setVisibility(8);
    }
    for (;;)
    {
      this.rIb.setVisibility(0);
      this.mdu.setVisibility(0);
      AppMethodBeat.o(27919);
      return;
      label553:
      this.pOz.setVisibility(0);
    }
  }
  
  private String dHO()
  {
    AppMethodBeat.i(27924);
    Object localObject = new k(p.f(this.dtI, this.msgId));
    if (((k)localObject).exists()) {}
    for (localObject = w.B(((k)localObject).fTh());; localObject = com.tencent.mm.model.c.aAa() + "web/" + com.tencent.mm.b.g.getMessageDigest(bu.bI(this.dtI.dox, "").getBytes()))
    {
      AppMethodBeat.o(27924);
      return localObject;
      localObject = new StringBuilder();
      bc.aCg();
    }
  }
  
  private void fz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27928);
    if (8 == getType()) {
      if (this.dtI.GzV <= 26214400L) {
        break label220;
      }
    }
    label220:
    for (int i = 7;; i = 5)
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1203L, paramInt2, 1L, false);
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.dtI.GzA, Integer.valueOf(i), Long.valueOf(this.dtI.GzV), Integer.valueOf(paramInt1), Long.valueOf((ch.aDb() - this.dCi.field_createTime) / 1000L), this.dtI.GzP, this.dCi.field_talker, Integer.valueOf(2), this.dtI.dua, Long.valueOf(this.dCi.field_msgSvrId), Long.valueOf(this.dCi.field_createTime) });
      ae.i("MicroMsg.RecordMsgFileUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(14665, str);
      AppMethodBeat.o(27928);
      return;
    }
  }
  
  private int getType()
  {
    int j = this.dtI.dataType;
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
      ae.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
      AppMethodBeat.o(27926);
      return;
    }
    ae.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[] { this.mediaId, paramj.field_mediaId });
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
      this.gKO.post(new Runnable()
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
      fz(0, 2);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1203L, 5L, this.dtI.GzV, false);
      AppMethodBeat.o(27926);
      return;
    case 4: 
      a(paramj, false);
      this.gKO.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27900);
          RecordMsgFileUI.r(RecordMsgFileUI.this);
          AppMethodBeat.o(27900);
        }
      });
      fz(1, 3);
      AppMethodBeat.o(27926);
      return;
    }
    this.gKO.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27901);
        RecordMsgFileUI.h(RecordMsgFileUI.this);
        com.tencent.mm.ui.base.h.cm(RecordMsgFileUI.this.getContext(), RecordMsgFileUI.this.getString(2131758104));
        AppMethodBeat.o(27901);
      }
    });
    a(paramj, false);
    fz(1, 4);
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
        ae.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27912);
            this.rDo.dismiss();
            AppMethodBeat.o(27912);
          }
        };
        if (!bu.isNullOrNil((String)localObject1)) {
          break label151;
        }
        AppMethodBeat.o(27923);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label151:
      Object localObject1 = bu.U(((String)localObject1).split(","));
      if ((getType() == 4) || (getType() == 15))
      {
        bc.ajU().aw(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27913);
            k localk = new k(p.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
            Iterator localIterator = this.xIp.iterator();
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              Object localObject1;
              if (localk.exists())
              {
                localObject1 = RecordMsgFileUI.n(RecordMsgFileUI.this);
                ae.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[] { w.B(localk.fTh()), localObject1 });
                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 15) {
                  com.tencent.mm.plugin.messenger.a.g.doC().a(RecordMsgFileUI.this.getContext(), str1, w.B(localk.fTh()), (String)localObject1, 62, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).ixk);
                }
              }
              for (;;)
              {
                com.tencent.mm.plugin.messenger.a.g.doC().hW(paramIntent, str1);
                break;
                com.tencent.mm.plugin.messenger.a.g.doC().a(RecordMsgFileUI.this.getContext(), str1, w.B(localk.fTh()), (String)localObject1, 1, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).ixk);
                continue;
                Object localObject2 = RecordMsgFileUI.a(RecordMsgFileUI.this).GzH;
                if (!bu.isNullOrNil((String)localObject2))
                {
                  localObject1 = new WXVideoObject();
                  ((WXVideoObject)localObject1).videoUrl = ((String)localObject2);
                  localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
                  String str2 = bu.bI(RecordMsgFileUI.a(RecordMsgFileUI.this).title, RecordMsgFileUI.this.getContext().getResources().getString(2131759030));
                  ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                  ((WXMediaMessage)localObject2).title = str2;
                  ((WXMediaMessage)localObject2).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
                  ((WXMediaMessage)localObject2).thumbData = bu.readFromFile(p.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
                  if (((WXMediaMessage)localObject2).thumbData == null)
                  {
                    localObject1 = new StringBuilder();
                    bc.aCg();
                    ((WXMediaMessage)localObject2).thumbData = bu.readFromFile(com.tencent.mm.model.c.aAa() + "web/" + com.tencent.mm.b.g.getMessageDigest(bu.bI(RecordMsgFileUI.a(RecordMsgFileUI.this).dox, "").getBytes()));
                  }
                  m.a((WXMediaMessage)localObject2, "", "", str1, 3, null);
                }
              }
            }
            RecordMsgFileUI.a(RecordMsgFileUI.this, 2, 7);
            ar.f(this.val$callback);
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
      bc.ajU().aw(new Runnable()
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
          ((WXMediaMessage)localObject1).thumbData = bu.readFromFile(p.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
          localObject2 = this.xIp.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            m.a((WXMediaMessage)localObject1, "", "", str, 3, null);
            com.tencent.mm.plugin.messenger.a.g.doC().hW(paramIntent, str);
          }
          ar.f(this.val$callback);
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
    this.gKO = new aq();
    this.xIm = new n();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dCi = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(this.msgId);
    paramBundle = getIntent().getStringExtra("record_data_id");
    Object localObject = p.awG(getIntent().getStringExtra("record_xml"));
    if (localObject == null)
    {
      ae.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    localObject = ((com.tencent.mm.protocal.b.a.c)localObject).hFT.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ajx localajx = (ajx)((Iterator)localObject).next();
      if (localajx.dua.equals(paramBundle)) {
        this.dtI = localajx;
      }
    }
    if (this.dtI == null)
    {
      ae.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    this.mediaId = p.g(this.dtI.dua, this.msgId, true);
    this.pOz = ((Button)findViewById(2131303391));
    this.rIb = ((Button)findViewById(2131303020));
    this.rIc = ((Button)findViewById(2131299195));
    this.rId = ((MMImageView)findViewById(2131300891));
    this.jiC = ((TextView)findViewById(2131302666));
    this.mdu = ((TextView)findViewById(2131305896));
    this.rIg = findViewById(2131299221);
    this.rIf = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.rIe = ((TextView)findViewById(2131299217));
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
      this.rId.setImageResource(2131689581);
      this.jiC.setText(this.dtI.title);
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
      this.rIb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27902);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
      localObject = this.dtI.GzH;
      if (!bu.isNullOrNil((String)localObject)) {
        this.pOz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27903);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", this.rIA);
            com.tencent.mm.br.d.b(RecordMsgFileUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27903);
          }
        });
      }
      this.rIc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27904);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!com.tencent.mm.compatible.util.e.abo())
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
      this.rIg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27905);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          RecordMsgFileUI.h(RecordMsgFileUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(27905);
        }
      });
      bc.aCg();
      localObject = com.tencent.mm.model.c.azI().ys(this.msgId);
      this.xIl = HandOffFile.a(this.dtI, null, (bv)localObject);
      this.xIl.doj = 1;
      boolean bool = p.d(this.dtI, this.msgId);
      localObject = this.xIl;
      if (!bool) {
        break label833;
      }
      i = 1;
      ((HandOffFile)localObject).uPu = i;
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).g(this.xIl);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.xIl);
      if ((getType() != 15) || (bu.aSB(com.tencent.mm.n.g.acL().getValue("SightForwardEnable")) == 1)) {
        break label838;
      }
      ae.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
      label640:
      if ((!bu.isNullOrNil(this.dtI.GzA)) && (!bu.isNullOrNil(this.dtI.GzC))) {
        break label857;
      }
      i = 1;
      label668:
      if ((!bu.isNullOrNil(this.dtI.GAS)) && (!bu.isNullOrNil(this.dtI.GAP))) {
        break label862;
      }
      j = 1;
      label696:
      if ((i != 0) || (j != 0)) {
        break label867;
      }
      cys();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
      if (8 == getType()) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aa(paramBundle, this.dCi.field_msgSvrId);
      }
      fz(4, 0);
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
      this.rId.setImageResource(com.tencent.mm.pluginsdk.f.aME(this.dtI.GzP));
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
          paramAnonymousMenuItem.LfS = new n.d()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27906);
              paramAnonymous2l.d(0, RecordMsgFileUI.this.getString(2131759001));
              AppMethodBeat.o(27906);
            }
          };
          paramAnonymousMenuItem.LfT = new n.e()
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
                  if (!com.tencent.mm.vfs.o.fB(paramAnonymous2MenuItem))
                  {
                    ae.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(2131758999), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                  if (new k(paramAnonymous2MenuItem).length() > RecordMsgFileUI.uP())
                  {
                    ae.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(2131759000), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                }
                RecordMsgFileUI.i(RecordMsgFileUI.this);
              }
            }
          };
          paramAnonymousMenuItem.cPF();
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
      if (!p.d(this.dtI, this.msgId)) {
        break label893;
      }
      enableOptionMenu(true);
      cyw();
    }
    label893:
    localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().awF(this.mediaId);
    if ((localObject == null) || (2 == ((j)localObject).field_status)) {
      cyu();
    }
    for (;;)
    {
      enableOptionMenu(false);
      break;
      if (4 == ((j)localObject).field_status)
      {
        cys();
      }
      else if ((((j)localObject).field_status == 0) || (1 == ((j)localObject).field_status))
      {
        cyt();
      }
      else
      {
        ae.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        cyu();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27920);
    if (this.oNV != null)
    {
      this.oNV.setVideoCallback(null);
      this.oNV.stop();
      this.oNV.onDetach();
      if (bc.MW() != null) {
        bc.MW().WC();
      }
    }
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    if (this.xIl != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.xIl);
    }
    this.xIm.destory();
    AppMethodBeat.o(27920);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27922);
    super.onPause();
    if (this.oNV != null) {
      this.oNV.stop();
    }
    AppMethodBeat.o(27922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27921);
    super.onResume();
    if (this.oNV != null) {
      this.oNV.start();
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