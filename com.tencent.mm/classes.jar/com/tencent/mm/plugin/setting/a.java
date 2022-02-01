package com.tencent.mm.plugin.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.k.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static void a(Context paramContext, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(298495);
    com.tencent.mm.cd.a.i(paramContext, paramFloat);
    h(paramContext, paramFloat);
    paramContext = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
    paramContext.putInt("current_text_size_index_key", paramInt);
    Log.i("MicroMsg.FontSizeService", "set CURRENT_TEXT_INDEX_KEY result: ".concat(String.valueOf(paramContext.commit())));
    m.Jf(true);
    AppMethodBeat.o(298495);
  }
  
  public static int aiQ(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 400;
    case 0: 
      return 440;
    case 2: 
    case 3: 
      return 360;
    }
    return 340;
  }
  
  public static void h(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(298511);
    paramContext = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
    paramContext.putFloat("current_text_size_scale_key", paramFloat);
    Log.i("MicroMsg.FontSizeService", "CURRENT_TEXT_SIZE_KEY put result: ".concat(String.valueOf(paramContext.commit())));
    AppMethodBeat.o(298511);
  }
  
  public static int jD(Context paramContext)
  {
    int i = 1;
    AppMethodBeat.i(298499);
    if (paramContext != null) {
      i = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("current_text_size_index_key", 1);
    }
    AppMethodBeat.o(298499);
    return i;
  }
  
  public static float jE(Context paramContext)
  {
    float f = 1.0F;
    AppMethodBeat.i(298515);
    if (paramContext != null) {
      f = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", 1.0F);
    }
    AppMethodBeat.o(298515);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.a
 * JD-Core Version:    0.7.0.1
 */