import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.smtt.sdk.TbsReaderView;

class acrw
  implements View.OnClickListener
{
  acrw(acrv paramacrv, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 5018)
    {
      paramView = this.jdField_a_of_type_Acrv.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
      if (paramView.getWidth() > paramView.getHeight()) {}
      for (int i = 0; i != 0; i = 1)
      {
        this.jdField_a_of_type_Acrv.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
        return;
      }
      this.jdField_a_of_type_Acrv.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      return;
    }
    LocalTbsViewManager.a(this.jdField_a_of_type_Acrv.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager).doCommand(Integer.valueOf(this.jdField_a_of_type_Int), null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acrw
 * JD-Core Version:    0.7.0.1
 */