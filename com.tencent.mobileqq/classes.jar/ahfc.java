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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ahfc
  extends BaseBubbleBuilder
  implements afwv, asyq
{
  protected asyo a;
  protected asyr a;
  protected atcc a;
  
  public ahfc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bguh a(bguh parambguh, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambguh;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambguh.a(2131365671, this.jdField_a_of_type_AndroidContentContext.getString(2131692331), 2130838925);
          break;
        case 3: 
          parambguh.a(2131364121, this.jdField_a_of_type_AndroidContentContext.getString(2131696614), 2130838925);
          break;
        case 4: 
          parambguh.a(2131372204, this.jdField_a_of_type_AndroidContentContext.getString(2131692333), 2130838932);
          break;
        case 5: 
          parambguh.a(2131376458, this.jdField_a_of_type_AndroidContentContext.getString(2131692452), 2130838934);
          break;
        case 7: 
          parambguh.a(2131372206, this.jdField_a_of_type_AndroidContentContext.getString(2131692333), 2130838932);
          break;
        case 8: 
          parambguh.a(2131376459, this.jdField_a_of_type_AndroidContentContext.getString(2131692482), 2130838934);
          break;
        case 6: 
          parambguh.a(2131364126, this.jdField_a_of_type_AndroidContentContext.getString(2131690640), 2130838918);
          break;
        case 9: 
          parambguh.a(2131367027, this.jdField_a_of_type_AndroidContentContext.getString(2131692083), 2130838929);
          break;
        case 10: 
          a(paramChatMessage, parambguh);
          break;
        case 11: 
          b(paramChatMessage, parambguh);
          break;
        case 14: 
          a(parambguh, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage);
          break;
        case 19: 
          parambguh.a(2131367055, this.jdField_a_of_type_AndroidContentContext.getString(2131692137), 2130838929);
          break;
        case 16: 
          a(parambguh, paramChatMessage);
          break;
        case 17: 
          parambguh.a(2131366271, this.jdField_a_of_type_AndroidContentContext.getString(2131692079), 2130838928);
          break;
        case 18: 
          e(parambguh, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 20: 
          parambguh.a(2131376876, this.jdField_a_of_type_AndroidContentContext.getString(2131692136), 2130838929);
          break;
        case 15: 
          super.c(parambguh, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 12: 
          b(parambguh, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          parambguh.a(2131376872, this.jdField_a_of_type_AndroidContentContext.getString(2131696622), 2130838925);
          break;
        case 21: 
          parambguh.a(2131378323, this.jdField_a_of_type_AndroidContentContext.getString(2131718475), 2130838940);
          break;
        case 22: 
          parambguh.a(2131377198, "StructMsg", 2130838929);
          break;
        case 23: 
          ApolloUtil.a(parambguh, this.jdField_a_of_type_Atcc.a());
          break;
        case 24: 
          parambguh.a(2131364620, anni.a(2131703302), 2130838928);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afwr a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afzq paramafzq)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafzq);
    paramViewGroup = (afwr)afur.a(paramView);
    this.jdField_a_of_type_Atcc.b(paramChatMessage);
    if (this.jdField_a_of_type_Asyr != null) {
      this.jdField_a_of_type_Asyr.a(paramViewGroup, paramView, this.jdField_a_of_type_Atcc.a());
    }
    if (this.jdField_a_of_type_Asyo != null)
    {
      this.jdField_a_of_type_Asyo.a(this);
      this.jdField_a_of_type_Asyo.a(paramViewGroup, paramView, this.jdField_a_of_type_Atcc.a());
    }
    return paramView;
  }
  
  protected abstract View a(afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq);
  
  public View a(ChatMessage paramChatMessage, afwr paramafwr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afzq paramafzq)
  {
    this.jdField_a_of_type_Atcc.b(paramChatMessage);
    this.jdField_a_of_type_Atcc.b();
    paramChatMessage = a(paramafwr, paramView, paramBaseChatItemLayout, paramafzq);
    if ((paramafwr instanceof ahfe)) {
      a((ahfe)paramafwr, paramBaseChatItemLayout, this.jdField_a_of_type_Atcc.c());
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Atcc.b(), this);
    return paramChatMessage;
  }
  
  public bguh a(bguh parambguh, ChatMessage paramChatMessage, afxj paramafxj)
  {
    this.jdField_a_of_type_Atcc.b(paramChatMessage);
    parambguh = a(parambguh, paramChatMessage, a(parambguh, paramafxj));
    super.a(parambguh, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, true);
    return parambguh;
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((afxj)afur.a(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Atcc.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bguh parambguh, afxj paramafxj);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Atcc.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(ahfe paramahfe, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramahfe.a != null) {
        paramahfe.a.setVisibility(8);
      }
      return;
    }
    if (paramahfe.a == null)
    {
      paramahfe.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramahfe.a.setBackgroundResource(2130842568);
      paramahfe.a.setTextSize(1, 12.0F);
      paramahfe.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167279));
      paramahfe.a.setText(this.jdField_a_of_type_Atcc.c());
      paramahfe.a.setSingleLine();
      paramahfe.a.setGravity(16);
      paramahfe.a.setPadding(bggq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, bggq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramahfe.a.setOnClickListener(new ahfd(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364379);
      paramViewGroup.addView(paramahfe.a, localLayoutParams);
    }
    paramahfe.a.setVisibility(0);
    if (this.jdField_a_of_type_Atcc.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramahfe.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364379);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296331) + bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramahfe.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramahfe.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364379);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296331) + bggq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramahfe.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Atcc.b(paramView);
    this.jdField_a_of_type_Atcc.c();
  }
  
  public void a(atcc paramatcc)
  {
    this.jdField_a_of_type_Atcc = paramatcc;
    this.jdField_a_of_type_Asyr = this.jdField_a_of_type_Atcc.a();
    this.jdField_a_of_type_Asyo = this.jdField_a_of_type_Atcc.a();
  }
  
  protected void a(ChatMessage paramChatMessage, afwr paramafwr) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afwr paramafwr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafwr, paramInt1, paramInt2);
    a(paramChatMessage, paramafwr);
  }
  
  public bguj[] a(View paramView)
  {
    paramView = a(paramView);
    bguh localbguh = new bguh();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbguh, paramView, null);
    }
    for (;;)
    {
      return localbguh.a();
      label38:
      a(localbguh, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract afwr b();
  
  public bguh b(bguh parambguh, ChatMessage paramChatMessage, afxj paramafxj)
  {
    this.jdField_a_of_type_Atcc.b(paramChatMessage);
    return a(parambguh, paramChatMessage, b(parambguh, paramafxj));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bguh parambguh, afxj paramafxj);
  
  protected abstract void e(View paramView);
  
  public void h(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    afur.n = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ChatMessage localChatMessage = a(paramView);
      this.jdField_a_of_type_Atcc.b(localChatMessage);
      e(paramView);
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfc
 * JD-Core Version:    0.7.0.1
 */