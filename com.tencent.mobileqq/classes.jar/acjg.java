import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;

public class acjg
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private acjk jdField_a_of_type_Acjk;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public acjg(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView, acjk paramacjk)
  {
    super(paramView);
    this.jdField_a_of_type_Acjk = paramacjk;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362832));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(ProfileGuideDialogUtils.a);
  }
  
  public void a(acjg paramacjg, acjj paramacjj)
  {
    String str = "";
    boolean bool = false;
    switch (paramacjj.f)
    {
    default: 
      paramacjj = str;
    }
    for (;;)
    {
      paramacjg.jdField_a_of_type_AndroidWidgetTextView.setText(paramacjj);
      paramacjg.jdField_a_of_type_AndroidWidgetTextView.setEnabled(bool);
      return;
      paramacjj = "载入中，请稍候...";
      continue;
      paramacjj = "加载失败，点击重试";
      bool = true;
      continue;
      paramacjj = "暂无更多的人啦~";
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Acjk != null) {
      this.jdField_a_of_type_Acjk.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjg
 * JD-Core Version:    0.7.0.1
 */