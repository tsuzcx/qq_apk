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

@TargetApi(14)
public class MMTextureView
  extends TextureView
{
  private Object GaA;
  private Object GaB;
  private Field Gay;
  boolean Gaz = false;
  
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
  
  private void eTh()
  {
    AppMethodBeat.i(164151);
    try
    {
      ad.i("MicroMsg.MMTextureView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      this.GaA = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      this.GaB = localField.get(this);
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
  
  private void eTi()
  {
    AppMethodBeat.i(164152);
    try
    {
      ad.i("MicroMsg.MMTextureView", "unHookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      localField.set(this, this.GaA);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      localField.set(this, this.GaB);
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
    if (this.Gaz) {
      eTi();
    }
    AppMethodBeat.o(164149);
  }
  
  public final void eTg()
  {
    AppMethodBeat.i(142223);
    if (d.lg(16))
    {
      ad.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (d.lh(20))
    {
      ad.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(142223);
      return;
    }
    if (ae.fFH.fCS == 2)
    {
      ad.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      AppMethodBeat.o(142223);
      return;
    }
    ad.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.Gay == null)
      {
        this.Gay = TextureView.class.getDeclaredField("mSurface");
        this.Gay.setAccessible(true);
      }
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)this.Gay.get(this);
      if (localSurfaceTexture != null) {
        if (!(localSurfaceTexture instanceof r))
        {
          r localr = new r();
          localr.mSurfaceTexture = localSurfaceTexture;
          this.Gay.set(this, localr);
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
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(164150);
    if (this.Gaz) {
      eTh();
    }
    super.onAttachedToWindow();
    if (this.Gaz) {
      eTi();
    }
    AppMethodBeat.o(164150);
  }
  
  @TargetApi(14)
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(142222);
    if (this.Gaz)
    {
      eTh();
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
    this.Gaz = paramBoolean;
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(142224);
    super.setSurfaceTexture(paramSurfaceTexture);
    eTg();
    AppMethodBeat.o(142224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTextureView
 * JD-Core Version:    0.7.0.1
 */