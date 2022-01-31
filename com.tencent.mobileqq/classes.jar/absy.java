import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;

class absy
  implements Runnable
{
  absy(absx paramabsx, FileMsg paramFileMsg) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Absx.a.a == null)
    {
      QLog.e("FavroamingManager", 1, "app is null");
      return;
    }
    ((FavroamingDBManager)this.jdField_a_of_type_Absx.a.a.getManager(148)).a(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absy
 * JD-Core Version:    0.7.0.1
 */