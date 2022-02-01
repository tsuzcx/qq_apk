import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ahdr
  extends BaseBubbleBuilder
  implements afqw, atfj
{
  protected atfh a;
  protected atfk a;
  protected atkn a;
  
  public ahdr(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bhjq a(bhjq parambhjq, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambhjq;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambhjq.a(2131365841, this.jdField_a_of_type_AndroidContentContext.getString(2131692486), 2130838987);
          break;
        case 3: 
          parambhjq.a(2131364260, this.jdField_a_of_type_AndroidContentContext.getString(2131697072), 2130838987);
          break;
        case 4: 
          parambhjq.a(2131372476, this.jdField_a_of_type_AndroidContentContext.getString(2131692488), 2130838995);
          break;
        case 5: 
          parambhjq.a(2131376611, this.jdField_a_of_type_AndroidContentContext.getString(2131692608), 2130838998);
          break;
        case 7: 
          parambhjq.a(2131372478, this.jdField_a_of_type_AndroidContentContext.getString(2131692488), 2130838995);
          break;
        case 8: 
          parambhjq.a(2131376612, this.jdField_a_of_type_AndroidContentContext.getString(2131692638), 2130838998);
          break;
        case 6: 
          parambhjq.a(2131364266, this.jdField_a_of_type_AndroidContentContext.getString(2131690755), 2130838980);
          break;
        case 9: 
          parambhjq.a(2131367213, this.jdField_a_of_type_AndroidContentContext.getString(2131692226), 2130838991);
          break;
        case 10: 
          a(paramChatMessage, parambhjq);
          break;
        case 12: 
          b(paramChatMessage, parambhjq);
          break;
        case 15: 
          a(parambhjq, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramChatMessage);
          break;
        case 20: 
          parambhjq.a(2131367241, this.jdField_a_of_type_AndroidContentContext.getString(2131692280), 2130838991);
          break;
        case 17: 
          a(parambhjq, paramChatMessage);
          break;
        case 18: 
          parambhjq.a(2131366456, this.jdField_a_of_type_AndroidContentContext.getString(2131692222), 2130838990);
          break;
        case 19: 
          e(parambhjq, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 21: 
          parambhjq.a(2131377034, this.jdField_a_of_type_AndroidContentContext.getString(2131692279), 2130838991);
          break;
        case 16: 
          super.c(parambhjq, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          b(parambhjq, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 14: 
          parambhjq.a(2131377030, this.jdField_a_of_type_AndroidContentContext.getString(2131697080), 2130838987);
          break;
        case 22: 
          parambhjq.a(2131378536, this.jdField_a_of_type_AndroidContentContext.getString(2131719252), 2130839003);
          break;
        case 11: 
          c(paramChatMessage, parambhjq);
          break;
        case 23: 
          parambhjq.a(2131377375, "StructMsg", 2130838991);
          break;
        case 24: 
          ApolloUtil.a(parambhjq, this.jdField_a_of_type_Atkn.a());
          break;
        case 25: 
          parambhjq.a(2131364781, anvx.a(2131703990), 2130838990);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public afqr a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aftk paramaftk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaftk);
    paramViewGroup = (afqr)AIOUtils.getHolder(paramView);
    this.jdField_a_of_type_Atkn.b(paramChatMessage);
    if (this.jdField_a_of_type_Atfk != null) {
      this.jdField_a_of_type_Atfk.a(paramViewGroup, paramView, this.jdField_a_of_type_Atkn.a());
    }
    if (this.jdField_a_of_type_Atfh != null)
    {
      this.jdField_a_of_type_Atfh.a(this);
      this.jdField_a_of_type_Atfh.a(paramViewGroup, paramView, this.jdField_a_of_type_Atkn.a());
    }
    return paramView;
  }
  
  protected abstract View a(afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk);
  
  public View a(ChatMessage paramChatMessage, afqr paramafqr, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aftk paramaftk)
  {
    this.jdField_a_of_type_Atkn.b(paramChatMessage);
    this.jdField_a_of_type_Atkn.b();
    paramView = a(paramafqr, paramView, paramBaseChatItemLayout, paramaftk);
    if ((paramafqr instanceof ahdt))
    {
      a((ahdt)paramafqr, paramBaseChatItemLayout, this.jdField_a_of_type_Atkn.c());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ((ahdt)paramafqr).d = super.a(((ahdt)paramafqr).d, paramafqr, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(((ahdt)paramafqr).d, paramBaseChatItemLayout, Integer.valueOf(2131379459), paramChatMessage, 2, Boolean.valueOf(false));
      }
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Atkn.b(), this);
    return paramView;
  }
  
  public bhjq a(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    this.jdField_a_of_type_Atkn.b(paramChatMessage);
    parambhjq = a(parambhjq, paramChatMessage, a(parambhjq, paramafrk));
    super.a(parambhjq, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, true);
    return parambhjq;
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((afrk)AIOUtils.getHolder(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Atkn.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bhjq parambhjq, afrk paramafrk);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Atkn.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(ahdt paramahdt, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramahdt.a != null) {
        paramahdt.a.setVisibility(8);
      }
      return;
    }
    if (paramahdt.a == null)
    {
      paramahdt.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramahdt.a.setId(2131379459);
      paramahdt.a.setBackgroundResource(2130842656);
      paramahdt.a.setTextSize(1, 12.0F);
      paramahdt.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167363));
      paramahdt.a.setText(this.jdField_a_of_type_Atkn.c());
      paramahdt.a.setSingleLine();
      paramahdt.a.setGravity(16);
      paramahdt.a.setPadding(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramahdt.a.setOnClickListener(new ahds(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364522);
      paramViewGroup.addView(paramahdt.a, localLayoutParams);
    }
    paramahdt.a.setVisibility(0);
    if (this.jdField_a_of_type_Atkn.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramahdt.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364522);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296388) + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramahdt.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramahdt.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364522);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296388) + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramahdt.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Atkn.b(paramView);
    this.jdField_a_of_type_Atkn.c();
  }
  
  public void a(atkn paramatkn)
  {
    this.jdField_a_of_type_Atkn = paramatkn;
    this.jdField_a_of_type_Atfk = this.jdField_a_of_type_Atkn.a();
    this.jdField_a_of_type_Atfh = this.jdField_a_of_type_Atkn.a();
  }
  
  protected void a(ChatMessage paramChatMessage, afqr paramafqr) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramafqr, paramInt1, paramInt2);
    a(paramChatMessage, paramafqr);
  }
  
  public bhjs[] a(View paramView)
  {
    paramView = a(paramView);
    bhjq localbhjq = new bhjq();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbhjq, paramView, null);
    }
    for (;;)
    {
      return localbhjq.a();
      label38:
      a(localbhjq, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract afqr b();
  
  public bhjq b(bhjq parambhjq, ChatMessage paramChatMessage, afrk paramafrk)
  {
    this.jdField_a_of_type_Atkn.b(paramChatMessage);
    return a(parambhjq, paramChatMessage, b(parambhjq, paramafrk));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bhjq parambhjq, afrk paramafrk);
  
  protected abstract void e(View paramView);
  
  public void h(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.isUserOperatedInAIO = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ChatMessage localChatMessage = a(paramView);
      this.jdField_a_of_type_Atkn.b(localChatMessage);
      e(paramView);
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdr
 * JD-Core Version:    0.7.0.1
 */