package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends MAutoStorage<k>
{
  public static final String[] SQL_CREATE;
  private final a JWl;
  
  static
  {
    AppMethodBeat.i(151753);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.info, "AppMessage") };
    AppMethodBeat.o(151753);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.info, "AppMessage", null);
    AppMethodBeat.i(223759);
    this.JWl = new a((byte)0);
    AppMethodBeat.o(223759);
  }
  
  public final k GL(long paramLong)
  {
    AppMethodBeat.i(151752);
    if (this.JWl.GM(paramLong))
    {
      localk = this.JWl.GL(paramLong);
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
    AppMethodBeat.i(223760);
    if (paramb == null)
    {
      AppMethodBeat.o(223760);
      return;
    }
    this.JWl.JWm.put(paramb, new Object());
    AppMethodBeat.o(223760);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(223761);
    this.JWl.JWm.remove(paramb);
    AppMethodBeat.o(223761);
  }
  
  static final class a
    implements l.b
  {
    ConcurrentHashMap<l.b, Object> JWm;
    
    private a()
    {
      AppMethodBeat.i(223753);
      this.JWm = new ConcurrentHashMap();
      AppMethodBeat.o(223753);
    }
    
    public final k GL(long paramLong)
    {
      AppMethodBeat.i(223755);
      Object localObject = this.JWm.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l.b localb = (l.b)((Iterator)localObject).next();
        if (localb.GM(paramLong))
        {
          localObject = localb.GL(paramLong);
          AppMethodBeat.o(223755);
          return localObject;
        }
      }
      AppMethodBeat.o(223755);
      return null;
    }
    
    public final boolean GM(long paramLong)
    {
      AppMethodBeat.i(223754);
      Iterator localIterator = this.JWm.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((l.b)localIterator.next()).GM(paramLong))
        {
          AppMethodBeat.o(223754);
          return true;
        }
      }
      AppMethodBeat.o(223754);
      return false;
    }
    
    public final boolean a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(223757);
      Iterator localIterator = this.JWm.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.GM(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean);
          AppMethodBeat.o(223757);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(223757);
      return false;
    }
    
    public final boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
    {
      AppMethodBeat.i(223758);
      Iterator localIterator = this.JWm.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.GM(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean, paramVarArgs);
          AppMethodBeat.o(223758);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(223758);
      return false;
    }
    
    public final boolean b(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(223756);
      Iterator localIterator = this.JWm.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.GM(paramk.field_msgId))
        {
          paramBoolean = localb.b(paramk, paramBoolean);
          AppMethodBeat.o(223756);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(223756);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract k GL(long paramLong);
    
    public abstract boolean GM(long paramLong);
    
    public abstract boolean a(k paramk, boolean paramBoolean);
    
    public abstract boolean a(k paramk, boolean paramBoolean, String... paramVarArgs);
    
    public abstract boolean b(k paramk, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.l
 * JD-Core Version:    0.7.0.1
 */