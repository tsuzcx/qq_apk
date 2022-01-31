import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendGroupFragment;
import com.tencent.mobileqq.extendfriend.fragment.GroupItemClickListeneer;

public class acie
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private GroupItemClickListeneer jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentGroupItemClickListeneer;
  
  public acie(ExtendFriendGroupFragment paramExtendFriendGroupFragment, View paramView, GroupItemClickListeneer paramGroupItemClickListeneer)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentGroupItemClickListeneer = paramGroupItemClickListeneer;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362832));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(ExtendFriendGroupFragment.a(paramExtendFriendGroupFragment));
  }
  
  public void a(acie paramacie, int paramInt)
  {
    String str = "";
    boolean bool = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      paramacie.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      paramacie.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      str = "载入中，请稍候...";
      continue;
      str = "加载失败，点击重试";
      bool = true;
      continue;
      str = "暂无更多的群啦~";
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentGroupItemClickListeneer != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentGroupItemClickListeneer.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acie
 * JD-Core Version:    0.7.0.1
 */