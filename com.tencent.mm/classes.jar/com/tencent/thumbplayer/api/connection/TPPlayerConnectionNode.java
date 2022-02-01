package com.tencent.thumbplayer.api.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b.b.b;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode;

public class TPPlayerConnectionNode
{
  private TPNativePlayerConnectionNode nativeNode;
  
  public TPPlayerConnectionNode()
  {
    AppMethodBeat.i(189081);
    this.nativeNode = new TPNativePlayerConnectionNode();
    AppMethodBeat.o(189081);
  }
  
  public boolean addAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    AppMethodBeat.i(189082);
    boolean bool = this.nativeNode.addAction(b.arj(paramInt));
    AppMethodBeat.o(189082);
    return bool;
  }
  
  public TPNativePlayerConnectionNode getNativeNode()
  {
    return this.nativeNode;
  }
  
  public void removeAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    AppMethodBeat.i(189083);
    this.nativeNode.removeAction(b.arj(paramInt));
    AppMethodBeat.o(189083);
  }
  
  public boolean setLongActionConfig(@TPPlayerConnectionConstant.Action int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(189084);
    boolean bool = this.nativeNode.setLongActionConfig(b.arj(paramInt1), b.ark(paramInt2), paramLong);
    AppMethodBeat.o(189084);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.TPPlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */