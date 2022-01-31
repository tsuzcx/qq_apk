import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.open.agent.DeviceFriendListOpenFrame;
import com.tencent.open.agent.DeviceFriendListOpenFrame.ViewHolder;

public class aljk
  implements Runnable
{
  public aljk(DeviceFriendListOpenFrame paramDeviceFriendListOpenFrame, String paramString, Bitmap paramBitmap) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.a.getChildCount();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        DeviceFriendListOpenFrame.ViewHolder localViewHolder = (DeviceFriendListOpenFrame.ViewHolder)this.jdField_a_of_type_ComTencentOpenAgentDeviceFriendListOpenFrame.a.getChildAt(i).getTag();
        if ((localViewHolder != null) && (this.jdField_a_of_type_JavaLangString.equals(localViewHolder.b))) {
          localViewHolder.a.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aljk
 * JD-Core Version:    0.7.0.1
 */