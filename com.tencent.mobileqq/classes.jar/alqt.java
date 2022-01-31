import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.RecommendCommonMessage;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkContextInfo;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedList;

public class alqt
  implements alqw
{
  public int a;
  public RecommendCommonMessage.ArkMsgAppInfo a;
  public RecommendCommonMessage a;
  public int b;
  public int c;
  
  private void a(alto paramalto, alts paramalts)
  {
    paramalto = new alqv(this, paramalto);
    paramalts.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramalto);
  }
  
  private void a(Context paramContext)
  {
    new bcqr(paramContext).a(2131719262, paramContext.getResources().getDimensionPixelSize(2131298865), 1, 0);
  }
  
  public void attachArkView(alto paramalto, alts paramalts, int paramInt)
  {
    paramalts.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130844080);
    ArkAppView localArkAppView = paramalts.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
    localArkAppView.setBorderType(3);
    localArkAppView.setClipRadiusTop(16.0F);
    localArkAppView.setClipRadius(0.0F);
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer = new adli();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a(paramalto);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a = new ArkAppMessage.Config();
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer.a.autoSize = Integer.valueOf(1);
      altc.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), "ShowView", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, null, altc.f, 0, 0);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer;
    if (this.c > 0) {
      ((adli)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, alsz.a(), this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo, paramalto.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    for (;;)
    {
      ((adli)localObject).setFixSize(alsz.jdField_a_of_type_Int, alsz.jdField_a_of_type_Int);
      ((adli)localObject).setMaxSize(alsz.jdField_a_of_type_Int, alsz.jdField_a_of_type_Int);
      ((adli)localObject).setMinSize(alsz.jdField_a_of_type_Int * 7 / 10, alsz.jdField_a_of_type_Int);
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView appName:", this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ", getChatbubbleMaxWidth=", Integer.valueOf(alsz.jdField_a_of_type_Int) });
      localObject = new alqu(this, paramalts, paramalto, paramInt, (adli)localObject);
      paramalts.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer, paramalts.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
      localArkAppView.setOnTouchListener(paramalto.jdField_a_of_type_Acxj);
      localArkAppView.setOnLongClickListener(paramalto.jdField_a_of_type_Acxj);
      localArkAppView.setLoadCallback((ArkViewImplement.LoadCallback)localObject);
      return;
      ((adli)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appVer, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta, alsz.a(), this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage, paramalto.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
  
  public void clickTail(alts paramalts, adlw paramadlw, Context paramContext) {}
  
  public void destroyContainerByRemove()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.doOnEvent(2);
  }
  
  public alqw extendArkCardByOpen(adlj paramadlj, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mArkContainer == paramadlj)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage.mContextList;
      int i = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.size();
      if (((ArrayList)localObject).size() == 1)
      {
        localObject = ((RecommendCommonMessage.ArkContextInfo)((ArrayList)localObject).get(0)).contextAppInfoList;
        if ((((LinkedList)localObject).size() == 1) && (i >= alua.jdField_a_of_type_Int - 1)) {
          return null;
        }
        if ((((LinkedList)localObject).size() > 1) && (i >= alua.c - 1)) {
          return null;
        }
      }
      else if ((((ArrayList)localObject).size() > 1) && (i >= alua.c - 1))
      {
        return null;
      }
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject == null) {
        return null;
      }
      localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(121);
      localObject = new alqt();
      ((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage;
      ((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo = new RecommendCommonMessage.ArkMsgAppInfo();
      ((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName = paramadlj.getAppName();
      ((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appPath = ArkAppMgr.getInstance().getAppPathByNameFromLocal(((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, ((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, null, false);
      ((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView = paramString1;
      ((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.meta = paramString2;
      ((alqt)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      ((alqt)localObject).b = this.b;
      ((alqt)localObject).c = (this.b + 1);
      this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.mOpenCardAppInfoList.add(0, ((alqt)localObject).jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo);
      return localObject;
    }
    return null;
  }
  
  public String[] getArkAppNameAndPath()
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName;
    arrayOfString[1] = null;
    arrayOfString[2] = null;
    if ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime() == null) {
      return arrayOfString;
    }
    arrayOfString[1] = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appName, this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView, null, false);
    arrayOfString[2] = this.jdField_a_of_type_ComTencentMobileqqDataRecommendCommonMessage$ArkMsgAppInfo.appView;
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alqt
 * JD-Core Version:    0.7.0.1
 */