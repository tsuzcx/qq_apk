import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.manager.MonitorManager;

public class adnj
  extends actq
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = ajyc.a(2131701140);
  private long jdField_a_of_type_Long;
  private ForegroundColorSpan jdField_a_of_type_AndroidTextStyleForegroundColorSpan = new ForegroundColorSpan(Color.parseColor("#883353"));
  
  public adnj(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, adnk paramadnk)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558729, null);
      paramadnk.jdField_b_of_type_AndroidViewView = paramView;
      paramadnk.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362234);
      paramadnk.d = paramView.findViewById(2131362233);
      paramadnk.a = ((URLImageView)paramView.findViewById(2131362236));
      paramadnk.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362237));
      paramadnk.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362235));
      localView = paramView;
      if (e)
      {
        paramadnk.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramadnk.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramadnk.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    long l1;
    if ((paramMessageRecord != null) && (!bbbf.a().a(paramMessageRecord, "aio_msg|birthday_notice")))
    {
      bbbf.a().a(paramMessageRecord, "aio_msg|birthday_notice");
      l1 = 0L;
    }
    try
    {
      long l2 = Long.parseLong(paramMessageRecord.frienduin);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("BirthDayNoticeItemBuilder", 1, "error parse friend uin " + paramMessageRecord);
        MonitorManager.a().a(19, 10, " error parse friend uin " + paramMessageRecord, false);
      }
    }
    paramMessageRecord = new LpReportInfo_pf00064();
    paramMessageRecord.actionType = 91;
    paramMessageRecord.subactionType = 22;
    paramMessageRecord.reserves = 1;
    paramMessageRecord.toUin = l1;
    LpReportManager.getInstance().reportToPF00064(paramMessageRecord, false, false);
  }
  
  protected actr a()
  {
    return new adnk(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, actr paramactr, View paramView, LinearLayout paramLinearLayout, acxn paramacxn)
  {
    paramMessageRecord = (MessageForBirthdayNotice)paramMessageRecord;
    paramactr = (adnk)paramactr;
    paramView = a(paramView, paramactr);
    try
    {
      paramactr.a.setBackgroundURL(paramMessageRecord.icon);
      paramactr.d.setBackgroundColor(Color.parseColor(paramMessageRecord.background));
      paramactr.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.birthday);
      int i = paramMessageRecord.blessing.indexOf(jdField_a_of_type_JavaLangString);
      if (i >= 0)
      {
        paramLinearLayout = new SpannableString(paramMessageRecord.blessing);
        paramLinearLayout.setSpan(this.jdField_a_of_type_AndroidTextStyleForegroundColorSpan, i, jdField_a_of_type_JavaLangString.length() + i, 33);
        paramactr.jdField_c_of_type_AndroidWidgetTextView.setText(paramLinearLayout);
        paramactr.jdField_c_of_type_AndroidViewView.setTag(paramMessageRecord);
        paramactr.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        a(paramMessageRecord);
        if (e)
        {
          paramactr.jdField_b_of_type_JavaLangStringBuilder.append("生日");
          paramactr.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageRecord.birthday);
          paramactr.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageRecord.blessing);
          paramactr.jdField_b_of_type_AndroidViewView.setContentDescription(paramactr.jdField_b_of_type_JavaLangStringBuilder.toString());
        }
        return paramView;
      }
    }
    catch (Exception paramLinearLayout)
    {
      for (;;)
      {
        QLog.e("BirthDayNoticeItemBuilder", 1, "set resource error " + paramLinearLayout);
        MonitorManager.a().a(19, 2, "set data error " + paramLinearLayout, false);
        continue;
        paramactr.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord.blessing);
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public boolean a()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 500L) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Long = l;
      return bool;
    }
  }
  
  public bblt[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (a())
    {
      paramView = paramView.getTag();
      if ((paramView instanceof MessageForBirthdayNotice))
      {
        paramView = (MessageForBirthdayNotice)paramView;
        if (!TextUtils.isEmpty(paramView.doufu_link)) {
          break label80;
        }
        if (QLog.isColorLevel()) {
          QLog.e("BirthDayNoticeItemBuilder", 2, "jumpToH5Page with url empty");
        }
        MonitorManager.a().a(19, 2, " parse data with empty url " + paramView, false);
      }
    }
    return;
    label80:
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramView.doufu_link);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    try
    {
      long l = Long.parseLong(paramView.frienduin);
      paramView = new LpReportInfo_pf00064();
      paramView.actionType = 91;
      paramView.subactionType = 22;
      paramView.reserves = 2;
      paramView.toUin = l;
      LpReportManager.getInstance().reportToPF00064(paramView, false, false);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("BirthDayNoticeItemBuilder", 1, "error parse friend uin " + paramView);
      MonitorManager.a().a(19, 10, " error parse friend uin " + paramView, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnj
 * JD-Core Version:    0.7.0.1
 */