import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.dating.BaseMsgBoxActivity;
import java.util.Iterator;
import java.util.List;

class acei
  implements Runnable
{
  acei(aceg paramaceg, boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Aceg.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) && (this.jdField_a_of_type_Aceg.a.jdField_a_of_type_JavaUtilList != null))
    {
      Iterator localIterator = this.jdField_a_of_type_Aceg.a.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if (localRecentBaseData.a().equals(this.jdField_a_of_type_JavaLangString))
        {
          localRecentBaseData.b = this.b;
          this.jdField_a_of_type_Aceg.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aceg.a.jdField_a_of_type_Int);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acei
 * JD-Core Version:    0.7.0.1
 */