import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.widget.TipsBar;

class ajbu
  implements View.OnClickListener
{
  ajbu(ajbm paramajbm, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!arof.a(ardf.a().b()))
    {
      ardf.a().c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
      return;
    }
    paramView = new ForwardFileInfo();
    paramView.b(10008);
    Intent localIntent = new Intent(ajbm.a(this.jdField_a_of_type_Ajbm), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramView);
    ajbm.a(this.jdField_a_of_type_Ajbm).startActivity(localIntent);
    arng.a("0X8004BFE");
    azmj.a(ajbm.a(this.jdField_a_of_type_Ajbm).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbu
 * JD-Core Version:    0.7.0.1
 */