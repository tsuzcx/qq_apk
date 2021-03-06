package com.tencent.mm.wear.app.ui;

import android.content.Context;
import com.tencent.mm.e.a.t;
import com.tencent.mm.e.a.y;
import com.tencent.mm.e.a.z;
import com.tencent.mm.wear.app.ui.a.c;
import com.tencent.mm.wear.app.ui.a.e;
import com.tencent.mm.wear.app.ui.a.i;
import com.tencent.mm.wear.app.ui.a.k;
import com.tencent.mm.wear.app.ui.a.o;
import com.tencent.mm.wear.app.ui.a.q;
import com.tencent.mm.wear.app.ui.a.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends a
  implements com.tencent.mm.wear.app.f.d
{
  private String agi;
  private com.tencent.mm.wear.app.f.b ahk;
  private LinkedList<g> aiB = new LinkedList();
  private HashSet<Long> aiC = new HashSet();
  private boolean aiD = true;
  private h aiE;
  
  public f(Context paramContext, String paramString)
  {
    super(paramContext);
    this.agi = paramString;
  }
  
  private void al(final int paramInt1, final int paramInt2)
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MessageHistoryAdapter", "Message History notifyRequestDataEnd %d", new Object[] { Integer.valueOf(this.aiB.size()) });
    com.tencent.mm.wear.a.b.a.amv.postDelayed(new Runnable()
    {
      public final void run()
      {
        f.this.setCount(f.a(f.this).size());
        f.this.clearCache();
        f.this.notifyDataSetChanged();
        if (f.b(f.this) != null) {
          f.b(f.this).ai(paramInt1, paramInt2);
        }
      }
    }, 500L);
  }
  
  private g b(com.tencent.mm.e.a.s params)
  {
    g localg = new g(this);
    localg.aiI = params;
    boolean bool = params.XI.equals(com.tencent.mm.wear.app.b.h.mO().mG().Xh);
    int i;
    switch (params.XP)
    {
    default: 
      return localg;
    case 1: 
      if (bool) {}
      for (i = 2;; i = 1)
      {
        localg.aiJ = i;
        return localg;
      }
    case 2: 
      if (bool) {}
      for (i = 4;; i = 3)
      {
        localg.aiJ = i;
        return localg;
      }
    case 4: 
      if (bool) {}
      for (i = 7;; i = 6)
      {
        localg.aiJ = i;
        return localg;
      }
    case 5: 
      if (bool) {}
      for (i = 9;; i = 8)
      {
        localg.aiJ = i;
        return localg;
      }
    case 6: 
      if (bool) {}
      for (i = 11;; i = 10)
      {
        localg.aiJ = i;
        return localg;
      }
    }
    localg.aiJ = 5;
    return localg;
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.ahk != null)
    {
      this.ahk.cancel();
      this.ahk = null;
    }
    this.ahk = new com.tencent.mm.wear.app.f.b(paramInt, paramArrayOfByte);
    this.ahk.a(this);
    this.ahk.I(true);
    com.tencent.mm.wear.app.b.h.mP().a(this.ahk);
  }
  
  public final void a(h paramh)
  {
    this.aiE = paramh;
  }
  
  public final void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramInt2 != 0)
    {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.MessageHistoryAdapter", "common task onEnd error funId=%d code=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    Object localObject;
    switch (paramInt1)
    {
    default: 
      return;
    case 11019: 
      localObject = new com.tencent.mm.e.a.u();
    }
    try
    {
      ((com.tencent.mm.e.a.u)localObject).h(paramArrayOfByte);
      paramArrayOfByte = ((com.tencent.mm.e.a.u)localObject).XW.iterator();
      while (paramArrayOfByte.hasNext())
      {
        com.tencent.mm.e.a.s locals = (com.tencent.mm.e.a.s)paramArrayOfByte.next();
        if (this.aiC.add(Long.valueOf(locals.XJ)))
        {
          this.aiB.add(b(locals));
          continue;
          localObject = new z();
          try
          {
            ((z)localObject).h(paramArrayOfByte);
            paramArrayOfByte = ((z)localObject).XW.iterator();
            while (paramArrayOfByte.hasNext())
            {
              locals = (com.tencent.mm.e.a.s)paramArrayOfByte.next();
              if (this.aiC.add(Long.valueOf(locals.XJ))) {
                this.aiB.add(b(locals));
              }
            }
            this.aiD = ((z)localObject).XV;
          }
          catch (IOException paramArrayOfByte)
          {
            com.tencent.mm.wear.a.c.d.a("MicroMsg.MessageHistoryAdapter", paramArrayOfByte);
            return;
          }
          Collections.sort(this.aiB);
          al(((z)localObject).XW.size(), 1);
          return;
        }
      }
    }
    catch (IOException paramArrayOfByte)
    {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.MessageHistoryAdapter", paramArrayOfByte);
      return;
    }
    if (!((com.tencent.mm.e.a.u)localObject).XU) {
      this.aiD = ((com.tencent.mm.e.a.u)localObject).XV;
    }
    Collections.sort(this.aiB);
    if (((com.tencent.mm.e.a.u)localObject).XU)
    {
      al(((com.tencent.mm.e.a.u)localObject).XW.size(), 3);
      return;
    }
    al(((com.tencent.mm.e.a.u)localObject).XW.size(), 2);
  }
  
  public final com.tencent.mm.wear.app.ui.a.a co(int paramInt)
  {
    Object localObject2 = (g)this.aiB.get(paramInt);
    Object localObject1 = null;
    switch (((g)localObject2).aiJ)
    {
    default: 
      if (localObject1 != null)
      {
        ((com.tencent.mm.wear.app.ui.a.a)localObject1).akG = ((g)localObject2);
        localObject2 = this.agi;
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          break label250;
        }
      }
      break;
    }
    label250:
    for (boolean bool = false;; bool = ((String)localObject2).endsWith("@chatroom"))
    {
      ((com.tencent.mm.wear.app.ui.a.a)localObject1).K(bool);
      return localObject1;
      localObject1 = new o(paramInt);
      break;
      localObject1 = new c(paramInt);
      break;
      localObject1 = new e(paramInt);
      break;
      localObject1 = new q(paramInt);
      break;
      localObject1 = new w(paramInt);
      break;
      localObject1 = new com.tencent.mm.wear.app.ui.a.g(paramInt);
      break;
      localObject1 = new i(paramInt);
      break;
      localObject1 = new k(paramInt);
      break;
      localObject1 = new com.tencent.mm.wear.app.ui.a.m(paramInt);
      break;
      localObject1 = new com.tencent.mm.wear.app.ui.a.s(paramInt);
      break;
      localObject1 = new com.tencent.mm.wear.app.ui.a.u(paramInt);
      break;
    }
  }
  
  public final List<com.tencent.mm.e.a.s> cr(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt < this.aiB.size())
    {
      localArrayList.add(((g)this.aiB.get(paramInt)).aiI);
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public final void finish()
  {
    if (this.ahk != null) {
      this.ahk.cancel();
    }
  }
  
  public final void nV()
  {
    y localy = new y();
    localy.Xh = this.agi;
    localy.XT = System.currentTimeMillis();
    try
    {
      b(11020, localy.toByteArray());
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.MessageHistoryAdapter", localIOException);
    }
  }
  
  public final boolean nW()
  {
    t localt = new t();
    localt.Xh = this.agi;
    localt.XU = true;
    if (this.aiB.size() > 0) {}
    for (localt.XT = ((g)this.aiB.getLast()).aiI.XQ;; localt.XT = System.currentTimeMillis()) {
      try
      {
        b(11019, localt.toByteArray());
        return true;
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.MessageHistoryAdapter", localIOException);
      }
    }
    return false;
  }
  
  public final boolean nX()
  {
    if (!this.aiD) {
      return false;
    }
    t localt = new t();
    localt.Xh = this.agi;
    localt.XU = false;
    if (this.aiB.size() > 0) {}
    for (localt.XT = ((g)this.aiB.getFirst()).aiI.XQ;; localt.XT = System.currentTimeMillis()) {
      try
      {
        b(11019, localt.toByteArray());
        return true;
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.MessageHistoryAdapter", localIOException);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.f
 * JD-Core Version:    0.7.0.1
 */