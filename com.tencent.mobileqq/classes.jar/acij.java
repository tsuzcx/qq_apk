import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.mobileqq.extendfriend.fragment.GroupItemClickListeneer;

class acij
  implements View.OnClickListener
{
  acij(acih paramacih, ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Acih.getPosition();
    int i = j;
    if (j > 0) {
      i = j - 1;
    }
    acih.a(this.jdField_a_of_type_Acih).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acij
 * JD-Core Version:    0.7.0.1
 */