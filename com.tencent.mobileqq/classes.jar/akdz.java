import android.view.View;
import com.tencent.mobileqq.werewolves.ReflectUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.reflect.Method;

public class akdz
  implements ActionSheet.OnButtonClickListener
{
  public akdz(WerewolvesHostInterface paramWerewolvesHostInterface, Object paramObject, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = ReflectUtils.a(this.jdField_a_of_type_JavaLangObject.getClass(), "onClick", new Class[] { Integer.TYPE });
    try
    {
      paramView.invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akdz
 * JD-Core Version:    0.7.0.1
 */