import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForActivity;
import com.tencent.mobileqq.data.MessageRecord;

public class aczo
  extends acjb
  implements View.OnClickListener
{
  protected String a;
  
  public aczo(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected acjc a()
  {
    return new aczq(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, acjc paramacjc, View paramView, LinearLayout paramLinearLayout, acmv paramacmv)
  {
    paramLinearLayout = (aczq)paramacjc;
    paramacjc = paramView;
    if (paramView == null)
    {
      paramacjc = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131494099, null);
      paramLinearLayout.b = ((TextView)paramacjc.findViewById(2131298550));
      paramLinearLayout.c = ((TextView)paramacjc.findViewById(2131298549));
      paramLinearLayout.d = ((TextView)paramacjc.findViewById(2131298548));
      paramLinearLayout.a = ((ImageView)paramacjc.findViewById(2131298546));
      paramacjc.setOnClickListener(this);
      paramLinearLayout.b.setOnClickListener(this);
      paramLinearLayout.c.setOnClickListener(this);
      paramLinearLayout.d.setOnClickListener(this);
      paramLinearLayout.a.setOnClickListener(this);
    }
    if ((paramMessageRecord instanceof MessageForActivity))
    {
      paramView = (MessageForActivity)paramMessageRecord;
      paramLinearLayout.b.setText(ajjy.a(2131633991));
      paramLinearLayout.c.setText(paramView.title);
      a(paramView.summary, paramLinearLayout.d);
    }
    try
    {
      paramMessageRecord = URLDrawable.getDrawable(paramView.bigPic, paramacjc.getResources().getDrawable(2130841885), paramacjc.getResources().getDrawable(2130841884));
      paramLinearLayout.a.setBackgroundDrawable(paramMessageRecord);
      this.jdField_a_of_type_JavaLangString = paramView.url;
      if (e)
      {
        if (TextUtils.isEmpty(paramView.title))
        {
          paramMessageRecord = "";
          paramLinearLayout = new StringBuilder().append(paramMessageRecord);
          if (!TextUtils.isEmpty(paramView.summary)) {
            break label298;
          }
          paramMessageRecord = "";
          paramacjc.setContentDescription(paramMessageRecord);
        }
      }
      else {
        return paramacjc;
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        paramLinearLayout.a.setBackgroundResource(2130841884);
        continue;
        paramMessageRecord = paramView.title;
        continue;
        label298:
        paramMessageRecord = paramView.summary;
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  protected void a(String paramString, TextView paramTextView)
  {
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new aczp(this, paramTextView, paramString));
  }
  
  public bakj[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    ayjh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aczo
 * JD-Core Version:    0.7.0.1
 */