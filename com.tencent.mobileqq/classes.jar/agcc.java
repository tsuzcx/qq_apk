import android.os.Handler;
import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;

public class agcc
  extends VipBaseUpsImageUploadTask
{
  public agcc(VipProfileCardPreviewActivity paramVipProfileCardPreviewActivity, long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3)
  {
    super(paramLong, paramString1, paramArrayOfByte, paramString2);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 1001: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.n();
      } while (a() == null);
      this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a(this.jdField_a_of_type_JavaLangString, (UpsImageUploadResult)a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.n();
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.obtainMessage(24, a());
    this.jdField_a_of_type_ComTencentMobileqqProfileVipProfileCardPreviewActivity.a.sendMessage(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agcc
 * JD-Core Version:    0.7.0.1
 */