package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.m;
import com.tencent.mm.g.b.a.jc;
import com.tencent.mm.g.b.a.x.a;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImageOptimLib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.al.a;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends a
  implements com.tencent.mm.av.e.a, e.a
{
  private static boolean PxT;
  private static long PxU;
  private HashMap<String, WeakReference<Bitmap>> JeH;
  private IListener PxN;
  n PxO;
  public HashMap<Long, Integer> PxP;
  public final e PxQ;
  private HashMap<ca, String> PxR;
  private HashMap<ca, String> PxS;
  private long PxV;
  int mScrollState;
  
  static
  {
    AppMethodBeat.i(36048);
    PxT = true;
    PxU = (Runtime.getRuntime().maxMemory() * 0.05D);
    AppMethodBeat.o(36048);
  }
  
  public d(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36007);
    this.PxP = new HashMap();
    this.PxQ = new e(this);
    this.JeH = new HashMap();
    this.PxR = new HashMap();
    this.PxS = new HashMap();
    this.PxV = 0L;
    this.mScrollState = 0;
    EventCenter localEventCenter = EventCenter.instance;
    paramb = new al(al.a.Pkl, paramb.Pwv);
    this.PxN = paramb;
    localEventCenter.addListener(paramb);
    paramb = g.a.Pyr.xqj.snapshot();
    this.PxQ.cg(paramb);
    l.gTf().PBn = this;
    AppMethodBeat.o(36007);
  }
  
  public static String a(ca paramca, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(36033);
    paramca = a(paramca, paramg, false);
    AppMethodBeat.o(36033);
    return paramca;
  }
  
  private static String a(ca paramca, com.tencent.mm.av.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(36034);
    if (paramca.field_isSend == 1)
    {
      paramca = com.tencent.mm.av.q.bcR().a(paramca.field_talker, paramg);
      str = com.tencent.mm.av.q.bcR().o(paramca, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", new Object[] { paramca, str });
      if (s.YS(str))
      {
        AppMethodBeat.o(36034);
        return str;
      }
      paramca = paramg.iXm;
      paramg = com.tencent.mm.av.q.bcR().o(paramca, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", new Object[] { paramca, paramg });
      if (s.YS(paramg))
      {
        AppMethodBeat.o(36034);
        return paramg;
      }
      AppMethodBeat.o(36034);
      return null;
    }
    if ((!paramBoolean) && (!paramg.bcu()))
    {
      Log.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(paramg.bcu()) });
      AppMethodBeat.o(36034);
      return null;
    }
    String str = paramg.iXm;
    if (paramg.bcv())
    {
      paramca = com.tencent.mm.av.q.bcR().a(paramca.field_talker, paramg);
      if (paramca != null)
      {
        paramca = com.tencent.mm.av.q.bcR().o(paramca, "", "");
        if (s.YS(paramca)) {
          Log.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      paramg = paramca;
      if (paramca == null) {
        paramg = com.tencent.mm.av.q.bcR().o(str, "", "");
      }
      Log.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[] { paramg });
      AppMethodBeat.o(36034);
      return paramg;
      paramca = null;
    }
  }
  
  @TargetApi(11)
  private void a(long paramLong, MultiTouchImageView paramMultiTouchImageView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(233294);
    if ((this.Pwu == null) || (this.Pwu.Pwv == null))
    {
      AppMethodBeat.o(233294);
      return;
    }
    Log.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), Integer.valueOf(paramBitmap.hashCode()) });
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.setEnableHorLongBmpMode(false);
      paramMultiTouchImageView.cN(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(null);
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.invalidate();
      if (this.PxO != null) {
        this.PxO.b(paramLong, paramMultiTouchImageView, paramString, paramBitmap);
      }
      AppMethodBeat.o(233294);
      return;
      ForceGpuUtil.decideLayerType((View)paramMultiTouchImageView.getParent(), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  private static void a(ca paramca, k paramk, int paramInt)
  {
    AppMethodBeat.i(36019);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = com.tencent.mm.av.q.bcR().R(paramca.field_imgPath, true);
    k.ai(paramk.PAY, 8);
    k.ai(paramk.PAT, 8);
    k.ai(paramk.PBc, 8);
    k.ai(paramk.PBd, 8);
    paramk.gTc().PAZ.setVisibility(0);
    paramk.gTc().PBb.setImageResource(2131690954);
    if ((str == null) || (!s.YS(str)))
    {
      paramk.gTc().PBa.setText(2131761769);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramInt == 6)
    {
      paramk.gTc().PBa.setText(2131761767);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramca.gDB())
    {
      paramk.gTc().PBa.setText(2131761765);
      AppMethodBeat.o(36019);
      return;
    }
    paramk.gTc().PBa.setText(2131761766);
    AppMethodBeat.o(36019);
  }
  
  private static void a(ca paramca, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36039);
    Log.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
    b.c(MMApplicationContext.getContext(), paramca, paramBoolean);
    AppMethodBeat.o(36039);
  }
  
  private void a(k paramk, ca paramca, com.tencent.mm.av.g paramg, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36017);
    a(paramk, paramca, paramg, paramBoolean, true, paramInt);
    AppMethodBeat.o(36017);
  }
  
  private void a(k paramk, ca paramca, com.tencent.mm.av.g paramg, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(36018);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(paramBoolean1)));
    k.ai(paramk.PAZ, 8);
    String str1 = null;
    if (!paramBoolean1) {
      paramk.PBc.setVisibility(0);
    }
    com.tencent.mm.av.g localg = com.tencent.mm.av.h.a(paramg);
    if ((paramBoolean1) && (paramInt == this.Pwu.Pwv.getCurrentItem())) {
      this.Pwu.Pwv.gST();
    }
    if (paramBoolean1) {
      str1 = a(paramca, paramg, true);
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1)) {
      str2 = com.tencent.mm.av.q.bcR().o(localg.iXo, "", "");
    }
    str1 = com.tencent.mm.av.q.bcR().R(paramca.field_imgPath, true);
    if (paramBoolean2) {
      a(paramk, str1, str2, paramca);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = paramg.iKP;
      int i = paramg.offset;
      if (paramInt == 0) {
        break label258;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label264;
      }
      paramk.gTb().PAY.setVisibility(8);
    }
    for (;;)
    {
      paramk.gTb().PAW.setVisibility(8);
      paramk.gTb().PAV.setVisibility(8);
      paramk.gTb().PAU.setVisibility(8);
      AppMethodBeat.o(36018);
      return;
      label258:
      l = 0L;
      break;
      label264:
      paramk.gTb().PAY.setVisibility(0);
    }
  }
  
  private static void a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    AppMethodBeat.i(36026);
    Object localObject;
    int i;
    if (paramk != null) {
      if (paramk.PBd != null)
      {
        localObject = paramk.PBd;
        if (!paramBoolean1) {
          break label92;
        }
        i = 0;
        ((WxImageView)localObject).setVisibility(i);
        if (!paramBoolean1) {
          break label98;
        }
      }
    }
    label92:
    label98:
    for (paramk.PBe = true;; paramk.PBe = false)
    {
      if (paramk.PBc != null)
      {
        localObject = paramk.PBc;
        i = j;
        if (paramBoolean2) {
          i = 0;
        }
        ((MultiTouchImageView)localObject).setVisibility(i);
        if (paramBoolean2) {
          paramk.PBe = false;
        }
      }
      AppMethodBeat.o(36026);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, int paramInt, ca paramca, k paramk)
  {
    AppMethodBeat.i(36024);
    boolean bool = a(true, paramMultiTouchImageView, paramString1, paramString2, false, paramInt, paramca, paramk, null, false);
    AppMethodBeat.o(36024);
    return bool;
  }
  
  private boolean a(k paramk, ca paramca, com.tencent.mm.av.g paramg, int paramInt)
  {
    AppMethodBeat.i(36016);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = d(paramca, paramg);
    k.ai(paramk.PAY, 8);
    String str1 = (String)this.PxS.get(paramca);
    paramg = str1;
    if (str1 == null)
    {
      paramg = com.tencent.mm.av.q.bcR().R(paramca.field_imgPath, true);
      this.PxS.put(paramca, paramg);
    }
    boolean bool = a(paramk, paramg, str2, paramca);
    if ((paramInt == this.Pwu.Pwv.getCurrentItem()) && (this.Pwu.Pwz))
    {
      this.Pwu.cu(paramca);
      this.Pwu.Pwz = false;
    }
    AppMethodBeat.o(36016);
    return bool;
  }
  
  private boolean a(k paramk, String paramString1, String paramString2, ca paramca)
  {
    AppMethodBeat.i(36020);
    boolean bool = b(paramk, paramString1, paramString2, paramca);
    AppMethodBeat.o(36020);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, final int paramInt, final ca paramca, final k paramk, com.tencent.mm.av.g paramg, boolean paramBoolean3)
  {
    AppMethodBeat.i(36025);
    Log.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt) });
    Object localObject2 = null;
    boolean bool1 = true;
    if ((paramString2 != null) && (s.YS(paramString2))) {
      localObject2 = s.k(paramString2, false);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramString1 != null)
        {
          localObject1 = localObject2;
          if (s.YS(paramString1))
          {
            localObject1 = s.k(paramString1, false);
            if (s.YS(paramString1 + "hd")) {
              localObject1 = s.k(paramString1 + "hd", false);
            }
          }
        }
      }
      if (localObject1 != null) {
        break;
      }
      Log.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", new Object[] { paramString2 });
      AppMethodBeat.o(36025);
      return false;
      bool1 = false;
    }
    if (paramk == null)
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
      AppMethodBeat.o(36025);
      return false;
    }
    int i;
    label285:
    boolean bool2;
    if ((!((String)localObject1).equals(paramString1)) && (!paramBoolean3) && (bmU((String)localObject1)))
    {
      paramBoolean3 = true;
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", new Object[] { Boolean.valueOf(paramBoolean3), localObject1 });
      if ((paramk.PBd == null) || (paramk.PBd.getVisibility() != 0)) {
        break label406;
      }
      i = 1;
      if ((!paramBoolean3) || (i != 0)) {
        break label412;
      }
      bool2 = true;
      label298:
      if ((paramBoolean3) || (paramBoolean2) || (!this.PxQ.xqj.check(localObject1))) {
        break label424;
      }
      localObject2 = (Bitmap)this.PxQ.xqj.aT(localObject1);
      if (((Bitmap)localObject2).isRecycled()) {
        break label424;
      }
      Log.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[] { localObject1 });
      if (paramca == null) {
        break label418;
      }
    }
    label406:
    label412:
    label418:
    for (long l = paramca.field_msgId;; l = 0L)
    {
      a(l, paramMultiTouchImageView, (String)localObject1, (Bitmap)localObject2);
      AppMethodBeat.o(36025);
      return true;
      paramBoolean3 = false;
      break;
      i = 0;
      break label285;
      bool2 = false;
      break label298;
    }
    label424:
    if (paramBoolean1) {
      paramMultiTouchImageView.setImageBitmap(null);
    }
    localObject2 = paramg;
    if (paramBoolean3)
    {
      if (paramk.PBd == null)
      {
        AppMethodBeat.o(36025);
        return false;
      }
      localObject2 = paramg;
      if (paramg == null) {
        localObject2 = i(paramca, true);
      }
      paramk.PBd.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
      {
        public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36000);
          Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          AppMethodBeat.o(36000);
        }
        
        public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36001);
          Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          com.tencent.mm.cq.c.aqq(paramAnonymousc.errCode);
          d.a(d.this, this.PxW, paramk, paramInt);
          if (paramAnonymousc.errCode == 4) {
            d.gSn();
          }
          AppMethodBeat.o(36001);
        }
        
        public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36002);
          Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          d.a(paramca, paramk);
          AppMethodBeat.o(36002);
        }
        
        public final void n(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(35999);
          int i;
          if ((paramAnonymousBitmap != null) && (d.this.PxQ != null))
          {
            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[] { this.PxW });
            e locale = d.this.PxQ;
            if (paramInt > 0)
            {
              i = paramInt;
              locale.e(i, paramAnonymousBitmap);
            }
          }
          else
          {
            d.a(paramk);
            if (d.a(d.this) != null) {
              if (paramca == null) {
                break label139;
              }
            }
          }
          label139:
          for (long l = paramca.field_msgId;; l = 0L)
          {
            d.a(d.this).b(l, paramk.PBd, this.PxW, paramAnonymousBitmap);
            AppMethodBeat.o(35999);
            return;
            i = paramk.mPosition;
            break;
          }
        }
        
        public final void sb()
        {
          AppMethodBeat.i(35998);
          Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
          AppMethodBeat.o(35998);
        }
        
        public final void sc() {}
      });
    }
    if (!this.Pwu.PwG)
    {
      if (paramInt >= 0)
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[] { Integer.valueOf(paramInt) });
        a(paramk, false, true);
        this.PxQ.c(paramMultiTouchImageView, paramInt);
      }
      if (!paramBoolean3) {
        break label784;
      }
      a(paramk, true, bool2);
      paramMultiTouchImageView = e(paramca, (com.tencent.mm.av.g)localObject2);
      paramString1 = this.PxQ;
      paramString2 = paramk.PBd;
      i = paramInt;
      if (paramInt < 0) {
        i = paramk.mPosition;
      }
      paramString1.b(paramString2, (String)localObject1, paramMultiTouchImageView, i);
    }
    for (;;)
    {
      AppMethodBeat.o(36025);
      return bool1;
      if (paramBoolean3)
      {
        paramMultiTouchImageView = e(paramca, (com.tencent.mm.av.g)localObject2);
        a(paramk, true, bool2);
        paramString1 = paramk.PBd;
        if (paramMultiTouchImageView != null) {}
        for (paramMultiTouchImageView = com.davemorrissey.labs.subscaleview.view.a.aP(paramMultiTouchImageView);; paramMultiTouchImageView = null)
        {
          a(paramString1, (String)localObject1, paramMultiTouchImageView);
          AppMethodBeat.o(36025);
          return bool1;
        }
      }
      Bitmap localBitmap = bmW((String)localObject1);
      paramg = localBitmap;
      if (localBitmap == null) {
        paramg = bmW(paramString1);
      }
      if (paramg == null) {
        break;
      }
      a(paramk, false, true);
      if (paramca != null) {}
      for (l = paramca.field_msgId;; l = 0L)
      {
        a(l, paramMultiTouchImageView, (String)localObject1, paramg);
        if (((String)localObject1).equals(paramString2))
        {
          this.PxQ.w((String)localObject1, paramg);
          this.PxQ.e(paramInt, paramg);
        }
        AppMethodBeat.o(36025);
        return bool1;
      }
      label784:
      a(paramk, false, true);
      paramString1 = this.PxQ;
      i = paramInt;
      if (paramInt < 0) {
        i = paramk.mPosition;
      }
      paramString1.f(paramMultiTouchImageView, (String)localObject1, i);
    }
  }
  
  private static Bitmap aT(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36030);
    String str = paramString + "_tmp.jpg";
    try
    {
      bool1 = com.tencent.mm.compatible.util.d.oE(16);
      if (bool1)
      {
        AppMethodBeat.o(36030);
        return null;
      }
      bool1 = CrashReportFactory.hasDebuger();
      if (!bool1) {
        try
        {
          i = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("UseOptImageRecv"), 0);
          bg.aVF();
          com.tencent.mm.b.p localp = new com.tencent.mm.b.p(com.tencent.mm.model.c.getUin());
          Log.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Integer.valueOf(i), Long.valueOf(localp.longValue()), Long.valueOf(localp.longValue() / 100L), Boolean.valueOf(CrashReportFactory.hasDebuger()), Integer.valueOf(Build.VERSION.SDK_INT) });
          j = (int)(localp.longValue() / 100L);
          if (j % 100 + 1 > i)
          {
            AppMethodBeat.o(36030);
            return null;
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[] { Util.stackTraceToString(localException) });
          AppMethodBeat.o(36030);
          return null;
        }
      }
      s.boN(s.boZ(str));
      s.nw(paramString, str);
      bool1 = MMNativeJpeg.IsJpegFile(str);
      bool2 = MMNativeJpeg.isProgressive(str);
      bool3 = ImageOptimLib.checkIntegrity(str);
      j = (int)s.boW(str);
      if ((!bool1) || (!bool2)) {
        break label442;
      }
      if (!bool3) {
        break label436;
      }
      localBitmap1 = MMNativeJpeg.decodeAsBitmap(str);
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        boolean bool1;
        int i;
        int j;
        boolean bool2;
        boolean bool3;
        Bitmap localBitmap1;
        localBitmap2 = null;
        Log.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[] { paramString, Util.stackTraceToString(localThrowable1) });
        localObject1 = localBitmap2;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = null;
      }
    }
    if (localBitmap1 != null) {}
    for (i = j;; i = 0 - j)
    {
      Bitmap localBitmap2 = localBitmap1;
      try
      {
        d.a.t(paramString, paramInt2, paramInt1, i);
        localBitmap2 = localBitmap1;
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localBitmap1, paramString });
        s.deleteFile(str);
        AppMethodBeat.o(36030);
        return localBitmap1;
      }
      catch (Throwable localThrowable2)
      {
        Object localObject1;
        break;
      }
    }
  }
  
  public static boolean amZ(int paramInt)
  {
    return paramInt == 1;
  }
  
  private void ap(long paramLong, int paramInt)
  {
    AppMethodBeat.i(36011);
    this.PxP.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(36011);
  }
  
  private boolean b(k paramk, String paramString1, String paramString2, ca paramca)
  {
    AppMethodBeat.i(36021);
    k.ai(paramk.PBc, 0);
    k.ai(paramk.PAT, 8);
    k.ai(paramk.PAY, 8);
    k.ai(paramk.PAZ, 8);
    boolean bool = a(paramk.PBc, paramString1, paramString2, paramk.mPosition, paramca, paramk);
    AppMethodBeat.o(36021);
    return bool;
  }
  
  protected static BitmapFactory.Options bmT(String paramString)
  {
    AppMethodBeat.i(36022);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    paramString = MMBitmapFactory.decodeFile(paramString, localOptions);
    if (paramString != null) {
      paramString.recycle();
    }
    AppMethodBeat.o(36022);
    return localOptions;
  }
  
  private boolean bmU(String paramString)
  {
    AppMethodBeat.i(36023);
    if (!PxT)
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
      AppMethodBeat.o(36023);
      return false;
    }
    if (br.D(this.Pwu.gSg()))
    {
      AppMethodBeat.o(36023);
      return false;
    }
    boolean bool = com.tencent.mm.cq.b.adl(paramString);
    AppMethodBeat.o(36023);
    return bool;
  }
  
  private static Bitmap bmW(String paramString)
  {
    AppMethodBeat.i(36031);
    if (paramString == null)
    {
      AppMethodBeat.o(36031);
      return null;
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    Object localObject3 = MMBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    if (localObject3 != null)
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localObject3.toString() });
      ((Bitmap)localObject3).recycle();
    }
    int i2 = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString);
    int i1 = ((BitmapFactory.Options)localObject1).outWidth;
    int n = ((BitmapFactory.Options)localObject1).outHeight;
    int k = n;
    int m = i1;
    for (;;)
    {
      try
      {
        long l1 = Math.max(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - PxU, 0L);
        k = n;
        m = i1;
        i = ((BitmapFactory.Options)localObject1).outHeight;
        k = n;
        m = i1;
        long l2 = ((BitmapFactory.Options)localObject1).outWidth * i * 4;
        k = n;
        m = i1;
        Log.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        j = n;
        i = i1;
        if (l1 < l2)
        {
          k = n;
          m = i1;
          double d = Math.sqrt(l1 / l2);
          k = n;
          m = i1;
          Log.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", new Object[] { Double.valueOf(d) });
          i = (int)(i1 * d);
          j = (int)(n * d);
        }
        k = j;
        m = i;
        localObject3 = aT(paramString, j, i);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          k = j;
          m = i;
          localObject1 = BitmapUtil.getBitmapNative(paramString, i, j, 0.0F);
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = localObject1;
          k = j;
          m = i;
          if (MMNativeJpeg.IsJpegFile(paramString))
          {
            localObject3 = localObject1;
            k = j;
            m = i;
            if (MMNativeJpeg.isProgressive(paramString))
            {
              k = j;
              m = i;
              localObject3 = MMNativeJpeg.decodeAsBitmap(paramString);
              if (localObject3 != null) {
                continue;
              }
              bool = true;
              k = j;
              m = i;
              Log.i("MicroMsg.ImageGalleryHolderImage", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
            }
          }
        }
        localObject1 = localObject3;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        boolean bool;
        Log.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", localOutOfMemoryError, "hy: out of memory! try use fallback bitmap", new Object[0]);
        Object localObject2 = MMApplicationContext.getContext();
        if (localObject2 != null) {
          continue;
        }
        int i = 0;
        localObject2 = MMApplicationContext.getContext();
        if (localObject2 != null) {
          continue;
        }
        int j = 0;
        localObject2 = e(paramString, m, k, i, j);
        continue;
        i = ((Context)localObject2).getResources().getDisplayMetrics().widthPixels;
        continue;
        j = ((Context)localObject2).getResources().getDisplayMetrics().heightPixels;
        continue;
        paramString = BitmapUtil.rotate((Bitmap)localObject2, i2);
        if ((paramString != localObject2) || (i2 % 360 == 0)) {
          continue;
        }
        Log.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[] { Integer.valueOf(i2) });
        AppMethodBeat.o(36031);
        return null;
        AppMethodBeat.o(36031);
      }
      if (localObject1 != null) {
        continue;
      }
      Log.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(36031);
      return null;
      bool = false;
    }
    return paramString;
  }
  
  private int d(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(36038);
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      paramObject = this.Pwu.amt(i);
      if ((paramObject != null) && (paramObject.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    paramObject = this.Pwu.OUz.values().iterator();
    while (paramObject.hasNext())
    {
      i = ((Integer)paramObject.next()).intValue();
      ca localca = this.Pwu.amt(i);
      if ((localca != null) && (localca.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    AppMethodBeat.o(36038);
    return -1;
  }
  
  private String d(ca paramca, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(36015);
    String str2 = (String)this.PxR.get(paramca);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(paramca, paramg, false);
      if ((str1 == null) || (str1.length() == 0))
      {
        AppMethodBeat.o(36015);
        return null;
      }
      this.PxR.put(paramca, str1);
    }
    AppMethodBeat.o(36015);
    return str1;
  }
  
  private static Bitmap e(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(36032);
    Log.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
    paramInt1 *= paramInt2;
    paramInt2 = paramInt3 * paramInt4;
    Log.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2) {}
    try
    {
      paramString = BitmapUtil.getBitmapNative(paramString, paramInt3, paramInt4, 0.0F);
      AppMethodBeat.o(36032);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      Log.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramString, "hy: oom in fallback bitmap!", new Object[0]);
      AppMethodBeat.o(36032);
    }
    Log.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
    AppMethodBeat.o(36032);
    return null;
    return null;
  }
  
  private static String e(ca paramca, com.tencent.mm.av.g paramg)
  {
    AppMethodBeat.i(36035);
    if ((paramca == null) || (paramg == null))
    {
      AppMethodBeat.o(36035);
      return null;
    }
    if (paramca.field_isSend == 1)
    {
      paramca = paramg.iXo;
      paramg = com.tencent.mm.av.q.bcR().o(paramca, "", "") + "hd";
      Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { paramca, paramg });
      if ((!Util.isNullOrNil(paramg)) && (s.YS(paramg)))
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
        AppMethodBeat.o(36035);
        return paramg;
      }
      paramg = com.tencent.mm.av.q.bcR().o(paramca, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", new Object[] { paramca, paramg });
      if ((!Util.isNullOrNil(paramg)) && (s.YS(paramg)))
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
        AppMethodBeat.o(36035);
        return paramg;
      }
      AppMethodBeat.o(36035);
      return null;
    }
    if (!paramg.bcu())
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
      AppMethodBeat.o(36035);
      return null;
    }
    paramca = paramg.iXo;
    paramg = com.tencent.mm.av.q.bcR().o(paramca, "", "") + "hd";
    Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { paramca, paramg });
    if ((!Util.isNullOrNil(paramg)) && (s.YS(paramg)))
    {
      Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
      AppMethodBeat.o(36035);
      return paramg;
    }
    AppMethodBeat.o(36035);
    return null;
  }
  
  public static void gSn()
  {
    PxT = false;
  }
  
  private void h(ca paramca, int paramInt)
  {
    AppMethodBeat.i(36010);
    this.PxP.put(Long.valueOf(paramca.field_msgId), Integer.valueOf(paramInt));
    AppMethodBeat.o(36010);
  }
  
  public static com.tencent.mm.av.g k(ca paramca)
  {
    AppMethodBeat.i(36013);
    if (!b.j(paramca))
    {
      AppMethodBeat.o(36013);
      return null;
    }
    long l;
    com.tencent.mm.av.g localg1;
    if (paramca.field_isSend == 1)
    {
      l = paramca.field_msgId;
      com.tencent.mm.av.g localg2 = com.tencent.mm.av.q.bcR().H(paramca.field_talker, l);
      localg1 = localg2;
      if (localg2.localId != 0L) {}
    }
    else
    {
      l = paramca.field_msgSvrId;
      localg1 = com.tencent.mm.av.q.bcR().G(paramca.field_talker, l);
    }
    AppMethodBeat.o(36013);
    return localg1;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36040);
    if (!(paramObject instanceof Integer))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
      AppMethodBeat.o(36040);
      return;
    }
    Log.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos ".concat(String.valueOf(((Integer)paramObject).intValue())), new Object[0]);
    AppMethodBeat.o(36040);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(36036);
    if ((this.Pwu == null) || (this.Pwu.Pwv == null))
    {
      AppMethodBeat.o(36036);
      return;
    }
    if (this.mScrollState != 0)
    {
      AppMethodBeat.o(36036);
      return;
    }
    int i;
    if (l.gTf().NS(paramLong2))
    {
      i = d(paramLong2, paramObject);
      if (i == -1)
      {
        AppMethodBeat.o(36036);
        return;
      }
      paramObject = Integer.valueOf(i);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        Log.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(36036);
        return;
      }
      i = ((Integer)paramObject).intValue();
      Log.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1) });
      if (i == -1)
      {
        Log.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
        AppMethodBeat.o(36036);
        return;
      }
      if (this.Pwu.abm(i) == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      paramObject = (k)this.Pwu.abm(i).getTag();
      if (paramObject == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.Pwu.Pwv.getCurrentItem()) && (amZ(paramInt1)))
        {
          Log.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.Pwu.Pwv.ani(paramInt2);
        }
        paramq = (m)paramq;
        boolean bool1 = MMNativeJpeg.isProgressive(paramq.iYV);
        boolean bool2 = paramq.iYX;
        paramLong1 = Util.ticksToNow(this.PxV);
        d.a.hf(paramq.iYV, paramInt4);
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramq.iYV });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break label679;
        }
        this.PxV = Util.currentTicks();
        paramq = this.Pwu.amt(i);
        if (paramq == null)
        {
          Log.e("MicroMsg.ImageGalleryHolderImage", "msg is null! pos:%s", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(36036);
        }
      }
      else
      {
        if (paramInt4 != 0) {}
        for (float f = paramInt3 / paramInt4 * 100.0F - 1.0F;; f = 0.0F)
        {
          paramInt2 = (int)f;
          break;
        }
      }
      com.tencent.mm.av.g localg = i(paramq, true);
      if (a(false, paramObject.PBc, com.tencent.mm.av.q.bcR().R(paramq.field_imgPath, true), a(paramq, localg, true), true, -1, paramq, paramObject, localg, true))
      {
        k.ai(paramObject.PAW, 8);
        k.ai(paramObject.PAZ, 8);
        if ((i == this.Pwu.Pwv.getCurrentItem()) && (!amZ(paramInt1))) {
          if (paramInt2 > 50)
          {
            k.ai(paramObject.PAY, 8);
            if (this.Pwu != null)
            {
              this.Pwu.a(paramq, localg, paramInt1, x.a.emW);
              AppMethodBeat.o(36036);
            }
          }
          else
          {
            k.ai(paramObject.PAY, 0);
          }
        }
      }
      label679:
      AppMethodBeat.o(36036);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, final int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(36037);
    if ((this.Pwu == null) || (this.Pwu.Pwv == null))
    {
      AppMethodBeat.o(36037);
      return;
    }
    if (l.gTf().NS(paramLong2))
    {
      paramInt2 = d(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        bg.aVF();
        a(com.tencent.mm.model.c.aSQ().Hb(paramLong2), "background", false);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = Integer.valueOf(paramInt2);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        Log.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(36037);
        return;
      }
      paramInt2 = ((Integer)paramObject).intValue();
      Log.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = ".concat(String.valueOf(paramInt2)));
      if (paramInt2 == -1)
      {
        Log.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 3L, 1L, true);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = null;
      if (this.Pwu.abm(paramInt2) != null) {
        paramObject = (k)this.Pwu.abm(paramInt2).getTag();
      }
      boolean bool = l.gTf().NS(paramLong2);
      if ((paramInt3 != 0) || (paramInt4 != 0))
      {
        if (bool)
        {
          paramObject = this.Pwu.amt(paramInt2);
          paramString = "hd_failed:".concat(String.valueOf(paramInt2));
          if (paramInt2 == this.Pwu.Pwv.getCurrentItem())
          {
            bool = true;
            a(paramObject, paramString, bool);
          }
        }
        else
        {
          if (paramInt4 != -5103059) {
            break label394;
          }
          ap(paramLong2, 5);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 0L, 1L, true);
        }
        for (;;)
        {
          Log.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
          this.Pwu.PwA.amN(paramInt2);
          if (this.Pwu != null) {
            this.Pwu.a(this.Pwu.amt(paramInt2), null, paramInt1, x.a.emY);
          }
          AppMethodBeat.o(36037);
          return;
          bool = false;
          break;
          label394:
          ap(paramLong2, 6);
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 1L, 1L, true);
        }
      }
      if (bool)
      {
        paramString = this.Pwu.amt(paramInt2);
        paramq = "hd_suc:".concat(String.valueOf(paramInt2));
        if (paramInt2 != this.Pwu.Pwv.getCurrentItem()) {
          break label561;
        }
      }
      label561:
      for (bool = true;; bool = false)
      {
        a(paramString, paramq, bool);
        Log.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.Pwu.Pwv.getCurrentItem(), new Object[0]);
        ap(paramLong2, 4);
        paramString = this.Pwu.amt(paramInt2);
        paramq = i(paramString, true);
        if ((paramString != null) && (paramq != null)) {
          break;
        }
        AppMethodBeat.o(36037);
        return;
      }
      if (this.PxO != null) {
        this.PxO.ar(paramString.field_msgId, paramInt1);
      }
      if (paramObject != null)
      {
        if (paramInt2 == this.Pwu.Pwv.getCurrentItem())
        {
          if (!amZ(paramInt1)) {
            break label866;
          }
          ImageGalleryUI localImageGalleryUI = this.Pwu.Pwv;
          localImageGalleryUI.gSF();
          localImageGalleryUI.gSF();
          Animation localAnimation = ImageGalleryUI.anh(1000);
          localAnimation.setAnimationListener(new ImageGalleryUI.38(localImageGalleryUI));
          localImageGalleryUI.cWV();
          localImageGalleryUI.gSq().PyT.setVisibility(0);
          localImageGalleryUI.gSq().PyU.setVisibility(8);
          localImageGalleryUI.gSq().PyV.setVisibility(8);
          localImageGalleryUI.gSq().PyW.setVisibility(0);
          localImageGalleryUI.gSq().PyW.startAnimation(localAnimation);
        }
        while (a(false, paramObject.PBc, com.tencent.mm.av.q.bcR().R(paramString.field_imgPath, true), a(paramString, paramq, true), true, -1, paramString, paramObject, paramq, false))
        {
          k.ai(paramObject.PAT, 8);
          k.ai(paramObject.PAY, 8);
          k.ai(paramObject.PAZ, 8);
          if ((cy(paramString) == 4) && (this.Pwu.Pwz))
          {
            this.Pwu.cu(paramString);
            this.Pwu.Pwz = false;
          }
          if (this.Pwu == null) {
            break label910;
          }
          this.Pwu.a(paramString, paramq, paramInt1, x.a.emW);
          AppMethodBeat.o(36037);
          return;
          label866:
          paramObject.PBc.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36003);
              if ((d.this.Pwu == null) || (d.this.Pwu.Pwv == null))
              {
                AppMethodBeat.o(36003);
                return;
              }
              d.this.Pwu.Pwv.and(paramInt2);
              AppMethodBeat.o(36003);
            }
          });
        }
        Log.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 2L, 1L, true);
      }
      label910:
      AppMethodBeat.o(36037);
      return;
    }
  }
  
  public final void a(long paramLong, View paramView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(233291);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(233291);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.hashCode();
      int j = paramBitmap.hashCode();
      int k = this.PxQ.xqk.indexOfValue(i);
      if (k >= 0) {
        this.PxQ.xqk.removeAt(k);
      }
      this.PxQ.xqk.put(j, i);
      if ((paramView instanceof MultiTouchImageView))
      {
        a(paramLong, (MultiTouchImageView)paramView, paramString, paramBitmap);
        AppMethodBeat.o(233291);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageBitmap(paramBitmap);
      }
    }
    AppMethodBeat.o(233291);
  }
  
  public final void a(WxImageView paramWxImageView, String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(36029);
    BitmapFactory.Options localOptions = bmT(paramString);
    paramWxImageView.setOrientation(BackwardSupportUtil.ExifHelper.getExifOrientation(paramString));
    paramWxImageView.cN(localOptions.outWidth, localOptions.outHeight);
    paramWxImageView.gKy();
    paramWxImageView.a(paramString, parama);
    AppMethodBeat.o(36029);
  }
  
  public final boolean a(k paramk, ca paramca, int paramInt)
  {
    AppMethodBeat.i(36012);
    super.a(paramk, paramca, paramInt);
    if ((paramk == null) || (paramca == null) || (paramInt < 0))
    {
      AppMethodBeat.o(36012);
      return false;
    }
    i = cy(paramca);
    Log.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", new Object[] { Integer.valueOf(paramk.PBc.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(i) });
    k.ai(paramk.PAT, 8);
    try
    {
      com.tencent.mm.av.g localg1 = i(paramca, false);
      if (localg1 != null) {
        break label184;
      }
      bool1 = false;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", localNullPointerException, "", new Object[0]);
        boolean bool1 = false;
        continue;
        if (paramca.gDB())
        {
          bool1 = true;
        }
        else
        {
          Object localObject = d(paramca, localNullPointerException);
          if ((!localNullPointerException.bcu()) || ((localObject != null) && (s.YS((String)localObject))))
          {
            long l1 = cl.aWy();
            long l2 = paramca.field_createTime;
            if ((l1 - l2 <= 259200000L) || ((!Util.isNullOrNil((String)localObject)) && (s.YS((String)localObject)))) {
              break label1071;
            }
            Log.i("MicroMsg.ImageGalleryHolderImage", "cur time: %s, msg time: %s, path: %s.", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject });
            i = 1;
            break label1060;
            if (a(paramk, paramca, localNullPointerException, paramInt))
            {
              bool1 = false;
              boolean bool2 = false;
              localObject = com.tencent.mm.av.q.bcR().U(paramca);
              Log.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.av.g)localObject).localId), Long.valueOf(((com.tencent.mm.av.g)localObject).iXv), Long.valueOf(((com.tencent.mm.av.g)localObject).dTS), Integer.valueOf(((com.tencent.mm.av.g)localObject).iXx), Integer.valueOf(((com.tencent.mm.av.g)localObject).iKP) });
              if (localObject != null) {
                if (!Util.isEqual(((com.tencent.mm.av.g)localObject).iXx, 0))
                {
                  localObject = com.tencent.mm.av.q.bcR().tl(((com.tencent.mm.av.g)localObject).iXx);
                  Log.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.av.g)localObject).localId), Long.valueOf(((com.tencent.mm.av.g)localObject).iXv), Long.valueOf(((com.tencent.mm.av.g)localObject).dTS), Integer.valueOf(((com.tencent.mm.av.g)localObject).iXx), Integer.valueOf(((com.tencent.mm.av.g)localObject).iKP) });
                  i = ((com.tencent.mm.av.g)localObject).iKP;
                  int j = (int)s.boW(com.tencent.mm.av.q.bcR().o(localNullPointerException.iXm, "", ""));
                  bool1 = bool2;
                  if (paramca.field_isSend == 1)
                  {
                    bool1 = bool2;
                    if (Util.isEqual(i, j)) {
                      bool1 = true;
                    }
                  }
                  Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() sizeInDb:%s oriSize:%s noNeedDownLoad:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
                }
              }
              for (;;)
              {
                if ((!bool1) && (!localNullPointerException.bcu())) {
                  break label756;
                }
                h(paramca, 4);
                break;
                i = ((com.tencent.mm.av.g)localObject).iKP;
                break label627;
                Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
              }
              h(paramca, 1);
            }
            com.tencent.mm.av.g localg2;
            for (;;)
            {
              ab.ab(paramca);
              i = com.tencent.mm.av.q.bcS().a(localNullPointerException.localId, paramca.field_msgId, 0, Integer.valueOf(paramInt), 2131231628, this, 0, true);
              if (this.Pwu != null) {
                this.Pwu.j(paramca, false);
              }
              Log.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[] { Integer.valueOf(i) });
              if (i != -2) {
                break label985;
              }
              Log.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
              localg2 = i(paramca, true);
              if (localg2 != null) {
                break label886;
              }
              Log.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
              break;
              Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
              h(paramca, 2);
            }
            if (a(paramk, paramca, localg2, paramInt))
            {
              if ((paramca.field_isSend == 1) || (localg2.bcu()))
              {
                h(paramca, 4);
                continue;
              }
              h(paramca, 1);
            }
            for (;;)
            {
              Log.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(localg2.localId), Boolean.valueOf(localg2.bcu()) });
              a(paramk, paramca, localg2, false, paramInt);
              break;
              h(paramca, 2);
            }
            a(paramk, paramca, localg2, false, paramInt);
            continue;
            a(paramk, paramca, localg2, paramInt);
            continue;
            a(paramk, paramca, localg2, false, paramInt);
            continue;
            a(paramk, paramca, localg2, true, paramInt);
            continue;
            a(paramca, paramk, i);
            paramk.convertView.invalidate();
          }
          else
          {
            bool1 = true;
            continue;
          }
          for (;;)
          {
            if (i == 0) {
              break label1077;
            }
            bool1 = true;
            break;
            i = 0;
          }
          bool1 = false;
        }
      }
    }
    paramk.PBc.OVa = br.H(paramca);
    if (paramk.PBc.OVa != 0.0F)
    {
      paramk = new jc();
      paramk.emN = paramca.field_msgSvrId;
      paramk.eLn = paramca.getType();
      paramk.eQu = br.C(paramca);
      paramk.ejA = 2L;
      paramk.bfK();
    }
    AppMethodBeat.o(36012);
    return bool1;
    switch (i)
    {
    default: 
    case 0: 
      for (;;)
      {
        label184:
        bool1 = true;
        break;
        Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
        Log.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
        if (paramca.field_isSend != 1) {
          break label305;
        }
        bool1 = paramca.gDB();
        if (!bool1) {
          break label429;
        }
        h(paramca, 5);
        a(paramca, paramk, 5);
      }
    }
  }
  
  public final Bitmap ana(int paramInt)
  {
    AppMethodBeat.i(36044);
    if (this.Pwu == null)
    {
      AppMethodBeat.o(36044);
      return null;
    }
    ca localca = this.Pwu.Pww.amY(paramInt);
    if (localca != null)
    {
      Object localObject = b.cr(localca);
      if ((localObject == b.b.Pxe) || (localObject == b.b.Pxf))
      {
        AppMethodBeat.o(36044);
        return null;
      }
      String str = (String)this.PxS.get(localca);
      localObject = str;
      if (str == null)
      {
        localObject = com.tencent.mm.av.q.bcR().R(localca.field_imgPath, true);
        this.PxS.put(localca, localObject);
      }
      str = (String)localObject + "hd";
      if (s.YS(str))
      {
        localObject = bmW(str);
        AppMethodBeat.o(36044);
        return localObject;
      }
      localObject = bmW((String)localObject);
      AppMethodBeat.o(36044);
      return localObject;
    }
    AppMethodBeat.o(36044);
    return null;
  }
  
  public final void bH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36041);
    Log.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(paramInt)));
    Object localObject1 = this.Pwu.amt(paramInt);
    if ((localObject1 == null) || (((eo)localObject1).field_msgId == 0L))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      AppMethodBeat.o(36041);
      return;
    }
    if (!b.j((ca)localObject1))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.av.g localg = i((ca)localObject1, true);
    Object localObject2;
    if ((localg == null) || (localg.localId == 0L))
    {
      localObject2 = new StringBuilder("viewHdImg fail, msgLocalId = ");
      if (localObject1 == null)
      {
        localObject1 = "null";
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", imgLocalId = ");
        if (localg != null) {
          break label178;
        }
      }
      label178:
      for (localObject1 = "null";; localObject1 = Long.valueOf(localg.localId))
      {
        Log.e("MicroMsg.ImageGalleryHolderImage", localObject1);
        AppMethodBeat.o(36041);
        return;
        localObject1 = Long.valueOf(((eo)localObject1).field_msgId);
        break;
      }
    }
    h((ca)localObject1, 3);
    if (amM(paramInt) != null) {
      a(amM(paramInt), (ca)localObject1, localg, true, false, paramInt);
    }
    if (this.Pwu != null) {
      this.Pwu.j((ca)localObject1, true);
    }
    if (paramBoolean)
    {
      localObject2 = l.gTf();
      Log.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((eo)localObject1).field_msgId) });
      ((l)localObject2).PBm.add(Long.valueOf(((eo)localObject1).field_msgId));
      com.tencent.mm.av.q.bcS().a(localg.localId, ((eo)localObject1).field_msgId, Integer.valueOf(paramInt), (com.tencent.mm.av.e.a)localObject2);
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.av.q.bcS().a(localg.localId, ((eo)localObject1).field_msgId, Integer.valueOf(paramInt), this);
    AppMethodBeat.o(36041);
  }
  
  public final Bitmap bmV(String paramString)
  {
    AppMethodBeat.i(258286);
    paramString = bmW(paramString);
    AppMethodBeat.o(258286);
    return paramString;
  }
  
  public final int cy(ca paramca)
  {
    AppMethodBeat.i(36009);
    if ((paramca != null) && (this.PxP.containsKey(Long.valueOf(paramca.field_msgId))))
    {
      int i = ((Integer)this.PxP.get(Long.valueOf(paramca.field_msgId))).intValue();
      AppMethodBeat.o(36009);
      return i;
    }
    AppMethodBeat.o(36009);
    return 0;
  }
  
  public final void cz(ca paramca)
  {
    AppMethodBeat.i(36042);
    com.tencent.mm.av.g localg = k(paramca);
    if ((localg == null) || (paramca == null))
    {
      AppMethodBeat.o(36042);
      return;
    }
    if (this.Pwu != null) {
      this.Pwu.a(paramca, null, 1, x.a.emX);
    }
    if (l.gTf().NS(paramca.field_msgId))
    {
      l locall = l.gTf();
      locall.PBm.remove(Long.valueOf(paramca.field_msgId));
      com.tencent.mm.av.q.bcS().a(localg.localId, paramca.field_msgId, 1, locall);
      com.tencent.mm.av.q.bcS().C(localg.localId, paramca.field_msgId);
      AppMethodBeat.o(36042);
      return;
    }
    com.tencent.mm.av.q.bcS().a(localg.localId, paramca.field_msgId, 1, this);
    com.tencent.mm.av.q.bcS().C(localg.localId, paramca.field_msgId);
    AppMethodBeat.o(36042);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36008);
    super.detach();
    EventCenter.instance.removeListener(this.PxN);
    if (this.JeH != null)
    {
      localObject = this.JeH.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.JeH.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.PxQ;
    ((e)localObject).Pyc = null;
    ((e)localObject).xqf.clear();
    ((e)localObject).xqi.clear();
    ((e)localObject).xqh.clear();
    ((e)localObject).xqg.clear();
    ((e)localObject).Pyb.clear();
    ((e)localObject).dSj();
    if ((((e)localObject).CQj != null) && (!((e)localObject).CQj.isRecycled()))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", new Object[] { ((e)localObject).CQj.toString() });
      ((e)localObject).CQj.recycle();
      ((e)localObject).CQj = null;
    }
    com.tencent.mm.av.q.bcS().a(this);
    localObject = l.gTf();
    if (equals(((l)localObject).PBn)) {
      ((l)localObject).PBn = null;
    }
    AppMethodBeat.o(36008);
  }
  
  public final p gSe()
  {
    AppMethodBeat.i(233293);
    Object localObject = this.Pwu.gSg();
    if (localObject == null)
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(233293);
      return null;
    }
    int i = cy((ca)localObject);
    Log.i("MicroMsg.ImageGalleryHolderImage", "getCurResourceState, msgState: ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      localObject = p.PBN;
      AppMethodBeat.o(233293);
      return localObject;
    case 5: 
    case 6: 
      localObject = p.PBM;
      AppMethodBeat.o(233293);
      return localObject;
    }
    localObject = p.PBO;
    AppMethodBeat.o(233293);
    return localObject;
  }
  
  public final com.tencent.mm.av.g i(ca paramca, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(36014);
    if (!b.j(paramca))
    {
      AppMethodBeat.o(36014);
      return null;
    }
    if ((this.Pwu == null) || (this.Pwu.Pww == null))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
      AppMethodBeat.o(36014);
      return null;
    }
    if (!paramBoolean)
    {
      if (paramca.field_isSend == 1) {
        localObject2 = (com.tencent.mm.av.g)this.Pwu.Pww.PwW.get(Long.valueOf(paramca.field_msgId));
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramca.field_msgSvrId > 0L) {
          localObject1 = (com.tencent.mm.av.g)this.Pwu.Pww.PwV.get(Long.valueOf(paramca.field_msgSvrId));
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramBoolean = false;
      long l;
      if (paramca.field_isSend == 1)
      {
        l = paramca.field_msgId;
        localObject2 = com.tencent.mm.av.q.bcR().H(paramca.field_talker, l);
        localObject1 = localObject2;
        if (((com.tencent.mm.av.g)localObject2).localId != 0L) {}
      }
      else
      {
        l = paramca.field_msgSvrId;
        localObject1 = com.tencent.mm.av.q.bcR().G(paramca.field_talker, l);
        paramBoolean = true;
      }
      this.Pwu.Pww.a(l, (com.tencent.mm.av.g)localObject1, paramBoolean);
      localObject2 = localObject1;
    }
    AppMethodBeat.o(36014);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d
 * JD-Core Version:    0.7.0.1
 */