import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout28;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager.LoadResourceCallback;
import com.tencent.qphone.base.util.QLog;

public class aije
  implements RobotResourcesManager.LoadResourceCallback
{
  public aije(StructMsgItemLayout28 paramStructMsgItemLayout28, String paramString1, String paramString2, aijf paramaijf) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.robot.StructMsg", 2, "errorCode = " + paramInt);
    }
    if (paramInt == 0) {
      RobotResourcesManager.a().a(this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Aijf.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aije
 * JD-Core Version:    0.7.0.1
 */