import com.tencent.mobileqq.shortvideo.ml.decisiontree.ID3.ImpurityFunction;

public final class aihi
  extends ID3.ImpurityFunction
{
  public double a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt2 / (paramInt1 + paramInt2);
    }
    return paramInt1 / (paramInt1 + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aihi
 * JD-Core Version:    0.7.0.1
 */