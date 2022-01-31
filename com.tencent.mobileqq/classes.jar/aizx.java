import android.os.Bundle;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.5;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

public class aizx
  implements ajid
{
  public aizx(CmGameServerQIPCModule.5 param5) {}
  
  public void a(boolean paramBoolean, String paramString, List<ajib> paramList)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.g = 6;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.jdField_a_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.jdField_a_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext.b;
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.jdField_e_of_type_Int >= 1) {
        this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.b = this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext.jdField_a_of_type_JavaLangString;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.jdField_a_of_type_Int = this.a.b;
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.l = this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowRenderView$PlayActionConfig.c;
      paramString = ajgl.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam, this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext, this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowRenderView$PlayActionConfig);
      this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam.jdField_e_of_type_JavaLangString = paramString;
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam;
      if (this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkCmShowRenderView$PlayActionConfig.jdField_a_of_type_Boolean)
      {
        paramString.m = i;
        paramString = new Bundle();
        paramString.putParcelable("IPCSpriteContext", this.a.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext);
        paramString.putParcelable("SpriteTaskParam", this.a.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteTaskParam);
        paramString = EIPCResult.createSuccessResult(paramString);
        this.a.this$0.callbackResult(this.a.c, paramString);
      }
    }
    for (;;)
    {
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
      i = 0;
      break;
      paramString = EIPCResult.createResult(-1, null);
      this.a.this$0.callbackResult(this.a.c, paramString);
    }
  }
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {}
    for (paramInt1 = 0;; paramInt1 = -1)
    {
      paramString = EIPCResult.createResult(paramInt1, null);
      this.a.this$0.callbackResult(this.a.c, paramString);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aizx
 * JD-Core Version:    0.7.0.1
 */