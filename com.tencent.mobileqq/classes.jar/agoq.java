import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class agoq
  implements ArkViewImplement.LoadCallback
{
  agoq(agop paramagop, MessageForArkApp paramMessageForArkApp, agol paramagol) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer.getContainerRect();
    float f = ArkAppCenterUtil.getDensity();
    int i = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
    int j = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
    localObject = this.jdField_a_of_type_Agol.a.getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
    localStringBuilder.append(i).append(",").append(j).append(")").append(", arkView layout rect(").append(((ViewGroup.LayoutParams)localObject).width).append(",").append(((ViewGroup.LayoutParams)localObject).height).append(")").append(", init mArkWidth=").append(agop.a(this.jdField_a_of_type_Agop)).append(", load state=").append(paramInt).append(", app=").append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName);
    QLog.i("ArkAppItemBuilder", 1, localStringBuilder.toString());
    if ((ArkAppCenterUtil.sIsFoldStrategyEnable) && (paramInt == 1) && (Math.abs(((ViewGroup.LayoutParams)localObject).width - agop.a(this.jdField_a_of_type_Agop)) > 5))
    {
      QLog.d("ArkAppItemBuilder", 1, new Object[] { "ArkFold.onLoadFinish setViewRect(", Integer.valueOf(agop.a(this.jdField_a_of_type_Agop)), ",", Integer.valueOf(j), ")" });
      this.jdField_a_of_type_Agol.a.setFixSize(agop.a(this.jdField_a_of_type_Agop), -1);
      this.jdField_a_of_type_Agol.a.setMaxSize(agop.a(this.jdField_a_of_type_Agop), -1);
      this.jdField_a_of_type_Agol.a.setMinSize(agop.a(this.jdField_a_of_type_Agop), -1);
      this.jdField_a_of_type_Agol.a.setViewRect(agop.a(this.jdField_a_of_type_Agop), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoq
 * JD-Core Version:    0.7.0.1
 */