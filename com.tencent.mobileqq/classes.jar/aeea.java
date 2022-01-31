import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aeea
  implements Runnable
{
  public aeea(MagicfaceActionManager paramMagicfaceActionManager, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      bool1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c;
      if (bool1) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(this.jdField_a_of_type_Int);
      localObject1 = null;
      if (this.b != 0) {
        break label277;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.a("send.xml");
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction. step 1");
      }
      if (localObject1 == null) {
        break label248;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder.a((String)localObject1);
      if (this.b == 1) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder.a((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.d();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_JavaUtilList.iterator();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool1;
        Object localObject1;
        Action localAction;
        boolean bool2;
        label248:
        if (QLog.isColorLevel()) {
          QLog.d("MagicfaceActionManager", 2, "doaction=Exception=" + localException.toString());
        }
        label277:
        label301:
        return;
        label383:
        if (bool1)
        {
          bool1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b;
          if (!bool1) {}
        }
      }
    }
    finally
    {
      if (!QLog.isColorLevel()) {
        break label417;
      }
      QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      label417:
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
    }
    if (((Iterator)localObject1).hasNext())
    {
      localAction = (Action)((Iterator)localObject1).next();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction = localAction;
      localAction.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager;
      localAction.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      bool1 = localAction.a();
      bool2 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b;
      if (!bool2) {
        break label301;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func doAction, 【magic end】");
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.b(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData);
      return;
      if (this.b != 1) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader.a("receive.xml");
      break;
      if (!localAction.d) {
        break label383;
      }
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeea
 * JD-Core Version:    0.7.0.1
 */