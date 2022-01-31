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

public class aeym
  extends aeyf
  implements View.OnClickListener
{
  public aeym(Context paramContext, QQAppInterface paramQQAppInterface, aicw paramaicw, atcu paramatcu)
  {
    super(paramContext, paramQQAppInterface, paramaicw, paramatcu);
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
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = axwd.a;
      }
      if (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable == null) {
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = axwd.a;
      }
      localURLDrawable = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      localObject = localURLDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("NewFriendFillAcademicInfoBuilder", 2, "getDrawable downLoadUrl ->" + paramString);
    return localURLDrawable;
  }
  
  private void a(aeyn paramaeyn)
  {
    if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      paramaeyn.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839019);
      paramaeyn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#12B7F5"));
      paramaeyn.b.setTextColor(Color.parseColor("#7F12B7F5"));
      paramaeyn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_DVTS7XhGQJ.png"));
      return;
    }
    paramaeyn.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839020);
    paramaeyn.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(102, 255, 255, 255));
    paramaeyn.b.setTextColor(Color.argb(102, 255, 255, 255));
    paramaeyn.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a("https://qzonestyle.gtimg.cn/aoi/sola/20190920103348_9H32GY0LpT.png"));
  }
  
  public View a(int paramInt, View paramView)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof aeyn)))
    {
      paramView = new aeyn();
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495538, null);
      a((View)localObject, bajq.a(78.0F));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131302887));
      paramView.b = ((TextView)((View)localObject).findViewById(2131312349));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131312553));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)((View)localObject).findViewById(2131297930));
      a(paramView);
      ((View)localObject).setOnClickListener(this);
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      ((View)localObject).setTag(paramView);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_exp", 1, 0, "", "", "", "");
      return localObject;
    }
    Object localObject = (aeyn)paramView.getTag();
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "frd_list", "info_add_clk", 1, 0, "", "", "", "");
    paramView = new Intent(paramView.getContext(), FriendProfileMoreInfoActivity.class);
    paramView.addFlags(536870912);
    paramView.addFlags(67108864);
    ((NewFriendActivity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramView, 231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeym
 * JD-Core Version:    0.7.0.1
 */