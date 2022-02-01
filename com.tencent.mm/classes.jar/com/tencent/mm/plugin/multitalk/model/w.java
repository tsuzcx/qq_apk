package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.c.a;
import com.tencent.mm.plugin.multitalk.c.d;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;", "Lcom/tencent/mm/plugin/multitalk/model/BaseDataSource;", "()V", "decodeTask", "", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "[Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "fpsWrapper", "Lcom/tencent/mm/pluginsdk/platformtools/FpsWraper;", "screenMemberId", "", "screenReceiver", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "screenRunning", "", "screenUserName", "", "videoRunning", "hasScreenData", "receiveScreenData", "buf", "", "byteArray", "", "receiveVideoData", "start", "", "startReceiveScreen", "userName", "stop", "stopReceiveScreen", "stopVideo", "Companion", "DecodeRunnable", "ScreenDataDecode", "plugin-multitalk_release"})
public final class w
  extends c
{
  public static final w.a wcL;
  final b[] wcE;
  volatile boolean wcF;
  private volatile boolean wcG;
  private volatile int wcH;
  volatile String wcI;
  private volatile c wcJ;
  private final com.tencent.mm.pluginsdk.i.e wcK;
  
  static
  {
    AppMethodBeat.i(206683);
    wcL = new w.a((byte)0);
    AppMethodBeat.o(206683);
  }
  
  public w()
  {
    AppMethodBeat.i(206682);
    this.wcE = new b[] { new b(true), new b(false) };
    this.wcH = -1;
    this.wcI = "";
    this.wcK = new com.tencent.mm.pluginsdk.i.e("multitalk_network");
    AppMethodBeat.o(206682);
  }
  
  public final void arB(String paramString)
  {
    AppMethodBeat.i(206680);
    p.h(paramString, "userName");
    int i = com.tencent.mm.plugin.multitalk.c.e.arI(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(206680);
      return;
    }
    if ((dqp()) || (this.wcG))
    {
      AppMethodBeat.o(206680);
      return;
    }
    this.wcG = true;
    this.wcH = i;
    this.wcI = paramString;
    paramString = com.tencent.mm.plugin.multitalk.c.e.whJ;
    if (!com.tencent.mm.plugin.multitalk.c.e.drr())
    {
      paramString = a.why;
      a.dqZ();
    }
    paramString = new c();
    new Thread((Runnable)paramString).start();
    this.wcJ = paramString;
    AppMethodBeat.o(206680);
  }
  
  final boolean dqp()
  {
    return this.wcH >= 0;
  }
  
  public final void dqq()
  {
    AppMethodBeat.i(206681);
    this.wcH = -1;
    this.wcG = false;
    if (!this.wcF) {
      this.way = null;
    }
    Object localObject1 = this.wcJ;
    if (localObject1 != null) {}
    synchronized (Boolean.valueOf(((c)localObject1).wcN))
    {
      ((c)localObject1).wcN = false;
      localObject1 = z.MKo;
      this.wcJ = null;
      AppMethodBeat.o(206681);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(206678);
    aa localaa = this.way;
    if (localaa != null) {
      localaa.dqB();
    }
    dqq();
    stopVideo();
    AppMethodBeat.o(206678);
  }
  
  public final void stopVideo()
  {
    int i = 0;
    AppMethodBeat.i(206679);
    this.wcF = false;
    if (!this.wcG) {
      this.way = null;
    }
    b[] arrayOfb = this.wcE;
    int j = arrayOfb.length;
    for (;;)
    {
      Object localObject2;
      if (i < j) {
        localObject2 = arrayOfb[i];
      }
      synchronized (Boolean.valueOf(((b)localObject2).wcN))
      {
        ((b)localObject2).wcN = false;
        localObject2 = z.MKo;
        i += 1;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "Ljava/lang/Runnable;", "isOdd", "", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;Z)V", "decodeBuf", "", "()Z", "taskRunning", "getTaskRunning", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
  public final class b
    implements Runnable
  {
    private final int[] wcM;
    volatile boolean wcN;
    private final boolean wcO;
    
    public b()
    {
      AppMethodBeat.i(206675);
      boolean bool;
      this.wcO = bool;
      this.wcM = new int[409600];
      AppMethodBeat.o(206675);
    }
    
    public final void run()
    {
      AppMethodBeat.i(206674);
      this.wcN = true;
      int i;
      if ((w.a(w.this)) && (this.wcN))
      {
        ??? = this.wcM;
        if (this.wcO)
        {
          i = 0;
          ???[0] = i;
          w.c(w.this).aLW("_total");
        }
      }
      for (;;)
      {
        synchronized (Boolean.valueOf(this.wcN))
        {
          for (;;)
          {
            if (!this.wcN) {
              break label172;
            }
            bool = w.a(w.this, this.wcM);
            z localz = z.MKo;
            if (bool) {
              break label146;
            }
            w.c(w.this).aLW("_fail");
            try
            {
              Thread.sleep(40L);
            }
            catch (InterruptedException localInterruptedException)
            {
              w.b(w.this);
            }
          }
          break;
          i = 1;
        }
        label146:
        w.c(w.this).aLW("_success");
        break;
        this.wcN = false;
        AppMethodBeat.o(206674);
        return;
        label172:
        boolean bool = true;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;)V", "decodeBuf", "", "decodeByteBuffer", "", "taskRunning", "", "getTaskRunning", "()Z", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
  public final class c
    implements Runnable
  {
    private final int[] wcM;
    volatile boolean wcN;
    private final byte[] wcQ;
    
    public c()
    {
      AppMethodBeat.i(206677);
      this.wcM = new int[2073600];
      this.wcQ = new byte[8294400];
      AppMethodBeat.o(206677);
    }
    
    public final void run()
    {
      AppMethodBeat.i(206676);
      this.wcN = true;
      if ((w.d(this.wcP)) && (w.f(this.wcP)) && (this.wcN)) {}
      for (;;)
      {
        synchronized (Boolean.valueOf(this.wcN))
        {
          for (;;)
          {
            if (!this.wcN) {
              break label152;
            }
            bool = w.a(this.wcP, this.wcM, this.wcQ);
            z localz = z.MKo;
            if (bool) {
              break;
            }
            try
            {
              Thread.sleep(40L);
            }
            catch (InterruptedException localInterruptedException)
            {
              w.e(this.wcP);
            }
          }
        }
        this.wcN = false;
        Object localObject1 = d.whH;
        d.dqq();
        localObject1 = this.wcP.way;
        if (localObject1 != null)
        {
          ((aa)localObject1).dqC();
          AppMethodBeat.o(206676);
          return;
        }
        AppMethodBeat.o(206676);
        return;
        label152:
        boolean bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.w
 * JD-Core Version:    0.7.0.1
 */