package android.support.v4.b;

public final class d
{
  public static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    String str2 = paramObject.getClass().getSimpleName();
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 0) {}
    }
    else
    {
      str2 = paramObject.getClass().getName();
      int i = str2.lastIndexOf('.');
      str1 = str2;
      if (i > 0) {
        str1 = str2.substring(i + 1);
      }
    }
    paramStringBuilder.append(str1);
    paramStringBuilder.append('{');
    paramStringBuilder.append(Integer.toHexString(System.identityHashCode(paramObject)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.b.d
 * JD-Core Version:    0.7.0.1
 */