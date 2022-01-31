import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.widget.TipsBar;

class ahkn
  implements View.OnClickListener
{
  ahkn(ahkf paramahkf, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!apvb.a(apke.a().b()))
    {
      apke.a().c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
      return;
    }
    paramView = new ForwardFileInfo();
    paramView.b(10008);
    Intent localIntent = new Intent(ahkf.a(this.jdField_a_of_type_Ahkf), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramView);
    ahkf.a(this.jdField_a_of_type_Ahkf).startActivity(localIntent);
    apuc.a("0X8004BFE");
    axqw.a(ahkf.a(this.jdField_a_of_type_Ahkf).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkn
 * JD-Core Version:    0.7.0.1
 */