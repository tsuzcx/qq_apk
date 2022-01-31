import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class afel
  implements ArkViewImplement.LoadCallback
{
  afel(afek paramafek, MessageForArkApp paramMessageForArkApp, afeg paramafeg) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer.getContainerRect();
    float f = anjs.a();
    int i = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
    int j = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
    localObject = this.jdField_a_of_type_Afeg.a.getLayoutParams();
    StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
    localStringBuilder.append(i).append(",").append(j).append(")").append(", arkView layout rect(").append(((ViewGroup.LayoutParams)localObject).width).append(",").append(((ViewGroup.LayoutParams)localObject).height).append(")").append(", init mArkWidth=").append(afek.a(this.jdField_a_of_type_Afek)).append(", load state=").append(paramInt).append(", app=").append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName);
    QLog.i("ArkAppItemBuilder", 1, localStringBuilder.toString());
    if ((anjs.a) && (paramInt == 1) && (Math.abs(((ViewGroup.LayoutParams)localObject).width - afek.a(this.jdField_a_of_type_Afek)) > 5))
    {
      QLog.d("ArkAppItemBuilder", 1, new Object[] { "ArkFold.onLoadFinish setViewRect(", Integer.valueOf(afek.a(this.jdField_a_of_type_Afek)), ",", Integer.valueOf(j), ")" });
      this.jdField_a_of_type_Afeg.a.setFixSize(afek.a(this.jdField_a_of_type_Afek), -1);
      this.jdField_a_of_type_Afeg.a.setMaxSize(afek.a(this.jdField_a_of_type_Afek), -1);
      this.jdField_a_of_type_Afeg.a.setMinSize(afek.a(this.jdField_a_of_type_Afek), -1);
      this.jdField_a_of_type_Afeg.a.setViewRect(afek.a(this.jdField_a_of_type_Afek), j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afel
 * JD-Core Version:    0.7.0.1
 */