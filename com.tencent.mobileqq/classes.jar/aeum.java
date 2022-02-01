import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGridItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeum
  implements View.OnClickListener
{
  public aeum(ActivateFriendGrid paramActivateFriendGrid) {}
  
  public void onClick(View paramView)
  {
    ActivateFriendGridItem localActivateFriendGridItem = (ActivateFriendGridItem)paramView;
    if (localActivateFriendGridItem.jdField_a_of_type_Boolean)
    {
      ActivateFriendGrid.a(this.a);
      if (localActivateFriendGridItem.jdField_a_of_type_Boolean) {
        break label108;
      }
    }
    label108:
    for (boolean bool = true;; bool = false)
    {
      localActivateFriendGridItem.setChecked(bool);
      if (ActivateFriendGrid.a(this.a) != null) {
        ActivateFriendGrid.a(this.a).a(ActivateFriendGrid.c(this.a));
      }
      if (ActivateFriendGrid.a(this.a) != null) {
        ActivateFriendGrid.a(this.a).a(localActivateFriendGridItem.jdField_a_of_type_Int);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ActivateFriendGrid.b(this.a);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeum
 * JD-Core Version:    0.7.0.1
 */