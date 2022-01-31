import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.config.BaseCheckHandler.ItemConfig;
import com.tencent.mobileqq.armap.config.ConfigCheckHander;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class abml
  implements Runnable
{
  public abml(ConfigCheckHander paramConfigCheckHander, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.d, 2, "check return,mIsChecking =" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_b_of_type_Boolean);
      }
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.d, 2, "check ,mIsChecking =" + this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_b_of_type_Boolean + ",needResCoverReport = " + this.jdField_a_of_type_Boolean);
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.a(true);
        if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
        {
          ??? = ((ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(189)).a();
          if (??? != null) {
            break label251;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.d, 2, "ARMapConfig is null");
          }
          ConfigCheckHander.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander, 1);
          return;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof ArMapInterface))
      {
        ??? = ((ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(209)).a(true);
        continue;
        label251:
        if (!TextUtils.isEmpty(((ARMapConfig)???).pccBid)) {
          com.tencent.mobileqq.armap.config.BaseCheckHandler.e = ((ARMapConfig)???).pccBid;
        }
        this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_b_of_type_JavaUtilList = ConfigCheckHander.a((ARMapConfig)???);
        Object localObject3;
        int j;
        int i;
        label354:
        Object localObject4;
        boolean bool;
        if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_b_of_type_JavaUtilList != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.d, 2, "check() start checking...");
          }
          localObject3 = new ArrayList();
          ((List)localObject3).addAll(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_b_of_type_JavaUtilList);
          j = ((List)localObject3).size();
          localObject3 = ((List)localObject3).iterator();
          i = 0;
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (BaseCheckHandler.ItemConfig)((Iterator)localObject3).next();
            bool = this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.a((BaseCheckHandler.ItemConfig)localObject4);
            if (!bool) {
              break label770;
            }
            i += 1;
          }
        }
        label770:
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.d, 2, "check, cover=" + bool + ", config=" + localObject4);
          }
          break label354;
          if (QLog.isColorLevel())
          {
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.d;
            localObject4 = new StringBuilder().append("check, resCover=");
            if (j == i)
            {
              bool = true;
              QLog.d((String)localObject3, 2, bool + ", total=" + j + ", cover=" + i);
            }
          }
          else
          {
            if ((!this.jdField_a_of_type_Boolean) || (??? == null)) {
              break;
            }
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("config_version", String.valueOf(((ARMapConfig)???).version));
            if (j != i) {
              break label731;
            }
            bool = true;
            label556:
            ((HashMap)localObject3).put("cover", String.valueOf(bool));
            ((HashMap)localObject3).put("totalRes", String.valueOf(j));
            ((HashMap)localObject3).put("coverRes", String.valueOf(i));
            ((HashMap)localObject3).put("coverRate", String.format("%.1f", new Object[] { Float.valueOf(1.0F * i / j) }));
            ??? = StatisticCollector.a(BaseApplicationImpl.getContext());
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
            if (j != i) {
              break label736;
            }
            bool = true;
            label649:
            ((StatisticCollector)???).a((String)localObject4, "armap_res_cover", bool, 0L, 0L, (HashMap)localObject3, "", false);
            if (!(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
              break;
            }
            localObject3 = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface;
            if (j != i) {
              break label741;
            }
          }
          label731:
          label736:
          label741:
          for (??? = "1";; ??? = "0")
          {
            ReportController.b((QQAppInterface)localObject3, "dc01440", "", "", "0X8007A3E", "0X8007A3E", 0, 0, (String)???, "", "", "");
            return;
            bool = false;
            break;
            bool = false;
            break label556;
            bool = false;
            break label649;
          }
          QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander.d, 2, "check(), getCheckItemList return null");
          ConfigCheckHander.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigConfigCheckHander, 1);
          return;
        }
      }
      else
      {
        ??? = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abml
 * JD-Core Version:    0.7.0.1
 */