import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.ark.ArkLocalAppMgr.IGetLocalAppPath;
import com.tencent.mobileqq.ark.ArkRecommendController.AttachAppHolder;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.IGetAppInfosByContextListCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

public final class aaqr
  extends RecommendCommonMessage.IGetAppInfosByContextListCallback
  implements ArkLocalAppMgr.IGetLocalAppPath
{
  private int jdField_a_of_type_Int;
  private ArkRecommendController.AttachAppHolder jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder;
  private RecommendCommonMessage jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public aaqr(RecommendCommonMessage paramRecommendCommonMessage, ArkRecommendController.AttachAppHolder paramAttachAppHolder, WeakReference paramWeakReference, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = paramRecommendCommonMessage;
    this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder = paramAttachAppHolder;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    label88:
    String str1;
    String str2;
    Object localObject;
    if ((paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_Int != 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkRecommendController", 2, "ArkRecommendController.loadIcon.reuse");
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mHasReportShowIcon) || (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mHasReportShowIconEach))
      {
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break label613;
        }
        paramString1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        str1 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mOldAppInfo.appView;
        str2 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mOldAppInfo.keyword;
        if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList.size() <= 0) {
          break label642;
        }
        localObject = (RecommendCommonMessage.ArkContextInfo)this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList.get(0);
        if ((localObject == null) || (((RecommendCommonMessage.ArkContextInfo)localObject).contextAppInfoList.size() <= 0)) {
          break label642;
        }
        localObject = (RecommendCommonMessage.ArkMsgAppInfo)((RecommendCommonMessage.ArkContextInfo)localObject).contextAppInfoList.get(0);
        if ((localObject == null) || (!paramString2.equals(((RecommendCommonMessage.ArkMsgAppInfo)localObject).appName))) {
          break label642;
        }
        str1 = ((RecommendCommonMessage.ArkMsgAppInfo)localObject).appView;
        str2 = ((RecommendCommonMessage.ArkMsgAppInfo)localObject).keyword;
      }
    }
    label642:
    for (;;)
    {
      int i;
      label282:
      String str3;
      if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mHasReportShowIcon)
      {
        ArkAppDataReport.a(null, paramString2, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType);
        if (4 == this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType) {
          ArkAppDataReport.a(null, paramString2, 0, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType);
        }
        if (paramString1 != null)
        {
          localObject = (ArkAppHandler)paramString1.a(95);
          if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.isFromArkServer)
          {
            i = 2;
            str3 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerExtraInfo;
            String str4 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerMsgId;
            String str5 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.msg;
            if (!"1".equals(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
              break label624;
            }
            j = 1;
            label329:
            ((ArkAppHandler)localObject).a(i, 2, 1, str3, str4, paramString2, str1, str5, j, 1);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mHasReportShowIcon = true;
          this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.saveRecommendMsg(this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_Int, false);
        }
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mHasReportShowIconEach)
      {
        ArkAppDataReport.c(null, paramString2, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType, str2);
        if (4 == this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mEchoType) {
          ArkAppDataReport.c(null, paramString2, 0, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextMatchType, str2);
        }
        if (paramString1 != null)
        {
          paramString1 = (ArkAppHandler)paramString1.a(95);
          if (!this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.isFromArkServer) {
            break label630;
          }
          i = 2;
          label457:
          str2 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerExtraInfo;
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.arkServerMsgId;
          str3 = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.msg;
          if (!"1".equals(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.getExtInfoFromExtStr("ark_text_analysis_flag"))) {
            break label636;
          }
        }
      }
      label613:
      label624:
      label630:
      label636:
      for (int j = 1;; j = 0)
      {
        paramString1.a(i, 2, 1, str2, (String)localObject, paramString2, str1, str3, j, 0);
        this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mHasReportShowIconEach = true;
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_Int == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130838197));
          ArkAppCenter.a(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_JavaLangString = paramString1;
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_Int = 1;
        ArkAppCenter.a(paramString1, new aaqt(this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder));
        break;
        paramString1 = null;
        break label88;
        i = 100;
        break label282;
        j = 0;
        break label329;
        i = 100;
        break label457;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mOldAppInfo.appName)) {
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mOldAppInfo.appPath = paramString;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mIconAppPath = paramString;
    a(paramString, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mOldAppInfo.appName);
  }
  
  public void onGetAppInfos(ArrayList paramArrayList)
  {
    if (paramArrayList.size() <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController$AttachAppHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    paramArrayList = (RecommendCommonMessage.ArkMsgAppInfo)paramArrayList.get(0);
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mIconAppPath = paramArrayList.appPath;
    a(paramArrayList.appPath, paramArrayList.appName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqr
 * JD-Core Version:    0.7.0.1
 */