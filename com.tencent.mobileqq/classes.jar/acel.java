import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class acel
  extends SyncListener
{
  public acel(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "upload_finish");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "download_finish");
    }
    ThreadManager.getUIHandler().post(new acem(this));
    this.a.i();
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005CEE", "0X8005CEE", 0, 0, paramInt + "", "", "", "");
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt1, int paramInt2)
  {
    this.a.i();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "roaming_finish");
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((FavroamingManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102)).b(this.a.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingSyncListener);
    }
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acel
 * JD-Core Version:    0.7.0.1
 */