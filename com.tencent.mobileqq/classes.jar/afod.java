import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class afod
  extends baiy
{
  public afod(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {}
    while (this.a.jdField_a_of_type_Bcpq == null) {
      try
      {
        paramBundle = paramBundle.getByteArray("structMsg");
        structmsg.StructMsg localStructMsg = new structmsg.StructMsg();
        localStructMsg.mergeFrom(paramBundle);
        TroopNotifyAndRecommendView.a(this.a, 1, localStructMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        do
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopNotifyAndRecommendView", 2, "structMsg merge error");
          }
        } while (this.a.jdField_a_of_type_Bcpq == null);
        this.a.jdField_a_of_type_Bcpq.dismiss();
        bcpw.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131697633), 0).b(this.a.a());
        return;
      }
    }
    this.a.jdField_a_of_type_Bcpq.dismiss();
    bcpw.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131697633), 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afod
 * JD-Core Version:    0.7.0.1
 */