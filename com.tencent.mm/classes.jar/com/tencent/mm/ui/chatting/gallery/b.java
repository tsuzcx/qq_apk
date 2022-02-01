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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.y;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.b.a.i.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.w;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b
  extends com.tencent.mm.ui.base.u
{
  public static long nYO = -1L;
  public static boolean ruj = false;
  public ImageGalleryUI JPk;
  protected a JPl;
  private String JPm;
  boolean JPn;
  public boolean JPo;
  public d JPp;
  public j JPq;
  public i JPr;
  public c JPs;
  public boolean JPt;
  boolean JPu;
  protected boolean JPv;
  private com.tencent.mm.g.b.a.i JPw;
  private String fJG;
  private int fromScene;
  private ArrayList<bu> rCx;
  
  public b(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35892);
    this.JPn = true;
    this.JPo = false;
    this.JPt = false;
    this.fJG = null;
    this.JPv = true;
    this.rCx = new ArrayList();
    this.JPw = null;
    this.JPt = paramImageGalleryUI.getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    String str;
    if (!this.JPt)
    {
      str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + bt.flS();
      if ((paramLong1 <= 0L) || (paramString1 == null) || (paramString1.length() <= 0)) {
        break label248;
      }
    }
    label248:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      this.JPk = paramImageGalleryUI;
      ruj = paramBoolean1;
      nYO = paramLong2;
      this.fJG = paramString1;
      this.fromScene = paramInt;
      this.JPl = new a(paramLong1, paramString1, this, paramBoolean, paramInt);
      this.JPo = paramBoolean2;
      this.JPm = paramString2;
      this.JPp = new d(this);
      this.JPq = new j(this);
      this.JPr = new i(this);
      AppMethodBeat.o(35892);
      return;
    }
  }
  
  private void L(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35909);
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
      AppMethodBeat.o(35909);
      return;
    }
    Object localObject;
    if (bt.isNullOrNil(this.JPm))
    {
      ad.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      localObject = new Intent(this.JPk, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Id", paramLong);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", paramInt);
      paramString = this.JPk;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35909);
      return;
    }
    ad.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.JPm });
    if (!bt.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.modelmulti.o.a(o.d.ifX).pk(4);
      ((o.e)localObject).dyU = com.tencent.mm.model.u.aAm();
      ((o.e)localObject).toUser = this.JPm;
      ((o.e)localObject).ibF = paramString;
      ((o.e)localObject).hZz = paramInt;
      ((o.e)localObject).igd = null;
      ((o.e)localObject).igc = 6;
      ((o.e)localObject).aJv().execute();
      bz.aCx().d(bz.hIc, null);
    }
    if (this.JPn)
    {
      localObject = new Intent(this.JPk, ChattingUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.JPm);
      paramString = this.JPk;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.JPm });
      AppMethodBeat.o(35909);
      return;
      com.tencent.mm.ui.base.h.cl(this.JPk, this.JPk.getString(2131755881));
    }
  }
  
  public static void a(Context paramContext, final bu parambu)
  {
    AppMethodBeat.i(194139);
    if ((paramContext == null) || (parambu == null))
    {
      AppMethodBeat.o(194139);
      return;
    }
    parambu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194131);
        b.b(this.val$context, parambu, this.JPy);
        if (this.JPz != null) {
          this.JPz.run();
        }
        AppMethodBeat.o(194131);
      }
    };
    b.4 local4 = new b.4(paramContext);
    if (PermissionHelper.aLV("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      parambu.run();
      AppMethodBeat.o(194139);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      p.a(paramContext, parambu, local4);
      AppMethodBeat.o(194139);
      return;
    }
    local4.run();
    AppMethodBeat.o(194139);
  }
  
  public static boolean b(Context paramContext, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(35912);
    if (parambu == null)
    {
      AppMethodBeat.o(35912);
      return false;
    }
    Object localObject = com.tencent.mm.modelvideo.o.aMJ().Hb(parambu.field_imgPath);
    boolean bool = false;
    if (localObject != null)
    {
      int i = 0;
      if (w.vF(((s)localObject).getUser())) {
        i = com.tencent.mm.model.q.yS(((s)localObject).getUser());
      }
      bool = ((s)localObject).aMY();
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yhR.f(12084, new Object[] { Integer.valueOf(((s)localObject).hMP), Integer.valueOf(((s)localObject).hHQ * 1000), Integer.valueOf(0), Integer.valueOf(2), ((s)localObject).getUser(), Integer.valueOf(i), s.GY(((s)localObject).aMV()), Long.valueOf(((s)localObject).createTime) });
    }
    if (!bool)
    {
      ad.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131764682), 1).show();
      }
      AppMethodBeat.o(35912);
      return false;
    }
    com.tencent.mm.modelvideo.o.aMJ();
    localObject = com.tencent.mm.modelvideo.u.Hz(com.tencent.mm.modelvideo.t.Hh(parambu.field_imgPath));
    if (bt.isNullOrNil((String)localObject))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131764682), 1).show();
      }
      AppMethodBeat.o(35912);
      return false;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aRB((String)localObject) }), 1).show();
    }
    String str = com.tencent.mm.vfs.i.aPK((String)localObject);
    v localv = v.iNJ;
    v.bH(str, bl.Bt(parambu.eLs));
    com.tencent.mm.sdk.f.b.s((String)localObject, paramContext);
    AppMethodBeat.o(35912);
    return true;
  }
  
  public static boolean b(bu parambu, com.tencent.mm.aw.g paramg)
  {
    AppMethodBeat.i(35903);
    if ((parambu == null) || (paramg == null))
    {
      AppMethodBeat.o(35903);
      return false;
    }
    boolean bool = com.tencent.mm.aw.q.aIG().a(paramg.dnz, parambu.field_msgId, 1);
    AppMethodBeat.o(35903);
    return bool;
  }
  
  public static boolean bX(bu parambu)
  {
    AppMethodBeat.i(35899);
    if (parambu == null)
    {
      AppMethodBeat.o(35899);
      return false;
    }
    if (parambu.getType() == 62)
    {
      AppMethodBeat.o(35899);
      return true;
    }
    AppMethodBeat.o(35899);
    return false;
  }
  
  public static boolean bY(bu parambu)
  {
    AppMethodBeat.i(35900);
    if (parambu == null)
    {
      AppMethodBeat.o(35900);
      return false;
    }
    if (parambu.getType() == 49)
    {
      AppMethodBeat.o(35900);
      return true;
    }
    AppMethodBeat.o(35900);
    return false;
  }
  
  public static boolean bZ(bu parambu)
  {
    AppMethodBeat.i(35901);
    if (parambu == null)
    {
      AppMethodBeat.o(35901);
      return false;
    }
    if (parambu.getType() == 268435505)
    {
      AppMethodBeat.o(35901);
      return true;
    }
    AppMethodBeat.o(35901);
    return false;
  }
  
  public static int c(bu parambu, com.tencent.mm.aw.g paramg)
  {
    AppMethodBeat.i(35918);
    if (parambu.field_isSend == 1)
    {
      if (paramg.aIj())
      {
        parambu = com.tencent.mm.aw.h.a(paramg);
        if ((parambu != null) && (parambu.dnz > 0L) && (parambu.aIi()) && (com.tencent.mm.vfs.i.fv(com.tencent.mm.aw.q.aIF().o(parambu.hZw, "", ""))))
        {
          AppMethodBeat.o(35918);
          return 1;
        }
      }
      AppMethodBeat.o(35918);
      return 0;
    }
    if (paramg.aIi())
    {
      if (paramg.aIj())
      {
        parambu = com.tencent.mm.aw.h.a(paramg);
        if ((parambu != null) && (parambu.dnz > 0L) && (parambu.aIi()) && (com.tencent.mm.vfs.i.fv(com.tencent.mm.aw.q.aIF().o(parambu.hZw, "", ""))))
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
  
  public static void c(Context paramContext, final bu parambu, final boolean paramBoolean)
  {
    AppMethodBeat.i(194140);
    if ((paramContext == null) || (parambu == null))
    {
      AppMethodBeat.o(194140);
      return;
    }
    parambu = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194133);
        b.d(this.val$context, parambu, paramBoolean);
        if (this.JPz != null) {
          this.JPz.run();
        }
        AppMethodBeat.o(194133);
      }
    };
    b.6 local6 = new b.6(paramBoolean, paramContext);
    if (PermissionHelper.aLV("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      parambu.run();
      AppMethodBeat.o(194140);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      p.a(paramContext, parambu, local6);
      AppMethodBeat.o(194140);
      return;
    }
    local6.run();
    AppMethodBeat.o(194140);
  }
  
  public static boolean ca(bu parambu)
  {
    AppMethodBeat.i(35902);
    if (parambu == null)
    {
      AppMethodBeat.o(35902);
      return false;
    }
    boolean bool = parambu.cxg();
    AppMethodBeat.o(35902);
    return bool;
  }
  
  public static b cb(bu parambu)
  {
    AppMethodBeat.i(35906);
    b localb = b.JPU;
    if (parambu == null) {
      localb = b.JPU;
    }
    if (bZ(parambu))
    {
      parambu = b.JPY;
      AppMethodBeat.o(35906);
      return parambu;
    }
    if (j(parambu))
    {
      parambu = b.JPV;
      AppMethodBeat.o(35906);
      return parambu;
    }
    if (cc(parambu))
    {
      parambu = b.JPX;
      AppMethodBeat.o(35906);
      return parambu;
    }
    if (m(parambu))
    {
      parambu = b.JPW;
      AppMethodBeat.o(35906);
      return parambu;
    }
    if (bX(parambu))
    {
      parambu = b.JPW;
      AppMethodBeat.o(35906);
      return parambu;
    }
    parambu = b.JPU;
    AppMethodBeat.o(35906);
    return parambu;
  }
  
  public static boolean cc(bu parambu)
  {
    AppMethodBeat.i(35907);
    if (parambu != null)
    {
      if (parambu.cxg())
      {
        AppMethodBeat.o(35907);
        return false;
      }
      parambu = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
      if ((parambu != null) && (parambu.iun != null) && ((!bt.isNullOrNil(parambu.iun.hCe)) || (parambu.iun.Gje > 0) || (!bt.isNullOrNil(parambu.iun.hCh)) || (!bt.isNullOrNil(parambu.iun.hCi)) || (!bt.isNullOrNil(parambu.iun.hCg)) || (!bt.isNullOrNil(parambu.iun.hCj)) || (!bt.isNullOrNil(parambu.iun.hCk)) || (!bt.isNullOrNil(parambu.iun.hCl))))
      {
        AppMethodBeat.o(35907);
        return true;
      }
    }
    AppMethodBeat.o(35907);
    return false;
  }
  
  public static boolean d(Context paramContext, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(35913);
    if (bZ(parambu)) {}
    for (Object localObject1 = l(parambu); (localObject1 == null) || (((String)localObject1).length() == 0); localObject1 = d.a(parambu, (com.tencent.mm.aw.g)localObject1))
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambu.field_msgId);
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
      }
      AppMethodBeat.o(35913);
      return false;
      if ((parambu == null) || (parambu.field_msgId == 0L))
      {
        ad.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
        }
        AppMethodBeat.o(35913);
        return false;
      }
      localObject1 = d.k(parambu);
      if ((localObject1 == null) || (((com.tencent.mm.aw.g)localObject1).dnz == 0L))
      {
        localObject2 = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (parambu == null)
        {
          parambu = "null";
          localObject2 = ((StringBuilder)localObject2).append(parambu).append(", imgLocalId = ");
          if (localObject1 != null) {
            break label241;
          }
        }
        label241:
        for (parambu = "null";; parambu = Long.valueOf(((com.tencent.mm.aw.g)localObject1).dnz))
        {
          ad.e("MicroMsg.ImageGalleryAdapter", parambu);
          if (paramBoolean) {
            Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
          }
          AppMethodBeat.o(35913);
          return false;
          parambu = Long.valueOf(parambu.field_msgId);
          break;
        }
      }
    }
    Object localObject2 = p.IP((String)localObject1);
    ad.i("MicroMsg.ExportFileUtil", "[+] Called exportImage, src: %s, dest: %s", new Object[] { localObject1, localObject2 });
    localObject1 = p.l(paramContext, (String)localObject1, (String)localObject2);
    if (!bt.isNullOrNil((String)localObject1))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.ffp() }), 1).show();
      }
      paramContext = com.tencent.mm.vfs.i.aPK((String)localObject1);
      localObject1 = v.iNJ;
      v.bH(paramContext, bl.Bt(parambu.eLs));
      AppMethodBeat.o(35913);
      return true;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
    }
    AppMethodBeat.o(35913);
    return false;
  }
  
  public static void f(Context paramContext, List<bu> paramList)
  {
    AppMethodBeat.i(194138);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(194138);
      return;
    }
    paramList = new b.1(paramList, paramContext);
    b.2 local2 = new b.2(paramContext);
    if ((paramContext instanceof Activity))
    {
      p.a(paramContext, paramList, local2);
      AppMethodBeat.o(194138);
      return;
    }
    local2.run();
    AppMethodBeat.o(194138);
  }
  
  public static boolean j(bu parambu)
  {
    AppMethodBeat.i(35897);
    if (parambu == null)
    {
      AppMethodBeat.o(35897);
      return false;
    }
    if ((parambu.getType() == 3) || (parambu.getType() == 39) || (parambu.getType() == 13))
    {
      AppMethodBeat.o(35897);
      return true;
    }
    AppMethodBeat.o(35897);
    return false;
  }
  
  public static String l(bu parambu)
  {
    Object localObject1 = null;
    AppMethodBeat.i(35916);
    Object localObject2 = k.b.yr(parambu.field_content);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35916);
      return null;
    }
    parambu = localObject1;
    if (((k.b)localObject2).dks != null)
    {
      parambu = localObject1;
      if (((k.b)localObject2).dks.length() > 0)
      {
        localObject2 = ao.bIX().aLD(((k.b)localObject2).dks);
        parambu = localObject1;
        if (localObject2 != null) {
          parambu = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        }
      }
    }
    AppMethodBeat.o(35916);
    return parambu;
  }
  
  public static boolean m(bu parambu)
  {
    AppMethodBeat.i(35898);
    if (parambu == null)
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if (cc(parambu))
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if ((parambu.getType() == 43) || (parambu.getType() == 486539313) || (parambu.getType() == 44) || (parambu.getType() == 62))
    {
      AppMethodBeat.o(35898);
      return true;
    }
    AppMethodBeat.o(35898);
    return false;
  }
  
  public final MultiTouchImageView Hq(int paramInt)
  {
    AppMethodBeat.i(35920);
    Object localObject = super.SJ(paramInt);
    if (localObject == null)
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
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
  
  public final WxImageView Hr(int paramInt)
  {
    AppMethodBeat.i(35921);
    Object localObject = super.SJ(paramInt);
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
  
  public final void a(bu parambu, com.tencent.mm.aw.g paramg, int paramInt, i.a parama)
  {
    AppMethodBeat.i(35934);
    if (parambu == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    if (this.JPw == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    this.JPw.RI().dRL = parama;
    long l1 = parambu.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.JPw.dRD != l1) && (this.JPw.dRF != i); i = 0)
    {
      ad.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.JPw.dRD), Long.valueOf(l1) });
      parambu = this.JPw;
      parambu.dRL = i.a.dRN;
      parambu.aLk();
      AppMethodBeat.o(35934);
      return;
    }
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0L;
    long l7 = bt.HI();
    long l3 = l6;
    long l2 = l5;
    l1 = l4;
    if (parama == i.a.dRM)
    {
      parambu = d.a(parambu, paramg);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!bt.isNullOrNil(parambu))
      {
        l1 = com.tencent.mm.vfs.i.aYo(parambu);
        parambu = d.aWn(parambu);
        l3 = parambu.outWidth;
        l2 = parambu.outHeight;
      }
    }
    parambu = this.JPw;
    parambu.dRG = l1;
    parambu.dRI = l2;
    parambu.dRH = l3;
    this.JPw.aLk();
    ad.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(bt.aO(l7)), this.JPw.RD() });
    this.JPw = null;
    AppMethodBeat.o(35934);
  }
  
  public final void adA(int paramInt)
  {
    AppMethodBeat.i(35923);
    this.JPq.j(ada(paramInt), paramInt);
    AppMethodBeat.o(35923);
  }
  
  public final void adB(int paramInt)
  {
    AppMethodBeat.i(35924);
    this.JPq.k(ada(paramInt), paramInt);
    AppMethodBeat.o(35924);
  }
  
  public final void adC(int paramInt)
  {
    AppMethodBeat.i(35927);
    this.JPq.adv(paramInt);
    AppMethodBeat.o(35927);
  }
  
  public final void adD(int paramInt)
  {
    AppMethodBeat.i(35930);
    bu localbu = ada(paramInt);
    if ((localbu == null) || (!j(localbu)))
    {
      AppMethodBeat.o(35930);
      return;
    }
    this.JPp.cj(localbu);
    AppMethodBeat.o(35930);
  }
  
  public final void adE(int paramInt)
  {
    AppMethodBeat.i(35931);
    this.JPr.adK(paramInt);
    AppMethodBeat.o(35931);
  }
  
  public final bu ada(int paramInt)
  {
    AppMethodBeat.i(35894);
    bu localbu = this.JPl.adG(paramInt);
    AppMethodBeat.o(35894);
    return localbu;
  }
  
  public final void adw(int paramInt)
  {
    AppMethodBeat.i(35904);
    Object localObject1 = ada(paramInt);
    Object localObject2 = cb((bu)localObject1);
    switch (8.JPD[localObject2.ordinal()])
    {
    default: 
      ce((bu)localObject1);
      AppMethodBeat.o(35904);
      return;
    case 1: 
    case 2: 
      cd((bu)localObject1);
      AppMethodBeat.o(35904);
      return;
    }
    String str = l((bu)localObject1);
    localObject2 = new Intent(this.JPk, MsgRetransmitUI.class);
    ((Intent)localObject2).putExtra("Retr_File_Name", str);
    ((Intent)localObject2).putExtra("Retr_Msg_Id", ((ei)localObject1).field_msgId);
    ((Intent)localObject2).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject2).putExtra("Retr_Msg_content", ((ei)localObject1).field_content);
    ((Intent)localObject2).putExtra("Retr_Compress_Type", 0);
    localObject1 = this.JPk;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35904);
  }
  
  public final void adx(int paramInt)
  {
    AppMethodBeat.i(35905);
    Object localObject1 = ada(paramInt);
    Object localObject2 = cb((bu)localObject1);
    switch (8.JPD[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35905);
      return;
      localObject2 = new Intent(this.JPk, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject2).putExtra("Retr_Msg_Id", ((ei)localObject1).field_msgId);
      localObject1 = this.JPk;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public final void ady(int paramInt)
  {
    AppMethodBeat.i(35914);
    Object localObject1 = ada(paramInt);
    if (this.JPt)
    {
      localObject1 = j.cr((bu)localObject1);
      if (localObject1 == null)
      {
        ad.e("MicroMsg.ImageGalleryAdapter", "doFavoriteImage mpShareVideoInfo should not be null");
        AppMethodBeat.o(35914);
        return;
      }
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.f.EoS;
      com.tencent.mm.plugin.webview.ui.tools.media.f.b((y)localObject1);
      com.tencent.mm.ui.base.h.cl(this.JPk, this.JPk.getString(2131758936));
      AppMethodBeat.o(35914);
      return;
    }
    Object localObject2 = new cv();
    com.tencent.mm.pluginsdk.model.g.e((cv)localObject2, (bu)localObject1);
    ((cv)localObject2).dnG.activity = this.JPk;
    ((cv)localObject2).dnG.dnM = 44;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
    if (((cv)localObject2).dnH.ret == 0)
    {
      if (((bu)localObject1).cxh()) {
        com.tencent.mm.ui.chatting.a.a(a.c.Jxc, a.d.Jxi, (bu)localObject1, 0);
      }
      com.tencent.mm.modelstat.b.inZ.S((bu)localObject1);
    }
    AppMethodBeat.o(35914);
  }
  
  public final View adz(int paramInt)
  {
    AppMethodBeat.i(35922);
    View localView3 = super.SJ(paramInt);
    if (localView3 == null)
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
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
  
  public final void bg(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35919);
    this.JPp.bg(paramInt, paramBoolean);
    AppMethodBeat.o(35919);
  }
  
  public final void cd(bu parambu)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(35908);
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.JPk, null);
      AppMethodBeat.o(35908);
      return;
    }
    if (parambu.cxg())
    {
      parambu = j.cr(parambu);
      if (parambu == null)
      {
        ad.e("MicroMsg.ImageGalleryAdapter", "doRestransmitVideo mpShareVideoInfo should not be null");
        AppMethodBeat.o(35908);
        return;
      }
      if (this.JPk.Eeo == null) {
        this.JPk.Eeo = new com.tencent.mm.plugin.webview.ui.tools.media.e();
      }
      this.JPk.Eeo.hzo = parambu;
      if (this.JPt) {}
      for (;;)
      {
        parambu.hDO = this.JPk.JRs.oog;
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.d.EoO;
        com.tencent.mm.plugin.webview.ui.tools.media.d.a(this.JPk, parambu.hDm, "", parambu.title, parambu.url, i);
        AppMethodBeat.o(35908);
        return;
        i = 0;
      }
    }
    s locals = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
    if (locals == null)
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      AppMethodBeat.o(35908);
      return;
    }
    Object localObject = new Intent(this.JPk, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_length", locals.hHQ);
    ((Intent)localObject).putExtra("Retr_File_Name", parambu.field_imgPath);
    ((Intent)localObject).putExtra("Retr_video_isexport", locals.iui);
    i = j;
    if (bX(parambu)) {
      i = 11;
    }
    ((Intent)localObject).putExtra("Retr_Msg_Type", i);
    ((Intent)localObject).putExtra("Retr_Msg_Id", parambu.field_msgId);
    ((Intent)localObject).putExtra("Retr_From", "gallery");
    parambu = this.JPk;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(parambu, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parambu.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(parambu, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35908);
  }
  
  public final void ce(bu parambu)
  {
    AppMethodBeat.i(35910);
    com.tencent.mm.aw.g localg = d.k(parambu);
    if ((parambu == null) || (parambu.field_msgId == 0L) || (localg == null) || (localg.dnz == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (parambu == null)
      {
        parambu = "null";
        localObject = ((StringBuilder)localObject).append(parambu).append(", imgLocalId = ");
        if (localg != null) {
          break label107;
        }
      }
      label107:
      for (parambu = "null";; parambu = Long.valueOf(localg.dnz))
      {
        ad.e("MicroMsg.ImageGalleryAdapter", parambu);
        AppMethodBeat.o(35910);
        return;
        parambu = Long.valueOf(parambu.field_msgId);
        break;
      }
    }
    Object localObject = d.a(parambu, localg);
    if (bt.isNullOrNil((String)localObject))
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambu.field_msgId + ", imgLocalId = " + localg.dnz);
      AppMethodBeat.o(35910);
      return;
    }
    L((String)localObject, c(parambu, localg), parambu.field_msgId);
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
    this.JPp.detach();
    this.JPq.detach();
    this.JPr.detach();
    if (this.JPw != null)
    {
      com.tencent.mm.g.b.a.i locali = this.JPw.RI();
      locali.dRL = i.a.dRN;
      locali.aLk();
    }
    super.detach();
    AppMethodBeat.o(35917);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(35915);
    final bu localbu = ada(paramInt);
    View localView;
    final k localk;
    if (paramView == null)
    {
      localView = View.inflate(this.JPk, 2131494469, null);
      localk = new k(this, localView);
      localView.setTag(localk);
      paramView = cb(localbu);
      localk.mPosition = paramInt;
      localk.JTa = paramView;
      k.aH(localk.tPw, 0);
      switch (k.5.JPD[paramView.ordinal()])
      {
      default: 
        label108:
        k.aH(localk.JTz, 8);
        k.aH(localk.JTA, 8);
        k.aH(localk.JTq, 8);
        k.aH(localk.JTw, 8);
        k.aH(localk.JTv, 8);
        ad.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (8.JPD[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.JPv = false;
      AppMethodBeat.o(35915);
      return localView;
      localk = (k)paramView.getTag();
      localView = paramView;
      break;
      k.aH(localk.JTi, 8);
      k.aH(localk.JTc, 8);
      break label108;
      localk.fGB();
      k.aH(localk.JTi, 0);
      k.aH(localk.JTc, 8);
      if (localk.JTc == null) {
        break label108;
      }
      k.aH(localk.JTe, 8);
      break label108;
      localk.fGA();
      k.aH(localk.JTi, 8);
      k.aH(localk.JTc, 0);
      break label108;
      k.aH(localk.tPw, 8);
      k.aH(localk.JTi, 8);
      k.aH(localk.JTc, 8);
      break label108;
      this.JPp.a(localk, localbu, paramInt);
      if (paramInt == a.JPE)
      {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ai(localbu);
        continue;
        k.aH(localk.JTz, 0);
        k.aH(localk.JTq, 8);
        k.aH(localk.JTv, 8);
        k.aH(localk.JTw, 8);
        k.aH(localk.JTm, 8);
        final String str = l(localbu);
        try
        {
          paramView = com.tencent.mm.platformtools.u.IU(str);
          localObject = paramView;
          if (paramView == null)
          {
            localObject = com.tencent.mm.platformtools.u.IT(com.tencent.mm.aw.q.aIF().R(localbu.field_imgPath, true));
            k.aH(localk.JTv, 0);
            new ap().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(194136);
                m.a(localbu, new m.a()
                {
                  public final void jk(int paramAnonymous2Int1, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(194135);
                    if (paramAnonymous2Int1 == paramAnonymous2Int2)
                    {
                      ad.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(b.7.this.hED.field_msgId) });
                      k.aH(b.7.this.JPA.JTv, 8);
                    }
                    try
                    {
                      Bitmap localBitmap1 = com.tencent.mm.platformtools.u.IU(b.7.this.liS);
                      if (localBitmap1 != null)
                      {
                        b.7.this.JPA.JTz.setEnableHorLongBmpMode(false);
                        com.tencent.mm.sdk.platformtools.q.A(b.7.this.JPA.JTz, localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.7.this.JPA.JTz.cH(localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.7.this.JPA.JTz.setImageBitmap(localBitmap1);
                        b.7.this.JPA.JTz.invalidate();
                      }
                      AppMethodBeat.o(194135);
                      return;
                    }
                    catch (OutOfMemoryError localOutOfMemoryError)
                    {
                      for (;;)
                      {
                        ad.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { b.7.this.liS });
                        Runtime.getRuntime().gc();
                        Runtime.getRuntime().runFinalization();
                        Bitmap localBitmap2 = com.tencent.mm.platformtools.u.IT(b.7.this.liS);
                      }
                    }
                  }
                });
                AppMethodBeat.o(194136);
              }
            });
          }
          if (localObject == null)
          {
            ad.w("MicroMsg.ImageGalleryAdapter", "get image fail");
            localk.JTz.setVisibility(8);
            localk.fGz().JTw.setVisibility(0);
            localk.fGz().JTy.setImageResource(2131690686);
            localk.fGz().JTx.setText(this.JPk.getString(2131760324));
            if (paramInt != a.JPE) {
              continue;
            }
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ai(localbu);
          }
        }
        catch (OutOfMemoryError paramView)
        {
          for (;;)
          {
            Object localObject;
            ad.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { str });
            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
            paramView = com.tencent.mm.platformtools.u.IT(str);
            continue;
            localk.JTz.setEnableHorLongBmpMode(false);
            com.tencent.mm.sdk.platformtools.q.A(localk.JTz, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.JTz.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.JTz.setImageBitmap((Bitmap)localObject);
            localk.JTz.invalidate();
          }
        }
        this.JPq.a(localk, localbu, paramInt);
        continue;
        this.JPr.a(localk, localbu, paramInt);
      }
    }
  }
  
  public final void fFK()
  {
    AppMethodBeat.i(35895);
    this.JPl.fFK();
    AppMethodBeat.o(35895);
  }
  
  public final bu fFL()
  {
    AppMethodBeat.i(35925);
    bu localbu = ada(this.JPk.getCurrentItem());
    AppMethodBeat.o(35925);
    return localbu;
  }
  
  public final k fFM()
  {
    AppMethodBeat.i(35926);
    Object localObject2 = this.JPp.adu(this.JPk.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.JPq.adu(this.JPk.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.JPr.adu(this.JPk.getCurrentItem());
    }
    AppMethodBeat.o(35926);
    return localObject2;
  }
  
  public final void fFN()
  {
    AppMethodBeat.i(35929);
    this.JPq.onResume();
    AppMethodBeat.o(35929);
  }
  
  public final int firstItemPosForDetermine()
  {
    AppMethodBeat.i(194141);
    int i = a.JPE;
    int j = a.c(this.JPl);
    AppMethodBeat.o(194141);
    return i - j;
  }
  
  public final com.tencent.mm.aw.g g(bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(35896);
    parambu = this.JPp.g(parambu, paramBoolean);
    AppMethodBeat.o(35896);
    return parambu;
  }
  
  public final int getCount()
  {
    a locala = this.JPl;
    return locala.fTM - locala.JPH + a.JPE + 1;
  }
  
  public final int getRealCount()
  {
    return this.JPl.fTM;
  }
  
  public final void h(bu parambu, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(35933);
    if (parambu == null)
    {
      AppMethodBeat.o(35933);
      return;
    }
    Object localObject = fFL();
    if ((localObject == null) || (((ei)localObject).field_msgId != parambu.field_msgId))
    {
      ad.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((ei)localObject).field_msgId), Long.valueOf(parambu.field_msgId) });
      AppMethodBeat.o(35933);
      return;
    }
    long l = parambu.field_msgSvrId;
    if ((this.JPw != null) && ((this.JPw.dRD != l) || (this.JPw.dRF != paramBoolean)))
    {
      localObject = this.JPw.RI();
      ((com.tencent.mm.g.b.a.i)localObject).dRL = i.a.dRN;
      ((com.tencent.mm.g.b.a.i)localObject).aLk();
    }
    this.JPw = new com.tencent.mm.g.b.a.i();
    this.JPw.RH();
    localObject = this.JPw;
    ((com.tencent.mm.g.b.a.i)localObject).dRD = l;
    ((com.tencent.mm.g.b.a.i)localObject).dRE = parambu.field_createTime;
    ((com.tencent.mm.g.b.a.i)localObject).dRF = paramBoolean;
    if (w.vF(this.fJG)) {
      i = com.tencent.mm.model.q.yS(this.fJG);
    }
    parambu = this.JPw;
    parambu.dRB = parambu.t("ChatName", this.fJG, true);
    parambu.dRC = i;
    AppMethodBeat.o(35933);
  }
  
  public final int lastItemPosForDetermine()
  {
    AppMethodBeat.i(194142);
    int i = a.JPE;
    int j = a.c(this.JPl);
    int k = a.d(this.JPl);
    AppMethodBeat.o(194142);
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
    if ((this.JPp != null) && (j(ada(paramInt)))) {
      this.JPp.JQH.onPageSelected(paramInt);
    }
    AppMethodBeat.o(35893);
  }
  
  public static final class a
  {
    public static int JPE = 100000;
    private List<bu> JPF;
    int JPH;
    protected int JPI;
    protected int JPJ;
    protected int JPK;
    protected long JPL;
    private b JPM;
    public HashMap<Long, com.tencent.mm.aw.g> JPN;
    public HashMap<Long, com.tencent.mm.aw.g> JPO;
    protected boolean bdb;
    int fTM;
    private int fromScene;
    private ap handler;
    private int min;
    private String talker;
    
    public a(final long paramLong, String paramString, final b paramb, Boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(35881);
      this.bdb = false;
      this.JPN = new HashMap();
      this.JPO = new HashMap();
      this.handler = new ap();
      this.talker = paramString;
      this.JPF = new LinkedList();
      this.JPM = paramb;
      this.fromScene = paramInt;
      if (paramb.JPt)
      {
        paramString = j.f(paramString, paramb.JPk);
        this.JPF.add(paramString);
        JPE = 0;
        AppMethodBeat.o(35881);
        return;
      }
      JPE = 100000;
      ba.aBQ();
      paramString = com.tencent.mm.model.c.azs().xY(paramLong);
      if (paramString.field_msgId == 0L)
      {
        Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + bt.flS(), false);
        AppMethodBeat.o(35881);
        return;
      }
      this.JPF.add(paramString);
      if (this.fromScene == 1) {}
      for (paramInt = i; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(35881);
        return;
      }
      ba.ajF().ay(new Runnable()
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
                if (b.a.1.this.JPR.JPs != null) {
                  b.a.1.this.JPR.JPs.ta();
                }
                AppMethodBeat.o(35878);
              }
            }, 0L);
          }
          AppMethodBeat.o(35879);
        }
      });
      paramb.JPk.JSa = new ImageGalleryUI.a()
      {
        public final void r(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35880);
          ad.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(paramAnonymousBoolean)));
          if (!paramAnonymousBoolean.booleanValue())
          {
            b.a.a(b.a.this);
            if (paramb.JPs != null) {
              paramb.JPs.ta();
            }
          }
          AppMethodBeat.o(35880);
        }
      };
      AppMethodBeat.o(35881);
    }
    
    private void K(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(35885);
      ad.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
      if (b.ruj) {
        ba.aBQ();
      }
      for (List localList = com.tencent.mm.model.c.azt().b(this.talker, b.nYO, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.azs().f(this.talker, paramLong, paramBoolean))
      {
        ad.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(paramBoolean)));
        AppMethodBeat.o(35885);
        return;
        ba.aBQ();
      }
      ad.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
      paramLong = System.currentTimeMillis();
      jdMethod_if(localList);
      ad.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
      if (paramBoolean)
      {
        this.JPF.addAll(localList);
        AppMethodBeat.o(35885);
        return;
      }
      this.JPF.addAll(0, localList);
      this.min -= localList.size();
      if (this.min < 0)
      {
        ad.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
        AppMethodBeat.o(35885);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("min from ");
      int i = this.min;
      ad.i("MicroMsg.AutoList", localList.size() + i + " to " + this.min);
      AppMethodBeat.o(35885);
    }
    
    private void jdMethod_if(List<bu> paramList)
    {
      AppMethodBeat.i(35882);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (b.j((bu)paramList.get(i)))
        {
          localArrayList1.add(Long.valueOf(((bu)paramList.get(i)).field_msgSvrId));
          if (((bu)paramList.get(i)).field_isSend == 1) {
            localArrayList2.add(Long.valueOf(((bu)paramList.get(i)).field_msgId));
          }
        }
        i += 1;
      }
      this.JPN.putAll(com.tencent.mm.aw.q.aIF().a((Long[])localArrayList1.toArray(new Long[0])));
      this.JPO.putAll(com.tencent.mm.aw.q.aIF().b((Long[])localArrayList2.toArray(new Long[0])));
      AppMethodBeat.o(35882);
    }
    
    public final void a(long paramLong, com.tencent.mm.aw.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(35883);
      if (paramBoolean)
      {
        this.JPN.put(Long.valueOf(paramLong), paramg);
        AppMethodBeat.o(35883);
        return;
      }
      this.JPO.put(Long.valueOf(paramLong), paramg);
      AppMethodBeat.o(35883);
    }
    
    public final int adF(int paramInt)
    {
      return paramInt - JPE + this.JPH;
    }
    
    public final bu adG(int paramInt)
    {
      AppMethodBeat.i(35884);
      paramInt = adF(paramInt);
      int i = this.min + this.JPF.size() - 1;
      if ((paramInt < this.min) || (paramInt > i))
      {
        ad.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
        AppMethodBeat.o(35884);
        return null;
      }
      ad.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(paramInt)));
      if (paramInt == this.min)
      {
        localbu = (bu)this.JPF.get(0);
        if (this.bdb) {
          K(localbu.field_msgId, false);
        }
        AppMethodBeat.o(35884);
        return localbu;
      }
      if ((paramInt == i) && (i < this.fTM - 1))
      {
        localbu = (bu)this.JPF.get(this.JPF.size() - 1);
        if (this.bdb) {
          K(localbu.field_msgId, true);
        }
        AppMethodBeat.o(35884);
        return localbu;
      }
      bu localbu = (bu)this.JPF.get(paramInt - this.min);
      AppMethodBeat.o(35884);
      return localbu;
    }
    
    public final void fFK()
    {
      this.bdb = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(35886);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AutoList, Size = " + this.JPF.size());
      ((StringBuilder)localObject).append("; Content = {");
      Iterator localIterator = this.JPF.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(((bu)localIterator.next()).field_msgId);
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
      JPU = new b("unkown", 0);
      JPV = new b("image", 1);
      JPW = new b("video", 2);
      JPX = new b("sight", 3);
      JPY = new b("appimage", 4);
      JPZ = new b[] { JPU, JPV, JPW, JPX, JPY };
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