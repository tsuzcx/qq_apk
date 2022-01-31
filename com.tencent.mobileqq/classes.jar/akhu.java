import android.graphics.drawable.Drawable;
import android.os.Message;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

public class akhu
  implements Runnable
{
  public akhu(PendantInfo paramPendantInfo, int paramInt, long paramLong, Drawable paramDrawable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PendantInfo", 2, "getDrawable, Runnable in");
    }
    Object localObject = AvatarPendantUtil.b(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
    if (2 == this.jdField_a_of_type_Int) {
      localObject = AvatarPendantUtil.b(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Long, 8);
    }
    if (FileUtils.a((String)localObject))
    {
      if (2 == this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a();
        if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_ArrayOfJavaLangString == null) {
          this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        }
        label248:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.n == -1) || (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.p == -1)) {
                  break;
                }
              } while ((this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.n == 0) || (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler == null));
              localObject = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(20);
            } while (!PendantInfo.a((Message)localObject, this.jdField_a_of_type_Long));
            this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
            return;
            localObject = new File(AvatarPendantUtil.b(this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_Long, 4));
            if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a((File)localObject, this.jdField_a_of_type_Int) > -1) {}
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label295;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.n != 0) {
                break label248;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PendantInfo", 2, "static type request dynamic resources");
              return;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler == null);
          localObject = this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(20);
        } while (!PendantInfo.a((Message)localObject, this.jdField_a_of_type_Long));
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
        return;
        label295:
        this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, false, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasPendantInfo.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akhu
 * JD-Core Version:    0.7.0.1
 */