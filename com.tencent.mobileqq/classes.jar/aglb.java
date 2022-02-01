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

public abstract class aglb
  extends BaseBubbleBuilder
  implements aezk, asbd
{
  protected asbb a;
  protected asbe a;
  protected asgh a;
  
  public aglb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bgaz a(bgaz parambgaz, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambgaz;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambgaz.a(2131365747, this.jdField_a_of_type_AndroidContentContext.getString(2131692384), 2130838967);
          break;
        case 3: 
          parambgaz.a(2131364184, this.jdField_a_of_type_AndroidContentContext.getString(2131696804), 2130838967);
          break;
        case 4: 
          parambgaz.a(2131372284, this.jdField_a_of_type_AndroidContentContext.getString(2131692386), 2130838975);
          break;
        case 5: 
          parambgaz.a(2131376356, this.jdField_a_of_type_AndroidContentContext.getString(2131692506), 2130838978);
          break;
        case 7: 
          parambgaz.a(2131372286, this.jdField_a_of_type_AndroidContentContext.getString(2131692386), 2130838975);
          break;
        case 8: 
          parambgaz.a(2131376357, this.jdField_a_of_type_AndroidContentContext.getString(2131692536), 2130838978);
          break;
        case 6: 
          parambgaz.a(2131364189, this.jdField_a_of_type_AndroidContentContext.getString(2131690678), 2130838960);
          break;
        case 9: 
          parambgaz.a(2131367094, this.jdField_a_of_type_AndroidContentContext.getString(2131692136), 2130838971);
          break;
        case 10: 
          a(paramChatMessage, parambgaz);
          break;
        case 12: 
          b(paramChatMessage, parambgaz);
          break;
        case 15: 
          a(parambgaz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, paramChatMessage);
          break;
        case 20: 
          parambgaz.a(2131367122, this.jdField_a_of_type_AndroidContentContext.getString(2131692190), 2130838971);
          break;
        case 17: 
          a(parambgaz, paramChatMessage);
          break;
        case 18: 
          parambgaz.a(2131366347, this.jdField_a_of_type_AndroidContentContext.getString(2131692132), 2130838970);
          break;
        case 19: 
          e(parambgaz, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 21: 
          parambgaz.a(2131376765, this.jdField_a_of_type_AndroidContentContext.getString(2131692189), 2130838971);
          break;
        case 16: 
          super.c(parambgaz, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          b(parambgaz, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 14: 
          parambgaz.a(2131376761, this.jdField_a_of_type_AndroidContentContext.getString(2131696812), 2130838967);
          break;
        case 22: 
          parambgaz.a(2131378248, this.jdField_a_of_type_AndroidContentContext.getString(2131718859), 2130838983);
          break;
        case 11: 
          c(paramChatMessage, parambgaz);
          break;
        case 23: 
          parambgaz.a(2131377101, "StructMsg", 2130838971);
          break;
        case 24: 
          ApolloUtil.a(parambgaz, this.jdField_a_of_type_Asgh.a());
          break;
        case 25: 
          parambgaz.a(2131364696, amtj.a(2131703639), 2130838970);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aezf a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, afce paramafce)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramafce);
    paramViewGroup = (aezf)AIOUtils.getHolder(paramView);
    this.jdField_a_of_type_Asgh.b(paramChatMessage);
    if (this.jdField_a_of_type_Asbe != null) {
      this.jdField_a_of_type_Asbe.a(paramViewGroup, paramView, this.jdField_a_of_type_Asgh.a());
    }
    if (this.jdField_a_of_type_Asbb != null)
    {
      this.jdField_a_of_type_Asbb.a(this);
      this.jdField_a_of_type_Asbb.a(paramViewGroup, paramView, this.jdField_a_of_type_Asgh.a());
    }
    return paramView;
  }
  
  protected abstract View a(aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce);
  
  public View a(ChatMessage paramChatMessage, aezf paramaezf, View paramView, BaseChatItemLayout paramBaseChatItemLayout, afce paramafce)
  {
    this.jdField_a_of_type_Asgh.b(paramChatMessage);
    this.jdField_a_of_type_Asgh.b();
    paramView = a(paramaezf, paramView, paramBaseChatItemLayout, paramafce);
    if ((paramaezf instanceof agld))
    {
      a((agld)paramaezf, paramBaseChatItemLayout, this.jdField_a_of_type_Asgh.c());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ((agld)paramaezf).d = super.a(((agld)paramaezf).d, paramaezf, paramBaseChatItemLayout, paramChatMessage, -2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(((agld)paramaezf).d, paramBaseChatItemLayout, Integer.valueOf(2131379164), paramChatMessage, 2, Boolean.valueOf(false));
      }
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Asgh.b(), this);
    return paramView;
  }
  
  public bgaz a(bgaz parambgaz, ChatMessage paramChatMessage, aezy paramaezy)
  {
    this.jdField_a_of_type_Asgh.b(paramChatMessage);
    parambgaz = a(parambgaz, paramChatMessage, a(parambgaz, paramaezy));
    super.a(parambgaz, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, true);
    return parambgaz;
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((aezy)AIOUtils.getHolder(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Asgh.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bgaz parambgaz, aezy paramaezy);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Asgh.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(agld paramagld, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramagld.a != null) {
        paramagld.a.setVisibility(8);
      }
      return;
    }
    if (paramagld.a == null)
    {
      paramagld.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramagld.a.setId(2131379164);
      paramagld.a.setBackgroundResource(2130842626);
      paramagld.a.setTextSize(1, 12.0F);
      paramagld.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167337));
      paramagld.a.setText(this.jdField_a_of_type_Asgh.c());
      paramagld.a.setSingleLine();
      paramagld.a.setGravity(16);
      paramagld.a.setPadding(DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramagld.a.setOnClickListener(new aglc(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364441);
      paramViewGroup.addView(paramagld.a, localLayoutParams);
    }
    paramagld.a.setVisibility(0);
    if (this.jdField_a_of_type_Asgh.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramagld.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364441);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296388) + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramagld.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramagld.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364441);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296388) + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramagld.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Asgh.b(paramView);
    this.jdField_a_of_type_Asgh.c();
  }
  
  public void a(asgh paramasgh)
  {
    this.jdField_a_of_type_Asgh = paramasgh;
    this.jdField_a_of_type_Asbe = this.jdField_a_of_type_Asgh.a();
    this.jdField_a_of_type_Asbb = this.jdField_a_of_type_Asgh.a();
  }
  
  protected void a(ChatMessage paramChatMessage, aezf paramaezf) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaezf, paramInt1, paramInt2);
    a(paramChatMessage, paramaezf);
  }
  
  public bgbb[] a(View paramView)
  {
    paramView = a(paramView);
    bgaz localbgaz = new bgaz();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbgaz, paramView, null);
    }
    for (;;)
    {
      return localbgaz.a();
      label38:
      a(localbgaz, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract aezf b();
  
  public bgaz b(bgaz parambgaz, ChatMessage paramChatMessage, aezy paramaezy)
  {
    this.jdField_a_of_type_Asgh.b(paramChatMessage);
    return a(parambgaz, paramChatMessage, b(parambgaz, paramaezy));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bgaz parambgaz, aezy paramaezy);
  
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
      this.jdField_a_of_type_Asgh.b(localChatMessage);
      e(paramView);
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglb
 * JD-Core Version:    0.7.0.1
 */