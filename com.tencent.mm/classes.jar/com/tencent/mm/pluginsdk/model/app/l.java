package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  private final a Ffu;
  
  static
  {
    AppMethodBeat.i(151753);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "AppMessage") };
    AppMethodBeat.o(151753);
  }
  
  public l(e parame)
  {
    super(parame, k.info, "AppMessage", null);
    AppMethodBeat.i(218824);
    this.Ffu = new a((byte)0);
    AppMethodBeat.o(218824);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(218825);
    if (paramb == null)
    {
      AppMethodBeat.o(218825);
      return;
    }
    this.Ffu.Ffv.put(paramb, new Object());
    AppMethodBeat.o(218825);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(218826);
    this.Ffu.Ffv.remove(paramb);
    AppMethodBeat.o(218826);
  }
  
  public final k yb(long paramLong)
  {
    AppMethodBeat.i(151752);
    if (this.Ffu.yc(paramLong))
    {
      localk = this.Ffu.yb(paramLong);
      AppMethodBeat.o(151752);
      return localk;
    }
    k localk = new k();
    localk.field_msgId = paramLong;
    if (super.get(localk, new String[0]))
    {
      AppMethodBeat.o(151752);
      return localk;
    }
    AppMethodBeat.o(151752);
    return null;
  }
  
  static final class a
    implements l.b
  {
    ConcurrentHashMap<l.b, Object> Ffv;
    
    private a()
    {
      AppMethodBeat.i(218818);
      this.Ffv = new ConcurrentHashMap();
      AppMethodBeat.o(218818);
    }
    
    public final boolean a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(218822);
      Iterator localIterator = this.Ffv.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.yc(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean);
          AppMethodBeat.o(218822);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(218822);
      return false;
    }
    
    public final boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
    {
      AppMethodBeat.i(218823);
      Iterator localIterator = this.Ffv.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.yc(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean, paramVarArgs);
          AppMethodBeat.o(218823);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(218823);
      return false;
    }
    
    public final boolean b(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(218821);
      Iterator localIterator = this.Ffv.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.yc(paramk.field_msgId))
        {
          paramBoolean = localb.b(paramk, paramBoolean);
          AppMethodBeat.o(218821);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(218821);
      return false;
    }
    
    public final k yb(long paramLong)
    {
      AppMethodBeat.i(218820);
      Object localObject = this.Ffv.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l.b localb = (l.b)((Iterator)localObject).next();
        if (localb.yc(paramLong))
        {
          localObject = localb.yb(paramLong);
          AppMethodBeat.o(218820);
          return localObject;
        }
      }
      AppMethodBeat.o(218820);
      return null;
    }
    
    public final boolean yc(long paramLong)
    {
      AppMethodBeat.i(218819);
      Iterator localIterator = this.Ffv.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((l.b)localIterator.next()).yc(paramLong))
        {
          AppMethodBeat.o(218819);
          return true;
        }
      }
      AppMethodBeat.o(218819);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(k paramk, boolean paramBoolean);
    
    public abstract boolean a(k paramk, boolean paramBoolean, String... paramVarArgs);
    
    public abstract boolean b(k paramk, boolean paramBoolean);
    
    public abstract k yb(long paramLong);
    
    public abstract boolean yc(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.l
 * JD-Core Version:    0.7.0.1
 */