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

public class ahow
  extends BaseBubbleBuilder
{
  protected static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  View.OnClickListener a;
  final int g = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public ahow(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahox(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aggl a()
  {
    return new ahpa(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramaggl = (ahpa)paramaggl;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131561876, null);
      paramaggl.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131378047));
      paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131378048));
      paramaggl.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131368119);
      paramaggl.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131365160));
      paramaggl.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131378936));
      paramaggl.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131378847));
      paramaggl.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131364772));
    }
    paramaggl.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = zpp.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846463);
      if (nnr.a(paramView))
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
        paramaggl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramaggl.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramaggl.jdField_a_of_type_AndroidWidgetTextView;
        paramaggl.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.summary);
        paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramagjk);
        paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramagjk);
      }
    }
    for (;;)
    {
      paramaggl.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new ahoy(this, paramagjk));
      paramChatMessage.setOnTouchListener(paramagjk);
      paramChatMessage.setOnLongClickListener(paramagjk);
      return paramChatMessage;
      paramaggl.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramaggl.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramaggl.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
    case 2131365352: 
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      yup.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131365191: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        yup.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
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
    case 2131367078: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      auxu.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      yup.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131371487: 
      super.a(paramChatMessage);
      yup.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.d(paramChatMessage);
    yup.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(aggl paramaggl, View paramView, ChatMessage paramChatMessage, aqkt paramaqkt)
  {
    paramaggl = (ahpa)paramaggl;
    if (paramaqkt.b == 0)
    {
      paramaggl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramaggl.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, 0, 0, 0));
      paramaggl.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramaggl.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramaqkt.b);
    int j = Color.green(paramaqkt.b);
    int k = Color.blue(paramaqkt.b);
    paramaggl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramaggl.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, i, j, k));
    paramaggl.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqkt.b);
    paramaggl.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(aggl paramaggl, ChatMessage paramChatMessage)
  {
    Object localObject = (ahpa)paramaggl;
    paramaggl = ((gc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(paramChatMessage);
    localObject = (ETTextView)((ahpa)localObject).jdField_b_of_type_AndroidWidgetTextView;
    if (paramaggl != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramaggl.jdField_a_of_type_Int, paramaggl.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramaggl.b, paramaggl.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
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
  
  public bhum[] a(View paramView)
  {
    bhuk localbhuk = new bhuk();
    localbhuk.a(2131365191, this.jdField_a_of_type_AndroidContentContext.getString(2131691137), 2130838930);
    localbhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692400), 2130838939);
    paramView = ((aggl)agej.a(paramView)).a;
    super.a(localbhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    a(localbhuk, paramView);
    super.c(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhuk, this.jdField_a_of_type_AndroidContentContext);
    return localbhuk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahow
 * JD-Core Version:    0.7.0.1
 */