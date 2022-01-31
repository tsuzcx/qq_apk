import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;

public class aijz
  implements Runnable
{
  public aijz(StructMsgItemVideo paramStructMsgItemVideo, Context paramContext, View paramView) {}
  
  public void run()
  {
    String str = CGILoader.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.t, StructMsgItemVideo.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo));
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo.a.obtainMessage().obj = this.jdField_a_of_type_AndroidViewView;
    if (!TextUtils.isEmpty(str))
    {
      StructMsgItemVideo.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo, this.jdField_a_of_type_AndroidContentContext, str);
      return;
    }
    StructMsgItemVideo.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemVideo, this.jdField_a_of_type_AndroidContentContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijz
 * JD-Core Version:    0.7.0.1
 */