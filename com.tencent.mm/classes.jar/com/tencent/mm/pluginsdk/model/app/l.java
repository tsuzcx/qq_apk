package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class l
  extends MAutoStorage<k>
{
  public static final String[] SQL_CREATE;
  public final a XSx;
  
  static
  {
    AppMethodBeat.i(151753);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.info, "AppMessage") };
    AppMethodBeat.o(151753);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, k.info, "AppMessage", null);
    AppMethodBeat.i(244879);
    this.XSx = new a((byte)0);
    AppMethodBeat.o(244879);
  }
  
  public final k rI(long paramLong)
  {
    AppMethodBeat.i(151752);
    if (this.XSx.rJ(paramLong))
    {
      localk = this.XSx.rI(paramLong);
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
  
  public static final class a
    implements l.b
  {
    public ConcurrentHashMap<l.b, Object> XSy;
    
    private a()
    {
      AppMethodBeat.i(244839);
      this.XSy = new ConcurrentHashMap();
      AppMethodBeat.o(244839);
    }
    
    public final boolean a(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(244852);
      Iterator localIterator = this.XSy.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.rJ(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean);
          AppMethodBeat.o(244852);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(244852);
      return false;
    }
    
    public final boolean a(k paramk, boolean paramBoolean, String... paramVarArgs)
    {
      AppMethodBeat.i(244853);
      Iterator localIterator = this.XSy.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.rJ(paramk.field_msgId))
        {
          paramBoolean = localb.a(paramk, paramBoolean, paramVarArgs);
          AppMethodBeat.o(244853);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(244853);
      return false;
    }
    
    public final boolean b(k paramk, boolean paramBoolean)
    {
      AppMethodBeat.i(244847);
      Iterator localIterator = this.XSy.keySet().iterator();
      while (localIterator.hasNext())
      {
        l.b localb = (l.b)localIterator.next();
        if (localb.rJ(paramk.field_msgId))
        {
          paramBoolean = localb.b(paramk, paramBoolean);
          AppMethodBeat.o(244847);
          return paramBoolean;
        }
      }
      AppMethodBeat.o(244847);
      return false;
    }
    
    public final k rI(long paramLong)
    {
      AppMethodBeat.i(244844);
      Object localObject = this.XSy.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        l.b localb = (l.b)((Iterator)localObject).next();
        if (localb.rJ(paramLong))
        {
          localObject = localb.rI(paramLong);
          AppMethodBeat.o(244844);
          return localObject;
        }
      }
      AppMethodBeat.o(244844);
      return null;
    }
    
    public final boolean rJ(long paramLong)
    {
      AppMethodBeat.i(244842);
      Iterator localIterator = this.XSy.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((l.b)localIterator.next()).rJ(paramLong))
        {
          AppMethodBeat.o(244842);
          return true;
        }
      }
      AppMethodBeat.o(244842);
      return false;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(k paramk, boolean paramBoolean);
    
    public abstract boolean a(k paramk, boolean paramBoolean, String... paramVarArgs);
    
    public abstract boolean b(k paramk, boolean paramBoolean);
    
    public abstract k rI(long paramLong);
    
    public abstract boolean rJ(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.l
 * JD-Core Version:    0.7.0.1
 */