import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class afuu
  implements View.OnClickListener
{
  public afuu(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void onClick(View paramView)
  {
    znw.a(this.a.jdField_a_of_type_Afwg);
    znw.a(this.a.jdField_a_of_type_JavaUtilList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(((afwe)this.a.jdField_a_of_type_JavaUtilList.get(i)).a);
      i += 1;
    }
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("extra_member_uin_list", localArrayList);
    this.a.setResult(-1, localIntent);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afuu
 * JD-Core Version:    0.7.0.1
 */