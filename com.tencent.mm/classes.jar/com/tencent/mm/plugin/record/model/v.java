package com.tencent.mm.plugin.record.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class v
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  
  static
  {
    AppMethodBeat.i(27827);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new v.1());
    baseDBFactories.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return e.SQL_CREATE;
      }
    });
    AppMethodBeat.o(27827);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(27826);
    h.b(g.class, new n());
    AppMethodBeat.o(27826);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.v
 * JD-Core Version:    0.7.0.1
 */