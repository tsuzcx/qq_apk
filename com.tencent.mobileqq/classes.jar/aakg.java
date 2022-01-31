import java.util.ArrayList;
import java.util.Iterator;

class aakg
  implements Runnable
{
  aakg(aakf paramaakf, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aakq)localIterator.next()).a(true);
    }
    localIterator = this.b.iterator();
    for (boolean bool = true; localIterator.hasNext(); bool = false) {
      ((aakq)localIterator.next()).a(false);
    }
    this.jdField_a_of_type_Aakf.a.a(bool, this.jdField_a_of_type_Aakf.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakg
 * JD-Core Version:    0.7.0.1
 */