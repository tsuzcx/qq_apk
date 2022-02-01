package com.tinkerboots.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tinkerboots.sdk.a.a.b;
import com.tinkerboots.sdk.b.c;

public final class a
{
  private static volatile a KJC;
  public b KJB;
  public final com.tinkerboots.sdk.a.b.a KJD;
  public boolean cuo;
  public long jDm;
  
  private a(b paramb)
  {
    AppMethodBeat.i(3432);
    this.jDm = 10800000L;
    this.KJD = com.tinkerboots.sdk.a.b.a.fMA();
    this.KJB = paramb;
    AppMethodBeat.o(3432);
  }
  
  public static a a(b paramb)
  {
    AppMethodBeat.i(3433);
    if (KJC != null)
    {
      paramb = new RuntimeException("tinker server client is already init");
      AppMethodBeat.o(3433);
      throw paramb;
    }
    if (KJC == null) {}
    try
    {
      if (KJC == null) {
        KJC = new a(paramb);
      }
      paramb = KJC;
      AppMethodBeat.o(3433);
      return paramb;
    }
    finally
    {
      AppMethodBeat.o(3433);
    }
  }
  
  private static boolean fMz()
  {
    AppMethodBeat.i(3436);
    ShareTinkerLog.v("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
    boolean bool = c.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1L).commit();
    AppMethodBeat.o(3436);
    return bool;
  }
  
  public final void ags(int paramInt)
  {
    AppMethodBeat.i(3435);
    if (paramInt == -1L)
    {
      fMz();
      AppMethodBeat.o(3435);
      return;
    }
    if ((paramInt < 0) || (paramInt > 24))
    {
      TinkerRuntimeException localTinkerRuntimeException = new TinkerRuntimeException("hours must be between 0 and 24");
      AppMethodBeat.o(3435);
      throw localTinkerRuntimeException;
    }
    this.jDm = (paramInt * 3600L * 1000L);
    AppMethodBeat.o(3435);
  }
  
  public final void mP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3434);
    this.KJD.mQ(paramString1, paramString2);
    AppMethodBeat.o(3434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */