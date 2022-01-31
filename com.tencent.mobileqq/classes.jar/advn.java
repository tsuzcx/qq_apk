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

public class advn
  extends actq
{
  View.OnClickListener a;
  
  public advn(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new advo(this);
  }
  
  protected actr a()
  {
    return new advp(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramLinearLayout.setPadding(0, actn.a(11.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), 0, 0);
    paramLinearLayout = paramView;
    if (paramView == null) {
      paramLinearLayout = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558743, null);
    }
    Object localObject2 = (MessageForPubAccount)paramMessageRecord;
    PAMessage localPAMessage = ((MessageForPubAccount)localObject2).mPAMessage;
    paramMessageRecord = (advp)paramactr;
    Object localObject3 = localPAMessage.items;
    paramactr = (ViewGroup)paramLinearLayout.findViewById(2131371206);
    Object localObject1 = (ImageView)paramLinearLayout.findViewById(2131371209);
    TextView localTextView1 = (TextView)paramLinearLayout.findViewById(2131371208);
    TextView localTextView2 = (TextView)paramLinearLayout.findViewById(2131371201);
    TextView localTextView3 = (TextView)paramLinearLayout.findViewById(2131371202);
    TextView localTextView4 = (TextView)paramLinearLayout.findViewById(2131371203);
    TextView localTextView5 = (TextView)paramLinearLayout.findViewById(2131371204);
    TextView localTextView6 = (TextView)paramLinearLayout.findViewById(2131371205);
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
      paramactr.setTag(paramMessageRecord);
      paramactr.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramactr.setOnTouchListener(paramacxn);
      paramactr.setOnLongClickListener(paramacxn);
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
    paramContext = aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    if ((paramContext != null) && (paramContext.uniseq == paramChatMessage.uniseq)) {
      aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    paramContext = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramChatMessage.uniseq;
    if (paramChatMessage.issend == 1) {}
    for (;;)
    {
      sgj.a(paramContext, localContext, str, paramInt, l, bool);
      return;
      bool = false;
    }
  }
  
  public bblt[] a(View paramView)
  {
    paramView = new bblr();
    paramView.a(2131364985, this.jdField_a_of_type_AndroidContentContext.getString(2131690708), 2130838601);
    return paramView.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     advn
 * JD-Core Version:    0.7.0.1
 */