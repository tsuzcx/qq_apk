import android.content.Context;
import java.util.ArrayList;

public class aiaw
{
  public ArrayList<aiax> a;
  public int[] a;
  public String[] a;
  
  public aiaw()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public void a(Context paramContext, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt1;
    String[] arrayOfString = new String[paramArrayOfInt2.length];
    int i = 0;
    while (i < paramArrayOfInt2.length)
    {
      arrayOfString[i] = paramContext.getString(paramArrayOfInt2[i]);
      this.jdField_a_of_type_JavaUtilArrayList.add(new aiax(paramArrayOfInt1[i], arrayOfString[i]));
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiaw
 * JD-Core Version:    0.7.0.1
 */