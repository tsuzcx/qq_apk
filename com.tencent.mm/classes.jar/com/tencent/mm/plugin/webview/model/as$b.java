package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class as$b
{
  public Bundle mEJ = null;
  
  public as$b(as paramas, Bundle paramBundle)
  {
    this.mEJ = paramBundle;
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    AppMethodBeat.i(6760);
    if (this.mEJ != null)
    {
      if ((paramObject instanceof String))
      {
        this.mEJ.putString(paramString, (String)paramObject);
        AppMethodBeat.o(6760);
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        this.mEJ.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        AppMethodBeat.o(6760);
        return;
      }
      if ((paramObject instanceof Integer))
      {
        this.mEJ.putInt(paramString, ((Integer)paramObject).intValue());
        AppMethodBeat.o(6760);
        return;
      }
      ab.w("MicroMsg.WebviewReporter", "put unknow type value.");
    }
    AppMethodBeat.o(6760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.as.b
 * JD-Core Version:    0.7.0.1
 */