package io.flutter.embedding.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.renderer.a;
import io.flutter.embedding.engine.renderer.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

@TargetApi(19)
public class FlutterImageView
  extends View
  implements c
{
  private Bitmap FAF;
  private Queue<Image> aaoP;
  private Image aaoQ;
  private a aaoR;
  private FlutterImageView.a aaoS;
  private int aaoT;
  private boolean aaoU;
  private ImageReader jUA;
  
  public FlutterImageView(Context paramContext, int paramInt1, int paramInt2, FlutterImageView.a parama)
  {
    this(paramContext, oj(paramInt1, paramInt2), parama);
    AppMethodBeat.i(254299);
    AppMethodBeat.o(254299);
  }
  
  private FlutterImageView(Context paramContext, ImageReader paramImageReader, FlutterImageView.a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(254301);
    this.aaoT = 0;
    this.aaoU = false;
    this.jUA = paramImageReader;
    this.aaoS = parama;
    this.aaoP = new LinkedList();
    setAlpha(0.0F);
    AppMethodBeat.o(254301);
  }
  
  public FlutterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, 1, 1, FlutterImageView.a.aaoW);
  }
  
  @TargetApi(19)
  private static ImageReader oj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254302);
    if (Build.VERSION.SDK_INT >= 29)
    {
      localImageReader = ImageReader.newInstance(paramInt1, paramInt2, 1, 3, 768L);
      AppMethodBeat.o(254302);
      return localImageReader;
    }
    ImageReader localImageReader = ImageReader.newInstance(paramInt1, paramInt2, 1, 3);
    AppMethodBeat.o(254302);
    return localImageReader;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(254305);
    if (this.aaoU)
    {
      AppMethodBeat.o(254305);
      return;
    }
    switch (FlutterImageView.1.aaoV[this.aaoS.ordinal()])
    {
    }
    for (;;)
    {
      setAlpha(1.0F);
      this.aaoR = parama;
      this.aaoU = true;
      AppMethodBeat.o(254305);
      return;
      parama.u(this.jUA.getSurface());
    }
  }
  
  public a getAttachedRenderer()
  {
    return this.aaoR;
  }
  
  public Surface getSurface()
  {
    AppMethodBeat.i(254303);
    Surface localSurface = this.jUA.getSurface();
    AppMethodBeat.o(254303);
    return localSurface;
  }
  
  @TargetApi(19)
  public final boolean iAA()
  {
    AppMethodBeat.i(254312);
    if (!this.aaoU)
    {
      AppMethodBeat.o(254312);
      return false;
    }
    int j = this.aaoP.size();
    int i = j;
    if (this.aaoQ != null) {
      i = j + 1;
    }
    if (i < this.jUA.getMaxImages())
    {
      Image localImage = this.jUA.acquireLatestImage();
      if (localImage != null) {
        this.aaoP.add(localImage);
      }
    }
    invalidate();
    if (!this.aaoP.isEmpty())
    {
      AppMethodBeat.o(254312);
      return true;
    }
    AppMethodBeat.o(254312);
    return false;
  }
  
  public final void iAz()
  {
    AppMethodBeat.i(254308);
    if (!this.aaoU)
    {
      AppMethodBeat.o(254308);
      return;
    }
    setAlpha(0.0F);
    iAA();
    this.FAF = null;
    Iterator localIterator = this.aaoP.iterator();
    while (localIterator.hasNext()) {
      ((Image)localIterator.next()).close();
    }
    this.aaoP.clear();
    if (this.aaoQ != null)
    {
      this.aaoQ.close();
      this.aaoQ = null;
    }
    invalidate();
    this.aaoU = false;
    AppMethodBeat.o(254308);
  }
  
  public final void ok(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254314);
    if (this.aaoR == null)
    {
      AppMethodBeat.o(254314);
      return;
    }
    if ((paramInt1 == this.jUA.getWidth()) && (paramInt2 == this.jUA.getHeight()))
    {
      AppMethodBeat.o(254314);
      return;
    }
    this.aaoP.clear();
    this.aaoQ = null;
    this.jUA.close();
    this.jUA = oj(paramInt1, paramInt2);
    this.aaoT = 0;
    AppMethodBeat.o(254314);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(254320);
    super.onDraw(paramCanvas);
    Object localObject;
    if (!this.aaoP.isEmpty())
    {
      if (this.aaoQ != null) {
        this.aaoQ.close();
      }
      this.aaoQ = ((Image)this.aaoP.poll());
      if (Build.VERSION.SDK_INT < 29) {
        break label113;
      }
      localObject = this.aaoQ.getHardwareBuffer();
      this.FAF = Bitmap.wrapHardwareBuffer((HardwareBuffer)localObject, ColorSpace.get(ColorSpace.Named.SRGB));
      ((HardwareBuffer)localObject).close();
    }
    for (;;)
    {
      if (this.FAF != null) {
        paramCanvas.drawBitmap(this.FAF, 0.0F, 0.0F, null);
      }
      AppMethodBeat.o(254320);
      return;
      label113:
      localObject = this.aaoQ.getPlanes();
      if (localObject.length == 1)
      {
        localObject = localObject[0];
        int i = ((Image.Plane)localObject).getRowStride() / ((Image.Plane)localObject).getPixelStride();
        int j = this.aaoQ.getHeight();
        if ((this.FAF == null) || (this.FAF.getWidth() != i) || (this.FAF.getHeight() != j)) {
          this.FAF = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        }
        this.FAF.copyPixelsFromBuffer(((Image.Plane)localObject).getBuffer());
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(254322);
    if ((paramInt1 == this.jUA.getWidth()) && (paramInt2 == this.jUA.getHeight()))
    {
      AppMethodBeat.o(254322);
      return;
    }
    if ((this.aaoS == FlutterImageView.a.aaoW) && (this.aaoU))
    {
      ok(paramInt1, paramInt2);
      this.aaoR.u(this.jUA.getSurface());
    }
    AppMethodBeat.o(254322);
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterImageView
 * JD-Core Version:    0.7.0.1
 */