package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class x
  extends MAutoStorage<w>
{
  public static int EmU;
  public static final String[] SQL_CREATE;
  public static int STATE_DEFAULT;
  public h iFy;
  
  static
  {
    AppMethodBeat.i(203224);
    STATE_DEFAULT = 0;
    EmU = 1;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(w.info, "SnsWsFoldGroup") };
    AppMethodBeat.o(203224);
  }
  
  public x(h paramh)
  {
    super(paramh, s.info, "SnsWsFoldGroup", null);
    this.iFy = paramh;
  }
  
  public final boolean a(w paramw)
  {
    AppMethodBeat.i(203223);
    if (paramw.field_size >= ah.DKg) {
      paramw.field_state = EmU;
    }
    paramw = paramw.convertTo();
    if (this.iFy.replace("SnsWsFoldGroup", "bottom", paramw) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsWsFoldGroupStorage", "SnsWsFoldGroup replace result ".concat(String.valueOf(bool)));
      AppMethodBeat.o(203223);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.x
 * JD-Core Version:    0.7.0.1
 */