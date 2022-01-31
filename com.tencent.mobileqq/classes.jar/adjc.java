import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import java.util.HashMap;

public class adjc
  implements TabBarView.OnTabChangeListener
{
  public adjc(QfileTabBarView paramQfileTabBarView) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.a.a(paramInt2) == null) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelected(true);
      this.a.b(paramInt2);
    } while (!this.a.jdField_a_of_type_Boolean);
    try
    {
      SharedPreferences.Editor localEditor = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getApplication().getSharedPreferences("aio_last_select_file", 0).edit();
      localEditor.putInt("last_select_tab_view", ((Integer)this.a.c.get(Integer.valueOf(paramInt2))).intValue());
      localEditor.commit();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adjc
 * JD-Core Version:    0.7.0.1
 */