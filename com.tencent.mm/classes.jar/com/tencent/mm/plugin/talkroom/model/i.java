package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  List<d> callbacks;
  ak handler;
  
  public i()
  {
    AppMethodBeat.i(25859);
    this.callbacks = new LinkedList();
    this.handler = new ak(Looper.getMainLooper());
    AppMethodBeat.o(25859);
  }
  
  public final void akV()
  {
    AppMethodBeat.i(25860);
    i.1 local1 = new i.1(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      AppMethodBeat.o(25860);
      return;
    }
    this.handler.post(local1);
    AppMethodBeat.o(25860);
  }
  
  public final void akX()
  {
    AppMethodBeat.i(25865);
    i.12 local12 = new i.12(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local12.run();
      AppMethodBeat.o(25865);
      return;
    }
    this.handler.post(local12);
    AppMethodBeat.o(25865);
  }
  
  public final void ala()
  {
    AppMethodBeat.i(25866);
    i.4 local4 = new i.4(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local4.run();
      AppMethodBeat.o(25866);
      return;
    }
    this.handler.post(local4);
    AppMethodBeat.o(25866);
  }
  
  public final void i(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(25864);
    paramString = new i.9(this, paramInt1, paramInt2, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(25864);
      return;
    }
    this.handler.post(paramString);
    AppMethodBeat.o(25864);
  }
  
  public final void mh(int paramInt)
  {
    AppMethodBeat.i(25862);
    i.7 local7 = new i.7(this, paramInt);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local7.run();
      AppMethodBeat.o(25862);
      return;
    }
    this.handler.post(local7);
    AppMethodBeat.o(25862);
  }
  
  public final void t(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25861);
    paramString = new i.5(this, paramString, paramInt1, paramInt2);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(25861);
      return;
    }
    this.handler.post(paramString);
    AppMethodBeat.o(25861);
  }
  
  public final void uM(String paramString)
  {
    AppMethodBeat.i(25863);
    paramString = new i.8(this, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(25863);
      return;
    }
    this.handler.post(paramString);
    AppMethodBeat.o(25863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i
 * JD-Core Version:    0.7.0.1
 */