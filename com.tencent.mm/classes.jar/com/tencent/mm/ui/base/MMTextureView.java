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
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TargetApi(14)
public class MMTextureView
  extends TextureView
{
  private Field HAm;
  boolean HAn = false;
  private Object HAo;
  private Object HAp;
  
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
  
  private void fiR()
  {
    AppMethodBeat.i(164151);
    try
    {
      ac.i("MicroMsg.MMTextureView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      this.HAo = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      this.HAp = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(164151);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(164151);
    }
  }
  
  private void fiS()
  {
    AppMethodBeat.i(164152);
    try
    {
      ac.i("MicroMsg.MMTextureView", "unHookInnerDetach");
      Field localField;
      if (this.HAo != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        localField.setAccessible(true);
        localField.set(this, this.HAo);
        this.HAo = null;
      }
      if (this.HAp != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        localField.setAccessible(true);
        localField.set(this, this.HAp);
        this.HAp = null;
      }
      AppMethodBeat.o(164152);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.MMTextureView", localException, "", new Object[0]);
      AppMethodBeat.o(164152);
    }
  }
  
  public void destroyDrawingCache()
  {
    AppMethodBeat.i(164149);
    super.destroyDrawingCache();
    if (this.HAn) {
      fiS();
    }
    AppMethodBeat.o(164149);
  }
  
  public final void fiQ()
  {
    AppMethodBeat.i(142223);
    if (d.la(16))
    {
      ac.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (d.lb(20))
    {
      ac.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (ae.fJo.fGz == 2)
    {
      ac.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(142223);
      return;
    }
    ac.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.HAm == null)
      {
        this.HAm = TextureView.class.getDeclaredField("mSurface");
        this.HAm.setAccessible(true);
      }
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)this.HAm.get(this);
      if (localSurfaceTexture != null) {
        if (!(localSurfaceTexture instanceof r))
        {
          r localr = new r();
          localr.mSurfaceTexture = localSurfaceTexture;
          this.HAm.set(this, localr);
          ac.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          AppMethodBeat.o(142223);
          return;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      ac.printErrStackTrace("MicroMsg.MMTextureView", localNoSuchFieldException, "", new Object[0]);
      ac.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      AppMethodBeat.o(142223);
      return;
      ac.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      AppMethodBeat.o(142223);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ac.printErrStackTrace("MicroMsg.MMTextureView", localIllegalArgumentException, "", new Object[0]);
      ac.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      AppMethodBeat.o(142223);
      return;
      ac.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      AppMethodBeat.o(142223);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ac.printErrStackTrace("MicroMsg.MMTextureView", localIllegalAccessException, "", new Object[0]);
      ac.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      AppMethodBeat.o(142223);
    }
  }
  
  public final void fiT()
  {
    AppMethodBeat.i(197189);
    try
    {
      setInterceptDetach(false);
      fiS();
      Method localMethod = TextureView.class.getMethod("destroyHardwareLayer", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      localMethod = TextureView.class.getMethod("releaseSurfaceTexture", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(this, new Object[0]);
      AppMethodBeat.o(197189);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(197189);
    }
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164150);
    if (this.HAn) {
      fiR();
    }
    super.onAttachedToWindow();
    if (this.HAn) {
      fiS();
    }
    AppMethodBeat.o(164150);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142222);
    if (this.HAn)
    {
      fiR();
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
      ac.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      AppMethodBeat.o(142222);
    }
  }
  
  public void setInterceptDetach(boolean paramBoolean)
  {
    this.HAn = paramBoolean;
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(142224);
    super.setSurfaceTexture(paramSurfaceTexture);
    fiQ();
    AppMethodBeat.o(142224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTextureView
 * JD-Core Version:    0.7.0.1
 */