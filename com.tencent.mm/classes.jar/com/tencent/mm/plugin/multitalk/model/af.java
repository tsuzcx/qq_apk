package com.tencent.mm.plugin.multitalk.model;

import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/model/VideoTransOutDataHandler;", "", "close", "", "onCameraFrame", "", "pBuffer", "", "bufferSize", "", "w", "h", "frameFormat", "mode", "onOrientationChange", "orientation", "onScreenFrame", "switchMode", "isVideo", "", "plugin-multitalk_release"})
public abstract interface af
{
  public abstract void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int b(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void onOrientationChange(int paramInt);
  
  public abstract void rQ(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.af
 * JD-Core Version:    0.7.0.1
 */