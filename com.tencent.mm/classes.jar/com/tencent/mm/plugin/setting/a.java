package com.tencent.mm.plugin.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  public static int Xm(int paramInt)
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
  
  public static void g(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(256452);
    paramContext = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
    paramContext.putFloat("current_text_size_scale_key", paramFloat);
    Log.i("MicroMsg.FontSizeService", "CURRENT_TEXT_SIZE_KEY put result: ".concat(String.valueOf(paramContext.commit())));
    AppMethodBeat.o(256452);
  }
  
  public static float gV(Context paramContext)
  {
    float f = 1.0F;
    AppMethodBeat.i(256453);
    if (paramContext != null) {
      f = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", 1.0F);
    }
    AppMethodBeat.o(256453);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.a
 * JD-Core Version:    0.7.0.1
 */