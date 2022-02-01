import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class adxw
  implements DialogInterface.OnClickListener
{
  adxw(adxv paramadxv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      this.a.jdField_a_of_type_Adxu.a.app.getMessageFacade().removeMsgByUniseq(this.a.jdField_a_of_type_Adxu.a.a(), 0, this.a.jdField_a_of_type_Long);
      this.a.jdField_a_of_type_Adxu.a.b();
      return;
    } while (this.a.jdField_a_of_type_Adxu.a.jdField_a_of_type_Adxu.getCount() <= 0);
    this.a.jdField_a_of_type_Adxu.a.app.getMessageFacade().clearHistory(this.a.jdField_a_of_type_Adxu.a.a(), 0);
    this.a.jdField_a_of_type_Adxu.a.jdField_a_of_type_Adxu.changeCursor(this.a.jdField_a_of_type_Adxu.getCursor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxw
 * JD-Core Version:    0.7.0.1
 */