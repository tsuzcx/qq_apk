import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout28;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager.LoadResourceCallback;
import com.tencent.qphone.base.util.QLog;

public class ainz
  implements RobotResourcesManager.LoadResourceCallback
{
  public ainz(StructMsgItemLayout28 paramStructMsgItemLayout28, String paramString1, String paramString2, aioa paramaioa) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.robot.StructMsg", 2, "errorCode = " + paramInt);
    }
    if (paramInt == 0) {
      RobotResourcesManager.a().a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Aioa.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainz
 * JD-Core Version:    0.7.0.1
 */