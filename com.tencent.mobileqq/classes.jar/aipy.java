import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class aipy
  implements EIPCResultCallback
{
  aipy(String paramString, long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("type");
    if (i == 1)
    {
      paramEIPCResult = paramEIPCResult.getString("nickName");
      aing.a().callbackGetNick(paramEIPCResult, this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_Long);
    }
    while (i != 2) {
      return;
    }
    paramEIPCResult = (Bitmap)paramEIPCResult.getParcelable("head");
    aing.a().callbackGetHead(paramEIPCResult, this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aipy
 * JD-Core Version:    0.7.0.1
 */