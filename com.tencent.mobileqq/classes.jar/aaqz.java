import java.util.ArrayList;
import java.util.Iterator;

class aaqz
  implements Runnable
{
  aaqz(aaqy paramaaqy, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((aark)localIterator.next()).a(true);
    }
    localIterator = this.b.iterator();
    for (boolean bool = true; localIterator.hasNext(); bool = false) {
      ((aark)localIterator.next()).a(false);
    }
    this.jdField_a_of_type_Aaqy.a.a(bool, this.jdField_a_of_type_Aaqy.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqz
 * JD-Core Version:    0.7.0.1
 */