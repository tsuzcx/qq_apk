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
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.d;
import com.tencent.mm.as.g;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.b.a.e.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.m;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

@SuppressLint({"UseSparseArrays"})
public final class c
  extends com.tencent.mm.ui.base.t
{
  public static long idK = -1L;
  public static boolean kax = false;
  private String dmh = null;
  private ArrayList<bi> khB = new ArrayList();
  public ImageGalleryUI vtJ;
  protected c.a vtK;
  private String vtL;
  boolean vtM = true;
  public boolean vtN = false;
  public e vtO;
  public j vtP;
  public i vtQ;
  public c.c vtR;
  boolean vtS;
  protected boolean vtT = true;
  private com.tencent.mm.h.b.a.e vtU = null;
  
  public c(ImageGalleryUI paramImageGalleryUI, long paramLong1, String paramString1, boolean paramBoolean1, long paramLong2, boolean paramBoolean2, String paramString2, Boolean paramBoolean)
  {
    String str = "MicroMsg.ImageGalleryAdapter, invalid argument, context = " + paramImageGalleryUI + ", currentMsgId = " + paramLong1 + ", talker = " + paramString1 + ", stack = " + bk.csb();
    if ((paramImageGalleryUI != null) && (paramLong1 > 0L) && (paramString1 != null) && (paramString1.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(str, bool);
      this.vtJ = paramImageGalleryUI;
      kax = paramBoolean1;
      idK = paramLong2;
      this.dmh = paramString1;
      this.vtK = new c.a(paramLong1, paramString1, this, paramBoolean);
      this.vtN = paramBoolean2;
      this.vtL = paramString2;
      this.vtO = new e(this);
      this.vtP = new j(this);
      this.vtQ = new i(this);
      return;
    }
  }
  
  public static boolean a(Context paramContext, bi parambi, boolean paramBoolean)
  {
    if (parambi == null) {
      return false;
    }
    com.tencent.mm.modelvideo.s locals = com.tencent.mm.modelvideo.o.Sr().nQ(parambi.field_imgPath);
    int i;
    label43:
    boolean bool;
    if (locals != null) {
      if (com.tencent.mm.model.s.fn(locals.SA()))
      {
        i = m.gM(locals.SA());
        bool = locals.SG();
        com.tencent.mm.plugin.report.service.h.nFQ.a(106L, 216L, 1L, false);
        com.tencent.mm.plugin.report.service.h.nFQ.f(12084, new Object[] { Integer.valueOf(locals.ebK), Integer.valueOf(locals.eHH * 1000), Integer.valueOf(0), Integer.valueOf(2), locals.SA(), Integer.valueOf(i), com.tencent.mm.modelvideo.s.nP(locals.SD()), Long.valueOf(locals.createTime) });
      }
    }
    for (;;)
    {
      if (!bool)
      {
        y.w("MicroMsg.ImageGalleryAdapter", "do export video but video had not download finish.");
        if (!paramBoolean) {
          break;
        }
        Toast.makeText(paramContext, paramContext.getString(R.l.video_file_save_failed), 1).show();
        return false;
      }
      com.tencent.mm.modelvideo.o.Sr();
      parambi = u.of(com.tencent.mm.modelvideo.t.nS(parambi.field_imgPath));
      if (bk.bl(parambi))
      {
        if (!paramBoolean) {
          break;
        }
        Toast.makeText(paramContext, paramContext.getString(R.l.video_file_save_failed), 1).show();
        return false;
      }
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(R.l.video_file_saved, new Object[] { parambi }), 1).show();
      }
      com.tencent.mm.pluginsdk.ui.tools.l.a(parambi, paramContext);
      return true;
      i = 0;
      break label43;
      bool = false;
    }
  }
  
  public static boolean a(bi parambi, com.tencent.mm.as.e parame)
  {
    if ((parambi == null) || (parame == null)) {
      return false;
    }
    return com.tencent.mm.as.o.OK().a(parame.enp, parambi.field_msgId, 1);
  }
  
  public static int b(bi parambi, com.tencent.mm.as.e parame)
  {
    if (parambi.field_isSend == 1) {
      if (parame.Or())
      {
        parambi = com.tencent.mm.as.f.a(parame);
        if ((parambi == null) || (parambi.enp <= 0L) || (!parambi.Oq()) || (!com.tencent.mm.vfs.e.bK(com.tencent.mm.as.o.OJ().o(parambi.enq, "", "")))) {}
      }
    }
    do
    {
      return 1;
      return 0;
      if (!parame.Oq()) {
        break label129;
      }
      if (!parame.Or()) {
        break;
      }
      parambi = com.tencent.mm.as.f.a(parame);
    } while ((parambi != null) && (parambi.enp > 0L) && (parambi.Oq()) && (com.tencent.mm.vfs.e.bK(com.tencent.mm.as.o.OJ().o(parambi.enq, "", ""))));
    return 0;
    label129:
    return 0;
  }
  
  public static boolean b(Context paramContext, bi parambi, boolean paramBoolean)
  {
    if (bi(parambi)) {}
    for (Object localObject = bo(parambi); (localObject == null) || (((String)localObject).length() == 0); localObject = e.d(parambi, (com.tencent.mm.as.e)localObject))
    {
      y.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambi.field_msgId);
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(R.l.save_image_err), 1).show();
      }
      return false;
      if ((parambi == null) || (parambi.field_msgId == 0L))
      {
        y.e("MicroMsg.ImageGalleryAdapter", "msg is null");
        if (paramBoolean) {
          Toast.makeText(paramContext, paramContext.getString(R.l.save_image_err), 1).show();
        }
        return false;
      }
      localObject = e.bt(parambi);
      if ((localObject == null) || (((com.tencent.mm.as.e)localObject).enp == 0L))
      {
        StringBuilder localStringBuilder = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
        if (parambi == null)
        {
          parambi = "null";
          localStringBuilder = localStringBuilder.append(parambi).append(", imgLocalId = ");
          if (localObject != null) {
            break label217;
          }
        }
        label217:
        for (parambi = "null";; parambi = Long.valueOf(((com.tencent.mm.as.e)localObject).enp))
        {
          y.e("MicroMsg.ImageGalleryAdapter", parambi);
          if (paramBoolean) {
            Toast.makeText(paramContext, paramContext.getString(R.l.save_image_err), 1).show();
          }
          return false;
          parambi = Long.valueOf(parambi.field_msgId);
          break;
        }
      }
    }
    if (!com.tencent.mm.platformtools.q.a((String)localObject, paramContext, paramBoolean, R.l.cropimage_saved))
    {
      if (paramBoolean) {
        Toast.makeText(paramContext, paramContext.getString(R.l.save_image_err), 1).show();
      }
      return false;
    }
    return true;
  }
  
  public static boolean be(bi parambi)
  {
    if (parambi == null) {}
    while ((parambi.getType() != 3) && (parambi.getType() != 39) && (parambi.getType() != 13)) {
      return false;
    }
    return true;
  }
  
  public static boolean bf(bi parambi)
  {
    if (parambi == null) {}
    while ((bl(parambi)) || ((parambi.getType() != 43) && (parambi.getType() != 44) && (parambi.getType() != 62))) {
      return false;
    }
    return true;
  }
  
  public static boolean bg(bi parambi)
  {
    if (parambi == null) {}
    while (parambi.getType() != 62) {
      return false;
    }
    return true;
  }
  
  public static boolean bh(bi parambi)
  {
    if (parambi == null) {}
    while (parambi.getType() != 49) {
      return false;
    }
    return true;
  }
  
  public static boolean bi(bi parambi)
  {
    if (parambi == null) {}
    while (parambi.getType() != 268435505) {
      return false;
    }
    return true;
  }
  
  public static b bk(bi parambi)
  {
    b localb = b.vun;
    if (parambi == null) {
      localb = b.vun;
    }
    if (bi(parambi)) {
      return b.vur;
    }
    if (be(parambi)) {
      return b.vuo;
    }
    if (bl(parambi)) {
      return b.vuq;
    }
    if (bf(parambi)) {
      return b.vup;
    }
    if (bg(parambi)) {
      return b.vup;
    }
    return b.vun;
  }
  
  private static boolean bl(bi parambi)
  {
    if (parambi != null)
    {
      parambi = u.oe(parambi.field_imgPath);
      if ((parambi != null) && (parambi.eHQ != null) && ((!bk.bl(parambi.eHQ.dSP)) || (parambi.eHQ.sWK > 0) || (!bk.bl(parambi.eHQ.dSS)) || (!bk.bl(parambi.eHQ.dST)) || (!bk.bl(parambi.eHQ.dSR)) || (!bk.bl(parambi.eHQ.dSU)) || (!bk.bl(parambi.eHQ.dSV)) || (!bk.bl(parambi.eHQ.dSW)))) {
        return true;
      }
    }
    return false;
  }
  
  public static String bo(bi parambi)
  {
    parambi = g.a.gp(parambi.field_content);
    if (parambi == null) {}
    do
    {
      do
      {
        return null;
      } while ((parambi.bFE == null) || (parambi.bFE.length() <= 0));
      parambi = ap.avh().VQ(parambi.bFE);
    } while (parambi == null);
    return parambi.field_fileFullPath;
  }
  
  public static boolean e(Context paramContext, List<bi> paramList)
  {
    boolean bool3 = true;
    boolean bool2;
    if ((paramContext == null) || (paramList == null) || (paramList.size() <= 0))
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1;
    label38:
    int i;
    label47:
    bi localbi;
    if (paramList.size() <= 1)
    {
      bool1 = true;
      paramList = paramList.iterator();
      i = 0;
      if (!paramList.hasNext()) {
        break label115;
      }
      localbi = (bi)paramList.next();
      if (!bf(localbi)) {
        break label103;
      }
      bool2 = a(paramContext, localbi, bool1);
      label84:
      if ((i != 0) || (!bool2)) {
        break label183;
      }
      i = 1;
    }
    label183:
    for (;;)
    {
      break label47;
      bool1 = false;
      break label38;
      label103:
      bool2 = b(paramContext, localbi, bool1);
      break label84;
      label115:
      if ((i == 0) && (!bool1))
      {
        Toast.makeText(paramContext, paramContext.getString(R.l.save_image_or_video_err), 1).show();
        return true;
      }
      bool2 = bool3;
      if (i == 0) {
        break;
      }
      bool2 = bool3;
      if (bool1) {
        break;
      }
      Toast.makeText(paramContext, paramContext.getString(R.l.exports_file_saved, new Object[] { com.tencent.mm.compatible.util.e.dzD }), 1).show();
      return true;
    }
  }
  
  public final bi GW(int paramInt)
  {
    return this.vtK.Hu(paramInt);
  }
  
  public final void Hk(int paramInt)
  {
    bi localbi = GW(paramInt);
    Object localObject = bk(localbi);
    switch (c.2.vtY[localObject.ordinal()])
    {
    default: 
      bn(localbi);
      return;
    case 1: 
    case 2: 
      bm(localbi);
      return;
    }
    localObject = bo(localbi);
    Intent localIntent = new Intent(this.vtJ, MsgRetransmitUI.class);
    localIntent.putExtra("Retr_File_Name", (String)localObject);
    localIntent.putExtra("Retr_Msg_Id", localbi.field_msgId);
    localIntent.putExtra("Retr_Msg_Type", 16);
    localIntent.putExtra("Retr_Msg_content", localbi.field_content);
    localIntent.putExtra("Retr_Compress_Type", 0);
    this.vtJ.startActivity(localIntent);
  }
  
  public final void Hl(int paramInt)
  {
    bi localbi = GW(paramInt);
    Object localObject = bk(localbi);
    switch (c.2.vtY[localObject.ordinal()])
    {
    case 3: 
    default: 
      return;
    }
    localObject = new Intent(this.vtJ, ChattingSendDataToDeviceUI.class);
    ((Intent)localObject).putExtra("Retr_Msg_Id", localbi.field_msgId);
    this.vtJ.startActivity((Intent)localObject);
  }
  
  public final void Hm(int paramInt)
  {
    bi localbi = GW(paramInt);
    cj localcj = new cj();
    com.tencent.mm.pluginsdk.model.e.a(localcj, localbi);
    localcj.bIw.activity = this.vtJ;
    localcj.bIw.bID = 44;
    com.tencent.mm.sdk.b.a.udP.m(localcj);
    if (localcj.bIx.ret == 0)
    {
      if (localbi.aRR()) {
        com.tencent.mm.ui.chatting.a.a(a.c.vgo, a.d.vgu, localbi, 0);
      }
      com.tencent.mm.modelstat.b.eBD.x(localbi);
    }
  }
  
  public final View Hn(int paramInt)
  {
    View localView3 = super.Gs(paramInt);
    if (localView3 == null) {
      y.e("MicroMsg.ImageGalleryAdapter", "position : %s getVideoViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
    }
    View localView1;
    do
    {
      return null;
      View localView2 = localView3.findViewById(R.h.video_containers);
      localView1 = localView2;
      if (localView2 == null) {
        localView1 = localView3.findViewById(R.h.video_container);
      }
    } while ((localView1 == null) || (localView1.getVisibility() == 8));
    return localView1;
  }
  
  public final void Ho(int paramInt)
  {
    this.vtP.g(GW(paramInt), paramInt);
  }
  
  public final void Hp(int paramInt)
  {
    this.vtP.h(GW(paramInt), paramInt);
  }
  
  public final void Hq(int paramInt)
  {
    this.vtP.Hj(paramInt);
  }
  
  public final void Hr(int paramInt)
  {
    bi localbi = GW(paramInt);
    if ((localbi == null) || (!be(localbi))) {
      return;
    }
    this.vtO.bu(localbi);
  }
  
  public final void Hs(int paramInt)
  {
    this.vtQ.Hy(paramInt);
  }
  
  public final void R(int paramInt)
  {
    if ((this.vtO != null) && (be(GW(paramInt)))) {
      this.vtO.vva.R(paramInt);
    }
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    super.a(paramViewGroup, paramInt, paramObject);
  }
  
  public final void a(bi parambi, com.tencent.mm.as.e parame, int paramInt, e.a parama)
  {
    if (parambi == null) {}
    while (this.vtU == null) {
      return;
    }
    this.vtU.uN().chh = parama;
    long l1 = parambi.field_msgSvrId;
    if (paramInt == 1) {}
    for (int i = 1; (this.vtU.cgZ != l1) && (this.vtU.chb != i); i = 0)
    {
      y.w("MicroMsg.ImageGalleryAdapter", "waiting img[%d] download finish but other img[%d] download finish callback don't report", new Object[] { Long.valueOf(this.vtU.cgZ), Long.valueOf(l1) });
      parambi = this.vtU;
      parambi.chh = e.a.chj;
      parambi.QX();
      return;
    }
    long l4 = 0L;
    long l5 = 0L;
    long l6 = 0L;
    long l7 = bk.UZ();
    long l3 = l6;
    long l2 = l5;
    l1 = l4;
    if (parama == e.a.chi)
    {
      parambi = e.d(parambi, parame);
      l3 = l6;
      l2 = l5;
      l1 = l4;
      if (!bk.bl(parambi))
      {
        l1 = com.tencent.mm.vfs.e.aeQ(parambi);
        parambi = e.adB(parambi);
        l3 = parambi.outWidth;
        l2 = parambi.outHeight;
      }
    }
    parambi = this.vtU;
    parambi.chc = l1;
    parambi.che = l2;
    parambi.chd = l3;
    this.vtU.QX();
    y.i("MicroMsg.ImageGalleryAdapter", "stopWaitingImg [%d] [%s]", new Object[] { Long.valueOf(bk.cp(l7)), this.vtU.uI() });
    this.vtU = null;
  }
  
  public final void as(int paramInt, boolean paramBoolean)
  {
    this.vtO.as(paramInt, paramBoolean);
  }
  
  public final boolean bj(bi parambi)
  {
    if (parambi == null) {}
    do
    {
      com.tencent.mm.as.e locale;
      do
      {
        return false;
        locale = h(parambi, false);
        if (locale == null) {
          break;
        }
      } while ((parambi == null) || (locale == null) || ((!com.tencent.mm.as.o.OK().a(locale.enp, parambi.field_msgId, 0)) && (!a(parambi, locale))));
      return true;
      parambi = j.bz(parambi);
    } while ((parambi == null) || (parambi == null));
    int i = parambi.status;
    int j = u.g(parambi);
    if (((i == 112) || (i == 122)) && (j < 100)) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.ImageGalleryAdapter", "it is video downloading %b, status %d, download progress %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      return bool;
    }
  }
  
  public final void bm(bi parambi)
  {
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.s.gM(this.vtJ);
      return;
    }
    com.tencent.mm.modelvideo.s locals = u.oe(parambi.field_imgPath);
    if (locals == null)
    {
      y.e("MicroMsg.ImageGalleryAdapter", "videoInfo should not be null");
      return;
    }
    Intent localIntent = new Intent(this.vtJ, MsgRetransmitUI.class);
    localIntent.putExtra("Retr_length", locals.eHH);
    localIntent.putExtra("Retr_File_Name", parambi.field_imgPath);
    localIntent.putExtra("Retr_video_isexport", locals.eHL);
    if (bg(parambi)) {}
    for (int i = 11;; i = 1)
    {
      localIntent.putExtra("Retr_Msg_Type", i);
      localIntent.putExtra("Retr_Msg_Id", parambi.field_msgId);
      localIntent.putExtra("Retr_From", "gallery");
      this.vtJ.startActivity(localIntent);
      return;
    }
  }
  
  public final void bn(bi parambi)
  {
    com.tencent.mm.as.e locale = e.bt(parambi);
    if ((parambi == null) || (parambi.field_msgId == 0L) || (locale == null) || (locale.enp == 0L))
    {
      localObject = new StringBuilder("doRestransmitMsg fail, msgLocalId = ");
      if (parambi == null)
      {
        parambi = "null";
        localObject = ((StringBuilder)localObject).append(parambi).append(", imgLocalId = ");
        if (locale != null) {
          break label99;
        }
      }
      label99:
      for (parambi = "null";; parambi = Long.valueOf(locale.enp))
      {
        y.e("MicroMsg.ImageGalleryAdapter", parambi);
        return;
        parambi = Long.valueOf(parambi.field_msgId);
        break;
      }
    }
    Object localObject = e.d(parambi, locale);
    if ((localObject == null) || (((String)localObject).length() == 0))
    {
      y.e("MicroMsg.ImageGalleryAdapter", "doRestransmitMsg fail, bigImgPath is null, msgLocalId = " + parambi.field_msgId + ", imgLocalId = " + locale.enp);
      return;
    }
    if (bk.bl(this.vtL))
    {
      y.i("MicroMsg.ImageGalleryAdapter", "directly send user is empty, select one");
      Intent localIntent = new Intent(this.vtJ, MsgRetransmitUI.class);
      localIntent.putExtra("Retr_File_Name", (String)localObject);
      localIntent.putExtra("Retr_Msg_Id", parambi.field_msgId);
      localIntent.putExtra("Retr_Msg_Type", 0);
      localIntent.putExtra("Retr_Compress_Type", b(parambi, locale));
      this.vtJ.startActivity(localIntent);
      return;
    }
    y.i("MicroMsg.ImageGalleryAdapter", "directly send user %s", new Object[] { this.vtL });
    int i;
    if (parambi.field_isSend == 1) {
      if (locale.Or())
      {
        i = 1;
        parambi = com.tencent.mm.model.q.Gj();
        localObject = com.tencent.mm.as.o.OJ().o(com.tencent.mm.as.f.c(locale), "", "");
        if (!bk.bl((String)localObject))
        {
          y.i("MicroMsg.ImageGalleryAdapter", "connector click[img]: to[%s] fileName[%s]", new Object[] { locale, localObject });
          parambi = new com.tencent.mm.as.l(parambi, this.vtL, (String)localObject, i);
          au.Dk().a(parambi, 0);
          bt.If().d(bt.dXD, null);
        }
        if (!this.vtM) {
          break label522;
        }
        parambi = new Intent(this.vtJ, ChattingUI.class);
        parambi.addFlags(67108864);
        parambi.putExtra("Chat_User", this.vtL);
        this.vtJ.startActivity(parambi);
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(10424, new Object[] { Integer.valueOf(3), Integer.valueOf(4), this.vtL });
      return;
      i = 0;
      break;
      if (!locale.Or())
      {
        i = 0;
        break;
      }
      parambi = com.tencent.mm.as.f.a(locale);
      if (!com.tencent.mm.vfs.e.bK(com.tencent.mm.as.o.OJ().o(parambi.enq, "", "")))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      label522:
      com.tencent.mm.ui.base.h.bC(this.vtJ, this.vtJ.getString(R.l.app_saved));
    }
  }
  
  public final View c(int paramInt, View paramView)
  {
    bi localbi = GW(paramInt);
    View localView;
    k localk;
    if (paramView == null)
    {
      localView = View.inflate(this.vtJ, R.i.image_gallery_item, null);
      localk = new k(this, localView);
      localView.setTag(localk);
      paramView = bk(localbi);
      localk.mPosition = paramInt;
      localk.vwY = paramView;
      k.X(localk.kKz, 0);
      switch (k.5.vtY[paramView.ordinal()])
      {
      default: 
        label104:
        k.X(localk.vxv, 8);
        k.X(localk.vxw, 8);
        k.X(localk.vxm, 8);
        k.X(localk.vxs, 8);
        k.X(localk.vxr, 8);
        y.d("MicroMsg.ImageGalleryAdapter", "position:%d, type: %s", new Object[] { Integer.valueOf(paramInt), paramView });
        switch (c.2.vtY[paramView.ordinal()])
        {
        }
        break;
      }
    }
    for (;;)
    {
      this.vtT = false;
      return localView;
      localk = (k)paramView.getTag();
      localView = paramView;
      break;
      k.X(localk.vxg, 8);
      k.X(localk.vxa, 8);
      break label104;
      localk.cGH();
      k.X(localk.vxg, 0);
      k.X(localk.vxa, 8);
      if (localk.vxa == null) {
        break label104;
      }
      k.X(localk.vxc, 8);
      break label104;
      localk.cGG();
      k.X(localk.vxg, 8);
      k.X(localk.vxa, 0);
      break label104;
      k.X(localk.kKz, 8);
      k.X(localk.vxg, 8);
      k.X(localk.vxa, 8);
      break label104;
      this.vtO.a(localk, localbi, paramInt);
      continue;
      k.X(localk.vxv, 0);
      k.X(localk.vxm, 8);
      k.X(localk.vxr, 8);
      k.X(localk.vxs, 8);
      k.X(localk.vxk, 8);
      String str = bo(localbi);
      try
      {
        paramView = x.ph(str);
        localObject = paramView;
        if (paramView == null)
        {
          localObject = x.pg(com.tencent.mm.as.o.OJ().F(localbi.field_imgPath, true));
          k.X(localk.vxr, 0);
          new ah().post(new c.1(this, localbi, localk, str));
        }
        if (localObject == null)
        {
          y.w("MicroMsg.ImageGalleryAdapter", "get image fail");
          localk.vxv.setVisibility(8);
          localk.cGF().vxs.setVisibility(0);
          localk.cGF().vxu.setImageResource(R.k.image_download_fail_icon);
          localk.cGF().vxt.setText(this.vtJ.getString(R.l.imgdownload_fail_or_cleaned));
        }
      }
      catch (OutOfMemoryError paramView)
      {
        Object localObject;
        for (;;)
        {
          y.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[] { str });
          Runtime.getRuntime().gc();
          Runtime.getRuntime().runFinalization();
          paramView = x.pg(str);
        }
        localk.vxv.setEnableHorLongBmpMode(false);
        com.tencent.mm.sdk.platformtools.k.o(localk.vxv, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        localk.vxv.fs(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
        localk.vxv.setImageBitmap((Bitmap)localObject);
        localk.vxv.invalidate();
      }
      continue;
      this.vtP.a(localk, localbi, paramInt);
      continue;
      this.vtQ.a(localk, localbi, paramInt);
    }
  }
  
  public final int cBh()
  {
    return 100000 - this.vtK.vua;
  }
  
  public final int cBi()
  {
    return 100000 - this.vtK.vua + this.vtK.dsw - 1;
  }
  
  public final void cFS()
  {
    this.vtK.cFS();
  }
  
  public final boolean cFT()
  {
    return this.vtK.prepared;
  }
  
  public final bi cFU()
  {
    return GW(this.vtJ.getCurrentItem());
  }
  
  public final k cFV()
  {
    Object localObject2 = this.vtO.Hi(this.vtJ.getCurrentItem());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.vtP.Hi(this.vtJ.getCurrentItem());
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.vtQ.Hi(this.vtJ.getCurrentItem());
    }
    return localObject2;
  }
  
  public final void cFW()
  {
    this.vtP.onResume();
  }
  
  public final void detach()
  {
    this.vtO.detach();
    this.vtP.detach();
    this.vtQ.detach();
    if (this.vtU != null)
    {
      com.tencent.mm.h.b.a.e locale = this.vtU.uN();
      locale.chh = e.a.chj;
      locale.QX();
    }
    super.detach();
  }
  
  public final int getCount()
  {
    c.a locala = this.vtK;
    return locala.dsw - locala.vua + 100000 + 1;
  }
  
  public final int getRealCount()
  {
    return this.vtK.dsw;
  }
  
  public final com.tencent.mm.as.e h(bi parambi, boolean paramBoolean)
  {
    return this.vtO.h(parambi, paramBoolean);
  }
  
  public final void i(bi parambi, boolean paramBoolean)
  {
    int i = 2;
    if (parambi == null) {
      return;
    }
    Object localObject = cFU();
    if ((localObject == null) || (((cs)localObject).field_msgId != parambi.field_msgId))
    {
      y.d("MicroMsg.ImageGalleryAdapter", "it is not curr msg[%d] handle nothing. arg msg[%d]", new Object[] { Long.valueOf(((cs)localObject).field_msgId), Long.valueOf(parambi.field_msgId) });
      return;
    }
    long l = parambi.field_msgSvrId;
    if ((this.vtU != null) && ((this.vtU.cgZ != l) || (this.vtU.chb != paramBoolean)))
    {
      localObject = this.vtU.uN();
      ((com.tencent.mm.h.b.a.e)localObject).chh = e.a.chj;
      ((com.tencent.mm.h.b.a.e)localObject).QX();
    }
    this.vtU = new com.tencent.mm.h.b.a.e();
    this.vtU.uM();
    localObject = this.vtU;
    ((com.tencent.mm.h.b.a.e)localObject).cgZ = l;
    ((com.tencent.mm.h.b.a.e)localObject).cha = parambi.field_createTime;
    ((com.tencent.mm.h.b.a.e)localObject).chb = paramBoolean;
    if (com.tencent.mm.model.s.fn(this.dmh)) {
      i = m.gM(this.dmh);
    }
    parambi = this.vtU;
    parambi.cgX = this.dmh;
    parambi.cgY = i;
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
  
  public final MultiTouchImageView rX(int paramInt)
  {
    View localView = super.Gs(paramInt);
    if (localView == null)
    {
      y.e("MicroMsg.ImageGalleryAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    localView = localView.findViewById(R.h.image);
    if ((localView == null) || (localView.getVisibility() == 8)) {
      return null;
    }
    return (MultiTouchImageView)localView;
  }
  
  public final WxImageView rY(int paramInt)
  {
    View localView = super.Gs(paramInt);
    if (localView == null) {
      return null;
    }
    localView = localView.findViewById(R.h.wx_image);
    if ((localView == null) || (localView.getVisibility() == 8)) {
      return null;
    }
    return (WxImageView)localView;
  }
  
  public static enum b
  {
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c
 * JD-Core Version:    0.7.0.1
 */