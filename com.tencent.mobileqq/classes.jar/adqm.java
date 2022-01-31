import android.os.Vibrator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CountDownLatch;

public class adqm
  implements MagicfaceDecoder.MagicPlayListener
{
  public adqm(Action paramAction) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Action", 2, "fun startMagicPlay begins, sumPlayTimes:" + this.a.jdField_c_of_type_Int + ",actionGlobalData.openSound:" + this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d);
    }
    Object localObject;
    if (this.a.jdField_c_of_type_Int == 0)
    {
      this.a.b();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.c != null) && (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.c.length() > 0) && (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.e > 0)
        {
          localObject = this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes;
          ((MagicfacePlayRes)localObject).e -= 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Action", 2, "fun startMagicPlay begins, start play Sound.");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.c, this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.e);
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.a)
      {
        this.a.jdField_a_of_type_AndroidOsVibrator = ((Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
        if (this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.h != -1) {
          break label311;
        }
        this.a.jdField_a_of_type_AndroidOsVibrator.vibrate(new long[] { 0L, 1000L }, 0);
      }
    }
    for (;;)
    {
      localObject = this.a;
      ((Action)localObject).jdField_c_of_type_Int += 1;
      if (QLog.isColorLevel()) {
        QLog.d("Action", 2, "fun startMagicPlay ends, sumPlayTimes:" + this.a.jdField_c_of_type_Int);
      }
      return;
      label311:
      this.a.jdField_a_of_type_AndroidOsVibrator.vibrate(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.h * 1000);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Action", 2, "func endMagicPlay begins, isStop:" + this.a.jdField_c_of_type_Boolean + ",timeout:" + this.a.jdField_a_of_type_Int + ",playTimes:" + this.a.jdField_b_of_type_Int + ",sumPlayTimes:" + this.a.jdField_c_of_type_Int + ",isTimeout:" + this.a.jdField_b_of_type_Boolean);
    }
    if (this.a.jdField_c_of_type_Boolean) {
      this.a.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Int == -1)
      {
        if (this.a.jdField_b_of_type_Int == -1)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
          return;
        }
        if (this.a.jdField_b_of_type_Int > this.a.jdField_c_of_type_Int)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
          return;
        }
        if (this.a.jdField_b_of_type_Int == this.a.jdField_c_of_type_Int)
        {
          this.a.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
          return;
        }
      }
    } while (this.a.jdField_b_of_type_Boolean);
    this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.a.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adqm
 * JD-Core Version:    0.7.0.1
 */