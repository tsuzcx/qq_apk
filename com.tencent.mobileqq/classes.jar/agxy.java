import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.widget.TipsBar;

class agxy
  implements View.OnClickListener
{
  agxy(agxq paramagxq, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!apdh.a(aosu.a().b()))
    {
      aosu.a().c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
      return;
    }
    paramView = new ForwardFileInfo();
    paramView.b(10008);
    Intent localIntent = new Intent(agxq.a(this.jdField_a_of_type_Agxq), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramView);
    agxq.a(this.jdField_a_of_type_Agxq).startActivity(localIntent);
    apci.a("0X8004BFE");
    awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 2, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agxy
 * JD-Core Version:    0.7.0.1
 */