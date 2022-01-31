import android.util.SparseArray;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class adpx
  implements Runnable
{
  public adpx(HotPicManager paramHotPicManager, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.a();
    switch (this.jdField_a_of_type_Int)
    {
    default: 
    case 10001: 
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.b) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.b())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HotPicManager", 2, "cancel request");
      return;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.a(this.b);
      localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager;
      int j = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.b();
      int k = this.b;
      if (bool) {}
      for (i = 10003;; i = 10002)
      {
        ((HotPicManager)localObject).a(0, 15, j, k, true, i);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HotPicManager", 2, "request REQ_CHECK_UPDATE getLoaclVersion is " + this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.b());
        return;
      }
    case 10002: 
      localArrayList = (ArrayList)HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager).get(this.b);
      localObject = localArrayList;
      if (localArrayList == null)
      {
        localObject = new ArrayList();
        HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager).put(this.b, localObject);
      }
      i = ((ArrayList)localObject).size();
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.a(i, 16 + i - 1, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.b(), this.b, false, this.jdField_a_of_type_Int);
      return;
    }
    ArrayList localArrayList = (ArrayList)HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager).get(this.b);
    Object localObject = localArrayList;
    if (localArrayList == null)
    {
      localObject = new ArrayList();
      HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager).put(this.b, localObject);
    }
    int i = ((ArrayList)localObject).size();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.a(i, 8 + i - 1, this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicManager.b(), this.b, false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adpx
 * JD-Core Version:    0.7.0.1
 */