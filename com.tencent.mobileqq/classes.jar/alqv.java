import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class alqv
  implements ArkViewImplement.LoadCallback
{
  alqv(alqu paramalqu, altt paramaltt, altp paramaltp, int paramInt, adlk paramadlk) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Altt.a.setVisibility(0);
      alqu.a(this.jdField_a_of_type_Alqu, this.jdField_a_of_type_Altp, this.jdField_a_of_type_Altt);
      this.jdField_a_of_type_Altt.b.setVisibility(0);
      this.jdField_a_of_type_Altp.a(this.jdField_a_of_type_Altt, this.jdField_a_of_type_Alqu);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Alqu.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Altp.a(this.jdField_a_of_type_Adlk, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Altt.a.setVisibility(8);
      this.jdField_a_of_type_Altt.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alqv
 * JD-Core Version:    0.7.0.1
 */