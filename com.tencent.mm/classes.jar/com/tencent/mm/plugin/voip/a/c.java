package com.tencent.mm.plugin.voip.a;

import android.annotation.SuppressLint;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public int mState;
  public Map<Integer, Map<Integer, Integer>> pZH;
  
  public c(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public final boolean Az(int paramInt)
  {
    if ((this.pZH == null) || (!this.pZH.containsKey(Integer.valueOf(this.mState))))
    {
      y.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { b.At(this.mState) });
      return false;
    }
    if (!((Map)this.pZH.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      y.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { b.At(this.mState), b.At(paramInt) });
      return false;
    }
    return true;
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final void X(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.pZH == null) {
      this.pZH = new HashMap();
    }
    Object localObject;
    if (!this.pZH.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.pZH.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      return;
      localObject = (Map)this.pZH.get(Integer.valueOf(paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.c
 * JD-Core Version:    0.7.0.1
 */