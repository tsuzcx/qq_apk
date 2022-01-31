import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;

class afdx
  implements View.OnClickListener
{
  afdx(afdw paramafdw) {}
  
  public void onClick(View paramView)
  {
    axqy.b(null, "dc00899", "Grp_find_new", "", "grptab", "seach_clk", 0, 0, this.a.a.c, this.a.a.a, "", "");
    paramView = new Intent(this.a.a.getActivity(), SearchContactsActivity.class);
    paramView.putExtra("from_key", 1);
    paramView.putExtra("fromType", 13);
    this.a.a.getActivity().startActivity(paramView);
    this.a.a.getActivity().overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afdx
 * JD-Core Version:    0.7.0.1
 */