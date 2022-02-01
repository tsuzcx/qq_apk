package com.tencent.qbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static e MhA;
  private static int lxZ;
  private static int lya;
  private Map<Long, String> MhB;
  private Map<Long, b> MhC;
  private Map<String, List<Long>> MhD;
  private g kLC;
  private Object yBn;
  private ExecutorService yBp;
  
  static
  {
    AppMethodBeat.i(91156);
    MhA = new e();
    lxZ = 0;
    lya = 0;
    AppMethodBeat.o(91156);
  }
  
  public e()
  {
    AppMethodBeat.i(91154);
    this.MhB = new HashMap();
    this.MhC = new HashMap();
    this.MhD = new HashMap();
    this.yBn = new Object();
    this.kLC = new g("WxFileDecodeQueue");
    this.yBp = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(91154);
  }
  
  public static e fXW()
  {
    return MhA;
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, Bitmap paramBitmap, b paramb, int[] paramArrayOfInt, c paramc)
  {
    AppMethodBeat.i(196687);
    synchronized (this.yBn)
    {
      int i = this.MhB.size();
      if (i < 5)
      {
        ae.i("WxFileDecodeQueue", "addDecodeTask submit decode task %d, fileMap: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        this.MhB.put(Long.valueOf(paramLong), paramString);
        if (paramb != null) {
          this.MhC.put(Long.valueOf(paramLong), paramb);
        }
        if (!this.MhD.containsKey(paramString))
        {
          this.MhD.put(paramString, new ArrayList());
          this.yBp.execute(new a(paramString, paramBitmap, com.tencent.scanlib.a.lg(paramContext), paramArrayOfInt, paramc));
        }
        ((List)this.MhD.get(paramString)).add(Long.valueOf(paramLong));
        AppMethodBeat.o(196687);
        return;
      }
      ae.w("WxFileDecodeQueue", "too many files are waiting and ignore: %d", new Object[] { Long.valueOf(paramLong) });
      paramb.a(paramLong, null);
    }
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, b paramb)
  {
    AppMethodBeat.i(196689);
    a(paramContext, paramLong, paramString, paramb, new int[] { 0 });
    AppMethodBeat.o(196689);
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196688);
    a(paramContext, paramLong, paramString, null, paramb, paramArrayOfInt, null);
    AppMethodBeat.o(196688);
  }
  
  final class a
    implements Runnable
  {
    private QbarNative.QbarAiModelParam MhE;
    private int[] MhF;
    private e.c MhG;
    private Bitmap bitmap;
    private String filePath;
    
    public a(String paramString, Bitmap paramBitmap, QbarNative.QbarAiModelParam paramQbarAiModelParam, int[] paramArrayOfInt, e.c paramc)
    {
      AppMethodBeat.i(196685);
      this.MhF = new int[] { 0 };
      this.filePath = paramString;
      this.bitmap = paramBitmap;
      this.MhE = paramQbarAiModelParam;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
        this.MhF = paramArrayOfInt;
      }
      this.MhG = paramc;
      AppMethodBeat.o(196685);
    }
    
    private boolean fXX()
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.MhF.length)
        {
          if ((this.MhF[i] == 3) || (this.MhF[i] == 0)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    private Bitmap fXY()
    {
      int i = 0;
      AppMethodBeat.i(196686);
      Object localObject1 = null;
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        ae.i("WxFileDecodeQueue", "decodeFile use bitmap");
        localObject1 = this.bitmap;
      }
      for (;;)
      {
        AppMethodBeat.o(196686);
        return localObject1;
        Object localObject3 = localObject1;
        try
        {
          Object localObject4 = new BitmapFactory.Options();
          localObject3 = localObject1;
          ((BitmapFactory.Options)localObject4).inJustDecodeBounds = true;
          localObject3 = localObject1;
          h.decodeFile(this.filePath, (BitmapFactory.Options)localObject4);
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
            AppMethodBeat.o(196686);
            return null;
          }
          localObject3 = localObject1;
          if (((BitmapFactory.Options)localObject4).outWidth * ((BitmapFactory.Options)localObject4).outHeight * 3 > 10485760)
          {
            localObject3 = localObject1;
            ae.i("WxFileDecodeQueue", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject4).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject4).outHeight) });
            localObject3 = localObject1;
            localOptions.inSampleSize = 2;
          }
          localObject3 = localObject1;
          int j = ((BitmapFactory.Options)localObject4).outWidth;
          localObject3 = localObject1;
          int k = ((BitmapFactory.Options)localObject4).outHeight;
          localObject3 = localObject1;
          if (e.lxZ != 0)
          {
            localObject3 = localObject1;
            if (e.lya != 0) {}
          }
          else
          {
            localObject3 = localObject1;
            e.access$002(com.tencent.mm.cb.a.iu(ak.getContext()));
            localObject3 = localObject1;
            e.access$102(com.tencent.mm.cb.a.iv(ak.getContext()));
          }
          localObject3 = localObject1;
          ae.v("WxFileDecodeQueue", "alvinluo needSampleImage image: %d, %d, screen: %d, %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(e.lxZ), Integer.valueOf(e.lya) });
          if (j > k)
          {
            localObject3 = localObject1;
            if (j > (int)(e.lxZ * 2.0F))
            {
              localObject3 = localObject1;
              i = com.tencent.qbar.b.a.O(j, k, (int)(e.lxZ * 2.0F), k);
            }
          }
          for (;;)
          {
            localObject3 = localObject1;
            ae.v("WxFileDecodeQueue", "decodeFile inSampleSize: %d, computeSampleSize: %d", new Object[] { Integer.valueOf(localOptions.inSampleSize), Integer.valueOf(i) });
            localObject3 = localObject1;
            if (localOptions.inSampleSize < i)
            {
              localObject3 = localObject1;
              localOptions.inSampleSize = i;
            }
            localObject3 = localObject1;
            localObject4 = h.decodeFile(this.filePath, localOptions);
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (this.MhG == null) {
              break;
            }
            localObject1 = localObject4;
            localObject3 = localObject4;
            if (!this.MhG.dFJ) {
              break;
            }
            localObject3 = localObject4;
            i = BackwardSupportUtil.ExifHelper.df(this.filePath);
            if (i != 90)
            {
              localObject1 = localObject4;
              if (i != 270) {
                break;
              }
            }
            localObject3 = localObject4;
            ae.i("WxFileDecodeQueue", "decodeBitmap needRotate: %d", new Object[] { Integer.valueOf(i) });
            localObject3 = localObject4;
            localObject1 = h.a((Bitmap)localObject4, i);
            break;
            localObject3 = localObject1;
            if (k > (int)(e.lya * 2.0F))
            {
              localObject3 = localObject1;
              i = com.tencent.qbar.b.a.O(j, k, j, (int)(e.lxZ * 2.0F));
            }
          }
        }
        catch (Exception localException)
        {
          ae.e("WxFileDecodeQueue", "decode file to bitmap error! " + localException.getMessage());
          Object localObject2 = localObject3;
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(91153);
      Object localObject5 = fXY();
      long l;
      e.d locald;
      int i;
      for (;;)
      {
        synchronized (e.a(e.this))
        {
          l = System.currentTimeMillis();
          if (!e.a(e.this).hasInited()) {
            e.a(e.this).a(1, this.MhE);
          }
          if (e.a(e.this).hasInited()) {
            e.a(e.this).M(this.MhF);
          }
          locald = new e.d();
          if (localObject5 == null) {
            break label695;
          }
          ae.i("WxFileDecodeQueue", "decodeFile image size: %d, %d", new Object[] { Integer.valueOf(((Bitmap)localObject5).getWidth()), Integer.valueOf(((Bitmap)localObject5).getHeight()) });
          localObject6 = new int[((Bitmap)localObject5).getWidth() * ((Bitmap)localObject5).getHeight()];
          ((Bitmap)localObject5).getPixels((int[])localObject6, 0, ((Bitmap)localObject5).getWidth(), 0, 0, ((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
          localObject7 = z.aBG().Bq("basescanui@datacenter");
          Object localObject1 = null;
          if (localObject7 != null) {
            localObject1 = new Point(((z.b)localObject7).getInt("key_basescanui_screen_x", 0), ((z.b)localObject7).getInt("key_basescanui_screen_y", 0));
          }
          locald.MhI = new ArrayList();
          locald.MhJ = new ArrayList();
          locald.MhK = new Point(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
          localObject7 = e.a(e.this);
          localObject8 = locald.MhK;
          List localList1 = locald.MhI;
          List localList2 = locald.MhJ;
          if ((this.MhG != null) && (this.MhG.dFJ))
          {
            bool = true;
            locald.yEe = ((g)localObject7).a((int[])localObject6, (Point)localObject8, (Point)localObject1, localList1, localList2, bool);
            if (this.MhG == null) {
              break label545;
            }
            i = this.MhG.dFK;
            locald.dFK = i;
            if (locald.yEe != null) {
              break label550;
            }
            i = 0;
            ae.i("WxFileDecodeQueue", "decodeFile get %d decode results", new Object[] { Integer.valueOf(i) });
            i = (int)(System.currentTimeMillis() - l);
            c.Mhe.fXV();
            c.Mhe.Fs(i);
            c.Mhe.kS(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
            c.Mhe.Mhv = fXX();
            if ((locald.yEe == null) || (locald.yEe.isEmpty())) {
              break label684;
            }
            localObject1 = locald.yEe.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject5 = (a.a)((Iterator)localObject1).next();
            ae.i("WxFileDecodeQueue", "decodeFile result " + ((a.a)localObject5).typeName + "," + ((a.a)localObject5).data);
          }
        }
        boolean bool = false;
        continue;
        label545:
        i = 0;
        continue;
        label550:
        i = locald.yEe.size();
      }
      c.Mhe.fXU();
      c.Mhe.Ft(i);
      localObject5 = c.Mhe;
      Object localObject6 = ((a.a)locald.yEe.get(0)).typeName;
      Object localObject7 = ((a.a)locald.yEe.get(0)).data;
      Object localObject8 = ((a.a)locald.yEe.get(0)).charset;
      if (locald.MhJ.isEmpty()) {}
      for (??? = null;; ??? = (WxQbarNative.QBarReportMsg)localObject4.MhJ.get(0))
      {
        ((c)localObject5).a((String)localObject6, (String)localObject7, (String)localObject8, (WxQbarNative.QBarReportMsg)???, locald.yEe.size(), locald.MhJ);
        label684:
        c.Mhe.byD();
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
        ae.i("WxFileDecodeQueue", "release QBar");
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
    public boolean dFJ = false;
    public int dFK = 0;
  }
  
  public static final class d
  {
    public List<QbarNative.QBarPoint> MhI;
    public List<WxQbarNative.QBarReportMsg> MhJ;
    public Point MhK;
    public int dFK;
    public List<a.a> yEe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qbar.e
 * JD-Core Version:    0.7.0.1
 */