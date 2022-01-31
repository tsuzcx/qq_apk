import Wallet.AcsMsg;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import java.util.ArrayList;

public class acht
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private ArrayList<acii> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private acht(ReminderListFragment paramReminderListFragment) {}
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return;
    }
    int j = 0;
    acii localacii;
    int i;
    if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localacii = (acii)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (paramString.equals(localacii.jdField_a_of_type_WalletAcsMsg.msg_id))
      {
        i = j;
        if (!baip.a(localacii.jdField_a_of_type_JavaLangString))
        {
          i = j;
          if (j + 1 < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if ((localacii.jdField_a_of_type_Int != 1) || (((acii)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_Int != 1)) {
              break label206;
            }
            ((acii)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_JavaLangString = ajjy.a(2131647597);
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
      if (localacii.jdField_a_of_type_Int == 0)
      {
        i = j;
        if (((acii)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_Int == 0)
        {
          ((acii)this.jdField_a_of_type_JavaUtilArrayList.get(j + 1)).jdField_a_of_type_JavaLangString = ajjy.a(2131647586);
          i = j;
          continue;
          j += 1;
          break;
          i = 0;
        }
      }
    }
  }
  
  public void a(ArrayList<acii> paramArrayList, boolean paramBoolean)
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
    if ((paramViewHolder instanceof achv))
    {
      paramViewHolder = (achv)paramViewHolder;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
        paramViewHolder.a((acii)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495028, null, false);
    return new achv(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acht
 * JD-Core Version:    0.7.0.1
 */