import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;

public class acgs
  implements View.OnClickListener
{
  public acgs(ActivateFriendGrid paramActivateFriendGrid) {}
  
  public void onClick(View paramView)
  {
    paramView = (ActivateFriendGridItem)paramView;
    if (paramView.jdField_a_of_type_Boolean)
    {
      ActivateFriendGrid.a(this.a);
      if (paramView.jdField_a_of_type_Boolean) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      if (ActivateFriendGrid.a(this.a) != null) {
        ActivateFriendGrid.a(this.a).a(ActivateFriendGrid.c(this.a));
      }
      if (ActivateFriendGrid.a(this.a) != null) {
        ActivateFriendGrid.a(this.a).a(paramView.jdField_a_of_type_Int);
      }
      return;
      ActivateFriendGrid.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acgs
 * JD-Core Version:    0.7.0.1
 */