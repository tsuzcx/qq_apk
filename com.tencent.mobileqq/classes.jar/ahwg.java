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

public class ahwg
  extends ahwe
{
  public ahwg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public aggl a()
  {
    return new ahwh();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramaggl = (ahwh)paramaggl;
    boolean bool1 = paramChatMessage.isSend();
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramChatMessage;
    localMessageForTroopSign.parse();
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from(this.a).inflate(2131562945, paramBaseChatItemLayout, false);
      paramChatMessage.setLayoutParams(new RelativeLayout.LayoutParams(this.c + BaseChatItemLayout.k + bhgr.a(this.a, 10.0F), this.e + BaseChatItemLayout.h + BaseChatItemLayout.i));
      paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage);
      paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365160));
      paramaggl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView = ((EllipsizingTextView)paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378936));
      paramaggl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378243));
      paramaggl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370602));
      paramaggl.b = ((TextView)paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370604));
      paramaggl.jdField_c_of_type_AndroidViewView = paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370603);
      paramaggl.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370606));
      paramaggl.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370601));
      paramaggl.jdField_d_of_type_AndroidViewView = paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370605);
      paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.c(false);
      paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d(false);
      paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusable(false);
      paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setFocusableInTouchMode(false);
      paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setClickable(false);
      paramChatMessage.setOnClickListener(this);
      paramChatMessage.setOnLongClickListener(paramagjk);
      paramChatMessage.setOnTouchListener(paramagjk);
      paramView = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 201326592, 855638016 });
      paramView.setShape(0);
      paramView.setGradientType(0);
      paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
    }
    for (;;)
    {
      boolean bool2 = TextUtils.isEmpty(localMessageForTroopSign.msgContent);
      paramView = (RelativeLayout.LayoutParams)paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getLayoutParams();
      if (!bool2)
      {
        paramView.height = this.d;
        if (!bool1) {
          break label844;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = bhgr.a(this.a, 10.0F);
        label395:
        paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setLayoutParams(paramView);
        paramView = new ColorDrawable(this.h);
        paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgCoverUrl)) {}
      }
      for (;;)
      {
        try
        {
          paramagjk = URLDrawable.URLDrawableOptions.obtain();
          paramagjk.mFailedDrawable = paramView;
          paramagjk.mLoadingDrawable = paramagjk.mFailedDrawable;
          paramagjk.mRequestWidth = this.c;
          if (bool2) {
            continue;
          }
          paramagjk.mRequestHeight = this.d;
          paramView = URLDrawable.getDrawable(localMessageForTroopSign.msgCoverUrl, paramagjk);
          if (paramView.getStatus() == 2) {
            paramView.restartDownload();
          }
          paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramView);
        }
        catch (Exception paramView)
        {
          label844:
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopSignItemBuilder", 2, QLog.getStackTraceString(paramView));
          continue;
          paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(14.0F);
          continue;
          paramView.leftMargin = this.g;
          paramView.rightMargin = 0;
          continue;
          paramaggl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
          paramaggl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText("");
          continue;
        }
        if (bool2) {
          continue;
        }
        paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadiusTop(14.0F);
        if (paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d != bool1)
        {
          paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.d = bool1;
          if (paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a == 1) {
            paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.a(paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getWidth(), paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getHeight());
          }
          paramaggl.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.invalidate();
        }
        if (bool2) {
          continue;
        }
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = (RelativeLayout.LayoutParams)paramaggl.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        if (!bool1) {
          continue;
        }
        paramView.leftMargin = 0;
        paramView.rightMargin = this.g;
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramView);
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageForTroopSign.msgContent);
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(1);
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setGravity(19);
        paramView = (RelativeLayout.LayoutParams)paramaggl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.getLayoutParams();
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
        paramaggl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setLayoutParams(paramView);
        if (TextUtils.isEmpty(localMessageForTroopSign.msgTitle)) {
          continue;
        }
        paramaggl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setText(localMessageForTroopSign.msgTitle);
        paramaggl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setMaxLines(2);
        paramaggl.jdField_a_of_type_ComTencentMobileqqTroopWidgetEllipsizingTextView.setEllipsize(TextUtils.TruncateAt.END);
        a(paramaggl, localMessageForTroopSign);
        if ((AppSetting.c) && (!TextUtils.isEmpty(localMessageForTroopSign.msgTitle))) {
          paramChatMessage.setContentDescription("" + localMessageForTroopSign.msgTitle);
        }
        a(paramaggl, paramBaseChatItemLayout);
        return paramChatMessage;
        paramView.height = this.e;
        break;
        paramView.leftMargin = bhgr.a(this.a, 10.0F);
        paramView.rightMargin = 0;
        break label395;
        paramagjk.mRequestHeight = this.e;
      }
      paramChatMessage = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwg
 * JD-Core Version:    0.7.0.1
 */