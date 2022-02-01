import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aied
  extends aiea
  implements View.OnClickListener
{
  public aied(Context paramContext, QQAppInterface paramQQAppInterface, aifw paramaifw, aigo paramaigo)
  {
    super(paramContext, paramQQAppInterface, paramaifw, paramaigo);
  }
  
  public View a(int paramInt, View paramView)
  {
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof aiee)) {}
    }
    else
    {
      localView = LayoutInflater.from(this.a).inflate(2131561485, null);
    }
    localView.setOnClickListener(this);
    localView.setTag(new aiee());
    return localView;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendBindContactGuideBuilder", 2, "start PhoneLaunchActivity");
    }
    Intent localIntent = new Intent(paramView.getContext(), BindNumberActivity.class);
    localIntent.putExtra("kSrouce", 15);
    ((Activity)paramView.getContext()).startActivityForResult(localIntent, 230);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aied
 * JD-Core Version:    0.7.0.1
 */