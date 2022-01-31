package com.tencent.ttpic.util;

import android.media.MediaRecorder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlayerUtil$Recorder
  extends MediaRecorder
{
  private boolean isRecording;
  
  public boolean isRecording()
  {
    return this.isRecording;
  }
  
  public void release()
  {
    AppMethodBeat.i(50284);
    try
    {
      super.release();
      this.isRecording = false;
      AppMethodBeat.o(50284);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50284);
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(50283);
    if (!this.isRecording)
    {
      AppMethodBeat.o(50283);
      return;
    }
    try
    {
      super.reset();
      this.isRecording = false;
      AppMethodBeat.o(50283);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50283);
    }
  }
  
  public void start()
  {
    AppMethodBeat.i(50281);
    if (this.isRecording)
    {
      AppMethodBeat.o(50281);
      return;
    }
    try
    {
      super.start();
      this.isRecording = true;
      AppMethodBeat.o(50281);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50281);
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(50282);
    if (!this.isRecording)
    {
      AppMethodBeat.o(50282);
      return;
    }
    try
    {
      super.stop();
      this.isRecording = false;
      AppMethodBeat.o(50282);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50282);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.PlayerUtil.Recorder
 * JD-Core Version:    0.7.0.1
 */