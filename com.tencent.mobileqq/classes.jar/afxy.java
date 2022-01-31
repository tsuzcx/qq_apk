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

public abstract class afxy
  extends BaseBubbleBuilder
  implements aeql, aqro
{
  protected aqrm a;
  protected aqrp a;
  protected aqvx a;
  
  public afxy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambdpi;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambdpi.a(2131365434, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838674);
          break;
        case 3: 
          parambdpi.a(2131363918, this.jdField_a_of_type_AndroidContentContext.getString(2131697772), 2130838674);
          break;
        case 4: 
          parambdpi.a(2131371631, this.jdField_a_of_type_AndroidContentContext.getString(2131692766), 2130838681);
          break;
        case 5: 
          parambdpi.a(2131375731, this.jdField_a_of_type_AndroidContentContext.getString(2131692927), 2130838683);
          break;
        case 7: 
          parambdpi.a(2131371633, this.jdField_a_of_type_AndroidContentContext.getString(2131692766), 2130838681);
          break;
        case 8: 
          parambdpi.a(2131375732, this.jdField_a_of_type_AndroidContentContext.getString(2131692956), 2130838683);
          break;
        case 6: 
          parambdpi.a(2131363923, this.jdField_a_of_type_AndroidContentContext.getString(2131690759), 2130838667);
          break;
        case 9: 
          parambdpi.a(2131366760, this.jdField_a_of_type_AndroidContentContext.getString(2131692498), 2130838678);
          break;
        case 10: 
          a(paramChatMessage, parambdpi);
          break;
        case 11: 
          b(paramChatMessage, parambdpi);
          break;
        case 14: 
          a(parambdpi, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage);
          break;
        case 19: 
          parambdpi.a(2131366787, this.jdField_a_of_type_AndroidContentContext.getString(2131692551), 2130838678);
          break;
        case 16: 
          a(parambdpi, paramChatMessage);
          break;
        case 17: 
          parambdpi.a(2131366017, this.jdField_a_of_type_AndroidContentContext.getString(2131692494), 2130838677);
          break;
        case 18: 
          e(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 20: 
          parambdpi.a(2131376117, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838678);
          break;
        case 15: 
          super.c(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 12: 
          b(parambdpi, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          parambdpi.a(2131376113, this.jdField_a_of_type_AndroidContentContext.getString(2131697780), 2130838674);
          break;
        case 21: 
          parambdpi.a(2131377486, this.jdField_a_of_type_AndroidContentContext.getString(2131720680), 2130838689);
          break;
        case 22: 
          parambdpi.a(2131376409, "StructMsg", 2130838678);
          break;
        case 23: 
          ApolloUtil.a(parambdpi, this.jdField_a_of_type_Aqvx.a());
          break;
        case 24: 
          parambdpi.a(2131364409, alud.a(2131704905), 2130838677);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aeqi a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aetk paramaetk)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaetk);
    paramViewGroup = (aeqi)aepi.a(paramView);
    this.jdField_a_of_type_Aqvx.b(paramChatMessage);
    if (this.jdField_a_of_type_Aqrp != null) {
      this.jdField_a_of_type_Aqrp.a(paramViewGroup, paramView, this.jdField_a_of_type_Aqvx.a());
    }
    if (this.jdField_a_of_type_Aqrm != null)
    {
      this.jdField_a_of_type_Aqrm.a(this);
      this.jdField_a_of_type_Aqrm.a(paramViewGroup, paramView, this.jdField_a_of_type_Aqvx.a());
    }
    return paramView;
  }
  
  protected abstract View a(aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk);
  
  public View a(ChatMessage paramChatMessage, aeqi paramaeqi, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aetk paramaetk)
  {
    this.jdField_a_of_type_Aqvx.b(paramChatMessage);
    this.jdField_a_of_type_Aqvx.b();
    paramChatMessage = a(paramaeqi, paramView, paramBaseChatItemLayout, paramaetk);
    if ((paramaeqi instanceof afya)) {
      a((afya)paramaeqi, paramBaseChatItemLayout, this.jdField_a_of_type_Aqvx.c());
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Aqvx.b(), this);
    return paramChatMessage;
  }
  
  public bdpi a(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    this.jdField_a_of_type_Aqvx.b(paramChatMessage);
    return a(parambdpi, paramChatMessage, a(parambdpi, paramaeqz));
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((aeqz)aepi.a(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aqvx.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bdpi parambdpi, aeqz paramaeqz);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aqvx.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(afya paramafya, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramafya.a != null) {
        paramafya.a.setVisibility(8);
      }
      return;
    }
    if (paramafya.a == null)
    {
      paramafya.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramafya.a.setBackgroundResource(2130842258);
      paramafya.a.setTextSize(1, 12.0F);
      paramafya.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167194));
      paramafya.a.setText(this.jdField_a_of_type_Aqvx.c());
      paramafya.a.setSingleLine();
      paramafya.a.setGravity(16);
      paramafya.a.setPadding(bdaq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramafya.a.setOnClickListener(new afxz(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364173);
      paramViewGroup.addView(paramafya.a, localLayoutParams);
    }
    paramafya.a.setVisibility(0);
    if (this.jdField_a_of_type_Aqvx.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramafya.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364173);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296297) + bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramafya.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramafya.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364173);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296297) + bdaq.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramafya.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Aqvx.b(paramView);
    this.jdField_a_of_type_Aqvx.c();
  }
  
  public void a(aqvx paramaqvx)
  {
    this.jdField_a_of_type_Aqvx = paramaqvx;
    this.jdField_a_of_type_Aqrp = this.jdField_a_of_type_Aqvx.a();
    this.jdField_a_of_type_Aqrm = this.jdField_a_of_type_Aqvx.a();
  }
  
  protected void a(ChatMessage paramChatMessage, aeqi paramaeqi) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aeqi paramaeqi, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaeqi, paramInt1, paramInt2);
    a(paramChatMessage, paramaeqi);
  }
  
  public bdpk[] a(View paramView)
  {
    paramView = a(paramView);
    bdpi localbdpi = new bdpi();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbdpi, paramView, null);
    }
    for (;;)
    {
      return localbdpi.a();
      label38:
      a(localbdpi, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract aeqi b();
  
  public bdpi b(bdpi parambdpi, ChatMessage paramChatMessage, aeqz paramaeqz)
  {
    this.jdField_a_of_type_Aqvx.b(paramChatMessage);
    return a(parambdpi, paramChatMessage, b(parambdpi, paramaeqz));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bdpi parambdpi, aeqz paramaeqz);
  
  protected abstract void d(View paramView);
  
  public void g(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    aepi.n = true;
    if (super.a()) {
      return;
    }
    ChatMessage localChatMessage = a(paramView);
    this.jdField_a_of_type_Aqvx.b(localChatMessage);
    d(paramView);
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxy
 * JD-Core Version:    0.7.0.1
 */