import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.qidian.plugin.QidianWpaWebviewPlugin;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class alnq
  implements ActionSheet.OnButtonClickListener
{
  alnq(alnp paramalnp, Intent paramIntent, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      paramView = this.jdField_a_of_type_AndroidContentIntent.getExtras();
      if ((paramView.containsKey("request_type")) && (paramView.containsKey("uin")) && (paramView.containsKey("sigt")) && (paramView.containsKey("nickname"))) {
        QidianWpaWebviewPlugin.a(this.jdField_a_of_type_Alnp.a, paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alnq
 * JD-Core Version:    0.7.0.1
 */