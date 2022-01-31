import android.annotation.TargetApi;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.RecommendCommonMessage.ArkMsgAppInfo;
import com.tencent.qphone.base.util.QLog;

class alqu
  implements ArkViewImplement.LoadCallback
{
  alqu(alqt paramalqt, alts paramalts, alto paramalto, int paramInt, adli paramadli) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Alts.a.setVisibility(0);
      alqt.a(this.jdField_a_of_type_Alqt, this.jdField_a_of_type_Alto, this.jdField_a_of_type_Alts);
      this.jdField_a_of_type_Alts.b.setVisibility(0);
      this.jdField_a_of_type_Alto.a(this.jdField_a_of_type_Alts, this.jdField_a_of_type_Alqt);
    }
    for (;;)
    {
      QLog.d("ArkAdapterItemForTextMsg", 1, new Object[] { "ArkFold.attachArkView.appName:", this.jdField_a_of_type_Alqt.a.appName, ", position=", Integer.valueOf(this.jdField_a_of_type_Int), ",state=", Integer.valueOf(paramInt) });
      this.jdField_a_of_type_Alto.a(this.jdField_a_of_type_Adli, this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Alts.a.setVisibility(8);
      this.jdField_a_of_type_Alts.b.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alqu
 * JD-Core Version:    0.7.0.1
 */