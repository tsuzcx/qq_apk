import Wallet.AcsMsg;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class agda
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private ArrayList<agdt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private agda(ReminderListFragment paramReminderListFragment) {}
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return;
    }
    int j = 0;
    agdt localagdt;
    int i;
    if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localagdt = (agdt)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (paramString.equals(localagdt.jdField_a_of_type_WalletAcsMsg.msg_id))
      {
        i = j;
        if (!bhsr.a(localagdt.jdField_a_of_type_JavaLangString))
        {
          i = j;
          if (j + 1 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if ((localagdt.jdField_a_of_type_Int != 1) || (((agdt)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_Int != 1)) {
              break label206;
            }
            ((agdt)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_JavaLangString = anzj.a(2131712268);
            i = j;
          }
        }
      }
    }
    for (;;)
    {
      j = i;
      if (i == this.jdField_a_of_type_JavaUtilArrayList.size()) {
        j = i - 1;
      }
      this.jdField_a_of_type_JavaUtilArrayList.remove(j);
      notifyItemRemoved(j);
      notifyItemRangeChanged(j, this.jdField_a_of_type_JavaUtilArrayList.size());
      if (getItemCount() == 0) {
        ReminderListFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment);
      }
      ReminderListFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, paramString);
      return;
      label206:
      i = j;
      if (localagdt.jdField_a_of_type_Int == 0)
      {
        i = j;
        if (((agdt)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_Int == 0)
        {
          ((agdt)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_JavaLangString = anzj.a(2131712257);
          i = j;
          continue;
          j += 1;
          break;
          i = 0;
        }
      }
    }
  }
  
  public void a(ArrayList<agdt> paramArrayList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof agdc))
    {
      agdc localagdc = (agdc)paramViewHolder;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        localagdc.a((agdt)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561031, null, false);
    return new agdc(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agda
 * JD-Core Version:    0.7.0.1
 */