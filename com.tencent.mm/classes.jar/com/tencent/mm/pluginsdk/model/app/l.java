package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends MAutoStorage<k>
{
  public static final String[] SQL_CREATE;
  private final a QWA;
  
  static
  {
    AppMethodBeat.i(151753);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.info, "AppMessage") };
    AppMethodBeat.o(151753);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.info, "AppMessage", null);
    AppMethodBeat.i(225207);
    this.QWA = new a((byte)0);
    AppMethodBeat.o(225207);
  }
  
  public final k NR(long paramLong)
  {
    AppMethodBeat.i(151752);
    if (this.QWA.NS(paramLong))
    {
      localk = this.QWA.NR(paramLong);
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
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(225211);
    if (paramb == null)
    {
      AppMethodBeat.o(225211);
      return;
    }
    this.QWA.QWB.put(paramb, new Object());
    AppMethodBeat.o(225211);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(225212);
    this.QWA.QWB.remove(paramb);
    AppMethodBeat.o(225212);
  }
  
  static final class a
    implements l.b
  {
    ConcurrentHashMap<l.b, Object> QWB;
    
    private a()
    {
      AppMethodBeat.i(217279);
      this.QWB = new ConcurrentHashMap();
      AppMethodBeat.o(217279);
    }
    
    public final k NR(long paramLong)
    {
      AppMethodBeat.i(217281);
      Object localObject = this.QWB.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l.b localb = (l.b)((Iterator)localObject).next();
        if (localb.NS(paramLong))
        {
          localObject = localb.NR(paramLong);
          AppMethodBeat.o(217281);
          return localObject;
        }
      }
      AppMethodBeat.o(217281);
      return null;
    }
    
    public final boolean NS(long paramLong)
    {
      AppMethodBeat.i(217280);
      Iterator localIterator = this.QWB.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((l.b)localIterator.next()).NS(paramLong))
        {
          AppMethodBeat.o(217280);
          return true;
        }
      }
      AppMethodBeat.o(217280);
      return false;
    }
    
    public final boolean a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(217285);
      Iterator localIterator = this.QWB.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.NS(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean);
          AppMethodBeat.o(217285);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(217285);
      return false;
    }
    
    public final boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
    {
      AppMethodBeat.i(217286);
      Iterator localIterator = this.QWB.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.NS(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean, paramVarArgs);
          AppMethodBeat.o(217286);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(217286);
      return false;
    }
    
    public final boolean b(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(217284);
      Iterator localIterator = this.QWB.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.NS(paramk.field_msgId))
        {
          paramBoolean = localb.b(paramk, paramBoolean);
          AppMethodBeat.o(217284);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(217284);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract k NR(long paramLong);
    
    public abstract boolean NS(long paramLong);
    
    public abstract boolean a(k paramk, boolean paramBoolean);
    
    public abstract boolean a(k paramk, boolean paramBoolean, String... paramVarArgs);
    
    public abstract boolean b(k paramk, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.l
 * JD-Core Version:    0.7.0.1
 */