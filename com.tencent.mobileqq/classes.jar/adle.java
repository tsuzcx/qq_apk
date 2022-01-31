import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.open.adapter.OpenAppClient;
import java.net.URL;
import java.util.HashSet;

public class adle
  extends BaseBubbleBuilder
{
  private final float jdField_b_of_type_Float;
  HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  
  public adle(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(adlf paramadlf)
  {
    if (paramadlf.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isMixed)
    {
      Object localObject = paramadlf.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      if (((MessageForPic)localObject).msgtype == -1032)
      {
        paramadlf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131720656);
      String str1;
      if (((MessageForPic)localObject).shareAppID != 0L)
      {
        localObject = bbcc.a(((MessageForPic)localObject).shareAppID);
        AppShareID localAppShareID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
        if (localAppShareID != null)
        {
          str1 = str2;
          if (localAppShareID.messagetail != null) {
            str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690147) + localAppShareID.messagetail;
          }
        }
      }
      for (;;)
      {
        paramadlf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramadlf.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
        return;
        str1 = str2;
        if (!this.jdField_b_of_type_JavaUtilHashSet.contains(localObject))
        {
          awzb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject);
          this.jdField_b_of_type_JavaUtilHashSet.add(localObject);
          str1 = str2;
          continue;
          str1 = str2;
          if (((MessageForPic)localObject).msgtype == -3001) {
            str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692220);
          }
        }
      }
    }
    paramadlf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("schemaurl", paramMessageForPic.action);
    localBundle.putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localBundle.putString("vkey", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    OpenAppClient.a((Activity)this.jdField_a_of_type_AndroidContentContext, localBundle);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public acuj a()
  {
    return new adlf(this);
  }
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    paramBaseChatItemLayout = (adlf)paramacuj;
    paramacuj = paramView;
    if (paramView == null)
    {
      paramacuj = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramacuj.setOrientation(1);
      paramView = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131371608);
      if (!jdField_a_of_type_Boolean) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMaxWidth((int)(this.jdField_b_of_type_Float * 224.0F + 0.5F));
      paramView.setMaxHeight((int)(this.jdField_b_of_type_Float * 224.0F + 0.5F));
      Object localObject = new LinearLayout.LayoutParams(-2, -2);
      int i = (int)(this.jdField_b_of_type_Float * 5.0F + 0.5F);
      ((LinearLayout.LayoutParams)localObject).leftMargin = i;
      ((LinearLayout.LayoutParams)localObject).topMargin = i;
      ((LinearLayout.LayoutParams)localObject).rightMargin = i;
      ((LinearLayout.LayoutParams)localObject).bottomMargin = i;
      paramacuj.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setTextColor(-16777216);
      ((TextView)localObject).setTextSize(2, 12.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      localLayoutParams.bottomMargin = i;
      paramacuj.addView((View)localObject, localLayoutParams);
      paramacuj.setOnClickListener(this);
      paramacuj.setOnTouchListener(paramacxj);
      paramacuj.setOnLongClickListener(paramacxj);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramChatMessage;
    if (!paramChatMessage.isSendFromLocal())
    {
      paramView = aywm.a(paramChatMessage, 1);
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
      {
        paramChatMessage = advs.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramChatMessage);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
      }
    }
    a(paramBaseChatItemLayout);
    return paramacuj;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ajya.a(2131700632);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131364984) {
      aanz.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    while (paramInt != 2131370536) {
      return;
    }
    super.d(paramChatMessage);
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = new bbmf();
    aanz.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    actj.n = true;
    if (super.a()) {}
    do
    {
      Object localObject;
      do
      {
        do
        {
          return;
          if (paramView.getId() != 2131364109) {
            break;
          }
          localObject = (adlf)actj.a(paramView);
          paramView = (MessageForPic)((adlf)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          localObject = ((adlf)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
        } while (paramView.isSendFromLocal());
        switch (((URLDrawable)localObject).getStatus())
        {
        default: 
          return;
        }
      } while (((URLDrawable)localObject).isDownloadStarted());
      ((URLDrawable)localObject).startDownload();
      return;
      ((URLDrawable)localObject).restartDownload();
      return;
      if (paramView.msgtype == -3001)
      {
        a(paramView);
        return;
      }
      if (paramView.msgtype == -3005)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.action, paramView.shareAppID, paramView.msgtype);
        return;
      }
    } while ((paramView.msgtype != -3000) && (paramView.msgtype != -3004) && (paramView.msgtype != -1032));
    ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.action, paramView.shareAppID, paramView.msgtype, null);
    return;
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adle
 * JD-Core Version:    0.7.0.1
 */