package com.tencent.mm.plugin.voip_cs.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MMTextureView;

public class VoipCSVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] vbX = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private VoipCSVideoView.a AWc;
  private int index;
  private Paint owg;
  private int position;
  private int surfaceHeight;
  private SurfaceTexture surfaceTexture;
  private int surfaceWidth;
  private String username;
  
  public VoipCSVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(125480);
    this.AWc = VoipCSVideoView.a.AWf;
    initView();
    AppMethodBeat.o(125480);
  }
  
  public VoipCSVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(125481);
    this.AWc = VoipCSVideoView.a.AWf;
    initView();
    AppMethodBeat.o(125481);
  }
  
  private void initView()
  {
    AppMethodBeat.i(125482);
    this.owg = new Paint();
    this.owg.setColor(-16777216);
    this.owg.setFilterBitmap(true);
    this.owg.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    if (isAvailable()) {
      onSurfaceTextureAvailable(getSurfaceTexture(), getWidth(), getHeight());
    }
    AppMethodBeat.o(125482);
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(125483);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ac.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(125483);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(125485);
    String str = this.username;
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.surfaceTexture = null;
      this.surfaceHeight = 0;
      this.surfaceWidth = 0;
      AppMethodBeat.o(125485);
      return false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(125484);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ac.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(125484);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    AppMethodBeat.i(125486);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ac.v("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
    AppMethodBeat.o(125486);
  }
  
  public void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.widget.VoipCSVideoView
 * JD-Core Version:    0.7.0.1
 */