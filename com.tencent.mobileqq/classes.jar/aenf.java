import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class aenf
  implements View.OnClickListener
{
  public aenf(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (asfa.a(this.a))
      {
        this.a.jdField_a_of_type_Boolean = true;
        EmojiHomeUiPlugin.openEmojiHomePage((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), this.a.app.getAccount(), 2);
        bdll.b(this.a.app, "CliOper", "", "", "EmosSetting", "ForwardEmojiHome", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aenf
 * JD-Core Version:    0.7.0.1
 */