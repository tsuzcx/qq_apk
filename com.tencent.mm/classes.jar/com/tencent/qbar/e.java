package com.tencent.qbar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.scanner.util.a.d;
import com.tencent.mm.plugin.scanner.util.a.h;
import com.tencent.mm.plugin.scanner.util.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.scanlib.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class e
{
  private static e ZmJ;
  private static i ZmN;
  private static int pEj;
  private static int pEk;
  private Object Brg;
  private ExecutorService IIs;
  private Map<Long, String> ZmK;
  private Map<Long, e.b> ZmL;
  private Map<String, List<Long>> ZmM;
  private g oMJ;
  
  static
  {
    AppMethodBeat.i(91156);
    ZmJ = new e();
    pEj = 0;
    pEk = 0;
    ZmN = null;
    AppMethodBeat.o(91156);
  }
  
  public e()
  {
    AppMethodBeat.i(91154);
    this.ZmK = new HashMap();
    this.ZmL = new HashMap();
    this.ZmM = new HashMap();
    this.Brg = new Object();
    this.oMJ = new g("WxFileDecodeQueue");
    this.IIs = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(91154);
  }
  
  public static e inE()
  {
    return ZmJ;
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, Bitmap paramBitmap, e.b paramb, int[] paramArrayOfInt, e.c paramc)
  {
    AppMethodBeat.i(193564);
    synchronized (this.Brg)
    {
      int i = this.ZmK.size();
      if (i < 9)
      {
        Log.i("WxFileDecodeQueue", "addDecodeTask submit decode task %d, fileMap: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i) });
        this.ZmK.put(Long.valueOf(paramLong), paramString);
        if (paramb != null) {
          this.ZmL.put(Long.valueOf(paramLong), paramb);
        }
        if (!this.ZmM.containsKey(paramString))
        {
          this.ZmM.put(paramString, new ArrayList());
          this.IIs.execute(new a(paramString, paramBitmap, b.lZ(paramContext), paramArrayOfInt, paramc));
        }
        ((List)this.ZmM.get(paramString)).add(Long.valueOf(paramLong));
        AppMethodBeat.o(193564);
        return;
      }
      Log.w("WxFileDecodeQueue", "too many files are waiting and ignore: %d", new Object[] { Long.valueOf(paramLong) });
      paramb.a(paramLong, null);
    }
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, e.b paramb)
  {
    AppMethodBeat.i(193566);
    a(paramContext, paramLong, paramString, paramb, new int[] { 0 });
    AppMethodBeat.o(193566);
  }
  
  public final void a(Context paramContext, long paramLong, String paramString, e.b paramb, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193565);
    a(paramContext, paramLong, paramString, null, paramb, paramArrayOfInt, null);
    AppMethodBeat.o(193565);
  }
  
  final class a
    implements Runnable
  {
    private QbarNative.QbarAiModelParam ZmO;
    private int[] ZmP;
    private e.c ZmQ;
    private Bitmap bitmap;
    private String filePath;
    
    public a(String paramString, Bitmap paramBitmap, QbarNative.QbarAiModelParam paramQbarAiModelParam, int[] paramArrayOfInt, e.c paramc)
    {
      AppMethodBeat.i(193044);
      this.ZmP = new int[] { 0 };
      this.filePath = paramString;
      this.bitmap = paramBitmap;
      this.ZmO = paramQbarAiModelParam;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
        this.ZmP = paramArrayOfInt;
      }
      this.ZmQ = paramc;
      AppMethodBeat.o(193044);
    }
    
    private boolean inG()
    {
      boolean bool2 = false;
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < this.ZmP.length)
        {
          if ((this.ZmP[i] == 3) || (this.ZmP[i] == 0)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    private Bitmap inH()
    {
      AppMethodBeat.i(193060);
      Bitmap localBitmap = null;
      if ((this.bitmap != null) && (!this.bitmap.isRecycled()))
      {
        Log.i("WxFileDecodeQueue", "decodeFile use bitmap");
        localBitmap = this.bitmap;
      }
      for (;;)
      {
        AppMethodBeat.o(193060);
        return localBitmap;
        try
        {
          if (e.inF() == null) {
            e.a(new d());
          }
          Object localObject = new com.tencent.mm.plugin.scanner.util.a.c(this.filePath);
          if ((this.ZmQ != null) && (this.ZmQ.fRi)) {}
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.scanner.util.a.c)localObject).fRi = bool;
            localObject = com.tencent.mm.plugin.scanner.util.a.e.a((com.tencent.mm.plugin.scanner.util.a.g)localObject, e.inF()).bitmap;
            AppMethodBeat.o(193060);
            return localObject;
          }
        }
        catch (Exception localException)
        {
          Log.e("WxFileDecodeQueue", "decode file to bitmap error! " + localException.getMessage());
        }
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(91153);
      Object localObject5 = inH();
      for (;;)
      {
        long l;
        e.d locald;
        synchronized (e.a(e.this))
        {
          l = System.currentTimeMillis();
          if (!e.a(e.this).hasInited()) {
            e.a(e.this).a(1, this.ZmO);
          }
          if (e.a(e.this).hasInited()) {
            e.a(e.this).S(this.ZmP);
          }
          locald = new e.d();
          if (localObject5 == null) {
            break label779;
          }
          Log.i("WxFileDecodeQueue", "decodeFile image size: %d, %d", new Object[] { Integer.valueOf(((Bitmap)localObject5).getWidth()), Integer.valueOf(((Bitmap)localObject5).getHeight()) });
          localObject6 = new int[((Bitmap)localObject5).getWidth() * ((Bitmap)localObject5).getHeight()];
          ((Bitmap)localObject5).getPixels((int[])localObject6, 0, ((Bitmap)localObject5).getWidth(), 0, 0, ((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
          localObject7 = ad.beh().Ro("basescanui@datacenter");
          Object localObject1 = null;
          if (localObject7 == null) {
            break label1037;
          }
          if (((ad.b)localObject7).getBoolean("key_basescanui_screen_position", false))
          {
            localObject1 = new PointF(((Float)((ad.b)localObject7).get("key_basescanui_screen_x", Float.valueOf(0.0F))).floatValue(), ((Float)((ad.b)localObject7).get("key_basescanui_screen_y", Float.valueOf(0.0F))).floatValue());
            bool1 = false;
            locald.KjT = new ArrayList();
            locald.ZmS = new ArrayList();
            locald.ZmT = new Point(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
            localObject7 = e.a(e.this);
            localObject8 = locald.ZmT;
            List localList1 = locald.KjT;
            List localList2 = locald.ZmS;
            if ((this.ZmQ == null) || (!this.ZmQ.fRi)) {
              break label1043;
            }
            bool2 = true;
            locald.IMj = ((g)localObject7).a((int[])localObject6, (Point)localObject8, (PointF)localObject1, localList1, localList2, bool2);
            if (this.ZmQ == null) {
              break label1049;
            }
            i = this.ZmQ.fRj;
            locald.fRj = i;
            if (locald.IMj != null) {
              break label634;
            }
            i = 0;
            Log.i("WxFileDecodeQueue", "alvinluo decodeFile get %d decode results, isFingerPositionNormalize: %b, finger: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), localObject1 });
            i = (int)(System.currentTimeMillis() - l);
            c.Zmn.inD();
            c.Zmn.WL(i);
            c.Zmn.nI(((Bitmap)localObject5).getWidth(), ((Bitmap)localObject5).getHeight());
            c.Zmn.ZmE = inG();
            if ((locald.IMj == null) || (locald.IMj.isEmpty())) {
              break label768;
            }
            localObject1 = locald.IMj.iterator();
            if (!((Iterator)localObject1).hasNext()) {
              break label648;
            }
            localObject5 = (a.a)((Iterator)localObject1).next();
            Log.i("WxFileDecodeQueue", "decodeFile result " + ((a.a)localObject5).typeName + "," + ((a.a)localObject5).data);
          }
        }
        ??? = new PointF(((Float)((ad.b)localObject7).get("key_basescanui_touch_normalize_x", Float.valueOf(0.0F))).floatValue(), ((Float)((ad.b)localObject7).get("key_basescanui_touch_normalize_y", Float.valueOf(0.0F))).floatValue());
        boolean bool1 = true;
        continue;
        label634:
        int i = locald.IMj.size();
        continue;
        label648:
        c.Zmn.inC();
        c.Zmn.WM(i);
        localObject5 = c.Zmn;
        Object localObject6 = ((a.a)locald.IMj.get(0)).typeName;
        Object localObject7 = ((a.a)locald.IMj.get(0)).data;
        Object localObject8 = ((a.a)locald.IMj.get(0)).charset;
        if (locald.ZmS.isEmpty()) {}
        for (??? = null;; ??? = (WxQbarNative.QBarReportMsg)localObject4.ZmS.get(0))
        {
          ((c)localObject5).a((String)localObject6, (String)localObject7, (String)localObject8, (WxQbarNative.QBarReportMsg)???, locald.IMj.size(), locald.ZmS);
          label768:
          c.Zmn.cig();
          this.bitmap = null;
          label779:
          synchronized (e.b(e.this))
          {
            if (!e.c(e.this).containsKey(this.filePath)) {
              break label992;
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
        label992:
        if (e.c(e.this).isEmpty())
        {
          Log.i("WxFileDecodeQueue", "release QBar");
          e.a(e.this).release();
        }
        AppMethodBeat.o(91153);
        return;
        label1037:
        bool1 = false;
        continue;
        label1043:
        boolean bool2 = false;
        continue;
        label1049:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qbar.e
 * JD-Core Version:    0.7.0.1
 */