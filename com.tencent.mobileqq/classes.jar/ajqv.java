import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.1;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.2;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.9.3;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajqv
  extends aocj
{
  public ajqv(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void a(String paramString)
  {
    if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing()))
    {
      this.a.jdField_a_of_type_Bjbs.dismiss();
      paramString = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131718517);
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (this.a.jdField_a_of_type_Ajop != null) {
      this.a.jdField_a_of_type_Ajop.a(new TroopNotifyAndRecommendView.9.3(this, paramString1, paramBoolean, paramString3, paramInt3, paramString2, paramString4, paramInt1, paramInt2));
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.bengin");
    }
    try
    {
      if (this.a.jdField_a_of_type_Ajop != null) {
        this.a.jdField_a_of_type_Ajop.a(new TroopNotifyAndRecommendView.9.2(this, paramBoolean1, paramList));
      }
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSuspiciousSystemMsgFin.bengin");
    }
    if (((Activity)this.a.jdField_a_of_type_AndroidContentContext).isFinishing()) {}
    for (;;)
    {
      return;
      try
      {
        if (this.a.jdField_a_of_type_Ajop != null)
        {
          this.a.jdField_a_of_type_Ajop.a(new TroopNotifyAndRecommendView.9.1(this, paramBoolean1, paramBoolean2, paramList));
          return;
        }
      }
      catch (Exception paramList)
      {
        paramList.printStackTrace();
        QLog.d("TroopNotifyAndRecommendView", 1, "onGetSuspiciousSystemMsgFin failed", paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqv
 * JD-Core Version:    0.7.0.1
 */