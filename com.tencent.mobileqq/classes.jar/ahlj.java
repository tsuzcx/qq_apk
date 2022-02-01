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
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

public class ahlj
  extends afuu
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  int[] jdField_a_of_type_ArrayOfInt;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int c = 0;
  int d = 0;
  
  public ahlj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.d = afur.a(16.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296348) * 2);
    this.c = ((int)(0.4531835F * this.jdField_a_of_type_Int));
    paramQQAppInterface = (afwx)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 8);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramContext.getResources().getStringArray(2130968581);
    this.jdField_a_of_type_ArrayOfInt = paramContext.getResources().getIntArray(2130968580);
  }
  
  private View a(View paramView, ahlk paramahlk)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558863, null);
      paramahlk.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364999);
      paramahlk.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370529);
      paramahlk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369849));
      paramahlk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369850));
      paramahlk.d = ((TextView)paramView.findViewById(2131369851));
      paramahlk.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367847));
      paramahlk.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367863));
      localObject = (ViewGroup.MarginLayoutParams)paramahlk.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).height = this.c;
      paramahlk.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramahlk.jdField_b_of_type_AndroidViewView.setOnTouchListener(mue.a);
      localObject = paramView;
      if (e)
      {
        paramahlk.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localObject = paramView;
      }
    }
    if (e)
    {
      ((View)localObject).setContentDescription(null);
      paramahlk.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahlk.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected afuv a()
  {
    return new ahlk(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    int j = 0;
    paramLinearLayout = (MessageForTofuIntimateAnniversary)paramMessageRecord;
    paramafuv = (ahlk)paramafuv;
    paramView = a(paramView, paramafuv);
    paramafuv.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramafuv.jdField_a_of_type_JavaLangString = Long.toString(paramLinearLayout.frdUin);
    paramafuv.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary = paramLinearLayout;
    paramMessageRecord = URLDrawable.URLDrawableOptions.obtain();
    paramMessageRecord.mLoadingDrawable = bdzx.b;
    paramMessageRecord.mFailedDrawable = bdzx.b;
    paramMessageRecord.mRequestHeight = this.c;
    paramMessageRecord.mRequestWidth = this.jdField_a_of_type_Int;
    paramMessageRecord = URLDrawable.getDrawable(paramLinearLayout.bgUrl, paramMessageRecord);
    paramafuv.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
    paramafuv.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramafuv.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramafuv.d.setTextColor(paramLinearLayout.txtColor);
    a(paramafuv.d.getBackground(), Color.argb(25, Color.red(paramLinearLayout.txtColor), Color.green(paramLinearLayout.txtColor), Color.blue(paramLinearLayout.txtColor)));
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > paramLinearLayout.inimateType) && (paramLinearLayout.inimateType >= 0))
    {
      paramMessageRecord = this.jdField_a_of_type_ArrayOfJavaLangString[paramLinearLayout.inimateType];
      paramafuv.jdField_c_of_type_AndroidWidgetTextView.setText(paramView.getContext().getString(2131689947, new Object[] { paramMessageRecord, Integer.valueOf(paramLinearLayout.years) }));
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(1000L * paramLinearLayout.bindTime);
      paramafuv.d.setText(paramView.getContext().getString(2131689948, new Object[] { paramMessageRecord }));
      paramMessageRecord = aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLinearLayout.frdUin));
      paramafuv.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
      paramMessageRecord = aoch.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramafuv.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessageRecord = paramafuv.jdField_c_of_type_AndroidViewView;
      if (!bool) {
        break label510;
      }
    }
    label510:
    for (int i = 0;; i = 8)
    {
      paramMessageRecord.setVisibility(i);
      paramafuv.jdField_b_of_type_AndroidViewView.setTag(paramafuv);
      if (e)
      {
        paramafuv.jdField_b_of_type_JavaLangStringBuilder.append(paramafuv.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramafuv.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramafuv.d.getText());
        paramView.setContentDescription(paramafuv.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramafuv.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
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
      bdqn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE61", i);
      return paramView;
      paramMessageRecord = "";
      break;
    }
  }
  
  public bguj[] a(View paramView)
  {
    return new bguj[0];
  }
  
  public void onClick(View paramView)
  {
    ahlk localahlk = (ahlk)paramView.getTag();
    if (localahlk == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    BaseChatPie localBaseChatPie = a();
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof ahzy)) && (localBaseChatPie.a != null)) {
      localBaseChatPie.a.b(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "jumpIntimatePage:" + localahlk.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > localahlk.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType) && (localahlk.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType >= 0)) {}
    for (int i = this.jdField_a_of_type_ArrayOfInt[localahlk.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType];; i = 0)
    {
      bdqn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE62", i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlj
 * JD-Core Version:    0.7.0.1
 */