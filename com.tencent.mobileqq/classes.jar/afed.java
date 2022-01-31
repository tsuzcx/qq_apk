import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.qphone.base.util.QLog;

class afed
  implements ArkViewImplement.LoadCallback
{
  afed(afec paramafec, MessageForArkApp paramMessageForArkApp, afeg paramafeg) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppItemBubbleBuilder", 2, new Object[] { "onLoadFinish state=", Integer.valueOf(paramInt), ",app=", this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName });
    }
    if (paramInt == 1)
    {
      if (!bcgx.b(this.jdField_a_of_type_Afec.a, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.senderuin)) {
        this.jdField_a_of_type_Afeg.a(this.jdField_a_of_type_Afeg, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.arkContainer.getContainerRect();
      float f = anjs.a();
      paramInt = (int)((((Rect)localObject).right - ((Rect)localObject).left) * f);
      int i = (int)((((Rect)localObject).bottom - ((Rect)localObject).top) * f);
      localObject = this.jdField_a_of_type_Afeg.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getLayoutParams();
      StringBuilder localStringBuilder = new StringBuilder("ArkFold.onLoadFinish arkContainer rect(");
      localStringBuilder.append(paramInt).append(",").append(i).append(")").append(", arkView layout rect(").append(((ViewGroup.LayoutParams)localObject).width).append(",").append(((ViewGroup.LayoutParams)localObject).height).append(")").append(", init mArkWidth=").append(afec.b(this.jdField_a_of_type_Afec)).append(",mArkHeight=").append(afec.a(this.jdField_a_of_type_Afec)).append(",app=").append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.appName);
      QLog.i("ArkAppItemBubbleBuilder", 1, localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_Afeg.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afed
 * JD-Core Version:    0.7.0.1
 */