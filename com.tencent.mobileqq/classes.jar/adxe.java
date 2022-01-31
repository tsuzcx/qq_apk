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

public class adxe
  extends BaseBubbleBuilder
{
  protected static final int c = BaseChatItemLayout.g + BaseChatItemLayout.l;
  protected static final int d = BaseChatItemLayout.h + BaseChatItemLayout.m;
  protected static final int e = BaseChatItemLayout.i + BaseChatItemLayout.n;
  protected static final int f = BaseChatItemLayout.j + BaseChatItemLayout.o;
  View.OnClickListener a;
  final int g = baxn.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  
  public adxe(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adxf(this);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public acuj a()
  {
    return new adxi(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    Object localObject = paramBaseChatItemLayout.getContext();
    paramBaseChatItemLayout = (MessageForQQStoryComment)paramChatMessage;
    paramacuj = (adxi)paramacuj;
    paramChatMessage = paramView;
    if (paramView == null)
    {
      paramChatMessage = LayoutInflater.from((Context)localObject).inflate(2131561392, null);
      paramacuj.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131376537));
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramChatMessage.findViewById(2131376538));
      paramacuj.jdField_c_of_type_AndroidViewView = paramChatMessage.findViewById(2131367596);
      paramacuj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramChatMessage.findViewById(2131364798));
      paramacuj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131377350));
      paramacuj.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131377264));
      paramacuj.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramChatMessage.findViewById(2131364437));
    }
    paramacuj.jdField_b_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.comment);
    if (paramBaseChatItemLayout.displayType == 0)
    {
      paramView = vzi.a(paramBaseChatItemLayout.coverUrl);
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845555);
      if (naj.a(paramView))
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
        paramacuj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        paramacuj.jdField_a_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.title);
        paramView = paramacuj.jdField_a_of_type_AndroidWidgetTextView;
        paramacuj.jdField_c_of_type_AndroidWidgetTextView.setText(paramBaseChatItemLayout.summary);
        paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(paramacxj);
        paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(paramacxj);
      }
    }
    for (;;)
    {
      paramacuj.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(new adxg(this, paramacxj));
      paramChatMessage.setOnTouchListener(paramacxj);
      paramChatMessage.setOnLongClickListener(paramacxj);
      return paramChatMessage;
      paramacuj.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      break;
      paramacuj.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      paramacuj.jdField_c_of_type_AndroidViewView.setVisibility(8);
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
    case 2131364984: 
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      vei.a("story_grp", "press_aio", 0, 0, new String[] { "4", "", "", "" });
      return;
    case 2131364824: 
      if (localMessageForQQStoryComment.comment != null) {}
      try
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(localMessageForQQStoryComment.comment);
        vei.a("story_grp", "press_aio", 0, 0, new String[] { "1", "", "", "" });
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
      aqbe.a((Activity)this.jdField_a_of_type_AndroidContentContext, paramChatMessage, 21);
      vei.a("story_grp", "press_aio", 0, 0, new String[] { "2", "", "", "" });
      return;
    case 2131370493: 
      super.a(paramChatMessage);
      vei.a("story_grp", "press_aio", 0, 0, new String[] { "3", "", "", "" });
      return;
    }
    super.d(paramChatMessage);
    vei.a("story_grp", "press_aio", 0, 0, new String[] { "5", "", "", "" });
  }
  
  public void a(acuj paramacuj, View paramView, ChatMessage paramChatMessage, ambg paramambg)
  {
    paramacuj = (adxi)paramacuj;
    if (paramambg.b == 0)
    {
      paramacuj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, 0, 0, 0));
      paramacuj.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, 0, 0, 0));
      paramacuj.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      paramacuj.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, 0, 0, 0));
      return;
    }
    int i = Color.red(paramambg.b);
    int j = Color.green(paramambg.b);
    int k = Color.blue(paramambg.b);
    paramacuj.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(178, i, j, k));
    paramacuj.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.argb(127, i, j, k));
    paramacuj.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramambg.b);
    paramacuj.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.argb(127, i, j, k));
  }
  
  public void a(acuj paramacuj, ChatMessage paramChatMessage)
  {
    Object localObject = (adxi)paramacuj;
    paramacuj = ((ho)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).b(paramChatMessage);
    localObject = (ETTextView)((adxi)localObject).jdField_b_of_type_AndroidWidgetTextView;
    if (paramacuj != null) {
      ((ETTextView)localObject).setFont(new ETFont(paramacuj.jdField_a_of_type_Int, paramacuj.jdField_a_of_type_JavaLangString, ((ETTextView)localObject).getTextSize(), paramacuj.b, paramacuj.jdField_a_of_type_AndroidGraphicsTypeface), paramChatMessage.uniseq);
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
  
  public bbmh[] a(View paramView)
  {
    bbmf localbbmf = new bbmf();
    localbbmf.a(2131364824, this.jdField_a_of_type_AndroidContentContext.getString(2131691303), 2130838597);
    localbbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692753), 2130838606);
    paramView = ((acuj)actj.a(paramView)).a;
    super.a(localbbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramView);
    a(localbbmf, paramView);
    super.c(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    super.e(localbbmf, this.jdField_a_of_type_AndroidContentContext);
    return localbbmf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxe
 * JD-Core Version:    0.7.0.1
 */