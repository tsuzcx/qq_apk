package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends j<k>
{
  public static final String[] SQL_CREATE;
  private final a EMX;
  
  static
  {
    AppMethodBeat.i(151753);
    SQL_CREATE = new String[] { j.getCreateSQLs(k.info, "AppMessage") };
    AppMethodBeat.o(151753);
  }
  
  public l(e parame)
  {
    super(parame, k.info, "AppMessage", null);
    AppMethodBeat.i(195371);
    this.EMX = new a((byte)0);
    AppMethodBeat.o(195371);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(195372);
    if (paramb == null)
    {
      AppMethodBeat.o(195372);
      return;
    }
    this.EMX.EMY.put(paramb, new Object());
    AppMethodBeat.o(195372);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(195373);
    this.EMX.EMY.remove(paramb);
    AppMethodBeat.o(195373);
  }
  
  public final k xH(long paramLong)
  {
    AppMethodBeat.i(151752);
    if (this.EMX.xI(paramLong))
    {
      localk = this.EMX.xH(paramLong);
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
    ConcurrentHashMap<l.b, Object> EMY;
    
    private a()
    {
      AppMethodBeat.i(195365);
      this.EMY = new ConcurrentHashMap();
      AppMethodBeat.o(195365);
    }
    
    public final boolean a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(195369);
      Iterator localIterator = this.EMY.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.xI(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean);
          AppMethodBeat.o(195369);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(195369);
      return false;
    }
    
    public final boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
    {
      AppMethodBeat.i(195370);
      Iterator localIterator = this.EMY.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.xI(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean, paramVarArgs);
          AppMethodBeat.o(195370);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(195370);
      return false;
    }
    
    public final boolean b(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(195368);
      Iterator localIterator = this.EMY.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.xI(paramk.field_msgId))
        {
          paramBoolean = localb.b(paramk, paramBoolean);
          AppMethodBeat.o(195368);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(195368);
      return false;
    }
    
    public final k xH(long paramLong)
    {
      AppMethodBeat.i(195367);
      Object localObject = this.EMY.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l.b localb = (l.b)((Iterator)localObject).next();
        if (localb.xI(paramLong))
        {
          localObject = localb.xH(paramLong);
          AppMethodBeat.o(195367);
          return localObject;
        }
      }
      AppMethodBeat.o(195367);
      return null;
    }
    
    public final boolean xI(long paramLong)
    {
      AppMethodBeat.i(195366);
      Iterator localIterator = this.EMY.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((l.b)localIterator.next()).xI(paramLong))
        {
          AppMethodBeat.o(195366);
          return true;
        }
      }
      AppMethodBeat.o(195366);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(k paramk, boolean paramBoolean);
    
    public abstract boolean a(k paramk, boolean paramBoolean, String... paramVarArgs);
    
    public abstract boolean b(k paramk, boolean paramBoolean);
    
    public abstract k xH(long paramLong);
    
    public abstract boolean xI(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.l
 * JD-Core Version:    0.7.0.1
 */