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
import com.tencent.mm.aw.l;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.b.a.g.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.by;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.m.a;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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
  public static long mUQ = -1L;
  public static boolean qbB = false;
  public ImageGalleryUI GAa;
  protected a GAb;
  private String GAc;
  boolean GAd;
  public boolean GAe;
  public d GAf;
  public j GAg;
  public i GAh;
  public c GAi;
  public boolean GAj;
  boolean GAk;
  protected boolean GAl;
  private com.tencent.mm.g.b.a.g GAm;
  private String fod;
  private int fromScene;
  private ArrayList<bl> qjT;
  
  public b(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(35892);
    this.GAd = true;
    this.GAe = false;
    this.GAj = false;
    this.fod = null;
    this.GAl = true;
    this.qjT = new ArrayList();
    this.GAm = null;
    this.GAj = paramImageGalleryUI.getIntent().getBooleanExtra("img_gallery_is_mp_video_without_msg", false);
    String str;
    if (!this.GAj)
    {
      str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + bt.eGN();
      if ((paramLong1 <= 0L) || (paramString1 == null) || (paramString1.length() <= 0)) {
        break label248;
      }
    }
    label248:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      this.GAa = paramImageGalleryUI;
      qbB = paramBoolean1;
      mUQ = paramLong2;
      this.fod = paramString1;
      this.fromScene = paramInt;
      this.GAb = new a(paramLong1, paramString1, this, paramBoolean, paramInt);
      this.GAe = paramBoolean2;
      this.GAc = paramString2;
      this.GAf = new d(this);
      this.GAg = new j(this);
      this.GAh = new i(this);
      AppMethodBeat.o(35892);
      return;
    }
  }
  
  public static void a(Context paramContext, bl parambl)
  {
    AppMethodBeat.i(191553);
    if ((paramContext == null) || (parambl == null))
    {
      AppMethodBeat.o(191553);
      return;
    }
    parambl = new b.3(paramContext, parambl);
    b.4 local4 = new b.4(paramContext);
    if (PermissionHelper.aBd("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      parambl.run();
      AppMethodBeat.o(191553);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.platformtools.p.a(paramContext, parambl, local4);
      AppMethodBeat.o(191553);
      return;
    }
    local4.run();
    AppMethodBeat.o(191553);
  }
  
  public static boolean b(Context paramContext, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(35912);
    if (parambl == null)
    {
      AppMethodBeat.o(35912);
      return false;
    }
    Object localObject = com.tencent.mm.modelvideo.o.aCI().zO(parambl.field_imgPath);
    boolean bool = false;
    if (localObject != null)
    {
      int i = 0;
      if (w.pF(((s)localObject).getUser())) {
        i = com.tencent.mm.model.q.rY(((s)localObject).getUser());
      }
      bool = ((s)localObject).aCW();
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(106L, 216L, 1L, false);
      com.tencent.mm.plugin.report.service.h.vKh.f(12084, new Object[] { Integer.valueOf(((s)localObject).gTY), Integer.valueOf(((s)localObject).gOY * 1000), Integer.valueOf(0), Integer.valueOf(2), ((s)localObject).getUser(), Integer.valueOf(i), s.zM(((s)localObject).aCT()), Long.valueOf(((s)localObject).createTime) });
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
    com.tencent.mm.modelvideo.o.aCI();
    localObject = com.tencent.mm.modelvideo.u.Af(com.tencent.mm.modelvideo.t.zQ(parambl.field_imgPath));
    if (bt.isNullOrNil((String)localObject))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131764682), 1).show();
      }
      AppMethodBeat.o(35912);
      return false;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131764683, new Object[] { localObject }), 1).show();
    }
    String str = com.tencent.mm.vfs.i.aEN((String)localObject);
    v localv = v.hUC;
    v.bx(str, bk.uo(parambl.esh));
    com.tencent.mm.pluginsdk.ui.tools.q.k((String)localObject, paramContext);
    AppMethodBeat.o(35912);
    return true;
  }
  
  public static boolean b(bl parambl, com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(35903);
    if ((parambl == null) || (parame == null))
    {
      AppMethodBeat.o(35903);
      return false;
    }
    boolean bool = com.tencent.mm.aw.o.ayG().a(parame.deI, parambl.field_msgId, 1);
    AppMethodBeat.o(35903);
    return bool;
  }
  
  public static boolean bO(bl parambl)
  {
    AppMethodBeat.i(35899);
    if (parambl == null)
    {
      AppMethodBeat.o(35899);
      return false;
    }
    if (parambl.getType() == 62)
    {
      AppMethodBeat.o(35899);
      return true;
    }
    AppMethodBeat.o(35899);
    return false;
  }
  
  public static boolean bP(bl parambl)
  {
    AppMethodBeat.i(35900);
    if (parambl == null)
    {
      AppMethodBeat.o(35900);
      return false;
    }
    if (parambl.getType() == 49)
    {
      AppMethodBeat.o(35900);
      return true;
    }
    AppMethodBeat.o(35900);
    return false;
  }
  
  public static boolean bQ(bl parambl)
  {
    AppMethodBeat.i(35901);
    if (parambl == null)
    {
      AppMethodBeat.o(35901);
      return false;
    }
    if (parambl.getType() == 268435505)
    {
      AppMethodBeat.o(35901);
      return true;
    }
    AppMethodBeat.o(35901);
    return false;
  }
  
  public static boolean bR(bl parambl)
  {
    AppMethodBeat.i(35902);
    if (parambl == null)
    {
      AppMethodBeat.o(35902);
      return false;
    }
    boolean bool = parambl.cjN();
    AppMethodBeat.o(35902);
    return bool;
  }
  
  public static b bS(bl parambl)
  {
    AppMethodBeat.i(35906);
    b localb = b.GAI;
    if (parambl == null) {
      localb = b.GAI;
    }
    if (bQ(parambl))
    {
      parambl = b.GAM;
      AppMethodBeat.o(35906);
      return parambl;
    }
    if (j(parambl))
    {
      parambl = b.GAJ;
      AppMethodBeat.o(35906);
      return parambl;
    }
    if (bT(parambl))
    {
      parambl = b.GAL;
      AppMethodBeat.o(35906);
      return parambl;
    }
    if (m(parambl))
    {
      parambl = b.GAK;
      AppMethodBeat.o(35906);
      return parambl;
    }
    if (bO(parambl))
    {
      parambl = b.GAK;
      AppMethodBeat.o(35906);
      return parambl;
    }
    parambl = b.GAI;
    AppMethodBeat.o(35906);
    return parambl;
  }
  
  public static boolean bT(bl parambl)
  {
    AppMethodBeat.i(35907);
    if (parambl != null)
    {
      if (parambl.cjN())
      {
        AppMethodBeat.o(35907);
        return false;
      }
      parambl = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
      if ((parambl != null) && (parambl.hAq != null) && ((!bt.isNullOrNil(parambl.hAq.gJv)) || (parambl.hAq.Dim > 0) || (!bt.isNullOrNil(parambl.hAq.gJy)) || (!bt.isNullOrNil(parambl.hAq.gJz)) || (!bt.isNullOrNil(parambl.hAq.gJx)) || (!bt.isNullOrNil(parambl.hAq.gJA)) || (!bt.isNullOrNil(parambl.hAq.gJB)) || (!bt.isNullOrNil(parambl.hAq.gJC))))
      {
        AppMethodBeat.o(35907);
        return true;
      }
    }
    AppMethodBeat.o(35907);
    return false;
  }
  
  public static int c(bl parambl, com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(35918);
    if (parambl.field_isSend == 1)
    {
      if (parame.ayi())
      {
        parambl = com.tencent.mm.aw.f.a(parame);
        if ((parambl != null) && (parambl.deI > 0L) && (parambl.ayh()) && (com.tencent.mm.vfs.i.eK(com.tencent.mm.aw.o.ayF().p(parambl.hgj, "", ""))))
        {
          AppMethodBeat.o(35918);
          return 1;
        }
      }
      AppMethodBeat.o(35918);
      return 0;
    }
    if (parame.ayh())
    {
      if (parame.ayi())
      {
        parambl = com.tencent.mm.aw.f.a(parame);
        if ((parambl != null) && (parambl.deI > 0L) && (parambl.ayh()) && (com.tencent.mm.vfs.i.eK(com.tencent.mm.aw.o.ayF().p(parambl.hgj, "", ""))))
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
  
  public static void c(Context paramContext, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(191554);
    if ((paramContext == null) || (parambl == null))
    {
      AppMethodBeat.o(191554);
      return;
    }
    parambl = new b.5(paramContext, parambl, paramBoolean);
    b.6 local6 = new b.6(paramBoolean, paramContext);
    if (PermissionHelper.aBd("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      parambl.run();
      AppMethodBeat.o(191554);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.platformtools.p.a(paramContext, parambl, local6);
      AppMethodBeat.o(191554);
      return;
    }
    local6.run();
    AppMethodBeat.o(191554);
  }
  
  public static boolean d(Context paramContext, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(35913);
    if (bQ(parambl)) {}
    for (Object localObject = l(parambl); (localObject == null) || (((String)localObject).length() == 0); localObject = d.a(parambl, (com.tencent.mm.aw.e)localObject))
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambl.field_msgId);
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
      }
      AppMethodBeat.o(35913);
      return false;
      if ((parambl == null) || (parambl.field_msgId == 0L))
      {
        ad.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
        }
        AppMethodBeat.o(35913);
        return false;
      }
      localObject = d.k(parambl);
      if ((localObject == null) || (((com.tencent.mm.aw.e)localObject).deI == 0L))
      {
        StringBuilder localStringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (parambl == null)
        {
          parambl = "null";
          localStringBuilder = localStringBuilder.append(parambl).append(", imgLocalId = ");
          if (localObject != null) {
            break label244;
          }
        }
        label244:
        for (parambl = "null";; parambl = Long.valueOf(((com.tencent.mm.aw.e)localObject).deI))
        {
          ad.e("MicroMsg.ImageGalleryAdapter", parambl);
          if (paramBoolean) {
            Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
          }
          AppMethodBeat.o(35913);
          return false;
          parambl = Long.valueOf(parambl.field_msgId);
          break;
        }
      }
    }
    localObject = com.tencent.mm.platformtools.p.H(paramContext, (String)localObject);
    if (!bt.isNullOrNil((String)localObject))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(2131757969, new Object[] { com.tencent.mm.sdk.f.b.eAT() }), 1).show();
      }
      paramContext = com.tencent.mm.vfs.i.aEN((String)localObject);
      localObject = v.hUC;
      v.bx(paramContext, bk.uo(parambl.esh));
      AppMethodBeat.o(35913);
      return true;
    }
    if (paramBoolean) {
      Toast.makeText(paramContext, paramContext.getString(2131762779), 1).show();
    }
    AppMethodBeat.o(35913);
    return false;
  }
  
  public static void f(Context paramContext, List<bl> paramList)
  {
    AppMethodBeat.i(191552);
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(191552);
      return;
    }
    paramList = new b.1(paramList, paramContext);
    b.2 local2 = new b.2(paramContext);
    if ((paramContext instanceof Activity))
    {
      com.tencent.mm.platformtools.p.a(paramContext, paramList, local2);
      AppMethodBeat.o(191552);
      return;
    }
    local2.run();
    AppMethodBeat.o(191552);
  }
  
  public static boolean j(bl parambl)
  {
    AppMethodBeat.i(35897);
    if (parambl == null)
    {
      AppMethodBeat.o(35897);
      return false;
    }
    if ((parambl.getType() == 3) || (parambl.getType() == 39) || (parambl.getType() == 13))
    {
      AppMethodBeat.o(35897);
      return true;
    }
    AppMethodBeat.o(35897);
    return false;
  }
  
  public static String l(bl parambl)
  {
    Object localObject1 = null;
    AppMethodBeat.i(35916);
    Object localObject2 = k.b.rx(parambl.field_content);
    if (localObject2 == null)
    {
      AppMethodBeat.o(35916);
      return null;
    }
    parambl = localObject1;
    if (((k.b)localObject2).dbA != null)
    {
      parambl = localObject1;
      if (((k.b)localObject2).dbA.length() > 0)
      {
        localObject2 = com.tencent.mm.pluginsdk.model.app.ap.bxS().aAL(((k.b)localObject2).dbA);
        parambl = localObject1;
        if (localObject2 != null) {
          parambl = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
        }
      }
    }
    AppMethodBeat.o(35916);
    return parambl;
  }
  
  public static boolean m(bl parambl)
  {
    AppMethodBeat.i(35898);
    if (parambl == null)
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if (bT(parambl))
    {
      AppMethodBeat.o(35898);
      return false;
    }
    if ((parambl.getType() == 43) || (parambl.getType() == 486539313) || (parambl.getType() == 44) || (parambl.getType() == 62))
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
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "doRestransmitImg fail, imgPath is null");
      AppMethodBeat.o(35909);
      return;
    }
    Object localObject;
    if (bt.isNullOrNil(this.GAc))
    {
      ad.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      localObject = new Intent(this.GAa, MsgRetransmitUI.class);
      ((Intent)localObject).putExtra("Retr_File_Name", paramString);
      ((Intent)localObject).putExtra("Retr_Msg_Id", paramLong);
      ((Intent)localObject).putExtra("Retr_Msg_Type", 0);
      ((Intent)localObject).putExtra("Retr_Compress_Type", paramInt);
      paramString = this.GAa;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(35909);
      return;
    }
    ad.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.GAc });
    if (!bt.isNullOrNil(paramString))
    {
      paramString = new l(com.tencent.mm.model.u.aqG(), this.GAc, paramString, paramInt);
      az.aeS().a(paramString, 0);
      by.asD().d(by.gPk, null);
    }
    if (this.GAd)
    {
      localObject = new Intent(this.GAa, ChattingUI.class);
      ((Intent)localObject).addFlags(67108864);
      ((Intent)localObject).putExtra("Chat_User", this.GAc);
      paramString = this.GAa;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestranmitImg", "(Ljava/lang/String;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.GAc });
      AppMethodBeat.o(35909);
      return;
      com.tencent.mm.ui.base.h.cf(this.GAa, this.GAa.getString(2131755881));
    }
  }
  
  public final MultiTouchImageView Ef(int paramInt)
  {
    AppMethodBeat.i(35920);
    Object localObject = super.OT(paramInt);
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
  
  public final WxImageView Eg(int paramInt)
  {
    AppMethodBeat.i(35921);
    Object localObject = super.OT(paramInt);
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
  
  public final bl YE(int paramInt)
  {
    AppMethodBeat.i(35894);
    bl localbl = this.GAb.Zi(paramInt);
    AppMethodBeat.o(35894);
    return localbl;
  }
  
  public final void YY(int paramInt)
  {
    AppMethodBeat.i(35904);
    Object localObject1 = YE(paramInt);
    Object localObject2 = bS((bl)localObject1);
    switch (8.GAt[localObject2.ordinal()])
    {
    default: 
      bV((bl)localObject1);
      AppMethodBeat.o(35904);
      return;
    case 1: 
    case 2: 
      bU((bl)localObject1);
      AppMethodBeat.o(35904);
      return;
    }
    String str = l((bl)localObject1);
    localObject2 = new Intent(this.GAa, MsgRetransmitUI.class);
    ((Intent)localObject2).putExtra("Retr_File_Name", str);
    ((Intent)localObject2).putExtra("Retr_Msg_Id", ((du)localObject1).field_msgId);
    ((Intent)localObject2).putExtra("Retr_Msg_Type", 16);
    ((Intent)localObject2).putExtra("Retr_Msg_content", ((du)localObject1).field_content);
    ((Intent)localObject2).putExtra("Retr_Compress_Type", 0);
    localObject1 = this.GAa;
    localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitAppImg", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35904);
  }
  
  public final void YZ(int paramInt)
  {
    AppMethodBeat.i(35905);
    Object localObject1 = YE(paramInt);
    Object localObject2 = bS((bl)localObject1);
    switch (8.GAt[localObject2.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35905);
      return;
      localObject2 = new Intent(this.GAa, ChattingSendDataToDeviceUI.class);
      ((Intent)localObject2).putExtra("Retr_Msg_Id", ((du)localObject1).field_msgId);
      localObject1 = this.GAa;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((ImageGalleryUI)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doSendMsgToDevice", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
  
  public final void Za(int paramInt)
  {
    AppMethodBeat.i(35914);
    Object localObject1 = YE(paramInt);
    if (this.GAj)
    {
      localObject1 = j.ci((bl)localObject1);
      if (localObject1 == null)
      {
        ad.e("MicroMsg.ImageGalleryAdapter", "doFavoriteImage mpShareVideoInfo should not be null");
        AppMethodBeat.o(35914);
        return;
      }
      localObject2 = com.tencent.mm.plugin.webview.ui.tools.media.e.BsW;
      com.tencent.mm.plugin.webview.ui.tools.media.e.b((y)localObject1);
      com.tencent.mm.ui.base.h.cf(this.GAa, this.GAa.getString(2131758936));
      AppMethodBeat.o(35914);
      return;
    }
    Object localObject2 = new cs();
    com.tencent.mm.pluginsdk.model.g.e((cs)localObject2, (bl)localObject1);
    ((cs)localObject2).deQ.activity = this.GAa;
    ((cs)localObject2).deQ.deW = 44;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
    if (((cs)localObject2).deR.ret == 0)
    {
      if (((bl)localObject1).cjO()) {
        com.tencent.mm.ui.chatting.a.a(a.c.Gjw, a.d.GjC, (bl)localObject1, 0);
      }
      com.tencent.mm.modelstat.b.huc.P((bl)localObject1);
    }
    AppMethodBeat.o(35914);
  }
  
  public final View Zb(int paramInt)
  {
    AppMethodBeat.i(35922);
    View localView3 = super.OT(paramInt);
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
  
  public final void Zc(int paramInt)
  {
    AppMethodBeat.i(35923);
    this.GAg.j(YE(paramInt), paramInt);
    AppMethodBeat.o(35923);
  }
  
  public final void Zd(int paramInt)
  {
    AppMethodBeat.i(35924);
    this.GAg.k(YE(paramInt), paramInt);
    AppMethodBeat.o(35924);
  }
  
  public final void Ze(int paramInt)
  {
    AppMethodBeat.i(35927);
    this.GAg.YX(paramInt);
    AppMethodBeat.o(35927);
  }
  
  public final void Zf(int paramInt)
  {
    AppMethodBeat.i(35930);
    bl localbl = YE(paramInt);
    if ((localbl == null) || (!j(localbl)))
    {
      AppMethodBeat.o(35930);
      return;
    }
    this.GAf.ca(localbl);
    AppMethodBeat.o(35930);
  }
  
  public final void Zg(int paramInt)
  {
    AppMethodBeat.i(35931);
    this.GAh.Zm(paramInt);
    AppMethodBeat.o(35931);
  }
  
  public final void a(bl parambl, com.tencent.mm.aw.e parame, int paramInt, g.a parama)
  {
    AppMethodBeat.i(35934);
    if (parambl == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    if (this.GAm == null)
    {
      AppMethodBeat.o(35934);
      return;
    }
    this.GAm.Qa().dHb = parama;
    long l1 = parambl.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.GAm.dGT != l1) && (this.GAm.dGV != i); i = 0)
    {
      ad.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.GAm.dGT), Long.valueOf(l1) });
      parambl = this.GAm;
      parambl.dHb = g.a.dHd;
      parambl.aBj();
      AppMethodBeat.o(35934);
      return;
    }
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0L;
    long l7 = bt.GC();
    long l3 = l6;
    long l2 = l5;
    l1 = l4;
    if (parama == g.a.dHc)
    {
      parambl = d.a(parambl, parame);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!bt.isNullOrNil(parambl))
      {
        l1 = com.tencent.mm.vfs.i.aMN(parambl);
        parambl = d.aKR(parambl);
        l3 = parambl.outWidth;
        l2 = parambl.outHeight;
      }
    }
    parambl = this.GAm;
    parambl.dGW = l1;
    parambl.dGY = l2;
    parambl.dGX = l3;
    this.GAm.aBj();
    ad.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(bt.aS(l7)), this.GAm.PV() });
    this.GAm = null;
    AppMethodBeat.o(35934);
  }
  
  public final void aV(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35919);
    this.GAf.aV(paramInt, paramBoolean);
    AppMethodBeat.o(35919);
  }
  
  public final void bU(bl parambl)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(35908);
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.t.g(this.GAa, null);
      AppMethodBeat.o(35908);
      return;
    }
    if (parambl.cjN())
    {
      parambl = j.ci(parambl);
      if (parambl == null)
      {
        ad.e("MicroMsg.ImageGalleryAdapter", "doRestransmitVideo mpShareVideoInfo should not be null");
        AppMethodBeat.o(35908);
        return;
      }
      if (this.GAa.Bit == null) {
        this.GAa.Bit = new com.tencent.mm.plugin.webview.ui.tools.media.d();
      }
      this.GAa.Bit.gGE = parambl;
      if (this.GAj) {}
      for (;;)
      {
        parambl.gLe = this.GAa.GCg.niH;
        localObject = com.tencent.mm.plugin.webview.ui.tools.media.c.BsS;
        com.tencent.mm.plugin.webview.ui.tools.media.c.a(this.GAa, parambl.gKD, "", parambl.title, parambl.url, i);
        AppMethodBeat.o(35908);
        return;
        i = 0;
      }
    }
    s locals = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
    if (locals == null)
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      AppMethodBeat.o(35908);
      return;
    }
    Object localObject = new Intent(this.GAa, MsgRetransmitUI.class);
    ((Intent)localObject).putExtra("Retr_length", locals.gOY);
    ((Intent)localObject).putExtra("Retr_File_Name", parambl.field_imgPath);
    ((Intent)localObject).putExtra("Retr_video_isexport", locals.hAl);
    i = j;
    if (bO(parambl)) {
      i = 11;
    }
    ((Intent)localObject).putExtra("Retr_Msg_Type", i);
    ((Intent)localObject).putExtra("Retr_Msg_Id", parambl.field_msgId);
    ((Intent)localObject).putExtra("Retr_From", "gallery");
    parambl = this.GAa;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(parambl, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parambl.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(parambl, "com/tencent/mm/ui/chatting/gallery/ImageGalleryAdapter", "doRestransmitVideo", "(Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(35908);
  }
  
  public final void bV(bl parambl)
  {
    AppMethodBeat.i(35910);
    com.tencent.mm.aw.e locale = d.k(parambl);
    if ((parambl == null) || (parambl.field_msgId == 0L) || (locale == null) || (locale.deI == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (parambl == null)
      {
        parambl = "null";
        localObject = ((StringBuilder)localObject).append(parambl).append(", imgLocalId = ");
        if (locale != null) {
          break label108;
        }
      }
      label108:
      for (parambl = "null";; parambl = Long.valueOf(locale.deI))
      {
        ad.e("MicroMsg.ImageGalleryAdapter", parambl);
        AppMethodBeat.o(35910);
        return;
        parambl = Long.valueOf(parambl.field_msgId);
        break;
      }
    }
    Object localObject = d.a(parambl, locale);
    if (bt.isNullOrNil((String)localObject))
    {
      ad.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambl.field_msgId + ", imgLocalId = " + locale.deI);
      AppMethodBeat.o(35910);
      return;
    }
    o((String)localObject, c(parambl, locale), parambl.field_msgId);
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
    this.GAf.detach();
    this.GAg.detach();
    this.GAh.detach();
    if (this.GAm != null)
    {
      com.tencent.mm.g.b.a.g localg = this.GAm.Qa();
      localg.dHb = g.a.dHd;
      localg.aBj();
    }
    super.detach();
    AppMethodBeat.o(35917);
  }
  
  public final View e(int paramInt, View paramView)
  {
    AppMethodBeat.i(35915);
    final bl localbl = YE(paramInt);
    View localView;
    final k localk;
    if (paramView == null)
    {
      localView = View.inflate(this.GAa, 2131494469, null);
      localk = new k(this, localView);
      localView.setTag(localk);
      paramView = bS(localbl);
      localk.mPosition = paramInt;
      localk.GDC = paramView;
      k.aD(localk.rLd, 0);
      switch (k.5.GAt[paramView.ordinal()])
      {
      default: 
        label108:
        k.aD(localk.GEb, 8);
        k.aD(localk.GEc, 8);
        k.aD(localk.GDS, 8);
        k.aD(localk.GDY, 8);
        k.aD(localk.GDX, 8);
        ad.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (8.GAt[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.GAl = false;
      AppMethodBeat.o(35915);
      return localView;
      localk = (k)paramView.getTag();
      localView = paramView;
      break;
      k.aD(localk.GDK, 8);
      k.aD(localk.GDE, 8);
      break label108;
      localk.fac();
      k.aD(localk.GDK, 0);
      k.aD(localk.GDE, 8);
      if (localk.GDE == null) {
        break label108;
      }
      k.aD(localk.GDG, 8);
      break label108;
      localk.fab();
      k.aD(localk.GDK, 8);
      k.aD(localk.GDE, 0);
      break label108;
      k.aD(localk.rLd, 8);
      k.aD(localk.GDK, 8);
      k.aD(localk.GDE, 8);
      break label108;
      this.GAf.a(localk, localbl, paramInt);
      if (paramInt == 100000)
      {
        ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).af(localbl);
        continue;
        k.aD(localk.GEb, 0);
        k.aD(localk.GDS, 8);
        k.aD(localk.GDX, 8);
        k.aD(localk.GDY, 8);
        k.aD(localk.GDO, 8);
        final String str = l(localbl);
        try
        {
          paramView = com.tencent.mm.platformtools.u.BB(str);
          localObject = paramView;
          if (paramView == null)
          {
            localObject = com.tencent.mm.platformtools.u.BA(com.tencent.mm.aw.o.ayF().Q(localbl.field_imgPath, true));
            k.aD(localk.GDX, 0);
            new com.tencent.mm.sdk.platformtools.ap().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(191550);
                m.a(localbl, new m.a()
                {
                  public final void iL(int paramAnonymous2Int1, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(191549);
                    if (paramAnonymous2Int1 == paramAnonymous2Int2)
                    {
                      ad.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[] { Long.valueOf(b.7.this.gLQ.field_msgId) });
                      k.aD(b.7.this.GAq.GDX, 8);
                    }
                    try
                    {
                      Bitmap localBitmap1 = com.tencent.mm.platformtools.u.BB(b.7.this.kkX);
                      if (localBitmap1 != null)
                      {
                        b.7.this.GAq.GEb.setEnableHorLongBmpMode(false);
                        com.tencent.mm.sdk.platformtools.p.z(b.7.this.GAq.GEb, localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.7.this.GAq.GEb.cH(localBitmap1.getWidth(), localBitmap1.getHeight());
                        b.7.this.GAq.GEb.setImageBitmap(localBitmap1);
                        b.7.this.GAq.GEb.invalidate();
                      }
                      AppMethodBeat.o(191549);
                      return;
                    }
                    catch (OutOfMemoryError localOutOfMemoryError)
                    {
                      for (;;)
                      {
                        ad.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { b.7.this.kkX });
                        Runtime.getRuntime().gc();
                        Runtime.getRuntime().runFinalization();
                        Bitmap localBitmap2 = com.tencent.mm.platformtools.u.BA(b.7.this.kkX);
                      }
                    }
                  }
                });
                AppMethodBeat.o(191550);
              }
            });
          }
          if (localObject == null)
          {
            ad.w("MicroMsg.ImageGalleryAdapter", "get image fail");
            localk.GEb.setVisibility(8);
            localk.faa().GDY.setVisibility(0);
            localk.faa().GEa.setImageResource(2131690686);
            localk.faa().GDZ.setText(this.GAa.getString(2131760324));
            if (paramInt != 100000) {
              continue;
            }
            ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).af(localbl);
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
            paramView = com.tencent.mm.platformtools.u.BA(str);
            continue;
            localk.GEb.setEnableHorLongBmpMode(false);
            com.tencent.mm.sdk.platformtools.p.z(localk.GEb, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.GEb.cH(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
            localk.GEb.setImageBitmap((Bitmap)localObject);
            localk.GEb.invalidate();
          }
        }
        this.GAg.a(localk, localbl, paramInt);
        continue;
        this.GAh.a(localk, localbl, paramInt);
      }
    }
  }
  
  public final void eZq()
  {
    AppMethodBeat.i(35895);
    this.GAb.eZq();
    AppMethodBeat.o(35895);
  }
  
  public final bl eZr()
  {
    AppMethodBeat.i(35925);
    bl localbl = YE(this.GAa.getCurrentItem());
    AppMethodBeat.o(35925);
    return localbl;
  }
  
  public final k eZs()
  {
    AppMethodBeat.i(35926);
    Object localObject2 = this.GAf.YW(this.GAa.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.GAg.YW(this.GAa.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.GAh.YW(this.GAa.getCurrentItem());
    }
    AppMethodBeat.o(35926);
    return localObject2;
  }
  
  public final void eZt()
  {
    AppMethodBeat.i(35929);
    this.GAg.onResume();
    AppMethodBeat.o(35929);
  }
  
  public final int firstItemPosForDetermine()
  {
    return 100000 - this.GAb.GAv;
  }
  
  public final int getCount()
  {
    a locala = this.GAb;
    return locala.fwP - locala.GAv + 100000 + 1;
  }
  
  public final int getRealCount()
  {
    return this.GAb.fwP;
  }
  
  public final com.tencent.mm.aw.e h(bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(35896);
    parambl = this.GAf.h(parambl, paramBoolean);
    AppMethodBeat.o(35896);
    return parambl;
  }
  
  public final void i(bl parambl, boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(35933);
    if (parambl == null)
    {
      AppMethodBeat.o(35933);
      return;
    }
    Object localObject = eZr();
    if ((localObject == null) || (((du)localObject).field_msgId != parambl.field_msgId))
    {
      ad.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((du)localObject).field_msgId), Long.valueOf(parambl.field_msgId) });
      AppMethodBeat.o(35933);
      return;
    }
    long l = parambl.field_msgSvrId;
    if ((this.GAm != null) && ((this.GAm.dGT != l) || (this.GAm.dGV != paramBoolean)))
    {
      localObject = this.GAm.Qa();
      ((com.tencent.mm.g.b.a.g)localObject).dHb = g.a.dHd;
      ((com.tencent.mm.g.b.a.g)localObject).aBj();
    }
    this.GAm = new com.tencent.mm.g.b.a.g();
    this.GAm.PZ();
    localObject = this.GAm;
    ((com.tencent.mm.g.b.a.g)localObject).dGT = l;
    ((com.tencent.mm.g.b.a.g)localObject).dGU = parambl.field_createTime;
    ((com.tencent.mm.g.b.a.g)localObject).dGV = paramBoolean;
    if (w.pF(this.fod)) {
      i = com.tencent.mm.model.q.rY(this.fod);
    }
    parambl = this.GAm;
    parambl.dGR = parambl.t("ChatName", this.fod, true);
    parambl.dGS = i;
    AppMethodBeat.o(35933);
  }
  
  public final int lastItemPosForDetermine()
  {
    return 100000 - this.GAb.GAv + this.GAb.fwP - 1;
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
    if ((this.GAf != null) && (j(YE(paramInt)))) {
      this.GAf.GBu.onPageSelected(paramInt);
    }
    AppMethodBeat.o(35893);
  }
  
  public static final class a
  {
    private b GAA;
    public HashMap<Long, com.tencent.mm.aw.e> GAB;
    public HashMap<Long, com.tencent.mm.aw.e> GAC;
    private List<bl> GAu;
    int GAv;
    protected int GAw;
    protected int GAx;
    protected int GAy;
    protected long GAz;
    protected boolean aRL;
    private int fromScene;
    int fwP;
    com.tencent.mm.sdk.platformtools.ap handler;
    private int min;
    private String talker;
    
    public a(final long paramLong, String paramString, final b paramb, Boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(35881);
      this.aRL = false;
      this.GAB = new HashMap();
      this.GAC = new HashMap();
      this.handler = new com.tencent.mm.sdk.platformtools.ap();
      this.talker = paramString;
      this.GAu = new LinkedList();
      this.GAA = paramb;
      this.fromScene = paramInt;
      if (paramb.GAj)
      {
        paramString = j.b(paramString, paramb.GAa);
        this.GAu.add(paramString);
        AppMethodBeat.o(35881);
        return;
      }
      az.arV();
      paramString = com.tencent.mm.model.c.apO().rm(paramLong);
      if (paramString.field_msgId == 0L)
      {
        Assert.assertTrue("MicroMsg.AutoList <init>, currentMsg does not exist, currentMsgId = " + paramLong + ", stack = " + bt.eGN(), false);
        AppMethodBeat.o(35881);
        return;
      }
      this.GAu.add(paramString);
      if (this.fromScene == 1) {}
      for (paramInt = i; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(35881);
        return;
      }
      az.afE().ax(new Runnable()
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
                if (b.a.1.this.GAF.GAi != null) {
                  b.a.1.this.GAF.GAi.rq();
                }
                AppMethodBeat.o(35878);
              }
            }, 0L);
          }
          AppMethodBeat.o(35879);
        }
      });
      paramb.GAa.GCD = new ImageGalleryUI.a()
      {
        public final void o(Boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(35880);
          ad.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(paramAnonymousBoolean)));
          if (!paramAnonymousBoolean.booleanValue())
          {
            b.a.a(b.a.this);
            if (paramb.GAi != null) {
              paramb.GAi.rq();
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
      ad.i("MicroMsg.AutoList", "start loadMsgInfo, currentMsgId = " + paramLong + ", forward = " + paramBoolean);
      if (b.qbB) {
        az.arV();
      }
      for (List localList = com.tencent.mm.model.c.apP().b(this.talker, b.mUQ, paramLong, paramBoolean); (localList == null) || (localList.size() == 0); localList = com.tencent.mm.model.c.apO().g(this.talker, paramLong, paramBoolean))
      {
        ad.w("MicroMsg.AutoList", "loadMsgInfo fail, addedMsgList is null, forward = ".concat(String.valueOf(paramBoolean)));
        AppMethodBeat.o(35885);
        return;
        az.arV();
      }
      ad.i("MicroMsg.AutoList", "loadMsgInfo done, new added list, size = " + localList.size() + ", forward = " + paramBoolean);
      paramLong = System.currentTimeMillis();
      hG(localList);
      ad.i("MicroMsg.AutoList", "loadImgInfo spent : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) });
      if (paramBoolean)
      {
        this.GAu.addAll(localList);
        AppMethodBeat.o(35885);
        return;
      }
      this.GAu.addAll(0, localList);
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
    
    private void hG(List<bl> paramList)
    {
      AppMethodBeat.i(35882);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        if (b.j((bl)paramList.get(i)))
        {
          localArrayList1.add(Long.valueOf(((bl)paramList.get(i)).field_msgSvrId));
          if (((bl)paramList.get(i)).field_isSend == 1) {
            localArrayList2.add(Long.valueOf(((bl)paramList.get(i)).field_msgId));
          }
        }
        i += 1;
      }
      this.GAB.putAll(com.tencent.mm.aw.o.ayF().a((Long[])localArrayList1.toArray(new Long[0])));
      this.GAC.putAll(com.tencent.mm.aw.o.ayF().b((Long[])localArrayList2.toArray(new Long[0])));
      AppMethodBeat.o(35882);
    }
    
    public final int Zh(int paramInt)
    {
      return paramInt - 100000 + this.GAv;
    }
    
    public final bl Zi(int paramInt)
    {
      AppMethodBeat.i(35884);
      paramInt = Zh(paramInt);
      int i = this.min + this.GAu.size() - 1;
      if ((paramInt < this.min) || (paramInt > i))
      {
        ad.e("MicroMsg.AutoList", "get, invalid pos " + paramInt + ", min = " + this.min + ", max = " + i);
        AppMethodBeat.o(35884);
        return null;
      }
      ad.d("MicroMsg.AutoList", "get, pos = ".concat(String.valueOf(paramInt)));
      if (paramInt == this.min)
      {
        localbl = (bl)this.GAu.get(0);
        if (this.aRL) {
          J(localbl.field_msgId, false);
        }
        AppMethodBeat.o(35884);
        return localbl;
      }
      if ((paramInt == i) && (i < this.fwP - 1))
      {
        localbl = (bl)this.GAu.get(this.GAu.size() - 1);
        if (this.aRL) {
          J(localbl.field_msgId, true);
        }
        AppMethodBeat.o(35884);
        return localbl;
      }
      bl localbl = (bl)this.GAu.get(paramInt - this.min);
      AppMethodBeat.o(35884);
      return localbl;
    }
    
    public final void a(long paramLong, com.tencent.mm.aw.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(35883);
      if (paramBoolean)
      {
        this.GAB.put(Long.valueOf(paramLong), parame);
        AppMethodBeat.o(35883);
        return;
      }
      this.GAC.put(Long.valueOf(paramLong), parame);
      AppMethodBeat.o(35883);
    }
    
    public final void eZq()
    {
      this.aRL = false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(35886);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("AutoList, Size = " + this.GAu.size());
      ((StringBuilder)localObject).append("; Content = {");
      Iterator localIterator = this.GAu.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(((bl)localIterator.next()).field_msgId);
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
      GAI = new b("unkown", 0);
      GAJ = new b("image", 1);
      GAK = new b("video", 2);
      GAL = new b("sight", 3);
      GAM = new b("appimage", 4);
      GAN = new b[] { GAI, GAJ, GAK, GAL, GAM };
      AppMethodBeat.o(35891);
    }
    
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void rq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.b
 * JD-Core Version:    0.7.0.1
 */