package com.tencent.ttpic.ar.filter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ARParticleFilter$ParticleCalculationHandler
  extends Handler
{
  public ARParticleFilter$ParticleCalculationHandler(ARParticleFilter paramARParticleFilter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    new ARParticleFilter.FrameData(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.ar.filter.ARParticleFilter.ParticleCalculationHandler
 * JD-Core Version:    0.7.0.1
 */