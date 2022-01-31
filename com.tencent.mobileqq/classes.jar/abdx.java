import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.ark.ArkHorizontalListView;
import com.tencent.mobileqq.ark.ArkHorizontalListViewAdapter;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkRecommendController.AttachAppHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class abdx
  implements View.OnTouchListener
{
  public abdx(ArkRecommendController paramArkRecommendController, ImageView paramImageView, RecommendCommonMessage paramRecommendCommonMessage, Context paramContext, View paramView, ArkRecommendController.AttachAppHolder paramAttachAppHolder, BaseChatItemLayout paramBaseChatItemLayout, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, boolean paramBoolean, ChatMessage paramChatMessage) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject1;
    Object localObject2;
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        return true;
        if (Build.VERSION.SDK_INT >= 16) {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(127);
        } else {
          this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(127);
        }
      }
    case 1: 
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mOldAppInfo.appName;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mOldAppInfo.keyword;
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mOldAppInfo.appView;
      if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList.size() > 0)
      {
        localObject2 = (RecommendCommonMessage.ArkContextInfo)this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList.get(0);
        if ((localObject2 != null) && (((RecommendCommonMessage.ArkContextInfo)localObject2).contextAppInfoList.size() > 0))
        {
          localObject2 = (RecommendCommonMessage.ArkMsgAppInfo)((RecommendCommonMessage.ArkContextInfo)localObject2).contextAppInfoList.get(0);
          if (localObject2 != null)
          {
            paramMotionEvent = ((RecommendCommonMessage.ArkMsgAppInfo)localObject2).appName;
            localObject1 = ((RecommendCommonMessage.ArkMsgAppInfo)localObject2).keyword;
            paramView = ((RecommendCommonMessage.ArkMsgAppInfo)localObject2).appView;
          }
        }
      }
      break;
    }
    for (;;)
    {
      int i;
      label527:
      label552:
      int j;
      if (NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
      {
        i = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.jdField_a_of_type_AndroidViewView.measure(i, i);
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel()) {
          QLog.d("ArkRecommendController", 2, "getAttachButton click ark icon msg.mIsShow=" + this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mIsShow);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mIsShow)
        {
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_Boolean = true;
          if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_AndroidViewView != null) {
            this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView != null)
          {
            localObject2 = (ArkHorizontalListViewAdapter)this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.a();
            ((ArkHorizontalListViewAdapter)localObject2).a(((ArkHorizontalListViewAdapter)localObject2).getCount());
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (RecommendCommonMessage.ArkContextInfo)((Iterator)localObject2).next();
              if (localObject3 != null)
              {
                localObject3 = ((RecommendCommonMessage.ArkContextInfo)localObject3).contextAppInfoList.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  localObject4 = (RecommendCommonMessage.ArkMsgAppInfo)((Iterator)localObject3).next();
                  if (localObject4 != null) {
                    ((RecommendCommonMessage.ArkMsgAppInfo)localObject4).mOpenCardAppInfoList.clear();
                  }
                }
              }
            }
            this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_ComTencentMobileqqArkArkHorizontalListView.setVisibility(8);
            if (QLog.isColorLevel()) {
              QLog.d("ArkRecommendController", 2, "getAttachButton set ark list gone at point 1");
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.setPadding(0, BaseChatItemLayout.u, 0, 0);
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mIsShow = false;
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.saveRecommendMsg(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a, this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.h, false);
          if (ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController) != null)
          {
            ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, 1);
            ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage);
          }
          if (AppSetting.b)
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mIsShow) {
              break label851;
            }
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("点击收拢");
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mIsShow) {
            break label890;
          }
          ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMotionEvent, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType, (String)localObject1);
          if (4 == this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType) {
            ArkAppDataReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMotionEvent, 0, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType, (String)localObject1);
          }
          localObject1 = (ArkAppHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(95);
          if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.isFromArkServer) {
            break label878;
          }
          i = 2;
          label641:
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerExtraInfo;
          Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerMsgId;
          Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.msg;
          if (!"1".equals(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
            break label884;
          }
          j = 1;
          label690:
          ((ArkAppHandler)localObject1).a(i, 2, 2, (String)localObject2, (String)localObject3, paramMotionEvent, paramView, (String)localObject4, j, 0);
        }
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT < 16) {
          break label942;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(255);
        break;
        if (ArkAiAppCenter.l)
        {
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a(null, 0, false, true, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener, this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder, this.jdField_a_of_type_Boolean, -2);
          break label527;
        }
        ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener, this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder, this.jdField_a_of_type_Boolean, -2);
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a(3, paramMotionEvent, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, null);
        break label527;
        label851:
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("点击展开");
        break label552;
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131434827, 1);
        break label552;
        label878:
        i = 100;
        break label641;
        label884:
        j = 0;
        break label690;
        label890:
        ArkAppDataReport.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMotionEvent, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType);
        if (4 == this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType) {
          ArkAppDataReport.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMotionEvent, 0, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType);
        }
      }
      label942:
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
      break;
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageAlpha(255);
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(255);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abdx
 * JD-Core Version:    0.7.0.1
 */