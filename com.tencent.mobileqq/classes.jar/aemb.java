import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class aemb
  implements TroopMemberApiClient.Callback
{
  public aemb(NearbyJsInterface paramNearbyJsInterface, TroopMemberApiClient paramTroopMemberApiClient, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("nearbyVideoConfig");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(new aemc(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aemb
 * JD-Core Version:    0.7.0.1
 */