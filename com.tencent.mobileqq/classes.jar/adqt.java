import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceSensorOperation;
import com.tencent.mobileqq.statistics.ReportController;
import mqq.app.AppRuntime;

public class adqt
  implements MagicfaceActionManager.MagicfaceSensorOperation
{
  public adqt(MagicfaceActionManager paramMagicfaceActionManager) {}
  
  public void a()
  {
    AppRuntime localAppRuntime;
    if (this.a.jdField_a_of_type_Int == 1)
    {
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbJieshou", "MbWanchengXiaochu", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
      }
    }
    do
    {
      return;
      localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    } while ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface)));
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbFasong", "MbZhudongChaozuo", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adqt
 * JD-Core Version:    0.7.0.1
 */