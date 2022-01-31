import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class admd
  implements ArkViewImplement.LoadCallback
{
  admd(admc paramadmc, MessageForArkApp paramMessageForArkApp, adly paramadly) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer.getContainerRect();
    float f = alta.a();
    int i = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
    int j = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
    localObject = this.jdField_a_of_type_Adly.a.getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
    localStringBuilder.append(i).append(",").append(j).append(")").append(", arkView layout rect(").append(((ViewGroup.LayoutParams)localObject).width).append(",").append(((ViewGroup.LayoutParams)localObject).height).append(")").append(", init mArkWidth=").append(admc.a(this.jdField_a_of_type_Admc)).append(", load state=").append(paramInt).append(", app=").append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName);
    QLog.i("ArkAppItemBuilder", 1, localStringBuilder.toString());
    if ((alta.a) && (paramInt == 1) && (i != admc.a(this.jdField_a_of_type_Admc)))
    {
      QLog.d("ArkAppItemBuilder", 1, new Object[] { "ArkFold.onLoadFinish setViewRect(", Integer.valueOf(admc.a(this.jdField_a_of_type_Admc)), ",", Integer.valueOf(j), ")" });
      this.jdField_a_of_type_Adly.a.setFixSize(admc.a(this.jdField_a_of_type_Admc), -1);
      this.jdField_a_of_type_Adly.a.setMaxSize(admc.a(this.jdField_a_of_type_Admc), -1);
      this.jdField_a_of_type_Adly.a.setMinSize(admc.a(this.jdField_a_of_type_Admc), -1);
      this.jdField_a_of_type_Adly.a.setViewRect(admc.a(this.jdField_a_of_type_Admc), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admd
 * JD-Core Version:    0.7.0.1
 */