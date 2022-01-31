import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.config.BaseCheckHandler.ItemConfig;
import com.tencent.mobileqq.armap.config.StarConfigCheckHander;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class abmt
  implements Runnable
{
  public abmt(StarConfigCheckHander paramStarConfigCheckHander, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null)
    {
      if (!(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label92;
      }
      localObject1 = (ARMapConfigManager)this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(189);
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig = ((ARMapConfigManager)localObject1).a();
    }
    label92:
    do
    {
      while (this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.d, 2, "ARMapConfig is null");
        }
        StarConfigCheckHander.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander, 1, null);
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof ArMapInterface))
        {
          localObject1 = (ARMapManager)this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(209);
          this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig = ((ARMapManager)localObject1).a(true);
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.pccBid)) {
        com.tencent.mobileqq.armap.config.BaseCheckHandler.e = this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.pccBid;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.b = StarConfigCheckHander.a(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig);
    } while (this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.b == null);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.d, 2, "check() start checking...");
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.b);
    int j = ((List)localObject1).size();
    localObject1 = ((List)localObject1).iterator();
    int i = 0;
    label257:
    Object localObject2;
    boolean bool;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseCheckHandler.ItemConfig)((Iterator)localObject1).next();
      bool = this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.a((BaseCheckHandler.ItemConfig)localObject2);
      if (!bool) {
        break label595;
      }
      i += 1;
    }
    label585:
    label590:
    label595:
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.d, 2, "check, cover=" + bool + ", config=" + localObject2);
      }
      break label257;
      label469:
      String str;
      if (QLog.isColorLevel())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.d;
        localObject2 = new StringBuilder().append("check, resCover=");
        if (j == i)
        {
          bool = true;
          QLog.d((String)localObject1, 2, bool + ", total=" + j + ", cover=" + i);
        }
      }
      else
      {
        if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig == null)) {
          break;
        }
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("config_version", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentMobileqqArmapConfigARMapConfig.version));
        if (j != i) {
          break label585;
        }
        bool = true;
        ((HashMap)localObject1).put("cover", String.valueOf(bool));
        ((HashMap)localObject1).put("totalRes", String.valueOf(j));
        ((HashMap)localObject1).put("coverRes", String.valueOf(i));
        ((HashMap)localObject1).put("coverRate", String.format("%.1f", new Object[] { Float.valueOf(1.0F * i / j) }));
        localObject2 = StatisticCollector.a(BaseApplicationImpl.getContext());
        str = this.jdField_a_of_type_ComTencentMobileqqArmapConfigStarConfigCheckHander.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        if (j != i) {
          break label590;
        }
      }
      for (bool = true;; bool = false)
      {
        ((StatisticCollector)localObject2).a(str, "armap_res_cover_star", bool, 0L, 0L, (HashMap)localObject1, "", false);
        return;
        bool = false;
        break;
        bool = false;
        break label469;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abmt
 * JD-Core Version:    0.7.0.1
 */