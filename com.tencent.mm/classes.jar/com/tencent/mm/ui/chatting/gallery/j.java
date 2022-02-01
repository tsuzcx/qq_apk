package com.tencent.mm.ui.chatting.gallery;

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
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.davemorrissey.labs.subscaleview.view.ImageSource;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ag.a;
import com.tencent.mm.autogen.mmdata.rpt.ol;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.f.a;
import com.tencent.mm.modelimage.n;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.ImageOptimLib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.ab;
import com.tencent.mm.ui.chatting.RevokeMsgListener;
import com.tencent.mm.ui.chatting.RevokeMsgListener.a;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class j
  extends a
  implements f.a, f
{
  private static long MAGIC_FREE_BUFFER;
  private static boolean SHj;
  private HashMap<String, WeakReference<Bitmap>> Etw;
  private IListener aeBS;
  u aeBT;
  public HashMap<Long, Integer> aeBU;
  public final k aeBV;
  private HashMap<cc, String> aeBW;
  private HashMap<cc, String> aeBX;
  private long aeBY;
  int mScrollState;
  
  static
  {
    AppMethodBeat.i(36048);
    SHj = true;
    MAGIC_FREE_BUFFER = (Runtime.getRuntime().maxMemory() * 0.05D);
    AppMethodBeat.o(36048);
  }
  
  public j(h paramh)
  {
    super(paramh);
    AppMethodBeat.i(36007);
    this.aeBU = new HashMap();
    this.aeBV = new k(this);
    this.Etw = new HashMap();
    this.aeBW = new HashMap();
    this.aeBX = new HashMap();
    this.aeBY = 0L;
    this.mScrollState = 0;
    this.aeBS = new RevokeMsgListener(RevokeMsgListener.a.aelu, paramh.aeAB);
    this.aeBS.alive();
    paramh = m.a.aeCt.HOH.snapshot();
    this.aeBV.cL(paramh);
    s.jwr().aeFQ = this;
    AppMethodBeat.o(36007);
  }
  
  public static String a(cc paramcc, com.tencent.mm.modelimage.h paramh)
  {
    AppMethodBeat.i(36033);
    paramcc = a(paramcc, paramh, false);
    AppMethodBeat.o(36033);
    return paramcc;
  }
  
  private static String a(cc paramcc, com.tencent.mm.modelimage.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(36034);
    if (paramcc.field_isSend == 1)
    {
      paramcc = com.tencent.mm.modelimage.r.bKa().a(paramcc.field_talker, paramh);
      str = com.tencent.mm.modelimage.r.bKa().v(paramcc, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", new Object[] { paramcc, str });
      if (y.ZC(str))
      {
        AppMethodBeat.o(36034);
        return str;
      }
      paramcc = paramh.oGr;
      paramh = com.tencent.mm.modelimage.r.bKa().v(paramcc, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", new Object[] { paramcc, paramh });
      if (y.ZC(paramh))
      {
        AppMethodBeat.o(36034);
        return paramh;
      }
      AppMethodBeat.o(36034);
      return null;
    }
    if ((!paramBoolean) && (!paramh.bJD()))
    {
      Log.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(paramh.bJD()) });
      AppMethodBeat.o(36034);
      return null;
    }
    String str = paramh.oGr;
    if (paramh.bJE())
    {
      paramcc = com.tencent.mm.modelimage.r.bKa().a(paramcc.field_talker, paramh);
      if (paramcc != null)
      {
        paramcc = com.tencent.mm.modelimage.r.bKa().v(paramcc, "", "");
        if (y.ZC(paramcc)) {
          Log.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      paramh = paramcc;
      if (paramcc == null) {
        paramh = com.tencent.mm.modelimage.r.bKa().v(str, "", "");
      }
      Log.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[] { paramh });
      AppMethodBeat.o(36034);
      return paramh;
      paramcc = null;
    }
  }
  
  private void a(long paramLong, MultiTouchImageView paramMultiTouchImageView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(254584);
    if ((this.aeAg == null) || (this.aeAg.aeAB == null))
    {
      AppMethodBeat.o(254584);
      return;
    }
    Log.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), Integer.valueOf(paramBitmap.hashCode()) });
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.setEnableHorLongBmpMode(false);
      paramMultiTouchImageView.dU(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(null);
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.invalidate();
      if (this.aeBT != null) {
        this.aeBT.b(paramLong, paramMultiTouchImageView, paramString, paramBitmap);
      }
      AppMethodBeat.o(254584);
      return;
      ForceGpuUtil.decideLayerType((View)paramMultiTouchImageView.getParent(), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  private static void a(cc paramcc, r paramr, int paramInt)
  {
    AppMethodBeat.i(36019);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = com.tencent.mm.modelimage.r.bKa().X(paramcc.field_imgPath, true);
    r.bo(paramr.aeFB, 8);
    r.bo(paramr.aeFw, 8);
    r.bo(paramr.aeFF, 8);
    r.bo(paramr.aeFG, 8);
    paramr.jwo().aeFC.setVisibility(0);
    paramr.jwo().aeFE.setImageResource(R.k.image_download_fail_icon);
    if ((str == null) || (!y.ZC(str)))
    {
      paramr.jwo().aeFD.setText(R.l.gJF);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramInt == 6)
    {
      paramr.jwo().aeFD.setText(R.l.imgdownload_fail);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramcc.isClean())
    {
      paramr.jwo().aeFD.setText(R.l.gJC);
      AppMethodBeat.o(36019);
      return;
    }
    paramr.jwo().aeFD.setText(R.l.gJD);
    AppMethodBeat.o(36019);
  }
  
  private static void a(cc paramcc, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36039);
    Log.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(paramcc.field_msgId), paramString });
    h.b(MMApplicationContext.getContext(), paramcc, paramBoolean);
    AppMethodBeat.o(36039);
  }
  
  private void a(r paramr, cc paramcc, com.tencent.mm.modelimage.h paramh, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36017);
    a(paramr, paramcc, paramh, paramBoolean, true, paramInt);
    AppMethodBeat.o(36017);
  }
  
  private void a(r paramr, cc paramcc, com.tencent.mm.modelimage.h paramh, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(36018);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(paramBoolean1)));
    r.bo(paramr.aeFC, 8);
    String str1 = null;
    if (!paramBoolean1) {
      paramr.aeFF.setVisibility(0);
    }
    com.tencent.mm.modelimage.h localh = com.tencent.mm.modelimage.i.a(paramh);
    if ((paramBoolean1) && (paramInt == this.aeAg.aeAB.getCurrentItem())) {
      this.aeAg.aeAB.jvX();
    }
    if (paramBoolean1) {
      str1 = a(paramcc, paramh, true);
    }
    String str2 = str1;
    if (Util.isNullOrNil(str1)) {
      str2 = com.tencent.mm.modelimage.r.bKa().v(localh.oGt, "", "");
    }
    str1 = com.tencent.mm.modelimage.r.bKa().X(paramcc.field_imgPath, true);
    if (paramBoolean2) {
      a(paramr, str1, str2, paramcc);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = paramh.osy;
      int i = paramh.offset;
      if (paramInt == 0) {
        break label258;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label264;
      }
      paramr.jwn().aeFB.setVisibility(8);
    }
    for (;;)
    {
      paramr.jwn().aeFz.setVisibility(8);
      paramr.jwn().aeFy.setVisibility(8);
      paramr.jwn().aeFx.setVisibility(8);
      AppMethodBeat.o(36018);
      return;
      label258:
      l = 0L;
      break;
      label264:
      paramr.jwn().aeFB.setVisibility(0);
    }
  }
  
  private static void a(r paramr, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    AppMethodBeat.i(36026);
    Object localObject;
    int i;
    if (paramr != null) {
      if (paramr.aeFG != null)
      {
        localObject = paramr.aeFG;
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
    for (paramr.aeFH = true;; paramr.aeFH = false)
    {
      if (paramr.aeFF != null)
      {
        localObject = paramr.aeFF;
        i = j;
        if (paramBoolean2) {
          i = 0;
        }
        ((MultiTouchImageView)localObject).setVisibility(i);
        if (paramBoolean2) {
          paramr.aeFH = false;
        }
      }
      AppMethodBeat.o(36026);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, int paramInt, cc paramcc, r paramr)
  {
    AppMethodBeat.i(36024);
    boolean bool = a(true, paramMultiTouchImageView, paramString1, paramString2, false, paramInt, paramcc, paramr, null, false);
    AppMethodBeat.o(36024);
    return bool;
  }
  
  private boolean a(r paramr, cc paramcc, com.tencent.mm.modelimage.h paramh, int paramInt)
  {
    AppMethodBeat.i(36016);
    Log.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = d(paramcc, paramh);
    r.bo(paramr.aeFB, 8);
    String str1 = (String)this.aeBX.get(paramcc);
    paramh = str1;
    if (str1 == null)
    {
      paramh = com.tencent.mm.modelimage.r.bKa().X(paramcc.field_imgPath, true);
      this.aeBX.put(paramcc, paramh);
    }
    boolean bool = a(paramr, paramh, str2, paramcc);
    if ((paramInt == this.aeAg.aeAB.getCurrentItem()) && (this.aeAg.aeAF))
    {
      this.aeAg.dn(paramcc);
      this.aeAg.aeAF = false;
    }
    AppMethodBeat.o(36016);
    return bool;
  }
  
  private boolean a(r paramr, String paramString1, String paramString2, cc paramcc)
  {
    AppMethodBeat.i(36020);
    boolean bool = b(paramr, paramString1, paramString2, paramcc);
    AppMethodBeat.o(36020);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, final int paramInt, final cc paramcc, final r paramr, com.tencent.mm.modelimage.h paramh, boolean paramBoolean3)
  {
    AppMethodBeat.i(36025);
    Log.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt) });
    Object localObject2 = null;
    boolean bool1 = true;
    if ((paramString2 != null) && (y.ZC(paramString2))) {
      localObject2 = y.n(paramString2, false);
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
          if (y.ZC(paramString1))
          {
            localObject1 = y.n(paramString1, false);
            if (y.ZC(paramString1 + "hd")) {
              localObject1 = y.n(paramString1 + "hd", false);
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
    if (paramr == null)
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
      AppMethodBeat.o(36025);
      return false;
    }
    int i;
    label285:
    boolean bool2;
    if ((!((String)localObject1).equals(paramString1)) && (!paramBoolean3) && (bBi((String)localObject1)))
    {
      paramBoolean3 = true;
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", new Object[] { Boolean.valueOf(paramBoolean3), localObject1 });
      if ((paramr.aeFG == null) || (paramr.aeFG.getVisibility() != 0)) {
        break label406;
      }
      i = 1;
      if ((!paramBoolean3) || (i != 0)) {
        break label412;
      }
      bool2 = true;
      label298:
      if ((paramBoolean3) || (paramBoolean2) || (!this.aeBV.HOH.check(localObject1))) {
        break label424;
      }
      localObject2 = (Bitmap)this.aeBV.HOH.ct(localObject1);
      if (((Bitmap)localObject2).isRecycled()) {
        break label424;
      }
      Log.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[] { localObject1 });
      if (paramcc == null) {
        break label418;
      }
    }
    label406:
    label412:
    label418:
    for (long l = paramcc.field_msgId;; l = 0L)
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
    localObject2 = paramh;
    if (paramBoolean3)
    {
      if (paramr.aeFG == null)
      {
        AppMethodBeat.o(36025);
        return false;
      }
      localObject2 = paramh;
      if (paramh == null) {
        localObject2 = j(paramcc, true);
      }
      paramr.aeFG.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
      {
        public final void onImageLoadError(ImageDecodeResult paramAnonymousImageDecodeResult)
        {
          AppMethodBeat.i(36001);
          Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousImageDecodeResult.errCode), paramAnonymousImageDecodeResult.errMsg });
          com.tencent.mm.cr.b.aGG(paramAnonymousImageDecodeResult.errCode);
          j.a(j.this, this.aeBZ, paramr, paramInt);
          if (paramAnonymousImageDecodeResult.errCode == 4) {
            j.jvk();
          }
          AppMethodBeat.o(36001);
        }
        
        public final void onImageLoaded(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(35999);
          int i;
          if ((paramAnonymousBitmap != null) && (j.this.aeBV != null))
          {
            Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[] { this.aeBZ });
            k localk = j.this.aeBV;
            if (paramInt > 0)
            {
              i = paramInt;
              localk.g(i, paramAnonymousBitmap);
            }
          }
          else
          {
            j.c(paramr);
            if (j.a(j.this) != null) {
              if (paramcc == null) {
                break label139;
              }
            }
          }
          label139:
          for (long l = paramcc.field_msgId;; l = 0L)
          {
            j.a(j.this).b(l, paramr.aeFG, this.aeBZ, paramAnonymousBitmap);
            AppMethodBeat.o(35999);
            return;
            i = paramr.mPosition;
            break;
          }
        }
        
        public final void onPreviewLoadError(ImageDecodeResult paramAnonymousImageDecodeResult)
        {
          AppMethodBeat.i(36000);
          Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousImageDecodeResult.errCode), paramAnonymousImageDecodeResult.errMsg });
          AppMethodBeat.o(36000);
        }
        
        public final void onPreviewLoaded()
        {
          AppMethodBeat.i(35998);
          Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
          AppMethodBeat.o(35998);
        }
        
        public final void onPreviewReleased() {}
        
        public final void onTileLoadError(ImageDecodeResult paramAnonymousImageDecodeResult)
        {
          AppMethodBeat.i(36002);
          Log.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousImageDecodeResult.errCode), paramAnonymousImageDecodeResult.errMsg });
          j.a(paramcc, paramr);
          AppMethodBeat.o(36002);
        }
      });
    }
    if (!this.aeAg.aeAM)
    {
      if (paramInt >= 0)
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[] { Integer.valueOf(paramInt) });
        a(paramr, false, true);
        this.aeBV.e(paramMultiTouchImageView, paramInt);
      }
      if (!paramBoolean3) {
        break label784;
      }
      a(paramr, true, bool2);
      paramMultiTouchImageView = e(paramcc, (com.tencent.mm.modelimage.h)localObject2);
      paramString1 = this.aeBV;
      paramString2 = paramr.aeFG;
      i = paramInt;
      if (paramInt < 0) {
        i = paramr.mPosition;
      }
      paramString1.b(paramString2, (String)localObject1, paramMultiTouchImageView, i);
    }
    for (;;)
    {
      AppMethodBeat.o(36025);
      return bool1;
      if (paramBoolean3)
      {
        paramMultiTouchImageView = e(paramcc, (com.tencent.mm.modelimage.h)localObject2);
        a(paramr, true, bool2);
        paramString1 = paramr.aeFG;
        if (paramMultiTouchImageView != null) {}
        for (paramMultiTouchImageView = ImageSource.uri(paramMultiTouchImageView);; paramMultiTouchImageView = null)
        {
          a(paramString1, (String)localObject1, paramMultiTouchImageView);
          AppMethodBeat.o(36025);
          return bool1;
        }
      }
      Bitmap localBitmap = bcH((String)localObject1);
      paramh = localBitmap;
      if (localBitmap == null) {
        paramh = bcH(paramString1);
      }
      if (paramh == null) {
        break;
      }
      a(paramr, false, true);
      if (paramcc != null) {}
      for (l = paramcc.field_msgId;; l = 0L)
      {
        a(l, paramMultiTouchImageView, (String)localObject1, paramh);
        if (((String)localObject1).equals(paramString2))
        {
          this.aeBV.w((String)localObject1, paramh);
          this.aeBV.g(paramInt, paramh);
        }
        AppMethodBeat.o(36025);
        return bool1;
      }
      label784:
      a(paramr, false, true);
      paramString1 = this.aeBV;
      i = paramInt;
      if (paramInt < 0) {
        i = paramr.mPosition;
      }
      paramString1.k(paramMultiTouchImageView, (String)localObject1, i);
    }
  }
  
  public static boolean aCM(int paramInt)
  {
    return paramInt == 1;
  }
  
  private void aR(long paramLong, int paramInt)
  {
    AppMethodBeat.i(36011);
    this.aeBU.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(36011);
  }
  
  private boolean b(r paramr, String paramString1, String paramString2, cc paramcc)
  {
    AppMethodBeat.i(36021);
    r.bo(paramr.aeFF, 0);
    r.bo(paramr.aeFw, 8);
    r.bo(paramr.aeFB, 8);
    r.bo(paramr.aeFC, 8);
    boolean bool = a(paramr.aeFF, paramString1, paramString2, paramr.mPosition, paramcc, paramr);
    AppMethodBeat.o(36021);
    return bool;
  }
  
  protected static BitmapFactory.Options bBh(String paramString)
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
  
  private boolean bBi(String paramString)
  {
    AppMethodBeat.i(36023);
    if (!SHj)
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
      AppMethodBeat.o(36023);
      return false;
    }
    if (bt.H(this.aeAg.jvd()))
    {
      AppMethodBeat.o(36023);
      return false;
    }
    boolean bool = com.tencent.mm.cr.a.aen(paramString);
    AppMethodBeat.o(36023);
    return bool;
  }
  
  private static Bitmap bcH(String paramString)
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
        localObject3 = be(paramString, i, j);
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
  
  private static Bitmap be(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36030);
    String str = paramString + "_tmp.jpg";
    try
    {
      bool1 = d.rc(16);
      if (bool1)
      {
        AppMethodBeat.o(36030);
        return null;
      }
      bool1 = CrashReportFactory.hasDebuger();
      if (!bool1) {
        try
        {
          i = Util.getInt(com.tencent.mm.k.i.aRC().getValue("UseOptImageRecv"), 0);
          bh.bCz();
          com.tencent.mm.b.p localp = new com.tencent.mm.b.p(c.getUin());
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
      y.bDX(y.bEo(str));
      y.O(paramString, str, false);
      bool1 = MMNativeJpeg.IsJpegFile(str);
      bool2 = MMNativeJpeg.isProgressive(str);
      bool3 = ImageOptimLib.checkIntegrity(str);
      j = (int)y.bEl(str);
      if ((!bool1) || (!bool2)) {
        break label443;
      }
      if (!bool3) {
        break label437;
      }
      localBitmap1 = MMNativeJpeg.decodeAsBitmap(str);
    }
    finally
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
        Log.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[] { paramString, Util.stackTraceToString(localThrowable) });
        localObject1 = localBitmap2;
        continue;
        Object localObject3 = null;
        continue;
        localObject3 = null;
      }
    }
    if (localBitmap1 != null) {}
    for (i = j;; i = 0 - j)
    {
      Bitmap localBitmap2 = localBitmap1;
      try
      {
        j.a.x(paramString, paramInt2, paramInt1, i);
        localBitmap2 = localBitmap1;
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localBitmap1, paramString });
        y.deleteFile(str);
        AppMethodBeat.o(36030);
        return localBitmap1;
      }
      finally
      {
        Object localObject1;
        break;
      }
    }
  }
  
  private String d(cc paramcc, com.tencent.mm.modelimage.h paramh)
  {
    AppMethodBeat.i(36015);
    String str2 = (String)this.aeBW.get(paramcc);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(paramcc, paramh, false);
      if ((str1 == null) || (str1.length() == 0))
      {
        AppMethodBeat.o(36015);
        return null;
      }
      this.aeBW.put(paramcc, str1);
    }
    AppMethodBeat.o(36015);
    return str1;
  }
  
  private static String e(cc paramcc, com.tencent.mm.modelimage.h paramh)
  {
    AppMethodBeat.i(36035);
    if ((paramcc == null) || (paramh == null))
    {
      AppMethodBeat.o(36035);
      return null;
    }
    if (paramcc.field_isSend == 1)
    {
      paramcc = paramh.oGt;
      paramh = com.tencent.mm.modelimage.r.bKa().v(paramcc, "", "") + "hd";
      Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { paramcc, paramh });
      if ((!Util.isNullOrNil(paramh)) && (y.ZC(paramh)))
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
        AppMethodBeat.o(36035);
        return paramh;
      }
      paramh = com.tencent.mm.modelimage.r.bKa().v(paramcc, "", "");
      Log.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", new Object[] { paramcc, paramh });
      if ((!Util.isNullOrNil(paramh)) && (y.ZC(paramh)))
      {
        Log.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
        AppMethodBeat.o(36035);
        return paramh;
      }
      AppMethodBeat.o(36035);
      return null;
    }
    if (!paramh.bJD())
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
      AppMethodBeat.o(36035);
      return null;
    }
    paramcc = paramh.oGt;
    paramh = com.tencent.mm.modelimage.r.bKa().v(paramcc, "", "") + "hd";
    Log.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { paramcc, paramh });
    if ((!Util.isNullOrNil(paramh)) && (y.ZC(paramh)))
    {
      Log.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
      AppMethodBeat.o(36035);
      return paramh;
    }
    AppMethodBeat.o(36035);
    return null;
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
  
  private int i(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(36038);
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      paramObject = this.aeAg.aBV(i);
      if ((paramObject != null) && (paramObject.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    paramObject = this.aeAg.adVb.values().iterator();
    while (paramObject.hasNext())
    {
      i = ((Integer)paramObject.next()).intValue();
      cc localcc = this.aeAg.aBV(i);
      if ((localcc != null) && (localcc.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    AppMethodBeat.o(36038);
    return -1;
  }
  
  public static void jvk()
  {
    SHj = false;
  }
  
  public static com.tencent.mm.modelimage.h k(cc paramcc)
  {
    AppMethodBeat.i(36013);
    if (!h.j(paramcc))
    {
      AppMethodBeat.o(36013);
      return null;
    }
    long l;
    if (paramcc.field_isSend == 1)
    {
      l = paramcc.field_msgId;
      com.tencent.mm.modelimage.h localh2 = com.tencent.mm.modelimage.r.bKa().H(paramcc.field_talker, l);
      if (localh2 != null)
      {
        localh1 = localh2;
        if (localh2.localId != 0L) {}
      }
      else
      {
        l = paramcc.field_msgSvrId;
      }
    }
    for (com.tencent.mm.modelimage.h localh1 = com.tencent.mm.modelimage.r.bKa().G(paramcc.field_talker, l);; localh1 = com.tencent.mm.modelimage.r.bKa().G(paramcc.field_talker, l))
    {
      AppMethodBeat.o(36013);
      return localh1;
      l = paramcc.field_msgSvrId;
    }
  }
  
  private void m(cc paramcc, int paramInt)
  {
    AppMethodBeat.i(36010);
    this.aeBU.put(Long.valueOf(paramcc.field_msgId), Integer.valueOf(paramInt));
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
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(36036);
    if ((this.aeAg == null) || (this.aeAg.aeAB == null))
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
    if (s.jwr().Ap(paramLong2))
    {
      i = i(paramLong2, paramObject);
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
      if (this.aeAg.aAZ(i) == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      paramObject = (r)this.aeAg.aAZ(i).getTag();
      if (paramObject == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.aeAg.aeAB.getCurrentItem()) && (aCM(paramInt1)))
        {
          Log.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.aeAg.aeAB.aCU(paramInt2);
        }
        paramp = (n)paramp;
        boolean bool1 = MMNativeJpeg.isProgressive(paramp.oIa);
        boolean bool2 = paramp.oIc;
        paramLong1 = Util.ticksToNow(this.aeBY);
        j.a.iV(paramp.oIa, paramInt4);
        Log.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramp.oIa });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break label679;
        }
        this.aeBY = Util.currentTicks();
        paramp = this.aeAg.aBV(i);
        if (paramp == null)
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
      com.tencent.mm.modelimage.h localh = j(paramp, true);
      if (a(false, paramObject.aeFF, com.tencent.mm.modelimage.r.bKa().X(paramp.field_imgPath, true), a(paramp, localh, true), true, -1, paramp, paramObject, localh, true))
      {
        r.bo(paramObject.aeFz, 8);
        r.bo(paramObject.aeFC, 8);
        if ((i == this.aeAg.aeAB.getCurrentItem()) && (!aCM(paramInt1))) {
          if (paramInt2 > 50)
          {
            r.bo(paramObject.aeFB, 8);
            if (this.aeAg != null)
            {
              this.aeAg.a(paramp, localh, paramInt1, ag.a.inX);
              AppMethodBeat.o(36036);
            }
          }
          else
          {
            r.bo(paramObject.aeFB, 0);
          }
        }
      }
      label679:
      AppMethodBeat.o(36036);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, final int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(36037);
    if ((this.aeAg == null) || (this.aeAg.aeAB == null))
    {
      AppMethodBeat.o(36037);
      return;
    }
    if (s.jwr().Ap(paramLong2))
    {
      paramInt2 = i(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        bh.bCz();
        a(c.bzD().sl(paramLong2), "background", false);
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
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 3L, 1L, true);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = null;
      if (this.aeAg.aAZ(paramInt2) != null) {
        paramObject = (r)this.aeAg.aAZ(paramInt2).getTag();
      }
      boolean bool = s.jwr().Ap(paramLong2);
      if ((paramInt3 != 0) || (paramInt4 != 0))
      {
        if (bool)
        {
          paramObject = this.aeAg.aBV(paramInt2);
          paramString = "hd_failed:".concat(String.valueOf(paramInt2));
          if (paramInt2 == this.aeAg.aeAB.getCurrentItem())
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
          aR(paramLong2, 5);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 0L, 1L, true);
        }
        for (;;)
        {
          Log.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
          this.aeAg.aeAG.aCu(paramInt2);
          if (this.aeAg != null) {
            this.aeAg.a(this.aeAg.aBV(paramInt2), null, paramInt1, ag.a.inZ);
          }
          AppMethodBeat.o(36037);
          return;
          bool = false;
          break;
          label394:
          aR(paramLong2, 6);
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 1L, 1L, true);
        }
      }
      if (bool)
      {
        paramString = this.aeAg.aBV(paramInt2);
        paramp = "hd_suc:".concat(String.valueOf(paramInt2));
        if (paramInt2 != this.aeAg.aeAB.getCurrentItem()) {
          break label561;
        }
      }
      label561:
      for (bool = true;; bool = false)
      {
        a(paramString, paramp, bool);
        Log.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.aeAg.aeAB.getCurrentItem(), new Object[0]);
        aR(paramLong2, 4);
        paramString = this.aeAg.aBV(paramInt2);
        paramp = j(paramString, true);
        if ((paramString != null) && (paramp != null)) {
          break;
        }
        AppMethodBeat.o(36037);
        return;
      }
      if (this.aeBT != null) {
        this.aeBT.aT(paramString.field_msgId, paramInt1);
      }
      if (paramObject != null)
      {
        if (paramInt2 == this.aeAg.aeAB.getCurrentItem())
        {
          if (!aCM(paramInt1)) {
            break label866;
          }
          ImageGalleryUI localImageGalleryUI = this.aeAg.aeAB;
          localImageGalleryUI.jvG();
          localImageGalleryUI.jvG();
          Animation localAnimation = ImageGalleryUI.aCT(1000);
          localAnimation.setAnimationListener(new ImageGalleryUI.41(localImageGalleryUI));
          localImageGalleryUI.dSU();
          localImageGalleryUI.jvn().aeDa.setVisibility(0);
          localImageGalleryUI.jvn().aeDb.setVisibility(8);
          localImageGalleryUI.jvn().aeDc.setVisibility(8);
          localImageGalleryUI.jvn().aeDd.setVisibility(0);
          localImageGalleryUI.jvn().aeDd.startAnimation(localAnimation);
        }
        while (a(false, paramObject.aeFF, com.tencent.mm.modelimage.r.bKa().X(paramString.field_imgPath, true), a(paramString, paramp, true), true, -1, paramString, paramObject, paramp, false))
        {
          r.bo(paramObject.aeFw, 8);
          r.bo(paramObject.aeFB, 8);
          r.bo(paramObject.aeFC, 8);
          if ((dr(paramString) == 4) && (this.aeAg.aeAF))
          {
            this.aeAg.dn(paramString);
            this.aeAg.aeAF = false;
          }
          if (this.aeAg == null) {
            break label910;
          }
          this.aeAg.a(paramString, paramp, paramInt1, ag.a.inX);
          AppMethodBeat.o(36037);
          return;
          label866:
          paramObject.aeFF.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36003);
              if ((j.this.aeAg == null) || (j.this.aeAg.aeAB == null))
              {
                AppMethodBeat.o(36003);
                return;
              }
              j.this.aeAg.aeAB.aCP(paramInt2);
              AppMethodBeat.o(36003);
            }
          });
        }
        Log.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 2L, 1L, true);
      }
      label910:
      AppMethodBeat.o(36037);
      return;
    }
  }
  
  public final void a(long paramLong, View paramView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(254632);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(254632);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.hashCode();
      int j = paramBitmap.hashCode();
      int k = this.aeBV.HOI.indexOfValue(i);
      if (k >= 0) {
        this.aeBV.HOI.removeAt(k);
      }
      this.aeBV.HOI.put(j, i);
      if ((paramView instanceof MultiTouchImageView))
      {
        a(paramLong, (MultiTouchImageView)paramView, paramString, paramBitmap);
        AppMethodBeat.o(254632);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageBitmap(paramBitmap);
      }
    }
    AppMethodBeat.o(254632);
  }
  
  public final void a(WxImageView paramWxImageView, String paramString, ImageSource paramImageSource)
  {
    AppMethodBeat.i(36029);
    BitmapFactory.Options localOptions = bBh(paramString);
    if (localOptions != null)
    {
      paramWxImageView.setOrientation(BackwardSupportUtil.ExifHelper.getExifOrientation(paramString));
      paramWxImageView.dU(localOptions.outWidth, localOptions.outHeight);
      paramWxImageView.jma();
      paramWxImageView.a(paramString, paramImageSource);
    }
    AppMethodBeat.o(36029);
  }
  
  public final boolean a(r paramr, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(36012);
    super.a(paramr, paramcc, paramInt);
    if ((paramr == null) || (paramcc == null) || (paramInt < 0))
    {
      AppMethodBeat.o(36012);
      return false;
    }
    i = dr(paramcc);
    Log.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", new Object[] { Integer.valueOf(paramr.aeFF.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(i) });
    r.bo(paramr.aeFw, 8);
    try
    {
      com.tencent.mm.modelimage.h localh1 = j(paramcc, false);
      if (localh1 != null) {
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
        if (paramcc.isClean())
        {
          bool1 = true;
        }
        else
        {
          Object localObject = d(paramcc, localNullPointerException);
          if ((!localNullPointerException.bJD()) || ((localObject != null) && (y.ZC((String)localObject))))
          {
            long l1 = cn.bDu();
            long l2 = paramcc.getCreateTime();
            if ((l1 - l2 <= 259200000L) || ((!Util.isNullOrNil((String)localObject)) && (y.ZC((String)localObject)))) {
              break label1071;
            }
            Log.i("MicroMsg.ImageGalleryHolderImage", "cur time: %s, msg time: %s, path: %s.", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject });
            i = 1;
            break label1060;
            if (a(paramr, paramcc, localNullPointerException, paramInt))
            {
              bool1 = false;
              boolean bool2 = false;
              localObject = com.tencent.mm.modelimage.r.bKa().af(paramcc);
              Log.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.modelimage.h)localObject).localId), Long.valueOf(((com.tencent.mm.modelimage.h)localObject).oGz), Long.valueOf(((com.tencent.mm.modelimage.h)localObject).hTh), Integer.valueOf(((com.tencent.mm.modelimage.h)localObject).oGB), Integer.valueOf(((com.tencent.mm.modelimage.h)localObject).osy) });
              if (localObject != null) {
                if (!Util.isEqual(((com.tencent.mm.modelimage.h)localObject).oGB, 0))
                {
                  localObject = com.tencent.mm.modelimage.r.bKa().wq(((com.tencent.mm.modelimage.h)localObject).oGB);
                  Log.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.modelimage.h)localObject).localId), Long.valueOf(((com.tencent.mm.modelimage.h)localObject).oGz), Long.valueOf(((com.tencent.mm.modelimage.h)localObject).hTh), Integer.valueOf(((com.tencent.mm.modelimage.h)localObject).oGB), Integer.valueOf(((com.tencent.mm.modelimage.h)localObject).osy) });
                  i = ((com.tencent.mm.modelimage.h)localObject).osy;
                  int j = (int)y.bEl(com.tencent.mm.modelimage.r.bKa().v(localNullPointerException.oGr, "", ""));
                  bool1 = bool2;
                  if (paramcc.field_isSend == 1)
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
                if ((!bool1) && (!localNullPointerException.bJD())) {
                  break label756;
                }
                m(paramcc, 4);
                break;
                i = ((com.tencent.mm.modelimage.h)localObject).osy;
                break label627;
                Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
              }
              m(paramcc, 1);
            }
            com.tencent.mm.modelimage.h localh2;
            for (;;)
            {
              ac.am(paramcc);
              i = com.tencent.mm.modelimage.r.bKb().a(localNullPointerException.localId, paramcc.field_msgId, 0, Integer.valueOf(paramInt), R.g.chat_img_template, this, 0, true);
              if (this.aeAg != null) {
                this.aeAg.k(paramcc, false);
              }
              Log.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[] { Integer.valueOf(i) });
              if (i != -2) {
                break label985;
              }
              Log.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
              localh2 = j(paramcc, true);
              if (localh2 != null) {
                break label886;
              }
              Log.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
              break;
              Log.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
              m(paramcc, 2);
            }
            if (a(paramr, paramcc, localh2, paramInt))
            {
              if ((paramcc.field_isSend == 1) || (localh2.bJD()))
              {
                m(paramcc, 4);
                continue;
              }
              m(paramcc, 1);
            }
            for (;;)
            {
              Log.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(localh2.localId), Boolean.valueOf(localh2.bJD()) });
              a(paramr, paramcc, localh2, false, paramInt);
              break;
              m(paramcc, 2);
            }
            a(paramr, paramcc, localh2, false, paramInt);
            continue;
            a(paramr, paramcc, localh2, paramInt);
            continue;
            a(paramr, paramcc, localh2, false, paramInt);
            continue;
            a(paramr, paramcc, localh2, true, paramInt);
            continue;
            a(paramcc, paramr, i);
            paramr.convertView.invalidate();
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
    paramr.aeFF.adVB = bt.L(paramcc);
    if (paramr.aeFF.adVB != 0.0F)
    {
      paramr = new ol();
      paramr.inO = paramcc.field_msgSvrId;
      paramr.iUM = paramcc.getType();
      paramr.jjm = bt.G(paramcc);
      paramr.ikE = 2L;
      paramr.bMH();
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
        if (paramcc.field_isSend != 1) {
          break label305;
        }
        bool1 = paramcc.isClean();
        if (!bool1) {
          break label429;
        }
        m(paramcc, 5);
        a(paramcc, paramr, 5);
      }
    }
  }
  
  public final Bitmap aCv(int paramInt)
  {
    AppMethodBeat.i(36044);
    if (this.aeAg == null)
    {
      AppMethodBeat.o(36044);
      return null;
    }
    cc localcc = this.aeAg.aeAC.aCK(paramInt);
    if (localcc != null)
    {
      Object localObject = h.dk(localcc);
      if ((localObject == h.b.aeBj) || (localObject == h.b.aeBk))
      {
        AppMethodBeat.o(36044);
        return null;
      }
      String str = (String)this.aeBX.get(localcc);
      localObject = str;
      if (str == null)
      {
        localObject = com.tencent.mm.modelimage.r.bKa().X(localcc.field_imgPath, true);
        this.aeBX.put(localcc, localObject);
      }
      str = (String)localObject + "hd";
      if (y.ZC(str))
      {
        localObject = bcH(str);
        AppMethodBeat.o(36044);
        return localObject;
      }
      localObject = bcH((String)localObject);
      AppMethodBeat.o(36044);
      return localObject;
    }
    AppMethodBeat.o(36044);
    return null;
  }
  
  public final Bitmap aEY(String paramString)
  {
    AppMethodBeat.i(369649);
    paramString = bcH(paramString);
    AppMethodBeat.o(369649);
    return paramString;
  }
  
  public final void cH(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36041);
    Log.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(paramInt)));
    Object localObject1 = this.aeAg.aBV(paramInt);
    if ((localObject1 == null) || (((fi)localObject1).field_msgId == 0L))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      AppMethodBeat.o(36041);
      return;
    }
    if (!h.j((cc)localObject1))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.modelimage.h localh = j((cc)localObject1, true);
    Object localObject2;
    if ((localh == null) || (localh.localId == 0L))
    {
      localObject2 = new StringBuilder("viewHdImg fail, msgLocalId = ");
      if (localObject1 == null)
      {
        localObject1 = "null";
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", imgLocalId = ");
        if (localh != null) {
          break label178;
        }
      }
      label178:
      for (localObject1 = "null";; localObject1 = Long.valueOf(localh.localId))
      {
        Log.e("MicroMsg.ImageGalleryHolderImage", localObject1);
        AppMethodBeat.o(36041);
        return;
        localObject1 = Long.valueOf(((fi)localObject1).field_msgId);
        break;
      }
    }
    m((cc)localObject1, 3);
    if (aCt(paramInt) != null) {
      a(aCt(paramInt), (cc)localObject1, localh, true, false, paramInt);
    }
    if (this.aeAg != null) {
      this.aeAg.k((cc)localObject1, true);
    }
    if (paramBoolean)
    {
      localObject2 = s.jwr();
      Log.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((fi)localObject1).field_msgId) });
      ((s)localObject2).aeFP.add(Long.valueOf(((fi)localObject1).field_msgId));
      com.tencent.mm.modelimage.r.bKb().a(localh.localId, ((fi)localObject1).field_msgId, Integer.valueOf(paramInt), R.g.chat_img_template, (f.a)localObject2);
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.modelimage.r.bKb().a(localh.localId, ((fi)localObject1).field_msgId, Integer.valueOf(paramInt), R.g.chat_img_template, this);
    AppMethodBeat.o(36041);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36008);
    super.detach();
    this.aeBS.dead();
    if (this.Etw != null)
    {
      localObject = this.Etw.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.Etw.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          Log.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.aeBV;
    ((k)localObject).aeCe = null;
    ((k)localObject).HOD.clear();
    ((k)localObject).HOG.clear();
    ((k)localObject).HOF.clear();
    ((k)localObject).HOE.clear();
    ((k)localObject).aeCd.clear();
    ((k)localObject).fBF();
    if ((((k)localObject).mVG != null) && (!((k)localObject).mVG.isRecycled()))
    {
      Log.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", new Object[] { ((k)localObject).mVG.toString() });
      ((k)localObject).mVG.recycle();
      ((k)localObject).mVG = null;
    }
    com.tencent.mm.modelimage.r.bKb().a(this);
    localObject = s.jwr();
    if (equals(((s)localObject).aeFQ)) {
      ((s)localObject).aeFQ = null;
    }
    AppMethodBeat.o(36008);
  }
  
  public final int dr(cc paramcc)
  {
    AppMethodBeat.i(36009);
    if ((paramcc != null) && (this.aeBU.containsKey(Long.valueOf(paramcc.field_msgId))))
    {
      int i = ((Integer)this.aeBU.get(Long.valueOf(paramcc.field_msgId))).intValue();
      AppMethodBeat.o(36009);
      return i;
    }
    AppMethodBeat.o(36009);
    return 0;
  }
  
  public final void ds(cc paramcc)
  {
    AppMethodBeat.i(36042);
    com.tencent.mm.modelimage.h localh = k(paramcc);
    if ((localh == null) || (paramcc == null))
    {
      AppMethodBeat.o(36042);
      return;
    }
    if (this.aeAg != null) {
      this.aeAg.a(paramcc, null, 1, ag.a.inY);
    }
    if (s.jwr().Ap(paramcc.field_msgId))
    {
      s locals = s.jwr();
      locals.aeFP.remove(Long.valueOf(paramcc.field_msgId));
      com.tencent.mm.modelimage.r.bKb().a(localh.localId, paramcc.field_msgId, 1, locals);
      com.tencent.mm.modelimage.r.bKb().Y(localh.localId, paramcc.field_msgId);
      AppMethodBeat.o(36042);
      return;
    }
    com.tencent.mm.modelimage.r.bKb().a(localh.localId, paramcc.field_msgId, 1, this);
    com.tencent.mm.modelimage.r.bKb().Y(localh.localId, paramcc.field_msgId);
    AppMethodBeat.o(36042);
  }
  
  public final com.tencent.mm.modelimage.h j(cc paramcc, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(36014);
    if (!h.j(paramcc))
    {
      AppMethodBeat.o(36014);
      return null;
    }
    if ((this.aeAg == null) || (this.aeAg.aeAC == null))
    {
      Log.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
      AppMethodBeat.o(36014);
      return null;
    }
    if (!paramBoolean)
    {
      if (paramcc.field_isSend == 1) {
        localObject2 = (com.tencent.mm.modelimage.h)this.aeAg.aeAC.aeBb.get(Long.valueOf(paramcc.field_msgId));
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramcc.field_msgSvrId > 0L) {
          localObject1 = (com.tencent.mm.modelimage.h)this.aeAg.aeAC.aeBa.get(Long.valueOf(paramcc.field_msgSvrId));
        }
      }
    }
    localObject2 = localObject1;
    long l;
    if (localObject1 == null)
    {
      paramBoolean = false;
      if (paramcc.field_isSend != 1) {
        break label247;
      }
      l = paramcc.field_msgId;
      localObject2 = com.tencent.mm.modelimage.r.bKa().H(paramcc.field_talker, l);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((com.tencent.mm.modelimage.h)localObject2).localId != 0L) {}
      }
      else
      {
        l = paramcc.field_msgSvrId;
        localObject1 = com.tencent.mm.modelimage.r.bKa().G(paramcc.field_talker, l);
      }
    }
    for (paramBoolean = true;; paramBoolean = true)
    {
      this.aeAg.aeAC.a(l, (com.tencent.mm.modelimage.h)localObject1, paramBoolean);
      localObject2 = localObject1;
      AppMethodBeat.o(36014);
      return localObject2;
      label247:
      l = paramcc.field_msgSvrId;
      localObject1 = com.tencent.mm.modelimage.r.bKa().G(paramcc.field_talker, l);
    }
  }
  
  public final w jvb()
  {
    AppMethodBeat.i(254650);
    Object localObject = this.aeAg.jvd();
    if (localObject == null)
    {
      Log.i("MicroMsg.ImageGalleryHolderImage", "getCurResourceState, msgInfo is null");
      AppMethodBeat.o(254650);
      return null;
    }
    int i = dr((cc)localObject);
    Log.i("MicroMsg.ImageGalleryHolderImage", "getCurResourceState, msgState: ".concat(String.valueOf(i)));
    switch (i)
    {
    default: 
      localObject = w.aeGn;
      AppMethodBeat.o(254650);
      return localObject;
    case 5: 
    case 6: 
      localObject = w.aeGm;
      AppMethodBeat.o(254650);
      return localObject;
    }
    localObject = w.aeGo;
    AppMethodBeat.o(254650);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j
 * JD-Core Version:    0.7.0.1
 */