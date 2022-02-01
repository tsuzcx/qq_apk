package com.tencent.mm.plugin.thumbplayer.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
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
  private Field Gis;
  boolean weu = false;
  private Object wev;
  private Object wew;
  
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
  
  private void dFv()
  {
    AppMethodBeat.i(238593);
    try
    {
      Log.i("MicroMsg.MMTextureView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      this.wev = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      this.wew = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(238593);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(238593);
    }
  }
  
  private void dFw()
  {
    AppMethodBeat.i(238594);
    try
    {
      Log.i("MicroMsg.MMTextureView", "unHookInnerDetach");
      Field localField;
      if (this.wev != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        localField.setAccessible(true);
        localField.set(this, this.wev);
        this.wev = null;
      }
      if (this.wew != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        localField.setAccessible(true);
        localField.set(this, this.wew);
        this.wew = null;
      }
      AppMethodBeat.o(238594);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(238594);
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(238590);
    super.destroyDrawingCache();
    if (this.weu) {
      dFw();
    }
    AppMethodBeat.o(238590);
  }
  
  public final void fxg()
  {
    AppMethodBeat.i(238595);
    try
    {
      setInterceptDetach(false);
      dFw();
      Method localMethod = TextureView.class.getMethod("destroyHardwareLayer", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      localMethod = TextureView.class.getMethod("releaseSurfaceTexture", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      AppMethodBeat.o(238595);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(238595);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(238591);
    if (this.weu) {
      dFv();
    }
    super.onAttachedToWindow();
    if (this.weu) {
      dFw();
    }
    AppMethodBeat.o(238591);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(238589);
    if (this.weu)
    {
      dFv();
      AppMethodBeat.o(238589);
      return;
    }
    try
    {
      super.onDetachedFromWindow();
      AppMethodBeat.o(238589);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      AppMethodBeat.o(238589);
    }
  }
  
  public void setInterceptDetach(boolean paramBoolean)
  {
    this.weu = paramBoolean;
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(238592);
    super.setSurfaceTexture(paramSurfaceTexture);
    if (d.oE(16))
    {
      Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(238592);
      return;
    }
    if (d.oF(20))
    {
      Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(238592);
      return;
    }
    if (ae.gKE.gHF == 2)
    {
      Log.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(238592);
      return;
    }
    Log.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.Gis == null)
      {
        this.Gis = TextureView.class.getDeclaredField("mSurface");
        this.Gis.setAccessible(true);
      }
      paramSurfaceTexture = (SurfaceTexture)this.Gis.get(this);
      if (paramSurfaceTexture != null) {
        if (!(paramSurfaceTexture instanceof b))
        {
          b localb = new b();
          localb.mSurfaceTexture = paramSurfaceTexture;
          this.Gis.set(this, localb);
          Log.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          AppMethodBeat.o(238592);
          return;
        }
      }
    }
    catch (NoSuchFieldException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      AppMethodBeat.o(238592);
      return;
      Log.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      AppMethodBeat.o(238592);
      return;
    }
    catch (IllegalArgumentException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      AppMethodBeat.o(238592);
      return;
      Log.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      AppMethodBeat.o(238592);
      return;
    }
    catch (IllegalAccessException paramSurfaceTexture)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", paramSurfaceTexture, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      AppMethodBeat.o(238592);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.view.MMTextureView
 * JD-Core Version:    0.7.0.1
 */