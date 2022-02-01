package com.tencent.mm.plugin.thumbplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmediacodec.hook.THookTextureView;
import java.lang.reflect.Field;

public class MMTextureView
  extends THookTextureView
{
  boolean GpP = false;
  private Object GpQ;
  private Object GpR;
  private Field TGT;
  
  public MMTextureView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MMTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void fjn()
  {
    AppMethodBeat.i(272273);
    try
    {
      Log.i("MicroMsg.MMTextureView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      this.GpQ = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      this.GpR = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(272273);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(272273);
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(272290);
    super.destroyDrawingCache();
    if (this.GpP) {
      fjo();
    }
    AppMethodBeat.o(272290);
  }
  
  public final void fjo()
  {
    AppMethodBeat.i(272325);
    try
    {
      Log.i("MicroMsg.MMTextureView", "unHookInnerDetach");
      Field localField;
      if (this.GpQ != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        localField.setAccessible(true);
        localField.set(this, this.GpQ);
        this.GpQ = null;
      }
      if (this.GpR != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        localField.setAccessible(true);
        localField.set(this, this.GpR);
        this.GpR = null;
      }
      AppMethodBeat.o(272325);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(272325);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(272296);
    if (this.GpP) {
      fjn();
    }
    super.onAttachedToWindow();
    if (this.GpP) {
      fjo();
    }
    AppMethodBeat.o(272296);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(272282);
    if (this.GpP) {
      fjn();
    }
    try
    {
      super.onDetachedFromWindow();
      AppMethodBeat.o(272282);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      AppMethodBeat.o(272282);
    }
  }
  
  public void setInterceptDetach(boolean paramBoolean)
  {
    this.GpP = paramBoolean;
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(272309);
    super.setSurfaceTexture(paramSurfaceTexture);
    if (d.rc(16))
    {
      Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(272309);
      return;
    }
    if (d.rd(20))
    {
      Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(272309);
      return;
    }
    if (af.lYj.lVm == 2)
    {
      Log.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(272309);
      return;
    }
    Log.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.TGT == null)
      {
        this.TGT = TextureView.class.getDeclaredField("mSurface");
        this.TGT.setAccessible(true);
      }
      paramSurfaceTexture = (SurfaceTexture)this.TGT.get(this);
      if (paramSurfaceTexture != null) {
        if (!(paramSurfaceTexture instanceof a))
        {
          a locala = new a();
          locala.mSurfaceTexture = paramSurfaceTexture;
          this.TGT.set(this, locala);
          Log.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          AppMethodBeat.o(272309);
          return;
        }
      }
    }
    catch (NoSuchFieldException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      AppMethodBeat.o(272309);
      return;
      Log.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      AppMethodBeat.o(272309);
      return;
    }
    catch (IllegalArgumentException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      AppMethodBeat.o(272309);
      return;
      Log.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      AppMethodBeat.o(272309);
      return;
    }
    catch (IllegalAccessException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      AppMethodBeat.o(272309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMTextureView
 * JD-Core Version:    0.7.0.1
 */