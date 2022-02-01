package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;

public final class k
{
  private Map<Integer, Map<Integer, Integer>> AMw;
  public int mState;
  
  public k(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public final boolean SY(int paramInt)
  {
    AppMethodBeat.i(115528);
    if ((this.AMw == null) || (!this.AMw.containsKey(Integer.valueOf(this.mState))))
    {
      ac.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { j.SR(this.mState) });
      AppMethodBeat.o(115528);
      return false;
    }
    if (!((Map)this.AMw.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      ac.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { j.SR(this.mState), j.SR(paramInt) });
      AppMethodBeat.o(115528);
      return false;
    }
    AppMethodBeat.o(115528);
    return true;
  }
  
  public final void SZ(int paramInt)
  {
    AppMethodBeat.i(115529);
    if (!SY(paramInt))
    {
      ac.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
      AppMethodBeat.o(115529);
      return;
    }
    int i = ((Integer)((Map)this.AMw.get(Integer.valueOf(this.mState))).get(Integer.valueOf(paramInt))).intValue();
    ac.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { j.SR(this.mState), j.SR(i), j.SR(paramInt) });
    this.mState = i;
    AppMethodBeat.o(115529);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final void av(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115527);
    if (this.AMw == null) {
      this.AMw = new HashMap();
    }
    Object localObject;
    if (!this.AMw.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.AMw.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      AppMethodBeat.o(115527);
      return;
      localObject = (Map)this.AMw.get(Integer.valueOf(paramInt1));
    }
  }
  
  public final int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.k
 * JD-Core Version:    0.7.0.1
 */