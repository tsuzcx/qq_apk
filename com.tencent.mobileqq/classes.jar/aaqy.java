import android.content.res.Resources;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public final class aaqy
  implements Runnable
{
  public aaqy(ArrayList paramArrayList1, Resources paramResources, aarg paramaarg, ArrayList paramArrayList2) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      aark localaark = (aark)localIterator.next();
      if (localaark.a(this.jdField_a_of_type_AndroidContentResResources))
      {
        localArrayList1.add(localaark);
      }
      else
      {
        localaark.c();
        localArrayList2.add(localaark);
      }
    }
    ThreadManager.getUIHandler().post(new aaqz(this, localArrayList1, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqy
 * JD-Core Version:    0.7.0.1
 */