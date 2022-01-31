import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class adqy
  extends bici
{
  public List<MessageRecord> a;
  
  public adqy(QQLSActivity paramQQLSActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (!(paramViewGroup instanceof adrd)) {}
    }
    for (paramViewGroup = (adrd)paramViewGroup;; paramViewGroup = null)
    {
      if (paramViewGroup == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561037, null);
        paramViewGroup = new adrd();
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373547));
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(10);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        Object localObject = (ImageView)paramView.findViewById(2131373541);
        if (localObject != null)
        {
          if (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() != 7432) {
            break label146;
          }
          ((ImageView)localObject).setVisibility(4);
        }
        while (paramInt >= this.jdField_a_of_type_JavaUtilList.size())
        {
          return paramView;
          label146:
          ((ImageView)localObject).setVisibility(0);
        }
        localObject = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).mTitleName;
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return paramView;
      }
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject = new BaseChatItemLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
    ((BaseChatItemLayout)localObject).setId(2131363112);
    ((BaseChatItemLayout)localObject).setFocusableInTouchMode(true);
    ((BaseChatItemLayout)localObject).setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
    if ((paramView == null) || (!(paramView.getTag() instanceof adqz)))
    {
      paramViewGroup = new adqz();
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561032, null);
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373428));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131373423));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)paramView.findViewById(2131373424));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = ((BaseChatItemLayout)localObject);
      MessageForPtt localMessageForPtt;
      ViewGroup.MarginLayoutParams localMarginLayoutParams;
      if ((localMessageRecord instanceof MessageForPtt))
      {
        localMessageForPtt = (MessageForPtt)localMessageRecord;
        localObject = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord);
        ((TextView)paramView.findViewById(2131373425)).setText(new bamb((CharSequence)localObject, 16).a());
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
        if (((String)localObject).equals("")) {
          break label569;
        }
        localMarginLayoutParams.setMargins(aepi.a(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), aepi.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
        int j = afxr.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessageForPtt);
        int i = j;
        if (j == -1)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(paramViewGroup, localMessageForPtt, false, true);
          i = 2001;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + localMessageForPtt.url + " uniseq " + localMessageForPtt.uniseq);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(paramViewGroup, localMessageForPtt, i, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localMessageForPtt));
        bavt.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), i, localMessageRecord);
        aery.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
        if ((QQLSActivity.b()) && (paramViewGroup.jdField_a_of_type_JavaLangStringBuilder == null)) {
          paramViewGroup.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        }
        paramViewGroup.b = paramInt;
        paramViewGroup.jdField_c_of_type_Int = paramInt;
        if (QQLSActivity.b())
        {
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
          if (!TextUtils.isEmpty(paramViewGroup.jdField_a_of_type_JavaLangStringBuilder)) {
            paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.replace(0, paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.length(), "");
          }
          if ((!((ChatMessage)localMessageRecord).mNeedTimeStamp) || (localMessageRecord.time <= 0L)) {}
        }
      }
      try
      {
        localObject = bdns.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, 3, localMessageRecord.time * 1000L);
        paramViewGroup.jdField_a_of_type_JavaLangStringBuilder.append((CharSequence)localObject).append(" ");
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)localMessageRecord);
        awyf.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).b(localMessageForPtt);
        return paramView;
        paramViewGroup = (adqz)paramView.getTag();
        continue;
        label569:
        localMarginLayoutParams.setMargins(0, aepi.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str = "";
        }
      }
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((List)((ArrayList)paramList).clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 1012) || (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 7432) || (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 1030) || (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 1035)) {
        return 1;
      }
      if ((localMessageRecord != null) && ((localMessageRecord.msgtype == -2002) || (localMessageRecord.msgtype == -1031))) {
        return 2;
      }
      if (QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a() == 9653) {
        return 4;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if ((i == 1) || (i == 4)) {
      paramView = b(paramInt, paramView, paramViewGroup);
    }
    Object localObject1;
    do
    {
      return paramView;
      if (i == 2) {
        return a(paramInt, paramView, paramViewGroup);
      }
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof adrc)) {}
      }
      else
      {
        paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561036, null);
        paramView = new adrc();
        localObject1 = (TextView)paramViewGroup.findViewById(2131373547);
        localObject2 = (ImageView)paramViewGroup.findViewById(2131373550);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setMaxLines(10);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject1);
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject2);
        paramViewGroup.setTag(paramView);
      }
      paramView = paramViewGroup;
    } while (paramInt >= this.jdField_a_of_type_JavaUtilList.size());
    MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = (adrc)paramViewGroup.getTag();
    if (localMessageRecord.istroop == 7000)
    {
      paramView = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_Badd != null) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_Badd.b(localMessageRecord.frienduin);
      }
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = localMessageRecord.frienduin;
      }
      paramView = (String)localObject1 + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
    }
    label1538:
    for (;;)
    {
      localObject1 = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject1 = "";
      }
      paramView = (View)localObject1;
      if (10007 == localMessageRecord.istroop) {
        paramView = asmw.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessageRecord, (String)localObject1);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramView.equals("")) && ((localMessageRecord.msgtype == -2016) || (localMessageRecord.msgtype == -2009) || (localMessageRecord.msgtype == -2026)))
      {
        paramView = localMessageRecord.msg;
        ((adrc)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-570319);
        ((adrc)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        label398:
        if ((localMessageRecord.istroop != 1) || ((localMessageRecord instanceof MessageForPubAccount))) {
          break label1501;
        }
        localObject1 = bdrv.a(localMessageRecord, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false));
        if (localObject1 == null) {
          break label1470;
        }
        ((adrc)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        return paramViewGroup;
        if ((localMessageRecord.istroop == 1001) || (localMessageRecord.istroop == 1010) || (localMessageRecord.istroop == 10002))
        {
          if (localMessageRecord.msgtype == -2053)
          {
            paramView = (MessageForNearbyLiveTip)azaf.a(-2053);
            paramView.msgData = localMessageRecord.msgData;
            paramView.parse();
            localObject1 = paramView.nickName;
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getString(2131699550) + (String)localObject1 + paramView.msg;
            continue;
          }
          localObject1 = bdgc.q(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessageRecord.senderuin);
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          Object localObject3;
          if (localMessageRecord.frienduin.equals(alof.ai))
          {
            ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131373543)).setText(BaseApplicationImpl.getApplication().getString(2131691510));
            localObject1 = BaseApplicationImpl.getApplication().getString(2131691509);
            ((DragTextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131373549)).setVisibility(8);
            localObject3 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
            paramView = (View)localObject1;
            if (((String)localObject3).length() <= 0) {
              break label1538;
            }
            localObject3 = ((String)localObject3).split("\\|");
            paramView = (View)localObject1;
            if (localObject3.length < 6) {
              break label1538;
            }
            ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131373543)).setText(localObject3[4]);
            paramView = localObject3[5];
            continue;
          }
          if (localMessageRecord.frienduin.equals(alof.ah))
          {
            ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131373543)).setText(BaseApplicationImpl.getApplication().getString(2131693845));
            localObject1 = BaseApplicationImpl.getApplication().getString(2131693844);
            ((DragTextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131373549)).setVisibility(8);
            localObject3 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
            paramView = (View)localObject1;
            if (((String)localObject3).length() <= 0) {
              break label1538;
            }
            localObject3 = ((String)localObject3).split("\\|");
            paramView = (View)localObject1;
            if (localObject3.length < 6) {
              break label1538;
            }
            ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131373543)).setText(localObject3[4]);
            paramView = localObject3[5];
            continue;
          }
          paramView = paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
          continue;
        }
        if ((localMessageRecord.istroop == 9501) && ("device_groupchat".equals(localMessageRecord.extStr)))
        {
          if ((localMessageRecord.msgtype == -4501) || (localMessageRecord.msgtype == -4508))
          {
            localObject1 = bdgc.b(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessageRecord.senderuin, true);
            paramView = (View)localObject1;
            if (!TextUtils.isEmpty(localMessageRecord.senderuin))
            {
              paramView = (View)localObject1;
              if (localMessageRecord.senderuin.equals(localMessageRecord.frienduin)) {
                paramView = aagc.a(((ztp)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a(51)).a(Long.parseLong(localMessageRecord.senderuin)));
              }
            }
            localObject1 = paramView;
            if (paramView == null) {
              localObject1 = "";
            }
            paramView = (String)localObject1 + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
            continue;
          }
          paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
          continue;
        }
        if (nav.a(localMessageRecord))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131697672) + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
          continue;
        }
        if ((localMessageRecord.istroop == 1) && ((localMessageRecord instanceof MessageForPubAccount))) {
          if (((MessageForPubAccount)localMessageRecord).isTextMsg()) {
            break label1532;
          }
        }
      }
      label1470:
      label1501:
      label1532:
      for (paramView = swy.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), BaseApplicationImpl.getContext()) + ":";; paramView = "")
      {
        paramView = paramView + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
        break;
        if (abti.a(localMessageRecord.istroop) == 1032)
        {
          paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().c(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
          break;
        }
        if ((localMessageRecord.istroop == 1041) || (localMessageRecord.istroop == 1042))
        {
          ((TextView)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).findViewById(2131373543)).setText(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131694790));
          paramView = localMessageRecord.msg;
          break;
        }
        paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessageRecord, false);
        break;
        ((adrc)localObject2).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        ((adrc)localObject2).jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label398;
        ((adrc)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(new bamp(paramView, 5, 16, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a()));
        return paramViewGroup;
        ((adrc)localObject2).jdField_a_of_type_AndroidWidgetTextView.setText(new bamp(paramView, 5, 16, QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a()));
        return paramViewGroup;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adqy
 * JD-Core Version:    0.7.0.1
 */