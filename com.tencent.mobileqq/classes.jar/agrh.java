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
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;

public class agrh
  extends aexf
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  int[] jdField_a_of_type_ArrayOfInt;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  int c = 0;
  int d = 0;
  
  public agrh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.d = AIOUtils.dp2px(16.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = (paramContext.getResources().getDisplayMetrics().widthPixels - paramContext.getResources().getDimensionPixelSize(2131296405) * 2);
    this.c = ((int)(0.4531835F * this.jdField_a_of_type_Int));
    paramQQAppInterface = (aezm)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 8);
    }
    this.jdField_a_of_type_ArrayOfJavaLangString = paramContext.getResources().getStringArray(2130968581);
    this.jdField_a_of_type_ArrayOfInt = paramContext.getResources().getIntArray(2130968580);
  }
  
  private View a(View paramView, agri paramagri)
  {
    Object localObject = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558869, null);
      paramagri.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365073);
      paramagri.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370601);
      paramagri.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369941));
      paramagri.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369942));
      paramagri.d = ((TextView)paramView.findViewById(2131369943));
      paramagri.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367948));
      paramagri.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367964));
      localObject = (ViewGroup.MarginLayoutParams)paramagri.jdField_b_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).height = this.c;
      paramagri.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramagri.jdField_b_of_type_AndroidViewView.setOnTouchListener(mum.a);
      localObject = paramView;
      if (e)
      {
        paramagri.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localObject = paramView;
      }
    }
    if (e)
    {
      ((View)localObject).setContentDescription(null);
      paramagri.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramagri.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected aexg a()
  {
    return new agri(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aexg paramaexg, View paramView, LinearLayout paramLinearLayout, afce paramafce)
  {
    int j = 0;
    paramLinearLayout = (MessageForTofuIntimateAnniversary)paramMessageRecord;
    paramaexg = (agri)paramaexg;
    paramView = a(paramView, paramaexg);
    paramaexg.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramaexg.jdField_a_of_type_JavaLangString = Long.toString(paramLinearLayout.frdUin);
    paramaexg.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary = paramLinearLayout;
    paramMessageRecord = URLDrawable.URLDrawableOptions.obtain();
    paramMessageRecord.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mFailedDrawable = URLDrawableHelper.TRANSLUCENT;
    paramMessageRecord.mRequestHeight = this.c;
    paramMessageRecord.mRequestWidth = this.jdField_a_of_type_Int;
    paramMessageRecord = URLDrawable.getDrawable(paramLinearLayout.bgUrl, paramMessageRecord);
    paramaexg.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramMessageRecord);
    paramaexg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramaexg.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramLinearLayout.txtColor);
    paramaexg.d.setTextColor(paramLinearLayout.txtColor);
    a(paramaexg.d.getBackground(), Color.argb(25, Color.red(paramLinearLayout.txtColor), Color.green(paramLinearLayout.txtColor), Color.blue(paramLinearLayout.txtColor)));
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (this.jdField_a_of_type_ArrayOfJavaLangString.length > paramLinearLayout.inimateType) && (paramLinearLayout.inimateType >= 0))
    {
      paramMessageRecord = this.jdField_a_of_type_ArrayOfJavaLangString[paramLinearLayout.inimateType];
      paramaexg.jdField_c_of_type_AndroidWidgetTextView.setText(paramView.getContext().getString(2131689968, new Object[] { paramMessageRecord, Integer.valueOf(paramLinearLayout.years) }));
      paramMessageRecord = Calendar.getInstance();
      paramMessageRecord.setTimeInMillis(1000L * paramLinearLayout.bindTime);
      paramaexg.d.setText(paramView.getContext().getString(2131689969, new Object[] { paramMessageRecord }));
      paramMessageRecord = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, String.valueOf(paramLinearLayout.frdUin));
      paramaexg.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
      paramMessageRecord = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramaexg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMessageRecord);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramMessageRecord = paramaexg.jdField_c_of_type_AndroidViewView;
      if (!bool) {
        break label510;
      }
    }
    label510:
    for (int i = 0;; i = 8)
    {
      paramMessageRecord.setVisibility(i);
      paramaexg.jdField_b_of_type_AndroidViewView.setTag(paramaexg);
      if (e)
      {
        paramaexg.jdField_b_of_type_JavaLangStringBuilder.append(paramaexg.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramaexg.jdField_c_of_type_AndroidWidgetTextView.getText()).append(paramaexg.d.getText());
        paramView.setContentDescription(paramaexg.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramaexg.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
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
      bdcf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE61", i);
      return paramView;
      paramMessageRecord = "";
      break;
    }
  }
  
  public bgbb[] a(View paramView)
  {
    return new bgbb[0];
  }
  
  public void onClick(View paramView)
  {
    agri localagri = (agri)paramView.getTag();
    if (localagri == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    BaseChatPie localBaseChatPie = a();
    if ((localBaseChatPie != null) && ((localBaseChatPie instanceof afiw)) && (localBaseChatPie.mChatDrawer != null)) {
      localBaseChatPie.mChatDrawer.b(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, "jumpIntimatePage:" + localagri.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ArrayOfInt != null) && (this.jdField_a_of_type_ArrayOfInt.length > localagri.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType) && (localagri.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType >= 0)) {}
    for (int i = this.jdField_a_of_type_ArrayOfInt[localagri.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuIntimateAnniversary.inimateType];; i = 0)
    {
      bdcf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE62", i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrh
 * JD-Core Version:    0.7.0.1
 */