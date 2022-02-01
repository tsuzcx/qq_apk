package com.tencent.mm.plugin.teenmode.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storagebase.h;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeStorageMgr;", "", "()V", "AuthorizationStg", "Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeAuthorizationStorage;", "getAuthorizationStg", "()Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeAuthorizationStorage;", "AuthorizationStg$delegate", "Lkotlin/Lazy;", "BindGuardian", "Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeBindGuardianStorage;", "getBindGuardian", "()Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeBindGuardianStorage;", "BindGuardian$delegate", "_db", "Lcom/tencent/mm/storagebase/SqliteDB;", "get_db", "()Lcom/tencent/mm/storagebase/SqliteDB;", "_db$delegate", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e SZq;
  private static final j SZr;
  private static final j SZs;
  private static final j SZt;
  
  static
  {
    AppMethodBeat.i(278926);
    SZq = new e();
    SZr = k.cm((a)c.SZw);
    SZs = k.cm((a)a.SZu);
    SZt = k.cm((a)b.SZv);
    AppMethodBeat.o(278926);
  }
  
  public static c hEB()
  {
    AppMethodBeat.i(278907);
    c localc = (c)SZs.getValue();
    AppMethodBeat.o(278907);
    return localc;
  }
  
  public static d hEC()
  {
    AppMethodBeat.i(278913);
    d locald = (d)SZt.getValue();
    AppMethodBeat.o(278913);
    return locald;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeAuthorizationStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<c>
  {
    public static final a SZu;
    
    static
    {
      AppMethodBeat.i(278883);
      SZu = new a();
      AppMethodBeat.o(278883);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeBindGuardianStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<d>
  {
    public static final b SZv;
    
    static
    {
      AppMethodBeat.i(278884);
      SZv = new b();
      AppMethodBeat.o(278884);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/storagebase/SqliteDB;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<h>
  {
    public static final c SZw;
    
    static
    {
      AppMethodBeat.i(278894);
      SZw = new c();
      AppMethodBeat.o(278894);
    }
    
    c()
    {
      super();
    }
    
    private static final String[] hEE()
    {
      AppMethodBeat.i(278880);
      Object localObject = c.SZo;
      localObject = c.hEA();
      AppMethodBeat.o(278880);
      return localObject;
    }
    
    private static final String[] hEF()
    {
      AppMethodBeat.i(278886);
      Object localObject = d.SZp;
      localObject = d.hEA();
      AppMethodBeat.o(278886);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.a.e
 * JD-Core Version:    0.7.0.1
 */