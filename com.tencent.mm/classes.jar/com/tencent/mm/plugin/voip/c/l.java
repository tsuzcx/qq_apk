package com.tencent.mm.plugin.voip.c;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  private Map<Integer, Map<Integer, Integer>> NYg;
  public int mState;
  
  public l(int paramInt)
  {
    this.mState = paramInt;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final void aH(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115527);
    if (this.NYg == null) {
      this.NYg = new HashMap();
    }
    Object localObject;
    if (!this.NYg.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.NYg.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      AppMethodBeat.o(115527);
      return;
      localObject = (Map)this.NYg.get(Integer.valueOf(paramInt1));
    }
  }
  
  public final boolean alG(int paramInt)
  {
    AppMethodBeat.i(115528);
    if ((this.NYg == null) || (!this.NYg.containsKey(Integer.valueOf(this.mState))))
    {
      Log.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { k.alz(this.mState) });
      AppMethodBeat.o(115528);
      return false;
    }
    if (!((Map)this.NYg.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      Log.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { k.alz(this.mState), k.alz(paramInt) });
      AppMethodBeat.o(115528);
      return false;
    }
    AppMethodBeat.o(115528);
    return true;
  }
  
  public final void alH(int paramInt)
  {
    AppMethodBeat.i(115529);
    if (!alG(paramInt))
    {
      Log.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
      AppMethodBeat.o(115529);
      return;
    }
    int i = ((Integer)((Map)this.NYg.get(Integer.valueOf(this.mState))).get(Integer.valueOf(paramInt))).intValue();
    Log.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { k.alz(this.mState), k.alz(i), k.alz(paramInt) });
    this.mState = i;
    AppMethodBeat.o(115529);
  }
  
  public final int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.l
 * JD-Core Version:    0.7.0.1
 */