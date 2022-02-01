import java.util.Comparator;

public class ajvu
  implements Comparator<ajvr>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public ajvu(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(ajvr paramajvr1, ajvr paramajvr2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramajvr1.c.compareToIgnoreCase(paramajvr2.c);
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
            if (paramajvr1.jdField_b_of_type_Long == paramajvr2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramajvr1.jdField_b_of_type_Long <= paramajvr2.jdField_b_of_type_Long) {
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
          if (paramajvr1.a == paramajvr2.a) {
            return 0;
          }
          if (paramajvr1.a <= paramajvr2.a) {
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
        if (paramajvr1.f != paramajvr2.f) {
          break;
        }
        j = paramajvr1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramajvr2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramajvr1.f >= paramajvr2.f);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramajvr1.n == paramajvr2.n) {
        return paramajvr1.c.compareToIgnoreCase(paramajvr2.c);
      }
      return paramajvr2.n - paramajvr1.n;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajvu
 * JD-Core Version:    0.7.0.1
 */