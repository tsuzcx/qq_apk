package com.tencent.qbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static e RKb;
  private static int mEX;
  private static int mEY;
  private Object CCt;
  private ExecutorService CDQ;
  private Map<Long, String> RKc;
  private Map<Long, e.b> RKd;
  private Map<String, List<Long>> RKe;
  private g lQo;
  
  static
  {
    AppMethodBeat.i(91156);
    RKb = new e();
    mEX = 0;
    mEY = 0;
    AppMethodBeat.o(91156);
  }
  
  public e()
  {
    AppMethodBeat.i(91154);
    this.RKc = new HashMap();
    this.RKd = new HashMap();
    this.RKe = new HashMap();
    this.CCt = new Object();
    this.lQo = new g("WxFileDecodeQueue");
    this.CDQ = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(91154);
  }
  
  public static e hki()
  {
    return RKb;
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, Bitmap paramBitmap, e.b paramb, int[] paramArrayOfInt, e.c paramc)
  {
    AppMethodBeat.i(194825);
    synchronized (this.CCt)
    {
      int i = this.RKc.size();
      if (i < 9)
      {
        Log.i("WxFileDecodeQueue", "addDecodeTask submit decode task %d, fileMap: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        this.RKc.put(Long.valueOf(paramLong), paramString);
        if (paramb != null) {
          this.RKd.put(Long.valueOf(paramLong), paramb);
        }
        if (!this.RKe.containsKey(paramString))
        {
          this.RKe.put(paramString, new ArrayList());
          this.CDQ.execute(new a(paramString, paramBitmap, com.tencent.scanlib.a.lb(paramContext), paramArrayOfInt, paramc));
        }
        ((List)this.RKe.get(paramString)).add(Long.valueOf(paramLong));
        AppMethodBeat.o(194825);
        return;
      }
      Log.w("WxFileDecodeQueue", "too many files are waiting and ignore: %d", new Object[] { Long.valueOf(paramLong) });
      paramb.a(paramLong, null);
    }
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, e.b paramb)
  {
    AppMethodBeat.i(194827);
    a(paramContext, paramLong, paramString, paramb, new int[] { 0 });
    AppMethodBeat.o(194827);
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, e.b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(194826);
    a(paramContext, paramLong, paramString, null, paramb, paramArrayOfInt, null);
    AppMethodBeat.o(194826);
  }
  
  final class a
    implements Runnable
  {
    private QbarNative.QbarAiModelParam RKf;
    private int[] RKg;
    private e.c RKh;
    private Bitmap bitmap;
    private String filePath;
    
    public a(String paramString, Bitmap paramBitmap, QbarNative.QbarAiModelParam paramQbarAiModelParam, int[] paramArrayOfInt, e.c paramc)
    {
      AppMethodBeat.i(194823);
      this.RKg = new int[] { 0 };
      this.filePath = paramString;
      this.bitmap = paramBitmap;
      this.RKf = paramQbarAiModelParam;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
        this.RKg = paramArrayOfInt;
      }
      this.RKh = paramc;
      AppMethodBeat.o(194823);
    }
    
    private boolean hkj()
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.RKg.length)
        {
          if ((this.RKg[i] == 3) || (this.RKg[i] == 0)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    private Bitmap hkk()
    {
      int i = 0;
      AppMethodBeat.i(194824);
      Object localObject1 = null;
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.i("WxFileDecodeQueue", "decodeFile use bitmap");
        localObject1 = this.bitmap;
      }
      for (;;)
      {
        AppMethodBeat.o(194824);
        return localObject1;
        Object localObject3 = localObject1;
        try
        {
          Object localObject4 = new BitmapFactory.Options();
          localObject3 = localObject1;
          ((BitmapFactory.Options)localObject4).inJustDecodeBounds = true;
          localObject3 = localObject1;
          BitmapUtil.decodeFile(this.filePath, (BitmapFactory.Options)localObject4);
          localObject3 = localObject1;
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localObject3 = localObject1;
          if (((BitmapFactory.Options)localObject4).outWidth > 4)
          {
            localObject3 = localObject1;
            j = ((BitmapFactory.Options)localObject4).outHeight;
            if (j > 4) {}
          }
          else
          {
            AppMethodBeat.o(194824);
            return null;
          }
          localObject3 = localObject1;
          if (((BitmapFactory.Options)localObject4).outWidth * ((BitmapFactory.Options)localObject4).outHeight * 3 > 10485760)
          {
            localObject3 = localObject1;
            Log.i("WxFileDecodeQueue", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject4).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject4).outHeight) });
            localObject3 = localObject1;
            localOptions.inSampleSize = 2;
          }
          localObject3 = localObject1;
          int j = ((BitmapFactory.Options)localObject4).outWidth;
          localObject3 = localObject1;
          int k = ((BitmapFactory.Options)localObject4).outHeight;
          localObject3 = localObject1;
          if (e.mEX != 0)
          {
            localObject3 = localObject1;
            if (e.mEY != 0) {}
          }
          else
          {
            localObject3 = localObject1;
            e.access$002(com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()));
            localObject3 = localObject1;
            e.access$102(com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()));
          }
          localObject3 = localObject1;
          Log.v("WxFileDecodeQueue", "alvinluo needSampleImage image: %d, %d, screen: %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(e.mEX), Integer.valueOf(e.mEY) });
          if (j > k)
          {
            localObject3 = localObject1;
            if (j > (int)(e.mEX * 2.0F))
            {
              localObject3 = localObject1;
              i = com.tencent.qbar.b.a.calculateInSampleSize(j, k, (int)(e.mEX * 2.0F), k);
            }
          }
          for (;;)
          {
            localObject3 = localObject1;
            Log.v("WxFileDecodeQueue", "decodeFile inSampleSize: %d, computeSampleSize: %d", new Object[] { Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(i) });
            localObject3 = localObject1;
            if (localOptions.inSampleSize < i)
            {
              localObject3 = localObject1;
              localOptions.inSampleSize = i;
            }
            localObject3 = localObject1;
            localObject4 = BitmapUtil.decodeFile(this.filePath, localOptions);
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (this.RKh == null) {
              break;
            }
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (!this.RKh.dXw) {
              break;
            }
            localObject3 = localObject4;
            i = BackwardSupportUtil.ExifHelper.getExifOrientation(this.filePath);
            if (i != 90)
            {
              localObject1 = localObject4;
              if (i != 270) {
                break;
              }
            }
            localObject3 = localObject4;
            Log.i("WxFileDecodeQueue", "decodeBitmap needRotate: %d", new Object[] { Integer.valueOf(i) });
            localObject3 = localObject4;
            localObject1 = BitmapUtil.rotate((Bitmap)localObject4, i);
            break;
            localObject3 = localObject1;
            if (k > (int)(e.mEY * 2.0F))
            {
              localObject3 = localObject1;
              i = com.tencent.qbar.b.a.calculateInSampleSize(j, k, j, (int)(e.mEX * 2.0F));
            }
          }
        }
        catch (Exception localException)
        {
          Log.e("WxFileDecodeQueue", "decode file to bitmap error! " + localException.getMessage());
          Object localObject2 = localObject3;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(91153);
      Object localObject5 = hkk();
      for (;;)
      {
        long l;
        e.d locald;
        synchronized (e.a(e.this))
        {
          l = System.currentTimeMillis();
          if (!e.a(e.this).hasInited()) {
            e.a(e.this).a(1, this.RKf);
          }
          if (e.a(e.this).hasInited()) {
            e.a(e.this).T(this.RKg);
          }
          locald = new e.d();
          if (localObject5 == null) {
            break label781;
          }
          Log.i("WxFileDecodeQueue", "decodeFile image size: %d, %d", new Object[] { Integer.valueOf(((Bitmap)localObject5).getWidth()), Integer.valueOf(((Bitmap)localObject5).getHeight()) });
          localObject6 = new int[((Bitmap)localObject5).getWidth() * ((Bitmap)localObject5).getHeight()];
          ((Bitmap)localObject5).getPixels((int[])localObject6, 0, ((Bitmap)localObject5).getWidth(), 0, 0, ((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
          localObject7 = ad.aVe().JW("basescanui@datacenter");
          Object localObject1 = null;
          if (localObject7 == null) {
            break label1039;
          }
          if (((ad.b)localObject7).getBoolean("key_basescanui_screen_position", false))
          {
            localObject1 = new PointF(((Float)((ad.b)localObject7).get("key_basescanui_screen_x", Float.valueOf(0.0F))).floatValue(), ((Float)((ad.b)localObject7).get("key_basescanui_screen_y", Float.valueOf(0.0F))).floatValue());
            bool1 = false;
            locald.RKj = new ArrayList();
            locald.RKk = new ArrayList();
            locald.RKl = new Point(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
            localObject7 = e.a(e.this);
            localObject8 = locald.RKl;
            List localList1 = locald.RKj;
            List localList2 = locald.RKk;
            if ((this.RKh == null) || (!this.RKh.dXw)) {
              break label1045;
            }
            bool2 = true;
            locald.CGY = ((g)localObject7).a((int[])localObject6, (Point)localObject8, (PointF)localObject1, localList1, localList2, bool2);
            if (this.RKh == null) {
              break label1051;
            }
            i = this.RKh.dXx;
            locald.dXx = i;
            if (locald.CGY != null) {
              break label636;
            }
            i = 0;
            Log.i("WxFileDecodeQueue", "alvinluo decodeFile get %d decode results, isFingerPositionNormalize: %b, finger: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), localObject1 });
            i = (int)(System.currentTimeMillis() - l);
            c.RJF.hkh();
            c.RJF.Ov(i);
            c.RJF.mr(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
            c.RJF.RJW = hkj();
            if ((locald.CGY == null) || (locald.CGY.isEmpty())) {
              break label770;
            }
            localObject1 = locald.CGY.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label650;
            }
            localObject5 = (a.a)((Iterator)localObject1).next();
            Log.i("WxFileDecodeQueue", "decodeFile result " + ((a.a)localObject5).typeName + "," + ((a.a)localObject5).data);
          }
        }
        ??? = new PointF(((Float)((ad.b)localObject7).get("key_basescanui_touch_normalize_x", Float.valueOf(0.0F))).floatValue(), ((Float)((ad.b)localObject7).get("key_basescanui_touch_normalize_y", Float.valueOf(0.0F))).floatValue());
        boolean bool1 = true;
        continue;
        label636:
        int i = locald.CGY.size();
        continue;
        label650:
        c.RJF.hkg();
        c.RJF.Ow(i);
        localObject5 = c.RJF;
        Object localObject6 = ((a.a)locald.CGY.get(0)).typeName;
        Object localObject7 = ((a.a)locald.CGY.get(0)).data;
        Object localObject8 = ((a.a)locald.CGY.get(0)).charset;
        if (locald.RKk.isEmpty()) {}
        for (??? = null;; ??? = (WxQbarNative.QBarReportMsg)localObject4.RKk.get(0))
        {
          ((c)localObject5).a((String)localObject6, (String)localObject7, (String)localObject8, (WxQbarNative.QBarReportMsg)???, locald.CGY.size(), locald.RKk);
          label770:
          c.RJF.bUV();
          this.bitmap = null;
          label781:
          synchronized (e.b(e.this))
          {
            if (!e.c(e.this).containsKey(this.filePath)) {
              break label994;
            }
            localObject5 = ((List)e.c(e.this).get(this.filePath)).iterator();
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            l = ((Long)((Iterator)localObject5).next()).longValue();
            if (e.d(e.this).containsKey(Long.valueOf(l)))
            {
              ((e.b)e.d(e.this).get(Long.valueOf(l))).a(l, locald);
              e.d(e.this).remove(Long.valueOf(l));
            }
            e.e(e.this).remove(Long.valueOf(l));
          }
        }
        e.c(e.this).remove(this.filePath);
        label994:
        if (e.c(e.this).isEmpty())
        {
          Log.i("WxFileDecodeQueue", "release QBar");
          e.a(e.this).release();
        }
        AppMethodBeat.o(91153);
        return;
        label1039:
        bool1 = false;
        continue;
        label1045:
        boolean bool2 = false;
        continue;
        label1051:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.e
 * JD-Core Version:    0.7.0.1
 */