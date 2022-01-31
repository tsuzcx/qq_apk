import android.os.Bundle;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.guide.NearbyGuideActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class aeys
  implements Runnable
{
  public aeys(NearbyGuideActivity paramNearbyGuideActivity, ArrayList paramArrayList, NearbyCardHandler paramNearbyCardHandler, Bundle paramBundle) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        PicInfo localPicInfo = new PicInfo();
        localPicInfo.a = localInteger.intValue();
        localArrayList.add(localPicInfo);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyBusinessNearbyCardHandler.a(this.jdField_a_of_type_AndroidOsBundle, localArrayList, null, true, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeys
 * JD-Core Version:    0.7.0.1
 */