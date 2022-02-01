package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.d.a;
import com.tencent.mm.plugin.multitalk.d.d;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;", "Lcom/tencent/mm/plugin/multitalk/model/BaseDataSource;", "()V", "decodeTask", "", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "[Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "fpsWrapper", "Lcom/tencent/mm/pluginsdk/platformtools/FpsWraper;", "screenMemberId", "", "screenReceiver", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "screenRunning", "", "screenUserName", "", "videoRunning", "hasScreenData", "receiveScreenData", "buf", "", "byteArray", "", "receiveVideoData", "start", "", "startReceiveScreen", "userName", "stop", "stopReceiveScreen", "stopVideo", "Companion", "DecodeRunnable", "ScreenDataDecode", "plugin-multitalk_release"})
public final class w
  extends c
{
  public static final w.a wsn;
  final b[] wsg;
  volatile boolean wsh;
  private volatile boolean wsi;
  private volatile int wsj;
  volatile String wsk;
  private volatile c wsl;
  private final com.tencent.mm.pluginsdk.i.e wsm;
  
  static
  {
    AppMethodBeat.i(190953);
    wsn = new w.a((byte)0);
    AppMethodBeat.o(190953);
  }
  
  public w()
  {
    AppMethodBeat.i(190952);
    this.wsg = new b[] { new b(true), new b(false) };
    this.wsj = -1;
    this.wsk = "";
    this.wsm = new com.tencent.mm.pluginsdk.i.e("multitalk_network");
    AppMethodBeat.o(190952);
  }
  
  public final void asN(String paramString)
  {
    AppMethodBeat.i(190950);
    p.h(paramString, "userName");
    int i = com.tencent.mm.plugin.multitalk.d.e.asV(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(190950);
      return;
    }
    if ((dtC()) || (this.wsi))
    {
      AppMethodBeat.o(190950);
      return;
    }
    this.wsi = true;
    this.wsj = i;
    this.wsk = paramString;
    paramString = com.tencent.mm.plugin.multitalk.d.e.wxn;
    if (!com.tencent.mm.plugin.multitalk.d.e.duD())
    {
      paramString = a.wxc;
      a.dul();
    }
    paramString = new c();
    new Thread((Runnable)paramString).start();
    this.wsl = paramString;
    AppMethodBeat.o(190950);
  }
  
  final boolean dtC()
  {
    return this.wsj >= 0;
  }
  
  public final void dtD()
  {
    AppMethodBeat.i(190951);
    this.wsj = -1;
    this.wsi = false;
    if (!this.wsh) {
      this.wpX = null;
    }
    Object localObject1 = this.wsl;
    if (localObject1 != null) {}
    synchronized (Boolean.valueOf(((c)localObject1).wsp))
    {
      ((c)localObject1).wsp = false;
      localObject1 = z.Nhr;
      this.wsl = null;
      AppMethodBeat.o(190951);
      return;
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(190948);
    aa localaa = this.wpX;
    if (localaa != null) {
      localaa.dtO();
    }
    dtD();
    stopVideo();
    AppMethodBeat.o(190948);
  }
  
  public final void stopVideo()
  {
    int i = 0;
    AppMethodBeat.i(190949);
    this.wsh = false;
    if (!this.wsi) {
      this.wpX = null;
    }
    b[] arrayOfb = this.wsg;
    int j = arrayOfb.length;
    for (;;)
    {
      Object localObject2;
      if (i < j) {
        localObject2 = arrayOfb[i];
      }
      synchronized (Boolean.valueOf(((b)localObject2).wsp))
      {
        ((b)localObject2).wsp = false;
        localObject2 = z.Nhr;
        i += 1;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "Ljava/lang/Runnable;", "isOdd", "", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;Z)V", "decodeBuf", "", "()Z", "taskRunning", "getTaskRunning", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
  public final class b
    implements Runnable
  {
    private final int[] wso;
    volatile boolean wsp;
    private final boolean wsq;
    
    public b()
    {
      AppMethodBeat.i(190945);
      boolean bool;
      this.wsq = bool;
      this.wso = new int[409600];
      AppMethodBeat.o(190945);
    }
    
    public final void run()
    {
      AppMethodBeat.i(190944);
      this.wsp = true;
      int i;
      if ((w.a(w.this)) && (this.wsp))
      {
        ??? = this.wso;
        if (this.wsq)
        {
          i = 0;
          ???[0] = i;
          w.c(w.this).aNs("_total");
        }
      }
      for (;;)
      {
        synchronized (Boolean.valueOf(this.wsp))
        {
          for (;;)
          {
            if (!this.wsp) {
              break label172;
            }
            bool = w.a(w.this, this.wso);
            z localz = z.Nhr;
            if (bool) {
              break label146;
            }
            w.c(w.this).aNs("_fail");
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
        w.c(w.this).aNs("_success");
        break;
        this.wsp = false;
        AppMethodBeat.o(190944);
        return;
        label172:
        boolean bool = true;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;)V", "decodeBuf", "", "decodeByteBuffer", "", "taskRunning", "", "getTaskRunning", "()Z", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"})
  public final class c
    implements Runnable
  {
    private final int[] wso;
    volatile boolean wsp;
    private final byte[] wss;
    
    public c()
    {
      AppMethodBeat.i(190947);
      this.wso = new int[2073600];
      this.wss = new byte[8294400];
      AppMethodBeat.o(190947);
    }
    
    public final void run()
    {
      AppMethodBeat.i(190946);
      this.wsp = true;
      if ((w.d(this.wsr)) && (w.f(this.wsr)) && (this.wsp)) {}
      for (;;)
      {
        synchronized (Boolean.valueOf(this.wsp))
        {
          for (;;)
          {
            if (!this.wsp) {
              break label152;
            }
            bool = w.a(this.wsr, this.wso, this.wss);
            z localz = z.Nhr;
            if (bool) {
              break;
            }
            try
            {
              Thread.sleep(40L);
            }
            catch (InterruptedException localInterruptedException)
            {
              w.e(this.wsr);
            }
          }
        }
        this.wsp = false;
        Object localObject1 = d.wxl;
        d.dtD();
        localObject1 = this.wsr.wpX;
        if (localObject1 != null)
        {
          ((aa)localObject1).dtP();
          AppMethodBeat.o(190946);
          return;
        }
        AppMethodBeat.o(190946);
        return;
        label152:
        boolean bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.w
 * JD-Core Version:    0.7.0.1
 */