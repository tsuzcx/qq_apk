package com.tencent.mm.plugin.voip.b;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Map;

public final class m
{
  private Map<Integer, Map<Integer, Integer>> ClK;
  public int mState;
  
  public m(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public final boolean UR(int paramInt)
  {
    AppMethodBeat.i(115528);
    if ((this.ClK == null) || (!this.ClK.containsKey(Integer.valueOf(this.mState))))
    {
      ad.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { l.UK(this.mState) });
      AppMethodBeat.o(115528);
      return false;
    }
    if (!((Map)this.ClK.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      ad.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { l.UK(this.mState), l.UK(paramInt) });
      AppMethodBeat.o(115528);
      return false;
    }
    AppMethodBeat.o(115528);
    return true;
  }
  
  public final void US(int paramInt)
  {
    AppMethodBeat.i(115529);
    if (!UR(paramInt))
    {
      ad.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
      AppMethodBeat.o(115529);
      return;
    }
    int i = ((Integer)((Map)this.ClK.get(Integer.valueOf(this.mState))).get(Integer.valueOf(paramInt))).intValue();
    ad.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { l.UK(this.mState), l.UK(i), l.UK(paramInt) });
    this.mState = i;
    AppMethodBeat.o(115529);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final void ax(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115527);
    if (this.ClK == null) {
      this.ClK = new HashMap();
    }
    Object localObject;
    if (!this.ClK.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.ClK.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      AppMethodBeat.o(115527);
      return;
      localObject = (Map)this.ClK.get(Integer.valueOf(paramInt1));
    }
  }
  
  public final int getState()
  {
    return this.mState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.b.m
 * JD-Core Version:    0.7.0.1
 */