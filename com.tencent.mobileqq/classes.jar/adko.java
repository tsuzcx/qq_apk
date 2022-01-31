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

public class adko
  extends actm
  implements View.OnClickListener
{
  protected String a;
  
  public adko(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected actn a()
  {
    return new adkq(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actn paramactn, View paramView, LinearLayout paramLinearLayout, acxj paramacxj)
  {
    paramLinearLayout = (adkq)paramactn;
    paramactn = paramView;
    if (paramView == null)
    {
      paramactn = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559672, null);
      paramLinearLayout.b = ((TextView)paramactn.findViewById(2131364107));
      paramLinearLayout.c = ((TextView)paramactn.findViewById(2131364106));
      paramLinearLayout.d = ((TextView)paramactn.findViewById(2131364105));
      paramLinearLayout.a = ((ImageView)paramactn.findViewById(2131364103));
      paramactn.setOnClickListener(this);
      paramLinearLayout.b.setOnClickListener(this);
      paramLinearLayout.c.setOnClickListener(this);
      paramLinearLayout.d.setOnClickListener(this);
      paramLinearLayout.a.setOnClickListener(this);
    }
    if ((paramMessageRecord instanceof MessageForActivity))
    {
      paramView = (MessageForActivity)paramMessageRecord;
      paramLinearLayout.b.setText(ajya.a(2131699790));
      paramLinearLayout.c.setText(paramView.title);
      a(paramView.summary, paramLinearLayout.d);
    }
    try
    {
      paramMessageRecord = URLDrawable.getDrawable(paramView.bigPic, paramactn.getResources().getDrawable(2130841978), paramactn.getResources().getDrawable(2130841977));
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
          paramactn.setContentDescription(paramMessageRecord);
        }
      }
      else {
        return paramactn;
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        paramLinearLayout.a.setBackgroundResource(2130841977);
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
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new adkp(this, paramTextView, paramString));
  }
  
  public bbmh[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    azjz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adko
 * JD-Core Version:    0.7.0.1
 */