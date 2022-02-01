import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.17.1;
import com.tencent.mobileqq.activity.EditInfoActivity.17.2;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adwk
  extends aofu
{
  public adwk(EditInfoActivity paramEditInfoActivity) {}
  
  protected void onGetTroopMemberAutoRemark(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      if ((paramString1 != null) && (paramString1.equals(this.a.f)) && (!TextUtils.isEmpty(paramString2)) && (this.a.jdField_a_of_type_AndroidWidgetEditText != null))
      {
        this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramString2);
        this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramString2.length());
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditInfoActivity", 2, new Object[] { paramString1, paramString2 });
      }
    }
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    if (!this.a.j) {}
    for (;;)
    {
      return;
      this.a.j = false;
      this.a.b(false);
      if (paramBoolean) {
        try
        {
          paramObject = (Object[])paramObject;
          long l = ((Long)paramObject[0]).longValue();
          ((Integer)paramObject[1]).intValue();
          paramObject = (TroopMemberCard)paramObject[2];
          if ((l == Long.parseLong(this.a.e)) && (paramObject != null) && (paramObject.memberUin == Long.parseLong(this.a.f)))
          {
            this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new EditInfoActivity.17.2(this, paramObject), 700L);
            return;
          }
        }
        catch (Exception paramObject) {}
      }
    }
  }
  
  protected void onModifyTroopInfoResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList, String paramString)
  {
    if (!this.a.j) {
      return;
    }
    this.a.j = false;
    if ((!paramBoolean) || (paramArrayList == null) || (paramArrayList.size() == 0))
    {
      this.a.b(false);
      EditInfoActivity localEditInfoActivity = this.a;
      paramArrayList = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramArrayList = this.a.getString(2131694032);
      }
      QQToast.a(localEditInfoActivity, 1, paramArrayList, 0).b(this.a.getTitleBarHeight());
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new EditInfoActivity.17.1(this), 1500L);
      this.a.app.reportClickEvent("dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_failure", 0, 0, String.valueOf(this.a.e), "1", "", "");
      return;
    }
    this.a.app.reportClickEvent("dc00899", "Grp_set", "", "nickname edit", "nickname edit_sub_success", 0, 0, String.valueOf(this.a.e), "", "", "");
    paramArrayList = (aoep)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    try
    {
      paramArrayList.a(Long.parseLong(this.a.e), Long.parseLong(this.a.f));
      this.a.j = true;
      return;
    }
    catch (Exception paramArrayList)
    {
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adwk
 * JD-Core Version:    0.7.0.1
 */