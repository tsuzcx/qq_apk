import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tofumsg.DrawCircleCornerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahur
  extends agem
  implements View.OnClickListener, View.OnLayoutChangeListener
{
  int a;
  int c = 0;
  int d = 0;
  int e;
  int f = 0;
  int g = 0;
  
  public ahur(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.d = agej.a(16.0F, paramContext.getResources());
    this.jdField_e_of_type_Int = agej.a(108.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296352) * 2);
    paramQQAppInterface = (aggr)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 9);
    }
  }
  
  private View a(View paramView, ahus paramahus)
  {
    Object localObject1 = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558860, null);
      paramahus.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365046);
      paramahus.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131370633));
      paramahus.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378936));
      paramahus.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
      paramahus.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131369947));
      paramahus.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131369948));
      paramahus.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131369949));
      paramahus.c = paramView.findViewById(2131365632);
      localObject1 = paramahus.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setColorFilter(-7894119, PorterDuff.Mode.SRC_IN);
        }
        i += 1;
      }
      paramahus.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView = ((DrawCircleCornerImageView)paramView.findViewById(2131363390));
      paramahus.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setRadius(this.d);
      paramahus.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setImageDrawable(new ColorDrawable(-657670));
      paramahus.jdField_b_of_type_AndroidViewView.setOnTouchListener(mvd.a);
      paramahus.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(this);
      paramahus.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.d);
      localObject1 = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramahus.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localObject1 = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      ((View)localObject1).setContentDescription(null);
      paramahus.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahus.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localObject1;
  }
  
  private void a(ahus paramahus, int paramInt1, int paramInt2)
  {
    paramInt1 -= agej.a(30.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt2 = agej.a(54.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramInt1 > 0)
    {
      paramahus.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setCircle(paramInt1, paramInt2, this.jdField_e_of_type_Int, -920839);
      paramahus.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.invalidate();
    }
  }
  
  protected agen a()
  {
    return new ahus(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    int j = 8;
    paramMessageRecord = (MessageForTofuBaseProfile)paramMessageRecord;
    paramagen = (ahus)paramagen;
    paramView = a(paramView, paramagen);
    paramagen.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramagen.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramLinearLayout = ahnd.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
    paramLinearLayout = paramView.getResources().getString(2131689952, new Object[] { paramLinearLayout });
    paramagen.jdField_b_of_type_AndroidWidgetTextView.setText(paramLinearLayout);
    int i = 0;
    if (i < 3)
    {
      if (paramagen.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i] != null)
      {
        if (i >= paramMessageRecord.linesCnt) {
          break label152;
        }
        paramLinearLayout = paramMessageRecord.lines[i];
        paramagen.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(paramLinearLayout);
        paramagen.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        label152:
        paramagen.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText("");
        paramagen.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      }
    }
    paramLinearLayout = paramagen.c;
    if (paramMessageRecord.linesCnt > 3) {}
    for (i = 0;; i = 8)
    {
      paramLinearLayout.setVisibility(i);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessageRecord = paramagen.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
      i = j;
      if (bool) {
        i = 0;
      }
      paramMessageRecord.setVisibility(i);
      paramagen.jdField_b_of_type_AndroidViewView.setTag(paramagen);
      if (jdField_e_of_type_Boolean)
      {
        paramagen.jdField_b_of_type_JavaLangStringBuilder.append(paramagen.jdField_b_of_type_AndroidWidgetTextView).append(paramagen.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].getText()).append(paramagen.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1].getText()).append(paramagen.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].getText());
        paramView.setContentDescription(paramagen.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramagen.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      bejj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5D", 0);
      return paramView;
    }
  }
  
  public bhum[] a(View paramView)
  {
    return new bhum[0];
  }
  
  public void onClick(View paramView)
  {
    ahus localahus = (ahus)paramView.getTag();
    if (localahus == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new bags();
      ((bags)localObject).a = true;
      localObject = bafb.a(localahus.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid(), "android-8.4.5", null, (bags)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (QQBrowserActivity.a(500L)))
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
        localIntent.putExtra("reqType", 1);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TofuBaseProfileItemBuilder", 2, "jump profile detail:" + localahus.jdField_a_of_type_JavaLangString);
      }
      bejj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5E", 0);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getMeasuredWidth();
    paramInt2 = paramView.getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 != this.f) && (paramInt2 != this.g))
    {
      paramView = (ahus)paramView.getTag();
      if (paramView != null) {}
    }
    else
    {
      return;
    }
    this.f = paramInt1;
    this.g = paramInt2;
    a(paramView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahur
 * JD-Core Version:    0.7.0.1
 */