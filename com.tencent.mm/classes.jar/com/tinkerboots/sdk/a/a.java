package com.tinkerboots.sdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tinkerboots.sdk.a.a.b;
import com.tinkerboots.sdk.b.c;

public final class a
{
  private static volatile a BLG;
  public b BLF;
  public final com.tinkerboots.sdk.a.b.a BLH;
  public long hin;
  public boolean isDebug;
  
  private a(b paramb)
  {
    AppMethodBeat.i(65525);
    this.hin = 10800000L;
    this.BLH = com.tinkerboots.sdk.a.b.a.eaL();
    this.BLF = paramb;
    AppMethodBeat.o(65525);
  }
  
  public static a a(b paramb)
  {
    AppMethodBeat.i(65526);
    if (BLG != null)
    {
      paramb = new RuntimeException("tinker server client is already init");
      AppMethodBeat.o(65526);
      throw paramb;
    }
    if (BLG == null) {}
    try
    {
      if (BLG == null) {
        BLG = new a(paramb);
      }
      paramb = BLG;
      AppMethodBeat.o(65526);
      return paramb;
    }
    finally
    {
      AppMethodBeat.o(65526);
    }
  }
  
  private static boolean eaK()
  {
    AppMethodBeat.i(65529);
    com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
    boolean bool = c.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1L).commit();
    AppMethodBeat.o(65529);
    return bool;
  }
  
  public final void TP(int paramInt)
  {
    AppMethodBeat.i(65528);
    if (paramInt == -1L)
    {
      eaK();
      AppMethodBeat.o(65528);
      return;
    }
    if ((paramInt < 0) || (paramInt > 24))
    {
      TinkerRuntimeException localTinkerRuntimeException = new TinkerRuntimeException("hours must be between 0 and 24");
      AppMethodBeat.o(65528);
      throw localTinkerRuntimeException;
    }
    this.hin = (paramInt * 3600L * 1000L);
    AppMethodBeat.o(65528);
  }
  
  public final void jj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(65527);
    this.BLH.jk(paramString1, paramString2);
    AppMethodBeat.o(65527);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tinkerboots.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */