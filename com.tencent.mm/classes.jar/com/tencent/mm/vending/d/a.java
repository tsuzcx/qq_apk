package com.tencent.mm.vending.d;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a
{
  Bundle mExtras;
  
  public a(Intent paramIntent)
  {
    AppMethodBeat.i(74872);
    this.mExtras = null;
    this.mExtras = paramIntent.getExtras();
    AppMethodBeat.o(74872);
  }
  
  public final int getIntExtra(String paramString, int paramInt)
  {
    AppMethodBeat.i(74873);
    if (this.mExtras == null)
    {
      AppMethodBeat.o(74873);
      return paramInt;
    }
    paramInt = this.mExtras.getInt(paramString, paramInt);
    AppMethodBeat.o(74873);
    return paramInt;
  }
  
  public final ArrayList<String> getStringArrayListExtra(String paramString)
  {
    AppMethodBeat.i(74875);
    if (this.mExtras == null)
    {
      AppMethodBeat.o(74875);
      return null;
    }
    paramString = this.mExtras.getStringArrayList(paramString);
    AppMethodBeat.o(74875);
    return paramString;
  }
  
  public final String getStringExtra(String paramString)
  {
    AppMethodBeat.i(74874);
    if (this.mExtras == null)
    {
      AppMethodBeat.o(74874);
      return null;
    }
    paramString = this.mExtras.getString(paramString);
    AppMethodBeat.o(74874);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.d.a
 * JD-Core Version:    0.7.0.1
 */