package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public final class v
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  
  static
  {
    AppMethodBeat.i(27827);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return h.SQL_CREATE;
      }
    });
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
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.record.a.g.class, new m());
    AppMethodBeat.o(27826);
  }
  
  public final void onAccountRelease() {}
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.v
 * JD-Core Version:    0.7.0.1
 */