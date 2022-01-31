import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class abge
  extends BusinessCardObserver
{
  public abge(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.c();
    if (paramBoolean)
    {
      this.a.b("更新中");
      ReportController.b(this.a.app, "CliOper", "", "", "0X8007748", "0X8007748", this.a.d, 0, "", "", "", "");
      return;
    }
    QQToast.a(this.a.getActivity(), 2, "修改失败，请重试。", 0).b(this.a.getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.c();
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_JavaLangString)))
    {
      if ((this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_Int == 2) && (this.a.c == 1))
      {
        this.a.c = 0;
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(false);
      }
      if ((!this.a.jdField_a_of_type_Boolean) || (!this.a.b) || (this.a.isFinishing())) {
        break label151;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(paramString);
      QLog.i("BusinessCard_observer", 4, "after edit and require : cardId = " + paramString);
      this.a.finish();
    }
    label151:
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(paramString);
    } while (paramString == null);
    this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardDataBusinessCard = paramString;
    BusinessCardEditActivity.a(this.a, false, true, true);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    this.a.c();
    if (paramBoolean)
    {
      QQToast.a(this.a.getActivity(), 2, "删除成功", 0).b(this.a.getTitleBarHeight());
      this.a.finish();
      return;
    }
    QQToast.a(this.a.getActivity(), 1, "删除失败", 0).b(this.a.getTitleBarHeight());
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.c();
    if (paramBoolean)
    {
      this.a.b("名片创建成功，正在拉取数据");
      if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) {
        this.a.jdField_a_of_type_JavaLangString = paramString;
      }
      if (this.a.jdField_a_of_type_Int == 4) {
        this.a.jdField_a_of_type_ComTencentMobileqqBusinessCardBusinessCardManager.a(false);
      }
      return;
    }
    paramString = this.a.getResources().getString(2131437103);
    if (paramInt == 66) {
      paramString = this.a.getResources().getString(2131437104);
    }
    QQToast.a(this.a.getActivity(), 2, paramString, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abge
 * JD-Core Version:    0.7.0.1
 */