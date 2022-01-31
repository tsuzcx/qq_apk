import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.open.agent.DeviceFriendListOpenFrame;
import com.tencent.open.agent.DeviceFriendListOpenFrame.FriendListAdapter;

public class aljj
  extends Handler
{
  public aljj(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 40, 0);
      return;
    case 2: 
      this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
      return;
    }
    this.a.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame$FriendListAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljj
 * JD-Core Version:    0.7.0.1
 */