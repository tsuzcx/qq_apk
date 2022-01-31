import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkAiInfo;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.ArkLocalAppMgr;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class aaxb
  implements Runnable
{
  public aaxb(ArkAppModuleReg.ModuleQQ paramModuleQQ, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public void run()
  {
    Object localObject1;
    if (this.jdField_a_of_type_JavaLangString.equals("fullscreen"))
    {
      ArkAppDataReport.j(null, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString);
      if ((BaseActivity.sTopActivity instanceof FragmentActivity))
      {
        localObject1 = (FragmentActivity)BaseActivity.sTopActivity;
        ArkAppDataReport.k(null, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString);
        ArkFullScreenAppActivity.a((Context)localObject1, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString, this.b, "0.0.0.1", this.c, ((FragmentActivity)localObject1).getResources().getDisplayMetrics().scaledDensity, null, 0);
      }
    }
    do
    {
      do
      {
        do
        {
          Object localObject3;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (!this.jdField_a_of_type_JavaLangString.equals("input")) {
                    break;
                  }
                } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
                localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
              } while (localObject1 == null);
              localObject1 = ((ChatFragment)localObject1).a();
            } while (localObject1 == null);
            localObject2 = ((ArkAppCenter)ArkAppModuleReg.a().getManager(120)).a().a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString, null);
            localObject3 = new ArrayList();
            ArkAiInfo localArkAiInfo = new ArkAiInfo();
            localArkAiInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString;
            localArkAiInfo.d = ((String)localObject2);
            localArkAiInfo.f = this.c;
            localArkAiInfo.b = this.b;
            ((List)localObject3).add(localArkAiInfo);
            ((BaseChatPie)localObject1).a.a((List)localObject3, 0);
            return;
            if (!this.jdField_a_of_type_JavaLangString.equals("popup")) {
              break;
            }
            localObject1 = BaseActivity.sTopActivity;
          } while (!(localObject1 instanceof FragmentActivity));
          Object localObject2 = QQCustomArkDialog.AppInfo.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString, this.b, "0.0.0.1", this.c, ((BaseActivity)localObject1).getResources().getDisplayMetrics().scaledDensity, null, null);
          if (ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ) != null)
          {
            localObject3 = (QQCustomDialog)ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ).get();
            if ((localObject3 != null) && (((QQCustomDialog)localObject3).isShowing())) {
              ((QQCustomDialog)localObject3).dismiss();
            }
          }
          localObject2 = DialogUtil.b((Context)localObject1, null, (Bundle)localObject2);
          ((QQCustomDialog)localObject2).setNegativeButton(2131433029, null);
          ((QQCustomDialog)localObject2).setPositiveButton(2131433030, null);
          ArkAppModuleReg.ModuleQQ.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ, new WeakReference(localObject2));
          ((QQCustomDialog)localObject2).show();
          ArkAppDataReport.d(((BaseActivity)localObject1).app, this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppModuleReg$ModuleQQ.jdField_a_of_type_JavaLangString, ArkAppDataReport.i, 0);
          return;
          if (!this.jdField_a_of_type_JavaLangString.equals("card")) {
            break;
          }
          localObject1 = ark.arkGetContainer(this.jdField_a_of_type_Long);
          QLog.d("ArkOpenView", 1, "OpenView card container=" + localObject1);
        } while (localObject1 == null);
        localObject1 = (ArkAppContainer)ArkAppContainer.a((ark.Container)localObject1).get();
      } while (localObject1 == null);
      ((ArkAppContainer)localObject1).a(this.b, this.c);
      return;
    } while ((!this.jdField_a_of_type_JavaLangString.equals("bottom_card")) || (!(BaseActivity.sTopActivity instanceof FragmentActivity)));
    ArkFullScreenAppActivity.a((FragmentActivity)BaseActivity.sTopActivity, "com.tencent.cmgame.intent", "GameCard", this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxb
 * JD-Core Version:    0.7.0.1
 */