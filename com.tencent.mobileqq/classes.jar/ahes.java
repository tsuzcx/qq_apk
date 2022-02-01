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
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView;
import com.tencent.biz.qqcircle.widgets.QCircleGiftRecordView;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCirclePrivateMsgShow.PMGiftDisplayInfo;
import qqcircle.QQCirclePrivateMsgShow.PMGiftInfo;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;

public class ahes
  extends afuu
  implements View.OnClickListener
{
  private String a;
  
  public ahes(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo);
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(bgtn.a(paramInt1));
    localGradientDrawable.setColor(paramInt2);
    return localGradientDrawable;
  }
  
  private void a(ahev paramahev, QQCirclePrivateMsgShow.UserPMGiftInfo paramUserPMGiftInfo)
  {
    if ((paramahev == null) || (paramUserPMGiftInfo == null) || (!paramUserPMGiftInfo.has())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleChatIceBreakItemBuilder", 2, new Object[] { "bind icebreak data,chatUin:", paramUserPMGiftInfo.uid.get(), ",relation:", Integer.valueOf(paramUserPMGiftInfo.relation.get()), ",giftInfo size:", Integer.valueOf(paramUserPMGiftInfo.giftInfos.size()) });
    }
    this.jdField_a_of_type_JavaLangString = paramUserPMGiftInfo.uid.get();
    vrf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 2, 1);
    Object localObject1 = bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
    paramahev.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setAvatar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramUserPMGiftInfo.uid.get());
    paramahev.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    localObject1 = new FeedCloudMeta.StUser();
    ((FeedCloudMeta.StUser)localObject1).id.set(this.jdField_a_of_type_JavaLangString);
    paramahev.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setUserData((FeedCloudMeta.StUser)localObject1);
    paramahev.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setItemPreClickListener(new aheu(this));
    Object localObject2;
    if (paramUserPMGiftInfo.giftInfos.has())
    {
      localObject1 = paramUserPMGiftInfo.giftInfos.get();
      if (paramahev.jdField_b_of_type_AndroidWidgetLinearLayout.getChildCount() > 0) {
        paramahev.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        int i = 0;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (QQCirclePrivateMsgShow.PMGiftInfo)((Iterator)localObject1).next();
          if ((localObject2 == null) || (!((QQCirclePrivateMsgShow.PMGiftInfo)localObject2).has())) {
            break label518;
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
            paramahev.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localQCircleGiftRecordView, (ViewGroup.LayoutParams)localObject2);
            i += 1;
          }
        }
      }
    }
    label518:
    for (;;)
    {
      break;
      ((LinearLayout.LayoutParams)localObject2).leftMargin = bgtn.b(8.0F);
      break label408;
      if ((paramUserPMGiftInfo.relation.get() == 1) || (paramUserPMGiftInfo.relation.get() == 2))
      {
        paramahev.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        ((LinearLayout.LayoutParams)paramahev.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams()).height = bgtn.b(78.0F);
        return;
      }
      paramahev.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      ((LinearLayout.LayoutParams)paramahev.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams()).height = bgtn.b(73.0F);
      return;
    }
  }
  
  protected afuv a()
  {
    return new ahev();
  }
  
  protected View a(MessageRecord paramMessageRecord, afuv paramafuv, View paramView, LinearLayout paramLinearLayout, afzq paramafzq)
  {
    ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    paramafzq = ((MessageForQCircleIceBreak)paramMessageRecord).getExtInfoFromExtStr("qcircle_chat_msg_data_key");
    paramMessageRecord = paramView;
    if (!TextUtils.isEmpty(paramafzq)) {
      paramLinearLayout = new QQCirclePrivateMsgShow.UserPMGiftInfo();
    }
    try
    {
      paramLinearLayout.mergeFrom(paramafzq.getBytes());
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
    if ((paramafuv instanceof ahev)) {}
    for (paramMessageRecord = (ahev)paramafuv;; paramMessageRecord = null)
    {
      if ((paramView == null) || (paramMessageRecord == null))
      {
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560673, null);
        paramMessageRecord = new LinearLayout.LayoutParams(bgtn.b(298.0F), -2);
        paramMessageRecord.topMargin = bgtn.b(24.0F);
        paramMessageRecord.gravity = 1;
        paramView.setLayoutParams(paramMessageRecord);
        paramMessageRecord = new ahev();
        paramView.setTag(paramMessageRecord);
      }
      for (;;)
      {
        paramMessageRecord.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370136);
        paramafuv = a(12, -1);
        paramMessageRecord.jdField_b_of_type_AndroidViewView.setBackgroundDrawable(paramafuv);
        paramMessageRecord.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramView.findViewById(2131366694));
        paramMessageRecord.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView = ((QCircleAvatarView)paramView.findViewById(2131369037));
        paramMessageRecord.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleAvatarView.setOnClickListener(this);
        paramMessageRecord.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379783));
        paramMessageRecord.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131370081));
        paramMessageRecord.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131366693));
        paramMessageRecord.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView = ((QCircleFollowView)paramView.findViewById(2131379672));
        paramMessageRecord.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView.setFollowStateChangeListener(new ahet(this, paramMessageRecord));
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
  
  public bguj[] a(View paramView)
  {
    return new bguj[0];
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369037)
    {
      uxo.a(this.jdField_a_of_type_JavaLangString, new QCircleReportBean());
      vrf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 45, 2, 2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahes
 * JD-Core Version:    0.7.0.1
 */