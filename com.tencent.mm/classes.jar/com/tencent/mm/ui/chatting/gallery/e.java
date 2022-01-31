package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.as.d.a;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.graphics.ui.WxBaseImageView;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.an.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
  extends a
  implements d.a, f.a
{
  private static boolean vvd = true;
  private static long vvf = (Runtime.getRuntime().maxMemory() * 0.05D);
  public HashMap<Long, Integer> ifu = new HashMap();
  int lf = 0;
  private HashMap<String, WeakReference<Bitmap>> rlK = new HashMap();
  private com.tencent.mm.sdk.b.c vuZ;
  public final f vva = new f(this);
  private HashMap<bi, String> vvb = new HashMap();
  private HashMap<bi, String> vvc = new HashMap();
  private b vve = new b();
  private long vvg = 0L;
  
  public e(c paramc)
  {
    super(paramc);
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.udP;
    paramc = new an(an.a.vmM, paramc.vtJ);
    this.vuZ = paramc;
    locala.c(paramc);
    paramc = g.a.vvC.kJt.snapshot();
    this.vva.ay(paramc);
    l.cGI().vxF = this;
  }
  
  private static boolean Hw(int paramInt)
  {
    return paramInt == 1;
  }
  
  private int a(long paramLong, Object paramObject)
  {
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      paramObject = this.vtH.GW(i);
      if ((paramObject != null) && (paramObject.field_msgId == paramLong)) {
        return i;
      }
    }
    paramObject = this.vtH.uZv.values().iterator();
    while (paramObject.hasNext())
    {
      i = ((Integer)paramObject.next()).intValue();
      bi localbi = this.vtH.GW(i);
      if ((localbi != null) && (localbi.field_msgId == paramLong)) {
        return i;
      }
    }
    return -1;
  }
  
  private static String a(bi parambi, com.tencent.mm.as.e parame, boolean paramBoolean)
  {
    if (parambi.field_isSend == 1)
    {
      parambi = com.tencent.mm.as.o.OJ().d(parame);
      parambi = com.tencent.mm.as.o.OJ().o(parambi, "", "");
      if (com.tencent.mm.vfs.e.bK(parambi)) {}
      do
      {
        return parambi;
        parambi = parame.enq;
        parame = com.tencent.mm.as.o.OJ().o(parambi, "", "");
        parambi = parame;
      } while (com.tencent.mm.vfs.e.bK(parame));
      return null;
    }
    if ((!paramBoolean) && (!parame.Oq()))
    {
      y.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(parame.Oq()) });
      return null;
    }
    String str = parame.enq;
    if (parame.Or())
    {
      parambi = com.tencent.mm.as.o.OJ().d(parame);
      if (parambi != null)
      {
        parambi = com.tencent.mm.as.o.OJ().o(parambi, "", "");
        if (com.tencent.mm.vfs.e.bK(parambi)) {
          y.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      parame = parambi;
      if (parambi == null) {
        parame = com.tencent.mm.as.o.OJ().o(str, "", "");
      }
      y.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[] { parame });
      return parame;
      parambi = null;
    }
  }
  
  private static void a(bi parambi, k paramk, int paramInt)
  {
    y.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true);
    k.X(paramk.vxr, 8);
    k.X(paramk.vxm, 8);
    k.X(paramk.vxv, 8);
    k.X(paramk.vxw, 8);
    paramk.cGF().vxs.setVisibility(0);
    paramk.cGF().vxu.setImageResource(R.k.image_download_fail_icon);
    if ((str == null) || (!com.tencent.mm.vfs.e.bK(str)))
    {
      paramk.cGF().vxt.setText(R.l.imgdownload_fail_tips);
      return;
    }
    if (paramInt == 6)
    {
      paramk.cGF().vxt.setText(R.l.imgdownload_fail);
      return;
    }
    if (parambi.cvx())
    {
      paramk.cGF().vxt.setText(R.l.imgdownload_cleaned);
      return;
    }
    paramk.cGF().vxt.setText(R.l.imgdownload_expired);
  }
  
  private static void a(bi parambi, String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(parambi.field_msgId), paramString });
    c.b(ae.getContext(), parambi, paramBoolean);
  }
  
  private void a(k paramk, bi parambi, com.tencent.mm.as.e parame, boolean paramBoolean, int paramInt)
  {
    a(paramk, parambi, parame, paramBoolean, true, paramInt);
  }
  
  private void a(k paramk, bi parambi, com.tencent.mm.as.e parame, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    y.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = " + paramBoolean1);
    k.X(paramk.vxs, 8);
    String str = null;
    if (!paramBoolean1) {
      paramk.vxv.setVisibility(0);
    }
    com.tencent.mm.as.e locale = com.tencent.mm.as.f.a(parame);
    if ((paramBoolean1) && (paramInt == this.vtH.vtJ.getCurrentItem()))
    {
      localObject = this.vtH.vtJ;
      ((ImageGalleryUI)localObject).gs(true);
      ((ImageGalleryUI)localObject).cGp();
      ((ImageGalleryUI)localObject).cGe().vvQ.setVisibility(0);
      ((ImageGalleryUI)localObject).cGe().vvR.setVisibility(8);
      ((ImageGalleryUI)localObject).cGe().vvS.setVisibility(0);
      ((ImageGalleryUI)localObject).cGe().vvT.setVisibility(8);
      ((ImageGalleryUI)localObject).cGr();
      ((ImageGalleryUI)localObject).cGs();
      ((ImageGalleryUI)localObject).cGe().vvS.setText("0%");
    }
    if (paramBoolean1) {
      str = a(parambi, parame, true);
    }
    Object localObject = str;
    if (bk.bl(str)) {
      localObject = com.tencent.mm.as.o.OJ().o(locale.ens, "", "");
    }
    str = com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true);
    if (paramBoolean2) {
      a(paramk, str, (String)localObject, parambi);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = parame.ebK;
      int i = parame.offset;
      if (paramInt == 0) {
        break label337;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label343;
      }
      paramk.cGE().vxr.setVisibility(8);
    }
    for (;;)
    {
      paramk.cGE().vxp.setVisibility(8);
      paramk.cGE().vxo.setVisibility(8);
      paramk.cGE().vxn.setVisibility(8);
      return;
      label337:
      l = 0L;
      break;
      label343:
      paramk.cGE().vxr.setVisibility(0);
    }
  }
  
  private static void a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (paramk != null)
    {
      if (paramk.vxw != null)
      {
        WxImageView localWxImageView = paramk.vxw;
        if (!paramBoolean1) {
          break label57;
        }
        i = 0;
        localWxImageView.setVisibility(i);
      }
      if (paramk.vxv != null)
      {
        paramk = paramk.vxv;
        if (!paramBoolean2) {
          break label63;
        }
      }
    }
    label57:
    label63:
    for (int i = j;; i = 8)
    {
      paramk.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(k paramk, bi parambi, com.tencent.mm.as.e parame, int paramInt)
  {
    y.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = c(parambi, parame);
    k.X(paramk.vxr, 8);
    String str1 = (String)this.vvc.get(parambi);
    parame = str1;
    if (str1 == null)
    {
      parame = com.tencent.mm.as.o.OJ().F(parambi.field_imgPath, true);
      this.vvc.put(parambi, parame);
    }
    boolean bool = a(paramk, parame, str2, parambi);
    if ((paramInt == this.vtH.vtJ.getCurrentItem()) && (this.vtH.vtN))
    {
      this.vtH.bn(parambi);
      this.vtH.vtN = false;
    }
    return bool;
  }
  
  private boolean a(k paramk, String paramString1, String paramString2, bi parambi)
  {
    k.X(paramk.vxv, 0);
    k.X(paramk.vxm, 8);
    k.X(paramk.vxr, 8);
    k.X(paramk.vxs, 8);
    return a(true, paramk.vxv, paramString1, paramString2, false, paramk.mPosition, parambi, paramk, null, -1, false);
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, int paramInt1, bi parambi, k paramk, com.tencent.mm.as.e parame, int paramInt2, boolean paramBoolean3)
  {
    y.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt1) });
    Object localObject2 = null;
    boolean bool1 = true;
    if ((paramString2 != null) && (com.tencent.mm.vfs.e.bK(paramString2)))
    {
      localObject2 = paramString2;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramString1 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.vfs.e.bK(paramString1)) {
            if (!com.tencent.mm.vfs.e.bK(paramString1 + "hd")) {
              break label794;
            }
          }
        }
      }
    }
    label794:
    for (Object localObject1 = paramString1 + "hd";; localObject1 = paramString1)
    {
      if (localObject1 == null)
      {
        y.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", new Object[] { paramString2 });
        return false;
        bool1 = false;
        break;
      }
      if (paramk == null)
      {
        y.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
        return false;
      }
      int i;
      if ((!((String)localObject1).equals(paramString1)) && (!paramBoolean3) && (adC((String)localObject1)))
      {
        paramBoolean3 = true;
        y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", new Object[] { Boolean.valueOf(paramBoolean3), localObject1 });
        if ((paramk.vxw == null) || (paramk.vxw.getVisibility() != 0)) {
          break label350;
        }
        i = 1;
        label252:
        if ((!Hw(paramInt2)) || (i != 0)) {
          break label356;
        }
      }
      label350:
      label356:
      for (boolean bool2 = true;; bool2 = false)
      {
        if ((paramBoolean3) || (paramBoolean2) || (!this.vva.kJt.aC(localObject1))) {
          break label362;
        }
        localObject2 = (Bitmap)this.vva.kJt.get(localObject1);
        if (((Bitmap)localObject2).isRecycled()) {
          break label362;
        }
        y.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[] { localObject1 });
        b(paramMultiTouchImageView, (Bitmap)localObject2);
        return true;
        paramBoolean3 = false;
        break;
        i = 0;
        break label252;
      }
      label362:
      if (paramBoolean1) {
        paramMultiTouchImageView.setImageBitmap(null);
      }
      localObject2 = parame;
      if (paramBoolean3)
      {
        if (paramk.vxw == null) {
          return false;
        }
        localObject2 = parame;
        if (parame == null) {
          localObject2 = h(parambi, true);
        }
        paramk.vxw.setOnImageLoadEventListener(new e.1(this, (String)localObject1, paramInt1, paramk, parambi));
      }
      if (!this.vtH.vtT)
      {
        if (paramInt1 >= 0)
        {
          y.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[] { Integer.valueOf(paramInt1) });
          a(paramk, false, true);
          this.vva.b(paramMultiTouchImageView, paramInt1);
        }
        if (!paramBoolean3) {
          break label754;
        }
        a(paramk, true, bool2);
        paramMultiTouchImageView = e(parambi, (com.tencent.mm.as.e)localObject2);
        paramString1 = this.vva;
        paramString2 = paramk.vxw;
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
          paramInt2 = paramk.mPosition;
        }
        if (!paramString1.kJv.contains(localObject1))
        {
          paramInt1 = paramString2.hashCode();
          paramString1.sa(paramInt1);
          paramString1.a(paramInt1, paramString2, (String)localObject1);
          if ((paramString2 instanceof WxImageView))
          {
            paramString1.vvn.remove(paramInt1);
            paramString1.vvn.put(paramInt1, paramMultiTouchImageView);
          }
          paramString1.kJv.add(localObject1);
          paramString1.vvs.add(Integer.valueOf(paramInt2));
          paramString1.ahX();
        }
      }
      for (;;)
      {
        return bool1;
        if (paramBoolean3)
        {
          paramMultiTouchImageView = e(parambi, (com.tencent.mm.as.e)localObject2);
          a(paramk, true, bool2);
          paramString1 = paramk.vxw;
          if (paramMultiTouchImageView != null) {}
          for (paramMultiTouchImageView = com.davemorrissey.labs.subscaleview.view.a.U(paramMultiTouchImageView);; paramMultiTouchImageView = null)
          {
            a(paramString1, (String)localObject1, paramMultiTouchImageView);
            return bool1;
          }
        }
        Bitmap localBitmap = adD((String)localObject1);
        parame = localBitmap;
        if (localBitmap == null) {
          parame = adD(paramString1);
        }
        if (parame == null) {
          break;
        }
        a(paramk, false, true);
        b(paramMultiTouchImageView, parame);
        if (((String)localObject1).equals(paramString2))
        {
          this.vva.s((String)localObject1, parame);
          this.vva.b(paramInt1, parame);
        }
        return bool1;
        label754:
        a(paramk, false, true);
        paramString1 = this.vva;
        paramInt2 = paramInt1;
        if (paramInt1 < 0) {
          paramInt2 = paramk.mPosition;
        }
        paramString1.h(paramMultiTouchImageView, (String)localObject1, paramInt2);
      }
    }
  }
  
  protected static BitmapFactory.Options adB(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    paramString = BitmapFactory.decodeFile(paramString, localOptions);
    if (paramString != null) {
      paramString.recycle();
    }
    return localOptions;
  }
  
  private boolean adC(String paramString)
  {
    if (!vvd) {
      y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
    }
    label115:
    label117:
    int k;
    label216:
    int m;
    label245:
    do
    {
      return false;
      int j;
      if (com.tencent.mm.compatible.util.m.zN())
      {
        y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt is MTK platform");
        if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25) || (Build.VERSION.SDK_INT == 27))
        {
          y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt is MTK platform, android api: %d, cannot use BigImgOpt", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
          i = Build.VERSION.SDK_INT;
          y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo reportMTKPlatform apiLevel: %d", new Object[] { Integer.valueOf(i) });
          if (i == 24)
          {
            h.nFQ.h(896L, 0L, 1L);
            i = 1;
            if (i != 0) {
              break label333;
            }
            paramString = adB(paramString);
            j = paramString.outWidth;
            k = paramString.outHeight;
            y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt ignore abTestFlag, widthFactor: %f, heightFactor: %f, width: %d, height: %d", new Object[] { Float.valueOf(1.0F), Float.valueOf(1.0F), Integer.valueOf(j), Integer.valueOf(k) });
            Object localObject = this.vve;
            if (((j < 5700) || (k < 8000)) && ((j < 8000) || (k < 5700))) {
              break label335;
            }
            i = 1;
            if (i == 0) {
              break label347;
            }
            paramString = Build.MODEL;
            if (bk.bl(paramString)) {
              break label347;
            }
            localObject = ((b)localObject).vtI;
            m = localObject.length;
            i = 0;
            if (i >= m) {
              break label347;
            }
            if (!paramString.equalsIgnoreCase(localObject[i])) {
              break label340;
            }
            com.tencent.luggage.j.c.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter filter model: %s, width: %d, height: %d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k) });
          }
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label352;
        }
        y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt filter image");
        return false;
        if (i != 25) {
          break label115;
        }
        h.nFQ.h(896L, 1L, 1L);
        break label115;
        i = 0;
        break label117;
        break;
        i = 0;
        break label216;
        i += 1;
        break label245;
      }
      y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not filter");
      i = getScreenWidth(ae.getContext());
      m = getScreenHeight(ae.getContext());
      y.d("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt width: %d, height: %d, screenWidth: %d, screenHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
      if (j >= i * 1.0F) {
        return true;
      }
    } while (k < m * 1.0F);
    label333:
    label335:
    label340:
    label347:
    label352:
    return true;
  }
  
  private static Bitmap adD(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    int i2;
    do
    {
      Object localObject2;
      int n;
      int i1;
      Bitmap localBitmap;
      do
      {
        return paramString;
        Object localObject1 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
        localObject2 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
        if (localObject2 != null)
        {
          y.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localObject2.toString() });
          ((Bitmap)localObject2).recycle();
        }
        i2 = BackwardSupportUtil.ExifHelper.YS(paramString);
        int m = ((BitmapFactory.Options)localObject1).outWidth;
        int k = ((BitmapFactory.Options)localObject1).outHeight;
        n = m;
        i1 = k;
        for (;;)
        {
          try
          {
            long l1 = Math.max(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - vvf, 0L);
            n = m;
            i1 = k;
            int i = ((BitmapFactory.Options)localObject1).outHeight;
            n = m;
            i1 = k;
            long l2 = ((BitmapFactory.Options)localObject1).outWidth * i * 4;
            n = m;
            i1 = k;
            y.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
            int j = m;
            i = k;
            if (l1 < l2)
            {
              n = m;
              i1 = k;
              double d = Math.sqrt(l1 / l2);
              n = m;
              i1 = k;
              y.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", new Object[] { Double.valueOf(d) });
              j = (int)(m * d);
              i = (int)(k * d);
            }
            n = j;
            i1 = i;
            localObject2 = aq(paramString, i, j);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              n = j;
              i1 = i;
              localObject1 = com.tencent.mm.sdk.platformtools.c.a(paramString, j, i, 0.0F, null, 0, new int[0]);
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = localObject1;
              n = j;
              i1 = i;
              if (MMNativeJpeg.IsJpegFile(paramString))
              {
                localObject2 = localObject1;
                n = j;
                i1 = i;
                if (MMNativeJpeg.isProgressive(paramString))
                {
                  n = j;
                  i1 = i;
                  localObject2 = MMNativeJpeg.decodeAsBitmap(paramString);
                  if (localObject2 != null) {
                    continue;
                  }
                  bool = true;
                  n = j;
                  i1 = i;
                  y.i("MicroMsg.ImageGalleryHolderImage", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
                }
              }
            }
            localObject1 = localObject2;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            boolean bool;
            y.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", localOutOfMemoryError, "hy: out of memory! try use fallback bitmap", new Object[0]);
            localBitmap = c(paramString, n, i1, getScreenWidth(ae.getContext()), getScreenHeight(ae.getContext()));
            continue;
            localObject2 = com.tencent.mm.sdk.platformtools.c.b(localBitmap, i2);
            paramString = (String)localObject2;
          }
          if (localObject1 != null) {
            continue;
          }
          y.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = " + paramString);
          return null;
          bool = false;
        }
      } while (localObject2 != localBitmap);
      paramString = (String)localObject2;
    } while (i2 % 360 == 0);
    y.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[] { Integer.valueOf(i2) });
    return null;
  }
  
  private static Bitmap aq(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString + "_tmp.jpg";
    try
    {
      if (com.tencent.mm.compatible.util.d.gG(16)) {
        return null;
      }
      bool1 = com.tencent.mm.sdk.a.b.cqk();
      if (!bool1) {
        try
        {
          i = bk.getInt(com.tencent.mm.m.g.AA().getValue("UseOptImageRecv"), 0);
          au.Hx();
          com.tencent.mm.a.o localo = new com.tencent.mm.a.o(com.tencent.mm.model.c.CK());
          y.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Integer.valueOf(i), Long.valueOf(localo.longValue()), Long.valueOf(localo.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.cqk()), Integer.valueOf(Build.VERSION.SDK_INT) });
          j = (int)(localo.longValue() / 100L);
          if (j % 100 + 1 > i) {
            return null;
          }
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[] { bk.j(localException) });
          return null;
        }
      }
      com.tencent.mm.vfs.e.r(paramString, str);
      bool2 = MMNativeJpeg.IsJpegFile(str);
      bool3 = MMNativeJpeg.isProgressive(str);
      if (bk.bl(str)) {
        break label434;
      }
      if (new File(str).exists()) {
        break label363;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        int i;
        int j;
        boolean bool2;
        boolean bool3;
        Bitmap localBitmap1;
        label363:
        Bitmap localBitmap2 = null;
        y.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[] { paramString, bk.j(localThrowable1) });
        localObject1 = localBitmap2;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        boolean bool1 = false;
      }
    }
    j = (int)com.tencent.mm.vfs.e.aeQ(str);
    if ((bool2) && (bool3)) {
      if (bool1)
      {
        localBitmap1 = MMNativeJpeg.decodeAsBitmap(str);
        if (localBitmap1 != null) {}
        for (i = j;; i = 0 - j)
        {
          localBitmap2 = localBitmap1;
          try
          {
            e.a.n(paramString, paramInt2, paramInt1, i);
            localBitmap2 = localBitmap1;
            y.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localBitmap1, paramString });
            com.tencent.mm.vfs.e.deleteFile(str);
            return localBitmap1;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject1;
            break label386;
          }
          bool1 = MMJpegOptim.checkIntegrity(str);
          break;
        }
      }
    }
  }
  
  @TargetApi(11)
  private void b(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    if ((this.vtH == null) || (this.vtH.vtJ == null)) {
      return;
    }
    y.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), Integer.valueOf(paramBitmap.hashCode()) });
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.setEnableHorLongBmpMode(false);
      paramMultiTouchImageView.fs(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(null);
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.invalidate();
      return;
      com.tencent.mm.sdk.platformtools.k.o((View)paramMultiTouchImageView.getParent(), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  public static com.tencent.mm.as.e bt(bi parambi)
  {
    Object localObject;
    if (!c.be(parambi)) {
      localObject = null;
    }
    com.tencent.mm.as.e locale;
    do
    {
      return localObject;
      if (parambi.field_isSend != 1) {
        break;
      }
      l = parambi.field_msgId;
      locale = com.tencent.mm.as.o.OJ().bY(l);
      localObject = locale;
    } while (locale.enp != 0L);
    long l = parambi.field_msgSvrId;
    return com.tencent.mm.as.o.OJ().bX(l);
  }
  
  private static Bitmap c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
    paramInt1 *= paramInt2;
    paramInt2 = paramInt3 * paramInt4;
    y.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2) {}
    try
    {
      return com.tencent.mm.sdk.platformtools.c.a(paramString, paramInt3, paramInt4, 0.0F, null, 0, new int[0]);
    }
    catch (OutOfMemoryError paramString)
    {
      y.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramString, "hy: oom in fallback bitmap!", new Object[0]);
    }
    y.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
    return null;
    return null;
  }
  
  private String c(bi parambi, com.tencent.mm.as.e parame)
  {
    String str2 = (String)this.vvb.get(parambi);
    String str1 = str2;
    if (str2 == null)
    {
      parame = a(parambi, parame, false);
      if ((parame == null) || (parame.length() == 0)) {
        str1 = null;
      }
    }
    else
    {
      return str1;
    }
    this.vvb.put(parambi, parame);
    return parame;
  }
  
  public static void cGa()
  {
    vvd = false;
  }
  
  public static String d(bi parambi, com.tencent.mm.as.e parame)
  {
    return a(parambi, parame, false);
  }
  
  private static String e(bi parambi, com.tencent.mm.as.e parame)
  {
    if ((parambi == null) || (parame == null)) {
      return null;
    }
    if (parambi.field_isSend == 1)
    {
      parambi = parame.ens;
      parame = com.tencent.mm.as.o.OJ().o(parambi, "", "") + "hd";
      y.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambi, parame });
      if ((!bk.bl(parame)) && (com.tencent.mm.vfs.e.bK(parame)))
      {
        y.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
        return parame;
      }
      return null;
    }
    if (!parame.Oq())
    {
      y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
      return null;
    }
    parambi = parame.ens;
    parame = com.tencent.mm.as.o.OJ().o(parambi, "", "") + "hd";
    y.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambi, parame });
    if ((!bk.bl(parame)) && (com.tencent.mm.vfs.e.bK(parame)))
    {
      y.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
      return parame;
    }
    return null;
  }
  
  private void f(bi parambi, int paramInt)
  {
    this.ifu.put(Long.valueOf(parambi.field_msgId), Integer.valueOf(paramInt));
  }
  
  private static int getScreenHeight(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private void i(long paramLong, int paramInt)
  {
    this.ifu.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public final Bitmap Hx(int paramInt)
  {
    if (this.vtH == null) {}
    bi localbi;
    do
    {
      return null;
      localbi = this.vtH.vtK.Hu(paramInt);
    } while (localbi == null);
    String str2 = (String)this.vvc.get(localbi);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = com.tencent.mm.as.o.OJ().F(localbi.field_imgPath, true);
      this.vvc.put(localbi, str1);
    }
    str2 = str1 + "hd";
    if (com.tencent.mm.vfs.e.bK(str2)) {
      return adD(str2);
    }
    return adD(str1);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    if (!(paramObject instanceof Integer))
    {
      y.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
      return;
    }
    paramInt1 = ((Integer)paramObject).intValue();
    y.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos " + paramInt1, new Object[0]);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ah.m paramm)
  {
    if ((this.vtH == null) || (this.vtH.vtJ == null)) {}
    label17:
    int i;
    do
    {
      break label17;
      break label17;
      break label17;
      break label17;
      break label17;
      do
      {
        return;
      } while (this.lf != 0);
      if (!l.cGI().ic(paramLong2)) {
        break;
      }
      i = a(paramLong2, paramObject);
    } while (i == -1);
    paramObject = new Integer(i);
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        y.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        return;
      }
      i = ((Integer)paramObject).intValue();
      y.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1) });
      if (i == -1)
      {
        y.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
        return;
      }
      if (this.vtH.Gs(i) == null) {
        break;
      }
      paramObject = (k)this.vtH.Gs(i).getTag();
      if (paramObject == null) {
        break;
      }
      if ((i == this.vtH.vtJ.getCurrentItem()) && (!Hw(paramInt1))) {
        this.vtH.vtJ.gs(false);
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.vtH.vtJ.getCurrentItem()) && (Hw(paramInt1)))
        {
          y.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.vtH.vtJ.HD(paramInt2);
        }
        paramm = (com.tencent.mm.as.k)paramm;
        boolean bool1 = MMNativeJpeg.isProgressive(paramm.eoT);
        boolean bool2 = paramm.eoV;
        paramLong1 = bk.cp(this.vvg);
        e.a.dI(paramm.eoT, paramInt4);
        y.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramm.eoT });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break;
        }
        this.vvg = bk.UZ();
        paramm = this.vtH.GW(i);
        com.tencent.mm.as.e locale = h(paramm, true);
        if (!a(false, paramObject.vxv, com.tencent.mm.as.o.OJ().F(paramm.field_imgPath, true), a(paramm, locale, true), true, -1, paramm, paramObject, locale, paramInt1, true)) {
          break;
        }
        k.X(paramObject.vxp, 8);
        k.X(paramObject.vxs, 8);
        if ((i != this.vtH.vtJ.getCurrentItem()) || (Hw(paramInt1))) {
          break;
        }
        if (paramInt2 <= 50) {
          break label620;
        }
        k.X(paramObject.vxr, 8);
        if (this.vtH == null) {
          break;
        }
        this.vtH.a(paramm, locale, paramInt1, com.tencent.mm.h.b.a.e.a.chi);
        return;
      }
      if (paramInt4 != 0) {}
      for (float f = paramInt3 / paramInt4 * 100.0F - 1.0F;; f = 0.0F)
      {
        paramInt2 = (int)f;
        break;
      }
      label620:
      k.X(paramObject.vxr, 0);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((this.vtH == null) || (this.vtH.vtJ == null)) {
      return;
    }
    if (l.cGI().ic(paramLong2))
    {
      paramInt2 = a(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        au.Hx();
        a(com.tencent.mm.model.c.Fy().fd(paramLong2), "background", false);
        return;
      }
      paramObject = new Integer(paramInt2);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        y.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        return;
      }
      paramInt2 = ((Integer)paramObject).intValue();
      y.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = " + paramInt2);
      if (paramInt2 == -1)
      {
        y.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
        h.nFQ.a(111L, 3L, 1L, true);
        return;
      }
      paramObject = null;
      if (this.vtH.Gs(paramInt2) != null) {
        paramObject = (k)this.vtH.Gs(paramInt2).getTag();
      }
      boolean bool = l.cGI().ic(paramLong2);
      if ((paramInt3 != 0) || (paramInt4 != 0))
      {
        if (bool)
        {
          paramObject = this.vtH.GW(paramInt2);
          paramString = "hd_failed:" + paramInt2;
          if (paramInt2 == this.vtH.vtJ.getCurrentItem())
          {
            bool = true;
            label259:
            a(paramObject, paramString, bool);
          }
        }
        else
        {
          if (paramInt2 == this.vtH.vtJ.getCurrentItem()) {
            this.vtH.vtJ.gs(true);
          }
          if (paramInt4 != -5103059) {
            break label402;
          }
          i(paramLong2, 5);
          h.nFQ.a(111L, 0L, 1L, true);
        }
        for (;;)
        {
          y.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
          this.vtH.vtO.Hj(paramInt2);
          if (this.vtH == null) {
            break;
          }
          this.vtH.a(this.vtH.GW(paramInt2), null, paramInt1, com.tencent.mm.h.b.a.e.a.chk);
          return;
          bool = false;
          break label259;
          label402:
          i(paramLong2, 6);
          h.nFQ.a(111L, 1L, 1L, true);
        }
      }
      if (bool)
      {
        paramString = this.vtH.GW(paramInt2);
        paramm = "hd_suc:" + paramInt2;
        if (paramInt2 == this.vtH.vtJ.getCurrentItem())
        {
          bool = true;
          label478:
          a(paramString, paramm, bool);
        }
      }
      else
      {
        y.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.vtH.vtJ.getCurrentItem(), new Object[0]);
        i(paramLong2, 4);
        paramString = this.vtH.GW(paramInt2);
        paramm = h(paramString, true);
        if ((paramString == null) || (paramm == null) || (paramObject == null)) {
          break;
        }
        this.vtH.vtJ.gs(true);
        if (paramInt2 == this.vtH.vtJ.getCurrentItem())
        {
          if (!Hw(paramInt1)) {
            break label860;
          }
          ImageGalleryUI localImageGalleryUI = this.vtH.vtJ;
          localImageGalleryUI.gs(true);
          localImageGalleryUI.gs(true);
          Animation localAnimation = ImageGalleryUI.HC(1000);
          localAnimation.setAnimationListener(new ImageGalleryUI.11(localImageGalleryUI));
          localImageGalleryUI.cGp();
          localImageGalleryUI.cGe().vvQ.setVisibility(0);
          localImageGalleryUI.cGe().vvR.setVisibility(8);
          localImageGalleryUI.cGe().vvS.setVisibility(8);
          localImageGalleryUI.cGe().vvT.setVisibility(0);
          localImageGalleryUI.cGe().vvT.startAnimation(localAnimation);
        }
      }
      for (;;)
      {
        if (!a(false, paramObject.vxv, com.tencent.mm.as.o.OJ().F(paramString.field_imgPath, true), a(paramString, paramm, true), true, -1, paramString, paramObject, paramm, paramInt1, false)) {
          break label882;
        }
        k.X(paramObject.vxm, 8);
        k.X(paramObject.vxr, 8);
        k.X(paramObject.vxs, 8);
        if ((bs(paramString) == 4) && (this.vtH.vtN))
        {
          this.vtH.bn(paramString);
          this.vtH.vtN = false;
        }
        if (this.vtH == null) {
          break;
        }
        this.vtH.a(paramString, paramm, paramInt1, com.tencent.mm.h.b.a.e.a.chi);
        return;
        bool = false;
        break label478;
        label860:
        paramObject.vxv.post(new e.2(this, paramInt2));
      }
      label882:
      y.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
      h.nFQ.a(111L, 2L, 1L, true);
      return;
    }
  }
  
  public final void a(WxImageView paramWxImageView, String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    Object localObject = adB(paramString);
    paramWxImageView.setOrientation(BackwardSupportUtil.ExifHelper.YS(paramString));
    int i = ((BitmapFactory.Options)localObject).outWidth;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    paramWxImageView.imageWidth = i;
    paramWxImageView.imageHeight = j;
    paramWxImageView.cAy();
    y.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d", new Object[] { paramString, Integer.valueOf(paramWxImageView.imageWidth), Integer.valueOf(paramWxImageView.imageHeight) });
    if (paramWxImageView.dDP == com.tencent.mm.graphics.a.c.dDd)
    {
      if (paramWxImageView.dDM == null) {
        y.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
      }
    }
    else {
      return;
    }
    if (paramString == null)
    {
      y.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
      return;
    }
    paramWxImageView.dDJ.setVisibility(0);
    localObject = com.davemorrissey.labs.subscaleview.view.a.U(paramString);
    i = paramWxImageView.imageWidth;
    j = paramWxImageView.imageHeight;
    if (((com.davemorrissey.labs.subscaleview.view.a)localObject).bitmap == null)
    {
      ((com.davemorrissey.labs.subscaleview.view.a)localObject).aoT = i;
      ((com.davemorrissey.labs.subscaleview.view.a)localObject).aoU = j;
    }
    if (((com.davemorrissey.labs.subscaleview.view.a)localObject).aoV != null)
    {
      ((com.davemorrissey.labs.subscaleview.view.a)localObject).aoS = true;
      ((com.davemorrissey.labs.subscaleview.view.a)localObject).aoT = ((com.davemorrissey.labs.subscaleview.view.a)localObject).aoV.width();
      ((com.davemorrissey.labs.subscaleview.view.a)localObject).aoU = ((com.davemorrissey.labs.subscaleview.view.a)localObject).aoV.height();
    }
    paramWxImageView.aoF = System.currentTimeMillis();
    y.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(paramWxImageView.aoF) });
    paramWxImageView.dDS = new a.a();
    paramWxImageView.dDS.dDC = 22;
    paramWxImageView.dDS.imagePath = paramString;
    paramWxImageView.dDS.bWQ = paramWxImageView.getActivityName();
    paramWxImageView.dDU = true;
    if (parama != null)
    {
      paramWxImageView.dDR = new a.a();
      if (parama.uri != null)
      {
        paramWxImageView.dDR.imagePath = parama.uri.toString();
        paramWxImageView.dDR.dDC = 21;
        paramWxImageView.dDR.bWQ = paramWxImageView.getActivityName();
      }
    }
    for (paramWxImageView.dDT = true;; paramWxImageView.dDT = false)
    {
      if (parama == null) {
        break label384;
      }
      paramWxImageView.dDM.a((com.davemorrissey.labs.subscaleview.view.a)localObject, parama);
      return;
      paramWxImageView.dDR.imagePath = "";
      break;
    }
    label384:
    paramWxImageView.dDM.setImage((com.davemorrissey.labs.subscaleview.view.a)localObject);
  }
  
  public final boolean a(k paramk, bi parambi, int paramInt)
  {
    super.a(paramk, parambi, paramInt);
    if ((paramk == null) || (parambi == null) || (paramInt < 0)) {
      return false;
    }
    int i = bs(parambi);
    y.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s", new Object[] { Integer.valueOf(paramk.vxv.hashCode()), Integer.valueOf(paramInt) });
    k.X(paramk.vxm, 8);
    com.tencent.mm.as.e locale = h(parambi, false);
    if (locale == null) {
      return false;
    }
    switch (i)
    {
    }
    label535:
    for (;;)
    {
      return true;
      y.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
      y.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
      boolean bool;
      if (parambi.field_isSend == 1) {
        bool = parambi.cvx();
      }
      for (;;)
      {
        if (!bool) {
          break label286;
        }
        f(parambi, 5);
        a(parambi, paramk, 5);
        break;
        if (parambi.cvx())
        {
          bool = true;
        }
        else
        {
          String str = c(parambi, locale);
          if ((locale.Oq()) && ((str == null) || (!com.tencent.mm.vfs.e.bK(str))))
          {
            bool = true;
          }
          else
          {
            if ((System.currentTimeMillis() - parambi.field_createTime > 259200000L) && ((bk.bl(str)) || (!com.tencent.mm.vfs.e.bK(str)))) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label280;
              }
              bool = true;
              break;
            }
            label280:
            bool = false;
          }
        }
      }
      label286:
      if (a(paramk, parambi, locale, paramInt))
      {
        if (locale.Oq()) {
          f(parambi, 4);
        } else {
          f(parambi, 1);
        }
      }
      else
      {
        for (;;)
        {
          z.w(parambi);
          i = com.tencent.mm.as.o.OK().a(locale.enp, parambi.field_msgId, 0, Integer.valueOf(paramInt), R.g.chat_img_template, this, 0);
          if (this.vtH != null) {
            this.vtH.i(parambi, false);
          }
          y.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[] { Integer.valueOf(i) });
          if (i != -2) {
            break label535;
          }
          y.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
          locale = h(parambi, true);
          if (locale != null) {
            break label436;
          }
          y.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
          break;
          f(parambi, 2);
        }
        label436:
        if (a(paramk, parambi, locale, paramInt))
        {
          if ((parambi.field_isSend == 1) || (locale.Oq())) {
            f(parambi, 4);
          } else {
            f(parambi, 1);
          }
        }
        else
        {
          for (;;)
          {
            y.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(locale.enp), Boolean.valueOf(locale.Oq()) });
            a(paramk, parambi, locale, false, paramInt);
            break;
            f(parambi, 2);
          }
          a(paramk, parambi, locale, false, paramInt);
          continue;
          a(paramk, parambi, locale, paramInt);
          continue;
          a(paramk, parambi, locale, false, paramInt);
          continue;
          a(paramk, parambi, locale, true, paramInt);
          continue;
          a(parambi, paramk, i);
          paramk.kKz.invalidate();
        }
      }
    }
  }
  
  public final void as(int paramInt, boolean paramBoolean)
  {
    y.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = " + paramInt);
    Object localObject1 = this.vtH.GW(paramInt);
    if ((localObject1 == null) || (((cs)localObject1).field_msgId == 0L))
    {
      y.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      return;
    }
    if (!c.be((bi)localObject1))
    {
      y.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      return;
    }
    com.tencent.mm.as.e locale = h((bi)localObject1, true);
    Object localObject2;
    if ((locale == null) || (locale.enp == 0L))
    {
      localObject2 = new StringBuilder("viewHdImg fail, msgLocalId = ");
      if (localObject1 == null)
      {
        localObject1 = "null";
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", imgLocalId = ");
        if (locale != null) {
          break label161;
        }
      }
      label161:
      for (localObject1 = "null";; localObject1 = Long.valueOf(locale.enp))
      {
        y.e("MicroMsg.ImageGalleryHolderImage", localObject1);
        return;
        localObject1 = Long.valueOf(((cs)localObject1).field_msgId);
        break;
      }
    }
    f((bi)localObject1, 3);
    if (Hi(paramInt) != null) {
      a(Hi(paramInt), (bi)localObject1, locale, true, false, paramInt);
    }
    if (this.vtH != null) {
      this.vtH.i((bi)localObject1, true);
    }
    if (paramBoolean)
    {
      localObject2 = l.cGI();
      y.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((cs)localObject1).field_msgId) });
      ((l)localObject2).vxE.add(Long.valueOf(((cs)localObject1).field_msgId));
      com.tencent.mm.as.o.OK().a(locale.enp, ((cs)localObject1).field_msgId, 1, Integer.valueOf(paramInt), R.g.chat_img_template, (d.a)localObject2, 0);
      return;
    }
    com.tencent.mm.as.o.OK().a(locale.enp, ((cs)localObject1).field_msgId, 1, Integer.valueOf(paramInt), R.g.chat_img_template, this, 0);
  }
  
  public final void b(View paramView, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    do
    {
      do
      {
        return;
      } while (paramView == null);
      int i = paramView.hashCode();
      int j = paramBitmap.hashCode();
      int k = this.vva.kJu.indexOfValue(i);
      if (k >= 0) {
        this.vva.kJu.removeAt(k);
      }
      this.vva.kJu.put(j, i);
      if ((paramView instanceof MultiTouchImageView))
      {
        b((MultiTouchImageView)paramView, paramBitmap);
        return;
      }
    } while (!(paramView instanceof ImageView));
    ((ImageView)paramView).setImageBitmap(paramBitmap);
  }
  
  public final int bs(bi parambi)
  {
    if ((parambi != null) && (this.ifu.containsKey(Long.valueOf(parambi.field_msgId)))) {
      return ((Integer)this.ifu.get(Long.valueOf(parambi.field_msgId))).intValue();
    }
    return 0;
  }
  
  public final void bu(bi parambi)
  {
    com.tencent.mm.as.e locale = bt(parambi);
    if ((locale == null) || (parambi == null)) {
      return;
    }
    if (this.vtH != null) {
      this.vtH.a(parambi, null, 1, com.tencent.mm.h.b.a.e.a.chj);
    }
    if (l.cGI().ic(parambi.field_msgId))
    {
      l locall = l.cGI();
      locall.vxE.remove(Long.valueOf(parambi.field_msgId));
      com.tencent.mm.as.o.OK().a(locale.enp, parambi.field_msgId, locall);
      com.tencent.mm.as.o.OK().q(locale.enp, parambi.field_msgId);
      return;
    }
    com.tencent.mm.as.o.OK().a(locale.enp, parambi.field_msgId, this);
    com.tencent.mm.as.o.OK().q(locale.enp, parambi.field_msgId);
  }
  
  public final void detach()
  {
    super.detach();
    com.tencent.mm.sdk.b.a.udP.d(this.vuZ);
    if (this.rlK != null)
    {
      localObject = this.rlK.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.rlK.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          y.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.vva;
    ((f)localObject).vvo = null;
    ((f)localObject).kJp.clear();
    ((f)localObject).kJs.clear();
    ((f)localObject).kJr.clear();
    ((f)localObject).kJq.clear();
    ((f)localObject).vvn.clear();
    ((f)localObject).aXQ();
    if ((((f)localObject).vvt != null) && (!((f)localObject).vvt.isRecycled()))
    {
      ((f)localObject).vvt.recycle();
      ((f)localObject).vvt = null;
    }
    com.tencent.mm.as.o.OK().a(this);
    localObject = l.cGI();
    if (equals(((l)localObject).vxF)) {
      ((l)localObject).vxF = null;
    }
  }
  
  public final com.tencent.mm.as.e h(bi parambi, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (!c.be(parambi)) {
      localObject2 = localObject1;
    }
    do
    {
      return localObject2;
      if ((this.vtH == null) || (this.vtH.vtK == null))
      {
        y.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
        return null;
      }
      localObject1 = localObject3;
      if (!paramBoolean)
      {
        if (parambi.field_isSend == 1) {
          localObject2 = (com.tencent.mm.as.e)this.vtH.vtK.vuh.get(Long.valueOf(parambi.field_msgId));
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (parambi.field_msgSvrId > 0L) {
            localObject1 = (com.tencent.mm.as.e)this.vtH.vtK.vug.get(Long.valueOf(parambi.field_msgSvrId));
          }
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    int i = 0;
    long l;
    if (parambi.field_isSend == 1)
    {
      l = parambi.field_msgId;
      localObject2 = com.tencent.mm.as.o.OJ().bY(l);
      localObject1 = localObject2;
      if (((com.tencent.mm.as.e)localObject2).enp != 0L) {}
    }
    else
    {
      l = parambi.field_msgSvrId;
      localObject1 = com.tencent.mm.as.o.OJ().bX(l);
      i = 1;
    }
    parambi = this.vtH.vtK;
    if (i != 0)
    {
      parambi.vug.put(Long.valueOf(l), localObject1);
      return localObject1;
    }
    parambi.vuh.put(Long.valueOf(l), localObject1);
    return localObject1;
  }
  
  public final Bitmap loadImage(String paramString)
  {
    return adD(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */