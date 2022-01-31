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
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

public class aeee
  extends aeec
{
  public aeee(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public acuj a()
  {
    return new aeef();
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramacuj = (aeef)paramacuj;
    boolean bool1 = paramChatMessage.isSend();
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.a).inflate(2131562450, paramBaseChatItemLayout, false);
      paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.c + BaseChatItemLayout.j + baxn.a(this.a, 10.0F), this.e + BaseChatItemLayout.g + BaseChatItemLayout.h));
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage);
      paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364798));
      paramacuj.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377350));
      paramacuj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376712));
      paramacuj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369774));
      paramacuj.b = ((TextView)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369776));
      paramacuj.jdField_c_of_type_AndroidViewView = paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369775);
      paramacuj.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369778));
      paramacuj.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369773));
      paramacuj.jdField_d_of_type_AndroidViewView = paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369777);
      paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnLongClickListener(paramacxj);
      paramChatMessage.setOnTouchListener(paramacxj);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 201326592, 855638016 });
      paramView.setShape(0);
      paramView.setGradientType(0);
      paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
    }
    for (;;)
    {
      boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      paramView = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (!bool2)
      {
        paramView.height = this.d;
        if (!bool1) {
          break label844;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = baxn.a(this.a, 10.0F);
        label395:
        paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
        paramView = new ColorDrawable(this.h);
        paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) {}
      }
      for (;;)
      {
        try
        {
          paramacxj = URLDrawable.URLDrawableOptions.obtain();
          paramacxj.mFailedDrawable = paramView;
          paramacxj.mLoadingDrawable = paramacxj.mFailedDrawable;
          paramacxj.mRequestWidth = this.c;
          if (bool2) {
            continue;
          }
          paramacxj.mRequestHeight = this.d;
          paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramacxj);
          if (paramView.getStatus() == 2) {
            paramView.restartDownload();
          }
          paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        }
        catch (Exception paramView)
        {
          label844:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(paramView));
          continue;
          paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(14.0F);
          continue;
          paramView.leftMargin = this.g;
          paramView.rightMargin = 0;
          continue;
          paramacuj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
          paramacuj.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText("");
          continue;
        }
        if (bool2) {
          continue;
        }
        paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadiusTop(14.0F);
        if (paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool1)
        {
          paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool1;
          if (paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a == 1) {
            paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth(), paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight());
          }
          paramacuj.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
        }
        if (bool2) {
          continue;
        }
        paramacuj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!bool1) {
          continue;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.g;
        paramacuj.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
        paramacuj.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        paramacuj.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramacuj.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramacuj.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
        paramView = (RelativeLayout.LayoutParams)paramacuj.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
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
        paramacuj.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgTitle)) {
          continue;
        }
        paramacuj.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(localMessageForTroopSign.msgTitle);
        paramacuj.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        paramacuj.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        a(paramacuj, localMessageForTroopSign);
        if ((AppSetting.d) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramChatMessage.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(paramacuj, paramBaseChatItemLayout);
        return paramChatMessage;
        paramView.height = this.e;
        break;
        paramView.leftMargin = baxn.a(this.a, 10.0F);
        paramView.rightMargin = 0;
        break label395;
        paramacxj.mRequestHeight = this.e;
      }
      paramChatMessage = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeee
 * JD-Core Version:    0.7.0.1
 */