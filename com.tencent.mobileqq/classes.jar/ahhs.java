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
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class ahhs
  extends BaseBubbleBuilder
{
  View.OnClickListener a;
  
  public ahhs(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahht(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return new ahhu(this);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((paramafqr instanceof ahhu))
    {
      paramaftk = (ahhu)paramafqr;
      paramafqr = paramView;
      paramView = paramaftk;
      if (paramafqr != null) {
        break label516;
      }
      paramafqr = LayoutInflater.from(localContext).inflate(2131560742, null);
      paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramafqr.findViewById(2131377984));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramafqr.findViewById(2131377989));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramafqr.findViewById(2131377990));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramafqr.findViewById(2131377991));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramafqr.findViewById(2131380505));
      paramView.jdField_c_of_type_AndroidViewView = paramafqr.findViewById(2131365826);
      paramView.d = paramafqr.findViewById(2131365167);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramafqr.findViewById(2131365799));
      paramView.d.getLayoutParams().width = BaseChatItemLayout.e;
    }
    label516:
    for (;;)
    {
      for (;;)
      {
        paramBaseChatItemLayout.setHeadIconVisible(false);
        if (paramBaseChatItemLayout.c != null) {
          paramBaseChatItemLayout.c.setVisibility(8);
        }
        if (paramBaseChatItemLayout.a != null) {
          paramBaseChatItemLayout.a.setVisibility(8);
        }
        paramBaseChatItemLayout.b().setVisibility(4);
        if ((paramChatMessage instanceof MessageForStarLeague))
        {
          paramBaseChatItemLayout = (MessageForStarLeague)paramChatMessage;
          paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.starName);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.subTitle);
          if (paramBaseChatItemLayout.levelStatus != 1) {
            break label442;
          }
          paramView.d.setBackgroundResource(2130843972);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843968);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          if (paramBaseChatItemLayout.starAvatar.isEmpty()) {}
        }
        try
        {
          paramaftk = URLDrawable.URLDrawableOptions.obtain();
          paramaftk.mRequestWidth = DisplayUtil.dip2px(localContext, 64.0F);
          paramaftk.mRequestHeight = DisplayUtil.dip2px(localContext, 64.0F);
          paramaftk.mFailedDrawable = null;
          paramaftk.mLoadingDrawable = null;
          paramaftk = URLDrawable.getDrawable(paramBaseChatItemLayout.starAvatar, paramaftk);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramaftk);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(DisplayUtil.dip2px(localContext, 32.0F));
          paramView.d.setContentDescription(paramBaseChatItemLayout.brief);
          paramView.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          return paramafqr;
          paramView = (ahhu)a();
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
          paramBaseChatItemLayout.setTag(paramView);
          paramafqr = null;
          break;
          label442:
          paramView.d.setBackgroundResource(2130843969);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843967);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        }
        catch (Throwable paramaftk)
        {
          for (;;)
          {
            QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramaftk);
          }
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
    paramChatMessage = (ahhu)paramafqr;
    if (paramChatMessage.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramChatMessage.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.jdField_a_of_type_AndroidViewView.setLayoutParams(paramContext);
    }
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = new bhjq();
    admh.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhs
 * JD-Core Version:    0.7.0.1
 */