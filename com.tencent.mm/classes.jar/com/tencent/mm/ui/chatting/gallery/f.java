package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.b.a.ad;
import com.tencent.mm.f.b.a.ad.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class f
  extends com.tencent.mm.ui.base.x
{
  public static long syu = -1L;
  public static boolean wIf = false;
  public ImageGalleryUI WQV;
  protected a WQW;
  private String WQX;
  boolean WQY;
  public boolean WQZ;
  public h WRa;
  public e WRb;
  public m WRc;
  public c WRd;
  public boolean WRe;
  boolean WRf;
  protected boolean WRg;
  private ad WRh;
  private int fromScene;
  private String iVe;
  private ArrayList<ca> wQK;
  
  public f(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35892);
    this.WQY = true;
    this.WQZ = false;
    this.WRe = false;
    this.iVe = null;
    this.WRg = true;
    this.wQK = new ArrayList();
    this.WRh = null;
    this.WRe = paramImageGalleryUI.getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    boolean bool;
    if (!this.WRe)
    {
      String str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + Util.getStack();
      if ((paramLong1 > 0L) && (paramString1 != null) && (paramString1.length() > 0))
      {
        bool = true;
        Assert.assertTrue(str, bool);
      }
    }
    else
    {
      this.WQV = paramImageGalleryUI;
      wIf = paramBoolean1;
      syu = paramLong2;
      this.iVe = paramString1;
      this.fromScene = paramInt;
      this.WQW = new a(paramLong1, paramString1, this, paramBoolean, paramInt);
      this.WQZ = paramBoolean2;
      this.WQX = paramString2;
      this.WQW.dpe();
      this.WRa = new h(this);
      if (!o.isEnabled()) {
        break label268;
      }
    }
    label268:
    for (this.WRb = new o(this);; this.WRb = new n(this))
    {
      this.WRc = new m(this);
      AppMethodBeat.o(35892);
      return;
      bool = false;
      break;
    }
  }
  
  private void K(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35909);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
      AppMethodBeat.o(35909);
      return;
    }
    Object localObject;
    if (Util.isNullOrNil(this.WQX))
    {
      Log.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      localObject = new Intent(this.WQV, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Id", paramLong);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", paramInt);
      paramString = this.WQV;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35909);
      return;
    }
    Log.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.WQX });
    if (!Util.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.modelmulti.o.a(o.d.lUk).wb(4);
      ((o.e)localObject).fLi = z.bcZ();
      ((o.e)localObject).toUser = this.WQX;
      ((o.e)localObject).lPO = paramString;
      ((o.e)localObject).lNK = paramInt;
      ((o.e)localObject).lUr = null;
      ((o.e)localObject).lUq = 6;
      ((o.e)localObject).bnl().aEv();
      cg.bfp().e(cg.lvK, null);
    }
    if (this.WQY)
    {
      localObject = new Intent(this.WQV, ChattingUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.WQX);
      paramString = this.WQV;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.WQX });
      AppMethodBeat.o(35909);
      return;
      com.tencent.mm.ui.base.h.cO(this.WQV, this.WQV.getString(R.l.app_saved));
    }
  }
  
  public static void a(Context paramContext, final ca paramca)
  {
    AppMethodBeat.i(285430);
    if ((paramContext == null) || (paramca == null))
    {
      AppMethodBeat.o(285430);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(285430);
  }
  
  public static boolean b(Context paramContext, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35912);
    if (paramca == null)
    {
      AppMethodBeat.o(35912);
      return false;
    }
    final com.tencent.mm.modelvideo.w localw = s.bqB().XN(paramca.field_imgPath);
    boolean bool = false;
    if (localw != null)
    {
      int i = 0;
      if (ab.Lj(localw.bqM())) {
        i = com.tencent.mm.model.v.Pu(localw.bqM());
      }
      bool = localw.bqS();
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.a(12084, new Object[] { Integer.valueOf(localw.lAW), Integer.valueOf(localw.lvw * 1000), Integer.valueOf(0), Integer.valueOf(2), localw.bqM(), Integer.valueOf(i), com.tencent.mm.modelvideo.w.XK(localw.bqO()), Long.valueOf(localw.createTime) });
    }
    if (!bool)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
      if (paramBoolean) {
        com.tencent.mm.platformtools.p.J(paramContext, paramContext.getString(R.l.video_file_save_failed));
      }
      AppMethodBeat.o(35912);
      return false;
    }
    s.bqB();
    final String str1 = com.tencent.mm.modelvideo.x.XT(paramca.field_imgPath);
    String str2 = com.tencent.mm.platformtools.p.L(paramContext, str1);
    if (Util.isNullOrNil(str2))
    {
      if (paramBoolean) {
        com.tencent.mm.platformtools.p.J(paramContext, paramContext.getString(R.l.video_file_save_failed));
      }
      AppMethodBeat.o(35912);
      return false;
    }
    if (paramBoolean) {
      com.tencent.mm.platformtools.p.J(paramContext, paramContext.getString(R.l.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(str2) }));
    }
    String str3 = com.tencent.mm.vfs.u.buc(str2);
    com.tencent.mm.platformtools.v localv = com.tencent.mm.platformtools.v.mEG;
    com.tencent.mm.platformtools.v.bV(str3, bs.RU(paramca.hxy));
    AndroidMediaUtil.refreshMediaScannerAsync(str2, paramContext);
    com.tencent.e.h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(289586);
        try
        {
          j.b localb;
          if (ab.Lj(this.lru.field_talker))
          {
            localb = com.tencent.mm.app.j.b(j.a.fcz);
            if (this.lru.field_isSend == 1)
            {
              localb.fcC = z.bcZ();
              localb.fcD = this.lru.field_talker;
            }
          }
          MultiMediaVideoChecker.a locala;
          for (;;)
          {
            locala = MultiMediaVideoChecker.NmA.bfs(str1);
            if (locala != null) {
              break;
            }
            Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get video data info, skip reporting. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(this.lru.field_msgId), Long.valueOf(this.lru.field_msgSvrId) });
            AppMethodBeat.o(289586);
            return;
            localb.fcC = bq.RL(this.lru.field_content);
            localb.fcD = this.lru.field_talker;
            continue;
            localb = com.tencent.mm.app.j.a(j.a.fcz);
            if (this.lru.field_isSend == 1)
            {
              localb.fcC = z.bcZ();
              localb.fcD = this.lru.field_talker;
            }
            else
            {
              localb.fcC = this.lru.field_talker;
              localb.fcD = z.bcZ();
            }
          }
          if (localw != null) {}
          for (Object localObject = XmlParser.parseXml(localw.bqO(), "msg", null); localObject == null; localObject = Collections.emptyMap())
          {
            Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse recv xml. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(this.lru.field_msgId), Long.valueOf(this.lru.field_msgSvrId) });
            AppMethodBeat.o(289586);
            return;
          }
          localb.msgId = this.lru.field_msgSvrId;
          localb.fcE = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
          localb.mediaWidth = locala.width;
          localb.mediaHeight = locala.height;
          localb.fcF = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnthumburl"));
          localb.fcG = ((int)locala.duration);
          localb.fileId = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
          localb.fileKey = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$aeskey"));
          localb.md5 = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$md5"));
          if (ab.Lj(this.lru.field_talker))
          {
            localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RA(this.lru.field_talker);
            if (localObject == null) {
              break label471;
            }
          }
          label471:
          for (int i = ((List)localObject).size();; i = 0)
          {
            localb.fcI = i;
            com.tencent.mm.app.j.a(localb);
            AppMethodBeat.o(289586);
            return;
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          Log.printErrStackTrace("MicroMsg.ImageGalleryAdapter", localThrowable, "[-] Exception was thrown when report.", new Object[0]);
          AppMethodBeat.o(289586);
        }
      }
    }, "MsgVideoExportReport");
    AppMethodBeat.o(35912);
    return true;
  }
  
  public static boolean b(ca paramca, com.tencent.mm.ay.g paramg)
  {
    AppMethodBeat.i(35903);
    if ((paramca == null) || (paramg == null))
    {
      AppMethodBeat.o(35903);
      return false;
    }
    boolean bool = com.tencent.mm.ay.q.bmi().a(paramg.localId, paramca.field_msgId, 1);
    AppMethodBeat.o(35903);
    return bool;
  }
  
  public static int c(ca paramca, com.tencent.mm.ay.g paramg)
  {
    AppMethodBeat.i(35918);
    if (paramca.field_isSend == 1)
    {
      if (paramg.blK())
      {
        paramca = com.tencent.mm.ay.h.a(paramg);
        if ((paramca != null) && (paramca.localId > 0L) && (paramca.blJ()) && (com.tencent.mm.vfs.u.agG(com.tencent.mm.ay.q.bmh().r(paramca.lNH, "", ""))))
        {
          AppMethodBeat.o(35918);
          return 1;
        }
      }
      AppMethodBeat.o(35918);
      return 0;
    }
    if (paramg.blJ())
    {
      if (paramg.blK())
      {
        paramca = com.tencent.mm.ay.h.a(paramg);
        if ((paramca != null) && (paramca.localId > 0L) && (paramca.blJ()) && (com.tencent.mm.vfs.u.agG(com.tencent.mm.ay.q.bmh().r(paramca.lNH, "", ""))))
        {
          AppMethodBeat.o(35918);
          return 1;
        }
      }
      AppMethodBeat.o(35918);
      return 0;
    }
    AppMethodBeat.o(35918);
    return 0;
  }
  
  public static void c(final Context paramContext, final ca paramca, final boolean paramBoolean)
  {
    AppMethodBeat.i(285431);
    if ((paramContext == null) || (paramca == null))
    {
      AppMethodBeat.o(285431);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(285431);
  }
  
  public static boolean cJ(ca paramca)
  {
    AppMethodBeat.i(35899);
    if (paramca == null)
    {
      AppMethodBeat.o(35899);
      return false;
    }
    if (paramca.getType() == 62)
    {
      AppMethodBeat.o(35899);
      return true;
    }
    AppMethodBeat.o(35899);
    return false;
  }
  
  public static boolean cK(ca paramca)
  {
    AppMethodBeat.i(35900);
    if (paramca == null)
    {
      AppMethodBeat.o(35900);
      return false;
    }
    if (paramca.getType() == 49)
    {
      AppMethodBeat.o(35900);
      return true;
    }
    AppMethodBeat.o(35900);
    return false;
  }
  
  public static boolean cL(ca paramca)
  {
    AppMethodBeat.i(35901);
    if (paramca == null)
    {
      AppMethodBeat.o(35901);
      return false;
    }
    if (paramca.getType() == 268435505)
    {
      AppMethodBeat.o(35901);
      return true;
    }
    AppMethodBeat.o(35901);
    return false;
  }
  
  public static boolean cM(ca paramca)
  {
    AppMethodBeat.i(35902);
    if (paramca == null)
    {
      AppMethodBeat.o(35902);
      return false;
    }
    boolean bool = paramca.dlS();
    AppMethodBeat.o(35902);
    return bool;
  }
  
  public static b cN(ca paramca)
  {
    AppMethodBeat.i(35906);
    b localb = b.WRC;
    if (paramca == null) {
      localb = b.WRC;
    }
    if (cL(paramca))
    {
      paramca = b.WRG;
      AppMethodBeat.o(35906);
      return paramca;
    }
    if (j(paramca))
    {
      paramca = b.WRD;
      AppMethodBeat.o(35906);
      return paramca;
    }
    if (cO(paramca))
    {
      paramca = b.WRF;
      AppMethodBeat.o(35906);
      return paramca;
    }
    if (m(paramca))
    {
      paramca = b.WRE;
      AppMethodBeat.o(35906);
      return paramca;
    }
    if (cJ(paramca))
    {
      paramca = b.WRE;
      AppMethodBeat.o(35906);
      return paramca;
    }
    paramca = b.WRC;
    AppMethodBeat.o(35906);
    return paramca;
  }
  
  public static boolean cO(ca paramca)
  {
    AppMethodBeat.i(35907);
    if (paramca != null)
    {
      if (paramca.dlS())
      {
        AppMethodBeat.o(35907);
        return false;
      }
      paramca = com.tencent.mm.modelvideo.y.Yk(paramca.field_imgPath);
      if ((paramca != null) && (paramca.mhZ != null) && ((!Util.isNullOrNil(paramca.mhZ.lor)) || (paramca.mhZ.SAk > 0) || (!Util.isNullOrNil(paramca.mhZ.lou)) || (!Util.isNullOrNil(paramca.mhZ.lov)) || (!Util.isNullOrNil(paramca.mhZ.lot)) || (!Util.isNullOrNil(paramca.mhZ.low)) || (!Util.isNullOrNil(paramca.mhZ.lox)) || (!Util.isNullOrNil(paramca.mhZ.loy))))
      {
        AppMethodBeat.o(35907);
        return true;
      }
    }
    AppMethodBeat.o(35907);
    return false;
  }
  
  public static boolean d(Context paramContext, final ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35913);
    final com.tencent.mm.ay.g localg = null;
    if (cL(paramca)) {}
    for (Object localObject = l(paramca); (localObject == null) || (((String)localObject).length() == 0); localObject = h.a(paramca, localg))
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + paramca.field_msgId);
      if (paramBoolean) {
        com.tencent.mm.platformtools.p.J(paramContext, paramContext.getString(R.l.save_image_err));
      }
      AppMethodBeat.o(35913);
      return false;
      if ((paramca == null) || (paramca.field_msgId == 0L))
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          com.tencent.mm.platformtools.p.J(paramContext, paramContext.getString(R.l.save_image_err));
        }
        AppMethodBeat.o(35913);
        return false;
      }
      localg = h.k(paramca);
      if ((localg == null) || (localg.localId == 0L))
      {
        localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (paramca == null)
        {
          paramca = "null";
          localObject = ((StringBuilder)localObject).append(paramca).append(", imgLocalId = ");
          if (localg != null) {
            break label232;
          }
        }
        label232:
        for (paramca = "null";; paramca = Long.valueOf(localg.localId))
        {
          Log.e("MicroMsg.ImageGalleryAdapter", paramca);
          if (paramBoolean) {
            com.tencent.mm.platformtools.p.J(paramContext, paramContext.getString(R.l.save_image_err));
          }
          AppMethodBeat.o(35913);
          return false;
          paramca = Long.valueOf(paramca.field_msgId);
          break;
        }
      }
    }
    String str = com.tencent.mm.platformtools.p.K(paramContext, (String)localObject);
    if (!Util.isNullOrNil(str))
    {
      if (paramBoolean) {
        com.tencent.mm.platformtools.p.J(paramContext, paramContext.getString(R.l.cropimage_saved, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }));
      }
      com.tencent.e.h.ZvG.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(280875);
          label528:
          for (;;)
          {
            try
            {
              BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(this.pqU);
              if (localOptions == null)
              {
                Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get bmp opts. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
                AppMethodBeat.o(280875);
                return;
              }
              j.b localb;
              if (ab.Lj(paramca.field_talker))
              {
                localb = com.tencent.mm.app.j.b(j.a.fcy);
                if (paramca.field_isSend == 1)
                {
                  localb.fcC = z.bcZ();
                  localb.fcD = paramca.field_talker;
                  localObject = com.tencent.mm.plugin.normsg.a.d.GxJ.aTq(this.pqU);
                  if (localObject == null) {
                    break label528;
                  }
                  localObject = localObject[0];
                  if (localg != null)
                  {
                    localMap = XmlParser.parseXml(localg.lNS, "msg", null);
                    if (localMap != null) {
                      continue;
                    }
                    Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse cdn info. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
                    AppMethodBeat.o(280875);
                  }
                }
                else
                {
                  localb.fcC = bq.RL(paramca.field_content);
                  localb.fcD = paramca.field_talker;
                  continue;
                }
              }
              else
              {
                localb = com.tencent.mm.app.j.a(j.a.fcy);
                if (paramca.field_isSend == 1)
                {
                  localb.fcC = z.bcZ();
                  localb.fcD = paramca.field_talker;
                  continue;
                }
                localb.fcC = paramca.field_talker;
                localb.fcD = z.bcZ();
                continue;
              }
              Map localMap = Collections.emptyMap();
              continue;
              String str;
              if (localg.lNK == 1)
              {
                str = (String)localMap.get(".msg.img.$cdnbigimgurl");
                localb.msgId = paramca.field_msgSvrId;
                localb.fcE = Util.nullAsNil(str);
                localb.mediaWidth = localOptions.outWidth;
                localb.mediaHeight = localOptions.outHeight;
                localb.fcF = Util.nullAsNil((String)localMap.get(".msg.img.$cdnthumburl"));
                localb.fileId = Util.nullAsNil(str);
                localb.fileKey = Util.nullAsNil((String)localMap.get(".msg.img.$aeskey"));
                localb.md5 = com.tencent.mm.b.g.getMD5(this.pqU);
                localb.fcH = ((String)localObject);
                if (ab.Lj(paramca.field_talker))
                {
                  localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().RA(paramca.field_talker);
                  if (localObject != null)
                  {
                    i = ((List)localObject).size();
                    localb.fcI = i;
                  }
                }
                else
                {
                  com.tencent.mm.app.j.a(localb);
                  AppMethodBeat.o(280875);
                }
              }
              else
              {
                str = (String)localMap.get(".msg.img.$cdnmidimgurl");
                continue;
              }
              int i = 0;
              continue;
              Object localObject = "";
            }
            catch (Throwable localThrowable)
            {
              Log.printErrStackTrace("MicroMsg.ImageGalleryAdapter", localThrowable, "[-] Exception was thrown when report.", new Object[0]);
              AppMethodBeat.o(280875);
              return;
            }
          }
        }
      }, "MsgImgExportReport");
      paramContext = com.tencent.mm.vfs.u.buc(str);
      localObject = com.tencent.mm.platformtools.v.mEG;
      com.tencent.mm.platformtools.v.bV(paramContext, bs.RU(paramca.hxy));
      AppMethodBeat.o(35913);
      return true;
    }
    if (paramBoolean) {
      com.tencent.mm.platformtools.p.J(paramContext, paramContext.getString(R.l.save_image_err));
    }
    AppMethodBeat.o(35913);
    return false;
  }
  
  public static void f(final Context paramContext, List<ca> paramList)
  {
    AppMethodBeat.i(285428);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(285428);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(285428);
  }
  
  public static boolean j(ca paramca)
  {
    AppMethodBeat.i(35897);
    if (paramca == null)
    {
      AppMethodBeat.o(35897);
      return false;
    }
    if ((paramca.getType() == 3) || (paramca.getType() == 39) || (paramca.getType() == 13))
    {
      AppMethodBeat.o(35897);
      return true;
    }
    AppMethodBeat.o(35897);
    return false;
  }
  
  public static String l(ca paramca)
  {
    Object localObject1 = null;
    AppMethodBeat.i(35916);
    Object localObject2 = k.b.OQ(paramca.field_content);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35916);
      return null;
    }
    paramca = localObject1;
    if (((k.b)localObject2).fvr != null)
    {
      paramca = localObject1;
      if (((k.b)localObject2).fvr.length() > 0)
      {
        localObject2 = ao.ctZ().bpR(((k.b)localObject2).fvr);
        paramca = localObject1;
        if (localObject2 != null) {
          paramca = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        }
      }
    }
    AppMethodBeat.o(35916);
    return paramca;
  }
  
  public static boolean m(ca paramca)
  {
    AppMethodBeat.i(35898);
    if (paramca == null)
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if (cO(paramca))
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if ((paramca.getType() == 43) || (paramca.getType() == 486539313) || (paramca.getType() == 44) || (paramca.getType() == 62))
    {
      AppMethodBeat.o(35898);
      return true;
    }
    AppMethodBeat.o(35898);
    return false;
  }
  
  public final MultiTouchImageView Tf(int paramInt)
  {
    AppMethodBeat.i(35920);
    Object localObject = super.aiI(paramInt);
    if (localObject == null)
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35920);
      return null;
    }
    localObject = ((View)localObject).findViewById(R.h.image);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(35920);
      return null;
    }
    localObject = (MultiTouchImageView)localObject;
    AppMethodBeat.o(35920);
    return localObject;
  }
  
  public final WxImageView Tg(int paramInt)
  {
    AppMethodBeat.i(35921);
    Object localObject = super.aiI(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(35921);
      return null;
    }
    localObject = ((View)localObject).findViewById(R.h.wx_image);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(35921);
      return null;
    }
    localObject = (WxImageView)localObject;
    AppMethodBeat.o(35921);
    return localObject;
  }
  
  public final void a(ca paramca, com.tencent.mm.ay.g paramg, int paramInt, ad.a parama)
  {
    AppMethodBeat.i(35934);
    if (paramca == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    if (this.WRh == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    this.WRh.agP().gib = parama;
    long l1 = paramca.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.WRh.ghT != l1) && (this.WRh.ghV != i); i = 0)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.WRh.ghT), Long.valueOf(l1) });
      paramca = this.WRh;
      paramca.gib = ad.a.gid;
      paramca.bpa();
      AppMethodBeat.o(35934);
      return;
    }
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0L;
    long l7 = Util.currentTicks();
    long l3 = l6;
    long l2 = l5;
    l1 = l4;
    if (parama == ad.a.gic)
    {
      paramca = h.a(paramca, paramg);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!Util.isNullOrNil(paramca))
      {
        l1 = com.tencent.mm.vfs.u.bBQ(paramca);
        paramca = h.bzu(paramca);
        l3 = paramca.outWidth;
        l2 = paramca.outHeight;
      }
    }
    paramca = this.WRh;
    paramca.ghW = l1;
    paramca.ghY = l2;
    paramca.ghX = l3;
    this.WRh.bpa();
    Log.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(Util.ticksToNow(l7)), this.WRh.agH() });
    this.WRh = null;
    AppMethodBeat.o(35934);
  }
  
  public final void avR(int paramInt)
  {
    AppMethodBeat.i(35904);
    Object localObject1 = avt(paramInt);
    Object localObject2 = cN((ca)localObject1);
    switch (2.WRj[localObject2.ordinal()])
    {
    default: 
      cQ((ca)localObject1);
      AppMethodBeat.o(35904);
      return;
    case 2: 
    case 3: 
      cP((ca)localObject1);
      AppMethodBeat.o(35904);
      return;
    }
    String str = l((ca)localObject1);
    localObject2 = new Intent(this.WQV, MsgRetransmitUI.class);
    ((Intent)localObject2).putExtra("Retr_File_Name", str);
    ((Intent)localObject2).putExtra("Retr_Msg_Id", ((et)localObject1).field_msgId);
    ((Intent)localObject2).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject2).putExtra("Retr_Msg_content", ((et)localObject1).field_content);
    ((Intent)localObject2).putExtra("Retr_Compress_Type", 0);
    localObject1 = this.WQV;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35904);
  }
  
  public final void avS(int paramInt)
  {
    AppMethodBeat.i(35905);
    Object localObject1 = avt(paramInt);
    Object localObject2 = cN((ca)localObject1);
    switch (2.WRj[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35905);
      return;
      localObject2 = new Intent(this.WQV, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject2).putExtra("Retr_Msg_Id", ((et)localObject1).field_msgId);
      localObject1 = this.WQV;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public final void avT(int paramInt)
  {
    AppMethodBeat.i(35914);
    Object localObject1 = avt(paramInt);
    if (this.WRe)
    {
      localObject1 = e.cG((ca)localObject1);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "doFavoriteImage mpShareVideoInfo should not be null");
        AppMethodBeat.o(35914);
        return;
      }
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.f.Quk;
      com.tencent.mm.plugin.webview.ui.tools.media.f.b((com.tencent.mm.aj.y)localObject1);
      com.tencent.mm.ui.base.h.cO(this.WQV, this.WQV.getString(R.l.favorite_ok));
      AppMethodBeat.o(35914);
      return;
    }
    Object localObject2 = new dd();
    com.tencent.mm.pluginsdk.model.j.d((dd)localObject2, (ca)localObject1);
    ((dd)localObject2).fyI.activity = this.WQV;
    ((dd)localObject2).fyI.fyP = 44;
    EventCenter.instance.publish((IEvent)localObject2);
    if (((dd)localObject2).fyJ.ret == 0)
    {
      if (((ca)localObject1).dlT()) {
        com.tencent.mm.ui.chatting.a.a(a.c.Wwh, a.d.Wwn, (ca)localObject1, 0);
      }
      com.tencent.mm.modelstat.b.mcf.aj((ca)localObject1);
    }
    AppMethodBeat.o(35914);
  }
  
  public final View avU(int paramInt)
  {
    AppMethodBeat.i(35922);
    View localView3 = super.aiI(paramInt);
    if (localView3 == null)
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35922);
      return null;
    }
    View localView2 = localView3.findViewById(R.h.dYF);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = localView3.findViewById(R.h.video_container);
    }
    if ((localView1 == null) || (localView1.getVisibility() == 8))
    {
      AppMethodBeat.o(35922);
      return null;
    }
    AppMethodBeat.o(35922);
    return localView1;
  }
  
  public final void avV(int paramInt)
  {
    AppMethodBeat.i(35923);
    this.WRb.k(avt(paramInt), paramInt);
    AppMethodBeat.o(35923);
  }
  
  public final void avW(int paramInt)
  {
    AppMethodBeat.i(35924);
    this.WRb.l(avt(paramInt), paramInt);
    AppMethodBeat.o(35924);
  }
  
  public final void avX(int paramInt)
  {
    AppMethodBeat.i(35927);
    this.WRb.avO(paramInt);
    AppMethodBeat.o(35927);
  }
  
  public final void avY(int paramInt)
  {
    AppMethodBeat.i(35930);
    ca localca = avt(paramInt);
    if ((localca == null) || (!j(localca)))
    {
      AppMethodBeat.o(35930);
      return;
    }
    this.WRa.cV(localca);
    AppMethodBeat.o(35930);
  }
  
  public final void avZ(int paramInt)
  {
    AppMethodBeat.i(35931);
    this.WRc.awe(paramInt);
    AppMethodBeat.o(35931);
  }
  
  public final ca avt(int paramInt)
  {
    AppMethodBeat.i(35894);
    ca localca = this.WQW.awb(paramInt);
    AppMethodBeat.o(35894);
    return localca;
  }
  
  public final void bU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35919);
    this.WRa.bU(paramInt, paramBoolean);
    AppMethodBeat.o(35919);
  }
  
  public final void cP(ca paramca)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(35908);
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.g(this.WQV, null);
      AppMethodBeat.o(35908);
      return;
    }
    if (paramca.dlS())
    {
      paramca = e.cG(paramca);
      if (paramca == null)
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitVideo mpShareVideoInfo should not be null");
        AppMethodBeat.o(35908);
        return;
      }
      if (this.WQV.QgI == null) {
        this.WQV.QgI = new com.tencent.mm.plugin.webview.ui.tools.media.e();
      }
      this.WQV.QgI.llv = paramca;
      if (this.WRe) {}
      for (;;)
      {
        paramca.lqn = this.WQV.WTa.QtB;
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.d.Qug;
        com.tencent.mm.plugin.webview.ui.tools.media.d.a(this.WQV, paramca.lpK, "", paramca.title, paramca.url, i);
        AppMethodBeat.o(35908);
        return;
        i = 0;
      }
    }
    com.tencent.mm.modelvideo.w localw = com.tencent.mm.modelvideo.y.Yk(paramca.field_imgPath);
    if (localw == null)
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      AppMethodBeat.o(35908);
      return;
    }
    Object localObject = new Intent(this.WQV, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_length", localw.lvw);
    ((Intent)localObject).putExtra("Retr_File_Name", paramca.field_imgPath);
    ((Intent)localObject).putExtra("Retr_video_isexport", localw.mhU);
    i = j;
    if (cJ(paramca)) {
      i = 11;
    }
    ((Intent)localObject).putExtra("Retr_Msg_Type", i);
    ((Intent)localObject).putExtra("Retr_Msg_Id", paramca.field_msgId);
    ((Intent)localObject).putExtra("Retr_From", "gallery");
    paramca = this.WQV;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramca, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramca.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramca, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35908);
  }
  
  public final void cQ(ca paramca)
  {
    AppMethodBeat.i(35910);
    com.tencent.mm.ay.g localg = h.k(paramca);
    if ((paramca == null) || (paramca.field_msgId == 0L) || (localg == null) || (localg.localId == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (paramca == null)
      {
        paramca = "null";
        localObject = ((StringBuilder)localObject).append(paramca).append(", imgLocalId = ");
        if (localg != null) {
          break label107;
        }
      }
      label107:
      for (paramca = "null";; paramca = Long.valueOf(localg.localId))
      {
        Log.e("MicroMsg.ImageGalleryAdapter", paramca);
        AppMethodBeat.o(35910);
        return;
        paramca = Long.valueOf(paramca.field_msgId);
        break;
      }
    }
    Object localObject = h.a(paramca, localg);
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + paramca.field_msgId + ", imgLocalId = " + localg.localId);
      AppMethodBeat.o(35910);
      return;
    }
    K((String)localObject, c(paramca, localg), paramca.field_msgId);
    AppMethodBeat.o(35910);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(35932);
    paramViewGroup.removeView((View)paramObject);
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    AppMethodBeat.o(35932);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(35917);
    this.WRa.detach();
    this.WRb.detach();
    this.WRc.detach();
    if (this.WRh != null)
    {
      ad localad = this.WRh.agP();
      localad.gib = ad.a.gid;
      localad.bpa();
    }
    super.detach();
    AppMethodBeat.o(35917);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(35915);
    final ca localca = avt(paramInt);
    View localView;
    final p localp;
    if (paramView == null)
    {
      localView = View.inflate(this.WQV, R.i.ehC, null);
      localp = new p(this, localView);
      localView.setTag(localp);
      paramView = cN(localca);
      localp.mPosition = paramInt;
      localp.WVA = paramView;
      p.aR(localp.convertView, 0);
      switch (p.5.WRj[paramView.ordinal()])
      {
      default: 
        label116:
        p.aR(localp.WVZ, 8);
        p.aR(localp.WWa, 8);
        p.aR(localp.WVQ, 8);
        p.aR(localp.WVW, 8);
        p.aR(localp.WVV, 8);
        Log.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (2.WRj[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.WRg = false;
      AppMethodBeat.o(35915);
      return localView;
      localp = (p)paramView.getTag();
      localView = paramView;
      break;
      p.aR(localp.WVI, 8);
      p.aR(localp.WVC, 8);
      break label116;
      localp.hSL();
      float f = bs.K(localca);
      localp.WVJ.setScaleX(f);
      localp.WVJ.setScaleY(f);
      ((View)localp.WVL).setScaleX(f);
      ((View)localp.WVL).setScaleY(f);
      p.aR(localp.WVI, 0);
      p.aR(localp.WVC, 8);
      if (localp.WVC == null) {
        break label116;
      }
      p.aR(localp.WVE, 8);
      break label116;
      localp.hSK();
      p.aR(localp.WVI, 8);
      p.aR(localp.WVC, 0);
      break label116;
      p.aR(localp.convertView, 8);
      p.aR(localp.WVI, 8);
      p.aR(localp.WVC, 8);
      break label116;
      this.WRa.a(localp, localca, paramInt);
      if (paramInt == a.WRo)
      {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).aA(localca);
        continue;
        p.aR(localp.WVZ, 0);
        p.aR(localp.WVQ, 8);
        p.aR(localp.WVV, 8);
        p.aR(localp.WVW, 8);
        p.aR(localp.WVM, 8);
        final String str = l(localca);
        try
        {
          paramView = com.tencent.mm.platformtools.u.ZT(str);
          localObject = paramView;
          if (paramView == null)
          {
            localObject = com.tencent.mm.platformtools.u.ZS(com.tencent.mm.ay.q.bmh().T(localca.field_imgPath, true));
            p.aR(localp.WVV, 0);
            new MMHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(282297);
                com.tencent.mm.pluginsdk.model.app.m.a(localca, new m.a()
                {
                  public final void lT(int paramAnonymous2Int1, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(288218);
                    if (paramAnonymous2Int1 == paramAnonymous2Int2)
                    {
                      Log.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(f.10.this.lrk.field_msgId) });
                      p.aR(f.10.this.WRl.WVV, 8);
                    }
                    try
                    {
                      Bitmap localBitmap1 = com.tencent.mm.platformtools.u.ZT(f.10.this.pqU);
                      if (localBitmap1 != null)
                      {
                        f.10.this.WRl.WVZ.setEnableHorLongBmpMode(false);
                        ForceGpuUtil.decideLayerType(f.10.this.WRl.WVZ, localBitmap1.getWidth(), localBitmap1.getHeight());
                        f.10.this.WRl.WVZ.di(localBitmap1.getWidth(), localBitmap1.getHeight());
                        f.10.this.WRl.WVZ.setImageBitmap(localBitmap1);
                        f.10.this.WRl.WVZ.invalidate();
                      }
                      AppMethodBeat.o(288218);
                      return;
                    }
                    catch (OutOfMemoryError localOutOfMemoryError)
                    {
                      for (;;)
                      {
                        Log.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { f.10.this.pqU });
                        Runtime.getRuntime().gc();
                        Runtime.getRuntime().runFinalization();
                        Bitmap localBitmap2 = com.tencent.mm.platformtools.u.ZS(f.10.this.pqU);
                      }
                    }
                  }
                });
                AppMethodBeat.o(282297);
              }
            });
          }
          if (localObject == null)
          {
            Log.w("MicroMsg.ImageGalleryAdapter", "get image fail");
            localp.WVZ.setVisibility(8);
            localp.hSJ().WVW.setVisibility(0);
            localp.hSJ().WVY.setImageResource(R.k.image_download_fail_icon);
            localp.hSJ().WVX.setText(this.WQV.getString(R.l.eHX));
            if (paramInt != a.WRo) {
              continue;
            }
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).aA(localca);
          }
        }
        catch (OutOfMemoryError paramView)
        {
          for (;;)
          {
            Object localObject;
            Log.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { str });
            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
            paramView = com.tencent.mm.platformtools.u.ZS(str);
            continue;
            localp.WVZ.setEnableHorLongBmpMode(false);
            ForceGpuUtil.decideLayerType(localp.WVZ, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localp.WVZ.di(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localp.WVZ.setImageBitmap((Bitmap)localObject);
            localp.WVZ.invalidate();
          }
        }
        this.WRb.a(localp, localca, paramInt);
        continue;
        this.WRc.a(localp, localca, paramInt);
      }
    }
  }
  
  public final int firstItemPosForDetermine()
  {
    AppMethodBeat.i(285433);
    int i = a.WRo;
    int j = a.c(this.WQW);
    AppMethodBeat.o(285433);
    return i - j;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(285422);
    int i = this.WQW.dpe();
    AppMethodBeat.o(285422);
    return i;
  }
  
  public final int getRealCount()
  {
    return this.WQW.jlf;
  }
  
  public final u hRD()
  {
    AppMethodBeat.i(285420);
    Object localObject1 = hRF();
    if (localObject1 == null)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(285420);
      return null;
    }
    Object localObject2 = cN((ca)localObject1);
    Log.i("MicroMsg.ImageGalleryAdapter", "getCurResourceState, type: ".concat(String.valueOf(localObject2)));
    switch (2.WRj[localObject2.ordinal()])
    {
    default: 
      AppMethodBeat.o(285420);
      return null;
    case 1: 
      localObject1 = this.WRa.hRD();
      AppMethodBeat.o(285420);
      return localObject1;
    case 2: 
      localObject1 = this.WRc.hRD();
      AppMethodBeat.o(285420);
      return localObject1;
    case 3: 
      localObject1 = this.WRb.hRD();
      AppMethodBeat.o(285420);
      return localObject1;
    }
    if (((ca)localObject1).Ic())
    {
      localObject1 = u.WWI;
      AppMethodBeat.o(285420);
      return localObject1;
    }
    localObject2 = k.b.OQ(((et)localObject1).field_content);
    if ((localObject2 != null) && (((k.b)localObject2).fvr != null) && (((k.b)localObject2).fvr.length() > 0))
    {
      localObject2 = ao.ctZ().bpR(((k.b)localObject2).fvr);
      int i;
      if ((localObject2 == null) || (!new com.tencent.mm.vfs.q(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath).ifE())) {
        i = 0;
      }
      while (i != 0)
      {
        localObject1 = u.WWK;
        AppMethodBeat.o(285420);
        return localObject1;
        if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).evg()) || ((((et)localObject1).field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload))) {
          i = 1;
        } else {
          i = 0;
        }
      }
      localObject1 = u.WWJ;
      AppMethodBeat.o(285420);
      return localObject1;
    }
    AppMethodBeat.o(285420);
    return null;
  }
  
  public final void hRE()
  {
    AppMethodBeat.i(35895);
    this.WQW.hRE();
    AppMethodBeat.o(35895);
  }
  
  public final ca hRF()
  {
    AppMethodBeat.i(35925);
    ca localca = avt(this.WQV.getCurrentItem());
    AppMethodBeat.o(35925);
    return localca;
  }
  
  public final p hRG()
  {
    AppMethodBeat.i(35926);
    Object localObject2 = this.WRa.avN(this.WQV.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.WRb.avN(this.WQV.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.WRc.avN(this.WQV.getCurrentItem());
    }
    AppMethodBeat.o(35926);
    return localObject2;
  }
  
  public final void hRH()
  {
    AppMethodBeat.i(285438);
    this.WRb.onPause();
    this.WRc.stopAll();
    AppMethodBeat.o(285438);
  }
  
  public final com.tencent.mm.ay.g i(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35896);
    paramca = this.WRa.i(paramca, paramBoolean);
    AppMethodBeat.o(35896);
    return paramca;
  }
  
  public final void j(ca paramca, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(35933);
    if (paramca == null)
    {
      AppMethodBeat.o(35933);
      return;
    }
    Object localObject = hRF();
    if ((localObject == null) || (((et)localObject).field_msgId != paramca.field_msgId))
    {
      Log.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((et)localObject).field_msgId), Long.valueOf(paramca.field_msgId) });
      AppMethodBeat.o(35933);
      return;
    }
    long l = paramca.field_msgSvrId;
    if ((this.WRh != null) && ((this.WRh.ghT != l) || (this.WRh.ghV != paramBoolean)))
    {
      localObject = this.WRh.agP();
      ((ad)localObject).gib = ad.a.gid;
      ((ad)localObject).bpa();
    }
    this.WRh = new ad();
    this.WRh.agO();
    localObject = this.WRh;
    ((ad)localObject).ghT = l;
    ((ad)localObject).ghU = paramca.field_createTime;
    ((ad)localObject).ghV = paramBoolean;
    if (ab.Lj(this.iVe)) {
      i = com.tencent.mm.model.v.Pu(this.iVe);
    }
    paramca = this.WRh;
    paramca.ggg = paramca.z("ChatName", this.iVe, true);
    paramca.ggi = i;
    AppMethodBeat.o(35933);
  }
  
  public final int lastItemPosForDetermine()
  {
    AppMethodBeat.i(285434);
    int i = a.WRo;
    int j = a.c(this.WQW);
    int k = a.d(this.WQW);
    AppMethodBeat.o(285434);
    return i - j + k - 1;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(35928);
    super.notifyDataSetChanged();
    AppMethodBeat.o(35928);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(35893);
    if ((this.WRa != null) && (j(avt(paramInt)))) {
      this.WRa.WSq.onPageSelected(paramInt);
    }
    AppMethodBeat.o(35893);
  }
  
  public static final class a
  {
    public static int WRo = 100000;
    private int WRp;
    protected int WRq;
    protected int WRr;
    protected int WRs;
    protected long WRt;
    private f WRu;
    public HashMap<Long, com.tencent.mm.ay.g> WRv;
    public HashMap<Long, com.tencent.mm.ay.g> WRw;
    protected boolean aMy;
    private int fromScene;
    private MMHandler handler;
    int jlf;
    private int min;
    private String talker;
    private List<ca> ziq;
    
    public a(final long paramLong, String paramString, final f paramf, Boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(35881);
      this.aMy = false;
      this.WRv = new HashMap();
      this.WRw = new HashMap();
      this.handler = new MMHandler();
      this.talker = paramString;
      this.ziq = new LinkedList();
      this.WRu = paramf;
      this.fromScene = paramInt;
      if (paramf.WRe)
      {
        paramString = e.f(paramString, paramf.WQV);
        this.ziq.add(paramString);
        WRo = 0;
        AppMethodBeat.o(35881);
        return;
      }
      WRo = 100000;
      bh.beI();
      paramString = com.tencent.mm.model.c.bbO().Oq(paramLong);
      if (paramString.field_msgId == 0L)
      {
        Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + Util.getStack(), false);
        AppMethodBeat.o(35881);
        return;
      }
      this.ziq.add(paramString);
      if (this.fromScene == 1)
      {
        paramInt = 1;
        if (paramInt == 0) {
          if (this.fromScene != 2) {
            break label238;
          }
        }
      }
      label238:
      for (paramInt = i;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label244;
        }
        AppMethodBeat.o(35881);
        return;
        paramInt = 0;
        break;
      }
      label244:
      bh.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35879);
          f.a.a(f.a.this, paramLong);
          if (paramf.booleanValue()) {
            f.a.b(f.a.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35878);
                f.a.a(f.a.this);
                if (f.a.1.this.WRz.WRd != null) {
                  f.a.1.this.WRz.WRd.qX();
                }
                AppMethodBeat.o(35878);
              }
            }, 0L);
          }
          AppMethodBeat.o(35879);
        }
      });
      paramf.WQV.WTV = new ImageGalleryUI.b()
      {
        public final void A(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35880);
          Log.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(paramAnonymousBoolean)));
          if (!paramAnonymousBoolean.booleanValue())
          {
            f.a.a(f.a.this);
            if (paramf.WRd != null) {
              paramf.WRd.qX();
            }
          }
          AppMethodBeat.o(35880);
        }
      };
      AppMethodBeat.o(35881);
    }
    
    private void R(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(35885);
      Log.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
      if (f.wIf) {
        bh.beI();
      }
      for (List localList = com.tencent.mm.model.c.bbP().c(this.talker, f.syu, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.bbO().e(this.talker, paramLong, paramBoolean))
      {
        Log.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(paramBoolean)));
        AppMethodBeat.o(35885);
        return;
        bh.beI();
      }
      Log.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
      paramLong = System.currentTimeMillis();
      kk(localList);
      Log.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
      if (paramBoolean)
      {
        this.ziq.addAll(localList);
        AppMethodBeat.o(35885);
        return;
      }
      this.ziq.addAll(0, localList);
      this.min -= localList.size();
      if (this.min < 0)
      {
        Log.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
        AppMethodBeat.o(35885);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("min from ");
      int i = this.min;
      Log.i("MicroMsg.AutoList", localList.size() + i + " to " + this.min);
      AppMethodBeat.o(35885);
    }
    
    private void kk(List<ca> paramList)
    {
      AppMethodBeat.i(35882);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (f.j((ca)paramList.get(i)))
        {
          localArrayList1.add(Long.valueOf(((ca)paramList.get(i)).field_msgSvrId));
          if (((ca)paramList.get(i)).field_isSend == 1) {
            localArrayList2.add(Long.valueOf(((ca)paramList.get(i)).field_msgId));
          }
        }
        i += 1;
      }
      this.WRv.putAll(com.tencent.mm.ay.q.bmh().a((Long[])localArrayList1.toArray(new Long[0])));
      this.WRw.putAll(com.tencent.mm.ay.q.bmh().b((Long[])localArrayList2.toArray(new Long[0])));
      AppMethodBeat.o(35882);
    }
    
    public final void a(long paramLong, com.tencent.mm.ay.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(35883);
      if (paramBoolean)
      {
        this.WRv.put(Long.valueOf(paramLong), paramg);
        AppMethodBeat.o(35883);
        return;
      }
      this.WRw.put(Long.valueOf(paramLong), paramg);
      AppMethodBeat.o(35883);
    }
    
    public final int awa(int paramInt)
    {
      return paramInt - WRo + this.WRp;
    }
    
    public final ca awb(int paramInt)
    {
      AppMethodBeat.i(35884);
      paramInt = awa(paramInt);
      int i = this.min + this.ziq.size() - 1;
      if ((paramInt < this.min) || (paramInt > i))
      {
        Log.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
        AppMethodBeat.o(35884);
        return null;
      }
      Log.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(paramInt)));
      if (paramInt == this.min)
      {
        localca = (ca)this.ziq.get(0);
        if (this.aMy) {
          R(localca.field_msgId, false);
        }
        AppMethodBeat.o(35884);
        return localca;
      }
      if ((paramInt == i) && (i < this.jlf - 1))
      {
        localca = (ca)this.ziq.get(this.ziq.size() - 1);
        if (this.aMy) {
          R(localca.field_msgId, true);
        }
        AppMethodBeat.o(35884);
        return localca;
      }
      ca localca = (ca)this.ziq.get(paramInt - this.min);
      AppMethodBeat.o(35884);
      return localca;
    }
    
    public final int dpe()
    {
      return this.jlf - this.WRp + WRo + 1;
    }
    
    public final void hRE()
    {
      this.aMy = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(35886);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AutoList, Size = " + this.ziq.size());
      ((StringBuilder)localObject).append("; Content = {");
      Iterator localIterator = this.ziq.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(((ca)localIterator.next()).field_msgId);
        ((StringBuilder)localObject).append(",");
      }
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(35886);
      return localObject;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(35891);
      WRC = new b("unkown", 0);
      WRD = new b("image", 1);
      WRE = new b("video", 2);
      WRF = new b("sight", 3);
      WRG = new b("appimage", 4);
      WRH = new b[] { WRC, WRD, WRE, WRF, WRG };
      AppMethodBeat.o(35891);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void qX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.f
 * JD-Core Version:    0.7.0.1
 */