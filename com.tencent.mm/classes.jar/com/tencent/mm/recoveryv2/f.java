package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class f
{
  public static void a(Context paramContext, String paramString, RecoveryCrash.Record paramRecord, e parame)
  {
    AppMethodBeat.i(190016);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "fallback");
      localJSONObject.put("time", paramRecord.SSg);
      localJSONObject.put("crash_count", paramRecord.SSh);
      localJSONObject.put("version", paramRecord.UPe);
      localJSONObject.put("actions", parame.getDescription());
      paramContext.getSharedPreferences("recovery_journal_fallback", 4).edit().putString(paramString, localJSONObject.toString()).apply();
      AppMethodBeat.o(190016);
      return;
    }
    catch (Throwable paramContext)
    {
      a.w("MicroMsg.recovery.journal", "put fallback desc fail", paramContext);
      AppMethodBeat.o(190016);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.f
 * JD-Core Version:    0.7.0.1
 */