import com.tencent.mobileqq.confess.TagUtils;
import com.tencent.mobileqq.confess.TagUtils.TagOriginal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public final class ablj
  implements Comparator
{
  public ablj(boolean paramBoolean, ArrayList paramArrayList) {}
  
  public int a(TagUtils.TagOriginal paramTagOriginal1, TagUtils.TagOriginal paramTagOriginal2)
  {
    int i = -1;
    if (paramTagOriginal1.jdField_a_of_type_Int > paramTagOriginal2.jdField_a_of_type_Int) {}
    do
    {
      return 1;
      if (paramTagOriginal1.jdField_a_of_type_Int < paramTagOriginal2.jdField_a_of_type_Int) {
        return -1;
      }
      if ((paramTagOriginal1.jdField_a_of_type_Boolean) && (!paramTagOriginal2.jdField_a_of_type_Boolean))
      {
        if (this.jdField_a_of_type_Boolean) {}
        for (;;)
        {
          return i;
          i = 1;
        }
      }
      if ((paramTagOriginal1.jdField_a_of_type_Boolean) || (!paramTagOriginal2.jdField_a_of_type_Boolean)) {
        break;
      }
    } while (this.jdField_a_of_type_Boolean);
    return -1;
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 3) && (Math.abs(paramTagOriginal1.jdField_a_of_type_Float - paramTagOriginal2.jdField_a_of_type_Float) > 3.0F)) {
      return Float.compare(paramTagOriginal1.jdField_a_of_type_Float, paramTagOriginal2.jdField_a_of_type_Float);
    }
    return TagUtils.a.nextInt(3) - 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ablj
 * JD-Core Version:    0.7.0.1
 */