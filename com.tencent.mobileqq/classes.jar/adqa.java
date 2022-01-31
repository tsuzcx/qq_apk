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

public class adqa
  extends BaseBubbleBuilder
{
  View.OnClickListener a;
  
  public adqa(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adqb(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return new adqc(this);
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Context localContext = paramBaseChatItemLayout.getContext();
    if ((paramacju instanceof adqc))
    {
      paramacmv = (adqc)paramacju;
      paramacju = paramView;
      paramView = paramacmv;
      if (paramacju != null) {
        break label472;
      }
      paramacju = LayoutInflater.from(localContext).inflate(2131494831, null);
      paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)paramacju.findViewById(2131310627));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramacju.findViewById(2131310632));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramacju.findViewById(2131310633));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramacju.findViewById(2131310634));
      paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramacju.findViewById(2131312830));
      paramView.jdField_c_of_type_AndroidViewView = paramacju.findViewById(2131299768);
      paramView.d = paramacju.findViewById(2131299142);
      paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramacju.findViewById(2131299740));
      paramView.d.getLayoutParams().width = BaseChatItemLayout.d;
    }
    label413:
    label472:
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
          break label413;
        }
        paramView.d.setBackgroundResource(2130843211);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843207);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      }
      for (;;)
      {
        paramacmv = URLDrawable.URLDrawableOptions.obtain();
        paramacmv.mRequestWidth = azvv.a(localContext, 64.0F);
        paramacmv.mRequestHeight = azvv.a(localContext, 64.0F);
        paramacmv.mFailedDrawable = null;
        paramacmv.mLoadingDrawable = null;
        paramacmv = URLDrawable.getDrawable(paramBaseChatItemLayout.starAvatar, paramacmv);
        paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setImageDrawable(paramacmv);
        paramView.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(azvv.a(localContext, 32.0F));
        paramView.d.setContentDescription(paramBaseChatItemLayout.brief);
        paramView.d.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
        return paramacju;
        paramView = (adqc)a();
        paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
        paramBaseChatItemLayout.setTag(paramView);
        paramacju = null;
        break;
        paramView.d.setBackgroundResource(2130843208);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843206);
        paramView.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        paramView.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        paramView.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return null;
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    paramChatMessage = (adqc)paramacju;
    if (paramChatMessage.jdField_a_of_type_AndroidViewView != null)
    {
      paramContext = paramChatMessage.jdField_a_of_type_AndroidViewView.getLayoutParams();
      paramContext.width = -1;
      paramContext.height = -1;
      paramChatMessage.jdField_a_of_type_AndroidViewView.setLayoutParams(paramContext);
    }
  }
  
  public bakj[] a(View paramView)
  {
    paramView = new bakh();
    aael.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.d(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adqa
 * JD-Core Version:    0.7.0.1
 */