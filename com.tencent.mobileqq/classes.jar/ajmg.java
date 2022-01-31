import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.surfaceviewaction.gl.RobotSpriteVideoView;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ajmg
  implements Runnable
{
  public ajmg(RobotResourcesManager paramRobotResourcesManager, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.robot.RobotResourcesManager", 2, "playAnim failed! aio not bind.");
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.c(this.jdField_a_of_type_JavaLangString);
      String str = (String)localObject1 + "video.mp4";
      localObject1 = (String)localObject1 + "header.png";
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.a(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView != null) {
        continue;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext;
      this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView = new RobotSpriteVideoView((Context)localObject2, true, (String)localObject1, this.b, new ajmh(this));
      RobotResourcesManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager, (WindowManager)((Context)localObject2).getSystemService("window"));
      localObject1 = new WindowManager.LayoutParams(-1, -1, 2002, 8, -2);
      ((WindowManager.LayoutParams)localObject1).gravity = 17;
      ((WindowManager.LayoutParams)localObject1).width = ((Context)localObject2).getResources().getDisplayMetrics().widthPixels;
      localObject2 = new int[2];
      Object tmp216_215 = localObject2;
      tmp216_215[0] = 506;
      Object tmp222_216 = tmp216_215;
      tmp222_216[1] = 640;
      tmp222_216;
      RobotResourcesManager.a(str, (int[])localObject2);
      ((WindowManager.LayoutParams)localObject1).height = ((int)(((WindowManager.LayoutParams)localObject1).width * localObject2[1] / localObject2[0]));
      try
      {
        RobotResourcesManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager).removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView);
        label272:
        RobotResourcesManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager).addView(this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlRobotSpriteVideoView.a(str, new ajmi(this));
        this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_JavaLangString = this.c;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopRobotRobotResourcesManager.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
        return;
      }
      catch (Exception localException)
      {
        break label272;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajmg
 * JD-Core Version:    0.7.0.1
 */