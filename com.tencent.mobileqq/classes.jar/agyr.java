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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.HashSet;

public class agyr
  extends BaseBubbleBuilder
{
  private final float jdField_b_of_type_Float;
  HashSet<String> jdField_b_of_type_JavaUtilHashSet = new HashSet();
  
  public agyr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_b_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private void a(agys paramagys)
  {
    if (paramagys.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.isMixed)
    {
      Object localObject = paramagys.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      if (((MessageForPic)localObject).msgtype == -1032)
      {
        paramagys.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
      }
      String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131719091);
      String str1;
      if (((MessageForPic)localObject).shareAppID != 0L)
      {
        localObject = bhki.a(((MessageForPic)localObject).shareAppID);
        AppShareID localAppShareID = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject);
        if (localAppShareID != null)
        {
          str1 = str2;
          if (localAppShareID.messagetail != null) {
            str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131690064) + localAppShareID.messagetail;
          }
        }
      }
      for (;;)
      {
        paramagys.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        paramagys.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
        return;
        str1 = str2;
        if (!this.jdField_b_of_type_JavaUtilHashSet.contains(localObject))
        {
          bcqj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject);
          this.jdField_b_of_type_JavaUtilHashSet.add(localObject);
          str1 = str2;
          continue;
          str1 = str2;
          if (((MessageForPic)localObject).msgtype == -3001) {
            str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131691906);
          }
        }
      }
    }
    paramagys.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
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
  
  public aggl a()
  {
    return new agys(this);
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    paramBaseChatItemLayout = (agys)paramaggl;
    paramaggl = paramView;
    if (paramView == null)
    {
      paramaggl = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      paramaggl.setOrientation(1);
      paramView = new ChatThumbView(this.jdField_a_of_type_AndroidContentContext);
      paramView.setId(2131372628);
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
      paramaggl.addView(paramView, (ViewGroup.LayoutParams)localObject);
      localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject).setTextColor(-16777216);
      ((TextView)localObject).setTextSize(2, 12.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = i;
      localLayoutParams.rightMargin = i;
      localLayoutParams.bottomMargin = i;
      paramaggl.addView((View)localObject, localLayoutParams);
      paramaggl.setOnClickListener(this);
      paramaggl.setOnTouchListener(paramagjk);
      paramaggl.setOnLongClickListener(paramagjk);
      paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView = paramView;
      paramBaseChatItemLayout.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
    }
    paramChatMessage = (MessageForPic)paramChatMessage;
    paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = paramChatMessage;
    if (!paramChatMessage.isSendFromLocal())
    {
      paramView = beyq.a(paramChatMessage, 1);
      if ((paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable == null) || (!paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable.getURL().equals(paramView)))
      {
        paramChatMessage = ahng.a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView.setImageDrawable(paramChatMessage);
        paramBaseChatItemLayout.jdField_a_of_type_ComTencentImageURLDrawable = paramChatMessage;
      }
    }
    a(paramBaseChatItemLayout);
    return paramaggl;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return anzj.a(2131699545);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365352) {
      aean.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    }
    while (paramInt != 2131371530) {
      return;
    }
    super.d(paramChatMessage);
  }
  
  public bhum[] a(View paramView)
  {
    paramView = new bhuk();
    aean.a(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.c(paramView, this.jdField_a_of_type_AndroidContentContext);
    super.e(paramView, this.jdField_a_of_type_AndroidContentContext);
    return paramView.a();
  }
  
  public void onClick(View paramView)
  {
    agej.n = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131364423)
      {
        Object localObject = (agys)agej.a(paramView);
        MessageForPic localMessageForPic = (MessageForPic)((agys)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        localObject = ((agys)localObject).jdField_a_of_type_ComTencentImageURLDrawable;
        if (!localMessageForPic.isSendFromLocal()) {
          switch (((URLDrawable)localObject).getStatus())
          {
          default: 
            break;
          case 0: 
            if (((URLDrawable)localObject).isDownloadStarted()) {
              continue;
            }
            ((URLDrawable)localObject).startDownload();
            break;
          case 2: 
            ((URLDrawable)localObject).restartDownload();
            break;
          case 1: 
            if (localMessageForPic.msgtype == -3001)
            {
              a(localMessageForPic);
              continue;
            }
            if (localMessageForPic.msgtype == -3005)
            {
              ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPic.action, localMessageForPic.shareAppID, localMessageForPic.msgtype);
              continue;
            }
            if ((localMessageForPic.msgtype != -3000) && (localMessageForPic.msgtype != -3004) && (localMessageForPic.msgtype != -1032)) {
              continue;
            }
            ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForPic.action, localMessageForPic.shareAppID, localMessageForPic.msgtype, null);
            break;
          }
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyr
 * JD-Core Version:    0.7.0.1
 */