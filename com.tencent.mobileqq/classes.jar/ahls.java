import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class ahls
  extends ahlq
{
  public ahls(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public afqr a()
  {
    return new ahlt();
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    paramafqr = (ahlt)paramafqr;
    boolean bool1 = paramChatMessage.isSend();
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.a).inflate(2131562895, paramBaseChatItemLayout, false);
      paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.c + BaseChatItemLayout.k + DisplayUtil.dip2px(this.a, 10.0F), this.e + BaseChatItemLayout.h + BaseChatItemLayout.i));
      paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage);
      paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365278));
      paramafqr.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379001));
      paramafqr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378299));
      paramafqr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370753));
      paramafqr.b = ((TextView)paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370755));
      paramafqr.jdField_c_of_type_AndroidViewView = paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370754);
      paramafqr.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370757));
      paramafqr.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370752));
      paramafqr.jdField_d_of_type_AndroidViewView = paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370756);
      paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnLongClickListener(paramaftk);
      paramChatMessage.setOnTouchListener(paramaftk);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 201326592, 855638016 });
      paramView.setShape(0);
      paramView.setGradientType(0);
      paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
    }
    for (;;)
    {
      boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      paramView = (RelativeLayout.LayoutParams)paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (!bool2)
      {
        paramView.height = this.d;
        if (!bool1) {
          break label844;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = DisplayUtil.dip2px(this.a, 10.0F);
        label395:
        paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
        paramView = new ColorDrawable(this.h);
        paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) {}
      }
      for (;;)
      {
        try
        {
          paramaftk = URLDrawable.URLDrawableOptions.obtain();
          paramaftk.mFailedDrawable = paramView;
          paramaftk.mLoadingDrawable = paramaftk.mFailedDrawable;
          paramaftk.mRequestWidth = this.c;
          if (bool2) {
            continue;
          }
          paramaftk.mRequestHeight = this.d;
          paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramaftk);
          if (paramView.getStatus() == 2) {
            paramView.restartDownload();
          }
          paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        }
        catch (Exception paramView)
        {
          label844:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(paramView));
          continue;
          paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(14.0F);
          continue;
          paramView.leftMargin = this.g;
          paramView.rightMargin = 0;
          continue;
          paramafqr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          continue;
          paramView.leftMargin = this.g;
          paramView.rightMargin = 0;
          continue;
          if ((TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) || (!localMessageForTroopSign.msgCoverUrl.endsWith("e8e22512720843268d733a5f30f22d7f.png"))) {
            continue;
          }
          paramView.addRule(12, 0);
          paramView.addRule(15, -1);
          continue;
          paramView.addRule(12, -1);
          paramView.addRule(15, 0);
          continue;
          paramafqr.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText("");
          continue;
        }
        if (bool2) {
          continue;
        }
        paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadiusTop(14.0F);
        if (paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool1)
        {
          paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool1;
          if (paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a == 1) {
            paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth(), paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight());
          }
          paramafqr.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
        }
        if (bool2) {
          continue;
        }
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = (RelativeLayout.LayoutParams)paramafqr.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!bool1) {
          continue;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.g;
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
        paramView = (RelativeLayout.LayoutParams)paramafqr.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
        if (!bool1) {
          continue;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.g;
        if (bool2) {
          continue;
        }
        paramView.addRule(12, 0);
        paramView.addRule(15, 0);
        paramafqr.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgTitle)) {
          continue;
        }
        paramafqr.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(localMessageForTroopSign.msgTitle);
        paramafqr.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        paramafqr.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        a(paramafqr, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramChatMessage.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(paramafqr, paramBaseChatItemLayout);
        return paramChatMessage;
        paramView.height = this.e;
        break;
        paramView.leftMargin = DisplayUtil.dip2px(this.a, 10.0F);
        paramView.rightMargin = 0;
        break label395;
        paramaftk.mRequestHeight = this.e;
      }
      paramChatMessage = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahls
 * JD-Core Version:    0.7.0.1
 */