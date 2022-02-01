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
import com.tencent.qphone.base.util.QLog;

public class ahsp
  extends BaseBubbleBuilder
{
  View.OnClickListener a;
  
  public ahsp(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahsq(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return new ahsr(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((paramaggl instanceof ahsr))
    {
      paramagjk = (ahsr)paramaggl;
      paramaggl = paramView;
      paramView = paramagjk;
      if (paramaggl != null) {
        break label516;
      }
      paramaggl = LayoutInflater.from(localContext).inflate(2131560678, null);
      paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramaggl.findViewById(2131377936));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramaggl.findViewById(2131377940));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramaggl.findViewById(2131377941));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramaggl.findViewById(2131377942));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramaggl.findViewById(2131380446));
      paramView.jdField_c_of_type_AndroidViewView = paramaggl.findViewById(2131365699);
      paramView.d = paramaggl.findViewById(2131365056);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramaggl.findViewById(2131365672));
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
          paramView.d.setBackgroundResource(2130843870);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843866);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
          if (paramBaseChatItemLayout.starAvatar.isEmpty()) {}
        }
        try
        {
          paramagjk = URLDrawable.URLDrawableOptions.obtain();
          paramagjk.mRequestWidth = bhgr.a(localContext, 64.0F);
          paramagjk.mRequestHeight = bhgr.a(localContext, 64.0F);
          paramagjk.mFailedDrawable = null;
          paramagjk.mLoadingDrawable = null;
          paramagjk = URLDrawable.getDrawable(paramBaseChatItemLayout.starAvatar, paramagjk);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramagjk);
          paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(bhgr.a(localContext, 32.0F));
          paramView.d.setContentDescription(paramBaseChatItemLayout.brief);
          paramView.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          return paramaggl;
          paramView = (ahsr)a();
          paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
          paramBaseChatItemLayout.setTag(paramView);
          paramaggl = null;
          break;
          label442:
          paramView.d.setBackgroundResource(2130843867);
          paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843865);
          paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
          paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
        }
        catch (Throwable paramagjk)
        {
          for (;;)
          {
            QLog.e("ChatItemBuilder", 1, "levelStatus parse failed!", paramagjk);
          }
        }
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aggl paramaggl, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaggl, paramInt1, paramInt2);
    paramChatMessage = (ahsr)paramaggl;
    if (paramChatMessage.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramChatMessage.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.jdField_a_of_type_AndroidViewView.setLayoutParams(paramContext);
    }
  }
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    aean.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahsp
 * JD-Core Version:    0.7.0.1
 */