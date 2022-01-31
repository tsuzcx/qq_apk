import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.qphone.base.util.QLog;

public class afxl
  extends BaseBubbleBuilder
{
  View.OnClickListener a;
  
  public afxl(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afxm(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return new afxn(this);
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((paramaelt instanceof afxn))
    {
      paramaeov = (afxn)paramaelt;
      paramaelt = paramView;
      paramView = paramaeov;
      if (paramaelt != null) {
        break label498;
      }
      paramaelt = LayoutInflater.from(localContext).inflate(2131560511, null);
      paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramaelt.findViewById(2131376923));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramaelt.findViewById(2131376928));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramaelt.findViewById(2131376929));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaelt.findViewById(2131376930));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramaelt.findViewById(2131379277));
      paramView.jdField_c_of_type_AndroidViewView = paramaelt.findViewById(2131365419);
      paramView.d = paramaelt.findViewById(2131364780);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramaelt.findViewById(2131365392));
      paramView.d.getLayoutParams().width = BaseChatItemLayout.d;
    }
    label424:
    label498:
    for (;;)
    {
      for (;;)
      {
        paramBaseChatItemLayout.setHeadIconVisible(false);
        if (paramBaseChatItemLayout.c != null) {
          paramBaseChatItemLayout.c.setVisibility(8);
        }
        paramBaseChatItemLayout.b().setVisibility(4);
        if ((paramChatMessage instanceof MessageForStarLeague))
        {
          paramBaseChatItemLayout = (MessageForStarLeague)paramChatMessage;
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.starName);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.subTitle);
          if (paramBaseChatItemLayout.levelStatus != 1) {
            break label424;
          }
          paramView.d.setBackgroundResource(2130843478);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843474);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          if (paramBaseChatItemLayout.starAvatar.isEmpty()) {}
        }
        try
        {
          paramaeov = URLDrawable.URLDrawableOptions.obtain();
          paramaeov.mRequestWidth = bcwh.a(localContext, 64.0F);
          paramaeov.mRequestHeight = bcwh.a(localContext, 64.0F);
          paramaeov.mFailedDrawable = null;
          paramaeov.mLoadingDrawable = null;
          paramaeov = URLDrawable.getDrawable(paramBaseChatItemLayout.starAvatar, paramaeov);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramaeov);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(bcwh.a(localContext, 32.0F));
          paramView.d.setContentDescription(paramBaseChatItemLayout.brief);
          paramView.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          return paramaelt;
          paramView = (afxn)a();
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
          paramBaseChatItemLayout.setTag(paramView);
          paramaelt = null;
          break;
          paramView.d.setBackgroundResource(2130843475);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843473);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        }
        catch (Throwable paramaeov)
        {
          for (;;)
          {
            QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramaeov);
          }
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
    paramChatMessage = (afxn)paramaelt;
    if (paramChatMessage.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramChatMessage.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.jdField_a_of_type_AndroidViewView.setLayoutParams(paramContext);
    }
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = new bdkz();
    acex.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxl
 * JD-Core Version:    0.7.0.1
 */