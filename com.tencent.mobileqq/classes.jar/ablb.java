import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ablb
  extends beot
{
  CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private ArrayList<RecentBaseData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ablb(QQLSActivity paramQQLSActivity) {}
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (!(paramViewGroup instanceof ablh)) {}
    }
    for (paramViewGroup = (ablh)paramViewGroup;; paramViewGroup = null)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131495255, null);
        localObject = new ablh();
        ((ablh)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131307343));
        ((ablh)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131307349));
        ((ablh)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((ablh)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
        paramView.setTag(localObject);
      }
      ((ablh)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      ((ablh)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mTitleName);
      ((ablh)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      beih.a(((ablh)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, 1, 0);
      return paramView;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
    paramViewGroup = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a(), ((MessageRecord)localObject1).uniseq);
    if (((RecentBaseData)localObject3).a() == 1032) {
      paramViewGroup = alyc.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageRecord)localObject1);
    }
    if (paramView != null)
    {
      localObject1 = paramView;
      if ((paramView.getTag() instanceof ablc)) {}
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131495256, null);
      paramView = new ablc();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131307343));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131307348));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131307349));
      ((View)localObject1).setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131307225));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131307220));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)((View)localObject1).findViewById(2131307221));
    }
    ablc localablc = (ablc)((View)localObject1).getTag();
    localablc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    int i = 0;
    if ((((RecentBaseData)localObject3).a().equals(ajed.ag)) || (((RecentBaseData)localObject3).a().equals(ajed.ah))) {
      i = 1;
    }
    int j;
    if (i != 0)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      label398:
      label464:
      Object localObject2;
      if ((((RecentBaseData)localObject3).a() == 0) || (((RecentBaseData)localObject3).a() == 3000) || (((RecentBaseData)localObject3).a() == 8)) {
        if (j > 0)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
          if ((paramView == null) || (paramView.size() <= 0))
          {
            this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).mLastMsg;
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
            }
            localablc.jdField_a_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject3).mTitleName);
            localablc.jdField_b_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject3).mShowTime);
            if (((RecentBaseData)localObject3).a() == 4000) {
              i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_Ajnf.d();
            }
            if (i + j != 0) {
              break label1537;
            }
            localablc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
            if ((((RecentBaseData)localObject3).a().equals(ajed.ah)) || (((RecentBaseData)localObject3).a().equals(ajed.ag))) {
              localablc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
            }
            paramView = new BaseChatItemLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
            paramView.setId(2131297536);
            paramView.setFocusableInTouchMode(true);
            paramView.setPadding(BaseChatItemLayout.s, BaseChatItemLayout.u, BaseChatItemLayout.t, 0);
            localablc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
            if ((paramViewGroup instanceof MessageForPtt))
            {
              localObject2 = (MessageForPtt)paramViewGroup;
              paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramViewGroup);
              ((TextView)((View)localObject1).findViewById(2131307222)).setText(paramView);
              localObject3 = (ViewGroup.MarginLayoutParams)localablc.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
              if (paramView.equals("")) {
                break label1564;
              }
              ((ViewGroup.MarginLayoutParams)localObject3).setMargins(aciy.a(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), aciy.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
              j = adlr.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageForPtt)localObject2);
              i = j;
              if (j == -1)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localablc, (MessageForPtt)localObject2, false, true);
                i = 2001;
              }
              if (QLog.isColorLevel()) {
                QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + ((MessageForPtt)localObject2).url + " uniseq " + ((MessageForPtt)localObject2).uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localablc, (MessageForPtt)localObject2, i, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a((ChatMessage)localObject2));
              axte.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), i, paramViewGroup);
              aclk.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
              if ((QQLSActivity.b()) && (localablc.jdField_a_of_type_JavaLangStringBuilder == null)) {
                localablc.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
              }
              localablc.jdField_b_of_type_Int = paramInt;
              localablc.jdField_c_of_type_Int = paramInt;
              if (QQLSActivity.b())
              {
                localablc.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
                if (!TextUtils.isEmpty(localablc.jdField_a_of_type_JavaLangStringBuilder)) {
                  localablc.jdField_a_of_type_JavaLangStringBuilder.replace(0, localablc.jdField_a_of_type_JavaLangStringBuilder.length(), "");
                }
                if ((!((ChatMessage)paramViewGroup).mNeedTimeStamp) || (paramViewGroup.time <= 0L)) {}
              }
            }
          }
        }
      }
      try
      {
        paramView = baiu.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, 3, paramViewGroup.time * 1000L);
        localablc.jdField_a_of_type_JavaLangStringBuilder.append(paramView).append(" ");
        localablc.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)paramViewGroup);
        audb.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).b((MessageForPtt)localObject2);
        return localObject1;
        i = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
        j = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + paramView.size());
        }
        localObject2 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
        long l1 = ((RecentBaseData)localObject3).a();
        long l2 = ((MessageRecord)paramView.get(paramView.size() - 1)).time;
        if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject2).msgtype != -2016) && (((MessageRecord)localObject2).msgtype != -2009) && (((MessageRecord)localObject2).msgtype != -2026))
        {
          this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).mLastMsg;
          break label398;
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)paramView.get(paramView.size() - 1)).msg;
        break label398;
        this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).mLastMsg;
        break label398;
        if ((((RecentBaseData)localObject3).a() == 1001) || (((RecentBaseData)localObject3).a() == 1010) || (((RecentBaseData)localObject3).a() == 10002))
        {
          if (((RecentBaseData)localObject3).a().equals(ajed.ah))
          {
            ((RecentBaseData)localObject3).mTitleName = BaseApplicationImpl.getApplication().getString(2131625880);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131625879);
            paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
            if (paramView.length() <= 0) {
              break label398;
            }
            paramView = paramView.split("\\|");
            if (paramView.length < 6) {
              break label398;
            }
            ((RecentBaseData)localObject3).mTitleName = paramView[4];
            this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
            break label398;
          }
          if (((RecentBaseData)localObject3).a().equals(ajed.ag))
          {
            ((RecentBaseData)localObject3).mTitleName = BaseApplicationImpl.getApplication().getString(2131628085);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131628084);
            paramView = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
            if (paramView.length() <= 0) {
              break label398;
            }
            paramView = paramView.split("\\|");
            if (paramView.length < 6) {
              break label398;
            }
            ((RecentBaseData)localObject3).mTitleName = paramView[4];
            this.jdField_a_of_type_JavaLangCharSequence = paramView[5];
            break label398;
          }
          QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).a(), ((RecentBaseData)localObject3).a());
          localObject2 = babh.q(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
          paramView = (View)localObject2;
          if (localObject2 == null) {
            paramView = "";
          }
          this.jdField_a_of_type_JavaLangCharSequence = (paramView + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
          break label398;
        }
        this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).mLastMsg;
        break label398;
        label1537:
        localablc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
        beih.a(localablc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, j + i, 0);
        break label464;
        label1564:
        ((ViewGroup.MarginLayoutParams)localObject3).setMargins(0, aciy.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView = "";
        }
      }
    }
  }
  
  public void a(ArrayList<RecentBaseData> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll((List)paramArrayList.clone());
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      if ((localRecentBaseData.a() == 1012) || (localRecentBaseData.a() == 7432) || (localRecentBaseData.a() == 1030) || (localRecentBaseData.a() == 1035)) {
        return 1;
      }
      if ((localMessage != null) && ((localMessage.msgtype == -2002) || (localMessage.msgtype == -1031))) {
        return 2;
      }
      if ((localMessage != null) && (localMessage.msgtype == -2025)) {
        return 3;
      }
      if (localRecentBaseData.a() == 9653) {
        return 4;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int k = getItemViewType(paramInt);
    if ((k == 1) || (k == 4))
    {
      paramView = b(paramInt, paramView, paramViewGroup);
      return paramView;
    }
    if (k == 2) {
      return a(paramInt, paramView, paramViewGroup);
    }
    if (paramView != null)
    {
      paramViewGroup = paramView;
      if ((paramView.getTag() instanceof ablg)) {}
    }
    else
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131495254, null);
      paramView = new ablg();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131307343));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131307347));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131307348));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramViewGroup.findViewById(2131307349));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131307350));
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    }
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ablg localablg = (ablg)paramViewGroup.getTag();
    localablg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    paramInt = 0;
    int j = 0;
    if ((localRecentBaseData.a().equals(ajed.ag)) || (localRecentBaseData.a().equals(ajed.ah))) {
      paramInt = 1;
    }
    int i;
    if (paramInt != 0)
    {
      i = 0;
      paramInt = j;
      label259:
      if (k == 3)
      {
        paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
        if (paramView != null) {
          localRecentBaseData.mLastMsg = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramView, false);
        }
      }
      paramView = localRecentBaseData.mTitleName;
      if ((localRecentBaseData.a() != 0) && (localRecentBaseData.a() != 3000) && (localRecentBaseData.a() != 8)) {
        break label1092;
      }
      if (i <= 0) {
        break label1035;
      }
      localablg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.a(), localRecentBaseData.a());
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        break label815;
      }
      this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.mLastMsg;
      localablg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
      }
      label434:
      localablg.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mShowTime);
    }
    for (;;)
    {
      if ((localRecentBaseData.a() == 8) && (localRecentBaseData.mExtraType == 25))
      {
        localObject1 = (aroh)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(11);
        if (localObject1 == null) {
          break label1951;
        }
        localObject1 = ((aroh)localObject1).c(localRecentBaseData.mPhoneNumber);
        label503:
        if (localObject1 == null) {
          break label1880;
        }
        localRecentBaseData.mTitleName = ((PhoneContact)localObject1).name;
        label518:
        if (localRecentBaseData.mTitleName.equals(localRecentBaseData.a())) {
          localRecentBaseData.mTitleName = localRecentBaseData.mPhoneNumber;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, "getView mTitleName = " + localRecentBaseData.mTitleName);
        }
      }
      localablg.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localablg.jdField_b_of_type_AndroidWidgetTextView.setText(new axkd(this.jdField_a_of_type_JavaLangCharSequence, 5, 16, localRecentBaseData.a()));
      localablg.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mShowTime);
      if (localRecentBaseData.a() == 4000) {
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_Ajnf.d();
      }
      if ((!TextUtils.equals(localRecentBaseData.a(), ajed.az)) || (localRecentBaseData.a() != 7220))
      {
        j = paramInt;
        if (TextUtils.equals(localRecentBaseData.a(), ajed.ay))
        {
          j = paramInt;
          if (localRecentBaseData.a() != 1008) {}
        }
      }
      else
      {
        j = 1;
      }
      if (j + i != 0) {
        break label1924;
      }
      localablg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      label727:
      if (!localRecentBaseData.a().equals(ajed.ah))
      {
        paramView = paramViewGroup;
        if (!localRecentBaseData.a().equals(ajed.ag)) {
          break;
        }
      }
      localablg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      return paramViewGroup;
      paramInt = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.a(), localRecentBaseData.a());
      break label259;
      label815:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + ((List)localObject1).size());
      }
      Object localObject2 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      long l1 = localRecentBaseData.a();
      long l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
      if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject2).msgtype != -2016) && (((MessageRecord)localObject2).msgtype != -2009) && (((MessageRecord)localObject2).msgtype != -2026) && (localRecentBaseData.a() != 8))
      {
        this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.mLastMsg;
        localablg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        break label434;
      }
      this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).msg;
      localablg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-570319);
      break label434;
      label1035:
      localablg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_JavaLangCharSequence = ((String)localRecentBaseData.mMsgExtroInfo + localRecentBaseData.mLastMsg);
      localablg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      continue;
      label1092:
      if ((localRecentBaseData.a() == 1001) || (localRecentBaseData.a() == 1010) || (localRecentBaseData.a() == 10002))
      {
        if (localRecentBaseData.a().equals(ajed.ah))
        {
          localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131625880);
          this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131625879);
          localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayDateMsgNotifyCfg.name());
          if (((String)localObject1).length() > 0)
          {
            localObject1 = ((String)localObject1).split("\\|");
            if (localObject1.length >= 6)
            {
              localRecentBaseData.mTitleName = localObject1[4];
              this.jdField_a_of_type_JavaLangCharSequence = localObject1[5];
            }
          }
        }
        for (;;)
        {
          localablg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
          localablg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          if (localRecentBaseData.a().equals(ajed.ag))
          {
            localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131628085);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131628084);
            localObject1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.OneyWayLBSFriendMsgNotifyCfg.name());
            if (((String)localObject1).length() > 0)
            {
              localObject1 = ((String)localObject1).split("\\|");
              if (localObject1.length >= 6)
              {
                localRecentBaseData.mTitleName = localObject1[4];
                this.jdField_a_of_type_JavaLangCharSequence = localObject1[5];
              }
            }
          }
          else
          {
            QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
            if (localMessage.msgtype == -2053)
            {
              localObject1 = (MessageForNearbyLiveTip)awbi.a(-2053);
              ((MessageForNearbyLiveTip)localObject1).msgData = localMessage.msgData;
              ((MessageForNearbyLiveTip)localObject1).parse();
              localObject2 = ((MessageForNearbyLiveTip)localObject1).nickName;
              this.jdField_a_of_type_JavaLangCharSequence = (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getString(2131633432) + (String)localObject2 + ((MessageForNearbyLiveTip)localObject1).msg);
            }
            else
            {
              localObject2 = babh.q(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              this.jdField_a_of_type_JavaLangCharSequence = ((String)localObject1 + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
            }
          }
        }
      }
      if ((localRecentBaseData.a() != 1041) && (localRecentBaseData.a() != 1042)) {
        break label1600;
      }
      paramView = (RecentItemNoticeData)localRecentBaseData;
      this.jdField_a_of_type_JavaLangCharSequence = ((RecentItemNoticeData)localRecentBaseData).wording;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131628967);
      paramInt = 1;
    }
    label1600:
    if (localRecentBaseData.a() == 1)
    {
      localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.a(), localRecentBaseData.a());
      localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
      if ((!(localObject1 instanceof MessageForPubAccount)) || (((MessageForPubAccount)localObject1).isTextMsg())) {}
    }
    for (Object localObject1 = rsp.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), BaseApplicationImpl.getContext()) + ":";; localObject1 = "")
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((String)localObject1 + localRecentBaseData.mLastMsg);
      if (localRecentBaseData.a() == 7220)
      {
        localObject1 = ((KandianMergeManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(162)).b();
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaLangCharSequence = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject1, false);
        }
      }
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) && ((localRecentBaseData instanceof RecentItemTroopMsgData)))
      {
        localObject1 = ((RecentItemTroopMsgData)localRecentBaseData).a().msg;
        if ((localObject1 instanceof ahdy)) {
          this.jdField_a_of_type_JavaLangCharSequence = ((ahdy)localObject1).a;
        }
      }
      localablg.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      localablg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1880:
      localObject1 = ((aufb)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(140)).a(localRecentBaseData.a());
      if (localObject1 == null) {
        break label518;
      }
      localRecentBaseData.mTitleName = ((QCallCardInfo)localObject1).nickname;
      break label518;
      label1924:
      localablg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      beih.a(localablg.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, j + i, 0);
      break label727;
      label1951:
      localObject1 = null;
      break label503;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ablb
 * JD-Core Version:    0.7.0.1
 */