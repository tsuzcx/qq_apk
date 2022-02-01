import java.util.Comparator;

public class ajtw
  implements Comparator<ajtt>
{
  int jdField_a_of_type_Int = -1;
  boolean jdField_a_of_type_Boolean = false;
  
  public ajtw(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(ajtt paramajtt1, ajtt paramajtt2)
  {
    int i = -1;
    int k = 1;
    int j = 1;
    if (this.jdField_a_of_type_Int == 0) {
      i = paramajtt1.c.compareToIgnoreCase(paramajtt2.c);
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
            if (paramajtt1.jdField_b_of_type_Long == paramajtt2.jdField_b_of_type_Long) {
              return 0;
            }
            if (paramajtt1.jdField_b_of_type_Long <= paramajtt2.jdField_b_of_type_Long) {
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
          if (paramajtt1.a == paramajtt2.a) {
            return 0;
          }
          if (paramajtt1.a <= paramajtt2.a) {
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
        if (paramajtt1.e != paramajtt2.e) {
          break;
        }
        j = paramajtt1.jdField_b_of_type_JavaLangString.compareToIgnoreCase(paramajtt2.jdField_b_of_type_JavaLangString);
        if (j == 0) {
          return 0;
        }
      } while (j <= 0);
      return 1;
    } while (paramajtt1.e >= paramajtt2.e);
    label149:
    return 1;
    label208:
    if (this.jdField_a_of_type_Int == 8)
    {
      if (paramajtt1.m == paramajtt2.m) {
        return paramajtt1.c.compareToIgnoreCase(paramajtt2.c);
      }
      return paramajtt2.m - paramajtt1.m;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtw
 * JD-Core Version:    0.7.0.1
 */