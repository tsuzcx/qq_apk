import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajgq
  implements View.OnClickListener
{
  ajgq(ajgp paramajgp) {}
  
  public void onClick(View paramView)
  {
    bdll.b(null, "dc00899", "Grp_find_new", "", "grptab", "seach_clk", 0, 0, this.a.a.c, this.a.a.a, "", "");
    Intent localIntent = new Intent(this.a.a.getActivity(), SearchContactsActivity.class);
    localIntent.putExtra("from_key", 1);
    localIntent.putExtra("fromType", 13);
    this.a.a.getActivity().startActivity(localIntent);
    this.a.a.getActivity().overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajgq
 * JD-Core Version:    0.7.0.1
 */