import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class aaex
  implements bcyc
{
  aaex(aaeq paramaaeq, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad("TroopMemberApiService", anvx.a(2131714965) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(anvx.a(2131714935));
        bcxc.a(1, paramInt2);
        this.jdField_a_of_type_Aaeq.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad("TroopMemberApiService", anvx.a(2131714926), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new aaey(this));
        return;
      }
      VideoEnvironment.LogDownLoad("TroopMemberApiService", anvx.a(2131714927) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(anvx.a(2131714964));
      bcxc.a(1, paramInt1);
      return;
    }
    VideoEnvironment.LogDownLoad("TroopMemberApiService", anvx.a(2131715015) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(anvx.a(2131714972));
    bcxc.a(1, paramInt2);
    this.jdField_a_of_type_Aaeq.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaex
 * JD-Core Version:    0.7.0.1
 */