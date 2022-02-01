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
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTofuNicePics;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.PhotoWallView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.jetbrains.annotations.NotNull;

public class ahll
  extends afuu
  implements View.OnClickListener
{
  int a;
  int c = 0;
  
  public ahll(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = afur.a(251.0F, paramContext.getResources());
    this.c = afur.a(131.0F, paramContext.getResources());
    paramQQAppInterface = (afwx)paramQQAppInterface.getManager(282);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(3, 10);
    }
  }
  
  @NotNull
  private Drawable a(boolean paramBoolean, String paramString)
  {
    Drawable localDrawable = bdzx.b;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = bdzx.b;
    localURLDrawableOptions.mFailedDrawable = bdzx.b;
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
  
  private View a(View paramView, ahlm paramahlm)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558864, null);
      paramahlm.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364999);
      paramahlm.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370529);
      paramahlm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363400));
      paramahlm.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369772));
      paramahlm.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376561));
      paramahlm.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369849));
      paramahlm.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369850));
      paramahlm.d = ((TextView)paramView.findViewById(2131378737));
      paramahlm.jdField_b_of_type_AndroidViewView.setOnTouchListener(mue.a);
      localView = paramView;
      if (e)
      {
        paramahlm.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramahlm.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramahlm.jdField_b_of_type_JavaLangStringBuilder.length(), "");
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
  
  protected afuv a()
  {
    return new ahlm(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    int i = 8;
    paramLinearLayout = (MessageForTofuNicePics)paramMessageRecord;
    paramMessageRecord = (ahlm)paramafuv;
    paramafuv = a(paramView, paramMessageRecord);
    paramMessageRecord.jdField_a_of_type_Long = paramLinearLayout.uniseq;
    paramMessageRecord.jdField_a_of_type_JavaLangString = Long.toString(paramLinearLayout.frdUin);
    paramMessageRecord.jdField_a_of_type_ComTencentMobileqqDataMessageForTofuNicePics = paramLinearLayout;
    if ((!TextUtils.isEmpty(paramLinearLayout.url1)) && (!TextUtils.isEmpty(paramLinearLayout.url2)))
    {
      paramView = a(false, paramLinearLayout.url1);
      paramafzq = a(false, paramLinearLayout.url2);
      a(paramMessageRecord.jdField_b_of_type_AndroidWidgetImageView, paramView);
      a(paramMessageRecord.jdField_c_of_type_AndroidWidgetImageView, paramafzq);
      a(paramMessageRecord.jdField_a_of_type_AndroidWidgetImageView, null);
      paramView = ahdr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d, 6);
      paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131689949, new Object[] { paramView, Integer.valueOf(paramLinearLayout.countInc) });
      paramMessageRecord.jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
      if (paramLinearLayout.countInc <= 1) {
        break label396;
      }
      paramMessageRecord.d.setText("共" + paramLinearLayout.countInc + "张");
      paramMessageRecord.d.setVisibility(0);
    }
    for (;;)
    {
      paramView = bgsu.a(this.jdField_a_of_type_AndroidContentContext, 7, paramLinearLayout.upTime * 1000L);
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
        paramafuv.setContentDescription(paramMessageRecord.jdField_b_of_type_JavaLangStringBuilder.toString());
      }
      paramMessageRecord.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      bdqn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE5F", 0);
      return paramafuv;
      paramView = a(true, paramLinearLayout.url1);
      a(paramMessageRecord.jdField_b_of_type_AndroidWidgetImageView, null);
      a(paramMessageRecord.jdField_c_of_type_AndroidWidgetImageView, null);
      a(paramMessageRecord.jdField_a_of_type_AndroidWidgetImageView, paramView);
      break;
      label396:
      paramMessageRecord.d.setVisibility(8);
    }
  }
  
  public bguj[] a(View paramView)
  {
    return new bguj[0];
  }
  
  public void onClick(View paramView)
  {
    ahlm localahlm = (ahlm)paramView.getTag();
    if (localahlm == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      PhotoWallView.a((Activity)paramView.getContext(), localahlm.jdField_a_of_type_JavaLangString, false);
      if (QLog.isColorLevel()) {
        QLog.d("TofuNicePicsItemBuilder", 2, "jump photowall:" + localahlm.jdField_a_of_type_JavaLangString);
      }
      bdqn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800AE60", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahll
 * JD-Core Version:    0.7.0.1
 */