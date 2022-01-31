import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class alch
  implements ArkViewImplement.LoadCallback
{
  alch(alcg paramalcg, alff paramalff, alfb paramalfb, int paramInt, adai paramadai) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Alff.a.setVisibility(0);
      alcg.a(this.jdField_a_of_type_Alcg, this.jdField_a_of_type_Alfb, this.jdField_a_of_type_Alff);
      this.jdField_a_of_type_Alff.b.setVisibility(0);
      this.jdField_a_of_type_Alfb.a(this.jdField_a_of_type_Alff, this.jdField_a_of_type_Alcg);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Alcg.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Alfb.a(this.jdField_a_of_type_Adai, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Alff.a.setVisibility(8);
      this.jdField_a_of_type_Alff.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alch
 * JD-Core Version:    0.7.0.1
 */