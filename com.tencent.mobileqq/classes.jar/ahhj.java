import java.io.File;
import java.util.Calendar;

public abstract class ahhj
{
  public static float a;
  public static int a;
  public static int b = 3;
  public static int c = 2;
  public static int d = 1;
  
  static
  {
    jdField_a_of_type_Float = 0.75F;
    jdField_a_of_type_Int = 2;
  }
  
  public static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(ajed.bc);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      localObject = "0" + i;
      localStringBuilder.append(localObject);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label300;
      }
      localObject = "0" + i;
      label108:
      localStringBuilder.append(localObject);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label308;
      }
      localObject = "0" + i;
      label148:
      localStringBuilder.append(localObject);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label316;
      }
      localObject = "0" + i;
      label188:
      localStringBuilder.append(localObject);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label324;
      }
    }
    label300:
    label308:
    label316:
    label324:
    for (Object localObject = "0" + i;; localObject = Integer.valueOf(i))
    {
      localStringBuilder.append(localObject);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label332;
      }
      return localStringBuilder.toString() + ".jpg";
      localObject = Integer.valueOf(i);
      break;
      localObject = Integer.valueOf(i);
      break label108;
      localObject = Integer.valueOf(i);
      break label148;
      localObject = Integer.valueOf(i);
      break label188;
    }
    label332:
    localObject = new StringBuilder(localStringBuilder);
    int j = localStringBuilder.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        ((StringBuilder)localObject).append('(');
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(')');
        ((StringBuilder)localObject).append(".jpg");
        if (new File(((StringBuilder)localObject).toString()).exists()) {}
      }
      else
      {
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).delete(j, ((StringBuilder)localObject).length());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahhj
 * JD-Core Version:    0.7.0.1
 */