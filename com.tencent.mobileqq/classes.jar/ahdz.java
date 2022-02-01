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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class ahdz
  extends BaseBubbleBuilder
{
  protected static final int c = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  protected static final int f = BaseChatItemLayout.k + BaseChatItemLayout.p;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ahea(this);
  private bdue jdField_a_of_type_Bdue;
  final int g = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public ahdz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public afqr a()
  {
    return new ahed(this);
  }
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramafqr = (ahed)paramafqr;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131561821, null);
      paramafqr.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131378099));
      paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131378100));
      paramafqr.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131368291);
      paramafqr.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131365278));
      paramafqr.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131379001));
      paramafqr.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131378905));
      paramafqr.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131364890));
    }
    paramafqr.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = zfe.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846467);
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
        paramafqr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramafqr.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramafqr.jdField_a_of_type_AndroidWidgetTextView;
        paramafqr.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.summary);
        paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramaftk);
        paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramaftk);
      }
    }
    for (;;)
    {
      paramafqr.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new aheb(this, paramaftk));
      paramChatMessage.setOnTouchListener(paramaftk);
      paramChatMessage.setOnLongClickListener(paramaftk);
      return paramChatMessage;
      paramafqr.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramafqr.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramafqr.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bdue != null) {
      this.jdField_a_of_type_Bdue.a();
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
    case 2131365475: 
      admh.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      ykv.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131365307: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        ykv.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
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
    case 2131367213: 
      paramContext = new Bundle();
      paramContext.putInt("forward_type", -1);
      paramContext.putString("forward_text", localMessageForQQStoryComment.comment);
      paramContext.putInt("selection_mode", this.b);
      paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      paramChatMessage.putExtra("direct_send_if_dataline_forward", true);
      aupt.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      ykv.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131371641: 
      super.a(paramChatMessage);
      ykv.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.d(paramChatMessage);
    ykv.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(afqr paramafqr, View paramView, ChatMessage paramChatMessage, aqhi paramaqhi)
  {
    paramafqr = (ahed)paramafqr;
    if (paramaqhi.b == 0)
    {
      paramafqr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramafqr.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, 0, 0, 0));
      paramafqr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramafqr.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramaqhi.b);
    int j = Color.green(paramaqhi.b);
    int k = Color.blue(paramaqhi.b);
    paramafqr.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramafqr.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, i, j, k));
    paramafqr.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramaqhi.b);
    paramafqr.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(afqr paramafqr, ChatMessage paramChatMessage)
  {
    Object localObject = (ahed)paramafqr;
    if (this.jdField_a_of_type_Bdue == null) {
      this.jdField_a_of_type_Bdue = new bdue();
    }
    if (this.jdField_a_of_type_Bdue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ETTextView)((ahed)localObject).jdField_b_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem)) {}
    do
    {
      return;
      paramafqr = ((gb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).b(paramChatMessage);
      localObject = (ETTextView)((ahed)localObject).jdField_b_of_type_AndroidWidgetTextView;
    } while (paramafqr == null);
    ((ETTextView)localObject).setFont(new ETFont(paramafqr.jdField_a_of_type_Int, paramafqr.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramafqr.b, paramafqr.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
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
  
  public bhjs[] a(View paramView)
  {
    bhjq localbhjq = new bhjq();
    localbhjq.a(2131365307, this.jdField_a_of_type_AndroidContentContext.getString(2131691261), 2130838982);
    localbhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838991);
    paramView = ((afqr)AIOUtils.getHolder(paramView)).a;
    super.a(localbhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramView);
    a(localbhjq, paramView);
    super.c(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbhjq, this.jdField_a_of_type_AndroidContentContext);
    return localbhjq.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdz
 * JD-Core Version:    0.7.0.1
 */