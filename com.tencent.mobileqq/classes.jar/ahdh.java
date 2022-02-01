import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.local.widgets.QCircleAvatarView;
import com.tencent.biz.qcircleshadow.local.widgets.QCircleFollowView;
import com.tencent.biz.qcircleshadow.local.widgets.QCircleGiftRecordView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudMeta.StUser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCirclePrivateMsgShow.PMGiftDisplayInfo;
import qqcircle.QQCirclePrivateMsgShow.PMGiftInfo;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class ahdh
  extends afor
  implements View.OnClickListener
{
  private String a;
  
  public ahdh(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.dip2px(paramInt1));
    localGradientDrawable.setColor(paramInt2);
    return localGradientDrawable;
  }
  
  private void a(ahdk paramahdk, QQCirclePrivateMsgShow.UserPMGiftInfo paramUserPMGiftInfo)
  {
    if ((paramahdk == null) || (paramUserPMGiftInfo == null) || (!paramUserPMGiftInfo.has())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleChatIceBreakItemBuilder", 2, new Object[] { "bind icebreak data,chatUin:", paramUserPMGiftInfo.uid.get(), ",relation:", Integer.valueOf(paramUserPMGiftInfo.relation.get()), ",giftInfo size:", Integer.valueOf(paramUserPMGiftInfo.giftInfos.size()) });
    }
    this.jdField_a_of_type_JavaLangString = paramUserPMGiftInfo.uid.get();
    QCircleLpReportDc05504.report(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 45, 2, 1);
    Object localObject1 = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
    paramahdk.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleAvatarView.setAvatar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramUserPMGiftInfo.uid.get());
    paramahdk.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    localObject1 = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject1).id.set(this.jdField_a_of_type_JavaLangString);
    paramahdk.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)localObject1);
    paramahdk.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.setItemPreClickListener(new ahdj(this));
    Object localObject2;
    if (paramUserPMGiftInfo.giftInfos.has())
    {
      localObject1 = paramUserPMGiftInfo.giftInfos.get();
      if (paramahdk.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
        paramahdk.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QQCirclePrivateMsgShow.PMGiftInfo)((Iterator)localObject1).next();
          if ((localObject2 == null) || (!((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).has())) {
            break label519;
          }
          QCircleGiftRecordView localQCircleGiftRecordView = new QCircleGiftRecordView(this.jdField_a_of_type_AndroidContentContext);
          QQCirclePrivateMsgShow.PMGiftDisplayInfo localPMGiftDisplayInfo = (QQCirclePrivateMsgShow.PMGiftDisplayInfo)((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).display.get();
          if ((localPMGiftDisplayInfo != null) && (localPMGiftDisplayInfo.has()))
          {
            localQCircleGiftRecordView.setIconUrl(localPMGiftDisplayInfo.icon.get());
            localQCircleGiftRecordView.setUIStyle(localPMGiftDisplayInfo.numberColor.get(), localPMGiftDisplayInfo.backgroudColor.get());
          }
          localQCircleGiftRecordView.setGiftCount(((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).giftCnt.get(), false);
          localObject2 = new LinearLayout.LayoutParams(-2, -1);
          ((LinearLayout.LayoutParams)localObject2).gravity = 17;
          if (i == 0)
          {
            ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
            label408:
            paramahdk.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localQCircleGiftRecordView, (ViewGroup.LayoutParams)localObject2);
            i += 1;
          }
        }
      }
    }
    label519:
    for (;;)
    {
      break;
      ((LinearLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dpToPx(8.0F);
      break label408;
      if ((paramUserPMGiftInfo.relation.get() == 1) || (paramUserPMGiftInfo.relation.get() == 2))
      {
        paramahdk.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        ((LinearLayout.LayoutParams)paramahdk.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams()).height = ViewUtils.dpToPx(78.0F);
        return;
      }
      paramahdk.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((LinearLayout.LayoutParams)paramahdk.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams()).height = ViewUtils.dpToPx(73.0F);
      return;
    }
  }
  
  protected afos a()
  {
    return new ahdk();
  }
  
  protected View a(MessageRecord paramMessageRecord, afos paramafos, View paramView, LinearLayout paramLinearLayout, aftk paramaftk)
  {
    ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    paramaftk = ((MessageForQCircleIceBreak)paramMessageRecord).getExtInfoFromExtStr("qcircle_chat_msg_data_key");
    paramMessageRecord = paramView;
    if (!TextUtils.isEmpty(paramaftk)) {
      paramLinearLayout = new QQCirclePrivateMsgShow.UserPMGiftInfo();
    }
    try
    {
      paramLinearLayout.mergeFrom(paramaftk.getBytes());
      if (!paramLinearLayout.has())
      {
        QLog.e("QCircleChatIceBreakItemBuilder", 1, "getItemView miss userGiftInfos");
        paramMessageRecord = null;
        return paramMessageRecord;
      }
    }
    catch (InvalidProtocolBufferMicroException paramMessageRecord)
    {
      for (;;)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    if ((paramafos instanceof ahdk)) {}
    for (paramMessageRecord = (ahdk)paramafos;; paramMessageRecord = null)
    {
      if ((paramView == null) || (paramMessageRecord == null))
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560750, null);
        paramMessageRecord = new LinearLayout.LayoutParams(ViewUtils.dpToPx(298.0F), -2);
        paramMessageRecord.topMargin = ViewUtils.dpToPx(24.0F);
        paramMessageRecord.gravity = 1;
        paramView.setLayoutParams(paramMessageRecord);
        paramMessageRecord = new ahdk();
        paramView.setTag(paramMessageRecord);
      }
      for (;;)
      {
        paramMessageRecord.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370386);
        paramafos = a(12, -1);
        paramMessageRecord.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramafos);
        paramMessageRecord.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366887));
        paramMessageRecord.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369321));
        paramMessageRecord.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleAvatarView.setOnClickListener(this);
        paramMessageRecord.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380042));
        paramMessageRecord.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370337));
        paramMessageRecord.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366886));
        paramMessageRecord.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131379937));
        paramMessageRecord.jdField_a_of_type_ComTencentBizQcircleshadowLocalWidgetsQCircleFollowView.setFollowStateChangeListener(new ahdi(this, paramMessageRecord));
        a(paramMessageRecord, paramLinearLayout);
        return paramView;
      }
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("QCircleChatIceBreakItemBuilder", 2, "destroy ");
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage) {}
  
  public bhjs[] a(View paramView)
  {
    return new bhjs[0];
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369321)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", this.jdField_a_of_type_JavaLangString);
      vvh.a(BaseApplicationImpl.context, "openmainpage", localHashMap);
      QCircleLpReportDc05504.report(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, 45, 2, 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahdh
 * JD-Core Version:    0.7.0.1
 */