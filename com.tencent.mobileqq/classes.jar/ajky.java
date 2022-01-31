import java.util.ArrayList;
import java.util.Iterator;

public class ajky
{
  int jdField_a_of_type_Int = -1;
  String jdField_a_of_type_JavaLangString;
  ArrayList<ajkx> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public void a()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public String toString()
  {
    int i = 2000;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size() * 100;
    if (j > 2000) {}
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder(i);
      localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append(",");
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localStringBuilder.append("{");
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localStringBuilder.append((ajkx)localIterator.next()).append(",");
            continue;
            if (j >= 100) {
              break label155;
            }
            i = 100;
            break;
          }
        }
        localStringBuilder.append("}");
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      label155:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajky
 * JD-Core Version:    0.7.0.1
 */