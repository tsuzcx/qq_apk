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
  public volatile c GuZ;
  volatile HandlerThread Gva;
  public String mName;
  
  protected d(String paramString, Looper paramLooper)
  {
    AppMethodBeat.i(158037);
    this.mName = paramString;
    this.GuZ = new c(paramLooper, this, (byte)0);
    AppMethodBeat.o(158037);
  }
  
  private Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(158044);
    Message localMessage = Message.obtain(this.GuZ, paramInt);
    AppMethodBeat.o(158044);
    return localMessage;
  }
  
  protected void IC(String paramString) {}
  
  public final void Yv(int paramInt)
  {
    AppMethodBeat.i(158046);
    c localc = this.GuZ;
    if (localc == null)
    {
      AppMethodBeat.o(158046);
      return;
    }
    localc.sendMessage(obtainMessage(paramInt));
    AppMethodBeat.o(158046);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(158038);
    c.a(this.GuZ, paramc);
    AppMethodBeat.o(158038);
  }
  
  protected void aWu() {}
  
  public final void b(a parama)
  {
    AppMethodBeat.i(158042);
    c.a(this.GuZ, parama);
    AppMethodBeat.o(158042);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(158039);
    c.b(this.GuZ, paramc);
    AppMethodBeat.o(158039);
  }
  
  protected final Message eWu()
  {
    AppMethodBeat.i(158040);
    Object localObject = this.GuZ;
    if (localObject == null)
    {
      AppMethodBeat.o(158040);
      return null;
    }
    localObject = c.b((c)localObject);
    AppMethodBeat.o(158040);
    return localObject;
  }
  
  public final a eWv()
  {
    AppMethodBeat.i(158041);
    Object localObject = this.GuZ;
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
    if (c.d(this.GuZ)) {
      IC(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
    AppMethodBeat.o(158043);
  }
  
  protected void log(String paramString) {}
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158045);
    paramObject = Message.obtain(this.GuZ, paramInt, paramObject);
    AppMethodBeat.o(158045);
    return paramObject;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(158048);
    c localc = this.GuZ;
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
    AppMethodBeat.i(199895);
    c localc = this.GuZ;
    if (localc == null)
    {
      AppMethodBeat.o(199895);
      return;
    }
    localc.sendMessage(paramMessage);
    AppMethodBeat.o(199895);
  }
  
  public void start()
  {
    AppMethodBeat.i(158051);
    c localc = this.GuZ;
    if (localc == null)
    {
      AppMethodBeat.o(158051);
      return;
    }
    c.g(localc);
    AppMethodBeat.o(158051);
  }
  
  public final void wa(boolean paramBoolean)
  {
    AppMethodBeat.i(158050);
    c localc = this.GuZ;
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
    private static final Object Gvn;
    private ArrayList<Message> GvA;
    private d Gvb;
    private boolean Gvl;
    private boolean Gvm;
    private Message Gvo;
    private d.b Gvp;
    private boolean Gvq;
    private c[] Gvr;
    private int Gvs;
    private c[] Gvt;
    private int Gvu;
    private a Gvv;
    private b Gvw;
    private HashMap<c, c> Gvx;
    private c Gvy;
    private c Gvz;
    
    static
    {
      AppMethodBeat.i(158036);
      Gvn = new Object();
      AppMethodBeat.o(158036);
    }
    
    private c(Looper paramLooper, d paramd)
    {
      super();
      AppMethodBeat.i(158027);
      this.Gvl = false;
      this.Gvm = false;
      this.Gvp = new d.b((byte)0);
      this.Gvs = -1;
      this.Gvv = new a((byte)0);
      this.Gvw = new b((byte)0);
      this.Gvx = new HashMap();
      this.GvA = new ArrayList();
      this.Gvb = paramd;
      c(this.Gvv);
      c(this.Gvw);
      AppMethodBeat.o(158027);
    }
    
    private final void Yw(int paramInt)
    {
      AppMethodBeat.i(158023);
      while (paramInt <= this.Gvs)
      {
        if (this.Gvm) {
          this.Gvb.log("invokeEnterMethods: " + this.Gvr[paramInt].GvC.getName());
        }
        this.Gvr[paramInt].GvC.enter();
        this.Gvr[paramInt].active = true;
        paramInt += 1;
      }
      AppMethodBeat.o(158023);
    }
    
    private void a(c paramc, Message paramMessage)
    {
      AppMethodBeat.i(158020);
      Object localObject = this.Gvr[this.Gvs].GvC;
      int i;
      if ((this.Gvb.i(this.Gvo)) && (paramMessage.obj != Gvn))
      {
        i = 1;
        if (!this.Gvp.eWw()) {
          break label255;
        }
        if (this.Gvz != null) {
          this.Gvp.b(this.Gvb, this.Gvo, "", paramc, (a)localObject, this.Gvz);
        }
      }
      for (;;)
      {
        paramc = this.Gvz;
        if (paramc == null) {
          break label405;
        }
        for (;;)
        {
          if (this.Gvm) {
            this.Gvb.log("handleMessage: new destination call exit/enter");
          }
          this.Gvu = 0;
          paramMessage = (c)this.Gvx.get(paramc);
          do
          {
            localObject = this.Gvt;
            i = this.Gvu;
            this.Gvu = (i + 1);
            localObject[i] = paramMessage;
            localObject = paramMessage.GvD;
            if (localObject == null) {
              break;
            }
            paramMessage = (Message)localObject;
          } while (!((c)localObject).active);
          if (this.Gvm) {
            this.Gvb.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.Gvu + ",curStateInfo: " + localObject);
          }
          a((c)localObject);
          Yw(eWy());
          eWx();
          if (paramc == this.Gvz) {
            break;
          }
          paramc = this.Gvz;
        }
        i = 0;
        break;
        label255:
        if (i != 0) {
          this.Gvp.b(this.Gvb, this.Gvo, "", paramc, (a)localObject, this.Gvz);
        }
      }
      this.Gvz = null;
      label405:
      for (;;)
      {
        if ((paramc != null) && (paramc == this.Gvw))
        {
          this.Gvb.aWu();
          if (this.Gvb.Gva != null)
          {
            getLooper().quit();
            this.Gvb.Gva = null;
          }
          this.Gvb.GuZ = null;
          this.Gvb = null;
          this.Gvo = null;
          this.Gvp.cleanup();
          this.Gvr = null;
          this.Gvt = null;
          this.Gvx.clear();
          this.Gvy = null;
          this.Gvz = null;
          this.GvA.clear();
          this.Gvl = true;
        }
        AppMethodBeat.o(158020);
        return;
      }
    }
    
    private final void a(c paramc)
    {
      AppMethodBeat.i(158022);
      while ((this.Gvs >= 0) && (this.Gvr[this.Gvs] != paramc))
      {
        c localc = this.Gvr[this.Gvs].GvC;
        if (this.Gvm) {
          this.Gvb.log("invokeExitMethods: " + localc.getName());
        }
        localc.exit();
        this.Gvr[this.Gvs].active = false;
        this.Gvs -= 1;
      }
      AppMethodBeat.o(158022);
    }
    
    private final void b(a parama)
    {
      AppMethodBeat.i(158028);
      this.Gvz = ((c)parama);
      if (this.Gvm) {
        this.Gvb.log("transitionTo: destState=" + this.Gvz.getName());
      }
      AppMethodBeat.o(158028);
    }
    
    private final c c(c paramc)
    {
      AppMethodBeat.i(158026);
      if (this.Gvm) {
        this.Gvb.log("addStateInternal: E state=" + paramc.getName() + ",parent=");
      }
      c localc2 = (c)this.Gvx.get(paramc);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c((byte)0);
        this.Gvx.put(paramc, localc1);
      }
      if ((localc1.GvD != null) && (localc1.GvD != null))
      {
        paramc = new RuntimeException("state already added");
        AppMethodBeat.o(158026);
        throw paramc;
      }
      localc1.GvC = paramc;
      localc1.GvD = null;
      localc1.active = false;
      if (this.Gvm) {
        this.Gvb.log("addStateInternal: X stateInfo: ".concat(String.valueOf(localc1)));
      }
      AppMethodBeat.o(158026);
      return localc1;
    }
    
    private final void eWx()
    {
      AppMethodBeat.i(158024);
      int i = this.GvA.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.GvA.get(i);
        if (this.Gvm) {
          this.Gvb.log("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
        }
        sendMessageAtFrontOfQueue(localMessage);
        i -= 1;
      }
      this.GvA.clear();
      AppMethodBeat.o(158024);
    }
    
    private final int eWy()
    {
      AppMethodBeat.i(158025);
      int k = this.Gvs + 1;
      int i = this.Gvu - 1;
      int j = k;
      while (i >= 0)
      {
        if (this.Gvm) {
          this.Gvb.log("moveTempStackToStateStack: i=" + i + ",j=" + j);
        }
        this.Gvr[j] = this.Gvt[i];
        j += 1;
        i -= 1;
      }
      this.Gvs = (j - 1);
      if (this.Gvm) {
        this.Gvb.log("moveTempStackToStateStack: X mStateStackTop=" + this.Gvs + ",startingIndex=" + k + ",Top=" + this.Gvr[this.Gvs].GvC.getName());
      }
      AppMethodBeat.o(158025);
      return k;
    }
    
    private final c s(Message paramMessage)
    {
      AppMethodBeat.i(158021);
      Object localObject2 = this.Gvr[this.Gvs];
      if (this.Gvm) {
        this.Gvb.log("processMsg: " + ((c)localObject2).GvC.getName());
      }
      int i;
      Object localObject1;
      if ((paramMessage.what == -1) && (paramMessage.obj == Gvn))
      {
        i = 1;
        localObject1 = localObject2;
        if (i == 0) {
          break label158;
        }
        b(this.Gvw);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label194;
        }
        paramMessage = ((c)localObject2).GvC;
        AppMethodBeat.o(158021);
        return paramMessage;
        i = 0;
        break;
        label158:
        do
        {
          localObject1 = localObject2;
          if (this.Gvm)
          {
            this.Gvb.log("processMsg: " + ((c)localObject2).GvC.getName());
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1.GvC.k(paramMessage)) {
            break;
          }
          localObject2 = localObject1.GvD;
        } while (localObject2 != null);
        this.Gvb.j(paramMessage);
      }
      label194:
      AppMethodBeat.o(158021);
      return null;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(158019);
      c localc;
      if (!this.Gvl)
      {
        if (this.Gvm) {
          this.Gvb.log("handleMessage: E msg.what=" + paramMessage.what);
        }
        this.Gvo = paramMessage;
        localc = null;
        if (!this.Gvq) {
          break label104;
        }
        localc = s(paramMessage);
      }
      for (;;)
      {
        a(localc, paramMessage);
        if ((this.Gvm) && (this.Gvb != null)) {
          this.Gvb.log("handleMessage: X");
        }
        AppMethodBeat.o(158019);
        return;
        label104:
        if ((this.Gvq) || (this.Gvo.what != -2) || (this.Gvo.obj != Gvn)) {
          break;
        }
        this.Gvq = true;
        Yw(0);
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
      c GvC;
      c GvD;
      boolean active;
      
      private c() {}
      
      public final String toString()
      {
        AppMethodBeat.i(158018);
        StringBuilder localStringBuilder = new StringBuilder("state=").append(this.GvC.getName()).append(",active=").append(this.active).append(",parent=");
        if (this.GvD == null) {}
        for (String str = "null";; str = this.GvD.GvC.getName())
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