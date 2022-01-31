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

public class aeeg
  extends aeee
{
  public aeeg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public acun a()
  {
    return new aeeh();
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    paramacun = (aeeh)paramacun;
    boolean bool1 = paramChatMessage.isSend();
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.a).inflate(2131562451, paramBaseChatItemLayout, false);
      paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.c + BaseChatItemLayout.j + bawz.a(this.a, 10.0F), this.e + BaseChatItemLayout.g + BaseChatItemLayout.h));
      paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage);
      paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131364799));
      paramacun.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131377350));
      paramacun.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131376710));
      paramacun.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369775));
      paramacun.b = ((TextView)paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369777));
      paramacun.jdField_c_of_type_AndroidViewView = paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369776);
      paramacun.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369779));
      paramacun.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369774));
      paramacun.jdField_d_of_type_AndroidViewView = paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369778);
      paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnLongClickListener(paramacxn);
      paramChatMessage.setOnTouchListener(paramacxn);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 201326592, 855638016 });
      paramView.setShape(0);
      paramView.setGradientType(0);
      paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
    }
    for (;;)
    {
      boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      paramView = (RelativeLayout.LayoutParams)paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (!bool2)
      {
        paramView.height = this.d;
        if (!bool1) {
          break label844;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = bawz.a(this.a, 10.0F);
        label395:
        paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
        paramView = new ColorDrawable(this.h);
        paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) {}
      }
      for (;;)
      {
        try
        {
          paramacxn = URLDrawable.URLDrawableOptions.obtain();
          paramacxn.mFailedDrawable = paramView;
          paramacxn.mLoadingDrawable = paramacxn.mFailedDrawable;
          paramacxn.mRequestWidth = this.c;
          if (bool2) {
            continue;
          }
          paramacxn.mRequestHeight = this.d;
          paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramacxn);
          if (paramView.getStatus() == 2) {
            paramView.restartDownload();
          }
          paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        }
        catch (Exception paramView)
        {
          label844:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(paramView));
          continue;
          paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(14.0F);
          continue;
          paramView.leftMargin = this.g;
          paramView.rightMargin = 0;
          continue;
          paramacun.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
          paramacun.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText("");
          continue;
        }
        if (bool2) {
          continue;
        }
        paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadiusTop(14.0F);
        if (paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool1)
        {
          paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool1;
          if (paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a == 1) {
            paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth(), paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight());
          }
          paramacun.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
        }
        if (bool2) {
          continue;
        }
        paramacun.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = (RelativeLayout.LayoutParams)paramacun.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!bool1) {
          continue;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.g;
        paramacun.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
        paramacun.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        paramacun.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramacun.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramacun.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
        paramView = (RelativeLayout.LayoutParams)paramacun.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
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
        paramacun.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgTitle)) {
          continue;
        }
        paramacun.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(localMessageForTroopSign.msgTitle);
        paramacun.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        paramacun.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        a(paramacun, localMessageForTroopSign);
        if ((AppSetting.d) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramChatMessage.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(paramacun, paramBaseChatItemLayout);
        return paramChatMessage;
        paramView.height = this.e;
        break;
        paramView.leftMargin = bawz.a(this.a, 10.0F);
        paramView.rightMargin = 0;
        break label395;
        paramacxn.mRequestHeight = this.e;
      }
      paramChatMessage = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeeg
 * JD-Core Version:    0.7.0.1
 */