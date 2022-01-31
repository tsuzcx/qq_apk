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

public abstract class adww
  extends BaseBubbleBuilder
  implements acum, aouh
{
  protected aouf a;
  protected aoui a;
  protected aoyq a;
  
  public adww(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bbmf a(bbmf parambbmf, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambbmf;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambbmf.a(2131365347, this.jdField_a_of_type_AndroidContentContext.getString(2131692683), 2130838602);
          break;
        case 3: 
          parambbmf.a(2131363859, this.jdField_a_of_type_AndroidContentContext.getString(2131697595), 2130838602);
          break;
        case 4: 
          parambbmf.a(2131371297, this.jdField_a_of_type_AndroidContentContext.getString(2131692685), 2130838609);
          break;
        case 5: 
          parambbmf.a(2131375198, this.jdField_a_of_type_AndroidContentContext.getString(2131692843), 2130838611);
          break;
        case 7: 
          parambbmf.a(2131371299, this.jdField_a_of_type_AndroidContentContext.getString(2131692685), 2130838609);
          break;
        case 8: 
          parambbmf.a(2131375199, this.jdField_a_of_type_AndroidContentContext.getString(2131692872), 2130838611);
          break;
        case 6: 
          parambbmf.a(2131363864, this.jdField_a_of_type_AndroidContentContext.getString(2131690707), 2130838595);
          break;
        case 9: 
          parambbmf.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692421), 2130838606);
          break;
        case 10: 
          a(paramChatMessage, parambbmf);
          break;
        case 11: 
          b(paramChatMessage, parambbmf);
          break;
        case 14: 
          a(parambbmf, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage);
          break;
        case 19: 
          parambbmf.a(2131366659, this.jdField_a_of_type_AndroidContentContext.getString(2131692474), 2130838606);
          break;
        case 16: 
          a(parambbmf, paramChatMessage);
          break;
        case 17: 
          parambbmf.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692417), 2130838605);
          break;
        case 18: 
          e(parambbmf, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 20: 
          parambbmf.a(2131375573, this.jdField_a_of_type_AndroidContentContext.getString(2131692473), 2130838606);
          break;
        case 15: 
          super.c(parambbmf, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 12: 
          b(parambbmf, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          parambbmf.a(2131375569, this.jdField_a_of_type_AndroidContentContext.getString(2131697603), 2130838602);
          break;
        case 21: 
          parambbmf.a(2131376912, this.jdField_a_of_type_AndroidContentContext.getString(2131720132), 2130838617);
          break;
        case 22: 
          parambbmf.a(2131375856, "StructMsg", 2130838606);
          break;
        case 23: 
          ApolloUtil.a(parambbmf, this.jdField_a_of_type_Aoyq.a());
          break;
        case 24: 
          parambbmf.a(2131364339, ajya.a(2131704521), 2130838605);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acuj a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxj paramacxj)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxj);
    paramViewGroup = (acuj)actj.a(paramView);
    this.jdField_a_of_type_Aoyq.b(paramChatMessage);
    if (this.jdField_a_of_type_Aoui != null) {
      this.jdField_a_of_type_Aoui.a(paramViewGroup, paramView, this.jdField_a_of_type_Aoyq.a());
    }
    if (this.jdField_a_of_type_Aouf != null)
    {
      this.jdField_a_of_type_Aouf.a(this);
      this.jdField_a_of_type_Aouf.a(paramViewGroup, paramView, this.jdField_a_of_type_Aoyq.a());
    }
    return paramView;
  }
  
  protected abstract View a(acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj);
  
  public View a(ChatMessage paramChatMessage, acuj paramacuj, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxj paramacxj)
  {
    this.jdField_a_of_type_Aoyq.b(paramChatMessage);
    this.jdField_a_of_type_Aoyq.b();
    paramChatMessage = a(paramacuj, paramView, paramBaseChatItemLayout, paramacxj);
    if ((paramacuj instanceof adwy)) {
      a((adwy)paramacuj, paramBaseChatItemLayout, this.jdField_a_of_type_Aoyq.c());
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Aoyq.b(), this);
    return paramChatMessage;
  }
  
  public bbmf a(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    this.jdField_a_of_type_Aoyq.b(paramChatMessage);
    return a(parambbmf, paramChatMessage, a(parambbmf, paramacva));
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((acva)actj.a(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aoyq.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bbmf parambbmf, acva paramacva);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aoyq.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(adwy paramadwy, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramadwy.a != null) {
        paramadwy.a.setVisibility(8);
      }
      return;
    }
    if (paramadwy.a == null)
    {
      paramadwy.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramadwy.a.setBackgroundResource(2130842092);
      paramadwy.a.setTextSize(1, 12.0F);
      paramadwy.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167134));
      paramadwy.a.setText(this.jdField_a_of_type_Aoyq.c());
      paramadwy.a.setSingleLine();
      paramadwy.a.setGravity(16);
      paramadwy.a.setPadding(baxn.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, baxn.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramadwy.a.setOnClickListener(new adwx(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364109);
      paramViewGroup.addView(paramadwy.a, localLayoutParams);
    }
    paramadwy.a.setVisibility(0);
    if (this.jdField_a_of_type_Aoyq.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramadwy.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364109);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296291) + baxn.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramadwy.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramadwy.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364109);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296291) + baxn.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramadwy.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Aoyq.b(paramView);
    this.jdField_a_of_type_Aoyq.c();
  }
  
  public void a(aoyq paramaoyq)
  {
    this.jdField_a_of_type_Aoyq = paramaoyq;
    this.jdField_a_of_type_Aoui = this.jdField_a_of_type_Aoyq.a();
    this.jdField_a_of_type_Aouf = this.jdField_a_of_type_Aoyq.a();
  }
  
  protected void a(ChatMessage paramChatMessage, acuj paramacuj) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acuj paramacuj, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacuj, paramInt1, paramInt2);
    a(paramChatMessage, paramacuj);
  }
  
  public bbmh[] a(View paramView)
  {
    paramView = a(paramView);
    bbmf localbbmf = new bbmf();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbbmf, paramView, null);
    }
    for (;;)
    {
      return localbbmf.a();
      label38:
      a(localbbmf, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract acuj b();
  
  public bbmf b(bbmf parambbmf, ChatMessage paramChatMessage, acva paramacva)
  {
    this.jdField_a_of_type_Aoyq.b(paramChatMessage);
    return a(parambbmf, paramChatMessage, b(parambbmf, paramacva));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bbmf parambbmf, acva paramacva);
  
  protected abstract void d(View paramView);
  
  public void g(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    actj.n = true;
    if (super.a()) {
      return;
    }
    ChatMessage localChatMessage = a(paramView);
    this.jdField_a_of_type_Aoyq.b(localChatMessage);
    d(paramView);
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adww
 * JD-Core Version:    0.7.0.1
 */