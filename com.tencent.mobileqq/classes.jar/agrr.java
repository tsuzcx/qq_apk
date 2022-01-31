import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.precover.PrecoverReporter;
import com.tencent.mobileqq.precover.PrecoverResDownloader;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class agrr
  implements Runnable
{
  public agrr(PrecoverManager paramPrecoverManager, String paramString) {}
  
  public void run()
  {
    boolean bool1 = true;
    Object localObject4;
    Object localObject3;
    for (;;)
    {
      synchronized (PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager))
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          Object localObject1 = PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).keySet();
          localObject4 = new ArrayList();
          localObject1 = ((Set)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject5 = (String)((Iterator)localObject1).next();
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, new Object[] { "startDownload, download business=", localObject5 });
          }
          localObject5 = (List)PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).get(localObject5);
          if ((localObject5 == null) || (((List)localObject5).size() <= 0)) {
            continue;
          }
          ((List)localObject4).addAll((Collection)localObject5);
        }
      }
      localObject3 = new HashSet();
      ((Set)localObject3).add(this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_JavaLangString == null) && (PrecoverUtils.a(PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).getApp(), "res_cover"))) {}
    for (;;)
    {
      if (bool1)
      {
        PrecoverUtils.a(PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).getApp(), "res_cover");
        PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager, true);
        PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager, new HashSet());
        PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverManager", 2, new Object[] { "startDownload, needReport=", Boolean.valueOf(bool1), ", resToDownload.size=", Integer.valueOf(((List)localObject4).size()) });
      }
      localObject3 = ((List)localObject4).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (PrecoverResource)((Iterator)localObject3).next();
        if ((localObject4 != null) && (((PrecoverResource)localObject4).isValid()))
        {
          if ((bool1) && (PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager) != null)) {
            PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).add(localObject4);
          }
          boolean bool2 = PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).a((PrecoverResource)localObject4, null, true, false);
          if ((bool1) && (PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager) != null) && (!bool2)) {
            PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).remove(localObject4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("PrecoverManager", 2, "startDownload, res=" + localObject4 + ", started=" + bool2);
          }
        }
      }
      if ((bool1) && (PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager) != null) && (PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrecoverManager", 2, "startDownload, nothing need download, doing report");
        }
        PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager, false);
        PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).b(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager);
        PrecoverManager.a(this.jdField_a_of_type_ComTencentMobileqqPrecoverPrecoverManager).a();
      }
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrr
 * JD-Core Version:    0.7.0.1
 */