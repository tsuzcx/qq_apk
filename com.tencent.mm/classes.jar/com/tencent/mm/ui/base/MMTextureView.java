package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.compatible.util.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(14)
public class MMTextureView
  extends TextureView
{
  private Field JIS;
  boolean JIT = false;
  private Object JIU;
  private Object JIV;
  
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
  
  private void fDi()
  {
    AppMethodBeat.i(164151);
    try
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      this.JIU = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      this.JIV = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(164151);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(164151);
    }
  }
  
  private void fDj()
  {
    AppMethodBeat.i(164152);
    try
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "unHookInnerDetach");
      Field localField;
      if (this.JIU != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        localField.setAccessible(true);
        localField.set(this, this.JIU);
        this.JIU = null;
      }
      if (this.JIV != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        localField.setAccessible(true);
        localField.set(this, this.JIV);
        this.JIV = null;
      }
      AppMethodBeat.o(164152);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(164152);
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(164149);
    super.destroyDrawingCache();
    if (this.JIT) {
      fDj();
    }
    AppMethodBeat.o(164149);
  }
  
  public final void fDh()
  {
    AppMethodBeat.i(142223);
    if (d.lB(16))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (d.lC(20))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (com.tencent.mm.compatible.deviceinfo.ae.geX.gch == 2)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(142223);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.JIS == null)
      {
        this.JIS = TextureView.class.getDeclaredField("mSurface");
        this.JIS.setAccessible(true);
      }
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)this.JIS.get(this);
      if (localSurfaceTexture != null) {
        if (!(localSurfaceTexture instanceof r))
        {
          r localr = new r();
          localr.mSurfaceTexture = localSurfaceTexture;
          this.JIS.set(this, localr);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          AppMethodBeat.o(142223);
          return;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMTextureView", localNoSuchFieldException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      AppMethodBeat.o(142223);
      return;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      AppMethodBeat.o(142223);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMTextureView", localIllegalArgumentException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      AppMethodBeat.o(142223);
      return;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      AppMethodBeat.o(142223);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMTextureView", localIllegalAccessException, "", new Object[0]);
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      AppMethodBeat.o(142223);
    }
  }
  
  public final void fDk()
  {
    AppMethodBeat.i(193726);
    try
    {
      setInterceptDetach(false);
      fDj();
      Method localMethod = TextureView.class.getMethod("destroyHardwareLayer", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      localMethod = TextureView.class.getMethod("releaseSurfaceTexture", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      AppMethodBeat.o(193726);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(193726);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164150);
    if (this.JIT) {
      fDi();
    }
    super.onAttachedToWindow();
    if (this.JIT) {
      fDj();
    }
    AppMethodBeat.o(164150);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142222);
    if (this.JIT)
    {
      fDi();
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
      com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      AppMethodBeat.o(142222);
    }
  }
  
  public void setInterceptDetach(boolean paramBoolean)
  {
    this.JIT = paramBoolean;
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(142224);
    super.setSurfaceTexture(paramSurfaceTexture);
    fDh();
    AppMethodBeat.o(142224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTextureView
 * JD-Core Version:    0.7.0.1
 */