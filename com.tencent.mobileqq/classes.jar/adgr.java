import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicFooterInterface;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import mqq.os.MqqHandler;

public class adgr
  implements HotPicFooterInterface
{
  int jdField_a_of_type_Int = 1;
  adgp jdField_a_of_type_Adgp;
  public boolean a;
  
  public adgr(HotPicPageView paramHotPicPageView, adgp paramadgp)
  {
    this.jdField_a_of_type_Adgp = paramadgp;
  }
  
  public RecyclerView.ViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new adgz(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_AndroidContentContext).inflate(2130968645, paramViewGroup, false), null);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    StaggeredGridLayoutManager.LayoutParams localLayoutParams1 = null;
    if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
      localLayoutParams1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
    }
    StaggeredGridLayoutManager.LayoutParams localLayoutParams2 = localLayoutParams1;
    if (localLayoutParams1 == null)
    {
      localLayoutParams2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
      paramViewHolder.itemView.setLayoutParams(localLayoutParams2);
    }
    localLayoutParams2.setFullSpan(true);
    paramInt = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_Int;
    if ((!this.jdField_a_of_type_Boolean) && (paramInt != -20) && (this.jdField_a_of_type_Int == 1))
    {
      HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(paramInt);
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      paramViewHolder.itemView.findViewById(2131362988).setVisibility(0);
      paramViewHolder.itemView.findViewById(2131362989).setVisibility(4);
      return;
    }
    if (HotPicPageView.b())
    {
      paramViewHolder.itemView.findViewById(2131362989).setVisibility(0);
      paramViewHolder.itemView.findViewById(2131362988).setVisibility(8);
      return;
    }
    ThreadManager.getUIHandler().post(new adgs(this, paramViewHolder));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adgr
 * JD-Core Version:    0.7.0.1
 */