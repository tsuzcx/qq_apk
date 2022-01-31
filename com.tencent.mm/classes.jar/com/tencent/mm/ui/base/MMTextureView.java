package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.TextureView;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;

@TargetApi(14)
public class MMTextureView
  extends TextureView
{
  private Field uYF;
  
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
  
  public final void cBe()
  {
    if (d.gG(16))
    {
      y.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      return;
    }
    if (d.gH(20))
    {
      y.i("MicroMsg.MMTextureView", "current API Level %d, do not do sly", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      return;
    }
    if (q.dyn.dxE == 2)
    {
      y.i("MicroMsg.MMTextureView", "do not do sly textureView, config ERROR");
      return;
    }
    y.i("MicroMsg.MMTextureView", "detect texture problem, sly");
    try
    {
      if (this.uYF == null)
      {
        this.uYF = TextureView.class.getDeclaredField("mSurface");
        this.uYF.setAccessible(true);
      }
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)this.uYF.get(this);
      if (localSurfaceTexture != null) {
        if (!(localSurfaceTexture instanceof r))
        {
          r localr = new r();
          localr.mSurfaceTexture = localSurfaceTexture;
          this.uYF.set(this, localr);
          y.i("MicroMsg.MMTextureView", "detect texture problem, wrap");
          return;
        }
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      y.printErrStackTrace("MicroMsg.MMTextureView", localNoSuchFieldException, "", new Object[0]);
      y.e("MicroMsg.MMTextureView", "detect texture problem, NoSuchFieldException");
      return;
      y.i("MicroMsg.MMTextureView", "detect texture problem, wrapped");
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      y.printErrStackTrace("MicroMsg.MMTextureView", localIllegalArgumentException, "", new Object[0]);
      y.e("MicroMsg.MMTextureView", "detect texture problem, IllegalArgumentException");
      return;
      y.i("MicroMsg.MMTextureView", "detect texture problem, no wrap");
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      y.printErrStackTrace("MicroMsg.MMTextureView", localIllegalAccessException, "", new Object[0]);
      y.e("MicroMsg.MMTextureView", "detect texture problem, IllegalAccessException");
    }
  }
  
  @TargetApi(14)
  public void onDetachedFromWindow()
  {
    try
    {
      super.onDetachedFromWindow();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.MMTextureView", localException, "unkown error", new Object[0]);
    }
  }
  
  @TargetApi(16)
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    super.setSurfaceTexture(paramSurfaceTexture);
    cBe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMTextureView
 * JD-Core Version:    0.7.0.1
 */