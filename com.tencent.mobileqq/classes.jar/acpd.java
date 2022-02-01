import android.util.SparseIntArray;

public class acpd
  implements acpc
{
  private final SparseIntArray a = new SparseIntArray();
  
  public int a(int paramInt)
  {
    try
    {
      paramInt = this.a.get(paramInt, 1);
      return paramInt;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.a.put(paramInt1, paramInt2);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpd
 * JD-Core Version:    0.7.0.1
 */