package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMTextureView;

public class VoIPVideoView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private static final int[] oWv = { 452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295 };
  private SurfaceTexture bbI;
  private float bxt;
  private int fbH;
  private int fbI;
  private Paint kMA;
  private int tJs;
  private int tJt;
  private int tJu;
  private float tJv;
  
  public VoIPVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(5157);
    this.bxt = 0.4F;
    this.tJs = 30;
    this.tJt = 30;
    this.tJu = 15;
    this.tJv = 0.02F;
    initView();
    AppMethodBeat.o(5157);
  }
  
  public VoIPVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(5158);
    this.bxt = 0.4F;
    this.tJs = 30;
    this.tJt = 30;
    this.tJu = 15;
    this.tJv = 0.02F;
    initView();
    AppMethodBeat.o(5158);
  }
  
  private void initView()
  {
    AppMethodBeat.i(5159);
    this.kMA = new Paint();
    this.kMA.setColor(-16777216);
    this.kMA.setFilterBitmap(true);
    this.kMA.setTextSize(40.0F);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(5159);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5160);
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureAvailable %b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.bbI = paramSurfaceTexture;
      this.fbH = paramInt1;
      this.fbI = paramInt2;
      dEs();
      AppMethodBeat.o(5160);
      return;
    }
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    AppMethodBeat.i(5162);
    if (paramSurfaceTexture != null) {}
    for (;;)
    {
      ab.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureDestroyed %b", new Object[] { Boolean.valueOf(bool) });
      this.bbI = null;
      this.fbI = 0;
      this.fbH = 0;
      AppMethodBeat.o(5162);
      return false;
      bool = false;
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5161);
    if (paramSurfaceTexture != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureSizeChanged %b %d %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.fbH = paramInt1;
      this.fbI = paramInt2;
      AppMethodBeat.o(5161);
      return;
    }
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = true;
    AppMethodBeat.i(5163);
    if (paramSurfaceTexture != null) {}
    for (;;)
    {
      ab.v("MicroMsg.VoIP.VoIPVideoView", "onSurfaceTextureUpdated %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(5163);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.VoIPVideoView
 * JD-Core Version:    0.7.0.1
 */