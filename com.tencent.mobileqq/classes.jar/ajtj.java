import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class ajtj
  extends TroopFeedViewFactory.ViewProvider
{
  public ajtj(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2130969858, null);
    }
    paramView = (ajtk)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new ajtk(this);
      ((ajtk)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366640));
      ((ajtk)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363378));
      ((ajtk)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368297));
      ((ajtk)localObject).b = ((TextView)localView.findViewById(2131368296));
      ((ajtk)localObject).c = ((TextView)localView.findViewById(2131368299));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((ajtk)localObject).jdField_a_of_type_Int = paramInt;
    ((ajtk)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((ajtk)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((ajtk)localObject).b.setText(paramTroopFeedItem.content);
    ((ajtk)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.a(paramTroopFeedItem.ex_1))
    {
      ((ajtk)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((ajtk)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841238);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " 两指向左横向滑动查看下一条通知";
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((ajtk)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtj
 * JD-Core Version:    0.7.0.1
 */