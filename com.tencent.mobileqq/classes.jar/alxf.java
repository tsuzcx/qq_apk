import android.util.Pair;

public final class alxf
  implements alxi
{
  public Pair a(String paramString)
  {
    paramString = paramString.split(":", 2);
    if ((paramString == null) || (paramString.length < 2)) {
      return null;
    }
    return new Pair(paramString[0].trim(), paramString[1].trim());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alxf
 * JD-Core Version:    0.7.0.1
 */