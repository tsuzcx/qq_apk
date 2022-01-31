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

public class aftr
  extends BaseBubbleBuilder
{
  protected static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  View.OnClickListener a;
  final int g = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public aftr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new afts(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aelt a()
  {
    return new aftv(this);
  }
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramaelt = (aftv)paramaelt;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131561582, null);
      paramaelt.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131377037));
      paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131377038));
      paramaelt.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131367725);
      paramaelt.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131364879));
      paramaelt.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131377884));
      paramaelt.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131377793));
      paramaelt.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131364509));
    }
    paramaelt.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = xoa.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845934);
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
        paramaelt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramaelt.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramaelt.jdField_a_of_type_AndroidWidgetTextView;
        paramaelt.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.summary);
        paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramaeov);
        paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramaeov);
      }
    }
    for (;;)
    {
      paramaelt.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aftt(this, paramaeov));
      paramChatMessage.setOnTouchListener(paramaeov);
      paramChatMessage.setOnLongClickListener(paramaeov);
      return paramChatMessage;
      paramaelt.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramaelt.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramaelt.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
    case 2131365069: 
      acex.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      wta.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131364910: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        wta.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
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
    case 2131366750: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      arum.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      wta.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131370799: 
      super.a(paramChatMessage);
      wta.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.d(paramChatMessage);
    wta.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(aelt paramaelt, View paramView, ChatMessage paramChatMessage, ansf paramansf)
  {
    paramaelt = (aftv)paramaelt;
    if (paramansf.b == 0)
    {
      paramaelt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramaelt.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, 0, 0, 0));
      paramaelt.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramaelt.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramansf.b);
    int j = Color.green(paramansf.b);
    int k = Color.blue(paramansf.b);
    paramaelt.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramaelt.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, i, j, k));
    paramaelt.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramansf.b);
    paramaelt.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(aelt paramaelt, ChatMessage paramChatMessage)
  {
    Object localObject = (aftv)paramaelt;
    paramaelt = ((fx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(paramChatMessage);
    localObject = (ETTextView)((aftv)localObject).jdField_b_of_type_AndroidWidgetTextView;
    if (paramaelt != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramaelt.jdField_a_of_type_Int, paramaelt.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramaelt.b, paramaelt.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
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
  
  public bdlb[] a(View paramView)
  {
    bdkz localbdkz = new bdkz();
    localbdkz.a(2131364910, this.jdField_a_of_type_AndroidContentContext.getString(2131691356), 2130838668);
    localbdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692835), 2130838677);
    paramView = ((aelt)aekt.a(paramView)).a;
    super.a(localbdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    a(localbdkz, paramView);
    super.c(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbdkz, this.jdField_a_of_type_AndroidContentContext);
    return localbdkz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftr
 * JD-Core Version:    0.7.0.1
 */