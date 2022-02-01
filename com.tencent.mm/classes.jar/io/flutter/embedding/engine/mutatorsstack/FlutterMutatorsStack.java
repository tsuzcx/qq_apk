package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FlutterMutatorsStack
{
  private List<Path> finalClippingPaths;
  private Matrix finalMatrix;
  private List<FlutterMutator> mutators;
  
  public FlutterMutatorsStack()
  {
    AppMethodBeat.i(190113);
    this.mutators = new ArrayList();
    this.finalMatrix = new Matrix();
    this.finalClippingPaths = new ArrayList();
    AppMethodBeat.o(190113);
  }
  
  public List<Path> getFinalClippingPaths()
  {
    return this.finalClippingPaths;
  }
  
  public Matrix getFinalMatrix()
  {
    return this.finalMatrix;
  }
  
  public List<FlutterMutator> getMutators()
  {
    return this.mutators;
  }
  
  public void pushClipRRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(190146);
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new FlutterMutator(localRect, paramArrayOfFloat);
    this.mutators.add(localObject);
    localObject = new Path();
    ((Path)localObject).addRoundRect(new RectF(localRect), paramArrayOfFloat, Path.Direction.CCW);
    ((Path)localObject).transform(this.finalMatrix);
    this.finalClippingPaths.add(localObject);
    AppMethodBeat.o(190146);
  }
  
  public void pushClipRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190132);
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = new FlutterMutator(localRect);
    this.mutators.add(localObject);
    localObject = new Path();
    ((Path)localObject).addRect(new RectF(localRect), Path.Direction.CCW);
    ((Path)localObject).transform(this.finalMatrix);
    this.finalClippingPaths.add(localObject);
    AppMethodBeat.o(190132);
  }
  
  public void pushTransform(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(190123);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(paramArrayOfFloat);
    paramArrayOfFloat = new FlutterMutator(localMatrix);
    this.mutators.add(paramArrayOfFloat);
    this.finalMatrix.preConcat(paramArrayOfFloat.getMatrix());
    AppMethodBeat.o(190123);
  }
  
  public class FlutterMutator
  {
    private Matrix matrix;
    private Path path;
    private float[] radiis;
    private Rect rect;
    private FlutterMutatorsStack.FlutterMutatorType type = FlutterMutatorsStack.FlutterMutatorType.CLIP_RRECT;
    
    public FlutterMutator(Matrix paramMatrix)
    {
      this.matrix = paramMatrix;
    }
    
    public FlutterMutator(Path paramPath)
    {
      this.path = paramPath;
    }
    
    public FlutterMutator(Rect paramRect)
    {
      this.rect = paramRect;
    }
    
    public FlutterMutator(Rect paramRect, float[] paramArrayOfFloat)
    {
      this.rect = paramRect;
      this.radiis = paramArrayOfFloat;
    }
    
    public Matrix getMatrix()
    {
      return this.matrix;
    }
    
    public Path getPath()
    {
      return this.path;
    }
    
    public Rect getRect()
    {
      return this.rect;
    }
    
    public FlutterMutatorsStack.FlutterMutatorType getType()
    {
      return this.type;
    }
  }
  
  public static enum FlutterMutatorType
  {
    static
    {
      AppMethodBeat.i(190166);
      CLIP_RECT = new FlutterMutatorType("CLIP_RECT", 0);
      CLIP_RRECT = new FlutterMutatorType("CLIP_RRECT", 1);
      CLIP_PATH = new FlutterMutatorType("CLIP_PATH", 2);
      TRANSFORM = new FlutterMutatorType("TRANSFORM", 3);
      OPACITY = new FlutterMutatorType("OPACITY", 4);
      $VALUES = new FlutterMutatorType[] { CLIP_RECT, CLIP_RRECT, CLIP_PATH, TRANSFORM, OPACITY };
      AppMethodBeat.o(190166);
    }
    
    private FlutterMutatorType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack
 * JD-Core Version:    0.7.0.1
 */