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

public abstract class adwy
  extends BaseBubbleBuilder
  implements acuq, aoud
{
  protected aoub a;
  protected aoue a;
  protected aoym a;
  
  public adwy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private bblr a(bblr parambblr, ChatMessage paramChatMessage, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return parambblr;
      Collections.sort(paramList);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        switch (((Integer)paramList.next()).intValue())
        {
        case 2: 
        default: 
          break;
        case 1: 
          parambblr.a(2131365348, this.jdField_a_of_type_AndroidContentContext.getString(2131692682), 2130838602);
          break;
        case 3: 
          parambblr.a(2131363860, this.jdField_a_of_type_AndroidContentContext.getString(2131697594), 2130838602);
          break;
        case 4: 
          parambblr.a(2131371297, this.jdField_a_of_type_AndroidContentContext.getString(2131692684), 2130838609);
          break;
        case 5: 
          parambblr.a(2131375196, this.jdField_a_of_type_AndroidContentContext.getString(2131692842), 2130838611);
          break;
        case 7: 
          parambblr.a(2131371299, this.jdField_a_of_type_AndroidContentContext.getString(2131692684), 2130838609);
          break;
        case 8: 
          parambblr.a(2131375197, this.jdField_a_of_type_AndroidContentContext.getString(2131692871), 2130838611);
          break;
        case 6: 
          parambblr.a(2131363865, this.jdField_a_of_type_AndroidContentContext.getString(2131690707), 2130838595);
          break;
        case 9: 
          parambblr.a(2131366632, this.jdField_a_of_type_AndroidContentContext.getString(2131692420), 2130838606);
          break;
        case 10: 
          a(paramChatMessage, parambblr);
          break;
        case 11: 
          b(paramChatMessage, parambblr);
          break;
        case 14: 
          a(parambblr, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramChatMessage);
          break;
        case 19: 
          parambblr.a(2131366659, this.jdField_a_of_type_AndroidContentContext.getString(2131692473), 2130838606);
          break;
        case 16: 
          a(parambblr, paramChatMessage);
          break;
        case 17: 
          parambblr.a(2131365928, this.jdField_a_of_type_AndroidContentContext.getString(2131692416), 2130838605);
          break;
        case 18: 
          e(parambblr, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 20: 
          parambblr.a(2131375571, this.jdField_a_of_type_AndroidContentContext.getString(2131692472), 2130838606);
          break;
        case 15: 
          super.c(parambblr, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 12: 
          b(parambblr, this.jdField_a_of_type_AndroidContentContext);
          break;
        case 13: 
          parambblr.a(2131375567, this.jdField_a_of_type_AndroidContentContext.getString(2131697602), 2130838602);
          break;
        case 21: 
          parambblr.a(2131376910, this.jdField_a_of_type_AndroidContentContext.getString(2131720121), 2130838617);
          break;
        case 22: 
          parambblr.a(2131375854, "StructMsg", 2130838606);
          break;
        case 23: 
          ApolloUtil.a(parambblr, this.jdField_a_of_type_Aoym.a());
          break;
        case 24: 
          parambblr.a(2131364340, ajyc.a(2131704510), 2130838605);
        }
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public acun a()
  {
    return b();
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, acxn paramacxn)
  {
    paramView = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramacxn);
    paramViewGroup = (acun)actn.a(paramView);
    this.jdField_a_of_type_Aoym.b(paramChatMessage);
    if (this.jdField_a_of_type_Aoue != null) {
      this.jdField_a_of_type_Aoue.a(paramViewGroup, paramView, this.jdField_a_of_type_Aoym.a());
    }
    if (this.jdField_a_of_type_Aoub != null)
    {
      this.jdField_a_of_type_Aoub.a(this);
      this.jdField_a_of_type_Aoub.a(paramViewGroup, paramView, this.jdField_a_of_type_Aoym.a());
    }
    return paramView;
  }
  
  protected abstract View a(acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn);
  
  public View a(ChatMessage paramChatMessage, acun paramacun, View paramView, BaseChatItemLayout paramBaseChatItemLayout, acxn paramacxn)
  {
    this.jdField_a_of_type_Aoym.b(paramChatMessage);
    this.jdField_a_of_type_Aoym.b();
    paramChatMessage = a(paramacun, paramView, paramBaseChatItemLayout, paramacxn);
    if ((paramacun instanceof adxa)) {
      a((adxa)paramacun, paramBaseChatItemLayout, this.jdField_a_of_type_Aoym.c());
    }
    paramBaseChatItemLayout.setFailedIconVisable(this.jdField_a_of_type_Aoym.b(), this);
    return paramChatMessage;
  }
  
  public bblr a(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    this.jdField_a_of_type_Aoym.b(paramChatMessage);
    return a(parambblr, paramChatMessage, a(parambblr, paramacve));
  }
  
  protected ChatMessage a(View paramView)
  {
    return ((acve)actn.a(paramView)).a;
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aoym.b(paramChatMessage);
    return b(paramChatMessage);
  }
  
  protected abstract List<Integer> a(bblr parambblr, acve paramacve);
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Aoym.b(paramChatMessage);
    a(paramInt, paramChatMessage);
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected abstract void a(int paramInt, ChatMessage paramChatMessage);
  
  protected void a(adxa paramadxa, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (paramadxa.a != null) {
        paramadxa.a.setVisibility(8);
      }
      return;
    }
    if (paramadxa.a == null)
    {
      paramadxa.a = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramadxa.a.setBackgroundResource(2130842091);
      paramadxa.a.setTextSize(1, 12.0F);
      paramadxa.a.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167134));
      paramadxa.a.setText(this.jdField_a_of_type_Aoym.c());
      paramadxa.a.setSingleLine();
      paramadxa.a.setGravity(16);
      paramadxa.a.setPadding(bawz.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0, bawz.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), 0);
      paramadxa.a.setOnClickListener(new adwz(this));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131364110);
      paramViewGroup.addView(paramadxa.a, localLayoutParams);
    }
    paramadxa.a.setVisibility(0);
    if (this.jdField_a_of_type_Aoym.a())
    {
      paramViewGroup = (RelativeLayout.LayoutParams)paramadxa.a.getLayoutParams();
      paramViewGroup.addRule(7, 2131364110);
      paramViewGroup.addRule(5, 0);
      paramViewGroup.rightMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296291) + bawz.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
      paramViewGroup.leftMargin = 0;
      paramadxa.a.setLayoutParams(paramViewGroup);
      return;
    }
    paramViewGroup = (RelativeLayout.LayoutParams)paramadxa.a.getLayoutParams();
    paramViewGroup.addRule(5, 2131364110);
    paramViewGroup.addRule(7, 0);
    paramViewGroup.leftMargin = (this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296291) + bawz.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    paramViewGroup.rightMargin = 0;
    paramadxa.a.setLayoutParams(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    paramView = a(paramView);
    this.jdField_a_of_type_Aoym.b(paramView);
    this.jdField_a_of_type_Aoym.c();
  }
  
  public void a(aoym paramaoym)
  {
    this.jdField_a_of_type_Aoym = paramaoym;
    this.jdField_a_of_type_Aoue = this.jdField_a_of_type_Aoym.a();
    this.jdField_a_of_type_Aoub = this.jdField_a_of_type_Aoym.a();
  }
  
  protected void a(ChatMessage paramChatMessage, acun paramacun) {}
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, acun paramacun, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramacun, paramInt1, paramInt2);
    a(paramChatMessage, paramacun);
  }
  
  public bblt[] a(View paramView)
  {
    paramView = a(paramView);
    bblr localbblr = new bblr();
    if (paramView != null)
    {
      if (!paramView.isMultiMsg) {
        break label38;
      }
      b(localbblr, paramView, null);
    }
    for (;;)
    {
      return localbblr.a();
      label38:
      a(localbblr, paramView, null);
    }
  }
  
  public void a_(ChatMessage paramChatMessage) {}
  
  protected abstract acun b();
  
  public bblr b(bblr parambblr, ChatMessage paramChatMessage, acve paramacve)
  {
    this.jdField_a_of_type_Aoym.b(paramChatMessage);
    return a(parambblr, paramChatMessage, b(parambblr, paramacve));
  }
  
  protected abstract String b(ChatMessage paramChatMessage);
  
  protected abstract List<Integer> b(bblr parambblr, acve paramacve);
  
  protected abstract void d(View paramView);
  
  public void g(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    actn.n = true;
    if (super.a()) {
      return;
    }
    ChatMessage localChatMessage = a(paramView);
    this.jdField_a_of_type_Aoym.b(localChatMessage);
    d(paramView);
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adwy
 * JD-Core Version:    0.7.0.1
 */