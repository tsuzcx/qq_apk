import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class aasz
  implements bcxy
{
  aasz(aast paramaast, AppRuntime paramAppRuntime, Bundle paramBundle) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a("TroopMemberApiService", "result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a("TroopMemberApiService", anzj.a(2131714386) + paramInt2 + "]", null);
        ShortVideoResourceManager.a(anzj.a(2131714356));
        bcwy.a(1, paramInt2);
        this.jdField_a_of_type_Aast.a.b = false;
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a("TroopMemberApiService", anzj.a(2131714347), null);
        ShortVideoResourceManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localArrayList, new aata(this));
        return;
      }
      VideoEnvironment.a("TroopMemberApiService", anzj.a(2131714348) + paramInt1 + "]", null);
      ShortVideoResourceManager.a(anzj.a(2131714385));
      bcwy.a(1, paramInt1);
      return;
    }
    VideoEnvironment.a("TroopMemberApiService", anzj.a(2131714436) + paramInt2 + "]", null);
    ShortVideoResourceManager.a(anzj.a(2131714393));
    bcwy.a(1, paramInt2);
    this.jdField_a_of_type_Aast.a.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasz
 * JD-Core Version:    0.7.0.1
 */