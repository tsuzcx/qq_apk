package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

public final class d$c
  extends Handler
{
  private static final Object yrr;
  private boolean iGk;
  private d.c.b yrA;
  private HashMap<c, d.c.c> yrB;
  private c yrC;
  private c yrD;
  private ArrayList<Message> yrE;
  private d yrf;
  private boolean yrq;
  private Message yrs;
  private d.b yrt;
  private boolean yru;
  private d.c.c[] yrv;
  private int yrw;
  private d.c.c[] yrx;
  private int yry;
  private d.c.a yrz;
  
  static
  {
    AppMethodBeat.i(52472);
    yrr = new Object();
    AppMethodBeat.o(52472);
  }
  
  private d$c(Looper paramLooper, d paramd)
  {
    super(paramLooper);
    AppMethodBeat.i(52464);
    this.iGk = false;
    this.yrq = false;
    this.yrt = new d.b((byte)0);
    this.yrw = -1;
    this.yrz = new d.c.a(this, (byte)0);
    this.yrA = new d.c.b(this, (byte)0);
    this.yrB = new HashMap();
    this.yrE = new ArrayList();
    this.yrf = paramd;
    c(this.yrz);
    c(this.yrA);
    AppMethodBeat.o(52464);
  }
  
  private final void Ni(int paramInt)
  {
    AppMethodBeat.i(52460);
    while (paramInt <= this.yrw)
    {
      if (this.yrq) {
        this.yrf.log("invokeEnterMethods: " + this.yrv[paramInt].yrG.getName());
      }
      this.yrv[paramInt].yrG.enter();
      this.yrv[paramInt].active = true;
      paramInt += 1;
    }
    AppMethodBeat.o(52460);
  }
  
  private void a(c paramc, Message paramMessage)
  {
    AppMethodBeat.i(52457);
    Object localObject = this.yrv[this.yrw].yrG;
    int i;
    if ((this.yrf.i(this.yrs)) && (paramMessage.obj != yrr))
    {
      i = 1;
      if (!this.yrt.duk()) {
        break label255;
      }
      if (this.yrD != null) {
        this.yrt.b(this.yrf, this.yrs, "", paramc, (a)localObject, this.yrD);
      }
    }
    for (;;)
    {
      paramc = this.yrD;
      if (paramc == null) {
        break label405;
      }
      for (;;)
      {
        if (this.yrq) {
          this.yrf.log("handleMessage: new destination call exit/enter");
        }
        this.yry = 0;
        paramMessage = (d.c.c)this.yrB.get(paramc);
        do
        {
          localObject = this.yrx;
          i = this.yry;
          this.yry = (i + 1);
          localObject[i] = paramMessage;
          localObject = paramMessage.yrH;
          if (localObject == null) {
            break;
          }
          paramMessage = (Message)localObject;
        } while (!((d.c.c)localObject).active);
        if (this.yrq) {
          this.yrf.log("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=" + this.yry + ",curStateInfo: " + localObject);
        }
        a((d.c.c)localObject);
        Ni(dum());
        dul();
        if (paramc == this.yrD) {
          break;
        }
        paramc = this.yrD;
      }
      i = 0;
      break;
      label255:
      if (i != 0) {
        this.yrt.b(this.yrf, this.yrs, "", paramc, (a)localObject, this.yrD);
      }
    }
    this.yrD = null;
    label405:
    for (;;)
    {
      if ((paramc != null) && (paramc == this.yrA))
      {
        this.yrf.avu();
        if (this.yrf.yre != null)
        {
          getLooper().quit();
          this.yrf.yre = null;
        }
        this.yrf.yrd = null;
        this.yrf = null;
        this.yrs = null;
        this.yrt.cleanup();
        this.yrv = null;
        this.yrx = null;
        this.yrB.clear();
        this.yrC = null;
        this.yrD = null;
        this.yrE.clear();
        this.iGk = true;
      }
      AppMethodBeat.o(52457);
      return;
    }
  }
  
  private final void a(d.c.c paramc)
  {
    AppMethodBeat.i(52459);
    while ((this.yrw >= 0) && (this.yrv[this.yrw] != paramc))
    {
      c localc = this.yrv[this.yrw].yrG;
      if (this.yrq) {
        this.yrf.log("invokeExitMethods: " + localc.getName());
      }
      localc.exit();
      this.yrv[this.yrw].active = false;
      this.yrw -= 1;
    }
    AppMethodBeat.o(52459);
  }
  
  private final void b(a parama)
  {
    AppMethodBeat.i(52465);
    this.yrD = ((c)parama);
    if (this.yrq) {
      this.yrf.log("transitionTo: destState=" + this.yrD.getName());
    }
    AppMethodBeat.o(52465);
  }
  
  private final d.c.c c(c paramc)
  {
    AppMethodBeat.i(52463);
    if (this.yrq) {
      this.yrf.log("addStateInternal: E state=" + paramc.getName() + ",parent=");
    }
    d.c.c localc2 = (d.c.c)this.yrB.get(paramc);
    d.c.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new d.c.c(this, (byte)0);
      this.yrB.put(paramc, localc1);
    }
    if ((localc1.yrH != null) && (localc1.yrH != null))
    {
      paramc = new RuntimeException("state already added");
      AppMethodBeat.o(52463);
      throw paramc;
    }
    localc1.yrG = paramc;
    localc1.yrH = null;
    localc1.active = false;
    if (this.yrq) {
      this.yrf.log("addStateInternal: X stateInfo: ".concat(String.valueOf(localc1)));
    }
    AppMethodBeat.o(52463);
    return localc1;
  }
  
  private final void dul()
  {
    AppMethodBeat.i(52461);
    int i = this.yrE.size() - 1;
    while (i >= 0)
    {
      Message localMessage = (Message)this.yrE.get(i);
      if (this.yrq) {
        this.yrf.log("moveDeferredMessageAtFrontOfQueue; what=" + localMessage.what);
      }
      sendMessageAtFrontOfQueue(localMessage);
      i -= 1;
    }
    this.yrE.clear();
    AppMethodBeat.o(52461);
  }
  
  private final int dum()
  {
    AppMethodBeat.i(52462);
    int k = this.yrw + 1;
    int i = this.yry - 1;
    int j = k;
    while (i >= 0)
    {
      if (this.yrq) {
        this.yrf.log("moveTempStackToStateStack: i=" + i + ",j=" + j);
      }
      this.yrv[j] = this.yrx[i];
      j += 1;
      i -= 1;
    }
    this.yrw = (j - 1);
    if (this.yrq) {
      this.yrf.log("moveTempStackToStateStack: X mStateStackTop=" + this.yrw + ",startingIndex=" + k + ",Top=" + this.yrv[this.yrw].yrG.getName());
    }
    AppMethodBeat.o(52462);
    return k;
  }
  
  private final c u(Message paramMessage)
  {
    AppMethodBeat.i(52458);
    Object localObject2 = this.yrv[this.yrw];
    if (this.yrq) {
      this.yrf.log("processMsg: " + ((d.c.c)localObject2).yrG.getName());
    }
    Object localObject1 = localObject2;
    if (v(paramMessage)) {
      b(this.yrA);
    }
    while (localObject2 != null)
    {
      paramMessage = ((d.c.c)localObject2).yrG;
      AppMethodBeat.o(52458);
      return paramMessage;
      do
      {
        localObject1 = localObject2;
        if (this.yrq)
        {
          this.yrf.log("processMsg: " + ((d.c.c)localObject2).yrG.getName());
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1.yrG.k(paramMessage)) {
          break;
        }
        localObject2 = localObject1.yrH;
      } while (localObject2 != null);
      this.yrf.j(paramMessage);
    }
    AppMethodBeat.o(52458);
    return null;
  }
  
  private static boolean v(Message paramMessage)
  {
    return (paramMessage.what == -1) && (paramMessage.obj == yrr);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(52456);
    c localc;
    if (!this.iGk)
    {
      if (this.yrq) {
        this.yrf.log("handleMessage: E msg.what=" + paramMessage.what);
      }
      this.yrs = paramMessage;
      localc = null;
      if (!this.yru) {
        break label104;
      }
      localc = u(paramMessage);
    }
    for (;;)
    {
      a(localc, paramMessage);
      if ((this.yrq) && (this.yrf != null)) {
        this.yrf.log("handleMessage: X");
      }
      AppMethodBeat.o(52456);
      return;
      label104:
      if ((this.yru) || (this.yrs.what != -2) || (this.yrs.obj != yrr)) {
        break;
      }
      this.yru = true;
      Ni(0);
    }
    paramMessage = new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: ".concat(String.valueOf(paramMessage)));
    AppMethodBeat.o(52456);
    throw paramMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d.c
 * JD-Core Version:    0.7.0.1
 */