import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akys
  implements View.OnClickListener
{
  akys(akyh paramakyh, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!atwl.a(atmc.a().b()))
    {
      atmc.a().c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10008);
      Intent localIntent = new Intent(akyh.a(this.jdField_a_of_type_Akyh), FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", localForwardFileInfo);
      akyh.a(this.jdField_a_of_type_Akyh).startActivity(localIntent);
      atvm.a("0X8004BFE");
      bcst.a(akyh.a(this.jdField_a_of_type_Akyh).app, "dc00898", "", "", "0X8009EE5", "0X8009EE5", 2, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akys
 * JD-Core Version:    0.7.0.1
 */