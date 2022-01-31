import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.mobileqq.extendfriend.fragment.GroupItemClickListeneer;

class acqo
  implements View.OnClickListener
{
  acqo(acqm paramacqm, ExtendFriendGroupFragment paramExtendFriendGroupFragment) {}
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Acqm.getPosition();
    int i = j;
    if (j > 0) {
      i = j - 1;
    }
    acqm.a(this.jdField_a_of_type_Acqm).a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqo
 * JD-Core Version:    0.7.0.1
 */