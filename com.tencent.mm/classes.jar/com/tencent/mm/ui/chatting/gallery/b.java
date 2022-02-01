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
import com.tencent.mm.av.l;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.b.a.g.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.by;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
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
  public static long nxq = -1L;
  public static boolean qKh = false;
  public ImageGalleryUI HZV;
  protected a HZW;
  private String HZX;
  boolean HZY;
  public boolean HZZ;
  public d Iaa;
  public j Iab;
  public i Iac;
  public c Iad;
  public boolean Iae;
  boolean Iaf;
  protected boolean Iag;
  private com.tencent.mm.g.b.a.g Iah;
  private int fromScene;
  private String frx;
  private ArrayList<bo> qSv;
  
  public b(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35892);
    this.HZY = true;
    this.HZZ = false;
    this.Iae = false;
    this.frx = null;
    this.Iag = true;
    this.qSv = new ArrayList();
    this.Iah = null;
    this.Iae = paramImageGalleryUI.getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    String str;
    if (!this.Iae)
    {
      str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + bs.eWi();
      if ((paramLong1 <= 0L) || (paramString1 == null) || (paramString1.length() <= 0)) {
        break label248;
      }
    }
    label248:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      this.HZV = paramImageGalleryUI;
      qKh = paramBoolean1;
      nxq = paramLong2;
      this.frx = paramString1;
      this.fromScene = paramInt;
      this.HZW = new a(paramLong1, paramString1, this, paramBoolean, paramInt);
      this.HZZ = paramBoolean2;
      this.HZX = paramString2;
      this.Iaa = new d(this);
      this.Iab = new j(this);
      this.Iac = new i(this);
      AppMethodBeat.o(35892);
      return;
    }
  }
  
  public static void a(Context paramContext, final bo parambo)
  {
    AppMethodBeat.i(196546);
    if ((paramContext == null) || (parambo == null))
    {
      AppMethodBeat.o(196546);
      return;
    }
    parambo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196538);
        b.b(this.val$context, parambo, this.Iaj);
        if (this.Iak != null) {
          this.Iak.run();
        }
        AppMethodBeat.o(196538);
      }
    };
    b.4 local4 = new b.4(paramContext);
    if (PermissionHelper.aGv("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      parambo.run();
      AppMethodBeat.o(196546);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.platformtools.p.a(paramContext, parambo, local4);
      AppMethodBeat.o(196546);
      return;
    }
    local4.run();
    AppMethodBeat.o(196546);
  }
  
  public static boolean b(Context paramContext, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(35912);
    if (parambo == null)
    {
      AppMethodBeat.o(35912);
      return false;
    }
    Object localObject = com.tencent.mm.modelvideo.o.aJy().DT(parambo.field_imgPath);
    boolean bool = false;
    if (localObject != null)
    {
      int i = 0;
      if (w.sQ(((s)localObject).getUser())) {
        i = com.tencent.mm.model.q.wb(((s)localObject).getUser());
      }
      bool = ((s)localObject).aJN();
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.h.wUl.f(12084, new Object[] { Integer.valueOf(((s)localObject).hux), Integer.valueOf(((s)localObject).hpy * 1000), Integer.valueOf(0), Integer.valueOf(2), ((s)localObject).getUser(), Integer.valueOf(i), s.DR(((s)localObject).aJK()), Long.valueOf(((s)localObject).createTime) });
    }
    if (!bool)
    {
      ac.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131764682), 1).show();
      }
      AppMethodBeat.o(35912);
      return false;
    }
    com.tencent.mm.modelvideo.o.aJy();
    localObject = com.tencent.mm.modelvideo.u.Ek(com.tencent.mm.modelvideo.t.DV(parambo.field_imgPath));
    if (bs.isNullOrNil((String)localObject))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131764682), 1).show();
      }
      AppMethodBeat.o(35912);
      return false;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aLU((String)localObject) }), 1).show();
    }
    String str = com.tencent.mm.vfs.i.aKe((String)localObject);
    v localv = v.iuG;
    v.bF(str, bk.yu(parambo.eul));
    com.tencent.mm.pluginsdk.ui.tools.q.k((String)localObject, paramContext);
    AppMethodBeat.o(35912);
    return true;
  }
  
  public static boolean b(bo parambo, com.tencent.mm.av.e parame)
  {
    AppMethodBeat.i(35903);
    if ((parambo == null) || (parame == null))
    {
      AppMethodBeat.o(35903);
      return false;
    }
    boolean bool = com.tencent.mm.av.o.aFy().a(parame.dcd, parambo.field_msgId, 1);
    AppMethodBeat.o(35903);
    return bool;
  }
  
  public static boolean bR(bo parambo)
  {
    AppMethodBeat.i(35899);
    if (parambo == null)
    {
      AppMethodBeat.o(35899);
      return false;
    }
    if (parambo.getType() == 62)
    {
      AppMethodBeat.o(35899);
      return true;
    }
    AppMethodBeat.o(35899);
    return false;
  }
  
  public static boolean bS(bo parambo)
  {
    AppMethodBeat.i(35900);
    if (parambo == null)
    {
      AppMethodBeat.o(35900);
      return false;
    }
    if (parambo.getType() == 49)
    {
      AppMethodBeat.o(35900);
      return true;
    }
    AppMethodBeat.o(35900);
    return false;
  }
  
  public static boolean bT(bo parambo)
  {
    AppMethodBeat.i(35901);
    if (parambo == null)
    {
      AppMethodBeat.o(35901);
      return false;
    }
    if (parambo.getType() == 268435505)
    {
      AppMethodBeat.o(35901);
      return true;
    }
    AppMethodBeat.o(35901);
    return false;
  }
  
  public static boolean bU(bo parambo)
  {
    AppMethodBeat.i(35902);
    if (parambo == null)
    {
      AppMethodBeat.o(35902);
      return false;
    }
    boolean bool = parambo.cru();
    AppMethodBeat.o(35902);
    return bool;
  }
  
  public static b bV(bo parambo)
  {
    AppMethodBeat.i(35906);
    b localb = b.IaD;
    if (parambo == null) {
      localb = b.IaD;
    }
    if (bT(parambo))
    {
      parambo = b.IaH;
      AppMethodBeat.o(35906);
      return parambo;
    }
    if (j(parambo))
    {
      parambo = b.IaE;
      AppMethodBeat.o(35906);
      return parambo;
    }
    if (bW(parambo))
    {
      parambo = b.IaG;
      AppMethodBeat.o(35906);
      return parambo;
    }
    if (m(parambo))
    {
      parambo = b.IaF;
      AppMethodBeat.o(35906);
      return parambo;
    }
    if (bR(parambo))
    {
      parambo = b.IaF;
      AppMethodBeat.o(35906);
      return parambo;
    }
    parambo = b.IaD;
    AppMethodBeat.o(35906);
    return parambo;
  }
  
  public static boolean bW(bo parambo)
  {
    AppMethodBeat.i(35907);
    if (parambo != null)
    {
      if (parambo.cru())
      {
        AppMethodBeat.o(35907);
        return false;
      }
      parambo = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
      if ((parambo != null) && (parambo.iaR != null) && ((!bs.isNullOrNil(parambo.iaR.hjV)) || (parambo.iaR.EBs > 0) || (!bs.isNullOrNil(parambo.iaR.hjY)) || (!bs.isNullOrNil(parambo.iaR.hjZ)) || (!bs.isNullOrNil(parambo.iaR.hjX)) || (!bs.isNullOrNil(parambo.iaR.hka)) || (!bs.isNullOrNil(parambo.iaR.hkb)) || (!bs.isNullOrNil(parambo.iaR.hkc))))
      {
        AppMethodBeat.o(35907);
        return true;
      }
    }
    AppMethodBeat.o(35907);
    return false;
  }
  
  public static int c(bo parambo, com.tencent.mm.av.e parame)
  {
    AppMethodBeat.i(35918);
    if (parambo.field_isSend == 1)
    {
      if (parame.aFa())
      {
        parambo = com.tencent.mm.av.f.a(parame);
        if ((parambo != null) && (parambo.dcd > 0L) && (parambo.aEZ()) && (com.tencent.mm.vfs.i.eA(com.tencent.mm.av.o.aFx().p(parambo.hGM, "", ""))))
        {
          AppMethodBeat.o(35918);
          return 1;
        }
      }
      AppMethodBeat.o(35918);
      return 0;
    }
    if (parame.aEZ())
    {
      if (parame.aFa())
      {
        parambo = com.tencent.mm.av.f.a(parame);
        if ((parambo != null) && (parambo.dcd > 0L) && (parambo.aEZ()) && (com.tencent.mm.vfs.i.eA(com.tencent.mm.av.o.aFx().p(parambo.hGM, "", ""))))
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
  
  public static void c(Context paramContext, final bo parambo, final boolean paramBoolean)
  {
    AppMethodBeat.i(196547);
    if ((paramContext == null) || (parambo == null))
    {
      AppMethodBeat.o(196547);
      return;
    }
    parambo = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196540);
        b.d(this.val$context, parambo, paramBoolean);
        if (this.Iak != null) {
          this.Iak.run();
        }
        AppMethodBeat.o(196540);
      }
    };
    b.6 local6 = new b.6(paramBoolean, paramContext);
    if (PermissionHelper.aGv("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      parambo.run();
      AppMethodBeat.o(196547);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.platformtools.p.a(paramContext, parambo, local6);
      AppMethodBeat.o(196547);
      return;
    }
    local6.run();
    AppMethodBeat.o(196547);
  }
  
  public static boolean d(Context paramContext, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(35913);
    if (bT(parambo)) {}
    for (Object localObject = l(parambo); (localObject == null) || (((String)localObject).length() == 0); localObject = d.a(parambo, (com.tencent.mm.av.e)localObject))
    {
      ac.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambo.field_msgId);
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
      }
      AppMethodBeat.o(35913);
      return false;
      if ((parambo == null) || (parambo.field_msgId == 0L))
      {
        ac.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
        }
        AppMethodBeat.o(35913);
        return false;
      }
      localObject = d.k(parambo);
      if ((localObject == null) || (((com.tencent.mm.av.e)localObject).dcd == 0L))
      {
        StringBuilder localStringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (parambo == null)
        {
          parambo = "null";
          localStringBuilder = localStringBuilder.append(parambo).append(", imgLocalId = ");
          if (localObject != null) {
            break label244;
          }
        }
        label244:
        for (parambo = "null";; parambo = Long.valueOf(((com.tencent.mm.av.e)localObject).dcd))
        {
          ac.e("MicroMsg.ImageGalleryAdapter", parambo);
          if (paramBoolean) {
            Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
          }
          AppMethodBeat.o(35913);
          return false;
          parambo = Long.valueOf(parambo.field_msgId);
          break;
        }
      }
    }
    localObject = com.tencent.mm.platformtools.p.I(paramContext, (String)localObject);
    if (!bs.isNullOrNil((String)localObject))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.eQn() }), 1).show();
      }
      paramContext = com.tencent.mm.vfs.i.aKe((String)localObject);
      localObject = v.iuG;
      v.bF(paramContext, bk.yu(parambo.eul));
      AppMethodBeat.o(35913);
      return true;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
    }
    AppMethodBeat.o(35913);
    return false;
  }
  
  public static void f(Context paramContext, List<bo> paramList)
  {
    AppMethodBeat.i(196545);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(196545);
      return;
    }
    paramList = new b.1(paramList, paramContext);
    b.2 local2 = new b.2(paramContext);
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.platformtools.p.a(paramContext, paramList, local2);
      AppMethodBeat.o(196545);
      return;
    }
    local2.run();
    AppMethodBeat.o(196545);
  }
  
  public static boolean j(bo parambo)
  {
    AppMethodBeat.i(35897);
    if (parambo == null)
    {
      AppMethodBeat.o(35897);
      return false;
    }
    if ((parambo.getType() == 3) || (parambo.getType() == 39) || (parambo.getType() == 13))
    {
      AppMethodBeat.o(35897);
      return true;
    }
    AppMethodBeat.o(35897);
    return false;
  }
  
  public static String l(bo parambo)
  {
    Object localObject1 = null;
    AppMethodBeat.i(35916);
    Object localObject2 = k.b.vA(parambo.field_content);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35916);
      return null;
    }
    parambo = localObject1;
    if (((k.b)localObject2).cZa != null)
    {
      parambo = localObject1;
      if (((k.b)localObject2).cZa.length() > 0)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.ap.bEO().aGd(((k.b)localObject2).cZa);
        parambo = localObject1;
        if (localObject2 != null) {
          parambo = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        }
      }
    }
    AppMethodBeat.o(35916);
    return parambo;
  }
  
  public static boolean m(bo parambo)
  {
    AppMethodBeat.i(35898);
    if (parambo == null)
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if (bW(parambo))
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if ((parambo.getType() == 43) || (parambo.getType() == 486539313) || (parambo.getType() == 44) || (parambo.getType() == 62))
    {
      AppMethodBeat.o(35898);
      return true;
    }
    AppMethodBeat.o(35898);
    return false;
  }
  
  private void o(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(35909);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
      AppMethodBeat.o(35909);
      return;
    }
    Object localObject;
    if (bs.isNullOrNil(this.HZX))
    {
      ac.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      localObject = new Intent(this.HZV, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Id", paramLong);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", paramInt);
      paramString = this.HZV;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35909);
      return;
    }
    ac.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.HZX });
    if (!bs.isNullOrNil(paramString))
    {
      paramString = new l(com.tencent.mm.model.u.axw(), this.HZX, paramString, paramInt);
      az.agi().a(paramString, 0);
      by.azu().d(by.hpK, null);
    }
    if (this.HZY)
    {
      localObject = new Intent(this.HZV, ChattingUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.HZX);
      paramString = this.HZV;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.HZX });
      AppMethodBeat.o(35909);
      return;
      com.tencent.mm.ui.base.h.cg(this.HZV, this.HZV.getString(2131755881));
    }
  }
  
  public final MultiTouchImageView Gb(int paramInt)
  {
    AppMethodBeat.i(35920);
    Object localObject = super.QZ(paramInt);
    if (localObject == null)
    {
      ac.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
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
  
  public final WxImageView Gc(int paramInt)
  {
    AppMethodBeat.i(35921);
    Object localObject = super.QZ(paramInt);
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
  
  public final void a(bo parambo, com.tencent.mm.av.e parame, int paramInt, g.a parama)
  {
    AppMethodBeat.i(35934);
    if (parambo == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    if (this.Iah == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    this.Iah.PW().dEO = parama;
    long l1 = parambo.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.Iah.dEG != l1) && (this.Iah.dEI != i); i = 0)
    {
      ac.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.Iah.dEG), Long.valueOf(l1) });
      parambo = this.Iah;
      parambo.dEO = g.a.dEQ;
      parambo.aHZ();
      AppMethodBeat.o(35934);
      return;
    }
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0L;
    long l7 = bs.Gn();
    long l3 = l6;
    long l2 = l5;
    l1 = l4;
    if (parama == g.a.dEP)
    {
      parambo = d.a(parambo, parame);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!bs.isNullOrNil(parambo))
      {
        l1 = com.tencent.mm.vfs.i.aSp(parambo);
        parambo = d.aQu(parambo);
        l3 = parambo.outWidth;
        l2 = parambo.outHeight;
      }
    }
    parambo = this.Iah;
    parambo.dEJ = l1;
    parambo.dEL = l2;
    parambo.dEK = l3;
    this.Iah.aHZ();
    ac.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(bs.aO(l7)), this.Iah.PR() });
    this.Iah = null;
    AppMethodBeat.o(35934);
  }
  
  public final void aZ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35919);
    this.Iaa.aZ(paramInt, paramBoolean);
    AppMethodBeat.o(35919);
  }
  
  public final bo aaP(int paramInt)
  {
    AppMethodBeat.i(35894);
    bo localbo = this.HZW.abu(paramInt);
    AppMethodBeat.o(35894);
    return localbo;
  }
  
  public final void abk(int paramInt)
  {
    AppMethodBeat.i(35904);
    Object localObject1 = aaP(paramInt);
    Object localObject2 = bV((bo)localObject1);
    switch (8.Iao[localObject2.ordinal()])
    {
    default: 
      bY((bo)localObject1);
      AppMethodBeat.o(35904);
      return;
    case 1: 
    case 2: 
      bX((bo)localObject1);
      AppMethodBeat.o(35904);
      return;
    }
    String str = l((bo)localObject1);
    localObject2 = new Intent(this.HZV, MsgRetransmitUI.class);
    ((Intent)localObject2).putExtra("Retr_File_Name", str);
    ((Intent)localObject2).putExtra("Retr_Msg_Id", ((dy)localObject1).field_msgId);
    ((Intent)localObject2).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject2).putExtra("Retr_Msg_content", ((dy)localObject1).field_content);
    ((Intent)localObject2).putExtra("Retr_Compress_Type", 0);
    localObject1 = this.HZV;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35904);
  }
  
  public final void abl(int paramInt)
  {
    AppMethodBeat.i(35905);
    Object localObject1 = aaP(paramInt);
    Object localObject2 = bV((bo)localObject1);
    switch (8.Iao[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35905);
      return;
      localObject2 = new Intent(this.HZV, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject2).putExtra("Retr_Msg_Id", ((dy)localObject1).field_msgId);
      localObject1 = this.HZV;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public final void abm(int paramInt)
  {
    AppMethodBeat.i(35914);
    Object localObject1 = aaP(paramInt);
    if (this.Iae)
    {
      localObject1 = j.cl((bo)localObject1);
      if (localObject1 == null)
      {
        ac.e("MicroMsg.ImageGalleryAdapter", "doFavoriteImage mpShareVideoInfo should not be null");
        AppMethodBeat.o(35914);
        return;
      }
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.e.CLc;
      com.tencent.mm.plugin.webview.ui.tools.media.e.b((y)localObject1);
      com.tencent.mm.ui.base.h.cg(this.HZV, this.HZV.getString(2131758936));
      AppMethodBeat.o(35914);
      return;
    }
    Object localObject2 = new cs();
    com.tencent.mm.pluginsdk.model.g.e((cs)localObject2, (bo)localObject1);
    ((cs)localObject2).dck.activity = this.HZV;
    ((cs)localObject2).dck.dcq = 44;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject2);
    if (((cs)localObject2).dcl.ret == 0)
    {
      if (((bo)localObject1).crv()) {
        com.tencent.mm.ui.chatting.a.a(a.c.HJl, a.d.HJr, (bo)localObject1, 0);
      }
      com.tencent.mm.modelstat.b.hUE.P((bo)localObject1);
    }
    AppMethodBeat.o(35914);
  }
  
  public final View abn(int paramInt)
  {
    AppMethodBeat.i(35922);
    View localView3 = super.QZ(paramInt);
    if (localView3 == null)
    {
      ac.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
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
  
  public final void abo(int paramInt)
  {
    AppMethodBeat.i(35923);
    this.Iab.j(aaP(paramInt), paramInt);
    AppMethodBeat.o(35923);
  }
  
  public final void abp(int paramInt)
  {
    AppMethodBeat.i(35924);
    this.Iab.k(aaP(paramInt), paramInt);
    AppMethodBeat.o(35924);
  }
  
  public final void abq(int paramInt)
  {
    AppMethodBeat.i(35927);
    this.Iab.abj(paramInt);
    AppMethodBeat.o(35927);
  }
  
  public final void abr(int paramInt)
  {
    AppMethodBeat.i(35930);
    bo localbo = aaP(paramInt);
    if ((localbo == null) || (!j(localbo)))
    {
      AppMethodBeat.o(35930);
      return;
    }
    this.Iaa.cd(localbo);
    AppMethodBeat.o(35930);
  }
  
  public final void abs(int paramInt)
  {
    AppMethodBeat.i(35931);
    this.Iac.aby(paramInt);
    AppMethodBeat.o(35931);
  }
  
  public final void bX(bo parambo)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(35908);
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.HZV, null);
      AppMethodBeat.o(35908);
      return;
    }
    if (parambo.cru())
    {
      parambo = j.cl(parambo);
      if (parambo == null)
      {
        ac.e("MicroMsg.ImageGalleryAdapter", "doRestransmitVideo mpShareVideoInfo should not be null");
        AppMethodBeat.o(35908);
        return;
      }
      if (this.HZV.CAG == null) {
        this.HZV.CAG = new com.tencent.mm.plugin.webview.ui.tools.media.d();
      }
      this.HZV.CAG.hhf = parambo;
      if (this.Iae) {}
      for (;;)
      {
        parambo.hlE = this.HZV.Ica.nLA;
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.c.CKY;
        com.tencent.mm.plugin.webview.ui.tools.media.c.a(this.HZV, parambo.hld, "", parambo.title, parambo.url, i);
        AppMethodBeat.o(35908);
        return;
        i = 0;
      }
    }
    s locals = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
    if (locals == null)
    {
      ac.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      AppMethodBeat.o(35908);
      return;
    }
    Object localObject = new Intent(this.HZV, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_length", locals.hpy);
    ((Intent)localObject).putExtra("Retr_File_Name", parambo.field_imgPath);
    ((Intent)localObject).putExtra("Retr_video_isexport", locals.iaM);
    i = j;
    if (bR(parambo)) {
      i = 11;
    }
    ((Intent)localObject).putExtra("Retr_Msg_Type", i);
    ((Intent)localObject).putExtra("Retr_Msg_Id", parambo.field_msgId);
    ((Intent)localObject).putExtra("Retr_From", "gallery");
    parambo = this.HZV;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(parambo, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parambo.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(parambo, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35908);
  }
  
  public final void bY(bo parambo)
  {
    AppMethodBeat.i(35910);
    com.tencent.mm.av.e locale = d.k(parambo);
    if ((parambo == null) || (parambo.field_msgId == 0L) || (locale == null) || (locale.dcd == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (parambo == null)
      {
        parambo = "null";
        localObject = ((StringBuilder)localObject).append(parambo).append(", imgLocalId = ");
        if (locale != null) {
          break label108;
        }
      }
      label108:
      for (parambo = "null";; parambo = Long.valueOf(locale.dcd))
      {
        ac.e("MicroMsg.ImageGalleryAdapter", parambo);
        AppMethodBeat.o(35910);
        return;
        parambo = Long.valueOf(parambo.field_msgId);
        break;
      }
    }
    Object localObject = d.a(parambo, locale);
    if (bs.isNullOrNil((String)localObject))
    {
      ac.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambo.field_msgId + ", imgLocalId = " + locale.dcd);
      AppMethodBeat.o(35910);
      return;
    }
    o((String)localObject, c(parambo, locale), parambo.field_msgId);
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
    this.Iaa.detach();
    this.Iab.detach();
    this.Iac.detach();
    if (this.Iah != null)
    {
      com.tencent.mm.g.b.a.g localg = this.Iah.PW();
      localg.dEO = g.a.dEQ;
      localg.aHZ();
    }
    super.detach();
    AppMethodBeat.o(35917);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(35915);
    final bo localbo = aaP(paramInt);
    View localView;
    final k localk;
    if (paramView == null)
    {
      localView = View.inflate(this.HZV, 2131494469, null);
      localk = new k(this, localView);
      localView.setTag(localk);
      paramView = bV(localbo);
      localk.mPosition = paramInt;
      localk.Idz = paramView;
      k.aF(localk.sSS, 0);
      switch (k.5.Iao[paramView.ordinal()])
      {
      default: 
        label108:
        k.aF(localk.IdY, 8);
        k.aF(localk.IdZ, 8);
        k.aF(localk.IdP, 8);
        k.aF(localk.IdV, 8);
        k.aF(localk.IdU, 8);
        ac.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (8.Iao[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.Iag = false;
      AppMethodBeat.o(35915);
      return localView;
      localk = (k)paramView.getTag();
      localView = paramView;
      break;
      k.aF(localk.IdH, 8);
      k.aF(localk.IdB, 8);
      break label108;
      localk.fpS();
      k.aF(localk.IdH, 0);
      k.aF(localk.IdB, 8);
      if (localk.IdB == null) {
        break label108;
      }
      k.aF(localk.IdD, 8);
      break label108;
      localk.fpR();
      k.aF(localk.IdH, 8);
      k.aF(localk.IdB, 0);
      break label108;
      k.aF(localk.sSS, 8);
      k.aF(localk.IdH, 8);
      k.aF(localk.IdB, 8);
      break label108;
      this.Iaa.a(localk, localbo, paramInt);
      if (paramInt == 100000)
      {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).af(localbo);
        continue;
        k.aF(localk.IdY, 0);
        k.aF(localk.IdP, 8);
        k.aF(localk.IdU, 8);
        k.aF(localk.IdV, 8);
        k.aF(localk.IdL, 8);
        final String str = l(localbo);
        try
        {
          paramView = com.tencent.mm.platformtools.u.FF(str);
          localObject = paramView;
          if (paramView == null)
          {
            localObject = com.tencent.mm.platformtools.u.FE(com.tencent.mm.av.o.aFx().R(localbo.field_imgPath, true));
            k.aF(localk.IdU, 0);
            new ao().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(196543);
                m.a(localbo, new m.a()
                {
                  public final void iY(int paramAnonymous2Int1, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(196542);
                    if (paramAnonymous2Int1 == paramAnonymous2Int2)
                    {
                      ac.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(b.7.this.hmq.field_msgId) });
                      k.aF(b.7.this.Ial.IdU, 8);
                    }
                    try
                    {
                      Bitmap localBitmap1 = com.tencent.mm.platformtools.u.FF(b.7.this.kMp);
                      if (localBitmap1 != null)
                      {
                        b.7.this.Ial.IdY.setEnableHorLongBmpMode(false);
                        com.tencent.mm.sdk.platformtools.p.z(b.7.this.Ial.IdY, localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.7.this.Ial.IdY.cF(localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.7.this.Ial.IdY.setImageBitmap(localBitmap1);
                        b.7.this.Ial.IdY.invalidate();
                      }
                      AppMethodBeat.o(196542);
                      return;
                    }
                    catch (OutOfMemoryError localOutOfMemoryError)
                    {
                      for (;;)
                      {
                        ac.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { b.7.this.kMp });
                        Runtime.getRuntime().gc();
                        Runtime.getRuntime().runFinalization();
                        Bitmap localBitmap2 = com.tencent.mm.platformtools.u.FE(b.7.this.kMp);
                      }
                    }
                  }
                });
                AppMethodBeat.o(196543);
              }
            });
          }
          if (localObject == null)
          {
            ac.w("MicroMsg.ImageGalleryAdapter", "get image fail");
            localk.IdY.setVisibility(8);
            localk.fpQ().IdV.setVisibility(0);
            localk.fpQ().IdX.setImageResource(2131690686);
            localk.fpQ().IdW.setText(this.HZV.getString(2131760324));
            if (paramInt != 100000) {
              continue;
            }
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).af(localbo);
          }
        }
        catch (OutOfMemoryError paramView)
        {
          for (;;)
          {
            Object localObject;
            ac.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { str });
            Runtime.getRuntime().gc();
            Runtime.getRuntime().runFinalization();
            paramView = com.tencent.mm.platformtools.u.FE(str);
            continue;
            localk.IdY.setEnableHorLongBmpMode(false);
            com.tencent.mm.sdk.platformtools.p.z(localk.IdY, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.IdY.cF(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.IdY.setImageBitmap((Bitmap)localObject);
            localk.IdY.invalidate();
          }
        }
        this.Iab.a(localk, localbo, paramInt);
        continue;
        this.Iac.a(localk, localbo, paramInt);
      }
    }
  }
  
  public final int firstItemPosForDetermine()
  {
    return 100000 - this.HZW.Iaq;
  }
  
  public final void fpf()
  {
    AppMethodBeat.i(35895);
    this.HZW.fpf();
    AppMethodBeat.o(35895);
  }
  
  public final bo fpg()
  {
    AppMethodBeat.i(35925);
    bo localbo = aaP(this.HZV.getCurrentItem());
    AppMethodBeat.o(35925);
    return localbo;
  }
  
  public final k fph()
  {
    AppMethodBeat.i(35926);
    Object localObject2 = this.Iaa.abi(this.HZV.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.Iab.abi(this.HZV.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.Iac.abi(this.HZV.getCurrentItem());
    }
    AppMethodBeat.o(35926);
    return localObject2;
  }
  
  public final void fpi()
  {
    AppMethodBeat.i(35929);
    this.Iab.onResume();
    AppMethodBeat.o(35929);
  }
  
  public final com.tencent.mm.av.e g(bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(35896);
    parambo = this.Iaa.g(parambo, paramBoolean);
    AppMethodBeat.o(35896);
    return parambo;
  }
  
  public final int getCount()
  {
    a locala = this.HZW;
    return locala.fAw - locala.Iaq + 100000 + 1;
  }
  
  public final int getRealCount()
  {
    return this.HZW.fAw;
  }
  
  public final void h(bo parambo, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(35933);
    if (parambo == null)
    {
      AppMethodBeat.o(35933);
      return;
    }
    Object localObject = fpg();
    if ((localObject == null) || (((dy)localObject).field_msgId != parambo.field_msgId))
    {
      ac.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((dy)localObject).field_msgId), Long.valueOf(parambo.field_msgId) });
      AppMethodBeat.o(35933);
      return;
    }
    long l = parambo.field_msgSvrId;
    if ((this.Iah != null) && ((this.Iah.dEG != l) || (this.Iah.dEI != paramBoolean)))
    {
      localObject = this.Iah.PW();
      ((com.tencent.mm.g.b.a.g)localObject).dEO = g.a.dEQ;
      ((com.tencent.mm.g.b.a.g)localObject).aHZ();
    }
    this.Iah = new com.tencent.mm.g.b.a.g();
    this.Iah.PV();
    localObject = this.Iah;
    ((com.tencent.mm.g.b.a.g)localObject).dEG = l;
    ((com.tencent.mm.g.b.a.g)localObject).dEH = parambo.field_createTime;
    ((com.tencent.mm.g.b.a.g)localObject).dEI = paramBoolean;
    if (w.sQ(this.frx)) {
      i = com.tencent.mm.model.q.wb(this.frx);
    }
    parambo = this.Iah;
    parambo.dEE = parambo.t("ChatName", this.frx, true);
    parambo.dEF = i;
    AppMethodBeat.o(35933);
  }
  
  public final int lastItemPosForDetermine()
  {
    return 100000 - this.HZW.Iaq + this.HZW.fAw - 1;
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
    if ((this.Iaa != null) && (j(aaP(paramInt)))) {
      this.Iaa.Ibp.onPageSelected(paramInt);
    }
    AppMethodBeat.o(35893);
  }
  
  public static final class a
  {
    private List<bo> Iap;
    int Iaq;
    protected int Iar;
    protected int Ias;
    protected int Iat;
    protected long Iau;
    private b Iav;
    public HashMap<Long, com.tencent.mm.av.e> Iaw;
    public HashMap<Long, com.tencent.mm.av.e> Iax;
    protected boolean aSG;
    int fAw;
    private int fromScene;
    ao handler;
    private int min;
    private String talker;
    
    public a(final long paramLong, String paramString, final b paramb, Boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(35881);
      this.aSG = false;
      this.Iaw = new HashMap();
      this.Iax = new HashMap();
      this.handler = new ao();
      this.talker = paramString;
      this.Iap = new LinkedList();
      this.Iav = paramb;
      this.fromScene = paramInt;
      if (paramb.Iae)
      {
        paramString = j.e(paramString, paramb.HZV);
        this.Iap.add(paramString);
        AppMethodBeat.o(35881);
        return;
      }
      az.ayM();
      paramString = com.tencent.mm.model.c.awD().vP(paramLong);
      if (paramString.field_msgId == 0L)
      {
        Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + bs.eWi(), false);
        AppMethodBeat.o(35881);
        return;
      }
      this.Iap.add(paramString);
      if (this.fromScene == 1) {}
      for (paramInt = i; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(35881);
        return;
      }
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(35879);
          b.a.a(b.a.this, paramLong);
          if (paramb.booleanValue()) {
            b.a.this.handler.postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(35878);
                b.a.a(b.a.this);
                if (b.a.1.this.IaA.Iad != null) {
                  b.a.1.this.IaA.Iad.rB();
                }
                AppMethodBeat.o(35878);
              }
            }, 0L);
          }
          AppMethodBeat.o(35879);
        }
      });
      paramb.HZV.Icz = new ImageGalleryUI.a()
      {
        public final void o(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35880);
          ac.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(paramAnonymousBoolean)));
          if (!paramAnonymousBoolean.booleanValue())
          {
            b.a.a(b.a.this);
            if (paramb.Iad != null) {
              paramb.Iad.rB();
            }
          }
          AppMethodBeat.o(35880);
        }
      };
      AppMethodBeat.o(35881);
    }
    
    private void J(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(35885);
      ac.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
      if (b.qKh) {
        az.ayM();
      }
      for (List localList = com.tencent.mm.model.c.awE().b(this.talker, b.nxq, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.awD().g(this.talker, paramLong, paramBoolean))
      {
        ac.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(paramBoolean)));
        AppMethodBeat.o(35885);
        return;
        az.ayM();
      }
      ac.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
      paramLong = System.currentTimeMillis();
      hT(localList);
      ac.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
      if (paramBoolean)
      {
        this.Iap.addAll(localList);
        AppMethodBeat.o(35885);
        return;
      }
      this.Iap.addAll(0, localList);
      this.min -= localList.size();
      if (this.min < 0)
      {
        ac.e("MicroMsg.AutoList", "loadMsgInfo fail, min should not be minus, min = " + this.min);
        AppMethodBeat.o(35885);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("min from ");
      int i = this.min;
      ac.i("MicroMsg.AutoList", localList.size() + i + " to " + this.min);
      AppMethodBeat.o(35885);
    }
    
    private void hT(List<bo> paramList)
    {
      AppMethodBeat.i(35882);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (b.j((bo)paramList.get(i)))
        {
          localArrayList1.add(Long.valueOf(((bo)paramList.get(i)).field_msgSvrId));
          if (((bo)paramList.get(i)).field_isSend == 1) {
            localArrayList2.add(Long.valueOf(((bo)paramList.get(i)).field_msgId));
          }
        }
        i += 1;
      }
      this.Iaw.putAll(com.tencent.mm.av.o.aFx().a((Long[])localArrayList1.toArray(new Long[0])));
      this.Iax.putAll(com.tencent.mm.av.o.aFx().b((Long[])localArrayList2.toArray(new Long[0])));
      AppMethodBeat.o(35882);
    }
    
    public final void a(long paramLong, com.tencent.mm.av.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(35883);
      if (paramBoolean)
      {
        this.Iaw.put(Long.valueOf(paramLong), parame);
        AppMethodBeat.o(35883);
        return;
      }
      this.Iax.put(Long.valueOf(paramLong), parame);
      AppMethodBeat.o(35883);
    }
    
    public final int abt(int paramInt)
    {
      return paramInt - 100000 + this.Iaq;
    }
    
    public final bo abu(int paramInt)
    {
      AppMethodBeat.i(35884);
      paramInt = abt(paramInt);
      int i = this.min + this.Iap.size() - 1;
      if ((paramInt < this.min) || (paramInt > i))
      {
        ac.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
        AppMethodBeat.o(35884);
        return null;
      }
      ac.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(paramInt)));
      if (paramInt == this.min)
      {
        localbo = (bo)this.Iap.get(0);
        if (this.aSG) {
          J(localbo.field_msgId, false);
        }
        AppMethodBeat.o(35884);
        return localbo;
      }
      if ((paramInt == i) && (i < this.fAw - 1))
      {
        localbo = (bo)this.Iap.get(this.Iap.size() - 1);
        if (this.aSG) {
          J(localbo.field_msgId, true);
        }
        AppMethodBeat.o(35884);
        return localbo;
      }
      bo localbo = (bo)this.Iap.get(paramInt - this.min);
      AppMethodBeat.o(35884);
      return localbo;
    }
    
    public final void fpf()
    {
      this.aSG = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(35886);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AutoList, Size = " + this.Iap.size());
      ((StringBuilder)localObject).append("; Content = {");
      Iterator localIterator = this.Iap.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(((bo)localIterator.next()).field_msgId);
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
      IaD = new b("unkown", 0);
      IaE = new b("image", 1);
      IaF = new b("video", 2);
      IaG = new b("sight", 3);
      IaH = new b("appimage", 4);
      IaI = new b[] { IaD, IaE, IaF, IaG, IaH };
      AppMethodBeat.o(35891);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void rB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b
 * JD-Core Version:    0.7.0.1
 */