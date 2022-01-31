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

public class admh
  extends BaseBubbleBuilder
{
  protected static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  View.OnClickListener a;
  final int g = azvv.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public admh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new admi(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acju a()
  {
    return new adml(this);
  }
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramacju = (adml)paramacju;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131495802, null);
      paramacju.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131310739));
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131310740));
      paramacju.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131301979);
      paramacju.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131299236));
      paramacju.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131311534));
      paramacju.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131311450));
      paramacju.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131298878));
    }
    paramacju.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = vmp.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845365);
      if (mpl.a(paramView))
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
        paramacju.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramacju.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramacju.jdField_a_of_type_AndroidWidgetTextView;
        paramacju.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.summary);
        paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramacmv);
        paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramacmv);
      }
    }
    for (;;)
    {
      paramacju.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new admj(this, paramacmv));
      paramChatMessage.setOnTouchListener(paramacmv);
      paramChatMessage.setOnLongClickListener(paramacmv);
      return paramChatMessage;
      paramacju.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramacju.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramacju.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
    case 2131299417: 
      aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      urp.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131299262: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        urp.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
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
    case 2131301021: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      aphp.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      urp.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131304829: 
      super.a(paramChatMessage);
      urp.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.d(paramChatMessage);
    urp.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(acju paramacju, View paramView, ChatMessage paramChatMessage, almt paramalmt)
  {
    paramacju = (adml)paramacju;
    if (paramalmt.b == 0)
    {
      paramacju.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramacju.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, 0, 0, 0));
      paramacju.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramacju.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramalmt.b);
    int j = Color.green(paramalmt.b);
    int k = Color.blue(paramalmt.b);
    paramacju.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramacju.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, i, j, k));
    paramacju.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramalmt.b);
    paramacju.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(acju paramacju, ChatMessage paramChatMessage)
  {
    Object localObject = (adml)paramacju;
    paramacju = ((fv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(paramChatMessage);
    localObject = (ETTextView)((adml)localObject).jdField_b_of_type_AndroidWidgetTextView;
    if (paramacju != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramacju.jdField_a_of_type_Int, paramacju.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramacju.b, paramacju.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
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
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    localbakh.a(2131299262, this.jdField_a_of_type_AndroidContentContext.getString(2131625727), 2130838590);
    localbakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131627114), 2130838599);
    paramView = ((acju)aciy.a(paramView)).a;
    super.a(localbakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    a(localbakh, paramView);
    super.c(localbakh, this.jdField_a_of_type_AndroidContentContext);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admh
 * JD-Core Version:    0.7.0.1
 */