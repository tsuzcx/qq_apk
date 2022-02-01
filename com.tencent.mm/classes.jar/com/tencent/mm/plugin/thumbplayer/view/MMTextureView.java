package com.tencent.mm.plugin.thumbplayer.view;

import android.annotation.TargetApi;
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
import java.lang.reflect.Method;

@TargetApi(14)
public class MMTextureView
  extends THookTextureView
{
  boolean ANp = false;
  private Object ANq;
  private Object ANr;
  private Field MUm;
  
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
  
  private void ehj()
  {
    AppMethodBeat.i(191892);
    try
    {
      Log.i("MicroMsg.MMTextureView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      this.ANq = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      this.ANr = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(191892);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(191892);
    }
  }
  
  private void ehk()
  {
    AppMethodBeat.i(191895);
    try
    {
      Log.i("MicroMsg.MMTextureView", "unHookInnerDetach");
      Field localField;
      if (this.ANq != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        localField.setAccessible(true);
        localField.set(this, this.ANq);
        this.ANq = null;
      }
      if (this.ANr != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        localField.setAccessible(true);
        localField.set(this, this.ANr);
        this.ANr = null;
      }
      AppMethodBeat.o(191895);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(191895);
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(191867);
    super.destroyDrawingCache();
    if (this.ANp) {
      ehk();
    }
    AppMethodBeat.o(191867);
  }
  
  public final void goX()
  {
    AppMethodBeat.i(191899);
    try
    {
      setInterceptDetach(false);
      ehk();
      Method localMethod = TextureView.class.getMethod("destroyHardwareLayer", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      localMethod = TextureView.class.getMethod("releaseSurfaceTexture", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      AppMethodBeat.o(191899);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(191899);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(191869);
    if (this.ANp) {
      ehj();
    }
    super.onAttachedToWindow();
    if (this.ANp) {
      ehk();
    }
    AppMethodBeat.o(191869);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(191864);
    if (this.ANp) {
      ehj();
    }
    try
    {
      super.onDetachedFromWindow();
      AppMethodBeat.o(191864);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      AppMethodBeat.o(191864);
    }
  }
  
  public void setInterceptDetach(boolean paramBoolean)
  {
    this.ANp = paramBoolean;
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(191884);
    super.setSurfaceTexture(paramSurfaceTexture);
    if (d.qW(16))
    {
      Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(191884);
      return;
    }
    if (d.qX(20))
    {
      Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(191884);
      return;
    }
    if (af.juS.jrW == 2)
    {
      Log.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(191884);
      return;
    }
    Log.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.MUm == null)
      {
        this.MUm = TextureView.class.getDeclaredField("mSurface");
        this.MUm.setAccessible(true);
      }
      paramSurfaceTexture = (SurfaceTexture)this.MUm.get(this);
      if (paramSurfaceTexture != null) {
        if (!(paramSurfaceTexture instanceof a))
        {
          a locala = new a();
          locala.mSurfaceTexture = paramSurfaceTexture;
          this.MUm.set(this, locala);
          Log.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          AppMethodBeat.o(191884);
          return;
        }
      }
    }
    catch (NoSuchFieldException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      AppMethodBeat.o(191884);
      return;
      Log.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      AppMethodBeat.o(191884);
      return;
    }
    catch (IllegalArgumentException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      AppMethodBeat.o(191884);
      return;
      Log.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      AppMethodBeat.o(191884);
      return;
    }
    catch (IllegalAccessException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      AppMethodBeat.o(191884);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMTextureView
 * JD-Core Version:    0.7.0.1
 */