package com.tencent.mm.plugin.voip_cs.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

public class VoipCSVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] oWv = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private SurfaceTexture bbI;
  private int fbH;
  private int fbI;
  private int index;
  private Paint kMA;
  private int position;
  private VoipCSVideoView.a tLL;
  private String username;
  
  public VoipCSVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(135429);
    this.tLL = VoipCSVideoView.a.tLO;
    initView();
    AppMethodBeat.o(135429);
  }
  
  public VoipCSVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(135430);
    this.tLL = VoipCSVideoView.a.tLO;
    initView();
    AppMethodBeat.o(135430);
  }
  
  private void initView()
  {
    AppMethodBeat.i(135431);
    this.kMA = new Paint();
    this.kMA.setColor(-16777216);
    this.kMA.setFilterBitmap(true);
    this.kMA.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    if (isAvailable()) {
      onSurfaceTextureAvailable(getSurfaceTexture(), getWidth(), getHeight());
    }
    AppMethodBeat.o(135431);
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
    AppMethodBeat.i(135432);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ab.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureAvailable %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(135432);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(135434);
    String str = this.username;
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureDestroyed %s %b", new Object[] { str, Boolean.valueOf(bool) });
      this.bbI = null;
      this.fbI = 0;
      this.fbH = 0;
      AppMethodBeat.o(135434);
      return false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    AppMethodBeat.i(135433);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ab.i("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureSizeChanged %s %b %d %d", new Object[] { str, Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(135433);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = false;
    AppMethodBeat.i(135435);
    String str = this.username;
    if (paramSurfaceTexture != null) {
      bool = true;
    }
    ab.v("MicroMsg.cs.VoipCSVideoView", "onSurfaceTextureUpdated %s %b", new Object[] { str, Boolean.valueOf(bool) });
    AppMethodBeat.o(135435);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.ui.widget.VoipCSVideoView
 * JD-Core Version:    0.7.0.1
 */