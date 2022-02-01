package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private Map<Integer, Map<Integer, Integer>> CDo;
  public int mState;
  
  public m(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public final boolean Vy(int paramInt)
  {
    AppMethodBeat.i(115528);
    if ((this.CDo == null) || (!this.CDo.containsKey(Integer.valueOf(this.mState))))
    {
      ae.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { l.Vr(this.mState) });
      AppMethodBeat.o(115528);
      return false;
    }
    if (!((Map)this.CDo.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      ae.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { l.Vr(this.mState), l.Vr(paramInt) });
      AppMethodBeat.o(115528);
      return false;
    }
    AppMethodBeat.o(115528);
    return true;
  }
  
  public final void Vz(int paramInt)
  {
    AppMethodBeat.i(115529);
    if (!Vy(paramInt))
    {
      ae.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
      AppMethodBeat.o(115529);
      return;
    }
    int i = ((Integer)((Map)this.CDo.get(Integer.valueOf(this.mState))).get(Integer.valueOf(paramInt))).intValue();
    ae.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { l.Vr(this.mState), l.Vr(i), l.Vr(paramInt) });
    this.mState = i;
    AppMethodBeat.o(115529);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final void ay(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115527);
    if (this.CDo == null) {
      this.CDo = new HashMap();
    }
    Object localObject;
    if (!this.CDo.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.CDo.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      AppMethodBeat.o(115527);
      return;
      localObject = (Map)this.CDo.get(Integer.valueOf(paramInt1));
    }
  }
  
  public final int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.m
 * JD-Core Version:    0.7.0.1
 */