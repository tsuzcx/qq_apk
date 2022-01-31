package com.tencent.ttpic.util;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlayerUtil$Player
  extends MediaPlayer
{
  private boolean isPlaying;
  
  public boolean isPlaying()
  {
    return this.isPlaying;
  }
  
  public void pause()
  {
    AppMethodBeat.i(50277);
    if (!this.isPlaying)
    {
      AppMethodBeat.o(50277);
      return;
    }
    try
    {
      super.pause();
      this.isPlaying = false;
      AppMethodBeat.o(50277);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50277);
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(50280);
    try
    {
      super.release();
      this.isPlaying = false;
      AppMethodBeat.o(50280);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50280);
    }
  }
  
  public void reset()
  {
    AppMethodBeat.i(50279);
    try
    {
      super.reset();
      this.isPlaying = false;
      AppMethodBeat.o(50279);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50279);
    }
  }
  
  public void start()
  {
    AppMethodBeat.i(50276);
    if (this.isPlaying)
    {
      AppMethodBeat.o(50276);
      return;
    }
    try
    {
      super.start();
      this.isPlaying = true;
      AppMethodBeat.o(50276);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50276);
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(50278);
    try
    {
      super.stop();
      this.isPlaying = false;
      AppMethodBeat.o(50278);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(50278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.PlayerUtil.Player
 * JD-Core Version:    0.7.0.1
 */