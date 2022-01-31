import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class admb
  implements ArkViewImplement.LoadCallback
{
  admb(adma paramadma, MessageForArkApp paramMessageForArkApp, adlw paramadlw) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer.getContainerRect();
    float f = alsz.a();
    int i = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
    int j = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
    localObject = this.jdField_a_of_type_Adlw.a.getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
    localStringBuilder.append(i).append(",").append(j).append(")").append(", arkView layout rect(").append(((ViewGroup.LayoutParams)localObject).width).append(",").append(((ViewGroup.LayoutParams)localObject).height).append(")").append(", init mArkWidth=").append(adma.a(this.jdField_a_of_type_Adma)).append(", load state=").append(paramInt).append(", app=").append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName);
    QLog.i("ArkAppItemBuilder", 1, localStringBuilder.toString());
    if ((alsz.a) && (paramInt == 1) && (i != adma.a(this.jdField_a_of_type_Adma)))
    {
      QLog.d("ArkAppItemBuilder", 1, new Object[] { "ArkFold.onLoadFinish setViewRect(", Integer.valueOf(adma.a(this.jdField_a_of_type_Adma)), ",", Integer.valueOf(j), ")" });
      this.jdField_a_of_type_Adlw.a.setFixSize(adma.a(this.jdField_a_of_type_Adma), -1);
      this.jdField_a_of_type_Adlw.a.setMaxSize(adma.a(this.jdField_a_of_type_Adma), -1);
      this.jdField_a_of_type_Adlw.a.setMinSize(adma.a(this.jdField_a_of_type_Adma), -1);
      this.jdField_a_of_type_Adlw.a.setViewRect(adma.a(this.jdField_a_of_type_Adma), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admb
 * JD-Core Version:    0.7.0.1
 */