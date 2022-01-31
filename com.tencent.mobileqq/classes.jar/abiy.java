import android.graphics.drawable.StateListDrawable;

public class abiy
  extends StateListDrawable
{
  public boolean setState(int[] paramArrayOfInt)
  {
    int k = 0;
    int j = k;
    int i;
    if (paramArrayOfInt != null)
    {
      j = k;
      if (paramArrayOfInt.length > 0)
      {
        i = 0;
        j = k;
        if (i < paramArrayOfInt.length)
        {
          if (paramArrayOfInt[i] != 16842919) {
            break label56;
          }
          j = 1;
        }
      }
    }
    if (j != 0) {
      setAlpha(128);
    }
    for (;;)
    {
      return super.setState(paramArrayOfInt);
      label56:
      i += 1;
      break;
      setAlpha(255);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abiy
 * JD-Core Version:    0.7.0.1
 */