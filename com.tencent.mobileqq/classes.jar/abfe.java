import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.armap.ArMapHandler.RespWealthGodInfo;
import com.tencent.mobileqq.armap.ArMapObserver;
import com.tencent.mobileqq.armap.ArMapUtil;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class abfe
  extends ArMapObserver
{
  public abfe(ARMapConfigManager paramARMapConfigManager) {}
  
  public void onGetWealthGodInfo(boolean paramBoolean, ArMapHandler.RespWealthGodInfo paramRespWealthGodInfo)
  {
    Object localObject1 = paramRespWealthGodInfo.jdField_a_of_type_JavaUtilList;
    long l2 = paramRespWealthGodInfo.jdField_a_of_type_Long;
    Object localObject2 = paramRespWealthGodInfo.jdField_b_of_type_JavaUtilList;
    int i = paramRespWealthGodInfo.jdField_a_of_type_Int;
    this.a.d = paramRespWealthGodInfo.c;
    this.a.e = paramRespWealthGodInfo.jdField_b_of_type_Boolean;
    int j;
    if (i == 1) {
      if ((paramBoolean) && (localObject1 != null))
      {
        localObject1 = ARMapConfigManager.a((List)localObject1);
        if (localObject1 == null) {
          break label636;
        }
        this.a.a((WealthGodInfo)localObject1);
        if (((WealthGodInfo)localObject1).b <= 0L) {
          break label557;
        }
        j = ((WealthGodInfo)localObject1).a();
        int k = ARMapConfigManager.a(this.a, (WealthGodInfo)localObject1);
        localObject2 = ((WealthGodInfo)localObject1).a();
        if (this.a.jdField_f_of_type_Boolean) {
          break label456;
        }
        this.a.jdField_f_of_type_Boolean = true;
        paramRespWealthGodInfo = ArMapUtil.a(ARMapConfigManager.a(this.a)).getString("key_cur_pendant_breath_key", "");
        if ((TextUtils.isEmpty(paramRespWealthGodInfo)) || (paramRespWealthGodInfo.equals("daily_pendant_breath")) || (!paramRespWealthGodInfo.equals(localObject2)) || ((j != 1) && (j != 2))) {
          break label362;
        }
        this.a.a(paramRespWealthGodInfo);
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "onGetWealthGodInfo actStatus = " + j + ",pendantStatus = " + k + ",lastProcessActKey = " + paramRespWealthGodInfo + ",curActKey = " + (String)localObject2);
        }
        label259:
        if (QLog.isColorLevel()) {
          QLog.d("ARMapConfigManager", 2, "onGetWealthGodInfo newWealthGodInfo:" + localObject1);
        }
      }
    }
    for (;;)
    {
      if (l2 > 0L) {
        this.a.jdField_f_of_type_Long = (1000L * l2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "onGetWealthGodInfo isSuc:" + paramBoolean + ",status:" + i + ",interval(s) = " + l2);
      }
      return;
      label362:
      long l1;
      if (j == 1)
      {
        l1 = this.a.a((WealthGodInfo)localObject1) - MessageCache.a() * 1000L;
        ARMapConfigManager localARMapConfigManager = this.a;
        if (l1 > 0L) {}
        for (;;)
        {
          localARMapConfigManager.a((String)localObject2, false, l1);
          break;
          l1 = 0L;
        }
      }
      if (j == 2)
      {
        this.a.a((String)localObject2, false, 0L);
        break;
      }
      this.a.a(((WealthGodInfo)localObject1).a(), 1, 0L);
      break;
      label456:
      if (j == 1)
      {
        l1 = this.a.a((WealthGodInfo)localObject1) - MessageCache.a() * 1000L;
        paramRespWealthGodInfo = this.a;
        if (l1 > 0L) {}
        for (;;)
        {
          paramRespWealthGodInfo.a((String)localObject2, false, l1);
          paramRespWealthGodInfo = "";
          break;
          l1 = 0L;
        }
      }
      if (j == 2)
      {
        this.a.a((String)localObject2, false, 0L);
        paramRespWealthGodInfo = "";
        break;
      }
      this.a.a(((WealthGodInfo)localObject1).a(), 1, 0L);
      paramRespWealthGodInfo = "";
      break;
      label557:
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "onGetWealthGodInfo redpactCount is 0 ,mCurShownPendantKey = " + this.a.a);
      }
      if ((this.a.a == null) || (this.a.a.equals("daily_pendant_breath"))) {
        break label259;
      }
      this.a.a(((WealthGodInfo)localObject1).a(), 2, 0L);
      break label259;
      label636:
      if (QLog.isColorLevel()) {
        QLog.d("ARMapConfigManager", 2, "onGetWealthGodInfo recentWealthGodInfo is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abfe
 * JD-Core Version:    0.7.0.1
 */