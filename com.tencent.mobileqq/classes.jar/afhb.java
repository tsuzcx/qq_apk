import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;

public class afhb
{
  public static float a(float paramFloat, int paramInt)
  {
    return Math.abs(paramFloat) / paramInt;
  }
  
  public static int a(int paramInt)
  {
    int i = paramInt;
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
      i = paramInt + 100;
    }
    return i;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i;
    if ((paramInt1 == 0) && (paramInt2 == 1)) {
      i = j;
    }
    for (;;)
    {
      try
      {
        boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        paramInt1 = i;
        if (bool) {
          paramInt1 = i + 100;
        }
        return paramInt1;
      }
      catch (Exception localException) {}
      if ((paramInt1 == 1) && (paramInt2 == 0))
      {
        i = 2;
      }
      else if ((paramInt1 == 1) && (paramInt2 == 2))
      {
        i = 3;
      }
      else if ((paramInt1 == 2) && (paramInt2 == 1))
      {
        i = 4;
      }
      else if ((paramInt1 == 0) && (paramInt2 == 2))
      {
        i = 7;
      }
      else
      {
        i = j;
        if (paramInt1 == 2)
        {
          i = j;
          if (paramInt2 == 0) {
            i = 6;
          }
        }
      }
    }
    return i;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 7) || (paramInt == 203) || (paramInt == 104) || (paramInt == 107) || (paramInt == 303);
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt <= 107;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhb
 * JD-Core Version:    0.7.0.1
 */