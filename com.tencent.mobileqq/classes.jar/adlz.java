import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class adlz
  extends BaseBubbleBuilder
  implements acjx, aodj
{
  protected aodh a;
  protected aodk a;
  protected aohs a;
  
  public adlz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bakh a(bakh parambakh, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambakh;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambakh.a(2131299781, this.jdField_a_of_type_AndroidContentContext.getString(2131627045), 2130838595);
          break;
        case 3: 
          parambakh.a(2131298305, this.jdField_a_of_type_AndroidContentContext.getString(2131631880), 2130838595);
          break;
        case 4: 
          parambakh.a(2131305601, this.jdField_a_of_type_AndroidContentContext.getString(2131627047), 2130838602);
          break;
        case 5: 
          parambakh.a(2131309448, this.jdField_a_of_type_AndroidContentContext.getString(2131627204), 2130838604);
          break;
        case 7: 
          parambakh.a(2131305603, this.jdField_a_of_type_AndroidContentContext.getString(2131627047), 2130838602);
          break;
        case 8: 
          parambakh.a(2131309449, this.jdField_a_of_type_AndroidContentContext.getString(2131627233), 2130838604);
          break;
        case 6: 
          parambakh.a(2131298310, this.jdField_a_of_type_AndroidContentContext.getString(2131625146), 2130838588);
          break;
        case 9: 
          parambakh.a(2131301021, this.jdField_a_of_type_AndroidContentContext.getString(2131626819), 2130838599);
          break;
        case 10: 
          a(paramChatMessage, parambakh);
          break;
        case 11: 
          b(paramChatMessage, parambakh);
          break;
        case 14: 
          a(parambakh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage);
          break;
        case 19: 
          parambakh.a(2131301048, this.jdField_a_of_type_AndroidContentContext.getString(2131626860), 2130838599);
          break;
        case 16: 
          a(parambakh, paramChatMessage);
          break;
        case 17: 
          parambakh.a(2131300328, this.jdField_a_of_type_AndroidContentContext.getString(2131626815), 2130838598);
          break;
        case 18: 
          d(parambakh, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 20: 
          parambakh.a(2131309812, this.jdField_a_of_type_AndroidContentContext.getString(2131626859), 2130838599);
          break;
        case 15: 
          super.c(parambakh, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 12: 
          b(parambakh, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          parambakh.a(2131309808, this.jdField_a_of_type_AndroidContentContext.getString(2131631888), 2130838595);
          break;
        case 21: 
          parambakh.a(2131311102, this.jdField_a_of_type_AndroidContentContext.getString(2131654231), 2130838610);
          break;
        case 22: 
          parambakh.a(2131310090, "StructMsg", 2130838599);
          break;
        case 23: 
          ApolloUtil.a(parambakh, this.jdField_a_of_type_Aohs.a());
          break;
        case 24: 
          parambakh.a(2131298783, ajjy.a(2131638725), 2130838598);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acju a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acmv paramacmv)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacmv);
    paramViewGroup = (acju)aciy.a(paramView);
    this.jdField_a_of_type_Aohs.b(paramChatMessage);
    if (this.jdField_a_of_type_Aodk != null) {
      this.jdField_a_of_type_Aodk.a(paramViewGroup, paramView, this.jdField_a_of_type_Aohs.a());
    }
    if (this.jdField_a_of_type_Aodh != null)
    {
      this.jdField_a_of_type_Aodh.a(this);
      this.jdField_a_of_type_Aodh.a(paramViewGroup, paramView, this.jdField_a_of_type_Aohs.a());
    }
    return paramView;
  }
  
  protected abstract View a(acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv);
  
  public View a(ChatMessage paramChatMessage, acju paramacju, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acmv paramacmv)
  {
    this.jdField_a_of_type_Aohs.b(paramChatMessage);
    this.jdField_a_of_type_Aohs.b();
    paramChatMessage = a(paramacju, paramView, paramBaseChatItemLayout, paramacmv);
    if ((paramacju instanceof admb)) {
      a((admb)paramacju, paramBaseChatItemLayout, this.jdField_a_of_type_Aohs.c());
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Aohs.b(), this);
    return paramChatMessage;
  }
  
  public bakh a(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    this.jdField_a_of_type_Aohs.b(paramChatMessage);
    return a(parambakh, paramChatMessage, a(parambakh, paramackl));
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((ackl)aciy.a(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aohs.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bakh parambakh, ackl paramackl);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aohs.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(admb paramadmb, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramadmb.a != null) {
        paramadmb.a.setVisibility(8);
      }
      return;
    }
    if (paramadmb.a == null)
    {
      paramadmb.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramadmb.a.setBackgroundResource(2130841999);
      paramadmb.a.setTextSize(1, 12.0F);
      paramadmb.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101537));
      paramadmb.a.setText(this.jdField_a_of_type_Aohs.c());
      paramadmb.a.setSingleLine();
      paramadmb.a.setGravity(16);
      paramadmb.a.setPadding(azvv.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, azvv.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramadmb.a.setOnClickListener(new adma(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131298552);
      paramViewGroup.addView(paramadmb.a, localLayoutParams);
    }
    paramadmb.a.setVisibility(0);
    if (this.jdField_a_of_type_Aohs.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramadmb.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131298552);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165219) + azvv.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramadmb.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramadmb.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131298552);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131165219) + azvv.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramadmb.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Aohs.b(paramView);
    this.jdField_a_of_type_Aohs.c();
  }
  
  public void a(aohs paramaohs)
  {
    this.jdField_a_of_type_Aohs = paramaohs;
    this.jdField_a_of_type_Aodk = this.jdField_a_of_type_Aohs.a();
    this.jdField_a_of_type_Aodh = this.jdField_a_of_type_Aohs.a();
  }
  
  protected void a(ChatMessage paramChatMessage, acju paramacju) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acju paramacju, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacju, paramInt1, paramInt2);
    a(paramChatMessage, paramacju);
  }
  
  public bakj[] a(View paramView)
  {
    paramView = a(paramView);
    bakh localbakh = new bakh();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbakh, paramView, null);
    }
    for (;;)
    {
      return localbakh.a();
      label38:
      a(localbakh, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract acju b();
  
  public bakh b(bakh parambakh, ChatMessage paramChatMessage, ackl paramackl)
  {
    this.jdField_a_of_type_Aohs.b(paramChatMessage);
    return a(parambakh, paramChatMessage, b(parambakh, paramackl));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bakh parambakh, ackl paramackl);
  
  protected abstract void d(View paramView);
  
  public void g(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    aciy.n = true;
    if (super.a()) {
      return;
    }
    ChatMessage localChatMessage = a(paramView);
    this.jdField_a_of_type_Aohs.b(localChatMessage);
    d(paramView);
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adlz
 * JD-Core Version:    0.7.0.1
 */