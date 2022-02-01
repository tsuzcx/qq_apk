package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class x
  extends MAutoStorage<w>
{
  public static int KAd;
  public static final String[] SQL_CREATE;
  public static int zci;
  public h lvy;
  
  static
  {
    AppMethodBeat.i(196048);
    zci = 0;
    KAd = 1;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(w.info, "SnsWsFoldGroup") };
    AppMethodBeat.o(196048);
  }
  
  public x(h paramh)
  {
    super(paramh, s.info, "SnsWsFoldGroup", null);
    this.lvy = paramh;
  }
  
  public final boolean a(w paramw)
  {
    AppMethodBeat.i(196046);
    if (paramw.field_size >= ah.JXi) {
      paramw.field_state = KAd;
    }
    paramw = paramw.convertTo();
    if (this.lvy.replace("SnsWsFoldGroup", "bottom", paramw) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsWsFoldGroupStorage", "SnsWsFoldGroup replace result ".concat(String.valueOf(bool)));
      AppMethodBeat.o(196046);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.x
 * JD-Core Version:    0.7.0.1
 */