import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.BubblePopupWindow;

public class almc
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new almd(this);
  public BubblePopupWindow a;
  public String a;
  
  public almc(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramView.getTag());
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(i, "复制");
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new alme(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     almc
 * JD-Core Version:    0.7.0.1
 */