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
import com.tencent.mm.al.n;
import com.tencent.mm.aw.o;
import com.tencent.mm.b.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
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
  implements com.tencent.mm.aw.d.a, e.a
{
  private static boolean GBx;
  private static long GBy;
  private HashMap<String, WeakReference<Bitmap>> BdE;
  private com.tencent.mm.sdk.b.c GBt;
  public final e GBu;
  private HashMap<bl, String> GBv;
  private HashMap<bl, String> GBw;
  private long GBz;
  int mScrollState;
  public HashMap<Long, Integer> mXj;
  
  static
  {
    AppMethodBeat.i(36048);
    GBx = true;
    GBy = (Runtime.getRuntime().maxMemory() * 0.05D);
    AppMethodBeat.o(36048);
  }
  
  public d(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36007);
    this.mXj = new HashMap();
    this.GBu = new e(this);
    this.BdE = new HashMap();
    this.GBv = new HashMap();
    this.GBw = new HashMap();
    this.GBz = 0L;
    this.mScrollState = 0;
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.ESL;
    paramb = new ak(ak.a.GqA, paramb.GAa);
    this.GBt = paramb;
    locala.c(paramb);
    paramb = g.a.GBX.rJL.snapshot();
    this.GBu.bL(paramb);
    l.fad().GEm = this;
    AppMethodBeat.o(36007);
  }
  
  private static boolean Zk(int paramInt)
  {
    return paramInt == 1;
  }
  
  public static String a(bl parambl, com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(36033);
    parambl = a(parambl, parame, false);
    AppMethodBeat.o(36033);
    return parambl;
  }
  
  private static String a(bl parambl, com.tencent.mm.aw.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(36034);
    if (parambl.field_isSend == 1)
    {
      parambl = o.ayF().d(parame);
      str = o.ayF().p(parambl, "", "");
      ad.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", new Object[] { parambl, str });
      if (i.eK(str))
      {
        AppMethodBeat.o(36034);
        return str;
      }
      parambl = parame.hgj;
      parame = o.ayF().p(parambl, "", "");
      ad.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", new Object[] { parambl, parame });
      if (i.eK(parame))
      {
        AppMethodBeat.o(36034);
        return parame;
      }
      AppMethodBeat.o(36034);
      return null;
    }
    if ((!paramBoolean) && (!parame.ayh()))
    {
      ad.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(parame.ayh()) });
      AppMethodBeat.o(36034);
      return null;
    }
    String str = parame.hgj;
    if (parame.ayi())
    {
      parambl = o.ayF().d(parame);
      if (parambl != null)
      {
        parambl = o.ayF().p(parambl, "", "");
        if (i.eK(parambl)) {
          ad.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      parame = parambl;
      if (parambl == null) {
        parame = o.ayF().p(str, "", "");
      }
      ad.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[] { parame });
      AppMethodBeat.o(36034);
      return parame;
      parambl = null;
    }
  }
  
  private static void a(bl parambl, k paramk, int paramInt)
  {
    AppMethodBeat.i(36019);
    ad.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = o.ayF().Q(parambl.field_imgPath, true);
    k.aD(paramk.GDX, 8);
    k.aD(paramk.GDS, 8);
    k.aD(paramk.GEb, 8);
    k.aD(paramk.GEc, 8);
    paramk.faa().GDY.setVisibility(0);
    paramk.faa().GEa.setImageResource(2131690686);
    if ((str == null) || (!i.eK(str)))
    {
      paramk.faa().GDZ.setText(2131760325);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramInt == 6)
    {
      paramk.faa().GDZ.setText(2131760323);
      AppMethodBeat.o(36019);
      return;
    }
    if (parambl.eMl())
    {
      paramk.faa().GDZ.setText(2131760321);
      AppMethodBeat.o(36019);
      return;
    }
    paramk.faa().GDZ.setText(2131760322);
    AppMethodBeat.o(36019);
  }
  
  private static void a(bl parambl, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36039);
    ad.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(parambl.field_msgId), paramString });
    b.c(aj.getContext(), parambl, paramBoolean);
    AppMethodBeat.o(36039);
  }
  
  private void a(k paramk, bl parambl, com.tencent.mm.aw.e parame, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36017);
    a(paramk, parambl, parame, paramBoolean, true, paramInt);
    AppMethodBeat.o(36017);
  }
  
  private void a(k paramk, bl parambl, com.tencent.mm.aw.e parame, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(36018);
    ad.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(paramBoolean1)));
    k.aD(paramk.GDY, 8);
    String str1 = null;
    if (!paramBoolean1) {
      paramk.GEb.setVisibility(0);
    }
    com.tencent.mm.aw.e locale = com.tencent.mm.aw.f.a(parame);
    if ((paramBoolean1) && (paramInt == this.GzZ.GAa.getCurrentItem())) {
      this.GzZ.GAa.eZR();
    }
    if (paramBoolean1) {
      str1 = a(parambl, parame, true);
    }
    String str2 = str1;
    if (bt.isNullOrNil(str1)) {
      str2 = o.ayF().p(locale.hgl, "", "");
    }
    str1 = o.ayF().Q(parambl.field_imgPath, true);
    if (paramBoolean2) {
      a(paramk, str1, str2, parambl);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = parame.gTY;
      int i = parame.offset;
      if (paramInt == 0) {
        break label258;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label264;
      }
      paramk.eZZ().GDX.setVisibility(8);
    }
    for (;;)
    {
      paramk.eZZ().GDV.setVisibility(8);
      paramk.eZZ().GDU.setVisibility(8);
      paramk.eZZ().GDT.setVisibility(8);
      AppMethodBeat.o(36018);
      return;
      label258:
      l = 0L;
      break;
      label264:
      paramk.eZZ().GDX.setVisibility(0);
    }
  }
  
  private static void a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    AppMethodBeat.i(36026);
    Object localObject;
    int i;
    if (paramk != null) {
      if (paramk.GEc != null)
      {
        localObject = paramk.GEc;
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
    for (paramk.GEd = true;; paramk.GEd = false)
    {
      if (paramk.GEb != null)
      {
        localObject = paramk.GEb;
        i = j;
        if (paramBoolean2) {
          i = 0;
        }
        ((MultiTouchImageView)localObject).setVisibility(i);
        if (paramBoolean2) {
          paramk.GEd = false;
        }
      }
      AppMethodBeat.o(36026);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, int paramInt, bl parambl, k paramk)
  {
    AppMethodBeat.i(36024);
    boolean bool = a(true, paramMultiTouchImageView, paramString1, paramString2, false, paramInt, parambl, paramk, null, false);
    AppMethodBeat.o(36024);
    return bool;
  }
  
  private boolean a(k paramk, bl parambl, com.tencent.mm.aw.e parame, int paramInt)
  {
    AppMethodBeat.i(36016);
    ad.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = d(parambl, parame);
    k.aD(paramk.GDX, 8);
    String str1 = (String)this.GBw.get(parambl);
    parame = str1;
    if (str1 == null)
    {
      parame = o.ayF().Q(parambl.field_imgPath, true);
      this.GBw.put(parambl, parame);
    }
    boolean bool = a(paramk, parame, str2, parambl);
    if ((paramInt == this.GzZ.GAa.getCurrentItem()) && (this.GzZ.GAe))
    {
      this.GzZ.bV(parambl);
      this.GzZ.GAe = false;
    }
    AppMethodBeat.o(36016);
    return bool;
  }
  
  private boolean a(k paramk, String paramString1, String paramString2, bl parambl)
  {
    AppMethodBeat.i(36020);
    boolean bool = b(paramk, paramString1, paramString2, parambl);
    AppMethodBeat.o(36020);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, final int paramInt, final bl parambl, final k paramk, com.tencent.mm.aw.e parame, boolean paramBoolean3)
  {
    AppMethodBeat.i(36025);
    ad.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt) });
    Object localObject2 = null;
    boolean bool1 = true;
    if ((paramString2 != null) && (i.eK(paramString2))) {
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
          if (i.eK(paramString1))
          {
            localObject1 = i.k(paramString1, false);
            if (i.eK(paramString1 + "hd")) {
              localObject1 = i.k(paramString1 + "hd", false);
            }
          }
        }
      }
      if (localObject1 != null) {
        break;
      }
      ad.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", new Object[] { paramString2 });
      AppMethodBeat.o(36025);
      return false;
      bool1 = false;
    }
    if (paramk == null)
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
      AppMethodBeat.o(36025);
      return false;
    }
    int i;
    if ((!((String)localObject1).equals(paramString1)) && (!paramBoolean3) && (aKS((String)localObject1)))
    {
      paramBoolean3 = true;
      ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", new Object[] { Boolean.valueOf(paramBoolean3), localObject1 });
      if ((paramk.GEc == null) || (paramk.GEc.getVisibility() != 0)) {
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
      if ((paramBoolean3) || (paramBoolean2) || (!this.GBu.rJL.aN(localObject1))) {
        break label401;
      }
      localObject2 = (Bitmap)this.GBu.rJL.aM(localObject1);
      if (((Bitmap)localObject2).isRecycled()) {
        break label401;
      }
      ad.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[] { localObject1 });
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
      if (paramk.GEc == null)
      {
        AppMethodBeat.o(36025);
        return false;
      }
      localObject2 = parame;
      if (parame == null) {
        localObject2 = h(parambl, true);
      }
      paramk.GEc.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
      {
        public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36000);
          ad.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onPreviewLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          AppMethodBeat.o(36000);
        }
        
        public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36001);
          ad.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onImageLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          com.tencent.mm.cq.c.abC(paramAnonymousc.errCode);
          d.a(d.this, this.GBA, paramk, paramInt);
          if (paramAnonymousc.errCode == 4) {
            d.eZy();
          }
          AppMethodBeat.o(36001);
        }
        
        public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36002);
          ad.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          d.a(parambl, paramk);
          AppMethodBeat.o(36002);
        }
        
        public final void m(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(35999);
          e locale;
          if ((paramAnonymousBitmap != null) && (d.this.GBu != null))
          {
            ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[] { this.GBA });
            locale = d.this.GBu;
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
        
        public final void qq()
        {
          AppMethodBeat.i(35998);
          ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
          AppMethodBeat.o(35998);
        }
        
        public final void qr() {}
      });
    }
    if (!this.GzZ.GAl)
    {
      if (paramInt >= 0)
      {
        ad.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[] { Integer.valueOf(paramInt) });
        a(paramk, false, true);
        this.GBu.c(paramMultiTouchImageView, paramInt);
      }
      if (!paramBoolean3) {
        break label739;
      }
      a(paramk, true, bool2);
      paramMultiTouchImageView = e(parambl, (com.tencent.mm.aw.e)localObject2);
      paramString1 = this.GBu;
      paramString2 = paramk.GEc;
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
        paramMultiTouchImageView = e(parambl, (com.tencent.mm.aw.e)localObject2);
        a(paramk, true, bool2);
        paramString1 = paramk.GEc;
        if (paramMultiTouchImageView != null) {}
        for (paramMultiTouchImageView = com.davemorrissey.labs.subscaleview.view.a.U(paramMultiTouchImageView);; paramMultiTouchImageView = null)
        {
          a(paramString1, (String)localObject1, paramMultiTouchImageView);
          AppMethodBeat.o(36025);
          return bool1;
        }
      }
      Bitmap localBitmap = aKT((String)localObject1);
      parame = localBitmap;
      if (localBitmap == null) {
        parame = aKT(paramString1);
      }
      if (parame == null) {
        break;
      }
      a(paramk, false, true);
      b(paramMultiTouchImageView, parame);
      if (((String)localObject1).equals(paramString2))
      {
        this.GBu.x((String)localObject1, parame);
        this.GBu.e(paramInt, parame);
      }
      AppMethodBeat.o(36025);
      return bool1;
      label739:
      a(paramk, false, true);
      paramString1 = this.GBu;
      i = paramInt;
      if (paramInt < 0) {
        i = paramk.mPosition;
      }
      paramString1.f(paramMultiTouchImageView, (String)localObject1, i);
    }
  }
  
  protected static BitmapFactory.Options aKR(String paramString)
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
  
  private static boolean aKS(String paramString)
  {
    AppMethodBeat.i(36023);
    if (!GBx)
    {
      ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
      AppMethodBeat.o(36023);
      return false;
    }
    boolean bool = com.tencent.mm.cq.b.aNp(paramString);
    AppMethodBeat.o(36023);
    return bool;
  }
  
  private static Bitmap aKT(String paramString)
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
      ad.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localObject3.toString() });
      ((Bitmap)localObject3).recycle();
    }
    int i2 = BackwardSupportUtil.ExifHelper.co(paramString);
    int i1 = ((BitmapFactory.Options)localObject1).outWidth;
    int n = ((BitmapFactory.Options)localObject1).outHeight;
    int k = n;
    int m = i1;
    for (;;)
    {
      try
      {
        long l1 = Math.max(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - GBy, 0L);
        k = n;
        m = i1;
        i = ((BitmapFactory.Options)localObject1).outHeight;
        k = n;
        m = i1;
        long l2 = ((BitmapFactory.Options)localObject1).outWidth * i * 4;
        k = n;
        m = i1;
        ad.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        j = n;
        i = i1;
        if (l1 < l2)
        {
          k = n;
          m = i1;
          double d = Math.sqrt(l1 / l2);
          k = n;
          m = i1;
          ad.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", new Object[] { Double.valueOf(d) });
          i = (int)(i1 * d);
          j = (int)(n * d);
        }
        k = j;
        m = i;
        localObject3 = aO(paramString, j, i);
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
              ad.i("MicroMsg.ImageGalleryHolderImage", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
            }
          }
        }
        localObject1 = localObject3;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        boolean bool;
        ad.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", localOutOfMemoryError, "hy: out of memory! try use fallback bitmap", new Object[0]);
        Object localObject2 = aj.getContext();
        if (localObject2 != null) {
          continue;
        }
        int i = 0;
        localObject2 = aj.getContext();
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
        ad.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[] { Integer.valueOf(i2) });
        AppMethodBeat.o(36031);
        return null;
        AppMethodBeat.o(36031);
      }
      if (localObject1 != null) {
        continue;
      }
      ad.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(36031);
      return null;
      bool = false;
    }
    return paramString;
  }
  
  private static Bitmap aO(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36030);
    String str = paramString + "_tmp.jpg";
    try
    {
      bool1 = com.tencent.mm.compatible.util.d.lg(16);
      if (bool1)
      {
        AppMethodBeat.o(36030);
        return null;
      }
      bool1 = com.tencent.mm.sdk.a.b.eEQ();
      if (!bool1) {
        try
        {
          i = bt.getInt(com.tencent.mm.m.g.Zd().getValue("UseOptImageRecv"), 0);
          az.arV();
          com.tencent.mm.b.p localp = new com.tencent.mm.b.p(com.tencent.mm.model.c.getUin());
          ad.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Integer.valueOf(i), Long.valueOf(localp.longValue()), Long.valueOf(localp.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.eEQ()), Integer.valueOf(Build.VERSION.SDK_INT) });
          j = (int)(localp.longValue() / 100L);
          if (j % 100 + 1 > i)
          {
            AppMethodBeat.o(36030);
            return null;
          }
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[] { bt.m(localException) });
          AppMethodBeat.o(36030);
          return null;
        }
      }
      i.aMF(i.aMQ(str));
      i.lC(paramString, str);
      bool2 = MMNativeJpeg.IsJpegFile(str);
      bool3 = MMNativeJpeg.isProgressive(str);
      if (bt.isNullOrNil(str)) {
        break label474;
      }
      if (i.eK(str)) {
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
        ad.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[] { paramString, bt.m(localThrowable1) });
        localObject1 = localBitmap2;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        boolean bool1 = false;
      }
    }
    j = (int)i.aMN(str);
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
            ad.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localBitmap1, paramString });
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
  
  private boolean b(k paramk, String paramString1, String paramString2, bl parambl)
  {
    AppMethodBeat.i(36021);
    k.aD(paramk.GEb, 0);
    k.aD(paramk.GDS, 8);
    k.aD(paramk.GDX, 8);
    k.aD(paramk.GDY, 8);
    boolean bool = a(paramk.GEb, paramString1, paramString2, paramk.mPosition, parambl, paramk);
    AppMethodBeat.o(36021);
    return bool;
  }
  
  @TargetApi(11)
  private void c(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(36043);
    if ((this.GzZ == null) || (this.GzZ.GAa == null))
    {
      AppMethodBeat.o(36043);
      return;
    }
    ad.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), Integer.valueOf(paramBitmap.hashCode()) });
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.setEnableHorLongBmpMode(false);
      paramMultiTouchImageView.cH(paramBitmap.getWidth(), paramBitmap.getHeight());
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
      paramObject = this.GzZ.YE(i);
      if ((paramObject != null) && (paramObject.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    paramObject = this.GzZ.Gbl.values().iterator();
    while (paramObject.hasNext())
    {
      i = ((Integer)paramObject.next()).intValue();
      bl localbl = this.GzZ.YE(i);
      if ((localbl != null) && (localbl.field_msgId == paramLong))
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
    ad.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
    paramInt1 *= paramInt2;
    paramInt2 = paramInt3 * paramInt4;
    ad.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2) {}
    try
    {
      paramString = com.tencent.mm.sdk.platformtools.f.a(paramString, paramInt3, paramInt4, 0.0F);
      AppMethodBeat.o(36032);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      ad.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramString, "hy: oom in fallback bitmap!", new Object[0]);
      AppMethodBeat.o(36032);
    }
    ad.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
    AppMethodBeat.o(36032);
    return null;
    return null;
  }
  
  private String d(bl parambl, com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(36015);
    String str2 = (String)this.GBv.get(parambl);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(parambl, parame, false);
      if ((str1 == null) || (str1.length() == 0))
      {
        AppMethodBeat.o(36015);
        return null;
      }
      this.GBv.put(parambl, str1);
    }
    AppMethodBeat.o(36015);
    return str1;
  }
  
  private static String e(bl parambl, com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(36035);
    if ((parambl == null) || (parame == null))
    {
      AppMethodBeat.o(36035);
      return null;
    }
    if (parambl.field_isSend == 1)
    {
      parambl = parame.hgl;
      parame = o.ayF().p(parambl, "", "") + "hd";
      ad.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambl, parame });
      if ((!bt.isNullOrNil(parame)) && (i.eK(parame)))
      {
        ad.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
        AppMethodBeat.o(36035);
        return parame;
      }
      parame = o.ayF().p(parambl, "", "");
      ad.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", new Object[] { parambl, parame });
      if ((!bt.isNullOrNil(parame)) && (i.eK(parame)))
      {
        ad.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
        AppMethodBeat.o(36035);
        return parame;
      }
      AppMethodBeat.o(36035);
      return null;
    }
    if (!parame.ayh())
    {
      ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
      AppMethodBeat.o(36035);
      return null;
    }
    parambl = parame.hgl;
    parame = o.ayF().p(parambl, "", "") + "hd";
    ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambl, parame });
    if ((!bt.isNullOrNil(parame)) && (i.eK(parame)))
    {
      ad.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
      AppMethodBeat.o(36035);
      return parame;
    }
    AppMethodBeat.o(36035);
    return null;
  }
  
  public static void eZy()
  {
    GBx = false;
  }
  
  private void h(bl parambl, int paramInt)
  {
    AppMethodBeat.i(36010);
    this.mXj.put(Long.valueOf(parambl.field_msgId), Integer.valueOf(paramInt));
    AppMethodBeat.o(36010);
  }
  
  public static com.tencent.mm.aw.e k(bl parambl)
  {
    AppMethodBeat.i(36013);
    if (!b.j(parambl))
    {
      AppMethodBeat.o(36013);
      return null;
    }
    long l;
    com.tencent.mm.aw.e locale1;
    if (parambl.field_isSend == 1)
    {
      l = parambl.field_msgId;
      com.tencent.mm.aw.e locale2 = o.ayF().ms(l);
      locale1 = locale2;
      if (locale2.deI != 0L) {}
    }
    else
    {
      l = parambl.field_msgSvrId;
      locale1 = o.ayF().mr(l);
    }
    AppMethodBeat.o(36013);
    return locale1;
  }
  
  private void n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(36011);
    this.mXj.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(36011);
  }
  
  public final Bitmap Zl(int paramInt)
  {
    AppMethodBeat.i(36044);
    if (this.GzZ == null)
    {
      AppMethodBeat.o(36044);
      return null;
    }
    bl localbl = this.GzZ.GAb.Zi(paramInt);
    if (localbl != null)
    {
      Object localObject = b.bS(localbl);
      if ((localObject == b.b.GAK) || (localObject == b.b.GAL))
      {
        AppMethodBeat.o(36044);
        return null;
      }
      String str = (String)this.GBw.get(localbl);
      localObject = str;
      if (str == null)
      {
        localObject = o.ayF().Q(localbl.field_imgPath, true);
        this.GBw.put(localbl, localObject);
      }
      str = (String)localObject + "hd";
      if (i.eK(str))
      {
        localObject = aKT(str);
        AppMethodBeat.o(36044);
        return localObject;
      }
      localObject = aKT((String)localObject);
      AppMethodBeat.o(36044);
      return localObject;
    }
    AppMethodBeat.o(36044);
    return null;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(36040);
    if (!(paramObject instanceof Integer))
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
      AppMethodBeat.o(36040);
      return;
    }
    ad.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos ".concat(String.valueOf(((Integer)paramObject).intValue())), new Object[0]);
    AppMethodBeat.o(36040);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn)
  {
    AppMethodBeat.i(36036);
    if ((this.GzZ == null) || (this.GzZ.GAa == null))
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
    if (l.fad().wQ(paramLong2))
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
        ad.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(36036);
        return;
      }
      i = ((Integer)paramObject).intValue();
      ad.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1) });
      if (i == -1)
      {
        ad.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
        AppMethodBeat.o(36036);
        return;
      }
      if (this.GzZ.OT(i) == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      paramObject = (k)this.GzZ.OT(i).getTag();
      if (paramObject == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.GzZ.GAa.getCurrentItem()) && (Zk(paramInt1)))
        {
          ad.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.GzZ.GAa.Zs(paramInt2);
        }
        paramn = (com.tencent.mm.aw.k)paramn;
        boolean bool1 = MMNativeJpeg.isProgressive(paramn.hhP);
        boolean bool2 = paramn.hhR;
        paramLong1 = bt.aS(this.GBz);
        d.a.gc(paramn.hhP, paramInt4);
        ad.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramn.hhP });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break label679;
        }
        this.GBz = bt.GC();
        paramn = this.GzZ.YE(i);
        if (paramn == null)
        {
          ad.e("MicroMsg.ImageGalleryHolderImage", "msg is null! pos:%s", new Object[] { Integer.valueOf(i) });
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
      com.tencent.mm.aw.e locale = h(paramn, true);
      if (a(false, paramObject.GEb, o.ayF().Q(paramn.field_imgPath, true), a(paramn, locale, true), true, -1, paramn, paramObject, locale, true))
      {
        k.aD(paramObject.GDV, 8);
        k.aD(paramObject.GDY, 8);
        if ((i == this.GzZ.GAa.getCurrentItem()) && (!Zk(paramInt1))) {
          if (paramInt2 > 50)
          {
            k.aD(paramObject.GDX, 8);
            if (this.GzZ != null)
            {
              this.GzZ.a(paramn, locale, paramInt1, com.tencent.mm.g.b.a.g.a.dHc);
              AppMethodBeat.o(36036);
            }
          }
          else
          {
            k.aD(paramObject.GDX, 0);
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
    if ((this.GzZ == null) || (this.GzZ.GAa == null))
    {
      AppMethodBeat.o(36037);
      return;
    }
    if (l.fad().wQ(paramLong2))
    {
      paramInt2 = d(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        az.arV();
        a(com.tencent.mm.model.c.apO().rm(paramLong2), "background", false);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = Integer.valueOf(paramInt2);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        ad.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(36037);
        return;
      }
      paramInt2 = ((Integer)paramObject).intValue();
      ad.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = ".concat(String.valueOf(paramInt2)));
      if (paramInt2 == -1)
      {
        ad.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 3L, 1L, true);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = null;
      if (this.GzZ.OT(paramInt2) != null) {
        paramObject = (k)this.GzZ.OT(paramInt2).getTag();
      }
      boolean bool = l.fad().wQ(paramLong2);
      if ((paramInt3 != 0) || (paramInt4 != 0))
      {
        if (bool)
        {
          paramObject = this.GzZ.YE(paramInt2);
          paramString = "hd_failed:".concat(String.valueOf(paramInt2));
          if (paramInt2 == this.GzZ.GAa.getCurrentItem())
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
          n(paramLong2, 5);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 0L, 1L, true);
        }
        for (;;)
        {
          ad.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
          this.GzZ.GAf.YX(paramInt2);
          if (this.GzZ != null) {
            this.GzZ.a(this.GzZ.YE(paramInt2), null, paramInt1, com.tencent.mm.g.b.a.g.a.dHe);
          }
          AppMethodBeat.o(36037);
          return;
          bool = false;
          break;
          label394:
          n(paramLong2, 6);
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 1L, 1L, true);
        }
      }
      if (bool)
      {
        paramString = this.GzZ.YE(paramInt2);
        paramn = "hd_suc:".concat(String.valueOf(paramInt2));
        if (paramInt2 != this.GzZ.GAa.getCurrentItem()) {
          break label561;
        }
      }
      label561:
      for (bool = true;; bool = false)
      {
        a(paramString, paramn, bool);
        ad.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.GzZ.GAa.getCurrentItem(), new Object[0]);
        n(paramLong2, 4);
        paramString = this.GzZ.YE(paramInt2);
        paramn = h(paramString, true);
        if ((paramString != null) && (paramn != null)) {
          break;
        }
        AppMethodBeat.o(36037);
        return;
      }
      if (paramObject != null)
      {
        if (paramInt2 == this.GzZ.GAa.getCurrentItem())
        {
          if (!Zk(paramInt1)) {
            break label843;
          }
          ImageGalleryUI localImageGalleryUI = this.GzZ.GAa;
          localImageGalleryUI.eZH();
          localImageGalleryUI.eZH();
          Animation localAnimation = ImageGalleryUI.Zr(1000);
          localAnimation.setAnimationListener(new ImageGalleryUI.25(localImageGalleryUI));
          localImageGalleryUI.cjY();
          localImageGalleryUI.eZB().GCk.setVisibility(0);
          localImageGalleryUI.eZB().GCl.setVisibility(8);
          localImageGalleryUI.eZB().GCm.setVisibility(8);
          localImageGalleryUI.eZB().GCn.setVisibility(0);
          localImageGalleryUI.eZB().GCn.startAnimation(localAnimation);
        }
        while (a(false, paramObject.GEb, o.ayF().Q(paramString.field_imgPath, true), a(paramString, paramn, true), true, -1, paramString, paramObject, paramn, false))
        {
          k.aD(paramObject.GDS, 8);
          k.aD(paramObject.GDX, 8);
          k.aD(paramObject.GDY, 8);
          if ((bZ(paramString) == 4) && (this.GzZ.GAe))
          {
            this.GzZ.bV(paramString);
            this.GzZ.GAe = false;
          }
          if (this.GzZ == null) {
            break label887;
          }
          this.GzZ.a(paramString, paramn, paramInt1, com.tencent.mm.g.b.a.g.a.dHc);
          AppMethodBeat.o(36037);
          return;
          label843:
          paramObject.GEb.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36003);
              if ((d.this.GzZ == null) || (d.this.GzZ.GAa == null))
              {
                AppMethodBeat.o(36003);
                return;
              }
              d.this.GzZ.GAa.Zn(paramInt2);
              AppMethodBeat.o(36003);
            }
          });
        }
        ad.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 2L, 1L, true);
      }
      label887:
      AppMethodBeat.o(36037);
      return;
    }
  }
  
  public final void a(WxImageView paramWxImageView, String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(36029);
    BitmapFactory.Options localOptions = aKR(paramString);
    paramWxImageView.setOrientation(BackwardSupportUtil.ExifHelper.co(paramString));
    paramWxImageView.cH(localOptions.outWidth, localOptions.outHeight);
    paramWxImageView.eSz();
    paramWxImageView.a(paramString, parama);
    AppMethodBeat.o(36029);
  }
  
  public final boolean a(k paramk, bl parambl, int paramInt)
  {
    AppMethodBeat.i(36012);
    super.a(paramk, parambl, paramInt);
    if ((paramk == null) || (parambl == null) || (paramInt < 0))
    {
      AppMethodBeat.o(36012);
      return false;
    }
    i = bZ(parambl);
    ad.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", new Object[] { Integer.valueOf(paramk.GEb.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(i) });
    k.aD(paramk.GDS, 8);
    try
    {
      locale = h(parambl, false);
      if (locale != null) {
        break label115;
      }
      bool1 = false;
    }
    catch (NullPointerException paramk)
    {
      for (;;)
      {
        com.tencent.mm.aw.e locale;
        ad.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramk, "", new Object[0]);
        boolean bool1 = false;
        continue;
        if (parambl.eMl())
        {
          bool1 = true;
        }
        else
        {
          Object localObject = d(parambl, locale);
          if ((!locale.ayh()) || ((localObject != null) && (i.eK((String)localObject))))
          {
            long l1 = ce.asQ();
            long l2 = parambl.field_createTime;
            if ((l1 - l2 <= 259200000L) || ((!bt.isNullOrNil((String)localObject)) && (i.eK((String)localObject)))) {
              break label1001;
            }
            ad.i("MicroMsg.ImageGalleryHolderImage", "cur time: %s, msg time: %s, path: %s.", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject });
            i = 1;
            break label990;
            if (a(paramk, parambl, locale, paramInt))
            {
              bool1 = false;
              boolean bool2 = false;
              localObject = o.ayF().I(parambl);
              ad.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.aw.e)localObject).deI), Long.valueOf(((com.tencent.mm.aw.e)localObject).hgs), Long.valueOf(((com.tencent.mm.aw.e)localObject).drA), Integer.valueOf(((com.tencent.mm.aw.e)localObject).hgu), Integer.valueOf(((com.tencent.mm.aw.e)localObject).gTY) });
              if (localObject != null) {
                if (!bt.iY(((com.tencent.mm.aw.e)localObject).hgu, 0))
                {
                  localObject = o.ayF().od(((com.tencent.mm.aw.e)localObject).hgu);
                  ad.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.aw.e)localObject).deI), Long.valueOf(((com.tencent.mm.aw.e)localObject).hgs), Long.valueOf(((com.tencent.mm.aw.e)localObject).drA), Integer.valueOf(((com.tencent.mm.aw.e)localObject).hgu), Integer.valueOf(((com.tencent.mm.aw.e)localObject).gTY) });
                  i = ((com.tencent.mm.aw.e)localObject).gTY;
                  int j = (int)i.aMN(o.ayF().p(locale.hgj, "", ""));
                  bool1 = bool2;
                  if (parambl.field_isSend == 1)
                  {
                    bool1 = bool2;
                    if (bt.iY(i, j)) {
                      bool1 = true;
                    }
                  }
                  ad.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() sizeInDb:%s oriSize:%s noNeedDownLoad:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
                }
              }
              for (;;)
              {
                if ((!bool1) && (!locale.ayh())) {
                  break label686;
                }
                h(parambl, 4);
                break;
                i = ((com.tencent.mm.aw.e)localObject).gTY;
                break label557;
                ad.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
              }
              h(parambl, 1);
            }
            for (;;)
            {
              aa.O(parambl);
              i = o.ayG().a(locale.deI, parambl.field_msgId, 0, Integer.valueOf(paramInt), 2131231564, this, 0, true);
              if (this.GzZ != null) {
                this.GzZ.i(parambl, false);
              }
              ad.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[] { Integer.valueOf(i) });
              if (i != -2) {
                break label915;
              }
              ad.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
              locale = h(parambl, true);
              if (locale != null) {
                break label816;
              }
              ad.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
              break;
              ad.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
              h(parambl, 2);
            }
            if (a(paramk, parambl, locale, paramInt))
            {
              if ((parambl.field_isSend == 1) || (locale.ayh()))
              {
                h(parambl, 4);
                continue;
              }
              h(parambl, 1);
            }
            for (;;)
            {
              ad.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(locale.deI), Boolean.valueOf(locale.ayh()) });
              a(paramk, parambl, locale, false, paramInt);
              break;
              h(parambl, 2);
            }
            a(paramk, parambl, locale, false, paramInt);
            continue;
            a(paramk, parambl, locale, paramInt);
            continue;
            a(paramk, parambl, locale, false, paramInt);
            continue;
            a(paramk, parambl, locale, true, paramInt);
            continue;
            a(parambl, paramk, i);
            paramk.rLd.invalidate();
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
        ad.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
        ad.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
        if (parambl.field_isSend != 1) {
          break label235;
        }
        bool1 = parambl.eMl();
        if (!bool1) {
          break label359;
        }
        h(parambl, 5);
        a(parambl, paramk, 5);
      }
    }
  }
  
  public final void aV(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36041);
    ad.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(paramInt)));
    Object localObject1 = this.GzZ.YE(paramInt);
    if ((localObject1 == null) || (((du)localObject1).field_msgId == 0L))
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      AppMethodBeat.o(36041);
      return;
    }
    if (!b.j((bl)localObject1))
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.aw.e locale = h((bl)localObject1, true);
    Object localObject2;
    if ((locale == null) || (locale.deI == 0L))
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
      for (localObject1 = "null";; localObject1 = Long.valueOf(locale.deI))
      {
        ad.e("MicroMsg.ImageGalleryHolderImage", localObject1);
        AppMethodBeat.o(36041);
        return;
        localObject1 = Long.valueOf(((du)localObject1).field_msgId);
        break;
      }
    }
    h((bl)localObject1, 3);
    if (YW(paramInt) != null) {
      a(YW(paramInt), (bl)localObject1, locale, true, false, paramInt);
    }
    if (this.GzZ != null) {
      this.GzZ.i((bl)localObject1, true);
    }
    if (paramBoolean)
    {
      localObject2 = l.fad();
      ad.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((du)localObject1).field_msgId) });
      ((l)localObject2).GEl.add(Long.valueOf(((du)localObject1).field_msgId));
      o.ayG().a(locale.deI, ((du)localObject1).field_msgId, Integer.valueOf(paramInt), (com.tencent.mm.aw.d.a)localObject2);
      AppMethodBeat.o(36041);
      return;
    }
    o.ayG().a(locale.deI, ((du)localObject1).field_msgId, Integer.valueOf(paramInt), this);
    AppMethodBeat.o(36041);
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
      int k = this.GBu.rJM.indexOfValue(i);
      if (k >= 0) {
        this.GBu.rJM.removeAt(k);
      }
      this.GBu.rJM.put(j, i);
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
  
  public final int bZ(bl parambl)
  {
    AppMethodBeat.i(36009);
    if ((parambl != null) && (this.mXj.containsKey(Long.valueOf(parambl.field_msgId))))
    {
      int i = ((Integer)this.mXj.get(Long.valueOf(parambl.field_msgId))).intValue();
      AppMethodBeat.o(36009);
      return i;
    }
    AppMethodBeat.o(36009);
    return 0;
  }
  
  public final void ca(bl parambl)
  {
    AppMethodBeat.i(36042);
    com.tencent.mm.aw.e locale = k(parambl);
    if ((locale == null) || (parambl == null))
    {
      AppMethodBeat.o(36042);
      return;
    }
    if (this.GzZ != null) {
      this.GzZ.a(parambl, null, 1, com.tencent.mm.g.b.a.g.a.dHd);
    }
    if (l.fad().wQ(parambl.field_msgId))
    {
      l locall = l.fad();
      locall.GEl.remove(Long.valueOf(parambl.field_msgId));
      o.ayG().a(locale.deI, parambl.field_msgId, locall);
      o.ayG().A(locale.deI, parambl.field_msgId);
      AppMethodBeat.o(36042);
      return;
    }
    o.ayG().a(locale.deI, parambl.field_msgId, this);
    o.ayG().A(locale.deI, parambl.field_msgId);
    AppMethodBeat.o(36042);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36008);
    super.detach();
    com.tencent.mm.sdk.b.a.ESL.d(this.GBt);
    if (this.BdE != null)
    {
      localObject = this.BdE.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.BdE.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ad.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.GBu;
    ((e)localObject).GBH = null;
    ((e)localObject).rJH.clear();
    ((e)localObject).rJK.clear();
    ((e)localObject).rJJ.clear();
    ((e)localObject).rJI.clear();
    ((e)localObject).GBG.clear();
    ((e)localObject).cAE();
    if ((((e)localObject).GBM != null) && (!((e)localObject).GBM.isRecycled()))
    {
      ad.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", new Object[] { ((e)localObject).GBM.toString() });
      ((e)localObject).GBM.recycle();
      ((e)localObject).GBM = null;
    }
    o.ayG().a(this);
    localObject = l.fad();
    if (equals(((l)localObject).GEm)) {
      ((l)localObject).GEm = null;
    }
    AppMethodBeat.o(36008);
  }
  
  public final com.tencent.mm.aw.e h(bl parambl, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(36014);
    if (!b.j(parambl))
    {
      AppMethodBeat.o(36014);
      return null;
    }
    if ((this.GzZ == null) || (this.GzZ.GAb == null))
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
      AppMethodBeat.o(36014);
      return null;
    }
    if (!paramBoolean)
    {
      if (parambl.field_isSend == 1) {
        localObject2 = (com.tencent.mm.aw.e)this.GzZ.GAb.GAC.get(Long.valueOf(parambl.field_msgId));
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (parambl.field_msgSvrId > 0L) {
          localObject1 = (com.tencent.mm.aw.e)this.GzZ.GAb.GAB.get(Long.valueOf(parambl.field_msgSvrId));
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramBoolean = false;
      long l;
      if (parambl.field_isSend == 1)
      {
        l = parambl.field_msgId;
        localObject2 = o.ayF().ms(l);
        localObject1 = localObject2;
        if (((com.tencent.mm.aw.e)localObject2).deI != 0L) {}
      }
      else
      {
        l = parambl.field_msgSvrId;
        localObject1 = o.ayF().mr(l);
        paramBoolean = true;
      }
      this.GzZ.GAb.a(l, (com.tencent.mm.aw.e)localObject1, paramBoolean);
      localObject2 = localObject1;
    }
    AppMethodBeat.o(36014);
    return localObject2;
  }
  
  public final Bitmap loadImage(String paramString)
  {
    AppMethodBeat.i(204971);
    paramString = aKT(paramString);
    AppMethodBeat.o(204971);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d
 * JD-Core Version:    0.7.0.1
 */