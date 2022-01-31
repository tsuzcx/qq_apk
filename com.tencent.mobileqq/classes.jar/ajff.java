import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory;
import com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider;
import com.tencent.mobileqq.utils.StringUtil;

public class ajff
  extends TroopFeedViewFactory.ViewProvider
{
  public ajff(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    super(paramTroopFeedViewFactory);
  }
  
  protected View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.a).inflate(2130969844, null);
    }
    paramView = (ajfg)localView.getTag();
    Object localObject = paramView;
    if (paramView == null)
    {
      localObject = new ajfg(this);
      ((ajfg)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366616));
      ((ajfg)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131363360));
      ((ajfg)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131368230));
      ((ajfg)localObject).b = ((TextView)localView.findViewById(2131368229));
      ((ajfg)localObject).c = ((TextView)localView.findViewById(2131368232));
      localView.setOnClickListener(this.a);
      localView.setTag(localObject);
    }
    ((ajfg)localObject).jdField_a_of_type_Int = paramInt;
    ((ajfg)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = paramTroopFeedItem;
    paramView = "[" + paramTroopFeedItem.tag + "] " + paramTroopFeedItem.title;
    ((ajfg)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
    ((ajfg)localObject).b.setText(paramTroopFeedItem.content);
    ((ajfg)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramView = "点击打开 " + paramTroopFeedItem.tag + " " + paramTroopFeedItem.title + " " + paramTroopFeedItem.content;
    if (!StringUtil.a(paramTroopFeedItem.ex_1))
    {
      ((ajfg)localObject).c.setText(paramTroopFeedItem.ex_1);
      paramView = paramView + " " + paramTroopFeedItem.ex_1;
    }
    for (;;)
    {
      ((ajfg)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841201);
      paramTroopFeedItem = paramView;
      if (!paramBoolean) {
        paramTroopFeedItem = paramView + " 两指向左横向滑动查看下一条通知";
      }
      localView.setContentDescription(paramTroopFeedItem);
      return localView;
      ((ajfg)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajff
 * JD-Core Version:    0.7.0.1
 */