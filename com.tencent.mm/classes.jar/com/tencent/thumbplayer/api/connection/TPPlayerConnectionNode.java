package com.tencent.thumbplayer.api.connection;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.b.b.b;
import com.tencent.thumbplayer.core.connection.TPNativePlayerConnectionNode;

public class TPPlayerConnectionNode
{
  private TPNativePlayerConnectionNode nativeNode;
  
  public TPPlayerConnectionNode()
  {
    AppMethodBeat.i(219975);
    this.nativeNode = new TPNativePlayerConnectionNode();
    AppMethodBeat.o(219975);
  }
  
  public boolean addAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    AppMethodBeat.i(219976);
    boolean bool = this.nativeNode.addAction(b.aAW(paramInt));
    AppMethodBeat.o(219976);
    return bool;
  }
  
  public TPNativePlayerConnectionNode getNativeNode()
  {
    return this.nativeNode;
  }
  
  public void removeAction(@TPPlayerConnectionConstant.Action int paramInt)
  {
    AppMethodBeat.i(219977);
    this.nativeNode.removeAction(b.aAW(paramInt));
    AppMethodBeat.o(219977);
  }
  
  public boolean setLongActionConfig(@TPPlayerConnectionConstant.Action int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(219979);
    boolean bool = this.nativeNode.setLongActionConfig(b.aAW(paramInt1), b.aAX(paramInt2), paramLong);
    AppMethodBeat.o(219979);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.api.connection.TPPlayerConnectionNode
 * JD-Core Version:    0.7.0.1
 */