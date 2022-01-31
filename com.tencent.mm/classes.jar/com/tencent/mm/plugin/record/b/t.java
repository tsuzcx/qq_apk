package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.f;
import java.util.HashMap;

public final class t
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  
  static
  {
    AppMethodBeat.i(24189);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new t.1());
    baseDBFactories.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    AppMethodBeat.o(24189);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24188);
    g.b(f.class, new k());
    AppMethodBeat.o(24188);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.t
 * JD-Core Version:    0.7.0.1
 */