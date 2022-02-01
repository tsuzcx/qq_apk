package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

@Keep
public class FlutterMutatorsStack
{
  private List<Path> finalClippingPaths;
  private Matrix finalMatrix;
  private List<a> mutators;
  
  public FlutterMutatorsStack()
  {
    AppMethodBeat.i(214971);
    this.mutators = new ArrayList();
    this.finalMatrix = new Matrix();
    this.finalClippingPaths = new ArrayList();
    AppMethodBeat.o(214971);
  }
  
  public List<Path> getFinalClippingPaths()
  {
    return this.finalClippingPaths;
  }
  
  public Matrix getFinalMatrix()
  {
    return this.finalMatrix;
  }
  
  public List<a> getMutators()
  {
    return this.mutators;
  }
  
  public void pushClipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(214973);
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new a(localRect);
    this.mutators.add(localObject);
    localObject = new Path();
    ((Path)localObject).addRect(new RectF(localRect), Path.Direction.CCW);
    ((Path)localObject).transform(this.finalMatrix);
    this.finalClippingPaths.add(localObject);
    AppMethodBeat.o(214973);
  }
  
  public void pushTransform(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(214972);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(paramArrayOfFloat);
    paramArrayOfFloat = new a(localMatrix);
    this.mutators.add(paramArrayOfFloat);
    this.finalMatrix.preConcat(paramArrayOfFloat.gT);
    AppMethodBeat.o(214972);
  }
  
  public final class a
  {
    private FlutterMutatorsStack.b SPs = FlutterMutatorsStack.b.SPu;
    Matrix gT;
    private Rect rect;
    
    public a(Matrix paramMatrix)
    {
      this.gT = paramMatrix;
    }
    
    public a(Rect paramRect)
    {
      this.rect = paramRect;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack
 * JD-Core Version:    0.7.0.1
 */