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
  private String acH;
  private com.tencent.mm.wear.app.f.b adI;
  private LinkedList<g> aeZ = new LinkedList();
  private HashSet<Long> afa = new HashSet();
  private boolean afb = true;
  private h afc;
  
  public f(Context paramContext, String paramString)
  {
    super(paramContext);
    this.acH = paramString;
  }
  
  private g a(com.tencent.mm.e.a.s params)
  {
    g localg = new g(this);
    localg.afg = params;
    boolean bool = params.VN.equals(com.tencent.mm.wear.app.b.h.mb().lT().Vm);
    int i;
    switch (params.VU)
    {
    default: 
      return localg;
    case 1: 
      if (bool) {}
      for (i = 2;; i = 1)
      {
        localg.afh = i;
        return localg;
      }
    case 2: 
      if (bool) {}
      for (i = 4;; i = 3)
      {
        localg.afh = i;
        return localg;
      }
    case 4: 
      if (bool) {}
      for (i = 7;; i = 6)
      {
        localg.afh = i;
        return localg;
      }
    case 5: 
      if (bool) {}
      for (i = 9;; i = 8)
      {
        localg.afh = i;
        return localg;
      }
    case 6: 
      if (bool) {}
      for (i = 11;; i = 10)
      {
        localg.afh = i;
        return localg;
      }
    }
    localg.afh = 5;
    return localg;
  }
  
  private void ai(final int paramInt1, final int paramInt2)
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MessageHistoryAdapter", "Message History notifyRequestDataEnd %d", new Object[] { Integer.valueOf(this.aeZ.size()) });
    com.tencent.mm.wear.a.b.a.aiT.postDelayed(new Runnable()
    {
      public final void run()
      {
        f.this.setCount(f.a(f.this).size());
        f.this.clearCache();
        f.this.notifyDataSetChanged();
        if (f.b(f.this) != null) {
          f.b(f.this).af(paramInt1, paramInt2);
        }
      }
    }, 500L);
  }
  
  private void b(int paramInt, byte[] paramArrayOfByte)
  {
    if (this.adI != null)
    {
      this.adI.cancel();
      this.adI = null;
    }
    this.adI = new com.tencent.mm.wear.app.f.b(paramInt, paramArrayOfByte);
    this.adI.a(this);
    this.adI.F(true);
    com.tencent.mm.wear.app.b.h.mc().a(this.adI);
  }
  
  public final void a(h paramh)
  {
    this.afc = paramh;
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
      paramArrayOfByte = ((com.tencent.mm.e.a.u)localObject).Wb.iterator();
      while (paramArrayOfByte.hasNext())
      {
        com.tencent.mm.e.a.s locals = (com.tencent.mm.e.a.s)paramArrayOfByte.next();
        if (this.afa.add(Long.valueOf(locals.VO)))
        {
          this.aeZ.add(a(locals));
          continue;
          localObject = new z();
          try
          {
            ((z)localObject).h(paramArrayOfByte);
            paramArrayOfByte = ((z)localObject).Wb.iterator();
            while (paramArrayOfByte.hasNext())
            {
              locals = (com.tencent.mm.e.a.s)paramArrayOfByte.next();
              if (this.afa.add(Long.valueOf(locals.VO))) {
                this.aeZ.add(a(locals));
              }
            }
            this.afb = ((z)localObject).Wa;
          }
          catch (IOException paramArrayOfByte)
          {
            com.tencent.mm.wear.a.c.d.a("MicroMsg.MessageHistoryAdapter", paramArrayOfByte);
            return;
          }
          Collections.sort(this.aeZ);
          ai(((z)localObject).Wb.size(), 1);
          return;
        }
      }
    }
    catch (IOException paramArrayOfByte)
    {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.MessageHistoryAdapter", paramArrayOfByte);
      return;
    }
    if (!((com.tencent.mm.e.a.u)localObject).VZ) {
      this.afb = ((com.tencent.mm.e.a.u)localObject).Wa;
    }
    Collections.sort(this.aeZ);
    if (((com.tencent.mm.e.a.u)localObject).VZ)
    {
      ai(((com.tencent.mm.e.a.u)localObject).Wb.size(), 3);
      return;
    }
    ai(((com.tencent.mm.e.a.u)localObject).Wb.size(), 2);
  }
  
  public final com.tencent.mm.wear.app.ui.a.a bS(int paramInt)
  {
    Object localObject2 = (g)this.aeZ.get(paramInt);
    Object localObject1 = null;
    switch (((g)localObject2).afh)
    {
    default: 
      if (localObject1 != null)
      {
        ((com.tencent.mm.wear.app.ui.a.a)localObject1).ahe = ((g)localObject2);
        localObject2 = this.acH;
        if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
          break label250;
        }
      }
      break;
    }
    label250:
    for (boolean bool = false;; bool = ((String)localObject2).endsWith("@chatroom"))
    {
      ((com.tencent.mm.wear.app.ui.a.a)localObject1).H(bool);
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
  
  public final List<com.tencent.mm.e.a.s> bV(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt < this.aeZ.size())
    {
      localArrayList.add(((g)this.aeZ.get(paramInt)).afg);
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public final void finish()
  {
    if (this.adI != null) {
      this.adI.cancel();
    }
  }
  
  public final void ni()
  {
    y localy = new y();
    localy.Vm = this.acH;
    localy.VY = System.currentTimeMillis();
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
  
  public final boolean nj()
  {
    t localt = new t();
    localt.Vm = this.acH;
    localt.VZ = true;
    if (this.aeZ.size() > 0) {}
    for (localt.VY = ((g)this.aeZ.getLast()).afg.VV;; localt.VY = System.currentTimeMillis()) {
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
  
  public final boolean nk()
  {
    if (!this.afb) {
      return false;
    }
    t localt = new t();
    localt.Vm = this.acH;
    localt.VZ = false;
    if (this.aeZ.size() > 0) {}
    for (localt.VY = ((g)this.aeZ.getFirst()).afg.VV;; localt.VY = System.currentTimeMillis()) {
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