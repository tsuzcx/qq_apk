package com.tencent.mm.ui.chatting.gallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
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
import com.tencent.mm.a.p;
import com.tencent.mm.at.d.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.e.ad;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.ak.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class e
  extends a
  implements d.a, f.a
{
  private static boolean zLe;
  private static long zLg;
  public HashMap<Long, Integer> jWf;
  int mScrollState;
  private HashMap<String, WeakReference<Bitmap>> vbm;
  private com.tencent.mm.sdk.b.c zLa;
  public final f zLb;
  private HashMap<bi, String> zLc;
  private HashMap<bi, String> zLd;
  private b zLf;
  private long zLh;
  
  static
  {
    AppMethodBeat.i(32135);
    zLe = true;
    zLg = (Runtime.getRuntime().maxMemory() * 0.05D);
    AppMethodBeat.o(32135);
  }
  
  public e(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(32092);
    this.jWf = new HashMap();
    this.zLb = new f(this);
    this.vbm = new HashMap();
    this.zLc = new HashMap();
    this.zLd = new HashMap();
    this.zLf = new b();
    this.zLh = 0L;
    this.mScrollState = 0;
    com.tencent.mm.sdk.b.a locala = com.tencent.mm.sdk.b.a.ymk;
    paramc = new ak(ak.a.zCi, paramc.zJK);
    this.zLa = paramc;
    locala.c(paramc);
    paramc = g.a.zLE.nfR.snapshot();
    this.zLb.aX(paramc);
    l.dKQ().zNR = this;
    AppMethodBeat.o(32092);
  }
  
  private static boolean Qd(int paramInt)
  {
    return paramInt == 1;
  }
  
  private int a(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(32125);
    int i;
    if ((paramObject instanceof Integer))
    {
      i = ((Integer)paramObject).intValue();
      paramObject = this.zJI.Pz(i);
      if ((paramObject != null) && (paramObject.field_msgId == paramLong))
      {
        AppMethodBeat.o(32125);
        return i;
      }
    }
    paramObject = this.zJI.znM.values().iterator();
    while (paramObject.hasNext())
    {
      i = ((Integer)paramObject.next()).intValue();
      bi localbi = this.zJI.Pz(i);
      if ((localbi != null) && (localbi.field_msgId == paramLong))
      {
        AppMethodBeat.o(32125);
        return i;
      }
    }
    AppMethodBeat.o(32125);
    return -1;
  }
  
  public static String a(bi parambi, com.tencent.mm.at.e parame)
  {
    AppMethodBeat.i(32120);
    parambi = a(parambi, parame, false);
    AppMethodBeat.o(32120);
    return parambi;
  }
  
  private static String a(bi parambi, com.tencent.mm.at.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(32121);
    if (parambi.field_isSend == 1)
    {
      parambi = o.ahC().d(parame);
      str = o.ahC().q(parambi, "", "");
      ab.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() pre fileName:%s bigImgPath:%s", new Object[] { parambi, str });
      if (com.tencent.mm.vfs.e.cN(str))
      {
        AppMethodBeat.o(32121);
        return str;
      }
      parambi = parame.fDM;
      parame = o.ahC().q(parambi, "", "");
      ab.d("MicroMsg.ImageGalleryHolderImage", "getImgPath() after fileName:%s bigImgPath:%s", new Object[] { parambi, parame });
      if (com.tencent.mm.vfs.e.cN(parame))
      {
        AppMethodBeat.o(32121);
        return parame;
      }
      AppMethodBeat.o(32121);
      return null;
    }
    if ((!paramBoolean) && (!parame.ahg()))
    {
      ab.w("MicroMsg.ImageGalleryHolderImage", "getImagePath is null because of isTryToGetProgress %s img.isGetCompleted() %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(parame.ahg()) });
      AppMethodBeat.o(32121);
      return null;
    }
    String str = parame.fDM;
    if (parame.ahh())
    {
      parambi = o.ahC().d(parame);
      if (parambi != null)
      {
        parambi = o.ahC().q(parambi, "", "");
        if (com.tencent.mm.vfs.e.cN(parambi)) {
          ab.i("MicroMsg.ImageGalleryHolderImage", "hasHdImg");
        }
      }
    }
    for (;;)
    {
      parame = parambi;
      if (parambi == null) {
        parame = o.ahC().q(str, "", "");
      }
      ab.i("MicroMsg.ImageGalleryHolderImage", "the path : %s", new Object[] { parame });
      AppMethodBeat.o(32121);
      return parame;
      parambi = null;
    }
  }
  
  private static void a(bi parambi, k paramk, int paramInt)
  {
    AppMethodBeat.i(32104);
    ab.i("MicroMsg.ImageGalleryHolderImage", "edw dealFail", new Object[0]);
    String str = o.ahC().J(parambi.field_imgPath, true);
    k.aq(paramk.zNB, 8);
    k.aq(paramk.zNw, 8);
    k.aq(paramk.zNF, 8);
    k.aq(paramk.zNG, 8);
    k.aq(paramk.zNH, 8);
    paramk.dKN().zNC.setVisibility(0);
    paramk.dKN().zNE.setImageResource(2131231546);
    if ((str == null) || (!com.tencent.mm.vfs.e.cN(str)))
    {
      paramk.dKN().zND.setText(2131300728);
      AppMethodBeat.o(32104);
      return;
    }
    if (paramInt == 6)
    {
      paramk.dKN().zND.setText(2131300726);
      AppMethodBeat.o(32104);
      return;
    }
    if (parambi.dyc())
    {
      paramk.dKN().zND.setText(2131300724);
      AppMethodBeat.o(32104);
      return;
    }
    paramk.dKN().zND.setText(2131300725);
    AppMethodBeat.o(32104);
  }
  
  private static void a(bi parambi, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(32126);
    ab.i("MicroMsg.ImageGalleryHolderImage", "[oreh download_and_save] hdImg end, msgLocalId:%d, %s", new Object[] { Long.valueOf(parambi.field_msgId), paramString });
    c.b(ah.getContext(), parambi, paramBoolean);
    AppMethodBeat.o(32126);
  }
  
  private void a(k paramk, bi parambi, com.tencent.mm.at.e parame, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(32102);
    a(paramk, parambi, parame, paramBoolean, true, paramInt);
    AppMethodBeat.o(32102);
  }
  
  private void a(k paramk, bi parambi, com.tencent.mm.at.e parame, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(32103);
    ab.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloading, isHd = ".concat(String.valueOf(paramBoolean1)));
    k.aq(paramk.zNC, 8);
    String str1 = null;
    if (!paramBoolean1) {
      paramk.zNF.setVisibility(0);
    }
    com.tencent.mm.at.e locale = com.tencent.mm.at.f.a(parame);
    if ((paramBoolean1) && (paramInt == this.zJI.zJK.getCurrentItem())) {
      this.zJI.zJK.dKD();
    }
    if (paramBoolean1) {
      str1 = a(parambi, parame, true);
    }
    String str2 = str1;
    if (bo.isNullOrNil(str1)) {
      str2 = o.ahC().q(locale.fDO, "", "");
    }
    str1 = o.ahC().J(parambi.field_imgPath, true);
    if (paramBoolean2) {
      a(paramk, str1, str2, parambi);
    }
    long l;
    if (!paramBoolean1)
    {
      paramInt = parame.fsd;
      int i = parame.offset;
      if (paramInt == 0) {
        break label258;
      }
      l = i * 100L / paramInt - 1L;
      if (Math.max(1, (int)l) <= 50) {
        break label264;
      }
      paramk.dKM().zNB.setVisibility(8);
    }
    for (;;)
    {
      paramk.dKM().zNz.setVisibility(8);
      paramk.dKM().zNy.setVisibility(8);
      paramk.dKM().zNx.setVisibility(8);
      AppMethodBeat.o(32103);
      return;
      label258:
      l = 0L;
      break;
      label264:
      paramk.dKM().zNB.setVisibility(0);
    }
  }
  
  private static void a(k paramk, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 8;
    AppMethodBeat.i(32111);
    Object localObject;
    int i;
    if (paramk != null) {
      if (paramk.zNG != null)
      {
        localObject = paramk.zNG;
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
    for (paramk.zNI = true;; paramk.zNI = false)
    {
      if (paramk.zNF != null)
      {
        localObject = paramk.zNF;
        i = j;
        if (paramBoolean2) {
          i = 0;
        }
        ((MultiTouchImageView)localObject).setVisibility(i);
        if (paramBoolean2) {
          paramk.zNI = false;
        }
      }
      AppMethodBeat.o(32111);
      return;
      i = 8;
      break;
    }
  }
  
  private boolean a(MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, int paramInt, bi parambi, k paramk)
  {
    AppMethodBeat.i(32109);
    boolean bool = a(true, paramMultiTouchImageView, paramString1, paramString2, false, paramInt, parambi, paramk, null, false);
    AppMethodBeat.o(32109);
    return bool;
  }
  
  private boolean a(k paramk, bi parambi, com.tencent.mm.at.e parame, int paramInt)
  {
    AppMethodBeat.i(32101);
    ab.i("MicroMsg.ImageGalleryHolderImage", "edw dealSucc");
    String str2 = d(parambi, parame);
    k.aq(paramk.zNB, 8);
    String str1 = (String)this.zLd.get(parambi);
    parame = str1;
    if (str1 == null)
    {
      parame = o.ahC().J(parambi.field_imgPath, true);
      this.zLd.put(parambi, parame);
    }
    boolean bool = a(paramk, parame, str2, parambi);
    if ((paramInt == this.zJI.zJK.getCurrentItem()) && (this.zJI.zJO))
    {
      this.zJI.bx(parambi);
      this.zJI.zJO = false;
    }
    AppMethodBeat.o(32101);
    return bool;
  }
  
  private boolean a(k paramk, String paramString1, String paramString2, bi parambi)
  {
    AppMethodBeat.i(32105);
    boolean bool = b(paramk, paramString1, paramString2, parambi);
    AppMethodBeat.o(32105);
    return bool;
  }
  
  private boolean a(boolean paramBoolean1, MultiTouchImageView paramMultiTouchImageView, String paramString1, String paramString2, boolean paramBoolean2, int paramInt, bi parambi, k paramk, com.tencent.mm.at.e parame, boolean paramBoolean3)
  {
    AppMethodBeat.i(32110);
    ab.i("MicroMsg.ImageGalleryHolderImage", "initImageView image : %s bigImgPath %s position : %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), paramString2, Integer.valueOf(paramInt) });
    Object localObject2 = null;
    boolean bool1 = true;
    if ((paramString2 != null) && (com.tencent.mm.vfs.e.cN(paramString2)))
    {
      localObject2 = paramString2;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramString1 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.vfs.e.cN(paramString1)) {
            if (!com.tencent.mm.vfs.e.cN(paramString1 + "hd")) {
              break label765;
            }
          }
        }
      }
    }
    label270:
    label375:
    label765:
    for (Object localObject1 = paramString1 + "hd";; localObject1 = paramString1)
    {
      if (localObject1 == null)
      {
        ab.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, file does not exist, filePath %s", new Object[] { paramString2 });
        AppMethodBeat.o(32110);
        return false;
        bool1 = false;
        break;
      }
      if (paramk == null)
      {
        ab.e("MicroMsg.ImageGalleryHolderImage", "alvinluo initImageView holder is null");
        AppMethodBeat.o(32110);
        return false;
      }
      int i;
      if ((!((String)localObject1).equals(paramString1)) && (!paramBoolean3) && (aue((String)localObject1)))
      {
        paramBoolean3 = true;
        ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt result: %b, path: %s", new Object[] { Boolean.valueOf(paramBoolean3), localObject1 });
        if ((paramk.zNG == null) || (paramk.zNG.getVisibility() != 0)) {
          break label375;
        }
        i = 1;
        if ((!paramBoolean3) || (i != 0)) {
          break label381;
        }
      }
      label381:
      for (boolean bool2 = true;; bool2 = false)
      {
        if ((paramBoolean3) || (paramBoolean2) || (!this.zLb.nfR.Z(localObject1))) {
          break label387;
        }
        localObject2 = (Bitmap)this.zLb.nfR.Y(localObject1);
        if (((Bitmap)localObject2).isRecycled()) {
          break label387;
        }
        ab.i("MicroMsg.ImageGalleryHolderImage", "use cache, fillBitmap path : %s", new Object[] { localObject1 });
        b(paramMultiTouchImageView, (Bitmap)localObject2);
        AppMethodBeat.o(32110);
        return true;
        paramBoolean3 = false;
        break;
        i = 0;
        break label270;
      }
      if (paramBoolean1) {
        paramMultiTouchImageView.setImageBitmap(null);
      }
      localObject2 = parame;
      if (paramBoolean3)
      {
        if (paramk.zNG == null)
        {
          AppMethodBeat.o(32110);
          return false;
        }
        localObject2 = parame;
        if (parame == null) {
          localObject2 = f(parambi, true);
        }
        paramk.zNG.setOnImageLoadEventListener(new e.1(this, (String)localObject1, paramInt, paramk, parambi));
      }
      if (!this.zJI.zJU)
      {
        if (paramInt >= 0)
        {
          ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo loadThumb postion: %d", new Object[] { Integer.valueOf(paramInt) });
          a(paramk, false, true);
          this.zLb.c(paramMultiTouchImageView, paramInt);
        }
        if (!paramBoolean3) {
          break label725;
        }
        a(paramk, true, bool2);
        paramMultiTouchImageView = e(parambi, (com.tencent.mm.at.e)localObject2);
        paramString1 = this.zLb;
        paramString2 = paramk.zNG;
        i = paramInt;
        if (paramInt < 0) {
          i = paramk.mPosition;
        }
        paramString1.b(paramString2, (String)localObject1, paramMultiTouchImageView, i);
      }
      for (;;)
      {
        AppMethodBeat.o(32110);
        return bool1;
        if (paramBoolean3)
        {
          paramMultiTouchImageView = e(parambi, (com.tencent.mm.at.e)localObject2);
          a(paramk, true, bool2);
          paramString1 = paramk.zNG;
          if (paramMultiTouchImageView != null) {}
          for (paramMultiTouchImageView = com.davemorrissey.labs.subscaleview.view.a.Y(paramMultiTouchImageView);; paramMultiTouchImageView = null)
          {
            a(paramString1, (String)localObject1, paramMultiTouchImageView);
            AppMethodBeat.o(32110);
            return bool1;
          }
        }
        Bitmap localBitmap = auf((String)localObject1);
        parame = localBitmap;
        if (localBitmap == null) {
          parame = auf(paramString1);
        }
        if (parame == null) {
          break;
        }
        a(paramk, false, true);
        b(paramMultiTouchImageView, parame);
        if (((String)localObject1).equals(paramString2))
        {
          this.zLb.u((String)localObject1, parame);
          this.zLb.c(paramInt, parame);
        }
        AppMethodBeat.o(32110);
        return bool1;
        a(paramk, false, true);
        paramString1 = this.zLb;
        i = paramInt;
        if (paramInt < 0) {
          i = paramk.mPosition;
        }
        paramString1.g(paramMultiTouchImageView, (String)localObject1, i);
      }
    }
  }
  
  private static Bitmap aH(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(32115);
    String str = paramString + "_tmp.jpg";
    try
    {
      bool1 = com.tencent.mm.compatible.util.d.fw(16);
      if (bool1)
      {
        AppMethodBeat.o(32115);
        return null;
      }
      bool1 = com.tencent.mm.sdk.a.b.dsf();
      if (!bool1) {
        try
        {
          i = bo.getInt(com.tencent.mm.m.g.Nq().getValue("UseOptImageRecv"), 0);
          aw.aaz();
          p localp = new p(com.tencent.mm.model.c.getUin());
          ab.i("MicroMsg.ImageGalleryHolderImage", "fromPathToImgInfo opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Integer.valueOf(i), Long.valueOf(localp.longValue()), Long.valueOf(localp.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.dsf()), Integer.valueOf(Build.VERSION.SDK_INT) });
          j = (int)(localp.longValue() / 100L);
          if (j % 100 + 1 > i)
          {
            AppMethodBeat.o(32115);
            return null;
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.ImageGalleryHolderImage", "get useopt :%s", new Object[] { bo.l(localException) });
          AppMethodBeat.o(32115);
          return null;
        }
      }
      com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(str));
      com.tencent.mm.vfs.e.C(paramString, str);
      bool2 = MMNativeJpeg.IsJpegFile(str);
      bool3 = MMNativeJpeg.isProgressive(str);
      if (bo.isNullOrNil(str)) {
        break label477;
      }
      if (new File(str).exists()) {
        break label406;
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
        label406:
        Bitmap localBitmap2 = null;
        ab.e("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt failed. file:%s e:%s", new Object[] { paramString, bo.l(localThrowable1) });
        localObject1 = localBitmap2;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = null;
        continue;
        boolean bool1 = false;
      }
    }
    j = (int)com.tencent.mm.vfs.e.avI(str);
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
            e.a.q(paramString, paramInt2, paramInt1, i);
            localBitmap2 = localBitmap1;
            ab.i("MicroMsg.ImageGalleryHolderImage", "dkprog tryUseImageOpt jpeg:%b isprog:%b inte:%b len:%d [%d,%d] bm:%s path:%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Integer.valueOf(j), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), localBitmap1, paramString });
            com.tencent.mm.vfs.e.deleteFile(str);
            AppMethodBeat.o(32115);
            return localBitmap1;
          }
          catch (Throwable localThrowable2)
          {
            Object localObject1;
            break label429;
          }
          bool1 = MMJpegOptim.checkIntegrity(str);
          break;
        }
      }
    }
  }
  
  protected static BitmapFactory.Options aud(String paramString)
  {
    AppMethodBeat.i(32107);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    paramString = BitmapFactory.decodeFile(paramString, localOptions);
    if (paramString != null) {
      paramString.recycle();
    }
    AppMethodBeat.o(32107);
    return localOptions;
  }
  
  private boolean aue(String paramString)
  {
    AppMethodBeat.i(32108);
    if (!zLe)
    {
      ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not enable BigImageOpt");
      AppMethodBeat.o(32108);
      return false;
    }
    if (Build.VERSION.SDK_INT == 27)
    {
      localObject = ad.get("ro.mediatek.platform");
      if ((localObject != null) && ((((String)localObject).startsWith("mt6765")) || (((String)localObject).startsWith("MT6765")))) {
        i = 0;
      }
    }
    while (i != 0)
    {
      AppMethodBeat.o(32108);
      return false;
      if (com.tencent.mm.compatible.util.m.Ms())
      {
        ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt is MTK platform");
        if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25) || (Build.VERSION.SDK_INT == 27))
        {
          ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt is MTK platform, android api: %d, cannot use BigImgOpt", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
          i = Build.VERSION.SDK_INT;
          ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo reportMTKPlatform apiLevel: %d", new Object[] { Integer.valueOf(i) });
          if (i == 24) {
            com.tencent.mm.plugin.report.service.h.qsU.j(896L, 0L, 1L);
          }
          for (;;)
          {
            i = 1;
            break;
            if (i == 25) {
              com.tencent.mm.plugin.report.service.h.qsU.j(896L, 1L, 1L);
            }
          }
        }
      }
      i = 0;
    }
    paramString = aud(paramString);
    int j = paramString.outWidth;
    int k = paramString.outHeight;
    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImgOpt ignore abTestFlag, widthFactor: %f, heightFactor: %f, width: %d, height: %d", new Object[] { Float.valueOf(1.0F), Float.valueOf(1.0F), Integer.valueOf(j), Integer.valueOf(k) });
    Object localObject = this.zLf;
    int i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lRX, 0);
    if (i == 1) {
      com.tencent.luggage.g.d.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter clicfg notFilter: %d", new Object[] { Integer.valueOf(i) });
    }
    label323:
    label461:
    label468:
    for (;;)
    {
      i = 0;
      if (i == 0) {
        break;
      }
      ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt filter image");
      AppMethodBeat.o(32108);
      return false;
      if (((j >= 5700) && (k >= 8000)) || ((j >= 8000) && (k >= 5700)))
      {
        i = 1;
        label375:
        if (i == 0) {
          break label461;
        }
        paramString = Build.MODEL;
        if (bo.isNullOrNil(paramString)) {
          continue;
        }
        localObject = ((b)localObject).zJJ;
        m = localObject.length;
        i = 0;
      }
      for (;;)
      {
        if (i >= m) {
          break label468;
        }
        if (paramString.equalsIgnoreCase(localObject[i]))
        {
          com.tencent.luggage.g.d.i("MicroMsg.BigImageFilter", "alvinluo BigImageFilter filter model: %s, width: %d, height: %d", new Object[] { paramString, Integer.valueOf(j), Integer.valueOf(k) });
          i = 1;
          break label323;
          i = 0;
          break label375;
          break;
        }
        i += 1;
      }
    }
    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt not filter");
    i = getScreenWidth(ah.getContext());
    int m = getScreenHeight(ah.getContext());
    ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo checkUseBigImageOpt width: %d, height: %d, screenWidth: %d, screenHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m) });
    if (j >= i * 1.0F)
    {
      AppMethodBeat.o(32108);
      return true;
    }
    if (k >= m * 1.0F)
    {
      AppMethodBeat.o(32108);
      return true;
    }
    AppMethodBeat.o(32108);
    return false;
  }
  
  private static Bitmap auf(String paramString)
  {
    AppMethodBeat.i(32116);
    if (paramString == null)
    {
      AppMethodBeat.o(32116);
      return null;
    }
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    Object localObject2 = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject1);
    if (localObject2 != null)
    {
      ab.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localObject2.toString() });
      ((Bitmap)localObject2).recycle();
    }
    int i2 = BackwardSupportUtil.ExifHelper.bY(paramString);
    int m = ((BitmapFactory.Options)localObject1).outWidth;
    int k = ((BitmapFactory.Options)localObject1).outHeight;
    int n = k;
    int i1 = m;
    for (;;)
    {
      try
      {
        long l1 = Math.max(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() - zLg, 0L);
        n = k;
        i1 = m;
        int i = ((BitmapFactory.Options)localObject1).outHeight;
        n = k;
        i1 = m;
        long l2 = ((BitmapFactory.Options)localObject1).outWidth * i * 4;
        n = k;
        i1 = m;
        ab.i("MicroMsg.ImageGalleryHolderImage", "hy: current free memory: %d, previewDecodedBmLength: %d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
        int j = k;
        i = m;
        if (l1 < l2)
        {
          n = k;
          i1 = m;
          double d = Math.sqrt(l1 / l2);
          n = k;
          i1 = m;
          ab.v("MicroMsg.ImageGalleryHolderImage", "hy: sample is %f", new Object[] { Double.valueOf(d) });
          i = (int)(m * d);
          j = (int)(k * d);
        }
        n = j;
        i1 = i;
        localObject2 = aH(paramString, j, i);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          n = j;
          i1 = i;
          localObject1 = com.tencent.mm.sdk.platformtools.d.a(paramString, i, j, 0.0F);
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
              ab.i("MicroMsg.ImageGalleryHolderImage", "Progressive jpeg, result isNull:%b", new Object[] { Boolean.valueOf(bool) });
            }
          }
        }
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        boolean bool;
        ab.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", localOutOfMemoryError, "hy: out of memory! try use fallback bitmap", new Object[0]);
        Bitmap localBitmap = e(paramString, i1, n, getScreenWidth(ah.getContext()), getScreenHeight(ah.getContext()));
        continue;
        paramString = com.tencent.mm.sdk.platformtools.d.b(localBitmap, i2);
        if ((paramString != localBitmap) || (i2 % 360 == 0)) {
          continue;
        }
        ab.e("MicroMsg.ImageGalleryHolderImage", "rotate failed degree:%d", new Object[] { Integer.valueOf(i2) });
        AppMethodBeat.o(32116);
        return null;
        AppMethodBeat.o(32116);
      }
      if (localObject1 != null) {
        continue;
      }
      ab.e("MicroMsg.ImageGalleryHolderImage", "getSuitableBmp fail, temBmp is null, filePath = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(32116);
      return null;
      bool = false;
    }
    return paramString;
  }
  
  @TargetApi(11)
  private void b(MultiTouchImageView paramMultiTouchImageView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(32130);
    if ((this.zJI == null) || (this.zJI.zJK == null))
    {
      AppMethodBeat.o(32130);
      return;
    }
    ab.i("MicroMsg.ImageGalleryHolderImage", "fillBitmap image : %s bmp %s", new Object[] { Integer.valueOf(paramMultiTouchImageView.hashCode()), Integer.valueOf(paramBitmap.hashCode()) });
    if (Build.VERSION.SDK_INT == 20) {
      paramMultiTouchImageView.setLayerType(1, null);
    }
    for (;;)
    {
      paramMultiTouchImageView.setEnableHorLongBmpMode(false);
      paramMultiTouchImageView.cb(paramBitmap.getWidth(), paramBitmap.getHeight());
      paramMultiTouchImageView.setImageBitmap(null);
      paramMultiTouchImageView.setImageBitmap(paramBitmap);
      paramMultiTouchImageView.invalidate();
      AppMethodBeat.o(32130);
      return;
      n.x((View)paramMultiTouchImageView.getParent(), paramBitmap.getWidth(), paramBitmap.getHeight());
    }
  }
  
  private boolean b(k paramk, String paramString1, String paramString2, bi parambi)
  {
    AppMethodBeat.i(32106);
    k.aq(paramk.zNF, 0);
    k.aq(paramk.zNw, 8);
    k.aq(paramk.zNB, 8);
    k.aq(paramk.zNC, 8);
    boolean bool = a(paramk.zNF, paramString1, paramString2, paramk.mPosition, parambi, paramk);
    AppMethodBeat.o(32106);
    return bool;
  }
  
  public static com.tencent.mm.at.e d(bi parambi)
  {
    AppMethodBeat.i(32098);
    if (!c.c(parambi))
    {
      AppMethodBeat.o(32098);
      return null;
    }
    long l;
    com.tencent.mm.at.e locale1;
    if (parambi.field_isSend == 1)
    {
      l = parambi.field_msgId;
      com.tencent.mm.at.e locale2 = o.ahC().gT(l);
      locale1 = locale2;
      if (locale2.fDL != 0L) {}
    }
    else
    {
      l = parambi.field_msgSvrId;
      locale1 = o.ahC().gS(l);
    }
    AppMethodBeat.o(32098);
    return locale1;
  }
  
  private String d(bi parambi, com.tencent.mm.at.e parame)
  {
    AppMethodBeat.i(32100);
    String str2 = (String)this.zLc.get(parambi);
    String str1 = str2;
    if (str2 == null)
    {
      str1 = a(parambi, parame, false);
      if ((str1 == null) || (str1.length() == 0))
      {
        AppMethodBeat.o(32100);
        return null;
      }
      this.zLc.put(parambi, str1);
    }
    AppMethodBeat.o(32100);
    return str1;
  }
  
  public static void dKe()
  {
    zLe = false;
  }
  
  private static Bitmap e(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(32117);
    ab.e("MicroMsg.ImageGalleryHolderImage", "hy: enter fallback bitmap logic");
    paramInt1 *= paramInt2;
    paramInt2 = paramInt3 * paramInt4;
    ab.i("MicroMsg.ImageGalleryHolderImage", "hy: oriImgPixelRate %d, displayPixelRate %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 > paramInt2) {}
    try
    {
      paramString = com.tencent.mm.sdk.platformtools.d.a(paramString, paramInt3, paramInt4, 0.0F);
      AppMethodBeat.o(32117);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      ab.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramString, "hy: oom in fallback bitmap!", new Object[0]);
      AppMethodBeat.o(32117);
    }
    ab.e("MicroMsg.ImageGalleryHolderImage", "hy: the picture is even smaller the screen! display nothing");
    AppMethodBeat.o(32117);
    return null;
    return null;
  }
  
  private static String e(bi parambi, com.tencent.mm.at.e parame)
  {
    AppMethodBeat.i(32122);
    if ((parambi == null) || (parame == null))
    {
      AppMethodBeat.o(32122);
      return null;
    }
    if (parambi.field_isSend == 1)
    {
      parambi = parame.fDO;
      parame = o.ahC().q(parambi, "", "") + "hd";
      ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambi, parame });
      if ((!bo.isNullOrNil(parame)) && (com.tencent.mm.vfs.e.cN(parame)))
      {
        ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
        AppMethodBeat.o(32122);
        return parame;
      }
      parame = o.ahC().q(parambi, "", "");
      ab.d("MicroMsg.ImageGalleryHolderImage", "preview fileName: %s, fullPath:%s", new Object[] { parambi, parame });
      if ((!bo.isNullOrNil(parame)) && (com.tencent.mm.vfs.e.cN(parame)))
      {
        ab.d("MicroMsg.ImageGalleryHolderImage", "preview image exist");
        AppMethodBeat.o(32122);
        return parame;
      }
      AppMethodBeat.o(32122);
      return null;
    }
    if (!parame.ahg())
    {
      ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo get previewPath img not completed");
      AppMethodBeat.o(32122);
      return null;
    }
    parambi = parame.fDO;
    parame = o.ahC().q(parambi, "", "") + "hd";
    ab.i("MicroMsg.ImageGalleryHolderImage", "alvinluo preview fileName: %s, fullPath: %s", new Object[] { parambi, parame });
    if ((!bo.isNullOrNil(parame)) && (com.tencent.mm.vfs.e.cN(parame)))
    {
      ab.d("MicroMsg.ImageGalleryHolderImage", "alvinluo preview image exist");
      AppMethodBeat.o(32122);
      return parame;
    }
    AppMethodBeat.o(32122);
    return null;
  }
  
  private static int getScreenHeight(Context paramContext)
  {
    AppMethodBeat.i(32119);
    if (paramContext == null)
    {
      AppMethodBeat.o(32119);
      return 0;
    }
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    AppMethodBeat.o(32119);
    return i;
  }
  
  private static int getScreenWidth(Context paramContext)
  {
    AppMethodBeat.i(32118);
    if (paramContext == null)
    {
      AppMethodBeat.o(32118);
      return 0;
    }
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    AppMethodBeat.o(32118);
    return i;
  }
  
  private void h(bi parambi, int paramInt)
  {
    AppMethodBeat.i(32095);
    this.jWf.put(Long.valueOf(parambi.field_msgId), Integer.valueOf(paramInt));
    AppMethodBeat.o(32095);
  }
  
  private void l(long paramLong, int paramInt)
  {
    AppMethodBeat.i(32096);
    this.jWf.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(32096);
  }
  
  public final Bitmap Qe(int paramInt)
  {
    AppMethodBeat.i(32131);
    if (this.zJI == null)
    {
      AppMethodBeat.o(32131);
      return null;
    }
    bi localbi = this.zJI.zJL.Qb(paramInt);
    if (localbi != null)
    {
      String str = (String)this.zLd.get(localbi);
      Object localObject = str;
      if (str == null)
      {
        localObject = o.ahC().J(localbi.field_imgPath, true);
        this.zLd.put(localbi, localObject);
      }
      str = (String)localObject + "hd";
      if (com.tencent.mm.vfs.e.cN(str))
      {
        localObject = auf(str);
        AppMethodBeat.o(32131);
        return localObject;
      }
      localObject = auf((String)localObject);
      AppMethodBeat.o(32131);
      return localObject;
    }
    AppMethodBeat.o(32131);
    return null;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(32127);
    if (!(paramObject instanceof Integer))
    {
      ab.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
      AppMethodBeat.o(32127);
      return;
    }
    ab.i("MicroMsg.ImageGalleryHolderImage", "image task canceled at pos ".concat(String.valueOf(((Integer)paramObject).intValue())), new Object[0]);
    AppMethodBeat.o(32127);
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(32123);
    if ((this.zJI == null) || (this.zJI.zJK == null))
    {
      AppMethodBeat.o(32123);
      return;
    }
    if (this.mScrollState != 0)
    {
      AppMethodBeat.o(32123);
      return;
    }
    int i;
    if (l.dKQ().oO(paramLong2))
    {
      i = a(paramLong2, paramObject);
      if (i == -1)
      {
        AppMethodBeat.o(32123);
        return;
      }
      paramObject = Integer.valueOf(i);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        ab.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(32123);
        return;
      }
      i = ((Integer)paramObject).intValue();
      ab.i("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos[%d], offset[%d], totalLen[%d], resId[%d], compressType[%d], imgLocalId[%d],", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1) });
      if (i == -1)
      {
        ab.e("MicroMsg.ImageGalleryHolderImage", "onImgTaskProgress, pos is -1");
        AppMethodBeat.o(32123);
        return;
      }
      if (this.zJI.Gm(i) == null)
      {
        AppMethodBeat.o(32123);
        return;
      }
      paramObject = (k)this.zJI.Gm(i).getTag();
      if (paramObject == null)
      {
        AppMethodBeat.o(32123);
        return;
      }
      if ((i == this.zJI.zJK.getCurrentItem()) && (!Qd(paramInt1))) {
        this.zJI.zJK.hX(false);
      }
      if (paramInt3 == 0)
      {
        paramInt2 = 0;
        paramInt2 = Math.max(1, paramInt2);
        if ((i == this.zJI.zJK.getCurrentItem()) && (Qd(paramInt1)))
        {
          ab.i("MicroMsg.ImageGalleryHolderImage", "jacks loading hd from progress : %d, time: %d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis()) });
          this.zJI.zJK.Qk(paramInt2);
        }
        paramm = (com.tencent.mm.at.k)paramm;
        boolean bool1 = MMNativeJpeg.isProgressive(paramm.fFr);
        boolean bool2 = paramm.fFt;
        paramLong1 = bo.av(this.zLh);
        e.a.eS(paramm.fFr, paramInt4);
        ab.i("MicroMsg.ImageGalleryHolderImage", "dkprog onImgTaskProgress getCanShow:%b isProg:%b timeDiff:%d  [%d/%d] %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Long.valueOf(paramLong1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), paramm.fFr });
        if ((!bool2) || (!bool1) || (paramLong1 <= 1000L)) {
          break label713;
        }
        this.zLh = bo.yB();
        paramm = this.zJI.Pz(i);
        if (paramm == null)
        {
          ab.e("MicroMsg.ImageGalleryHolderImage", "msg is null! pos:%s", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(32123);
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
      com.tencent.mm.at.e locale = f(paramm, true);
      if (a(false, paramObject.zNF, o.ahC().J(paramm.field_imgPath, true), a(paramm, locale, true), true, -1, paramm, paramObject, locale, true))
      {
        k.aq(paramObject.zNz, 8);
        k.aq(paramObject.zNC, 8);
        if ((i == this.zJI.zJK.getCurrentItem()) && (!Qd(paramInt1))) {
          if (paramInt2 > 50)
          {
            k.aq(paramObject.zNB, 8);
            if (this.zJI != null)
            {
              this.zJI.a(paramm, locale, paramInt1, com.tencent.mm.g.b.a.e.a.cPO);
              AppMethodBeat.o(32123);
            }
          }
          else
          {
            k.aq(paramObject.zNB, 0);
          }
        }
      }
      label713:
      AppMethodBeat.o(32123);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(32124);
    if ((this.zJI == null) || (this.zJI.zJK == null))
    {
      AppMethodBeat.o(32124);
      return;
    }
    if (l.dKQ().oO(paramLong2))
    {
      paramInt2 = a(paramLong2, paramObject);
      if (paramInt2 == -1)
      {
        aw.aaz();
        a(com.tencent.mm.model.c.YC().kB(paramLong2), "background", false);
        AppMethodBeat.o(32124);
        return;
      }
      paramObject = Integer.valueOf(paramInt2);
    }
    for (;;)
    {
      if (!(paramObject instanceof Integer))
      {
        ab.e("MicroMsg.ImageGalleryHolderImage", "param data not integer instance");
        AppMethodBeat.o(32124);
        return;
      }
      paramInt2 = ((Integer)paramObject).intValue();
      ab.i("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos = ".concat(String.valueOf(paramInt2)));
      if (paramInt2 == -1)
      {
        ab.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, pos is -1");
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 3L, 1L, true);
        AppMethodBeat.o(32124);
        return;
      }
      paramObject = null;
      if (this.zJI.Gm(paramInt2) != null) {
        paramObject = (k)this.zJI.Gm(paramInt2).getTag();
      }
      boolean bool = l.dKQ().oO(paramLong2);
      if ((paramInt3 != 0) || (paramInt4 != 0))
      {
        if (bool)
        {
          paramObject = this.zJI.Pz(paramInt2);
          paramString = "hd_failed:".concat(String.valueOf(paramInt2));
          if (paramInt2 == this.zJI.zJK.getCurrentItem())
          {
            bool = true;
            a(paramObject, paramString, bool);
          }
        }
        else
        {
          if (paramInt2 == this.zJI.zJK.getCurrentItem()) {
            this.zJI.zJK.hX(true);
          }
          if (paramInt4 != -5103059) {
            break label420;
          }
          l(paramLong2, 5);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 0L, 1L, true);
        }
        for (;;)
        {
          ab.e("MicroMsg.ImageGalleryHolderImage", "onSceneEnd, errType = " + paramInt3 + ", errCode = " + paramInt4);
          this.zJI.zJP.PQ(paramInt2);
          if (this.zJI != null) {
            this.zJI.a(this.zJI.Pz(paramInt2), null, paramInt1, com.tencent.mm.g.b.a.e.a.cPQ);
          }
          AppMethodBeat.o(32124);
          return;
          bool = false;
          break;
          label420:
          l(paramLong2, 6);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 1L, 1L, true);
        }
      }
      if (bool)
      {
        paramString = this.zJI.Pz(paramInt2);
        paramm = "hd_suc:".concat(String.valueOf(paramInt2));
        if (paramInt2 != this.zJI.zJK.getCurrentItem()) {
          break label587;
        }
      }
      label587:
      for (bool = true;; bool = false)
      {
        a(paramString, paramm, bool);
        ab.i("MicroMsg.ImageGalleryHolderImage", "pos = " + paramInt2 + ", selectedPos = " + this.zJI.zJK.getCurrentItem(), new Object[0]);
        l(paramLong2, 4);
        paramString = this.zJI.Pz(paramInt2);
        paramm = f(paramString, true);
        if ((paramString != null) && (paramm != null)) {
          break;
        }
        AppMethodBeat.o(32124);
        return;
      }
      if (paramObject != null)
      {
        this.zJI.zJK.hX(true);
        if (paramInt2 == this.zJI.zJK.getCurrentItem())
        {
          if (!Qd(paramInt1)) {
            break label882;
          }
          ImageGalleryUI localImageGalleryUI = this.zJI.zJK;
          localImageGalleryUI.hX(true);
          localImageGalleryUI.hX(true);
          Animation localAnimation = ImageGalleryUI.Qj(1000);
          localAnimation.setAnimationListener(new ImageGalleryUI.19(localImageGalleryUI));
          localImageGalleryUI.dKu();
          localImageGalleryUI.dKh().zLR.setVisibility(0);
          localImageGalleryUI.dKh().zLS.setVisibility(8);
          localImageGalleryUI.dKh().zLT.setVisibility(8);
          localImageGalleryUI.dKh().zLU.setVisibility(0);
          localImageGalleryUI.dKh().zLU.startAnimation(localAnimation);
        }
        while (a(false, paramObject.zNF, o.ahC().J(paramString.field_imgPath, true), a(paramString, paramm, true), true, -1, paramString, paramObject, paramm, false))
        {
          k.aq(paramObject.zNw, 8);
          k.aq(paramObject.zNB, 8);
          k.aq(paramObject.zNC, 8);
          if ((bB(paramString) == 4) && (this.zJI.zJO))
          {
            this.zJI.bx(paramString);
            this.zJI.zJO = false;
          }
          if (this.zJI == null) {
            break label926;
          }
          this.zJI.a(paramString, paramm, paramInt1, com.tencent.mm.g.b.a.e.a.cPO);
          AppMethodBeat.o(32124);
          return;
          label882:
          paramObject.zNF.post(new e.2(this, paramInt2));
        }
        ab.e("MicroMsg.ImageGalleryHolderImage", "failed to show downloaded image!");
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 2L, 1L, true);
      }
      label926:
      AppMethodBeat.o(32124);
      return;
    }
  }
  
  public final void a(WxImageView paramWxImageView, String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(32114);
    BitmapFactory.Options localOptions = aud(paramString);
    paramWxImageView.setOrientation(BackwardSupportUtil.ExifHelper.bY(paramString));
    paramWxImageView.cb(localOptions.outWidth, localOptions.outHeight);
    paramWxImageView.dDJ();
    paramWxImageView.a(paramString, parama);
    AppMethodBeat.o(32114);
  }
  
  public final boolean a(k paramk, bi parambi, int paramInt)
  {
    AppMethodBeat.i(32097);
    super.a(paramk, parambi, paramInt);
    if ((paramk == null) || (parambi == null) || (paramInt < 0))
    {
      AppMethodBeat.o(32097);
      return false;
    }
    i = bB(parambi);
    ab.i("MicroMsg.ImageGalleryHolderImage", "filling image : %s position : %s currentState : %s", new Object[] { Integer.valueOf(paramk.zNF.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(i) });
    k.aq(paramk.zNw, 8);
    try
    {
      locale = f(parambi, false);
      if (locale != null) {
        break label115;
      }
      bool1 = false;
    }
    catch (NullPointerException paramk)
    {
      for (;;)
      {
        com.tencent.mm.at.e locale;
        ab.printErrStackTrace("MicroMsg.ImageGalleryHolderImage", paramk, "", new Object[0]);
        boolean bool1 = false;
        continue;
        if (parambi.dyc())
        {
          bool1 = true;
        }
        else
        {
          Object localObject = d(parambi, locale);
          if ((!locale.ahg()) || ((localObject != null) && (com.tencent.mm.vfs.e.cN((String)localObject))))
          {
            if (System.currentTimeMillis() - parambi.field_createTime <= 259200000L) {
              break label960;
            }
            if (!bo.isNullOrNil((String)localObject))
            {
              if (com.tencent.mm.vfs.e.cN((String)localObject)) {
                break label960;
              }
              break label946;
              if (a(paramk, parambi, locale, paramInt))
              {
                bool1 = false;
                boolean bool2 = false;
                localObject = o.ahC().w(parambi);
                ab.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc temp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.at.e)localObject).fDL), Long.valueOf(((com.tencent.mm.at.e)localObject).fDU), Long.valueOf(((com.tencent.mm.at.e)localObject).cFn), Integer.valueOf(((com.tencent.mm.at.e)localObject).fDW), Integer.valueOf(((com.tencent.mm.at.e)localObject).fsd) });
                if (localObject != null) {
                  if (!bo.hl(((com.tencent.mm.at.e)localObject).fDW, 0))
                  {
                    localObject = o.ahC().lv(((com.tencent.mm.at.e)localObject).fDW);
                    ab.d("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc hdTemp, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d, totalLen:%s", new Object[] { Long.valueOf(((com.tencent.mm.at.e)localObject).fDL), Long.valueOf(((com.tencent.mm.at.e)localObject).fDU), Long.valueOf(((com.tencent.mm.at.e)localObject).cFn), Integer.valueOf(((com.tencent.mm.at.e)localObject).fDW), Integer.valueOf(((com.tencent.mm.at.e)localObject).fsd) });
                    i = ((com.tencent.mm.at.e)localObject).fsd;
                    int j = (int)com.tencent.mm.vfs.e.avI(o.ahC().q(locale.fDM, "", ""));
                    bool1 = bool2;
                    if (parambi.field_isSend == 1)
                    {
                      bool1 = bool2;
                      if (bo.hl(i, j)) {
                        bool1 = true;
                      }
                    }
                    ab.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() sizeInDb:%s oriSize:%s noNeedDownLoad:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
                  }
                }
                for (;;)
                {
                  if ((!bool1) && (!locale.ahg())) {
                    break label642;
                  }
                  h(parambi, 4);
                  break;
                  i = ((com.tencent.mm.at.e)localObject).fsd;
                  break label513;
                  ab.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc() temp == null");
                }
                h(parambi, 1);
              }
              for (;;)
              {
                aa.C(parambi);
                i = o.ahD().a(locale.fDL, parambi.field_msgId, 0, Integer.valueOf(paramInt), 2130838228, this, 0, true);
                if (this.zJI != null) {
                  this.zJI.g(parambi, false);
                }
                ab.i("MicroMsg.ImageGalleryHolderImage", "put image download task downloadCode [%d].", new Object[] { Integer.valueOf(i) });
                if (i != -2) {
                  break label871;
                }
                ab.w("MicroMsg.ImageGalleryHolderImage", "it is already download image finish, but imgInfo is old, search db and repair.");
                locale = f(parambi, true);
                if (locale != null) {
                  break label772;
                }
                ab.w("MicroMsg.ImageGalleryHolderImage", "get imgInfo by db but it is null.");
                break;
                ab.i("MicroMsg.ImageGalleryHolderImage", "dealDownloadOrSucc dealSucc() == false");
                h(parambi, 2);
              }
              if (a(paramk, parambi, locale, paramInt))
              {
                if ((parambi.field_isSend == 1) || (locale.ahg()))
                {
                  h(parambi, 4);
                  continue;
                }
                h(parambi, 1);
              }
              for (;;)
              {
                ab.w("MicroMsg.ImageGalleryHolderImage", "it repair fail show thumb image.ImgInfo[%d, %b]", new Object[] { Long.valueOf(locale.fDL), Boolean.valueOf(locale.ahg()) });
                a(paramk, parambi, locale, false, paramInt);
                break;
                h(parambi, 2);
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
              paramk.ngZ.invalidate();
            }
          }
          else
          {
            bool1 = true;
            continue;
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label966;
            }
            bool1 = true;
            break;
          }
          bool1 = false;
        }
      }
    }
    AppMethodBeat.o(32097);
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
        ab.i("MicroMsg.ImageGalleryHolderImage", "edw dealDownloadOrSucc");
        ab.i("MicroMsg.ImageGalleryHolderImage", "deal LoadFail");
        if (parambi.field_isSend != 1) {
          break label235;
        }
        bool1 = parambi.dyc();
        if (!bool1) {
          break label315;
        }
        h(parambi, 5);
        a(parambi, paramk, 5);
      }
    }
  }
  
  public final void aI(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(32128);
    ab.i("MicroMsg.ImageGalleryHolderImage", "viewHdImg, pos = ".concat(String.valueOf(paramInt)));
    Object localObject1 = this.zJI.Pz(paramInt);
    if ((localObject1 == null) || (((dd)localObject1).field_msgId == 0L))
    {
      ab.e("MicroMsg.ImageGalleryHolderImage", "msg is null");
      AppMethodBeat.o(32128);
      return;
    }
    if (!c.c((bi)localObject1))
    {
      ab.e("MicroMsg.ImageGalleryHolderImage", "not img can't download hd");
      AppMethodBeat.o(32128);
      return;
    }
    com.tencent.mm.at.e locale = f((bi)localObject1, true);
    Object localObject2;
    if ((locale == null) || (locale.fDL == 0L))
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
      for (localObject1 = "null";; localObject1 = Long.valueOf(locale.fDL))
      {
        ab.e("MicroMsg.ImageGalleryHolderImage", localObject1);
        AppMethodBeat.o(32128);
        return;
        localObject1 = Long.valueOf(((dd)localObject1).field_msgId);
        break;
      }
    }
    h((bi)localObject1, 3);
    if (PP(paramInt) != null) {
      a(PP(paramInt), (bi)localObject1, locale, true, false, paramInt);
    }
    if (this.zJI != null) {
      this.zJI.g((bi)localObject1, true);
    }
    if (paramBoolean)
    {
      localObject2 = l.dKQ();
      ab.i("MicroMsg.ImageHDDownloadAndSaveMgr", "[oreh download_and_save] startScene, msgLoacalID:%d", new Object[] { Long.valueOf(((dd)localObject1).field_msgId) });
      ((l)localObject2).zNQ.add(Long.valueOf(((dd)localObject1).field_msgId));
      o.ahD().a(locale.fDL, ((dd)localObject1).field_msgId, Integer.valueOf(paramInt), (d.a)localObject2);
      AppMethodBeat.o(32128);
      return;
    }
    o.ahD().a(locale.fDL, ((dd)localObject1).field_msgId, Integer.valueOf(paramInt), this);
    AppMethodBeat.o(32128);
  }
  
  public final void b(View paramView, Bitmap paramBitmap)
  {
    AppMethodBeat.i(32112);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(32112);
      return;
    }
    if (paramView != null)
    {
      int i = paramView.hashCode();
      int j = paramBitmap.hashCode();
      int k = this.zLb.nfS.indexOfValue(i);
      if (k >= 0) {
        this.zLb.nfS.removeAt(k);
      }
      this.zLb.nfS.put(j, i);
      if ((paramView instanceof MultiTouchImageView))
      {
        b((MultiTouchImageView)paramView, paramBitmap);
        AppMethodBeat.o(32112);
        return;
      }
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageBitmap(paramBitmap);
      }
    }
    AppMethodBeat.o(32112);
  }
  
  public final int bB(bi parambi)
  {
    AppMethodBeat.i(32094);
    if ((parambi != null) && (this.jWf.containsKey(Long.valueOf(parambi.field_msgId))))
    {
      int i = ((Integer)this.jWf.get(Long.valueOf(parambi.field_msgId))).intValue();
      AppMethodBeat.o(32094);
      return i;
    }
    AppMethodBeat.o(32094);
    return 0;
  }
  
  public final void bC(bi parambi)
  {
    AppMethodBeat.i(32129);
    com.tencent.mm.at.e locale = d(parambi);
    if ((locale == null) || (parambi == null))
    {
      AppMethodBeat.o(32129);
      return;
    }
    if (this.zJI != null) {
      this.zJI.a(parambi, null, 1, com.tencent.mm.g.b.a.e.a.cPP);
    }
    if (l.dKQ().oO(parambi.field_msgId))
    {
      l locall = l.dKQ();
      locall.zNQ.remove(Long.valueOf(parambi.field_msgId));
      o.ahD().a(locale.fDL, parambi.field_msgId, locall);
      o.ahD().z(locale.fDL, parambi.field_msgId);
      AppMethodBeat.o(32129);
      return;
    }
    o.ahD().a(locale.fDL, parambi.field_msgId, this);
    o.ahD().z(locale.fDL, parambi.field_msgId);
    AppMethodBeat.o(32129);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(32093);
    super.detach();
    com.tencent.mm.sdk.b.a.ymk.d(this.zLa);
    if (this.vbm != null)
    {
      localObject = this.vbm.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Bitmap localBitmap = (Bitmap)((WeakReference)this.vbm.get(((Iterator)localObject).next())).get();
        if ((localBitmap != null) && (!localBitmap.isRecycled()))
        {
          ab.i("MicroMsg.ImageGalleryHolderImage", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
      }
    }
    Object localObject = this.zLb;
    ((f)localObject).zLp = null;
    ((f)localObject).nfN.clear();
    ((f)localObject).nfQ.clear();
    ((f)localObject).nfP.clear();
    ((f)localObject).nfO.clear();
    ((f)localObject).zLo.clear();
    ((f)localObject).bEy();
    if ((((f)localObject).zLu != null) && (!((f)localObject).zLu.isRecycled()))
    {
      ab.i("MicroMsg.ImageGalleryLazyLoader", "bitmap recycle %s", new Object[] { ((f)localObject).zLu.toString() });
      ((f)localObject).zLu.recycle();
      ((f)localObject).zLu = null;
    }
    o.ahD().a(this);
    localObject = l.dKQ();
    if (equals(((l)localObject).zNR)) {
      ((l)localObject).zNR = null;
    }
    AppMethodBeat.o(32093);
  }
  
  public final com.tencent.mm.at.e f(bi parambi, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(32099);
    if (!c.c(parambi))
    {
      AppMethodBeat.o(32099);
      return null;
    }
    if ((this.zJI == null) || (this.zJI.zJL == null))
    {
      ab.e("MicroMsg.ImageGalleryHolderImage", "adapter is null!!");
      AppMethodBeat.o(32099);
      return null;
    }
    if (!paramBoolean)
    {
      if (parambi.field_isSend == 1) {
        localObject2 = (com.tencent.mm.at.e)this.zJI.zJL.zKi.get(Long.valueOf(parambi.field_msgId));
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (parambi.field_msgSvrId > 0L) {
          localObject1 = (com.tencent.mm.at.e)this.zJI.zJL.zKh.get(Long.valueOf(parambi.field_msgSvrId));
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramBoolean = false;
      long l;
      if (parambi.field_isSend == 1)
      {
        l = parambi.field_msgId;
        localObject2 = o.ahC().gT(l);
        localObject1 = localObject2;
        if (((com.tencent.mm.at.e)localObject2).fDL != 0L) {}
      }
      else
      {
        l = parambi.field_msgSvrId;
        localObject1 = o.ahC().gS(l);
        paramBoolean = true;
      }
      this.zJI.zJL.a(l, (com.tencent.mm.at.e)localObject1, paramBoolean);
      localObject2 = localObject1;
    }
    AppMethodBeat.o(32099);
    return localObject2;
  }
  
  public final Bitmap loadImage(String paramString)
  {
    AppMethodBeat.i(156908);
    paramString = auf(paramString);
    AppMethodBeat.o(156908);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.e
 * JD-Core Version:    0.7.0.1
 */