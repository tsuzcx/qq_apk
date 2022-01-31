import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;

public class acrn
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private acrr jdField_a_of_type_Acrr;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public acrn(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView, acrr paramacrr)
  {
    super(paramView);
    this.jdField_a_of_type_Acrr = paramacrr;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362837));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(ProfileGuideDialogUtils.a);
  }
  
  public void a(acrn paramacrn, acrq paramacrq)
  {
    String str = "";
    boolean bool = false;
    switch (paramacrq.f)
    {
    default: 
      paramacrq = str;
    }
    for (;;)
    {
      paramacrn.jdField_a_of_type_AndroidWidgetTextView.setText(paramacrq);
      paramacrn.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramacrq = "载入中，请稍候...";
      continue;
      paramacrq = "加载失败，点击重试";
      bool = true;
      continue;
      paramacrq = "暂无更多的人啦~";
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Acrr != null) {
      this.jdField_a_of_type_Acrr.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrn
 * JD-Core Version:    0.7.0.1
 */