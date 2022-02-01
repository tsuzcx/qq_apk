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

public abstract class ahoo
  extends BaseBubbleBuilder
  implements aggp, atou
{
  protected atos a;
  protected atov a;
  protected attx a;
  
  public ahoo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambhuk;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambhuk.a(2131365714, this.jdField_a_of_type_AndroidContentContext.getString(2131692336), 2130838935);
          break;
        case 3: 
          parambhuk.a(2131364162, this.jdField_a_of_type_AndroidContentContext.getString(2131696663), 2130838935);
          break;
        case 4: 
          parambhuk.a(2131372318, this.jdField_a_of_type_AndroidContentContext.getString(2131692338), 2130838942);
          break;
        case 5: 
          parambhuk.a(2131376590, this.jdField_a_of_type_AndroidContentContext.getString(2131692458), 2130838944);
          break;
        case 7: 
          parambhuk.a(2131372320, this.jdField_a_of_type_AndroidContentContext.getString(2131692338), 2130838942);
          break;
        case 8: 
          parambhuk.a(2131376591, this.jdField_a_of_type_AndroidContentContext.getString(2131692488), 2130838944);
          break;
        case 6: 
          parambhuk.a(2131364167, this.jdField_a_of_type_AndroidContentContext.getString(2131690638), 2130838928);
          break;
        case 9: 
          parambhuk.a(2131367078, this.jdField_a_of_type_AndroidContentContext.getString(2131692088), 2130838939);
          break;
        case 10: 
          a(paramChatMessage, parambhuk);
          break;
        case 12: 
          b(paramChatMessage, parambhuk);
          break;
        case 15: 
          a(parambhuk, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage);
          break;
        case 20: 
          parambhuk.a(2131367106, this.jdField_a_of_type_AndroidContentContext.getString(2131692142), 2130838939);
          break;
        case 17: 
          a(parambhuk, paramChatMessage);
          break;
        case 18: 
          parambhuk.a(2131366320, this.jdField_a_of_type_AndroidContentContext.getString(2131692084), 2130838938);
          break;
        case 19: 
          e(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 21: 
          parambhuk.a(2131377015, this.jdField_a_of_type_AndroidContentContext.getString(2131692141), 2130838939);
          break;
        case 16: 
          super.c(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          b(parambhuk, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 14: 
          parambhuk.a(2131377011, this.jdField_a_of_type_AndroidContentContext.getString(2131696671), 2130838935);
          break;
        case 22: 
          parambhuk.a(2131378480, this.jdField_a_of_type_AndroidContentContext.getString(2131718611), 2130838949);
          break;
        case 11: 
          c(paramChatMessage, parambhuk);
          break;
        case 23: 
          parambhuk.a(2131377338, "StructMsg", 2130838939);
          break;
        case 24: 
          ApolloUtil.a(parambhuk, this.jdField_a_of_type_Attx.a());
          break;
        case 25: 
          parambhuk.a(2131364665, anzj.a(2131703409), 2130838938);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aggl a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, agjk paramagjk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramagjk);
    paramViewGroup = (aggl)agej.a(paramView);
    this.jdField_a_of_type_Attx.b(paramChatMessage);
    if (this.jdField_a_of_type_Atov != null) {
      this.jdField_a_of_type_Atov.a(paramViewGroup, paramView, this.jdField_a_of_type_Attx.a());
    }
    if (this.jdField_a_of_type_Atos != null)
    {
      this.jdField_a_of_type_Atos.a(this);
      this.jdField_a_of_type_Atos.a(paramViewGroup, paramView, this.jdField_a_of_type_Attx.a());
    }
    return paramView;
  }
  
  protected abstract View a(aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk);
  
  public View a(ChatMessage paramChatMessage, aggl paramaggl, View paramView, BaseChatItemLayout paramBaseChatItemLayout, agjk paramagjk)
  {
    this.jdField_a_of_type_Attx.b(paramChatMessage);
    this.jdField_a_of_type_Attx.b();
    paramView = a(paramaggl, paramView, paramBaseChatItemLayout, paramagjk);
    if ((paramaggl instanceof ahoq))
    {
      a((ahoq)paramaggl, paramBaseChatItemLayout, this.jdField_a_of_type_Attx.c());
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ((ahoq)paramaggl).d = super.a(((ahoq)paramaggl).d, paramaggl, paramBaseChatItemLayout, paramChatMessage, -2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 21.0F));
        super.a(((ahoq)paramaggl).d, paramBaseChatItemLayout, Integer.valueOf(2131379394), paramChatMessage, 2, Boolean.valueOf(false));
      }
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Attx.b(), this);
    return paramView;
  }
  
  public bhuk a(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    this.jdField_a_of_type_Attx.b(paramChatMessage);
    parambhuk = a(parambhuk, paramChatMessage, a(parambhuk, paramaghd));
    super.a(parambhuk, this.jdField_a_of_type_AndroidContentContext, paramChatMessage, true);
    return parambhuk;
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((aghd)agej.a(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Attx.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bhuk parambhuk, aghd paramaghd);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Attx.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(ahoq paramahoq, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramahoq.a != null) {
        paramahoq.a.setVisibility(8);
      }
      return;
    }
    if (paramahoq.a == null)
    {
      paramahoq.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramahoq.a.setId(2131379394);
      paramahoq.a.setBackgroundResource(2130842581);
      paramahoq.a.setTextSize(1, 12.0F);
      paramahoq.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167302));
      paramahoq.a.setText(this.jdField_a_of_type_Attx.c());
      paramahoq.a.setSingleLine();
      paramahoq.a.setGravity(16);
      paramahoq.a.setPadding(bhgr.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramahoq.a.setOnClickListener(new ahop(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364423);
      paramViewGroup.addView(paramahoq.a, localLayoutParams);
    }
    paramahoq.a.setVisibility(0);
    if (this.jdField_a_of_type_Attx.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramahoq.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364423);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296335) + bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramahoq.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramahoq.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364423);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296335) + bhgr.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramahoq.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Attx.b(paramView);
    this.jdField_a_of_type_Attx.c();
  }
  
  public void a(attx paramattx)
  {
    this.jdField_a_of_type_Attx = paramattx;
    this.jdField_a_of_type_Atov = this.jdField_a_of_type_Attx.a();
    this.jdField_a_of_type_Atos = this.jdField_a_of_type_Attx.a();
  }
  
  protected void a(ChatMessage paramChatMessage, aggl paramaggl) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aggl paramaggl, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaggl, paramInt1, paramInt2);
    a(paramChatMessage, paramaggl);
  }
  
  public bhum[] a(View paramView)
  {
    paramView = a(paramView);
    bhuk localbhuk = new bhuk();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbhuk, paramView, null);
    }
    for (;;)
    {
      return localbhuk.a();
      label38:
      a(localbhuk, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract aggl b();
  
  public bhuk b(bhuk parambhuk, ChatMessage paramChatMessage, aghd paramaghd)
  {
    this.jdField_a_of_type_Attx.b(paramChatMessage);
    return a(parambhuk, paramChatMessage, b(parambhuk, paramaghd));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bhuk parambhuk, aghd paramaghd);
  
  protected abstract void e(View paramView);
  
  public void h(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    agej.n = true;
    if (super.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ChatMessage localChatMessage = a(paramView);
      this.jdField_a_of_type_Attx.b(localChatMessage);
      e(paramView);
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahoo
 * JD-Core Version:    0.7.0.1
 */