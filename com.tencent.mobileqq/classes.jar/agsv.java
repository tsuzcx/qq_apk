import com.tencent.mobileqq.richmedia.capture.adapter.PtvTemplateAdapter;
import com.tencent.mobileqq.richmedia.capture.view.PtvTemplateItemView;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GridView;
import java.util.ArrayList;

class agsv
  implements Runnable
{
  agsv(agst paramagst, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_Agst.a.jdField_a_of_type_ComTencentWidgetGridView.getFirstVisiblePosition();
    int k = this.jdField_a_of_type_Agst.a.jdField_a_of_type_ComTencentWidgetGridView.getLastVisiblePosition();
    int i = j;
    Object localObject;
    if (i <= k)
    {
      if (i < 0) {}
      do
      {
        i += 1;
        break;
        localObject = (PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_Agst.a.jdField_a_of_type_JavaUtilArrayList.get(i);
      } while ((localObject == null) || (!((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)));
      if (QLog.isColorLevel()) {
        QLog.i("CapturePtvTemplateManager", 2, "onProgressUpdate index: " + i + " progress: " + this.jdField_a_of_type_Int);
      }
      ((PtvTemplateManager.PtvTemplateInfo)localObject).downloading = true;
      localObject = this.jdField_a_of_type_Agst.a.jdField_a_of_type_ComTencentWidgetGridView.getChildAt(i - j);
      if ((localObject instanceof PtvTemplateItemView))
      {
        localObject = (PtvTemplateItemView)localObject;
        if (this.jdField_a_of_type_Int != 100) {
          break label193;
        }
      }
    }
    label193:
    for (i = 99;; i = this.jdField_a_of_type_Int)
    {
      ((PtvTemplateItemView)localObject).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agsv
 * JD-Core Version:    0.7.0.1
 */