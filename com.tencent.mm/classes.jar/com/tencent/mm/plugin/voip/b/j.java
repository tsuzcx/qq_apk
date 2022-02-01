package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  public int mState;
  private Map<Integer, Map<Integer, Integer>> ztF;
  
  public j(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public final boolean QP(int paramInt)
  {
    AppMethodBeat.i(115528);
    if ((this.ztF == null) || (!this.ztF.containsKey(Integer.valueOf(this.mState))))
    {
      ad.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { i.QI(this.mState) });
      AppMethodBeat.o(115528);
      return false;
    }
    if (!((Map)this.ztF.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      ad.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { i.QI(this.mState), i.QI(paramInt) });
      AppMethodBeat.o(115528);
      return false;
    }
    AppMethodBeat.o(115528);
    return true;
  }
  
  public final void QQ(int paramInt)
  {
    AppMethodBeat.i(115529);
    if (!QP(paramInt))
    {
      ad.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
      AppMethodBeat.o(115529);
      return;
    }
    int i = ((Integer)((Map)this.ztF.get(Integer.valueOf(this.mState))).get(Integer.valueOf(paramInt))).intValue();
    ad.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { i.QI(this.mState), i.QI(i), i.QI(paramInt) });
    this.mState = i;
    AppMethodBeat.o(115529);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final void au(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115527);
    if (this.ztF == null) {
      this.ztF = new HashMap();
    }
    Object localObject;
    if (!this.ztF.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.ztF.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      AppMethodBeat.o(115527);
      return;
      localObject = (Map)this.ztF.get(Integer.valueOf(paramInt1));
    }
  }
  
  public final int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.j
 * JD-Core Version:    0.7.0.1
 */