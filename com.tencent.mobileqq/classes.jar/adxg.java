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

public class adxg
  extends BaseBubbleBuilder
{
  protected static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  View.OnClickListener a;
  final int g = bawz.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public adxg(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adxh(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acun a()
  {
    return new adxk(this);
  }
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramacun = (adxk)paramacun;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131561393, null);
      paramacun.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131376535));
      paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131376536));
      paramacun.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131367596);
      paramacun.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131364799));
      paramacun.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131377350));
      paramacun.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131377263));
      paramacun.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131364438));
    }
    paramacun.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = vzl.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845549);
      if (nam.a(paramView))
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
        paramacun.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramacun.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramacun.jdField_a_of_type_AndroidWidgetTextView;
        paramacun.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.summary);
        paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramacxn);
        paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramacxn);
      }
    }
    for (;;)
    {
      paramacun.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new adxi(this, paramacxn));
      paramChatMessage.setOnTouchListener(paramacxn);
      paramChatMessage.setOnLongClickListener(paramacxn);
      return paramChatMessage;
      paramacun.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramacun.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramacun.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
    case 2131364985: 
      aaod.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      vel.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131364825: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        vel.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
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
    case 2131366632: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      aqbc.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      vel.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131370494: 
      super.a(paramChatMessage);
      vel.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.d(paramChatMessage);
    vel.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(acun paramacun, View paramView, ChatMessage paramChatMessage, ambh paramambh)
  {
    paramacun = (adxk)paramacun;
    if (paramambh.b == 0)
    {
      paramacun.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramacun.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, 0, 0, 0));
      paramacun.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramacun.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramambh.b);
    int j = Color.green(paramambh.b);
    int k = Color.blue(paramambh.b);
    paramacun.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramacun.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, i, j, k));
    paramacun.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramambh.b);
    paramacun.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(acun paramacun, ChatMessage paramChatMessage)
  {
    Object localObject = (adxk)paramacun;
    paramacun = ((ho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(paramChatMessage);
    localObject = (ETTextView)((adxk)localObject).jdField_b_of_type_AndroidWidgetTextView;
    if (paramacun != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramacun.jdField_a_of_type_Int, paramacun.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramacun.b, paramacun.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
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
  
  public bblt[] a(View paramView)
  {
    bblr localbblr = new bblr();
    localbblr.a(2131364825, this.jdField_a_of_type_AndroidContentContext.getString(2131691303), 2130838597);
    localbblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692752), 2130838606);
    paramView = ((acun)actn.a(paramView)).a;
    super.a(localbblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    a(localbblr, paramView);
    super.c(localbblr, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbblr, this.jdField_a_of_type_AndroidContentContext);
    return localbblr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxg
 * JD-Core Version:    0.7.0.1
 */