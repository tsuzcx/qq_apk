import java.util.Comparator;

public class aidi
  implements Comparator<aidf>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public aidi(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(aidf paramaidf1, aidf paramaidf2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramaidf1.c.compareToIgnoreCase(paramaidf2.c);
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
            if (paramaidf1.jdField_b_of_type_Long == paramaidf2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramaidf1.jdField_b_of_type_Long <= paramaidf2.jdField_b_of_type_Long) {
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
          if (paramaidf1.a == paramaidf2.a) {
            return 0;
          }
          if (paramaidf1.a <= paramaidf2.a) {
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
        if (paramaidf1.d != paramaidf2.d) {
          break;
        }
        j = paramaidf1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramaidf2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramaidf1.d >= paramaidf2.d);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramaidf1.l == paramaidf2.l) {
        return paramaidf1.c.compareToIgnoreCase(paramaidf2.c);
      }
      return paramaidf2.l - paramaidf1.l;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidi
 * JD-Core Version:    0.7.0.1
 */