package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  private Map<Integer, Map<Integer, Integer>> Hhr;
  public int mState;
  
  public l(int paramInt)
  {
    this.mState = paramInt;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final void aD(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115527);
    if (this.Hhr == null) {
      this.Hhr = new HashMap();
    }
    Object localObject;
    if (!this.Hhr.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.Hhr.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      AppMethodBeat.o(115527);
      return;
      localObject = (Map)this.Hhr.get(Integer.valueOf(paramInt1));
    }
  }
  
  public final boolean adT(int paramInt)
  {
    AppMethodBeat.i(115528);
    if ((this.Hhr == null) || (!this.Hhr.containsKey(Integer.valueOf(this.mState))))
    {
      Log.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { k.adM(this.mState) });
      AppMethodBeat.o(115528);
      return false;
    }
    if (!((Map)this.Hhr.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      Log.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { k.adM(this.mState), k.adM(paramInt) });
      AppMethodBeat.o(115528);
      return false;
    }
    AppMethodBeat.o(115528);
    return true;
  }
  
  public final void adU(int paramInt)
  {
    AppMethodBeat.i(115529);
    if (!adT(paramInt))
    {
      Log.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
      AppMethodBeat.o(115529);
      return;
    }
    int i = ((Integer)((Map)this.Hhr.get(Integer.valueOf(this.mState))).get(Integer.valueOf(paramInt))).intValue();
    Log.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { k.adM(this.mState), k.adM(i), k.adM(paramInt) });
    this.mState = i;
    AppMethodBeat.o(115529);
  }
  
  public final int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.l
 * JD-Core Version:    0.7.0.1
 */