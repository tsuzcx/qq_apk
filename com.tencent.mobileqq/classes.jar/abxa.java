import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import mqq.app.AppRuntime;

public class abxa
{
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public abxa(AppRuntime paramAppRuntime, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
  }
  
  public static void a(int paramInt, Bundle paramBundle, abxb paramabxb)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("key_sub_cmd", paramInt);
    if (paramabxb != null)
    {
      yqz.a().a(118, localBundle, paramabxb);
      return;
    }
    yqz.a().a(118, localBundle);
  }
  
  public void a(int paramInt1, Bundle paramBundle, int paramInt2)
  {
    switch (paramBundle.getInt("key_sub_cmd"))
    {
    default: 
      return;
    case 1: 
      paramBundle.putBundle("key_result", abye.a());
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(paramInt1, paramBundle);
      return;
    case 2: 
      str1 = paramBundle.getString("key");
      paramInt1 = paramBundle.getInt("type");
      paramBundle = paramBundle.getString("appid");
      abzo.a().b(str1, paramInt1, paramBundle);
      return;
    }
    String str1 = paramBundle.getString("key");
    paramInt1 = paramBundle.getInt("type");
    String str2 = paramBundle.getString("appid");
    paramBundle = paramBundle.getString("api");
    abzo.a().b(str1, paramInt1, str2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abxa
 * JD-Core Version:    0.7.0.1
 */