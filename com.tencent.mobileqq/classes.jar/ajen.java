import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ajen
  extends bgiw
{
  public ajen(NotificationView paramNotificationView) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null)) {}
    while (this.a.jdField_a_of_type_Bisl == null) {
      try
      {
        paramBundle = paramBundle.getByteArray("structMsg");
        structmsg.StructMsg localStructMsg = new structmsg.StructMsg();
        localStructMsg.mergeFrom(paramBundle);
        NotificationView.a(this.a, 1, localStructMsg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        do
        {
          if (QLog.isColorLevel()) {
            QLog.e("NotificationView", 2, "structMsg merge error");
          }
        } while (this.a.jdField_a_of_type_Bisl == null);
        this.a.jdField_a_of_type_Bisl.dismiss();
        QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131697111), 0).b(this.a.a());
        return;
      }
    }
    this.a.jdField_a_of_type_Bisl.dismiss();
    QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidContentContext.getString(2131697111), 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajen
 * JD-Core Version:    0.7.0.1
 */