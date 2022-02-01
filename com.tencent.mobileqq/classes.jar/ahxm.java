import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.WriteTogetherItemBuilder.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.jetbrains.annotations.NotNull;

public class ahxm
  extends ahtp
{
  private boolean f;
  private boolean g;
  
  public ahxm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    a(paramQQAppInterface);
  }
  
  private int a(String paramString, Context paramContext)
  {
    int i = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 55.0F);
    int j = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    int k = paramContext.getResources().getDimensionPixelOffset(2131299132);
    int m = paramContext.getResources().getDimensionPixelOffset(2131299132);
    paramContext = new Paint();
    paramContext.setColor(-1);
    paramContext.setTextSize(bhtq.d(12.0F));
    return i + j + k + (int)paramContext.measureText(paramString) + m;
  }
  
  private View a(Context paramContext, View paramView, MessageRecord paramMessageRecord, String paramString, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
      paramView.setBackgroundResource(2130838391);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setEnabled(paramBoolean);
      localTextView.setText(paramString);
      localTextView.setId(2131364451);
      int i = paramContext.getResources().getDimensionPixelOffset(2131299132);
      int j = paramContext.getResources().getDimensionPixelOffset(2131299133);
      localTextView.setPadding(i, j, i, j);
      paramView.setTag(paramMessageRecord);
      paramView.setOnClickListener(paramOnClickListener);
      return paramView;
    }
  }
  
  @NotNull
  private RelativeLayout a(BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    RelativeLayout localRelativeLayout = paramRelativeLayout;
    if (paramRelativeLayout == null)
    {
      localRelativeLayout = new RelativeLayout(paramBaseChatItemLayout.getContext());
      localRelativeLayout.setId(2131381461);
      localRelativeLayout.setVisibility(8);
      paramBaseChatItemLayout.addView(localRelativeLayout, new RelativeLayout.LayoutParams(-2, -2));
    }
    return localRelativeLayout;
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage, RelativeLayout paramRelativeLayout)
  {
    if ((paramContext == null) || (paramChatMessage == null) || (paramRelativeLayout == null)) {}
    label195:
    for (;;)
    {
      return;
      MessageForWriteTogether localMessageForWriteTogether = (MessageForWriteTogether)paramChatMessage;
      View localView = paramRelativeLayout.getChildAt(0);
      String str;
      if (localView == null) {
        if (localMessageForWriteTogether.partCnt <= 2)
        {
          str = "";
          paramContext = a(paramContext, localView, paramChatMessage, str + "一起写", true, new ahxo(this));
          paramRelativeLayout.addView(paramContext);
        }
      }
      for (;;)
      {
        if (!(paramContext instanceof TextView)) {
          break label195;
        }
        paramRelativeLayout = new StringBuilder();
        if (localMessageForWriteTogether.partCnt <= 0) {}
        for (paramChatMessage = "";; paramChatMessage = localMessageForWriteTogether.partCnt + "人")
        {
          paramChatMessage = paramChatMessage + "一起写";
          ((TextView)paramContext).setText(paramChatMessage);
          return;
          str = localMessageForWriteTogether.partCnt + "人";
          break;
        }
        paramContext = localView;
      }
    }
  }
  
  private void a(Context paramContext, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    if (!(paramChatMessage instanceof MessageForWriteTogether)) {}
    do
    {
      do
      {
        return;
      } while (paramBaseChatItemLayout == null);
      paramRelativeLayout = a(paramBaseChatItemLayout, paramRelativeLayout);
    } while (paramRelativeLayout == null);
    a(paramChatMessage, paramBaseChatItemLayout, paramRelativeLayout);
    a(paramContext, paramChatMessage, paramRelativeLayout);
    paramBaseChatItemLayout.requestLayout();
  }
  
  private void a(View paramView, RelativeLayout paramRelativeLayout)
  {
    if ((paramView == null) || (paramRelativeLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView.setVisibility(8);
      paramRelativeLayout.setVisibility(8);
      return;
    }
    a(localLayoutParams);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296335);
    int j = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    localLayoutParams.addRule(7, 2131364423);
    localLayoutParams.addRule(3, 2131364423);
    localLayoutParams.topMargin = -4;
    localLayoutParams.rightMargin = (i + j + bhgr.a(this.jdField_a_of_type_AndroidContentContext, 3.0F));
    paramView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView.setVisibility(8);
      paramRelativeLayout.setVisibility(8);
      return;
    }
    a(localLayoutParams);
    localLayoutParams.rightMargin = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
    localLayoutParams.addRule(3, 2131364423);
    localLayoutParams.addRule(0, 2131379384);
    localLayoutParams.addRule(1, 0);
    paramRelativeLayout.setLayoutParams(localLayoutParams);
    paramRelativeLayout.setVisibility(0);
    paramView.setVisibility(0);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ahxn(this);
    this.jdField_a_of_type_Biuy = new ahxp(this, paramQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(ChatMessage paramChatMessage, ahtx paramahtx)
  {
    RelativeLayout localRelativeLayout;
    if ((paramahtx.jdField_a_of_type_AndroidViewView != null) && (paramahtx.c != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      localRelativeLayout = (RelativeLayout)paramahtx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.findViewById(2131381461);
      localRelativeLayout = a(paramahtx.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localRelativeLayout);
      if (localRelativeLayout != null) {}
    }
    else
    {
      return;
    }
    a(this.jdField_a_of_type_AndroidContentContext, paramChatMessage, localRelativeLayout);
    int j = a("1000人一起写", this.jdField_a_of_type_AndroidContentContext);
    Object localObject = localRelativeLayout.getChildAt(0);
    int i = j;
    if ((localObject instanceof TextView))
    {
      localObject = ((TextView)localObject).getText().toString();
      i = j;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = j;
        if (this.jdField_a_of_type_AndroidContentContext != null) {
          i = a((String)localObject, this.jdField_a_of_type_AndroidContentContext);
        }
      }
    }
    paramahtx.jdField_a_of_type_AndroidViewView.post(new WriteTogetherItemBuilder.2(this, paramahtx, i, paramChatMessage, localRelativeLayout, paramChatMessage));
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, RelativeLayout paramRelativeLayout)
  {
    if ((paramChatMessage == null) || (paramBaseChatItemLayout == null) || (paramRelativeLayout == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)paramRelativeLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    }
    paramBaseChatItemLayout = paramBaseChatItemLayout.getResources();
    localLayoutParams1.topMargin = agej.a(-2.0F, paramBaseChatItemLayout);
    localLayoutParams1.addRule(5, 2131364423);
    localLayoutParams1.addRule(3, 2131364423);
    int i;
    if (!paramChatMessage.isSend())
    {
      i = 1;
      if (i == 0) {
        break label122;
      }
    }
    label122:
    for (localLayoutParams1.leftMargin = agej.a(11.0F, paramBaseChatItemLayout);; localLayoutParams1.leftMargin = agej.a(9.0F, paramBaseChatItemLayout))
    {
      paramRelativeLayout.setLayoutParams(localLayoutParams1);
      paramRelativeLayout.setVisibility(0);
      return;
      i = 0;
      break;
    }
  }
  
  private void b(ChatMessage paramChatMessage, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if (localObject != null) {
        break label36;
      }
      QLog.e("WriteTogetherItemBuilder", 1, "[launchWriteTogether] ChatFragment is null");
    }
    label36:
    do
    {
      do
      {
        return;
        localObject = ((ChatFragment)localObject).a();
      } while (localObject == null);
      localObject = (bemp)((BaseChatPie)localObject).a(74);
    } while ((localObject == null) || (!(paramChatMessage instanceof MessageForWriteTogether)));
    ((bemp)localObject).a(((MessageForWriteTogether)paramChatMessage).padId, paramInt);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return super.a(paramChatMessage);
  }
  
  public aggl a()
  {
    return super.a();
  }
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = (MessageForWriteTogether)paramChatMessage;
      localObject3 = new StringBuilder().append("[getBubbleView] cvtView: ");
      if (paramView != null) {
        break label78;
      }
    }
    label78:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramView.hashCode()))
    {
      QLog.d("WriteTogetherItemBuilder", 2, localObject1 + ", isLong: " + ((MessageForWriteTogether)localObject2).isLongMsg);
      if ((paramChatMessage instanceof MessageForWriteTogether)) {
        break;
      }
      paramView = null;
      return paramView;
    }
    Object localObject4 = paramBaseChatItemLayout.getContext();
    Object localObject2 = (ahtx)paramaggl;
    Object localObject3 = (MessageForWriteTogether)paramChatMessage;
    ((MessageForWriteTogether)localObject3).parse();
    label140:
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      bool = bfuv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, (String)localObject1);
      if ((!bool) || (((MessageForWriteTogether)localObject3).isLongMsg))
      {
        localObject1 = ((ahtx)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
        a((Context)localObject4, paramChatMessage, (BaseChatItemLayout)localObject1, (RelativeLayout)((BaseChatItemLayout)localObject1).findViewById(2131381461));
      }
      if (((MessageForWriteTogether)localObject3).isLongMsg) {
        break label329;
      }
      if (!(paramView instanceof TextView)) {
        break label314;
      }
    }
    label314:
    for (paramaggl = super.a(paramChatMessage, paramaggl, paramView, paramBaseChatItemLayout, paramagjk);; paramaggl = super.a(paramChatMessage, paramaggl, null, paramBaseChatItemLayout, paramagjk))
    {
      if (((ahtx)localObject2).d != null) {
        ((ahtx)localObject2).d.setPadding(0, 0, 0, 0);
      }
      paramView = paramaggl;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
      ((ahtx)localObject2).c = super.a(((ahtx)localObject2).c, (aggl)localObject2, ((ahtx)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
      paramView = paramaggl;
      if (((ahtx)localObject2).c == null) {
        break;
      }
      paramView = paramaggl;
      if (!bool) {
        break;
      }
      a(paramChatMessage, (ahtx)localObject2);
      return paramaggl;
      localObject1 = "";
      break label140;
    }
    label329:
    if (paramView != null)
    {
      paramaggl = paramView;
      if (!(paramView instanceof TextView)) {}
    }
    else
    {
      paramView = ((Context)localObject4).getResources();
      paramaggl = (RelativeLayout)LayoutInflater.from((Context)localObject4).inflate(2131563129, null);
      localObject1 = new RelativeLayout.LayoutParams(BaseChatItemLayout.e, -2);
      int i = paramView.getDimensionPixelSize(2131298911);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(i, 0, i, 0);
      paramaggl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView = (LinearLayout)paramaggl.findViewById(2131381459);
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(BaseChatItemLayout.f, -2));
      paramView.setOrientation(1);
      paramView = paramaggl.findViewById(2131381509);
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = BaseChatItemLayout.f;
      ((ViewGroup.LayoutParams)localObject1).height = ((Context)localObject4).getResources().getDimensionPixelSize(2131299121);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView = (TextView)paramaggl.findViewById(2131381462);
      paramView.setTextColor(-16777216);
      behh.a(paramView);
      ((ahtx)localObject2).d = paramView;
    }
    localObject4 = paramaggl.findViewById(2131381459);
    paramView = (TextView)paramaggl.findViewById(2131381462);
    localObject1 = (TextView)paramaggl.findViewById(2131381460);
    if (!TextUtils.isEmpty(((MessageForWriteTogether)localObject3).sb)) {
      if (!TextUtils.isEmpty(((MessageForWriteTogether)localObject3).sb2)) {
        ((ahtx)localObject2).d.setText(((MessageForWriteTogether)localObject3).sb2);
      }
    }
    for (;;)
    {
      ((View)localObject4).setOnTouchListener(paramagjk);
      ((View)localObject4).setOnLongClickListener(paramagjk);
      ((TextView)localObject1).setClickable(false);
      ((View)localObject4).setTag(localObject3);
      ((View)localObject4).setOnClickListener(this);
      ((View)localObject4).setClickable(false);
      ((View)localObject4).setVisibility(0);
      paramagjk = go.a(paramChatMessage);
      paramView.setTypeface(paramagjk);
      ((TextView)localObject1).setTypeface(paramagjk);
      ((TextView)localObject1).setTextColor(paramView.getTextColors());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ((ahtx)localObject2).c = super.a(((ahtx)localObject2).c, (aggl)localObject2, ((ahtx)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(((ahtx)localObject2).c, paramBaseChatItemLayout, Integer.valueOf(2131381459), paramChatMessage, -4, Boolean.valueOf(true));
      }
      return paramaggl;
      ((ahtx)localObject2).d.setText(((MessageForWriteTogether)localObject3).sb);
      continue;
      paramView.setText(((MessageForWriteTogether)localObject3).msg);
    }
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return super.a(paramChatMessage);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131381511)
    {
      b(paramChatMessage, 8);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    MessageForWriteTogether localMessageForWriteTogether = (MessageForWriteTogether)paramChatMessage;
    if ((localMessageForWriteTogether.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (localMessageForWriteTogether.getExtInfoFromExtStr("long_text_recv_state").equals("3"))) {
      return;
    }
    super.a(paramView, paramChatMessage);
  }
  
  public void a(Integer paramInteger, MessageRecord paramMessageRecord, Boolean paramBoolean, RelativeLayout.LayoutParams paramLayoutParams, ViewGroup paramViewGroup)
  {
    if (paramInteger != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramViewGroup.findViewById(paramInteger.intValue()).getLayoutParams();
      localLayoutParams.rightMargin = 0;
      localLayoutParams.addRule(0, 0);
    }
    super.a(paramInteger, paramMessageRecord, paramBoolean, paramLayoutParams, paramViewGroup);
  }
  
  protected boolean d()
  {
    return super.d();
  }
  
  public void onClick(View paramView)
  {
    ChatMessage localChatMessage = agej.a(paramView);
    if (paramView.getId() == 2131381459) {
      b(localChatMessage, 6);
    }
    for (;;)
    {
      super.onClick(paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131381461) {
        b(localChatMessage, 5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxm
 * JD-Core Version:    0.7.0.1
 */