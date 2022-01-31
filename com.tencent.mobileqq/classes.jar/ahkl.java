import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.widget.TipsBar;

class ahkl
  implements View.OnClickListener
{
  ahkl(ahkd paramahkd, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!apvd.a(apki.a().b()))
    {
      apki.a().c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
      return;
    }
    paramView = new ForwardFileInfo();
    paramView.b(10008);
    Intent localIntent = new Intent(ahkd.a(this.jdField_a_of_type_Ahkd), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramView);
    ahkd.a(this.jdField_a_of_type_Ahkd).startActivity(localIntent);
    apue.a("0X8004BFE");
    axqy.a(ahkd.a(this.jdField_a_of_type_Ahkd).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahkl
 * JD-Core Version:    0.7.0.1
 */