package com.tencent.qbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.scanlib.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static e JQO;
  private Map<Long, String> JQP;
  private Map<Long, b> JQQ;
  private Map<String, List<Long>> JQR;
  private g knn;
  private Object wXD;
  private ExecutorService wXF;
  
  static
  {
    AppMethodBeat.i(91156);
    JQO = new e();
    AppMethodBeat.o(91156);
  }
  
  public e()
  {
    AppMethodBeat.i(91154);
    this.JQP = new HashMap();
    this.JQQ = new HashMap();
    this.JQR = new HashMap();
    this.wXD = new Object();
    this.knn = new g("WxFileDecodeQueue");
    this.wXF = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(91154);
  }
  
  public static e fCh()
  {
    return JQO;
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(91155);
    synchronized (this.wXD)
    {
      if (this.JQP.size() < 5)
      {
        ac.i("WxFileDecodeQueue", String.format("submit decode task %d", new Object[] { Long.valueOf(paramLong) }));
        this.JQP.put(Long.valueOf(paramLong), paramString);
        if (paramb != null) {
          this.JQQ.put(Long.valueOf(paramLong), paramb);
        }
        if (!this.JQR.containsKey(paramString))
        {
          this.JQR.put(paramString, new ArrayList());
          this.wXF.execute(new a(paramString, a.kN(paramContext), paramArrayOfInt));
        }
        ((List)this.JQR.get(paramString)).add(Long.valueOf(paramLong));
        AppMethodBeat.o(91155);
        return;
      }
      ac.w("WxFileDecodeQueue", "too many files are waiting!");
      paramb.a(paramLong, null, null);
    }
  }
  
  final class a
    implements Runnable
  {
    private QbarNative.QbarAiModelParam JQS;
    private int[] JQT;
    private String filePath;
    
    public a(String paramString, QbarNative.QbarAiModelParam paramQbarAiModelParam, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(91152);
      this.JQT = new int[] { 0 };
      this.filePath = paramString;
      this.JQS = paramQbarAiModelParam;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
        this.JQT = paramArrayOfInt;
      }
      AppMethodBeat.o(91152);
    }
    
    private boolean fCi()
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.JQT.length)
        {
          if ((this.JQT[i] == 3) || (this.JQT[i] == 0)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(91153);
      long l;
      Object localObject7;
      for (;;)
      {
        try
        {
          localObject1 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
          f.decodeFile(this.filePath, (BitmapFactory.Options)localObject1);
          localObject5 = new BitmapFactory.Options();
          if (((BitmapFactory.Options)localObject1).outWidth * ((BitmapFactory.Options)localObject1).outHeight * 3 > 10485760)
          {
            ac.i("WxFileDecodeQueue", "bitmap too large %d x %d, sample", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight) });
            ((BitmapFactory.Options)localObject5).inSampleSize = 2;
          }
          localObject1 = f.decodeFile(this.filePath, (BitmapFactory.Options)localObject5);
        }
        catch (Exception localException)
        {
          Object localObject1;
          ac.e("WxFileDecodeQueue", "decode file to bitmap error! " + localException.getMessage());
          localObject3 = null;
          continue;
          int i = ((List)localObject5).size();
          continue;
          c.JQs.fCf();
          c.JQs.BP(i);
          localObject7 = c.JQs;
          str1 = ((a.a)((List)localObject5).get(0)).typeName;
          str2 = ((a.a)((List)localObject5).get(0)).data;
          str3 = ((a.a)((List)localObject5).get(0)).charset;
          if (!((List)???).isEmpty()) {
            break label858;
          }
        }
        synchronized (e.a(e.this))
        {
          l = System.currentTimeMillis();
          if (!e.a(e.this).hasInited()) {
            e.a(e.this).a(1, this.JQS);
          }
          if (e.a(e.this).hasInited()) {
            e.a(e.this).L(this.JQT);
          }
          if (localObject1 == null) {
            break label942;
          }
          ac.i("WxFileDecodeQueue", String.format("%s,%s", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) }));
          localObject7 = new int[((Bitmap)localObject1).getWidth() * ((Bitmap)localObject1).getHeight()];
          ((Bitmap)localObject1).getPixels((int[])localObject7, 0, ((Bitmap)localObject1).getWidth(), 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
          localObject5 = y.ayq().xI("basescanui@datacenter");
          if (localObject5 == null) {
            break label936;
          }
          localObject5 = new Point(((y.b)localObject5).getInt("key_basescanui_screen_x", 0), ((y.b)localObject5).getInt("key_basescanui_screen_y", 0));
          ??? = new ArrayList();
          localObject5 = e.a(e.this).a((int[])localObject7, new Point(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight()), (Point)localObject5, (List)???);
          if (localObject5 == null)
          {
            i = 0;
            ac.i("WxFileDecodeQueue", String.format("get %d decode results", new Object[] { Integer.valueOf(i) }));
            i = (int)(System.currentTimeMillis() - l);
            c.JQs.fCg();
            c.JQs.BO(i);
            c.JQs.kw(((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
            c.JQs.JQJ = fCi();
            if ((localObject5 == null) || (((List)localObject5).isEmpty())) {
              break label665;
            }
            localObject1 = ((List)localObject5).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject7 = (a.a)((Iterator)localObject1).next();
            ac.i("WxFileDecodeQueue", "result " + ((a.a)localObject7).typeName + "," + ((a.a)localObject7).data);
          }
        }
      }
      String str1;
      String str2;
      String str3;
      Object localObject3 = null;
      label643:
      ((c)localObject7).a(str1, str2, str3, (WxQbarNative.QBarReportMsg)localObject3, ((List)localObject5).size(), (List)???);
      label665:
      c.JQs.btF();
      localObject3 = localObject5;
      Object localObject5 = ???;
      for (;;)
      {
        synchronized (e.b(e.this))
        {
          if (!e.c(e.this).containsKey(this.filePath)) {
            break label891;
          }
          localObject7 = ((List)e.c(e.this).get(this.filePath)).iterator();
          if (!((Iterator)localObject7).hasNext()) {
            break label874;
          }
          l = ((Long)((Iterator)localObject7).next()).longValue();
          if (e.d(e.this).containsKey(Long.valueOf(l)))
          {
            ((e.b)e.d(e.this).get(Long.valueOf(l))).a(l, (List)localObject3, (List)localObject5);
            e.d(e.this).remove(Long.valueOf(l));
          }
          e.e(e.this).remove(Long.valueOf(l));
        }
        label858:
        WxQbarNative.QBarReportMsg localQBarReportMsg = (WxQbarNative.QBarReportMsg)((List)???).get(0);
        break label643;
        label874:
        e.c(e.this).remove(this.filePath);
        label891:
        if (e.c(e.this).isEmpty())
        {
          ac.i("WxFileDecodeQueue", "release QBar");
          e.a(e.this).release();
        }
        AppMethodBeat.o(91153);
        return;
        label936:
        localObject5 = null;
        break;
        label942:
        localObject5 = null;
        localQBarReportMsg = null;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong, List<a.a> paramList, List<WxQbarNative.QBarReportMsg> paramList1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.e
 * JD-Core Version:    0.7.0.1
 */