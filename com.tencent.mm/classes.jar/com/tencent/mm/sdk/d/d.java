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
  public volatile c IBf;
  volatile HandlerThread IBg;
  public String mName;
  
  protected d(String paramString, Looper paramLooper)
  {
    AppMethodBeat.i(158037);
    this.mName = paramString;
    this.IBf = new c(paramLooper, this, (byte)0);
    AppMethodBeat.o(158037);
  }
  
  private Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(158044);
    Message localMessage = Message.obtain(this.IBf, paramInt);
    AppMethodBeat.o(158044);
    return localMessage;
  }
  
  protected void Mx(String paramString) {}
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(158038);
    c.a(this.IBf, paramc);
    AppMethodBeat.o(158038);
  }
  
  public final void abg(int paramInt)
  {
    AppMethodBeat.i(158046);
    c localc = this.IBf;
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
    c.a(this.IBf, parama);
    AppMethodBeat.o(158042);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(158039);
    c.b(this.IBf, paramc);
    AppMethodBeat.o(158039);
  }
  
  protected void bao() {}
  
  protected final Message fpZ()
  {
    AppMethodBeat.i(158040);
    Object localObject = this.IBf;
    if (localObject == null)
    {
      AppMethodBeat.o(158040);
      return null;
    }
    localObject = c.b((c)localObject);
    AppMethodBeat.o(158040);
    return localObject;
  }
  
  public final a fqa()
  {
    AppMethodBeat.i(158041);
    Object localObject = this.IBf;
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
    if (c.d(this.IBf)) {
      Mx(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
    AppMethodBeat.o(158043);
  }
  
  protected void log(String paramString) {}
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158045);
    paramObject = Message.obtain(this.IBf, paramInt, paramObject);
    AppMethodBeat.o(158045);
    return paramObject;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(158048);
    c localc = this.IBf;
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
    AppMethodBeat.i(200311);
    c localc = this.IBf;
    if (localc == null)
    {
      AppMethodBeat.o(200311);
      return;
    }
    localc.sendMessage(paramMessage);
    AppMethodBeat.o(200311);
  }
  
  public void start()
  {
    AppMethodBeat.i(158051);
    c localc = this.IBf;
    if (localc == null)
    {
      AppMethodBeat.o(158051);
      return;
    }
    c.g(localc);
    AppMethodBeat.o(158051);
  }
  
  public final void wU(boolean paramBoolean)
  {
    AppMethodBeat.i(158050);
    c localc = this.IBf;
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
    private static final Object IBt;
    private int IBA;
    private a IBB;
    private b IBC;
    private HashMap<c, c> IBD;
    private c IBE;
    private c IBF;
    private ArrayList<Message> IBG;
    private d IBh;
    private boolean IBr;
    private boolean IBs;
    private Message IBu;
    private d.b IBv;
    private boolean IBw;
    private c[] IBx;
    private int IBy;
    private c[] IBz;
    
    static
    {
      AppMethodBeat.i(158036);
      IBt = new Object();
      AppMethodBeat.o(158036);
    }
    
    private c(Looper paramLooper, d paramd)
    {
      super();
      AppMethodBeat.i(158027);
      this.IBr = false;
      this.IBs = false;
      this.IBv = new d.b((byte)0);
      this.IBy = -1;
      this.IBB = new a((byte)0);
      this.IBC = new b((byte)0);
      this.IBD = new HashMap();
      this.IBG = new ArrayList();
      this.IBh = paramd;
      c(this.IBB);
      c(this.IBC);
      AppMethodBeat.o(158027);
    }
    
    private void a(c paramc, Message paramMessage)
    {
      AppMethodBeat.i(158020);
      Object localObject = this.IBx[this.IBy].IBI;
      int i;
      if ((this.IBh.i(this.IBu)) && (paramMessage.obj != IBt))
      {
        i = 1;
        if (!this.IBv.fqb()) {
          break label255;
        }
        if (this.IBF != null) {
          this.IBv.b(this.IBh, this.IBu, "", paramc, (a)localObject, this.IBF);
        }
      }
      for (;;)
      {
        paramc = this.IBF;
        if (paramc == null) {
          break label405;
        }
        for (;;)
        {
          if (this.IBs) {
            this.IBh.log("handleMessage: new destination call exit/enter");
          }
          this.IBA = 0;
          paramMessage = (c)this.IBD.get(paramc);
          do
          {
            localObject = this.IBz;
            i = this.IBA;
            this.IBA = (i + 1);
            localObject[i] = paramMessage;
            localObject = paramMessage.IBJ;
            if (localObject == null) {
              break;
            }
            paramMessage = (Message)localObject;
          } while (!((c)localObject).active);
          if (this.IBs) {
            this.IBh.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.IBA + ",curStateInfo: " + localObject);
          }
          a((c)localObject);
          abh(fqd());
          fqc();
          if (paramc == this.IBF) {
            break;
          }
          paramc = this.IBF;
        }
        i = 0;
        break;
        label255:
        if (i != 0) {
          this.IBv.b(this.IBh, this.IBu, "", paramc, (a)localObject, this.IBF);
        }
      }
      this.IBF = null;
      label405:
      for (;;)
      {
        if ((paramc != null) && (paramc == this.IBC))
        {
          this.IBh.bao();
          if (this.IBh.IBg != null)
          {
            getLooper().quit();
            this.IBh.IBg = null;
          }
          this.IBh.IBf = null;
          this.IBh = null;
          this.IBu = null;
          this.IBv.cleanup();
          this.IBx = null;
          this.IBz = null;
          this.IBD.clear();
          this.IBE = null;
          this.IBF = null;
          this.IBG.clear();
          this.IBr = true;
        }
        AppMethodBeat.o(158020);
        return;
      }
    }
    
    private final void a(c paramc)
    {
      AppMethodBeat.i(158022);
      while ((this.IBy >= 0) && (this.IBx[this.IBy] != paramc))
      {
        c localc = this.IBx[this.IBy].IBI;
        if (this.IBs) {
          this.IBh.log("invokeExitMethods: " + localc.getName());
        }
        localc.exit();
        this.IBx[this.IBy].active = false;
        this.IBy -= 1;
      }
      AppMethodBeat.o(158022);
    }
    
    private final void abh(int paramInt)
    {
      AppMethodBeat.i(158023);
      while (paramInt <= this.IBy)
      {
        if (this.IBs) {
          this.IBh.log("invokeEnterMethods: " + this.IBx[paramInt].IBI.getName());
        }
        this.IBx[paramInt].IBI.enter();
        this.IBx[paramInt].active = true;
        paramInt += 1;
      }
      AppMethodBeat.o(158023);
    }
    
    private final void b(a parama)
    {
      AppMethodBeat.i(158028);
      this.IBF = ((c)parama);
      if (this.IBs) {
        this.IBh.log("transitionTo: destState=" + this.IBF.getName());
      }
      AppMethodBeat.o(158028);
    }
    
    private final c c(c paramc)
    {
      AppMethodBeat.i(158026);
      if (this.IBs) {
        this.IBh.log("addStateInternal: E state=" + paramc.getName() + ",parent=");
      }
      c localc2 = (c)this.IBD.get(paramc);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c((byte)0);
        this.IBD.put(paramc, localc1);
      }
      if ((localc1.IBJ != null) && (localc1.IBJ != null))
      {
        paramc = new RuntimeException("state already added");
        AppMethodBeat.o(158026);
        throw paramc;
      }
      localc1.IBI = paramc;
      localc1.IBJ = null;
      localc1.active = false;
      if (this.IBs) {
        this.IBh.log("addStateInternal: X stateInfo: ".concat(String.valueOf(localc1)));
      }
      AppMethodBeat.o(158026);
      return localc1;
    }
    
    private final void fqc()
    {
      AppMethodBeat.i(158024);
      int i = this.IBG.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.IBG.get(i);
        if (this.IBs) {
          this.IBh.log("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
        }
        sendMessageAtFrontOfQueue(localMessage);
        i -= 1;
      }
      this.IBG.clear();
      AppMethodBeat.o(158024);
    }
    
    private final int fqd()
    {
      AppMethodBeat.i(158025);
      int k = this.IBy + 1;
      int i = this.IBA - 1;
      int j = k;
      while (i >= 0)
      {
        if (this.IBs) {
          this.IBh.log("moveTempStackToStateStack: i=" + i + ",j=" + j);
        }
        this.IBx[j] = this.IBz[i];
        j += 1;
        i -= 1;
      }
      this.IBy = (j - 1);
      if (this.IBs) {
        this.IBh.log("moveTempStackToStateStack: X mStateStackTop=" + this.IBy + ",startingIndex=" + k + ",Top=" + this.IBx[this.IBy].IBI.getName());
      }
      AppMethodBeat.o(158025);
      return k;
    }
    
    private final c s(Message paramMessage)
    {
      AppMethodBeat.i(158021);
      Object localObject2 = this.IBx[this.IBy];
      if (this.IBs) {
        this.IBh.log("processMsg: " + ((c)localObject2).IBI.getName());
      }
      int i;
      Object localObject1;
      if ((paramMessage.what == -1) && (paramMessage.obj == IBt))
      {
        i = 1;
        localObject1 = localObject2;
        if (i == 0) {
          break label158;
        }
        b(this.IBC);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label194;
        }
        paramMessage = ((c)localObject2).IBI;
        AppMethodBeat.o(158021);
        return paramMessage;
        i = 0;
        break;
        label158:
        do
        {
          localObject1 = localObject2;
          if (this.IBs)
          {
            this.IBh.log("processMsg: " + ((c)localObject2).IBI.getName());
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1.IBI.k(paramMessage)) {
            break;
          }
          localObject2 = localObject1.IBJ;
        } while (localObject2 != null);
        this.IBh.j(paramMessage);
      }
      label194:
      AppMethodBeat.o(158021);
      return null;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(158019);
      c localc;
      if (!this.IBr)
      {
        if (this.IBs) {
          this.IBh.log("handleMessage: E msg.what=" + paramMessage.what);
        }
        this.IBu = paramMessage;
        localc = null;
        if (!this.IBw) {
          break label104;
        }
        localc = s(paramMessage);
      }
      for (;;)
      {
        a(localc, paramMessage);
        if ((this.IBs) && (this.IBh != null)) {
          this.IBh.log("handleMessage: X");
        }
        AppMethodBeat.o(158019);
        return;
        label104:
        if ((this.IBw) || (this.IBu.what != -2) || (this.IBu.obj != IBt)) {
          break;
        }
        this.IBw = true;
        abh(0);
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
      c IBI;
      c IBJ;
      boolean active;
      
      private c() {}
      
      public final String toString()
      {
        AppMethodBeat.i(158018);
        StringBuilder localStringBuilder = new StringBuilder("state=").append(this.IBI.getName()).append(",active=").append(this.active).append(",parent=");
        if (this.IBJ == null) {}
        for (String str = "null";; str = this.IBJ.IBI.getName())
        {
          str = str;
          AppMethodBeat.o(158018);
          return str;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d
 * JD-Core Version:    0.7.0.1
 */