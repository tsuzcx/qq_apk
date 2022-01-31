package com.tencent.mm.sdk.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class d$c
  extends Handler
{
  private static final Object ujr = new Object();
  private boolean gXR = false;
  private d.c.b ujA = new d.c.b(this, (byte)0);
  private HashMap<c, d.c.c> ujB = new HashMap();
  private c ujC;
  private c ujD;
  private ArrayList<Message> ujE = new ArrayList();
  private d ujf;
  private boolean ujq = false;
  private Message ujs;
  private d.b ujt = new d.b((byte)0);
  private boolean uju;
  private d.c.c[] ujv;
  private int ujw = -1;
  private d.c.c[] ujx;
  private int ujy;
  private d.c.a ujz = new d.c.a(this, (byte)0);
  
  private d$c(Looper paramLooper, d paramd)
  {
    super(paramLooper);
    this.ujf = paramd;
    c(this.ujz);
    c(this.ujA);
  }
  
  private final void Fh(int paramInt)
  {
    while (paramInt <= this.ujw)
    {
      if (this.ujq) {
        new StringBuilder("invokeEnterMethods: ").append(this.ujv[paramInt].ujG.getName());
      }
      this.ujv[paramInt].ujG.enter();
      this.ujv[paramInt].axD = true;
      paramInt += 1;
    }
  }
  
  private void a(c paramc, Message paramMessage)
  {
    Object localObject = this.ujv[this.ujw].ujG;
    int i;
    if ((this.ujf.e(this.ujs)) && (paramMessage.obj != ujr))
    {
      i = 1;
      if (!this.ujt.csm()) {
        break label225;
      }
      if (this.ujD != null) {
        this.ujt.b(this.ujf, this.ujs, "", paramc, (a)localObject, this.ujD);
      }
    }
    for (;;)
    {
      paramc = this.ujD;
      if (paramc == null) {
        break label370;
      }
      for (;;)
      {
        this.ujy = 0;
        paramMessage = (d.c.c)this.ujB.get(paramc);
        do
        {
          localObject = this.ujx;
          i = this.ujy;
          this.ujy = (i + 1);
          localObject[i] = paramMessage;
          localObject = paramMessage.ujH;
          if (localObject == null) {
            break;
          }
          paramMessage = (Message)localObject;
        } while (!((d.c.c)localObject).axD);
        if (this.ujq) {
          new StringBuilder("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(this.ujy).append(",curStateInfo: ").append(localObject);
        }
        a((d.c.c)localObject);
        Fh(cso());
        csn();
        if (paramc == this.ujD) {
          break;
        }
        paramc = this.ujD;
      }
      i = 0;
      break;
      label225:
      if (i != 0) {
        this.ujt.b(this.ujf, this.ujs, "", paramc, (a)localObject, this.ujD);
      }
    }
    this.ujD = null;
    label370:
    for (;;)
    {
      if ((paramc != null) && (paramc == this.ujA))
      {
        this.ujf.abD();
        if (this.ujf.uje != null)
        {
          getLooper().quit();
          this.ujf.uje = null;
        }
        this.ujf.ujd = null;
        this.ujf = null;
        this.ujs = null;
        this.ujt.cleanup();
        this.ujv = null;
        this.ujx = null;
        this.ujB.clear();
        this.ujC = null;
        this.ujD = null;
        this.ujE.clear();
        this.gXR = true;
      }
      return;
    }
  }
  
  private final void a(d.c.c paramc)
  {
    while ((this.ujw >= 0) && (this.ujv[this.ujw] != paramc))
    {
      c localc = this.ujv[this.ujw].ujG;
      if (this.ujq) {
        new StringBuilder("invokeExitMethods: ").append(localc.getName());
      }
      localc.exit();
      this.ujv[this.ujw].axD = false;
      this.ujw -= 1;
    }
  }
  
  private final void b(a parama)
  {
    this.ujD = ((c)parama);
    if (this.ujq) {
      new StringBuilder("transitionTo: destState=").append(this.ujD.getName());
    }
  }
  
  private final d.c.c c(c paramc)
  {
    if (this.ujq) {
      new StringBuilder("addStateInternal: E state=").append(paramc.getName()).append(",parent=");
    }
    d.c.c localc2 = (d.c.c)this.ujB.get(paramc);
    d.c.c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new d.c.c(this, (byte)0);
      this.ujB.put(paramc, localc1);
    }
    if ((localc1.ujH != null) && (localc1.ujH != null)) {
      throw new RuntimeException("state already added");
    }
    localc1.ujG = paramc;
    localc1.ujH = null;
    localc1.axD = false;
    if (this.ujq) {
      new StringBuilder("addStateInternal: X stateInfo: ").append(localc1);
    }
    return localc1;
  }
  
  private final void csn()
  {
    int i = this.ujE.size() - 1;
    while (i >= 0)
    {
      Message localMessage = (Message)this.ujE.get(i);
      if (this.ujq) {
        new StringBuilder("moveDeferredMessageAtFrontOfQueue; what=").append(localMessage.what);
      }
      sendMessageAtFrontOfQueue(localMessage);
      i -= 1;
    }
    this.ujE.clear();
  }
  
  private final int cso()
  {
    int k = this.ujw + 1;
    int i = this.ujy - 1;
    int j = k;
    while (i >= 0)
    {
      if (this.ujq) {
        new StringBuilder("moveTempStackToStateStack: i=").append(i).append(",j=").append(j);
      }
      this.ujv[j] = this.ujx[i];
      j += 1;
      i -= 1;
    }
    this.ujw = (j - 1);
    if (this.ujq) {
      new StringBuilder("moveTempStackToStateStack: X mStateStackTop=").append(this.ujw).append(",startingIndex=").append(k).append(",Top=").append(this.ujv[this.ujw].ujG.getName());
    }
    return k;
  }
  
  private final c o(Message paramMessage)
  {
    Object localObject2 = this.ujv[this.ujw];
    if (this.ujq) {
      new StringBuilder("processMsg: ").append(((d.c.c)localObject2).ujG.getName());
    }
    int i;
    Object localObject1;
    if ((paramMessage.what == -1) && (paramMessage.obj == ujr))
    {
      i = 1;
      localObject1 = localObject2;
      if (i == 0) {
        break label126;
      }
      b(this.ujA);
    }
    for (;;)
    {
      if (localObject2 == null) {
        break label162;
      }
      return ((d.c.c)localObject2).ujG;
      i = 0;
      break;
      label126:
      do
      {
        localObject1 = localObject2;
        if (this.ujq)
        {
          new StringBuilder("processMsg: ").append(((d.c.c)localObject2).ujG.getName());
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        if (localObject1.ujG.g(paramMessage)) {
          break;
        }
        localObject2 = localObject1.ujH;
      } while (localObject2 != null);
      this.ujf.f(paramMessage);
    }
    label162:
    return null;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    c localc;
    if (!this.gXR)
    {
      if (this.ujq) {
        new StringBuilder("handleMessage: E msg.what=").append(paramMessage.what);
      }
      this.ujs = paramMessage;
      localc = null;
      if (!this.uju) {
        break label59;
      }
      localc = o(paramMessage);
    }
    for (;;)
    {
      a(localc, paramMessage);
      return;
      label59:
      if ((this.uju) || (this.ujs.what != -2) || (this.ujs.obj != ujr)) {
        break;
      }
      this.uju = true;
      Fh(0);
    }
    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.d.d.c
 * JD-Core Version:    0.7.0.1
 */