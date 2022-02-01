package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Keep;
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
    AppMethodBeat.i(253659);
    this.mutators = new ArrayList();
    this.finalMatrix = new Matrix();
    this.finalClippingPaths = new ArrayList();
    AppMethodBeat.o(253659);
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
  
  public void pushClipRRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(253665);
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new a(localRect, paramArrayOfFloat);
    this.mutators.add(localObject);
    localObject = new Path();
    ((Path)localObject).addRoundRect(new RectF(localRect), paramArrayOfFloat, Path.Direction.CCW);
    ((Path)localObject).transform(this.finalMatrix);
    this.finalClippingPaths.add(localObject);
    AppMethodBeat.o(253665);
  }
  
  public void pushClipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(253664);
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new a(localRect);
    this.mutators.add(localObject);
    localObject = new Path();
    ((Path)localObject).addRect(new RectF(localRect), Path.Direction.CCW);
    ((Path)localObject).transform(this.finalMatrix);
    this.finalClippingPaths.add(localObject);
    AppMethodBeat.o(253664);
  }
  
  public void pushTransform(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(253661);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(paramArrayOfFloat);
    paramArrayOfFloat = new a(localMatrix);
    this.mutators.add(paramArrayOfFloat);
    this.finalMatrix.preConcat(paramArrayOfFloat.aHZ);
    AppMethodBeat.o(253661);
  }
  
  public final class a
  {
    Matrix aHZ;
    private float[] aarG;
    private FlutterMutatorsStack.b aarH = FlutterMutatorsStack.b.aarK;
    private Rect byG;
    
    public a(Matrix paramMatrix)
    {
      this.aHZ = paramMatrix;
    }
    
    public a(Rect paramRect)
    {
      this.byG = paramRect;
    }
    
    public a(Rect paramRect, float[] paramArrayOfFloat)
    {
      this.byG = paramRect;
      this.aarG = paramArrayOfFloat;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(255357);
      aarJ = new b("CLIP_RECT", 0);
      aarK = new b("CLIP_RRECT", 1);
      aarL = new b("CLIP_PATH", 2);
      aarM = new b("TRANSFORM", 3);
      aarN = new b("OPACITY", 4);
      aarO = new b[] { aarJ, aarK, aarL, aarM, aarN };
      AppMethodBeat.o(255357);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack
 * JD-Core Version:    0.7.0.1
 */