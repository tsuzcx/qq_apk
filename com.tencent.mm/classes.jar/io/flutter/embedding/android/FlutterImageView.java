package io.flutter.embedding.android;

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
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FlutterImageView
  extends View
  implements RenderSurface
{
  private Bitmap currentBitmap;
  private Image currentImage;
  private FlutterRenderer flutterRenderer;
  private Queue<Image> imageQueue;
  private ImageReader imageReader;
  private boolean isAttachedToFlutterRenderer;
  private SurfaceKind kind;
  private int pendingImages;
  
  public FlutterImageView(Context paramContext)
  {
    this(paramContext, 1, 1, SurfaceKind.background);
  }
  
  public FlutterImageView(Context paramContext, int paramInt1, int paramInt2, SurfaceKind paramSurfaceKind)
  {
    this(paramContext, createImageReader(paramInt1, paramInt2), paramSurfaceKind);
    AppMethodBeat.i(190359);
    AppMethodBeat.o(190359);
  }
  
  FlutterImageView(Context paramContext, ImageReader paramImageReader, SurfaceKind paramSurfaceKind)
  {
    super(paramContext, null);
    AppMethodBeat.i(190374);
    this.pendingImages = 0;
    this.isAttachedToFlutterRenderer = false;
    this.imageReader = paramImageReader;
    this.kind = paramSurfaceKind;
    this.imageQueue = new LinkedList();
    init();
    AppMethodBeat.o(190374);
  }
  
  public FlutterImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, 1, 1, SurfaceKind.background);
  }
  
  private static ImageReader createImageReader(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190383);
    if (Build.VERSION.SDK_INT >= 29)
    {
      localImageReader = ImageReader.newInstance(paramInt1, paramInt2, 1, 3, 768L);
      AppMethodBeat.o(190383);
      return localImageReader;
    }
    ImageReader localImageReader = ImageReader.newInstance(paramInt1, paramInt2, 1, 3);
    AppMethodBeat.o(190383);
    return localImageReader;
  }
  
  private void init()
  {
    AppMethodBeat.i(190379);
    setAlpha(0.0F);
    AppMethodBeat.o(190379);
  }
  
  private void updateCurrentBitmap()
  {
    AppMethodBeat.i(190389);
    if (Build.VERSION.SDK_INT >= 29)
    {
      localObject = this.currentImage.getHardwareBuffer();
      this.currentBitmap = Bitmap.wrapHardwareBuffer((HardwareBuffer)localObject, ColorSpace.get(ColorSpace.Named.SRGB));
      ((HardwareBuffer)localObject).close();
      AppMethodBeat.o(190389);
      return;
    }
    Object localObject = this.currentImage.getPlanes();
    if (localObject.length != 1)
    {
      AppMethodBeat.o(190389);
      return;
    }
    localObject = localObject[0];
    int i = ((Image.Plane)localObject).getRowStride() / ((Image.Plane)localObject).getPixelStride();
    int j = this.currentImage.getHeight();
    if ((this.currentBitmap == null) || (this.currentBitmap.getWidth() != i) || (this.currentBitmap.getHeight() != j)) {
      this.currentBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    }
    this.currentBitmap.copyPixelsFromBuffer(((Image.Plane)localObject).getBuffer());
    AppMethodBeat.o(190389);
  }
  
  public boolean acquireLatestImage()
  {
    AppMethodBeat.i(190416);
    if (!this.isAttachedToFlutterRenderer)
    {
      AppMethodBeat.o(190416);
      return false;
    }
    int j = this.imageQueue.size();
    int i = j;
    if (this.currentImage != null) {
      i = j + 1;
    }
    if (i < this.imageReader.getMaxImages())
    {
      Image localImage = this.imageReader.acquireLatestImage();
      if (localImage != null) {
        this.imageQueue.add(localImage);
      }
    }
    invalidate();
    if (!this.imageQueue.isEmpty())
    {
      AppMethodBeat.o(190416);
      return true;
    }
    AppMethodBeat.o(190416);
    return false;
  }
  
  public void attachToRenderer(FlutterRenderer paramFlutterRenderer)
  {
    AppMethodBeat.i(190408);
    if (this.isAttachedToFlutterRenderer)
    {
      AppMethodBeat.o(190408);
      return;
    }
    switch (1.$SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[this.kind.ordinal()])
    {
    }
    for (;;)
    {
      setAlpha(1.0F);
      this.flutterRenderer = paramFlutterRenderer;
      this.isAttachedToFlutterRenderer = true;
      AppMethodBeat.o(190408);
      return;
      paramFlutterRenderer.swapSurface(this.imageReader.getSurface());
    }
  }
  
  public void detachFromRenderer()
  {
    AppMethodBeat.i(190412);
    if (!this.isAttachedToFlutterRenderer)
    {
      AppMethodBeat.o(190412);
      return;
    }
    setAlpha(0.0F);
    acquireLatestImage();
    this.currentBitmap = null;
    Iterator localIterator = this.imageQueue.iterator();
    while (localIterator.hasNext()) {
      ((Image)localIterator.next()).close();
    }
    this.imageQueue.clear();
    if (this.currentImage != null)
    {
      this.currentImage.close();
      this.currentImage = null;
    }
    invalidate();
    this.isAttachedToFlutterRenderer = false;
    AppMethodBeat.o(190412);
  }
  
  public FlutterRenderer getAttachedRenderer()
  {
    return this.flutterRenderer;
  }
  
  public Surface getSurface()
  {
    AppMethodBeat.i(190393);
    Surface localSurface = this.imageReader.getSurface();
    AppMethodBeat.o(190393);
    return localSurface;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(190429);
    super.onDraw(paramCanvas);
    if (!this.imageQueue.isEmpty())
    {
      if (this.currentImage != null) {
        this.currentImage.close();
      }
      this.currentImage = ((Image)this.imageQueue.poll());
      updateCurrentBitmap();
    }
    if (this.currentBitmap != null) {
      paramCanvas.drawBitmap(this.currentBitmap, 0.0F, 0.0F, null);
    }
    AppMethodBeat.o(190429);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190438);
    if ((paramInt1 == this.imageReader.getWidth()) && (paramInt2 == this.imageReader.getHeight()))
    {
      AppMethodBeat.o(190438);
      return;
    }
    if ((this.kind == SurfaceKind.background) && (this.isAttachedToFlutterRenderer))
    {
      resizeIfNeeded(paramInt1, paramInt2);
      this.flutterRenderer.swapSurface(this.imageReader.getSurface());
    }
    AppMethodBeat.o(190438);
  }
  
  public void pause() {}
  
  public void resizeIfNeeded(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190422);
    if (this.flutterRenderer == null)
    {
      AppMethodBeat.o(190422);
      return;
    }
    if ((paramInt1 == this.imageReader.getWidth()) && (paramInt2 == this.imageReader.getHeight()))
    {
      AppMethodBeat.o(190422);
      return;
    }
    this.imageQueue.clear();
    this.currentImage = null;
    this.imageReader.close();
    this.imageReader = createImageReader(paramInt1, paramInt2);
    this.pendingImages = 0;
    AppMethodBeat.o(190422);
  }
  
  public static enum SurfaceKind
  {
    static
    {
      AppMethodBeat.i(190529);
      background = new SurfaceKind("background", 0);
      overlay = new SurfaceKind("overlay", 1);
      $VALUES = new SurfaceKind[] { background, overlay };
      AppMethodBeat.o(190529);
    }
    
    private SurfaceKind() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterImageView
 * JD-Core Version:    0.7.0.1
 */