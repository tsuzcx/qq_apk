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
import com.tencent.mm.ak.n;
import com.tencent.mm.av.o;
import com.tencent.mm.b.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends a
  implements com.tencent.mm.av.d.a, e.a
{
  private static boolean Ibs;
  private static long Ibt;
  private HashMap<String, WeakReference<Bitmap>> CvQ;
  private com.tencent.mm.sdk.b.c Ibo;
  public final e Ibp;
  private HashMap<bo, String> Ibq;
  private HashMap<bo, String> Ibr;
  private long Ibu;
  int mScrollState;
  public HashMap<Long, Integer> nzI;
  
  static
  {
    AppMethodBeat.i(36048);
    Ibs = true;
    Ibt = (Runtime.getRuntime().maxMemory() * 0.05D);
    AppMethodBeat.o(36048);
  }
  
  public d(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36007);
    this.nzI = new HashMap();
    this.Ibp = new e(this);
    this.CvQ = new HashMap();
    this.Ibq = new HashMap();
    this.Ibr = new HashMap();
    this.Ibu = 0L;
    this.mScrollState = 0;
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.GpY;
    paramb = new ak(ak.a.HQs, paramb.HZV);
    this.Ibo = paramb;
    locala.c(paramb);
    paramb = g.a.IbR.sRA.snapshot();
    this.Ibp.bQ(paramb);
    l.fpT().Iej = this;
    AppMethodBeat.o(36007);
  }
  
  public static String a(bo parambo, com.tencent.mm.av.e parame)
  {
    AppMethodBeat.i(36033);
    parambo = a(parambo, parame, false);
    AppMethodBeat.o(36033);
    return parambo;
  }
  
  private static String a(bo parambo, com.tencent.mm.av.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(36034);
    if (parambo.field_isSend == 1)
    {
      parambo = o.aFx().d(parame);
      str = o.aFx().p(parambo, "", "");
      ac.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", new Object[] { parambo, str });
      if (i.eA(str))
      {
        AppMethodBeat.o(36034);
        return str;
      }
      parambo = parame.hGM;
      parame = o.aFx().p(parambo, "", "");
      ac.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", new Object[] { parambo, parame });
      if (i.eA(parame))
      {
        AppMethodBeat.o(36034);
        return parame;
      }
      AppMethodBeat.o(36034);
      return null;
    }
    if ((!paramBoolean) && (!parame.aEZ()))
    {
      ac.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(parame.aEZ()) });
      AppMethodBeat.o(36034);
      return null;
    }
    String str = parame.hGM;
    if (parame.aFa())
    {
      parambo = o.aFx().d(parame);
      if (parambo != null)
      {
        parambo = o.aFx().p(parambo, "", "");
        if (i.eA(parambo)) {
          ac.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      parame = parambo;
      if (parambo == null) {
        parame = o.aFx().p(str, "", "");
      }
      ac.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[] { parame });
      AppMethodBeat.o(36034);
      return parame;
      parambo = null;
    }
  }
  
  private static void a(bo parambo, k paramk, int paramInt)
  {
    AppMethodBeat.i(36019);
    ac.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = o.aFx().R(parambo.field_imgPath, true);
    k.aF(paramk.IdU, 8);
    k.aF(paramk.IdP, 8);
    k.aF(paramk.IdY, 8);
    k.aF(paramk.IdZ, 8);
    paramk.fpQ().IdV.setVisibility(0);
    paramk.fpQ().IdX.setImageResource(2131690686);
    if ((str == null) || (!i.eA(str)))
    {
      paramk.fpQ().IdW.setText(2131760325);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramInt == 6)
    {
      paramk.fpQ().IdW.setText(2131760323);
      AppMethodBeat.o(36019);
      return;
    }
    if (parambo.fbQ())
    {
      paramk.fpQ().IdW.setText(2131760321);
      AppMethodBeat.o(36019);
      return;
    }
    paramk.fpQ().IdW.setText(2131760322);
    AppMethodBeat.o(36019);
  }
  
  private static void a(bo parambo, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36039);
    ac.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(parambo.field_msgId), paramString });
    b.c(ai.getContext(), parambo, paramBoolean);
    AppMethodBeat.o(36039);
  }
  
  private void a(k paramk, bo parambo, com.tencent.mm.av.e parame, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36017);
    a(paramk, parambo, parame, paramBoolean, true, paramInt);
    AppMethodBeat.o(36017);
  }
  
  private void a(k paramk, bo parambo, com.tencent.mm.av.e parame, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(36018);
    ac.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(paramBoolean1)));
    k.aF(paramk.IdV, 8);
    String str1 = null;
    if (!paramBoolean1) {
      paramk.IdY.setVisibility(0);
    }
    com.tencent.mm.av.e locale = com.tencent.mm.av.f.a(parame);
    if ((paramBoolean1) && (paramInt == this.HZU.HZV.getCurrentItem())) {
      this.HZU.HZV.fpH();
    }
    if (paramBoolean1) {
      str1 = a(parambo, parame, true);
    }
    String str2 = str1;
    if (bs.isNullOrNil(str1)) {
      str2 = o.aFx().p(locale.hGO, "", "");
    }
    str1 = o.aFx().R(parambo.field_imgPath, true);
    if (paramBoolean2) {
      a(paramk, str1, str2, parambo);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = parame.hux;
      int i = parame.offset;
      if (paramInt == 0) {
        break label258;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label264;
      }
      paramk.fpP().IdU.setVisibility(8);
    }
    for (;;)
    {
      paramk.fpP().IdS.setVisibility(8);
      paramk.fpP().IdR.setVisibility(8);
      paramk.fpP().IdQ.setVisibility(8);
      AppMethodBeat.o(36018);
      return;
      label258:
      l = 0L;
      break;
      label264:
      paramk.fpP().IdU.setVisibility(0);
    }
  }
  
  private static void a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    AppMethodBeat.i(36026);
    Object localObject;
    int i;
    if (paramk != null) {
      if (paramk.IdZ != null)
      {
        localObject = paramk.IdZ;
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
    for (paramk.Iea = true;; paramk.Iea = false)
    {
      if (paramk.IdY != null)
      {
        localObject = paramk.IdY;
        i = j;
        if (paramBoolean2) {
          i = 0;
        }
        ((MultiTouchImageView)localObject).setVisibility(i);
        if (paramBoolean2) {
          paramk.Iea = false;
        }
      }
      AppMethodBeat.o(36026);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, int paramInt, bo parambo, k paramk)
  {
    AppMethodBeat.i(36024);
    boolean bool = a(true, paramMultiTouchImageView, paramString1, paramString2, false, paramInt, parambo, paramk, null, false);
    AppMethodBeat.o(36024);
    return bool;
  }
  
  private boolean a(k paramk, bo parambo, com.tencent.mm.av.e parame, int paramInt)
  {
    AppMethodBeat.i(36016);
    ac.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = d(parambo, parame);
    k.aF(paramk.IdU, 8);
    String str1 = (String)this.Ibr.get(parambo);
    parame = str1;
    if (str1 == null)
    {
      parame = o.aFx().R(parambo.field_imgPath, true);
      this.Ibr.put(parambo, parame);
    }
    boolean bool = a(paramk, parame, str2, parambo);
    if ((paramInt == this.HZU.HZV.getCurrentItem()) && (this.HZU.HZZ))
    {
      this.HZU.bY(parambo);
      this.HZU.HZZ = false;
    }
    AppMethodBeat.o(36016);
    return bool;
  }
  
  private boolean a(k paramk, String paramString1, String paramString2, bo parambo)
  {
    AppMethodBeat.i(36020);
    boolean bool = b(paramk, paramString1, paramString2, parambo);
    AppMethodBeat.o(36020);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, final int paramInt, final bo parambo, final k paramk, com.tencent.mm.av.e parame, boolean paramBoolean3)
  {
    AppMethodBeat.i(36025);
    ac.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt) });
    Object localObject2 = null;
    boolean bool1 = true;
    if ((paramString2 != null) && (i.eA(paramString2))) {
      localObject2 = i.k(paramString2, false);
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
          if (i.eA(paramString1))
          {
            localObject1 = i.k(paramString1, false);
            if (i.eA(paramString1 + "hd")) {
              localObject1 = i.k(paramString1 + "hd", false);
            }
          }
        }
      }
      if (localObject1 != null) {
        break;
      }
      ac.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", new Object[] { paramString2 });
      AppMethodBeat.o(36025);
      return false;
      bool1 = false;
    }
    if (paramk == null)
    {
      ac.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
      AppMethodBeat.o(36025);
      return false;
    }
    int i;
    if ((!((String)localObject1).equals(paramString1)) && (!paramBoolean3) && (aQv((String)localObject1)))
    {
      paramBoolean3 = true;
      ac.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", new Object[] { Boolean.valueOf(paramBoolean3), localObject1 });
      if ((paramk.IdZ == null) || (paramk.IdZ.getVisibility() != 0)) {
        break label389;
      }
      i = 1;
      label284:
      if ((!paramBoolean3) || (i != 0)) {
        break label395;
      }
    }
    label389:
    label395:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((paramBoolean3) || (paramBoolean2) || (!this.Ibp.sRA.aK(localObject1))) {
        break label401;
      }
      localObject2 = (Bitmap)this.Ibp.sRA.aJ(localObject1);
      if (((Bitmap)localObject2).isRecycled()) {
        break label401;
      }
      ac.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[] { localObject1 });
      c(paramMultiTouchImageView, (Bitmap)localObject2);
      AppMethodBeat.o(36025);
      return true;
      paramBoolean3 = false;
      break;
      i = 0;
      break label284;
    }
    label401:
    if (paramBoolean1) {
      paramMultiTouchImageView.setImageBitmap(null);
    }
    localObject2 = parame;
    if (paramBoolean3)
    {
      if (paramk.IdZ == null)
      {
        AppMethodBeat.o(36025);
        return false;
      }
      localObject2 = parame;
      if (parame == null) {
        localObject2 = g(parambo, true);
      }
      paramk.IdZ.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
      {
        public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36000);
          ac.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          AppMethodBeat.o(36000);
        }
        
        public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36001);
          ac.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          com.tencent.mm.cp.c.adV(paramAnonymousc.errCode);
          d.a(d.this, this.Ibv, paramk, paramInt);
          if (paramAnonymousc.errCode == 4) {
            d.fpn();
          }
          AppMethodBeat.o(36001);
        }
        
        public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36002);
          ac.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          d.a(parambo, paramk);
          AppMethodBeat.o(36002);
        }
        
        public final void m(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(35999);
          e locale;
          if ((paramAnonymousBitmap != null) && (d.this.Ibp != null))
          {
            ac.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[] { this.Ibv });
            locale = d.this.Ibp;
            if (paramInt <= 0) {
              break label76;
            }
          }
          label76:
          for (int i = paramInt;; i = paramk.mPosition)
          {
            locale.e(i, paramAnonymousBitmap);
            d.a(paramk);
            AppMethodBeat.o(35999);
            return;
          }
        }
        
        public final void qA()
        {
          AppMethodBeat.i(35998);
          ac.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
          AppMethodBeat.o(35998);
        }
        
        public final void qB() {}
      });
    }
    if (!this.HZU.Iag)
    {
      if (paramInt >= 0)
      {
        ac.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[] { Integer.valueOf(paramInt) });
        a(paramk, false, true);
        this.Ibp.c(paramMultiTouchImageView, paramInt);
      }
      if (!paramBoolean3) {
        break label739;
      }
      a(paramk, true, bool2);
      paramMultiTouchImageView = e(parambo, (com.tencent.mm.av.e)localObject2);
      paramString1 = this.Ibp;
      paramString2 = paramk.IdZ;
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
        paramMultiTouchImageView = e(parambo, (com.tencent.mm.av.e)localObject2);
        a(paramk, true, bool2);
        paramString1 = paramk.IdZ;
        if (paramMultiTouchImageView != null) {}
        for (paramMultiTouchImageView = com.davemorrissey.labs.subscaleview.view.a.W(paramMultiTouchImageView);; paramMultiTouchImageView = null)
        {
          a(paramString1, (String)localObject1, paramMultiTouchImageView);
          AppMethodBeat.o(36025);
          return bool1;
        }
      }
      Bitmap localBitmap = aQx((String)localObject1);
      parame = localBitmap;
      if (localBitmap == null) {
        parame = aQx(paramString1);
      }
      if (parame == null) {
        break;
      }
      a(paramk, false, true);
      b(paramMultiTouchImageView, parame);
      if (((String)localObject1).equals(paramString2))
      {
        this.Ibp.w((String)localObject1, parame);
        this.Ibp.e(paramInt, parame);
      }
      AppMethodBeat.o(36025);
      return bool1;
      label739:
      a(paramk, false, true);
      paramString1 = this.Ibp;
      i = paramInt;
      if (paramInt < 0) {
        i = paramk.mPosition;
      }
      paramString1.f(paramMultiTouchImageView, (String)localObject1, i);
    }
  }
  
  protected static BitmapFactory.Options aQu(String paramString)
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
  
  private static boolean aQv(String paramString)
  {
    AppMethodBeat.i(36023);
    if (!Ibs)
    {
      ac.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
      AppMethodBeat.o(36023);
      return false;
    }
    boolean bool = com.tencent.mm.cp.b.aSS(paramString);
    AppMethodBeat.o(36023);
    return bool;
  }
  
  private static Bitmap aQx(String paramString)
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
      ac.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localObject3.toString() });
      ((Bitmap)localObject3).recycle();
    }
    int i2 = BackwardSupportUtil.ExifHelper.ce(paramString);
    int i1 = ((BitmapFactory.Options)localObject1).outWidth;
    int n = ((BitmapFactory.Options)localObject1).outHeight;
    int k = n;
    int m = i1;
    for (;;)
    {
      try
      {
        long l1 = Math.max(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - Ibt, 0L);
        k = n;
        m = i1;
        i = ((BitmapFactory.Options)localObject1).outHeight;
        k = n;
        m = i1;
        long l2 = ((BitmapFactory.Options)localObject1).outWidth * i * 4;
        k = n;
        m = i1;
        ac.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        j = n;
        i = i1;
        if (l1 < l2)
        {
          k = n;
          m = i1;
          double d = Math.sqrt(l1 / l2);
          k = n;
          m = i1;
          ac.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", new Object[] { Double.valueOf(d) });
          i = (int)(i1 * d);
          j = (int)(n * d);
        }
        k = j;
        m = i;
        localObject3 = aR(paramString, j, i);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          k = j;
          m = i;
          localObject1 = com.tencent.mm.sdk.platformtools.f.a(paramString, i, j, 0.0F);
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
              ac.i("MicroMsg.ImageGalleryHolderImage", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
            }
          }
        }
        localObject1 = localObject3;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        boolean bool;
        ac.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", localOutOfMemoryError, "hy: out of memory! try use fallback bitmap", new Object[0]);
        Object localObject2 = ai.getContext();
        if (localObject2 != null) {
          continue;
        }
        int i = 0;
        localObject2 = ai.getContext();
        if (localObject2 != null) {
          continue;
        }
        int j = 0;
        localObject2 = d(paramString, m, k, i, j);
        continue;
        i = ((Context)localObject2).getResources().getDisplayMetrics().widthPixels;
        continue;
        j = ((Context)localObject2).getResources().getDisplayMetrics().heightPixels;
        continue;
        paramString = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, i2);
        if ((paramString != localObject2) || (i2 % 360 == 0)) {
          continue;
        }
        ac.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[] { Integer.valueOf(i2) });
        AppMethodBeat.o(36031);
        return null;
        AppMethodBeat.o(36031);
      }
      if (localObject1 != null) {
        continue;
      }
      ac.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(36031);
      return null;
      bool = false;
    }
    return paramString;
  }
  
  private static Bitmap aR(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36030);
    String str = paramString + "_tmp.jpg";
    try
    {
      bool1 = com.tencent.mm.compatible.util.d.la(16);
      if (bool1)
      {
        AppMethodBeat.o(36030);
        return null;
      }
      bool1 = com.tencent.mm.sdk.a.b.eUk();
      if (!bool1) {
        try
        {
          i = bs.getInt(com.tencent.mm.m.g.ZY().getValue("UseOptImageRecv"), 0);
          az.ayM();
          com.tencent.mm.b.p localp = new com.tencent.mm.b.p(com.tencent.mm.model.c.getUin());
          ac.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Integer.valueOf(i), Long.valueOf(localp.longValue()), Long.valueOf(localp.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.eUk()), Integer.valueOf(Build.VERSION.SDK_INT) });
          j = (int)(localp.longValue() / 100L);
          if (j % 100 + 1 > i)
          {
            AppMethodBeat.o(36030);
            return null;
          }
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[] { bs.m(localException) });
          AppMethodBeat.o(36030);
          return null;
        }
      }
      i.aSh(i.aSs(str));
      i.lZ(paramString, str);
      bool2 = MMNativeJpeg.IsJpegFile(str);
      bool3 = MMNativeJpeg.isProgressive(str);
      if (bs.isNullOrNil(str)) {
        break label474;
      }
      if (i.eA(str)) {
        break label399;
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
        label399:
        Bitmap localBitmap2 = null;
        ac.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[] { paramString, bs.m(localThrowable1) });
        localObject1 = localBitmap2;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        boolean bool1 = false;
      }
    }
    j = (int)i.aSp(str);
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
            d.a.t(paramString, paramInt2, paramInt1, i);
            localBitmap2 = localBitmap1;
            ac.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localBitmap1, paramString });
            i.deleteFile(str);
            AppMethodBeat.o(36030);
            return localBitmap1;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject1;
            break label426;
          }
          bool1 = MMJpegOptim.checkIntegrity(q.k(str, false));
          break;
        }
      }
    }
  }
  
  private static boolean abw(int paramInt)
  {
    return paramInt == 1;
  }
  
  private boolean b(k paramk, String paramString1, String paramString2, bo parambo)
  {
    AppMethodBeat.i(36021);
    k.aF(paramk.IdY, 0);
    k.aF(paramk.IdP, 8);
    k.aF(paramk.IdU, 8);
    k.aF(paramk.IdV, 8);
    boolean bool = a(paramk.IdY, paramString1, paramString2, paramk.mPosition, parambo, paramk);
    AppMethodBeat.o(36021);
    return bool;
  }
  
  @TargetApi(11)
  private void c(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36043);
    if ((this.HZU == null) || (this.HZU.HZV == null))
    {
      AppMethodBeat.o(36043);
      return;
    }
    ac.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), Integer.valueOf(paramBitmap.hashCode()) });
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.setEnableHorLongBmpMode(false);
      paramMultiTouchImageView.cF(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(null);
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.invalidate();
      AppMethodBeat.o(36043);
      return;
      com.tencent.mm.sdk.platformtools.p.z((View)paramMultiTouchImageView.getParent(), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  private int d(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(36038);
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      paramObject = this.HZU.aaP(i);
      if ((paramObject != null) && (paramObject.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    paramObject = this.HZU.HBa.values().iterator();
    while (paramObject.hasNext())
    {
      i = ((Integer)paramObject.next()).intValue();
      bo localbo = this.HZU.aaP(i);
      if ((localbo != null) && (localbo.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    AppMethodBeat.o(36038);
    return -1;
  }
  
  private static Bitmap d(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(36032);
    ac.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
    paramInt1 *= paramInt2;
    paramInt2 = paramInt3 * paramInt4;
    ac.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2) {}
    try
    {
      paramString = com.tencent.mm.sdk.platformtools.f.a(paramString, paramInt3, paramInt4, 0.0F);
      AppMethodBeat.o(36032);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      ac.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramString, "hy: oom in fallback bitmap!", new Object[0]);
      AppMethodBeat.o(36032);
    }
    ac.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
    AppMethodBeat.o(36032);
    return null;
    return null;
  }
  
  private String d(bo parambo, com.tencent.mm.av.e parame)
  {
    AppMethodBeat.i(36015);
    String str2 = (String)this.Ibq.get(parambo);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(parambo, parame, false);
      if ((str1 == null) || (str1.length() == 0))
      {
        AppMethodBeat.o(36015);
        return null;
      }
      this.Ibq.put(parambo, str1);
    }
    AppMethodBeat.o(36015);
    return str1;
  }
  
  private static String e(bo parambo, com.tencent.mm.av.e parame)
  {
    AppMethodBeat.i(36035);
    if ((parambo == null) || (parame == null))
    {
      AppMethodBeat.o(36035);
      return null;
    }
    if (parambo.field_isSend == 1)
    {
      parambo = parame.hGO;
      parame = o.aFx().p(parambo, "", "") + "hd";
      ac.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambo, parame });
      if ((!bs.isNullOrNil(parame)) && (i.eA(parame)))
      {
        ac.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
        AppMethodBeat.o(36035);
        return parame;
      }
      parame = o.aFx().p(parambo, "", "");
      ac.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", new Object[] { parambo, parame });
      if ((!bs.isNullOrNil(parame)) && (i.eA(parame)))
      {
        ac.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
        AppMethodBeat.o(36035);
        return parame;
      }
      AppMethodBeat.o(36035);
      return null;
    }
    if (!parame.aEZ())
    {
      ac.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
      AppMethodBeat.o(36035);
      return null;
    }
    parambo = parame.hGO;
    parame = o.aFx().p(parambo, "", "") + "hd";
    ac.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambo, parame });
    if ((!bs.isNullOrNil(parame)) && (i.eA(parame)))
    {
      ac.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
      AppMethodBeat.o(36035);
      return parame;
    }
    AppMethodBeat.o(36035);
    return null;
  }
  
  public static void fpn()
  {
    Ibs = false;
  }
  
  private void h(bo parambo, int paramInt)
  {
    AppMethodBeat.i(36010);
    this.nzI.put(Long.valueOf(parambo.field_msgId), Integer.valueOf(paramInt));
    AppMethodBeat.o(36010);
  }
  
  public static com.tencent.mm.av.e k(bo parambo)
  {
    AppMethodBeat.i(36013);
    if (!b.j(parambo))
    {
      AppMethodBeat.o(36013);
      return null;
    }
    long l;
    com.tencent.mm.av.e locale1;
    if (parambo.field_isSend == 1)
    {
      l = parambo.field_msgId;
      com.tencent.mm.av.e locale2 = o.aFx().qg(l);
      locale1 = locale2;
      if (locale2.dcd != 0L) {}
    }
    else
    {
      l = parambo.field_msgSvrId;
      locale1 = o.aFx().qf(l);
    }
    AppMethodBeat.o(36013);
    return locale1;
  }
  
  private void o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(36011);
    this.nzI.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(36011);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36040);
    if (!(paramObject instanceof Integer))
    {
      ac.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
      AppMethodBeat.o(36040);
      return;
    }
    ac.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos ".concat(String.valueOf(((Integer)paramObject).intValue())), new Object[0]);
    AppMethodBeat.o(36040);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn)
  {
    AppMethodBeat.i(36036);
    if ((this.HZU == null) || (this.HZU.HZV == null))
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
    if (l.fpT().Bt(paramLong2))
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
        ac.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(36036);
        return;
      }
      i = ((Integer)paramObject).intValue();
      ac.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1) });
      if (i == -1)
      {
        ac.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
        AppMethodBeat.o(36036);
        return;
      }
      if (this.HZU.QZ(i) == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      paramObject = (k)this.HZU.QZ(i).getTag();
      if (paramObject == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.HZU.HZV.getCurrentItem()) && (abw(paramInt1)))
        {
          ac.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.HZU.HZV.abE(paramInt2);
        }
        paramn = (com.tencent.mm.av.k)paramn;
        boolean bool1 = MMNativeJpeg.isProgressive(paramn.hIs);
        boolean bool2 = paramn.hIu;
        paramLong1 = bs.aO(this.Ibu);
        d.a.gg(paramn.hIs, paramInt4);
        ac.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramn.hIs });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break label679;
        }
        this.Ibu = bs.Gn();
        paramn = this.HZU.aaP(i);
        if (paramn == null)
        {
          ac.e("MicroMsg.ImageGalleryHolderImage", "msg is null! pos:%s", new Object[] { Integer.valueOf(i) });
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
      com.tencent.mm.av.e locale = g(paramn, true);
      if (a(false, paramObject.IdY, o.aFx().R(paramn.field_imgPath, true), a(paramn, locale, true), true, -1, paramn, paramObject, locale, true))
      {
        k.aF(paramObject.IdS, 8);
        k.aF(paramObject.IdV, 8);
        if ((i == this.HZU.HZV.getCurrentItem()) && (!abw(paramInt1))) {
          if (paramInt2 > 50)
          {
            k.aF(paramObject.IdU, 8);
            if (this.HZU != null)
            {
              this.HZU.a(paramn, locale, paramInt1, com.tencent.mm.g.b.a.g.a.dEP);
              AppMethodBeat.o(36036);
            }
          }
          else
          {
            k.aF(paramObject.IdU, 0);
          }
        }
      }
      label679:
      AppMethodBeat.o(36036);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, final int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(36037);
    if ((this.HZU == null) || (this.HZU.HZV == null))
    {
      AppMethodBeat.o(36037);
      return;
    }
    if (l.fpT().Bt(paramLong2))
    {
      paramInt2 = d(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        az.ayM();
        a(com.tencent.mm.model.c.awD().vP(paramLong2), "background", false);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = Integer.valueOf(paramInt2);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        ac.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(36037);
        return;
      }
      paramInt2 = ((Integer)paramObject).intValue();
      ac.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = ".concat(String.valueOf(paramInt2)));
      if (paramInt2 == -1)
      {
        ac.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 3L, 1L, true);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = null;
      if (this.HZU.QZ(paramInt2) != null) {
        paramObject = (k)this.HZU.QZ(paramInt2).getTag();
      }
      boolean bool = l.fpT().Bt(paramLong2);
      if ((paramInt3 != 0) || (paramInt4 != 0))
      {
        if (bool)
        {
          paramObject = this.HZU.aaP(paramInt2);
          paramString = "hd_failed:".concat(String.valueOf(paramInt2));
          if (paramInt2 == this.HZU.HZV.getCurrentItem())
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
          o(paramLong2, 5);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 0L, 1L, true);
        }
        for (;;)
        {
          ac.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
          this.HZU.Iaa.abj(paramInt2);
          if (this.HZU != null) {
            this.HZU.a(this.HZU.aaP(paramInt2), null, paramInt1, com.tencent.mm.g.b.a.g.a.dER);
          }
          AppMethodBeat.o(36037);
          return;
          bool = false;
          break;
          label394:
          o(paramLong2, 6);
          com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 1L, 1L, true);
        }
      }
      if (bool)
      {
        paramString = this.HZU.aaP(paramInt2);
        paramn = "hd_suc:".concat(String.valueOf(paramInt2));
        if (paramInt2 != this.HZU.HZV.getCurrentItem()) {
          break label561;
        }
      }
      label561:
      for (bool = true;; bool = false)
      {
        a(paramString, paramn, bool);
        ac.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.HZU.HZV.getCurrentItem(), new Object[0]);
        o(paramLong2, 4);
        paramString = this.HZU.aaP(paramInt2);
        paramn = g(paramString, true);
        if ((paramString != null) && (paramn != null)) {
          break;
        }
        AppMethodBeat.o(36037);
        return;
      }
      if (paramObject != null)
      {
        if (paramInt2 == this.HZU.HZV.getCurrentItem())
        {
          if (!abw(paramInt1)) {
            break label843;
          }
          ImageGalleryUI localImageGalleryUI = this.HZU.HZV;
          localImageGalleryUI.fpx();
          localImageGalleryUI.fpx();
          Animation localAnimation = ImageGalleryUI.abD(1000);
          localAnimation.setAnimationListener(new ImageGalleryUI.26(localImageGalleryUI));
          localImageGalleryUI.crF();
          localImageGalleryUI.fpq().Icg.setVisibility(0);
          localImageGalleryUI.fpq().Ich.setVisibility(8);
          localImageGalleryUI.fpq().Ici.setVisibility(8);
          localImageGalleryUI.fpq().Icj.setVisibility(0);
          localImageGalleryUI.fpq().Icj.startAnimation(localAnimation);
        }
        while (a(false, paramObject.IdY, o.aFx().R(paramString.field_imgPath, true), a(paramString, paramn, true), true, -1, paramString, paramObject, paramn, false))
        {
          k.aF(paramObject.IdP, 8);
          k.aF(paramObject.IdU, 8);
          k.aF(paramObject.IdV, 8);
          if ((cc(paramString) == 4) && (this.HZU.HZZ))
          {
            this.HZU.bY(paramString);
            this.HZU.HZZ = false;
          }
          if (this.HZU == null) {
            break label887;
          }
          this.HZU.a(paramString, paramn, paramInt1, com.tencent.mm.g.b.a.g.a.dEP);
          AppMethodBeat.o(36037);
          return;
          label843:
          paramObject.IdY.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36003);
              if ((d.this.HZU == null) || (d.this.HZU.HZV == null))
              {
                AppMethodBeat.o(36003);
                return;
              }
              d.this.HZU.HZV.abz(paramInt2);
              AppMethodBeat.o(36003);
            }
          });
        }
        ac.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(111L, 2L, 1L, true);
      }
      label887:
      AppMethodBeat.o(36037);
      return;
    }
  }
  
  public final void a(WxImageView paramWxImageView, String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(36029);
    BitmapFactory.Options localOptions = aQu(paramString);
    paramWxImageView.setOrientation(BackwardSupportUtil.ExifHelper.ce(paramString));
    paramWxImageView.cF(localOptions.outWidth, localOptions.outHeight);
    paramWxImageView.fij();
    paramWxImageView.a(paramString, parama);
    AppMethodBeat.o(36029);
  }
  
  public final boolean a(k paramk, bo parambo, int paramInt)
  {
    AppMethodBeat.i(36012);
    super.a(paramk, parambo, paramInt);
    if ((paramk == null) || (parambo == null) || (paramInt < 0))
    {
      AppMethodBeat.o(36012);
      return false;
    }
    i = cc(parambo);
    ac.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", new Object[] { Integer.valueOf(paramk.IdY.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(i) });
    k.aF(paramk.IdP, 8);
    try
    {
      locale = g(parambo, false);
      if (locale != null) {
        break label115;
      }
      bool1 = false;
    }
    catch (NullPointerException paramk)
    {
      for (;;)
      {
        com.tencent.mm.av.e locale;
        ac.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramk, "", new Object[0]);
        boolean bool1 = false;
        continue;
        if (parambo.fbQ())
        {
          bool1 = true;
        }
        else
        {
          Object localObject = d(parambo, locale);
          if ((!locale.aEZ()) || ((localObject != null) && (i.eA((String)localObject))))
          {
            long l1 = ce.azH();
            long l2 = parambo.field_createTime;
            if ((l1 - l2 <= 259200000L) || ((!bs.isNullOrNil((String)localObject)) && (i.eA((String)localObject)))) {
              break label1001;
            }
            ac.i("MicroMsg.ImageGalleryHolderImage", "cur time: %s, msg time: %s, path: %s.", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject });
            i = 1;
            break label990;
            if (a(paramk, parambo, locale, paramInt))
            {
              bool1 = false;
              boolean bool2 = false;
              localObject = o.aFx().I(parambo);
              ac.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.av.e)localObject).dcd), Long.valueOf(((com.tencent.mm.av.e)localObject).hGV), Long.valueOf(((com.tencent.mm.av.e)localObject).dpl), Integer.valueOf(((com.tencent.mm.av.e)localObject).hGX), Integer.valueOf(((com.tencent.mm.av.e)localObject).hux) });
              if (localObject != null) {
                if (!bs.jl(((com.tencent.mm.av.e)localObject).hGX, 0))
                {
                  localObject = o.aFx().oR(((com.tencent.mm.av.e)localObject).hGX);
                  ac.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.av.e)localObject).dcd), Long.valueOf(((com.tencent.mm.av.e)localObject).hGV), Long.valueOf(((com.tencent.mm.av.e)localObject).dpl), Integer.valueOf(((com.tencent.mm.av.e)localObject).hGX), Integer.valueOf(((com.tencent.mm.av.e)localObject).hux) });
                  i = ((com.tencent.mm.av.e)localObject).hux;
                  int j = (int)i.aSp(o.aFx().p(locale.hGM, "", ""));
                  bool1 = bool2;
                  if (parambo.field_isSend == 1)
                  {
                    bool1 = bool2;
                    if (bs.jl(i, j)) {
                      bool1 = true;
                    }
                  }
                  ac.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() sizeInDb:%s oriSize:%s noNeedDownLoad:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
                }
              }
              for (;;)
              {
                if ((!bool1) && (!locale.aEZ())) {
                  break label686;
                }
                h(parambo, 4);
                break;
                i = ((com.tencent.mm.av.e)localObject).hux;
                break label557;
                ac.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
              }
              h(parambo, 1);
            }
            for (;;)
            {
              aa.O(parambo);
              i = o.aFy().a(locale.dcd, parambo.field_msgId, 0, Integer.valueOf(paramInt), 2131231564, this, 0, true);
              if (this.HZU != null) {
                this.HZU.h(parambo, false);
              }
              ac.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[] { Integer.valueOf(i) });
              if (i != -2) {
                break label915;
              }
              ac.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
              locale = g(parambo, true);
              if (locale != null) {
                break label816;
              }
              ac.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
              break;
              ac.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
              h(parambo, 2);
            }
            if (a(paramk, parambo, locale, paramInt))
            {
              if ((parambo.field_isSend == 1) || (locale.aEZ()))
              {
                h(parambo, 4);
                continue;
              }
              h(parambo, 1);
            }
            for (;;)
            {
              ac.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(locale.dcd), Boolean.valueOf(locale.aEZ()) });
              a(paramk, parambo, locale, false, paramInt);
              break;
              h(parambo, 2);
            }
            a(paramk, parambo, locale, false, paramInt);
            continue;
            a(paramk, parambo, locale, paramInt);
            continue;
            a(paramk, parambo, locale, false, paramInt);
            continue;
            a(paramk, parambo, locale, true, paramInt);
            continue;
            a(parambo, paramk, i);
            paramk.sSS.invalidate();
          }
          else
          {
            bool1 = true;
            continue;
          }
          for (;;)
          {
            if (i == 0) {
              break label1007;
            }
            bool1 = true;
            break;
            i = 0;
          }
          bool1 = false;
        }
      }
    }
    AppMethodBeat.o(36012);
    return bool1;
    switch (i)
    {
    default: 
    case 0: 
      for (;;)
      {
        label115:
        bool1 = true;
        break;
        ac.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
        ac.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
        if (parambo.field_isSend != 1) {
          break label235;
        }
        bool1 = parambo.fbQ();
        if (!bool1) {
          break label359;
        }
        h(parambo, 5);
        a(parambo, paramk, 5);
      }
    }
  }
  
  public final Bitmap aQw(String paramString)
  {
    AppMethodBeat.i(210139);
    paramString = aQx(paramString);
    AppMethodBeat.o(210139);
    return paramString;
  }
  
  public final void aZ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36041);
    ac.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(paramInt)));
    Object localObject1 = this.HZU.aaP(paramInt);
    if ((localObject1 == null) || (((dy)localObject1).field_msgId == 0L))
    {
      ac.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      AppMethodBeat.o(36041);
      return;
    }
    if (!b.j((bo)localObject1))
    {
      ac.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.av.e locale = g((bo)localObject1, true);
    Object localObject2;
    if ((locale == null) || (locale.dcd == 0L))
    {
      localObject2 = new StringBuilder("viewHdImg fail, msgLocalId = ");
      if (localObject1 == null)
      {
        localObject1 = "null";
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", imgLocalId = ");
        if (locale != null) {
          break label178;
        }
      }
      label178:
      for (localObject1 = "null";; localObject1 = Long.valueOf(locale.dcd))
      {
        ac.e("MicroMsg.ImageGalleryHolderImage", localObject1);
        AppMethodBeat.o(36041);
        return;
        localObject1 = Long.valueOf(((dy)localObject1).field_msgId);
        break;
      }
    }
    h((bo)localObject1, 3);
    if (abi(paramInt) != null) {
      a(abi(paramInt), (bo)localObject1, locale, true, false, paramInt);
    }
    if (this.HZU != null) {
      this.HZU.h((bo)localObject1, true);
    }
    if (paramBoolean)
    {
      localObject2 = l.fpT();
      ac.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((dy)localObject1).field_msgId) });
      ((l)localObject2).Iei.add(Long.valueOf(((dy)localObject1).field_msgId));
      o.aFy().a(locale.dcd, ((dy)localObject1).field_msgId, Integer.valueOf(paramInt), (com.tencent.mm.av.d.a)localObject2);
      AppMethodBeat.o(36041);
      return;
    }
    o.aFy().a(locale.dcd, ((dy)localObject1).field_msgId, Integer.valueOf(paramInt), this);
    AppMethodBeat.o(36041);
  }
  
  public final Bitmap abx(int paramInt)
  {
    AppMethodBeat.i(36044);
    if (this.HZU == null)
    {
      AppMethodBeat.o(36044);
      return null;
    }
    bo localbo = this.HZU.HZW.abu(paramInt);
    if (localbo != null)
    {
      Object localObject = b.bV(localbo);
      if ((localObject == b.b.IaF) || (localObject == b.b.IaG))
      {
        AppMethodBeat.o(36044);
        return null;
      }
      String str = (String)this.Ibr.get(localbo);
      localObject = str;
      if (str == null)
      {
        localObject = o.aFx().R(localbo.field_imgPath, true);
        this.Ibr.put(localbo, localObject);
      }
      str = (String)localObject + "hd";
      if (i.eA(str))
      {
        localObject = aQx(str);
        AppMethodBeat.o(36044);
        return localObject;
      }
      localObject = aQx((String)localObject);
      AppMethodBeat.o(36044);
      return localObject;
    }
    AppMethodBeat.o(36044);
    return null;
  }
  
  public final void b(View paramView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36027);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(36027);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.hashCode();
      int j = paramBitmap.hashCode();
      int k = this.Ibp.sRB.indexOfValue(i);
      if (k >= 0) {
        this.Ibp.sRB.removeAt(k);
      }
      this.Ibp.sRB.put(j, i);
      if ((paramView instanceof MultiTouchImageView))
      {
        c((MultiTouchImageView)paramView, paramBitmap);
        AppMethodBeat.o(36027);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageBitmap(paramBitmap);
      }
    }
    AppMethodBeat.o(36027);
  }
  
  public final int cc(bo parambo)
  {
    AppMethodBeat.i(36009);
    if ((parambo != null) && (this.nzI.containsKey(Long.valueOf(parambo.field_msgId))))
    {
      int i = ((Integer)this.nzI.get(Long.valueOf(parambo.field_msgId))).intValue();
      AppMethodBeat.o(36009);
      return i;
    }
    AppMethodBeat.o(36009);
    return 0;
  }
  
  public final void cd(bo parambo)
  {
    AppMethodBeat.i(36042);
    com.tencent.mm.av.e locale = k(parambo);
    if ((locale == null) || (parambo == null))
    {
      AppMethodBeat.o(36042);
      return;
    }
    if (this.HZU != null) {
      this.HZU.a(parambo, null, 1, com.tencent.mm.g.b.a.g.a.dEQ);
    }
    if (l.fpT().Bt(parambo.field_msgId))
    {
      l locall = l.fpT();
      locall.Iei.remove(Long.valueOf(parambo.field_msgId));
      o.aFy().a(locale.dcd, parambo.field_msgId, locall);
      o.aFy().x(locale.dcd, parambo.field_msgId);
      AppMethodBeat.o(36042);
      return;
    }
    o.aFy().a(locale.dcd, parambo.field_msgId, this);
    o.aFy().x(locale.dcd, parambo.field_msgId);
    AppMethodBeat.o(36042);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36008);
    super.detach();
    com.tencent.mm.sdk.b.a.GpY.d(this.Ibo);
    if (this.CvQ != null)
    {
      localObject = this.CvQ.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.CvQ.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ac.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.Ibp;
    ((e)localObject).IbC = null;
    ((e)localObject).sRw.clear();
    ((e)localObject).sRz.clear();
    ((e)localObject).sRy.clear();
    ((e)localObject).sRx.clear();
    ((e)localObject).IbB.clear();
    ((e)localObject).cNO();
    if ((((e)localObject).xio != null) && (!((e)localObject).xio.isRecycled()))
    {
      ac.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", new Object[] { ((e)localObject).xio.toString() });
      ((e)localObject).xio.recycle();
      ((e)localObject).xio = null;
    }
    o.aFy().a(this);
    localObject = l.fpT();
    if (equals(((l)localObject).Iej)) {
      ((l)localObject).Iej = null;
    }
    AppMethodBeat.o(36008);
  }
  
  public final com.tencent.mm.av.e g(bo parambo, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(36014);
    if (!b.j(parambo))
    {
      AppMethodBeat.o(36014);
      return null;
    }
    if ((this.HZU == null) || (this.HZU.HZW == null))
    {
      ac.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
      AppMethodBeat.o(36014);
      return null;
    }
    if (!paramBoolean)
    {
      if (parambo.field_isSend == 1) {
        localObject2 = (com.tencent.mm.av.e)this.HZU.HZW.Iax.get(Long.valueOf(parambo.field_msgId));
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (parambo.field_msgSvrId > 0L) {
          localObject1 = (com.tencent.mm.av.e)this.HZU.HZW.Iaw.get(Long.valueOf(parambo.field_msgSvrId));
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramBoolean = false;
      long l;
      if (parambo.field_isSend == 1)
      {
        l = parambo.field_msgId;
        localObject2 = o.aFx().qg(l);
        localObject1 = localObject2;
        if (((com.tencent.mm.av.e)localObject2).dcd != 0L) {}
      }
      else
      {
        l = parambo.field_msgSvrId;
        localObject1 = o.aFx().qf(l);
        paramBoolean = true;
      }
      this.HZU.HZW.a(l, (com.tencent.mm.av.e)localObject1, paramBoolean);
      localObject2 = localObject1;
    }
    AppMethodBeat.o(36014);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d
 * JD-Core Version:    0.7.0.1
 */