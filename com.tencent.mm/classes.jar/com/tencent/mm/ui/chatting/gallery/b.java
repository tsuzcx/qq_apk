package com.tencent.mm.ui.chatting.gallery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.y;
import com.tencent.mm.app.j.a;
import com.tencent.mm.app.j.b;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.b.a.i.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.bv;
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
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b
  extends com.tencent.mm.ui.base.u
{
  public static long oex = -1L;
  public static boolean rCv = false;
  public boolean KkA;
  public d KkB;
  public j KkC;
  public i KkD;
  public c KkE;
  public boolean KkF;
  boolean KkG;
  protected boolean KkH;
  private com.tencent.mm.g.b.a.i KkI;
  public ImageGalleryUI Kkw;
  protected a Kkx;
  private String Kky;
  boolean Kkz;
  private String fLJ;
  private int fromScene;
  private ArrayList<bv> rKI;
  
  public b(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35892);
    this.Kkz = true;
    this.KkA = false;
    this.KkF = false;
    this.fLJ = null;
    this.KkH = true;
    this.rKI = new ArrayList();
    this.KkI = null;
    this.KkF = paramImageGalleryUI.getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    String str;
    if (!this.KkF)
    {
      str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + bu.fpN();
      if ((paramLong1 <= 0L) || (paramString1 == null) || (paramString1.length() <= 0)) {
        break label248;
      }
    }
    label248:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      this.Kkw = paramImageGalleryUI;
      rCv = paramBoolean1;
      oex = paramLong2;
      this.fLJ = paramString1;
      this.fromScene = paramInt;
      this.Kkx = new a(paramLong1, paramString1, this, paramBoolean, paramInt);
      this.KkA = paramBoolean2;
      this.Kky = paramString2;
      this.KkB = new d(this);
      this.KkC = new j(this);
      this.KkD = new i(this);
      AppMethodBeat.o(35892);
      return;
    }
  }
  
  private void K(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35909);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
      AppMethodBeat.o(35909);
      return;
    }
    Object localObject;
    if (bu.isNullOrNil(this.Kky))
    {
      ae.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      localObject = new Intent(this.Kkw, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Id", paramLong);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", paramInt);
      paramString = this.Kkw;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35909);
      return;
    }
    ae.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.Kky });
    if (!bu.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(4);
      ((o.e)localObject).dzZ = com.tencent.mm.model.v.aAC();
      ((o.e)localObject).toUser = this.Kky;
      ((o.e)localObject).iey = paramString;
      ((o.e)localObject).icr = paramInt;
      ((o.e)localObject).iiW = null;
      ((o.e)localObject).iiV = 6;
      ((o.e)localObject).aJO().execute();
      cb.aCN().d(cb.hKU, null);
    }
    if (this.Kkz)
    {
      localObject = new Intent(this.Kkw, ChattingUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.Kky);
      paramString = this.Kkw;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.Kky });
      AppMethodBeat.o(35909);
      return;
      com.tencent.mm.ui.base.h.cm(this.Kkw, this.Kkw.getString(2131755881));
    }
  }
  
  public static void a(Context paramContext, final bv parambv)
  {
    AppMethodBeat.i(187478);
    if ((paramContext == null) || (parambv == null))
    {
      AppMethodBeat.o(187478);
      return;
    }
    parambv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187469);
        b.b(this.val$context, parambv, this.KkL);
        if (this.KkM != null) {
          this.KkM.run();
        }
        AppMethodBeat.o(187469);
      }
    };
    b.5 local5 = new b.5(paramContext);
    if (PermissionHelper.aNr("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      parambv.run();
      AppMethodBeat.o(187478);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      p.a(paramContext, parambv, local5);
      AppMethodBeat.o(187478);
      return;
    }
    local5.run();
    AppMethodBeat.o(187478);
  }
  
  public static boolean b(Context paramContext, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(35912);
    if (parambv == null)
    {
      AppMethodBeat.o(35912);
      return false;
    }
    final s locals = com.tencent.mm.modelvideo.o.aNh().HD(parambv.field_imgPath);
    boolean bool = false;
    if (locals != null)
    {
      int i = 0;
      if (x.wb(locals.getUser())) {
        i = com.tencent.mm.model.r.zC(locals.getUser());
      }
      bool = locals.aNw();
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.f(12084, new Object[] { Integer.valueOf(locals.hPI), Integer.valueOf(locals.hKI * 1000), Integer.valueOf(0), Integer.valueOf(2), locals.getUser(), Integer.valueOf(i), s.HA(locals.aNt()), Long.valueOf(locals.createTime) });
    }
    if (!bool)
    {
      ae.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131764682), 1).show();
      }
      AppMethodBeat.o(35912);
      return false;
    }
    com.tencent.mm.modelvideo.o.aNh();
    final String str1 = com.tencent.mm.modelvideo.t.HJ(parambv.field_imgPath);
    String str2 = com.tencent.mm.modelvideo.u.Ib(str1);
    if (bu.isNullOrNil(str2))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131764682), 1).show();
      }
      AppMethodBeat.o(35912);
      return false;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aSY(str2) }), 1).show();
    }
    String str3 = com.tencent.mm.vfs.o.aRh(str2);
    com.tencent.mm.platformtools.v localv = com.tencent.mm.platformtools.v.iQD;
    com.tencent.mm.platformtools.v.bH(str3, bn.BV(parambv.eNd));
    com.tencent.mm.sdk.f.b.m(str2, paramContext);
    com.tencent.e.h.MqF.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187471);
        try
        {
          j.b localb;
          if (x.wb(this.hHF.field_talker))
          {
            localb = com.tencent.mm.app.j.b(j.a.cUx);
            if (this.hHF.field_isSend == 1)
            {
              localb.cUA = com.tencent.mm.model.v.aAC();
              localb.cUB = this.hHF.field_talker;
            }
          }
          MultiMediaVideoChecker.a locala;
          for (;;)
          {
            locala = MultiMediaVideoChecker.BXt.aED(str1);
            if (locala != null) {
              break;
            }
            ae.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get video data info, skip reporting. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(this.hHF.field_msgId), Long.valueOf(this.hHF.field_msgSvrId) });
            AppMethodBeat.o(187471);
            return;
            localb.cUA = bl.BM(this.hHF.field_content);
            localb.cUB = this.hHF.field_talker;
            continue;
            localb = com.tencent.mm.app.j.a(j.a.cUx);
            if (this.hHF.field_isSend == 1)
            {
              localb.cUA = com.tencent.mm.model.v.aAC();
              localb.cUB = this.hHF.field_talker;
            }
            else
            {
              localb.cUA = this.hHF.field_talker;
              localb.cUB = com.tencent.mm.model.v.aAC();
            }
          }
          if (locals != null) {}
          for (Object localObject = bx.M(locals.aNt(), "msg"); localObject == null; localObject = Collections.emptyMap())
          {
            ae.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse recv xml. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(this.hHF.field_msgId), Long.valueOf(this.hHF.field_msgSvrId) });
            AppMethodBeat.o(187471);
            return;
          }
          localb.msgId = this.hHF.field_msgSvrId;
          localb.cUC = bu.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
          localb.cUD = locala.width;
          localb.cUE = locala.height;
          localb.cUF = bu.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnthumburl"));
          localb.cUG = ((int)locala.duration);
          localb.fileId = bu.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$cdnvideourl"));
          localb.fileKey = bu.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$aeskey"));
          localb.md5 = bu.nullAsNil((String)((Map)localObject).get(".msg.videomsg.$md5"));
          if (x.wb(this.hHF.field_talker))
          {
            localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BB(this.hHF.field_talker);
            if (localObject == null) {
              break label470;
            }
          }
          label470:
          for (int i = ((List)localObject).size();; i = 0)
          {
            localb.cUI = i;
            com.tencent.mm.app.j.a(localb);
            AppMethodBeat.o(187471);
            return;
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.printErrStackTrace("MicroMsg.ImageGalleryAdapter", localThrowable, "[-] Exception was thrown when report.", new Object[0]);
          AppMethodBeat.o(187471);
        }
      }
    }, "MsgVideoExportReport");
    AppMethodBeat.o(35912);
    return true;
  }
  
  public static boolean b(bv parambv, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(35903);
    if ((parambv == null) || (paramg == null))
    {
      AppMethodBeat.o(35903);
      return false;
    }
    boolean bool = q.aIY().a(paramg.doE, parambv.field_msgId, 1);
    AppMethodBeat.o(35903);
    return bool;
  }
  
  public static boolean bX(bv parambv)
  {
    AppMethodBeat.i(35899);
    if (parambv == null)
    {
      AppMethodBeat.o(35899);
      return false;
    }
    if (parambv.getType() == 62)
    {
      AppMethodBeat.o(35899);
      return true;
    }
    AppMethodBeat.o(35899);
    return false;
  }
  
  public static boolean bY(bv parambv)
  {
    AppMethodBeat.i(35900);
    if (parambv == null)
    {
      AppMethodBeat.o(35900);
      return false;
    }
    if (parambv.getType() == 49)
    {
      AppMethodBeat.o(35900);
      return true;
    }
    AppMethodBeat.o(35900);
    return false;
  }
  
  public static boolean bZ(bv parambv)
  {
    AppMethodBeat.i(35901);
    if (parambv == null)
    {
      AppMethodBeat.o(35901);
      return false;
    }
    if (parambv.getType() == 268435505)
    {
      AppMethodBeat.o(35901);
      return true;
    }
    AppMethodBeat.o(35901);
    return false;
  }
  
  public static int c(bv parambv, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(35918);
    if (parambv.field_isSend == 1)
    {
      if (paramg.aIB())
      {
        parambv = com.tencent.mm.av.h.a(paramg);
        if ((parambv != null) && (parambv.doE > 0L) && (parambv.aIA()) && (com.tencent.mm.vfs.o.fB(q.aIX().o(parambv.ico, "", ""))))
        {
          AppMethodBeat.o(35918);
          return 1;
        }
      }
      AppMethodBeat.o(35918);
      return 0;
    }
    if (paramg.aIA())
    {
      if (paramg.aIB())
      {
        parambv = com.tencent.mm.av.h.a(paramg);
        if ((parambv != null) && (parambv.doE > 0L) && (parambv.aIA()) && (com.tencent.mm.vfs.o.fB(q.aIX().o(parambv.ico, "", ""))))
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
  
  public static void c(Context paramContext, final bv parambv, final boolean paramBoolean)
  {
    AppMethodBeat.i(187479);
    if ((paramContext == null) || (parambv == null))
    {
      AppMethodBeat.o(187479);
      return;
    }
    parambv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187472);
        b.d(this.val$context, parambv, paramBoolean);
        if (this.KkM != null) {
          this.KkM.run();
        }
        AppMethodBeat.o(187472);
      }
    };
    b.8 local8 = new b.8(paramBoolean, paramContext);
    if (PermissionHelper.aNr("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      parambv.run();
      AppMethodBeat.o(187479);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      p.a(paramContext, parambv, local8);
      AppMethodBeat.o(187479);
      return;
    }
    local8.run();
    AppMethodBeat.o(187479);
  }
  
  public static boolean ca(bv parambv)
  {
    AppMethodBeat.i(35902);
    if (parambv == null)
    {
      AppMethodBeat.o(35902);
      return false;
    }
    boolean bool = parambv.cyH();
    AppMethodBeat.o(35902);
    return bool;
  }
  
  public static b cb(bv parambv)
  {
    AppMethodBeat.i(35906);
    b localb = b.Klf;
    if (parambv == null) {
      localb = b.Klf;
    }
    if (bZ(parambv))
    {
      parambv = b.Klj;
      AppMethodBeat.o(35906);
      return parambv;
    }
    if (j(parambv))
    {
      parambv = b.Klg;
      AppMethodBeat.o(35906);
      return parambv;
    }
    if (cc(parambv))
    {
      parambv = b.Kli;
      AppMethodBeat.o(35906);
      return parambv;
    }
    if (m(parambv))
    {
      parambv = b.Klh;
      AppMethodBeat.o(35906);
      return parambv;
    }
    if (bX(parambv))
    {
      parambv = b.Klh;
      AppMethodBeat.o(35906);
      return parambv;
    }
    parambv = b.Klf;
    AppMethodBeat.o(35906);
    return parambv;
  }
  
  public static boolean cc(bv parambv)
  {
    AppMethodBeat.i(35907);
    if (parambv != null)
    {
      if (parambv.cyH())
      {
        AppMethodBeat.o(35907);
        return false;
      }
      parambv = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
      if ((parambv != null) && (parambv.ixh != null) && ((!bu.isNullOrNil(parambv.ixh.hET)) || (parambv.ixh.GBN > 0) || (!bu.isNullOrNil(parambv.ixh.hEW)) || (!bu.isNullOrNil(parambv.ixh.hEX)) || (!bu.isNullOrNil(parambv.ixh.hEV)) || (!bu.isNullOrNil(parambv.ixh.hEY)) || (!bu.isNullOrNil(parambv.ixh.hEZ)) || (!bu.isNullOrNil(parambv.ixh.hFa))))
      {
        AppMethodBeat.o(35907);
        return true;
      }
    }
    AppMethodBeat.o(35907);
    return false;
  }
  
  public static boolean d(Context paramContext, final bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(35913);
    final com.tencent.mm.av.g localg = null;
    if (bZ(parambv)) {}
    for (Object localObject = l(parambv); (localObject == null) || (((String)localObject).length() == 0); localObject = d.a(parambv, localg))
    {
      ae.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambv.field_msgId);
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
      }
      AppMethodBeat.o(35913);
      return false;
      if ((parambv == null) || (parambv.field_msgId == 0L))
      {
        ae.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
        }
        AppMethodBeat.o(35913);
        return false;
      }
      localg = d.k(parambv);
      if ((localg == null) || (localg.doE == 0L))
      {
        localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (parambv == null)
        {
          parambv = "null";
          localObject = ((StringBuilder)localObject).append(parambv).append(", imgLocalId = ");
          if (localg != null) {
            break label244;
          }
        }
        label244:
        for (parambv = "null";; parambv = Long.valueOf(localg.doE))
        {
          ae.e("MicroMsg.ImageGalleryAdapter", parambv);
          if (paramBoolean) {
            Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
          }
          AppMethodBeat.o(35913);
          return false;
          parambv = Long.valueOf(parambv.field_msgId);
          break;
        }
      }
    }
    String str = p.Jo((String)localObject);
    ae.i("MicroMsg.ExportFileUtil", "[+] Called exportImage, src: %s, dest: %s", new Object[] { localObject, str });
    str = p.l(paramContext, (String)localObject, str);
    if (!bu.isNullOrNil(str))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.fjf() }), 1).show();
      }
      com.tencent.e.h.MqF.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187474);
          label527:
          for (;;)
          {
            try
            {
              BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.h.aRz(this.lmE);
              if (localOptions == null)
              {
                ae.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to get bmp opts. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_msgSvrId) });
                AppMethodBeat.o(187474);
                return;
              }
              j.b localb;
              if (x.wb(parambv.field_talker))
              {
                localb = com.tencent.mm.app.j.b(j.a.cUw);
                if (parambv.field_isSend == 1)
                {
                  localb.cUA = com.tencent.mm.model.v.aAC();
                  localb.cUB = parambv.field_talker;
                  localObject = com.tencent.mm.plugin.normsg.a.b.wJt.auK(this.lmE);
                  if (localObject == null) {
                    break label527;
                  }
                  localObject = localObject[0];
                  if (localg != null)
                  {
                    localMap = bx.M(localg.icA, "msg");
                    if (localMap != null) {
                      continue;
                    }
                    ae.e("MicroMsg.ImageGalleryAdapter", "[-] Fail to parse cdn info. msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_msgSvrId) });
                    AppMethodBeat.o(187474);
                  }
                }
                else
                {
                  localb.cUA = bl.BM(parambv.field_content);
                  localb.cUB = parambv.field_talker;
                  continue;
                }
              }
              else
              {
                localb = com.tencent.mm.app.j.a(j.a.cUw);
                if (parambv.field_isSend == 1)
                {
                  localb.cUA = com.tencent.mm.model.v.aAC();
                  localb.cUB = parambv.field_talker;
                  continue;
                }
                localb.cUA = parambv.field_talker;
                localb.cUB = com.tencent.mm.model.v.aAC();
                continue;
              }
              Map localMap = Collections.emptyMap();
              continue;
              String str;
              if (localg.icr == 1)
              {
                str = (String)localMap.get(".msg.img.$cdnbigimgurl");
                localb.msgId = parambv.field_msgSvrId;
                localb.cUC = bu.nullAsNil(str);
                localb.cUD = localOptions.outWidth;
                localb.cUE = localOptions.outHeight;
                localb.cUF = bu.nullAsNil((String)localMap.get(".msg.img.$cdnthumburl"));
                localb.fileId = bu.nullAsNil(str);
                localb.fileKey = bu.nullAsNil((String)localMap.get(".msg.img.$aeskey"));
                localb.md5 = com.tencent.mm.b.g.getMD5(this.lmE);
                localb.cUH = ((String)localObject);
                if (x.wb(parambv.field_talker))
                {
                  localObject = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BB(parambv.field_talker);
                  if (localObject != null)
                  {
                    i = ((List)localObject).size();
                    localb.cUI = i;
                  }
                }
                else
                {
                  com.tencent.mm.app.j.a(localb);
                  AppMethodBeat.o(187474);
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
              ae.printErrStackTrace("MicroMsg.ImageGalleryAdapter", localThrowable, "[-] Exception was thrown when report.", new Object[0]);
              AppMethodBeat.o(187474);
              return;
            }
          }
        }
      }, "MsgImgExportReport");
      paramContext = com.tencent.mm.vfs.o.aRh(str);
      localObject = com.tencent.mm.platformtools.v.iQD;
      com.tencent.mm.platformtools.v.bH(paramContext, bn.BV(parambv.eNd));
      AppMethodBeat.o(35913);
      return true;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
    }
    AppMethodBeat.o(35913);
    return false;
  }
  
  public static void f(Context paramContext, List<bv> paramList)
  {
    AppMethodBeat.i(187477);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(187477);
      return;
    }
    paramList = new b.1(paramList, paramContext);
    b.3 local3 = new b.3(paramContext);
    if ((paramContext instanceof Activity))
    {
      p.a(paramContext, paramList, local3);
      AppMethodBeat.o(187477);
      return;
    }
    local3.run();
    AppMethodBeat.o(187477);
  }
  
  public static boolean j(bv parambv)
  {
    AppMethodBeat.i(35897);
    if (parambv == null)
    {
      AppMethodBeat.o(35897);
      return false;
    }
    if ((parambv.getType() == 3) || (parambv.getType() == 39) || (parambv.getType() == 13))
    {
      AppMethodBeat.o(35897);
      return true;
    }
    AppMethodBeat.o(35897);
    return false;
  }
  
  public static String l(bv parambv)
  {
    Object localObject1 = null;
    AppMethodBeat.i(35916);
    Object localObject2 = k.b.zb(parambv.field_content);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35916);
      return null;
    }
    parambv = localObject1;
    if (((k.b)localObject2).dlu != null)
    {
      parambv = localObject1;
      if (((k.b)localObject2).dlu.length() > 0)
      {
        localObject2 = ao.bJV().aMZ(((k.b)localObject2).dlu);
        parambv = localObject1;
        if (localObject2 != null) {
          parambv = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        }
      }
    }
    AppMethodBeat.o(35916);
    return parambv;
  }
  
  public static boolean m(bv parambv)
  {
    AppMethodBeat.i(35898);
    if (parambv == null)
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if (cc(parambv))
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if ((parambv.getType() == 43) || (parambv.getType() == 486539313) || (parambv.getType() == 44) || (parambv.getType() == 62))
    {
      AppMethodBeat.o(35898);
      return true;
    }
    AppMethodBeat.o(35898);
    return false;
  }
  
  public final MultiTouchImageView HN(int paramInt)
  {
    AppMethodBeat.i(35920);
    Object localObject = super.Tq(paramInt);
    if (localObject == null)
    {
      ae.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35920);
      return null;
    }
    localObject = ((View)localObject).findViewById(2131300914);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(35920);
      return null;
    }
    localObject = (MultiTouchImageView)localObject;
    AppMethodBeat.o(35920);
    return localObject;
  }
  
  public final WxImageView HO(int paramInt)
  {
    AppMethodBeat.i(35921);
    Object localObject = super.Tq(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(35921);
      return null;
    }
    localObject = ((View)localObject).findViewById(2131307106);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(35921);
      return null;
    }
    localObject = (WxImageView)localObject;
    AppMethodBeat.o(35921);
    return localObject;
  }
  
  public final void a(bv parambv, com.tencent.mm.av.g paramg, int paramInt, i.a parama)
  {
    AppMethodBeat.i(35934);
    if (parambv == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    if (this.KkI == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    this.KkI.RH().dTb = parama;
    long l1 = parambv.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.KkI.dST != l1) && (this.KkI.dSV != i); i = 0)
    {
      ae.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.KkI.dST), Long.valueOf(l1) });
      parambv = this.KkI;
      parambv.dTb = i.a.dTd;
      parambv.aLH();
      AppMethodBeat.o(35934);
      return;
    }
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0L;
    long l7 = bu.HQ();
    long l3 = l6;
    long l2 = l5;
    l1 = l4;
    if (parama == i.a.dTc)
    {
      parambv = d.a(parambv, paramg);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!bu.isNullOrNil(parambv))
      {
        l1 = com.tencent.mm.vfs.o.aZR(parambv);
        parambv = d.aXO(parambv);
        l3 = parambv.outWidth;
        l2 = parambv.outHeight;
      }
    }
    parambv = this.KkI;
    parambv.dSW = l1;
    parambv.dSY = l2;
    parambv.dSX = l3;
    this.KkI.aLH();
    ae.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(bu.aO(l7)), this.KkI.RC() });
    this.KkI = null;
    AppMethodBeat.o(35934);
  }
  
  public final bv adI(int paramInt)
  {
    AppMethodBeat.i(35894);
    bv localbv = this.Kkx.aen(paramInt);
    AppMethodBeat.o(35894);
    return localbv;
  }
  
  public final void aed(int paramInt)
  {
    AppMethodBeat.i(35904);
    Object localObject1 = adI(paramInt);
    Object localObject2 = cb((bv)localObject1);
    switch (2.KkK[localObject2.ordinal()])
    {
    default: 
      ce((bv)localObject1);
      AppMethodBeat.o(35904);
      return;
    case 1: 
    case 2: 
      cd((bv)localObject1);
      AppMethodBeat.o(35904);
      return;
    }
    String str = l((bv)localObject1);
    localObject2 = new Intent(this.Kkw, MsgRetransmitUI.class);
    ((Intent)localObject2).putExtra("Retr_File_Name", str);
    ((Intent)localObject2).putExtra("Retr_Msg_Id", ((ei)localObject1).field_msgId);
    ((Intent)localObject2).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject2).putExtra("Retr_Msg_content", ((ei)localObject1).field_content);
    ((Intent)localObject2).putExtra("Retr_Compress_Type", 0);
    localObject1 = this.Kkw;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35904);
  }
  
  public final void aee(int paramInt)
  {
    AppMethodBeat.i(35905);
    Object localObject1 = adI(paramInt);
    Object localObject2 = cb((bv)localObject1);
    switch (2.KkK[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35905);
      return;
      localObject2 = new Intent(this.Kkw, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject2).putExtra("Retr_Msg_Id", ((ei)localObject1).field_msgId);
      localObject1 = this.Kkw;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public final void aef(int paramInt)
  {
    AppMethodBeat.i(35914);
    Object localObject1 = adI(paramInt);
    if (this.KkF)
    {
      localObject1 = j.cq((bv)localObject1);
      if (localObject1 == null)
      {
        ae.e("MicroMsg.ImageGalleryAdapter", "doFavoriteImage mpShareVideoInfo should not be null");
        AppMethodBeat.o(35914);
        return;
      }
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.f.EGX;
      com.tencent.mm.plugin.webview.ui.tools.media.f.b((y)localObject1);
      com.tencent.mm.ui.base.h.cm(this.Kkw, this.Kkw.getString(2131758936));
      AppMethodBeat.o(35914);
      return;
    }
    Object localObject2 = new cw();
    com.tencent.mm.pluginsdk.model.g.e((cw)localObject2, (bv)localObject1);
    ((cw)localObject2).doL.activity = this.Kkw;
    ((cw)localObject2).doL.doR = 44;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
    if (((cw)localObject2).doM.ret == 0)
    {
      if (((bv)localObject1).cyI()) {
        com.tencent.mm.ui.chatting.a.a(a.c.JRS, a.d.JRY, (bv)localObject1, 0);
      }
      com.tencent.mm.modelstat.b.iqT.S((bv)localObject1);
    }
    AppMethodBeat.o(35914);
  }
  
  public final View aeg(int paramInt)
  {
    AppMethodBeat.i(35922);
    View localView3 = super.Tq(paramInt);
    if (localView3 == null)
    {
      ae.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35922);
      return null;
    }
    View localView2 = localView3.findViewById(2131306319);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = localView3.findViewById(2131306317);
    }
    if ((localView1 == null) || (localView1.getVisibility() == 8))
    {
      AppMethodBeat.o(35922);
      return null;
    }
    AppMethodBeat.o(35922);
    return localView1;
  }
  
  public final void aeh(int paramInt)
  {
    AppMethodBeat.i(35923);
    this.KkC.j(adI(paramInt), paramInt);
    AppMethodBeat.o(35923);
  }
  
  public final void aei(int paramInt)
  {
    AppMethodBeat.i(35924);
    this.KkC.k(adI(paramInt), paramInt);
    AppMethodBeat.o(35924);
  }
  
  public final void aej(int paramInt)
  {
    AppMethodBeat.i(35927);
    this.KkC.aec(paramInt);
    AppMethodBeat.o(35927);
  }
  
  public final void aek(int paramInt)
  {
    AppMethodBeat.i(35930);
    bv localbv = adI(paramInt);
    if ((localbv == null) || (!j(localbv)))
    {
      AppMethodBeat.o(35930);
      return;
    }
    this.KkB.cj(localbv);
    AppMethodBeat.o(35930);
  }
  
  public final void ael(int paramInt)
  {
    AppMethodBeat.i(35931);
    this.KkD.aer(paramInt);
    AppMethodBeat.o(35931);
  }
  
  public final void bm(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35919);
    this.KkB.bm(paramInt, paramBoolean);
    AppMethodBeat.o(35919);
  }
  
  public final void cd(bv parambv)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(35908);
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.Kkw, null);
      AppMethodBeat.o(35908);
      return;
    }
    if (parambv.cyH())
    {
      parambv = j.cq(parambv);
      if (parambv == null)
      {
        ae.e("MicroMsg.ImageGalleryAdapter", "doRestransmitVideo mpShareVideoInfo should not be null");
        AppMethodBeat.o(35908);
        return;
      }
      if (this.Kkw.Ewq == null) {
        this.Kkw.Ewq = new com.tencent.mm.plugin.webview.ui.tools.media.e();
      }
      this.Kkw.Ewq.hCc = parambv;
      if (this.KkF) {}
      for (;;)
      {
        parambv.hGG = this.Kkw.KmD.otX;
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.d.EGT;
        com.tencent.mm.plugin.webview.ui.tools.media.d.a(this.Kkw, parambv.hGe, "", parambv.title, parambv.url, i);
        AppMethodBeat.o(35908);
        return;
        i = 0;
      }
    }
    s locals = com.tencent.mm.modelvideo.u.Ia(parambv.field_imgPath);
    if (locals == null)
    {
      ae.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      AppMethodBeat.o(35908);
      return;
    }
    Object localObject = new Intent(this.Kkw, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_length", locals.hKI);
    ((Intent)localObject).putExtra("Retr_File_Name", parambv.field_imgPath);
    ((Intent)localObject).putExtra("Retr_video_isexport", locals.ixc);
    i = j;
    if (bX(parambv)) {
      i = 11;
    }
    ((Intent)localObject).putExtra("Retr_Msg_Type", i);
    ((Intent)localObject).putExtra("Retr_Msg_Id", parambv.field_msgId);
    ((Intent)localObject).putExtra("Retr_From", "gallery");
    parambv = this.Kkw;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(parambv, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parambv.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(parambv, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35908);
  }
  
  public final void ce(bv parambv)
  {
    AppMethodBeat.i(35910);
    com.tencent.mm.av.g localg = d.k(parambv);
    if ((parambv == null) || (parambv.field_msgId == 0L) || (localg == null) || (localg.doE == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (parambv == null)
      {
        parambv = "null";
        localObject = ((StringBuilder)localObject).append(parambv).append(", imgLocalId = ");
        if (localg != null) {
          break label107;
        }
      }
      label107:
      for (parambv = "null";; parambv = Long.valueOf(localg.doE))
      {
        ae.e("MicroMsg.ImageGalleryAdapter", parambv);
        AppMethodBeat.o(35910);
        return;
        parambv = Long.valueOf(parambv.field_msgId);
        break;
      }
    }
    Object localObject = d.a(parambv, localg);
    if (bu.isNullOrNil((String)localObject))
    {
      ae.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambv.field_msgId + ", imgLocalId = " + localg.doE);
      AppMethodBeat.o(35910);
      return;
    }
    K((String)localObject, c(parambv, localg), parambv.field_msgId);
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
    this.KkB.detach();
    this.KkC.detach();
    this.KkD.detach();
    if (this.KkI != null)
    {
      com.tencent.mm.g.b.a.i locali = this.KkI.RH();
      locali.dTb = i.a.dTd;
      locali.aLH();
    }
    super.detach();
    AppMethodBeat.o(35917);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(35915);
    final bv localbv = adI(paramInt);
    View localView;
    final k localk;
    if (paramView == null)
    {
      localView = View.inflate(this.Kkw, 2131494469, null);
      localk = new k(this, localView);
      localView.setTag(localk);
      paramView = cb(localbv);
      localk.mPosition = paramInt;
      localk.KoA = paramView;
      k.aH(localk.uan, 0);
      switch (k.5.KkK[paramView.ordinal()])
      {
      default: 
        label108:
        k.aH(localk.KoZ, 8);
        k.aH(localk.Kpa, 8);
        k.aH(localk.KoQ, 8);
        k.aH(localk.KoW, 8);
        k.aH(localk.KoV, 8);
        ae.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (2.KkK[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.KkH = false;
      AppMethodBeat.o(35915);
      return localView;
      localk = (k)paramView.getTag();
      localView = paramView;
      break;
      k.aH(localk.KoI, 8);
      k.aH(localk.KoC, 8);
      break label108;
      localk.fKM();
      k.aH(localk.KoI, 0);
      k.aH(localk.KoC, 8);
      if (localk.KoC == null) {
        break label108;
      }
      k.aH(localk.KoE, 8);
      break label108;
      localk.fKL();
      k.aH(localk.KoI, 8);
      k.aH(localk.KoC, 0);
      break label108;
      k.aH(localk.uan, 8);
      k.aH(localk.KoI, 8);
      k.aH(localk.KoC, 8);
      break label108;
      this.KkB.a(localk, localbv, paramInt);
      if (paramInt == a.KkQ)
      {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ah(localbv);
        continue;
        k.aH(localk.KoZ, 0);
        k.aH(localk.KoQ, 8);
        k.aH(localk.KoV, 8);
        k.aH(localk.KoW, 8);
        k.aH(localk.KoM, 8);
        final String str = l(localbv);
        try
        {
          paramView = com.tencent.mm.platformtools.u.Jt(str);
          localObject = paramView;
          if (paramView == null)
          {
            localObject = com.tencent.mm.platformtools.u.Js(q.aIX().R(localbv.field_imgPath, true));
            k.aH(localk.KoV, 0);
            new aq().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187476);
                m.a(localbv, new m.a()
                {
                  public final void jo(int paramAnonymous2Int1, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(187475);
                    if (paramAnonymous2Int1 == paramAnonymous2Int2)
                    {
                      ae.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(b.10.this.hHv.field_msgId) });
                      k.aH(b.10.this.KkN.KoV, 8);
                    }
                    try
                    {
                      Bitmap localBitmap1 = com.tencent.mm.platformtools.u.Jt(b.10.this.lmE);
                      if (localBitmap1 != null)
                      {
                        b.10.this.KkN.KoZ.setEnableHorLongBmpMode(false);
                        com.tencent.mm.sdk.platformtools.r.z(b.10.this.KkN.KoZ, localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.10.this.KkN.KoZ.cH(localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.10.this.KkN.KoZ.setImageBitmap(localBitmap1);
                        b.10.this.KkN.KoZ.invalidate();
                      }
                      AppMethodBeat.o(187475);
                      return;
                    }
                    catch (OutOfMemoryError localOutOfMemoryError)
                    {
                      for (;;)
                      {
                        ae.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { b.10.this.lmE });
                        Runtime.getRuntime().gc();
                        Runtime.getRuntime().runFinalization();
                        Bitmap localBitmap2 = com.tencent.mm.platformtools.u.Js(b.10.this.lmE);
                      }
                    }
                  }
                });
                AppMethodBeat.o(187476);
              }
            });
          }
          if (localObject == null)
          {
            ae.w("MicroMsg.ImageGalleryAdapter", "get image fail");
            localk.KoZ.setVisibility(8);
            localk.fKK().KoW.setVisibility(0);
            localk.fKK().KoY.setImageResource(2131690686);
            localk.fKK().KoX.setText(this.Kkw.getString(2131760324));
            if (paramInt != a.KkQ) {
              continue;
            }
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ah(localbv);
          }
        }
        catch (OutOfMemoryError paramView)
        {
          for (;;)
          {
            Object localObject;
            ae.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { str });
            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
            paramView = com.tencent.mm.platformtools.u.Js(str);
            continue;
            localk.KoZ.setEnableHorLongBmpMode(false);
            com.tencent.mm.sdk.platformtools.r.z(localk.KoZ, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.KoZ.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.KoZ.setImageBitmap((Bitmap)localObject);
            localk.KoZ.invalidate();
          }
        }
        this.KkC.a(localk, localbv, paramInt);
        continue;
        this.KkD.a(localk, localbv, paramInt);
      }
    }
  }
  
  public final void fJR()
  {
    AppMethodBeat.i(35895);
    this.Kkx.fJR();
    AppMethodBeat.o(35895);
  }
  
  public final bv fJS()
  {
    AppMethodBeat.i(35925);
    bv localbv = adI(this.Kkw.getCurrentItem());
    AppMethodBeat.o(35925);
    return localbv;
  }
  
  public final k fJT()
  {
    AppMethodBeat.i(35926);
    Object localObject2 = this.KkB.aeb(this.Kkw.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.KkC.aeb(this.Kkw.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.KkD.aeb(this.Kkw.getCurrentItem());
    }
    AppMethodBeat.o(35926);
    return localObject2;
  }
  
  public final void fJU()
  {
    AppMethodBeat.i(35929);
    this.KkC.onResume();
    AppMethodBeat.o(35929);
  }
  
  public final int firstItemPosForDetermine()
  {
    AppMethodBeat.i(187480);
    int i = a.KkQ;
    int j = a.c(this.Kkx);
    AppMethodBeat.o(187480);
    return i - j;
  }
  
  public final int getCount()
  {
    a locala = this.Kkx;
    return locala.fVS - locala.KkS + a.KkQ + 1;
  }
  
  public final int getRealCount()
  {
    return this.Kkx.fVS;
  }
  
  public final com.tencent.mm.av.g h(bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(35896);
    parambv = this.KkB.h(parambv, paramBoolean);
    AppMethodBeat.o(35896);
    return parambv;
  }
  
  public final void i(bv parambv, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(35933);
    if (parambv == null)
    {
      AppMethodBeat.o(35933);
      return;
    }
    Object localObject = fJS();
    if ((localObject == null) || (((ei)localObject).field_msgId != parambv.field_msgId))
    {
      ae.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(parambv.field_msgId) });
      AppMethodBeat.o(35933);
      return;
    }
    long l = parambv.field_msgSvrId;
    if ((this.KkI != null) && ((this.KkI.dST != l) || (this.KkI.dSV != paramBoolean)))
    {
      localObject = this.KkI.RH();
      ((com.tencent.mm.g.b.a.i)localObject).dTb = i.a.dTd;
      ((com.tencent.mm.g.b.a.i)localObject).aLH();
    }
    this.KkI = new com.tencent.mm.g.b.a.i();
    this.KkI.RG();
    localObject = this.KkI;
    ((com.tencent.mm.g.b.a.i)localObject).dST = l;
    ((com.tencent.mm.g.b.a.i)localObject).dSU = parambv.field_createTime;
    ((com.tencent.mm.g.b.a.i)localObject).dSV = paramBoolean;
    if (x.wb(this.fLJ)) {
      i = com.tencent.mm.model.r.zC(this.fLJ);
    }
    parambv = this.KkI;
    parambv.dSR = parambv.t("ChatName", this.fLJ, true);
    parambv.dSS = i;
    AppMethodBeat.o(35933);
  }
  
  public final int lastItemPosForDetermine()
  {
    AppMethodBeat.i(187481);
    int i = a.KkQ;
    int j = a.c(this.Kkx);
    int k = a.d(this.Kkx);
    AppMethodBeat.o(187481);
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
    if ((this.KkB != null) && (j(adI(paramInt)))) {
      this.KkB.KlS.onPageSelected(paramInt);
    }
    AppMethodBeat.o(35893);
  }
  
  public static final class a
  {
    public static int KkQ = 100000;
    private List<bv> KkR;
    int KkS;
    protected int KkT;
    protected int KkU;
    protected int KkV;
    protected long KkW;
    private b KkX;
    public HashMap<Long, com.tencent.mm.av.g> KkY;
    public HashMap<Long, com.tencent.mm.av.g> KkZ;
    protected boolean bdb;
    int fVS;
    private int fromScene;
    private aq handler;
    private int min;
    private String talker;
    
    public a(final long paramLong, String paramString, final b paramb, Boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(35881);
      this.bdb = false;
      this.KkY = new HashMap();
      this.KkZ = new HashMap();
      this.handler = new aq();
      this.talker = paramString;
      this.KkR = new LinkedList();
      this.KkX = paramb;
      this.fromScene = paramInt;
      if (paramb.KkF)
      {
        paramString = j.f(paramString, paramb.Kkw);
        this.KkR.add(paramString);
        KkQ = 0;
        AppMethodBeat.o(35881);
        return;
      }
      KkQ = 100000;
      bc.aCg();
      paramString = com.tencent.mm.model.c.azI().ys(paramLong);
      if (paramString.field_msgId == 0L)
      {
        Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + bu.fpN(), false);
        AppMethodBeat.o(35881);
        return;
      }
      this.KkR.add(paramString);
      if (this.fromScene == 1) {}
      for (paramInt = i; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(35881);
        return;
      }
      bc.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35879);
          b.a.a(b.a.this, paramLong);
          if (paramb.booleanValue()) {
            b.a.b(b.a.this).postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35878);
                b.a.a(b.a.this);
                if (b.a.1.this.Klc.KkE != null) {
                  b.a.1.this.Klc.KkE.ta();
                }
                AppMethodBeat.o(35878);
              }
            }, 0L);
          }
          AppMethodBeat.o(35879);
        }
      });
      paramb.Kkw.Kny = new ImageGalleryUI.a()
      {
        public final void r(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35880);
          ae.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(paramAnonymousBoolean)));
          if (!paramAnonymousBoolean.booleanValue())
          {
            b.a.a(b.a.this);
            if (paramb.KkE != null) {
              paramb.KkE.ta();
            }
          }
          AppMethodBeat.o(35880);
        }
      };
      AppMethodBeat.o(35881);
    }
    
    private void M(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(35885);
      ae.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
      if (b.rCv) {
        bc.aCg();
      }
      for (List localList = com.tencent.mm.model.c.azJ().b(this.talker, b.oex, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.azI().f(this.talker, paramLong, paramBoolean))
      {
        ae.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(paramBoolean)));
        AppMethodBeat.o(35885);
        return;
        bc.aCg();
      }
      ae.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
      paramLong = System.currentTimeMillis();
      ip(localList);
      ae.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
      if (paramBoolean)
      {
        this.KkR.addAll(localList);
        AppMethodBeat.o(35885);
        return;
      }
      this.KkR.addAll(0, localList);
      this.min -= localList.size();
      if (this.min < 0)
      {
        ae.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
        AppMethodBeat.o(35885);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("min from ");
      int i = this.min;
      ae.i("MicroMsg.AutoList", localList.size() + i + " to " + this.min);
      AppMethodBeat.o(35885);
    }
    
    private void ip(List<bv> paramList)
    {
      AppMethodBeat.i(35882);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (b.j((bv)paramList.get(i)))
        {
          localArrayList1.add(Long.valueOf(((bv)paramList.get(i)).field_msgSvrId));
          if (((bv)paramList.get(i)).field_isSend == 1) {
            localArrayList2.add(Long.valueOf(((bv)paramList.get(i)).field_msgId));
          }
        }
        i += 1;
      }
      this.KkY.putAll(q.aIX().a((Long[])localArrayList1.toArray(new Long[0])));
      this.KkZ.putAll(q.aIX().b((Long[])localArrayList2.toArray(new Long[0])));
      AppMethodBeat.o(35882);
    }
    
    public final void a(long paramLong, com.tencent.mm.av.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(35883);
      if (paramBoolean)
      {
        this.KkY.put(Long.valueOf(paramLong), paramg);
        AppMethodBeat.o(35883);
        return;
      }
      this.KkZ.put(Long.valueOf(paramLong), paramg);
      AppMethodBeat.o(35883);
    }
    
    public final int aem(int paramInt)
    {
      return paramInt - KkQ + this.KkS;
    }
    
    public final bv aen(int paramInt)
    {
      AppMethodBeat.i(35884);
      paramInt = aem(paramInt);
      int i = this.min + this.KkR.size() - 1;
      if ((paramInt < this.min) || (paramInt > i))
      {
        ae.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
        AppMethodBeat.o(35884);
        return null;
      }
      ae.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(paramInt)));
      if (paramInt == this.min)
      {
        localbv = (bv)this.KkR.get(0);
        if (this.bdb) {
          M(localbv.field_msgId, false);
        }
        AppMethodBeat.o(35884);
        return localbv;
      }
      if ((paramInt == i) && (i < this.fVS - 1))
      {
        localbv = (bv)this.KkR.get(this.KkR.size() - 1);
        if (this.bdb) {
          M(localbv.field_msgId, true);
        }
        AppMethodBeat.o(35884);
        return localbv;
      }
      bv localbv = (bv)this.KkR.get(paramInt - this.min);
      AppMethodBeat.o(35884);
      return localbv;
    }
    
    public final void fJR()
    {
      this.bdb = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(35886);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AutoList, Size = " + this.KkR.size());
      ((StringBuilder)localObject).append("; Content = {");
      Iterator localIterator = this.KkR.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(((bv)localIterator.next()).field_msgId);
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
      Klf = new b("unkown", 0);
      Klg = new b("image", 1);
      Klh = new b("video", 2);
      Kli = new b("sight", 3);
      Klj = new b("appimage", 4);
      Klk = new b[] { Klf, Klg, Klh, Kli, Klj };
      AppMethodBeat.o(35891);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void ta();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b
 * JD-Core Version:    0.7.0.1
 */