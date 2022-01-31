import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFooterView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView;
import java.util.ArrayList;
import java.util.List;

public class acro
  extends RecyclerView.Adapter
{
  private acrl jdField_a_of_type_Acrl;
  private acrq jdField_a_of_type_Acrq = new acrq(null);
  private acrr jdField_a_of_type_Acrr;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public acro(ExtendFriendSquareFragment paramExtendFriendSquareFragment, acrr paramacrr)
  {
    this.jdField_a_of_type_Acrq.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Acrr = paramacrr;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public acrq a(int paramInt)
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
          localObject1 = (acrq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
  
  public void a(int paramInt, acrq paramacrq)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramacrq);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Acrq.f = paramInt;
    if ((paramBoolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      notifyItemChanged(getItemCount() - 1);
    }
  }
  
  public void a(acrl paramacrl)
  {
    this.jdField_a_of_type_Acrl = paramacrl;
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
      return ((acrq)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    }
    return 1;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return;
    case 0: 
      paramViewHolder = (acrm)paramViewHolder;
      acrq localacrq = (acrq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewHolder.a(paramViewHolder, localacrq);
      if ((ExtendFriendSquareFragment.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) == paramInt) && (!paramViewHolder.a.b())) {
        paramViewHolder.a.c();
      }
      while (this.jdField_a_of_type_Acrl != null)
      {
        this.jdField_a_of_type_Acrl.a(localacrq.jdField_a_of_type_JavaLangString);
        return;
        paramViewHolder.a.d();
      }
    case 1: 
      paramViewHolder = (acrn)paramViewHolder;
      paramViewHolder.a(paramViewHolder, this.jdField_a_of_type_Acrq);
      return;
    }
    paramViewHolder = (acrk)paramViewHolder;
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
      return new acrm(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, paramViewGroup, this.jdField_a_of_type_Acrr);
    case 1: 
      paramViewGroup = new ExtendFriendFooterView(ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment));
      paramViewGroup.setLayoutParams(localLayoutParams);
      return new acrn(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, paramViewGroup, this.jdField_a_of_type_Acrr);
    }
    paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970344, paramViewGroup, false);
    return new acrk(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acro
 * JD-Core Version:    0.7.0.1
 */