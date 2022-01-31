package com.tencent.ttpic.gles;

import android.graphics.PointF;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TextureDataPipe
{
  public static final int BUFFER_BUSY = 1;
  public static final int BUFFER_FREE = 0;
  public static final int BUFFER_READY = 2;
  public static final String TAG = "TextureDataPipe";
  private static float[] sMtxIdentity = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  public List<List<PointF>> mPoints;
  public h mTexFrame;
  public AtomicInteger mTextureDataFlag;
  public long mTimestamp;
  
  public TextureDataPipe()
  {
    AppMethodBeat.i(50044);
    this.mTextureDataFlag = new AtomicInteger(0);
    this.mTexFrame = new h();
    this.mPoints = new ArrayList();
    AppMethodBeat.o(50044);
  }
  
  public int getTexureCurrentStatus()
  {
    AppMethodBeat.i(50052);
    int i = this.mTextureDataFlag.getAndAdd(0);
    AppMethodBeat.o(50052);
    return i;
  }
  
  public void getTransformMatrix(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(50045);
    if (paramArrayOfFloat.length != 16)
    {
      paramArrayOfFloat = new IllegalArgumentException();
      AppMethodBeat.o(50045);
      throw paramArrayOfFloat;
    }
    System.arraycopy(sMtxIdentity, 0, paramArrayOfFloat, 0, sMtxIdentity.length);
    AppMethodBeat.o(50045);
  }
  
  public boolean isBusy()
  {
    AppMethodBeat.i(50046);
    if (this.mTextureDataFlag.get() == 1)
    {
      AppMethodBeat.o(50046);
      return true;
    }
    AppMethodBeat.o(50046);
    return false;
  }
  
  public boolean isReady()
  {
    AppMethodBeat.i(50047);
    if (this.mTextureDataFlag.get() == 2)
    {
      AppMethodBeat.o(50047);
      return true;
    }
    AppMethodBeat.o(50047);
    return false;
  }
  
  public void makeBusy()
  {
    AppMethodBeat.i(50050);
    this.mTextureDataFlag.getAndSet(1);
    AppMethodBeat.o(50050);
  }
  
  public void makeDataReady()
  {
    AppMethodBeat.i(50051);
    this.mTextureDataFlag.getAndSet(2);
    AppMethodBeat.o(50051);
  }
  
  public void makeFree()
  {
    AppMethodBeat.i(50049);
    this.mTextureDataFlag.getAndSet(0);
    AppMethodBeat.o(50049);
  }
  
  public void release()
  {
    AppMethodBeat.i(50048);
    this.mTexFrame.clear();
    AppMethodBeat.o(50048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.gles.TextureDataPipe
 * JD-Core Version:    0.7.0.1
 */