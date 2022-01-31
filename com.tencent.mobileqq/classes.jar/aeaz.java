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

public class aeaz
  extends BaseBubbleBuilder
{
  View.OnClickListener a;
  
  public aeaz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new aeba(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acun a()
  {
    return new aebb(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((paramacun instanceof aebb))
    {
      paramacxn = (aebb)paramacun;
      paramacun = paramView;
      paramView = paramacxn;
      if (paramacun != null) {
        break label498;
      }
      paramacun = LayoutInflater.from(localContext).inflate(2131560403, null);
      paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramacun.findViewById(2131376420));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramacun.findViewById(2131376425));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramacun.findViewById(2131376426));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacun.findViewById(2131376427));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramacun.findViewById(2131378654));
      paramView.jdField_c_of_type_AndroidViewView = paramacun.findViewById(2131365335);
      paramView.d = paramacun.findViewById(2131364702);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramacun.findViewById(2131365308));
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
          paramView.d.setBackgroundResource(2130843294);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843290);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          if (paramBaseChatItemLayout.starAvatar.isEmpty()) {}
        }
        try
        {
          paramacxn = URLDrawable.URLDrawableOptions.obtain();
          paramacxn.mRequestWidth = bawz.a(localContext, 64.0F);
          paramacxn.mRequestHeight = bawz.a(localContext, 64.0F);
          paramacxn.mFailedDrawable = null;
          paramacxn.mLoadingDrawable = null;
          paramacxn = URLDrawable.getDrawable(paramBaseChatItemLayout.starAvatar, paramacxn);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramacxn);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(bawz.a(localContext, 32.0F));
          paramView.d.setContentDescription(paramBaseChatItemLayout.brief);
          paramView.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          return paramacun;
          paramView = (aebb)a();
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
          paramBaseChatItemLayout.setTag(paramView);
          paramacun = null;
          break;
          paramView.d.setBackgroundResource(2130843291);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843289);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        }
        catch (Throwable paramacxn)
        {
          for (;;)
          {
            QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramacxn);
          }
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacun, paramInt1, paramInt2);
    paramChatMessage = (aebb)paramacun;
    if (paramChatMessage.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramChatMessage.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.jdField_a_of_type_AndroidViewView.setLayoutParams(paramContext);
    }
  }
  
  public bblt[] a(View paramView)
  {
    paramView = new bblr();
    aaod.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeaz
 * JD-Core Version:    0.7.0.1
 */