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

public class agyb
  extends agem
  implements View.OnClickListener
{
  protected String a;
  
  public agyb(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  protected agen a()
  {
    return new agyd(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, agen paramagen, View paramView, LinearLayout paramLinearLayout, agjk paramagjk)
  {
    paramLinearLayout = (agyd)paramagen;
    paramagen = paramView;
    if (paramView == null)
    {
      paramagen = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559873, null);
      paramLinearLayout.b = ((TextView)paramagen.findViewById(2131364421));
      paramLinearLayout.c = ((TextView)paramagen.findViewById(2131364420));
      paramLinearLayout.d = ((TextView)paramagen.findViewById(2131364419));
      paramLinearLayout.a = ((ImageView)paramagen.findViewById(2131364417));
      paramagen.setOnClickListener(this);
      paramLinearLayout.b.setOnClickListener(this);
      paramLinearLayout.c.setOnClickListener(this);
      paramLinearLayout.d.setOnClickListener(this);
      paramLinearLayout.a.setOnClickListener(this);
    }
    if ((paramMessageRecord instanceof MessageForActivity))
    {
      paramView = (MessageForActivity)paramMessageRecord;
      paramLinearLayout.b.setText(anzj.a(2131698704));
      paramLinearLayout.c.setText(paramView.title);
      a(paramView.summary, paramLinearLayout.d);
    }
    try
    {
      paramMessageRecord = URLDrawable.getDrawable(paramView.bigPic, paramagen.getResources().getDrawable(2130842466), paramagen.getResources().getDrawable(2130842465));
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
          paramagen.setContentDescription(paramMessageRecord);
        }
      }
      else {
        return paramagen;
      }
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        paramLinearLayout.a.setBackgroundResource(2130842465);
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
    paramTextView.getViewTreeObserver().addOnPreDrawListener(new agyc(this, paramTextView, paramString));
  }
  
  public bhum[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    bfmm.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agyb
 * JD-Core Version:    0.7.0.1
 */