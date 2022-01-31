import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFooterView;
import java.util.ArrayList;
import java.util.List;

public class acjh
  extends RecyclerView.Adapter
{
  private acje jdField_a_of_type_Acje;
  private acjj jdField_a_of_type_Acjj = new acjj(null);
  private acjk jdField_a_of_type_Acjk;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public acjh(ExtendFriendSquareFragment paramExtendFriendSquareFragment, acjk paramacjk)
  {
    this.jdField_a_of_type_Acjj.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Acjk = paramacjk;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public acjj a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < i) {
          localObject1 = (acjj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramInt);
  }
  
  public void a(int paramInt, acjj paramacjj)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramacjj);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Acjj.f = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(acje paramacje)
  {
    this.jdField_a_of_type_Acje = paramacje;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return 2;
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return ((acjj)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
    case 0: 
      acjj localacjj;
      do
      {
        return;
        paramViewHolder = (acjf)paramViewHolder;
        localacjj = (acjj)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        paramViewHolder.a(paramViewHolder, localacjj);
      } while (this.jdField_a_of_type_Acje == null);
      this.jdField_a_of_type_Acje.a(localacjj.jdField_a_of_type_JavaLangString);
      return;
    case 1: 
      paramViewHolder = (acjg)paramViewHolder;
      paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Acjj);
      return;
    }
    paramViewHolder = (acjd)paramViewHolder;
    paramViewHolder.a(paramViewHolder, null);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      paramViewGroup = new ExtendFriendFeedView(ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment));
      paramViewGroup.setLayoutParams(localLayoutParams);
      return new acjf(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, paramViewGroup, this.jdField_a_of_type_Acjk);
    case 1: 
      paramViewGroup = new ExtendFriendFooterView(ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment));
      paramViewGroup.setLayoutParams(localLayoutParams);
      return new acjg(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, paramViewGroup, this.jdField_a_of_type_Acjk);
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970329, paramViewGroup, false);
    return new acjd(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjh
 * JD-Core Version:    0.7.0.1
 */