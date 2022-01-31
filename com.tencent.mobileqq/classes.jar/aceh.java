import android.content.Context;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aceh
  implements Runnable
{
  aceh(aceg paramaceg, EmoticonPackage paramEmoticonPackage, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_Aceg.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter;
    if (localObject != null) {
      ((EmotionPanelViewPagerAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags & 0x2) > 0) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_Aceg.a.j = false;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.extraFlags &= 0xFFFFFFFD;
      this.jdField_a_of_type_Aceg.a.c(EmoticonMainPanel.c);
    }
    label86:
    do
    {
      do
      {
        break label86;
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 3) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 5));
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
        if (this.jdField_a_of_type_Aceg.a.b.contains(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage))
        {
          this.jdField_a_of_type_Aceg.a.b.remove(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage);
          return;
        }
        this.jdField_a_of_type_Aceg.a.jdField_g_of_type_Boolean = false;
        this.jdField_a_of_type_Aceg.a.j = false;
        this.jdField_a_of_type_Aceg.a.i = false;
      } while ((this.jdField_a_of_type_Aceg.a.getVisibility() != 0) || (this.jdField_a_of_type_Aceg.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "Emoticon pkg downloaded in panel, refresh");
      }
      localObject = this.jdField_a_of_type_Aceg.a.jdField_a_of_type_JavaUtilList;
    } while (localObject == null);
    int i = 0;
    label249:
    if (i < ((List)localObject).size())
    {
      EmoticonPackage localEmoticonPackage = ((EmotionPanelInfo)((List)localObject).get(i)).jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
      if ((localEmoticonPackage == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId))) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_Aceg.a.c(i);
      this.jdField_a_of_type_Aceg.a.h = false;
      return;
      i += 1;
      break label249;
      if (this.jdField_a_of_type_Int == 11000)
      {
        QQToast.a(this.jdField_a_of_type_Aceg.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aceg.a.jdField_a_of_type_AndroidContentContext.getString(2131436304), 1).b(this.jdField_a_of_type_Aceg.a.jdField_g_of_type_Int);
        return;
      }
      if (this.jdField_a_of_type_Int != 11001) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_Aceg.a.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Aceg.a.jdField_a_of_type_AndroidContentContext.getString(2131436303), 1).b(this.jdField_a_of_type_Aceg.a.jdField_g_of_type_Int);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aceh
 * JD-Core Version:    0.7.0.1
 */