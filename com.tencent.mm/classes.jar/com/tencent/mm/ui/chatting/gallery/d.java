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
import com.tencent.mm.aw.h;
import com.tencent.mm.aw.m;
import com.tencent.mm.b.f;
import com.tencent.mm.b.p;
import com.tencent.mm.g.b.a.i.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class d
  extends a
  implements com.tencent.mm.aw.e.a, e.a
{
  private static boolean JQK;
  private static long JQL;
  private HashMap<String, WeakReference<Bitmap>> DZy;
  private com.tencent.mm.sdk.b.c JQF;
  n JQG;
  public final e JQH;
  private HashMap<bu, String> JQI;
  private HashMap<bu, String> JQJ;
  private long JQM;
  int mScrollState;
  public HashMap<Long, Integer> oaN;
  
  static
  {
    AppMethodBeat.i(36048);
    JQK = true;
    JQL = (Runtime.getRuntime().maxMemory() * 0.05D);
    AppMethodBeat.o(36048);
  }
  
  public d(b paramb)
  {
    super(paramb);
    AppMethodBeat.i(36007);
    this.oaN = new HashMap();
    this.JQH = new e(this);
    this.DZy = new HashMap();
    this.JQI = new HashMap();
    this.JQJ = new HashMap();
    this.JQM = 0L;
    this.mScrollState = 0;
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.IbL;
    paramb = new ak(ak.a.JEh, paramb.JPk);
    this.JQF = paramb;
    locala.c(paramb);
    paramb = g.a.JRj.tOe.snapshot();
    this.JQH.bU(paramb);
    l.fGC().JTK = this;
    AppMethodBeat.o(36007);
  }
  
  public static String a(bu parambu, com.tencent.mm.aw.g paramg)
  {
    AppMethodBeat.i(36033);
    parambu = a(parambu, paramg, false);
    AppMethodBeat.o(36033);
    return parambu;
  }
  
  private static String a(bu parambu, com.tencent.mm.aw.g paramg, boolean paramBoolean)
  {
    AppMethodBeat.i(36034);
    if (parambu.field_isSend == 1)
    {
      parambu = com.tencent.mm.aw.q.aIF().a(parambu.field_talker, paramg);
      str = com.tencent.mm.aw.q.aIF().o(parambu, "", "");
      ad.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", new Object[] { parambu, str });
      if (com.tencent.mm.vfs.i.fv(str))
      {
        AppMethodBeat.o(36034);
        return str;
      }
      parambu = paramg.hZw;
      paramg = com.tencent.mm.aw.q.aIF().o(parambu, "", "");
      ad.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", new Object[] { parambu, paramg });
      if (com.tencent.mm.vfs.i.fv(paramg))
      {
        AppMethodBeat.o(36034);
        return paramg;
      }
      AppMethodBeat.o(36034);
      return null;
    }
    if ((!paramBoolean) && (!paramg.aIi()))
    {
      ad.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(paramg.aIi()) });
      AppMethodBeat.o(36034);
      return null;
    }
    String str = paramg.hZw;
    if (paramg.aIj())
    {
      parambu = com.tencent.mm.aw.q.aIF().a(parambu.field_talker, paramg);
      if (parambu != null)
      {
        parambu = com.tencent.mm.aw.q.aIF().o(parambu, "", "");
        if (com.tencent.mm.vfs.i.fv(parambu)) {
          ad.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      paramg = parambu;
      if (parambu == null) {
        paramg = com.tencent.mm.aw.q.aIF().o(str, "", "");
      }
      ad.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[] { paramg });
      AppMethodBeat.o(36034);
      return paramg;
      parambu = null;
    }
  }
  
  private static void a(bu parambu, k paramk, int paramInt)
  {
    AppMethodBeat.i(36019);
    ad.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
    k.aH(paramk.JTv, 8);
    k.aH(paramk.JTq, 8);
    k.aH(paramk.JTz, 8);
    k.aH(paramk.JTA, 8);
    paramk.fGz().JTw.setVisibility(0);
    paramk.fGz().JTy.setImageResource(2131690686);
    if ((str == null) || (!com.tencent.mm.vfs.i.fv(str)))
    {
      paramk.fGz().JTx.setText(2131760325);
      AppMethodBeat.o(36019);
      return;
    }
    if (paramInt == 6)
    {
      paramk.fGz().JTx.setText(2131760323);
      AppMethodBeat.o(36019);
      return;
    }
    if (parambu.frT())
    {
      paramk.fGz().JTx.setText(2131760321);
      AppMethodBeat.o(36019);
      return;
    }
    paramk.fGz().JTx.setText(2131760322);
    AppMethodBeat.o(36019);
  }
  
  private static void a(bu parambu, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(36039);
    ad.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(parambu.field_msgId), paramString });
    b.c(aj.getContext(), parambu, paramBoolean);
    AppMethodBeat.o(36039);
  }
  
  private void a(k paramk, bu parambu, com.tencent.mm.aw.g paramg, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(36017);
    a(paramk, parambu, paramg, paramBoolean, true, paramInt);
    AppMethodBeat.o(36017);
  }
  
  private void a(k paramk, bu parambu, com.tencent.mm.aw.g paramg, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(36018);
    ad.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(paramBoolean1)));
    k.aH(paramk.JTw, 8);
    String str1 = null;
    if (!paramBoolean1) {
      paramk.JTz.setVisibility(0);
    }
    com.tencent.mm.aw.g localg = h.a(paramg);
    if ((paramBoolean1) && (paramInt == this.JPj.JPk.getCurrentItem())) {
      this.JPj.JPk.fGq();
    }
    if (paramBoolean1) {
      str1 = a(parambu, paramg, true);
    }
    String str2 = str1;
    if (bt.isNullOrNil(str1)) {
      str2 = com.tencent.mm.aw.q.aIF().o(localg.hZy, "", "");
    }
    str1 = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
    if (paramBoolean2) {
      a(paramk, str1, str2, parambu);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = paramg.hMP;
      int i = paramg.offset;
      if (paramInt == 0) {
        break label258;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label264;
      }
      paramk.fGy().JTv.setVisibility(8);
    }
    for (;;)
    {
      paramk.fGy().JTt.setVisibility(8);
      paramk.fGy().JTs.setVisibility(8);
      paramk.fGy().JTr.setVisibility(8);
      AppMethodBeat.o(36018);
      return;
      label258:
      l = 0L;
      break;
      label264:
      paramk.fGy().JTv.setVisibility(0);
    }
  }
  
  private static void a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    AppMethodBeat.i(36026);
    Object localObject;
    int i;
    if (paramk != null) {
      if (paramk.JTA != null)
      {
        localObject = paramk.JTA;
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
    for (paramk.JTB = true;; paramk.JTB = false)
    {
      if (paramk.JTz != null)
      {
        localObject = paramk.JTz;
        i = j;
        if (paramBoolean2) {
          i = 0;
        }
        ((MultiTouchImageView)localObject).setVisibility(i);
        if (paramBoolean2) {
          paramk.JTB = false;
        }
      }
      AppMethodBeat.o(36026);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, int paramInt, bu parambu, k paramk)
  {
    AppMethodBeat.i(36024);
    boolean bool = a(true, paramMultiTouchImageView, paramString1, paramString2, false, paramInt, parambu, paramk, null, false);
    AppMethodBeat.o(36024);
    return bool;
  }
  
  private boolean a(k paramk, bu parambu, com.tencent.mm.aw.g paramg, int paramInt)
  {
    AppMethodBeat.i(36016);
    ad.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = d(parambu, paramg);
    k.aH(paramk.JTv, 8);
    String str1 = (String)this.JQJ.get(parambu);
    paramg = str1;
    if (str1 == null)
    {
      paramg = com.tencent.mm.aw.q.aIF().R(parambu.field_imgPath, true);
      this.JQJ.put(parambu, paramg);
    }
    boolean bool = a(paramk, paramg, str2, parambu);
    if ((paramInt == this.JPj.JPk.getCurrentItem()) && (this.JPj.JPo))
    {
      this.JPj.ce(parambu);
      this.JPj.JPo = false;
    }
    AppMethodBeat.o(36016);
    return bool;
  }
  
  private boolean a(k paramk, String paramString1, String paramString2, bu parambu)
  {
    AppMethodBeat.i(36020);
    boolean bool = b(paramk, paramString1, paramString2, parambu);
    AppMethodBeat.o(36020);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, final int paramInt, final bu parambu, final k paramk, com.tencent.mm.aw.g paramg, boolean paramBoolean3)
  {
    AppMethodBeat.i(36025);
    ad.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt) });
    Object localObject2 = null;
    boolean bool1 = true;
    if ((paramString2 != null) && (com.tencent.mm.vfs.i.fv(paramString2))) {
      localObject2 = com.tencent.mm.vfs.i.k(paramString2, false);
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
          if (com.tencent.mm.vfs.i.fv(paramString1))
          {
            localObject1 = com.tencent.mm.vfs.i.k(paramString1, false);
            if (com.tencent.mm.vfs.i.fv(paramString1 + "hd")) {
              localObject1 = com.tencent.mm.vfs.i.k(paramString1 + "hd", false);
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
    if ((!((String)localObject1).equals(paramString1)) && (!paramBoolean3) && (aWo((String)localObject1)))
    {
      paramBoolean3 = true;
      ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", new Object[] { Boolean.valueOf(paramBoolean3), localObject1 });
      if ((paramk.JTA == null) || (paramk.JTA.getVisibility() != 0)) {
        break label391;
      }
      i = 1;
      label284:
      if ((!paramBoolean3) || (i != 0)) {
        break label397;
      }
    }
    label391:
    label397:
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((paramBoolean3) || (paramBoolean2) || (!this.JQH.tOe.aM(localObject1))) {
        break label403;
      }
      localObject2 = (Bitmap)this.JQH.tOe.aL(localObject1);
      if (((Bitmap)localObject2).isRecycled()) {
        break label403;
      }
      ad.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[] { localObject1 });
      b(paramMultiTouchImageView, (String)localObject1, (Bitmap)localObject2);
      AppMethodBeat.o(36025);
      return true;
      paramBoolean3 = false;
      break;
      i = 0;
      break label284;
    }
    label403:
    if (paramBoolean1) {
      paramMultiTouchImageView.setImageBitmap(null);
    }
    localObject2 = paramg;
    if (paramBoolean3)
    {
      if (paramk.JTA == null)
      {
        AppMethodBeat.o(36025);
        return false;
      }
      localObject2 = paramg;
      if (paramg == null) {
        localObject2 = g(parambu, true);
      }
      paramk.JTA.setOnImageLoadEventListener(new com.tencent.mm.graphics.a.b()
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
          com.tencent.mm.cp.c.agv(paramAnonymousc.errCode);
          d.a(d.this, this.JQN, paramk, paramInt);
          if (paramAnonymousc.errCode == 4) {
            d.fFS();
          }
          AppMethodBeat.o(36001);
        }
        
        public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(36002);
          ad.e("MicroMsg.ImageGalleryHolderImage", "alvinluo BigImgOpt onTileLoadError errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramAnonymousc.errCode), paramAnonymousc.errMsg });
          d.a(parambu, paramk);
          AppMethodBeat.o(36002);
        }
        
        public final void m(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(35999);
          e locale;
          if ((paramAnonymousBitmap != null) && (d.this.JQH != null))
          {
            ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo onImageLoaded cache bitmap, cacheImagePath: %s", new Object[] { this.JQN });
            locale = d.this.JQH;
            if (paramInt <= 0) {
              break label110;
            }
          }
          label110:
          for (int i = paramInt;; i = paramk.mPosition)
          {
            locale.e(i, paramAnonymousBitmap);
            d.a(paramk);
            if (d.a(d.this) != null) {
              d.a(d.this).b(paramk.JTA, this.JQN, paramAnonymousBitmap);
            }
            AppMethodBeat.o(35999);
            return;
          }
        }
        
        public final void rY()
        {
          AppMethodBeat.i(35998);
          ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo SubsamplingImageView onPreviewLoaded");
          AppMethodBeat.o(35998);
        }
        
        public final void rZ() {}
      });
    }
    if (!this.JPj.JPv)
    {
      if (paramInt >= 0)
      {
        ad.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[] { Integer.valueOf(paramInt) });
        a(paramk, false, true);
        this.JQH.c(paramMultiTouchImageView, paramInt);
      }
      if (!paramBoolean3) {
        break label743;
      }
      a(paramk, true, bool2);
      paramMultiTouchImageView = e(parambu, (com.tencent.mm.aw.g)localObject2);
      paramString1 = this.JQH;
      paramString2 = paramk.JTA;
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
        paramMultiTouchImageView = e(parambu, (com.tencent.mm.aw.g)localObject2);
        a(paramk, true, bool2);
        paramString1 = paramk.JTA;
        if (paramMultiTouchImageView != null) {}
        for (paramMultiTouchImageView = com.davemorrissey.labs.subscaleview.view.a.aP(paramMultiTouchImageView);; paramMultiTouchImageView = null)
        {
          a(paramString1, (String)localObject1, paramMultiTouchImageView);
          AppMethodBeat.o(36025);
          return bool1;
        }
      }
      Bitmap localBitmap = aWq((String)localObject1);
      paramg = localBitmap;
      if (localBitmap == null) {
        paramg = aWq(paramString1);
      }
      if (paramg == null) {
        break;
      }
      a(paramk, false, true);
      a(paramMultiTouchImageView, (String)localObject1, paramg);
      if (((String)localObject1).equals(paramString2))
      {
        this.JQH.w((String)localObject1, paramg);
        this.JQH.e(paramInt, paramg);
      }
      AppMethodBeat.o(36025);
      return bool1;
      label743:
      a(paramk, false, true);
      paramString1 = this.JQH;
      i = paramInt;
      if (paramInt < 0) {
        i = paramk.mPosition;
      }
      paramString1.f(paramMultiTouchImageView, (String)localObject1, i);
    }
  }
  
  private static Bitmap aV(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(36030);
    String str = paramString + "_tmp.jpg";
    try
    {
      bool1 = com.tencent.mm.compatible.util.d.lz(16);
      if (bool1)
      {
        AppMethodBeat.o(36030);
        return null;
      }
      bool1 = com.tencent.mm.sdk.a.b.fjN();
      if (!bool1) {
        try
        {
          i = bt.getInt(com.tencent.mm.n.g.acA().getValue("UseOptImageRecv"), 0);
          ba.aBQ();
          p localp = new p(com.tencent.mm.model.c.getUin());
          ad.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Integer.valueOf(i), Long.valueOf(localp.longValue()), Long.valueOf(localp.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.fjN()), Integer.valueOf(Build.VERSION.SDK_INT) });
          j = (int)(localp.longValue() / 100L);
          if (j % 100 + 1 > i)
          {
            AppMethodBeat.o(36030);
            return null;
          }
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[] { bt.n(localException) });
          AppMethodBeat.o(36030);
          return null;
        }
      }
      com.tencent.mm.vfs.i.aYg(com.tencent.mm.vfs.i.aYr(str));
      com.tencent.mm.vfs.i.mz(paramString, str);
      bool2 = MMNativeJpeg.IsJpegFile(str);
      bool3 = MMNativeJpeg.isProgressive(str);
      if (bt.isNullOrNil(str)) {
        break label474;
      }
      if (com.tencent.mm.vfs.i.fv(str)) {
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
        ad.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[] { paramString, bt.n(localThrowable1) });
        localObject1 = localBitmap2;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        boolean bool1 = false;
      }
    }
    j = (int)com.tencent.mm.vfs.i.aYo(str);
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
            com.tencent.mm.vfs.i.deleteFile(str);
            AppMethodBeat.o(36030);
            return localBitmap1;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject1;
            break label426;
          }
          bool1 = MMJpegOptim.checkIntegrity(com.tencent.mm.b.q.k(str, false));
          break;
        }
      }
    }
  }
  
  protected static BitmapFactory.Options aWn(String paramString)
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
  
  private static boolean aWo(String paramString)
  {
    AppMethodBeat.i(36023);
    if (!JQK)
    {
      ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
      AppMethodBeat.o(36023);
      return false;
    }
    boolean bool = com.tencent.mm.cp.b.aYR(paramString);
    AppMethodBeat.o(36023);
    return bool;
  }
  
  private static Bitmap aWq(String paramString)
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
    int i2 = BackwardSupportUtil.ExifHelper.cY(paramString);
    int i1 = ((BitmapFactory.Options)localObject1).outWidth;
    int n = ((BitmapFactory.Options)localObject1).outHeight;
    int k = n;
    int m = i1;
    for (;;)
    {
      try
      {
        long l1 = Math.max(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - JQL, 0L);
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
        localObject3 = aV(paramString, j, i);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          k = j;
          m = i;
          localObject1 = com.tencent.mm.sdk.platformtools.g.a(paramString, i, j, 0.0F);
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
        localObject2 = e(paramString, m, k, i, j);
        continue;
        i = ((Context)localObject2).getResources().getDisplayMetrics().widthPixels;
        continue;
        j = ((Context)localObject2).getResources().getDisplayMetrics().heightPixels;
        continue;
        paramString = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, i2);
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
  
  private static boolean adI(int paramInt)
  {
    return paramInt == 1;
  }
  
  @TargetApi(11)
  private void b(MultiTouchImageView paramMultiTouchImageView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(194145);
    if ((this.JPj == null) || (this.JPj.JPk == null))
    {
      AppMethodBeat.o(194145);
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
      if (this.JQG != null) {
        this.JQG.b(paramMultiTouchImageView, paramString, paramBitmap);
      }
      AppMethodBeat.o(194145);
      return;
      com.tencent.mm.sdk.platformtools.q.A((View)paramMultiTouchImageView.getParent(), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  private boolean b(k paramk, String paramString1, String paramString2, bu parambu)
  {
    AppMethodBeat.i(36021);
    k.aH(paramk.JTz, 0);
    k.aH(paramk.JTq, 8);
    k.aH(paramk.JTv, 8);
    k.aH(paramk.JTw, 8);
    boolean bool = a(paramk.JTz, paramString1, paramString2, paramk.mPosition, parambu, paramk);
    AppMethodBeat.o(36021);
    return bool;
  }
  
  private int d(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(36038);
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      paramObject = this.JPj.ada(i);
      if ((paramObject != null) && (paramObject.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    paramObject = this.JPj.JoR.values().iterator();
    while (paramObject.hasNext())
    {
      i = ((Integer)paramObject.next()).intValue();
      bu localbu = this.JPj.ada(i);
      if ((localbu != null) && (localbu.field_msgId == paramLong))
      {
        AppMethodBeat.o(36038);
        return i;
      }
    }
    AppMethodBeat.o(36038);
    return -1;
  }
  
  private String d(bu parambu, com.tencent.mm.aw.g paramg)
  {
    AppMethodBeat.i(36015);
    String str2 = (String)this.JQI.get(parambu);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(parambu, paramg, false);
      if ((str1 == null) || (str1.length() == 0))
      {
        AppMethodBeat.o(36015);
        return null;
      }
      this.JQI.put(parambu, str1);
    }
    AppMethodBeat.o(36015);
    return str1;
  }
  
  private static Bitmap e(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(36032);
    ad.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
    paramInt1 *= paramInt2;
    paramInt2 = paramInt3 * paramInt4;
    ad.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2) {}
    try
    {
      paramString = com.tencent.mm.sdk.platformtools.g.a(paramString, paramInt3, paramInt4, 0.0F);
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
  
  private static String e(bu parambu, com.tencent.mm.aw.g paramg)
  {
    AppMethodBeat.i(36035);
    if ((parambu == null) || (paramg == null))
    {
      AppMethodBeat.o(36035);
      return null;
    }
    if (parambu.field_isSend == 1)
    {
      parambu = paramg.hZy;
      paramg = com.tencent.mm.aw.q.aIF().o(parambu, "", "") + "hd";
      ad.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambu, paramg });
      if ((!bt.isNullOrNil(paramg)) && (com.tencent.mm.vfs.i.fv(paramg)))
      {
        ad.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
        AppMethodBeat.o(36035);
        return paramg;
      }
      paramg = com.tencent.mm.aw.q.aIF().o(parambu, "", "");
      ad.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", new Object[] { parambu, paramg });
      if ((!bt.isNullOrNil(paramg)) && (com.tencent.mm.vfs.i.fv(paramg)))
      {
        ad.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
        AppMethodBeat.o(36035);
        return paramg;
      }
      AppMethodBeat.o(36035);
      return null;
    }
    if (!paramg.aIi())
    {
      ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
      AppMethodBeat.o(36035);
      return null;
    }
    parambu = paramg.hZy;
    paramg = com.tencent.mm.aw.q.aIF().o(parambu, "", "") + "hd";
    ad.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambu, paramg });
    if ((!bt.isNullOrNil(paramg)) && (com.tencent.mm.vfs.i.fv(paramg)))
    {
      ad.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
      AppMethodBeat.o(36035);
      return paramg;
    }
    AppMethodBeat.o(36035);
    return null;
  }
  
  public static void fFS()
  {
    JQK = false;
  }
  
  private void h(bu parambu, int paramInt)
  {
    AppMethodBeat.i(36010);
    this.oaN.put(Long.valueOf(parambu.field_msgId), Integer.valueOf(paramInt));
    AppMethodBeat.o(36010);
  }
  
  public static com.tencent.mm.aw.g k(bu parambu)
  {
    AppMethodBeat.i(36013);
    if (!b.j(parambu))
    {
      AppMethodBeat.o(36013);
      return null;
    }
    long l;
    com.tencent.mm.aw.g localg1;
    if (parambu.field_isSend == 1)
    {
      l = parambu.field_msgId;
      com.tencent.mm.aw.g localg2 = com.tencent.mm.aw.q.aIF().G(parambu.field_talker, l);
      localg1 = localg2;
      if (localg2.dnz != 0L) {}
    }
    else
    {
      l = parambu.field_msgSvrId;
      localg1 = com.tencent.mm.aw.q.aIF().F(parambu.field_talker, l);
    }
    AppMethodBeat.o(36013);
    return localg1;
  }
  
  private void o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(36011);
    this.oaN.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(36011);
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
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(36036);
    if ((this.JPj == null) || (this.JPj.JPk == null))
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
    if (l.fGC().El(paramLong2))
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
      if (this.JPj.SJ(i) == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      paramObject = (k)this.JPj.SJ(i).getTag();
      if (paramObject == null)
      {
        AppMethodBeat.o(36036);
        return;
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.JPj.JPk.getCurrentItem()) && (adI(paramInt1)))
        {
          ad.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.JPj.JPk.adQ(paramInt2);
        }
        paramn = (m)paramn;
        boolean bool1 = MMNativeJpeg.isProgressive(paramn.ibg);
        boolean bool2 = paramn.ibi;
        paramLong1 = bt.aO(this.JQM);
        d.a.gD(paramn.ibg, paramInt4);
        ad.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramn.ibg });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break label679;
        }
        this.JQM = bt.HI();
        paramn = this.JPj.ada(i);
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
      com.tencent.mm.aw.g localg = g(paramn, true);
      if (a(false, paramObject.JTz, com.tencent.mm.aw.q.aIF().R(paramn.field_imgPath, true), a(paramn, localg, true), true, -1, paramn, paramObject, localg, true))
      {
        k.aH(paramObject.JTt, 8);
        k.aH(paramObject.JTw, 8);
        if ((i == this.JPj.JPk.getCurrentItem()) && (!adI(paramInt1))) {
          if (paramInt2 > 50)
          {
            k.aH(paramObject.JTv, 8);
            if (this.JPj != null)
            {
              this.JPj.a(paramn, localg, paramInt1, i.a.dRM);
              AppMethodBeat.o(36036);
            }
          }
          else
          {
            k.aH(paramObject.JTv, 0);
          }
        }
      }
      label679:
      AppMethodBeat.o(36036);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, final int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(36037);
    if ((this.JPj == null) || (this.JPj.JPk == null))
    {
      AppMethodBeat.o(36037);
      return;
    }
    if (l.fGC().El(paramLong2))
    {
      paramInt2 = d(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        ba.aBQ();
        a(com.tencent.mm.model.c.azs().xY(paramLong2), "background", false);
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
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 3L, 1L, true);
        AppMethodBeat.o(36037);
        return;
      }
      paramObject = null;
      if (this.JPj.SJ(paramInt2) != null) {
        paramObject = (k)this.JPj.SJ(paramInt2).getTag();
      }
      boolean bool = l.fGC().El(paramLong2);
      if ((paramInt3 != 0) || (paramInt4 != 0))
      {
        if (bool)
        {
          paramObject = this.JPj.ada(paramInt2);
          paramString = "hd_failed:".concat(String.valueOf(paramInt2));
          if (paramInt2 == this.JPj.JPk.getCurrentItem())
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
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 0L, 1L, true);
        }
        for (;;)
        {
          ad.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
          this.JPj.JPp.adv(paramInt2);
          if (this.JPj != null) {
            this.JPj.a(this.JPj.ada(paramInt2), null, paramInt1, i.a.dRO);
          }
          AppMethodBeat.o(36037);
          return;
          bool = false;
          break;
          label394:
          o(paramLong2, 6);
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 1L, 1L, true);
        }
      }
      if (bool)
      {
        paramString = this.JPj.ada(paramInt2);
        paramn = "hd_suc:".concat(String.valueOf(paramInt2));
        if (paramInt2 != this.JPj.JPk.getCurrentItem()) {
          break label561;
        }
      }
      label561:
      for (bool = true;; bool = false)
      {
        a(paramString, paramn, bool);
        ad.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.JPj.JPk.getCurrentItem(), new Object[0]);
        o(paramLong2, 4);
        paramString = this.JPj.ada(paramInt2);
        paramn = g(paramString, true);
        if ((paramString != null) && (paramn != null)) {
          break;
        }
        AppMethodBeat.o(36037);
        return;
      }
      if (paramObject != null)
      {
        if (paramInt2 == this.JPj.JPk.getCurrentItem())
        {
          if (!adI(paramInt1)) {
            break label843;
          }
          ImageGalleryUI localImageGalleryUI = this.JPj.JPk;
          localImageGalleryUI.fGe();
          localImageGalleryUI.fGe();
          Animation localAnimation = ImageGalleryUI.adP(1000);
          localAnimation.setAnimationListener(new ImageGalleryUI.30(localImageGalleryUI));
          localImageGalleryUI.cxr();
          localImageGalleryUI.fFV().JRA.setVisibility(0);
          localImageGalleryUI.fFV().JRB.setVisibility(8);
          localImageGalleryUI.fFV().JRC.setVisibility(8);
          localImageGalleryUI.fFV().JRD.setVisibility(0);
          localImageGalleryUI.fFV().JRD.startAnimation(localAnimation);
        }
        while (a(false, paramObject.JTz, com.tencent.mm.aw.q.aIF().R(paramString.field_imgPath, true), a(paramString, paramn, true), true, -1, paramString, paramObject, paramn, false))
        {
          k.aH(paramObject.JTq, 8);
          k.aH(paramObject.JTv, 8);
          k.aH(paramObject.JTw, 8);
          if ((ci(paramString) == 4) && (this.JPj.JPo))
          {
            this.JPj.ce(paramString);
            this.JPj.JPo = false;
          }
          if (this.JPj == null) {
            break label887;
          }
          this.JPj.a(paramString, paramn, paramInt1, i.a.dRM);
          AppMethodBeat.o(36037);
          return;
          label843:
          paramObject.JTz.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(36003);
              if ((d.this.JPj == null) || (d.this.JPj.JPk == null))
              {
                AppMethodBeat.o(36003);
                return;
              }
              d.this.JPj.JPk.adL(paramInt2);
              AppMethodBeat.o(36003);
            }
          });
        }
        ad.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 2L, 1L, true);
      }
      label887:
      AppMethodBeat.o(36037);
      return;
    }
  }
  
  public final void a(View paramView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(194143);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(194143);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.hashCode();
      int j = paramBitmap.hashCode();
      int k = this.JQH.tOf.indexOfValue(i);
      if (k >= 0) {
        this.JQH.tOf.removeAt(k);
      }
      this.JQH.tOf.put(j, i);
      if ((paramView instanceof MultiTouchImageView))
      {
        b((MultiTouchImageView)paramView, paramString, paramBitmap);
        AppMethodBeat.o(194143);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageBitmap(paramBitmap);
      }
    }
    AppMethodBeat.o(194143);
  }
  
  public final void a(WxImageView paramWxImageView, String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(36029);
    BitmapFactory.Options localOptions = aWn(paramString);
    paramWxImageView.setOrientation(BackwardSupportUtil.ExifHelper.cY(paramString));
    paramWxImageView.cH(localOptions.outWidth, localOptions.outHeight);
    paramWxImageView.fyy();
    paramWxImageView.a(paramString, parama);
    AppMethodBeat.o(36029);
  }
  
  public final boolean a(k paramk, bu parambu, int paramInt)
  {
    AppMethodBeat.i(36012);
    super.a(paramk, parambu, paramInt);
    if ((paramk == null) || (parambu == null) || (paramInt < 0))
    {
      AppMethodBeat.o(36012);
      return false;
    }
    i = ci(parambu);
    ad.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", new Object[] { Integer.valueOf(paramk.JTz.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(i) });
    k.aH(paramk.JTq, 8);
    try
    {
      localg = g(parambu, false);
      if (localg != null) {
        break label115;
      }
      bool1 = false;
    }
    catch (NullPointerException paramk)
    {
      for (;;)
      {
        com.tencent.mm.aw.g localg;
        ad.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramk, "", new Object[0]);
        boolean bool1 = false;
        continue;
        if (parambu.frT())
        {
          bool1 = true;
        }
        else
        {
          Object localObject = d(parambu, localg);
          if ((!localg.aIi()) || ((localObject != null) && (com.tencent.mm.vfs.i.fv((String)localObject))))
          {
            long l1 = cf.aCK();
            long l2 = parambu.field_createTime;
            if ((l1 - l2 <= 259200000L) || ((!bt.isNullOrNil((String)localObject)) && (com.tencent.mm.vfs.i.fv((String)localObject)))) {
              break label1001;
            }
            ad.i("MicroMsg.ImageGalleryHolderImage", "cur time: %s, msg time: %s, path: %s.", new Object[] { Long.valueOf(l1), Long.valueOf(l2), localObject });
            i = 1;
            break label990;
            if (a(paramk, parambu, localg, paramInt))
            {
              bool1 = false;
              boolean bool2 = false;
              localObject = com.tencent.mm.aw.q.aIF().L(parambu);
              ad.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.aw.g)localObject).dnz), Long.valueOf(((com.tencent.mm.aw.g)localObject).hZF), Long.valueOf(((com.tencent.mm.aw.g)localObject).dAY), Integer.valueOf(((com.tencent.mm.aw.g)localObject).hZH), Integer.valueOf(((com.tencent.mm.aw.g)localObject).hMP) });
              if (localObject != null) {
                if (!bt.jx(((com.tencent.mm.aw.g)localObject).hZH, 0))
                {
                  localObject = com.tencent.mm.aw.q.aIF().pt(((com.tencent.mm.aw.g)localObject).hZH);
                  ad.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.aw.g)localObject).dnz), Long.valueOf(((com.tencent.mm.aw.g)localObject).hZF), Long.valueOf(((com.tencent.mm.aw.g)localObject).dAY), Integer.valueOf(((com.tencent.mm.aw.g)localObject).hZH), Integer.valueOf(((com.tencent.mm.aw.g)localObject).hMP) });
                  i = ((com.tencent.mm.aw.g)localObject).hMP;
                  int j = (int)com.tencent.mm.vfs.i.aYo(com.tencent.mm.aw.q.aIF().o(localg.hZw, "", ""));
                  bool1 = bool2;
                  if (parambu.field_isSend == 1)
                  {
                    bool1 = bool2;
                    if (bt.jx(i, j)) {
                      bool1 = true;
                    }
                  }
                  ad.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() sizeInDb:%s oriSize:%s noNeedDownLoad:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
                }
              }
              for (;;)
              {
                if ((!bool1) && (!localg.aIi())) {
                  break label686;
                }
                h(parambu, 4);
                break;
                i = ((com.tencent.mm.aw.g)localObject).hMP;
                break label557;
                ad.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
              }
              h(parambu, 1);
            }
            for (;;)
            {
              aa.R(parambu);
              i = com.tencent.mm.aw.q.aIG().a(localg.dnz, parambu.field_msgId, 0, Integer.valueOf(paramInt), 2131231564, this, 0, true);
              if (this.JPj != null) {
                this.JPj.h(parambu, false);
              }
              ad.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[] { Integer.valueOf(i) });
              if (i != -2) {
                break label915;
              }
              ad.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
              localg = g(parambu, true);
              if (localg != null) {
                break label816;
              }
              ad.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
              break;
              ad.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
              h(parambu, 2);
            }
            if (a(paramk, parambu, localg, paramInt))
            {
              if ((parambu.field_isSend == 1) || (localg.aIi()))
              {
                h(parambu, 4);
                continue;
              }
              h(parambu, 1);
            }
            for (;;)
            {
              ad.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(localg.dnz), Boolean.valueOf(localg.aIi()) });
              a(paramk, parambu, localg, false, paramInt);
              break;
              h(parambu, 2);
            }
            a(paramk, parambu, localg, false, paramInt);
            continue;
            a(paramk, parambu, localg, paramInt);
            continue;
            a(paramk, parambu, localg, false, paramInt);
            continue;
            a(paramk, parambu, localg, true, paramInt);
            continue;
            a(parambu, paramk, i);
            paramk.tPw.invalidate();
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
        if (parambu.field_isSend != 1) {
          break label235;
        }
        bool1 = parambu.frT();
        if (!bool1) {
          break label359;
        }
        h(parambu, 5);
        a(parambu, paramk, 5);
      }
    }
  }
  
  public final Bitmap aWp(String paramString)
  {
    AppMethodBeat.i(221406);
    paramString = aWq(paramString);
    AppMethodBeat.o(221406);
    return paramString;
  }
  
  public final Bitmap adJ(int paramInt)
  {
    AppMethodBeat.i(36044);
    if (this.JPj == null)
    {
      AppMethodBeat.o(36044);
      return null;
    }
    bu localbu = this.JPj.JPl.adG(paramInt);
    if (localbu != null)
    {
      Object localObject = b.cb(localbu);
      if ((localObject == b.b.JPW) || (localObject == b.b.JPX))
      {
        AppMethodBeat.o(36044);
        return null;
      }
      String str = (String)this.JQJ.get(localbu);
      localObject = str;
      if (str == null)
      {
        localObject = com.tencent.mm.aw.q.aIF().R(localbu.field_imgPath, true);
        this.JQJ.put(localbu, localObject);
      }
      str = (String)localObject + "hd";
      if (com.tencent.mm.vfs.i.fv(str))
      {
        localObject = aWq(str);
        AppMethodBeat.o(36044);
        return localObject;
      }
      localObject = aWq((String)localObject);
      AppMethodBeat.o(36044);
      return localObject;
    }
    AppMethodBeat.o(36044);
    return null;
  }
  
  public final void bg(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(36041);
    ad.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(paramInt)));
    Object localObject1 = this.JPj.ada(paramInt);
    if ((localObject1 == null) || (((ei)localObject1).field_msgId == 0L))
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      AppMethodBeat.o(36041);
      return;
    }
    if (!b.j((bu)localObject1))
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.aw.g localg = g((bu)localObject1, true);
    Object localObject2;
    if ((localg == null) || (localg.dnz == 0L))
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
      for (localObject1 = "null";; localObject1 = Long.valueOf(localg.dnz))
      {
        ad.e("MicroMsg.ImageGalleryHolderImage", localObject1);
        AppMethodBeat.o(36041);
        return;
        localObject1 = Long.valueOf(((ei)localObject1).field_msgId);
        break;
      }
    }
    h((bu)localObject1, 3);
    if (adu(paramInt) != null) {
      a(adu(paramInt), (bu)localObject1, localg, true, false, paramInt);
    }
    if (this.JPj != null) {
      this.JPj.h((bu)localObject1, true);
    }
    if (paramBoolean)
    {
      localObject2 = l.fGC();
      ad.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((ei)localObject1).field_msgId) });
      ((l)localObject2).JTJ.add(Long.valueOf(((ei)localObject1).field_msgId));
      com.tencent.mm.aw.q.aIG().a(localg.dnz, ((ei)localObject1).field_msgId, Integer.valueOf(paramInt), (com.tencent.mm.aw.e.a)localObject2);
      AppMethodBeat.o(36041);
      return;
    }
    com.tencent.mm.aw.q.aIG().a(localg.dnz, ((ei)localObject1).field_msgId, Integer.valueOf(paramInt), this);
    AppMethodBeat.o(36041);
  }
  
  public final int ci(bu parambu)
  {
    AppMethodBeat.i(36009);
    if ((parambu != null) && (this.oaN.containsKey(Long.valueOf(parambu.field_msgId))))
    {
      int i = ((Integer)this.oaN.get(Long.valueOf(parambu.field_msgId))).intValue();
      AppMethodBeat.o(36009);
      return i;
    }
    AppMethodBeat.o(36009);
    return 0;
  }
  
  public final void cj(bu parambu)
  {
    AppMethodBeat.i(36042);
    com.tencent.mm.aw.g localg = k(parambu);
    if ((localg == null) || (parambu == null))
    {
      AppMethodBeat.o(36042);
      return;
    }
    if (this.JPj != null) {
      this.JPj.a(parambu, null, 1, i.a.dRN);
    }
    if (l.fGC().El(parambu.field_msgId))
    {
      l locall = l.fGC();
      locall.JTJ.remove(Long.valueOf(parambu.field_msgId));
      com.tencent.mm.aw.q.aIG().a(localg.dnz, parambu.field_msgId, locall);
      com.tencent.mm.aw.q.aIG().x(localg.dnz, parambu.field_msgId);
      AppMethodBeat.o(36042);
      return;
    }
    com.tencent.mm.aw.q.aIG().a(localg.dnz, parambu.field_msgId, this);
    com.tencent.mm.aw.q.aIG().x(localg.dnz, parambu.field_msgId);
    AppMethodBeat.o(36042);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(36008);
    super.detach();
    com.tencent.mm.sdk.b.a.IbL.d(this.JQF);
    if (this.DZy != null)
    {
      localObject = this.DZy.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.DZy.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ad.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.JQH;
    ((e)localObject).JQU = null;
    ((e)localObject).tOa.clear();
    ((e)localObject).tOd.clear();
    ((e)localObject).tOc.clear();
    ((e)localObject).tOb.clear();
    ((e)localObject).JQT.clear();
    ((e)localObject).cWg();
    if ((((e)localObject).ywr != null) && (!((e)localObject).ywr.isRecycled()))
    {
      ad.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", new Object[] { ((e)localObject).ywr.toString() });
      ((e)localObject).ywr.recycle();
      ((e)localObject).ywr = null;
    }
    com.tencent.mm.aw.q.aIG().a(this);
    localObject = l.fGC();
    if (equals(((l)localObject).JTK)) {
      ((l)localObject).JTK = null;
    }
    AppMethodBeat.o(36008);
  }
  
  public final com.tencent.mm.aw.g g(bu parambu, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(36014);
    if (!b.j(parambu))
    {
      AppMethodBeat.o(36014);
      return null;
    }
    if ((this.JPj == null) || (this.JPj.JPl == null))
    {
      ad.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
      AppMethodBeat.o(36014);
      return null;
    }
    if (!paramBoolean)
    {
      if (parambu.field_isSend == 1) {
        localObject2 = (com.tencent.mm.aw.g)this.JPj.JPl.JPO.get(Long.valueOf(parambu.field_msgId));
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (parambu.field_msgSvrId > 0L) {
          localObject1 = (com.tencent.mm.aw.g)this.JPj.JPl.JPN.get(Long.valueOf(parambu.field_msgSvrId));
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramBoolean = false;
      long l;
      if (parambu.field_isSend == 1)
      {
        l = parambu.field_msgId;
        localObject2 = com.tencent.mm.aw.q.aIF().G(parambu.field_talker, l);
        localObject1 = localObject2;
        if (((com.tencent.mm.aw.g)localObject2).dnz != 0L) {}
      }
      else
      {
        l = parambu.field_msgSvrId;
        localObject1 = com.tencent.mm.aw.q.aIF().F(parambu.field_talker, l);
        paramBoolean = true;
      }
      this.JPj.JPl.a(l, (com.tencent.mm.aw.g)localObject1, paramBoolean);
      localObject2 = localObject1;
    }
    AppMethodBeat.o(36014);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.d
 * JD-Core Version:    0.7.0.1
 */