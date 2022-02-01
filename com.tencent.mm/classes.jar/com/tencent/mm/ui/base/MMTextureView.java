package com.tencent.mm.ui.base;

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
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView
  extends TextureView
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
    AppMethodBeat.i(164151);
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
      AppMethodBeat.o(164151);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(164151);
    }
  }
  
  private void dFw()
  {
    AppMethodBeat.i(164152);
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
      AppMethodBeat.o(164152);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(164152);
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(164149);
    super.destroyDrawingCache();
    if (this.weu) {
      dFw();
    }
    AppMethodBeat.o(164149);
  }
  
  public final void gLi()
  {
    AppMethodBeat.i(142223);
    if (d.oE(16))
    {
      Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (d.oF(20))
    {
      Log.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (ae.gKE.gHF == 2)
    {
      Log.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(142223);
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
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)this.Gis.get(this);
      if (localSurfaceTexture != null) {
        if (!(localSurfaceTexture instanceof s))
        {
          s locals = new s();
          locals.mSurfaceTexture = localSurfaceTexture;
          this.Gis.set(this, locals);
          Log.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          AppMethodBeat.o(142223);
          return;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localNoSuchFieldException, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      AppMethodBeat.o(142223);
      return;
      Log.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      AppMethodBeat.o(142223);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localIllegalArgumentException, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      AppMethodBeat.o(142223);
      return;
      Log.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      AppMethodBeat.o(142223);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localIllegalAccessException, "", new Object[0]);
      Log.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      AppMethodBeat.o(142223);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164150);
    if (this.weu) {
      dFv();
    }
    super.onAttachedToWindow();
    if (this.weu) {
      dFw();
    }
    AppMethodBeat.o(164150);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142222);
    if (this.weu)
    {
      dFv();
      AppMethodBeat.o(142222);
      return;
    }
    try
    {
      super.onDetachedFromWindow();
      AppMethodBeat.o(142222);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      AppMethodBeat.o(142222);
    }
  }
  
  public void setInterceptDetach(boolean paramBoolean)
  {
    this.weu = paramBoolean;
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(142224);
    super.setSurfaceTexture(paramSurfaceTexture);
    gLi();
    AppMethodBeat.o(142224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTextureView
 * JD-Core Version:    0.7.0.1
 */