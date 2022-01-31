import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import java.util.ArrayList;
import java.util.List;

public class adkm
  extends acjb
{
  View.OnClickListener a;
  
  public adkm(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new adkn(this);
  }
  
  protected acjc a()
  {
    return new adko(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    paramLinearLayout.setPadding(0, aciy.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131493187, null);
    }
    Object localObject2 = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = ((MessageForPubAccount)localObject2).mPAMessage;
    paramMessageRecord = (adko)paramacjc;
    Object localObject3 = localPAMessage.items;
    paramacjc = (ViewGroup)paramLinearLayout.findViewById(2131305512);
    Object localObject1 = (ImageView)paramLinearLayout.findViewById(2131305515);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131305514);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131305507);
    TextView localTextView3 = (TextView)paramLinearLayout.findViewById(2131305508);
    TextView localTextView4 = (TextView)paramLinearLayout.findViewById(2131305509);
    TextView localTextView5 = (TextView)paramLinearLayout.findViewById(2131305510);
    TextView localTextView6 = (TextView)paramLinearLayout.findViewById(2131305511);
    paramView = new ArrayList();
    paramView.add(localTextView2);
    paramView.add(localTextView3);
    paramView.add(localTextView4);
    paramView.add(localTextView5);
    paramView.add(localTextView6);
    localObject3 = (PAMessage.Item)((ArrayList)localObject3).get(0);
    paramMessageRecord.jdField_c_of_type_JavaLangString = ((PAMessage.Item)localObject3).url;
    paramMessageRecord.jdField_c_of_type_Int = localPAMessage.type;
    paramMessageRecord.jdField_b_of_type_JavaLangString = ((PAMessage.Item)localObject3).actionUrl;
    paramMessageRecord.jdField_a_of_type_JavaLangString = ((PAMessage.Item)localObject3).nativeJumpString;
    paramMessageRecord.jdField_b_of_type_Int = 6;
    paramMessageRecord.jdField_a_of_type_JavaLangObject = Long.valueOf(((MessageForPubAccount)localObject2).uniseq);
    paramMessageRecord.d = ((PAMessage.Item)localObject3).iconsString;
    if ((!TextUtils.isEmpty(paramMessageRecord.d)) && (paramMessageRecord.d.contains("1")))
    {
      i = 1;
      localObject2 = localTextView1.getLayoutParams();
      if (i == 0) {
        break label450;
      }
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 24;
        localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      ((ImageView)localObject1).setVisibility(0);
      label351:
      localTextView1.setText(((PAMessage.Item)localObject3).title);
      localObject1 = ((PAMessage.Item)localObject3).digestList;
      if (localObject1 == null) {
        break label526;
      }
    }
    label385:
    label526:
    for (int i = ((List)localObject1).size();; i = 0)
    {
      int j = 0;
      if (j < paramView.size())
      {
        localTextView1 = (TextView)paramView.get(j);
        if (i > j)
        {
          localTextView1.setText((CharSequence)((List)localObject1).get(j));
          localTextView1.setVisibility(0);
        }
        for (;;)
        {
          j += 1;
          break label385;
          i = 0;
          break;
          label450:
          if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
          {
            localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
            localTextView1.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          ((ImageView)localObject1).setVisibility(8);
          break label351;
          localTextView1.setVisibility(8);
        }
      }
      paramacjc.setTag(paramMessageRecord);
      paramacjc.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramacjc.setOnTouchListener(paramacmv);
      paramacjc.setOnLongClickListener(paramacmv);
      return paramLinearLayout;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      return;
    }
    paramContext = aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      aael.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      rtr.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bakj[] a(View paramView)
  {
    paramView = new bakh();
    paramView.a(2131299417, this.jdField_a_of_type_AndroidContentContext.getString(2131625147), 2130838594);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkm
 * JD-Core Version:    0.7.0.1
 */