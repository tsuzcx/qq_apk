import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class akaw
  extends TroopFeedViewFactory.ViewProvider
{
  public akaw(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2130969869, null);
    }
    paramView = (akax)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new akax(this);
      ((akax)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366638));
      ((akax)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363397));
      ((akax)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368299));
      ((akax)localObject).b = ((TextView)localView.findViewById(2131368298));
      ((akax)localObject).c = ((TextView)localView.findViewById(2131368301));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((akax)localObject).jdField_a_of_type_Int = paramInt;
    ((akax)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((akax)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((akax)localObject).b.setText(paramTroopFeedItem.content);
    ((akax)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.a(paramTroopFeedItem.ex_1))
    {
      ((akax)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((akax)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841264);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " 两指向左横向滑动查看下一条通知";
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((akax)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akaw
 * JD-Core Version:    0.7.0.1
 */