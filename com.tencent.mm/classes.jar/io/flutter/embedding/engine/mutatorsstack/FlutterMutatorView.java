package io.flutter.embedding.engine.mutatorsstack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.android.AndroidTouchProcessor;
import java.util.Iterator;
import java.util.List;

public class FlutterMutatorView
  extends FrameLayout
{
  private final AndroidTouchProcessor androidTouchProcessor;
  private int left;
  private FlutterMutatorsStack mutatorsStack;
  private int prevLeft;
  private int prevTop;
  private float screenDensity;
  private int top;
  
  public FlutterMutatorView(Context paramContext)
  {
    super(paramContext, null);
    this.screenDensity = 1.0F;
    this.androidTouchProcessor = null;
  }
  
  public FlutterMutatorView(Context paramContext, float paramFloat, AndroidTouchProcessor paramAndroidTouchProcessor)
  {
    super(paramContext, null);
    this.screenDensity = paramFloat;
    this.androidTouchProcessor = paramAndroidTouchProcessor;
  }
  
  private Matrix getPlatformViewMatrix()
  {
    AppMethodBeat.i(190130);
    Matrix localMatrix = new Matrix(this.mutatorsStack.getFinalMatrix());
    localMatrix.preScale(1.0F / this.screenDensity, 1.0F / this.screenDensity);
    localMatrix.postTranslate(-this.left, -this.top);
    AppMethodBeat.o(190130);
    return localMatrix;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(190163);
    paramCanvas.save();
    paramCanvas.concat(getPlatformViewMatrix());
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(190163);
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(190154);
    paramCanvas.save();
    Iterator localIterator = this.mutatorsStack.getFinalClippingPaths().iterator();
    while (localIterator.hasNext())
    {
      Path localPath = new Path((Path)localIterator.next());
      localPath.offset(-this.left, -this.top);
      paramCanvas.clipPath(localPath);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(190154);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(190178);
    boolean bool;
    if (this.androidTouchProcessor == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(190178);
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
      bool = this.androidTouchProcessor.onTouchEvent(paramMotionEvent, localMatrix);
      AppMethodBeat.o(190178);
      return bool;
      this.prevLeft = this.left;
      this.prevTop = this.top;
      localMatrix.postTranslate(this.left, this.top);
      continue;
      localMatrix.postTranslate(this.prevLeft, this.prevTop);
      this.prevLeft = this.left;
      this.prevTop = this.top;
    }
  }
  
  public void readyToDisplay(FlutterMutatorsStack paramFlutterMutatorsStack, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190143);
    this.mutatorsStack = paramFlutterMutatorsStack;
    this.left = paramInt1;
    this.top = paramInt2;
    paramFlutterMutatorsStack = new FrameLayout.LayoutParams(paramInt3, paramInt4);
    paramFlutterMutatorsStack.leftMargin = paramInt1;
    paramFlutterMutatorsStack.topMargin = paramInt2;
    setLayoutParams(paramFlutterMutatorsStack);
    setWillNotDraw(false);
    AppMethodBeat.o(190143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView
 * JD-Core Version:    0.7.0.1
 */