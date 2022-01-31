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

public class aeax
  extends BaseBubbleBuilder
{
  View.OnClickListener a;
  
  public aeax(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aeay(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return new aeaz(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((paramacuj instanceof aeaz))
    {
      paramacxj = (aeaz)paramacuj;
      paramacuj = paramView;
      paramView = paramacxj;
      if (paramacuj != null) {
        break label498;
      }
      paramacuj = LayoutInflater.from(localContext).inflate(2131560403, null);
      paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramacuj.findViewById(2131376422));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramacuj.findViewById(2131376427));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramacuj.findViewById(2131376428));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacuj.findViewById(2131376429));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramacuj.findViewById(2131378659));
      paramView.jdField_c_of_type_AndroidViewView = paramacuj.findViewById(2131365334);
      paramView.d = paramacuj.findViewById(2131364701);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramacuj.findViewById(2131365307));
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
          paramView.d.setBackgroundResource(2130843295);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843291);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          if (paramBaseChatItemLayout.starAvatar.isEmpty()) {}
        }
        try
        {
          paramacxj = URLDrawable.URLDrawableOptions.obtain();
          paramacxj.mRequestWidth = baxn.a(localContext, 64.0F);
          paramacxj.mRequestHeight = baxn.a(localContext, 64.0F);
          paramacxj.mFailedDrawable = null;
          paramacxj.mLoadingDrawable = null;
          paramacxj = URLDrawable.getDrawable(paramBaseChatItemLayout.starAvatar, paramacxj);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramacxj);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(baxn.a(localContext, 32.0F));
          paramView.d.setContentDescription(paramBaseChatItemLayout.brief);
          paramView.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          return paramacuj;
          paramView = (aeaz)a();
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
          paramBaseChatItemLayout.setTag(paramView);
          paramacuj = null;
          break;
          paramView.d.setBackgroundResource(2130843292);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843290);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        }
        catch (Throwable paramacxj)
        {
          for (;;)
          {
            QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramacxj);
          }
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acuj paramacuj, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacuj, paramInt1, paramInt2);
    paramChatMessage = (aeaz)paramacuj;
    if (paramChatMessage.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramChatMessage.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.jdField_a_of_type_AndroidViewView.setLayoutParams(paramContext);
    }
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = new bbmf();
    aanz.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeax
 * JD-Core Version:    0.7.0.1
 */