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

public class adth
  extends adtf
{
  public adth(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public acju a()
  {
    return new adti();
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    paramacju = (adti)paramacju;
    boolean bool1 = paramChatMessage.isSend();
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.a).inflate(2131496851, paramBaseChatItemLayout, false);
      paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.c + BaseChatItemLayout.j + azvv.a(this.a, 10.0F), this.e + BaseChatItemLayout.g + BaseChatItemLayout.h));
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131299236));
      paramacju.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311534));
      paramacju.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131310903));
      paramacju.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304102));
      paramacju.b = ((TextView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304104));
      paramacju.jdField_c_of_type_AndroidViewView = paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304103);
      paramacju.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304106));
      paramacju.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304101));
      paramacju.jdField_d_of_type_AndroidViewView = paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304105);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnLongClickListener(paramacmv);
      paramChatMessage.setOnTouchListener(paramacmv);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 201326592, 855638016 });
      paramView.setShape(0);
      paramView.setGradientType(0);
      paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
    }
    for (;;)
    {
      boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      paramView = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (!bool2)
      {
        paramView.height = this.d;
        if (!bool1) {
          break label843;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = azvv.a(this.a, 10.0F);
        label395:
        paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
        paramView = new ColorDrawable(this.h);
        paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        if (!TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl))
        {
          paramacmv = URLDrawable.URLDrawableOptions.obtain();
          paramacmv.mFailedDrawable = paramView;
          paramacmv.mLoadingDrawable = paramacmv.mFailedDrawable;
          paramacmv.mRequestWidth = this.c;
          if (bool2) {
            break label864;
          }
          paramacmv.mRequestHeight = this.d;
          label478:
          paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramacmv);
          if (paramView.getStatus() == 2) {
            paramView.restartDownload();
          }
          paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        }
        if (bool2) {
          break label876;
        }
        paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadiusTop(14.0F);
        label523:
        if (paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool1)
        {
          paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool1;
          if (paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a == 1) {
            paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth(), paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight());
          }
          paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
        }
        if (bool2) {
          break label904;
        }
        paramacju.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!bool1) {
          break label888;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.g;
        label627:
        paramacju.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
        paramacju.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        paramacju.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramacju.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramacju.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
        label674:
        paramView = (RelativeLayout.LayoutParams)paramacju.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
        if (!bool1) {
          break label916;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.g;
        label703:
        if (bool2) {
          break label932;
        }
        paramView.addRule(12, 0);
        paramView.addRule(15, 0);
        label722:
        paramacju.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgTitle)) {
          break label991;
        }
        paramacju.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(localMessageForTroopSign.msgTitle);
        paramacju.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        paramacju.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
      }
      for (;;)
      {
        a(paramacju, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramChatMessage.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(paramacju, paramBaseChatItemLayout);
        return paramChatMessage;
        paramView.height = this.e;
        break;
        label843:
        paramView.leftMargin = azvv.a(this.a, 10.0F);
        paramView.rightMargin = 0;
        break label395;
        label864:
        paramacmv.mRequestHeight = this.e;
        break label478;
        label876:
        paramacju.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(14.0F);
        break label523;
        label888:
        paramView.leftMargin = this.g;
        paramView.rightMargin = 0;
        break label627;
        label904:
        paramacju.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label674;
        label916:
        paramView.leftMargin = this.g;
        paramView.rightMargin = 0;
        break label703;
        label932:
        if ((!TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) && (localMessageForTroopSign.msgCoverUrl.endsWith("e8e22512720843268d733a5f30f22d7f.png")))
        {
          paramView.addRule(12, 0);
          paramView.addRule(15, -1);
          break label722;
        }
        paramView.addRule(12, -1);
        paramView.addRule(15, 0);
        break label722;
        label991:
        paramacju.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText("");
      }
      paramChatMessage = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adth
 * JD-Core Version:    0.7.0.1
 */