import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateCallback;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic.TroopCreateResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class aipk
  extends BizTroopObserver
{
  public aipk(TroopCreateLogic paramTroopCreateLogic) {}
  
  protected void i(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.a.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Activity localActivity = null;; localActivity = (Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      this.a.jdField_a_of_type_JavaLangRefWeakReference = null;
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback != null) {
        break;
      }
      TroopCreateLogic.a(this.a);
      return;
    }
    int i = -1;
    if (paramObject == null)
    {
      TroopCreateLogic.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(-1, "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
    if (!paramBoolean) {}
    try
    {
      int j = ((TroopCreateLogic.TroopCreateResult)paramObject).jdField_a_of_type_Int;
      i = j;
    }
    catch (Exception paramObject)
    {
      label127:
      String str;
      break label127;
    }
    TroopCreateLogic.a(this.a);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(i, "");
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
    return;
    paramObject = (TroopInfo)paramObject;
    str = paramObject.troopuin;
    if (TextUtils.isEmpty(str))
    {
      TroopCreateLogic.a(this.a);
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(-1, "");
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.f = str;
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str, Integer.toString(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_Int), "", "");
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList == null)
    {
      i = 1;
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_create_new", "", "suc_create", "person_create", 0, 0, str, "" + this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.d, "" + i, "");
      ThreadManager.post(new aipl(this, str, paramObject, i), 8, null, true);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.b)
      {
        paramObject = localActivity;
        if (localActivity == null) {
          paramObject = BaseApplicationImpl.getContext();
        }
        this.a.a(paramObject, str);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.a(0, str);
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
        break label508;
      }
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(str, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList, "");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
    }
    for (;;)
    {
      TroopCreateLogic.a(this.a);
      return;
      i = this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateInfo.jdField_a_of_type_JavaUtilArrayList.size();
      break;
      label508:
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aipk
 * JD-Core Version:    0.7.0.1
 */