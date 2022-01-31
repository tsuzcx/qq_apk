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

public class afcy
  extends aekw
  implements View.OnClickListener
{
  protected String a;
  
  public afcy(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected aekx a()
  {
    return new afda(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, aekx paramaekx, View paramView, LinearLayout paramLinearLayout, aeov paramaeov)
  {
    paramLinearLayout = (afda)paramaekx;
    paramaekx = paramView;
    if (paramView == null)
    {
      paramaekx = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559728, null);
      paramLinearLayout.b = ((TextView)paramaekx.findViewById(2131364169));
      paramLinearLayout.c = ((TextView)paramaekx.findViewById(2131364168));
      paramLinearLayout.d = ((TextView)paramaekx.findViewById(2131364167));
      paramLinearLayout.a = ((ImageView)paramaekx.findViewById(2131364165));
      paramaekx.setOnClickListener(this);
      paramLinearLayout.b.setOnClickListener(this);
      paramLinearLayout.c.setOnClickListener(this);
      paramLinearLayout.d.setOnClickListener(this);
      paramLinearLayout.a.setOnClickListener(this);
    }
    if ((paramMessageRecord instanceof MessageForActivity))
    {
      paramView = (MessageForActivity)paramMessageRecord;
      paramLinearLayout.b.setText(alpo.a(2131700159));
      paramLinearLayout.c.setText(paramView.title);
      a(paramView.summary, paramLinearLayout.d);
    }
    try
    {
      paramMessageRecord = URLDrawable.getDrawable(paramView.bigPic, paramaekx.getResources().getDrawable(2130842130), paramaekx.getResources().getDrawable(2130842129));
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
          paramaekx.setContentDescription(paramMessageRecord);
        }
      }
      else {
        return paramaekx;
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        paramLinearLayout.a.setBackgroundResource(2130842129);
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
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new afcz(this, paramTextView, paramString));
  }
  
  public bdlb[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    bbii.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcy
 * JD-Core Version:    0.7.0.1
 */