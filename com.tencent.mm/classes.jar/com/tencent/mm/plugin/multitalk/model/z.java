package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.a;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.pluginsdk.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.common.b.a.a.a.ap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;", "Lcom/tencent/mm/plugin/multitalk/model/BaseDataSource;", "()V", "decodeTask", "", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "[Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "fpsWrapper", "Lcom/tencent/mm/pluginsdk/platformtools/FpsWraper;", "screenMemberId", "", "screenReceiver", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "screenRunning", "", "screenUserName", "", "videoRunning", "checkCurrentIsReceiver", "hasScreenData", "receiveScreenData", "buf", "", "byteArray", "", "receiveVideoData", "start", "", "startReceiveScreen", "userName", "stop", "stopReceiveScreen", "stopVideo", "Companion", "DecodeRunnable", "ScreenDataDecode", "plugin-multitalk_release"})
public final class z
  extends c
{
  public static final z.a FtW;
  private final b[] FtP;
  public volatile boolean FtQ;
  public volatile boolean FtR;
  private volatile int FtS;
  private volatile String FtT;
  private volatile c FtU;
  private final b FtV;
  
  static
  {
    AppMethodBeat.i(201942);
    FtW = new z.a((byte)0);
    AppMethodBeat.o(201942);
  }
  
  public z()
  {
    AppMethodBeat.i(201941);
    this.FtP = new b[] { new b(true), new b(false) };
    this.FtS = -1;
    this.FtT = "";
    this.FtV = new b("multitalk_network");
    AppMethodBeat.o(201941);
  }
  
  private final boolean eXU()
  {
    return this.FtS >= 0;
  }
  
  public final void aQA(String paramString)
  {
    AppMethodBeat.i(201925);
    p.k(paramString, "userName");
    int i = e.aQT(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(201925);
      return;
    }
    if ((eXU()) || (this.FtR))
    {
      AppMethodBeat.o(201925);
      return;
    }
    this.FtR = true;
    this.FtS = i;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new a.ap();
    ((a.ap)localObject).tQm = i;
    localArrayList.add(localObject);
    localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN).putInt(i);
    o localo = ad.eYb();
    p.j(localo, "SubCoreMultiTalk.getMultiEngine()");
    localo.eWv().setAppCmd(55, ((ByteBuffer)localObject).array(), 4);
    localObject = ad.eYb();
    p.j(localObject, "SubCoreMultiTalk.getMultiEngine()");
    ((o)localObject).eWv().kW((List)localArrayList);
    this.FtT = paramString;
    paramString = e.FEP;
    if (!e.eZV())
    {
      paramString = a.FEC;
      a.eZz();
    }
    paramString = new c();
    new Thread((Runnable)paramString).start();
    this.FtU = paramString;
    AppMethodBeat.o(201925);
  }
  
  public final void eXV()
  {
    AppMethodBeat.i(201936);
    ??? = ByteBuffer.allocate(4);
    ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN).putInt(-1);
    Object localObject2 = ad.eYb();
    p.j(localObject2, "SubCoreMultiTalk.getMultiEngine()");
    ((o)localObject2).eWv().setAppCmd(55, ((ByteBuffer)???).array(), 4);
    ??? = ad.eYb();
    p.j(???, "SubCoreMultiTalk.getMultiEngine()");
    ((o)???).eWv().kW((List)new ArrayList());
    this.FtS = -1;
    this.FtR = false;
    if (!this.FtQ) {
      this.FqA = null;
    }
    localObject2 = this.FtU;
    if (localObject2 != null) {}
    synchronized (Boolean.valueOf(((c)localObject2).FtY))
    {
      ((c)localObject2).FtY = false;
      localObject2 = x.aazN;
      this.FtU = null;
      AppMethodBeat.o(201936);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(201898);
    if (this.FtQ)
    {
      AppMethodBeat.o(201898);
      return;
    }
    Log.i("NetworkDataSource", "start");
    this.FtQ = true;
    b[] arrayOfb = this.FtP;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfb[i];
      synchronized (Boolean.valueOf(((b)localObject2).FtY))
      {
        if (!((b)localObject2).FtY)
        {
          ((b)localObject2).FtY = true;
          new Thread((Runnable)localObject2).start();
        }
        localObject2 = x.aazN;
        i += 1;
      }
    }
    if (eXU()) {
      aQA(this.FtT);
    }
    AppMethodBeat.o(201898);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(201900);
    eXV();
    stopVideo();
    AppMethodBeat.o(201900);
  }
  
  public final void stopVideo()
  {
    int i = 0;
    AppMethodBeat.i(201908);
    this.FtQ = false;
    if (!this.FtR) {
      this.FqA = null;
    }
    b[] arrayOfb = this.FtP;
    int j = arrayOfb.length;
    for (;;)
    {
      Object localObject2;
      if (i < j) {
        localObject2 = arrayOfb[i];
      }
      synchronized (Boolean.valueOf(((b)localObject2).FtY))
      {
        ((b)localObject2).FtY = false;
        localObject2 = x.aazN;
        i += 1;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "Ljava/lang/Runnable;", "isOdd", "", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;Z)V", "decodeBuf", "", "()Z", "taskRunning", "getTaskRunning", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
  public final class b
    implements Runnable
  {
    private final int[] FtX;
    volatile boolean FtY;
    private final boolean FtZ;
    
    public b()
    {
      AppMethodBeat.i(196193);
      boolean bool;
      this.FtZ = bool;
      this.FtX = new int[409600];
      AppMethodBeat.o(196193);
    }
    
    public final void run()
    {
      AppMethodBeat.i(196190);
      this.FtY = true;
      int i;
      if ((z.a(z.this)) && (this.FtY))
      {
        ??? = this.FtX;
        if (this.FtZ)
        {
          i = 0;
          ???[0] = i;
          z.c(z.this).bqq("_total");
        }
      }
      for (;;)
      {
        synchronized (Boolean.valueOf(this.FtY))
        {
          for (;;)
          {
            if (!this.FtY) {
              break label172;
            }
            bool = z.a(z.this, this.FtX);
            x localx = x.aazN;
            if (bool) {
              break label146;
            }
            z.c(z.this).bqq("_fail");
            try
            {
              Thread.sleep(40L);
            }
            catch (InterruptedException localInterruptedException)
            {
              z.b(z.this);
            }
          }
          break;
          i = 1;
        }
        label146:
        z.c(z.this).bqq("_success");
        break;
        this.FtY = false;
        AppMethodBeat.o(196190);
        return;
        label172:
        boolean bool = true;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;)V", "decodeBuf", "", "decodeByteBuffer", "", "taskRunning", "", "getTaskRunning", "()Z", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
  public final class c
    implements Runnable
  {
    private final int[] FtX;
    volatile boolean FtY;
    private final byte[] Fub;
    
    public c()
    {
      AppMethodBeat.i(205240);
      this.FtX = new int[3686400];
      this.Fub = new byte[14745600];
      AppMethodBeat.o(205240);
    }
    
    public final void run()
    {
      AppMethodBeat.i(205239);
      this.FtY = true;
      if ((z.d(this.Fua)) && (z.f(this.Fua)) && (this.FtY)) {}
      for (;;)
      {
        synchronized (Boolean.valueOf(this.FtY))
        {
          for (;;)
          {
            if (!this.FtY) {
              break label152;
            }
            bool = z.a(this.Fua, this.FtX, this.Fub);
            x localx = x.aazN;
            if (bool) {
              break;
            }
            try
            {
              Thread.sleep(40L);
            }
            catch (InterruptedException localInterruptedException)
            {
              z.e(this.Fua);
            }
          }
        }
        this.FtY = false;
        Object localObject1 = com.tencent.mm.plugin.multitalk.d.d.FEN;
        com.tencent.mm.plugin.multitalk.d.d.eXV();
        localObject1 = this.Fua.FqA;
        if (localObject1 != null)
        {
          ((ae)localObject1).eYi();
          AppMethodBeat.o(205239);
          return;
        }
        AppMethodBeat.o(205239);
        return;
        label152:
        boolean bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.z
 * JD-Core Version:    0.7.0.1
 */