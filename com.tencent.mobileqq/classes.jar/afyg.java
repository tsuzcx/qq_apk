import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETTextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.qphone.base.util.QLog;

public class afyg
  extends BaseBubbleBuilder
{
  protected static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  View.OnClickListener a;
  final int g = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public afyg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afyh(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aeqi a()
  {
    return new afyk(this);
  }
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramaeqi = (afyk)paramaeqi;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131561600, null);
      paramaeqi.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131377091));
      paramaeqi.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131377092));
      paramaeqi.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131367735);
      paramaeqi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131364881));
      paramaeqi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131377938));
      paramaeqi.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131377847));
      paramaeqi.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131364511));
    }
    paramaeqi.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = xsj.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846007);
      if (ndd.a(paramView))
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = localURLDrawableOptions.mFailedDrawable;
        localURLDrawableOptions.mRequestWidth = this.g;
        localURLDrawableOptions.mRequestHeight = this.g;
        paramView = URLDrawable.getDrawable(paramView, localURLDrawableOptions);
        if (paramView.getStatus() == 2) {
          paramView.restartDownload();
        }
        paramaeqi.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramaeqi.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramaeqi.jdField_a_of_type_AndroidWidgetTextView;
        paramaeqi.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.summary);
        paramaeqi.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramaeqi.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramaetk);
        paramaeqi.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramaetk);
      }
    }
    for (;;)
    {
      paramaeqi.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new afyi(this, paramaetk));
      paramChatMessage.setOnTouchListener(paramaetk);
      paramChatMessage.setOnLongClickListener(paramaetk);
      return paramChatMessage;
      paramaeqi.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramaeqi.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramaeqi.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365071: 
      acjm.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      wxj.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131364912: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        wxj.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
        return;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("QQStoryCommentItemBuilder", 2, paramContext.toString());
          }
        }
      }
    case 2131366760: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      aryv.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      wxj.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131370818: 
      super.a(paramChatMessage);
      wxj.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.d(paramChatMessage);
    wxj.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(aeqi paramaeqi, View paramView, ChatMessage paramChatMessage, anwo paramanwo)
  {
    paramaeqi = (afyk)paramaeqi;
    if (paramanwo.b == 0)
    {
      paramaeqi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramaeqi.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, 0, 0, 0));
      paramaeqi.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramaeqi.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramanwo.b);
    int j = Color.green(paramanwo.b);
    int k = Color.blue(paramanwo.b);
    paramaeqi.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramaeqi.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, i, j, k));
    paramaeqi.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramanwo.b);
    paramaeqi.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(aeqi paramaeqi, ChatMessage paramChatMessage)
  {
    Object localObject = (afyk)paramaeqi;
    paramaeqi = ((fx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(paramChatMessage);
    localObject = (ETTextView)((afyk)localObject).jdField_b_of_type_AndroidWidgetTextView;
    if (paramaeqi != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramaeqi.jdField_a_of_type_Int, paramaeqi.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramaeqi.b, paramaeqi.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(f, c, e, d);
      return;
    }
    paramView.setPadding(e, c, f, d);
  }
  
  public bdpk[] a(View paramView)
  {
    bdpi localbdpi = new bdpi();
    localbdpi.a(2131364912, this.jdField_a_of_type_AndroidContentContext.getString(2131691357), 2130838669);
    localbdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692837), 2130838678);
    paramView = ((aeqi)aepi.a(paramView)).a;
    super.a(localbdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    a(localbdpi, paramView);
    super.c(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdpi, this.jdField_a_of_type_AndroidContentContext);
    return localbdpi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afyg
 * JD-Core Version:    0.7.0.1
 */