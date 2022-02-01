package com.tencent.mm.plugin.secdata.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.plugin.p.h;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoStorage;", "Lcom/tencent/mm/plugin/livestorage/MMLiveStorage;", "Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfo;", "dbProvider", "Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;", "(Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanExpireData", "", "deleteById", "", "id", "getById", "getLogTag", "plugin-sec-data_release"})
public final class d
  extends h<b>
{
  public final String TAG;
  
  public d(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(197908);
    this.TAG = "MicroMsg.SecData.SecReportDataInfoStorage";
    AppMethodBeat.o(197908);
  }
  
  public final b aXJ(String paramString)
  {
    AppMethodBeat.i(197905);
    p.k(paramString, "id");
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", paramString);
    paramString = (b)a(localContentValues, ab.bO(b.class));
    AppMethodBeat.o(197905);
    return paramString;
  }
  
  public final int aXK(String paramString)
  {
    AppMethodBeat.i(197907);
    p.k(paramString, "id");
    paramString = aXJ(paramString);
    if (paramString != null)
    {
      int i = h.b(this, (IAutoDBItem)paramString, false, false, 6);
      AppMethodBeat.o(197907);
      return i;
    }
    AppMethodBeat.o(197907);
    return 0;
  }
  
  public final String getLogTag()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.a.d
 * JD-Core Version:    0.7.0.1
 */