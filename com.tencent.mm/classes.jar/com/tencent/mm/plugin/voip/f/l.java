package com.tencent.mm.plugin.voip.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  public Map<Integer, Map<Integer, Integer>> UMd;
  public int mState;
  
  public l(int paramInt)
  {
    this.mState = paramInt;
  }
  
  public final boolean aro(int paramInt)
  {
    AppMethodBeat.i(115528);
    if ((this.UMd == null) || (!this.UMd.containsKey(Integer.valueOf(this.mState))))
    {
      Log.e("MicroMsg.Voip.VoipStateMachine", "no rule for state: %s", new Object[] { k.arg(this.mState) });
      AppMethodBeat.o(115528);
      return false;
    }
    if (!((Map)this.UMd.get(Integer.valueOf(this.mState))).containsKey(Integer.valueOf(paramInt)))
    {
      Log.e("MicroMsg.Voip.VoipStateMachine", "state: %s don't contain rule for action: %s", new Object[] { k.arg(this.mState), k.arg(paramInt) });
      AppMethodBeat.o(115528);
      return false;
    }
    AppMethodBeat.o(115528);
    return true;
  }
  
  public final void bj(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115527);
    if (this.UMd == null) {
      this.UMd = new HashMap();
    }
    Object localObject;
    if (!this.UMd.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = new HashMap();
      this.UMd.put(Integer.valueOf(paramInt1), localObject);
    }
    for (;;)
    {
      ((Map)localObject).put(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3));
      AppMethodBeat.o(115527);
      return;
      localObject = (Map)this.UMd.get(Integer.valueOf(paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.f.l
 * JD-Core Version:    0.7.0.1
 */