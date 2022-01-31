import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.nearby.NearbyJsInterface;

public class aeul
  implements TroopMemberApiClient.Callback
{
  public aeul(NearbyJsInterface paramNearbyJsInterface, TroopMemberApiClient paramTroopMemberApiClient, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("nearbyVideoConfig");
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(new aeum(this, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aeul
 * JD-Core Version:    0.7.0.1
 */