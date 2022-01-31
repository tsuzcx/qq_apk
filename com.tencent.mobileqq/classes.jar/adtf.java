import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.qphone.base.util.QLog;

public abstract class adtf
  extends BaseBubbleBuilder
{
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  protected int h = 12303291;
  protected int i;
  
  public adtf(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.c = azvv.a(paramContext, 151.5F);
    this.d = azvv.a(paramContext, 125.5F);
    this.e = azvv.a(paramContext, 152.0F);
    this.f = azvv.a(this.jdField_a_of_type_AndroidContentContext, 14.0F);
    this.g = azvv.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.i = azvv.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopSign)paramChatMessage).getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131309376: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    aael.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
  }
  
  public void a(adtg paramadtg, BaseChatItemLayout paramBaseChatItemLayout)
  {
    MessageForTroopSign localMessageForTroopSign = (MessageForTroopSign)paramadtg.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Resources localResources;
    Object localObject1;
    TextView localTextView;
    Object localObject2;
    Drawable localDrawable;
    if (paramadtg.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
      paramadtg.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject1 = new FrameLayout.LayoutParams(-2, -2);
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setSingleLine(true);
      localTextView.setGravity(16);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setBackgroundResource(2130841999);
      paramadtg.jdField_a_of_type_AndroidWidgetFrameLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject1);
      paramadtg.e = localTextView;
      paramadtg.e.setText(localMessageForTroopSign.srcName);
      if (!TextUtils.isEmpty(localMessageForTroopSign.srcIconUrl))
      {
        localObject2 = localMessageForTroopSign.srcIconUrl;
        localDrawable = localResources.getDrawable(2130849111);
        localDrawable.setBounds(0, 0, aciy.a(12.0F, localResources), aciy.a(12.0F, localResources));
        localObject1 = new ColorDrawable(15790320);
        ((Drawable)localObject1).setBounds(0, 0, aciy.a(12.0F, localResources), aciy.a(12.0F, localResources));
      }
    }
    else
    {
      try
      {
        localObject2 = URLDrawable.getDrawable((String)localObject2, localDrawable, (Drawable)localObject1);
        if (axwd.a(this.jdField_a_of_type_AndroidContentContext)) {
          break label399;
        }
        bool = true;
        ((URLDrawable)localObject2).setAutoDownload(bool);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool;
          label296:
          if (QLog.isColorLevel()) {
            QLog.e("TroopSignItemBuilder", 2, "setSourceView exception" + localException.toString());
          }
        }
      }
      ((Drawable)localObject1).setBounds(0, 0, aciy.a(12.0F, localResources), aciy.a(12.0F, localResources));
      localTextView.setCompoundDrawablePadding(aciy.a(3.0F, localResources));
      localTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
      localTextView.setPadding(aciy.a(5.0F, localResources), 0, aciy.a(5.0F, localResources), 0);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131298552);
      ((RelativeLayout.LayoutParams)localObject1).addRule(5, 2131298552);
      paramBaseChatItemLayout.addView(paramadtg.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
      paramadtg.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(this);
      paramBaseChatItemLayout = (FrameLayout.LayoutParams)paramadtg.e.getLayoutParams();
      if (!localMessageForTroopSign.isSend()) {
        break label456;
      }
    }
    label399:
    label456:
    for (paramBaseChatItemLayout.leftMargin = BaseChatItemLayout.j;; paramBaseChatItemLayout.leftMargin = this.g)
    {
      paramadtg.e.setLayoutParams(paramBaseChatItemLayout);
      return;
      bool = false;
      break;
      localTextView.setCompoundDrawables(null, null, null, null);
      break label296;
    }
  }
  
  public void a(adtg paramadtg, MessageForTroopSign paramMessageForTroopSign)
  {
    boolean bool = paramMessageForTroopSign.isSend();
    if ((paramMessageForTroopSign.markType == 1) || (paramMessageForTroopSign.markType == 2)) {
      if (!TextUtils.isEmpty(paramMessageForTroopSign.markIconUrl))
      {
        Object localObject = new ColorDrawable(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = this.i;
        localURLDrawableOptions.mRequestHeight = this.i;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localObject = URLDrawable.getDrawable(paramMessageForTroopSign.markIconUrl, localURLDrawableOptions);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        paramadtg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      }
    }
    while (paramMessageForTroopSign.markType == 1)
    {
      paramadtg.jdField_d_of_type_AndroidViewView.setVisibility(4);
      paramadtg.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramadtg.b.setVisibility(4);
      a(paramadtg.jdField_c_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
      paramadtg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
      continue;
      paramadtg.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (paramMessageForTroopSign.markType == 2)
    {
      paramadtg.jdField_d_of_type_AndroidViewView.setVisibility(4);
      paramadtg.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramadtg.b.setVisibility(0);
      paramadtg.b.setText(paramMessageForTroopSign.markDesc);
      a(paramadtg.jdField_c_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
    }
    if (paramMessageForTroopSign.markType == 3)
    {
      paramadtg.jdField_d_of_type_AndroidViewView.setVisibility(0);
      paramadtg.jdField_c_of_type_AndroidViewView.setVisibility(4);
      paramadtg.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageForTroopSign.markWord);
      paramadtg.jdField_d_of_type_AndroidWidgetTextView.setText(paramMessageForTroopSign.markDesc);
      a(paramadtg.jdField_d_of_type_AndroidViewView, paramMessageForTroopSign.positonType, bool);
      return;
    }
    paramadtg.jdField_d_of_type_AndroidViewView.setVisibility(4);
    paramadtg.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    int j = this.f / 2;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (paramInt == 7)
    {
      localLayoutParams.topMargin = this.f;
      localLayoutParams.addRule(11, 0);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, -1);
      localLayoutParams.addRule(10, -1);
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.topMargin = j;
      localLayoutParams.addRule(11, -1);
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(14, 0);
      localLayoutParams.addRule(10, -1);
      if (paramBoolean) {
        localLayoutParams.rightMargin = (j + this.g);
      } else {
        localLayoutParams.rightMargin = j;
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(BaseChatItemLayout.j, BaseChatItemLayout.g, 0, BaseChatItemLayout.h);
      return;
    }
    paramView.setPadding(0, BaseChatItemLayout.g, BaseChatItemLayout.j, BaseChatItemLayout.h);
  }
  
  public bakj[] a(View paramView)
  {
    bakh localbakh = new bakh();
    paramView = (MessageForTroopSign)((ackl)aciy.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    super.a(paramView, localbakh);
    aael.a(localbakh, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    b(paramView, localbakh);
    super.d(localbakh, this.jdField_a_of_type_AndroidContentContext);
    return localbakh.a();
  }
  
  public void onClick(View paramView)
  {
    if (a()) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_AndroidContentContext instanceof MultiForwardActivity)) {
      return;
    }
    Object localObject1 = (adtg)aciy.a(paramView);
    Object localObject2 = (MessageForTroopSign)((adtg)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (paramView == ((adtg)localObject1).jdField_a_of_type_AndroidWidgetFrameLayout)
    {
      localObject2 = ((MessageForTroopSign)localObject2).srcAction;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_checkin", "", "entry", "clk_obj_graybar", 0, 0, "", "", "", "");
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label267;
      }
      QLog.d("TroopSignItemBuilder", 2, "onSrcClick actionURL:" + (String)localObject2);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          paramView = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
          paramView.putExtra("url", (String)localObject1);
          rtr.a(paramView, (String)localObject1);
          this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
          return;
        }
        catch (Exception paramView) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("TroopSignItemBuilder", 2, "onClick exp:", paramView);
        return;
        if (paramView != ((adtg)localObject1).jdField_a_of_type_AndroidViewView) {
          break label276;
        }
        localObject2 = ((MessageForTroopSign)localObject2).msgAction;
        awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_checkin", "", "entry", "clk_obj", 0, 0, "", "", "", "");
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("TroopSignItemBuilder", 2, "onContentClick actionURL:" + (String)localObject2);
          localObject1 = localObject2;
        }
        label267:
        continue;
      }
      super.onClick(paramView);
      return;
      label276:
      localObject1 = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adtf
 * JD-Core Version:    0.7.0.1
 */