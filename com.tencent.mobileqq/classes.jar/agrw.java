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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.manager.MonitorManager;

public class agrw
  extends afuu
  implements View.OnClickListener
{
  private static final String jdField_a_of_type_JavaLangString = anni.a(2131699956);
  private long jdField_a_of_type_Long;
  private ForegroundColorSpan jdField_a_of_type_AndroidTextStyleForegroundColorSpan = new ForegroundColorSpan(Color.parseColor("#883353"));
  
  public agrw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private View a(View paramView, agrx paramagrx)
  {
    View localView = paramView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558830, null);
      paramagrx.jdField_b_of_type_AndroidViewView = paramView;
      paramagrx.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131362330);
      paramagrx.d = paramView.findViewById(2131362329);
      paramagrx.a = ((URLImageView)paramView.findViewById(2131362332));
      paramagrx.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362333));
      paramagrx.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362331));
      localView = paramView;
      if (e)
      {
        paramagrx.jdField_b_of_type_JavaLangStringBuilder = new StringBuilder();
        localView = paramView;
      }
    }
    if (e)
    {
      localView.setContentDescription(null);
      paramagrx.jdField_b_of_type_JavaLangStringBuilder.replace(0, paramagrx.jdField_b_of_type_JavaLangStringBuilder.length(), "");
    }
    return localView;
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    long l1;
    if ((paramMessageRecord != null) && (!bgjy.a().a(paramMessageRecord, "aio_msg|birthday_notice")))
    {
      bgjy.a().a(paramMessageRecord, "aio_msg|birthday_notice");
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
  
  protected afuv a()
  {
    return new agrx(this);
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    paramMessageRecord = (MessageForBirthdayNotice)paramMessageRecord;
    paramafuv = (agrx)paramafuv;
    paramView = a(paramView, paramafuv);
    try
    {
      paramafuv.a.setBackgroundURL(paramMessageRecord.icon);
      paramafuv.d.setBackgroundColor(Color.parseColor(paramMessageRecord.background));
      paramafuv.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord.birthday);
      int i = paramMessageRecord.blessing.indexOf(jdField_a_of_type_JavaLangString);
      if (i >= 0)
      {
        paramLinearLayout = new SpannableString(paramMessageRecord.blessing);
        paramLinearLayout.setSpan(this.jdField_a_of_type_AndroidTextStyleForegroundColorSpan, i, jdField_a_of_type_JavaLangString.length() + i, 33);
        paramafuv.jdField_c_of_type_AndroidWidgetTextView.setText(paramLinearLayout);
        paramafuv.jdField_c_of_type_AndroidViewView.setTag(paramMessageRecord);
        paramafuv.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
        a(paramMessageRecord);
        if (e)
        {
          paramafuv.jdField_b_of_type_JavaLangStringBuilder.append("生日");
          paramafuv.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageRecord.birthday);
          paramafuv.jdField_b_of_type_JavaLangStringBuilder.append(paramMessageRecord.blessing);
          paramafuv.jdField_b_of_type_AndroidViewView.setContentDescription(paramafuv.jdField_b_of_type_JavaLangStringBuilder.toString());
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
        paramafuv.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord.blessing);
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
  
  public bguj[] a(View paramView)
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (a())
    {
      localObject = paramView.getTag();
      if ((localObject instanceof MessageForBirthdayNotice))
      {
        localObject = (MessageForBirthdayNotice)localObject;
        if (!TextUtils.isEmpty(((MessageForBirthdayNotice)localObject).doufu_link)) {
          break label93;
        }
        if (QLog.isColorLevel()) {
          QLog.e("BirthDayNoticeItemBuilder", 2, "jumpToH5Page with url empty");
        }
        MonitorManager.a().a(19, 2, " parse data with empty url " + localObject, false);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label93:
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", ((MessageForBirthdayNotice)localObject).doufu_link);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      try
      {
        long l = Long.parseLong(((MessageForBirthdayNotice)localObject).frienduin);
        localObject = new LpReportInfo_pf00064();
        ((LpReportInfo_pf00064)localObject).actionType = 91;
        ((LpReportInfo_pf00064)localObject).subactionType = 22;
        ((LpReportInfo_pf00064)localObject).reserves = 2;
        ((LpReportInfo_pf00064)localObject).toUin = l;
        LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, false);
      }
      catch (Exception localException)
      {
        QLog.e("BirthDayNoticeItemBuilder", 1, "error parse friend uin " + localObject);
        MonitorManager.a().a(19, 10, " error parse friend uin " + localObject, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agrw
 * JD-Core Version:    0.7.0.1
 */