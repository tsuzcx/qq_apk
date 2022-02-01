package com.tencent.mm.ui.chatting.gallery;

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
import com.tencent.mm.app.l.a;
import com.tencent.mm.app.l.b;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ag;
import com.tencent.mm.autogen.mmdata.rpt.ag.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelimage.f;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.webview.ui.tools.media.e;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.n.a;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import junit.framework.Assert;

public final class h
  extends com.tencent.mm.ui.base.ab
{
  public static boolean Aet = false;
  public static long vEb = -1L;
  private ArrayList<cc> Ann;
  public ImageGalleryUI aeAB;
  protected a aeAC;
  private String aeAD;
  boolean aeAE;
  public boolean aeAF;
  public j aeAG;
  public g aeAH;
  public o aeAI;
  public c aeAJ;
  public boolean aeAK;
  boolean aeAL;
  protected boolean aeAM;
  private ag aeAN;
  private int fromScene;
  private String lxj;
  
  public h(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35892);
    this.aeAE = true;
    this.aeAF = false;
    this.aeAK = false;
    this.lxj = null;
    this.aeAM = true;
    this.Ann = new ArrayList();
    this.aeAN = null;
    this.aeAK = paramImageGalleryUI.getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    boolean bool;
    if (!this.aeAK)
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
      this.aeAB = paramImageGalleryUI;
      Aet = paramBoolean1;
      vEb = paramLong2;
      this.lxj = paramString1;
      this.fromScene = paramInt;
      this.aeAC = new a(paramLong1, paramString1, this, paramBoolean, paramInt);
      this.aeAF = paramBoolean2;
      this.aeAD = paramString2;
      this.aeAC.dWF();
      this.aeAG = new j(this);
      if (!q.isEnabled()) {
        break label268;
      }
    }
    label268:
    for (this.aeAH = new q(this);; this.aeAH = new p(this))
    {
      this.aeAI = new o(this);
      AppMethodBeat.o(35892);
      return;
      bool = false;
      break;
    }
  }
  
  private void M(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35909);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
      AppMethodBeat.o(35909);
      return;
    }
    Object localObject;
    if (Util.isNullOrNil(this.aeAD))
    {
      Log.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      localObject = new Intent(this.aeAB, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Id", paramLong);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", paramInt);
      paramString = this.aeAB;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35909);
      return;
    }
    Log.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.aeAD });
    if (!Util.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.modelmulti.t.a(t.d.oNd).wg(4);
      ((t.e)localObject).hQQ = com.tencent.mm.model.z.bAM();
      ((t.e)localObject).toUser = this.aeAD;
      ((t.e)localObject).oIx = paramString;
      ((t.e)localObject).oGu = paramInt;
      ((t.e)localObject).oNk = null;
      ((t.e)localObject).oNj = 6;
      ((t.e)localObject).bKW().aXz();
      ch.bDg().f(ch.oni, null);
    }
    if (this.aeAE)
    {
      localObject = new Intent(this.aeAB, ChattingUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.aeAD);
      paramString = this.aeAB;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.aeAD });
      AppMethodBeat.o(35909);
      return;
      com.tencent.mm.ui.base.k.cZ(this.aeAB, this.aeAB.getString(R.l.app_saved));
    }
  }
  
  public static boolean a(Context paramContext, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(35912);
    if (paramcc == null)
    {
      AppMethodBeat.o(35912);
      return false;
    }
    final com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.v.bOh().PR(paramcc.field_imgPath);
    boolean bool = false;
    final String str1 = null;
    if (localz != null)
    {
      int i = 0;
      if (au.bwE(localz.bOs())) {
        i = com.tencent.mm.model.v.getMembersCountByChatRoomName(localz.bOs());
      }
      bool = localz.bOx();
      str1 = localz.oYk;
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.b(12084, new Object[] { Integer.valueOf(localz.osy), Integer.valueOf(localz.omT * 1000), Integer.valueOf(0), Integer.valueOf(2), localz.bOs(), Integer.valueOf(i), com.tencent.mm.modelvideo.z.PM(localz.bOu()), Long.valueOf(localz.createTime) });
    }
    if (!bool)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
      if (paramBoolean) {
        ExportFileUtil.N(paramContext, paramContext.getString(R.l.video_file_save_failed));
      }
      AppMethodBeat.o(35912);
      return false;
    }
    bool = false;
    Object localObject = com.tencent.mm.modelvideo.ab.Qo(str1);
    if (localObject != null) {
      bool = ((com.tencent.mm.modelvideo.z)localObject).bOx();
    }
    com.tencent.mm.modelvideo.v.bOh();
    if (bool) {}
    for (;;)
    {
      str1 = com.tencent.mm.modelvideo.aa.PX(str1);
      localObject = ExportFileUtil.P(paramContext, str1);
      if (!Util.isNullOrNil((String)localObject)) {
        break;
      }
      if (paramBoolean) {
        ExportFileUtil.N(paramContext, paramContext.getString(R.l.video_file_save_failed));
      }
      AppMethodBeat.o(35912);
      return false;
      str1 = paramcc.field_imgPath;
    }
    if (paramBoolean) {
      ExportFileUtil.N(paramContext, paramContext.getString(R.l.video_file_saved, new Object[] { AndroidMediaUtil.getFriendlySdcardPath((String)localObject) }));
    }
    String str2 = com.tencent.mm.vfs.y.bub((String)localObject);
    s locals = s.pBi;
    s.ci(str2, bt.JV(paramcc.jUr));
    AndroidMediaUtil.refreshMediaScannerAsync((String)localObject, paramContext);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254555);
        try
        {
          l.b localb;
          if (au.bwE(h.this.field_talker))
          {
            localb = com.tencent.mm.app.l.b(l.a.hgh);
            if (h.this.field_isSend == 1)
            {
              localb.hgk = com.tencent.mm.model.z.bAM();
              localb.hgl = h.this.field_talker;
            }
          }
          MultiMediaVideoChecker.a locala;
          for (;;)
          {
            locala = MultiMediaVideoChecker.ObB.aTG(str1);
            if (locala != null) {
              break;
            }
            Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get video data info, skip reporting. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(h.this.field_msgId), Long.valueOf(h.this.field_msgSvrId) });
            AppMethodBeat.o(254555);
            return;
            localb.hgk = br.JJ(h.this.field_content);
            localb.hgl = h.this.field_talker;
            continue;
            localb = com.tencent.mm.app.l.a(l.a.hgh);
            if (h.this.field_isSend == 1)
            {
              localb.hgk = com.tencent.mm.model.z.bAM();
              localb.hgl = h.this.field_talker;
            }
            else
            {
              localb.hgk = h.this.field_talker;
              localb.hgl = com.tencent.mm.model.z.bAM();
            }
          }
          if (localz != null) {}
          for (Object localObject = XmlParser.parseXml(localz.bOu(), "msg", null); localObject == null; localObject = Collections.emptyMap())
          {
            Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse recv xml. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(h.this.field_msgId), Long.valueOf(h.this.field_msgSvrId) });
            AppMethodBeat.o(254555);
            return;
          }
          localb.msgId = h.this.field_msgSvrId;
          localb.hgm = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
          localb.mediaWidth = locala.width;
          localb.mediaHeight = locala.height;
          localb.hgn = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnthumburl"));
          localb.hgo = ((int)locala.duration);
          localb.fileId = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
          localb.fileKey = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$aeskey"));
          localb.md5 = Util.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$md5"));
          if (au.bwE(h.this.field_talker))
          {
            localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jy(h.this.field_talker);
            if (localObject == null) {
              break label471;
            }
          }
          label471:
          for (int i = ((List)localObject).size();; i = 0)
          {
            localb.hgq = i;
            com.tencent.mm.app.l.a(localb);
            AppMethodBeat.o(254555);
            return;
          }
          return;
        }
        finally
        {
          Log.printErrStackTrace("MicroMsg.ImageGalleryAdapter", localThrowable, "[-] Exception was thrown when report.", new Object[0]);
          AppMethodBeat.o(254555);
        }
      }
    }, "MsgVideoExportReport");
    AppMethodBeat.o(35912);
    return true;
  }
  
  public static void b(Context paramContext, final cc paramcc)
  {
    AppMethodBeat.i(254524);
    if ((paramContext == null) || (paramcc == null))
    {
      AppMethodBeat.o(254524);
      return;
    }
    ExportFileUtil.a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(254524);
  }
  
  public static void b(final Context paramContext, final cc paramcc, final boolean paramBoolean)
  {
    AppMethodBeat.i(254536);
    if ((paramContext == null) || (paramcc == null))
    {
      AppMethodBeat.o(254536);
      return;
    }
    ExportFileUtil.a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(254536);
  }
  
  public static boolean b(cc paramcc, com.tencent.mm.modelimage.h paramh)
  {
    AppMethodBeat.i(35903);
    if ((paramcc == null) || (paramh == null))
    {
      AppMethodBeat.o(35903);
      return false;
    }
    boolean bool = com.tencent.mm.modelimage.r.bKb().c(paramh.localId, paramcc.field_msgId, 1);
    AppMethodBeat.o(35903);
    return bool;
  }
  
  public static int c(cc paramcc, com.tencent.mm.modelimage.h paramh)
  {
    AppMethodBeat.i(35918);
    if (paramcc.field_isSend == 1)
    {
      if (paramh.bJE())
      {
        paramcc = com.tencent.mm.modelimage.i.a(paramh);
        if ((paramcc != null) && (paramcc.localId > 0L) && (paramcc.bJD()) && (com.tencent.mm.vfs.y.ZC(com.tencent.mm.modelimage.r.bKa().v(paramcc.oGr, "", ""))))
        {
          AppMethodBeat.o(35918);
          return 1;
        }
      }
      AppMethodBeat.o(35918);
      return 0;
    }
    if (paramh.bJD())
    {
      if (paramh.bJE())
      {
        paramcc = com.tencent.mm.modelimage.i.a(paramh);
        if ((paramcc != null) && (paramcc.localId > 0L) && (paramcc.bJD()) && (com.tencent.mm.vfs.y.ZC(com.tencent.mm.modelimage.r.bKa().v(paramcc.oGr, "", ""))))
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
  
  public static boolean c(Context paramContext, final cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(35913);
    final com.tencent.mm.modelimage.h localh = null;
    if (dh(paramcc)) {}
    for (Object localObject = l(paramcc); (localObject == null) || (((String)localObject).length() == 0); localObject = j.a(paramcc, localh))
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + paramcc.field_msgId);
      if (paramBoolean) {
        ExportFileUtil.N(paramContext, paramContext.getString(R.l.save_image_err));
      }
      AppMethodBeat.o(35913);
      return false;
      if ((paramcc == null) || (paramcc.field_msgId == 0L))
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          ExportFileUtil.N(paramContext, paramContext.getString(R.l.save_image_err));
        }
        AppMethodBeat.o(35913);
        return false;
      }
      localh = j.k(paramcc);
      if ((localh == null) || (localh.localId == 0L))
      {
        localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (paramcc == null)
        {
          paramcc = "null";
          localObject = ((StringBuilder)localObject).append(paramcc).append(", imgLocalId = ");
          if (localh != null) {
            break label232;
          }
        }
        label232:
        for (paramcc = "null";; paramcc = Long.valueOf(localh.localId))
        {
          Log.e("MicroMsg.ImageGalleryAdapter", paramcc);
          if (paramBoolean) {
            ExportFileUtil.N(paramContext, paramContext.getString(R.l.save_image_err));
          }
          AppMethodBeat.o(35913);
          return false;
          paramcc = Long.valueOf(paramcc.field_msgId);
          break;
        }
      }
    }
    String str = ExportFileUtil.O(paramContext, (String)localObject);
    if (!Util.isNullOrNil(str))
    {
      if (paramBoolean) {
        ExportFileUtil.N(paramContext, paramContext.getString(R.l.cropimage_saved, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }));
      }
      com.tencent.threadpool.h.ahAA.g(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(254562);
          label528:
          for (;;)
          {
            try
            {
              BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(h.this);
              if (localOptions == null)
              {
                Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get bmp opts. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
                AppMethodBeat.o(254562);
                return;
              }
              l.b localb;
              if (au.bwE(paramcc.field_talker))
              {
                localb = com.tencent.mm.app.l.b(l.a.hgg);
                if (paramcc.field_isSend == 1)
                {
                  localb.hgk = com.tencent.mm.model.z.bAM();
                  localb.hgl = paramcc.field_talker;
                  localObject = com.tencent.mm.plugin.normsg.a.d.MtP.aQq(h.this);
                  if (localObject == null) {
                    break label528;
                  }
                  localObject = localObject[0];
                  if (localh != null)
                  {
                    localMap = XmlParser.parseXml(localh.oGC, "msg", null);
                    if (localMap != null) {
                      continue;
                    }
                    Log.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse cdn info. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
                    AppMethodBeat.o(254562);
                  }
                }
                else
                {
                  localb.hgk = br.JJ(paramcc.field_content);
                  localb.hgl = paramcc.field_talker;
                  continue;
                }
              }
              else
              {
                localb = com.tencent.mm.app.l.a(l.a.hgg);
                if (paramcc.field_isSend == 1)
                {
                  localb.hgk = com.tencent.mm.model.z.bAM();
                  localb.hgl = paramcc.field_talker;
                  continue;
                }
                localb.hgk = paramcc.field_talker;
                localb.hgl = com.tencent.mm.model.z.bAM();
                continue;
              }
              Map localMap = Collections.emptyMap();
              continue;
              String str;
              if (localh.oGu == 1)
              {
                str = (String)localMap.get(".msg.img.$cdnbigimgurl");
                localb.msgId = paramcc.field_msgSvrId;
                localb.hgm = Util.nullAsNil(str);
                localb.mediaWidth = localOptions.outWidth;
                localb.mediaHeight = localOptions.outHeight;
                localb.hgn = Util.nullAsNil((String)localMap.get(".msg.img.$cdnthumburl"));
                localb.fileId = Util.nullAsNil(str);
                localb.fileKey = Util.nullAsNil((String)localMap.get(".msg.img.$aeskey"));
                localb.md5 = com.tencent.mm.b.g.getMD5(h.this);
                localb.hgp = ((String)localObject);
                if (au.bwE(paramcc.field_talker))
                {
                  localObject = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jy(paramcc.field_talker);
                  if (localObject != null)
                  {
                    i = ((List)localObject).size();
                    localb.hgq = i;
                  }
                }
                else
                {
                  com.tencent.mm.app.l.a(localb);
                  AppMethodBeat.o(254562);
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
            finally
            {
              Log.printErrStackTrace("MicroMsg.ImageGalleryAdapter", localThrowable, "[-] Exception was thrown when report.", new Object[0]);
              AppMethodBeat.o(254562);
              return;
            }
          }
        }
      }, "MsgImgExportReport");
      paramContext = com.tencent.mm.vfs.y.bub(str);
      localObject = s.pBi;
      s.ci(paramContext, bt.JV(paramcc.jUr));
      AppMethodBeat.o(35913);
      return true;
    }
    if (paramBoolean) {
      ExportFileUtil.N(paramContext, paramContext.getString(R.l.save_image_err));
    }
    AppMethodBeat.o(35913);
    return false;
  }
  
  public static boolean df(cc paramcc)
  {
    AppMethodBeat.i(35899);
    if (paramcc == null)
    {
      AppMethodBeat.o(35899);
      return false;
    }
    if (paramcc.getType() == 62)
    {
      AppMethodBeat.o(35899);
      return true;
    }
    AppMethodBeat.o(35899);
    return false;
  }
  
  public static boolean dg(cc paramcc)
  {
    AppMethodBeat.i(35900);
    if (paramcc == null)
    {
      AppMethodBeat.o(35900);
      return false;
    }
    if (paramcc.getType() == 49)
    {
      AppMethodBeat.o(35900);
      return true;
    }
    AppMethodBeat.o(35900);
    return false;
  }
  
  public static boolean dh(cc paramcc)
  {
    AppMethodBeat.i(35901);
    if (paramcc == null)
    {
      AppMethodBeat.o(35901);
      return false;
    }
    if (paramcc.getType() == 268435505)
    {
      AppMethodBeat.o(35901);
      return true;
    }
    AppMethodBeat.o(35901);
    return false;
  }
  
  public static boolean di(cc paramcc)
  {
    AppMethodBeat.i(35902);
    if (paramcc == null)
    {
      AppMethodBeat.o(35902);
      return false;
    }
    boolean bool = paramcc.dSI();
    AppMethodBeat.o(35902);
    return bool;
  }
  
  public static b dk(cc paramcc)
  {
    AppMethodBeat.i(35906);
    b localb = b.aeBh;
    if (paramcc == null) {
      localb = b.aeBh;
    }
    if (dh(paramcc))
    {
      paramcc = b.aeBl;
      AppMethodBeat.o(35906);
      return paramcc;
    }
    if (j(paramcc))
    {
      paramcc = b.aeBi;
      AppMethodBeat.o(35906);
      return paramcc;
    }
    if (dl(paramcc))
    {
      paramcc = b.aeBk;
      AppMethodBeat.o(35906);
      return paramcc;
    }
    if (m(paramcc))
    {
      paramcc = b.aeBj;
      AppMethodBeat.o(35906);
      return paramcc;
    }
    if (df(paramcc))
    {
      paramcc = b.aeBj;
      AppMethodBeat.o(35906);
      return paramcc;
    }
    paramcc = b.aeBh;
    AppMethodBeat.o(35906);
    return paramcc;
  }
  
  public static boolean dl(cc paramcc)
  {
    AppMethodBeat.i(35907);
    if (paramcc != null)
    {
      if (paramcc.dSI())
      {
        AppMethodBeat.o(35907);
        return false;
      }
      paramcc = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
      if ((paramcc != null) && (paramcc.pbk != null) && ((!Util.isNullOrNil(paramcc.pbk.nTu)) || (paramcc.pbk.ZBc > 0) || (!Util.isNullOrNil(paramcc.pbk.nTx)) || (!Util.isNullOrNil(paramcc.pbk.nTy)) || (!Util.isNullOrNil(paramcc.pbk.nTw)) || (!Util.isNullOrNil(paramcc.pbk.nTz)) || (!Util.isNullOrNil(paramcc.pbk.nTA)) || (!Util.isNullOrNil(paramcc.pbk.nTB))))
      {
        AppMethodBeat.o(35907);
        return true;
      }
    }
    AppMethodBeat.o(35907);
    return false;
  }
  
  public static void g(final Context paramContext, List<cc> paramList)
  {
    AppMethodBeat.i(254519);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(254519);
      return;
    }
    ExportFileUtil.a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(254519);
  }
  
  public static boolean j(cc paramcc)
  {
    AppMethodBeat.i(35897);
    if (paramcc == null)
    {
      AppMethodBeat.o(35897);
      return false;
    }
    if ((paramcc.getType() == 3) || (paramcc.getType() == 39) || (paramcc.getType() == 13))
    {
      AppMethodBeat.o(35897);
      return true;
    }
    AppMethodBeat.o(35897);
    return false;
  }
  
  public static String l(cc paramcc)
  {
    Object localObject1 = null;
    AppMethodBeat.i(35916);
    Object localObject2 = k.b.Hf(paramcc.field_content);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35916);
      return null;
    }
    paramcc = localObject1;
    if (((k.b)localObject2).hzM != null)
    {
      paramcc = localObject1;
      if (((k.b)localObject2).hzM.length() > 0)
      {
        localObject2 = as.cWJ().bpI(((k.b)localObject2).hzM);
        paramcc = localObject1;
        if (localObject2 != null) {
          paramcc = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        }
      }
    }
    AppMethodBeat.o(35916);
    return paramcc;
  }
  
  public static boolean m(cc paramcc)
  {
    AppMethodBeat.i(35898);
    if (paramcc == null)
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if (dl(paramcc))
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if ((paramcc.getType() == 43) || (paramcc.getType() == 486539313) || (paramcc.getType() == 44) || (paramcc.getType() == 62))
    {
      AppMethodBeat.o(35898);
      return true;
    }
    AppMethodBeat.o(35898);
    return false;
  }
  
  public final MultiTouchImageView WN(int paramInt)
  {
    AppMethodBeat.i(35920);
    Object localObject = super.aAZ(paramInt);
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
  
  public final WxImageView WO(int paramInt)
  {
    AppMethodBeat.i(35921);
    Object localObject = super.aAZ(paramInt);
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
  
  public final void a(cc paramcc, com.tencent.mm.modelimage.h paramh, int paramInt, ag.a parama)
  {
    AppMethodBeat.i(35934);
    if (paramcc == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    if (this.aeAN == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    this.aeAN.aIJ().inW = parama;
    long l1 = paramcc.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.aeAN.inO != l1) && (this.aeAN.inQ != i); i = 0)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.aeAN.inO), Long.valueOf(l1) });
      paramcc = this.aeAN;
      paramcc.inW = ag.a.inY;
      paramcc.bMH();
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
    if (parama == ag.a.inX)
    {
      paramcc = j.a(paramcc, paramh);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!Util.isNullOrNil(paramcc))
      {
        l1 = com.tencent.mm.vfs.y.bEl(paramcc);
        paramcc = j.bBh(paramcc);
        l3 = paramcc.outWidth;
        l2 = paramcc.outHeight;
      }
    }
    paramcc = this.aeAN;
    paramcc.inR = l1;
    paramcc.inT = l2;
    paramcc.inS = l3;
    this.aeAN.bMH();
    Log.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(Util.ticksToNow(l7)), this.aeAN.aIE() });
    this.aeAN = null;
    AppMethodBeat.o(35934);
  }
  
  public final cc aBV(int paramInt)
  {
    AppMethodBeat.i(35894);
    cc localcc = this.aeAC.aCK(paramInt);
    AppMethodBeat.o(35894);
    return localcc;
  }
  
  public final void aCA(int paramInt)
  {
    AppMethodBeat.i(35904);
    Object localObject1 = aBV(paramInt);
    Object localObject2 = dk((cc)localObject1);
    switch (2.aeAP[localObject2.ordinal()])
    {
    default: 
      dn((cc)localObject1);
      AppMethodBeat.o(35904);
      return;
    case 2: 
    case 3: 
      dm((cc)localObject1);
      AppMethodBeat.o(35904);
      return;
    }
    String str = l((cc)localObject1);
    localObject2 = new Intent(this.aeAB, MsgRetransmitUI.class);
    ((Intent)localObject2).putExtra("Retr_File_Name", str);
    ((Intent)localObject2).putExtra("Retr_Msg_Id", ((fi)localObject1).field_msgId);
    ((Intent)localObject2).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject2).putExtra("Retr_Msg_content", ((fi)localObject1).field_content);
    ((Intent)localObject2).putExtra("Retr_Compress_Type", 0);
    localObject1 = this.aeAB;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35904);
  }
  
  public final void aCB(int paramInt)
  {
    AppMethodBeat.i(35905);
    Object localObject1 = aBV(paramInt);
    Object localObject2 = dk((cc)localObject1);
    switch (2.aeAP[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35905);
      return;
      localObject2 = new Intent(this.aeAB, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject2).putExtra("Retr_Msg_Id", ((fi)localObject1).field_msgId);
      localObject1 = this.aeAB;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public final void aCC(int paramInt)
  {
    AppMethodBeat.i(35914);
    Object localObject1 = aBV(paramInt);
    if (this.aeAK)
    {
      localObject1 = g.dc((cc)localObject1);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "doFavoriteImage mpShareVideoInfo should not be null");
        AppMethodBeat.o(35914);
        return;
      }
      localObject2 = e.Xml;
      e.c((com.tencent.mm.message.y)localObject1);
      com.tencent.mm.ui.base.k.cZ(this.aeAB, this.aeAB.getString(R.l.favorite_ok));
      AppMethodBeat.o(35914);
      return;
    }
    Object localObject2 = new dn();
    com.tencent.mm.pluginsdk.model.l.d((dn)localObject2, (cc)localObject1);
    ((dn)localObject2).hDr.activity = this.aeAB;
    ((dn)localObject2).hDr.hDy = 44;
    ((dn)localObject2).publish();
    if (((dn)localObject2).hDs.ret == 0)
    {
      if (((cc)localObject1).dSJ()) {
        com.tencent.mm.ui.chatting.a.a(a.c.aedy, a.d.aedE, (cc)localObject1, 0);
      }
      com.tencent.mm.modelstat.b.oUZ.ao((cc)localObject1);
    }
    AppMethodBeat.o(35914);
  }
  
  public final View aCD(int paramInt)
  {
    AppMethodBeat.i(35922);
    View localView3 = super.aAZ(paramInt);
    if (localView3 == null)
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35922);
      return null;
    }
    View localView2 = localView3.findViewById(R.h.gbt);
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
  
  public final void aCE(int paramInt)
  {
    AppMethodBeat.i(35923);
    this.aeAH.k(aBV(paramInt), paramInt);
    AppMethodBeat.o(35923);
  }
  
  public final void aCF(int paramInt)
  {
    AppMethodBeat.i(35924);
    this.aeAH.l(aBV(paramInt), paramInt);
    AppMethodBeat.o(35924);
  }
  
  public final void aCG(int paramInt)
  {
    AppMethodBeat.i(35927);
    this.aeAH.aCu(paramInt);
    AppMethodBeat.o(35927);
  }
  
  public final void aCH(int paramInt)
  {
    AppMethodBeat.i(35930);
    cc localcc = aBV(paramInt);
    if ((localcc == null) || (!j(localcc)))
    {
      AppMethodBeat.o(35930);
      return;
    }
    this.aeAG.ds(localcc);
    AppMethodBeat.o(35930);
  }
  
  public final void aCI(int paramInt)
  {
    AppMethodBeat.i(35931);
    this.aeAI.aCN(paramInt);
    AppMethodBeat.o(35931);
  }
  
  public final void cH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35919);
    this.aeAG.cH(paramInt, paramBoolean);
    AppMethodBeat.o(35919);
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
    this.aeAG.detach();
    this.aeAH.detach();
    this.aeAI.detach();
    if (this.aeAN != null)
    {
      ag localag = this.aeAN.aIJ();
      localag.inW = ag.a.inY;
      localag.bMH();
    }
    super.detach();
    AppMethodBeat.o(35917);
  }
  
  public final boolean dj(cc paramcc)
  {
    AppMethodBeat.i(254600);
    if (paramcc == null)
    {
      AppMethodBeat.o(254600);
      return false;
    }
    com.tencent.mm.modelimage.h localh = j(paramcc, false);
    if (localh != null)
    {
      if ((paramcc == null) || (localh == null))
      {
        AppMethodBeat.o(254600);
        return false;
      }
      if ((com.tencent.mm.modelimage.r.bKb().c(localh.localId, paramcc.field_msgId, 0)) || (b(paramcc, localh)))
      {
        AppMethodBeat.o(254600);
        return true;
      }
      AppMethodBeat.o(254600);
      return false;
    }
    paramcc = g.dd(paramcc);
    if (paramcc != null)
    {
      if (paramcc == null)
      {
        AppMethodBeat.o(254600);
        return false;
      }
      int i = paramcc.status;
      int j = com.tencent.mm.modelvideo.ab.g(paramcc);
      if (((i == 112) || (i == 122)) && (j < 100)) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
        AppMethodBeat.o(254600);
        return bool;
      }
    }
    AppMethodBeat.o(254600);
    return false;
  }
  
  public final void dm(cc paramcc)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(35908);
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.aa.j(this.aeAB, null);
      AppMethodBeat.o(35908);
      return;
    }
    if (paramcc.dSI())
    {
      paramcc = g.dc(paramcc);
      if (paramcc == null)
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitVideo mpShareVideoInfo should not be null");
        AppMethodBeat.o(35908);
        return;
      }
      if (this.aeAB.WYF == null) {
        this.aeAB.WYF = new com.tencent.mm.plugin.webview.ui.tools.media.d();
      }
      this.aeAB.WYF.nQs = paramcc;
      if (this.aeAK) {}
      for (;;)
      {
        paramcc.nVq = this.aeAB.aeCD.XlS;
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.c.Xmk;
        com.tencent.mm.plugin.webview.ui.tools.media.c.a(this.aeAB, paramcc.nUM, "", paramcc.title, paramcc.url, i);
        AppMethodBeat.o(35908);
        return;
        i = 0;
      }
    }
    com.tencent.mm.modelvideo.z localz = com.tencent.mm.modelvideo.ab.Qo(paramcc.field_imgPath);
    if (localz == null)
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      AppMethodBeat.o(35908);
      return;
    }
    Object localObject = new Intent(this.aeAB, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_length", localz.omT);
    ((Intent)localObject).putExtra("Retr_File_Name", paramcc.field_imgPath);
    ((Intent)localObject).putExtra("Retr_video_isexport", localz.pbf);
    i = j;
    if (df(paramcc)) {
      i = 11;
    }
    ((Intent)localObject).putExtra("Retr_Msg_Type", i);
    ((Intent)localObject).putExtra("Retr_Msg_Id", paramcc.field_msgId);
    ((Intent)localObject).putExtra("Retr_From", "gallery");
    paramcc = this.aeAB;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramcc, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramcc.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramcc, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35908);
  }
  
  public final void dn(cc paramcc)
  {
    AppMethodBeat.i(35910);
    com.tencent.mm.modelimage.h localh = j.k(paramcc);
    if ((paramcc == null) || (paramcc.field_msgId == 0L) || (localh == null) || (localh.localId == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (paramcc == null)
      {
        paramcc = "null";
        localObject = ((StringBuilder)localObject).append(paramcc).append(", imgLocalId = ");
        if (localh != null) {
          break label107;
        }
      }
      label107:
      for (paramcc = "null";; paramcc = Long.valueOf(localh.localId))
      {
        Log.e("MicroMsg.ImageGalleryAdapter", paramcc);
        AppMethodBeat.o(35910);
        return;
        paramcc = Long.valueOf(paramcc.field_msgId);
        break;
      }
    }
    Object localObject = j.a(paramcc, localh);
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + paramcc.field_msgId + ", imgLocalId = " + localh.localId);
      AppMethodBeat.o(35910);
      return;
    }
    M((String)localObject, c(paramcc, localh), paramcc.field_msgId);
    AppMethodBeat.o(35910);
  }
  
  public final int firstItemPosForDetermine()
  {
    AppMethodBeat.i(254642);
    int i = a.aeAT;
    int j = a.c(this.aeAC);
    AppMethodBeat.o(254642);
    return i - j;
  }
  
  public final View g(int paramInt, View paramView)
  {
    AppMethodBeat.i(35915);
    final cc localcc = aBV(paramInt);
    View localView;
    final r localr;
    if (paramView == null)
    {
      localView = View.inflate(this.aeAB, R.i.gkx, null);
      localr = new r(this, localView);
      localView.setTag(localr);
      paramView = dk(localcc);
      localr.mPosition = paramInt;
      localr.aeFg = paramView;
      r.bo(localr.convertView, 0);
      switch (r.5.aeAP[paramView.ordinal()])
      {
      default: 
        label116:
        r.bo(localr.aeFF, 8);
        r.bo(localr.aeFG, 8);
        r.bo(localr.aeFw, 8);
        r.bo(localr.aeFC, 8);
        r.bo(localr.aeFB, 8);
        Log.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (2.aeAP[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.aeAM = false;
      AppMethodBeat.o(35915);
      return localView;
      localr = (r)paramView.getTag();
      localView = paramView;
      break;
      r.bo(localr.aeFo, 8);
      r.bo(localr.aeFi, 8);
      break label116;
      localr.jwq();
      float f = bt.M(localcc);
      localr.aeFp.setScaleX(f);
      localr.aeFp.setScaleY(f);
      ((View)localr.aeFr).setScaleX(f);
      ((View)localr.aeFr).setScaleY(f);
      r.bo(localr.aeFo, 0);
      r.bo(localr.aeFi, 8);
      if (localr.aeFi == null) {
        break label116;
      }
      r.bo(localr.aeFk, 8);
      break label116;
      localr.jwp();
      r.bo(localr.aeFo, 8);
      r.bo(localr.aeFi, 0);
      break label116;
      r.bo(localr.convertView, 8);
      r.bo(localr.aeFo, 8);
      r.bo(localr.aeFi, 8);
      break label116;
      this.aeAG.a(localr, localcc, paramInt);
      if (paramInt == a.aeAT)
      {
        ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).aJ(localcc);
        continue;
        r.bo(localr.aeFF, 0);
        r.bo(localr.aeFw, 8);
        r.bo(localr.aeFB, 8);
        r.bo(localr.aeFC, 8);
        r.bo(localr.aeFs, 8);
        final String str = l(localcc);
        try
        {
          paramView = com.tencent.mm.platformtools.r.Sh(str);
          localObject = paramView;
          if (paramView == null)
          {
            localObject = com.tencent.mm.platformtools.r.Sg(com.tencent.mm.modelimage.r.bKa().X(localcc.field_imgPath, true));
            r.bo(localr.aeFB, 0);
            new MMHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(254429);
                n.a(localcc, new n.a()
                {
                  public final void nH(int paramAnonymous2Int1, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(254734);
                    if (paramAnonymous2Int1 == paramAnonymous2Int2)
                    {
                      Log.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(h.10.this.oiL.field_msgId) });
                      r.bo(h.10.this.aeAw.aeFB, 8);
                    }
                    try
                    {
                      Bitmap localBitmap1 = com.tencent.mm.platformtools.r.Sh(h.10.this.svE);
                      if (localBitmap1 != null)
                      {
                        h.10.this.aeAw.aeFF.setEnableHorLongBmpMode(false);
                        ForceGpuUtil.decideLayerType(h.10.this.aeAw.aeFF, localBitmap1.getWidth(), localBitmap1.getHeight());
                        h.10.this.aeAw.aeFF.dU(localBitmap1.getWidth(), localBitmap1.getHeight());
                        h.10.this.aeAw.aeFF.setImageBitmap(localBitmap1);
                        h.10.this.aeAw.aeFF.invalidate();
                      }
                      AppMethodBeat.o(254734);
                      return;
                    }
                    catch (OutOfMemoryError localOutOfMemoryError)
                    {
                      for (;;)
                      {
                        Log.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { h.10.this.svE });
                        Runtime.getRuntime().gc();
                        Runtime.getRuntime().runFinalization();
                        Bitmap localBitmap2 = com.tencent.mm.platformtools.r.Sg(h.10.this.svE);
                      }
                    }
                  }
                });
                AppMethodBeat.o(254429);
              }
            });
          }
          if (localObject == null)
          {
            Log.w("MicroMsg.ImageGalleryAdapter", "get image fail");
            localr.aeFF.setVisibility(8);
            localr.jwo().aeFC.setVisibility(0);
            localr.jwo().aeFE.setImageResource(R.k.image_download_fail_icon);
            localr.jwo().aeFD.setText(this.aeAB.getString(R.l.gJE));
            if (paramInt != a.aeAT) {
              continue;
            }
            ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).aJ(localcc);
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
            paramView = com.tencent.mm.platformtools.r.Sg(str);
            continue;
            localr.aeFF.setEnableHorLongBmpMode(false);
            ForceGpuUtil.decideLayerType(localr.aeFF, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localr.aeFF.dU(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localr.aeFF.setImageBitmap((Bitmap)localObject);
            localr.aeFF.invalidate();
          }
        }
        this.aeAH.a(localr, localcc, paramInt);
        continue;
        this.aeAI.a(localr, localcc, paramInt);
      }
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(254575);
    int i = this.aeAC.dWF();
    AppMethodBeat.o(254575);
    return i;
  }
  
  public final int getRealCount()
  {
    return this.aeAC.lNX;
  }
  
  public final com.tencent.mm.modelimage.h j(cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(35896);
    paramcc = this.aeAG.j(paramcc, paramBoolean);
    AppMethodBeat.o(35896);
    return paramcc;
  }
  
  public final w jvb()
  {
    AppMethodBeat.i(254564);
    Object localObject1 = jvd();
    if (localObject1 == null)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(254564);
      return null;
    }
    Object localObject2 = dk((cc)localObject1);
    Log.i("MicroMsg.ImageGalleryAdapter", "getCurResourceState, type: ".concat(String.valueOf(localObject2)));
    switch (2.aeAP[localObject2.ordinal()])
    {
    default: 
      AppMethodBeat.o(254564);
      return null;
    case 1: 
      localObject1 = this.aeAG.jvb();
      AppMethodBeat.o(254564);
      return localObject1;
    case 2: 
      localObject1 = this.aeAI.jvb();
      AppMethodBeat.o(254564);
      return localObject1;
    case 3: 
      localObject1 = this.aeAH.jvb();
      AppMethodBeat.o(254564);
      return localObject1;
    }
    if (((cc)localObject1).isClean())
    {
      localObject1 = w.aeGm;
      AppMethodBeat.o(254564);
      return localObject1;
    }
    localObject2 = k.b.Hf(((fi)localObject1).field_content);
    if ((localObject2 != null) && (((k.b)localObject2).hzM != null) && (((k.b)localObject2).hzM.length() > 0))
    {
      localObject2 = as.cWJ().bpI(((k.b)localObject2).hzM);
      int i;
      if ((localObject2 == null) || (!new u(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath).jKS())) {
        i = 0;
      }
      while (i != 0)
      {
        localObject1 = w.aeGo;
        AppMethodBeat.o(254564);
        return localObject1;
        if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).efT()) || ((((fi)localObject1).field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload))) {
          i = 1;
        } else {
          i = 0;
        }
      }
      localObject1 = w.aeGn;
      AppMethodBeat.o(254564);
      return localObject1;
    }
    AppMethodBeat.o(254564);
    return null;
  }
  
  public final void jvc()
  {
    AppMethodBeat.i(35895);
    this.aeAC.jvc();
    AppMethodBeat.o(35895);
  }
  
  public final cc jvd()
  {
    AppMethodBeat.i(35925);
    cc localcc = aBV(this.aeAB.getCurrentItem());
    AppMethodBeat.o(35925);
    return localcc;
  }
  
  public final r jve()
  {
    AppMethodBeat.i(35926);
    Object localObject2 = this.aeAG.aCt(this.aeAB.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.aeAH.aCt(this.aeAB.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.aeAI.aCt(this.aeAB.getCurrentItem());
    }
    AppMethodBeat.o(35926);
    return localObject2;
  }
  
  public final void jvf()
  {
    AppMethodBeat.i(254687);
    this.aeAH.onPause();
    this.aeAI.stopAll();
    AppMethodBeat.o(254687);
  }
  
  public final void k(cc paramcc, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(35933);
    if (paramcc == null)
    {
      AppMethodBeat.o(35933);
      return;
    }
    Object localObject = jvd();
    if ((localObject == null) || (((fi)localObject).field_msgId != paramcc.field_msgId))
    {
      Log.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((fi)localObject).field_msgId), Long.valueOf(paramcc.field_msgId) });
      AppMethodBeat.o(35933);
      return;
    }
    long l = paramcc.field_msgSvrId;
    if ((this.aeAN != null) && ((this.aeAN.inO != l) || (this.aeAN.inQ != paramBoolean)))
    {
      localObject = this.aeAN.aIJ();
      ((ag)localObject).inW = ag.a.inY;
      ((ag)localObject).bMH();
    }
    this.aeAN = new ag();
    this.aeAN.aII();
    localObject = this.aeAN;
    ((ag)localObject).inO = l;
    ((ag)localObject).inP = paramcc.getCreateTime();
    ((ag)localObject).inQ = paramBoolean;
    if (au.bwE(this.lxj)) {
      i = com.tencent.mm.model.v.getMembersCountByChatRoomName(this.lxj);
    }
    paramcc = this.aeAN;
    paramcc.imN = paramcc.F("ChatName", this.lxj, true);
    paramcc.imZ = i;
    AppMethodBeat.o(35933);
  }
  
  public final int lastItemPosForDetermine()
  {
    AppMethodBeat.i(254648);
    int i = a.aeAT;
    int j = a.c(this.aeAC);
    int k = a.d(this.aeAC);
    AppMethodBeat.o(254648);
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
    if ((this.aeAG != null) && (j(aBV(paramInt)))) {
      this.aeAG.aeBV.onPageSelected(paramInt);
    }
    AppMethodBeat.o(35893);
  }
  
  public static final class a
  {
    public static int aeAT = 100000;
    private List<cc> EgE;
    private int aeAU;
    protected int aeAV;
    protected int aeAW;
    protected int aeAX;
    protected long aeAY;
    private h aeAZ;
    public HashMap<Long, com.tencent.mm.modelimage.h> aeBa;
    public HashMap<Long, com.tencent.mm.modelimage.h> aeBb;
    protected boolean cGv;
    private int fromScene;
    private MMHandler handler;
    int lNX;
    private int min;
    private String talker;
    
    public a(final long paramLong, String paramString, final h paramh, Boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(35881);
      this.cGv = false;
      this.aeBa = new HashMap();
      this.aeBb = new HashMap();
      this.handler = new MMHandler();
      this.talker = paramString;
      this.EgE = new LinkedList();
      this.aeAZ = paramh;
      this.fromScene = paramInt;
      if (paramh.aeAK)
      {
        paramString = g.g(paramString, paramh.aeAB);
        this.EgE.add(paramString);
        aeAT = 0;
        AppMethodBeat.o(35881);
        return;
      }
      aeAT = 100000;
      bh.bCz();
      paramString = com.tencent.mm.model.c.bzD().sl(paramLong);
      if ((paramString == null) || (paramString.field_msgId == 0L))
      {
        Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + Util.getStack(), false);
        AppMethodBeat.o(35881);
        return;
      }
      this.EgE.add(paramString);
      if (this.fromScene == 1)
      {
        paramInt = 1;
        if (paramInt == 0) {
          if (this.fromScene != 2) {
            break label242;
          }
        }
      }
      label242:
      for (paramInt = i;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label248;
        }
        AppMethodBeat.o(35881);
        return;
        paramInt = 0;
        break;
      }
      label248:
      bh.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35879);
          h.a.a(h.a.this, paramLong);
          if (paramh.booleanValue()) {
            h.a.b(h.a.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35878);
                h.a.a(h.a.this);
                if (h.a.1.this.aeBe.aeAJ != null) {
                  h.a.1.this.aeBe.aeAJ.Qz();
                }
                AppMethodBeat.o(35878);
              }
            }, 0L);
          }
          AppMethodBeat.o(35879);
        }
      });
      paramh.aeAB.aeDE = new ImageGalleryUI.b()
      {
        public final void M(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35880);
          Log.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(paramAnonymousBoolean)));
          if (!paramAnonymousBoolean.booleanValue())
          {
            h.a.a(h.a.this);
            if (paramh.aeAJ != null) {
              paramh.aeAJ.Qz();
            }
          }
          AppMethodBeat.o(35880);
        }
      };
      AppMethodBeat.o(35881);
    }
    
    private void ac(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(35885);
      Log.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
      if (h.Aet) {
        bh.bCz();
      }
      for (List localList = com.tencent.mm.model.c.bzE().b(this.talker, h.vEb, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.bzD().e(this.talker, paramLong, paramBoolean))
      {
        Log.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(paramBoolean)));
        AppMethodBeat.o(35885);
        return;
        bh.bCz();
      }
      Log.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
      paramLong = System.currentTimeMillis();
      nA(localList);
      Log.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
      if (paramBoolean)
      {
        this.EgE.addAll(localList);
        AppMethodBeat.o(35885);
        return;
      }
      this.EgE.addAll(0, localList);
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
    
    private void nA(List<cc> paramList)
    {
      AppMethodBeat.i(35882);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (h.j((cc)paramList.get(i)))
        {
          localArrayList1.add(Long.valueOf(((cc)paramList.get(i)).field_msgSvrId));
          if (((cc)paramList.get(i)).field_isSend == 1) {
            localArrayList2.add(Long.valueOf(((cc)paramList.get(i)).field_msgId));
          }
        }
        i += 1;
      }
      this.aeBa.putAll(com.tencent.mm.modelimage.r.bKa().a((Long[])localArrayList1.toArray(new Long[0])));
      this.aeBb.putAll(com.tencent.mm.modelimage.r.bKa().b((Long[])localArrayList2.toArray(new Long[0])));
      AppMethodBeat.o(35882);
    }
    
    public final void a(long paramLong, com.tencent.mm.modelimage.h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(35883);
      if (paramBoolean)
      {
        this.aeBa.put(Long.valueOf(paramLong), paramh);
        AppMethodBeat.o(35883);
        return;
      }
      this.aeBb.put(Long.valueOf(paramLong), paramh);
      AppMethodBeat.o(35883);
    }
    
    public final int aCJ(int paramInt)
    {
      return paramInt - aeAT + this.aeAU;
    }
    
    public final cc aCK(int paramInt)
    {
      AppMethodBeat.i(35884);
      paramInt = aCJ(paramInt);
      int i = this.min + this.EgE.size() - 1;
      if ((paramInt < this.min) || (paramInt > i))
      {
        Log.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
        AppMethodBeat.o(35884);
        return null;
      }
      Log.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(paramInt)));
      if (paramInt == this.min)
      {
        localcc = (cc)this.EgE.get(0);
        if (this.cGv) {
          ac(localcc.field_msgId, false);
        }
        AppMethodBeat.o(35884);
        return localcc;
      }
      if ((paramInt == i) && (i < this.lNX - 1))
      {
        localcc = (cc)this.EgE.get(this.EgE.size() - 1);
        if (this.cGv) {
          ac(localcc.field_msgId, true);
        }
        AppMethodBeat.o(35884);
        return localcc;
      }
      cc localcc = (cc)this.EgE.get(paramInt - this.min);
      AppMethodBeat.o(35884);
      return localcc;
    }
    
    public final int dWF()
    {
      return this.lNX - this.aeAU + aeAT + 1;
    }
    
    public final void jvc()
    {
      this.cGv = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(35886);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AutoList, Size = " + this.EgE.size());
      ((StringBuilder)localObject).append("; Content = {");
      Iterator localIterator = this.EgE.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(((cc)localIterator.next()).field_msgId);
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
      aeBh = new b("unkown", 0);
      aeBi = new b("image", 1);
      aeBj = new b("video", 2);
      aeBk = new b("sight", 3);
      aeBl = new b("appimage", 4);
      aeBm = new b[] { aeBh, aeBi, aeBj, aeBk, aeBl };
      AppMethodBeat.o(35891);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void Qz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */