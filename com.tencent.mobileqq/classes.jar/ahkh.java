import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForTofuNicePics;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.jetbrains.annotations.NotNull;

public class ahkh
  extends afor
  implements View.OnClickListener
{
  int a;
  int c = 0;
  
  public ahkh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = AIOUtils.dp2px(251.0F, paramContext.getResources());
    this.c = AIOUtils.dp2px(131.0F, paramContext.getResources());
    paramQQAppInterface = (afqy)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 10);
    }
  }
  
  @NotNull
  private Drawable a(boolean paramBoolean, String paramString)
  {
    Drawable localDrawable = URLDrawableHelper.TRANSLUCENT;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSLUCENT;
    localURLDrawableOptions.mRequestHeight = this.c;
    if (paramBoolean) {}
    for (int i = this.jdField_a_of_type_Int;; i = (int)(0.5F * this.jdField_a_of_type_Int))
    {
      localURLDrawableOptions.mRequestWidth = i;
      try
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.d("TofuNicePicsItemBuilder", 1, "getDrawable ex=" + paramString.getMessage(), paramString);
      }
    }
    return localDrawable;
  }
  
  private View a(View paramView, ahki paramahki)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558897, null);
      paramahki.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131365157);
      paramahki.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370784);
      paramahki.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363521));
      paramahki.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370032));
      paramahki.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376715));
      paramahki.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370111));
      paramahki.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370112));
      paramahki.d = ((TextView)paramView.findViewById(2131378963));
      paramahki.jdField_b_of_type_AndroidViewView.setOnTouchListener(mvk.a);
      localView = paramView;
      if (e)
      {
        paramahki.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramahki.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahki.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  private void a(ImageView paramImageView, Drawable paramDrawable)
  {
    if (paramDrawable != null) {}
    for (int i = 0;; i = 8)
    {
      paramImageView.setVisibility(i);
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  protected afos a()
  {
    return new ahki(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    int i = 8;
    paramLinearLayout = (MessageForTofuNicePics)paramMessageRecord;
    paramMessageRecord = (ahki)paramafos;
    paramafos = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = Long.toString(paramLinearLayout.frdUin);
    paramMessageRecord.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuNicePics = paramLinearLayout;
    if ((!TextUtils.isEmpty(paramLinearLayout.url1)) && (!TextUtils.isEmpty(paramLinearLayout.url2)))
    {
      paramView = a(false, paramLinearLayout.url1);
      paramaftk = a(false, paramLinearLayout.url2);
      a(paramMessageRecord.jdField_b_of_type_AndroidWidgetImageView, paramView);
      a(paramMessageRecord.jdField_c_of_type_AndroidWidgetImageView, paramaftk);
      a(paramMessageRecord.jdField_a_of_type_AndroidWidgetImageView, null);
      paramView = ahcg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendNick, 6);
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689999, new Object[] { paramView, Integer.valueOf(paramLinearLayout.countInc) });
      paramMessageRecord.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
      if (paramLinearLayout.countInc <= 1) {
        break label397;
      }
      paramMessageRecord.d.setText("共" + paramLinearLayout.countInc + "张");
      paramMessageRecord.d.setVisibility(0);
    }
    for (;;)
    {
      paramView = bhid.a(this.jdField_a_of_type_AndroidContentContext, 7, paramLinearLayout.upTime * 1000L);
      paramMessageRecord.jdField_c_of_type_AndroidWidgetTextView.setText(paramView);
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramView = paramMessageRecord.jdField_c_of_type_AndroidViewView;
      if (bool) {
        i = 0;
      }
      paramView.setVisibility(i);
      paramMessageRecord.jdField_b_of_type_AndroidViewView.setTag(paramMessageRecord);
      if (e)
      {
        paramMessageRecord.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageRecord.jdField_b_of_type_AndroidWidgetTextView.getText()).append(paramMessageRecord.jdField_c_of_type_AndroidWidgetTextView.getText());
        paramafos.setContentDescription(paramMessageRecord.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramMessageRecord.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      bejf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5F", 0);
      return paramafos;
      paramView = a(true, paramLinearLayout.url1);
      a(paramMessageRecord.jdField_b_of_type_AndroidWidgetImageView, null);
      a(paramMessageRecord.jdField_c_of_type_AndroidWidgetImageView, null);
      a(paramMessageRecord.jdField_a_of_type_AndroidWidgetImageView, paramView);
      break;
      label397:
      paramMessageRecord.d.setVisibility(8);
    }
  }
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
  
  public void onClick(View paramView)
  {
    ahki localahki = (ahki)paramView.getTag();
    if (localahki == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PhotoWallView.a((Activity)paramView.getContext(), localahki.jdField_a_of_type_JavaLangString, false);
      if (QLog.isColorLevel()) {
        QLog.d("TofuNicePicsItemBuilder", 2, "jump photowall:" + localahki.jdField_a_of_type_JavaLangString);
      }
      bejf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE60", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkh
 * JD-Core Version:    0.7.0.1
 */