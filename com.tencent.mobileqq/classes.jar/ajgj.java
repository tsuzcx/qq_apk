import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.widget.TipsBar;

class ajgj
  implements View.OnClickListener
{
  ajgj(ajgb paramajgb, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!arso.a(arho.a().b()))
    {
      arho.a().c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
      return;
    }
    paramView = new ForwardFileInfo();
    paramView.b(10008);
    Intent localIntent = new Intent(ajgb.a(this.jdField_a_of_type_Ajgb), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramView);
    ajgb.a(this.jdField_a_of_type_Ajgb).startActivity(localIntent);
    arrp.a("0X8004BFE");
    azqs.a(ajgb.a(this.jdField_a_of_type_Ajgb).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgj
 * JD-Core Version:    0.7.0.1
 */