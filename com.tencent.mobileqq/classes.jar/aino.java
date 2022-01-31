import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13.ViewHolder;
import com.tencent.mobileqq.utils.ContactUtils;

public class aino
  implements Runnable
{
  public aino(StructMsgItemLayout13 paramStructMsgItemLayout13, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, StructMsgItemLayout13.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    String str = ContactUtils.g(StructMsgItemLayout13.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout13), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.frienduin, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.author);
    new Handler(Looper.getMainLooper()).post(new ainp(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aino
 * JD-Core Version:    0.7.0.1
 */