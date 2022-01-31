import android.view.WindowManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.surfaceviewaction.gl.ImageButton.OnClickListener;
import com.tencent.mobileqq.surfaceviewaction.gl.RobotSpriteVideoView;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;

class ajtt
  implements ImageButton.OnClickListener
{
  ajtt(ajts paramajts) {}
  
  public void a(Sprite paramSprite)
  {
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView != null)
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView.n();
      RobotResourcesManager.a(this.a.a).removeView(this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView);
    }
    this.a.a.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView = null;
    this.a.a.jdField_a_of_type_JavaLangString = null;
    if (this.a.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtt
 * JD-Core Version:    0.7.0.1
 */