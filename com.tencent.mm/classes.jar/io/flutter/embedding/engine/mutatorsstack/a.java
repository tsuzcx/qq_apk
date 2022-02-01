package io.flutter.embedding.engine.mutatorsstack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.b;
import java.util.Iterator;
import java.util.List;

public final class a
  extends FrameLayout
{
  private final b aapp;
  public FlutterMutatorsStack aarC;
  private float aarD;
  private int aarE;
  private int aarF;
  public int left;
  public int top;
  
  public a(Context paramContext, float paramFloat, b paramb)
  {
    super(paramContext, null);
    this.aarD = paramFloat;
    this.aapp = paramb;
  }
  
  private Matrix getPlatformViewMatrix()
  {
    AppMethodBeat.i(253763);
    Matrix localMatrix = new Matrix(this.aarC.getFinalMatrix());
    localMatrix.preScale(1.0F / this.aarD, 1.0F / this.aarD);
    localMatrix.postTranslate(-this.left, -this.top);
    AppMethodBeat.o(253763);
    return localMatrix;
  }
  
  public final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(253761);
    paramCanvas.save();
    paramCanvas.concat(getPlatformViewMatrix());
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(253761);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(253759);
    paramCanvas.save();
    Iterator localIterator = this.aarC.getFinalClippingPaths().iterator();
    while (localIterator.hasNext())
    {
      Path localPath = new Path((Path)localIterator.next());
      localPath.offset(-this.left, -this.top);
      paramCanvas.clipPath(localPath);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(253759);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(253770);
    boolean bool;
    if (this.aapp == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(253770);
      return bool;
    }
    Matrix localMatrix = new Matrix();
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      localMatrix.postTranslate(this.left, this.top);
    }
    for (;;)
    {
      bool = this.aapp.a(paramMotionEvent, localMatrix);
      AppMethodBeat.o(253770);
      return bool;
      this.aarE = this.left;
      this.aarF = this.top;
      localMatrix.postTranslate(this.left, this.top);
      continue;
      localMatrix.postTranslate(this.aarE, this.aarF);
      this.aarE = this.left;
      this.aarF = this.top;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.a
 * JD-Core Version:    0.7.0.1
 */