import android.content.res.Resources;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public final class aakf
  implements Runnable
{
  public aakf(ArrayList paramArrayList1, Resources paramResources, aakm paramaakm, ArrayList paramArrayList2) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aakq localaakq = (aakq)localIterator.next();
      if (localaakq.a(this.jdField_a_of_type_AndroidContentResResources))
      {
        localArrayList1.add(localaakq);
      }
      else
      {
        localaakq.c();
        localArrayList2.add(localaakq);
      }
    }
    ThreadManager.getUIHandler().post(new aakg(this, localArrayList1, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakf
 * JD-Core Version:    0.7.0.1
 */