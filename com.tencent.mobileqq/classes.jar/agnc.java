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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agnc
  extends afor
  implements View.OnClickListener
{
  protected String a;
  
  public agnc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected afos a()
  {
    return new agne(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    paramLinearLayout = (agne)paramafos;
    paramafos = paramView;
    if (paramView == null)
    {
      paramafos = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559919, null);
      paramLinearLayout.b = ((TextView)paramafos.findViewById(2131364520));
      paramLinearLayout.c = ((TextView)paramafos.findViewById(2131364519));
      paramLinearLayout.d = ((TextView)paramafos.findViewById(2131364518));
      paramLinearLayout.a = ((ImageView)paramafos.findViewById(2131364516));
      paramafos.setOnClickListener(this);
      paramLinearLayout.b.setOnClickListener(this);
      paramLinearLayout.c.setOnClickListener(this);
      paramLinearLayout.d.setOnClickListener(this);
      paramLinearLayout.a.setOnClickListener(this);
    }
    if ((paramMessageRecord instanceof MessageForActivity))
    {
      paramView = (MessageForActivity)paramMessageRecord;
      paramLinearLayout.b.setText(anvx.a(2131699290));
      paramLinearLayout.c.setText(paramView.title);
      a(paramView.summary, paramLinearLayout.d);
    }
    try
    {
      paramMessageRecord = URLDrawable.getDrawable(paramView.bigPic, paramafos.getResources().getDrawable(2130842542), paramafos.getResources().getDrawable(2130842541));
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
          paramafos.setContentDescription(paramMessageRecord);
        }
      }
      else {
        return paramafos;
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        paramLinearLayout.a.setBackgroundResource(2130842541);
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
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new agnd(this, paramTextView, paramString));
  }
  
  public bhjs[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    bfcz.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agnc
 * JD-Core Version:    0.7.0.1
 */