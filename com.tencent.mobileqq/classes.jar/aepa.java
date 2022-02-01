import java.util.Comparator;

public class aepa
  implements Comparator<aeox>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public aepa(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(aeox paramaeox1, aeox paramaeox2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramaeox1.c.compareToIgnoreCase(paramaeox2.c);
    }
    label89:
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            if (this.jdField_a_of_type_Int != 2) {
              break label89;
            }
            if (paramaeox1.jdField_b_of_type_Long == paramaeox2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramaeox1.jdField_b_of_type_Long <= paramaeox2.jdField_b_of_type_Long) {
              break;
            }
          } while (this.jdField_a_of_type_Boolean);
          return 1;
          if (this.jdField_a_of_type_Boolean) {}
          for (i = j;; i = -1) {
            return i;
          }
          if (this.jdField_a_of_type_Int != 3) {
            break label149;
          }
          if (paramaeox1.a == paramaeox2.a) {
            return 0;
          }
          if (paramaeox1.a <= paramaeox2.a) {
            break;
          }
        } while (this.jdField_a_of_type_Boolean);
        return 1;
        if (this.jdField_a_of_type_Boolean) {}
        for (i = k;; i = -1) {
          return i;
        }
        if (this.jdField_a_of_type_Int != 1) {
          break label208;
        }
        if (paramaeox1.e != paramaeox2.e) {
          break;
        }
        j = paramaeox1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramaeox2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramaeox1.e >= paramaeox2.e);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramaeox1.m == paramaeox2.m) {
        return paramaeox1.c.compareToIgnoreCase(paramaeox2.c);
      }
      return paramaeox2.m - paramaeox1.m;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aepa
 * JD-Core Version:    0.7.0.1
 */