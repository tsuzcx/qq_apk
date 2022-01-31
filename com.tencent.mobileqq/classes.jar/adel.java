import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.ArrayList;
import java.util.List;

public abstract class adel
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int = 10;
  private int b = 25;
  
  private float a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 1) {
      return (paramFloat1 + paramFloat2) / 2.0F;
    }
    return (paramFloat2 - paramFloat1) * (paramInt2 + 1) / paramInt1 + paramFloat1;
  }
  
  private long a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 1) {
      return (paramLong1 + paramLong2) / 2L;
    }
    return (paramLong2 - paramLong1) * (paramInt2 + 1) / paramInt1 + paramLong1;
  }
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<ades> paramList);
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = 10;
    }
    if (this.b <= 0) {
      this.b = 25;
    }
    if (this.jdField_a_of_type_Float <= 0.0F) {
      this.jdField_a_of_type_Float = 1.0F;
    }
  }
  
  public abstract void a(Path paramPath, List<ades> paramList);
  
  public void a(List<ades> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
    } while (paramList.size() <= i);
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ades)paramList.get(i);
    paramInt = i + 1;
    while (paramInt < paramList.size())
    {
      ades localades = (ades)paramList.get(paramInt);
      if ((localades.a() - ((ades)localObject).a() < this.b) && (Math.abs(localades.a() - ((ades)localObject).a()) < this.jdField_a_of_type_Float))
      {
        ((ades)localObject).a(localades);
        paramInt += 1;
      }
      else
      {
        localArrayList.add(localObject);
        if (((ades)localObject).a() != localades.a()) {
          localades.a(0);
        }
        for (;;)
        {
          localObject = localades;
          break;
          localades.a(((ades)localObject).a() + 1);
        }
      }
    }
    localArrayList.add(localObject);
    paramList.clear();
    paramList.addAll(localArrayList);
  }
  
  public abstract void a(List<aden> paramList, Path paramPath, List<ades> paramList1);
  
  public abstract void a(List<aden> paramList, Path paramPath, List<ades> paramList1, int paramInt);
  
  protected boolean a(List<ades> paramList, Path paramPath)
  {
    if ((paramList == null) || (paramPath == null) || (paramList.size() == 0)) {
      return false;
    }
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f3 = localPathMeasure.getLength();
    int i = 0;
    float f1;
    for (float f2 = 0.0F; i < paramList.size(); f2 = f1)
    {
      Path localPath = new Path();
      float f4 = ((ades)paramList.get(i)).b() + f2;
      f1 = f4;
      if (f4 > f3) {
        f1 = f3;
      }
      localPathMeasure.getSegment(f2, f1, localPath, true);
      localPath.rLineTo(0.0F, 0.0F);
      paramPath.addPath(localPath);
      ((ades)paramList.get(i)).a(localPath);
      i += 1;
    }
    return true;
  }
  
  protected boolean a(List<ades> paramList, Path paramPath, float paramFloat1, float paramFloat2, long paramLong1, long paramLong2)
  {
    if (paramList == null) {
      return false;
    }
    PathMeasure localPathMeasure = new PathMeasure(paramPath, false);
    float f2 = localPathMeasure.getLength();
    int j = (int)Math.ceil(f2 / this.jdField_a_of_type_Int);
    if (j == 0) {
      return false;
    }
    int i = 0;
    paramPath = null;
    if (i < j)
    {
      Object localObject = new Path();
      float f3 = (i + 1) * this.jdField_a_of_type_Int;
      float f1 = f3;
      if (f3 > f2) {
        f1 = f2;
      }
      localPathMeasure.getSegment(this.jdField_a_of_type_Int * i, f1, (Path)localObject, true);
      ((Path)localObject).rLineTo(0.0F, 0.0F);
      localObject = new ades((Path)localObject);
      ((ades)localObject).a(a(paramFloat1, paramFloat2, j, i));
      ((ades)localObject).a(a(paramLong1, paramLong2, j, i));
      ((ades)localObject).b(f1 - this.jdField_a_of_type_Int * i);
      if ((paramPath != null) && (paramPath.a() == ((ades)localObject).a())) {
        ((ades)localObject).a(paramPath.a() + 1);
      }
      for (;;)
      {
        paramList.add(localObject);
        i += 1;
        paramPath = (Path)localObject;
        break;
        ((ades)localObject).a(0);
      }
    }
    return true;
  }
  
  public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<ades> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adel
 * JD-Core Version:    0.7.0.1
 */