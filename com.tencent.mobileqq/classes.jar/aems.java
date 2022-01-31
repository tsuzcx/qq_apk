import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.nearby.NearbyProxy;

public class aems
  implements Runnable
{
  public aems(NearbyProxy paramNearbyProxy, Context paramContext) {}
  
  public void run()
  {
    ((NowProxy)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyProxy.a.getManager(181)).b(this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aems
 * JD-Core Version:    0.7.0.1
 */