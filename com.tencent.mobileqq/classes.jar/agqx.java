import com.tencent.mobileqq.portal.FormalView;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.ComboNumber;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class agqx
  implements Runnable
{
  public agqx(FormalView paramFormalView, List paramList) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      PortalManager.ComboNumber localComboNumber = (PortalManager.ComboNumber)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localComboNumber != null)
      {
        PortalManager.a(localComboNumber.numberImageMD5, "hb_icon_path");
        if (QLog.isColorLevel()) {
          QLog.d("FormalView", 2, "setComboNumberList, preload p=" + localComboNumber);
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agqx
 * JD-Core Version:    0.7.0.1
 */