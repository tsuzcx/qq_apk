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
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class aglj
  extends BaseBubbleBuilder
{
  protected static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aglk(this);
  private bcne jdField_a_of_type_Bcne;
  final int g = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public aglj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public aezf a()
  {
    return new agln(this);
  }
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramaezf = (agln)paramaezf;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131561753, null);
      paramaezf.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131377817));
      paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131377818));
      paramaezf.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131368148);
      paramaezf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131365187));
      paramaezf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131378707));
      paramaezf.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131378611));
      paramaezf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131364803));
    }
    paramaezf.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = yql.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846371);
      if (HttpUtil.isValidUrl(paramView))
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
        paramaezf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramaezf.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramaezf.jdField_a_of_type_AndroidWidgetTextView;
        paramaezf.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.summary);
        paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramafce);
        paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramafce);
      }
    }
    for (;;)
    {
      paramaezf.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new agll(this, paramafce));
      paramChatMessage.setOnTouchListener(paramafce);
      paramChatMessage.setOnLongClickListener(paramafce);
      return paramChatMessage;
      paramaezf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramaezf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramaezf.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bcne != null) {
      this.jdField_a_of_type_Bcne.a();
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForQQStoryComment localMessageForQQStoryComment = (MessageForQQStoryComment)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365382: 
      acvv.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      xwa.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131365216: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        xwa.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
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
    case 2131367094: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      atky.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      xwa.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131371455: 
      super.a(paramChatMessage);
      xwa.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.d(paramChatMessage);
    xwa.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(aezf paramaezf, View paramView, ChatMessage paramChatMessage, apee paramapee)
  {
    paramaezf = (agln)paramaezf;
    if (paramapee.b == 0)
    {
      paramaezf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramaezf.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, 0, 0, 0));
      paramaezf.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramaezf.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramapee.b);
    int j = Color.green(paramapee.b);
    int k = Color.blue(paramapee.b);
    paramaezf.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramaezf.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, i, j, k));
    paramaezf.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramapee.b);
    paramaezf.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(aezf paramaezf, ChatMessage paramChatMessage)
  {
    Object localObject = (agln)paramaezf;
    if (this.jdField_a_of_type_Bcne == null) {
      this.jdField_a_of_type_Bcne = new bcne();
    }
    if (this.jdField_a_of_type_Bcne.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ETTextView)((agln)localObject).jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem)) {}
    do
    {
      return;
      paramaezf = ((gb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(paramChatMessage);
      localObject = (ETTextView)((agln)localObject).jdField_b_of_type_AndroidWidgetTextView;
    } while (paramaezf == null);
    ((ETTextView)localObject).setFont(new ETFont(paramaezf.jdField_a_of_type_Int, paramaezf.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramaezf.b, paramaezf.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
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
  
  public bgbb[] a(View paramView)
  {
    bgaz localbgaz = new bgaz();
    localbgaz.a(2131365216, this.jdField_a_of_type_AndroidContentContext.getString(2131691176), 2130838962);
    localbgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692448), 2130838971);
    paramView = ((aezf)AIOUtils.getHolder(paramView)).a;
    super.a(localbgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
    a(localbgaz, paramView);
    super.c(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbgaz, this.jdField_a_of_type_AndroidContentContext);
    return localbgaz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglj
 * JD-Core Version:    0.7.0.1
 */