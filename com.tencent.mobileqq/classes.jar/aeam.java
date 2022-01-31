import com.tencent.mobileqq.leba.LebaWithFeeds;
import com.tencent.mobileqq.leba.header.LebaGridMenuAdapter;
import com.tencent.mobileqq.leba.model.LebaGridItemInfo;
import com.tencent.mobileqq.leba.model.PluginInfo;
import com.tencent.mobileqq.leba.view.LebaTopBarView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class aeam
  implements Runnable
{
  aeam(aeal paramaeal, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aeal.a.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_Aeal.a.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    int i = this.jdField_a_of_type_Aeal.a.jdField_a_of_type_JavaUtilList.size();
    Iterator localIterator1 = this.jdField_a_of_type_Aeal.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      LebaGridItemInfo localLebaGridItemInfo1 = (LebaGridItemInfo)localIterator1.next();
      if ((localLebaGridItemInfo1 != null) && (localLebaGridItemInfo1.jdField_a_of_type_JavaLangString != null) && (localLebaGridItemInfo1.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null))
      {
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          LebaGridItemInfo localLebaGridItemInfo2 = (LebaGridItemInfo)localIterator2.next();
          if ((localLebaGridItemInfo2 != null) && (localLebaGridItemInfo2.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo != null) && (localLebaGridItemInfo2.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName.equals(localLebaGridItemInfo1.jdField_a_of_type_ComTencentMobileqqLebaModelPluginInfo.pkgName))) {
            localLebaGridItemInfo2.jdField_a_of_type_JavaLangString = localLebaGridItemInfo1.jdField_a_of_type_JavaLangString;
          }
        }
      }
    }
    this.jdField_a_of_type_Aeal.a.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Aeal.a.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_Aeal.a.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter != null) {
      this.jdField_a_of_type_Aeal.a.jdField_a_of_type_ComTencentMobileqqLebaHeaderLebaGridMenuAdapter.a();
    }
    LebaWithFeeds.a(this.jdField_a_of_type_Aeal.a).a(this.jdField_a_of_type_JavaUtilList);
    if ((this.jdField_a_of_type_Aeal.a.jdField_a_of_type_JavaUtilList.size() > 0) && (i == 0)) {
      LebaWithFeeds.a(this.jdField_a_of_type_Aeal.a, 0);
    }
    this.jdField_a_of_type_Aeal.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134007, 100L);
    this.jdField_a_of_type_Aeal.a.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1134006, 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeam
 * JD-Core Version:    0.7.0.1
 */