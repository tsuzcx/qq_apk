package com.tencent.thumbplayer.api.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b.b.b;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode;

public class TPPlayerConnectionNode
{
  private TPNativePlayerConnectionNode nativeNode;
  
  public TPPlayerConnectionNode()
  {
    AppMethodBeat.i(228457);
    this.nativeNode = new TPNativePlayerConnectionNode();
    AppMethodBeat.o(228457);
  }
  
  public boolean addAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    AppMethodBeat.i(228461);
    boolean bool = this.nativeNode.addAction(b.aHJ(paramInt));
    AppMethodBeat.o(228461);
    return bool;
  }
  
  public TPNativePlayerConnectionNode getNativeNode()
  {
    return this.nativeNode;
  }
  
  public void removeAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    AppMethodBeat.i(228466);
    this.nativeNode.removeAction(b.aHJ(paramInt));
    AppMethodBeat.o(228466);
  }
  
  public boolean setLongActionConfig(@TPPlayerConnectionConstant.Action int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(228474);
    boolean bool = this.nativeNode.setLongActionConfig(b.aHJ(paramInt1), b.aHK(paramInt2), paramLong);
    AppMethodBeat.o(228474);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.TPPlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */