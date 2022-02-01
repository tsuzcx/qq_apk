package com.tencent.tav.player;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlayerLayer
{
  private boolean needReleaseSurface;
  private Player player;
  private boolean readyForDisplay;
  private PlayerLayerReadyListener readyListener;
  Surface surface;
  int surfaceHeight;
  SurfaceTexture surfaceTexture;
  int surfaceWidth;
  private int videoGravity;
  private Rect videoRect;
  
  public PlayerLayer(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202167);
    this.needReleaseSurface = false;
    this.readyListener = null;
    this.surface = new Surface(paramSurfaceTexture);
    this.needReleaseSurface = true;
    this.surfaceTexture = paramSurfaceTexture;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    AppMethodBeat.o(202167);
  }
  
  public PlayerLayer(Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.needReleaseSurface = false;
    this.readyListener = null;
    this.surface = paramSurface;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
  }
  
  public Player getPlayer()
  {
    return this.player;
  }
  
  public Surface getSurface()
  {
    return this.surface;
  }
  
  public int getSurfaceHeight()
  {
    return this.surfaceHeight;
  }
  
  public int getSurfaceWidth()
  {
    return this.surfaceWidth;
  }
  
  public int getVideoGravity()
  {
    return this.videoGravity;
  }
  
  public Rect getVideoRect()
  {
    return this.videoRect;
  }
  
  public boolean isReadyForDisplay()
  {
    return this.readyForDisplay;
  }
  
  void release()
  {
    AppMethodBeat.i(202169);
    if (this.needReleaseSurface) {
      this.surface.release();
    }
    AppMethodBeat.o(202169);
  }
  
  public void setPlayer(Player paramPlayer)
  {
    AppMethodBeat.i(202168);
    this.player = paramPlayer;
    if (paramPlayer != null) {
      paramPlayer.bindLayer(this);
    }
    AppMethodBeat.o(202168);
  }
  
  public void setReadyForDisplay(PlayerLayerReadyListener paramPlayerLayerReadyListener)
  {
    this.readyListener = paramPlayerLayerReadyListener;
  }
  
  public void setVideoGravity(int paramInt)
  {
    this.videoGravity = paramInt;
  }
  
  public static abstract interface PlayerLayerReadyListener
  {
    public abstract void finish(PlayerLayer paramPlayerLayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.player.PlayerLayer
 * JD-Core Version:    0.7.0.1
 */