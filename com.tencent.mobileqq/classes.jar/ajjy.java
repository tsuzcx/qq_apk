import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ajjy
  extends ajjr
  implements View.OnClickListener
{
  public ajjy(Context paramContext, QQAppInterface paramQQAppInterface, ajln paramajln, ajmf paramajmf)
  {
    super(paramContext, paramQQAppInterface, paramajln, paramajmf);
  }
  
  private URLDrawable a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    URLDrawable localURLDrawable;
    do
    {
      return localObject;
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = beyq.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = beyq.a;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendFillAcademicInfoBuilder", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(ajjz paramajjz)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramajjz.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839312);
      paramajjz.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramajjz.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramajjz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramajjz.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839313);
    paramajjz.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramajjz.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramajjz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof ajjz)))
    {
      paramView = new ajjz();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561604, null);
      a((View)localObject, bhtq.a(78.0F));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131369139));
      paramView.b = ((TextView)((View)localObject).findViewById(2131379839));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380141));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131363741));
      a(paramView);
      ((View)localObject).setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((View)localObject).setTag(paramView);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 1, 0, "", "", "", "");
      return localObject;
    }
    Object localObject = (ajjz)paramView.getTag();
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 1, 0, "", "", "", "");
    Intent localIntent = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 231);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjy
 * JD-Core Version:    0.7.0.1
 */