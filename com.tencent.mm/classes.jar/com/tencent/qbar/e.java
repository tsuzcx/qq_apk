package com.tencent.qbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static e LKB;
  private static int ltA;
  private static int ltB;
  private Map<Long, String> LKC;
  private Map<Long, b> LKD;
  private Map<String, List<Long>> LKE;
  private g kIn;
  private Object ylo;
  private ExecutorService ylq;
  
  static
  {
    AppMethodBeat.i(91156);
    LKB = new e();
    ltA = 0;
    ltB = 0;
    AppMethodBeat.o(91156);
  }
  
  public e()
  {
    AppMethodBeat.i(91154);
    this.LKC = new HashMap();
    this.LKD = new HashMap();
    this.LKE = new HashMap();
    this.ylo = new Object();
    this.kIn = new g("WxFileDecodeQueue");
    this.ylq = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(91154);
  }
  
  public static e fTw()
  {
    return LKB;
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, Bitmap paramBitmap, b paramb, int[] paramArrayOfInt, c paramc)
  {
    AppMethodBeat.i(218752);
    synchronized (this.ylo)
    {
      int i = this.LKC.size();
      if (i < 5)
      {
        ad.i("WxFileDecodeQueue", "addDecodeTask submit decode task %d, fileMap: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        this.LKC.put(Long.valueOf(paramLong), paramString);
        if (paramb != null) {
          this.LKD.put(Long.valueOf(paramLong), paramb);
        }
        if (!this.LKE.containsKey(paramString))
        {
          this.LKE.put(paramString, new ArrayList());
          this.ylq.execute(new a(paramString, paramBitmap, com.tencent.scanlib.a.la(paramContext), paramArrayOfInt, paramc));
        }
        ((List)this.LKE.get(paramString)).add(Long.valueOf(paramLong));
        AppMethodBeat.o(218752);
        return;
      }
      ad.w("WxFileDecodeQueue", "too many files are waiting and ignore: %d", new Object[] { Long.valueOf(paramLong) });
      paramb.a(paramLong, null);
    }
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(218753);
    a(paramContext, paramLong, paramString, null, paramb, paramArrayOfInt, null);
    AppMethodBeat.o(218753);
  }
  
  final class a
    implements Runnable
  {
    private QbarNative.QbarAiModelParam LKF;
    private int[] LKG;
    private e.c LKH;
    private Bitmap bitmap;
    private String filePath;
    
    public a(String paramString, Bitmap paramBitmap, QbarNative.QbarAiModelParam paramQbarAiModelParam, int[] paramArrayOfInt, e.c paramc)
    {
      AppMethodBeat.i(218750);
      this.LKG = new int[] { 0 };
      this.filePath = paramString;
      this.bitmap = paramBitmap;
      this.LKF = paramQbarAiModelParam;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
        this.LKG = paramArrayOfInt;
      }
      this.LKH = paramc;
      AppMethodBeat.o(218750);
    }
    
    private boolean fTx()
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.LKG.length)
        {
          if ((this.LKG[i] == 3) || (this.LKG[i] == 0)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    private Bitmap fTy()
    {
      int i = 0;
      AppMethodBeat.i(218751);
      Object localObject1 = null;
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ad.i("WxFileDecodeQueue", "decodeFile use bitmap");
        localObject1 = this.bitmap;
      }
      for (;;)
      {
        AppMethodBeat.o(218751);
        return localObject1;
        Object localObject3 = localObject1;
        try
        {
          Object localObject4 = new BitmapFactory.Options();
          localObject3 = localObject1;
          ((BitmapFactory.Options)localObject4).inJustDecodeBounds = true;
          localObject3 = localObject1;
          com.tencent.mm.sdk.platformtools.g.decodeFile(this.filePath, (BitmapFactory.Options)localObject4);
          localObject3 = localObject1;
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localObject3 = localObject1;
          if (((BitmapFactory.Options)localObject4).outWidth * ((BitmapFactory.Options)localObject4).outHeight * 3 > 10485760)
          {
            localObject3 = localObject1;
            ad.i("WxFileDecodeQueue", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject4).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject4).outHeight) });
            localObject3 = localObject1;
            localOptions.inSampleSize = 2;
          }
          localObject3 = localObject1;
          int j = ((BitmapFactory.Options)localObject4).outWidth;
          localObject3 = localObject1;
          int k = ((BitmapFactory.Options)localObject4).outHeight;
          localObject3 = localObject1;
          if (e.ltA != 0)
          {
            localObject3 = localObject1;
            if (e.ltB != 0) {}
          }
          else
          {
            localObject3 = localObject1;
            e.access$002(com.tencent.mm.cc.a.ip(aj.getContext()));
            localObject3 = localObject1;
            e.access$102(com.tencent.mm.cc.a.iq(aj.getContext()));
          }
          localObject3 = localObject1;
          ad.v("WxFileDecodeQueue", "alvinluo needSampleImage image: %d, %d, screen: %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(e.ltA), Integer.valueOf(e.ltB) });
          if (j > k)
          {
            localObject3 = localObject1;
            if (j > (int)(e.ltA * 2.0F))
            {
              localObject3 = localObject1;
              i = com.tencent.qbar.b.a.O(j, k, (int)(e.ltA * 2.0F), k);
            }
          }
          for (;;)
          {
            localObject3 = localObject1;
            ad.v("WxFileDecodeQueue", "decodeFile inSampleSize: %d, computeSampleSize: %d", new Object[] { Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(i) });
            localObject3 = localObject1;
            if (localOptions.inSampleSize < i)
            {
              localObject3 = localObject1;
              localOptions.inSampleSize = i;
            }
            localObject3 = localObject1;
            localObject4 = com.tencent.mm.sdk.platformtools.g.decodeFile(this.filePath, localOptions);
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (this.LKH == null) {
              break;
            }
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (!this.LKH.dEE) {
              break;
            }
            localObject3 = localObject4;
            i = BackwardSupportUtil.ExifHelper.cY(this.filePath);
            if (i != 90)
            {
              localObject1 = localObject4;
              if (i != 270) {
                break;
              }
            }
            localObject3 = localObject4;
            ad.i("WxFileDecodeQueue", "decodeBitmap needRotate: %d", new Object[] { Integer.valueOf(i) });
            localObject3 = localObject4;
            localObject1 = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject4, i);
            break;
            localObject3 = localObject1;
            if (k > (int)(e.ltB * 2.0F))
            {
              localObject3 = localObject1;
              i = com.tencent.qbar.b.a.O(j, k, j, (int)(e.ltA * 2.0F));
            }
          }
        }
        catch (Exception localException)
        {
          ad.e("WxFileDecodeQueue", "decode file to bitmap error! " + localException.getMessage());
          Object localObject2 = localObject3;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(91153);
      Object localObject5 = fTy();
      long l;
      e.d locald;
      int i;
      for (;;)
      {
        synchronized (e.a(e.this))
        {
          l = System.currentTimeMillis();
          if (!e.a(e.this).hasInited()) {
            e.a(e.this).a(1, this.LKF);
          }
          if (e.a(e.this).hasInited()) {
            e.a(e.this).L(this.LKG);
          }
          locald = new e.d();
          if (localObject5 == null) {
            break label695;
          }
          ad.i("WxFileDecodeQueue", "decodeFile image size: %d, %d", new Object[] { Integer.valueOf(((Bitmap)localObject5).getWidth()), Integer.valueOf(((Bitmap)localObject5).getHeight()) });
          localObject6 = new int[((Bitmap)localObject5).getWidth() * ((Bitmap)localObject5).getHeight()];
          ((Bitmap)localObject5).getPixels((int[])localObject6, 0, ((Bitmap)localObject5).getWidth(), 0, 0, ((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
          localObject7 = y.aBq().AG("basescanui@datacenter");
          Object localObject1 = null;
          if (localObject7 != null) {
            localObject1 = new Point(((y.b)localObject7).getInt("key_basescanui_screen_x", 0), ((y.b)localObject7).getInt("key_basescanui_screen_y", 0));
          }
          locald.LKJ = new ArrayList();
          locald.LKK = new ArrayList();
          locald.LKL = new Point(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
          localObject7 = e.a(e.this);
          localObject8 = locald.LKL;
          List localList1 = locald.LKJ;
          List localList2 = locald.LKK;
          if ((this.LKH != null) && (this.LKH.dEE))
          {
            bool = true;
            locald.yof = ((g)localObject7).a((int[])localObject6, (Point)localObject8, (Point)localObject1, localList1, localList2, bool);
            if (this.LKH == null) {
              break label545;
            }
            i = this.LKH.dEF;
            locald.dEF = i;
            if (locald.yof != null) {
              break label550;
            }
            i = 0;
            ad.i("WxFileDecodeQueue", "decodeFile get %d decode results", new Object[] { Integer.valueOf(i) });
            i = (int)(System.currentTimeMillis() - l);
            c.LKf.fTv();
            c.LKf.EQ(i);
            c.LKf.kL(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
            c.LKf.LKw = fTx();
            if ((locald.yof == null) || (locald.yof.isEmpty())) {
              break label684;
            }
            localObject1 = locald.yof.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject5 = (a.a)((Iterator)localObject1).next();
            ad.i("WxFileDecodeQueue", "decodeFile result " + ((a.a)localObject5).typeName + "," + ((a.a)localObject5).data);
          }
        }
        boolean bool = false;
        continue;
        label545:
        i = 0;
        continue;
        label550:
        i = locald.yof.size();
      }
      c.LKf.fTu();
      c.LKf.ER(i);
      localObject5 = c.LKf;
      Object localObject6 = ((a.a)locald.yof.get(0)).typeName;
      Object localObject7 = ((a.a)locald.yof.get(0)).data;
      Object localObject8 = ((a.a)locald.yof.get(0)).charset;
      if (locald.LKK.isEmpty()) {}
      for (??? = null;; ??? = (WxQbarNative.QBarReportMsg)localObject4.LKK.get(0))
      {
        ((c)localObject5).a((String)localObject6, (String)localObject7, (String)localObject8, (WxQbarNative.QBarReportMsg)???, locald.yof.size(), locald.LKK);
        label684:
        c.LKf.bxK();
        this.bitmap = null;
        label695:
        synchronized (e.b(e.this))
        {
          if (!e.c(e.this).containsKey(this.filePath)) {
            break label908;
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
      label908:
      if (e.c(e.this).isEmpty())
      {
        ad.i("WxFileDecodeQueue", "release QBar");
        e.a(e.this).release();
      }
      AppMethodBeat.o(91153);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, e.d paramd);
  }
  
  public static final class c
  {
    public boolean dEE = false;
    public int dEF = 0;
  }
  
  public static final class d
  {
    public List<QbarNative.QBarPoint> LKJ;
    public List<WxQbarNative.QBarReportMsg> LKK;
    public Point LKL;
    public int dEF;
    public List<a.a> yof;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.e
 * JD-Core Version:    0.7.0.1
 */