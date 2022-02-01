package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class d
{
  public volatile c EXN;
  volatile HandlerThread EXO;
  public String mName;
  
  protected d(String paramString, Looper paramLooper)
  {
    AppMethodBeat.i(158037);
    this.mName = paramString;
    this.EXN = new c(paramLooper, this, (byte)0);
    AppMethodBeat.o(158037);
  }
  
  private Message obtainMessage(int paramInt)
  {
    AppMethodBeat.i(158044);
    Message localMessage = Message.obtain(this.EXN, paramInt);
    AppMethodBeat.o(158044);
    return localMessage;
  }
  
  protected void Ez(String paramString) {}
  
  public final void Wm(int paramInt)
  {
    AppMethodBeat.i(158046);
    c localc = this.EXN;
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
    c.a(this.EXN, paramc);
    AppMethodBeat.o(158038);
  }
  
  protected void aPC() {}
  
  public final void b(a parama)
  {
    AppMethodBeat.i(158042);
    c.a(this.EXN, parama);
    AppMethodBeat.o(158042);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(158039);
    c.b(this.EXN, paramc);
    AppMethodBeat.o(158039);
  }
  
  protected final Message eGZ()
  {
    AppMethodBeat.i(158040);
    Object localObject = this.EXN;
    if (localObject == null)
    {
      AppMethodBeat.o(158040);
      return null;
    }
    localObject = c.b((c)localObject);
    AppMethodBeat.o(158040);
    return localObject;
  }
  
  public final a eHa()
  {
    AppMethodBeat.i(158041);
    Object localObject = this.EXN;
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
    if (c.d(this.EXN)) {
      Ez(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
    AppMethodBeat.o(158043);
  }
  
  protected void log(String paramString) {}
  
  public final Message obtainMessage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(158045);
    paramObject = Message.obtain(this.EXN, paramInt, paramObject);
    AppMethodBeat.o(158045);
    return paramObject;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(158048);
    c localc = this.EXN;
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
    AppMethodBeat.i(194745);
    c localc = this.EXN;
    if (localc == null)
    {
      AppMethodBeat.o(194745);
      return;
    }
    localc.sendMessage(paramMessage);
    AppMethodBeat.o(194745);
  }
  
  public void start()
  {
    AppMethodBeat.i(158051);
    c localc = this.EXN;
    if (localc == null)
    {
      AppMethodBeat.o(158051);
      return;
    }
    c.g(localc);
    AppMethodBeat.o(158051);
  }
  
  public final void uY(boolean paramBoolean)
  {
    AppMethodBeat.i(158050);
    c localc = this.EXN;
    if (localc == null)
    {
      AppMethodBeat.o(158050);
      return;
    }
    c.a(localc, paramBoolean);
    AppMethodBeat.o(158050);
  }
  
  public static final class a
  {
    private d EXP;
    private long EXQ;
    private int EXR;
    private String EXS;
    private a EXT;
    private a EXU;
    private a EXV;
    
    a(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
    {
      AppMethodBeat.i(158011);
      a(paramd, paramMessage, paramString, parama1, parama2, parama3);
      AppMethodBeat.o(158011);
    }
    
    public final void a(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
    {
      AppMethodBeat.i(158012);
      this.EXP = paramd;
      this.EXQ = System.currentTimeMillis();
      if (paramMessage != null) {}
      for (int i = paramMessage.what;; i = 0)
      {
        this.EXR = i;
        this.EXS = paramString;
        this.EXT = parama1;
        this.EXU = parama2;
        this.EXV = parama3;
        AppMethodBeat.o(158012);
        return;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(158013);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("time=");
      Object localObject = Calendar.getInstance();
      ((Calendar)localObject).setTimeInMillis(this.EXQ);
      localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
      localStringBuilder.append(" processed=");
      if (this.EXT == null)
      {
        localObject = "<null>";
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" org=");
        if (this.EXU != null) {
          break label249;
        }
        localObject = "<null>";
        label111:
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" dest=");
        if (this.EXV != null) {
          break label262;
        }
        localObject = "<null>";
        label134:
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" what=");
        if (this.EXP == null) {
          break label275;
        }
        localObject = null;
        label156:
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label281;
        }
        localStringBuilder.append(this.EXR);
        localStringBuilder.append("(0x");
        localStringBuilder.append(Integer.toHexString(this.EXR));
        localStringBuilder.append(")");
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(this.EXS))
        {
          localStringBuilder.append(" ");
          localStringBuilder.append(this.EXS);
        }
        localObject = localStringBuilder.toString();
        AppMethodBeat.o(158013);
        return localObject;
        localObject = this.EXT.getName();
        break;
        label249:
        localObject = this.EXU.getName();
        break label111;
        label262:
        localObject = this.EXV.getName();
        break label134;
        label275:
        localObject = "";
        break label156;
        label281:
        localStringBuilder.append((String)localObject);
      }
    }
  }
  
  static final class b
  {
    private Vector<d.a> EXW;
    private int EXX;
    private boolean EXY;
    private int mCount;
    private int xZb;
    
    private b()
    {
      AppMethodBeat.i(158014);
      this.EXW = new Vector();
      this.xZb = 20;
      this.EXX = 0;
      this.mCount = 0;
      this.EXY = false;
      AppMethodBeat.o(158014);
    }
    
    /* Error */
    final void b(d paramd, Message paramMessage, String paramString, a parama1, a parama2, a parama3)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 48
      //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: aload_0
      //   8: aload_0
      //   9: getfield 38	com/tencent/mm/sdk/d/d$b:mCount	I
      //   12: iconst_1
      //   13: iadd
      //   14: putfield 38	com/tencent/mm/sdk/d/d$b:mCount	I
      //   17: aload_0
      //   18: getfield 32	com/tencent/mm/sdk/d/d$b:EXW	Ljava/util/Vector;
      //   21: invokevirtual 52	java/util/Vector:size	()I
      //   24: aload_0
      //   25: getfield 34	com/tencent/mm/sdk/d/d$b:xZb	I
      //   28: if_icmpge +35 -> 63
      //   31: aload_0
      //   32: getfield 32	com/tencent/mm/sdk/d/d$b:EXW	Ljava/util/Vector;
      //   35: new 54	com/tencent/mm/sdk/d/d$a
      //   38: dup
      //   39: aload_1
      //   40: aload_2
      //   41: aload_3
      //   42: aload 4
      //   44: aload 5
      //   46: aload 6
      //   48: invokespecial 56	com/tencent/mm/sdk/d/d$a:<init>	(Lcom/tencent/mm/sdk/d/d;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;)V
      //   51: invokevirtual 60	java/util/Vector:add	(Ljava/lang/Object;)Z
      //   54: pop
      //   55: ldc 48
      //   57: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   60: aload_0
      //   61: monitorexit
      //   62: return
      //   63: aload_0
      //   64: getfield 32	com/tencent/mm/sdk/d/d$b:EXW	Ljava/util/Vector;
      //   67: aload_0
      //   68: getfield 36	com/tencent/mm/sdk/d/d$b:EXX	I
      //   71: invokevirtual 64	java/util/Vector:get	(I)Ljava/lang/Object;
      //   74: checkcast 54	com/tencent/mm/sdk/d/d$a
      //   77: astore 7
      //   79: aload_0
      //   80: aload_0
      //   81: getfield 36	com/tencent/mm/sdk/d/d$b:EXX	I
      //   84: iconst_1
      //   85: iadd
      //   86: putfield 36	com/tencent/mm/sdk/d/d$b:EXX	I
      //   89: aload_0
      //   90: getfield 36	com/tencent/mm/sdk/d/d$b:EXX	I
      //   93: aload_0
      //   94: getfield 34	com/tencent/mm/sdk/d/d$b:xZb	I
      //   97: if_icmplt +8 -> 105
      //   100: aload_0
      //   101: iconst_0
      //   102: putfield 36	com/tencent/mm/sdk/d/d$b:EXX	I
      //   105: aload 7
      //   107: aload_1
      //   108: aload_2
      //   109: aload_3
      //   110: aload 4
      //   112: aload 5
      //   114: aload 6
      //   116: invokevirtual 67	com/tencent/mm/sdk/d/d$a:a	(Lcom/tencent/mm/sdk/d/d;Landroid/os/Message;Ljava/lang/String;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;Lcom/tencent/mm/sdk/d/a;)V
      //   119: ldc 48
      //   121: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   124: goto -64 -> 60
      //   127: astore_1
      //   128: aload_0
      //   129: monitorexit
      //   130: aload_1
      //   131: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	132	0	this	b
      //   0	132	1	paramd	d
      //   0	132	2	paramMessage	Message
      //   0	132	3	paramString	String
      //   0	132	4	parama1	a
      //   0	132	5	parama2	a
      //   0	132	6	parama3	a
      //   77	29	7	locala	d.a
      // Exception table:
      //   from	to	target	type
      //   2	60	127	finally
      //   63	105	127	finally
      //   105	124	127	finally
    }
    
    final void cleanup()
    {
      try
      {
        AppMethodBeat.i(158015);
        this.EXW.clear();
        AppMethodBeat.o(158015);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final boolean eHb()
    {
      try
      {
        boolean bool = this.EXY;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  public static final class c
    extends Handler
  {
    private static final Object EYb;
    private d EXP;
    private boolean EXZ;
    private boolean EYa;
    private Message EYc;
    private d.b EYd;
    private boolean EYe;
    private c[] EYf;
    private int EYg;
    private c[] EYh;
    private int EYi;
    private a EYj;
    private b EYk;
    private HashMap<c, c> EYl;
    private c EYm;
    private c EYn;
    private ArrayList<Message> EYo;
    
    static
    {
      AppMethodBeat.i(158036);
      EYb = new Object();
      AppMethodBeat.o(158036);
    }
    
    private c(Looper paramLooper, d paramd)
    {
      super();
      AppMethodBeat.i(158027);
      this.EXZ = false;
      this.EYa = false;
      this.EYd = new d.b((byte)0);
      this.EYg = -1;
      this.EYj = new a((byte)0);
      this.EYk = new b((byte)0);
      this.EYl = new HashMap();
      this.EYo = new ArrayList();
      this.EXP = paramd;
      c(this.EYj);
      c(this.EYk);
      AppMethodBeat.o(158027);
    }
    
    private final void Wn(int paramInt)
    {
      AppMethodBeat.i(158023);
      while (paramInt <= this.EYg)
      {
        if (this.EYa) {
          this.EXP.log("invokeEnterMethods: " + this.EYf[paramInt].EYq.getName());
        }
        this.EYf[paramInt].EYq.enter();
        this.EYf[paramInt].active = true;
        paramInt += 1;
      }
      AppMethodBeat.o(158023);
    }
    
    private void a(c paramc, Message paramMessage)
    {
      AppMethodBeat.i(158020);
      Object localObject = this.EYf[this.EYg].EYq;
      int i;
      if ((this.EXP.i(this.EYc)) && (paramMessage.obj != EYb))
      {
        i = 1;
        if (!this.EYd.eHb()) {
          break label255;
        }
        if (this.EYn != null) {
          this.EYd.b(this.EXP, this.EYc, "", paramc, (a)localObject, this.EYn);
        }
      }
      for (;;)
      {
        paramc = this.EYn;
        if (paramc == null) {
          break label405;
        }
        for (;;)
        {
          if (this.EYa) {
            this.EXP.log("handleMessage: new destination call exit/enter");
          }
          this.EYi = 0;
          paramMessage = (c)this.EYl.get(paramc);
          do
          {
            localObject = this.EYh;
            i = this.EYi;
            this.EYi = (i + 1);
            localObject[i] = paramMessage;
            localObject = paramMessage.EYr;
            if (localObject == null) {
              break;
            }
            paramMessage = (Message)localObject;
          } while (!((c)localObject).active);
          if (this.EYa) {
            this.EXP.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.EYi + ",curStateInfo: " + localObject);
          }
          a((c)localObject);
          Wn(eHd());
          eHc();
          if (paramc == this.EYn) {
            break;
          }
          paramc = this.EYn;
        }
        i = 0;
        break;
        label255:
        if (i != 0) {
          this.EYd.b(this.EXP, this.EYc, "", paramc, (a)localObject, this.EYn);
        }
      }
      this.EYn = null;
      label405:
      for (;;)
      {
        if ((paramc != null) && (paramc == this.EYk))
        {
          this.EXP.aPC();
          if (this.EXP.EXO != null)
          {
            getLooper().quit();
            this.EXP.EXO = null;
          }
          this.EXP.EXN = null;
          this.EXP = null;
          this.EYc = null;
          this.EYd.cleanup();
          this.EYf = null;
          this.EYh = null;
          this.EYl.clear();
          this.EYm = null;
          this.EYn = null;
          this.EYo.clear();
          this.EXZ = true;
        }
        AppMethodBeat.o(158020);
        return;
      }
    }
    
    private final void a(c paramc)
    {
      AppMethodBeat.i(158022);
      while ((this.EYg >= 0) && (this.EYf[this.EYg] != paramc))
      {
        c localc = this.EYf[this.EYg].EYq;
        if (this.EYa) {
          this.EXP.log("invokeExitMethods: " + localc.getName());
        }
        localc.exit();
        this.EYf[this.EYg].active = false;
        this.EYg -= 1;
      }
      AppMethodBeat.o(158022);
    }
    
    private final void b(a parama)
    {
      AppMethodBeat.i(158028);
      this.EYn = ((c)parama);
      if (this.EYa) {
        this.EXP.log("transitionTo: destState=" + this.EYn.getName());
      }
      AppMethodBeat.o(158028);
    }
    
    private final c c(c paramc)
    {
      AppMethodBeat.i(158026);
      if (this.EYa) {
        this.EXP.log("addStateInternal: E state=" + paramc.getName() + ",parent=");
      }
      c localc2 = (c)this.EYl.get(paramc);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c((byte)0);
        this.EYl.put(paramc, localc1);
      }
      if ((localc1.EYr != null) && (localc1.EYr != null))
      {
        paramc = new RuntimeException("state already added");
        AppMethodBeat.o(158026);
        throw paramc;
      }
      localc1.EYq = paramc;
      localc1.EYr = null;
      localc1.active = false;
      if (this.EYa) {
        this.EXP.log("addStateInternal: X stateInfo: ".concat(String.valueOf(localc1)));
      }
      AppMethodBeat.o(158026);
      return localc1;
    }
    
    private final void eHc()
    {
      AppMethodBeat.i(158024);
      int i = this.EYo.size() - 1;
      while (i >= 0)
      {
        Message localMessage = (Message)this.EYo.get(i);
        if (this.EYa) {
          this.EXP.log("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
        }
        sendMessageAtFrontOfQueue(localMessage);
        i -= 1;
      }
      this.EYo.clear();
      AppMethodBeat.o(158024);
    }
    
    private final int eHd()
    {
      AppMethodBeat.i(158025);
      int k = this.EYg + 1;
      int i = this.EYi - 1;
      int j = k;
      while (i >= 0)
      {
        if (this.EYa) {
          this.EXP.log("moveTempStackToStateStack: i=" + i + ",j=" + j);
        }
        this.EYf[j] = this.EYh[i];
        j += 1;
        i -= 1;
      }
      this.EYg = (j - 1);
      if (this.EYa) {
        this.EXP.log("moveTempStackToStateStack: X mStateStackTop=" + this.EYg + ",startingIndex=" + k + ",Top=" + this.EYf[this.EYg].EYq.getName());
      }
      AppMethodBeat.o(158025);
      return k;
    }
    
    private final c s(Message paramMessage)
    {
      AppMethodBeat.i(158021);
      Object localObject2 = this.EYf[this.EYg];
      if (this.EYa) {
        this.EXP.log("processMsg: " + ((c)localObject2).EYq.getName());
      }
      int i;
      Object localObject1;
      if ((paramMessage.what == -1) && (paramMessage.obj == EYb))
      {
        i = 1;
        localObject1 = localObject2;
        if (i == 0) {
          break label158;
        }
        b(this.EYk);
      }
      for (;;)
      {
        if (localObject2 == null) {
          break label194;
        }
        paramMessage = ((c)localObject2).EYq;
        AppMethodBeat.o(158021);
        return paramMessage;
        i = 0;
        break;
        label158:
        do
        {
          localObject1 = localObject2;
          if (this.EYa)
          {
            this.EXP.log("processMsg: " + ((c)localObject2).EYq.getName());
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1.EYq.k(paramMessage)) {
            break;
          }
          localObject2 = localObject1.EYr;
        } while (localObject2 != null);
        this.EXP.j(paramMessage);
      }
      label194:
      AppMethodBeat.o(158021);
      return null;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(158019);
      c localc;
      if (!this.EXZ)
      {
        if (this.EYa) {
          this.EXP.log("handleMessage: E msg.what=" + paramMessage.what);
        }
        this.EYc = paramMessage;
        localc = null;
        if (!this.EYe) {
          break label104;
        }
        localc = s(paramMessage);
      }
      for (;;)
      {
        a(localc, paramMessage);
        if ((this.EYa) && (this.EXP != null)) {
          this.EXP.log("handleMessage: X");
        }
        AppMethodBeat.o(158019);
        return;
        label104:
        if ((this.EYe) || (this.EYc.what != -2) || (this.EYc.obj != EYb)) {
          break;
        }
        this.EYe = true;
        Wn(0);
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
      c EYq;
      c EYr;
      boolean active;
      
      private c() {}
      
      public final String toString()
      {
        AppMethodBeat.i(158018);
        StringBuilder localStringBuilder = new StringBuilder("state=").append(this.EYq.getName()).append(",active=").append(this.active).append(",parent=");
        if (this.EYr == null) {}
        for (String str = "null";; str = this.EYr.EYq.getName())
        {
          str = str;
          AppMethodBeat.o(158018);
          return str;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d
 * JD-Core Version:    0.7.0.1
 */