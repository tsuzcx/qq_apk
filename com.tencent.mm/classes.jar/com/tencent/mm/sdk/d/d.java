package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

public class d
{
  public volatile c IgU;
  volatile HandlerThread IgV;
  public String mName;
  
  protected d(String paramString, Looper paramLooper)
  {
    AppMethodBeat.i(158037);
    this.mName = paramString;
    this.IgU = new c(paramLooper, this, (byte)0);
    AppMethodBeat.o(158037);
  }
  
  private Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(158044);
    Message localMessage = Message.obtain(this.IgU, paramInt);
    AppMethodBeat.o(158044);
    return localMessage;
  }
  
  protected void LT(String paramString) {}
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(158038);
    c.a(this.IgU, paramc);
    AppMethodBeat.o(158038);
  }
  
  protected void aZP() {}
  
  public final void aaA(int paramInt)
  {
    AppMethodBeat.i(158046);
    c localc = this.IgU;
    if (localc == null)
    {
      AppMethodBeat.o(158046);
      return;
    }
    localc.sendMessage(obtainMessage(paramInt));
    AppMethodBeat.o(158046);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(158042);
    c.a(this.IgU, parama);
    AppMethodBeat.o(158042);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(158039);
    c.b(this.IgU, paramc);
    AppMethodBeat.o(158039);
  }
  
  protected final Message fme()
  {
    AppMethodBeat.i(158040);
    Object localObject = this.IgU;
    if (localObject == null)
    {
      AppMethodBeat.o(158040);
      return null;
    }
    localObject = c.b((c)localObject);
    AppMethodBeat.o(158040);
    return localObject;
  }
  
  public final a fmf()
  {
    AppMethodBeat.i(158041);
    Object localObject = this.IgU;
    if (localObject == null)
    {
      AppMethodBeat.o(158041);
      return null;
    }
    localObject = c.c((c)localObject);
    AppMethodBeat.o(158041);
    return localObject;
  }
  
  protected boolean i(Message paramMessage)
  {
    return true;
  }
  
  protected void j(Message paramMessage)
  {
    AppMethodBeat.i(158043);
    if (c.d(this.IgU)) {
      LT(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
    AppMethodBeat.o(158043);
  }
  
  protected void log(String paramString) {}
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158045);
    paramObject = Message.obtain(this.IgU, paramInt, paramObject);
    AppMethodBeat.o(158045);
    return paramObject;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(158048);
    c localc = this.IgU;
    if (localc == null)
    {
      AppMethodBeat.o(158048);
      return;
    }
    c.e(localc);
    AppMethodBeat.o(158048);
  }
  
  public final void r(Message paramMessage)
  {
    AppMethodBeat.i(194962);
    c localc = this.IgU;
    if (localc == null)
    {
      AppMethodBeat.o(194962);
      return;
    }
    localc.sendMessage(paramMessage);
    AppMethodBeat.o(194962);
  }
  
  public void start()
  {
    AppMethodBeat.i(158051);
    c localc = this.IgU;
    if (localc == null)
    {
      AppMethodBeat.o(158051);
      return;
    }
    c.g(localc);
    AppMethodBeat.o(158051);
  }
  
  public final void wM(boolean paramBoolean)
  {
    AppMethodBeat.i(158050);
    c localc = this.IgU;
    if (localc == null)
    {
      AppMethodBeat.o(158050);
      return;
    }
    c.a(localc, paramBoolean);
    AppMethodBeat.o(158050);
  }
  
  public static final class c
    extends Handler
  {
    private static final Object Ihi;
    private d IgW;
    private boolean Ihg;
    private boolean Ihh;
    private Message Ihj;
    private d.b Ihk;
    private boolean Ihl;
    private c[] Ihm;
    private int Ihn;
    private c[] Iho;
    private int Ihp;
    private a Ihq;
    private b Ihr;
    private HashMap<c, c> Ihs;
    private c Iht;
    private c Ihu;
    private ArrayList<Message> Ihv;
    
    static
    {
      AppMethodBeat.i(158036);
      Ihi = new Object();
      AppMethodBeat.o(158036);
    }
    
    private c(Looper paramLooper, d paramd)
    {
      super();
      AppMethodBeat.i(158027);
      this.Ihg = false;
      this.Ihh = false;
      this.Ihk = new d.b((byte)0);
      this.Ihn = -1;
      this.Ihq = new a((byte)0);
      this.Ihr = new b((byte)0);
      this.Ihs = new HashMap();
      this.Ihv = new ArrayList();
      this.IgW = paramd;
      c(this.Ihq);
      c(this.Ihr);
      AppMethodBeat.o(158027);
    }
    
    private void a(c paramc, Message paramMessage)
    {
      AppMethodBeat.i(158020);
      Object localObject = this.Ihm[this.Ihn].Ihx;
      int i;
      if ((this.IgW.i(this.Ihj)) && (paramMessage.obj != Ihi))
      {
        i = 1;
        if (!this.Ihk.fmg()) {
          break label255;
        }
        if (this.Ihu != null) {
          this.Ihk.b(this.IgW, this.Ihj, "", paramc, (a)localObject, this.Ihu);
        }
      }
      for (;;)
      {
        paramc = this.Ihu;
        if (paramc == null) {
          break label405;
        }
        for (;;)
        {
          if (this.Ihh) {
            this.IgW.log("handleMessage: new destination call exit/enter");
          }
          this.Ihp = 0;
          paramMessage = (c)this.Ihs.get(paramc);
          do
          {
            localObject = this.Iho;
            i = this.Ihp;
            this.Ihp = (i + 1);
            localObject[i] = paramMessage;
            localObject = paramMessage.Ihy;
            if (localObject == null) {
              break;
            }
            paramMessage = (Message)localObject;
          } while (!((c)localObject).active);
          if (this.Ihh) {
            this.IgW.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.Ihp + ",curStateInfo: " + localObject);
          }
          a((c)localObject);
          aaB(fmi());
          fmh();
          if (paramc == this.Ihu) {
            break;
          }
          paramc = this.Ihu;
        }
        i = 0;
        break;
        label255:
        if (i != 0) {
          this.Ihk.b(this.IgW, this.Ihj, "", paramc, (a)localObject, this.Ihu);
        }
      }
      this.Ihu = null;
      label405:
      for (;;)
      {
        if ((paramc != null) && (paramc == this.Ihr))
        {
          this.IgW.aZP();
          if (this.IgW.IgV != null)
          {
            getLooper().quit();
            this.IgW.IgV = null;
          }
          this.IgW.IgU = null;
          this.IgW = null;
          this.Ihj = null;
          this.Ihk.cleanup();
          this.Ihm = null;
          this.Iho = null;
          this.Ihs.clear();
          this.Iht = null;
          this.Ihu = null;
          this.Ihv.clear();
          this.Ihg = true;
        }
        AppMethodBeat.o(158020);
        return;
      }
    }
    
    private final void a(c paramc)
    {
      AppMethodBeat.i(158022);
      while ((this.Ihn >= 0) && (this.Ihm[this.Ihn] != paramc))
      {
        c localc = this.Ihm[this.Ihn].Ihx;
        if (this.Ihh) {
          this.IgW.log("invokeExitMethods: " + localc.getName());
        }
        localc.exit();
        this.Ihm[this.Ihn].active = false;
        this.Ihn -= 1;
      }
      AppMethodBeat.o(158022);
    }
    
    private final void aaB(int paramInt)
    {
      AppMethodBeat.i(158023);
      while (paramInt <= this.Ihn)
      {
        if (this.Ihh) {
          this.IgW.log("invokeEnterMethods: " + this.Ihm[paramInt].Ihx.getName());
        }
        this.Ihm[paramInt].Ihx.enter();
        this.Ihm[paramInt].active = true;
        paramInt += 1;
      }
      AppMethodBeat.o(158023);
    }
    
    private final void b(a parama)
    {
      AppMethodBeat.i(158028);
      this.Ihu = ((c)parama);
      if (this.Ihh) {
        this.IgW.log("transitionTo: destState=" + this.Ihu.getName());
      }
      AppMethodBeat.o(158028);
    }
    
    private final c c(c paramc)
    {
      AppMethodBeat.i(158026);
      if (this.Ihh) {
        this.IgW.log("addStateInternal: E state=" + paramc.getName() + ",parent=");
      }
      c localc2 = (c)this.Ihs.get(paramc);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c((byte)0);
        this.Ihs.put(paramc, localc1);
      }
      if ((localc1.Ihy != null) && (localc1.Ihy != null))
      {
        paramc = new RuntimeException("state already added");
        AppMethodBeat.o(158026);
        throw paramc;
      }
      localc1.Ihx = paramc;
      localc1.Ihy = null;
      localc1.active = false;
      if (this.Ihh) {
        this.IgW.log("addStateInternal: X stateInfo: ".concat(String.valueOf(localc1)));
      }
      AppMethodBeat.o(158026);
      return localc1;
    }
    
    private final void fmh()
    {
      AppMethodBeat.i(158024);
      int i = this.Ihv.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.Ihv.get(i);
        if (this.Ihh) {
          this.IgW.log("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
        }
        sendMessageAtFrontOfQueue(localMessage);
        i -= 1;
      }
      this.Ihv.clear();
      AppMethodBeat.o(158024);
    }
    
    private final int fmi()
    {
      AppMethodBeat.i(158025);
      int k = this.Ihn + 1;
      int i = this.Ihp - 1;
      int j = k;
      while (i >= 0)
      {
        if (this.Ihh) {
          this.IgW.log("moveTempStackToStateStack: i=" + i + ",j=" + j);
        }
        this.Ihm[j] = this.Iho[i];
        j += 1;
        i -= 1;
      }
      this.Ihn = (j - 1);
      if (this.Ihh) {
        this.IgW.log("moveTempStackToStateStack: X mStateStackTop=" + this.Ihn + ",startingIndex=" + k + ",Top=" + this.Ihm[this.Ihn].Ihx.getName());
      }
      AppMethodBeat.o(158025);
      return k;
    }
    
    private final c s(Message paramMessage)
    {
      AppMethodBeat.i(158021);
      Object localObject2 = this.Ihm[this.Ihn];
      if (this.Ihh) {
        this.IgW.log("processMsg: " + ((c)localObject2).Ihx.getName());
      }
      int i;
      Object localObject1;
      if ((paramMessage.what == -1) && (paramMessage.obj == Ihi))
      {
        i = 1;
        localObject1 = localObject2;
        if (i == 0) {
          break label158;
        }
        b(this.Ihr);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label194;
        }
        paramMessage = ((c)localObject2).Ihx;
        AppMethodBeat.o(158021);
        return paramMessage;
        i = 0;
        break;
        label158:
        do
        {
          localObject1 = localObject2;
          if (this.Ihh)
          {
            this.IgW.log("processMsg: " + ((c)localObject2).Ihx.getName());
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1.Ihx.k(paramMessage)) {
            break;
          }
          localObject2 = localObject1.Ihy;
        } while (localObject2 != null);
        this.IgW.j(paramMessage);
      }
      label194:
      AppMethodBeat.o(158021);
      return null;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(158019);
      c localc;
      if (!this.Ihg)
      {
        if (this.Ihh) {
          this.IgW.log("handleMessage: E msg.what=" + paramMessage.what);
        }
        this.Ihj = paramMessage;
        localc = null;
        if (!this.Ihl) {
          break label104;
        }
        localc = s(paramMessage);
      }
      for (;;)
      {
        a(localc, paramMessage);
        if ((this.Ihh) && (this.IgW != null)) {
          this.IgW.log("handleMessage: X");
        }
        AppMethodBeat.o(158019);
        return;
        label104:
        if ((this.Ihl) || (this.Ihj.what != -2) || (this.Ihj.obj != Ihi)) {
          break;
        }
        this.Ihl = true;
        aaB(0);
      }
      paramMessage = new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: ".concat(String.valueOf(paramMessage)));
      AppMethodBeat.o(158019);
      throw paramMessage;
    }
    
    final class a
      extends c
    {
      private a() {}
      
      public final boolean k(Message paramMessage)
      {
        AppMethodBeat.i(158017);
        AppMethodBeat.o(158017);
        return true;
      }
    }
    
    final class b
      extends c
    {
      private b() {}
      
      public final boolean k(Message paramMessage)
      {
        return false;
      }
    }
    
    final class c
    {
      c Ihx;
      c Ihy;
      boolean active;
      
      private c() {}
      
      public final String toString()
      {
        AppMethodBeat.i(158018);
        StringBuilder localStringBuilder = new StringBuilder("state=").append(this.Ihx.getName()).append(",active=").append(this.active).append(",parent=");
        if (this.Ihy == null) {}
        for (String str = "null";; str = this.Ihy.Ihx.getName())
        {
          str = str;
          AppMethodBeat.o(158018);
          return str;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d
 * JD-Core Version:    0.7.0.1
 */