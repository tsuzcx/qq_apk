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
  private final b SNr;
  public FlutterMutatorsStack SPq;
  private float SPr;
  public int left;
  public int top;
  
  public a(Context paramContext, float paramFloat, b paramb)
  {
    super(paramContext, null);
    this.SPr = paramFloat;
    this.SNr = paramb;
  }
  
  private Matrix getPlatformViewMatrix()
  {
    AppMethodBeat.i(214969);
    Matrix localMatrix = new Matrix(this.SPq.getFinalMatrix());
    localMatrix.preScale(1.0F / this.SPr, 1.0F / this.SPr);
    localMatrix.postTranslate(-this.left, -this.top);
    AppMethodBeat.o(214969);
    return localMatrix;
  }
  
  public final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(214968);
    paramCanvas.save();
    paramCanvas.concat(getPlatformViewMatrix());
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(214968);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(214967);
    paramCanvas.save();
    Iterator localIterator = this.SPq.getFinalClippingPaths().iterator();
    while (localIterator.hasNext())
    {
      Path localPath = new Path((Path)localIterator.next());
      localPath.offset(-this.left, -this.top);
      paramCanvas.clipPath(localPath);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(214967);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(214970);
    if (this.SNr == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(214970);
      return bool;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.postTranslate(this.left, this.top);
    boolean bool = this.SNr.a(paramMotionEvent, localMatrix);
    AppMethodBeat.o(214970);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.a
 * JD-Core Version:    0.7.0.1
 */