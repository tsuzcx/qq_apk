package com.tencent.mm.vending.d;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  Bundle AOp;
  
  public a(Intent paramIntent)
  {
    AppMethodBeat.i(126078);
    this.AOp = null;
    this.AOp = paramIntent.getExtras();
    AppMethodBeat.o(126078);
  }
  
  public final int getIntExtra(String paramString, int paramInt)
  {
    AppMethodBeat.i(126079);
    if (this.AOp == null)
    {
      AppMethodBeat.o(126079);
      return paramInt;
    }
    paramInt = this.AOp.getInt(paramString, paramInt);
    AppMethodBeat.o(126079);
    return paramInt;
  }
  
  public final String getStringExtra(String paramString)
  {
    AppMethodBeat.i(126080);
    if (this.AOp == null)
    {
      AppMethodBeat.o(126080);
      return null;
    }
    paramString = this.AOp.getString(paramString);
    AppMethodBeat.o(126080);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.d.a
 * JD-Core Version:    0.7.0.1
 */