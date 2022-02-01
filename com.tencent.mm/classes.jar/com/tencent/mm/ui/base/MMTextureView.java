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
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(14)
public class MMTextureView
  extends TextureView
{
  private Field Jod;
  boolean Joe = false;
  private Object Jof;
  private Object Jog;
  
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
  
  private void fzg()
  {
    AppMethodBeat.i(164151);
    try
    {
      ad.i("MicroMsg.MMTextureView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      this.Jof = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      this.Jog = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(164151);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(164151);
    }
  }
  
  private void fzh()
  {
    AppMethodBeat.i(164152);
    try
    {
      ad.i("MicroMsg.MMTextureView", "unHookInnerDetach");
      Field localField;
      if (this.Jof != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        localField.setAccessible(true);
        localField.set(this, this.Jof);
        this.Jof = null;
      }
      if (this.Jog != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        localField.setAccessible(true);
        localField.set(this, this.Jog);
        this.Jog = null;
      }
      AppMethodBeat.o(164152);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(164152);
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(164149);
    super.destroyDrawingCache();
    if (this.Joe) {
      fzh();
    }
    AppMethodBeat.o(164149);
  }
  
  public final void fzf()
  {
    AppMethodBeat.i(142223);
    if (d.lz(16))
    {
      ad.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (d.lA(20))
    {
      ad.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (ae.gcP.fZY == 2)
    {
      ad.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(142223);
      return;
    }
    ad.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.Jod == null)
      {
        this.Jod = TextureView.class.getDeclaredField("mSurface");
        this.Jod.setAccessible(true);
      }
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)this.Jod.get(this);
      if (localSurfaceTexture != null) {
        if (!(localSurfaceTexture instanceof r))
        {
          r localr = new r();
          localr.mSurfaceTexture = localSurfaceTexture;
          this.Jod.set(this, localr);
          ad.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          AppMethodBeat.o(142223);
          return;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      ad.printErrStackTrace("MicroMsg.MMTextureView", localNoSuchFieldException, "", new Object[0]);
      ad.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      AppMethodBeat.o(142223);
      return;
      ad.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      AppMethodBeat.o(142223);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ad.printErrStackTrace("MicroMsg.MMTextureView", localIllegalArgumentException, "", new Object[0]);
      ad.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      AppMethodBeat.o(142223);
      return;
      ad.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      AppMethodBeat.o(142223);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ad.printErrStackTrace("MicroMsg.MMTextureView", localIllegalAccessException, "", new Object[0]);
      ad.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      AppMethodBeat.o(142223);
    }
  }
  
  public final void fzi()
  {
    AppMethodBeat.i(186472);
    try
    {
      setInterceptDetach(false);
      fzh();
      Method localMethod = TextureView.class.getMethod("destroyHardwareLayer", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      localMethod = TextureView.class.getMethod("releaseSurfaceTexture", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      AppMethodBeat.o(186472);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(186472);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164150);
    if (this.Joe) {
      fzg();
    }
    super.onAttachedToWindow();
    if (this.Joe) {
      fzh();
    }
    AppMethodBeat.o(164150);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142222);
    if (this.Joe)
    {
      fzg();
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
      ad.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      AppMethodBeat.o(142222);
    }
  }
  
  public void setInterceptDetach(boolean paramBoolean)
  {
    this.Joe = paramBoolean;
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(142224);
    super.setSurfaceTexture(paramSurfaceTexture);
    fzf();
    AppMethodBeat.o(142224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTextureView
 * JD-Core Version:    0.7.0.1
 */