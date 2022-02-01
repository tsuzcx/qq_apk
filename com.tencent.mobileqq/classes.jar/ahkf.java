import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

public class ahkf
  extends afor
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  int[] jdField_a_of_type_ArrayOfInt;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int c = 0;
  int d = 0;
  
  public ahkf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.d = AIOUtils.dp2px(16.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296405) * 2);
    this.c = ((int)(0.4531835F * this.jdField_a_of_type_Int));
    paramQQAppInterface = (afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 8);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramContext.getResources().getStringArray(2130968581);
    this.jdField_a_of_type_ArrayOfInt = paramContext.getResources().getIntArray(2130968580);
  }
  
  private View a(View paramView, ahkg paramahkg)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558896, null);
      paramahkg.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365157);
      paramahkg.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370784);
      paramahkg.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370111));
      paramahkg.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370112));
      paramahkg.d = ((TextView)paramView.findViewById(2131370113));
      paramahkg.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368084));
      paramahkg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368100));
      localObject = (ViewGroup.MarginLayoutParams)paramahkg.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).height = this.c;
      paramahkg.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramahkg.jdField_b_of_type_AndroidViewView.setOnTouchListener(mvk.a);
      localObject = paramView;
      if (e)
      {
        paramahkg.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localObject = paramView;
      }
    }
    if (e)
    {
      ((View)localObject).setContentDescription(null);
      paramahkg.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahkg.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localObject;
  }
  
  @Nullable
  private BaseChatPie a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localChatFragment == null) {
        return null;
      }
      return localChatFragment.a();
    }
    return null;
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    }
    for (;;)
    {
      if (paramDrawable != null) {
        paramDrawable.invalidateSelf();
      }
      return;
      if ((paramDrawable instanceof GradientDrawable)) {
        ((GradientDrawable)paramDrawable).setColor(paramInt);
      }
    }
  }
  
  protected afos a()
  {
    return new ahkg(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    int j = 0;
    paramLinearLayout = (MessageForTofuIntimateAnniversary)paramMessageRecord;
    paramafos = (ahkg)paramafos;
    paramView = a(paramView, paramafos);
    paramafos.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramafos.jdField_a_of_type_JavaLangString = Long.toString(paramLinearLayout.frdUin);
    paramafos.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary = paramLinearLayout;
    paramMessageRecord = URLDrawable.URLDrawableOptions.obtain();
    paramMessageRecord.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mFailedDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mRequestHeight = this.c;
    paramMessageRecord.mRequestWidth = this.jdField_a_of_type_Int;
    paramMessageRecord = URLDrawable.getDrawable(paramLinearLayout.bgUrl, paramMessageRecord);
    paramafos.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
    paramafos.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramafos.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramafos.d.setTextColor(paramLinearLayout.txtColor);
    a(paramafos.d.getBackground(), Color.argb(25, Color.red(paramLinearLayout.txtColor), Color.green(paramLinearLayout.txtColor), Color.blue(paramLinearLayout.txtColor)));
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > paramLinearLayout.inimateType) && (paramLinearLayout.inimateType >= 0))
    {
      paramMessageRecord = this.jdField_a_of_type_ArrayOfJavaLangString[paramLinearLayout.inimateType];
      paramafos.jdField_c_of_type_AndroidWidgetTextView.setText(paramView.getContext().getString(2131689997, new Object[] { paramMessageRecord, Integer.valueOf(paramLinearLayout.years) }));
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(1000L * paramLinearLayout.bindTime);
      paramafos.d.setText(paramView.getContext().getString(2131689998, new Object[] { paramMessageRecord }));
      paramMessageRecord = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLinearLayout.frdUin));
      paramafos.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
      paramMessageRecord = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramafos.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessageRecord = paramafos.jdField_c_of_type_AndroidViewView;
      if (!bool) {
        break label510;
      }
    }
    label510:
    for (int i = 0;; i = 8)
    {
      paramMessageRecord.setVisibility(i);
      paramafos.jdField_b_of_type_AndroidViewView.setTag(paramafos);
      if (e)
      {
        paramafos.jdField_b_of_type_JavaLangStringBuilder.append(paramafos.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramafos.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramafos.d.getText());
        paramView.setContentDescription(paramafos.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramafos.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      i = j;
      if (this.jdField_a_of_type_ArrayOfInt != null)
      {
        i = j;
        if (this.jdField_a_of_type_ArrayOfInt.length > paramLinearLayout.inimateType)
        {
          i = j;
          if (paramLinearLayout.inimateType >= 0) {
            i = this.jdField_a_of_type_ArrayOfInt[paramLinearLayout.inimateType];
          }
        }
      }
      bejf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE61", i);
      return paramView;
      paramMessageRecord = "";
      break;
    }
  }
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
  
  public void onClick(View paramView)
  {
    ahkg localahkg = (ahkg)paramView.getTag();
    if (localahkg == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    BaseChatPie localBaseChatPie = a();
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof agab)) && (localBaseChatPie.mChatDrawer != null)) {
      localBaseChatPie.mChatDrawer.b(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "jumpIntimatePage:" + localahkg.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > localahkg.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType) && (localahkg.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType >= 0)) {}
    for (int i = this.jdField_a_of_type_ArrayOfInt[localahkg.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType];; i = 0)
    {
      bejf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE62", i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkf
 * JD-Core Version:    0.7.0.1
 */