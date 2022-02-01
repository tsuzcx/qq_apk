public final class abmi
{
  private static volatile boolean a;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case -5: 
    case -4: 
    case -3: 
    case -1: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    default: 
      return 1;
    case 0: 
      return 0;
    case -2: 
      return 3;
    case -6: 
      return 6;
    case -7: 
      return 13;
    }
    return 207;
  }
  
  public static void a()
  {
    abrl.b("GdtArkUtil", String.format("init %b", new Object[] { Boolean.valueOf(a) }));
    if (a) {
      return;
    }
    try
    {
      if (a) {
        return;
      }
    }
    finally {}
    a = true;
    aoye.a(true);
    aoye.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abmi
 * JD-Core Version:    0.7.0.1
 */