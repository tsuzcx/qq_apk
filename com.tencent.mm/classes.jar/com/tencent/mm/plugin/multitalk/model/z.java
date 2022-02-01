package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.a;
import com.tencent.mm.plugin.multitalk.d.e;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.common.b.a.a.a.aq;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;", "Lcom/tencent/mm/plugin/multitalk/model/BaseDataSource;", "()V", "decodeTask", "", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "[Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "fpsWrapper", "Lcom/tencent/mm/pluginsdk/platformtools/FpsWraper;", "screenMemberId", "", "screenReceiver", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "screenRunning", "", "screenUserName", "", "videoRunning", "checkCurrentIsReceiver", "hasScreenData", "receiveScreenData", "buf", "", "byteArray", "", "receiveVideoData", "start", "", "startReceiveScreen", "userName", "stop", "stopReceiveScreen", "stopVideo", "Companion", "DecodeRunnable", "ScreenDataDecode", "plugin-multitalk_release"})
public final class z
  extends c
{
  public static final z.a zOz;
  private final b[] zOs;
  public volatile boolean zOt;
  public volatile boolean zOu;
  private volatile int zOv;
  private volatile String zOw;
  private volatile c zOx;
  private final b zOy;
  
  static
  {
    AppMethodBeat.i(239663);
    zOz = new z.a((byte)0);
    AppMethodBeat.o(239663);
  }
  
  public z()
  {
    AppMethodBeat.i(239662);
    this.zOs = new b[] { new b(true), new b(false) };
    this.zOv = -1;
    this.zOw = "";
    this.zOy = new b("multitalk_network");
    AppMethodBeat.o(239662);
  }
  
  private final boolean eoe()
  {
    return this.zOv >= 0;
  }
  
  public final void aGm(String paramString)
  {
    AppMethodBeat.i(239660);
    p.h(paramString, "userName");
    int i = e.aGF(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(239660);
      return;
    }
    if ((eoe()) || (this.zOu))
    {
      AppMethodBeat.o(239660);
      return;
    }
    this.zOu = true;
    this.zOv = i;
    ArrayList localArrayList = new ArrayList();
    Object localObject = new a.aq();
    ((a.aq)localObject).qrD = i;
    localArrayList.add(localObject);
    localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN).putInt(i);
    o localo = ac.eol();
    p.g(localo, "SubCoreMultiTalk.getMultiEngine()");
    localo.emG().setAppCmd(55, ((ByteBuffer)localObject).array(), 4);
    localObject = ac.eol();
    p.g(localObject, "SubCoreMultiTalk.getMultiEngine()");
    ((o)localObject).emG().kc((List)localArrayList);
    this.zOw = paramString;
    paramString = e.zZc;
    if (!e.eqe())
    {
      paramString = a.zYP;
      a.epL();
    }
    paramString = new c();
    new Thread((Runnable)paramString).start();
    this.zOx = paramString;
    AppMethodBeat.o(239660);
  }
  
  public final void eof()
  {
    AppMethodBeat.i(239661);
    ??? = ByteBuffer.allocate(4);
    ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN).putInt(-1);
    Object localObject2 = ac.eol();
    p.g(localObject2, "SubCoreMultiTalk.getMultiEngine()");
    ((o)localObject2).emG().setAppCmd(55, ((ByteBuffer)???).array(), 4);
    ??? = ac.eol();
    p.g(???, "SubCoreMultiTalk.getMultiEngine()");
    ((o)???).emG().kc((List)new ArrayList());
    this.zOv = -1;
    this.zOu = false;
    if (!this.zOt) {
      this.zLj = null;
    }
    localObject2 = this.zOx;
    if (localObject2 != null) {}
    synchronized (Boolean.valueOf(((c)localObject2).zOB))
    {
      ((c)localObject2).zOB = false;
      localObject2 = x.SXb;
      this.zOx = null;
      AppMethodBeat.o(239661);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(239657);
    if (this.zOt)
    {
      AppMethodBeat.o(239657);
      return;
    }
    Log.i("NetworkDataSource", "start");
    this.zOt = true;
    b[] arrayOfb = this.zOs;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfb[i];
      synchronized (Boolean.valueOf(((b)localObject2).zOB))
      {
        if (!((b)localObject2).zOB)
        {
          ((b)localObject2).zOB = true;
          new Thread((Runnable)localObject2).start();
        }
        localObject2 = x.SXb;
        i += 1;
      }
    }
    if (eoe()) {
      aGm(this.zOw);
    }
    AppMethodBeat.o(239657);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(239658);
    eof();
    stopVideo();
    AppMethodBeat.o(239658);
  }
  
  public final void stopVideo()
  {
    int i = 0;
    AppMethodBeat.i(239659);
    this.zOt = false;
    if (!this.zOu) {
      this.zLj = null;
    }
    b[] arrayOfb = this.zOs;
    int j = arrayOfb.length;
    for (;;)
    {
      Object localObject2;
      if (i < j) {
        localObject2 = arrayOfb[i];
      }
      synchronized (Boolean.valueOf(((b)localObject2).zOB))
      {
        ((b)localObject2).zOB = false;
        localObject2 = x.SXb;
        i += 1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "Ljava/lang/Runnable;", "isOdd", "", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;Z)V", "decodeBuf", "", "()Z", "taskRunning", "getTaskRunning", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
  public final class b
    implements Runnable
  {
    private final int[] zOA;
    volatile boolean zOB;
    private final boolean zOC;
    
    public b()
    {
      AppMethodBeat.i(239654);
      boolean bool;
      this.zOC = bool;
      this.zOA = new int[409600];
      AppMethodBeat.o(239654);
    }
    
    public final void run()
    {
      AppMethodBeat.i(239653);
      this.zOB = true;
      int i;
      if ((z.a(z.this)) && (this.zOB))
      {
        ??? = this.zOA;
        if (this.zOC)
        {
          i = 0;
          ???[0] = i;
          z.c(z.this).bdU("_total");
        }
      }
      for (;;)
      {
        synchronized (Boolean.valueOf(this.zOB))
        {
          for (;;)
          {
            if (!this.zOB) {
              break label172;
            }
            bool = z.a(z.this, this.zOA);
            x localx = x.SXb;
            if (bool) {
              break label146;
            }
            z.c(z.this).bdU("_fail");
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
        z.c(z.this).bdU("_success");
        break;
        this.zOB = false;
        AppMethodBeat.o(239653);
        return;
        label172:
        boolean bool = true;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;)V", "decodeBuf", "", "decodeByteBuffer", "", "taskRunning", "", "getTaskRunning", "()Z", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
  public final class c
    implements Runnable
  {
    private final int[] zOA;
    volatile boolean zOB;
    private final byte[] zOE;
    
    public c()
    {
      AppMethodBeat.i(239656);
      this.zOA = new int[3686400];
      this.zOE = new byte[14745600];
      AppMethodBeat.o(239656);
    }
    
    public final void run()
    {
      AppMethodBeat.i(239655);
      this.zOB = true;
      if ((z.d(this.zOD)) && (z.f(this.zOD)) && (this.zOB)) {}
      for (;;)
      {
        synchronized (Boolean.valueOf(this.zOB))
        {
          for (;;)
          {
            if (!this.zOB) {
              break label152;
            }
            bool = z.a(this.zOD, this.zOA, this.zOE);
            x localx = x.SXb;
            if (bool) {
              break;
            }
            try
            {
              Thread.sleep(40L);
            }
            catch (InterruptedException localInterruptedException)
            {
              z.e(this.zOD);
            }
          }
        }
        this.zOB = false;
        Object localObject1 = com.tencent.mm.plugin.multitalk.d.d.zZa;
        com.tencent.mm.plugin.multitalk.d.d.eof();
        localObject1 = this.zOD.zLj;
        if (localObject1 != null)
        {
          ((ad)localObject1).eos();
          AppMethodBeat.o(239655);
          return;
        }
        AppMethodBeat.o(239655);
        return;
        label152:
        boolean bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.z
 * JD-Core Version:    0.7.0.1
 */