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
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
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
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class afgj
  extends blqv
{
  CharSequence jdField_a_of_type_JavaLangCharSequence = "";
  private ArrayList<RecentBaseData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public afgj(QQLSActivity paramQQLSActivity) {}
  
  private View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = paramView.getTag();
      if (!(paramViewGroup instanceof afgp)) {}
    }
    for (paramViewGroup = (afgp)paramViewGroup;; paramViewGroup = null)
    {
      RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      Object localObject = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561286, null);
        localObject = new afgp();
        ((afgp)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374386));
        ((afgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131374392));
        ((afgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
        ((afgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
        paramView.setTag(localObject);
      }
      ((afgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
      ((afgp)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mTitleName);
      ((afgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      blkk.a(((afgp)localObject).jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, 1, 0);
      return paramView;
    }
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    Object localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType());
    paramViewGroup = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType(), ((MessageRecord)localObject1).uniseq);
    if (((RecentBaseData)localObject3).getRecentUserType() == 1032) {
      paramViewGroup = aqyt.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageRecord)localObject1);
    }
    if (paramView != null)
    {
      localObject1 = paramView;
      if ((paramView.getTag() instanceof afgk)) {}
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561287, null);
      paramView = new afgk();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131374386));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131374391));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)((View)localObject1).findViewById(2131374392));
      ((View)localObject1).setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131374270));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131374265));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout = ((BreathAnimationLayout)((View)localObject1).findViewById(2131374266));
    }
    afgk localafgk = (afgk)((View)localObject1).getTag();
    localafgk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    int i = 0;
    if ((((RecentBaseData)localObject3).getRecentUserUin().equals(antf.ah)) || (((RecentBaseData)localObject3).getRecentUserUin().equals(antf.ai))) {
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
      if ((((RecentBaseData)localObject3).getRecentUserType() == 0) || (((RecentBaseData)localObject3).getRecentUserType() == 3000) || (((RecentBaseData)localObject3).getRecentUserType() == 8)) {
        if (j > 0)
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType());
          if ((paramView == null) || (paramView.size() <= 0))
          {
            this.jdField_a_of_type_JavaLangCharSequence = ((RecentBaseData)localObject3).mLastMsg;
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
            }
            localafgk.jdField_a_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject3).mTitleName);
            localafgk.jdField_b_of_type_AndroidWidgetTextView.setText(((RecentBaseData)localObject3).mShowTime);
            if (((RecentBaseData)localObject3).getRecentUserType() == 4000) {
              i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_Ajka.d();
            }
            if (i + j != 0) {
              break label1537;
            }
            localafgk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
            if ((((RecentBaseData)localObject3).getRecentUserUin().equals(antf.ai)) || (((RecentBaseData)localObject3).getRecentUserUin().equals(antf.ah))) {
              localafgk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
            }
            paramView = new BaseChatItemLayout(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
            paramView.setId(2131363324);
            paramView.setFocusableInTouchMode(true);
            paramView.setPadding(BaseChatItemLayout.t, BaseChatItemLayout.v, BaseChatItemLayout.u, 0);
            localafgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramView;
            if ((paramViewGroup instanceof MessageForPtt))
            {
              localObject2 = (MessageForPtt)paramViewGroup;
              paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramViewGroup);
              ((TextView)((View)localObject1).findViewById(2131374267)).setText(paramView);
              localObject3 = (ViewGroup.MarginLayoutParams)localafgk.jdField_a_of_type_ComTencentMobileqqActivityAioItemBreathAnimationLayout.getLayoutParams();
              if (paramView.equals("")) {
                break label1564;
              }
              ((ViewGroup.MarginLayoutParams)localObject3).setMargins(agej.a(5.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), agej.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
              j = ahnz.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), (MessageForPtt)localObject2);
              i = j;
              if (j == -1)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localafgk, (MessageForPtt)localObject2, false, true);
                i = 2001;
              }
              if (QLog.isColorLevel()) {
                QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + i + " url " + ((MessageForPtt)localObject2).url + " uniseq " + ((MessageForPtt)localObject2).uniseq);
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localafgk, (MessageForPtt)localObject2, i, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a((ChatMessage)localObject2));
              bewa.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), i, paramViewGroup);
              agid.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).a((View)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity);
              if ((QQLSActivity.b()) && (localafgk.jdField_a_of_type_JavaLangStringBuilder == null)) {
                localafgk.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
              }
              localafgk.jdField_b_of_type_Int = paramInt;
              localafgk.jdField_c_of_type_Int = paramInt;
              if (QQLSActivity.b())
              {
                localafgk.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setContentDescription(null);
                if (!TextUtils.isEmpty(localafgk.jdField_a_of_type_JavaLangStringBuilder)) {
                  localafgk.jdField_a_of_type_JavaLangStringBuilder.replace(0, localafgk.jdField_a_of_type_JavaLangStringBuilder.length(), "");
                }
                if ((!((ChatMessage)paramViewGroup).mNeedTimeStamp) || (paramViewGroup.time <= 0L)) {}
              }
            }
          }
        }
      }
      try
      {
        paramView = bhsw.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, 3, paramViewGroup.time * 1000L);
        localafgk.jdField_a_of_type_JavaLangStringBuilder.append(paramView).append(" ");
        localafgk.jdField_a_of_type_ComTencentMobileqqDataChatMessage = ((ChatMessage)paramViewGroup);
        bamk.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity)).b((MessageForPtt)localObject2);
        return localObject1;
        i = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType());
        j = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType());
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + paramView.size());
        }
        localObject2 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType());
        long l1 = ((RecentBaseData)localObject3).getLastMsgTime();
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
        if ((((RecentBaseData)localObject3).getRecentUserType() == 1001) || (((RecentBaseData)localObject3).getRecentUserType() == 1010) || (((RecentBaseData)localObject3).getRecentUserType() == 10002))
        {
          if (((RecentBaseData)localObject3).getRecentUserUin().equals(antf.ai))
          {
            ((RecentBaseData)localObject3).mTitleName = BaseApplicationImpl.getApplication().getString(2131691293);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131691292);
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
          if (((RecentBaseData)localObject3).getRecentUserUin().equals(antf.ah))
          {
            ((RecentBaseData)localObject3).mTitleName = BaseApplicationImpl.getApplication().getString(2131693195);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131693194);
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
          QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(((RecentBaseData)localObject3).getRecentUserUin(), ((RecentBaseData)localObject3).getRecentUserType());
          localObject2 = bhlg.q(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
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
        localafgk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
        blkk.a(localafgk.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, j + i, 0);
        break label464;
        label1564:
        ((ViewGroup.MarginLayoutParams)localObject3).setMargins(0, agej.a(7.0F, this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources()), 0, 0);
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
      QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
      if ((localRecentBaseData.getRecentUserType() == 1012) || (localRecentBaseData.getRecentUserType() == 7432) || (localRecentBaseData.getRecentUserType() == 1030) || (localRecentBaseData.getRecentUserType() == 1035)) {
        return 1;
      }
      if ((localMessage != null) && ((localMessage.msgtype == -2002) || (localMessage.msgtype == -1031))) {
        return 2;
      }
      if ((localMessage != null) && (localMessage.msgtype == -2025)) {
        return 3;
      }
      if (localRecentBaseData.getRecentUserType() == 9653) {
        return 4;
      }
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    System.currentTimeMillis();
    int m = getItemViewType(paramInt);
    if ((m == 1) || (m == 4)) {}
    for (View localView = b(paramInt, paramView, paramViewGroup);; localView = a(paramInt, paramView, paramViewGroup))
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (m != 2) {
        break;
      }
    }
    if (paramView != null)
    {
      localView = paramView;
      if ((paramView.getTag() instanceof afgo)) {}
    }
    else
    {
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getLayoutInflater().inflate(2131561285, null);
      paramView = new afgo();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131374386));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131374390));
      paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131374391));
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)localView.findViewById(2131374392));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131374393));
      localView.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
      paramView.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0);
    }
    RecentBaseData localRecentBaseData = (RecentBaseData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    afgo localafgo = (afgo)localView.getTag();
    localafgo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(Integer.valueOf(paramInt));
    int i = 0;
    int k = 0;
    if ((localRecentBaseData.getRecentUserUin().equals(antf.ah)) || (localRecentBaseData.getRecentUserUin().equals(antf.ai))) {
      i = 1;
    }
    int j;
    if (i != 0)
    {
      j = 0;
      i = k;
      label292:
      if (m == 3)
      {
        paramView = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
        if (paramView != null) {
          localRecentBaseData.mLastMsg = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, paramView, false);
        }
      }
      paramView = localRecentBaseData.mTitleName;
      if ((localRecentBaseData.getRecentUserType() != 0) && (localRecentBaseData.getRecentUserType() != 3000) && (localRecentBaseData.getRecentUserType() != 8)) {
        break label1156;
      }
      if (j <= 0) {
        break label1099;
      }
      localafgo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        break label879;
      }
      this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.mLastMsg;
      localafgo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
      }
      label467:
      localafgo.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mShowTime);
    }
    for (;;)
    {
      if ((localRecentBaseData.getRecentUserType() == 8) && (localRecentBaseData.mExtraType == 25))
      {
        localObject1 = (axfr)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(11);
        if (localObject1 == null) {
          break label2048;
        }
        localObject1 = ((axfr)localObject1).c(localRecentBaseData.mPhoneNumber);
        label536:
        if (localObject1 == null) {
          break label1977;
        }
        localRecentBaseData.mTitleName = ((PhoneContact)localObject1).name;
        label551:
        if (localRecentBaseData.mTitleName.equals(localRecentBaseData.getRecentUserUin())) {
          localRecentBaseData.mTitleName = localRecentBaseData.mPhoneNumber;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQLSActivity", 4, "getView mTitleName = " + localRecentBaseData.mTitleName);
        }
      }
      localafgo.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localafgo.jdField_b_of_type_AndroidWidgetTextView.setText(new begp(this.jdField_a_of_type_JavaLangCharSequence, 5, 16, localRecentBaseData.getRecentUserType()));
      localafgo.jdField_c_of_type_AndroidWidgetTextView.setText(localRecentBaseData.mShowTime);
      if (localRecentBaseData.getRecentUserType() == 4000) {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.jdField_a_of_type_Ajka.d();
      }
      if (((!TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.aA)) || (localRecentBaseData.getRecentUserType() != 7220)) && ((!TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.aR)) || (localRecentBaseData.getRecentUserType() != 1008)))
      {
        k = i;
        if (TextUtils.equals(localRecentBaseData.getRecentUserUin(), antf.az))
        {
          k = i;
          if (localRecentBaseData.getRecentUserType() != 1008) {}
        }
      }
      else
      {
        k = 1;
      }
      if (k + j != 0) {
        break label2021;
      }
      localafgo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(4);
      label788:
      if ((localRecentBaseData.getRecentUserUin().equals(antf.ai)) || (localRecentBaseData.getRecentUserUin().equals(antf.ah))) {
        localafgo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(8);
      }
      paramView = localView;
      break;
      i = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
      j = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
      break label292;
      label879:
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + ((List)localObject1).size());
      }
      Object localObject2 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
      long l1 = localRecentBaseData.getLastMsgTime();
      long l2 = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).time;
      if ((Long.valueOf(l1).longValue() >= Long.valueOf(l2).longValue()) && (((MessageRecord)localObject2).msgtype != -2016) && (((MessageRecord)localObject2).msgtype != -2009) && (((MessageRecord)localObject2).msgtype != -2026) && (localRecentBaseData.getRecentUserType() != 8))
      {
        this.jdField_a_of_type_JavaLangCharSequence = localRecentBaseData.mLastMsg;
        localafgo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
        break label467;
      }
      this.jdField_a_of_type_JavaLangCharSequence = ((MessageRecord)((List)localObject1).get(((List)localObject1).size() - 1)).msg;
      localafgo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-570319);
      break label467;
      label1099:
      localafgo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_JavaLangCharSequence = ((String)localRecentBaseData.mMsgExtroInfo + localRecentBaseData.mLastMsg);
      localafgo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      continue;
      label1156:
      if ((localRecentBaseData.getRecentUserType() == 1001) || (localRecentBaseData.getRecentUserType() == 1010) || (localRecentBaseData.getRecentUserType() == 10002))
      {
        if (localRecentBaseData.getRecentUserUin().equals(antf.ai))
        {
          localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131691293);
          this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131691292);
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
          localafgo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
          localafgo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          break;
          if (localRecentBaseData.getRecentUserUin().equals(antf.ah))
          {
            localRecentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(2131693195);
            this.jdField_a_of_type_JavaLangCharSequence = BaseApplicationImpl.getApplication().getString(2131693194);
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
            QQMessageFacade.Message localMessage = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
            if (localMessage.msgtype == -2053)
            {
              localObject1 = (MessageForNearbyLiveTip)bcry.a(-2053);
              ((MessageForNearbyLiveTip)localObject1).msgData = localMessage.msgData;
              ((MessageForNearbyLiveTip)localObject1).parse();
              localObject2 = ((MessageForNearbyLiveTip)localObject1).nickName;
              this.jdField_a_of_type_JavaLangCharSequence = (this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getString(2131698194) + (String)localObject2 + ((MessageForNearbyLiveTip)localObject1).msg);
            }
            else
            {
              localObject2 = bhlg.q(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localMessage.senderuin);
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              this.jdField_a_of_type_JavaLangCharSequence = ((String)localObject1 + ": " + QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, localMessage, false));
            }
          }
        }
      }
      if ((localRecentBaseData.getRecentUserType() != 1041) && (localRecentBaseData.getRecentUserType() != 1042)) {
        break label1665;
      }
      paramView = (RecentItemNoticeData)localRecentBaseData;
      this.jdField_a_of_type_JavaLangCharSequence = ((RecentItemNoticeData)localRecentBaseData).wording;
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity.getResources().getString(2131693984);
      i = 1;
    }
    label1665:
    if (localRecentBaseData.getRecentUserType() == 1)
    {
      localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().a(localRecentBaseData.getRecentUserUin(), localRecentBaseData.getRecentUserType());
      localObject1 = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq);
      if ((!(localObject1 instanceof MessageForPubAccount)) || (((MessageForPubAccount)localObject1).isTextMsg())) {}
    }
    for (Object localObject1 = tyi.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), BaseApplicationImpl.getContext()) + ":";; localObject1 = "")
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((String)localObject1 + localRecentBaseData.mLastMsg);
      if (10007 == localRecentBaseData.getRecentUserType()) {
        this.jdField_a_of_type_JavaLangCharSequence = avlf.a(QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity), localRecentBaseData, localRecentBaseData.mLastMsg);
      }
      if (localRecentBaseData.getRecentUserType() == 7220)
      {
        localObject1 = ((KandianMergeManager)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(162)).b();
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaLangCharSequence = QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).a().b(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity, (MessageRecord)localObject1, false);
        }
      }
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangCharSequence)) && ((localRecentBaseData instanceof RecentItemTroopMsgData)))
      {
        localObject1 = ((RecentItemTroopMsgData)localRecentBaseData).a().msg;
        if ((localObject1 instanceof alqt)) {
          this.jdField_a_of_type_JavaLangCharSequence = ((alqt)localObject1).a;
        }
      }
      localafgo.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-4210755);
      localafgo.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label1977:
      localObject1 = ((baok)QQLSActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQLSActivity).getManager(140)).a(localRecentBaseData.getRecentUserUin());
      if (localObject1 == null) {
        break label551;
      }
      localRecentBaseData.mTitleName = ((QCallCardInfo)localObject1).nickname;
      break label551;
      label2021:
      localafgo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setVisibility(0);
      blkk.a(localafgo.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 3, k + j, 0);
      break label788;
      label2048:
      localObject1 = null;
      break label536;
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgj
 * JD-Core Version:    0.7.0.1
 */