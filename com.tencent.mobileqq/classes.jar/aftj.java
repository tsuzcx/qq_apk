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

public abstract class aftj
  extends BaseBubbleBuilder
  implements aelw, aqnf
{
  protected aqnd a;
  protected aqng a;
  protected aqro a;
  
  public aftj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bdkz a(bdkz parambdkz, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambdkz;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambdkz.a(2131365432, this.jdField_a_of_type_AndroidContentContext.getString(2131692762), 2130838673);
          break;
        case 3: 
          parambdkz.a(2131363916, this.jdField_a_of_type_AndroidContentContext.getString(2131697770), 2130838673);
          break;
        case 4: 
          parambdkz.a(2131371612, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838680);
          break;
        case 5: 
          parambdkz.a(2131375680, this.jdField_a_of_type_AndroidContentContext.getString(2131692925), 2130838682);
          break;
        case 7: 
          parambdkz.a(2131371614, this.jdField_a_of_type_AndroidContentContext.getString(2131692764), 2130838680);
          break;
        case 8: 
          parambdkz.a(2131375681, this.jdField_a_of_type_AndroidContentContext.getString(2131692954), 2130838682);
          break;
        case 6: 
          parambdkz.a(2131363921, this.jdField_a_of_type_AndroidContentContext.getString(2131690759), 2130838666);
          break;
        case 9: 
          parambdkz.a(2131366750, this.jdField_a_of_type_AndroidContentContext.getString(2131692497), 2130838677);
          break;
        case 10: 
          a(paramChatMessage, parambdkz);
          break;
        case 11: 
          b(paramChatMessage, parambdkz);
          break;
        case 14: 
          a(parambdkz, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage);
          break;
        case 19: 
          parambdkz.a(2131366777, this.jdField_a_of_type_AndroidContentContext.getString(2131692550), 2130838677);
          break;
        case 16: 
          a(parambdkz, paramChatMessage);
          break;
        case 17: 
          parambdkz.a(2131366015, this.jdField_a_of_type_AndroidContentContext.getString(2131692493), 2130838676);
          break;
        case 18: 
          e(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 20: 
          parambdkz.a(2131376063, this.jdField_a_of_type_AndroidContentContext.getString(2131692549), 2130838677);
          break;
        case 15: 
          super.c(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 12: 
          b(parambdkz, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          parambdkz.a(2131376059, this.jdField_a_of_type_AndroidContentContext.getString(2131697778), 2130838673);
          break;
        case 21: 
          parambdkz.a(2131377432, this.jdField_a_of_type_AndroidContentContext.getString(2131720668), 2130838688);
          break;
        case 22: 
          parambdkz.a(2131376355, "StructMsg", 2130838677);
          break;
        case 23: 
          ApolloUtil.a(parambdkz, this.jdField_a_of_type_Aqro.a());
          break;
        case 24: 
          parambdkz.a(2131364407, alpo.a(2131704893), 2130838676);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public aelt a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, aeov paramaeov)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramaeov);
    paramViewGroup = (aelt)aekt.a(paramView);
    this.jdField_a_of_type_Aqro.b(paramChatMessage);
    if (this.jdField_a_of_type_Aqng != null) {
      this.jdField_a_of_type_Aqng.a(paramViewGroup, paramView, this.jdField_a_of_type_Aqro.a());
    }
    if (this.jdField_a_of_type_Aqnd != null)
    {
      this.jdField_a_of_type_Aqnd.a(this);
      this.jdField_a_of_type_Aqnd.a(paramViewGroup, paramView, this.jdField_a_of_type_Aqro.a());
    }
    return paramView;
  }
  
  protected abstract View a(aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov);
  
  public View a(ChatMessage paramChatMessage, aelt paramaelt, View paramView, BaseChatItemLayout paramBaseChatItemLayout, aeov paramaeov)
  {
    this.jdField_a_of_type_Aqro.b(paramChatMessage);
    this.jdField_a_of_type_Aqro.b();
    paramChatMessage = a(paramaelt, paramView, paramBaseChatItemLayout, paramaeov);
    if ((paramaelt instanceof aftl)) {
      a((aftl)paramaelt, paramBaseChatItemLayout, this.jdField_a_of_type_Aqro.c());
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Aqro.b(), this);
    return paramChatMessage;
  }
  
  public bdkz a(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    this.jdField_a_of_type_Aqro.b(paramChatMessage);
    return a(parambdkz, paramChatMessage, a(parambdkz, paramaemk));
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((aemk)aekt.a(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aqro.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bdkz parambdkz, aemk paramaemk);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aqro.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(aftl paramaftl, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramaftl.a != null) {
        paramaftl.a.setVisibility(8);
      }
      return;
    }
    if (paramaftl.a == null)
    {
      paramaftl.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramaftl.a.setBackgroundResource(2130842245);
      paramaftl.a.setTextSize(1, 12.0F);
      paramaftl.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167192));
      paramaftl.a.setText(this.jdField_a_of_type_Aqro.c());
      paramaftl.a.setSingleLine();
      paramaftl.a.setGravity(16);
      paramaftl.a.setPadding(bcwh.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramaftl.a.setOnClickListener(new aftk(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364171);
      paramViewGroup.addView(paramaftl.a, localLayoutParams);
    }
    paramaftl.a.setVisibility(0);
    if (this.jdField_a_of_type_Aqro.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramaftl.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364171);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296297) + bcwh.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramaftl.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramaftl.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364171);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296297) + bcwh.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramaftl.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Aqro.b(paramView);
    this.jdField_a_of_type_Aqro.c();
  }
  
  public void a(aqro paramaqro)
  {
    this.jdField_a_of_type_Aqro = paramaqro;
    this.jdField_a_of_type_Aqng = this.jdField_a_of_type_Aqro.a();
    this.jdField_a_of_type_Aqnd = this.jdField_a_of_type_Aqro.a();
  }
  
  protected void a(ChatMessage paramChatMessage, aelt paramaelt) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aelt paramaelt, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramaelt, paramInt1, paramInt2);
    a(paramChatMessage, paramaelt);
  }
  
  public bdlb[] a(View paramView)
  {
    paramView = a(paramView);
    bdkz localbdkz = new bdkz();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbdkz, paramView, null);
    }
    for (;;)
    {
      return localbdkz.a();
      label38:
      a(localbdkz, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract aelt b();
  
  public bdkz b(bdkz parambdkz, ChatMessage paramChatMessage, aemk paramaemk)
  {
    this.jdField_a_of_type_Aqro.b(paramChatMessage);
    return a(parambdkz, paramChatMessage, b(parambdkz, paramaemk));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bdkz parambdkz, aemk paramaemk);
  
  protected abstract void d(View paramView);
  
  public void g(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    aekt.n = true;
    if (super.a()) {
      return;
    }
    ChatMessage localChatMessage = a(paramView);
    this.jdField_a_of_type_Aqro.b(localChatMessage);
    d(paramView);
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aftj
 * JD-Core Version:    0.7.0.1
 */