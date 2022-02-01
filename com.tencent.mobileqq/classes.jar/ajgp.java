import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.1;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.2;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.8.3;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ajgp
  extends anyz
{
  public ajgp(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void onGetSuspiciousSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
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
        if (this.a.jdField_a_of_type_Ajdx != null)
        {
          this.a.jdField_a_of_type_Ajdx.a(new TroopNotifyAndRecommendView.8.1(this, paramBoolean1, paramBoolean2, paramList));
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
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotifyAndRecommendView", 2, "onGetSystemMsgFin.bengin");
    }
    try
    {
      if (this.a.jdField_a_of_type_Ajdx != null) {
        this.a.jdField_a_of_type_Ajdx.a(new TroopNotifyAndRecommendView.8.2(this, paramBoolean1, paramList));
      }
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  protected void onSendSystemMsgActionError(String paramString)
  {
    if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing()))
    {
      this.a.jdField_a_of_type_Bisl.dismiss();
      paramString = this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131719155);
      QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, 1, paramString, 0).b(this.a.a());
    }
  }
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    if (this.a.jdField_a_of_type_Ajdx != null) {
      this.a.jdField_a_of_type_Ajdx.a(new TroopNotifyAndRecommendView.8.3(this, paramString1, paramBoolean, paramString3, paramInt3, paramString2, paramString4, paramInt1, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgp
 * JD-Core Version:    0.7.0.1
 */