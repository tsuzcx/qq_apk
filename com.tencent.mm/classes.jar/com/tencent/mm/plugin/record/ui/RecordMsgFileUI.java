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
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecordMsgFileUI
  extends MMActivity
  implements com.tencent.mm.plugin.record.a.d
{
  private agx dhe;
  private bo dpq;
  private ao gox;
  private TextView iMz;
  private TextView lzD;
  private String mediaId;
  private long msgId;
  private com.tencent.mm.pluginsdk.ui.tools.h odZ = null;
  private Button pet;
  private ProgressBar progressBar;
  private Button qPQ;
  private Button qPR;
  private MMImageView qPS;
  private TextView qPT;
  private View qPU;
  private View qPV;
  private boolean qPZ = false;
  private boolean qQd = false;
  private boolean qQe = false;
  private boolean rzJ = false;
  private HandOffFile wku;
  private com.tencent.mm.plugin.record.b.l wkv;
  private boolean wkw;
  
  private void a(com.tencent.mm.plugin.record.a.i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(27929);
    if ((1 == parami.field_type) && ((parami.field_fileType == com.tencent.mm.i.a.fqr) || (parami.field_fileType == com.tencent.mm.i.a.MediaType_FILE)) && (this.rzJ)) {
      try
      {
        long l = Long.valueOf(parami.field_mediaId.split("@")[2]).longValue();
        bo localbo = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(l);
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).a(false, parami.field_dataId, localbo.field_msgSvrId, paramBoolean);
        AppMethodBeat.o(27929);
        return;
      }
      catch (Exception parami) {}
    }
    AppMethodBeat.o(27929);
  }
  
  private void blc()
  {
    AppMethodBeat.i(27927);
    if (this.qQd)
    {
      AppMethodBeat.o(27927);
      return;
    }
    this.qQd = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("key_detail_fav_path", n.c(this.dhe, this.msgId));
    localIntent.putExtra("key_detail_fav_thumb_path", n.f(this.dhe, this.msgId));
    localIntent.putExtra("key_detail_fav_video_duration", this.dhe.duration);
    localIntent.putExtra("key_detail_statExtStr", this.dhe.dvs);
    localIntent.putExtra("key_detail_fav_video_scene_from", 1);
    localIntent.putExtra("key_detail_msg_uuid", this.dhe.iaU);
    com.tencent.mm.plugin.fav.a.b.b(this, ".ui.detail.FavoriteVideoPlayUI", localIntent);
    finish();
    AppMethodBeat.o(27927);
  }
  
  private void c(com.tencent.mm.plugin.record.a.i parami)
  {
    AppMethodBeat.i(27925);
    final int j;
    final int i;
    final int k;
    if (parami != null)
    {
      j = (int)(parami.field_offset / Math.max(1, parami.field_totalLen) * 100.0F);
      i = parami.field_offset;
      k = parami.field_totalLen;
    }
    for (;;)
    {
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27898);
          RecordMsgFileUI.o(RecordMsgFileUI.this).setProgress(j);
          RecordMsgFileUI.p(RecordMsgFileUI.this).setText(RecordMsgFileUI.this.getString(2131758872, new Object[] { bs.aX(i), bs.aX(k) }));
          AppMethodBeat.o(27898);
        }
      });
      AppMethodBeat.o(27925);
      return;
      k = (int)this.dhe.EzA;
      i = 0;
      j = 0;
    }
  }
  
  private void crh()
  {
    AppMethodBeat.i(27916);
    this.qPR.setVisibility(8);
    this.pet.setVisibility(8);
    this.qPQ.setVisibility(8);
    this.qPU.setVisibility(8);
    this.lzD.setVisibility(0);
    if (this.dhe.dataType == 4)
    {
      this.lzD.setGravity(17);
      this.lzD.setText(2131758941);
      AppMethodBeat.o(27916);
      return;
    }
    this.lzD.setGravity(17);
    this.lzD.setText(2131758940);
    if (!this.wkw)
    {
      this.wkw = true;
      ft(8, 6);
    }
    AppMethodBeat.o(27916);
  }
  
  private void cri()
  {
    AppMethodBeat.i(27917);
    this.qPR.setVisibility(8);
    this.pet.setVisibility(8);
    this.qPQ.setVisibility(8);
    this.lzD.setVisibility(8);
    this.qPU.setVisibility(0);
    c(((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(this.mediaId));
    AppMethodBeat.o(27917);
  }
  
  private void crj()
  {
    AppMethodBeat.i(27918);
    this.qPU.setVisibility(8);
    this.qPQ.setVisibility(8);
    if (bs.isNullOrNil(this.dhe.Ezm)) {
      this.pet.setVisibility(8);
    }
    for (;;)
    {
      this.qPR.setVisibility(0);
      this.qPR.setText(2131758918);
      this.lzD.setVisibility(8);
      AppMethodBeat.o(27918);
      return;
      this.pet.setVisibility(0);
    }
  }
  
  private void crl()
  {
    AppMethodBeat.i(27919);
    if (this.wku.tBg != 1)
    {
      this.wku.tBg = 1;
      this.wku.air(bs.nullAsNil(n.c(this.dhe, this.msgId)));
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.wku);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.wku);
    }
    if ((getType() == 15) && (this.dhe.EAf != null) && (!bs.isNullOrNil(this.dhe.EAf.hjV)) && (!bs.isNullOrNil(this.dhe.EAf.hjZ)))
    {
      this.qQe = true;
      this.qPS.setVisibility(8);
      this.qPU.setVisibility(8);
      this.qPR.setVisibility(8);
      this.pet.setVisibility(8);
      this.qPQ.setVisibility(8);
      this.lzD.setVisibility(8);
      String str = n.c(this.dhe, this.msgId);
      ac.d("MicroMsg.RecordMsgFileUI", f.YF() + " initView: fullpath:" + str);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131306317);
      this.odZ = t.hz(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(13);
      localViewGroup.addView((View)this.odZ, 0, localLayoutParams);
      this.odZ.setVideoCallback(new h.a()
      {
        public final void dZ(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final int eP(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return 0;
        }
        
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
          com.tencent.mm.sdk.a.b.N(Base64.encodeToString((com.tencent.mm.plugin.sight.base.e.dEw() + "[RecordMsgFileUI] on play sight error, what=" + paramAnonymousInt1 + ", extra=" + paramAnonymousInt2 + ", path=" + bs.bG(str, "")).getBytes(), 2), "FullScreenPlaySight");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(27909);
              Object localObject1 = (ImageView)RecordMsgFileUI.this.findViewById(2131306415);
              ((ImageView)localObject1).setImageBitmap(localBitmap);
              ((ImageView)localObject1).setVisibility(0);
              Object localObject2 = new Intent();
              ((Intent)localObject2).setAction("android.intent.action.VIEW");
              com.tencent.mm.sdk.platformtools.m.a(RecordMsgFileUI.this.getContext(), (Intent)localObject2, new com.tencent.mm.vfs.e(str), "video/*");
              try
              {
                localObject1 = RecordMsgFileUI.this;
                localObject2 = Intent.createChooser((Intent)localObject2, RecordMsgFileUI.this.getString(2131759030));
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((RecordMsgFileUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/record/ui/RecordMsgFileUI$7$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(27909);
                return;
              }
              catch (Exception localException)
              {
                ac.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                com.tencent.mm.ui.base.h.l(RecordMsgFileUI.this.getContext(), 2131758931, 2131758932);
                AppMethodBeat.o(27909);
              }
            }
          });
          AppMethodBeat.o(27911);
        }
        
        public final void rB()
        {
          AppMethodBeat.i(27910);
          ac.d("MicroMsg.RecordMsgFileUI", f.YF() + " onPrepared");
          RecordMsgFileUI.j(RecordMsgFileUI.this).setLoop(true);
          RecordMsgFileUI.j(RecordMsgFileUI.this).start();
          AppMethodBeat.o(27910);
        }
      });
      ac.d("MicroMsg.RecordMsgFileUI", f.YF() + " initView :" + str);
      if (str != null)
      {
        this.odZ.stop();
        this.odZ.setVideoPath(str);
      }
      ac.d("MicroMsg.RecordMsgFileUI", f.YF() + " initView");
      if (az.Lt() != null) {
        az.Lt().Ue();
      }
    }
    if ((getType() == 15) || (getType() == 4))
    {
      if (!this.qQe)
      {
        this.qPU.setVisibility(8);
        this.qPR.setVisibility(8);
        this.pet.setVisibility(8);
        this.qPQ.setVisibility(0);
        this.qPQ.setText(2131758920);
        this.lzD.setVisibility(8);
        blc();
        AppMethodBeat.o(27919);
      }
    }
    else
    {
      this.qPU.setVisibility(8);
      this.qPR.setVisibility(4);
      if (!bs.isNullOrNil(this.dhe.Ezm)) {
        break label553;
      }
      this.pet.setVisibility(8);
    }
    for (;;)
    {
      this.qPQ.setVisibility(0);
      this.lzD.setVisibility(0);
      AppMethodBeat.o(27919);
      return;
      label553:
      this.pet.setVisibility(0);
    }
  }
  
  private String dua()
  {
    AppMethodBeat.i(27924);
    Object localObject = new com.tencent.mm.vfs.e(n.f(this.dhe, this.msgId));
    if (((com.tencent.mm.vfs.e)localObject).exists()) {}
    for (localObject = q.B(((com.tencent.mm.vfs.e)localObject).fxV());; localObject = com.tencent.mm.model.c.awV() + "web/" + com.tencent.mm.b.g.getMessageDigest(bs.bG(this.dhe.dbZ, "").getBytes()))
    {
      AppMethodBeat.o(27924);
      return localObject;
      localObject = new StringBuilder();
      az.ayM();
    }
  }
  
  private void ft(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27928);
    if (8 == getType()) {
      if (this.dhe.EzA <= 26214400L) {
        break label220;
      }
    }
    label220:
    for (int i = 7;; i = 5)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1203L, paramInt2, 1L, false);
      String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { this.dhe.Ezf, Integer.valueOf(i), Long.valueOf(this.dhe.EzA), Integer.valueOf(paramInt1), Long.valueOf((ce.azI() - this.dpq.field_createTime) / 1000L), this.dhe.Ezu, this.dpq.field_talker, Integer.valueOf(2), this.dhe.dhw, Long.valueOf(this.dpq.field_msgSvrId), Long.valueOf(this.dpq.field_createTime) });
      ac.i("MicroMsg.RecordMsgFileUI", "reportKVStat 14665 %s", new Object[] { str });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(14665, str);
      AppMethodBeat.o(27928);
      return;
    }
  }
  
  private int getType()
  {
    int j = this.dhe.dataType;
    int i = j;
    if (j == 15) {
      i = 4;
    }
    return i;
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.record.a.i parami)
  {
    AppMethodBeat.i(27926);
    if (parami == null)
    {
      ac.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
      AppMethodBeat.o(27926);
      return;
    }
    ac.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", new Object[] { this.mediaId, parami.field_mediaId });
    if (!this.mediaId.equals(parami.field_mediaId))
    {
      AppMethodBeat.o(27926);
      return;
    }
    switch (parami.field_status)
    {
    default: 
      c(parami);
      AppMethodBeat.o(27926);
      return;
    case 2: 
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27899);
          RecordMsgFileUI.this.enableOptionMenu(true);
          RecordMsgFileUI.q(RecordMsgFileUI.this);
          AppMethodBeat.o(27899);
        }
      });
      a(parami, true);
      ft(0, 2);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1203L, 5L, this.dhe.EzA, false);
      AppMethodBeat.o(27926);
      return;
    case 4: 
      a(parami, false);
      this.gox.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27900);
          RecordMsgFileUI.r(RecordMsgFileUI.this);
          AppMethodBeat.o(27900);
        }
      });
      ft(1, 3);
      AppMethodBeat.o(27926);
      return;
    }
    this.gox.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(27901);
        RecordMsgFileUI.h(RecordMsgFileUI.this);
        com.tencent.mm.ui.base.h.cg(RecordMsgFileUI.this.getContext(), RecordMsgFileUI.this.getString(2131758104));
        AppMethodBeat.o(27901);
      }
    });
    a(parami, false);
    ft(1, 4);
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
        ac.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", new Object[] { Integer.valueOf(getType()) });
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27912);
            this.qLa.dismiss();
            AppMethodBeat.o(27912);
          }
        };
        if (!bs.isNullOrNil((String)localObject1)) {
          break label151;
        }
        AppMethodBeat.o(27923);
        return;
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label151:
      Object localObject1 = bs.S(((String)localObject1).split(","));
      if ((getType() == 4) || (getType() == 15))
      {
        az.agU().az(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(27913);
            com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(n.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
            Iterator localIterator = this.wky.iterator();
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              Object localObject1;
              if (locale.exists())
              {
                localObject1 = RecordMsgFileUI.n(RecordMsgFileUI.this);
                ac.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", new Object[] { q.B(locale.fxV()), localObject1 });
                if (RecordMsgFileUI.c(RecordMsgFileUI.this) == 15) {
                  j.dck().a(RecordMsgFileUI.this.getContext(), str1, q.B(locale.fxV()), (String)localObject1, 62, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).iaU);
                }
              }
              for (;;)
              {
                j.dck().hF(paramIntent, str1);
                break;
                j.dck().a(RecordMsgFileUI.this.getContext(), str1, q.B(locale.fxV()), (String)localObject1, 1, RecordMsgFileUI.a(RecordMsgFileUI.this).duration, "", RecordMsgFileUI.a(RecordMsgFileUI.this).iaU);
                continue;
                Object localObject2 = RecordMsgFileUI.a(RecordMsgFileUI.this).Ezm;
                if (!bs.isNullOrNil((String)localObject2))
                {
                  localObject1 = new WXVideoObject();
                  ((WXVideoObject)localObject1).videoUrl = ((String)localObject2);
                  localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
                  String str2 = bs.bG(RecordMsgFileUI.a(RecordMsgFileUI.this).title, RecordMsgFileUI.this.getContext().getResources().getString(2131759030));
                  ((WXMediaMessage)localObject2).mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
                  ((WXMediaMessage)localObject2).title = str2;
                  ((WXMediaMessage)localObject2).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
                  ((WXMediaMessage)localObject2).thumbData = bs.readFromFile(n.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
                  if (((WXMediaMessage)localObject2).thumbData == null)
                  {
                    localObject1 = new StringBuilder();
                    az.ayM();
                    ((WXMediaMessage)localObject2).thumbData = bs.readFromFile(com.tencent.mm.model.c.awV() + "web/" + com.tencent.mm.b.g.getMessageDigest(bs.bG(RecordMsgFileUI.a(RecordMsgFileUI.this).dbZ, "").getBytes()));
                  }
                  com.tencent.mm.pluginsdk.model.app.m.a((WXMediaMessage)localObject2, "", "", str1, 3, null);
                }
              }
            }
            RecordMsgFileUI.a(RecordMsgFileUI.this, 2, 7);
            ap.f(this.val$callback);
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
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(27896);
          Object localObject1 = n.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          Object localObject2 = new WXFileObject();
          ((WXFileObject)localObject2).setFilePath((String)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).mediaObject = ((WXMediaMessage.IMediaObject)localObject2);
          ((WXMediaMessage)localObject1).title = RecordMsgFileUI.a(RecordMsgFileUI.this).title;
          ((WXMediaMessage)localObject1).description = RecordMsgFileUI.a(RecordMsgFileUI.this).desc;
          ((WXMediaMessage)localObject1).thumbData = bs.readFromFile(n.f(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this)));
          localObject2 = this.wky.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            com.tencent.mm.pluginsdk.model.app.m.a((WXMediaMessage)localObject1, "", "", str, 3, null);
            j.dck().hF(paramIntent, str);
          }
          ap.f(this.val$callback);
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
    this.gox = new ao();
    this.wkv = new com.tencent.mm.plugin.record.b.l();
    this.msgId = getIntent().getLongExtra("message_id", -1L);
    this.dpq = ((k)com.tencent.mm.kernel.g.ab(k.class)).dcr().vP(this.msgId);
    paramBundle = getIntent().getStringExtra("record_data_id");
    Object localObject = n.aqs(getIntent().getStringExtra("record_xml"));
    if (localObject == null)
    {
      ac.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    localObject = ((com.tencent.mm.protocal.b.a.c)localObject).hkS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      agx localagx = (agx)((Iterator)localObject).next();
      if (localagx.dhw.equals(paramBundle)) {
        this.dhe = localagx;
      }
    }
    if (this.dhe == null)
    {
      ac.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
      finish();
      AppMethodBeat.o(27915);
      return;
    }
    this.mediaId = n.h(this.dhe.dhw, this.msgId, true);
    this.pet = ((Button)findViewById(2131303391));
    this.qPQ = ((Button)findViewById(2131303020));
    this.qPR = ((Button)findViewById(2131299195));
    this.qPS = ((MMImageView)findViewById(2131300891));
    this.iMz = ((TextView)findViewById(2131302666));
    this.lzD = ((TextView)findViewById(2131305896));
    this.qPV = findViewById(2131299221);
    this.qPU = findViewById(2131299216);
    this.progressBar = ((ProgressBar)findViewById(2131299214));
    this.qPT = ((TextView)findViewById(2131299217));
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
      this.qPS.setImageResource(2131689581);
      this.iMz.setText(this.dhe.title);
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
      this.qPQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27902);
          paramAnonymousView = n.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
          new Intent().setAction("android.intent.action.VIEW");
          if (4 == RecordMsgFileUI.c(RecordMsgFileUI.this))
          {
            RecordMsgFileUI.d(RecordMsgFileUI.this);
            RecordMsgFileUI.e(RecordMsgFileUI.this);
            AppMethodBeat.o(27902);
            return;
          }
          RecordMsgFileUI.a(RecordMsgFileUI.this, paramAnonymousView);
          AppMethodBeat.o(27902);
        }
      });
      localObject = this.dhe.Ezm;
      if (!bs.isNullOrNil((String)localObject)) {
        this.pet.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(27903);
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", this.qQp);
            com.tencent.mm.br.d.b(RecordMsgFileUI.this.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
            AppMethodBeat.o(27903);
          }
        });
      }
      this.qPR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27904);
          if (!com.tencent.mm.compatible.util.e.YD())
          {
            com.tencent.mm.ui.base.h.l(RecordMsgFileUI.this.getContext(), 2131758934, 2131755906);
            AppMethodBeat.o(27904);
            return;
          }
          n.b(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this), true);
          RecordMsgFileUI.f(RecordMsgFileUI.this);
          RecordMsgFileUI.g(RecordMsgFileUI.this);
          RecordMsgFileUI.a(RecordMsgFileUI.this, 7, 1);
          AppMethodBeat.o(27904);
        }
      });
      this.qPV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27905);
          RecordMsgFileUI.h(RecordMsgFileUI.this);
          AppMethodBeat.o(27905);
        }
      });
      az.ayM();
      localObject = com.tencent.mm.model.c.awD().vP(this.msgId);
      this.wku = HandOffFile.a(this.dhe, null, (bo)localObject);
      this.wku.dbL = 1;
      boolean bool = n.d(this.dhe, this.msgId);
      localObject = this.wku;
      if (!bool) {
        break label833;
      }
      i = 1;
      ((HandOffFile)localObject).tBg = i;
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.wku);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).c(this.wku);
      if ((getType() != 15) || (bs.aLy(com.tencent.mm.m.g.ZY().getValue("SightForwardEnable")) == 1)) {
        break label838;
      }
      ac.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
      label640:
      if ((!bs.isNullOrNil(this.dhe.Ezf)) && (!bs.isNullOrNil(this.dhe.Ezh))) {
        break label857;
      }
      i = 1;
      label668:
      if ((!bs.isNullOrNil(this.dhe.EAx)) && (!bs.isNullOrNil(this.dhe.EAu))) {
        break label862;
      }
      j = 1;
      label696:
      if ((i != 0) || (j != 0)) {
        break label867;
      }
      crh();
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this);
      if (8 == getType()) {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).T(paramBundle, this.dpq.field_msgSvrId);
      }
      ft(4, 0);
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
      this.qPS.setImageResource(com.tencent.mm.pluginsdk.e.aFI(this.dhe.Ezu));
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
          paramAnonymousMenuItem.ISu = new n.c()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
            {
              AppMethodBeat.i(27906);
              paramAnonymous2l.c(0, RecordMsgFileUI.this.getString(2131759001));
              AppMethodBeat.o(27906);
            }
          };
          paramAnonymousMenuItem.ISv = new n.d()
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
                  paramAnonymous2MenuItem = n.c(RecordMsgFileUI.a(RecordMsgFileUI.this), RecordMsgFileUI.b(RecordMsgFileUI.this));
                  if (!com.tencent.mm.vfs.i.eA(paramAnonymous2MenuItem))
                  {
                    ac.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(2131758999), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                  if (new com.tencent.mm.vfs.e(paramAnonymous2MenuItem).length() > 10485760L)
                  {
                    ac.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                    Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(2131759000), 1).show();
                    AppMethodBeat.o(27907);
                    return;
                  }
                }
                RecordMsgFileUI.i(RecordMsgFileUI.this);
              }
            }
          };
          paramAnonymousMenuItem.cED();
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
      if (!n.d(this.dhe, this.msgId)) {
        break label893;
      }
      enableOptionMenu(true);
      crl();
    }
    label893:
    localObject = ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().aqr(this.mediaId);
    if ((localObject == null) || (2 == ((com.tencent.mm.plugin.record.a.i)localObject).field_status)) {
      crj();
    }
    for (;;)
    {
      enableOptionMenu(false);
      break;
      if (4 == ((com.tencent.mm.plugin.record.a.i)localObject).field_status)
      {
        crh();
      }
      else if ((((com.tencent.mm.plugin.record.a.i)localObject).field_status == 0) || (1 == ((com.tencent.mm.plugin.record.a.i)localObject).field_status))
      {
        cri();
      }
      else
      {
        ac.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        crj();
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(27920);
    if (this.odZ != null)
    {
      this.odZ.setVideoCallback(null);
      this.odZ.stop();
      this.odZ.onDetach();
      if (az.Lt() != null) {
        az.Lt().Ud();
      }
    }
    super.onDestroy();
    ((com.tencent.mm.plugin.record.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this);
    if (this.wku != null) {
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).d(this.wku);
    }
    this.wkv.destory();
    AppMethodBeat.o(27920);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(27922);
    super.onPause();
    if (this.odZ != null) {
      this.odZ.stop();
    }
    AppMethodBeat.o(27922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(27921);
    super.onResume();
    if (this.odZ != null) {
      this.odZ.start();
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