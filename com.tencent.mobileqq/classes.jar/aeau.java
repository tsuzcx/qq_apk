import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import java.util.ArrayList;
import java.util.List;

public class aeau
  implements View.OnClickListener
{
  public aeau(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    xmh.a(this.a.jdField_a_of_type_Aecg);
    xmh.a(this.a.jdField_a_of_type_JavaUtilList);
    paramView = new ArrayList();
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      paramView.add(((aece)this.a.jdField_a_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", paramView);
    this.a.setResult(-1, localIntent);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeau
 * JD-Core Version:    0.7.0.1
 */