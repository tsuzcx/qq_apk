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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tofumsg.DrawCircleCornerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agrf
  extends aexf
  implements View.OnClickListener, View.OnLayoutChangeListener
{
  int a;
  int c = 0;
  int d = 0;
  int e;
  int f = 0;
  int g = 0;
  
  public agrf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.d = AIOUtils.dp2px(16.0F, paramContext.getResources());
    this.jdField_e_of_type_Int = AIOUtils.dp2px(108.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296405) * 2);
    paramQQAppInterface = (aezm)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 9);
    }
  }
  
  private View a(View paramView, agrg paramagrg)
  {
    Object localObject1 = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558868, null);
      paramagrg.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365073);
      paramagrg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131370601));
      paramagrg.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378707));
      paramagrg.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
      paramagrg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131369941));
      paramagrg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131369942));
      paramagrg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131369943));
      paramagrg.c = paramView.findViewById(2131365665);
      localObject1 = paramagrg.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
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
      paramagrg.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView = ((DrawCircleCornerImageView)paramView.findViewById(2131363417));
      paramagrg.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setRadius(this.d);
      paramagrg.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setImageDrawable(new ColorDrawable(-657670));
      paramagrg.jdField_b_of_type_AndroidViewView.setOnTouchListener(mum.a);
      paramagrg.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(this);
      paramagrg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.d);
      localObject1 = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramagrg.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localObject1 = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      ((View)localObject1).setContentDescription(null);
      paramagrg.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramagrg.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localObject1;
  }
  
  private void a(agrg paramagrg, int paramInt1, int paramInt2)
  {
    paramInt1 -= AIOUtils.dp2px(30.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt2 = AIOUtils.dp2px(54.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramInt1 > 0)
    {
      paramagrg.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setCircle(paramInt1, paramInt2, this.jdField_e_of_type_Int, -920839);
      paramagrg.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.invalidate();
    }
  }
  
  protected aexg a()
  {
    return new agrg(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    int j = 8;
    paramMessageRecord = (MessageForTofuBaseProfile)paramMessageRecord;
    paramaexg = (agrg)paramaexg;
    paramView = a(paramView, paramaexg);
    paramaexg.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramaexg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    paramLinearLayout = agjq.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, 6);
    paramLinearLayout = paramView.getResources().getString(2131689966, new Object[] { paramLinearLayout });
    paramaexg.jdField_b_of_type_AndroidWidgetTextView.setText(paramLinearLayout);
    int i = 0;
    if (i < 3)
    {
      if (paramaexg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i] != null)
      {
        if (i >= paramMessageRecord.linesCnt) {
          break label152;
        }
        paramLinearLayout = paramMessageRecord.lines[i];
        paramaexg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(paramLinearLayout);
        paramaexg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        label152:
        paramaexg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText("");
        paramaexg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      }
    }
    paramLinearLayout = paramaexg.c;
    if (paramMessageRecord.linesCnt > 3) {}
    for (i = 0;; i = 8)
    {
      paramLinearLayout.setVisibility(i);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessageRecord = paramaexg.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
      i = j;
      if (bool) {
        i = 0;
      }
      paramMessageRecord.setVisibility(i);
      paramaexg.jdField_b_of_type_AndroidViewView.setTag(paramaexg);
      if (jdField_e_of_type_Boolean)
      {
        paramaexg.jdField_b_of_type_JavaLangStringBuilder.append(paramaexg.jdField_b_of_type_AndroidWidgetTextView).append(paramaexg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].getText()).append(paramaexg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1].getText()).append(paramaexg.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].getText());
        paramView.setContentDescription(paramaexg.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramaexg.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      bdcf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5D", 0);
      return paramView;
    }
  }
  
  public bgbb[] a(View paramView)
  {
    return new bgbb[0];
  }
  
  public void onClick(View paramView)
  {
    agrg localagrg = (agrg)paramView.getTag();
    if (localagrg == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new aywj();
      ((aywj)localObject).a = true;
      localObject = aytq.a(localagrg.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid(), "android-8.4.8", null, (aywj)localObject);
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
        QLog.d("TofuBaseProfileItemBuilder", 2, "jump profile detail:" + localagrg.jdField_a_of_type_JavaLangString);
      }
      bdcf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5E", 0);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getMeasuredWidth();
    paramInt2 = paramView.getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 != this.f) && (paramInt2 != this.g))
    {
      paramView = (agrg)paramView.getTag();
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
 * Qualified Name:     agrf
 * JD-Core Version:    0.7.0.1
 */