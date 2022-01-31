public class aljh
{
  public static float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((paramArrayOfFloat1 != null) && (paramArrayOfFloat2 != null) && (paramArrayOfFloat1.length == paramArrayOfFloat2.length))
    {
      int i = 0;
      while (i < paramArrayOfFloat1.length)
      {
        paramArrayOfFloat1[i] = (paramArrayOfFloat2[i] * 0.9F + paramArrayOfFloat1[i] * 0.1F);
        i += 1;
      }
    }
    return paramArrayOfFloat1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aljh
 * JD-Core Version:    0.7.0.1
 */