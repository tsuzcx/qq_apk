import android.view.WindowManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;

class aiyf
  implements Runnable
{
  aiyf(aiye paramaiye) {}
  
  public void run()
  {
    if (this.a.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView != null) {
      RobotResourcesManager.a(this.a.a.a).removeView(this.a.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView);
    }
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView = null;
    this.a.a.a.jdField_a_of_type_JavaLangString = null;
    if (this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiyf
 * JD-Core Version:    0.7.0.1
 */