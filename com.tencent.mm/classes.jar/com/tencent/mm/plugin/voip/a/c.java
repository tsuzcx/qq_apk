package com.tencent.mm.plugin.voip.a;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public int mState;
  private Map<Integer, Map<Integer, Integer>> tFj;
  
  public c(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public final boolean HT(int paramInt)
  {
    AppMethodBeat.i(5005);
    if ((this.tFj == null) || (!this.tFj.containsKey(Integer.valueOf(this.mState))))
    {
      ab.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { b.HN(this.mState) });
      AppMethodBeat.o(5005);
      return false;
    }
    if (!((Map)this.tFj.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      ab.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { b.HN(this.mState), b.HN(paramInt) });
      AppMethodBeat.o(5005);
      return false;
    }
    AppMethodBeat.o(5005);
    return true;
  }
  
  public final void HU(int paramInt)
  {
    AppMethodBeat.i(5006);
    if (!HT(paramInt))
    {
      ab.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
      AppMethodBeat.o(5006);
      return;
    }
    int i = ((Integer)((Map)this.tFj.get(Integer.valueOf(this.mState))).get(Integer.valueOf(paramInt))).intValue();
    ab.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { b.HN(this.mState), b.HN(i), b.HN(paramInt) });
    this.mState = i;
    AppMethodBeat.o(5006);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final void ak(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(5004);
    if (this.tFj == null) {
      this.tFj = new HashMap();
    }
    Object localObject;
    if (!this.tFj.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.tFj.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      AppMethodBeat.o(5004);
      return;
      localObject = (Map)this.tFj.get(Integer.valueOf(paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.c
 * JD-Core Version:    0.7.0.1
 */