package com.tencent.mm.plugin.secdata.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ac.g;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ai;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfoStorage;", "Lcom/tencent/mm/plugin/mvvmstorage/MvvmStorage;", "Lcom/tencent/mm/plugin/secdata/model/SecReportDataInfo;", "dbProvider", "Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "(Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cleanExpireData", "", "deleteById", "", "id", "getById", "getLogTag", "plugin-sec-data_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends g<b>
{
  public final String TAG;
  
  public d(IMvvmDBProvider paramIMvvmDBProvider)
  {
    super(paramIMvvmDBProvider);
    AppMethodBeat.i(261453);
    this.TAG = "MicroMsg.SecData.SecReportDataInfoStorage";
    AppMethodBeat.o(261453);
  }
  
  public final b aVs(String paramString)
  {
    AppMethodBeat.i(261462);
    s.u(paramString, "id");
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", paramString);
    paramString = ah.aiuX;
    paramString = (b)a(localContentValues, ai.cz(b.class));
    AppMethodBeat.o(261462);
    return paramString;
  }
  
  public final int aVt(String paramString)
  {
    AppMethodBeat.i(261471);
    s.u(paramString, "id");
    paramString = aVs(paramString);
    if (paramString != null)
    {
      int i = g.b((g)this, (IAutoDBItem)paramString, false, false, 6);
      AppMethodBeat.o(261471);
      return i;
    }
    AppMethodBeat.o(261471);
    return 0;
  }
  
  public final String getLogTag()
  {
    return this.TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.a.d
 * JD-Core Version:    0.7.0.1
 */