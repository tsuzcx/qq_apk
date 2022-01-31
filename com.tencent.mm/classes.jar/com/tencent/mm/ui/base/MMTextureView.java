package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView
  extends TextureView
{
  private Field zmV;
  
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
  
  public final void dEs()
  {
    AppMethodBeat.i(106863);
    if (d.fw(16))
    {
      ab.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(106863);
      return;
    }
    if (d.iU(20))
    {
      ab.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(106863);
      return;
    }
    if (ac.erF.epC == 2)
    {
      ab.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(106863);
      return;
    }
    ab.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.zmV == null)
      {
        this.zmV = TextureView.class.getDeclaredField("mSurface");
        this.zmV.setAccessible(true);
      }
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)this.zmV.get(this);
      if (localSurfaceTexture != null) {
        if (!(localSurfaceTexture instanceof r))
        {
          r localr = new r();
          localr.mSurfaceTexture = localSurfaceTexture;
          this.zmV.set(this, localr);
          ab.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          AppMethodBeat.o(106863);
          return;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      ab.printErrStackTrace("MicroMsg.MMTextureView", localNoSuchFieldException, "", new Object[0]);
      ab.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      AppMethodBeat.o(106863);
      return;
      ab.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      AppMethodBeat.o(106863);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ab.printErrStackTrace("MicroMsg.MMTextureView", localIllegalArgumentException, "", new Object[0]);
      ab.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      AppMethodBeat.o(106863);
      return;
      ab.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      AppMethodBeat.o(106863);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      ab.printErrStackTrace("MicroMsg.MMTextureView", localIllegalAccessException, "", new Object[0]);
      ab.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
      AppMethodBeat.o(106863);
    }
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(106862);
    try
    {
      super.onDetachedFromWindow();
      AppMethodBeat.o(106862);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
      AppMethodBeat.o(106862);
    }
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(106864);
    super.setSurfaceTexture(paramSurfaceTexture);
    dEs();
    AppMethodBeat.o(106864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTextureView
 * JD-Core Version:    0.7.0.1
 */