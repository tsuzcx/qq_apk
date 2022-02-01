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
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.e.a;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.m;
import com.tencent.mm.f.b.a.ad.a;
import com.tencent.mm.f.b.a.ll;
import com.tencent.mm.f.c.et;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.cm;
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
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.chatting.al;
import com.tencent.mm.ui.chatting.al.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class h
  extends a
  implements e.a, d
{
  private static long MAGIC_FREE_BUFFER;
  private static boolean WSt;
  private HashMap<String, WeakReference<Bitmap>> QbK;
  private IListener WSn;
  s WSo;
  public HashMap<Long, Integer> WSp;
  public final i WSq;
  private HashMap<ca, String> WSr;
  private HashMap<ca, String> WSs;
  private long WSu;
  int mScrollState;
  
  static
  {
    AppMethodBeat.i(36048);
    WSt = true;
    MAGIC_FREE_BUFFER = (Runtime.getRuntime().maxMemory() * 0.05D);
    AppMethodBeat.o(36048);
  }
  
  public h(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(36007);
    this.WSp = new HashMap();
    this.WSq = new i(this);
    this.QbK = new HashMap();
    this.WSr = new HashMap();
    this.WSs = new HashMap();
    this.WSu = 0L;
    this.mScrollState = 0;
    EventCenter localEventCenter = EventCenter.instance;
    paramf = new al(al.a.WDU, paramf.WQV);
    this.WSn = paramf;
    localEventCenter.addListener(paramf);
    paramf = k.a.WSQ.CcE.snapshot();
    this.WSq.cn(paramf);
    q.hSM().WWk = this;
    AppMethodBeat.o(36007);
  }
  
  public static String a(ca paramca, g paramg)
  {
    AppMethodBeat.i(36033);
    paramca = a(paramca, paramg, false);
    AppMethodBeat.o(36033);
    return paramca;
  }
  
  private static String a(ca paramca, g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(36034);
    if (paramca.field_isSend == 1)
    {
      paramca = com.tencent.mm.ay.q.bmh().a(paramca.field_talker, paramg);
      str = com.tencent.mm.ay.q.bmh().r(paramca, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", new Object[] { paramca, str });
      if (com.tencent.mm.vfs.u.agG(str))
      {
        AppMethodBeat.o(36034);
        return str;
      }
      paramca = paramg.lNH;
      paramg = com.tencent.mm.ay.q.bmh().r(paramca, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", new Object[] { paramca, paramg });
      if (com.tencent.mm.vfs.u.agG(paramg))
      {
        AppMethodBeat.o(36034);
        return paramg;
      }
      AppMethodBeat.o(36034);
      return null;
    }
    if ((!paramBoolean) && (!paramg.blJ()))
    {
      Log.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(paramg.blJ()) });
      AppMethodBeat.o(36034);
      return null;
    }
    String str = paramg.lNH;
    if (paramg.blK())
    {
      paramca = com.tencent.mm.ay.q.bmh().a(paramca.field_talker, paramg);
      if (paramca != null)
      {
        paramca = com.tencent.mm.ay.q.bmh().r(paramca, "", "");
        if (com.tencent.mm.vfs.u.agG(paramca)) {
          Log.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      paramg = paramca;
      if (paramca == null) {
        paramg = com.tencent.mm.ay.q.bmh().r(str, "", "");
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
    AppMethodBeat.i(285261);
    if ((this.WQM == null) || (this.WQM.WQV == null))
    {
      AppMethodBeat.o(285261);
      return;
    }
    Log.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), Integer.valueOf(paramBitmap.hashCode()) });
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.setEnableHorLongBmpMode(false);
      paramMultiTouchImageView.di(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(null);
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.invalidate();
      if (this.WSo != null) {
        this.WSo.b(paramLong, paramMultiTouchImageView, paramString, paramBitmap);
      }
      AppMethodBeat.o(285261);
      return;
      ForceGpuUtil.decideLayerType((View)paramMultiTouchImageView.getParent(), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  private static void a(ca paramca, p paramp, int paramInt)
  {
    AppMethodBeat.i(36019);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
    p.aR(paramp.WVV, 8);
    p.aR(paramp.WVQ, 8);
    p.aR(paramp.WVZ, 8);
    p.aR(paramp.WWa, 8);
    paramp.hSJ().WVW.setVisibility(0);
    paramp.hSJ().WVY.setImageResource(R.k.image_download_fail_icon);
    if ((str == null) || (!com.tencent.mm.vfs.u.agG(str)))
    {
      paramp.hSJ().WVX.setText(R.l.eHY);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramInt == 6)
    {
      paramp.hSJ().WVX.setText(R.l.imgdownload_fail);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramca.Ic())
    {
      paramp.hSJ().WVX.setText(R.l.eHV);
      AppMethodBeat.o(36019);
      return;
    }
    paramp.hSJ().WVX.setText(R.l.eHW);
    AppMethodBeat.o(36019);
  }
  
  private static void a(ca paramca, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36039);
    Log.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
    f.c(MMApplicationContext.getContext(), paramca, paramBoolean);
    AppMethodBeat.o(36039);
  }
  
  private void a(p paramp, ca paramca, g paramg, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36017);
    a(paramp, paramca, paramg, paramBoolean, true, paramInt);
    AppMethodBeat.o(36017);
  }
  
  private void a(p paramp, ca paramca, g paramg, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(36018);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(paramBoolean1)));
    p.aR(paramp.WVW, 8);
    String str1 = null;
    if (!paramBoolean1) {
      paramp.WVZ.setVisibility(0);
    }
    g localg = com.tencent.mm.ay.h.a(paramg);
    if ((paramBoolean1) && (paramInt == this.WQM.WQV.getCurrentItem())) {
      this.WQM.WQV.hSw();
    }
    if (paramBoolean1) {
      str1 = a(paramca, paramg, true);
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1)) {
      str2 = com.tencent.mm.ay.q.bmh().r(localg.lNJ, "", "");
    }
    str1 = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
    if (paramBoolean2) {
      a(paramp, str1, str2, paramca);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = paramg.lAW;
      int i = paramg.offset;
      if (paramInt == 0) {
        break label258;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label264;
      }
      paramp.hSI().WVV.setVisibility(8);
    }
    for (;;)
    {
      paramp.hSI().WVT.setVisibility(8);
      paramp.hSI().WVS.setVisibility(8);
      paramp.hSI().WVR.setVisibility(8);
      AppMethodBeat.o(36018);
      return;
      label258:
      l = 0L;
      break;
      label264:
      paramp.hSI().WVV.setVisibility(0);
    }
  }
  
  private static void a(p paramp, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    AppMethodBeat.i(36026);
    Object localObject;
    int i;
    if (paramp != null) {
      if (paramp.WWa != null)
      {
        localObject = paramp.WWa;
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
    for (paramp.WWb = true;; paramp.WWb = false)
    {
      if (paramp.WVZ != null)
      {
        localObject = paramp.WVZ;
        i = j;
        if (paramBoolean2) {
          i = 0;
        }
        ((MultiTouchImageView)localObject).setVisibility(i);
        if (paramBoolean2) {
          paramp.WWb = false;
        }
      }
      AppMethodBeat.o(36026);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, int paramInt, ca paramca, p paramp)
  {
    AppMethodBeat.i(36024);
    boolean bool = a(true, paramMultiTouchImageView, paramString1, paramString2, false, paramInt, paramca, paramp, null, false);
    AppMethodBeat.o(36024);
    return bool;
  }
  
  private boolean a(p paramp, ca paramca, g paramg, int paramInt)
  {
    AppMethodBeat.i(36016);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = d(paramca, paramg);
    p.aR(paramp.WVV, 8);
    String str1 = (String)this.WSs.get(paramca);
    paramg = str1;
    if (str1 == null)
    {
      paramg = com.tencent.mm.ay.q.bmh().T(paramca.field_imgPath, true);
      this.WSs.put(paramca, paramg);
    }
    boolean bool = a(paramp, paramg, str2, paramca);
    if ((paramInt == this.WQM.WQV.getCurrentItem()) && (this.WQM.WQZ))
    {
      this.WQM.cQ(paramca);
      this.WQM.WQZ = false;
    }
    AppMethodBeat.o(36016);
    return bool;
  }
  
  private boolean a(p paramp, String paramString1, String paramString2, ca paramca)
  {
    AppMethodBeat.i(36020);
    boolean bool = b(paramp, paramString1, paramString2, paramca);
    AppMethodBeat.o(36020);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, final int paramInt, final ca paramca, final p paramp, g paramg, boolean paramBoolean3)
  {
    AppMethodBeat.i(36025);
    Log.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt) });
    Object localObject2 = null;
    boolean bool1 = true;
    if ((paramString2 != null) && (com.tencent.mm.vfs.u.agG(paramString2))) {
      localObject2 = com.tencent.mm.vfs.u.n(paramString2, false);
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
          if (com.tencent.mm.vfs.u.agG(paramString1))
          {
            localObject1 = com.tencent.mm.vfs.u.n(paramString1, false);
            if (com.tencent.mm.vfs.u.agG(paramString1 + "hd")) {
              localObject1 = com.tencent.mm.vfs.u.n(paramString1 + "hd", false);
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
    if (paramp == null)
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
      AppMethodBeat.o(36025);
      return false;
    }
    int i;
    label285:
    boolean bool2;
    if ((!((String)localObject1).equals(paramString1)) && (!paramBoolean3) && (bzv((String)localObject1)))
    {
      paramBoolean3 = true;
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", new Object[] { Boolean.valueOf(paramBoolean3), localObject1 });
      if ((paramp.WWa == null) || (paramp.WWa.getVisibility() != 0)) {
        break label406;
      }
      i = 1;
      if ((!paramBoolean3) || (i != 0)) {
        break label412;
      }
      bool2 = true;
      label298:
      if ((paramBoolean3) || (paramBoolean2) || (!this.WSq.CcE.check(localObject1))) {
        break label424;
      }
      localObject2 = (Bitmap)this.WSq.CcE.aX(localObject1);
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
      if (paramp.WWa == null)
      {
        AppMethodBeat.o(36025);
        return false;
      }
      localObject2 = paramg;
      if (paramg == null) {
        localObject2 = i(paramca, true);
      }
      paramp.WWa.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
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
          com.tencent.mm.cy.b.azQ(paramAnonymousc.errCode);
          h.a(h.this, this.WSv, paramp, paramInt);
          if (paramAnonymousc.errCode == 4) {
            h.hRM();
          }
          AppMethodBeat.o(36001);
        }
        
        public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36002);
          Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          h.a(paramca, paramp);
          AppMethodBeat.o(36002);
        }
        
        public final void i(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(35999);
          int i;
          if ((paramAnonymousBitmap != null) && (h.this.WSq != null))
          {
            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[] { this.WSv });
            i locali = h.this.WSq;
            if (paramInt > 0)
            {
              i = paramInt;
              locali.e(i, paramAnonymousBitmap);
            }
          }
          else
          {
            h.c(paramp);
            if (h.a(h.this) != null) {
              if (paramca == null) {
                break label139;
              }
            }
          }
          label139:
          for (long l = paramca.field_msgId;; l = 0L)
          {
            h.a(h.this).b(l, paramp.WWa, this.WSv, paramAnonymousBitmap);
            AppMethodBeat.o(35999);
            return;
            i = paramp.mPosition;
            break;
          }
        }
        
        public final void pP()
        {
          AppMethodBeat.i(35998);
          Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
          AppMethodBeat.o(35998);
        }
        
        public final void pQ() {}
      });
    }
    if (!this.WQM.WRg)
    {
      if (paramInt >= 0)
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[] { Integer.valueOf(paramInt) });
        a(paramp, false, true);
        this.WSq.c(paramMultiTouchImageView, paramInt);
      }
      if (!paramBoolean3) {
        break label784;
      }
      a(paramp, true, bool2);
      paramMultiTouchImageView = e(paramca, (g)localObject2);
      paramString1 = this.WSq;
      paramString2 = paramp.WWa;
      i = paramInt;
      if (paramInt < 0) {
        i = paramp.mPosition;
      }
      paramString1.b(paramString2, (String)localObject1, paramMultiTouchImageView, i);
    }
    for (;;)
    {
      AppMethodBeat.o(36025);
      return bool1;
      if (paramBoolean3)
      {
        paramMultiTouchImageView = e(paramca, (g)localObject2);
        a(paramp, true, bool2);
        paramString1 = paramp.WWa;
        if (paramMultiTouchImageView != null) {}
        for (paramMultiTouchImageView = com.davemorrissey.labs.subscaleview.view.a.aZ(paramMultiTouchImageView);; paramMultiTouchImageView = null)
        {
          a(paramString1, (String)localObject1, paramMultiTouchImageView);
          AppMethodBeat.o(36025);
          return bool1;
        }
      }
      Bitmap localBitmap = bzw((String)localObject1);
      paramg = localBitmap;
      if (localBitmap == null) {
        paramg = bzw(paramString1);
      }
      if (paramg == null) {
        break;
      }
      a(paramp, false, true);
      if (paramca != null) {}
      for (l = paramca.field_msgId;; l = 0L)
      {
        a(l, paramMultiTouchImageView, (String)localObject1, paramg);
        if (((String)localObject1).equals(paramString2))
        {
          this.WSq.w((String)localObject1, paramg);
          this.WSq.e(paramInt, paramg);
        }
        AppMethodBeat.o(36025);
        return bool1;
      }
      label784:
      a(paramp, false, true);
      paramString1 = this.WSq;
      i = paramInt;
      if (paramInt < 0) {
        i = paramp.mPosition;
      }
      paramString1.k(paramMultiTouchImageView, (String)localObject1, i);
    }
  }
  
  private static Bitmap aV(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36030);
    String str = paramString + "_tmp.jpg";
    try
    {
      bool1 = com.tencent.mm.compatible.util.d.qW(16);
      if (bool1)
      {
        AppMethodBeat.o(36030);
        return null;
      }
      bool1 = CrashReportFactory.hasDebuger();
      if (!bool1) {
        try
        {
          i = Util.getInt(com.tencent.mm.n.h.axc().getValue("UseOptImageRecv"), 0);
          bh.beI();
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
      com.tencent.mm.vfs.u.bBD(com.tencent.mm.vfs.u.bBT(str));
      com.tencent.mm.vfs.u.on(paramString, str);
      bool1 = MMNativeJpeg.IsJpegFile(str);
      bool2 = MMNativeJpeg.isProgressive(str);
      bool3 = ImageOptimLib.checkIntegrity(str);
      j = (int)com.tencent.mm.vfs.u.bBQ(str);
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
        h.a.x(paramString, paramInt2, paramInt1, i);
        localBitmap2 = localBitmap1;
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localBitmap1, paramString });
        com.tencent.mm.vfs.u.deleteFile(str);
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
  
  public static boolean awd(int paramInt)
  {
    return paramInt == 1;
  }
  
  private void az(long paramLong, int paramInt)
  {
    AppMethodBeat.i(36011);
    this.WSp.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(36011);
  }
  
  private boolean b(p paramp, String paramString1, String paramString2, ca paramca)
  {
    AppMethodBeat.i(36021);
    p.aR(paramp.WVZ, 0);
    p.aR(paramp.WVQ, 8);
    p.aR(paramp.WVV, 8);
    p.aR(paramp.WVW, 8);
    boolean bool = a(paramp.WVZ, paramString1, paramString2, paramp.mPosition, paramca, paramp);
    AppMethodBeat.o(36021);
    return bool;
  }
  
  protected static BitmapFactory.Options bzu(String paramString)
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
  
  private boolean bzv(String paramString)
  {
    AppMethodBeat.i(36023);
    if (!WSt)
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
      AppMethodBeat.o(36023);
      return false;
    }
    if (bs.F(this.WQM.hRF()))
    {
      AppMethodBeat.o(36023);
      return false;
    }
    boolean bool = com.tencent.mm.cy.a.alg(paramString);
    AppMethodBeat.o(36023);
    return bool;
  }
  
  private static Bitmap bzw(String paramString)
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
    double d3 = 1.0D;
    int m = n;
    double d1 = d3;
    int k = i1;
    for (;;)
    {
      try
      {
        long l1 = Math.min(Math.max(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - MAGIC_FREE_BUFFER, 0L), 99614720L);
        m = n;
        d1 = d3;
        k = i1;
        i = ((BitmapFactory.Options)localObject1).outHeight;
        m = n;
        d1 = d3;
        k = i1;
        long l2 = ((BitmapFactory.Options)localObject1).outWidth * i * 4;
        m = n;
        d1 = d3;
        k = i1;
        Log.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        i = n;
        double d2 = d3;
        j = i1;
        if (l1 < l2)
        {
          m = n;
          d1 = d3;
          k = i1;
          d2 = Math.sqrt(l1 / l2);
          m = n;
          d1 = d2;
          k = i1;
          Log.v("MicroMsg.ImageGalleryHolderImage", "hy: scale is %f, currentFreeMem is %d, previewDecodedBmLength is %d.", new Object[] { Double.valueOf(d2), Long.valueOf(l1), Long.valueOf(l2) });
          j = (int)(i1 * d2);
          i = (int)(n * d2);
        }
        m = i;
        d1 = d2;
        k = j;
        localObject3 = aV(paramString, i, j);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          m = i;
          d1 = d2;
          k = j;
          localObject1 = BitmapUtil.getBitmapNative(paramString, j, i, 0.0F);
        }
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = localObject1;
          m = i;
          d1 = d2;
          k = j;
          if (MMNativeJpeg.IsJpegFile(paramString))
          {
            localObject3 = localObject1;
            m = i;
            d1 = d2;
            k = j;
            if (MMNativeJpeg.isProgressive(paramString))
            {
              m = i;
              d1 = d2;
              k = j;
              localObject3 = MMNativeJpeg.decodeAsBitmap(paramString);
              if (localObject3 != null) {
                continue;
              }
              bool = true;
              m = i;
              d1 = d2;
              k = j;
              Log.i("MicroMsg.ImageGalleryHolderImage", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
            }
          }
        }
        localObject1 = localObject3;
        d1 = d2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
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
        localObject2 = f(paramString, k, m, i, j);
        i = m;
        j = k;
        continue;
        i = ((Context)localObject2).getResources().getDisplayMetrics().widthPixels;
        continue;
        j = ((Context)localObject2).getResources().getDisplayMetrics().heightPixels;
        continue;
        k = ((Bitmap)localObject2).getWidth();
        k = ((Bitmap)localObject2).getHeight() * k;
        m = j * i;
        if ((d1 == 1.0D) || (k <= m)) {
          continue;
        }
        boolean bool = true;
        Log.i("MicroMsg.ImageGalleryHolderImage", "extractBitmap scale : %s, oriImgPixelRate: %s, targetImgPixelRate: %s, needScaleBitmap: %s, width: %s, height: %s.", new Object[] { Double.valueOf(d1), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool), Integer.valueOf(j), Integer.valueOf(i) });
        if (!bool) {
          continue;
        }
        Log.i("MicroMsg.ImageGalleryHolderImage", "extractBitmap, scale: %s", new Object[] { Double.valueOf(d1) });
        paramString = BitmapUtil.rotateAndScale((Bitmap)localObject2, i2, (float)d1, (float)d1);
        if ((paramString != localObject2) || (i2 % 360 == 0)) {
          continue;
        }
        Log.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[] { Integer.valueOf(i2) });
        AppMethodBeat.o(36031);
        return null;
        bool = false;
        continue;
        paramString = BitmapUtil.rotate((Bitmap)localObject2, i2);
        continue;
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
  
  private String d(ca paramca, g paramg)
  {
    AppMethodBeat.i(36015);
    String str2 = (String)this.WSr.get(paramca);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(paramca, paramg, false);
      if ((str1 == null) || (str1.length() == 0))
      {
        AppMethodBeat.o(36015);
        return null;
      }
      this.WSr.put(paramca, str1);
    }
    AppMethodBeat.o(36015);
    return str1;
  }
  
  private static String e(ca paramca, g paramg)
  {
    AppMethodBeat.i(36035);
    if ((paramca == null) || (paramg == null))
    {
      AppMethodBeat.o(36035);
      return null;
    }
    if (paramca.field_isSend == 1)
    {
      paramca = paramg.lNJ;
      paramg = com.tencent.mm.ay.q.bmh().r(paramca, "", "") + "hd";
      Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { paramca, paramg });
      if ((!Util.isNullOrNil(paramg)) && (com.tencent.mm.vfs.u.agG(paramg)))
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
        AppMethodBeat.o(36035);
        return paramg;
      }
      paramg = com.tencent.mm.ay.q.bmh().r(paramca, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", new Object[] { paramca, paramg });
      if ((!Util.isNullOrNil(paramg)) && (com.tencent.mm.vfs.u.agG(paramg)))
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
        AppMethodBeat.o(36035);
        return paramg;
      }
      AppMethodBeat.o(36035);
      return null;
    }
    if (!paramg.blJ())
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
      AppMethodBeat.o(36035);
      return null;
    }
    paramca = paramg.lNJ;
    paramg = com.tencent.mm.ay.q.bmh().r(paramca, "", "") + "hd";
    Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { paramca, paramg });
    if ((!Util.isNullOrNil(paramg)) && (com.tencent.mm.vfs.u.agG(paramg)))
    {
      Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
      AppMethodBeat.o(36035);
      return paramg;
    }
    AppMethodBeat.o(36035);
    return null;
  }
  
  private int f(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(36038);
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      paramObject = this.WQM.avt(i);
      if ((paramObject != null) && (paramObject.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    paramObject = this.WQM.WnM.values().iterator();
    while (paramObject.hasNext())
    {
      i = ((Integer)paramObject.next()).intValue();
      ca localca = this.WQM.avt(i);
      if ((localca != null) && (localca.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    AppMethodBeat.o(36038);
    return -1;
  }
  
  private static Bitmap f(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  public static void hRM()
  {
    WSt = false;
  }
  
  public static g k(ca paramca)
  {
    AppMethodBeat.i(36013);
    if (!f.j(paramca))
    {
      AppMethodBeat.o(36013);
      return null;
    }
    long l;
    g localg1;
    if (paramca.field_isSend == 1)
    {
      l = paramca.field_msgId;
      g localg2 = com.tencent.mm.ay.q.bmh().D(paramca.field_talker, l);
      localg1 = localg2;
      if (localg2.localId != 0L) {}
    }
    else
    {
      l = paramca.field_msgSvrId;
      localg1 = com.tencent.mm.ay.q.bmh().C(paramca.field_talker, l);
    }
    AppMethodBeat.o(36013);
    return localg1;
  }
  
  private void m(ca paramca, int paramInt)
  {
    AppMethodBeat.i(36010);
    this.WSp.put(Long.valueOf(paramca.field_msgId), Integer.valueOf(paramInt));
    AppMethodBeat.o(36010);
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
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(36036);
    if ((this.WQM == null) || (this.WQM.WQV == null))
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
    if (q.hSM().We(paramLong2))
    {
      i = f(paramLong2, paramObject);
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
      if (this.WQM.aiI(i) == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      paramObject = (p)this.WQM.aiI(i).getTag();
      if (paramObject == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.WQM.WQV.getCurrentItem()) && (awd(paramInt1)))
        {
          Log.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.WQM.WQV.awl(paramInt2);
        }
        paramq = (m)paramq;
        boolean bool1 = MMNativeJpeg.isProgressive(paramq.lPq);
        boolean bool2 = paramq.lPs;
        paramLong1 = Util.ticksToNow(this.WSu);
        h.a.hO(paramq.lPq, paramInt4);
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramq.lPq });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break label679;
        }
        this.WSu = Util.currentTicks();
        paramq = this.WQM.avt(i);
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
      g localg = i(paramq, true);
      if (a(false, paramObject.WVZ, com.tencent.mm.ay.q.bmh().T(paramq.field_imgPath, true), a(paramq, localg, true), true, -1, paramq, paramObject, localg, true))
      {
        p.aR(paramObject.WVT, 8);
        p.aR(paramObject.WVW, 8);
        if ((i == this.WQM.WQV.getCurrentItem()) && (!awd(paramInt1))) {
          if (paramInt2 > 50)
          {
            p.aR(paramObject.WVV, 8);
            if (this.WQM != null)
            {
              this.WQM.a(paramq, localg, paramInt1, ad.a.gic);
              AppMethodBeat.o(36036);
            }
          }
          else
          {
            p.aR(paramObject.WVV, 0);
          }
        }
      }
      label679:
      AppMethodBeat.o(36036);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, final int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(36037);
    if ((this.WQM == null) || (this.WQM.WQV == null))
    {
      AppMethodBeat.o(36037);
      return;
    }
    if (q.hSM().We(paramLong2))
    {
      paramInt2 = f(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        bh.beI();
        a(com.tencent.mm.model.c.bbO().Oq(paramLong2), "background", false);
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
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 3L, 1L, true);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = null;
      if (this.WQM.aiI(paramInt2) != null) {
        paramObject = (p)this.WQM.aiI(paramInt2).getTag();
      }
      boolean bool = q.hSM().We(paramLong2);
      if ((paramInt3 != 0) || (paramInt4 != 0))
      {
        if (bool)
        {
          paramObject = this.WQM.avt(paramInt2);
          paramString = "hd_failed:".concat(String.valueOf(paramInt2));
          if (paramInt2 == this.WQM.WQV.getCurrentItem())
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
          az(paramLong2, 5);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 0L, 1L, true);
        }
        for (;;)
        {
          Log.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
          this.WQM.WRa.avO(paramInt2);
          if (this.WQM != null) {
            this.WQM.a(this.WQM.avt(paramInt2), null, paramInt1, ad.a.gie);
          }
          AppMethodBeat.o(36037);
          return;
          bool = false;
          break;
          label394:
          az(paramLong2, 6);
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 1L, 1L, true);
        }
      }
      if (bool)
      {
        paramString = this.WQM.avt(paramInt2);
        paramq = "hd_suc:".concat(String.valueOf(paramInt2));
        if (paramInt2 != this.WQM.WQV.getCurrentItem()) {
          break label561;
        }
      }
      label561:
      for (bool = true;; bool = false)
      {
        a(paramString, paramq, bool);
        Log.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.WQM.WQV.getCurrentItem(), new Object[0]);
        az(paramLong2, 4);
        paramString = this.WQM.avt(paramInt2);
        paramq = i(paramString, true);
        if ((paramString != null) && (paramq != null)) {
          break;
        }
        AppMethodBeat.o(36037);
        return;
      }
      if (this.WSo != null) {
        this.WSo.aB(paramString.field_msgId, paramInt1);
      }
      if (paramObject != null)
      {
        if (paramInt2 == this.WQM.WQV.getCurrentItem())
        {
          if (!awd(paramInt1)) {
            break label866;
          }
          ImageGalleryUI localImageGalleryUI = this.WQM.WQV;
          localImageGalleryUI.hSg();
          localImageGalleryUI.hSg();
          Animation localAnimation = ImageGalleryUI.awk(1000);
          localAnimation.setAnimationListener(new ImageGalleryUI.39(localImageGalleryUI));
          localImageGalleryUI.dmd();
          localImageGalleryUI.hRP().WTr.setVisibility(0);
          localImageGalleryUI.hRP().WTs.setVisibility(8);
          localImageGalleryUI.hRP().WTt.setVisibility(8);
          localImageGalleryUI.hRP().WTu.setVisibility(0);
          localImageGalleryUI.hRP().WTu.startAnimation(localAnimation);
        }
        while (a(false, paramObject.WVZ, com.tencent.mm.ay.q.bmh().T(paramString.field_imgPath, true), a(paramString, paramq, true), true, -1, paramString, paramObject, paramq, false))
        {
          p.aR(paramObject.WVQ, 8);
          p.aR(paramObject.WVV, 8);
          p.aR(paramObject.WVW, 8);
          if ((cU(paramString) == 4) && (this.WQM.WQZ))
          {
            this.WQM.cQ(paramString);
            this.WQM.WQZ = false;
          }
          if (this.WQM == null) {
            break label910;
          }
          this.WQM.a(paramString, paramq, paramInt1, ad.a.gic);
          AppMethodBeat.o(36037);
          return;
          label866:
          paramObject.WVZ.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36003);
              if ((h.this.WQM == null) || (h.this.WQM.WQV == null))
              {
                AppMethodBeat.o(36003);
                return;
              }
              h.this.WQM.WQV.awg(paramInt2);
              AppMethodBeat.o(36003);
            }
          });
        }
        Log.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 2L, 1L, true);
      }
      label910:
      AppMethodBeat.o(36037);
      return;
    }
  }
  
  public final void a(long paramLong, View paramView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(285250);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(285250);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.hashCode();
      int j = paramBitmap.hashCode();
      int k = this.WSq.CcF.indexOfValue(i);
      if (k >= 0) {
        this.WSq.CcF.removeAt(k);
      }
      this.WSq.CcF.put(j, i);
      if ((paramView instanceof MultiTouchImageView))
      {
        a(paramLong, (MultiTouchImageView)paramView, paramString, paramBitmap);
        AppMethodBeat.o(285250);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageBitmap(paramBitmap);
      }
    }
    AppMethodBeat.o(285250);
  }
  
  public final void a(WxImageView paramWxImageView, String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(36029);
    BitmapFactory.Options localOptions = bzu(paramString);
    paramWxImageView.setOrientation(BackwardSupportUtil.ExifHelper.getExifOrientation(paramString));
    paramWxImageView.di(localOptions.outWidth, localOptions.outHeight);
    paramWxImageView.hJx();
    paramWxImageView.a(paramString, parama);
    AppMethodBeat.o(36029);
  }
  
  public final boolean a(p paramp, ca paramca, int paramInt)
  {
    AppMethodBeat.i(36012);
    super.a(paramp, paramca, paramInt);
    if ((paramp == null) || (paramca == null) || (paramInt < 0))
    {
      AppMethodBeat.o(36012);
      return false;
    }
    i = cU(paramca);
    Log.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", new Object[] { Integer.valueOf(paramp.WVZ.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(i) });
    p.aR(paramp.WVQ, 8);
    try
    {
      g localg1 = i(paramca, false);
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
        if (paramca.Ic())
        {
          bool1 = true;
        }
        else
        {
          Object localObject = d(paramca, localNullPointerException);
          if ((!localNullPointerException.blJ()) || ((localObject != null) && (com.tencent.mm.vfs.u.agG((String)localObject))))
          {
            long l1 = cm.bfC();
            long l2 = paramca.field_createTime;
            if ((l1 - l2 <= 259200000L) || ((!Util.isNullOrNil((String)localObject)) && (com.tencent.mm.vfs.u.agG((String)localObject)))) {
              break label1071;
            }
            Log.i("MicroMsg.ImageGalleryHolderImage", "cur time: %s, msg time: %s, path: %s.", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject });
            i = 1;
            break label1060;
            if (a(paramp, paramca, localNullPointerException, paramInt))
            {
              bool1 = false;
              boolean bool2 = false;
              localObject = com.tencent.mm.ay.q.bmh().aa(paramca);
              Log.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((g)localObject).localId), Long.valueOf(((g)localObject).lNP), Long.valueOf(((g)localObject).fNu), Integer.valueOf(((g)localObject).lNR), Integer.valueOf(((g)localObject).lAW) });
              if (localObject != null) {
                if (!Util.isEqual(((g)localObject).lNR, 0))
                {
                  localObject = com.tencent.mm.ay.q.bmh().wl(((g)localObject).lNR);
                  Log.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((g)localObject).localId), Long.valueOf(((g)localObject).lNP), Long.valueOf(((g)localObject).fNu), Integer.valueOf(((g)localObject).lNR), Integer.valueOf(((g)localObject).lAW) });
                  i = ((g)localObject).lAW;
                  int j = (int)com.tencent.mm.vfs.u.bBQ(com.tencent.mm.ay.q.bmh().r(localNullPointerException.lNH, "", ""));
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
                if ((!bool1) && (!localNullPointerException.blJ())) {
                  break label756;
                }
                m(paramca, 4);
                break;
                i = ((g)localObject).lAW;
                break label627;
                Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
              }
              m(paramca, 1);
            }
            g localg2;
            for (;;)
            {
              ab.ah(paramca);
              i = com.tencent.mm.ay.q.bmi().a(localNullPointerException.localId, paramca.field_msgId, 0, Integer.valueOf(paramInt), R.g.chat_img_template, this, 0, true);
              if (this.WQM != null) {
                this.WQM.j(paramca, false);
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
              m(paramca, 2);
            }
            if (a(paramp, paramca, localg2, paramInt))
            {
              if ((paramca.field_isSend == 1) || (localg2.blJ()))
              {
                m(paramca, 4);
                continue;
              }
              m(paramca, 1);
            }
            for (;;)
            {
              Log.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(localg2.localId), Boolean.valueOf(localg2.blJ()) });
              a(paramp, paramca, localg2, false, paramInt);
              break;
              m(paramca, 2);
            }
            a(paramp, paramca, localg2, false, paramInt);
            continue;
            a(paramp, paramca, localg2, paramInt);
            continue;
            a(paramp, paramca, localg2, false, paramInt);
            continue;
            a(paramp, paramca, localg2, true, paramInt);
            continue;
            a(paramca, paramp, i);
            paramp.convertView.invalidate();
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
    paramp.WVZ.Wom = bs.J(paramca);
    if (paramp.WVZ.Wom != 0.0F)
    {
      paramp = new ll();
      paramp.ghT = paramca.field_msgSvrId;
      paramp.gKR = paramca.getType();
      paramp.gQQ = bs.E(paramca);
      paramp.gef = 2L;
      paramp.bpa();
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
        bool1 = paramca.Ic();
        if (!bool1) {
          break label429;
        }
        m(paramca, 5);
        a(paramca, paramp, 5);
      }
    }
  }
  
  public final Bitmap aIz(String paramString)
  {
    AppMethodBeat.i(293349);
    paramString = bzw(paramString);
    AppMethodBeat.o(293349);
    return paramString;
  }
  
  public final Bitmap avP(int paramInt)
  {
    AppMethodBeat.i(36044);
    if (this.WQM == null)
    {
      AppMethodBeat.o(36044);
      return null;
    }
    ca localca = this.WQM.WQW.awb(paramInt);
    if (localca != null)
    {
      Object localObject = f.cN(localca);
      if ((localObject == f.b.WRE) || (localObject == f.b.WRF))
      {
        AppMethodBeat.o(36044);
        return null;
      }
      String str = (String)this.WSs.get(localca);
      localObject = str;
      if (str == null)
      {
        localObject = com.tencent.mm.ay.q.bmh().T(localca.field_imgPath, true);
        this.WSs.put(localca, localObject);
      }
      str = (String)localObject + "hd";
      if (com.tencent.mm.vfs.u.agG(str))
      {
        localObject = bzw(str);
        AppMethodBeat.o(36044);
        return localObject;
      }
      localObject = bzw((String)localObject);
      AppMethodBeat.o(36044);
      return localObject;
    }
    AppMethodBeat.o(36044);
    return null;
  }
  
  public final void bU(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36041);
    Log.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(paramInt)));
    Object localObject1 = this.WQM.avt(paramInt);
    if ((localObject1 == null) || (((et)localObject1).field_msgId == 0L))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      AppMethodBeat.o(36041);
      return;
    }
    if (!f.j((ca)localObject1))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      AppMethodBeat.o(36041);
      return;
    }
    g localg = i((ca)localObject1, true);
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
        localObject1 = Long.valueOf(((et)localObject1).field_msgId);
        break;
      }
    }
    m((ca)localObject1, 3);
    if (avN(paramInt) != null) {
      a(avN(paramInt), (ca)localObject1, localg, true, false, paramInt);
    }
    if (this.WQM != null) {
      this.WQM.j((ca)localObject1, true);
    }
    if (paramBoolean)
    {
      localObject2 = q.hSM();
      Log.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((et)localObject1).field_msgId) });
      ((q)localObject2).WWj.add(Long.valueOf(((et)localObject1).field_msgId));
      com.tencent.mm.ay.q.bmi().a(localg.localId, ((et)localObject1).field_msgId, Integer.valueOf(paramInt), R.g.chat_img_template, (e.a)localObject2);
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.ay.q.bmi().a(localg.localId, ((et)localObject1).field_msgId, Integer.valueOf(paramInt), R.g.chat_img_template, this);
    AppMethodBeat.o(36041);
  }
  
  public final int cU(ca paramca)
  {
    AppMethodBeat.i(36009);
    if ((paramca != null) && (this.WSp.containsKey(Long.valueOf(paramca.field_msgId))))
    {
      int i = ((Integer)this.WSp.get(Long.valueOf(paramca.field_msgId))).intValue();
      AppMethodBeat.o(36009);
      return i;
    }
    AppMethodBeat.o(36009);
    return 0;
  }
  
  public final void cV(ca paramca)
  {
    AppMethodBeat.i(36042);
    g localg = k(paramca);
    if ((localg == null) || (paramca == null))
    {
      AppMethodBeat.o(36042);
      return;
    }
    if (this.WQM != null) {
      this.WQM.a(paramca, null, 1, ad.a.gid);
    }
    if (q.hSM().We(paramca.field_msgId))
    {
      q localq = q.hSM();
      localq.WWj.remove(Long.valueOf(paramca.field_msgId));
      com.tencent.mm.ay.q.bmi().a(localg.localId, paramca.field_msgId, 1, localq);
      com.tencent.mm.ay.q.bmi().C(localg.localId, paramca.field_msgId);
      AppMethodBeat.o(36042);
      return;
    }
    com.tencent.mm.ay.q.bmi().a(localg.localId, paramca.field_msgId, 1, this);
    com.tencent.mm.ay.q.bmi().C(localg.localId, paramca.field_msgId);
    AppMethodBeat.o(36042);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36008);
    super.detach();
    EventCenter.instance.removeListener(this.WSn);
    if (this.QbK != null)
    {
      localObject = this.QbK.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.QbK.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.WSq;
    ((i)localObject).WSB = null;
    ((i)localObject).CcA.clear();
    ((i)localObject).CcD.clear();
    ((i)localObject).CcC.clear();
    ((i)localObject).CcB.clear();
    ((i)localObject).WSA.clear();
    ((i)localObject).euK();
    if ((((i)localObject).krJ != null) && (!((i)localObject).krJ.isRecycled()))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", new Object[] { ((i)localObject).krJ.toString() });
      ((i)localObject).krJ.recycle();
      ((i)localObject).krJ = null;
    }
    com.tencent.mm.ay.q.bmi().a(this);
    localObject = q.hSM();
    if (equals(((q)localObject).WWk)) {
      ((q)localObject).WWk = null;
    }
    AppMethodBeat.o(36008);
  }
  
  public final u hRD()
  {
    AppMethodBeat.i(285253);
    Object localObject = this.WQM.hRF();
    if (localObject == null)
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(285253);
      return null;
    }
    int i = cU((ca)localObject);
    Log.i("MicroMsg.ImageGalleryHolderImage", "getCurResourceState, msgState: ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      localObject = u.WWJ;
      AppMethodBeat.o(285253);
      return localObject;
    case 5: 
    case 6: 
      localObject = u.WWI;
      AppMethodBeat.o(285253);
      return localObject;
    }
    localObject = u.WWK;
    AppMethodBeat.o(285253);
    return localObject;
  }
  
  public final g i(ca paramca, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(36014);
    if (!f.j(paramca))
    {
      AppMethodBeat.o(36014);
      return null;
    }
    if ((this.WQM == null) || (this.WQM.WQW == null))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
      AppMethodBeat.o(36014);
      return null;
    }
    if (!paramBoolean)
    {
      if (paramca.field_isSend == 1) {
        localObject2 = (g)this.WQM.WQW.WRw.get(Long.valueOf(paramca.field_msgId));
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramca.field_msgSvrId > 0L) {
          localObject1 = (g)this.WQM.WQW.WRv.get(Long.valueOf(paramca.field_msgSvrId));
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
        localObject2 = com.tencent.mm.ay.q.bmh().D(paramca.field_talker, l);
        localObject1 = localObject2;
        if (((g)localObject2).localId != 0L) {}
      }
      else
      {
        l = paramca.field_msgSvrId;
        localObject1 = com.tencent.mm.ay.q.bmh().C(paramca.field_talker, l);
        paramBoolean = true;
      }
      this.WQM.WQW.a(l, (g)localObject1, paramBoolean);
      localObject2 = localObject1;
    }
    AppMethodBeat.o(36014);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.h
 * JD-Core Version:    0.7.0.1
 */