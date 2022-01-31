import java.util.HashMap;

public class alsw
{
  private static HashMap<String, alsx> a = new HashMap();
  
  public static Object a(int paramInt, String paramString, Object paramObject1, Object paramObject2)
  {
    paramString = (alsx)a.get(paramString);
    if (paramString != null) {
      paramObject2 = paramString.a(paramInt, paramObject1);
    }
    return paramObject2;
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {
      a.remove(paramString);
    }
  }
  
  public static void a(String paramString, alsx paramalsx)
  {
    if (paramString != null) {
      a.put(paramString, paramalsx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alsw
 * JD-Core Version:    0.7.0.1
 */