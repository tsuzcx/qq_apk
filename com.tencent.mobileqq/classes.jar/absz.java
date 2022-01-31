import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet.IHandleConfigCallback;
import com.tencent.mobileqq.shortvideo.ShortVideoMsgTailHelper;
import java.util.List;

public class absz
  implements ConfigServlet.IHandleConfigCallback
{
  public absz(ConfigServlet paramConfigServlet, QQAppInterface paramQQAppInterface) {}
  
  public int a()
  {
    return ShortVideoMsgTailHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
  }
  
  public void a(int paramInt)
  {
    ShortVideoMsgTailHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramInt);
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0)) {
      ShortVideoMsgTailHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     absz
 * JD-Core Version:    0.7.0.1
 */