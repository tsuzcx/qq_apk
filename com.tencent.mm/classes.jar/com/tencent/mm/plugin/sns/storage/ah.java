package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class ah
  extends MAutoStorage<ag>
{
  public static int DYC;
  public static int QZC;
  public static final String[] SQL_CREATE;
  public h omV;
  
  static
  {
    AppMethodBeat.i(306535);
    DYC = 0;
    QZC = 1;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(ag.info, "SnsWsFoldGroup") };
    AppMethodBeat.o(306535);
  }
  
  public ah(h paramh)
  {
    super(paramh, ac.info, "SnsWsFoldGroup", null);
    this.omV = paramh;
  }
  
  public final boolean a(ag paramag)
  {
    AppMethodBeat.i(306539);
    if (paramag.field_size >= aj.Quq) {
      paramag.field_state = QZC;
    }
    paramag = paramag.convertTo();
    if (this.omV.replace("SnsWsFoldGroup", "bottom", paramag) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.SnsWsFoldGroupStorage", "SnsWsFoldGroup replace result ".concat(String.valueOf(bool)));
      AppMethodBeat.o(306539);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.ah
 * JD-Core Version:    0.7.0.1
 */