package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.e.a;
import com.tencent.mm.plugin.multitalk.e.e;
import com.tencent.mm.plugin.multitalk.e.f;
import com.tencent.mm.pluginsdk.platformtools.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.talkroom.sdk.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;", "Lcom/tencent/mm/plugin/multitalk/model/BaseDataSource;", "()V", "decodeTask", "", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "[Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "fpsWrapper", "Lcom/tencent/mm/pluginsdk/platformtools/FpsWraper;", "screenMemberId", "", "screenReceiver", "Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "screenRunning", "", "screenUserName", "", "videoRunning", "checkCurrentIsReceiver", "hasScreenData", "receiveScreenData", "buf", "", "byteArray", "", "receiveVideoData", "start", "", "startReceiveScreen", "userName", "stop", "stopReceiveScreen", "stopVideo", "Companion", "DecodeRunnable", "ScreenDataDecode", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends c
{
  public static final y.a Lqi;
  private final b[] Lqj;
  public volatile boolean Lqk;
  public volatile boolean Lql;
  private volatile int Lqm;
  private volatile String Lqn;
  private volatile c Lqo;
  private final b Lqp;
  
  static
  {
    AppMethodBeat.i(284770);
    Lqi = new y.a((byte)0);
    AppMethodBeat.o(284770);
  }
  
  public y()
  {
    AppMethodBeat.i(284732);
    this.Lqj = new b[] { new b(true), new b(false) };
    this.Lqm = -1;
    this.Lqn = "";
    this.Lqp = new b("multitalk_network");
    AppMethodBeat.o(284732);
  }
  
  private final boolean ggJ()
  {
    return this.Lqm >= 0;
  }
  
  public final void aNt(String paramString)
  {
    AppMethodBeat.i(284797);
    s.u(paramString, "userName");
    int i = f.aNL(paramString);
    if (i == -1)
    {
      AppMethodBeat.o(284797);
      return;
    }
    if ((ggJ()) || (this.Lql))
    {
      AppMethodBeat.o(284797);
      return;
    }
    this.Lql = true;
    this.Lqm = i;
    Object localObject1 = new ArrayList();
    Object localObject2 = new a.ap();
    ((a.ap)localObject2).wTC = i;
    ah localah = ah.aiuX;
    ((ArrayList)localObject1).add(localObject2);
    localObject2 = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject2).order(ByteOrder.LITTLE_ENDIAN).putInt(i);
    ac.ggR().LnJ.setAppCmd(55, ((ByteBuffer)localObject2).array(), 4);
    ac.ggR().LnJ.ot((List)localObject1);
    this.Lqn = paramString;
    paramString = f.LAR;
    if (!f.gja())
    {
      paramString = a.LAn;
      a.giA();
    }
    paramString = new c();
    new Thread((Runnable)paramString).start();
    localObject1 = ah.aiuX;
    this.Lqo = paramString;
    AppMethodBeat.o(284797);
  }
  
  public final void ggK()
  {
    AppMethodBeat.i(284803);
    ??? = ByteBuffer.allocate(4);
    ((ByteBuffer)???).order(ByteOrder.LITTLE_ENDIAN).putInt(-1);
    ac.ggR().LnJ.setAppCmd(55, ((ByteBuffer)???).array(), 4);
    ac.ggR().LnJ.ot((List)new ArrayList());
    this.Lqm = -1;
    this.Lql = false;
    if (!this.Lqk) {
      this.LmK = null;
    }
    Object localObject2 = this.Lqo;
    if (localObject2 != null) {}
    synchronized (Boolean.valueOf(((c)localObject2).Lqs))
    {
      ((c)localObject2).Lqs = false;
      localObject2 = ah.aiuX;
      this.Lqo = null;
      AppMethodBeat.o(284803);
      return;
    }
  }
  
  public final void start()
  {
    AppMethodBeat.i(284778);
    if (this.Lqk)
    {
      AppMethodBeat.o(284778);
      return;
    }
    Log.i("NetworkDataSource", "start");
    this.Lqk = true;
    b[] arrayOfb = this.Lqj;
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = arrayOfb[i];
      synchronized (Boolean.valueOf(((b)localObject2).Lqs))
      {
        if (!((b)localObject2).Lqs)
        {
          ((b)localObject2).Lqs = true;
          new Thread((Runnable)localObject2).start();
        }
        localObject2 = ah.aiuX;
        i += 1;
      }
    }
    if (ggJ()) {
      aNt(this.Lqn);
    }
    AppMethodBeat.o(284778);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(284784);
    ggK();
    stopVideo();
    AppMethodBeat.o(284784);
  }
  
  public final void stopVideo()
  {
    int i = 0;
    AppMethodBeat.i(284788);
    this.Lqk = false;
    if (!this.Lql) {
      this.LmK = null;
    }
    b[] arrayOfb = this.Lqj;
    int j = arrayOfb.length;
    for (;;)
    {
      Object localObject2;
      if (i < j) {
        localObject2 = arrayOfb[i];
      }
      synchronized (Boolean.valueOf(((b)localObject2).Lqs))
      {
        ((b)localObject2).Lqs = false;
        localObject2 = ah.aiuX;
        i += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$DecodeRunnable;", "Ljava/lang/Runnable;", "isOdd", "", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;Z)V", "decodeBuf", "", "()Z", "taskRunning", "getTaskRunning", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements Runnable
  {
    private final boolean Lqq;
    private final int[] Lqr;
    volatile boolean Lqs;
    
    public b()
    {
      AppMethodBeat.i(284746);
      boolean bool;
      this.Lqq = bool;
      this.Lqr = new int[409600];
      AppMethodBeat.o(284746);
    }
    
    public final void run()
    {
      AppMethodBeat.i(284750);
      this.Lqs = true;
      Object localObject1;
      int i;
      label41:
      Object localObject2;
      if ((y.a(y.this)) && (this.Lqs))
      {
        localObject1 = this.Lqr;
        if (this.Lqq)
        {
          i = 0;
          localObject1[0] = i;
          y.b(y.this).bqd("_total");
          localObject1 = Boolean.valueOf(this.Lqs);
          localObject2 = y.this;
        }
      }
      for (;;)
      {
        try
        {
          for (;;)
          {
            if (!this.Lqs) {
              break label176;
            }
            bool = y.a((y)localObject2, this.Lqr);
            localObject2 = ah.aiuX;
            if (bool) {
              break label150;
            }
            y.b(y.this).bqd("_fail");
            try
            {
              Thread.sleep(40L);
            }
            catch (InterruptedException localInterruptedException)
            {
              y.c(y.this);
            }
          }
          break;
        }
        finally
        {
          AppMethodBeat.o(284750);
        }
        i = 1;
        break label41;
        label150:
        y.b(y.this).bqd("_success");
        break;
        this.Lqs = false;
        AppMethodBeat.o(284750);
        return;
        label176:
        boolean bool = true;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource$ScreenDataDecode;", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/multitalk/model/NetworkDataSource;)V", "decodeBuf", "", "decodeByteBuffer", "", "taskRunning", "", "getTaskRunning", "()Z", "setTaskRunning", "(Z)V", "run", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements Runnable
  {
    private final int[] Lqr;
    volatile boolean Lqs;
    private final byte[] Lqu;
    
    public c()
    {
      AppMethodBeat.i(284733);
      this.Lqr = new int[3686400];
      this.Lqu = new byte[14745600];
      AppMethodBeat.o(284733);
    }
    
    public final void run()
    {
      AppMethodBeat.i(284740);
      this.Lqs = true;
      Boolean localBoolean;
      Object localObject2;
      if ((y.d(this.Lqt)) && (y.e(this.Lqt)) && (this.Lqs))
      {
        localBoolean = Boolean.valueOf(this.Lqs);
        localObject2 = this.Lqt;
      }
      for (;;)
      {
        try
        {
          for (;;)
          {
            if (!this.Lqs) {
              break label224;
            }
            bool = y.a((y)localObject2, this.Lqr, this.Lqu);
            localObject2 = ah.aiuX;
            if (bool) {
              break;
            }
            try
            {
              Thread.sleep(40L);
            }
            catch (InterruptedException localInterruptedException)
            {
              y.f(this.Lqt);
            }
          }
          break;
        }
        finally
        {
          AppMethodBeat.o(284740);
        }
        this.Lqs = false;
        Object localObject1 = e.LAH;
        long l;
        if (e.LAQ == 1)
        {
          l = System.currentTimeMillis() - e.LAL;
          e.LAN += l;
          e.LAM = l + e.LAM;
        }
        for (;;)
        {
          localObject1 = this.Lqt.LmK;
          if (localObject1 != null) {
            ((ad)localObject1).ggY();
          }
          AppMethodBeat.o(284740);
          return;
          if (e.LAQ == 2)
          {
            l = System.currentTimeMillis() - e.LAL;
            e.LAP += l;
            e.LAM = l + e.LAM;
          }
        }
        label224:
        boolean bool = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.y
 * JD-Core Version:    0.7.0.1
 */