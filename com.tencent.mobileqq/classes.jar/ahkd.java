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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tofumsg.DrawCircleCornerImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahkd
  extends afor
  implements View.OnClickListener, View.OnLayoutChangeListener
{
  int a;
  int c = 0;
  int d = 0;
  int e;
  int f = 0;
  int g = 0;
  
  public ahkd(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.d = AIOUtils.dp2px(16.0F, paramContext.getResources());
    this.jdField_e_of_type_Int = AIOUtils.dp2px(108.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296405) * 2);
    paramQQAppInterface = (afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 9);
    }
  }
  
  private View a(View paramView, ahke paramahke)
  {
    Object localObject1 = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558895, null);
      paramahke.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365157);
      paramahke.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView = ((CornerImageView)paramView.findViewById(2131370784));
      paramahke.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379001));
      paramahke.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
      paramahke.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)paramView.findViewById(2131370111));
      paramahke.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)paramView.findViewById(2131370112));
      paramahke.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)paramView.findViewById(2131370113));
      paramahke.c = paramView.findViewById(2131365759);
      localObject1 = paramahke.jdField_b_of_type_AndroidWidgetTextView.getCompoundDrawables();
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
      paramahke.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView = ((DrawCircleCornerImageView)paramView.findViewById(2131363486));
      paramahke.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setRadius(this.d);
      paramahke.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setImageDrawable(new ColorDrawable(-657670));
      paramahke.jdField_b_of_type_AndroidViewView.setOnTouchListener(mvk.a);
      paramahke.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(this);
      paramahke.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setRadius(this.d);
      localObject1 = paramView;
      if (jdField_e_of_type_Boolean)
      {
        paramahke.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localObject1 = paramView;
      }
    }
    if (jdField_e_of_type_Boolean)
    {
      ((View)localObject1).setContentDescription(null);
      paramahke.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahke.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localObject1;
  }
  
  private void a(ahke paramahke, int paramInt1, int paramInt2)
  {
    paramInt1 -= AIOUtils.dp2px(30.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt2 = AIOUtils.dp2px(54.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    if (paramInt1 > 0)
    {
      paramahke.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.setCircle(paramInt1, paramInt2, this.jdField_e_of_type_Int, -920839);
      paramahke.jdField_a_of_type_ComTencentMobileqqTofumsgDrawCircleCornerImageView.invalidate();
    }
  }
  
  protected afos a()
  {
    return new ahke(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    int j = 8;
    paramMessageRecord = (MessageForTofuBaseProfile)paramMessageRecord;
    paramafos = (ahke)paramafos;
    paramView = a(paramView, paramafos);
    paramafos.jdField_a_of_type_Long = paramMessageRecord.uniseq;
    paramafos.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    paramLinearLayout = ahcg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, 6);
    paramLinearLayout = paramView.getResources().getString(2131689995, new Object[] { paramLinearLayout });
    paramafos.jdField_b_of_type_AndroidWidgetTextView.setText(paramLinearLayout);
    int i = 0;
    if (i < 3)
    {
      if (paramafos.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i] != null)
      {
        if (i >= paramMessageRecord.linesCnt) {
          break label152;
        }
        paramLinearLayout = paramMessageRecord.lines[i];
        paramafos.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText(paramLinearLayout);
        paramafos.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(0);
      }
      for (;;)
      {
        i += 1;
        break;
        label152:
        paramafos.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setText("");
        paramafos.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i].setVisibility(8);
      }
    }
    paramLinearLayout = paramafos.c;
    if (paramMessageRecord.linesCnt > 3) {}
    for (i = 0;; i = 8)
    {
      paramLinearLayout.setVisibility(i);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessageRecord = paramafos.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView;
      i = j;
      if (bool) {
        i = 0;
      }
      paramMessageRecord.setVisibility(i);
      paramafos.jdField_b_of_type_AndroidViewView.setTag(paramafos);
      if (jdField_e_of_type_Boolean)
      {
        paramafos.jdField_b_of_type_JavaLangStringBuilder.append(paramafos.jdField_b_of_type_AndroidWidgetTextView).append(paramafos.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0].getText()).append(paramafos.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1].getText()).append(paramafos.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2].getText());
        paramView.setContentDescription(paramafos.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramafos.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      bejf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5D", 0);
      return paramView;
    }
  }
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
  
  public void onClick(View paramView)
  {
    ahke localahke = (ahke)paramView.getTag();
    if (localahke == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = new babe();
      ((babe)localObject).a = true;
      localObject = azym.a(localahke.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid(), "android-8.4.10", null, (babe)localObject);
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
        QLog.d("TofuBaseProfileItemBuilder", 2, "jump profile detail:" + localahke.jdField_a_of_type_JavaLangString);
      }
      bejf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5E", 0);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt1 = paramView.getMeasuredWidth();
    paramInt2 = paramView.getMeasuredHeight();
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 != this.f) && (paramInt2 != this.g))
    {
      paramView = (ahke)paramView.getTag();
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
 * Qualified Name:     ahkd
 * JD-Core Version:    0.7.0.1
 */