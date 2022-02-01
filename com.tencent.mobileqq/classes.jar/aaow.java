import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class aaow
  implements bcfg
{
  aaow(aaor paramaaor, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("TroopMemberApiService", anni.a(2131714277) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(anni.a(2131714247));
        bceg.a(1, paramInt2);
        this.jdField_a_of_type_Aaor.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("TroopMemberApiService", anni.a(2131714238), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new aaox(this));
        return;
      }
      VideoEnvironment.a("TroopMemberApiService", anni.a(2131714239) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(anni.a(2131714276));
      bceg.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("TroopMemberApiService", anni.a(2131714327) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(anni.a(2131714284));
    bceg.a(1, paramInt2);
    this.jdField_a_of_type_Aaor.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaow
 * JD-Core Version:    0.7.0.1
 */