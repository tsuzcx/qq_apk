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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.g.b.a.x.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ca;
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
import java.util.concurrent.Callable;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class b
  extends com.tencent.mm.ui.base.v
{
  public static long ppv = -1L;
  public static boolean tca = false;
  public d PwA;
  public j PwB;
  public i PwC;
  public c PwD;
  public boolean PwE;
  boolean PwF;
  protected boolean PwG;
  private x PwH;
  public ImageGalleryUI Pwv;
  protected a Pww;
  private String Pwx;
  boolean Pwy;
  public boolean Pwz;
  private int fromScene;
  private String gqV;
  private ArrayList<ca> tkt;
  
  public b(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35892);
    this.Pwy = true;
    this.Pwz = false;
    this.PwE = false;
    this.gqV = null;
    this.PwG = true;
    this.tkt = new ArrayList();
    this.PwH = null;
    this.PwE = paramImageGalleryUI.getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    String str;
    if (!this.PwE)
    {
      str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + Util.getStack();
      if ((paramLong1 <= 0L) || (paramString1 == null) || (paramString1.length() <= 0)) {
        break label248;
      }
    }
    label248:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      this.Pwv = paramImageGalleryUI;
      tca = paramBoolean1;
      ppv = paramLong2;
      this.gqV = paramString1;
      this.fromScene = paramInt;
      this.Pww = new a(paramLong1, paramString1, this, paramBoolean, paramInt);
      this.Pwz = paramBoolean2;
      this.Pwx = paramString2;
      this.PwA = new d(this);
      this.PwB = new j(this);
      this.PwC = new i(this);
      AppMethodBeat.o(35892);
      return;
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
    if (Util.isNullOrNil(this.Pwx))
    {
      Log.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      localObject = new Intent(this.Pwv, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Id", paramLong);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", paramInt);
      paramString = this.Pwv;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35909);
      return;
    }
    Log.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.Pwx });
    if (!Util.isNullOrNil(paramString))
    {
      localObject = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(4);
      ((o.e)localObject).dRL = z.aTY();
      ((o.e)localObject).toUser = this.Pwx;
      ((o.e)localObject).iZt = paramString;
      ((o.e)localObject).iXp = paramInt;
      ((o.e)localObject).jdS = null;
      ((o.e)localObject).jdR = 6;
      ((o.e)localObject).bdQ().execute();
      cf.aWl().f(cf.iFI, null);
    }
    if (this.Pwy)
    {
      localObject = new Intent(this.Pwv, ChattingUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.Pwx);
      paramString = this.Pwv;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.Pwx });
      AppMethodBeat.o(35909);
      return;
      com.tencent.mm.ui.base.h.cD(this.Pwv, this.Pwv.getString(2131755971));
    }
  }
  
  public static void a(Context paramContext, final ca paramca)
  {
    AppMethodBeat.i(233287);
    if ((paramContext == null) || (paramca == null))
    {
      AppMethodBeat.o(233287);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, new Callable()new android.support.v4.e.c {}, new android.support.v4.e.c() {});
    AppMethodBeat.o(233287);
  }
  
  public static boolean b(Context paramContext, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35912);
    if (paramca == null)
    {
      AppMethodBeat.o(35912);
      return false;
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.o.bhj().Qq(paramca.field_imgPath);
    boolean bool = false;
    if (locals != null)
    {
      int i = 0;
      if (ab.Eq(locals.getUser())) {
        i = com.tencent.mm.model.v.Ie(locals.getUser());
      }
      bool = locals.bhy();
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.a(12084, new Object[] { Integer.valueOf(locals.iKP), Integer.valueOf(locals.iFw * 1000), Integer.valueOf(0), Integer.valueOf(2), locals.getUser(), Integer.valueOf(i), com.tencent.mm.modelvideo.s.Qn(locals.bhv()), Long.valueOf(locals.createTime) });
    }
    if (!bool)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
      if (paramBoolean) {
        com.tencent.mm.platformtools.p.I(paramContext, paramContext.getString(2131767075));
      }
      AppMethodBeat.o(35912);
      return false;
    }
    com.tencent.mm.modelvideo.o.bhj();
    String str1 = com.tencent.mm.modelvideo.t.Qw(paramca.field_imgPath);
    String str2 = com.tencent.mm.platformtools.p.L(paramContext, str1);
    if (Util.isNullOrNil(str2))
    {
      if (paramBoolean) {
        com.tencent.mm.platformtools.p.I(paramContext, paramContext.getString(2131767075));
      }
      AppMethodBeat.o(35912);
      return false;
    }
    if (paramBoolean) {
      com.tencent.mm.platformtools.p.I(paramContext, paramContext.getString(2131767076, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(str2) }));
    }
    String str3 = com.tencent.mm.vfs.s.bhK(str2);
    com.tencent.mm.platformtools.v localv = com.tencent.mm.platformtools.v.jNy;
    com.tencent.mm.platformtools.v.bR(str3, br.KB(paramca.fqK));
    AndroidMediaUtil.refreshMediaScannerAsync(str2, paramContext);
    com.tencent.f.h.RTc.b(new b.6(paramca, str1, locals), "MsgVideoExportReport");
    AppMethodBeat.o(35912);
    return true;
  }
  
  public static boolean b(ca paramca, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(35903);
    if ((paramca == null) || (paramg == null))
    {
      AppMethodBeat.o(35903);
      return false;
    }
    boolean bool = q.bcS().a(paramg.localId, paramca.field_msgId, 1);
    AppMethodBeat.o(35903);
    return bool;
  }
  
  public static int c(ca paramca, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(35918);
    if (paramca.field_isSend == 1)
    {
      if (paramg.bcv())
      {
        paramca = com.tencent.mm.av.h.a(paramg);
        if ((paramca != null) && (paramca.localId > 0L) && (paramca.bcu()) && (com.tencent.mm.vfs.s.YS(q.bcR().o(paramca.iXm, "", ""))))
        {
          AppMethodBeat.o(35918);
          return 1;
        }
      }
      AppMethodBeat.o(35918);
      return 0;
    }
    if (paramg.bcu())
    {
      if (paramg.bcv())
      {
        paramca = com.tencent.mm.av.h.a(paramg);
        if ((paramca != null) && (paramca.localId > 0L) && (paramca.bcu()) && (com.tencent.mm.vfs.s.YS(q.bcR().o(paramca.iXm, "", ""))))
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
    AppMethodBeat.i(233288);
    if ((paramContext == null) || (paramca == null))
    {
      AppMethodBeat.o(233288);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, new Callable()new android.support.v4.e.c {}, new android.support.v4.e.c() {});
    AppMethodBeat.o(233288);
  }
  
  public static boolean cn(ca paramca)
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
  
  public static boolean co(ca paramca)
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
  
  public static boolean cp(ca paramca)
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
  
  public static boolean cq(ca paramca)
  {
    AppMethodBeat.i(35902);
    if (paramca == null)
    {
      AppMethodBeat.o(35902);
      return false;
    }
    boolean bool = paramca.cWK();
    AppMethodBeat.o(35902);
    return bool;
  }
  
  public static b cr(ca paramca)
  {
    AppMethodBeat.i(35906);
    b localb = b.Pxc;
    if (paramca == null) {
      localb = b.Pxc;
    }
    if (cp(paramca))
    {
      paramca = b.Pxg;
      AppMethodBeat.o(35906);
      return paramca;
    }
    if (j(paramca))
    {
      paramca = b.Pxd;
      AppMethodBeat.o(35906);
      return paramca;
    }
    if (cs(paramca))
    {
      paramca = b.Pxf;
      AppMethodBeat.o(35906);
      return paramca;
    }
    if (m(paramca))
    {
      paramca = b.Pxe;
      AppMethodBeat.o(35906);
      return paramca;
    }
    if (cn(paramca))
    {
      paramca = b.Pxe;
      AppMethodBeat.o(35906);
      return paramca;
    }
    paramca = b.Pxc;
    AppMethodBeat.o(35906);
    return paramca;
  }
  
  public static boolean cs(ca paramca)
  {
    AppMethodBeat.i(35907);
    if (paramca != null)
    {
      if (paramca.cWK())
      {
        AppMethodBeat.o(35907);
        return false;
      }
      paramca = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
      if ((paramca != null) && (paramca.jsw != null) && ((!Util.isNullOrNil(paramca.jsw.iyZ)) || (paramca.jsw.LxJ > 0) || (!Util.isNullOrNil(paramca.jsw.izc)) || (!Util.isNullOrNil(paramca.jsw.izd)) || (!Util.isNullOrNil(paramca.jsw.izb)) || (!Util.isNullOrNil(paramca.jsw.ize)) || (!Util.isNullOrNil(paramca.jsw.izf)) || (!Util.isNullOrNil(paramca.jsw.izg))))
      {
        AppMethodBeat.o(35907);
        return true;
      }
    }
    AppMethodBeat.o(35907);
    return false;
  }
  
  public static boolean d(Context paramContext, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35913);
    com.tencent.mm.av.g localg = null;
    if (cp(paramca)) {}
    for (Object localObject = l(paramca); (localObject == null) || (((String)localObject).length() == 0); localObject = d.a(paramca, localg))
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + paramca.field_msgId);
      if (paramBoolean) {
        com.tencent.mm.platformtools.p.I(paramContext, paramContext.getString(2131764864));
      }
      AppMethodBeat.o(35913);
      return false;
      if ((paramca == null) || (paramca.field_msgId == 0L))
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          com.tencent.mm.platformtools.p.I(paramContext, paramContext.getString(2131764864));
        }
        AppMethodBeat.o(35913);
        return false;
      }
      localg = d.k(paramca);
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
            com.tencent.mm.platformtools.p.I(paramContext, paramContext.getString(2131764864));
          }
          AppMethodBeat.o(35913);
          return false;
          paramca = Long.valueOf(paramca.field_msgId);
          break;
        }
      }
    }
    String str = com.tencent.mm.platformtools.p.J(paramContext, (String)localObject);
    if (!Util.isNullOrNil(str))
    {
      if (paramBoolean) {
        com.tencent.mm.platformtools.p.I(paramContext, paramContext.getString(2131758218, new Object[] { AndroidMediaUtil.getToastSysCameraPath() }));
      }
      com.tencent.f.h.RTc.b(new b.9((String)localObject, paramca, localg), "MsgImgExportReport");
      paramContext = com.tencent.mm.vfs.s.bhK(str);
      localObject = com.tencent.mm.platformtools.v.jNy;
      com.tencent.mm.platformtools.v.bR(paramContext, br.KB(paramca.fqK));
      AppMethodBeat.o(35913);
      return true;
    }
    if (paramBoolean) {
      com.tencent.mm.platformtools.p.I(paramContext, paramContext.getString(2131764864));
    }
    AppMethodBeat.o(35913);
    return false;
  }
  
  public static void f(final Context paramContext, List<ca> paramList)
  {
    AppMethodBeat.i(233286);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(233286);
      return;
    }
    com.tencent.mm.platformtools.p.a(paramContext, new Callable()new android.support.v4.e.c {}, new android.support.v4.e.c() {});
    AppMethodBeat.o(233286);
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
    Object localObject2 = k.b.HD(paramca.field_content);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35916);
      return null;
    }
    paramca = localObject1;
    if (((k.b)localObject2).dCK != null)
    {
      paramca = localObject1;
      if (((k.b)localObject2).dCK.length() > 0)
      {
        localObject2 = ao.cgO().bdx(((k.b)localObject2).dCK);
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
    if (cs(paramca))
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
  
  public final MultiTouchImageView NQ(int paramInt)
  {
    AppMethodBeat.i(35920);
    Object localObject = super.abm(paramInt);
    if (localObject == null)
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35920);
      return null;
    }
    localObject = ((View)localObject).findViewById(2131302526);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(35920);
      return null;
    }
    localObject = (MultiTouchImageView)localObject;
    AppMethodBeat.o(35920);
    return localObject;
  }
  
  public final WxImageView NR(int paramInt)
  {
    AppMethodBeat.i(35921);
    Object localObject = super.abm(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(35921);
      return null;
    }
    localObject = ((View)localObject).findViewById(2131310633);
    if ((localObject == null) || (((View)localObject).getVisibility() == 8))
    {
      AppMethodBeat.o(35921);
      return null;
    }
    localObject = (WxImageView)localObject;
    AppMethodBeat.o(35921);
    return localObject;
  }
  
  public final void a(ca paramca, com.tencent.mm.av.g paramg, int paramInt, x.a parama)
  {
    AppMethodBeat.i(35934);
    if (paramca == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    if (this.PwH == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    this.PwH.acc().emV = parama;
    long l1 = paramca.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.PwH.emN != l1) && (this.PwH.emP != i); i = 0)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.PwH.emN), Long.valueOf(l1) });
      paramca = this.PwH;
      paramca.emV = x.a.emX;
      paramca.bfK();
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
    if (parama == x.a.emW)
    {
      paramca = d.a(paramca, paramg);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!Util.isNullOrNil(paramca))
      {
        l1 = com.tencent.mm.vfs.s.boW(paramca);
        paramca = d.bmT(paramca);
        l3 = paramca.outWidth;
        l2 = paramca.outHeight;
      }
    }
    paramca = this.PwH;
    paramca.emQ = l1;
    paramca.emS = l2;
    paramca.emR = l3;
    this.PwH.bfK();
    Log.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(Util.ticksToNow(l7)), this.PwH.abV() });
    this.PwH = null;
    AppMethodBeat.o(35934);
  }
  
  public final void amO(int paramInt)
  {
    AppMethodBeat.i(35904);
    Object localObject1 = amt(paramInt);
    Object localObject2 = cr((ca)localObject1);
    switch (2.PwJ[localObject2.ordinal()])
    {
    default: 
      cu((ca)localObject1);
      AppMethodBeat.o(35904);
      return;
    case 2: 
    case 3: 
      ct((ca)localObject1);
      AppMethodBeat.o(35904);
      return;
    }
    String str = l((ca)localObject1);
    localObject2 = new Intent(this.Pwv, MsgRetransmitUI.class);
    ((Intent)localObject2).putExtra("Retr_File_Name", str);
    ((Intent)localObject2).putExtra("Retr_Msg_Id", ((eo)localObject1).field_msgId);
    ((Intent)localObject2).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject2).putExtra("Retr_Msg_content", ((eo)localObject1).field_content);
    ((Intent)localObject2).putExtra("Retr_Compress_Type", 0);
    localObject1 = this.Pwv;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35904);
  }
  
  public final void amP(int paramInt)
  {
    AppMethodBeat.i(35905);
    Object localObject1 = amt(paramInt);
    Object localObject2 = cr((ca)localObject1);
    switch (2.PwJ[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35905);
      return;
      localObject2 = new Intent(this.Pwv, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject2).putExtra("Retr_Msg_Id", ((eo)localObject1).field_msgId);
      localObject1 = this.Pwv;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public final void amQ(int paramInt)
  {
    AppMethodBeat.i(35914);
    Object localObject1 = amt(paramInt);
    if (this.PwE)
    {
      localObject1 = j.cG((ca)localObject1);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "doFavoriteImage mpShareVideoInfo should not be null");
        AppMethodBeat.o(35914);
        return;
      }
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.f.JwB;
      com.tencent.mm.plugin.webview.ui.tools.media.f.b((y)localObject1);
      com.tencent.mm.ui.base.h.cD(this.Pwv, this.Pwv.getString(2131759260));
      AppMethodBeat.o(35914);
      return;
    }
    Object localObject2 = new cz();
    com.tencent.mm.pluginsdk.model.h.d((cz)localObject2, (ca)localObject1);
    ((cz)localObject2).dFZ.activity = this.Pwv;
    ((cz)localObject2).dFZ.dGf = 44;
    EventCenter.instance.publish((IEvent)localObject2);
    if (((cz)localObject2).dGa.ret == 0)
    {
      if (((ca)localObject1).cWL()) {
        com.tencent.mm.ui.chatting.a.a(a.c.PcW, a.d.Pdc, (ca)localObject1, 0);
      }
      com.tencent.mm.modelstat.b.jmd.ac((ca)localObject1);
    }
    AppMethodBeat.o(35914);
  }
  
  public final View amR(int paramInt)
  {
    AppMethodBeat.i(35922);
    View localView3 = super.abm(paramInt);
    if (localView3 == null)
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(35922);
      return null;
    }
    View localView2 = localView3.findViewById(2131309738);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = localView3.findViewById(2131309736);
    }
    if ((localView1 == null) || (localView1.getVisibility() == 8))
    {
      AppMethodBeat.o(35922);
      return null;
    }
    AppMethodBeat.o(35922);
    return localView1;
  }
  
  public final void amS(int paramInt)
  {
    AppMethodBeat.i(35923);
    this.PwB.j(amt(paramInt), paramInt);
    AppMethodBeat.o(35923);
  }
  
  public final void amT(int paramInt)
  {
    AppMethodBeat.i(35924);
    this.PwB.k(amt(paramInt), paramInt);
    AppMethodBeat.o(35924);
  }
  
  public final void amU(int paramInt)
  {
    AppMethodBeat.i(35927);
    this.PwB.amN(paramInt);
    AppMethodBeat.o(35927);
  }
  
  public final void amV(int paramInt)
  {
    AppMethodBeat.i(35930);
    ca localca = amt(paramInt);
    if ((localca == null) || (!j(localca)))
    {
      AppMethodBeat.o(35930);
      return;
    }
    this.PwA.cz(localca);
    AppMethodBeat.o(35930);
  }
  
  public final void amW(int paramInt)
  {
    AppMethodBeat.i(35931);
    this.PwC.anb(paramInt);
    AppMethodBeat.o(35931);
  }
  
  public final ca amt(int paramInt)
  {
    AppMethodBeat.i(35894);
    ca localca = this.Pww.amY(paramInt);
    AppMethodBeat.o(35894);
    return localca;
  }
  
  public final void bH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35919);
    this.PwA.bH(paramInt, paramBoolean);
    AppMethodBeat.o(35919);
  }
  
  public final void ct(ca paramca)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(35908);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.u.g(this.Pwv, null);
      AppMethodBeat.o(35908);
      return;
    }
    if (paramca.cWK())
    {
      paramca = j.cG(paramca);
      if (paramca == null)
      {
        Log.e("MicroMsg.ImageGalleryAdapter", "doRestransmitVideo mpShareVideoInfo should not be null");
        AppMethodBeat.o(35908);
        return;
      }
      if (this.Pwv.JjJ == null) {
        this.Pwv.JjJ = new com.tencent.mm.plugin.webview.ui.tools.media.e();
      }
      this.Pwv.JjJ.iwi = paramca;
      if (this.PwE) {}
      for (;;)
      {
        paramca.iAP = this.Pwv.PyB.pHu;
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.d.Jwx;
        com.tencent.mm.plugin.webview.ui.tools.media.d.a(this.Pwv, paramca.iAo, "", paramca.title, paramca.url, i);
        AppMethodBeat.o(35908);
        return;
        i = 0;
      }
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.u.QN(paramca.field_imgPath);
    if (locals == null)
    {
      Log.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      AppMethodBeat.o(35908);
      return;
    }
    Object localObject = new Intent(this.Pwv, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_length", locals.iFw);
    ((Intent)localObject).putExtra("Retr_File_Name", paramca.field_imgPath);
    ((Intent)localObject).putExtra("Retr_video_isexport", locals.jsr);
    i = j;
    if (cn(paramca)) {
      i = 11;
    }
    ((Intent)localObject).putExtra("Retr_Msg_Type", i);
    ((Intent)localObject).putExtra("Retr_Msg_Id", paramca.field_msgId);
    ((Intent)localObject).putExtra("Retr_From", "gallery");
    paramca = this.Pwv;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramca, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramca.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramca, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35908);
  }
  
  public final void cu(ca paramca)
  {
    AppMethodBeat.i(35910);
    com.tencent.mm.av.g localg = d.k(paramca);
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
    Object localObject = d.a(paramca, localg);
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
    this.PwA.detach();
    this.PwB.detach();
    this.PwC.detach();
    if (this.PwH != null)
    {
      x localx = this.PwH.acc();
      localx.emV = x.a.emX;
      localx.bfK();
    }
    super.detach();
    AppMethodBeat.o(35917);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(35915);
    final ca localca = amt(paramInt);
    View localView;
    final k localk;
    if (paramView == null)
    {
      localView = View.inflate(this.Pwv, 2131495058, null);
      localk = new k(this, localView);
      localView.setTag(localk);
      paramView = cr(localca);
      localk.mPosition = paramInt;
      localk.PAD = paramView;
      k.ai(localk.convertView, 0);
      switch (k.5.PwJ[paramView.ordinal()])
      {
      default: 
        label116:
        k.ai(localk.PBc, 8);
        k.ai(localk.PBd, 8);
        k.ai(localk.PAT, 8);
        k.ai(localk.PAZ, 8);
        k.ai(localk.PAY, 8);
        Log.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (2.PwJ[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.PwG = false;
      AppMethodBeat.o(35915);
      return localView;
      localk = (k)paramView.getTag();
      localView = paramView;
      break;
      k.ai(localk.PAL, 8);
      k.ai(localk.PAF, 8);
      break label116;
      localk.gTe();
      float f = br.I(localca);
      localk.PAM.setScaleX(f);
      localk.PAM.setScaleY(f);
      ((View)localk.PAO).setScaleX(f);
      ((View)localk.PAO).setScaleY(f);
      k.ai(localk.PAL, 0);
      k.ai(localk.PAF, 8);
      if (localk.PAF == null) {
        break label116;
      }
      k.ai(localk.PAH, 8);
      break label116;
      localk.gTd();
      k.ai(localk.PAL, 8);
      k.ai(localk.PAF, 0);
      break label116;
      k.ai(localk.convertView, 8);
      k.ai(localk.PAL, 8);
      k.ai(localk.PAF, 8);
      break label116;
      this.PwA.a(localk, localca, paramInt);
      if (paramInt == a.PwO)
      {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).as(localca);
        continue;
        k.ai(localk.PBc, 0);
        k.ai(localk.PAT, 8);
        k.ai(localk.PAY, 8);
        k.ai(localk.PAZ, 8);
        k.ai(localk.PAP, 8);
        final String str = l(localca);
        try
        {
          paramView = com.tencent.mm.platformtools.u.Sr(str);
          localObject = paramView;
          if (paramView == null)
          {
            localObject = com.tencent.mm.platformtools.u.Sq(q.bcR().R(localca.field_imgPath, true));
            k.ai(localk.PAY, 0);
            new MMHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233284);
                m.a(localca, new m.a()
                {
                  public final void kA(int paramAnonymous2Int1, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(233283);
                    if (paramAnonymous2Int1 == paramAnonymous2Int2)
                    {
                      Log.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(b.10.this.iBF.field_msgId) });
                      k.ai(b.10.this.PwL.PAY, 8);
                    }
                    try
                    {
                      Bitmap localBitmap1 = com.tencent.mm.platformtools.u.Sr(b.10.this.msL);
                      if (localBitmap1 != null)
                      {
                        b.10.this.PwL.PBc.setEnableHorLongBmpMode(false);
                        ForceGpuUtil.decideLayerType(b.10.this.PwL.PBc, localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.10.this.PwL.PBc.cN(localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.10.this.PwL.PBc.setImageBitmap(localBitmap1);
                        b.10.this.PwL.PBc.invalidate();
                      }
                      AppMethodBeat.o(233283);
                      return;
                    }
                    catch (OutOfMemoryError localOutOfMemoryError)
                    {
                      for (;;)
                      {
                        Log.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { b.10.this.msL });
                        Runtime.getRuntime().gc();
                        Runtime.getRuntime().runFinalization();
                        Bitmap localBitmap2 = com.tencent.mm.platformtools.u.Sq(b.10.this.msL);
                      }
                    }
                  }
                });
                AppMethodBeat.o(233284);
              }
            });
          }
          if (localObject == null)
          {
            Log.w("MicroMsg.ImageGalleryAdapter", "get image fail");
            localk.PBc.setVisibility(8);
            localk.gTc().PAZ.setVisibility(0);
            localk.gTc().PBb.setImageResource(2131690954);
            localk.gTc().PBa.setText(this.Pwv.getString(2131761768));
            if (paramInt != a.PwO) {
              continue;
            }
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).as(localca);
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
            paramView = com.tencent.mm.platformtools.u.Sq(str);
            continue;
            localk.PBc.setEnableHorLongBmpMode(false);
            ForceGpuUtil.decideLayerType(localk.PBc, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.PBc.cN(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.PBc.setImageBitmap((Bitmap)localObject);
            localk.PBc.invalidate();
          }
        }
        this.PwB.a(localk, localca, paramInt);
        continue;
        this.PwC.a(localk, localca, paramInt);
      }
    }
  }
  
  public final int firstItemPosForDetermine()
  {
    AppMethodBeat.i(233289);
    int i = a.PwO;
    int j = a.c(this.Pww);
    AppMethodBeat.o(233289);
    return i - j;
  }
  
  public final p gSe()
  {
    AppMethodBeat.i(233285);
    Object localObject1 = gSg();
    if (localObject1 == null)
    {
      Log.w("MicroMsg.ImageGalleryAdapter", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(233285);
      return null;
    }
    Object localObject2 = cr((ca)localObject1);
    Log.i("MicroMsg.ImageGalleryAdapter", "getCurResourceState, type: ".concat(String.valueOf(localObject2)));
    switch (2.PwJ[localObject2.ordinal()])
    {
    default: 
      AppMethodBeat.o(233285);
      return null;
    case 1: 
      localObject1 = this.PwA.gSe();
      AppMethodBeat.o(233285);
      return localObject1;
    case 2: 
      localObject1 = this.PwC.gSe();
      AppMethodBeat.o(233285);
      return localObject1;
    case 3: 
      localObject1 = this.PwB.gSe();
      AppMethodBeat.o(233285);
      return localObject1;
    }
    if (((ca)localObject1).gDB())
    {
      localObject1 = p.PBM;
      AppMethodBeat.o(233285);
      return localObject1;
    }
    localObject2 = k.b.HD(((eo)localObject1).field_content);
    if ((localObject2 != null) && (((k.b)localObject2).dCK != null) && (((k.b)localObject2).dCK.length() > 0))
    {
      localObject2 = ao.cgO().bdx(((k.b)localObject2).dCK);
      int i;
      if ((localObject2 == null) || (!new com.tencent.mm.vfs.o(((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath).exists())) {
        i = 0;
      }
      while (i != 0)
      {
        localObject1 = p.PBO;
        AppMethodBeat.o(233285);
        return localObject1;
        if ((((com.tencent.mm.pluginsdk.model.app.c)localObject2).deQ()) || ((((eo)localObject1).field_isSend == 1) && (((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_isUpload))) {
          i = 1;
        } else {
          i = 0;
        }
      }
      localObject1 = p.PBN;
      AppMethodBeat.o(233285);
      return localObject1;
    }
    AppMethodBeat.o(233285);
    return null;
  }
  
  public final void gSf()
  {
    AppMethodBeat.i(35895);
    this.Pww.gSf();
    AppMethodBeat.o(35895);
  }
  
  public final ca gSg()
  {
    AppMethodBeat.i(35925);
    ca localca = amt(this.Pwv.getCurrentItem());
    AppMethodBeat.o(35925);
    return localca;
  }
  
  public final k gSh()
  {
    AppMethodBeat.i(35926);
    Object localObject2 = this.PwA.amM(this.Pwv.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.PwB.amM(this.Pwv.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.PwC.amM(this.Pwv.getCurrentItem());
    }
    AppMethodBeat.o(35926);
    return localObject2;
  }
  
  public final void gSi()
  {
    AppMethodBeat.i(35929);
    this.PwB.onResume();
    AppMethodBeat.o(35929);
  }
  
  public final int getCount()
  {
    a locala = this.Pww;
    return locala.gAZ - locala.PwP + a.PwO + 1;
  }
  
  public final int getRealCount()
  {
    return this.Pww.gAZ;
  }
  
  public final com.tencent.mm.av.g i(ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(35896);
    paramca = this.PwA.i(paramca, paramBoolean);
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
    Object localObject = gSg();
    if ((localObject == null) || (((eo)localObject).field_msgId != paramca.field_msgId))
    {
      Log.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((eo)localObject).field_msgId), Long.valueOf(paramca.field_msgId) });
      AppMethodBeat.o(35933);
      return;
    }
    long l = paramca.field_msgSvrId;
    if ((this.PwH != null) && ((this.PwH.emN != l) || (this.PwH.emP != paramBoolean)))
    {
      localObject = this.PwH.acc();
      ((x)localObject).emV = x.a.emX;
      ((x)localObject).bfK();
    }
    this.PwH = new x();
    this.PwH.acb();
    localObject = this.PwH;
    ((x)localObject).emN = l;
    ((x)localObject).emO = paramca.field_createTime;
    ((x)localObject).emP = paramBoolean;
    if (ab.Eq(this.gqV)) {
      i = com.tencent.mm.model.v.Ie(this.gqV);
    }
    paramca = this.PwH;
    paramca.emL = paramca.x("ChatName", this.gqV, true);
    paramca.emM = i;
    AppMethodBeat.o(35933);
  }
  
  public final int lastItemPosForDetermine()
  {
    AppMethodBeat.i(233290);
    int i = a.PwO;
    int j = a.c(this.Pww);
    int k = a.d(this.Pww);
    AppMethodBeat.o(233290);
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
    if ((this.PwA != null) && (j(amt(paramInt)))) {
      this.PwA.PxQ.onPageSelected(paramInt);
    }
    AppMethodBeat.o(35893);
  }
  
  public static final class a
  {
    public static int PwO = 100000;
    int PwP;
    protected int PwQ;
    protected int PwR;
    protected int PwS;
    protected long PwT;
    private b PwU;
    public HashMap<Long, com.tencent.mm.av.g> PwV;
    public HashMap<Long, com.tencent.mm.av.g> PwW;
    protected boolean bcY;
    private int fromScene;
    int gAZ;
    private MMHandler handler;
    private int min;
    private String talker;
    private List<ca> uDs;
    
    public a(final long paramLong, String paramString, final b paramb, Boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(35881);
      this.bcY = false;
      this.PwV = new HashMap();
      this.PwW = new HashMap();
      this.handler = new MMHandler();
      this.talker = paramString;
      this.uDs = new LinkedList();
      this.PwU = paramb;
      this.fromScene = paramInt;
      if (paramb.PwE)
      {
        paramString = j.f(paramString, paramb.Pwv);
        this.uDs.add(paramString);
        PwO = 0;
        AppMethodBeat.o(35881);
        return;
      }
      PwO = 100000;
      bg.aVF();
      paramString = com.tencent.mm.model.c.aSQ().Hb(paramLong);
      if (paramString.field_msgId == 0L)
      {
        Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + Util.getStack(), false);
        AppMethodBeat.o(35881);
        return;
      }
      this.uDs.add(paramString);
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
      bg.aAk().postToWorker(new Runnable()
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
                if (b.a.1.this.PwZ.PwD != null) {
                  b.a.1.this.PwZ.PwD.tf();
                }
                AppMethodBeat.o(35878);
              }
            }, 0L);
          }
          AppMethodBeat.o(35879);
        }
      });
      paramb.Pwv.Pzw = new ImageGalleryUI.b()
      {
        public final void t(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35880);
          Log.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(paramAnonymousBoolean)));
          if (!paramAnonymousBoolean.booleanValue())
          {
            b.a.a(b.a.this);
            if (paramb.PwD != null) {
              paramb.PwD.tf();
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
      if (b.tca) {
        bg.aVF();
      }
      for (List localList = com.tencent.mm.model.c.aSR().b(this.talker, b.ppv, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.aSQ().f(this.talker, paramLong, paramBoolean))
      {
        Log.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(paramBoolean)));
        AppMethodBeat.o(35885);
        return;
        bg.aVF();
      }
      Log.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
      paramLong = System.currentTimeMillis();
      js(localList);
      Log.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
      if (paramBoolean)
      {
        this.uDs.addAll(localList);
        AppMethodBeat.o(35885);
        return;
      }
      this.uDs.addAll(0, localList);
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
    
    private void js(List<ca> paramList)
    {
      AppMethodBeat.i(35882);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (b.j((ca)paramList.get(i)))
        {
          localArrayList1.add(Long.valueOf(((ca)paramList.get(i)).field_msgSvrId));
          if (((ca)paramList.get(i)).field_isSend == 1) {
            localArrayList2.add(Long.valueOf(((ca)paramList.get(i)).field_msgId));
          }
        }
        i += 1;
      }
      this.PwV.putAll(q.bcR().a((Long[])localArrayList1.toArray(new Long[0])));
      this.PwW.putAll(q.bcR().b((Long[])localArrayList2.toArray(new Long[0])));
      AppMethodBeat.o(35882);
    }
    
    public final void a(long paramLong, com.tencent.mm.av.g paramg, boolean paramBoolean)
    {
      AppMethodBeat.i(35883);
      if (paramBoolean)
      {
        this.PwV.put(Long.valueOf(paramLong), paramg);
        AppMethodBeat.o(35883);
        return;
      }
      this.PwW.put(Long.valueOf(paramLong), paramg);
      AppMethodBeat.o(35883);
    }
    
    public final int amX(int paramInt)
    {
      return paramInt - PwO + this.PwP;
    }
    
    public final ca amY(int paramInt)
    {
      AppMethodBeat.i(35884);
      paramInt = amX(paramInt);
      int i = this.min + this.uDs.size() - 1;
      if ((paramInt < this.min) || (paramInt > i))
      {
        Log.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
        AppMethodBeat.o(35884);
        return null;
      }
      Log.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(paramInt)));
      if (paramInt == this.min)
      {
        localca = (ca)this.uDs.get(0);
        if (this.bcY) {
          R(localca.field_msgId, false);
        }
        AppMethodBeat.o(35884);
        return localca;
      }
      if ((paramInt == i) && (i < this.gAZ - 1))
      {
        localca = (ca)this.uDs.get(this.uDs.size() - 1);
        if (this.bcY) {
          R(localca.field_msgId, true);
        }
        AppMethodBeat.o(35884);
        return localca;
      }
      ca localca = (ca)this.uDs.get(paramInt - this.min);
      AppMethodBeat.o(35884);
      return localca;
    }
    
    public final void gSf()
    {
      this.bcY = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(35886);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AutoList, Size = " + this.uDs.size());
      ((StringBuilder)localObject).append("; Content = {");
      Iterator localIterator = this.uDs.iterator();
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
      Pxc = new b("unkown", 0);
      Pxd = new b("image", 1);
      Pxe = new b("video", 2);
      Pxf = new b("sight", 3);
      Pxg = new b("appimage", 4);
      Pxh = new b[] { Pxc, Pxd, Pxe, Pxf, Pxg };
      AppMethodBeat.o(35891);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void tf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b
 * JD-Core Version:    0.7.0.1
 */